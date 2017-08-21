package project.edupm.projectmanage.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.edupm.projectmanage.dao.IEduProjectReadDAO;
import project.edupm.projectmanage.dto.EduProjectDTO;
import project.edupm.projectmanage.pojo.CanSign;
import project.edupm.projectmanage.pojo.EduModel;
import project.edupm.projectmanage.pojo.EduModelPOJO;
import project.edupm.projectmanage.pojo.EduOrgProjectStatus;
import project.edupm.projectmanage.pojo.EduPaper;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduProjectAllocateByArea;
import project.edupm.projectmanage.pojo.EduProjectAudit;
import project.edupm.projectmanage.pojo.EduProjectAuditPOJO;
import project.edupm.projectmanage.pojo.EduProjectComment;
import project.edupm.projectmanage.pojo.EduProjectForAudit;
import project.edupm.projectmanage.pojo.EduProjectProcess;
import project.edupm.projectmanage.pojo.EduProjectSummary;
import project.edupm.projectmanage.pojo.EduQuestion;
import project.edupm.projectmanage.pojo.EduQuestionOptions;
import project.edupm.projectmanage.pojo.EduResponse;
import project.edupm.projectmanage.pojo.EduResponseQuestion;
import project.edupm.projectmanage.pojo.EduTeacherAudit;
import project.edupm.projectmanage.pojo.EduTeacherForReport;
import project.edupm.projectmanage.pojo.EduTeacherImportRecord;
import project.edupm.projectmanage.pojo.EduTeacherProject;
import project.edupm.projectmanage.pojo.ProjectReportInfo;
import project.edupm.projectmanage.pojo.SsOrgProjectAuditActivity;
import project.organization.pojo.OrgProTeacherActivity;
import project.teacher.teacherProject.pojo.EduProjectPojo;
import project.teacher.teachermanage.pojo.EduProjectCommentTeacher;
import framelib.dao.BaseDAOImpl;
@SuppressWarnings("unchecked")
public class EduProjectReadDAOImpl extends BaseDAOImpl implements IEduProjectReadDAO{

	@Override
	public List<EduProject> selectProjectList(Map<String, Object> conditions)
			throws Exception {
//		return this.getSqlMapClientTemplate().queryForList("selectProjectByConditions",conditions);
		return this.getSqlMapClientTemplate().queryForList("mgr_selectProjectList",conditions);
	}

	@Override
	public int selectCountByConditions(Map<String, Object> conditions)
			throws Exception {
/*		return (Integer)this.getSqlMapClientTemplate().queryForObject("count_mgr_selectProjectList",conditions);*/
		return (Integer)this.getSqlMapClientTemplate().queryForObject("count_project_list_for_audit",conditions);
	} 
	
	@Override
	public int selectCountProListForAudit(Map<String, Object> conditions)
			throws Exception {
/*		return (Integer)this.getSqlMapClientTemplate().queryForObject("count_mgr_selectProjectList",conditions);*/
		return (Integer)this.getSqlMapClientTemplate().queryForObject("select_count_project_list_for_audit",conditions);
	} 
	
	/**
	 * 教师报名审核 项目列表
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	@Override
	public int selectCountProjectForAudit(Map<String, Object> conditions) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("count_project_list_for_auditSH",conditions);
	}
	
	/**
	 * 待审核项目id
	 */
	@Override
	public List<Integer> selectUnAuditProjectIds(Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("project_list_unaudit",conditions);
	}
	
	/**
	 * 已完成审核项目id
	 */
	@Override
	public List<Integer> selectHasFinishedAuditProjectIds(Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("project_list_hasaudit",conditions);
	}
	
	@Override
	public int selectPaperCountByConditions(Map<String, Object> conditions)
			throws Exception {
//			return (Integer)this.getSqlMapClientTemplate().queryForObject("selectProjectCountByConditions",conditions);
		return (Integer)this.getSqlMapClientTemplate().queryForObject("count_mgr_selectPaperListByPid",conditions);
	}

	@Override
	public EduProjectDTO selectProFullInfoById(int proId) throws Exception {
		return (EduProjectDTO)this.getSqlMapClientTemplate().queryForObject("select_pro_full_info", proId);
	}

	@Override
	public EduProject selectBaseInfoById(int proId) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("pro_selectByPrimaryKey",proId);
		if(obj != null){
			return  (EduProject)obj;
		}
		return null;
	}

	
	@Override
	public List<EduProjectAudit> selectProListForAudit(
			Map<String, Object> conditions) throws Exception {
			return this.getSqlMapClientTemplate().queryForList("project_list_for_audit",conditions);
	}
	/*
	 * 成绩审核
	 */
	@Override
	public List<EduProjectAudit> selectProListForAuditSH(
			Map<String, Object> conditions) throws Exception {
			return this.getSqlMapClientTemplate().queryForList("project_list_for_auditSH",conditions);
	}

	@Override
	public List<OrgProTeacherActivity> selectTeacherByProjectId(
			Map<String, Object> params) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_pro_Teachers",params);
	}

	@Override
	public int selectCountTeacherForAudit(Map<String, Object> params)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_pro_teachers",params);
		if(obj != null){
			return (Integer)obj;
		}
		return 0;
	}

	@Override
	public String selectUnpassReason(int id) throws Exception {
		Object object = this.getSqlMapClientTemplate().queryForObject("select_unpass_reason",id);
		if(object == null){
			return "";
		}
		return object.toString();
	}

	@Override
	public int selectCountForSetSignWay(int projectId) throws Exception {
		Object object = this.getSqlMapClientTemplate().queryForObject("select_count_teacher_by_project",projectId);
		if(object != null){
			return (Integer)object;
		}
		return 0;
	}

	@Override
	public int selectCountForAllocate(Map<String, Object> params)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("select_count_org_by_project",params);
		if(obj != null){
			return (Integer)obj;
		}
		return 0;
	}

	/**
	 *之前是得到eud_project_comment的id集合，现在改成得到eud_project_comment的teacher_id的集合 
	因为在service中调用该方法的名字叫：getAllTeachers，不知道之前开发人员怎么命名的，
	还有就是为什么要去掉后面的那些isNotEmpty,如果不传递该参数，下面的压根运行不到
	再有就是，为什么分页和不分页需要些两个查询？可以根据传递的startIndex或者其他参数来判断是否是分页啊
	 */
	@Override
	public List<String> selectAllTeacherRecord(Map<String, Object> params)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_pro_Teachers_no_page",params);
	}

	@Override
	public List<String> selectAllOrgByProjectId(int projectId) throws Exception {
		
		return this.getSqlMapClientTemplate().queryForList("select_org_by_project_id_no_page",projectId);
	}

	//查找所有的项目
	@Override
	public List<String> selectProjectName() throws Exception{
		return this.getSqlMapClientTemplate().queryForList("select_projectName");
	}
	
	//查找所有校本和非培训类项目
	@Override
	public List<String> selectTrainProjectName(Integer type) throws Exception{
		return this.getSqlMapClientTemplate().queryForList("select_train_projectName",type);
	}
	
	
	
	@Override
	public List<String> selectProjectNo() throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_projectNO");
	}

	@Override
	public List<String> selectTrainProjectNo(Integer type) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_train_projectNO",type);
	}

	
	
	@Override
	public List<Integer> selectTeacherIdsByProjectId(int projectId)
			throws Exception {
		
		return this.getSqlMapClientTemplate().queryForList("select_tId_by_project_id",projectId);
	}

	@Override
	public List<EduTeacherImportRecord> selectTeacherImprotRecord(
			Map<String, Object> params) throws Exception {
		
		return this.getSqlMapClientTemplate().queryForList("select_import_record",params);
		
	}

	@Override
	public int coutImportTeacherRecord(Map<String, Object> param)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_import_record",param);
		if(obj != null){
			return (Integer)obj;
		}
		return 0; 
	}
	@Override
	public List<EduPaper> selectPaperListByPid(Map<String, Object> conditions)
			throws Exception {
//		return this.getSqlMapClientTemplate().queryForList("selectProjectByConditions",conditions);
		return this.getSqlMapClientTemplate().queryForList("mgr_selectPaperListByPid",conditions);
	}
	
	
	@Override
	public List<Object> selectProjectListByCondition(
			Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_project_list_all",conditions);
	}
	
	@Override
	public List<Object> selectProjectListByCreateBy(
			Map<String, Object> conditions) {
		return this.getSqlMapClientTemplate().queryForList("selectProjectListByCreateBy",conditions);
	}
	
	
	@Override
	public List<EduProject> selectProjectListByStatus(
			Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("mgr_select_project_list",conditions);
		
	}
	/*
	 * 
	 * 
	 * 成绩修改
	 */
	
	@Override
	public List<EduProject> selectProjectListByStatusUpdate(
			Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("mgr_select_project_lists",conditions);
		
	}
	/*
	 * 公布
	 */
	@Override
	public List<EduProject> selectProjectPublicListByStatus(
			Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("mgr_select_project_public_list",conditions);
		
	}
	
	@Override
	public List<EduProject> selectProjectListByStatus(Map<String, Object> conditions,String queryFlag) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("queryProjectByStatusForReport",conditions);
		
	}
	
	@Override
	public int countProjectByStatus(Map<String, Object> conditions) throws Exception{
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_mgr_select_project_list_by_status",conditions);
		if(obj == null){
			return 0;
		}
		return (Integer)obj;
	}
	
	@Override
	public int countProjectByStatusPage(Map<String, Object> conditions)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_cjxg",conditions);
		if(obj == null){                                            
			return 0;
		}
		return (Integer)obj;
	}
	@Override
	public int countProjectPublicByStatus(Map<String, Object> conditions) throws Exception{
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_mgr_select_project_public_list_by_status",conditions);
		if(obj == null){
			return 0;
		}
		return (Integer)obj;
	}
	
	@Override
	public int countProjectByStatus(Map<String, Object> conditions,String queryFlag) throws Exception{
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_mgr_select_project_list_by_status_ba",conditions);
		if(obj == null){
			return 0;
		}
		return (Integer)obj;
	}
	
	
	@Override
	public EduPaper selectEduPaperById(int papId) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("eduPaper_selectByPrimaryKey",papId);
		if(obj != null){
			return  (EduPaper)obj;
		}
		return null;
	}
	@Override
	public EduQuestion selectEduQuestionById(int eqId) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("eduQuestion_selectByPrimaryKey",eqId);
		if(obj != null){
			return  (EduQuestion)obj;
		}
		return null;
	}
	@Override
	public EduQuestionOptions selectEduQuestionOptionsById(int eqoId) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("eduQuestionOptions_selectByPrimaryKey",eqoId);
		if(obj != null){
			return  (EduQuestionOptions)obj;
		}
		return null;
	}
	@Override
	public List<EduQuestion> selectEduQuestionListByPapid(Map<String, Object> conditions)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("mgr_selectQuestionListByPapid",conditions);
	}
	@Override
	public List<EduQuestionOptions> selectEduQuestionOptionsListByQid(Map<String, Object> conditions)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("mgr_selectQuestionOptionsListByQid",conditions);
	}
	@Override
	public int selectEduQuestionCountByConditionsByPapid(Map<String, Object> conditions)
			throws Exception {
//			return (Integer)this.getSqlMapClientTemplate().queryForObject("selectProjectCountByConditions",conditions);
		return (Integer)this.getSqlMapClientTemplate().queryForObject("count_mgr_selectQuestionOptionsListByPid",conditions);
	}
	@Override
	public int selectEduQuestionOptionsCountByConditionsByQid(Map<String, Object> conditions)
			throws Exception {
//			return (Integer)this.getSqlMapClientTemplate().queryForObject("selectProjectCountByConditions",conditions);
		return (Integer)this.getSqlMapClientTemplate().queryForObject("count_mgr_selectQuestionOptionsListByQid",conditions);
	}
	
	
	/**
	 * 项目中已经使用到的继教板块id集合
	 * @author liuyiyou
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Integer> selectModelListIds() throws Exception{
		return this.getSqlMapClientTemplate().queryForList("select_edu_mode_type");
	}
	
	@Override
	public List<EduModel> selectModelList(Map<String, Object> params)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_model_list",params);
	}
	@Override
	public List<Integer> selectGroupYear()
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectGroupYear",null);
	}

	@Override
	public int selectModelCountByParamMap(Map<String, Object> paramMap)
			throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("select_model_count",paramMap);
	}

	@Override
	public EduModel selectModelInfoById(int id) throws Exception {
		return (EduModel) this.getSqlMapClientTemplate().queryForObject("select_model_info_id",id);
	}

	@Override
	public EduProjectAuditPOJO selectAuditInfo(int projectId) throws Exception {
		return (EduProjectAuditPOJO) this.getSqlMapClientTemplate().queryForObject("select_audit_by_project_id",projectId);
	}

	@Override
	public List<EduProjectAllocateByArea> selectAllocateByAreaId(int areaId,int projectId)
			throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("projectId", projectId);
		params.put("areaId", areaId);
//		return this.getSqlMapClientTemplate().queryForList("select_allocate_info",params);
		return this.getSqlMapClientTemplate().queryForList("select_allocate_info2",params);
	}

	@Override
	public int countAllocateByProject(EduProjectAllocateByArea allocate)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_by_areaId_projectId",allocate);
		return obj==null?0:(Integer)obj;
	}

	@Override
	public EduProjectAllocateByArea selectAllocate(EduProjectAllocateByArea allocate) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("select_by_areaId_projectId",allocate);
		if(obj!= null){
			return (EduProjectAllocateByArea) obj;
		}
		return null;
	}

	@Override
	public List<EduProjectAllocateByArea> selectSchool(int areaId,int projectId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("areaId", areaId);
		map.put("projectId", projectId);
		List<EduProjectAllocateByArea> list = this.getSqlMapClientTemplate().queryForList("select_school_by_area2",map);
		return list;
	}
	@Override
	public List<EduProjectAllocateByArea> selectSchool(int areaId,int projectId,String schoolName) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("areaId", areaId);
		map.put("projectId", projectId);
		map.put("schoolName", schoolName);
		List<EduProjectAllocateByArea> list = this.getSqlMapClientTemplate().queryForList("select_school_by_area2",map);
		return list;
	}	
	@Override
	public List<EduProjectAllocateByArea> selectSchool(int areaId,int projectId,int schoolId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("areaId", areaId);
		map.put("projectId", projectId);
		map.put("schoolId", schoolId);
		List<EduProjectAllocateByArea> list = this.getSqlMapClientTemplate().queryForList("select_school_by_area3",map);
		return list;
	}
	@Override
	public List<EduProjectAllocateByArea> selectSchooles(int areaId,int projectId,String schoolName,Integer schoolTypeId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("areaId", areaId);
		map.put("projectId", projectId);
		map.put("schoolName", schoolName);
		map.put("schoolTypeId", schoolTypeId);
		List<EduProjectAllocateByArea> list = this.getSqlMapClientTemplate().queryForList("select_school_by_areaes",map);
		return list;
	}
	@Override
	public EduResponse selectEduResponseById(Integer id) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("eduResponse_selectByPrimaryKey",id);
		if(obj!= null){
			return (EduResponse) obj;
		}
		return null;
	}
	@Override
	public EduResponseQuestion selectEduResponseQuestionById(Integer id) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("eduResponseQuestion_selectByPrimaryKey",id);
		if(obj!= null){
			return (EduResponseQuestion) obj;
		}
		return null;
	}
	@Override
	public int countEduResponseQuestionByCondition(Map<String, Object> conditions)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_mgr_selectEduResponseQuestionListByCondition",conditions);
		return obj==null?0:(Integer)obj;
	}
	@Override
	public int countEduResponseByCondition(Map<String, Object> conditions)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_mgr_selectEduResponseListByCondition",conditions);
		return obj==null?0:(Integer)obj;
	}
	@Override
	public List<EduResponse> selectEduResponseListByCondition(Map<String, Object> conditions)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("mgr_selectEduResponseListByCondition",conditions);
	}
	@Override
	public List<EduResponseQuestion> selectEduResponseQuestionListByCondition(Map<String, Object> conditions)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("mgr_selectEduResponseQuestionListByCondition",conditions);
	}

	/**
	 * 实施机构 --> 承培机构任务分配列表总数查询
	 */
	@Override
	public int countSelectProjectsByStatus(Map<String, Object> paramMap)throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("countSelectProjectsByStatus", paramMap);
		return obj==null?0:(Integer)obj;
	}

	
	/**
	 * 实施机构 --> 承培机构任务分配列表查询
	 */
	@Override
	public List<SsOrgProjectAuditActivity> selectProjectsByStatus(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectProjectsByStatus", paramMap);
	}

	@Override
	public List<EduTeacherForReport> selectTeacherByArea(Map<String,Object> param)
			throws Exception {
//		return this.getSqlMapClientTemplate().queryForList("select_teacher_by_area",param);
		return this.getSqlMapClientTemplate().queryForList("select_teacher_by_project_and_area",param);
	}

	@Override
	public List<EduProjectComment> selectTeacherByAreaAndProject(Map<String, Object> param)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_teacher_has_bm",param);
	}

	@Override
	public int countTeacherByArea(int areaId) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_teacher_by_area",areaId);
		return obj==null?0:(Integer)obj;
	}

	@Override
	public int countProjectSuccessByStatus(Map<String, Object> conditions)
			throws Exception {
			Object obj = this.getSqlMapClientTemplate().queryForObject("count_select_project_success_list_by_status",conditions);
			if(obj == null){
				return 0;
			}
			return (Integer)obj;
	}

	@Override
	public List<EduProject> selectProjectSuccessListByStatus(
			Map<String, Object> conditions) throws Exception {
			return this.getSqlMapClientTemplate().queryForList("select_project_success",conditions);
	}

	@Override
	public List<EduProject> selectSuccessProjectList(
			Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_project_success",conditions);
	}

	@Override
	public int countProjectSuccess(Map<String, Object> conditions)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("select_project_success_count",conditions);
		if(obj == null){
			return 0;
		}
		return (Integer)obj;
	}

	@Override
	public int countTeacherByAreaAndProject(Map<String, Object> params)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("select_count_teacher_has_bm",params);
		return obj==null?0:(Integer)obj;
	}

	@Override
	public EduProjectAllocateByArea selectAllocateByAreaAndProject(
			Map<String, Object> param) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("select_allocate_by_project_and_area", param);
		return obj==null?null:(EduProjectAllocateByArea)obj;
	}

	@Override
	public List<EduProject> selectProjectByStatusForStart(Map<String,Object> param) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_project_by_status_for_start",param);
	}

	/**
	 * 启动项目列表和培训项目关闭列表
	 * @return
	 */
	@Override
	public int countProjectByStatusForStart(Map<String,Object> param) throws Exception {
		
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_project_by_status_for_start",param);
		return obj==null?0:(Integer)obj;
	}

	@Override
	public EduOrgProjectStatus selectOrgProjectStatus(int projectId) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("select_org_project_status", projectId);
		return obj == null ? null:(EduOrgProjectStatus)obj;
	}
	
	/**
	 * 创建项目--查询继教信息模块
	 */
	@Override
	public List<EduModelPOJO> selectModelNoPage(Map<String, Object> param) throws Exception {
		
		return this.getSqlMapClientTemplate().queryForList("select_model_no_page",param);
	}

	/**
	 * 获取项目培训对象属性
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	public CanSign selectCanSginProject(Integer projectId) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("select_cansgin_project", projectId);
		return obj==null?null:(CanSign)obj;
	}

	/**
	 * 获取教师--项目培训对象属性
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	public List<CanSign> selectCanSginTeacher(Integer id) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_cansgin_teacher",id);
	}

	@Override
	public boolean hasReport(int projectId, int type, int areaId)
			throws Exception {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("areaId", areaId);
		param.put("projectId", projectId);
		param.put("type", type);
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_by_areaId_projectId_status",param);
		int num = obj == null?0:(Integer)obj;
		return num>0?true:false;
	}

	@Override
	public EduProjectAllocateByArea selectSumNumByUpLvId(int projectId,
			int type, int areaId) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("projectId", projectId);
		params.put("type", type);
		params.put("areaId", areaId);
		return (EduProjectAllocateByArea) this.getSqlMapClientTemplate().queryForObject("select_allocate_info_by_areaId_and_type",params);
	}

	@Override
	public EduProjectAllocateByArea selectSchoolSumNumByUpLvId(int projectId,
			int type, int areaId) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("projectId", projectId);
		params.put("type", type);
		params.put("areaId", areaId);
		return (EduProjectAllocateByArea) this.getSqlMapClientTemplate().queryForObject("select_sum_school_allocate_by_areaId_and_type",params);
	}

	/**
	 * 查询项目审核记录
	 * @param projectId 项目ID
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public List<EduProjectAuditPOJO> selectProjectAudit(int projectId)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_project_audit",projectId);
	}
	@Override
	public List<EduProject> selectProjectByParam(Map<String, Object> param) {
		//selectProjectByParam 	
		return this.getSqlMapClientTemplate().queryForList("selectProjectByParam",param);
	}

	@Override
	public Integer selectProjectCountByParam(Map<String, Object> param) {
		//count_mgr_select_project_list_by_status selectProjectCountByParam
		return (Integer) this.getSqlMapClientTemplate().queryForObject("selectProjectCountByParam",param);
	}

	@Override
	public List<Integer> selectAreaIdsHasAllocate(int projectId, List<Integer> ids,
			int type) throws Exception {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("ids", ids);
		params.put("projectId", projectId);
		params.put("type", type);
		if(ids.size()>0){
			return this.getSqlMapClientTemplate().queryForList("select_area_id_in_ids",params);
		}
		return new ArrayList<Integer>();
	}

	/**
	 * 查询上报名额详情
	 * @param queryMap 查询条件
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public List<ProjectReportInfo> selectProjectReportInfo(
			Map<String, Object> queryMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_project_report_Info",queryMap);
	}

	/**
	 * 培训项目审核列表查询
	 */
	@Override
	public List<EduProjectForAudit> selectProjectForAudit(
			Map<String, Object> params) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_project_for_audit",params);
	}

	/**
	 * 培训项目审核列表查询
	 */
	@Override
	public int countProjectForAudit(Map<String, Object> params)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_project_for_audit", params);
		return obj==null?0:(Integer)obj;
	}

	@Override
	public List<Integer> selectSchoolIdByArea(int areaId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_school_id_by_area",areaId);
	}

	@Override
	public List<EduModel> selectEduModelForSet(Map<String,Object> param)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_model_list_for_set_exchange_role",param);
	}
	
	
	public int selectCountEduModelForSet(Map<String,Object> param) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_model_list_for_set_exchange_role",param);
		return obj==null?0:(Integer)obj; 
	}

	@Override
	public List<EduProject> selectProjectByAuditStatus(Map<String, Object> param)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_project_by_audit_status",param);
	}

	@Override
	public int countProjectByAuditStatus(Map<String, Object> param)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_project_by_audit_status",param);
		
		return obj==null?0:(Integer)obj;
	}

	@Override
	public boolean hasSign(int teacherId, int projectId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teacherId", teacherId);
		map.put("projectId", projectId);
		Object obj = this.getSqlMapClientTemplate().queryForObject("select_has_sign",map);
		
		return (Integer)obj==0?false:true;
	}

	@Override
	public List<EduTeacherProject> selectEduTeacherProjByParam(
			Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("teacherSelectCloseProj",param);
	}
	@Override
	public Integer selectEduTeacherProjCountByParam(Map<String, Object> param) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("teacherSelectCloseProjCount",param);
	}

	@Override
	public List<Map<String, Object>> queryStats(Map<String, Object> conditions) throws Exception{
		return this.getSqlMapClientTemplate().queryForList("queryStats",conditions);
	}

	@Override
	public List<Map<String, Object>> queryStatsSchool(Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("queryStatsSchool",conditions);
	}

	@Override
	public List<Map<String, Object>> queryStatsFuther(
			Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("queryStatsFuther",conditions);
	}
	
	@Override
	public EduProjectProcess selectProcessById(Integer id) {
		return  (EduProjectProcess)this.getSqlMapClientTemplate().queryForObject("process_selectByPrimaryKey", id);
	}

	@Override
	public List<EduProjectProcess> selectProcessByParam(EduProjectProcess epp) {
		return this.getSqlMapClientTemplate().queryForList("process_selectByClause",epp);
	}
	
	@Override
	public boolean downLvAreaHasAllocated(int areaId,int projectId) throws Exception{
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("areaId", areaId);
		params.put("projectId", projectId);
//		return (Integer)this.getSqlMapClientTemplate().queryForObject("all_down_lv_allocated", params)>0?true:false;
		return (Integer)this.getSqlMapClientTemplate().queryForObject("all_down_lv_allocated4", params)>0?false:true;
	}
	
	@Override
	public boolean downLvSchoolHasAllocated(int areaId,int projectId) throws Exception{
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("areaId", areaId);
		params.put("projectId", projectId);
//		return (Integer)this.getSqlMapClientTemplate().queryForObject("all_down_lv_allocated2", params)>0?true:false;
		return (Integer)this.getSqlMapClientTemplate().queryForObject("all_down_lv_allocated3", params)>0?false:true;
	}
	@Override
	public boolean hasAllocate(Map<String,Object> params) throws Exception{
		return (Integer)this.getSqlMapClientTemplate().queryForObject("has_allocate_gt0",params)>0?true:false;
	}
	
	@Override
	public boolean selectCountOrgAndProject(Map<String,Object> params) throws Exception{
		return (Integer)this.getSqlMapClientTemplate().queryForObject("countOrgAndProject",params)>0?true:false;
	}

	@Override
	public List<EduProject> selectshishijigou() throws Exception {
	
		return this.getSqlMapClientTemplate().queryForList("suoyoushihsijigou");
	}

	

	@Override
	public int countTeacherByAreaes(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlMapClientTemplate().queryForObject("TeacherListByArea",param);
	}

	

	@Override
	public int ProjectByRegistrationCount(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlMapClientTemplate().queryForObject("ProjectByRegistrationCount",conditions);
	}

	@Override
	public List<EduProject> ProjectByRegistration(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("ProjectByRegistration",conditions);
	}
	

	@Override
	public int districtAuditCount(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return (Integer)this.getSqlMapClientTemplate().queryForObject("districtAuditCount",conditions);
	}

	@Override
	public List<EduProjectAudit> districtAudit(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("districtAudit",conditions);
	}

	@Override
	public Integer countProject(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return (Integer)this.getSqlMapClientTemplate().queryForObject("countProject",conditions);
	}

	/**
	 * 根据继教板块id得到项目列表
	 * @author liuyiyou
	 * @param eduModelType
	 * @return List<EduProject>
	 */
	@Override
	public List<EduProject> getEduProjectByEduModelType(String eduModelType) {
		return this.getSqlMapClientTemplate().queryForList("getProjectByEduModelType", eduModelType);
	}

	@Override
	public List<EduProjectAudit> cityAudit(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("cityAudit",conditions);
	}
	
	@Override
	public int cityAuditCount(Map<String, Object> conditions) throws Exception {
		// TODO Auto-generated method stub
		return (Integer)this.getSqlMapClientTemplate().queryForObject("cityAuditCount",conditions);
	}

	@Override
	public int provinceAuditCount(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return (Integer)this.getSqlMapClientTemplate().queryForObject("provinceAuditCount",conditions);
	}

	

	@Override
	public List<EduProjectAudit> provinceAudit(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("provinceAudit",conditions);
	}

	@Override
	public List<Integer> selectSchoolIdByArea(int areaId, int projectId) {
		return this.getSqlMapClientTemplate().queryForList("select_school_id_by_area",areaId,projectId);
	}

	@Override
	public List<Integer> selectSchoolIdByArea(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("select_school_id_by_area",param);
	}

	@Override
	public List<OrgProTeacherActivity> downTeacherExcl(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("downTeacherExcl",paramMap);
	}

	@Override
	public String qryModelInfo(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		Object result = this.getSqlMapClientTemplate().queryForObject("select_model_max_id",paramMap);
		if(result != null){
			return result.toString();
		}else{
			return null;
		}
	}

	@Override
	public List<EduProjectCommentTeacher> queryProjectCommentTeachers(int projectId) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("queryProjectCommentTeachers",projectId);
	}

	@Override
	public EduProjectCommentTeacher selectTeacherCommentfoById(
			Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return (EduProjectCommentTeacher)this.getSqlMapClientTemplate().queryForObject("selectTeacherCommentfoById",paramMap);
	}

	@Override
	public EduProjectPojo selectprojectInfo(Map<String, Object> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return (EduProjectPojo)this.getSqlMapClientTemplate().queryForObject("selectprojectInfo",paramMap);
	}

	public List<EduModel> selectAllModelList(Map<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("select_model_all_list");
	}

	@Override
	public Integer checkIsForcePaper(Map<String, Object> conditions) {
		// TODO Auto-generated method stub
		return (Integer)this.getSqlMapClientTemplate().queryForObject("count_check_is_force_paper",conditions);
	}

	@Override
	public int selectCountTeacherProjectList(Map<String, Object> conditions)
			throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("count_select_teacher_project_list",conditions);
	}

	@Override
	public List<EduProject> selectTeacherProjectList(
			Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_teacher_project_list",conditions);
	}

	public Integer getAllProjectComment(Map<String, Object> paraMap) throws Exception {
		// TODO Auto-generated method stub
		return (Integer)this.getSqlMapClientTemplate().queryForObject("select_project_comments",paraMap);
	}

	/**
	 * 培训结果审核下的项目count
	 */
	@Override
	public int selectCountProjectForAuditTeacher(Map<String, Object> conditions) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("count_teacher_train_result_list",conditions);
	}

	/**
	 * 培训结果审核下的项目列表
	 */
	@Override
	public List<EduTeacherAudit> selectProListForAuditTeacher(Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("teacher_train_result_list",conditions);
	}

	/**
	 * 查询指定继教版块下的项目ids
	 */
	@Override
	public List<Integer> selectProjectIdsByModelId(Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_project_ids_by_modelId",conditions);
	}

	@Override
	public int countCreditLendForAudit(Map<String, Object> params)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_credit_lend_for_audit", params);
		return obj==null?0:(Integer)obj;
	}

	@Override
	public List<EduProjectForAudit> selectCreditLendForAudit(
			Map<String, Object> params) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_credit_lend_for_audit",params);
		}

	@Override
	public List<EduProject> getSpecialProject(Map<String, Object> params) {
		return this.getSqlMapClientTemplate().queryForList("select_special_project",params);
	}

	@Override
	public List<Integer> selectProjectIdsConditions(
			Map<String, Object> condition) {
		return this.getSqlMapClientTemplate().queryForList("select_projectIds_by_condition",condition);
	}
}
