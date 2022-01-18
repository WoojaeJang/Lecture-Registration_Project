/*
 * Project 	: 학생 수강 정보 프로젝트
 * Name 	: StartView.java
 * DESC		: 실행 클래스
 * 				학생, 교수, 강의 및 학생의 수강정보를 생성하고 CRUD 로직을 test하는 클래스
 */

package view;

import controller.LectureRegistraionProjectController;
import model.dto.Lecture;
import model.dto.Professor;
import model.dto.Student;
import model.dto.LectureRegistraionProject;

public class StartView {

	public static void main(String[] args) {

		// 학생
		// 학번, 학생명, 생년월일, 학년, 전공, 지도교수id
		Student student1 = new Student("0677444", "김민준", "960302", 3, "컴퓨터공학", "A2345");
		Student student2 = new Student("1514623", "이준석", "071012", 1, "정보통신공학", "C3456");
		Student student3 = new Student("1537923", "장우재", "981129", 2, "산업공학", "D1234");
		Student student4 = new Student("2101170", "이현빈", "020723", 4, "물리학", "B6789");
		Student student5 = new Student("1703150", "박컴터", "010313", 1, "컴퓨터공학", "A2345");
		Student student6 = new Student("1915111", "김미술", "991225", 5, "디자인학", "F7789");
		Student student7 = new Student("1915111", "김변경", "991225", 5, "자율전공", "F7789");
		

		// 교수
		// 교수id, 교수명, 생년월일, 학과
		Professor professor1 = new Professor("A2345", "김독사", "500923", "전자전기");
		Professor professor2 = new Professor("C3456", "마변수", "620115", "수학");
		Professor professor3 = new Professor("D1234", "채송화", "581223", "컴퓨터공학");
		Professor professor4 = new Professor("B6789", "박둑심", "530404", "경영학");
		Professor professor5 = new Professor("F7789", "미자인", "630709", "디자인학");

		// 강의
		// 강의id, 강의명, 강의교수id, 강의종류, 강의시간, 교실
		Lecture lecture1 = new Lecture("0177888", "자료구조", "D1234", "전공", "월3-5", "C201");
		Lecture lecture2 = new Lecture("2177666", "통계학", "C3456", "전공", "화4-5", "T912");
		Lecture lecture3 = new Lecture("3255888", "네트워크통신학", "A2345", "전공", "금1-3", "A203");
		Lecture lecture4 = new Lecture("4477999", "보건학", "B6789", "교양", "목6-8", "H903");
		Lecture lecture5 = new Lecture("5577999", "디자인1", "F7789", "전공", "금6-8", "C603");

		// 프로젝트
		// 학생, 교수, 강의가 매핑된 실제 학생의 수강신청 정보
		// 프로젝트id, 학생, 강의, 교수, 등록날짜
		LectureRegistraionProject lectureRegistraionProject1 = new LectureRegistraionProject("A101", student1, lecture1, professor3, "2020-03-31");
		LectureRegistraionProject lectureRegistraionProject2 = new LectureRegistraionProject("A102", student2, lecture3, professor3, "2020-02-28");
		LectureRegistraionProject lectureRegistraionProject3 = new LectureRegistraionProject("A103", student2, lecture2, professor2, "2020-03-15");
		LectureRegistraionProject lectureRegistraionProject4 = new LectureRegistraionProject("A104", student3, lecture1, professor3, "2020-03-19");
		LectureRegistraionProject lectureRegistraionProject5 = new LectureRegistraionProject("A105", student3, lecture2, professor1, "2020-03-17");
		LectureRegistraionProject lectureRegistraionProject6 = new LectureRegistraionProject("A106", student4, lecture1, professor3, "2020-03-19");
		LectureRegistraionProject lectureRegistraionProject7 = new LectureRegistraionProject("A107", student6, lecture5, professor5, "2020-03-20");
		
		LectureRegistraionProjectController controller = LectureRegistraionProjectController.getInstance();

		// ----------------------------------------------------------------------

		// 1. Create
		System.out.println("-------------------------------------------------");
		System.out.println("-------------------------------------------------");
		System.out.println("*** 01. Create ***");
		System.out.println("-------------------------------------------------");
		System.out.println("-------------------------------------------------");
		System.out.println();

		// 1.1. 수강신청 내역 저장
		System.out.println("*** 01.01. 수강신청 ***\n");
		controller.lectureProjectInsert(lectureRegistraionProject1);
		controller.lectureProjectInsert(lectureRegistraionProject2);
		controller.lectureProjectInsert(lectureRegistraionProject3);
		controller.lectureProjectInsert(lectureRegistraionProject4);
		controller.lectureProjectInsert(lectureRegistraionProject5);
		controller.lectureProjectInsert(lectureRegistraionProject6);
		controller.lectureProjectInsert(lectureRegistraionProject7);

		// ----------------------------------------------------------------------

		// 2. Read
		System.out.println("\n\n-------------------------------------------------");
		System.out.println("-------------------------------------------------");
		System.out.println("*** 02. Read ***");
		System.out.println("-------------------------------------------------");
		System.out.println("-------------------------------------------------\n");

		// 2.1. 모든 수강 신청 정보 출력
		System.out.println("*** 02.01. 모든 수강정보 검색 ***\n");
		controller.getProjectAll();
		System.out.println("\n-------------------------------------------------\n");

		// 2.2. 프로젝트id 기준 -> 수강 신청 정보 조회
		System.out.println("*** 02.02. 프로젝트id = 'A101' 수강정보 검색 ***\n");
		controller.getProject("A101");
		System.out.println("\n-------------------------------------------------\n");
		
		// 2.3. 강의명 기준 -> 수강 신청 정보 조회
		System.out.println("*** 02.03. 강의명 = '자료구조' 수강정보 검색 ***\n");
		controller.getProjectByLname("자료구조");
		System.out.println("\n-------------------------------------------------\n");
		
		// 2.4. 학생명 기준 -> 수강 신청 정보 조회
		System.out.println("*** 02.04. 학생명 = '김민준' 수강정보 검색 ***\n");
		controller.getProjectBySname("김민준");
		System.out.println("\n-------------------------------------------------\n");
				
		// 2.5. 교수명 기준 -> 수강 신청 정보 조회
		System.out.println("*** 02.05. 교수명 = '마변수' 수강정보 검색 ***\n");
		controller.getProjectByPname("마변수");
		
		// ----------------------------------------------------------------------

		// 3. Update
		System.out.println("\n\n-------------------------------------------------");
		System.out.println("-------------------------------------------------");
		System.out.println("*** 03. Update ***");
		System.out.println("-------------------------------------------------");
		System.out.println("-------------------------------------------------\n");
		
		// 3.0. 기존 정보 출력
		System.out.println("*** 03.00. 프로젝트id = 'A101' 기존 수강정보 검색 ***\n");
		controller.getProject("A101");
		System.out.println("\n-------------------------------------------------\n");
		
		// 3.1. 프로젝트id 기준 -> 학생 변경 (변경과 검색 한번에)
		System.out.println("*** 03.01 프로젝트id = 'A101' 수강정보의 '학생' 변경 후 검색 ***\n");
		controller.updateStudent("A101", student6);
		System.out.println("\n-------------------------------------------------\n");
		
		// 3.2. 프로젝트id 기준 -> 강의 변경 (변경과 검색 한번에)
		System.out.println("*** 03.02 프로젝트id = 'A101' 수강정보의 '강의' 변경 후 검색 ***\n");
		controller.updateLecture("A101", lecture5);
		System.out.println("\n-------------------------------------------------\n");
		
		// 3.3. 프로젝트id 기준 -> 교수 변경 (변경과 검색 한번에)
		System.out.println("*** 03.03 프로젝트id = 'A101' 수강정보의 '교수' 변경 후 검색 ***\n");
		controller.updateProfessor("A101", professor5);
		System.out.println("\n-------------------------------------------------\n");
		
		// 3.4. 학생명 기준 -> 강의 변경 (변경 후 따로 검색)
		System.out.println("*** 03.04. 학생명 = '이준석' 수강정보의 '강의' 변경 후 검색 ***\n");
		System.out.println("----- 변경 전 -----");
		controller.getProjectBySname("이준석");
		System.out.println("\n----- 변경 후 -----");
		controller.updateLectureBySname("이준석", lecture4);
		controller.getProjectBySname("이준석");
		System.out.println("\n-------------------------------------------------\n");
		
		// 3.5. 강의명 기준 -> 교수 변경 (변경 후 따로 검색)
		System.out.println("*** 03.05. 강의명 = '자료구조' 수강정보의 '교수' 변경 후 검색 ***\n");
		System.out.println("----- 변경 전 -----");
		controller.getProjectByLname("자료구조");
		System.out.println("\n----- 변경 후 -----");
		controller.updateProfessorByLname("자료구조", professor4);
		controller.getProjectByLname("자료구조");
		
		// ----------------------------------------------------------------------
		
		// 4. Delete
		System.out.println("\n\n-------------------------------------------------");
		System.out.println("-------------------------------------------------");
		System.out.println("*** 04. Delete ***");
		System.out.println("-------------------------------------------------");
		System.out.println("-------------------------------------------------\n");
		
		// 4.1. 프로젝트id 기준 -> 수강신청 철회
		System.out.println("*** 04.01. 프로젝트id = 'A101' 수강정보 삭제 후 검색 ***\n");
		System.out.println("----- 삭제 전 -----");
		controller.getProject("A101");
		System.out.println("\n----- 삭제 -----");
		controller.deleteProject("A101");
		System.out.println("\n----- 삭제 후 -----");
		controller.getProject("A101");
		System.out.println("\n-------------------------------------------------\n");
		
		// 4.2. 학생명 기준 -> 수강신청 철회
		System.out.println("*** 04.02. 학생명 = '이현빈' 수강정보 삭제 후 검색 ***\n");
		System.out.println("----- 삭제 전 -----");
		controller.getProjectBySname("이현빈");
		System.out.println("\n----- 삭제 -----");
		controller.deleteProjectBySname("이현빈");
		System.out.println("\n----- 삭제 후 -----");
		controller.getProjectBySname("이현빈");
		System.out.println("\n-------------------------------------------------\n");
		
		// 4.3. 강의명 기준 -> 수강신청 철회
		System.out.println("*** 04.03. 강의명 = '디자인1' 수강정보 삭제 후 검색 ***\n");
		System.out.println("----- 삭제 전 -----");
		controller.getProjectByLname("디자인1");
		System.out.println("\n----- 삭제 -----");
		controller.deleteProjectByLname("디자인1");
		System.out.println("\n----- 삭제 후 -----");
		controller.getProjectByLname("디자인1");
		System.out.println("\n-------------------------------------------------\n");
		
		// 4.4. 교수명 기준 -> 수강신청 철회
		System.out.println("*** 04.04. 교수명 = '채송화' 수강정보 삭제 후 검색 ***\n");
		System.out.println("----- 삭제 전 -----");
		controller.getProjectByPname("채송화");
		System.out.println("\n----- 삭제 -----");
		controller.deleteProjectByPname("채송화");
		System.out.println("\n----- 삭제 후 -----");
		controller.getProjectByPname("채송화");
		System.out.println("\n-------------------------------------------------\n");
		
	}

}
