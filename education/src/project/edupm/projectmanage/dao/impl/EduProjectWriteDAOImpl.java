package project.edupm.projectmanage.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.SqlMapClientCallback;

import project.common.Common;
import project.edupm.projectmanage.dao.IEduProjectReadDAO;
import project.edupm.projectmanage.dao.IEduProjectWriteDAO;
import project.edupm.projectmanage.pojo.EduPaper;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduProjectAllocateByArea;
import project.edupm.projectmanage.pojo.EduProjectAuditPOJO;
import project.edupm.projectmanage.pojo.EduProjectProcess;
import project.edupm.projectmanage.pojo.EduProjectTrainTarget;
import project.edupm.projectmanage.pojo.EduQuestion;
import project.edupm.projectmanage.pojo.EduQuestionOptions;
import project.edupm.projectmanage.pojo.EduResponse;
import project.edupm.projectmanage.pojo.EduResponseQuestion;
import project.edupm.projectmanage.pojo.EduTeacherImportHistory;
import project.organization.pojo.Organization;
import project.teacher.teachermanage.dao.ITeacherReadDao;
import project.teacher.teachermanage.pojo.EduProjectCommentTeacher;

import com.ibatis.sqlmap.client.SqlMapExecutor;

import framelib.dao.BaseDAOImpl;

public class EduProjectWriteDAOImpl  extends BaseDAOImpl implements IEduProjectWriteDAO{
	
	@Autowired
	@Qualifier("teacherReadDao")
	ITeacherReadDao teacherReadDao;

	@Autowired
	@Qualifier("eduProjectReadDAO")
	IEduProjectReadDAO eduProjectReadDAO;

	@Override
	public boolean updateProject(EduProject pro) throws Exception {
		int i = this.getSqlMapClientTemplate().update("pro_updateByPrimaryKeySelective",pro);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public int insertProject(EduProject pro) throws Exception {
		Object object = this.getSqlMapClientTemplate().insert("pro_insert",pro);
		if(object != null){
			return Integer.parseInt(object.toString());
		}
		return 0;
	}

	@Override
	public boolean insertProjectTrainTarget(EduProjectTrainTarget target)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("train_target_insert",target);
		if(obj == null){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProjectById(int proId) throws Exception {
		int i = this.getSqlMapClientTemplate().update("del_pro",proId);
		if(i>0){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateProSignUpWay(Map<String, Object> params)
			throws Exception {
		int i = this.getSqlMapClientTemplate().update("set_pro_sign_up_way",params);
		if(i >0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateTrainTargetById(EduProjectTrainTarget target)
			throws Exception {
		int i = this.getSqlMapClientTemplate().update("target_updateByPrimaryKeySelective",target);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateComment(Map<String, Object> params) throws Exception {
		int i = this.getSqlMapClientTemplate().update("update_teacher_info",params);
		if(i >0){
			return true;
		}
		return false;
	}
	/*
	 * 取消报名
	 * wych
	 */
	@Override
	public boolean deleteTeacher(String projectId,int teacherId,int schoolId) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Integer schoolID=schoolId;
		paramMap.put("teacherId", teacherId);
		paramMap.put("projectId", projectId);
		if(schoolID!=0 && schoolID!=null){
			paramMap.put("schoolId", schoolID);
		}
		
		int i = this.getSqlMapClientTemplate().delete("deleteTeacher",paramMap);
		if(i >0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProjectStatus(Map<String, Object> params)
			throws Exception {
		int i = this.getSqlMapClientTemplate().update("update_project_status",params);
		if(i>0){
			return true;
		}
		return false;
	}

	//教师报名批量审核
	@Override
	public boolean batchAudit(final String[] ids, final Map<String, Object> params) throws Exception {
		Object obj = this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {

			@Override
			public Object doInSqlMapClient(SqlMapExecutor arg0) throws SQLException {
				arg0.startBatch();
				for(String id:ids){
					params.put("commentId", id);
					arg0.update("update_teacher_info",params);
				}
				return arg0.executeBatch();
			}
		});
		if(obj != null){
			int i = (Integer)obj;
			if(i>0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean updateAudit(final String[] ids,final  Map<String, Object> params)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {

			@Override
			public Object doInSqlMapClient(SqlMapExecutor arg0) throws SQLException {
				arg0.startBatch();
				for(String id:ids){
					params.put("id", id);
					arg0.update("update_audit_info",params);
				}
				return arg0.executeBatch();
			}
		});
		if(obj != null){
			int i = (Integer)obj;
			if(i>0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	@Override
	public boolean deleteOPById(int id) throws Exception {
		int i = this.getSqlMapClientTemplate().delete("cancel_OP_by_id",id);
		if(i > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean insertCommentBatch(final List<Integer> ids, final int projectId,final String account,final String type)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {

			@Override
			public Object doInSqlMapClient(SqlMapExecutor arg0) throws SQLException {
				arg0.startBatch();
				for(int id:ids){
					final Map<String,Object> param = new HashMap<String,Object>();
					param.put("projectId", projectId);
					param.put("account", account);
					param.put("type", type);
					param.put("status", Common.COMMON_AUDIT_UNHANDL);
					param.put("teacherId", id);
					param.put("version", teacherReadDao.selectTeacherAllVersion(id).getUserVersion());
					
					try {
						param.put("organizationId", eduProjectReadDAO.selectBaseInfoById(projectId).getOrganizationId());
					} catch (Exception e) {}
					
					arg0.insert("batch_sign_up", param);
				}
				
				return arg0.executeBatch();
			}
			
		});
		if(obj != null && (Integer)obj>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean insertImportTeacherHistory(EduTeacherImportHistory history)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("insert_import_history",history);
		if(obj == null){
			return true;
		}
		return false;
	}

	@Override
	public boolean insertModelInfo(Map<String, Object> paramMap)
			throws Exception {
		Object object = this.getSqlMapClientTemplate().insert("model_insert",paramMap);
		if(object == null){
			return true;
		}
		return false;
	}
	
	@Override
	public String checkModelName(String modelName) throws Exception{
		Object result = this.getSqlMapClientTemplate().queryForObject("checkModelName",modelName);
		if(result != null){
			return result.toString();
		}else{
			return null;
		}
		
	}
	
	@Override
	public String checkModelName(Map<String, Object> paramMap) throws Exception {
		Object result = this.getSqlMapClientTemplate().queryForObject("checkModelNameInEdit",paramMap);
		if(result != null){
			return result.toString();
		}else{
			return null;
		}
	}


	
	
	@Override
	public String checkModelCode(String modelCode) throws Exception{
		Object result = this.getSqlMapClientTemplate().queryForObject("checkModelCode",modelCode);
		if(result != null){
			return result.toString();
		}else{
			return null;
		}
		
	}
	
	
	@Override
	public String checkModelCode(Map<String, Object> paramMap) throws Exception {
		Object result = this.getSqlMapClientTemplate().queryForObject("checkModelCodeInEdit",paramMap);
		if(result != null){
			return result.toString();
		}else{
			return null;
		}
	}

	
	
	@Override
	public int insertPaper(EduPaper eduPaper) throws Exception {
		Object object = this.getSqlMapClientTemplate().insert("eduPaper_insert",eduPaper);
		if(object != null){
			return Integer.parseInt(object.toString());
		}
		return 0;
	}

	@Override
	public int insertQuestion(EduQuestion eduQuestion) throws Exception {
		Object object = this.getSqlMapClientTemplate().insert("eduQuestion_insert",eduQuestion);
		if(object != null){
			return Integer.parseInt(object.toString());
		}
		return 0;
	}

	@Override
	public int insertQuestionOptions(EduQuestionOptions eduQuestionOptions)
			throws Exception {
		Object object = this.getSqlMapClientTemplate().insert("eduQuestionOptions_insert",eduQuestionOptions);
		if(object != null){
			return Integer.parseInt(object.toString());
		}
		return 0;
	}

	@Override
	public boolean updatePaper(EduPaper eduPaper) throws Exception {
		int i = this.getSqlMapClientTemplate().update("eduPaper_updateByPrimaryKeySelective",eduPaper);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateQuestion(EduQuestion eduQuestion) throws Exception {
		int i = this.getSqlMapClientTemplate().update("eduQuestion_updateByPrimaryKeySelective",eduQuestion);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateQuestionOptions(EduQuestionOptions eduQuestionOptions)
			throws Exception {
		int i = this.getSqlMapClientTemplate().update("eduQuestionOptions_updateByPrimaryKeySelective",eduQuestionOptions);
		if(i>0){
			return true;
		}
		return false;
	}
	
	/**
	 * 保存项目审核记录
	 */
	@Override
	public boolean insertProjectAudit(EduProjectAuditPOJO audit)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("insert_project_audit",audit);
		if(obj == null){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProjectAudit(EduProjectAuditPOJO audit)
			throws Exception {
		audit.setId((Integer)this.getSqlMapClientTemplate().queryForObject("select_max_audit_id",audit.getProjectId()));
		return this.getSqlMapClientTemplate().update("update_audit_by_conditions",audit)>0?true:false;
	}

	@Override
	public boolean updateModelInfo(Map<String,Object> paramMap) throws Exception {
		int result = this.getSqlMapClientTemplate().update("update_model_info",paramMap);
		if(result>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean insertAllocate(EduProjectAllocateByArea allocate)
			throws Exception {
		return this.getSqlMapClientTemplate().insert("insert_allocate",allocate) == null?true:false;
	}

	@Override
	public boolean updateAllocate(EduProjectAllocateByArea allocate)
			throws Exception {
		return this.getSqlMapClientTemplate().update("update_allocate_ByPrimaryKeySelective",allocate)>0?true:false;
	}
	@Override
	public int insertResponse(EduResponse eduResponse) throws Exception {
		Object object = this.getSqlMapClientTemplate().insert("eduResponse_insert",eduResponse);
		if(object != null){
			return Integer.parseInt(object.toString());
		}
		return 0;
	}
	@Override
	public boolean updateResponse(EduResponse eduResponse) throws Exception {
		int result = this.getSqlMapClientTemplate().update("eduResponse_updateByPrimaryKeySelective",eduResponse);
		if(result>0){
			return true;
		}
		return false;
	}
	@Override
	public int insertResponseQuestion(EduResponseQuestion responseQuestion) throws Exception {
		Object object = this.getSqlMapClientTemplate().insert("eduResponseQuestion_insert",responseQuestion);
		if(object != null){
			return Integer.parseInt(object.toString());
		}
		return 0;
	}
	@Override
	public boolean updateResponseQuestion(EduResponseQuestion responseQuestion) throws Exception {
		int result = this.getSqlMapClientTemplate().update("eduResponseQuestion_updateByPrimaryKeySelective",responseQuestion);
		if(result>0){
			return true;
		}
		return false;
	}

	
	/**
	 * 指定承培机构
	 */
	@Override
	public boolean insertProForOrg(final String account, final int projectId, final List<Organization> list) throws Exception {
		Object obj = this.getSqlMapClientTemplate().execute(
				new SqlMapClientCallback<Object>() {
					public Object doInSqlMapClient(SqlMapExecutor arg0)throws SQLException {
						arg0.startBatch();
						for (Organization org : list) {
							Map<String, Object> paramMap = new HashMap<String, Object>();
							paramMap.put("projectId", projectId);
							paramMap.put("orgId", org.getOrganizationId());
							paramMap.put("orgName", org.getOrganizationName());
							paramMap.put("account", account);
							paramMap.put("trainingHomeAddress", org.getTrainingHomeAddress());
							paramMap.put("trainingAddress", org.getTrainingAddress());
							paramMap.put("classSubjectId", org.getSubjectIds());
							paramMap.put("classSubjectName", org.getSubjectName());
							paramMap.put("planNum", org.getPlanNum());
							paramMap.put("areaCode", org.getAreaCode());
							paramMap.put("areaName", org.getAreaName());
							arg0.update("insertProForOrg", paramMap);
						}
						arg0.executeBatch();
						return null;
					}
				});
		if (obj == null) {
			return true;// 插入成功
		} else {
			return false;
		}
	}

	
	@Override
	public boolean updateTeacherScore(Map<String, Object> conditions)
			throws Exception {
		int result = this.getSqlMapClientTemplate().update("updateTeacherScore_by_modify_score",conditions);
		if(result>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean updateTeacherScores(Map<String, Object> conditions)
			throws Exception {
		int result = this.getSqlMapClientTemplate().update("updateTeacherScore_by_modify_scores",conditions);
		if(result>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean ScoreBatchUpdate(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		String updateMethod=conditions.get("method").toString();
		if(updateMethod.equalsIgnoreCase("add")){
			return  ScoreBatchUpdateByAdd( conditions);
		}else if(updateMethod.equalsIgnoreCase("sub")){
			return  ScoreBatchUpdateBySub( conditions);
		}else if(updateMethod.equalsIgnoreCase("give")){
			return  ScoreBatchUpdateByGive( conditions);
		}else if(updateMethod.equalsIgnoreCase("modifyPeriod")){
			return  ScoreBatchUpdatePeriod( conditions);
		}
				
		return false;
	}

	private boolean ScoreBatchUpdatePeriod(Map<String, Object> conditions) {
		int result = this.getSqlMapClientTemplate().update("ScoreBatchUpdateByModifyPeriod",conditions);
		if(result>0){
			return true;
		}
		return false;
	}

	private boolean ScoreBatchUpdateByGive(Map<String, Object> conditions) {
		int result = this.getSqlMapClientTemplate().update("ScoreBatchUpdateByGive",conditions);
		if(result>0){
			return true;
		}
		return false;
	}

	private boolean ScoreBatchUpdateBySub(Map<String, Object> conditions) {
		int result = this.getSqlMapClientTemplate().update("ScoreBatchUpdateBySub",conditions);
		if(result>0){
			return true;
		}
		return false;
	}

	private boolean ScoreBatchUpdateByAdd(Map<String, Object> conditions) {
		int result = this.getSqlMapClientTemplate().update("ScoreBatchUpdateByAdd",conditions);
		if(result>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProjectByProjectId(int projectId) throws Exception {
		return this.getSqlMapClientTemplate().update("update_project_stop_sign",projectId)>0?true:false;
	}

	@Override
	public boolean updateAllocateByAreaIds(int projectId, List<Integer> areaIds,int type)
			throws Exception {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("projectId", projectId);
		params.put("ids", areaIds);
		params.put("type", type);
		int num = this.getSqlMapClientTemplate().update("update_allocate_by_areaIds",params);
		return num>0?true:false;
	}

	@Override
	public boolean bathInsertAllocate(final List<EduProjectAllocateByArea> list)
			throws Exception {
		
		Object obj = this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>(){
			public Object doInSqlMapClient(SqlMapExecutor arg0)throws SQLException {
				arg0.startBatch();
				for (EduProjectAllocateByArea aba : list) {
					arg0.insert("insert_allocate",aba);
				}
				return arg0.executeBatch();
			}
		});
		Log.info(obj.toString());
		return obj==null?false:(Integer)obj>0?true:false;
	}

	@Override
	public boolean updateProjectStatus(int id, int status)
			throws Exception {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("status", status);
		int result = this.getSqlMapClientTemplate().update("update_project_status_byId",paramMap);
		if(result>0){
			return true;
		}
		return false;
	}
	
	@Override
	public int countAllocateByProject(EduProjectAllocateByArea allocate)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_by_areaId_projectId",allocate);
		return obj==null?0:(Integer)obj;
	}
	
	/**
	 * 设置兑换规则
	 */
	@Override
	public boolean updateEduProjectRule(Map<String, Object> param) throws Exception {
		return this.getSqlMapClientTemplate().update("set_role",param)>0?true:false;
	}

	@Override
	public void updateProjectComment(Map<String, Object> conditions)
			throws Exception {
		String pubRule =  conditions.get("pubRule").toString();
		String publishRuleScore =  conditions.get("publishRuleScore").toString();
		if(pubRule.equalsIgnoreCase("0")){ //0.直接公布原始导入的成绩
			this.getSqlMapClientTemplate().update("update_score_rule_zero",conditions); //合格者,如果没有导入学时时修改其学时为项目学时
			this.getSqlMapClientTemplate().update("update_score_rule_zero_nopass",conditions);//不合格者且导入学时为null，学时修改为0
		}else if(pubRule.equalsIgnoreCase("1")){ //1.按 成绩公布
			this.getSqlMapClientTemplate().update("update_score_rule_one_tow_A",conditions); //合格
			this.getSqlMapClientTemplate().update("update_score_rule_one_tow_B",conditions); //不合格
			
		}else if(pubRule.equalsIgnoreCase("2")){ //1.按 合格否公布
			this.getSqlMapClientTemplate().update("update_score_rule_one_tow_A",conditions);//合格
			this.getSqlMapClientTemplate().update("update_score_rule_one_tow_B",conditions);//不合格
		}else if(pubRule.equalsIgnoreCase("3")){ //1.按等级公布
			String[] scores = publishRuleScore.split(",");
			String levelC = scores[0];//中
			String levelB = scores[1];//良好
			String levelA = scores[2];//优秀
			conditions.put("levelA", levelA);
			conditions.put("levelB", levelB);
			conditions.put("levelC", levelC);
			this.getSqlMapClientTemplate().update("update_score_rule_three_D",conditions); //差
			this.getSqlMapClientTemplate().update("update_score_rule_three_C",conditions); //中
			this.getSqlMapClientTemplate().update("update_score_rule_three_B",conditions); //良好
			this.getSqlMapClientTemplate().update("update_score_rule_three_A",conditions); //优秀
		}
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
	public Integer insertEduProjectProcess(EduProjectProcess eduProjectProcess) {
		Object obj = this.getSqlMapClientTemplate().insert("process_insert", eduProjectProcess);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}

	@Override
	public Integer updateEduProjectProcess(EduProjectProcess eduProjectProcess) {
		return this.getSqlMapClientTemplate().update("process_updateByPrimaryKeySelective", eduProjectProcess);
	}

	public Integer deleteModelInfoById(Integer id){
		return this.getSqlMapClientTemplate().delete("deleteModelInfoById",id);
	}

	@Override
	public boolean batchAuditTeacherScores(final String[] ids,final Map<String, Object> params) {
		Object obj = this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {

			@Override
			public Object doInSqlMapClient(SqlMapExecutor arg0) throws SQLException {
				arg0.startBatch();
				for(String id:ids){
					params.put("commentId", id);
					arg0.update("update_teacher_Score_info",params);
				}
				return arg0.executeBatch();
			}
		});
		if(obj != null){
			int i = (Integer)obj;
			if(i>0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean auditAllTeacherScores(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		int result =  this.getSqlMapClientTemplate().update("audit_all_teacher_scores", conditions);
		if(result>0){
			return true;
		}
		return false;
	}

	@Override
	public void updateProjectCommentTeachers(
			EduProjectCommentTeacher teacherInfo) throws Exception{
		// TODO Auto-generated method stub
		this.getSqlMapClientTemplate().update("updateProjectCommentTeachers",teacherInfo);
	}

	@Override
	public void updateProjectCommentTeachers(
			List<EduProjectCommentTeacher> eduList) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlMapClientTemplate().update("updateProjectCommentTeacherList",eduList);
	}

	@Override
	public void updateProjectCommentTeachers(Map<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		this.getSqlMapClientTemplate().update("updateProjectCommentTeacherMap",map);
	}

	public boolean updateProjectCertificateAll(Map<String, Object> param)
			throws Exception {
		// TODO Auto-generated method stub
		int result =  this.getSqlMapClientTemplate().update("updateProjectCertificateAll",param);
		if(result>0){
			return true;
		}
		return false;
	}

	public boolean updateTeacherProjectComment(Map<String, Object> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		int result =  this.getSqlMapClientTemplate().update("updateTeacherProjectComment",paramMap);
		if(result>0){
			return true;
		}
		return false;
	}

	/**
	 * 更新教师培训结果
	 */
	@Override
	public boolean updateProjectCommentTrainStatus(Map<String, Object> params) throws Exception {
		int i = this.getSqlMapClientTemplate().update("update_teacher_train_status",params);
		if(i >0){
			return true;
		}
		return false;
	}

	/**
	 * 根据项目ids更新教师学分
	 */
	@Override
	public boolean batchModifyTeacherScoresByProjectIds(Map<String, Object> params) throws Exception {
		int i = this.getSqlMapClientTemplate().update("update_teacher_score_by_proId",params);
		if(i >0){
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyTeacherClassScore(Map<String, Object> params) throws Exception {
		int i = this.getSqlMapClientTemplate().update("update_teacher_class_score",params);
		if(i >0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCreditLendStatus(Map<String, Object> params)
			throws Exception {
		int i = this.getSqlMapClientTemplate().update("update_credit_lend_status",params);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public int insertProjectComment(Map<String, Object> params) {
		return (Integer) this.getSqlMapClientTemplate().insert("insert_project_comment_special", params);
	}
}
