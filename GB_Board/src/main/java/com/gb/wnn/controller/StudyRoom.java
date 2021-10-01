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

@Controller
public class StudyRoom {
	
	@RequestMapping(value="/new_study")
	public String studyNew(Model model) {	
		
		return "studyInsertForm";
	}	
	
}
