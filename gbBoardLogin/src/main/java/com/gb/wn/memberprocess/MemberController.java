package com.gb.wn.memberprocess;





import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;


import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.gb.wn.memberService.MemberService;
//import com.gb.wn.memberServiceImpl.PrintWriter;
import com.gb.wn.memberVO.MemberVO;



@Controller
public class MemberController {

	
	@Resource(name="memberService")
	private MemberService memkaja;
	
	 @Autowired
	 private JavaMailSender mailSender;
	
	
	//로그인 화면으로 
	@RequestMapping(value="member/login.do")
	public String loingView(){
		
		return "member/login";
	}
	
	@RequestMapping(value="member/myinfo.do")
	public String infoView(){
		
		return "member/myinfo";
	}
	
	//
//	@RequestMapping(value="member/kakao_login.do")
//	public String callback(){
//		
//		return "member/kakao_login";
//	}
	
	//회원가입 화면으로 
	@RequestMapping(value="member/join.do")
	public String joinView(){
		
		return "member/register";
	}
	
	// 회원가입 get
	@RequestMapping(value = "member/register.do", method = RequestMethod.GET)
	public void getRegister() throws Exception {
	}
		
	// 회원가입 post
	@RequestMapping(value = "member/register.do", method = RequestMethod.POST)
	public String postRegister(MemberVO vo) throws Exception {
		System.out.println("회원가입");
		
		int result = memkaja.idChk(vo);
		System.out.println(result);
		try {
			if(result == 1) {
				return "member/register";
				/*return "member/login";*/
			}else if(result == 0) {
			/*	String inputPass = vo.getUserpass();
				//회원가입 요청이 들어왔을때 비밀번호를 암호호화 하여 다시 vo에넣어 준다 .그리고 다시 회원가입 서비스를 실행한다. 
				String pwd = pwdEncoder.encode(inputPass);
				vo.setUserpass(pwd);*/
				
				
				memkaja.register(vo);
			}
			// 요기에서~ 입력된 아이디가 존재한다면 -> 다시 회원가입 페이지로 돌아가기 
			// 존재하지 않는다면 -> register
		} catch (Exception e) {
			throw new RuntimeException();
		}
	
		return "member/login";
	}
	//로그인
	@RequestMapping(value = "member/loginOk.do", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		
		String loginok = "";
		HttpSession session = req.getSession();
		MemberVO login = memkaja.login(vo);
		
		if(login == null) {
			
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			
			loginok = "redirect:/member/login.do";
		}else {
			session.setAttribute("member", login);
			loginok = "member/myinfo";
		
		}
		
		/*return "redirect:/";*/
		return loginok;
	}
	
	/*//로그인
	@RequestMapping(value = "member/loginOk.do", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
		
		String loginok = "";
		session.getAttribute("member");
		MemberVO login = memkaja.login(vo);
		//회원가입을 암호화를 해야 했기 때문에 로그인을 할때 입력된 비밀번호와 조호한 비밀번호 가 맞아야 된다.
		//때문에 먼저 비밀번호를 조회해야 한다.  
		//login.getUserpass()로 입력된 정보를 가져온다. 
		//pwdEncoder.matches(입력된 비밀번호(), 암호화된 비밀번호()) 비교를 해줍니다. 맞으면 true 틀리면 false를 반환하여 로그인을 진행합니다.
		
		boolean pwdMatch = pwdEncoder.matches(vo.getUserpass(), login.getUserpass());
		
		if(login != null && pwdMatch == true) {
			session.setAttribute("member", login);
			loginok = "member/myinfo";
			
		}else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			loginok = "redirect:/member/login.do";
		}
		
		return "redirect:/";
		return loginok;
	}*/
	
	
	
	@RequestMapping(value = "member/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		/*return "redirect:/";*/
		return "member/login";
	}
	
	@RequestMapping(value="member/memberUpdateView.do", method = RequestMethod.GET)
	public String registerUpdateView() throws Exception{
		
		return "member/memberUpdateView";
	}

	//회원정보 수정 
	@RequestMapping(value="member/memberUpdate.do", method = RequestMethod.POST)
	public String registerUpdate(MemberVO vo, HttpSession session) throws Exception{
		System.out.println("회원정보수정");
		memkaja.memberUpdate(vo);
		
		session.invalidate();
		
		return "member/login";
	}
	
	// 회원 탈퇴 get
	@RequestMapping(value="member/memberDeleteView.do", method = RequestMethod.GET)
	public String memberDeleteView() throws Exception{
		return "member/memberDeleteView";
	}
	
	// 회원 탈퇴 post
	@RequestMapping(value="member/memberDelete.do", method = RequestMethod.POST)
	public String memberDelete(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
		
		// 세션에 있는 member를 가져와 member변수에 넣어줍니다.
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		// 세션에있는 비밀번호
		System.out.println(member.getUserpass());
		String sessionPass = member.getUserpass();
		// vo로 들어오는 비밀번호
		String voPass = vo.getUserpass();
		System.out.println("입력한 비밀번호 :"+voPass);
		System.out.println("아이디:"+member.getUserid());
		if(!(sessionPass.equals(voPass))) {
			rttr.addFlashAttribute("msg", false);
			/*return "member/memberDeleteView";*/
			return "redirect:/member/memberDeleteView.do";
		}
		memkaja.memberDelete(vo);
		session.invalidate();
		System.out.println("회원탈톼");
		return "member/login";
	}
	
/*	//회원탈퇴
	@RequestMapping(value="member/memberDelete.do", method = RequestMethod.POST)
	public String memberDelete(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
		
		memkaja.memberDelete(vo);
		session.invalidate();
		
		return "member/login";
	}*/
	

	// 패스워드 체크
	@ResponseBody//????????
	@RequestMapping(value="member/passChk.do", method = RequestMethod.POST)
	public int passChk(MemberVO vo) throws Exception {
		int result = memkaja.passChk(vo);
		System.out.println("패스워드체크/"+result);
		return result;
	}
/*	@ResponseBody//????????
	@RequestMapping(value="member/passChk.do", method = RequestMethod.POST)
	public boolean passChk(MemberVO vo) throws Exception {
		System.out.println("패스워드체크");
		
		// passChk()요청에서 비밀번호를 비교해주기때문에 서비스만 실행시켜줍니다.
		MemberVO login = memkaja.login(vo);
		boolean pwdChk = pwdEncoder.matches(vo.getUserpass(), login.getUserpass());
		return pwdChk;
	}*/
	
	@RequestMapping(value="member/kajainfo.do")
	public String kajainfo(){
		return "member/myinfo";
	}
	
	

	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value="member/idChk.do", method = RequestMethod.POST)
	public int idChk(MemberVO vo) throws Exception {
		System.out.println("아이디중복체크");
		int result = memkaja.idChk(vo);
		return result;
	}
	
	/* 이메일 인증 */
	@RequestMapping(value="member/mailCheck", method=RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception{
		System.out.println("이메일 인증 ");
		/* 뷰(View)로부터 넘어온 데이터 확인 */
	/*	logger.info("이메일 데이터 전송 확인");
		logger.info("이메일 : " + email);*/
		System.out.println(email);
				
		/* 인증번호(난수) 생성 */
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		/*logger.info("인증번호 " + checkNum);*/
		System.out.println("인증번호 " + checkNum);
		/* 이메일 보내기 */
		String setFrom = "lisa9963@naver.com";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String content = 
				"GoonBooZ를 방문해주셔서 감사합니다." +
				"<br><br>" + 
				"인증 번호는 " + checkNum + "입니다." + 
				"<br>" + 
				"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";		
		
		try {
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
		String num = Integer.toString(checkNum);
		
		return num;
		
	}
	

	@RequestMapping(value="member/findPw.do")
	public String findPwView(){
		
		return "member/findform";
	}
	
	// 비밀번호 찾기
	@RequestMapping(value = "member/find_pw.do", method = RequestMethod.POST)
	public void find_pw(@ModelAttribute MemberVO member, HttpServletResponse response) throws Exception{
		System.out.println("비밀번호찾기");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String subject = "";
		String msg = "";
		// 아이디가 없으면
		if(memkaja.idChk(member) == 0) {
			out.print("아이디가 없습니다.");
			out.close();
		}
		// 가입에 사용한 이메일이 아니면
		else if(!member.getMembermail().equals(memkaja.emailfind(member).getMembermail())) {
			out.print("잘못된 이메일 입니다.");
			out.close();
		}else {	
			// 임시 비밀번호 생성
			String pw = "";
			for (int i = 0; i < 12; i++) {
				pw += (char) ((Math.random() * 26) + 97);
			}
			member.setUserpass(pw);
			// 비밀번호 변경
			memkaja.update_pw(member);
			
			subject = "GongBooZ 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += member.getUserid() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += member.getUserpass() + "</p></div>";
			// 받는 사람 E-Mail 주소
			String mail = member.getMembermail();
			String setFrom = "lisa9963@naver.com";
			// 비밀번호 변경 메일 발송
			//send_mail(member, "find_pw");
			
			try {
				
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
				helper.setFrom(setFrom);
				helper.setTo(mail);
				helper.setSubject(subject);
				helper.setText(msg,true);
				mailSender.send(message);
				
			}catch(Exception e) {
				e.printStackTrace();
			}		
			
	
			
			out.print("이메일로 임시 비밀번호를 발송하였습니다.");
			out.close();
		}
	
	}
	
	
	// 아이디 찾기
	@RequestMapping(value = "member/find_id.do", method = RequestMethod.POST)
	public String find_id(HttpServletResponse response, @RequestParam("membermail") String email, Model md) throws Exception{
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		//String id = memkaja.find_id(email);
		
		
		
	/*	if (id == null) {
			out.println("<script>");
			out.println("alert('가입된 아이디가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
		}*/
		//md.addAttribute("id", id);

		
		if (memkaja.find_id(email).isEmpty()) {
			out.println("<script>");
			out.println("alert('가입된 아이디가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
		}
		
		md.addAttribute("array", memkaja.find_id(email));
		
		
		
		return "member/find_id";
		
	}
	
	// 이메일 중복 검사(AJAX)
	@RequestMapping(value = "member/check_email.do", method = RequestMethod.POST)
	public void check_email(@RequestParam("membermail") String email, HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		out.println(memkaja.check_email(email));
		out.close();
	}
	

		

	



	
}
