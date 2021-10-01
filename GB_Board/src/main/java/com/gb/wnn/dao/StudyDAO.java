package com.gb.wnn.dao;

import java.util.ArrayList;
import com.gb.wnn.vo.StudyVO;

//mapper interface 참조
public interface StudyDAO {
	ArrayList <StudyVO> getAllStudy();
	void insertStudy(StudyVO studyVO); //스터디 입력
	StudyVO getStudy_region(StudyVO studyVO); //지역으로 스터디 찾기
	StudyVO getStudy_tag(StudyVO studyVO); //태그로 스터디 찾기
	StudyVO getStudy_name(StudyVO studyVO); //이름으로 스터디 찾기
		
	void deleteStudy(StudyVO studyVO); //스터디를 삭제한다.
}
