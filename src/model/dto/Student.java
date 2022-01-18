/*
 * Project 	: 학생 수강 정보 프로젝트
 * Name 	: Student.java
 * DESC		: 학생 정보(Data)
 */

package model.dto;

public class Student {
	
	// 학번
	private String sid;
	
	// 학생의 이름
	private String sname;
	
	// 학생의 생년월일
	private String sbirthday;
	
	// 학생의 학년
	private int sgrade;
	
	// 학생의 전공
	private String smajor;
	
	// 학생의 지도교수 id
	private String advpid;
	
	public Student() {
		super();
	}

	public Student(String sid, String sname, String sbirthday, int sgrade, String smajor, String advpid) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sbirthday = sbirthday;
		this.sgrade = sgrade;
		this.smajor = smajor;
		this.advpid = advpid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSbirthday() {
		return sbirthday;
	}

	public void setSbirthday(String sbirthday) {
		this.sbirthday = sbirthday;
	}

	public int getSgrade() {
		return sgrade;
	}

	public void setSgrade(int sgrade) {
		this.sgrade = sgrade;
	}

	public String getSmajor() {
		return smajor;
	}

	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}

	public String getAdvpid() {
		return advpid;
	}

	public void setAdvpid(String advpid) {
		this.advpid = advpid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[학번 : ");
		builder.append(sid);
		builder.append(", 학생명 : ");
		builder.append(sname);
		builder.append(", 생년월일 : ");
		builder.append(sbirthday);
		builder.append(", 학년 : ");
		builder.append(sgrade);
		builder.append(", 전공 : ");
		builder.append(smajor);
		builder.append(", 지도교수 : ");
		builder.append(advpid);
		builder.append("]");
		return builder.toString();
	}
		
}
