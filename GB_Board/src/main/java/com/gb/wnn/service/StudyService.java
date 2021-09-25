package com.gb.wnn.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gb.wnn.vo.StudyVO;

public interface StudyService {
	
	public ArrayList <StudyVO> getAllStudyinfo(StudyVO vo1) throws ClassNotFoundException, SQLException; 
	public StudyVO getStudyinfo (StudyVO vo1) throws ClassNotFoundException, SQLException;
	public void updateStudyino(StudyVO vo1) throws ClassNotFoundException, SQLException;
	public void insertStudyinfo(StudyVO vo1) throws ClassNotFoundException, SQLException;
    public void deleteStudyinfo(StudyVO vo1) throws ClassNotFoundException, SQLException;    
    
    
    /* 주석 나중에 삭제하기
     *  public ArrayList <TelInfoVO> getAllTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException; 	
		public TelInfoVO getTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;		
		public void updateTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;	
		public void insertTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;
		public void deleteTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;
     * */
}
