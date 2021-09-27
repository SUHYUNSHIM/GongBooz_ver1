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
	
	/*public ArrayList <StudyVO> getAllStudyinfo(StudyVO vo1) throws ClassNotFoundException, SQLException; 
	public StudyVO getStudyinfo (StudyVO vo1) throws ClassNotFoundException, SQLException;
	public void updateStudyino(StudyVO vo1) throws ClassNotFoundException, SQLException;
	public void insertStudyinfo(StudyVO vo1) throws ClassNotFoundException, SQLException;
    public void deleteStudyinfo(StudyVO vo1) throws ClassNotFoundException, SQLException;    */
    
    
   
}
