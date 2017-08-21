package project.edupm.projectmanage.dao.impl;

import java.util.List;
import java.util.Map;


import framelib.dao.BaseDAOImpl;
import framelib.utils.page.PageObject;

import project.edupm.projectmanage.dao.ISummaryReadDAO;
import project.edupm.projectmanage.pojo.EduOrgSummary;
import project.edupm.projectmanage.pojo.EduProjectSummary;
import project.teacher.teacherProject.pojo.TeacherSummary;
@SuppressWarnings("unchecked")
public class ISummaryReadDAOImpl extends BaseDAOImpl implements ISummaryReadDAO{

	
	@Override
	public List<EduProjectSummary> selectSummaryByParam(EduProjectSummary eps) {
		return this.getSqlMapClientTemplate().queryForList("summay_selectByClause",eps);
	}

	@Override
	public EduProjectSummary selectSummaryById(Integer id) {
		return  (EduProjectSummary)this.getSqlMapClientTemplate().queryForObject("summay_selectByPrimaryKey", id);
	}

	@Override
	public List<EduOrgSummary> selectOrgSummaryByParam(Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList("summary_select_of_organiztion",paramMap);
	}

	@Override
	public List<TeacherSummary> selectTeacherSummaryByParam(
			Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList("summary_select_of_teacher",paramMap);
	}

	
}
