package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDBLibrary {

	private Connection conn;
	private String url;
	private String user;
	private String pass;
	private String db;
	public ConnectionDBLibrary() {
		this.db="myfriends";
		this.url = "jdbc:mysql://localhost:3306/"+db+"?useUnicode=true&characterEncoding=UTF-8";
	
		this.user = "root";
		this.pass = "";
	}
	
	public Connection getConnectMySQL() {
		//nap driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String [] args) {
		ConnectionDBLibrary connectionDBLibrary = new ConnectionDBLibrary();
		System.out.println(connectionDBLibrary.getConnectMySQL());
	}
}
