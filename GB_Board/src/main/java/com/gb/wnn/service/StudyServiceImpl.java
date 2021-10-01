package com.gb.wnn.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gb.wnn.dao.StudyDAO;
import com.gb.wnn.vo.StudyVO;
@Service("StudyService")
public class StudyServiceImpl implements StudyService{

	@Autowired
	private StudyDAO studyroom;

	//등록된 모든 스터디 목록 조회
	@Override
	public ArrayList<StudyVO> getAllStudy() throws Exception {
		//dao의 메소드를 찾아간다.
		return studyroom.getAllStudy();
	}

	@Override
	public void insertStudy(StudyVO studyVO) {
		studyroom.insertStudy(studyVO);		
	}

	@Override
	public StudyVO getStudy_region(StudyVO studyVO) {
		return studyroom.getStudy_region(studyVO);
	}

	@Override
	public StudyVO getStudy_tag(StudyVO studyVO) {
		return studyroom.getStudy_tag(studyVO);
	}

	@Override
	public StudyVO getStudy_name(StudyVO studyVO) {
		return studyroom.getStudy_name(studyVO);
	}

	@Override
	public void deleteStudy(StudyVO studyVO) {
		studyroom.deleteStudy(studyVO);		
	}
	//select *가 mapper에 있다.
	//전부 가져와서 종이상자 = resultSet에 넣고 이것을 객체 단위로 해서 넘겨줄 것이다.
	
}
