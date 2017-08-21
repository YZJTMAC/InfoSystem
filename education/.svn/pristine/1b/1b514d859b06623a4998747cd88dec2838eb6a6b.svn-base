package project.edupm.projectmanage.dao;

import java.util.List;
import java.util.Map;

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
public interface IEduProjectWriteDAO {
	
	
	/**
	 * 更新edu_project
	 * @param pro
	 * @return
	 * @throws Exception
	 */
	public boolean updateProject(EduProject pro) throws Exception;
	
	public int insertProject(EduProject pro) throws Exception;
	
	public boolean insertProjectTrainTarget(EduProjectTrainTarget target) throws Exception;
	
	public boolean updateProjectById(int proId) throws Exception;
	
	public boolean updateProSignUpWay(Map<String,Object> params) throws Exception;
	
	boolean updateTrainTargetById(EduProjectTrainTarget target) throws Exception;
	
	/**
	 * 更新教师报名审核状态
	 * @param params
	 * @return
	 * @throws Exception
	 */
	boolean updateComment(Map<String, Object> params) throws Exception;
	/**
	 * 取消报名
	 * @param params
	 * @return
	 * @throws Exception
	 */
	boolean deleteTeacher(String projectId,int teacherId,int schoolId) throws Exception;
	
	/**
	 * 更新项目状态
	 * @param params
	 * @return
	 * @throws Exception
	 */
	boolean updateProjectStatus(Map<String, Object> params) throws Exception;
	
	boolean batchAudit(String[] ids,Map<String, Object> params) throws Exception;
	boolean updateAudit(String[] ids,Map<String, Object> params) throws Exception;
	/**
	 * 删除项目分配的机构
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean deleteOPById(int id) throws Exception;
	
	boolean insertCommentBatch(List<Integer> ids,int projectId,String account,String type) throws Exception;
	
	boolean insertImportTeacherHistory(EduTeacherImportHistory history) throws Exception;
	
	boolean insertModelInfo(Map<String,Object> paramMap) throws Exception;
	
	/**
	 * 检查继教模块名称是否已经存在
	 * @author liuyiyou
	 */
	String checkModelName(String modelName) throws Exception;
	
	/**
	 * liuyiyou
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	String checkModelName(Map<String,Object> paramMap) throws Exception;
	
	/**
	 * @author liuyiyou
	 * 检查继教板块编码是否已经存在
	 * @param modelName
	 * @return
	 * @throws Exception
	 */
	String checkModelCode(String modelCode) throws Exception;
	
	/**
	 * liuyiyou
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	String checkModelCode(Map<String,Object> paramMap) throws Exception;
	
	boolean updateModelInfo(Map<String,Object> paramMap)throws Exception;
	/**
	 * 保存试卷
	 * @param eduPaper
	 * @return
	 * @throws Exception
	 */
	public int insertPaper(EduPaper eduPaper) throws Exception;
	/**
	 * 保存题干
	 * @param eduQuestion
	 * @return
	 * @throws Exception
	 */
	public int insertQuestion(EduQuestion eduQuestion) throws Exception;
	/**
	 * 保存题项
	 * @param eduQuestionOptions
	 * @return
	 * @throws Exception
	 */
	public int insertQuestionOptions(EduQuestionOptions eduQuestionOptions) throws Exception;
	/**
	 * 修改试卷
	 * @param eduPaper
	 * @return
	 * @throws Exception
	 */
	public boolean updatePaper(EduPaper eduPaper) throws Exception;
	/**
	 * 修改题干
	 * @param eduQuestion
	 * @return
	 * @throws Exception
	 */
	public boolean updateQuestion(EduQuestion eduQuestion) throws Exception;
	/**
	 * 修改题项
	 * @param eduQuestionOptions
	 * @return
	 * @throws Exception
	 */
	public boolean updateQuestionOptions(EduQuestionOptions eduQuestionOptions) throws Exception;
	
	boolean insertProjectAudit(EduProjectAuditPOJO audit) throws Exception;
	
	boolean updateProjectAudit(EduProjectAuditPOJO audit) throws Exception;
	
	boolean insertAllocate(EduProjectAllocateByArea allocate) throws Exception;
	
	boolean updateAllocate(EduProjectAllocateByArea allocate) throws Exception;
	/**
	 * 保存答券信息
	 * @param eduResponse
	 * @return
	 * @throws Exception
	 */
	public int insertResponse(EduResponse eduResponse) throws Exception ;
    /**
     * 修改答券信息
     * @param eduResponse
     * @return
     * @throws Exception
     */
	public boolean updateResponse(EduResponse eduResponse) throws Exception ;
	/**
	 * 保存答券具体选项信息
	 * @param responseQuestion
	 * @return
	 * @throws Exception
	 */
	public int insertResponseQuestion(EduResponseQuestion responseQuestion) throws Exception ;
	/**
	 * 修改答券具体选项信息
	 * @param responseQuestion
	 * @return
	 * @throws Exception
	 */
	public boolean updateResponseQuestion(EduResponseQuestion responseQuestion) throws Exception ;

	/**
	 * 指定承培机构
	 * @param account
	 * @param projectId
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public boolean insertProForOrg(String account, int projectId, List<Organization> list) throws Exception;

	public boolean updateTeacherScore(Map<String, Object> conditions) throws Exception ;
	public boolean updateTeacherScores(Map<String, Object> conditions) throws Exception ;

	public boolean ScoreBatchUpdate(Map<String, Object> conditions)throws Exception ;
	
	boolean updateProjectByProjectId(int projectId) throws Exception;
	
	boolean updateAllocateByAreaIds(int projectId,List<Integer> areaIds,int type) throws Exception;
	
	/**
	 * 批量插入分配记录
	 * @param list
	 * @return
	 * @throws Exception
	 */
	boolean bathInsertAllocate(List<EduProjectAllocateByArea> list) throws Exception;
	
	/**
	 * 审核不通过修改项目状态
	 * @author yinxiaolong
	 * @param id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public boolean updateProjectStatus(int id,int status) throws Exception;
	
	int countAllocateByProject(EduProjectAllocateByArea allocate) throws Exception;
	
	boolean updateEduProjectRule(Map<String,Object> param) throws Exception;

	public void updateProjectComment(Map<String, Object> conditions)throws Exception;
	
	EduProjectAllocateByArea selectSchoolSumNumByUpLvId(int projectId,int type, int areaId) throws Exception;
	
	 EduProjectAllocateByArea selectSumNumByUpLvId(int projectId,int type, int areaId) throws Exception;
	 
	public Integer insertEduProjectProcess(EduProjectProcess eduProjectProcess);
	public Integer updateEduProjectProcess(EduProjectProcess eduProjectProcess);

	public Integer deleteModelInfoById(Integer id);

	public boolean batchAuditTeacherScores(String[] cids,
			Map<String, Object> params);

	public boolean auditAllTeacherScores(Map<String, Object> conditions) throws Exception;

	public void updateProjectCommentTeachers(EduProjectCommentTeacher teacherInfo)throws Exception;

	public void updateProjectCommentTeachers(List<EduProjectCommentTeacher> eduList)throws Exception;

	public void updateProjectCommentTeachers(Map<String, Object> map)throws Exception;

	public boolean updateProjectCertificateAll(Map<String, Object> param)throws Exception;

	public boolean updateTeacherProjectComment(Map<String, Object> paramMap)throws Exception;

	/**
	 * 更新教师培训结果
	 */
	public boolean updateProjectCommentTrainStatus(Map<String, Object> params) throws Exception;
	
	/**
	 * 根据项目ids更新教师学分
	 */
	public boolean batchModifyTeacherScoresByProjectIds(Map<String, Object> params) throws Exception;
	
	public boolean modifyTeacherClassScore(Map<String, Object> params) throws Exception;

	/**
	 * 更新学分借贷状态
	 */
	boolean updateCreditLendStatus(Map<String, Object> params) throws Exception;

	public int insertProjectComment(Map<String, Object> params);
}
