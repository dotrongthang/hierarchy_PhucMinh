package com.project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.protocol.Protocol.GetProfilerEventHandlerInstanceFunction;
import com.project.converter.UserConverter;
import com.project.dto.LogDTO;
import com.project.dto.UserDTO;
import com.project.entity.LogEntity;
import com.project.entity.SurveyAnswerStatistics;
import com.project.service.ILogService;
import com.project.service.IUserService;
import com.project.utils.MessageUtil;
import com.project.utils.StringUtil;

import jdk.internal.net.http.common.Log;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

	@Autowired
	private MessageUtil messageUtil;
	
	@Autowired
	private StringUtil stringUtil;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ILogService logService;
	
	@Autowired
	private UserConverter userConverter;

	@RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(@RequestParam(value ="search", required = false) String search) {
		ModelAndView mav = new ModelAndView("admin/home");
		String result = "";
		if(search != null) {
			result = userService.findIDWhenActive(Integer.parseInt(search));
		}
		mav.addObject("result", result);
		return mav;
	}

	@RequestMapping(value = "/quan-tri/thanh-vien/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam(value = "page", required = false) int page, @RequestParam(value="limit", required = false) int limit, 
			@RequestParam(value ="search", required = false) String search,
			@RequestParam(value ="searchId", required = false) String searchId,
			HttpServletRequest request) {
		UserDTO model = new UserDTO();
		ModelAndView mav = new ModelAndView("admin/list");
		if(searchId != null) {
			model.setPage(page);
			model.setLimit(limit);
			Pageable pageable = new PageRequest(page - 1, limit);
			model.setListResult(userService.findByName(searchId));
		} else if(search != null) {
			model.setPage(page);
			model.setLimit(limit);
			Pageable pageable = new PageRequest(page - 1, limit);
			model.setListResult(userService.findByParentId(userService.findByParentName(search).get(0).getId()));
		}else {
			model.setPage(page);
			model.setLimit(limit);
			Pageable pageable = new PageRequest(page - 1, limit);
			model.setListResult(userService.findAll(pageable));
		}
		
		model.setTotalItem(userService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/quan-tri/them-moi", method = RequestMethod.GET)
	public ModelAndView AddPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/edit");
		UserDTO model = new UserDTO();
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/thanh-vien/thong-ke", method = RequestMethod.GET)
	public ModelAndView showLog(@RequestParam(value ="search", required = false) String search,
			@RequestParam(value ="start", required = false) String start,
			@RequestParam(value ="end", required = false) String end) {
		
		LogDTO model = new LogDTO();
		ModelAndView mav = new ModelAndView("admin/log");
		if(start != null && end != null) {
			String startNew = stringUtil.splitString(start);
			String endNew = stringUtil.splitString(end);
			if(startNew != "" && endNew !="") {
				if(search != null) {
					model.setListResult(logService.showtLog(search, startNew, endNew));
				}else {
					model.setListResult(logService.countLog(startNew, endNew));
					
				}
				mav.addObject("model", model);
			}else {
				mav.addObject("model", model);
			}	
		}
		
		return mav;
	}
}