package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// Controller를 어노테이션 하지 않으면 반드시 Controller 상속(구현)해야 한다

public class Start1Controller implements Controller {
	// 실제 실행하는 메소드
	// 어노테이션을 하지 않으면 반환형은 ModelAndView 이다
	// 어노테이션을 하면 반환형은 String 또는 ModelAndView 둘 다 가능하다
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 일처리 저장하는 곳 = Model
		// 되돌아갈 jsp 지정하는 곳 = View

		// 방법1 (사용추천)
		// ModelAndView mv = new ModelAndView();
		// mv.setViewName("ViewName = 되돌아갈 jsp 이름");
		
		// 방법2
		// ModelAndView mv = new ModelAndView("ViewName = 되돌아갈 jsp 이름");
		
		ModelAndView mv =new ModelAndView();
		// 이때 jsp를 붙이지 않는다
		mv.setViewName("result1");
		
		// 일처리 = 비즈니스로직 => 서비스 => 서비스임플 => 맵퍼(DAO) => DB처리
		// ModelAndView 모두 request에 저장되어 EL 사용 가능
		
		// jsp처럼 필요한 정보를 ModelAndView를 이용해서 저장
		// 방법1. ModelAndView
		mv.addObject("name", "홍길동");
		mv.addObject("age", 17);
		
		// 방법2. request.setAttribute("이름", "값");
		request.setAttribute("addr", "Seoul");
		
		// 방법3. request.getSession().setAttribute("이름", "값");
		request.getSession().setAttribute("phone", "010-7777-9999");
		
		return mv;
	}
}
