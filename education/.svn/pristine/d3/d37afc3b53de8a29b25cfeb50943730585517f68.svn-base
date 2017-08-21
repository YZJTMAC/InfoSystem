package project.edupm.projectmanage.service;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.multipart.MultipartFile;

import project.edupm.projectmanage.dto.EduProjectDTO;
import project.edupm.projectmanage.pojo.EduModel;
import project.edupm.projectmanage.pojo.EduModelPOJO;
import project.edupm.projectmanage.pojo.EduOrgProjectStatus;
import project.edupm.projectmanage.pojo.EduPaper;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduProjectAllocateByArea;
import project.edupm.projectmanage.pojo.EduProjectAuditPOJO;
import project.edupm.projectmanage.pojo.EduProjectProcess;
import project.edupm.projectmanage.pojo.EduQuestion;
import project.edupm.projectmanage.pojo.EduQuestionOptions;
import project.edupm.projectmanage.pojo.EduResponse;
import project.edupm.projectmanage.pojo.EduResponseQuestion;
import project.edupm.projectmanage.pojo.ProjectReportInfo;
import project.organization.pojo.OrgProTeacherActivity;
import project.organization.pojo.Organization;
import project.teacher.teachermanage.dto.TeacherDTO;
import project.teacher.teachermanage.pojo.EduProjectCommentTeacher;
import project.teacher.teachermanage.pojo.EduTeacherVersionPOJO;
import framelib.utils.page.PageObject;

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
public interface IEduProjectService {
	public PageObject queryTeacherProjectListByAdmin(Map<String, Object> conditions, int startPage, int pageSize) throws Exception;
	
	public PageObject selectTeacherProj(Map<String, Object> param,Integer startIndex,Integer pageSize);
	
	/**
	 * 查询实施机构对应的已关闭的项目
	 * @param proParam	对应的项目属性值
	 * @param otherParam 其他后来可能要用到的参数
	 */
	public PageObject findProjectByParam(Map<String,Object> proParam,Integer startIndex,Integer pageSize);
	
	/**
	 * 更新project基本信息
	 * @param dto
	 * @return
	 */
	boolean updateProject(EduProjectDTO dto);
	
	
	boolean updateProject(EduProject eduproject);
	
	public Integer countProject(Map<String, Object> conditions) throws Exception;
	
	/**
	 * 创建项目
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public boolean saveProject(EduProjectDTO dto, List<MultipartFile> files,
			String path) throws Exception;

	/**
	 * 保存项目附件
	 * 
	 * @param files
	 * @param projectNO
	 * @return
	 * @throws Exception
	 */
	// public String saveProjectAttechment(List<MultipartFile> files,String
	// projectNO) throws Exception;

	/**
	 * 项目列表
	 * 
	 * @param conditions
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public PageObject projectList(Map<String, Object> conditions,
			int startPage, int pageSize) throws Exception;

	/**
	 * 问卷列表
	 * 
	 * @param conditions
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public PageObject paperList(Map<String, Object> conditions, int startPage,
			int pageSize) throws Exception;

	// public OrganizationProjectActivity queryProInfoById(int proId) throws
	// Exception;

	/**
	 * 删除项目
	 * 
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	public boolean modifyProById(int proId) throws Exception;

	/**
	 * 项目详情
	 * 
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	public EduProjectDTO qryProFullInfo(int proId) throws Exception;

	/**
	 * 设置报名方式
	 * 
	 * @param proId
	 * @param way
	 * @return
	 * @throws Exception
	 */
	public boolean setProSignUpWay(int proId, String way) throws Exception;

	Map<String, Object> importTeacher(List<TeacherDTO> dtos, String account,
			Map<String, Object> param) throws Exception;

	/**
	 * 查询项目基本信息
	 * 
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	EduProject queryProjectBaseInfoById(int proId) throws Exception;

	/**
	 * 修改项目信息
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	boolean modifyProById(EduProjectDTO dto, String deleted,
			List<MultipartFile> files, String path) throws Exception;

	/**
	 * 获取项目课程--有分页(无项目信息)
	 * 
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	// PageObject projectClasses(int proId) throws Exception;

	/**
	 * 获取项目课程--无分页(无项目信息)
	 * 
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	// List<EduProjectClass> projectClassNoPage(int proId) throws Exception;

	/**
	 * 项目课程列表(包含项目信息)
	 * 
	 * @return
	 * @throws Exception
	 */
	PageObject classesListForProject(int startIndex, int pageSize,
			Map<String, Object> conditions) throws Exception;

	/**
	 * 通过地区查询机构
	 * 
	 * @param pro
	 * @return
	 * @throws Exception
	 */
	List<Organization> getOrgsByArea(EduProjectDTO pro) throws Exception;

	/**
	 * 项目列表
	 * 
	 * @param conditions
	 * @param startIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageObject proListForAudit(Map<String, Object> conditions, int status, int startIndex,
			int pageSize) throws Exception;
	PageObject districtAudit(Map<String, Object> conditions, int startIndex,
			int pageSize) throws Exception;
	PageObject cityAudit(Map<String, Object> conditions, int startIndex,
			int pageSize) throws Exception;
	PageObject provinceAudit(Map<String, Object> conditions, int startIndex,
			int pageSize) throws Exception;
	
	
	
	PageObject proListForAuditSH(Map<String, Object> conditions, int startIndex,
			int pageSize) throws Exception;

	/**
	 * 报名教师列表
	 * 
	 * @param conditions
	 * @param startIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageObject teachersForAudit(Map<String, Object> conditions, int startIndex,
			int pageSize) throws Exception;
	
	public List<OrgProTeacherActivity> downTeacherExcl(Map<String, Object> paramMap)
			throws Exception;
	/**
	 * 审核报名教师
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	boolean auditTeacher(Map<String, Object> params) throws Exception;
	
	/*
	 * 新教师报名审核
	 * wych
	 */
	boolean deleteTeacher(String projectId,int teacherId,int schoolId) throws Exception;

	/**
	 * 查询教师未通过审核备注
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String getUnpassReason(int id) throws Exception;

	/**
	 * 修改项目状态
	 * 
	 * @param projectId
	 * @param status
	 * @return
	 * @throws Exception
	 */
	boolean modifyProjectStatus(int projectId, int status) throws Exception;

	/**
	 * 批量审核教师
	 * 
	 * @param ids
	 * @param params
	 * @return
	 * @throws Exception
	 */
	boolean batchAuditTeacher(String ids, Map<String, Object> params)
			throws Exception;

	/**
	 * 判断是否已经有教师报名
	 * 
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	boolean hasTeacherEnter(int projectId) throws Exception;

	/**
	 * 判断机构是否已经被分配
	 * 
	 * @param projectId
	 * @param organizationId
	 * @return
	 * @throws Exception
	 */
	boolean hasAllocate(int projectId, int organizationId) throws Exception;

	boolean cancelOP(int id) throws Exception;

	/**
	 *之前是得到eud_project_comment的id集合，现在改成得到eud_project_comment的teacher_id的集合 
	因为在service中调用该方法的名字叫：getAllTeachers，不知道之前开发人员怎么命名的，
	还有就是为什么要去掉后面的那些isNotEmpty,如果不传递该参数，下面的压根运行不到
	再有就是，为什么分页和不分页需要些两个查询？可以根据传递的startIndex或者其他参数来判断是否是分页啊
	 */
	String getAllTeachers(Map<String, Object> params) throws Exception;

	List<String> getAllOrgByProjectId(int projectId) throws Exception;

	boolean isReduplicated(String projectNo) throws Exception;
	
	boolean isTrainReduplicated(String projectNo,Integer type) throws Exception;

	Map<String, Object> parseExcel(InputStream is, String fileType)
			throws Exception;

	Map<String, Object> parseStudentExcel(InputStream is, String fileType,Map<String,Object> params)
			throws Exception;

	boolean procBatchSignUp(List<Integer> ids, int projectId, String account,String type)
			throws Exception;

	/**
	 * 教师离退休导入
	 * @param is
	 * @param fileType
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> parseRetireesTeacherExcel(InputStream is,String fileType,Map<String,Object> params) throws Exception;

	boolean procWrite2ImportTeacherHistory(String account, String realName,
			Date date, int total, int toExl, String names, String failUrl, String type)
			throws Exception;

	/**
	 * new_实施机构项目列表
	 * 
	 * @param conditions
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageObject queryProjectListByStatus(Map<String, Object> conditions,
			int startPage, int pageSize) throws Exception;
	/*
	 * 报名审核
	 */
	PageObject ProjectByRegistration(Map<String, Object> conditions,
			int startPage, int pageSize) throws Exception;
	
	
	PageObject queryProjectListByStatusUpdate(Map<String, Object> conditions,
			int startPage, int pageSize) throws Exception;
	
	PageObject queryProjectListByStatuses(Map<String, Object> conditions,
			int startPage, int pageSize) throws Exception;
	
	/**
	 * 实施机构项目审核通过列表
	 * @author yinxiaolong
	 * @param conditions
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageObject queryProjectListSuccessByStatus(Map<String, Object> conditions,
			int startIndex, int pageSize) throws Exception;

	/**
	 * 保存试卷
	 * 
	 * @param eduPaper
	 * @return
	 * @throws Exception
	 */
	public int insertPaper(EduPaper eduPaper) throws Exception;

	/**
	 * 保存题干
	 * 
	 * @param eduQuestion
	 * @return
	 * @throws Exception
	 */
	public int insertQuestion(EduQuestion eduQuestion) throws Exception;

	/**
	 * 保存题项
	 * 
	 * @param eduQuestionOptions
	 * @return
	 * @throws Exception
	 */
	public int insertQuestionOptions(EduQuestionOptions eduQuestionOptions)
			throws Exception;

	/**
	 * 修改试卷
	 * 
	 * @param eduPaper
	 * @return
	 * @throws Exception
	 */
	public boolean updatePaper(EduPaper eduPaper) throws Exception;

	/**
	 * 修改题干
	 * 
	 * @param eduQuestion
	 * @return
	 * @throws Exception
	 */
	public boolean updateQuestion(EduQuestion eduQuestion) throws Exception;

	/**
	 * 修改题项
	 * 
	 * @param eduQuestionOptions
	 * @return
	 * @throws Exception
	 */
	public boolean updateQuestionOptions(EduQuestionOptions eduQuestionOptions)
			throws Exception;

	/**
	 * 获得一个问卷
	 * 
	 * @param papId
	 * @return
	 * @throws Exception
	 */
	public EduPaper selectEduPaperById(int papId) throws Exception;

	/**
	 * 获得一个题干
	 * 
	 * @param eqId
	 * @return
	 * @throws Exception
	 */
	public EduQuestion selectEduQuestionById(int eqId) throws Exception;

	/**
	 * 获得一个题选项
	 * 
	 * @param eqoId
	 * @return
	 * @throws Exception
	 */
	public EduQuestionOptions selectEduQuestionOptionsById(int eqoId)
			throws Exception;

	/**
	 * 通过问卷id获得题干列表
	 * 
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public PageObject selectEduQuestionListByPapid(
			Map<String, Object> conditions, int startIndex,
			int pageSize) throws Exception;

	/**
	 * 通过题干id获得题选项列表
	 * 
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public PageObject selectEduQuestionOptionsListByQid(
			Map<String, Object> conditions, int startIndex,
			int pageSize) throws Exception;

	/**
	 * 继教信息模板设置
	 * @author yinxiaolong
	 * @param paramMap
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public PageObject selectModelList(Map<String, Object> paramMap,int startPage,int pageSize) throws Exception;
	
	/**
	 * 继教信息模板设置增加 
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	boolean insertModelInfo(Map<String,Object> paramMap) throws Exception;
	
	/**
	 * 检查继教板块名称是否已经存在--增加继教板块的时候
	 * @param modelName
	 * @return
	 * @throws Exception
	 */
	String checkModelName(String modelName) throws Exception;
	
	/**
	 * @author liuyiyou
	 * 检查继教板块名称是否已经存在--修改继教板块的时候
	 * @param modelName
	 * @return
	 * @throws Exception
	 */
	String checkModelName(int modelId,String modelName) throws Exception;
	
	/**
	 * 检查继教板块编码是否已经存在
	 * @param code
	 * @return
	 * @throws Exception
	 */
	String checkModelCode(String code) throws Exception;
	
	/**
	 * @author liuyiyou
	 * 检查继教板块编码是否已经存在--修改继教板块的时候
	 * @param code
	 * @return
	 * @throws Exception
	 */
	String checkModelCode(int modelId,String code) throws Exception;
	/**
	 * 继教信息模板设置编查看
	 * @author yinxiaolong
	 * @param d
	 * @return
	 * @throws Exception
	 */
	public EduModel qryModelInfo(int id) throws Exception;
	public String qryModelInfo(Map<String,Object> paramMap) throws Exception;
	
	
	/**
	 * 项目申报
	 * @param projectId
	 * @param accountId
	 * @return
	 * @throws Exception
	 *	2014-4-27
	 * zhangBo
	 */
	Map<String,Object> procDeclareProject(int projectId,int accountId,List<MultipartFile> files,String path) throws Exception;
	
	
	/**
	 * 项目申报
	 * @param projectId
	 * @param accountId
	 * @return
	 * @throws Exception
	 *	2014-11-25
	 * liuyiyou
	 */
	Map<String,Object> procDeclareProjectAgain(int projectId,String accountName,int accountId,List<MultipartFile> files,String path) throws Exception;

	/**
	 * 项目审核  
	 * @param status
	 * @param memo
	 * @param projectId
	 * @param accountId 审核人ID
	 * @return
	 * @throws Exception
	 *	2014-4-27
	 * zhangBo
	 */
	boolean procAuditProject(int status,String memo,int projectId,int accountId,String realName, String account) throws Exception;
	/**
	 * 查询审核详情
	 * @param projectId
	 * @return
	 * @throws Exception
	 *	2014-4-27
	 * zhangBo
	 */
	EduProjectAuditPOJO procQueryAuditInfo(int projectId) throws Exception;
	
	List<EduProjectAllocateByArea> queryAllocateInfo(int areaId,String type,int projectId,String schoolName ) throws Exception;
	List<EduProjectAllocateByArea> queryAllocateInfoes(int areaId,String type,int projectId,String schoolName, Integer schoolTypeId) throws Exception;
	/**
	 * 继教信息模板设置编辑
	 * @author yinxiaolong
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean updateModelInfoById(Map<String,Object> paramMap)throws Exception;
	
	
	boolean deleteModelInfoById(Integer id)throws Exception;
	
	/**
	 * 分配名额
	 * @param allocate
	 * @return
	 * @throws Exception
	 */
	boolean saveOrUpdateAllocate(EduProjectAllocateByArea allocate) throws Exception;
	
	EduProjectAllocateByArea selectAllocateByArea(EduProjectAllocateByArea allocate) throws Exception;
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
	 * 修改分配名额
	 * @param allocate
	 * @return
	 * @throws Exception
	 */
	boolean modifyAllocateByArea(EduProjectAllocateByArea allocate) throws Exception;
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
	 * 查询答券分页
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public PageObject selectEduResponseListByCondition(
			Map<String, Object> conditions,int startIndex,
			int pageSize) throws Exception ;
	/**
	 * 查询答券详细分页
	 * @param conditions
	 * @return
	 */
	public PageObject selectEduResponseQuestionListByCondition(
			Map<String, Object> conditions,int startIndex,
			int pageSize) throws Exception;
	
	/**
	 * 实施机构 --> 承培机构任务分配列表查询
	 * @author 曉
	 * @param paramMap
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public PageObject selectProjectByStatus(Map<String, Object> paramMap, Integer pageIndex, int pageSize)throws Exception;
	
	
	/**
	 * 上报教师--教师列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	PageObject procTeacherListForReport(Map<String, Object> param,int startIndex,int pageSize) throws Exception;
	
	/**
	 * 查询教师所有版本号
	 * @param teacherId
	 * @return
	 * @throws Exception
	 */
	EduTeacherVersionPOJO queryAllTeacherVersion(int teacherId) throws Exception;
	
	
	boolean apply(int areaId,int projectId,int type) throws Exception;
	/**
	 * 根据项目培训范围查询此地区级别及其以上地区级别的承培机构
	 * @param trainScopeId
	 * @return
	 * @throws Exception
	 */
	public List<Organization> queryOrgByProScopeId(String trainScopeId) throws Exception;
	boolean updateTeacherScore(Map<String, Object> conditions)throws Exception;
	
	boolean updateTeacherScores(Map<String, Object> conditions)throws Exception;
	/**
	 * 通过条件获得回答问题的数量
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public Integer countEduResponseQuestionByCondition(Map<String, Object> conditions)throws Exception;
	boolean ScoreBatchUpdate(Map<String, Object> conditions)throws Exception;
	
	/**
	 * 设置停止报名
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	boolean setStopSign(int projectId) throws Exception;
	/**
	 * 启动项目列表
	 * @return
	 */
	PageObject queryProjectByStatusForStart(Map<String, Object> conditions,int startIndex, int pageSize) throws Exception;
	/**
	 * 指定承培机构
	 * @param projecId
	 * @param orgList
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> assginOrg(String account, int projecId, List<Organization> orgList) throws Exception;
	
	EduOrgProjectStatus queryOrgStatus(int projectId) throws Exception;
	
	/**
	 * 判断教师是否可以报名
	 * @param projectId 项目ID
	 * @param teacherId 教师ID
	 * @return
	 * @throws Exception
	 */
	public boolean canSign(int projectId,int teacherId, StringBuffer failMsg) throws Exception;
	
	/**
	 * 查询继教信息模块--无分页
	 * @return
	 * @throws Exception
	 */
	List<EduModelPOJO> queryEduModel(Map<String, Object> param) throws Exception;
	
	boolean procReportByUpLvId(int areaId,int projectId) throws Exception;
	
	/**
	 * 查询项目审核记录
	 * @param projectId 项目ID
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public List<EduProjectAuditPOJO>queryProjectAudit(int projectId)throws Exception;
	
	/**
	 * 审核不通过修改项目状态
	 * @author yinxiaolong
	 * @param id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public boolean updateProjectStatus(int id,int status) throws Exception;
	
	/**
	 * 查询上报名额详情
	 * @param queryMap 查询条件
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public List<ProjectReportInfo>queryProjectReportInfo(Map<String, Object> queryMap)throws Exception;
	
	/**
	 * 项目审核列表
	 * @param paramMap
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageObject queryProjectListForAudit(Map<String, Object> paramMap, Integer pageIndex, int pageSize) throws Exception;
	
	
	/**
	 * 查询项目的所有实施机构
	 */
	public List<EduProject> selectshishijigou()throws Exception;
	
	
	
	/**
	 * 继教模块列表
	 * @param params
	 * @param startIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageObject queryModelListForSet(Map<String, Object> params, Integer startIndex, int pageSize) throws Exception;
	
	void setRole(Map<String, Object> condition) throws Exception;
	
	PageObject queryProjectByAuditStatus(Map<String,Object> params,int startIndex,int pageSize) throws Exception;

	public void updateProjectComment(Map<String, Object> conditions) throws Exception;
	
	Map<String, Object> parseTeacherExcel(InputStream is, String fileType) throws Exception;
	
	public Integer writeProcess(EduProjectProcess epp);
	public EduProjectProcess getProcessByParam(EduProjectProcess epp);
	
	List<Object> queryProjectListByCreateBy(Map<String, Object> conditions)throws Exception;

	List<Object> queryProjectListByStatus(Map<String, Object> conditions)
			throws Exception;

	EduProjectAllocateByArea queryAllocateInfo(int projectId, int type,
			int areaId) throws Exception;

	boolean hasAllocate(int projectId, int areaId, int type) throws Exception;

	PageObject queryProjectListByStatus(Map<String, Object> conditions,
			int startIndex, int pageSize, String queryFlag) throws Exception;

	boolean isOrg(int projectId, int orgId) throws Exception;

	boolean isReduplicatedProName(String projectName) throws Exception;
	
	boolean isReduplicatedTrinProName(String projectName,Integer type) throws Exception;

	List<EduProjectAllocateByArea> queryAllocateInfo(int areaId, String type,
			int projectId, int schoolId) throws Exception;

	boolean isReport(int projectId) throws Exception;

	public boolean batchAuditTeacherScores(String ids, Map<String, Object> params) throws Exception;

	public boolean auditAllTeacherScores(Map<String, Object> conditions) throws Exception;

	public List<EduProjectCommentTeacher> queryProjectCommentTeachers(int projectId)throws Exception;

	public void updateProjectCommentTeachers(EduProjectCommentTeacher teacherInfo)throws Exception;

	public void updateProjectCommentTeachers(List<EduProjectCommentTeacher> eduList)throws Exception;

	public void updateProjectCommentTeachers(Map<String, Object> map)throws Exception;

	public EduProjectCommentTeacher queryProjectCommentByTeacherId(EduProject  project,Integer userId) throws Exception;

	/**
	 * 检查是否强制提交调查问卷
	 * @param conditions
	 * @return
	 */
	public Integer checkIsForcePaper(Map<String, Object> conditions);

	public boolean updateProjectCertificateAll(Map<String, Object> param) throws Exception;

	public boolean updateTeacherProjectComment(Map<String, Object> paramMap) throws Exception;

	public Integer getAllProjectComment(Map<String, Object> paraMap) throws Exception;
	
	PageObject proListForAuditTeacher(Map<String, Object> conditions, int startIndex,
			int pageSize) throws Exception;
			
	/**
	 * 更新教师培训结果
	 */
	public void updateProjectCommentTrainStatus(EduProjectDTO dto, String projectId, String ids, int trainStatusId) throws Exception;
	
	/**
	 * 根据项目id更新教师学分
	 */
	public void modifyTeacherScoresByProjectIds(String projectId, String commonPeriod, String excellentPeriod) throws Exception;

	/**
	 * 接卸问卷调查问题excel并拆分数据
	 * @param paramMap 
	 */
	Map<String, Object> parsePaperQuestionExcel(InputStream is, String fileType, Map<String,Object> params);

	/**
	 * 批量导入调研问卷问题
	 */
	public void batchInsertPaperQuestion(List<Row> rows,Map<String, Object> params);
	
	/**
	 * 查询教师借贷学分列表
	 */
	PageObject queryCreditLendListForAudit(Map<String, Object> conditions,int startPage, int pageSize) throws Exception;
	
	/**
	 * 审核教师学分借贷
	 */
	boolean procAuditCreditLend(Map<String, Object> conditions) throws Exception;

	public List<EduProject> getSpecialProject(Map<String, Object> params);

	public int addProjectComment(Map<String, Object> params);

	
}
