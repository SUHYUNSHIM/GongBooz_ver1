package com.gb.wn.chat.model.dao;


import java.util.List;
import java.util.Map;

import com.gb.wn.chat.model.vo.Chat;

public interface ChatDAO {
//	List<Map<String, Object>> selectchatList(int roomNo,int startNo);

	List<Chat> selectchatList(Map<String, Object> map);

	List<Chat> selectFirstChatList(int roomNo);

	int insertChat(Chat chat);
}
