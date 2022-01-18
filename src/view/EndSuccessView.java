package view;

import model.dto.LectureRegistraionProject;

public class EndSuccessView {

	public static void successView(String m) {		
			System.out.println(m);	
	}

	public static void saveSuccessView(LectureRegistraionProject project) {
		System.out.println("[수강번호='"+project.getProjectID() + "'] 저장 완료");
	}

	public static void deleteSuccessView(String projectID) {
		System.out.println("[수강번호='" + projectID + "'] 삭제 완료");
	}

	public static void deleteSuccessViewBySname(String sname) {
		System.out.println("[학생명='" + sname + "'] 삭제 완료");
	}

	public static void deleteSuccessViewByLname(String lname) {
		System.out.println("[강의명='" + lname + "'] 삭제 완료");
	}

	public static void deleteSuccessViewByPname(String pname) {
		System.out.println("[교수명='" + pname + "'] 삭제 완료");
	}
	
}
