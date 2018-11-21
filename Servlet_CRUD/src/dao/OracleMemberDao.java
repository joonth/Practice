package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import util.DBConnectionPool;
import vo.Member;

public class OracleMemberDao implements MemberDao {
		
	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public Member login (Member mem)throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select mno, mname, email from members where email=? and pwd=?");
			pstmt.setString(1, mem.getEmail());
			pstmt.setString(2, mem.getPwd());
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
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
	}
	
	public List<Member> getList () throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		try {
			conn = ds.getConnection();
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
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
	}
	
	public void addMember(Member mem) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select mno from members order by mno desc");
			rs.next();
			int lastNum =rs.getInt("mno")+1;
			
			pstmt = conn.prepareStatement("insert into members (mno,mname,email,pwd,cre_date,mod_date) values (?,?,?,?,sysdate,sysdate)");
			pstmt.setInt(1, lastNum);
			pstmt.setString(2, mem.getMname());
			pstmt.setString(3, mem.getEmail());
			pstmt.setString(4, mem.getPwd());
			pstmt.executeQuery();
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(pstmt != null) pstmt.close();}catch(Exception e) {}
			try {if(stmt != null) stmt.close();}catch(Exception e) {}
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
	}
	
	public Member getMemberInfo (String mno) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			System.out.println("######"+mno);
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select mno,mname,email,cre_date from members where mno ="+mno);
			rs.next();
			Member member = new Member()
					.setMno(rs.getInt("mno"))
					.setMname(rs.getString("mname"))
					.setEmail(rs.getString("email"))
					.setCre_date(rs.getDate("cre_date"));
			return member;
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(rs !=null) rs.close();}catch(Exception e) {}
			try {if(stmt !=null) stmt.close();}catch(Exception e) {}
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
	}
	
	public void updateMember(Member mem) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("update members set mname =? ,email = ? ,mod_date=sysdate where mno=?");
			pstmt.setString(1, mem.getMname());
			pstmt.setString(2, mem.getEmail());
			pstmt.setInt(3, mem.getMno());
			pstmt.executeQuery();
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(rs !=null) rs.close();}catch(Exception e) {}
			try {if(pstmt !=null) pstmt.close();}catch(Exception e) {}
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
	}
	
	public void deleteMember(String mno) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		Statement stmt1 = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			stmt.executeQuery("delete members where mno="+mno);
			
			stmt1 = conn.createStatement();
			stmt1.executeQuery("update members set mno = mno-1 where mno >"+mno);
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(stmt1 != null) stmt1.close();}catch(Exception e) {}
			try {if(stmt != null) stmt.close();}catch(Exception e) {}
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
	}
	
}
