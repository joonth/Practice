package bulletin_board;

public class User {
	String id ;
	String pw;
	boolean loginStatus = false;
	
	public User(String id , String pw ) {
		this.id = id;
		this. pw = pw;
	}
	
	public String getId() {return id;}
	public String getPw() {return pw;}
	public boolean getLs() {return loginStatus;}
	public void setLs(boolean loginStatus) {this.loginStatus = loginStatus;}
}
