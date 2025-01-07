package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Model.User;
import Util.DataBaseUtil;

public class UserController {
	
	public int insertRecord(User user) throws ClassNotFoundException, SQLException {
		
		int status = 0;
		
		Connection conn = DataBaseUtil.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO user (name, gender, address, contact) VALUES (?, ?, ?, ?)");
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getGender());
		stmt.setString(3, user.getAddress());
		stmt.setString(4, user.getContact());
	
		status = stmt.executeUpdate();
		return status;
	}
	
	public int deleteRecord(int id) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = DataBaseUtil.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM user WHERE id = ?");
		stmt.setInt(1, id);
		
		status = stmt.executeUpdate();
		return status;
	}
	
	public int updateUser(User user) throws ClassNotFoundException, SQLException {
		int status = 0;
		
		Connection conn = DataBaseUtil.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement("UPDATE user SET name = ?, gender = ?, address = ?, contact = ? WHERE id = ?");
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getGender());
		stmt.setString(3, user.getAddress());
		stmt.setString(4, user.getContact());
		stmt.setInt(5, user.getId());
		
		status = stmt.executeUpdate();
		
		return status;
	}
	
	public ResultSet readRecord() throws ClassNotFoundException, SQLException {
		Connection conn = DataBaseUtil.getConnection();
		String sql = "SELECT * from user";
		Statement stmt = conn.createStatement();
		 
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	
	
}
