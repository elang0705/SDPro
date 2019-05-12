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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sd.constant.Constant;
import com.sd.model.PersonInfo;
import com.sd.model.User;
import com.sd.service.IPersonInfoService;
import com.sd.service.IUserService;
import com.sd.util.DateManager;
import com.sd.util.MD5Tool;

@Controller
@RequestMapping("/")
public class UserController {
	 private static final Logger logger = LoggerFactory
	            .getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IPersonInfoService personInfoService;

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("/addUser")
	public ModelAndView addUser(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> map = new HashMap<String, String>(0);
		User user = new User();
		List<User> useList = null;
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String type = request.getParameter("type");
		user.setUsername(username);
		user.setPwd(MD5Tool.getMD5Encoding(pwd));
		user.setPhone(phone);
		user.setType(Integer.parseInt(type));
		user.setCreateTime(DateManager.dateFormatTime(new Date()));
		useList = userService.queryUserByusername(username);
		if (useList.size() > 0) {
			map.put("sign", "你输入的用户名，已注册过，注册失败！");
		} else {
			map.put("sign", "注册成功");
			user.setRole("ROLE_USER");
			int temp = userService.addUser(user);
			PersonInfo pInfo = new PersonInfo();
			pInfo.setPid(user.getId());
			pInfo.setPhone(phone);
			personInfoService.addData(pInfo);
		}
		return new ModelAndView("login", map);
	}

	@RequestMapping("/userLogin")
	public ModelAndView userLogin(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> map = new HashMap<String, String>(0);
		User user = null;
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		user = userService.queryUserByusernameAndPwd(username,
				MD5Tool.getMD5Encoding(pwd));
		if (user == null) {
			map.put("flag", "非常抱歉,登录失败!");
		} else {
			request.getSession().setAttribute(Constant.USERKEY, user.getId());
			request.getSession().setAttribute(Constant.USERNAME, user.getUsername());
			map.put("flag", "恭喜你,登录成功!");
		}
		return new ModelAndView("welcome", map);
	}

	@RequestMapping("/completePersonInfo")
	public String completePersonInfo(@ModelAttribute PersonInfo person,
			@RequestParam("file") MultipartFile[] files) {
		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			try {
				byte[] bytes = file.getBytes();
				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

				message = message + "You successfully uploaded file="
						+ file.getOriginalFilename() + "<br />";
			} catch (Exception e) {
				return "You failed to upload " + file.getOriginalFilename()
						+ " => " + e.getMessage();
			}
		}
		return "login";
	}
	
}
