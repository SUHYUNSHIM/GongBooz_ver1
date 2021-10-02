package com.gb.wnn.service;

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
	
	//service와 dao가 내용이 같다.
   
}
