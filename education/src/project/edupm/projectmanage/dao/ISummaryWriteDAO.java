package project.edupm.projectmanage.dao;

import project.edupm.projectmanage.pojo.EduProjectSummary;

public interface ISummaryWriteDAO {
	public Integer insertEduProjectSummary(EduProjectSummary eduProjectSummary);
	public Integer updateEduProjectSummary(EduProjectSummary eduProjectSummary);
}
