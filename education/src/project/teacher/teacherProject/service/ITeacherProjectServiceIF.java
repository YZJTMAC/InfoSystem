package project.teacher.teacherProject.service;

import java.util.List;
import java.util.Map;

import framelib.utils.page.PageObject;

import project.edupm.projectmanage.pojo.EduProjectComment;
import project.edupm.projectmanage.pojo.EduTeacherForReport;
import project.organization.pojo.Organization;
import project.person.pojo.EduUser;
import project.teacher.teacherProject.pojo.EduAudit;
import project.teacher.teacherProject.pojo.EduProjectPojo;
import project.teacher.teacherProject.pojo.EduProjectTeacherJoin;
import project.teacher.teacherProject.pojo.EduProjectTrainTargetActitity;
import project.teacher.teacherProject.pojo.EduTeacherOldSchool;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherJob;
import project.teacher.teachermanage.pojo.EduTeacherMobilize;

public interface ITeacherProjectServiceIF {
	/**
	 * 教师资料信息
	 * add by yinxiaolong
	 * @param supplierId
	 * @return
	 * @throws Exception
	 */
	public EduUser selectTeacherBasicInfo(Map<String,Object> paramMap) throws Exception;
	/**
	 * 教师基本信息
	 * add by yinxiaolong
	 * @param supplierId
	 * @return
	 * @throws Exception
	 */
	public EduTeacherBasicInfo selectTeacherBasicInfoByTeacherId(Map<String,Object> paramMap) throws Exception;
	
	/**
	 *教师教育经历
	 * add by yinxiaolong
	 */
	public List<EduTeacherEducation> selectTeacherEducationByTeacherId(Map<String,Object> paramMap) throws Exception;
	/**
	 * 教师工作信息
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduTeacherJob selectTeacherJobInfoByTeacherId(Map<String,Object> paramMap) throws Exception;
	/**
	 * 教师历次学校记录
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTeacherOldSchool> selectTeacherOldSchoolInfoByTeacherId(Map<String,Object> paramMap) throws Exception;
	/**
	 * 教师审核情况
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduAudit> selectTeacherAuditInfoByTeacherId(Map<String,Object> paramMap) throws Exception;
	/**
	 * 教师正在参加的培训项目列表
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduProjectPojo> selectTeacherProjectListByTeacherId(Integer teacherId) throws Exception;
	/**
	 * 教师正在参加的培训项目查看详情
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduProjectPojo selectTeacherProjectByProjectId(Integer teacherId,Integer projectId) throws Exception;
	/**
	 *教师教育经历
	 * add by yinxiaolong
	 */
	public List<EduProjectPojo> selectTeacherProjectTariInfoByProjectId(Integer teacherId,Integer projectId) throws Exception;
	/**
	 * 教师加入培训项目列表
	 * @param conditions
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	//全部项目
	public PageObject projectList(Map<String, Object> conditions,int startPage,int pageSize) throws Exception;
	//我的项目
	public PageObject teacherMyProject(Map<String, Object> conditions,int startPage,int pageSize) throws Exception;
	//国培
	public PageObject teacherOtherProject(Map<String, Object> conditions,int startPage,int pageSize) throws Exception;
	//省培
	public PageObject teacherAddProjectGuoPei(Map<String, Object> conditions,int startPage,int pageSize) throws Exception;
	public PageObject teacherProjectXiaoBen(Map<String, Object> conditions,int startPage,int pageSize) throws Exception;
	/**
	 * 教师正在参加培训项目审核状态
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduProjectComment selectTeacherStatusByTeacherId(Integer ProjectId,Integer teacherId) throws Exception;
	boolean insertCommentTeacherInfo(Integer organizationId, String projectId,Integer teacherId,int jobVersion,String loginAccount,int status,String type) throws Exception;
	boolean insertCommentTeacherInfo2(String projectId,Integer teacherId,int jobVersion,String loginAccount,int status,String type) throws Exception;
	/**
	 * 教师已结束的项目列表
	 * @param paramMap
	 * @return
	 */
	public PageObject selectTeacherOverProjectListByTeacherId(Map<String, Object> paramMap,int startPage,int pageSize) throws Exception;
	
	boolean insertTeacherCommentScore(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 查询工作调动记录
	 * @param teacherId
	 * @return
	 * @throws Exception
	 */
	List<EduTeacherMobilize> selectJobtransferHistoryByTeacherId(
			Integer teacherId) throws Exception;
	
	/**
	 * 教师去学习查询培训机构
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<Organization> selectProjectOrganizationList(Map<String,Object> paramMap) throws Exception;
	/**
	 * 教师去学习更新机构id
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	boolean insertTeacherOrganizationId(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 报名之前查看该项目是否需要审核
	 * add by yinxiaolong
	 * @param supplierId
	 * @return
	 * @throws Exception
	 */
	public EduProjectTrainTargetActitity selectProMustAudit(Map<String,Object> paramMap) throws Exception;
	
	/**
	 * 查询教师版本信息
	 * @param teacherId
	 * @param version
	 * @return
	 * @throws Exception
	 */
	EduTeacherBasicInfo selectTeacherBasicInfoByTeacherIdAndVersion(
			Integer teacherId, Integer version) throws Exception;
	
	/**
	 * 查询教师教育版本信息
	 * @param teacherId
	 * @param version
	 * @return
	 * @throws Exception
	 */
	List<EduTeacherEducation> selectTeacherEducationByTeacherIdAndVersion(
			Integer teacherId, Integer version) throws Exception;
	
	/**
	 * 查询教师工作版本信息
	 * @param teacherId
	 * @param version
	 * @return
	 * @throws Exception
	 */
	EduTeacherJob selectTeacherJobInfoByTeacherIdAndVersion(Integer teacherId,
			Integer version) throws Exception;
	
	/**
	 * 查询老师已经加入的项目并且项目的状态为已经结束
	 * @param projectName
	 * @param year
	 * @param teacherId
	 * @return
	 */
	public List<EduProjectTeacherJoin> selectProjectTeacherJoinFinish(String projectName,String year,Integer teacherId);
	
	public PageObject selectProjectTeacherJoinFinishByPage(
			String projectName,String beginYear, String endYear, Integer teacherId, int startIndex,int pageSize);
	List<EduTeacherForReport> queryTeacherByIds(List<Integer> tids)
			throws Exception;
	public PageObject teacherProjectCommonAll(Map<String, Object> conditions,String flag, int startIndex, int sizePerPage)throws Exception;
	
	/***
	 * 查询学分借贷记录（某一教师的）
	 * @param conditions
	 * @return
	 */
	public PageObject queryTeacherLendCredit(Map<String, Object> conditions);
	/***
	 * 新增接借贷记录
	 * @param conditions
	 * @return
	 */
	public boolean insertLendCredit(Map<String, Object> conditions);
	/***
	 * 修改接借贷记录
	 * @param conditions
	 * @return
	 */
	public boolean updateLendCredit(Map<String, Object> conditions);
	/***
	 * 查询教师培训结果列表
	 * @param conditions
	 * @return
	 */
	public PageObject queryTeacherScore(Map<String, Object> conditions);
	/**
	 * 查询教师获得的总学分
	 * @param conditions
	 * @return
	 */
	public int queryTeacherCredit(Map<String, Object> conditions);
	/**
	 * 偿还学分
	 * @param conditions
	 * @return
	 */
	public boolean repayLendCredit(Map<String, Object> conditions);
	/**
	 * 查询教师获得的总学时
	 * @param conditions
	 * @return
	 */
	public int queryTeacherPeriod(Map<String, Object> conditions);
	/**
	 * 查询教师年度总学分（通过学习项目）
	 * @param conditions
	 * @return
	 */
	public Float queryTeacherTotalCreditByYear(Map<String, Object> conditions);
	/**
	 * 查询教师年度借贷学分
	 * @param conditions
	 * @return
	 */
	public Float queryTeacherLendCreditByYear(Map<String, Object> conditions);
	/**
	 * 查询教师年度偿还学分
	 * @param conditions
	 * @return
	 */
	public Float queryTeacherRepayCreditByYear(Map<String, Object> conditions);
	/**
	 * 查询年度应该修习学分
	 * @param conditions
	 * @return
	 */
	public Integer queryNeedCreditByYear(Map<String, Object> conditions);
	/**
	 * 查询教师年度总学时（通过学习项目）
	 * @param conditions
	 * @return
	 */
	public Float queryTeacherTotalPeriodByYear(Map<String, Object> conditions);
	/**
	 * 通过地区查询教师借贷
	 * @param conditions
	 * @return
	 */
	public PageObject queryAllTeacherLendCreditByArea(Map<String, Object> conditions);
	/**
	 * 查询教师自主研修总学分
	 * @param conditions
	 * @return
	 */
	public Float queryTeacherTotalIsCreditByYear(Map<String, Object> conditions);
}
