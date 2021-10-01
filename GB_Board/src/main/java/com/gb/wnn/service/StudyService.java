package com.gb.wnn.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gb.wnn.vo.StudyVO;

public interface StudyService {
	
	ArrayList <StudyVO> getAllStudy() throws Exception;
	void insertStudy(StudyVO studyVO);
	StudyVO getStudy(StudyVO studyVO);
	void updateStudy(StudyVO studyVO);
	void deleteStudy(StudyVO studyVO);
	   
   
}
