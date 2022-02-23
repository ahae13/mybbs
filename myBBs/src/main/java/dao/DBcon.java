package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcon {
	public static Connection conn;
	static final String url = "jdbc:oracle:thin:@localhost:1521/xe";
	static final String user ="system";
	static final String pw = "1234";
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(url, user, pw);
		
		return conn;
	}
	
}
