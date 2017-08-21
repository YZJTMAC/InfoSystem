package project.system.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.edupm.projectmanage.pojo.EduProjectNotrain;
import project.edupm.projectmanage.pojo.EduQustionSummary;
import project.furtheredu.certificate.pojo.EduDiploma;
import project.message.pojo.MessageTree;
import project.message.pojo.NoticeTree;
import project.organization.pojo.Organization;
import project.person.pojo.EduUser;
import project.system.dao.ISysReadDAO;
import project.system.pojo.EduSchool;
import project.system.pojo.EduTeacherScoreInfo;
import project.system.pojo.FjTeacherStudyInfo;
import project.system.pojo.Fjimport;
import project.system.pojo.FjimportActivty;
import project.system.pojo.FjimportHistory;
import project.system.pojo.ProjectStatisticsActivty;
import project.system.pojo.RoleType;
import project.system.pojo.SysArea;
import project.system.pojo.SysDictionary;
import project.system.pojo.SysFunction;
import project.system.pojo.SysPlatformSetup;
import project.system.pojo.SysRole;
import project.system.pojo.SysRoleFuncActivty;
import project.system.pojo.SysSetup;
import project.system.pojo.ZTree;
import project.teacher.teacherProject.pojo.EduProjectActivityPojo;
import framelib.dao.BaseDAOImpl;

@SuppressWarnings("unchecked")
public class SysReadDAOImpl extends BaseDAOImpl implements ISysReadDAO{
	
	/**
	 * 通过字典类型查询字典表数据
	 * @param dicType 字典类型 如：project_class 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SysDictionary> selectDicByDicType(String dicType)
			throws Exception {
		List<SysDictionary> list = this.getSqlMapClientTemplate().queryForList("queryDicByType",dicType);
		return list;
	}
	
	@Override
	public int countAreaByConditions(Map<String, Object> params)
			throws Exception {
		
		return (Integer)this.getSqlMapClientTemplate().queryForObject("count_area",params);
	}

	
	@Override
	public List<SysArea> selectAreaByConditions(Map<String, Object> params)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_area",params);
	}

	@Override
	public List<EduSchool> selectSchoolList(Map<String, Object> params)	throws Exception {
		List<EduSchool> list = this.getSqlMapClientTemplate().queryForList("select_school_byCondition",params);
		return list;
	}
	@Override
	public List<SysArea> selectAreaByBelong(Map<String , Object> pram) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectAreaByBelong", pram);
	}

	@Override
	public List<SysArea> selectAllAreas() throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_all_area");
	}

	@Override
	public List<Object> selectDiplomaListByCondition(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("select_diploma_page", param);
	}
	
	@Override  
	public Integer selectDiplomaCountByCondition(Map<String, Object> param) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("select_diploma_page_count", param);
	}
	
	@Override
	public EduDiploma selectDiplomaById(Integer Id, String projectId, String type) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("diplomaId", Id);
		paramMap.put("projectId", projectId);
		paramMap.put("type", type);
		return (EduDiploma)this.getSqlMapClientTemplate().queryForObject("select_certificate_byId", paramMap);
	}
	
	@Override
	public EduDiploma selectDiplomaByYear(Map<String, Object> paramMap) throws Exception {
		return (EduDiploma)this.getSqlMapClientTemplate().queryForObject("select_certificate_byYear", paramMap);
	}
	
	/**
	 * 项目汇总统计 总数
	 * @author cl
	 * @create date 2014-4-3
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectProjectCount(Map<String, Object> paramMap) throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject("selectProjectCount", paramMap);
		return count;
	}
	
	/**
	 * 项目模板汇总教师合格人数信息
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectModeStatisticsCount(Map<String, Object> paramMap) throws Exception{
		int count = (Integer)this.getSqlMapClientTemplate().queryForObject("selectModelStatisticsCount",paramMap);
		return count;
	}

	@Override
	public SysArea selectAreaByCode(String code) throws Exception {
		return (SysArea) this.getSqlMapClientTemplate().queryForObject("selectAreaByCode",code);
	}

	 /**
	 * 项目汇总统计 列表
	 * @author cl
	 * @create date 2014-4-3
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<ProjectStatisticsActivty> selectProjectList(Map<String, Object> paramMap) throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectProjectList", paramMap);
	}
	
	/**
	 * 继教模板汇总统计 列表
	 * 
	 * @author 
	 * @create date 2016-08-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<ProjectStatisticsActivty> selectModelStatisticsList(
			Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectModelStatisticsList",
				paramMap);
	}
	
	/**
	 * 地区汇总统计 列表
	 * 
	 * @author 
	 * @create date 2016-08-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<ProjectStatisticsActivty> selectAreaStatisticsList(
			Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectAreaStatisticsList",
				paramMap);
	}

	 /**
	 * 获取角色对应的权限
	 * @author cl
	 * @create date 2014-4-4
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<SysRoleFuncActivty> selectRoleFuncList(Integer id)
			throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectRoleFunction", id);
	}

	@Override
	public List<SysDictionary> selectSubjectBySection(String id, String sectionName) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sectionName", sectionName);
		paramMap.put("id", id);
		return this.getSqlMapClientTemplate().queryForList("select_subject_by_section",paramMap);
	}

	 /**
	 * 角色管理
	 * @author cl
	 * @create date 2014-4-10
	 * @return
	 * @throws Exception
	 */
	public List<SysRole> selectRoleList(Map<String, Object> paramMap) throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectRoleList",paramMap);
	}

	/**
	 * 学校管理记录 总数
	 * @author cl
	 * @create date 2014-4-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectSysSchoolCount(Map<String, Object> paramMap)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject("selectSysSchoolCount", paramMap);
		return count;
	}
	
	/**
	 * 学校导入时，验证区域内是否存在学校
	 * @author cl
	 * @create date 2014-4-21
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectSysSchoolCountForImport(Map<String, Object> paramMap)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject("selectSysSchoolCountForImport", paramMap);
		return count;
	}

	 /**
	 * 学校管理 列表
	 * @author cl
	 * @create date 2014-4-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduSchool> selectSysSchoolList(Map<String, Object> paramMap)
			throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectSysSchoolList", paramMap);
	}

	 /**
	 * 学校管理 查看详情
	 * @author cl
	 * @create date 2014-4-13
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduSchool selectSysSchoolInfo(Integer id) throws Exception {
		return  (EduSchool)this.getSqlMapClientTemplate().queryForObject("selectSysSchoolInfo", id);
	}

	
	@Override
	public int selectSysOrganizationCount(Map<String, Object> paramMap)
	throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject("selectSysOrganizationCount", paramMap);
		return count;
	}
	
	@Override
	public List<Organization> selectSysOrganizationList(
			Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectSysOrganizationList", paramMap);
	}

	
	/**
	 * 查询系统设置的功能设置
	 * @author zxq
	 * @return
	 * @throws Exception
	 */
	@Override
	public SysSetup selectSysSetupInfo() throws Exception {
		return (SysSetup)this.getSqlMapClientTemplate().queryForObject("selectSysSetupInfo");
	}
	/**
	 * 查询所有存在的用户名
	 */
	@Override
	public List<String> selectAllUserName() throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_all_user_name");
	}
	
	/**
	 * 查询所有存在的用户编号
	 */
	@Override
	public List<String> selectAllUserNo() throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_all_user_no");
	}

	@Override
	public Organization selectOrganizationInfoById(Integer organizationId) throws Exception {
		return (Organization) this.getSqlMapClientTemplate().queryForObject("selectorganizationInfoById",organizationId);
	}

	@Override
	public List<EduSchool> selectAllSchool() throws Exception {
		
		return this.getSqlMapClientTemplate().queryForList("select_school");
	}

	/**
	 * 获取系统模块
	 * @return
	 * @throws Exception
	 */
	public List<SysFunction> selectSysFunction() throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectSysFunction");
	}


	/**
	 * 获取角色对应的系统模块
	 * @return
	 * @throws Exception
	 */
	public List<SysFunction> selectSysFunction(Integer id) throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectSysFunctionRole",id);
	}

	@Override
	public List<EduUser> selectAdmins(Map<String, Object> paramMap)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectOrgAdminsInfoByOrgId",paramMap);
	}

	@Override
	public int selectOrgAdminsCount(Map<String, Object> paramMap)
			throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectOrgAdminsCount",paramMap);
	}

	@Override
	public SysArea selectAreaByProScopeId(String projectScopeId) throws Exception {
		return (SysArea)this.getSqlMapClientTemplate().queryForObject("selectAreaByProScopeId", projectScopeId);
	}
	@Override
	public ZTree getById(Map<String, Object> paramMap) throws Exception {
		return (ZTree) this.getSqlMapClientTemplate().queryForObject("select_by_it",paramMap);
	}
	
	@Override
	public ZTree getAreaTeacherById(Map<String, Object> paramMap) throws Exception {
		return (ZTree) this.getSqlMapClientTemplate().queryForObject("select_area_teacher_by_it",paramMap);
	}

	@Override
	public List<ZTree> getChildAreaList(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_child_area",paramMap);
	}

	@Override
	public List<ZTree> getSchoolTypeListOfArea(int areaId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("getSchoolTypeListOfArea",areaId);
	}

	@Override
	public List<ZTree> getSchoolListOfAreaByType(Map<String, Object> params)
			throws Exception {
	 
		
		return this.getSqlMapClientTemplate().queryForList("getSchoolListOfAreaByType",params);
	}
	@Override
	public int countNotrainByConditions(Map<String, Object> params)
			throws Exception {
		
		return (Integer)this.getSqlMapClientTemplate().queryForObject("countNotrainByConditions",params);
		/*Object sid = params.get("sid");//学校id
		Object did = params.get("did");//区县id
		Object cid = params.get("cid");//市id
		Object pid = params.get("pid");//省id
		if(sid !=null){
			return  (Integer)this.getSqlMapClientTemplate().queryForObject("countNotrainByConditions_sid",params);
		}
		if(did !=null){
			return  (Integer)this.getSqlMapClientTemplate().queryForObject("countNotrainByConditions_did",params);
		}
		if(cid !=null){
			return  (Integer)this.getSqlMapClientTemplate().queryForObject("countNotrainByConditions_cid",params);
		}
		if(pid !=null){
			return  (Integer)this.getSqlMapClientTemplate().queryForObject("countNotrainByConditions_pid",params);
		}
		return 0; */
		
	}

	
	@Override
	public List<EduProjectNotrain> selectNotrainByConditions(Map<String, Object> params)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectNotrainByConditions",params);
		/*Object sid = params.get("sid");//学校id
		Object did = params.get("did");//区县id
		Object cid = params.get("cid");//市id
		Object pid = params.get("pid");//省id
		if(sid !=null){
			return this.getSqlMapClientTemplate().queryForList("selectNotrainByConditions_sid",params);
		}
		if(did !=null){
			return this.getSqlMapClientTemplate().queryForList("selectNotrainByConditions_did",params);
		}
		if(cid !=null){
			return this.getSqlMapClientTemplate().queryForList("selectNotrainByConditions_cid",params);
		}
		if(pid !=null){
			return this.getSqlMapClientTemplate().queryForList("selectNotrainByConditions_pid",params);
		}
		return null; */
	}
	
	@Override
	public EduProjectNotrain selectNotraiByPrimaryKey(Integer id) throws Exception {
		return (EduProjectNotrain)this.getSqlMapClientTemplate().queryForObject("selectNotraiByPrimaryKey", id);
	}

	@Override
	public ZTree getAreaById(Map<String, Object> conditions) throws Exception {
		return (ZTree) this.getSqlMapClientTemplate().queryForObject("getAreaById",conditions);
	}

	@Override
	public List<ZTree> getSchoolTypeList(Map<String, Object> conditions)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("getSchoolTypeList",conditions);
	}

	@Override
	public List<ZTree> getChildrenAreaById(Map<String, Object> conditions)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("getChildrenAreaById",conditions);
	}

	@Override
	public List<ZTree> getSchoolList(Map<String, Object> conditions)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("getSchoolList",conditions);
	}

	/**
	 * 查询系统平台设置详情
	 * @author 曉
	 * @return
	 */
	@Override
	public SysPlatformSetup selectSysPlatformSetup() throws Exception {
		return (SysPlatformSetup) this.getSqlMapClientTemplate().queryForObject("selectSysPlatformSetup");
	}

	@Override
	public List<SysArea> selectAreasByUserCode(Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList("select_areas_by_user_code", paramMap);
	}

	/**
	 * 删除学校时，检查学校是否被引用
	 * @author cl
	 * @create date 2014-6-23
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectSchoolBelongCount(int schoolId) throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject("selectSysSchoolBelongCount", schoolId);
		return count;
	}
	
	@Override
	public List<Integer> selectAreaById(int areaId) throws Exception{
		return this.getSqlMapClientTemplate().queryForList("select_area_count_by_areaId",areaId);
	}

	@Override
	public List<ZTree> getNodes() throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectArea");
	}
	
	/**
	 * liuyiyou
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<NoticeTree> schoolTree(Map<String,Object> param) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("schoolTree",param);
	}
	
	
	@Override
	public List<NoticeTree> getNodes(String id) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectAreaForNotice",id);
	}

	@Override
	public List<ZTree> getChildAreaTeacherList(Map<String, Object> paramMap)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_child_area_teacher",paramMap);
	}

	@Override
	public List<ZTree> getSchoolListOfTeacherByType(
			Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("getSchoolListOfTeacherByType",conditions);
	}

	public List<FjTeacherStudyInfo> getFJTeacherAchievements(Map<String, Object> params)
			throws Exception {
		// TODO Auto-generated method stub
		return (List<FjTeacherStudyInfo>)this.getSqlMapClientTemplate().queryForList("select_import_list_by_area",params);
	}

	@Override
	public SysArea getAreaByName(Map<String, Object> paramMap) {
		return (SysArea)this.getSqlMapClientTemplate().queryForObject("select_area_by_name", paramMap);
	}
	
	@Override
	public List<SysArea> getDistrictList(Map<String, Object> paramMap) {
		return (List<SysArea>)this.getSqlMapClientTemplate().queryForList("select_district_list", paramMap);
	}
	
	@Override
	public List<SysArea> getAreaListByUpcode(Map<String, Object> paramMap) {
		return (List<SysArea>)this.getSqlMapClientTemplate().queryForList("select_area_list_by_upcode", paramMap);
	}

	public Fjimport getFjimportByName(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return (Fjimport)this.getSqlMapClientTemplate().queryForObject("fjimport_By_areaName", paramMap);
	}

	public List<RoleType> getRoleTypeList(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("roleTypeList",paramMap);
	}

	public EduSchool selectSchoolByName(Map<String, Object> params)
			throws Exception {
		// TODO Auto-generated method stub
		return (EduSchool)this.getSqlMapClientTemplate().queryForObject("select_School_ByName", params);
	}

	@Override
	public List<MessageTree> selectAdministratorNode(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_administrator_node", paramMap);
	}
	
	@Override
	public List<MessageTree> selectOrgAdministratorNode(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_org_administrator_node", paramMap);
	}
	
	@Override
	public List<MessageTree> selectSchoolAdministratorNode(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_school_administrator_node", paramMap);
	}

	@Override
	public List<MessageTree> selectSchoolTeacherNode(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_school_teacher_node", paramMap);
	}
	
	public List<EduDiploma> queryAllProjectDeploma() throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("select_diploma_no_page");
	}

	public FjimportActivty getFjimportInfo(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return (FjimportActivty)this.getSqlMapClientTemplate().queryForObject("select_fjimportInfo_by_schoolId", param);
	}

	public int getTeacherTrainScoreCount(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject("select_teacher_score_count", param);
		return count;
	}

	public List<EduTeacherScoreInfo> getTeacherTrainScoreListPage(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("select_teacher_score_pagelist",param);
	}

	public List<EduTeacherScoreInfo> queryEduTeacherScoreInfoList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("select_teacher_train_score",params);
	}

	public int getTeacherScoreHistoryCount(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject("select_teacher_score_history_count", param);
		return count;
	}

	public List<FjimportHistory> getTeacherScoreHistoryListPage( Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("select_teacher_score_history_pagelist",param);
	}

	public List<EduTeacherScoreInfo> queryTeacherScoreListNoPage(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("select_teacher_score_list",param);
	}

	public EduTeacherScoreInfo getTeacherScoreInfoById( Map<String, Object> result) throws Exception {
		// TODO Auto-generated method stub
		return (EduTeacherScoreInfo)this.getSqlMapClientTemplate().queryForObject("select_teacherScoreInfo_by_condition", result);
	}

	public int getTeacherTrainScoreByTeacherCount(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectTrainScoreCountByParamMap",param);
	}

	public List<EduProjectActivityPojo> getgetTeacherTrainScoreListByTeacher(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("selectTrainScoreListByParamMap",param);
	}

	@Override
	public List<EduQustionSummary> questionSurverSummaryList(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("questionSurverSummaryList",param);
	}

	@Override
	public int getTeacherTrainCreditCount(Map<String, Object> param) {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject("select_teacher_credit_count", param);
		return count;
	}

	@Override
	public List<EduTeacherScoreInfo> getTeacherTrainCreditListPage(	Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("select_teacher_credit_pagelist",param);
	}

	@Override
	public List<EduTeacherScoreInfo> getTeacherTrainRemainCredit(
			Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("select_teacher_remain_credit",condition);
	}

	@Override
	public List<String> getNeedCredit(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("select_need_remain_credit",params);
	}

	@Override
	public int selectInitYear() {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("select_init_year");
	}

}
