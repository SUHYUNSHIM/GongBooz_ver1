package com.gb.wn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String name(@RequestParam("name") String name, HttpSession ses)  {
		//ses.removeAttribute("name"); //초기화
		ses.setAttribute("name", name);
		System.out.println(name);
		//session.invalidate();
		//return "index"; //.do를 여기서 써야 하나? redirect 하는 과정이 필요하다. nono... 일단 해결 완료... 아니네 또 안되네.		
		//ses.invalidate();
		return "redirect:/"; //멀티스레드 도입해야.아니면 direct 하는데 새로 생성한 session값으로 response를 전달하지 못해서 일 수도 있다. 
		//https://wickedmagic.tistory.com/131 --> 세션 삭제 참조 블로그 
		//https://hoing.io/archives/24492 클라우드 오라클 DB 참조 블로그 
	}
}
