package controller;

import exception.ProjectIDDuplicationException;
import exception.ProjectNotFoundException;
import model.dto.Lecture;
import model.dto.LectureRegistraionProject;
import model.dto.Professor;
import model.dto.Student;
import service.LectureRegistraionProjectService;
import view.EndFailView;
import view.EndSuccessView;
import view.EndView;

public class LectureRegistraionProjectController {

	private static LectureRegistraionProjectController instance = new LectureRegistraionProjectController();

	private LectureRegistraionProjectController() {
	}

	public static LectureRegistraionProjectController getInstance() {
		return instance;
	}

	private LectureRegistraionProjectService service = LectureRegistraionProjectService.getInstance();

	// --- Create ---------------------------------------------------------------

	// Insert : 프로젝트 추가
	/*
	 * 개발 방법 : 1. 데이터 유무 확인 1.1. 데이터 있는 경우 -> Service에서 insert 진행 1.1.1. 중복된
	 * projectID가 있는 경우 -> 예외처리 -> EndFailView에서 문제 출력 1.1.2. 중복된 projectID가 없는 경우
	 * -> 데이터 추가 1.2. 데이터 없는 경우 -> EndFailView에서 문제 출력
	 * 
	 */
	public void lectureProjectInsert(LectureRegistraionProject project) {
		if (project != null) {
			try {
				service.lectureProjectInsert(project);
				EndSuccessView.saveSuccessView(project);
			} catch (ProjectIDDuplicationException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("저장하고자 하는 데이터가 없습니다.");
		}
	}

	// --- Read -----------------------------------------------------------------

	// Get All : 모든 프로젝트 검색
	public void getProjectAll() {
		EndView.projectViewAll(service.getProjectAll());
	}

	// Get One (By projetID) : projectID로 프로젝트 검색
	public void getProject(String projectID) {
		try {
			EndView.projectView(service.getProject(projectID));
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	// Get By Lname : 강의명으로 프로젝트 검색
	public void getProjectByLname(String lname) {
		try {
			EndView.projectListView(service.getProjectByLname(lname));
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	// Get By Sname : 학생명으로 프로젝트 검색
	public void getProjectBySname(String sname) {
		try {
			EndView.projectListView(service.getProjectBySname(sname));
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}
	
	// Get By Pname : 교수명으로 프로젝트 검색
	public void getProjectByPname(String pname) {
		try {
			EndView.projectListView(service.getProjectByPname(pname));
		} catch (ProjectNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	// --- Update --------------------------------------------------------------

	// Update Student (By projetID) : projectID로 강의 변경
	// 방법1 : 갱신과 조회 한번에 해보기
	public void updateStudent(String projectID, Student student) {
		if (projectID != null && student != null) {
			boolean result = service.updateStudent(projectID, student);
			if (result) {
				try {
					EndView.projectView(service.getProject(projectID));
				} catch (ProjectNotFoundException e) {
					e.printStackTrace();
					EndFailView.failView(e.getMessage());
				}
			} else {
				EndFailView.failView("저장하고자 하는 데이터가 없습니다.");
			}
		} else {
			EndFailView.failView("잘못된 입력 입니다.");
		}
	}

	// Update Lecture (By projetID) : projectID로 강의 변경
	// 방법1 : 갱신과 조회 한번에 해보기
	public void updateLecture(String projectID, Lecture lecture) {
		if (projectID != null && lecture != null) {
			boolean result = service.updateLecture(projectID, lecture);
			if (result) {
				try {
					EndView.projectView(service.getProject(projectID));
				} catch (ProjectNotFoundException e) {
					e.printStackTrace();
					EndFailView.failView(e.getMessage());
				}
			} else {
				EndFailView.failView("저장하고자 하는 데이터가 없습니다.");
			}
		} else {
			EndFailView.failView("잘못된 입력 입니다.");
		}
	}

	// Update Professor (By projetID) : projectID로 교수 변경
	// 방법1 : 갱신과 조회 한번에 해보기
	public void updateProfessor(String projectID, Professor professor) {
		if (projectID != null && professor != null) {
			boolean result = service.updateProfessor(projectID, professor);
			if (result) {
				try {
					EndView.projectView(service.getProject(projectID));
				} catch (ProjectNotFoundException e) {
					e.printStackTrace();
					EndFailView.failView(e.getMessage());
				}
			} else {
				EndFailView.failView("저장하고자 하는 데이터가 없습니다.");
			}
		} else {
			EndFailView.failView("잘못된 입력 입니다.");
		}
	}

	// Update Lecture By Sanme : 학생명으로 강의 변경
	// 방법2 : 갱신과 조회 따로
	public void updateLectureBySname(String sname, Lecture lecture) {
		if (sname != null && lecture != null) {
			try {
				service.updateLectureBySname(sname, lecture);
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("잘못된 입력 입니다.");
		}

	}

	// Update Professor By Lanme : 강의명으로 교수 변경
	public void updateProfessorByLname(String lname, Professor professor) {
		if (lname != null && professor != null) {
			try {
				service.updateProfessorByLname(lname, professor);
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("잘못된 입력 입니다.");
		}

	}

	// --- Delete ---------------------------------------------------------------

	// Delete (By projetID) : projectID로 프로젝트 삭제
	public void deleteProject(String projectID) {
		if (projectID != null) {
			boolean result = service.deleteProject(projectID);
			if (result) {
				EndSuccessView.deleteSuccessView(projectID);
			} else {
				EndFailView.failView("삭제하고자 하는 데이터가 없습니다.");
			}
		} else {
			EndFailView.failView("잘못된 입력 입니다.");
		}
	}

	// Delete By Sname : 학생명으로 프로젝트 삭제
	public void deleteProjectBySname(String sname) {
		if (sname != null) {
			boolean result = service.deleteProjectBySname(sname);
			if (result) {
				EndSuccessView.deleteSuccessViewBySname(sname);
			} else {
				EndFailView.failView("삭제하고자 하는 데이터가 없습니다.");
			}
		} else {
			EndFailView.failView("잘못된 입력 입니다.");
		}
	}

	// Delete By Lname : 강의명으로 프로젝트 삭제
	public void deleteProjectByLname(String lname) {
		if (lname != null) {
			boolean result = service.deleteProjectByLname(lname);
			if (result) {
				EndSuccessView.deleteSuccessViewByLname(lname);
			} else {
				EndFailView.failView("삭제하고자 하는 데이터가 없습니다.");
			}
		} else {
			EndFailView.failView("잘못된 입력 입니다.");
		}

	}

	// Delete By Pname : 강의명으로 프로젝트 삭제
	// 방법1 : 갱신과 조회 한번에 해보기
	public void deleteProjectByPname(String pname) {
		if (pname != null) {
			boolean result = service.deleteProjectByPname(pname);
			if (result) {
				EndSuccessView.deleteSuccessViewByPname(pname);
			} else {
				EndFailView.failView("삭제하고자 하는 데이터가 없습니다.");
			}
		} else {
			EndFailView.failView("잘못된 입력 입니다.");
		}

	}

}
