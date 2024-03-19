package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Start4Controller {
	
	// 컨트롤러 메소드의 반환형은 String, ModelAndView 
	@GetMapping("start4.do")
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		/* 현재 안됨
		 * ModelAndView mv = new ModelAndView(); 
		 * mv.addObject("computer", "14세대 i7"); 		
		 */
		request.setAttribute("computer", "14세대 i7");
		
		return "result4";
	}
}
