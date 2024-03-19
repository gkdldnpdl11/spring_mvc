package com.ict.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu.service.Test01Service;

@Controller
public class Test01Controller {
	// 변수 이름과 참조하는 클래스의 ID가 같을때 : @Autowired 사용
	// 변수 이름과 참조하는 클래스의 ID가 다를때 : @Qualifier 사용
	@Autowired
	private Test01Service test01Service;
	
	@GetMapping("hello.do")
	public ModelAndView HelloCommand(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("test01/result");
		
		// 서비스 객체 생성, 이렇게하면 서비스객체가 두번 생김 => 오류는 아니지만 잘못된 코딩
		// Test01Service service = new Test01Service();
		// String msg = serivce.getGreeting();
		
		// 생성한 객체가 반환형이 있으므로 반환형 변수에 저장
		String msg = test01Service.getGreeting();
		// 저장한 변수를 mv 객체에 저장
		mv.addObject("msg", msg);
		return mv;
	}
}
