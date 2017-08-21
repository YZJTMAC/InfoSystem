package project.edupm.projectmanage.service;

import java.util.List;
import java.util.Map;

import framelib.utils.page.PageObject;

import project.edupm.projectmanage.pojo.EduOrgSummary;
import project.edupm.projectmanage.pojo.EduProjectSummary;
import project.teacher.teacherProject.pojo.TeacherSummary;


public interface ISummaryService {
	
	public Integer saveSummary(EduProjectSummary eps);
	
	public Integer updateSummary(EduProjectSummary eps);
	
	public EduProjectSummary getSummaryById(Integer id);

	public Integer writeSummary(EduProjectSummary eps);
	
	public EduProjectSummary getSummaryByParam(EduProjectSummary eps);
	
	public Integer  selectOrgSummaryCountByParam(Map<String, Object> paramMap);
	
	public List<EduOrgSummary> selectOrgSummaryByParam(Map<String, Object> paramMap);
	
	public PageObject selectOrgSummayByPage(Map<String, Object> paramMap,int startPage, int pageSize) throws Exception;

	public Integer  selectTeacherSummaryCountByParam(Map<String, Object> paramMap);
	public List<TeacherSummary> selectTeacherSummaryByParam(Map<String, Object> paramMap);
	public PageObject selectTeacherSummayByPage(Map<String, Object> paramMap,int startPage, int pageSize) throws Exception;
	
}
