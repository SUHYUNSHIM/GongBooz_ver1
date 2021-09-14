package com.gb.wn.chat.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gb.wn.chat.model.service.ChatService;
import com.gb.wn.chat.model.vo.Chat;
//import com.gb.onairstudy.report.model.vo.Report;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@RequestMapping("/enter/chat.do")
	public ModelAndView enterChat(@RequestParam int roomNo, ModelAndView mav, HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		List<Chat> firstList = chatService.selectFirstChatList(roomNo);
		mav.addObject("roomNo",roomNo);
		mav.addObject("memberId",memberId);
		mav.addObject("firstList",firstList);
		mav.setViewName("mypage2/chatting");
		
		return mav;
	}
	
	@RequestMapping("/test/enter.do")
	public String enter() {
		return "mypage2/change";
	}
	//채팅 내역 가져오기
	@RequestMapping("/chat/chatList.do")
	@ResponseBody
	public List<Chat> selectChatList(@RequestParam int roomNo,@RequestParam int endNo) {
		int startNo = endNo-11;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("roomNo", roomNo);
		map.put("startNo",endNo-1);
		List<Chat> list = chatService.selectChatList(map);
		//log.info("list= {}", list);
		return list;
	}
	// 채팅 메세지 전달
    @MessageMapping("/hello/{roomNo}")
    @SendTo("/subscribe/chat/{roomNo}")
    public Chat broadcasting(Chat chat) {

    	//log.debug("받아온 data={}",chat);
    	Map<String,Object> map = new HashMap<String, Object>();
    	map.put("chat", chat);
    	
        chat.setSendDate(new Date());
        int result = chatService.insertChat(chat);
        //log.info("selectkey 사용 = {}",chat);
        return chat;
    }
	
//  //채팅 저장
//    @RequestMapping("/chat/insertChat.do")
//    @ResponseBody
//    public int insertChat(Chat chat) {
////    	Map<String,Object> map = new HashMap<>();
////    	map.put("chat", chat);
//    	int result = chatService.insertChat(chat);
//    	return result;
//    }
//    
}
