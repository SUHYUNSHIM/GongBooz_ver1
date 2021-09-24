package com.gb.wnn.service;

import java.sql.SQLException;
import com.gb.wnn.vo.StudyVO;

public interface StudyService {
	public StudyVO getStudy(StudyVO vo1) throws ClassNotFoundException, SQLException;
	public void updateLogin(StudyVO vo1) throws ClassNotFoundException, SQLException;
	public void insertLogin(StudyVO vo1) throws ClassNotFoundException, SQLException;
    public void deleteLogin(StudyVO vo1) throws ClassNotFoundException, SQLException;
}
