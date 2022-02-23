package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {
	
	Connection conn;
	PreparedStatement pstmt;
	//Statement stmt;
	ResultSet rs;
	
	public int regist(String id, String pw, String name) throws Exception {
		
		String sql = "insert into mybbs_user_tbl values(?, ?, ?)";
		conn = DBcon.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, name);
		pstmt.executeUpdate();
				
		conn.close();
		return 0;
	}
	
	public int checkId(String id) throws Exception {
		
		String sql = "select count(id) cnt from mybbs_user_tbl where id=?";
		System.out.println("userDao.checkId : " + id);
		conn = DBcon.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		rs.next();
		int result = rs.getInt("cnt");
		return result;
	}
	
	public int checkLogin(String id, String pw) throws Exception {
		
		String sql = "select count(*) from mybbs_user_tbl where id=? and pw=?";
		conn = DBcon.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		rs = pstmt.executeQuery();
		int result = 0;
		
		if(rs.next()) {
			System.out.println(rs.getInt("count(*)"));
			result = rs.getInt("count(*)");
		}else
			System.out.println("Login fail");
		
		conn.close();
		
		return result;
	}
	
	
}
