package com.sd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sd.model.RequireInfo;
import com.sd.service.IDemandService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private IDemandService iDemandService;
	
	@RequestMapping("/init")
	public ModelAndView home(HttpServletRequest request,HttpServletResponse response) {
		//查询最新需求
		List<RequireInfo> newlist = iDemandService.queryNewRequireInfos();
		//查询热门需求
		List<RequireInfo> hotlist = iDemandService.queryHotRequireInfos();
		request.setAttribute("newlist", newlist);
		request.setAttribute("hotlist", hotlist);
		return new ModelAndView("index");		
	}

}
