package project.edupm.projectmanage.dao;

import java.util.List;
import java.util.Map;

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


/**
 * 项目管理
 * 
 * @Create_by:zhangBo
 * @Create_date:2014-3-26
 * @Last_Edit_By:
 * @Edit_Description
 * @version:1.0
 * 
 */
public interface IEduProjectReadDAO {
	
	public List<EduTeacherProject> selectEduTeacherProjByParam(Map<String,Object> param);
	public Integer selectEduTeacherProjCountByParam(Map<String,Object> param);
	/***
	 * 根据对应参数查询项目
	 * @author 姚吟
	 * @param param
	 * @return
	 */
	public List<EduProject> selectProjectByParam(Map<String,Object> param);
	/**
	 * 根据对应参数查询项目的数量
	 * @author 姚吟
	 * @param param
	 * @return
	 */
	public Integer selectProjectCountByParam(Map<String,Object> param);
	/**
	 * 条件查询
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public List<EduProject> selectProjectList(Map<String,Object> conditions) throws Exception;
	
	List<EduProject> selectProjectListByStatus(Map<String,Object> conditions) throws Exception;
	List<EduProject> ProjectByRegistration(Map<String,Object> conditions) throws Exception;
	List<EduProject> selectProjectListByStatusUpdate(Map<String,Object> conditions) throws Exception;
	/**
	 * 项目培训成绩公布列表查询
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	List<EduProject> selectProjectPublicListByStatus(Map<String,Object> conditions) throws Exception;
	
	List<EduProject> selectSuccessProjectList(Map<String,Object> conditions)throws Exception;
	
	public int selectCountByConditions(Map<String,Object> conditions) throws Exception;
	
	/**
	 * 教师报名审核列表-count
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public int selectCountProListForAudit(Map<String,Object> conditions) throws Exception;
	
	/**
	 * 待审核项目id
	 */
	public List<Integer> selectUnAuditProjectIds(Map<String,Object> conditions) throws Exception;
	
	/**
	 * 已完成审核项目id
	 */
	public List<Integer> selectHasFinishedAuditProjectIds(Map<String,Object> conditions) throws Exception;
	
	public int districtAuditCount(Map<String,Object> conditions) throws Exception;
	public int cityAuditCount(Map<String,Object> conditions) throws Exception;
	public int provinceAuditCount(Map<String,Object> conditions) throws Exception;
	
	
	public EduProjectDTO selectProFullInfoById(int proId) throws Exception;
	
	public EduProject selectBaseInfoById(int proId) throws Exception;
	
	
	List<EduProjectAudit> selectProListForAudit(Map<String, Object> conditions) throws Exception; 
	List<EduProjectAudit> districtAudit(Map<String, Object> conditions) throws Exception; 
	List<EduProjectAudit> cityAudit(Map<String, Object> conditions) throws Exception; 
	List<EduProjectAudit> provinceAudit(Map<String, Object> conditions) throws Exception; 
	List<EduProjectAudit> selectProListForAuditSH(Map<String, Object> conditions) throws Exception; 
	
	List<OrgProTeacherActivity> selectTeacherByProjectId(Map<String, Object> params) throws Exception;
	
	public List<OrgProTeacherActivity> downTeacherExcl(Map<String, Object> paramMap)throws Exception;
	int selectCountTeacherForAudit(Map<String, Object> params) throws Exception;
	
	String selectUnpassReason(int id) throws Exception;
	
	int selectCountForSetSignWay(int projectId) throws Exception;
	
	/**
	 * 判断机构是否已经被分配
	 * @param params  key:projectId,organizationId
	 * @return
	 * @throws Exception
	 */
	int selectCountForAllocate(Map<String,Object> params) throws Exception;
	
	/**
	 *  之前是得到eud_project_comment的id集合，现在改成得到eud_project_comment的teacher_id的集合 
	因为在service中调用该方法的名字叫：getAllTeachers，不知道之前开发人员怎么命名的，
	还有就是为什么要去掉后面的那些isNotEmpty,如果不传递该参数，下面的压根运行不到
	再有就是，为什么分页和不分页需要些两个查询？可以根据传递的startIndex或者其他参数来判断是否是分页啊
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<String> selectAllTeacherRecord(Map<String,Object> params) throws Exception;
	
	List<String> selectAllOrgByProjectId(int projectId) throws Exception;
	
	List<String> selectProjectNo() throws Exception;
	
	
	List<String> selectTrainProjectNo(Integer type) throws Exception;
	
	/**
	 * 通过项目ID查出所有报名教师的ID
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	List<Integer> selectTeacherIdsByProjectId(int projectId) throws Exception;
	
	/**
	 * 查询教师导入记录
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<EduTeacherImportRecord> selectTeacherImprotRecord(Map<String,Object> params) throws Exception;
	
	/**
	 * new_实施机构项目列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int coutImportTeacherRecord(Map<String,Object> param) throws Exception;
	
	public int selectModelCountByParamMap(Map<String,Object> paramMap) throws Exception;
	
	/**
	 * 继教信息板块
	 * @author yinxiaolong
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<EduModel> selectModelList(Map<String,Object> params) throws Exception;
	public String qryModelInfo(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 项目中已经使用到的继教板块id集合
	 * @author liuyiyou
	 * @return
	 * @throws Exception
	 */
	public List<Integer> selectModelListIds() throws Exception;
	
	
	/**
	 * 继教信息板块编辑、查看
	 * @author yinxiaolong
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EduModel selectModelInfoById(int id) throws Exception;
	/**
	 * new_实施机构项目数量
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	int countProjectByStatus(Map<String, Object> conditions) throws Exception;
	int ProjectByRegistrationCount(Map<String, Object> conditions) throws Exception;
	int countProjectByStatusPage(Map<String, Object> conditions) throws Exception;
	/**
	 * 查询成绩公布项目列表count
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	int countProjectPublicByStatus(Map<String, Object> conditions) throws Exception;
	
	int countProjectSuccess(Map<String, Object> conditions)throws Exception;
	
	/**
	 * 实施机构项目审核通过数量 
	 * @author yinxiaolong
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	int countProjectSuccessByStatus(Map<String, Object> conditions) throws Exception;
	/**
	 * 问卷数量
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public int selectPaperCountByConditions(Map<String, Object> conditions)
			throws Exception;
	/**
	 * 调查问卷列表
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public List<EduPaper> selectPaperListByPid(Map<String, Object> conditions)throws Exception ;
	
	/**
	 * 获得一个问卷
	 * @param papId
	 * @return
	 * @throws Exception
	 */
	public EduPaper selectEduPaperById(int papId) throws Exception ;
	/**
	 * 获得一个题干
	 * @param eqId
	 * @return
	 * @throws Exception
	 */
	public EduQuestion selectEduQuestionById(int eqId) throws Exception ;
	/**
	 * 获得一个题选项
	 * @param eqoId
	 * @return
	 * @throws Exception
	 */
	public EduQuestionOptions selectEduQuestionOptionsById(int eqoId) throws Exception ;

	/**
	 * 通过问卷id获得题干列表
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public List<EduQuestion> selectEduQuestionListByPapid(
			Map<String, Object> conditions) throws Exception;
    /**
     * 通过题干id获得题选项列表
     * @param conditions
     * @return
     * @throws Exception
     */
	public List<EduQuestionOptions> selectEduQuestionOptionsListByQid(
			Map<String, Object> conditions) throws Exception;
	/**
	 * 通过问卷id获得题干总数
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public int selectEduQuestionCountByConditionsByPapid(
			Map<String, Object> conditions) throws Exception;
	  /**
     * 通过题干id获得题选项总数
     * @param conditions
     * @return
     * @throws Exception
     */
	public int selectEduQuestionOptionsCountByConditionsByQid(
			Map<String, Object> conditions) throws Exception;
	
	EduProjectAuditPOJO selectAuditInfo(int projectId) throws Exception;
	
	List<EduProjectAllocateByArea> selectAllocateByAreaId(int areaId,int projectId) throws Exception;
	
	int countAllocateByProject(EduProjectAllocateByArea allocate) throws Exception;
	
	EduProjectAllocateByArea selectAllocate(EduProjectAllocateByArea allocate) throws Exception;
	
	List<EduProjectAllocateByArea> selectSchool(int areaId,int projectId) throws Exception;

	/**
	 * 查询单个答券
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EduResponse selectEduResponseById(Integer id) throws Exception;

	/**
	 *  查询单个答题详细
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EduResponseQuestion selectEduResponseQuestionById(Integer id)
			throws Exception;

	/**
	 * 查询答券数
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public int countEduResponseQuestionByCondition(
			Map<String, Object> conditions) throws Exception;

	/**
	 * 查询答题详细数
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public int countEduResponseByCondition(Map<String, Object> conditions)
			throws Exception;

	/**
	 * 查询答券分页
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public List<EduResponse> selectEduResponseListByCondition(
			Map<String, Object> conditions) throws Exception;

	/**
	 * 查询答券详细分页
	 * @param conditions
	 * @return
	 */
	public List<EduResponseQuestion> selectEduResponseQuestionListByCondition(
			Map<String, Object> conditions)	throws Exception;

	/**
	 * 实施机构 --> 承培机构任务分配列表总数查询
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int countSelectProjectsByStatus(Map<String, Object> paramMap)throws Exception;

	
	/**
	 * 实施机构 --> 承培机构任务分配列表查询
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<SsOrgProjectAuditActivity> selectProjectsByStatus(Map<String, Object> paramMap)throws Exception;
	
	/**
	 * 查询项目的所有实施机构
	 */
	public List<EduProject> selectshishijigou()throws Exception;
	
	
	public Integer  countProject(Map<String, Object> conditions)throws Exception;
	
	
	
	
	
	/**
	 * 通过地区查询教师
	 * @param areaId
	 * @return
	 * @throws Exception
	 */
	List<EduTeacherForReport> selectTeacherByArea(Map<String,Object> param) throws Exception;
	
	int countTeacherByArea(int areaId) throws Exception;
	int countTeacherByAreaes(Map<String,Object> param) throws Exception;
	
	/**
	 * 查询某地区已经报名某项目的教师
	 * @param param key:areaId,projectId
	 * @return
	 * @throws Exception
	 */
	List<EduProjectComment> selectTeacherByAreaAndProject(Map<String,Object> param) throws Exception;
	
	/**
	 * 项目审核通过列表
	 * @author yinxiaolong
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	List<EduProject> selectProjectSuccessListByStatus(Map<String,Object> conditions) throws Exception;
	
	/**
	 * 通过地区查询教师报名人数
	 * @param params key:areaId,projectId
	 * @return
	 * @throws Exception
	 */
	int countTeacherByAreaAndProject(Map<String,Object> params) throws Exception;
	
	/**
	 * 通过地区和项目查询非配名额
	 * @param param
	 * @return
	 * @throws Exception
	 */
	EduProjectAllocateByArea selectAllocateByAreaAndProject(Map<String,Object> param) throws Exception;
	
	/**
	 * 启动项目和培训项目关闭列表--查询项目报名情况
	 * @param status
	 * @return
	 * @throws Exception
	 */
	List<EduProject> selectProjectByStatusForStart(Map<String,Object> param) throws Exception;
	/**
	 * 启动项目列表
	 * @return
	 */
	int countProjectByStatusForStart(Map<String,Object> param) throws Exception;
	
	EduOrgProjectStatus selectOrgProjectStatus(int projectId) throws Exception;
	
	List<EduModelPOJO> selectModelNoPage(Map<String, Object> param) throws Exception;
	
	/**
	 * 获取项目培训对象属性
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	public CanSign selectCanSginProject(Integer projectId) throws Exception;
	
	/**
	 * 获取教师--项目培训对象属性
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	public List<CanSign> selectCanSginTeacher(Integer id) throws Exception;
	
	boolean hasReport(int projectId,int type,int areaId) throws Exception;
	
	EduProjectAllocateByArea selectSumNumByUpLvId(int projectId,int type,int areaId) throws Exception;
	
	EduProjectAllocateByArea selectSchoolSumNumByUpLvId(int projectId,int type,int areaId) throws Exception;
	
	/**
	 * 查询项目审核记录
	 * @param projectId 项目ID
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public List<EduProjectAuditPOJO> selectProjectAudit(int projectId) throws Exception;
	/**
	 * 已经分配的地区ID
	 * @param projectId
	 * @param ids
	 * @param type
	 * @return
	 * @throws Exception
	 */
	List<Integer> selectAreaIdsHasAllocate(int projectId,List<Integer> ids,int type) throws Exception;
	
	/**
	 * 查询上报名额详情
	 * @param queryMap 查询条件
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public List<ProjectReportInfo> selectProjectReportInfo(Map<String, Object> queryMap) throws Exception;
	
	List<EduProjectForAudit> selectProjectForAudit(Map<String,Object> params) throws Exception;
	
	int countProjectForAudit(Map<String,Object> params) throws Exception;
	
	List<Integer> selectSchoolIdByArea(int areaId) throws Exception;
	
	int selectCountProjectForAudit(Map<String, Object> conditions) throws Exception;
	
	/**
	 * 设置兑换规则-- 模块列表
	 * @param modelName
	 * @return
	 * @throws Exception
	 */
	List<EduModel> selectEduModelForSet(Map<String,Object> params) throws Exception;
	
	int selectCountEduModelForSet(Map<String,Object> param) throws Exception;
	
	List<EduProject> selectProjectByAuditStatus(Map<String,Object> param) throws Exception;
	
	int countProjectByAuditStatus(Map<String,Object> param) throws Exception;
	
	boolean hasSign(int teacherId,int projectId) throws Exception;
	List<Integer> selectGroupYear() throws Exception;
	
	public List<Map<String, Object>> queryStats(Map<String, Object> conditions)throws Exception;
	public List<Map<String, Object>> queryStatsSchool(Map<String, Object> conditions)throws Exception;
	public List<Map<String, Object>> queryStatsFuther(Map<String, Object> conditions)throws Exception;
	
	public List<EduProjectAllocateByArea> selectSchool(int areaId,int projectId,String schoolName) throws Exception;
	public List<EduProjectAllocateByArea> selectSchooles(int areaId,int projectId,String schoolName,Integer schoolTypeId) throws Exception;
    
	public EduProjectProcess selectProcessById(Integer id);
	
	public List<EduProjectProcess> selectProcessByParam(EduProjectProcess epp);
	List<Object> selectProjectListByCondition(Map<String, Object> conditions)
			throws Exception;
	boolean downLvAreaHasAllocated(int areaId, int projectId) throws Exception;
	boolean downLvSchoolHasAllocated(int areaId, int projectId)
			throws Exception;
	boolean hasAllocate(Map<String, Object> params) throws Exception;
	List<EduProject> selectProjectListByStatus(Map<String, Object> conditions,
			String queryFlag) throws Exception;
	int countProjectByStatus(Map<String, Object> conditions, String queryFlag)
			throws Exception;
	boolean selectCountOrgAndProject(Map<String, Object> params)
			throws Exception;
	public List<Object> selectProjectListByCreateBy(
			Map<String, Object> conditions);
	public List<String> selectProjectName() throws Exception;
	
	public List<String> selectTrainProjectName(Integer type) throws Exception;
	
	/**
	 * 根据继教板块id得到项目列表
	 * @author liuyiyou
	 * @param eduModelType
	 * @return List<EduProject>
	 */
	public List<EduProject> getEduProjectByEduModelType(String eduModelType);
	List<EduProjectAllocateByArea> selectSchool(int areaId, int projectId,
			int schoolId) throws Exception;
	public List<Integer> selectSchoolIdByArea(int areaId, int projectId);
	public List<Integer> selectSchoolIdByArea(Map<String, Object> param);
	public List<EduProjectCommentTeacher> queryProjectCommentTeachers(
			int projectId);
	public EduProjectCommentTeacher selectTeacherCommentfoById(Map<String, Object> paramMap)throws Exception;
	
	public EduProjectPojo selectprojectInfo(Map<String, Object> paramMap)throws Exception;
	public List<EduModel> selectAllModelList(Map<String, Object> map)throws Exception;
	/**
	 * 检查是否强制提交调查问卷
	 * @param conditions
	 * @return
	 */
	public Integer checkIsForcePaper(Map<String, Object> conditions);
	
	/**
	 * 教师成绩查询下的项目count
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	int selectCountTeacherProjectList(Map<String, Object> conditions) throws Exception;
	
	/**
	 * 教师成绩查询下的项目列表
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	List<EduProject> selectTeacherProjectList(Map<String,Object> conditions) throws Exception;
	
	/**
	 * 查询同一继教板块下的所有学员信息
	 * @param paraMap
	 * @return
	 */
	public Integer getAllProjectComment(Map<String, Object> paraMap) throws Exception;
	
	/**
	 * 培训结果审核下的项目count
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	int selectCountProjectForAuditTeacher(Map<String, Object> conditions) throws Exception;
	
	/**
	 * 培训结果审核下的项目列表
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	List<EduTeacherAudit> selectProListForAuditTeacher(Map<String, Object> conditions) throws Exception;
	
	/**
	 * 查询指定继教版块下的项目ids
	 */
	public List<Integer> selectProjectIdsByModelId(Map<String,Object> param) throws Exception;
	
	/**
	 * 教师借贷学分数量
	 */
	int countCreditLendForAudit(Map<String,Object> params) throws Exception;
	/***
	 * 教师借贷学分列表查询
	 */
	List<EduProjectForAudit> selectCreditLendForAudit(Map<String,Object> params) throws Exception;
	
	/**
	 * 教师特殊研修项目
	 */
	public List<EduProject> getSpecialProject(Map<String, Object> params);
	
	/**
	 * 查询项目ids
	 * @param condition
	 * @return
	 */
	public List<Integer> selectProjectIdsConditions(
			Map<String, Object> condition);
}
