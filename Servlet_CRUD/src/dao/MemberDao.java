package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Member;

public class MemberDao {
		
	Connection conn = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public Member login (String email, String pwd)throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select mno, mname, email from members where email=? and pwd=?");
			pstmt.setString(1, email);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Member member= new Member()
						.setMno(rs.getInt("mno"))
						.setMname(rs.getString("mname"))
						.setEmail(rs.getString("email"));
				return member;
			}else {
				return null;
			}
				
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(rs!=null) rs.close();}catch(Exception e) {}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e) {}
		}
	}
	
	public List<Member> getList () throws Exception{
		Statement stmt = null;
		ResultSet rs =null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select mno,mname,email,cre_date from members order by mno asc");
			List<Member> members = new ArrayList<>();
			while(rs.next()) {
				members.add(new Member()
						.setMno(rs.getInt("mno"))
						.setMname(rs.getString("mname"))
						.setEmail(rs.getString("email"))
						.setCre_date(rs.getDate("cre_date")));
			}
			return members;
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(rs!=null) rs.close();}catch(Exception e) {}
			try {if(stmt!=null) stmt.close();}catch(Exception e) {}
		}
	}
	
	
}
