package view;

import java.util.ArrayList;

import model.dto.LectureRegistraionProject;

public class EndView {

	public static void projectViewAll(ArrayList<LectureRegistraionProject> projectAll) {

		if (projectAll != null) {
			int projectSize = projectAll.size();

			for (int index = 0; index < projectSize; index++) {
				if (projectAll.get(index) != null) {
					System.out.println("[조회된 수강정보 (" + (index + 1) + "/"+ projectSize +")] \n" + projectAll.get(index));
				}
			}
		} else {
			System.out.println("현재 진행중인 project가 없습니다.");
		}

	}

	public static void projectListView(ArrayList<LectureRegistraionProject> projectAll) {

		if (projectAll != null) {
			int projectSize = projectAll.size();

			for (int index = 0; index < projectSize; index++) {
				if (projectAll.get(index) != null) {
					System.out.println("[조회된 수강정보 (" + (index + 1) + "/"+ projectSize +")] \n" + projectAll.get(index));
				}
			}
		} else {
			System.out.println("조건에 맞는 project가 없습니다.");
		}

	}

	public static void projectView(Object project) {

		if (project != null) {
			System.out.println("[조회된 단일 수강정보] \n" + project);
		}

		else {
			System.out.println("해당 project는 없습니다.");
		}
	}

}
