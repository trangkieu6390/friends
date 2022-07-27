package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library.ConnectionDBLibrary;
import model.bean.DanhMucBanBe;

public class DanhMucBanBeDao {

	private ConnectionDBLibrary connectionDBLibrary;

	private ResultSet rs;
	private Connection conn;
	private PreparedStatement psmt;
	public DanhMucBanBeDao() {
		// TODO Auto-generated constructor stub
		connectionDBLibrary = new ConnectionDBLibrary();
	} 
	
	public ArrayList<DanhMucBanBe> getItems(){
		ArrayList<DanhMucBanBe> listDMBB = new ArrayList<DanhMucBanBe>();
		conn = connectionDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM friend_list";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				DanhMucBanBe objDMBB = new DanhMucBanBe(rs.getInt("fl_id"), rs.getString("flname"));
				listDMBB.add(objDMBB);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listDMBB;
	}
	
	
	public DanhMucBanBe getItem(int idBB) {
		DanhMucBanBe objDMBB = null;
		conn = connectionDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM friend_list WHERE fl_id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, idBB);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				objDMBB = new DanhMucBanBe(rs.getInt("fl_id"), rs.getString("flname"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return objDMBB;
	}
}
