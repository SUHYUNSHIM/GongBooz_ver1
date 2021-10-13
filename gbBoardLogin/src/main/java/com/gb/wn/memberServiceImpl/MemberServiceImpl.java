package com.gb.wn.memberServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gb.wn.memberDAO.MemberDAO;
import com.gb.wn.memberService.MemberService;
import com.gb.wn.memberVO.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mdao;
	
	@Override
	public void register(MemberVO vo) throws Exception {

		mdao.register(vo);
		
	}

	@Override//MemberDAO에서 MemberVO안에 조회된 값들이 담긴다.
	public MemberVO login(MemberVO vo) throws Exception {
		return mdao.login(vo);
	}

	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		
		mdao.memberUpdate(vo);
		
	}

	@Override
	public void memberDelete(MemberVO vo) throws Exception {

		mdao.memberDelete(vo);
	}

	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = mdao.passChk(vo);
		return result;
	}

	@Override
	public int idChk(MemberVO vo) throws Exception {
		int result = mdao.idChk(vo);
		return result;
	}
	// 비밀번호 변경
	@Transactional
	@Override
	public int update_pw(MemberVO vo) throws Exception {
		return mdao.update_pw(vo);
	}

	@Override
	public MemberVO emailfind(MemberVO vo) throws Exception {
		return mdao.emailfind(vo);
	}

//	@Override
//	public String find_id(String email) throws Exception {
//		return mdao.find_id(email);
//	}
	@Override
	public List<MemberVO> find_id(String email) throws Exception {
		return mdao.find_id(email);
	}

	@Override
	public int check_email(String email) throws Exception {
		return mdao.check_email(email);
	}
	

		
	

}
