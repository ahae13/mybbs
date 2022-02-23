package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.BbsDto;

public class MyBbsDao {
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public List<BbsDto> getList() throws Exception{
		
		List<BbsDto> list = new ArrayList<>();
		conn = DBcon.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from mybbs_tbl");
		
		while(rs.next()) {
			BbsDto bDto = new BbsDto();
			bDto.setNum(rs.getInt("num"));
			bDto.setTitle(rs.getString("title"));
			bDto.setContent(rs.getString("content"));
			bDto.setWriter(rs.getString("writer"));
			bDto.setRegdate(rs.getString("regdate"));
			bDto.setReplycnt(rs.getInt("replycnt"));
			
			list.add(bDto);
		}
		
		conn.close();
		
		return list;
	}
	
	public BbsDto getBbs(int num) throws Exception{
		
		String sql = "select * from mybbs_tbl where num=" + num;
		conn = DBcon.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		BbsDto dto = new BbsDto();
		
		if(rs.next()) {
			dto.setNum(rs.getInt("num"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setWriter(rs.getString("writer"));
			dto.setRegdate(rs.getString("regdate"));
			dto.setReplycnt(rs.getInt("replycnt"));
		}
		
		return dto;
	}
}
