package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// 상속을 받는게 아니라서 implements 가 없음
@Controller
public class Start3Controller {
	
	// 요청이 오면 실행해야 한다
	/* 해당 요청이 오게되면 5가지 중 1가지 실행
	 * 1,2번은 사용하지 않음 (옛날방식임)
	 * 3번은 get인지 post 정확히 모를때 사용
	 * 4,5번을 사용 추천
	 * 1. @RequestMapping(value = "start3.do", method = RequestMethod.GET)
	 * 
	 * 2. @RequestMapping(value = "start3.do", method = RequestMethod.POST)
	 * 
	 * 3. @RequestMapping("start3.do")
	 * 
	 * 4. @GetMapping("start3.do")
	 * 
	 * 5. @PostMapping("start3.do")
	 */
	
	// get방식인지 post인지 확인 후 방식 또한 매칭시켜야지 오류가 나지 않는다, 현재 a태그 사용 (a태그=get)
	@GetMapping("start3.do")
	public ModelAndView exec(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("result3");
		mv.addObject("city", "Seoul");
		return mv;
	}
}
