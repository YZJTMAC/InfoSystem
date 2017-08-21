package project.edupm.projectmanage.dao;

import java.util.List;
import java.util.Map;

import framelib.utils.page.PageObject;

import project.edupm.projectmanage.pojo.EduOrgSummary;
import project.edupm.projectmanage.pojo.EduProjectSummary;
import project.teacher.teacherProject.pojo.TeacherSummary;

public interface ISummaryReadDAO {
	/**
	 * 根据参数查询总结
	 * @param param
	 * @return
	 */
	public List<EduProjectSummary> selectSummaryByParam(EduProjectSummary eps);
	
	
	/**
	 * 根据参数查询总结
	 * @param param
	 * @return
	 */
	public List<EduOrgSummary> selectOrgSummaryByParam(Map<String, Object> paramMap);
	
	
	/**
	 * 根据Id查询总结
	 * @param id
	 * @return
	 */
	public EduProjectSummary selectSummaryById(Integer id);
	
	
	
	public List<TeacherSummary> selectTeacherSummaryByParam(Map<String, Object> paramMap);
	
}
