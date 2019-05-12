package com.sd.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sd.constant.Constant;
import com.sd.model.PersonInfo;
import com.sd.service.IPersonInfoService;

@Controller
@RequestMapping("/")
public class PersonController {
	@Autowired
	private IPersonInfoService iPersonInfoService;
	/**
	 * 跳转完善个人信息界面
	 * @return
	 */
	@RequestMapping("/complete")
	public ModelAndView complete(HttpServletRequest request,HttpServletResponse response) {
		Map<String, PersonInfo> model = new HashMap<String, PersonInfo>(0);
		int userId = (Integer)request.getSession().getAttribute(Constant.USERKEY);
		PersonInfo pInfo = iPersonInfoService.queryPersonInfo(userId);
		model.put("pInfo", pInfo);
		return new ModelAndView("personInfo",model);
	}

	/**
	 * 查询跳转个人信息界面
	 * @param userId
	 * @return
	 */
	@RequestMapping("/qpInfo")
	public ModelAndView qPersonInfo(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>(0);
		int userId = (Integer)request.getSession().getAttribute(Constant.USERKEY);
		PersonInfo personInfo = iPersonInfoService.queryPersonInfo(userId);
		model.put("pInfo", personInfo);
		return new ModelAndView("userInfo",model);
	}	
	/**
	 * 修改个人信息
	 * @return
	 */
	@RequestMapping("/modifyP")
	public ModelAndView modifyPInfo(PersonInfo pInfo,HttpServletRequest request,HttpServletResponse response) {
		iPersonInfoService.updateData(pInfo);
		return new ModelAndView("redirect:qpInfo"); 		
	}

}
