package com.gb.wn.controller;

import javax.servlet.http.HttpSession;

/*import org.apache.tomcat.jni.User;*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("name")
public class login {

//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String name(@RequestParam(name="name",  required=false) String name,
//				HttpSession session) {
//		session.setAttribute("name", name);
//		System.out.println(name);
//		
//		return "chat";
//	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String name(@RequestParam("name") String name, HttpSession session) {
		session.setAttribute("name", name);
		System.out.println(name);
		//session.invalidate();
		return "index"; //.do를 여기서 써야 하나? redirect 하는 과정이 필요하다. nono... 일단 해결 완료
	}
}
