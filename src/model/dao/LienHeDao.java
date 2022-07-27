package model.dao;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

import library.ConnectionDBLibrary;


public class LienHeDao {
	private ConnectionDBLibrary connectionDBLibrary;
	private Statement st;
	private Connection conn;
	
	public LienHeDao() {
		connectionDBLibrary = new ConnectionDBLibrary();
		
	}
	public void Insert(String name, String email, String phone, String content) {
		conn = connectionDBLibrary.getConnectMySQL();
		String sql = "INSERT INTO contact1(name, email, phone, content )values('"+name+"','"+email+"','"+phone+"','"+content+"')";
		try {
			st = conn.createStatement();
			
			st.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}