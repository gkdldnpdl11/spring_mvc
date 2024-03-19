package com.ict.edu2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu2.service.Test02Service;
import com.ict.edu2.vo.VO;

@Controller
public class Test02Controller {
	@Autowired
	private Test02Service test02Service;
	
	/* jsp방식
	@PostMapping("calc.do")
	public ModelAndView calc(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("test02/result");
		String s1= request.getParameter("s1");
		String s2= request.getParameter("s2");
		String op= request.getParameter("op");
		String cPage= request.getParameter("cPage");
		
		// 배열처리
		String hobby [] = request.getParameterValues("hobby");
		
		int su1= Integer.parseInt(s1);
		int su2= Integer.parseInt(s2);
		
		int result = test02Service.getCalc(su1, su2, op);
		mv.addObject("result", result);
		mv.addObject("s1", s1);
		mv.addObject("s2", s2);
		mv.addObject("op", op);
		mv.addObject("cPage", cPage);
		
		// 배열처리
		mv.addObject("hobby", hobby);
		
		return mv;
	}
	*/
	
	/* 스프링 방식 1 : 객체에 저장하여 파라미터값을 받음
	@PostMapping("calc.do")
	// 파라미터값을 vo에 저장 (vo에 있는 변수는 파라미터 이름과 같아야 한다)
	public ModelAndView calc(VO vo) {
		ModelAndView mv = new ModelAndView("test02/result");
		int su1= Integer.parseInt(vo.getS1());
		int su2= Integer.parseInt(vo.getS2());
		
		int result = test02Service.getCalc(su1, su2, vo.getOp());
		// result 또한 vo에 저장하였으므로 result의 값을 vo에 저장, 그러나 String이기때문에 형변환 한다
		vo.setResult((String.valueOf(result)));
		// 저장한 vo의 값을 mv에 저장, mv는 servlet으로 리턴 후 jsp 파일로 정보를 보냄
		mv.addObject("vo", vo);
		
		return mv;
	}
	*/
	
	@PostMapping("calc.do")
	// 파라미터값을 vo에 저장 (vo에 있는 변수는 파라미터 이름과 같아야 한다)
	public ModelAndView calc(@ModelAttribute("vo2")VO vo) {
		ModelAndView mv = new ModelAndView("test02/result");
		int su1= Integer.parseInt(vo.getS1());
		int su2= Integer.parseInt(vo.getS2());
		
		int result = test02Service.getCalc(su1, su2, vo.getOp());
		vo.setResult((String.valueOf(result)));
		
		// mv.addObject("vo2", vo);
		// 위의 @ModelAttribute("vo2") 에서 이미 저장을 하였기 때문에 저장하지 않아도됨
		
		return mv;
	}
}
