package com.sd.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sd.constant.Constant;
import com.sd.model.AcceptRequireInfo;
import com.sd.model.Attachment;
import com.sd.model.DataTableResult;
import com.sd.model.RequireInfo;
import com.sd.model.TableColum;
import com.sd.model.TableParam;
import com.sd.service.IAttachmentService;
import com.sd.service.IDemandService;
import com.sd.util.DateManager;

@Controller
@RequestMapping("/")
public class DemandController {	
	private static final Logger logger = LoggerFactory
			.getLogger(DemandController.class);
	@Autowired
	private IDemandService iDemandService;
	@Autowired
	private IAttachmentService iAttachmentService;

	@RequestMapping("/pb")
	public ModelAndView zcJsp() {
		return new ModelAndView("publish");
	}

	/**
	 * 发布需求
	 * @param r
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/publish", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView publishDemand(@ModelAttribute RequireInfo r,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String filePath = null;
		String fileName = null;
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();
				fileName = file.getOriginalFilename();
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				filePath = serverFile.toString();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				logger.error("You failed to upload "
						+ file.getOriginalFilename() + " => " + e.getMessage());

			}
		} else {
			logger.error("You failed to upload " + file.getOriginalFilename()
					+ " because the file was empty.");
		}
		r.setCreDate(DateManager.dateFormat(new Date()));
		r.setState(Constant.ONE_CODE);
		r.setFilePath(filePath);
		r.setDeal("需求协议");
		r.setUserId((Integer) request.getSession().getAttribute(
				Constant.USERKEY));
		int c = iDemandService.addData(r);
		Attachment attachment = new Attachment();
		attachment.setFid(r.getRid());
		attachment.setCreateTime(DateManager.dateFormat(new Date()));
		attachment.setCreator((Integer)request.getSession().getAttribute(Constant.USERKEY));
		attachment.setType(Integer.parseInt(Constant.ONE_CODE));
		attachment.setFileName(fileName);
		attachment.setFilePath(filePath);
		iAttachmentService.addAttachment(attachment);
		return new ModelAndView("redirect:/myRequire?type=1&flag=true"); 		
	}

	/**
	 * 跳转我的需求列表界面（包括我发布需求列表或者我参与竞标需求列表界面）
	 * 
	 * @return
	 */
	@RequestMapping(value = "/myRequire")
	public ModelAndView rTableData(HttpServletRequest request,
			HttpServletResponse response) {	
		String type = request.getParameter("type");
		String flag = request.getParameter("flag");
		request.setAttribute("type", type);
		request.setAttribute("flag", flag);
		return new ModelAndView("requireInfo");
	}

	/**
	 * 查询需求数据 
	 * @param tableParam
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/data", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	DataTableResult TableData(@RequestBody TableParam tableParam,
			HttpServletRequest request, HttpServletResponse response) {
		DataTableResult dataTableResult = new DataTableResult();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>(0);
		String[] param = tableParam.getSearchParam();
		int userId = (Integer) request.getSession().getAttribute(
				Constant.USERKEY);
		map.put("start", tableParam.getStart());
		map.put("length", tableParam.getLength());

		/** 1代表我发布的需求、2代表我参与竞标的需求、3代表可报名的需求、4代表查询某需求的竞争者 */
		if (Constant.ONE_CODE.equals(param[0])) {
			map.put("userId", userId);
			jsonObject = iDemandService.queryReInfos(map);
		} else if (Constant.TWO_CODE.equals(param[0])) {
			map.put("userId", userId);
			jsonObject = iDemandService.queryBidReInfos(map);
		}else if (Constant.THREE_CODE.equals(param[0])) {
			map.put("state", param[1]);
			jsonObject = iDemandService.queryByState(map);
		} else {
			map.put("rid", Integer.parseInt(param[1]));
			jsonObject = iDemandService.queryPerList(map);
		}
		int count = (Integer) jsonObject.get("total");

		dataTableResult.setRecordsFiltered(count);
		dataTableResult.setRecordsTotal(count);
		dataTableResult.setDraw(0);
		dataTableResult.setData(jsonArray.fromObject(jsonObject.get("data")));
		return dataTableResult;
	}

	@RequestMapping(value = "/titles", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	JSONArray TableTitles(HttpServletRequest request,
			HttpServletResponse response) {
		JSONArray resultArray = new JSONArray();
		String type = (String) request.getAttribute("type");
		resultArray = iDemandService.titleInfo(type);
		return resultArray;
	}

	/**
	 * 查询热门需求
	 * 
	 * @return
	 */
	@RequestMapping(value = "/rot")
	public @ResponseBody
	List<RequireInfo> rotRequireData() {
		List<RequireInfo> rList = null;
		rList = iDemandService.queryHotRequireInfos();
		return rList;
	}

	/**
	 * 查询最新需求
	 * 
	 * @return
	 */
	@RequestMapping(value = "/new")
	public @ResponseBody
	List<RequireInfo> newRequireData() {
		List<RequireInfo> rList = null;
		rList = iDemandService.queryNewRequireInfos();
		return rList;
	}

	/**
	 * 根据id查看单个需求信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/rInfo/rid")
	public ModelAndView requireInfo(@RequestParam String rid,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>(0);
		RequireInfo rInfo = null;
		rInfo = iDemandService.queryById(Integer.parseInt(rid));
		model.put("rData", rInfo);
		return new ModelAndView("rInfo", model);
	}

	/**
	 * 修改需求状态
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mState")
	public String updataState(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>(0);
		String state = request.getParameter("state");
		String rid = request.getParameter("rid");
		String aid = request.getParameter("aid");
		String isUploadPact = request.getParameter("isUploadPact");
		String isUploadWorks = request.getParameter("isUploadWorks");
		String isSure = request.getParameter("isSure");
		map.put("state", state);
		map.put("rid", Integer.parseInt(rid));
		if (StringUtils.isNotEmpty(aid)) {
			map.put("aid", Integer.parseInt(aid));
		}		
		map.put("isUploadPact", Integer.parseInt(isUploadPact));
		map.put("isUploadWorks", isUploadWorks);
		map.put("isSure", isSure);
		iDemandService.updateData(map);
		return "redirect:/myRequire?type=1";
	}
	/**
	 * 参与竞标报名 
	 * @return
	 */
	@RequestMapping(value = "/bm")
	public ModelAndView applyRequireJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>(0);
		String rid = request.getParameter("rid");
		int uid = (Integer)request.getSession().getAttribute(Constant.USERKEY);
		String title = request.getParameter("title");
		model.put("rid", rid);
		model.put("uid", uid);
		model.put("title", title);
		return new ModelAndView("accept", model);
	}
	/**
	 * 参与竞标报名 
	 * @return
	 */
	@RequestMapping(value = "/apply")
	public ModelAndView applyRequire(@ModelAttribute AcceptRequireInfo aInfo,
			HttpServletRequest request, HttpServletResponse response) {
		boolean sign = false;
		Map<String, Integer> map = new HashMap<String, Integer>(0);
		map.put("rid", aInfo.getRid());
		map.put("uid", aInfo.getUid());
		sign = iDemandService.isAccepted(map);
		if (sign) {
			return new ModelAndView("redirect:/myRequire?type=3&flag=false"); 		
		}
		aInfo.setIsReach("0");
		iDemandService.addAcceptRequireData(aInfo);
		//更新需求 是否报名状态
		Map<String, Object> mapParam = new HashMap<String, Object>(0);
		mapParam.put("state", "1");
		mapParam.put("rid", aInfo.getRid());
		mapParam.put("isUploadPact", 0);
		mapParam.put("isUploadWorks", 0);
		mapParam.put("isSure", 1);
		iDemandService.updateData(mapParam);
		return new ModelAndView("redirect:/myRequire?type=2&flag=true"); 		
	}	
	/**
	 * 中间过渡，为获取rid
	 * @param rid
	 * @return
	 */
	@RequestMapping("/mid")
	public ModelAndView requirJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, String> model = new HashMap<String, String>(0);
		String rid = request.getParameter("rid");
		model.put("rid", rid);
		model.put("type", "4");
		return new ModelAndView("requireInfo",model);
	}	
}
