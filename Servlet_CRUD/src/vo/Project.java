package vo;

import java.sql.Date;

public class Project {
	protected int pno;
	protected String pname;
	protected String content;
	protected int state;
	protected String tags;
	protected Date sta_date;
	protected Date end_date;
	protected Date cre_date;
	
	
	public int getPno() {
		return pno;
	}
	public Project setPno(int pno) {
		this.pno = pno; return this;
	}
	public String getPname() {
		return pname;
	}
	public Project setPname(String pname) {
		this.pname = pname; return this;
	}
	public String getContent() {
		return content;
	}
	public Project setContent(String content) {
		this.content = content; return this;
	}
	public int getState() {
		return state;
	}
	public Project setState(int state) {
		this.state = state; return this;
	}
	public String getTags() {
		return tags;
	}
	public Project setTags(String tags) {
		this.tags = tags; return this;
	}
	public Date getSta_date() {
		return sta_date;
	}
	public Project setSta_date(Date sta_date) {
		this.sta_date = sta_date; return this;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public Project setEnd_date(Date end_date) {
		this.end_date = end_date; return this;
	}
	public Date getCre_date() {
		return cre_date;
	}
	public Project setCre_date(Date cre_date) {
		this.cre_date = cre_date; return this;
	}
	
}
