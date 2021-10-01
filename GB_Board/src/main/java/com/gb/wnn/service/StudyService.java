package com.gb.wnn.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gb.wnn.vo.StudyVO;

//service에 선언한 것은 mapper를 도와주기 위해
public interface StudyService {
	
	ArrayList <StudyVO> getAllStudy() throws Exception;
	void insertStudy(StudyVO studyVO);
	StudyVO getStudy_region(StudyVO studyVO); //지역으로 스터디 찾기
	StudyVO getStudy_tag(StudyVO studyVO); //태그로 스터디 찾기
	StudyVO getStudy_name(StudyVO studyVO); //이름으로 스터디 찾기
		
	void deleteStudy(StudyVO studyVO);
	
	/*
	 * ArrayList <StudyVO> getAllStudy();
	void insertStudy(StudyVO studyVO); //스터디 입력
	StudyVO getStudy_region(StudyVO studyVO); //지역으로 스터디 찾기
	StudyVO getStudy_tag(StudyVO studyVO); //태그로 스터디 찾기
	StudyVO getStudy_name(StudyVO studyVO); //이름으로 스터디 찾기
		
	void deleteStudy(StudyVO studyVO); //스터디를 삭제한다.
	 * */
	   
   
}
