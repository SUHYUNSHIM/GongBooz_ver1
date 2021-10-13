package com.gb.wn.boardDAO;

import java.util.List;

import com.gb.wn.boardVO.ReplyVO;

public interface ReplyDAO {

	public List<ReplyVO> readReply(int bno) throws Exception;
	
	public void writeReply(ReplyVO vo) throws Exception;
	
	public void updateReply(ReplyVO vo) throws Exception;
	
	public void deleteReply(ReplyVO vo) throws Exception;
	
	public ReplyVO selectReply(int rno) throws Exception;
	
	public void replyCnt(ReplyVO vo) throws Exception;
	
	
}
