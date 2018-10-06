package bulletin_board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Content {
	String title;
	String content;
	String writer;
	
	SimpleDateFormat d = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
	Date wt = new Date();
	String writeTime = d.format(wt);
	
	public Content(String title, String content, String writer) {
		this. title = title;
		this. content = content;
		this.writer = writer;
	}
	
	public void  setTitle(String title) {this.title = title;}
	public void  setContetn(String content) {this.content = content;}
	public String getTitle() {return title;}
	public String getContent() {return content;}
	public String getWriteTime() {return writeTime;}
	public String getWriter() {return writer;}
	
	
}
