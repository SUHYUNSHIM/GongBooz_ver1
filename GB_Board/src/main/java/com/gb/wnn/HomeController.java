package com.gb.wnn;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gb.wnn.service.StudyService;
import com.gb.wnn.vo.StudyVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Resource(name="studyService")
	private StudyService studyService;

	//전체 스터디 목록 조회
	@RequestMapping(value="/studyAll.do")
	public String studyAll(Model model) throws Exception{
		ArrayList <StudyVO> alist = studyService.getAllStudy();
		model.addAttribute("alist",alist);
		return "studyAll"; //studyAll.jsp에서 전부 출력
	}
	
	@RequestMapping(value="/studyInsertForm.do")
	public String studyInsertForm(@ModelAttribute("studyVO") StudyVO studyVO, Model model) throws Exception{
		return "studyInsertForm";
	}
	
	
	
}
