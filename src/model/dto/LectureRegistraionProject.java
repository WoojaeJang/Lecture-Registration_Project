/*
 * Project 	: 학생 수강 정보 프로젝트
 * Name 	: StudentCurriculumProject.java
 * DESC		: 학생들의 강의 수강 정보(Data)
 */

package model.dto;

public class LectureRegistraionProject {
	
	// 학생의 강의 수강 정보 id
	private String projectID;
	
	// 학생
	private Student projectStudent;
	
	// 강의
	private Lecture projectLecture;
	
	// 교수
	private Professor projectProfessor;
	
	// 등록 날짜
	private String registerDate;
	
	public LectureRegistraionProject() {
		super();
	}

	public LectureRegistraionProject(String projectID, Student projectStudent, Lecture projectLecture, Professor projectProfessor, String registerDate) {
		super();
		this.projectID = projectID;
		this.projectStudent = projectStudent;
		this.projectLecture = projectLecture;
		this.projectProfessor = projectProfessor;
		this.registerDate = registerDate;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public Student getProjectStudent() {
		return projectStudent;
	}

	public void setProjectStudent(Student projectStudent) {
		this.projectStudent = projectStudent;
	}

	public Lecture getProjectLecture() {
		return projectLecture;
	}

	public void setProjectLecture(Lecture projectLecture) {
		this.projectLecture = projectLecture;
	}

	public Professor getProjectProfessor() {
		return projectProfessor;
	}

	public void setProjectProfessor(Professor projectProfessor) {
		this.projectProfessor = projectProfessor;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("* 수강번호 : ");
		builder.append(projectID);
		builder.append("\n* 학생정보 : ");
		builder.append(projectStudent);
		builder.append("\n* 강의정보 : ");
		builder.append(projectLecture);
		builder.append("\n* 교수정보 : ");
		builder.append(projectProfessor);
		builder.append("\n* 등록날짜 : ");
		builder.append(registerDate);
		return builder.toString();
	}

}
