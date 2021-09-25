package com.gb.wnn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.gb.wnn.dbconn.StudyDBConn;

@Repository
public class StudyDAO {
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public StudyDAO() throws ClassNotFoundException, SQLException {
		con = new StudyDBConn().getConnection();
	}
	
	/*public LoginDAO() 
			throws ClassNotFoundException, SQLException {
		con = new LoginDBConn().getConnection();
	}
	
	 * */
}
