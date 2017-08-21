package project.teacher.teacherProject.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

import project.common.Common;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduProjectComment;
import project.edupm.projectmanage.pojo.EduTeacherForReport;
import project.organization.pojo.Organization;
import project.person.pojo.EduUser;
import project.system.pojo.EduCreditLend;
import project.teacher.teacherProject.dao.ITeacherProjectReadDaoIF;
import project.teacher.teacherProject.dao.ITeacherProjectWriteDaoIF;
import project.teacher.teacherProject.pojo.EduAudit;
import project.teacher.teacherProject.pojo.EduProjectActivityPojo;
import project.teacher.teacherProject.pojo.EduProjectPojo;
import project.teacher.teacherProject.pojo.EduProjectTeacherJoin;
import project.teacher.teacherProject.pojo.EduProjectTrainTargetActitity;
import project.teacher.teacherProject.pojo.EduTeacherOldSchool;
import project.teacher.teacherProject.service.ITeacherProjectServiceIF;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherJob;
import project.teacher.teachermanage.pojo.EduTeacherMobilize;

public class TeacherProjectServiceImpl implements ITeacherProjectServiceIF{
	@Autowired
	@Qualifier("teacherProjectReadDao")
	ITeacherProjectReadDaoIF teacherProjectReadDao;
@Autowired
@Qualifier("teacherProjectWriteDao")
ITeacherProjectWriteDaoIF teacherProjectWriteDao;
	/**
	 * 教师资料信息
	 * add by yinxiaolong
	 */
	@Override
	public EduUser selectTeacherBasicInfo(
			Map<String, Object> paramMap) throws Exception {
		return teacherProjectReadDao.selectTeacherBasicInfoByLoginAccount(paramMap);
	}
	/**
	 * 教师基本信息
	 * add by yinxiaolong
	 */
	@Override
	public EduTeacherBasicInfo selectTeacherBasicInfoByTeacherId(
			Map<String, Object> paramMap) throws Exception {
		return teacherProjectReadDao.selectTeacherBasicInfoByTeacherId(paramMap);
	}
	
	@Override
	public EduTeacherBasicInfo selectTeacherBasicInfoByTeacherIdAndVersion(Integer teacherId, Integer version
			) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("teacherId", teacherId);
		paramMap.put("version", version);
		return teacherProjectReadDao.selectTeacherBasicInfoByTeacherIdAndVersion(paramMap);
	}
	
	@Override
	public List<EduTeacherEducation> selectTeacherEducationByTeacherIdAndVersion(Integer teacherId, Integer version) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("teacherId", teacherId);
		paramMap.put("version", version);
		return teacherProjectReadDao.selectTeacherEducationByTeacherIdAndVersion(paramMap);
	}
	
	@Override
	public EduTeacherJob selectTeacherJobInfoByTeacherIdAndVersion(
			Integer teacherId, Integer version) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("teacherId", teacherId);
		paramMap.put("version", version);
		return teacherProjectReadDao.selectTeacherJobInfoByTeacherIdAndVersion(paramMap);
	}
	
	@Override
	public List<EduTeacherEducation> selectTeacherEducationByTeacherId(
			Map<String, Object> paramMap) throws Exception {
		return teacherProjectReadDao.selectTeacherEducationByTeacherId(paramMap);
	}
	@Override
	public EduTeacherJob selectTeacherJobInfoByTeacherId(
			Map<String, Object> paramMap) throws Exception {
		return teacherProjectReadDao.selectTeacherJobInfoByTeacherId(paramMap);
	}
	@Override
	public List<EduTeacherOldSchool> selectTeacherOldSchoolInfoByTeacherId(
			Map<String, Object> paramMap) throws Exception {
		return teacherProjectReadDao.selectTeacherOldSchoolInfoByTeacherId(paramMap);
	}
	@Override
	public List<EduAudit> selectTeacherAuditInfoByTeacherId(
			Map<String, Object> paramMap) throws Exception {
		return teacherProjectReadDao.selectTeacherAuditInfoByTeacherId(paramMap);
	}
	@Override
	public List<EduProjectPojo> selectTeacherProjectListByTeacherId(
			Integer teacherId) throws Exception {
		return teacherProjectReadDao.selectTeacherProjectListByTeacherId(teacherId);
	}
	
	@Override
	public List<EduTeacherMobilize> selectJobtransferHistoryByTeacherId(
			Integer teacherId) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("teacherId", teacherId);
		return teacherProjectReadDao.selectJobtransferHistoryByTeacherId(paramMap);
	}
	
	@Override
	public EduProjectPojo selectTeacherProjectByProjectId(Integer teacherId,Integer projectId)
			throws Exception {
		return teacherProjectReadDao.selectTeacherProjectInfoByProjectId(teacherId,projectId);
	}
	@Override
	public List<EduProjectPojo> selectTeacherProjectTariInfoByProjectId(
			Integer teacherId, Integer projectId) throws Exception {
		return teacherProjectReadDao.selectTeacherProjectTainInfoByTeacherId(teacherId, projectId);
	}
	@Override
	public PageObject projectList(Map<String, Object> conditions,int startIndex,int pageSize) throws Exception{
		PageObject po = new PageObject();
		int count = teacherProjectReadDao.selectCountByConditions(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProjectTrainTargetActitity> proList = teacherProjectReadDao.selectProjectList(conditions);
		//判断教师是否达到报名条件
		EduTeacherJob eduTeacherJob = teacherProjectReadDao.selectTeacherAddProjectTerm(conditions);
		if(eduTeacherJob!=null){
			List<EduTeacherEducation> teacherEduList = teacherProjectReadDao.selectTeacherAddPrijectEducationByTeacherId(conditions);
			for(int i=0;i<proList.size();i++){
				boolean okOrNo = containsSubjectOkOrOn(eduTeacherJob,teacherEduList,proList,i);
				boolean contaions = containsLocalOkOrOn(eduTeacherJob, proList, i);
				EduProjectTrainTargetActitity projects = proList.get(i);
				if(contaions){
					projects.setContins("contin");
				}else{
					projects.setContins("noContin");
				}
			}
		}
		po.setObjects(proList);
		return po;
	}
	
	@Override
	public PageObject teacherMyProject(Map<String, Object> conditions,int startIndex,int pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageObject po = new PageObject();
		int count = teacherProjectReadDao.selectCountMyProject(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProjectTrainTargetActitity> proList = teacherProjectReadDao.teacherMyProject(conditions);
		//判断教师是否达到报名条件
		EduTeacherJob eduTeacherJob = teacherProjectReadDao.selectTeacherAddProjectTerm(conditions);
		if(eduTeacherJob!=null){
			List<EduTeacherEducation> teacherEduList = teacherProjectReadDao.selectTeacherAddPrijectEducationByTeacherId(conditions);
			for(int i=0;i<proList.size();i++){
				boolean okOrNo = containsSubjectOkOrOn(eduTeacherJob,teacherEduList,proList,i);
				boolean contaions = containsLocalOkOrOn(eduTeacherJob, proList, i);
				EduProjectTrainTargetActitity projects = proList.get(i);
				if(contaions){
					projects.setContins("contin");
				}else{
					projects.setContins("noContin");
				}
			}
		}
		po.setObjects(proList);
		return po;
	}
	@Override
	public PageObject teacherOtherProject(Map<String, Object> conditions,int startIndex,int pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageObject po = new PageObject();
		int count = teacherProjectReadDao.selectCountTeacherOtherProject(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProjectTrainTargetActitity> proList = teacherProjectReadDao.teacherOtherProject(conditions);
		//判断教师是否达到报名条件
		EduTeacherJob eduTeacherJob = teacherProjectReadDao.selectTeacherAddProjectTerm(conditions);
		if(eduTeacherJob!=null){
			List<EduTeacherEducation> teacherEduList = teacherProjectReadDao.selectTeacherAddPrijectEducationByTeacherId(conditions);
			for(int i=0;i<proList.size();i++){
				boolean okOrNo = containsSubjectOkOrOn(eduTeacherJob,teacherEduList,proList,i);
				boolean contaions = containsLocalOkOrOn(eduTeacherJob, proList, i);
				EduProjectTrainTargetActitity projects = proList.get(i);
				if(contaions){
					projects.setContins("contin");
				}else{
					projects.setContins("noContin");
				}
			}
		}
		po.setObjects(proList);
		return po;
	}
	@Override
	public PageObject teacherAddProjectGuoPei(Map<String, Object> conditions,int startIndex,int pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageObject po = new PageObject();
		int count = teacherProjectReadDao.selectCountTeacherAddProjectGuoPei(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProjectTrainTargetActitity> proList = teacherProjectReadDao.teacherAddProjectGuoPei(conditions);
		//判断教师是否达到报名条件
		EduTeacherJob eduTeacherJob = teacherProjectReadDao.selectTeacherAddProjectTerm(conditions);
		if(eduTeacherJob!=null){
			List<EduTeacherEducation> teacherEduList = teacherProjectReadDao.selectTeacherAddPrijectEducationByTeacherId(conditions);
			for(int i=0;i<proList.size();i++){
				boolean okOrNo = containsSubjectOkOrOn(eduTeacherJob,teacherEduList,proList,i);
				boolean contaions = containsLocalOkOrOn(eduTeacherJob, proList, i);
				EduProjectTrainTargetActitity projects = proList.get(i);
				if(contaions){
					projects.setContins("contin");
				}else{
					projects.setContins("noContin");
				}
			}
		}
		po.setObjects(proList);
		return po;
	}
	
	@Override
	public PageObject teacherProjectXiaoBen(Map<String, Object> conditions,int startIndex,int pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageObject po = new PageObject();
		int count = teacherProjectReadDao.teacherProjectXiaoBenCount(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProjectTrainTargetActitity> proList = teacherProjectReadDao.teacherProjectXiaoBen(conditions);
		//判断教师是否达到报名条件
		EduTeacherJob eduTeacherJob = teacherProjectReadDao.selectTeacherAddProjectTerm(conditions);
		if(eduTeacherJob!=null){
			List<EduTeacherEducation> teacherEduList = teacherProjectReadDao.selectTeacherAddPrijectEducationByTeacherId(conditions);
			for(int i=0;i<proList.size();i++){
				boolean okOrNo = containsSubjectOkOrOn(eduTeacherJob,teacherEduList,proList,i);
				boolean contaions = containsLocalOkOrOn(eduTeacherJob, proList, i);
				EduProjectTrainTargetActitity projects = proList.get(i);
				if(contaions){
					projects.setContins("contin");
				}else{
					projects.setContins("noContin");
				}
			}
		}
		po.setObjects(proList);
		return po;
	}
	/**
	 * 判断教师报名是否符合报名条件
	 */
	private boolean containsLocalOkOrOn(EduTeacherJob eduTeacherJob,
			List<EduProjectTrainTargetActitity> proList,int i){
		boolean flag = false;
		Integer userProvinceId = eduTeacherJob.getUserProvinceId();
		Integer userCityId = eduTeacherJob.getUserCityId();
		Integer userDistrictId = eduTeacherJob.getUserDistrictId();
		EduProjectTrainTargetActitity projects = proList.get(i);
		Integer trainScopeId = projects.getTrainScopeId();
		if(trainScopeId.equals(userProvinceId)){
			return true;
		}
		if(trainScopeId.equals(userCityId)){
			return true;
		}
		if(trainScopeId.equals(userDistrictId)){
			return true;
		}
		return flag;
	}
	
	/**
	 * 判断教师报名是否符合报名条件
	 */
	private boolean containsSubjectOkOrOn(EduTeacherJob eduTeacherJob,List<EduTeacherEducation> teacherEduList,
			List<EduProjectTrainTargetActitity> proList,int i){
		boolean flag = true;
		//学科，可能有多个
		String jobSubiects = eduTeacherJob.getJobFormerTeachingSubject();
		if(jobSubiects!=null){
			String[] jobSubiect = jobSubiects.split(",");
		
		//学段
//		String jobSections = eduTeacherJob.getJobFormerTeachingSection();
//		String[] jobSection = jobSections.split(",");
			EduProjectTrainTargetActitity projects = proList.get(i);
			String project = projects.getSubjectName();
			String[] subjects = project.split(",");
			String[] xueke = jobSubiects.split(",");
//			//TODO: 性别从会话取
//			String sex = project.getSex();
//			Integer integer=Integer.valueOf(sex);
//			Integer gender = eduTeacherJob.getGender();
//			boolean flag1 = integer.equals(gender);
//			if(!flag1){
//				return false;
//			}
//			
//			//职务equals(eduTeacherJob.getJobRecruitmentPosition())
//			
//			if(!project.getPositionName().equals(eduTeacherJob.getJobSchoolAdministrationOffice())){
//				return false;
//			}
//			//职称job_recruitment_position  job_recruitment_position
//			if(!project.getProfessionalTitleName().equals(eduTeacherJob.getJobRecruitmentPosition())){
//				return false;
//			}
//			String isClassTeacher = project.getIsClassCharger();
//			Integer isClassChanger=eduTeacherJob.getJobWhetherTeacher();
//			Integer integerIsgender=Integer.valueOf(isClassTeacher);
//			boolean flagIsGender = isClassChanger.equals(integerIsgender);
//			if(!flagIsGender){
//				return false;
//			}
			//学科
			if(!containsSubject(xueke, subjects)){
				projects.setXueke("学科不符合培训要求");
				return false;
			}
//			//学段
//			if(!containsSubject( project.getStdutySection(), jobSection)){
//				project.setXueduan("学段不符合培训要求");
//				return false;
//			}
//			//学历BUG
//			for(EduTeacherEducation edu : teacherEduList){
//				String educationExperience = edu.getEducationExperience();
//				if(!project.getEducationBackgroundName().equals(educationExperience)){
//					flag =  false;
//				}else{
//					flag =  true;
//				}
//			}
			projects.setTeacherOkOrNo("Ok");
		}
		return flag;
	}
	
	/**
	 * 判断所给学科是否在数组中
	 * @param subject 学科
	 * @param subjects 学科数组
	 * @return
	 */
	private boolean containsSubject(String[] xueke,String[] subjects){
		for(String str:subjects){
			for(String strs:xueke){
				if(str.trim().equals(strs.trim())){
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public EduProjectComment selectTeacherStatusByTeacherId(Integer projectId,Integer teacherId)
			throws Exception {
		return teacherProjectReadDao.selectTeacherStatusByTeacherId(projectId,teacherId);
	}
	@Override
	public boolean insertCommentTeacherInfo(Integer organizationId, String projectId, Integer teacherId,int jobVersion,String loginAccount,int status,String type)
			throws Exception {
		boolean flag = false;
		
		if(teacherProjectWriteDao.countTeacherSignInfo(projectId, teacherId, jobVersion, loginAccount, status, type)>0){
			flag = teacherProjectWriteDao.updateTeacherSignInfo(projectId, teacherId, jobVersion, loginAccount, status, type)>0?true:false;
		}else{
			flag = teacherProjectWriteDao.insertCommentTeacherInfo(organizationId, projectId, teacherId,jobVersion,loginAccount,status,type);
		}
		return flag;
	}
	@Override
	public boolean insertCommentTeacherInfo2(String projectId, Integer teacherId,int jobVersion,String loginAccount,int status,String type)
			throws Exception {
		return teacherProjectWriteDao.insertCommentTeacherInfo2(projectId, teacherId,jobVersion,loginAccount,status,type);
	}
	@Override
	public PageObject selectTeacherOverProjectListByTeacherId(
			Map<String, Object> paramMap, int startIndex,int pageSize)
			throws Exception {
		PageObject po = new PageObject();
		int count = teacherProjectReadDao.selectOverProCountByParamMap(paramMap);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<EduProjectActivityPojo> proList = teacherProjectReadDao.selectTeacherOverProjectListByTeacherId(paramMap);
		po.setObjects(proList);
		return po;
	}
	@Override
	public boolean insertTeacherCommentScore(Map<String, Object> paramMap)
			throws Exception {
		return teacherProjectWriteDao.insertTeacherComment(paramMap);
	}
	@Override
	public List<Organization> selectProjectOrganizationList(
			Map<String, Object> paramMap) throws Exception {
		return teacherProjectReadDao.selectProjectOrganizationList(paramMap);
	}
	@Override
	public boolean insertTeacherOrganizationId(Map<String, Object> paramMap)
			throws Exception {
		return teacherProjectWriteDao.insertTeacherOrganizationId(paramMap);
	}
	@Override
	public EduProjectTrainTargetActitity selectProMustAudit(
			Map<String, Object> paramMap) throws Exception {
		return teacherProjectReadDao.selectProMustAudit(paramMap);
	}
	@Override
	public List<EduProjectTeacherJoin> selectProjectTeacherJoinFinish(
			String projectName, String year, Integer teacherId) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("teacherId", teacherId);
		param.put("projectName", projectName);
		param.put("year", year);
		param.put("projectStatus", Common.PROJECT_COMMON_STATUS.get("已结束"));
		return teacherProjectReadDao.selectProjectTeacherJoinByParam(param);
	}
	
	@Override
	public PageObject selectProjectTeacherJoinFinishByPage(
			String projectName, String start,String end, Integer teacherId, int startIndex,int pageSize) {
		PageObject po = new PageObject();
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("teacherId", teacherId);
		param.put("projectName", projectName);
		param.put("beginYear", start == null || start == "" ? null : start);
		param.put("endYear", end == null || end == "" ? null : end);
		param.put("projectStatus", Common.PROJECT_COMMON_STATUS.get("已结束"));
		
		//冗余查询
//		int count = teacherProjectReadDao.selectProjectTeacherJoinByParam(param).size();
		List<EduProjectTeacherJoin> proList = teacherProjectReadDao.selectProjectTeacherJoinByParam(param);
		
		po.setCount(proList.size());
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		param.put("startIndex", po.getStartIndex());
		param.put("endIndex", pageSize);
		po.setObjects(proList);
		
		return po;
	}
	
	@Override
	public List<EduTeacherForReport> queryTeacherByIds(List<Integer> tids) throws Exception{
		return teacherProjectReadDao.selectTeacherByIds(tids);
	}
	@Override
	public PageObject teacherProjectCommonAll(Map<String, Object> conditions,String flag, int startIndex, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageObject po = new PageObject();
		int count = teacherProjectReadDao.selectCountTeacherProjectCommon(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProjectTrainTargetActitity> proList = teacherProjectReadDao.teacherProjectCommon(conditions);
		//判断教师是否达到报名条件
		EduTeacherJob eduTeacherJob = teacherProjectReadDao.selectTeacherAddProjectTerm(conditions);
		if(eduTeacherJob!=null){
			List<EduTeacherEducation> teacherEduList = teacherProjectReadDao.selectTeacherAddPrijectEducationByTeacherId(conditions);
			for(int i=0;i<proList.size();i++){
				boolean okOrNo = containsSubjectOkOrOn(eduTeacherJob,teacherEduList,proList,i);
				boolean contaions = containsLocalOkOrOn(eduTeacherJob, proList, i);
				EduProjectTrainTargetActitity projects = proList.get(i);
				if(contaions){
					projects.setContins("contin");
				}else{
					projects.setContins("noContin");
				}
			}
		}
		po.setObjects(proList);
		return po;
	}

	@Override
	public PageObject queryTeacherLendCredit(Map<String, Object> conditions) {
		PageObject po = new PageObject();
		List<EduProjectTrainTargetActitity> proList = teacherProjectReadDao.queryTeacherLendCredit(conditions);
		po.setObjects(proList);
		return po;
	}
	@Override
	public boolean insertLendCredit(Map<String, Object> conditions) {
		return teacherProjectWriteDao.insertLendCredit(conditions);
	}
	@Override
	public boolean updateLendCredit(Map<String, Object> conditions) {
		return teacherProjectWriteDao.updateLendCredit(conditions);
	}
	@Override
	public PageObject queryTeacherScore(Map<String, Object> conditions) {
		PageObject po = new PageObject();
		List<EduProject> proList = teacherProjectReadDao.queryTeacherScore(conditions);
		po.setObjects(proList);
		return po;
	}
	@Override
	public int queryTeacherCredit(Map<String, Object> conditions) {
		return teacherProjectReadDao.queryTeacherCredit(conditions);
	}
	@Override
	public boolean repayLendCredit(Map<String, Object> conditions) {
		return teacherProjectWriteDao.repayLendCredit(conditions);
	}
	@Override
	public int queryTeacherPeriod(Map<String, Object> conditions) {
		return teacherProjectReadDao.queryTeacherPeriod(conditions);
	}
	@Override
	public Float queryTeacherTotalCreditByYear(Map<String, Object> conditions) {
		return teacherProjectReadDao.queryTeacherTotalCreditByYear(conditions);
	}
	@Override
	public Float queryTeacherLendCreditByYear(Map<String, Object> conditions) {
		return teacherProjectReadDao.queryTeacherLendCreditByYear(conditions);
	}
	@Override
	public Float queryTeacherRepayCreditByYear(Map<String, Object> conditions) {
		return teacherProjectReadDao.queryTeacherRepayCreditByYear(conditions);
	}
	@Override
	public Integer queryNeedCreditByYear(Map<String, Object> conditions) {
		return teacherProjectReadDao.queryNeedCreditByYear(conditions);
	}
	@Override
	public Float queryTeacherTotalPeriodByYear(Map<String, Object> conditions) {
		return teacherProjectReadDao.queryTeacherTotalPeriodByYear(conditions);
	}
	@Override
	public PageObject queryAllTeacherLendCreditByArea(
			Map<String, Object> conditions) {
		PageObject po = new PageObject();
		List<EduCreditLend> proList = teacherProjectReadDao.queryAllTeacherLendCreditByArea(conditions);
		po.setObjects(proList);
		return po;
	}
	@Override
	public Float queryTeacherTotalIsCreditByYear(Map<String, Object> conditions) {
		return teacherProjectReadDao.queryTeacherTotalIsCreditByYear(conditions);
	}
	
}
