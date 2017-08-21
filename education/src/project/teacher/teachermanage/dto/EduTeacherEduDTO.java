package project.teacher.teachermanage.dto;

import java.util.List;

import project.teacher.teachermanage.pojo.EduTeacherEducation;

public class EduTeacherEduDTO { 

	private Integer teacherId;
	
	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	private List<EduTeacherEducation> eduInfoList;

	public List<EduTeacherEducation> getEduInfoList() {
		return eduInfoList;
	}

	public void setEduInfoList(List<EduTeacherEducation> eduInfoList) {
		this.eduInfoList = eduInfoList;
	}
}