package service;

import java.util.ArrayList;
import java.util.Iterator;

import exception.ProjectIDDuplicationException;
import exception.ProjectNotFoundException;
import model.dto.Lecture;
import model.dto.LectureRegistraionProject;
import model.dto.Professor;
import model.dto.Student;

public class LectureRegistraionProjectService {

	private static LectureRegistraionProjectService instance = new LectureRegistraionProjectService();

	private LectureRegistraionProjectService() {
	}

	public static LectureRegistraionProjectService getInstance() {
		return instance;
	}

	private ArrayList<LectureRegistraionProject> lectureRegistrationProjectList = new ArrayList<LectureRegistraionProject>();

	// --- Insert --------------------------------------------------------------

	// Insert
	public void lectureProjectInsert(LectureRegistraionProject project) throws ProjectIDDuplicationException {

		for (LectureRegistraionProject p : lectureRegistrationProjectList) {
			if (p.getProjectID().equals(project.getProjectID())) {
				throw new ProjectIDDuplicationException("이미 존재하는 Project 입니다.");
			}
		}

		lectureRegistrationProjectList.add(project);

	}

	// --- Get -----------------------------------------------------------------
	
	// Get All
	public ArrayList<LectureRegistraionProject> getProjectAll() {
		return lectureRegistrationProjectList;
	}

	// Get One (By ProjectID)
	public LectureRegistraionProject getProject(String projectID) throws ProjectNotFoundException {

		for (LectureRegistraionProject p : lectureRegistrationProjectList) {
			if (p.getProjectID().equals(projectID)) {
				return p;
			}
		}

		throw new ProjectNotFoundException("해당 projectID는 존재하지 않습니다.");

	}

	// Get By LectureName
	public ArrayList<LectureRegistraionProject> getProjectByLname(String lname) throws ProjectNotFoundException {
		ArrayList<LectureRegistraionProject> lnamelist = new ArrayList<LectureRegistraionProject>();
		for (LectureRegistraionProject p : lectureRegistrationProjectList) {
			if (p.getProjectLecture().getLname().equals(lname)) {
				lnamelist.add(p);
			}
		}
		if (lnamelist.isEmpty()) {
			throw new ProjectNotFoundException("해당 projectID는 존재하지 않습니다.");
		} else {
			return lnamelist;
		}
	}

	// Get By StudentName
	public ArrayList<LectureRegistraionProject> getProjectBySname(String sname) throws ProjectNotFoundException {
		ArrayList<LectureRegistraionProject> snamelist = new ArrayList<LectureRegistraionProject>();
		for (LectureRegistraionProject p : lectureRegistrationProjectList) {
			if (p.getProjectStudent().getSname().equals(sname)) {
				snamelist.add(p);
			}
		}
		if (snamelist.isEmpty()) {
			throw new ProjectNotFoundException("해당 projectID는 존재하지 않습니다.");
		} else {
			return snamelist;
		}
	}

	// Get By ProfessorName
	public ArrayList<LectureRegistraionProject> getProjectByPname(String pname) throws ProjectNotFoundException {
		ArrayList<LectureRegistraionProject> pnamelist = new ArrayList<LectureRegistraionProject>();
		for (LectureRegistraionProject p : lectureRegistrationProjectList) {
			if (p.getProjectProfessor().getPname().equals(pname)) {
				pnamelist.add(p);
			}
		}
		if (pnamelist.isEmpty()) {
			throw new ProjectNotFoundException("해당 projectID는 존재하지 않습니다.");
		} else {
			return pnamelist;
		}
	}

	// --- Update --------------------------------------------------------------

	// Update Student By ProjectID
	public boolean updateStudent(String projectID, Student student) {
		for (LectureRegistraionProject p : lectureRegistrationProjectList) {
			if (p.getProjectID().equals(projectID)) {
				p.setProjectStudent(student);
				return true;
			}
		}
		return false;
	}

	// Update Lecture By ProjectID
	public boolean updateLecture(String projectID, Lecture lecture) {
		for (LectureRegistraionProject p : lectureRegistrationProjectList) {
			if (p.getProjectID().equals(projectID)) {
				p.setProjectLecture(lecture);
				return true;
			}
		}
		return false;
	}

	// Update Professor By ProjectID
	public boolean updateProfessor(String projectID, Professor professor) {
		for (LectureRegistraionProject p : lectureRegistrationProjectList) {
			if (p.getProjectID().equals(projectID)) {
				p.setProjectProfessor(professor);
				return true;
			}
		}
		return false;
	}

	// Update Lecture By StudentName
	public void updateLectureBySname(String sname, Lecture lecture) throws ProjectNotFoundException {
		int i = 0;
		for (LectureRegistraionProject p : lectureRegistrationProjectList) {
			if (p != null && p.getProjectStudent().getSname().equals(sname)) {
				p.setProjectLecture(lecture);
				i++;
			}
		}
		if (i != 0) {
			return;
		} else {
			throw new ProjectNotFoundException("해당 Student Name은 존재하지 않습니다.");
		}
	}

	// Update Professor By LectureName
	public void updateProfessorByLname(String lname, Professor professor) throws ProjectNotFoundException {
		int i = 0;
		for (LectureRegistraionProject p : lectureRegistrationProjectList) {
			if (p != null && p.getProjectLecture().getLname().equals(lname)) {
				p.setProjectProfessor(professor);
				i++;
			}
		}
		if (i != 0) {
			return;
		} else {
			throw new ProjectNotFoundException("해당 projectID는 존재하지 않습니다.");
		}
	}

	// --- Delete --------------------------------------------------------------

	// Delete Project By ProjectID
	// index 사용 (한개만 가능)
	public boolean deleteProject(String projectID) {
		LectureRegistraionProject p;
		int psize = lectureRegistrationProjectList.size();
		for (int i = 0; i < psize; i++) {
			p = lectureRegistrationProjectList.get(i);
			if (p.getProjectID().equals(projectID)) {
				lectureRegistrationProjectList.remove(i);
				return true;
			}
		}
		return false;
	}

	// Delete Project By StudentName
	// Iterator 사용 (중복 가능)
	public boolean deleteProjectBySname(String sname) {
		boolean result = false;
		for (Iterator<LectureRegistraionProject> it = lectureRegistrationProjectList.iterator(); it.hasNext();) {
			LectureRegistraionProject value = it.next();
			if (value.getProjectStudent().getSname().equals(sname)) {
				it.remove();
				result = true;
			}
		}
		return result;
	}

	// Delete Project By LectureName
	// Iterator 사용 (중복 가능)
	public boolean deleteProjectByLname(String lname) {
		boolean result = false;
		for (Iterator<LectureRegistraionProject> it = lectureRegistrationProjectList.iterator(); it.hasNext();) {
			LectureRegistraionProject value = it.next();
			if (value.getProjectLecture().getLname().equals(lname)) {
				it.remove();
				result = true;
			}
		}
		return result;
	}
	
	// Delete Project By ProfessorName
		// Iterator 사용 (중복 가능)
	public boolean deleteProjectByPname(String pname) {
		boolean result = false;
		for (Iterator<LectureRegistraionProject> it = lectureRegistrationProjectList.iterator(); it.hasNext();) {
			LectureRegistraionProject value = it.next();
			if (value.getProjectProfessor().getPname().equals(pname)) {
				it.remove();
				result = true;
			}
		}
		return result;
	}

}
