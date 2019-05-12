/**
 * 
 */
package com.sd.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sd.constant.Constant;
import com.sd.model.Attachment;
import com.sd.service.IAttachmentService;
import com.sd.service.IDemandService;
import com.sd.util.DateManager;

/**
 * @author elang
 *
 */
@Controller
@RequestMapping("/")
public class UploadController {
	private static final Logger logger = LoggerFactory
			.getLogger(DemandController.class);
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private IAttachmentService iAttachmentService;
	@Autowired
	private IDemandService iDemandService;
	/**
	 * 上传文件
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request,HttpServletResponse response) {
		Attachment attachment = new Attachment();
		String fid = request.getParameter("fid");
		String filetype = request.getParameter("filetype");
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
				attachment.setFid(Integer.parseInt(fid));
				attachment.setCreateTime(DateManager.dateFormat(new Date()));
				attachment.setCreator((Integer)request.getSession().getAttribute(Constant.USERKEY));
				attachment.setType(Integer.parseInt(filetype));
				attachment.setFileName(fileName);
				attachment.setFilePath(filePath);
				iAttachmentService.addAttachment(attachment);
				//更新需求表
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("rid", Integer.parseInt(fid));
				if ("2".equals(filetype)) {//表示上传合同
					map.put("isUploadPact", 1);
					map.put("isUploadWorks", 0);
					map.put("state", 2);
				}else if ("3".equals(filetype)) {//表示上传作品
					map.put("isUploadPact", 1);
					map.put("isUploadWorks", 1);
					map.put("state", 3);
				}
				iDemandService.updateByUpload(map);
			} catch (Exception e) {
				logger.error("You failed to upload "
						+ file.getOriginalFilename() + " => " + e.getMessage());

			}
		} else {
			logger.error("You failed to upload " + file.getOriginalFilename()
					+ " because the file was empty.");
		}
		return new ModelAndView("redirect:/myRequire?type=2&isUploadPact=true"); 		
	}
	@RequestMapping("/download")
	public void downloadFile(HttpServletRequest request,HttpServletResponse response){
		String rid = request.getParameter("rid");
		String type = request.getParameter("type");	
		Map<String, Integer> map = new HashMap<String, Integer>(0);
		map.put("rid", Integer.parseInt(rid));
		map.put("type", Integer.parseInt(type));
		Attachment attachment = iAttachmentService.queryFile(map);
        String filePath = attachment.getFilePath(); 
        String fileName = attachment.getFileName();
        //获取网站部署路径(通过ServletContext对象)，用于确定下载文件位置，从而实现下载  
//        String path = servletContext.getRealPath("/");  
  
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
        response.setContentType("multipart/form-data");  
        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)  
        response.setHeader("Content-Disposition", "attachment;fileName="+fileName);  
        ServletOutputStream out;  
        //通过文件路径获得File对象  
        File file = new File(filePath);  
  
        try {  
            FileInputStream inputStream = new FileInputStream(file);  
  
            //3.通过response获取ServletOutputStream对象(out)  
            out = response.getOutputStream();
            int b = 0;  
            byte[] buffer = new byte[1024];  
            while ((b = inputStream.read()) != -1){
                //4.写到输出流(out)中  
                out.write(buffer,0,b);  
            }  
            inputStream.close();  
            out.close();  
            out.flush();  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	}
}
