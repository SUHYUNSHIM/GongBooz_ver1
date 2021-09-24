package com.gb.wnn.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gb.wnn.vo.StudyVO;
@Service("StudyService")
public class StudyServiceImpl implements StudyService{
	
	@Autowired
	

	@Override
	public StudyVO getStudy(StudyVO vo1) throws ClassNotFoundException, SQLException {
		
		return null;
	}

	@Override
	public void updateLogin(StudyVO vo1) throws ClassNotFoundException, SQLException {
		
		
	}

	@Override
	public void insertLogin(StudyVO vo1) throws ClassNotFoundException, SQLException {
		
		
	}

	@Override
	public void deleteLogin(StudyVO vo1) throws ClassNotFoundException, SQLException {
		
		
	}

}
