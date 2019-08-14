package pojos;

import java.sql.Timestamp;

public class Topic {
	private int id;
	private int userid;
	private String title;
	private String content;
	

	private int pid;

	private Timestamp creatDate;

	private int isLegal;
	
	private int sid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Timestamp getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Timestamp creatDate) {
		this.creatDate = creatDate;
	}
	public int getIsLegal() {
		return isLegal;
	}
	public void setIsLegal(int isLegal) {
		this.isLegal = isLegal;
	}
	
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public void setAll(int id,int userid,int pid,String title,String content,Timestamp date){
		setId(id);
		setUserid(userid);
		setPid(pid);
		setTitle(title);
		setContent(content);
		setCreatDate(date);
		
	}
	
}
