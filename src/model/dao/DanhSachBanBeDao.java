package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library.ConnectionDBLibrary;
import model.bean.DanhSachBanBe;

public class DanhSachBanBeDao {

	private ConnectionDBLibrary connectionDBLibrary;
	private ResultSet rs;
	private Connection conn;
	private PreparedStatement psmt;
	
	public DanhSachBanBeDao() {
		connectionDBLibrary = new ConnectionDBLibrary();
		
	}
	
	public int countPage() {
		int total = 0;
		conn = connectionDBLibrary.getConnectMySQL();
		String sql = "SELECT COUNT(*) FROM friends WHERE fid";
		try {
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				int total1 = rs.getInt(1);
				total = total1/3;
				if(total%3!=0) {
					total++;
				}
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
		
		return total;
	}
	
	public ArrayList<DanhSachBanBe> getPagging(int indexPgae){
		ArrayList<DanhSachBanBe> listBB = new ArrayList<DanhSachBanBe>();
		conn = connectionDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM friends LIMIT ?,3";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, (indexPgae-1)*3);
			rs = psmt.executeQuery();
			while(rs.next()) {
				DanhSachBanBe objBB = new DanhSachBanBe(
						rs.getInt("fl_id"),
						rs.getInt("fid"), 
						rs.getString("preview_text") ,
						rs.getDate("date_create"), 
						rs.getString("flname"), 
						rs.getInt("count_number"),
						rs.getString("detail"));
			
				listBB.add(objBB);
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
		return listBB;
	}

	public DanhSachBanBe getItem(int idDSBB) {
		DanhSachBanBe objBanBe = null;
		conn = connectionDBLibrary.getConnectMySQL();
		String sql = " SELECT * FROM friends WHERE fid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, idDSBB);
			rs = psmt.executeQuery();
			if(rs.next()) {

				objBanBe = new DanhSachBanBe(
						rs.getInt("fl_id"),
						rs.getInt("fid"), 
						rs.getString("preview_text") ,
						rs.getDate("date_create"), 
						rs.getString("flname"), 
						rs.getInt("count_number"),
						rs.getString("detail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return objBanBe;
	}

	public ArrayList<DanhSachBanBe> getItemsByID(int idBB) {
		ArrayList<DanhSachBanBe> listBB = new ArrayList<DanhSachBanBe>();
		conn = connectionDBLibrary.getConnectMySQL();
		String sql = " SELECT * FROM friends WHERE fl_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, idBB);
			rs = psmt.executeQuery();
			while(rs.next()) {
				DanhSachBanBe objBB = new DanhSachBanBe(
						
								rs.getInt("fl_id"),
								rs.getInt("fid"), 
								rs.getString("preview_text") ,
								rs.getDate("date_create"), 
								rs.getString("flname"), 
								rs.getInt("count_number"),
								rs.getString("detail"));
				listBB.add(objBB);
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
		return listBB;
	}

	public int countPage1(int idBB) {
		int total = 0;
		conn = connectionDBLibrary.getConnectMySQL();
		String sql = "SELECT COUNT(*) FROM friends WHERE fl_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, idBB);
			rs = psmt.executeQuery();
			while(rs.next()) {
				int total1 = rs.getInt(1);
				total = total1/3;
				if(total%3!=0) {
					total++;
				}
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
		
		return total;
	}

	public ArrayList<DanhSachBanBe> getPagging(String searchBB, int index_page) {
		ArrayList<DanhSachBanBe> listBB = new ArrayList<DanhSachBanBe>();
		conn = connectionDBLibrary.getConnectMySQL();
	
		String sql = "SELECT * FROM friends WHERE flname like ? LIMIT ?,3";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+searchBB+"%");
			psmt.setInt(2, (index_page-1)*3);
			rs = psmt.executeQuery();
			while(rs.next()) {
				DanhSachBanBe objBB = new DanhSachBanBe(
						
						rs.getInt("fl_id"),
						rs.getInt("fid"), 
						rs.getString("preview_text") ,
						rs.getDate("date_create"), 
						rs.getString("flname"), 
						rs.getInt("count_number"),
						rs.getString("detail"));
				listBB.add(objBB);
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
		return listBB;
	}

	public int countPage(String searchPage) {
		int total = 0;
		conn = connectionDBLibrary.getConnectMySQL();
		String sql = "SELECT COUNT(*) FROM friends WHERE flname like ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+searchPage+"%");
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				int total1 = rs.getInt(1);
				total = total1/3;
				if(total%3!=0) {
					total++;
				}
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
		
		return total;
	}

	public DanhSachBanBe updateView(int idBB) {
		DanhSachBanBe objDMBB = null;
		conn = connectionDBLibrary.getConnectMySQL();
		String sql = " UPDATE friends SET count_number = count_number + 1  WHERE fid = ?";
		try {
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, idBB);
			psmt.executeUpdate();
			
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
	public ArrayList<DanhSachBanBe> getListFriend(int fid, int fl_id) {
		ArrayList<DanhSachBanBe> listBB = new ArrayList<DanhSachBanBe>();
		conn = connectionDBLibrary.getConnectMySQL();
		String sql = " SELECT * FROM friends WHERE fl_id = ? and fid not in(?) limit 2";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, fl_id);
			psmt.setInt(2, fid);
			rs = psmt.executeQuery();
			while(rs.next()) {
				DanhSachBanBe objBB = new DanhSachBanBe(
						
								rs.getInt("fl_id"),
								rs.getInt("fid"), 
								rs.getString("preview_text") ,
								rs.getDate("date_create"), 
								rs.getString("flname"), 
								rs.getInt("count_number"),
								rs.getString("detail"));
				listBB.add(objBB);
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
		return listBB;
	}
}
