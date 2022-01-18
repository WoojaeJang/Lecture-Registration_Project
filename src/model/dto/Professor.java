/*
 * Project 	: 학생 수강 정보 프로젝트
 * Name 	: Professor.java
 * DESC		: 교수 정보(Data)
 */

package model.dto;

public class Professor {
	
	// 교수의 id
	private String pid;
	
	// 교수의 이름
	private String pname;
	
	// 교수의 생년월일
	private String pbirthday;
	
	// 교수의 학과
	private String pdepartment;
	
	public Professor() {
		super();
	}

	public Professor(String pid, String pname, String pbirthday, String pdepartment) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pbirthday = pbirthday;
		this.pdepartment = pdepartment;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPbirthday() {
		return pbirthday;
	}

	public void setPbirthday(String pbirthday) {
		this.pbirthday = pbirthday;
	}

	public String getPdepartment() {
		return pdepartment;
	}

	public void setPdepartment(String pdepartment) {
		this.pdepartment = pdepartment;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[교수번호 : ");
		builder.append(pid);
		builder.append(", 교수명 : ");
		builder.append(pname);
		builder.append(", 생년월일 : ");
		builder.append(pbirthday);
		builder.append(", 학과 : ");
		builder.append(pdepartment);
		builder.append("]");
		return builder.toString();
	}

}
