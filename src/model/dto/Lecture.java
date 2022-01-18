/*
 * Project 	: 학생 수강 정보 프로젝트
 * Name 	: Lecture.java
 * DESC		: 강의 정보(Data)
 */

package model.dto;

public class Lecture {
	
	// 학수 번호
	private String lid;
	
	// 강의명
	private String lname;
	
	// 강의 교수 이름
	private String lpid;
	
	// 강의 타입 (전공 / 교양)
	private String ltype;
	
	// 강의 시간
	private String ltime;
	
	// 강의 교실
	private String lclassroom;
	
	public Lecture() {
		super();
	}

	public Lecture(String lid, String lname, String lpid, String ltype, String ltime, String lclassroom) {
		super();
		this.lid = lid;
		this.lname = lname;
		this.lpid = lpid;
		this.ltype = ltype;
		this.ltime = ltime;
		this.lclassroom = lclassroom;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLpid() {
		return lpid;
	}

	public void setLpid(String lpid) {
		this.lpid = lpid;
	}

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	public String getLtime() {
		return ltime;
	}

	public void setLtime(String ltime) {
		this.ltime = ltime;
	}

	public String getLclassroom() {
		return lclassroom;
	}

	public void setLclassroom(String lclassroom) {
		this.lclassroom = lclassroom;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[학수번호 : ");
		builder.append(lid);
		builder.append(", 강의명 : ");
		builder.append(lname);
		builder.append(", 교수번호 : ");
		builder.append(lpid);
		builder.append(", 과목구분 : ");
		builder.append(ltype);
		builder.append(", 강의시간 : ");
		builder.append(ltime);
		builder.append(", 강의실 : ");
		builder.append(lclassroom);
		builder.append("]");
		return builder.toString();
	}

}
