package project.system.dao;

import java.util.List;
import java.util.Map;

import project.edupm.projectmanage.pojo.EduProjectNotrain;
import project.edupm.projectmanage.pojo.EduQustionSummary;
import project.furtheredu.certificate.pojo.EduDiploma;
import project.message.pojo.MessageTree;
import project.message.pojo.NoticeTree;
import project.organization.pojo.Organization;
import project.person.pojo.EduUser;
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

public interface ISysReadDAO {
	/**机构管理列表分页
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectSysOrganizationCount(Map<String, Object> paramMap) throws Exception;
	/**
	 * 机构管理列表
	 * @author yinxiaolong
	 * @create date 2014-4-13
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<Organization> selectSysOrganizationList(Map<String, Object> paramMap) throws Exception;
	
	public List<SysDictionary> selectDicByDicType(String dicType) throws Exception;
	
	int countAreaByConditions(Map<String,Object> params) throws Exception;
	
	List<SysArea> selectAreaByConditions(Map<String,Object> params) throws Exception;

	List<EduSchool> selectSchoolList(Map<String, Object> params)
			throws Exception;

	public List<SysArea> selectAreaByBelong(Map<String , Object> pram) throws Exception;
	
	List<SysArea> selectAllAreas() throws Exception;

	/**
	 * 证书查询 分页
	 * @param param
	 * @return
	 */
	List<Object> selectDiplomaListByCondition(Map<String, Object> param);

	/**
	 * 证书查询 分页
	 * @param param
	 * @return
	 */
	Integer selectDiplomaCountByCondition(Map<String, Object> param);

	/**
	 * 单个证书查询
	 * @param Id
	 * @return
	 */
	EduDiploma selectDiplomaById(Integer Id, String projectId, String type) throws Exception;
	

	/**
	 * 单个证书查询
	 * @param paramMap
	 * @return
	 */
	EduDiploma selectDiplomaByYear(Map<String, Object> paramMap) throws Exception;
	
	SysArea selectAreaByCode(String code) throws Exception;
	
	/**
	 * 项目汇总统计 总数
	 * @author cl
	 * @create date 2014-4-3
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectProjectCount(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 项目模板汇总教师合格人数信息
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectModeStatisticsCount(Map<String, Object> paramMap) throws Exception;

	 /**
	 * 项目汇总统计 列表
	 * @author cl
	 * @create date 2014-4-3
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<ProjectStatisticsActivty> selectProjectList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 继教模板汇总统计 列表
	 * 
	 * @author 
	 * @create date 2016-08-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<ProjectStatisticsActivty> selectModelStatisticsList(Map<String, Object> paramMap) throws Exception ;
	
	/**
	 * 地区汇总统计 列表
	 * 
	 * @author 
	 * @create date 2016-08-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<ProjectStatisticsActivty> selectAreaStatisticsList(Map<String, Object> paramMap) throws Exception ;



	 /**
	 * 获取角色对应的权限
	 * @author cl
	 * @create date 2014-4-4
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<SysRoleFuncActivty> selectRoleFuncList(Integer id) throws Exception;
	
	/**
	 * 通过学段查询学科
	 * @return
	 * @throws Exception
	 */
	List<SysDictionary> selectSubjectBySection(String id, String sectionName) throws Exception;
	
	 /**
	 * 角色管理
	 * @author cl
	 * @create date 2014-4-10
	 * @return
	 * @throws Exception
	 */
	public List<SysRole> selectRoleList(Map<String, Object> param) throws Exception;
	
	/**
	 * 学校管理记录 总数
	 * @author cl
	 * @create date 2014-4-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectSysSchoolCount(Map<String, Object> paramMap) throws Exception;

	 /**
	 * 学校管理 列表
	 * @author cl
	 * @create date 2014-4-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduSchool> selectSysSchoolList(Map<String, Object> paramMap) throws Exception;
	
	 /**
	 * 学校管理 查看详情
	 * @author cl
	 * @create date 2014-4-13
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduSchool selectSysSchoolInfo(Integer id) throws Exception;


	/**
	 * 查询系统设置的功能设置
	 * @author zxq
	 * @return
	 * @throws Exception
	 */
	public SysSetup selectSysSetupInfo() throws Exception;
	/**
	 * 查看机构详情
	 * @author yinxiaolong
	 * @return
	 * @throws Exception
	 */
	public Organization selectOrganizationInfoById(Integer organizationId) throws Exception;
	
	/**
	 * 查询所有已经存在的用户名
	 * @return
	 * @throws Exception
	 */
	List<String> selectAllUserName() throws Exception;
	
	List<EduSchool> selectAllSchool() throws Exception;
	

	/**
	 * 学校导入时，验证区域内是否存在学校
	 * @author cl
	 * @create date 2014-4-21
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectSysSchoolCountForImport(Map<String, Object> paramMap)
			throws Exception;
	
	/**
	 * 获取系统模块
	 * @return
	 * @throws Exception
	 */
	public List<SysFunction> selectSysFunction() throws Exception;
	
	/**
	 * 获取角色对应的系统模块
	 * @return
	 * @throws Exception
	 */
	public List<SysFunction> selectSysFunction(Integer id) throws Exception;
	
	/**
	 * 设置机构管理员列表分页
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectOrgAdminsCount(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 设置机构管理员列表
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduUser> selectAdmins(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 根据projectScopeId查出此地区的type
	 * @param projectScopeId
	 * @return
	 * @throws Exception
	 */
	public SysArea selectAreaByProScopeId(String projectScopeId)throws Exception;;
	
	public ZTree getById(Map<String, Object> paramMap)throws Exception;
	public List<ZTree> getChildAreaList(Map<String, Object> paramMap)throws Exception;
	public List<ZTree> getSchoolTypeListOfArea(int areaId)throws Exception;
	public List<ZTree> getSchoolListOfAreaByType(Map<String, Object> paramMap)throws Exception;
	
	public int countNotrainByConditions(Map<String, Object> params)
			throws Exception;

	
	public List<EduProjectNotrain> selectNotrainByConditions(Map<String, Object> params)
			throws Exception ;
	
	public EduProjectNotrain selectNotraiByPrimaryKey(Integer id) throws Exception ;
	public ZTree getAreaById(Map<String, Object> conditions)throws Exception ;
	public List<ZTree> getSchoolTypeList(Map<String, Object> conditions)throws Exception ;
	public List<ZTree> getChildrenAreaById(Map<String, Object> conditions)throws Exception ;
	public List<ZTree> getSchoolList(Map<String, Object> conditions)throws Exception ;
	
	/**
	 * 查询系统平台设置详情
	 * @author 曉
	 * @return
	 */
	public SysPlatformSetup selectSysPlatformSetup()throws Exception ;
	
	
	/**
	 * 当前登录人所控制的范围
	 * @param paramMap
	 * @return
	 */
	public List<SysArea> selectAreasByUserCode(Map<String, Object> paramMap);
	
	/**
	 * 删除学校时，检查学校是否被引用
	 * @author cl
	 * @create date 2014-6-23
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectSchoolBelongCount(int schoolId) throws Exception;
	List<Integer> selectAreaById(int areaId) throws Exception;
	/**
	 * 查询所有的用户编号
	 * @return
	 * @throws Exception
	 */
	List<String> selectAllUserNo() throws Exception;
	
	List<ZTree> getNodes() throws Exception;
	
	/**
	 * liuyiyou
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<NoticeTree> schoolTree(Map<String,Object> param) throws Exception;
	
	/**
	 * liuyiyou
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<NoticeTree> getNodes(String id) throws Exception;
	ZTree getAreaTeacherById(Map<String, Object> paramMap) throws Exception;
	public List<ZTree> getChildAreaTeacherList(Map<String, Object> paramMap)throws Exception;
	public List<ZTree> getSchoolListOfTeacherByType(Map<String, Object> conditions)throws Exception;
	public List<FjTeacherStudyInfo> getFJTeacherAchievements(Map<String, Object> params)throws Exception;
	public SysArea getAreaByName(Map<String, Object> paramMap);
	public List<SysArea> getDistrictList(Map<String, Object> paramMap);
	public List<SysArea> getAreaListByUpcode(Map<String, Object> paramMap);
	public Fjimport getFjimportByName(Map<String, Object> paramMap);
	public List<RoleType> getRoleTypeList(Map<String, Object> paramMap);
	public EduSchool selectSchoolByName(Map<String, Object> params)throws Exception;
	
	/**
	 * 行政管理员tree
	 */
	public List<MessageTree> selectAdministratorNode(Map<String, Object> paramMap)  throws Exception;
	
	/**
	 * 实施机构管理员tree
	 */
	public List<MessageTree> selectOrgAdministratorNode(Map<String, Object> paramMap)  throws Exception;
	
	/**
	 * 校管理员tree
	 */
	public List<MessageTree> selectSchoolAdministratorNode(Map<String, Object> paramMap)  throws Exception;
	
	/**
	 * 教师tree
	 */
	public List<MessageTree> selectSchoolTeacherNode(Map<String, Object> paramMap)  throws Exception;
	
	public List<EduDiploma> queryAllProjectDeploma()throws Exception;
	public FjimportActivty getFjimportInfo(Map<String, Object> param)throws Exception;
	
	/*
	 * 学员学分详情汇总
	 */
	public int getTeacherTrainScoreCount(Map<String, Object> param) throws Exception ;
	
	public List<EduTeacherScoreInfo> getTeacherTrainScoreListPage(Map<String, Object> param) throws Exception ;
	
	public List<EduTeacherScoreInfo> queryEduTeacherScoreInfoList(Map<String, Object> params);
	
	public int getTeacherScoreHistoryCount(Map<String, Object> param) throws Exception;
	
	public List<FjimportHistory> getTeacherScoreHistoryListPage( Map<String, Object> param) throws Exception;
	
	public List<EduTeacherScoreInfo> queryTeacherScoreListNoPage(Map<String, Object> paramMap) throws Exception;
	
	public EduTeacherScoreInfo getTeacherScoreInfoById( Map<String, Object> result) throws Exception;
	
	public int getTeacherTrainScoreByTeacherCount(Map<String, Object> param) throws Exception;
	
	public List<EduProjectActivityPojo> getgetTeacherTrainScoreListByTeacher(Map<String, Object> param) throws Exception;
	
	public List<EduQustionSummary> questionSurverSummaryList(Map<String, Object> param);
	
	public int getTeacherTrainCreditCount(Map<String, Object> param);
	
	public List<EduTeacherScoreInfo> getTeacherTrainCreditListPage(
			Map<String, Object> param);
	
	public List<EduTeacherScoreInfo> getTeacherTrainRemainCredit(
			Map<String, Object> condition);
	
	public List<String> getNeedCredit(Map<String, Object> params);
	
	public int selectInitYear();
}
