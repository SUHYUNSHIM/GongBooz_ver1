package com.gb.wnn;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	
	@Resource(name="StudyService")
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
	
	@RequestMapping(value="/studyInsert.do")
	public String studyInsert(@ModelAttribute("studyVO") StudyVO studyVO, Model model) {
		studyService.insertStudy(studyVO);
		return "redirect:/studyAll.do";
	}
	
	@RequestMapping(value="/search-controller.do", method= RequestMethod.POST)
	public String studySearch(@ModelAttribute("studyVO") StudyVO studyVO,Model model, HttpServletRequest req) {
		String filter = req.getParameter("filter");
		String search = req.getParameter("search");	
		
		String whatSearched = filter+"/"+search;
		model.addAttribute("whatSearched", whatSearched);
		
		if(filter.equals("study_name")) {
			studyVO.setStudy_name(search);
			ArrayList <StudyVO> svo_name = studyService.getStudy_name(studyVO);
			model.addAttribute("alist",svo_name);
			req.setAttribute("alist", svo_name);
						
			return "studyAll";
		}
		else if(filter.equals("study_tag")) {
			studyVO.setStudy_tag(search);
			ArrayList <StudyVO> svo_tag = studyService.getStudy_tag(studyVO);
			model.addAttribute("alist",svo_tag);
			req.setAttribute("alist", svo_tag);
			return "studyAll";
		}
		else if(filter.equals("region")) {
			studyVO.setRegion(search);
			ArrayList <StudyVO> svo_region = studyService.getStudy_region(studyVO);
			model.addAttribute("alist",svo_region);
			req.setAttribute("alist", svo_region);
			return "studyAll";
		}
		return "redirect:/studyAll.do";
		
	}
	
	
}
