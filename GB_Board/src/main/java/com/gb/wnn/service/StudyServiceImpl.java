package com.gb.wnn.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gb.wnn.dao.StudyDAO;
import com.gb.wnn.vo.StudyVO;
//@Service("StudyService")
public class StudyServiceImpl implements StudyService{

	@Autowired
	private StudyDAO studyroom;
	
	@Override
	public ArrayList<StudyVO> getAllStudy() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertStudy(StudyVO studyVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StudyVO getStudy(StudyVO studyVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudy(StudyVO studyVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudy(StudyVO studyVO) {
		// TODO Auto-generated method stub
		
	}

	//@Autowired
	
	
	

	
}
