package project.teacher.teacherProject.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import framelib.utils.page.PageObject;

import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduProjectComment;
import project.edupm.projectmanage.pojo.EduTeacherForReport;
import project.organization.pojo.Organization;
import project.person.pojo.EduUser;
import project.system.pojo.EduCreditLend;
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

public interface ITeacherProjectReadDaoIF {
	
	/**
	 * 根据教师idNumber查询教师id
	 * 
	 * add by zhangxiaoqi
	 * @param idNumber
	 * @return
	 * @throws Exception
	 */
	public int selectTeacherIdByIdNumber(String idNumber) throws Exception;
	
	/**
	 * 老师的资料信息
	 * add by yinxiaolong
	 * @param paramMap
	 * @return
	 */
	public EduUser selectTeacherBasicInfoByLoginAccount(Map<String,Object> paramMap);
	/**
	 * 教师基本信息
	 * add by yinxiaolong
	 * @param paramMap
	 * @return
	 */
	public EduTeacherBasicInfo selectTeacherBasicInfoByTeacherId(Map<String,Object> paramMap);
	
	/**
	 * 教育经历
	 * abb by yinxiaolong
	 */
	public List<EduTeacherEducation> selectTeacherEducationByTeacherId(Map<String,Object> paramMap);
	
	public List<EduTeacherEducation> selectTeacherEducationByTeacherId(Integer Id, Integer status);
	
	/**
	 * 老师工作信息
	 * add by yinxiaolong
	 * @param paramMap
	 * @return
	 */
	public EduTeacherJob selectTeacherJobInfoByTeacherId(Map<String,Object> paramMap);
	
	/**
	 * 老师的历次学校记录
	 * add by yinxiaolong
	 * @param paramMap
	 * @return
	 */
	public List<EduTeacherOldSchool> selectTeacherOldSchoolInfoByTeacherId(Map<String,Object> paramMap);
	/**
	 * 老师审核情况
	 * add by yinxiaolong
	 * @param paramMap
	 * @return
	 */
	public List<EduAudit> selectTeacherAuditInfoByTeacherId(Map<String,Object> paramMap);
	/**
	 * 老师正在参加的培训项目列表
	 * add by yinxiaolong
	 * @param paramMap
	 * @return
	 */
	public List<EduProjectPojo> selectTeacherProjectListByTeacherId(Integer teacherId);
	
	/**
	 * 教师正在参加培训的项目查看信息
	 * add by yinxiaolong
	 * @param paramMap
	 * @return
	 */
	public EduProjectPojo selectTeacherProjectInfoByProjectId(Integer teacherId,Integer projectId);
	/**
	 * 老师正在参加培训的项目，项目培训对象查看信息
	 * add by yinxiaolong
	 * @param paramMap
	 * @return
	 */
	public List<EduProjectPojo> selectTeacherProjectTainInfoByTeacherId(Integer teacherId,Integer projectId);
	/**
	 * 教师加入培训项目培训列表分页
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	/*
	 * 全部项目
	 */
	public int selectCountByConditions(Map<String,Object> conditions) throws Exception;
	/*
	 * 我的项目
	 */
	public int selectCountMyProject(Map<String,Object> conditions) throws Exception;
	/*
	 * 国培项目
	 */
	public int selectCountTeacherOtherProject(Map<String,Object> conditions) throws Exception;
	/*
	 * 省培项目
	 */
	public int selectCountTeacherAddProjectGuoPei(Map<String,Object> conditions) throws Exception;
	public int teacherProjectXiaoBenCount(Map<String,Object> conditions) throws Exception;
	/**
	 * 教师加入培训项目培训列表查询
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public List<EduProjectTrainTargetActitity> selectProjectList(Map<String,Object> conditions) throws Exception;
	public List<EduProjectTrainTargetActitity> teacherMyProject(Map<String,Object> conditions) throws Exception;
	public List<EduProjectTrainTargetActitity> teacherOtherProject(Map<String,Object> conditions) throws Exception;
	public List<EduProjectTrainTargetActitity> teacherAddProjectGuoPei(Map<String,Object> conditions) throws Exception;
	public List<EduProjectTrainTargetActitity> teacherProjectXiaoBen(Map<String,Object> conditions) throws Exception;
	/**
	 * 老师加入项目资格信息
	 * add by yinxiaolong
	 * @param paramMap
	 * @return
	 */
	public EduTeacherJob selectTeacherAddProjectTerm(Map<String,Object> conditions);
	/**
	 * 老师加入项目资格信息学历
	 * add by yinxiaolong
	 * @param paramMap
	 * @return
	 */
	public List<EduTeacherEducation> selectTeacherAddPrijectEducationByTeacherId(Map<String,Object> conditions);
	public EduProjectComment selectTeacherStatusByTeacherId(Integer projectId,Integer teacherId);
	/**
	 * 教师已结束的培训项目培训列表分页
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public int selectOverProCountByParamMap(Map<String,Object> paramMap) throws Exception;
	/**
	 * 老师已结束的培训项目列表
	 * add by yinxiaolong
	 * @param paramMap
	 * @return
	 */
	public List<EduProjectActivityPojo> selectTeacherOverProjectListByTeacherId(Map<String,Object> paramMap)throws Exception;

	/**
	 * 
	 * @param paramMap
	 * @return
	 */
	List<EduTeacherMobilize> selectJobtransferHistoryByTeacherId(
			Map<String, Object> paramMap);
	
	/**
	 * 教师去学习查询培训机构
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public List<Organization> selectProjectOrganizationList(Map<String,Object> ParamMap) throws Exception;
	
	/**
	 * 报名之前查看该项目是否需要审核
	 * add by yinxiaolong
	 * @param paramMap
	 * @return
	 */
	public EduProjectTrainTargetActitity selectProMustAudit(Map<String,Object> paramMap);

	/**
	 * 根据教师版本获得基本信息
	 * @param paramMap
	 * @return
	 */
	public EduTeacherBasicInfo selectTeacherBasicInfoByTeacherIdAndVersion(
			Map<String, Object> paramMap);

	/**
	 * 根据教师教育经历
	 * @param paramMap
	 * @return
	 */
	public List<EduTeacherEducation> selectTeacherEducationByTeacherIdAndVersion(
			Map<String, Object> paramMap);

	/**
	 * 根据教师工作信息
	 * @param paramMap
	 * @return
	 */
	public EduTeacherJob selectTeacherJobInfoByTeacherIdAndVersion(
			Map<String, Object> paramMap);
	
	/**
	 * 查询老师加入的项目
	 * @param param
	 * @return
	 */
	public List<EduProjectTeacherJoin> selectProjectTeacherJoinByParam(HashMap<String, Object> param);

	List<EduTeacherForReport> selectTeacherByIds(List<Integer> tids) throws Exception;

	/**
	 * 培训项目count查询
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public int selectCountTeacherProjectCommon(Map<String, Object> conditions) throws Exception;

	/**
	 * 培训项目通用查询
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public List<EduProjectTrainTargetActitity> teacherProjectCommon(Map<String, Object> conditions) throws Exception;

	/***
	 * 教师学分借贷记录数量
	 * @param conditions
	 * @return
	 */
	public int queryTeacherLendCreditCount(Map<String, Object> conditions);

	/***
	 * 教师学分借贷记录
	 * @param conditions
	 * @return
	 */
	public List<EduProjectTrainTargetActitity> queryTeacherLendCredit(Map<String, Object> conditions);
	/***
	 * 教师教师培训项目列表数
	 * @param conditions
	 * @return
	 */
	public int queryTeacherScoreCount(Map<String, Object> conditions);
	/***
	 * 教师教师培训项目列表
	 * @param conditions
	 * @return
	 */
	public List<EduProject> queryTeacherScore(Map<String, Object> conditions);

	/**
	 * 查询教师几年获得的总学分
	 * @param conditions
	 * @return
	 */
	public int queryTeacherCredit(Map<String, Object> conditions);

	/**
	 * 查询教师几年获得的总学时
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
	 * 查询教师年度借贷总学分
	 * @param conditions
	 * @return
	 */
	public Float queryTeacherLendCreditByYear(Map<String, Object> conditions);

	/**
	 * 查询教师年度偿还总学分
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
	 * 查询教师年度借贷总学时
	 * @param conditions
	 * @return
	 */
	public Float queryTeacherTotalPeriodByYear(Map<String, Object> conditions);

	/**
	 * 通过地区查询教师借贷
	 * @param conditions
	 * @return
	 */
	public List<EduCreditLend> queryAllTeacherLendCreditByArea(Map<String, Object> conditions);

	/**
	 * 查询教师年度自主研修总学分
	 * @param conditions
	 * @return
	 */
	public Float queryTeacherTotalIsCreditByYear(Map<String, Object> conditions);

	
}
