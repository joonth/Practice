package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
