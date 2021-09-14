package com.gb.wn;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value="/studyroom", method=RequestMethod.GET)
	public String room_report(Model model, HttpServletRequest req) {
		
		String room1 = req.getParameter("room1");
		System.out.println(room1);
		//HttpSession session=req.getSession();
		//session.setAttribute("room1", room1);
		model.addAttribute("room1", room1);
		
		/*String name = req.getParameter("name");
		int java = Integer.parseInt(req.getParameter("java"));
		int ui = Integer.parseInt(req.getParameter("ui"));
		int sql = Integer.parseInt(req.getParameter("sql"));
		
		int sum = 0;
		int avg;
		
		sum += java+ui+sql;
		avg = sum/3;
		
		model.addAttribute("name",name);
		model.addAttribute("total",sum);
		model.addAttribute("avg",avg);*/
		
		return "room1";
	}
	
	
	
	
	
	
	
	
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 *//*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/
	
}
