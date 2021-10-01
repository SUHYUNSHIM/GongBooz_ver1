package com.gb.wnn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.gb.wnn.vo.StudyVO;

//mapper interface 참조
public interface StudyDAO {
	ArrayList <StudyVO> getAllStudy();
	void insertSawon(StudyVO sawonVO);
	StudyVO getTelinfo(StudyVO sawonVO);
	void updateTelinfo(StudyVO sawonVO);
	void deleteTelinfo(StudyVO sawonVO);
}
