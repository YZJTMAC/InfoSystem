package project.teacher.teacherProject.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduProjectComment;
import project.edupm.projectmanage.pojo.EduTeacherForReport;
import project.organization.pojo.Organization;
import project.person.pojo.EduUser;
import project.system.pojo.EduCreditLend;
import project.teacher.teacherProject.dao.ITeacherProjectReadDaoIF;
import project.teacher.teacherProject.pojo.EduAudit;
import project.teacher.teacherProject.pojo.EduProjectActivityPojo;
import project.teacher.teacherProject.pojo.EduProjectPojo;
import project.teacher.teacherProject.pojo.EduProjectTeacherJoin;
import project.teacher.teacherProject.pojo.EduProjectTrainTargetActitity;
import project.teacher.teacherProject.pojo.EduTeacherOldSchool;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherJob;
import project.teacher.teachermanage.pojo.EduTeacherMobilize;
import framelib.dao.BaseDAOImpl;
import framelib.utils.page.PageObject;

public class TeacherProjectReadDaoImpl extends BaseDAOImpl implements ITeacherProjectReadDaoIF{

	@Override
	public EduUser selectTeacherBasicInfoByLoginAccount(
			Map<String, Object> paramMap) {
		return (EduUser) this.getSqlMapClientTemplate().queryForObject("selectTeacherInfoByLoginAccount", paramMap);
	}

	@Override
	public EduTeacherBasicInfo selectTeacherBasicInfoByTeacherId(
			Map<String, Object> paramMap) {
		return (EduTeacherBasicInfo) this.getSqlMapClientTemplate().queryForObject("selectTeacherBasicInfoByTeacherId", paramMap);
	}
	
	@Override
	public EduTeacherBasicInfo selectTeacherBasicInfoByTeacherIdAndVersion(
			Map<String, Object> paramMap) {
		return (EduTeacherBasicInfo) this.getSqlMapClientTemplate().queryForObject("selectTeacherBasicInfoByTeacherIdAndVersion", paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EduTeacherEducation> selectTeacherEducationByTeacherId(
			Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList(
				"selectTeacherEducationByTeacherId", paramMap);
	}
	
	@Override
	public List<EduTeacherEducation> selectTeacherEducationByTeacherIdAndVersion(
			Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList(
				"selectTeacherEducationByTeacherIdAndVersion", paramMap);
	}
	
	@Override
	public List<EduTeacherMobilize> selectJobtransferHistoryByTeacherId(
			Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList(
				"selectJobTranHistoryById", paramMap);
	}

	@Override
	public List<EduTeacherEducation> selectTeacherEducationByTeacherId(
			Integer Id, Integer status) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("teacherId", Id);
		paramMap.put("status", status);
		return selectTeacherEducationByTeacherId(paramMap);
	}

	@Override
	public EduTeacherJob selectTeacherJobInfoByTeacherIdAndVersion(
			Map<String, Object> paramMap) {
		return (EduTeacherJob) this.getSqlMapClientTemplate().queryForObject("selectTeacherJobInfoByTeacherIdAndVersion", paramMap);
	}
	
	@Override
	public EduTeacherJob selectTeacherJobInfoByTeacherId(
			Map<String, Object> paramMap) {
		return (EduTeacherJob) this.getSqlMapClientTemplate().queryForObject("selectTeacherJobInfoByTeacherId", paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EduTeacherOldSchool> selectTeacherOldSchoolInfoByTeacherId(
			Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherOldSchoolInfoByTeacherId", paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EduAudit> selectTeacherAuditInfoByTeacherId(
			Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherAuditInfoByTeacherId", paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EduProjectPojo> selectTeacherProjectListByTeacherId(
			Integer teacherId) {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherProjectListByTeacherId", teacherId);
	}

	@Override
	public EduProjectPojo selectTeacherProjectInfoByProjectId(Integer teacherId,Integer projectId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("teacherId", teacherId);
		paramMap.put("projectId", projectId);
		return (EduProjectPojo) this.getSqlMapClientTemplate().queryForObject("selectTeacherProjectInfoByTeacherId",paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EduProjectPojo> selectTeacherProjectTainInfoByTeacherId(
			Integer teacherId, Integer projectId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("teacherId", teacherId);
		paramMap.put("projectId", projectId);
		return this.getSqlMapClientTemplate().queryForList("selectTeacherProjectTainInfoByTeacherId", paramMap);
	}
	@Override
	public int selectCountByConditions(Map<String, Object> conditions)
			throws Exception {
			return (Integer)this.getSqlMapClientTemplate().queryForObject("selectTeacherAddProjectCountByConditions",conditions);
	}
	
	@Override
	public int selectCountMyProject(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectCountMyProject",conditions);
	}

	@Override
	public int selectCountTeacherOtherProject(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectCountTeacherOtherProject",conditions);
	}

	@Override
	public int selectCountTeacherAddProjectGuoPei(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectCountTeacherAddProjectGuoPei",conditions);
	}
	
	@Override
	public int teacherProjectXiaoBenCount(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return (Integer)this.getSqlMapClientTemplate().queryForObject("teacherProjectXiaoBenCount",conditions);
	}
	
	@Override
	public List<EduProjectTrainTargetActitity> teacherProjectXiaoBen(
			Map<String, Object> conditions) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("teacherProjectXiaoBen",conditions);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EduProjectTrainTargetActitity> selectProjectList(Map<String, Object> conditions)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherAddProjectListByConditions",conditions);
	}
	
	@Override
	public List<EduProjectTrainTargetActitity> teacherMyProject(
			Map<String, Object> conditions) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("teacherMyProject",conditions);
	}

	@Override
	public List<EduProjectTrainTargetActitity> teacherOtherProject(
			Map<String, Object> conditions) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("teacherOtherProject",conditions);
	}

	@Override
	public List<EduProjectTrainTargetActitity> teacherAddProjectGuoPei(
			Map<String, Object> conditions) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("teacherAddProjectGuoPei",conditions);
	}

	@Override
	public EduTeacherJob selectTeacherAddProjectTerm(Map<String,Object> conditions) {
		return (EduTeacherJob) this.getSqlMapClientTemplate().queryForObject("selectTeacherAddProjectTermByTeacherId",conditions);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EduTeacherEducation> selectTeacherAddPrijectEducationByTeacherId(
			Map<String, Object> conditions) {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherAddProjectEducationyTeacherId",conditions);
	}

	@Override
	public int selectTeacherIdByIdNumber(String idNumber) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectTeacherIdByIdNumber", idNumber);
	}
	

	@Override
	public EduProjectComment selectTeacherStatusByTeacherId(Integer projectId,Integer teacherId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("teacherId", teacherId);
		paramMap.put("projectId", projectId);
		return (EduProjectComment) this.getSqlMapClientTemplate().queryForObject("selectTeacherSatusByTeacherId",paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EduProjectActivityPojo> selectTeacherOverProjectListByTeacherId(
			Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherOverProcjectList",paramMap);
	}

	@Override
	public int selectOverProCountByParamMap(Map<String, Object> paramMap)
			throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectOverProCountByParamMap",paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> selectProjectOrganizationList(
			Map<String, Object> ParamMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectOrganizationName",ParamMap);
	}

	@Override
	public EduProjectTrainTargetActitity selectProMustAudit(Map<String, Object> paramMap) {
		return (EduProjectTrainTargetActitity) this.getSqlMapClientTemplate().queryForObject("selectProMustAudit",paramMap);
	}

	@Override
	public List<EduProjectTeacherJoin> selectProjectTeacherJoinByParam(HashMap<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectProjectTeacherJoinByParam",param);
	}
	
	@Override
	public List<EduTeacherForReport> selectTeacherByIds(List<Integer> tids) throws Exception{
		return super.getSqlMapClientTemplate().queryForList("selectTeahcerInfoByIds", tids);
	}

	@Override
	public int selectCountTeacherProjectCommon(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectCountTeacherProjectCommon",conditions);
	}

	@Override
	public List<EduProjectTrainTargetActitity> teacherProjectCommon(
			Map<String, Object> conditions) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("selectTeacherProjectCommon",conditions);
	}

	@Override
	public int queryTeacherLendCreditCount(Map<String, Object> conditions) {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlMapClientTemplate().queryForObject("query_teacher_lend_credit_count",conditions);
	}

	@Override
	public List<EduProjectTrainTargetActitity> queryTeacherLendCredit(
			Map<String, Object> conditions) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("query_teacher_lend_credit",conditions);
	}

	@Override
	public int queryTeacherScoreCount(Map<String, Object> conditions) {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlMapClientTemplate().queryForObject("query_teacher_score_count",conditions);
	}

	@Override
	public List<EduProject> queryTeacherScore(Map<String, Object> conditions) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("query_teacher_score",conditions);
	}

	@Override
	public int queryTeacherCredit(Map<String, Object> conditions) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("query_teacher_credit", conditions);
	}

	@Override
	public int queryTeacherPeriod(Map<String, Object> conditions) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("query_teacher_period", conditions);
	}

	@Override
	public Float queryTeacherTotalCreditByYear(Map<String, Object> conditions) {
		return (Float)this.getSqlMapClientTemplate().queryForObject("query_teacher_total_credit_by_year", conditions);
	}

	@Override
	public Float queryTeacherLendCreditByYear(Map<String, Object> conditions) {
		return (Float)this.getSqlMapClientTemplate().queryForObject("query_teacher_lend_credit_by_year", conditions);
	}

	@Override
	public Float queryTeacherRepayCreditByYear(Map<String, Object> conditions) {
		return (Float)this.getSqlMapClientTemplate().queryForObject("query_teacher_repay_credit_by_year", conditions);
	}

	@Override
	public Integer queryNeedCreditByYear(Map<String, Object> conditions) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("query_teacher_need_credit_by_year", conditions);
	}

	@Override
	public Float queryTeacherTotalPeriodByYear(Map<String, Object> conditions) {
		return (Float)this.getSqlMapClientTemplate().queryForObject("query_teacher_total_period_by_year", conditions);
	}

	@Override
	public List<EduCreditLend> queryAllTeacherLendCreditByArea(Map<String, Object> conditions) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("query_teacher_indept_study_list",conditions);
	}

	@Override
	public Float queryTeacherTotalIsCreditByYear(Map<String, Object> conditions) {
		return (Float)this.getSqlMapClientTemplate().queryForObject("query_teacher_indept_study_credit", conditions);
	}
	
}
