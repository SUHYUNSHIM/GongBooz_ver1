package com.gb.wnn.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gb.wnn.vo.StudyVO;
@Service("StudyService")
public class StudyServiceImpl implements StudyService{

	//@Autowired
	
	
	@Override
	public ArrayList<StudyVO> getAllStudyinfo(StudyVO vo1) throws ClassNotFoundException, SQLException {
		
		return null;
	}

	@Override
	public StudyVO getStudyinfo(StudyVO vo1) throws ClassNotFoundException, SQLException {
		
		return null;
	}

	@Override
	public void updateStudyino(StudyVO vo1) throws ClassNotFoundException, SQLException {
		
		
	}

	@Override
	public void insertStudyinfo(StudyVO vo1) throws ClassNotFoundException, SQLException {
		
		
	}

	@Override
	public void deleteStudyinfo(StudyVO vo1) throws ClassNotFoundException, SQLException {
		
		
	}
	
	
	

	
}
