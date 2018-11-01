package dao;

import java.sql.Connection;

public class MemberDao {
		
	Connection conn = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	
	
}
