package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import annotation.Component;
import vo.Project;

@Component("projectDao")
public class OracleProjectDao implements ProjectDao {

	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public List<Project> selectList() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Project> list = new ArrayList<>();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select pno,pname,sta_date,end_date,state from projects order by pno desc ");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("pno")+","+rs.getString("pname")+","+rs.getDate("sta_date"));
				list.add(new Project()
						.setPno(rs.getInt("pno"))
						.setPname(rs.getString("pname"))
						.setSta_date(rs.getDate("sta_date"))
						.setEnd_date(rs.getDate("end_date"))
						.setState(rs.getInt("state"))
				);
			}
			System.out.println(list.size());

			return list;
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(pstmt != null) pstmt.close();}catch(Exception e) {}
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
	}

	@Override
	public int insert(Project project) throws Exception {
		Connection conn =null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count =0;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select pno from projects order by pno desc");
			rs.next();
			int lastNum = rs.getInt("pno")+1;
			pstmt = conn.prepareStatement("insert into projects values (?,?,?,0,?,?,?,sysdate)");
			pstmt.setInt(1, lastNum);
			pstmt.setString(2, project.getPname());
			pstmt.setString(3, project.getContent());
			pstmt.setString(4, project.getTags());
			pstmt.setDate(5,(Date) project.getSta_date() );
			pstmt.setDate(6, (Date) project.getEnd_date());
			count = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(rs !=null) rs.close();}catch(Exception e) {}
			try {if(pstmt !=null) pstmt.close();}catch(Exception e) {}
			try {if(stmt !=null) stmt.close();}catch(Exception e) {}
			try {if(conn !=null) conn.close();}catch(Exception e) {}
		}
		return count;
	}

	@Override
	public Project selectOne(int pno) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Project project = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select pno,pname,content,sta_date,end_date,state,tags from projects where pno = ?");
			pstmt.setInt(1, pno);
			rs = pstmt.executeQuery();
			rs.next();
			project = new Project()
									.setPno(rs.getInt("pno"))
									.setPname(rs.getString("pname"))
									.setContent(rs.getString("content"))
									.setSta_date(rs.getDate("sta_date"))
									.setEnd_date(rs.getDate("end_date"))
									.setState(rs.getInt("state"))
									.setTags(rs.getString("tags"));
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(pstmt != null) pstmt.close();}catch(Exception e) {}
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
		return project;
	}

	@Override
	public int update(Project project) throws Exception {
		Connection conn= null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("update projects set pname = ?, content = ?, sta_date = ?, end_date =?, state = ? , tags = ? where pno = ?");
			pstmt.setString(1, project.getPname());
			pstmt.setString(2, project.getContent());
			pstmt.setDate(3, (Date) project.getSta_date());
			pstmt.setDate(4, (Date) project.getEnd_date());
			pstmt.setInt(5, project.getState());
			pstmt.setString(6, project.getTags());
			pstmt.setInt(7, project.getPno());
			count = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(pstmt !=null) pstmt.close();}catch(Exception e) {}
			try {if(conn !=null) conn.close();}catch(Exception e) {}
		}
		return count;
	}
}
