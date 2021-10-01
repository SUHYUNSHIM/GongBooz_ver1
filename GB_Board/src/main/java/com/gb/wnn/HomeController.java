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
//@Controller
public class HomeController {
	
	@Resource(name="studyService")
	private StudyService studyService;

	//
	@RequestMapping(value="/studyAll.do")
	public String studyAll(Model model) throws Exception{
		ArrayList <StudyVO> alist = studyService.getAllStudy();
		model.addAttribute("alist",alist);
		return "studyAll";
	}
	
	@RequestMapping(value="/studyInsertForm.do")
	public String studyInsertForm(@ModelAttribute("studyVO") StudyVO studyVO, Model model) throws Exception{
		return "studyInsertForm";
	}
	
	@RequestMapping(value="/studyInsert.do")
	public String studyInsert(@ModelAttribute("studyVO") StudyVO studyVO, Model model) {
		studyService.insertStudy(studyVO);
		return "redirect:/studyAll.do";
	}
	@RequestMapping(value="/getStudy.do")
	public String studyGetinfo(@ModelAttribute("studyVO") StudyVO studyVO, Model model) {
		studyService.getStudy(studyVO);
		return "studyGetinfo";
	}
	
	@RequestMapping("/updateStudy.do")
	public String updateStudy(StudyVO studyVO, Model model) throws ClassNotFoundException, SQLException{
		studyService.updateStudy(studyVO);
		return "redirect:/studyAll.do";
	}
	@RequestMapping("/deleteStudy.do")
	public String deleteStudy(StudyVO studyVO, Model model) throws ClassNotFoundException, SQLException{
		studyService.deleteStudy(studyVO);
		return "redirect:/studyAll.do";
	}
	
}
