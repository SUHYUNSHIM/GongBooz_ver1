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
		
		
		return "room1";
	}	
	
}
