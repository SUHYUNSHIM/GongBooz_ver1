package com.gb.wnn.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gb.wnn.service.StudyService;
import com.gb.wnn.vo.StudyVO;

@Controller //이 클래스에 대한 bean 객체 생성. 메소드의 집합
public class StudyRoom {
	
	//https://min-it.tistory.com/7?category=751930
	
	
	@RequestMapping(value="/new_study")
	public String studyNew(Model model) {	
		
		return "studyInsertForm";
	}	//화면전환
	
}
