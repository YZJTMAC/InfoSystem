package project.system.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import project.edupm.projectmanage.pojo.EduProjectNotrain;
import project.edupm.projectmanage.pojo.EduQustionSummary;
import project.furtheredu.certificate.pojo.EduDiploma;
import project.message.pojo.MessageTree;
import project.message.pojo.NoticeTree;
import project.organization.dto.OrganizationDto;
import project.organization.pojo.Organization;
import project.person.pojo.EduUser;
import project.system.pojo.EduTeacherScoreInfo;
import project.system.pojo.FjTeacherStudyInfo;
import project.system.pojo.Fjimport;
import project.system.pojo.FjimportActivty;
import project.system.pojo.FjimportHistory;
import project.system.pojo.RoleType;
import project.system.pojo.SysArea;
import project.system.pojo.SysDictionary;
import project.system.pojo.SysFunction;
import project.system.pojo.SysPlatformSetup;
import project.system.pojo.SysRole;
import project.system.pojo.SysRoleFuncActivty;
import project.system.pojo.SysSetup;
import project.system.pojo.TrainingDTO;
import project.system.pojo.ZTree;
import project.teacher.teachermanage.pojo.TeacherExportActivity;
import framelib.utils.page.PageObject;

public interface ISysService {
	/**
	 * 字典表管理列表
	 * @author yinxiaolong
	 * create date 2014-4-13
	 * @param paramMap
	 * @param pageIndex 
	 * @param pageSize 
	 * @return
	 * @throws Exception
	 */
	public PageObject querySysOrganization(Map<String, Object> paramMap,int pageIndex, int pageSize) throws Exception;
	
	public List<SysDictionary> queryDicByDicType(String dicType) throws Exception;
	
	boolean addArea(SysArea area) throws Exception;
	
	PageObject qryAreaList(int startIndex,int pageSize,int belong) throws Exception;

	public List<SysArea> selectAreaList(Map<String , Object> pram) throws Exception;

	/**
	 * 证书查询分页
	 * @param paramMap
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageObject queryDeplomaListPage(Map<String, Object> paramMap,
			int startPage, int pageSize) throws Exception;

	/**
	 * 保存 证书 
	 * @param pojo
	 * @return
	 */
	public Integer saveCertificate(EduDiploma pojo);

	/**
	 * 单个查询证书
	 * @param id
	 * @param projectId 项目证书 需要传递此参数
	 * @return
	 * @throws Exception
	 */
	EduDiploma queryDeplomaById(Integer id, String projectId, String type,String certificateView) throws Exception;

	Integer modifyCertificate(EduDiploma pojo);

	Integer removeDeplomaById(Integer id) throws Exception;
	
	/**
	 * 项目汇总统计 列表
	 * @author cl
	 * create date 2014-4-3
	 * @param paramMap
	 * @param pageIndex 当前页
	 * @param pageSize 页大小
	 * @return
	 * @throws Exception
	 */
	public PageObject queryProjectStatistics(Map<String, Object> paramMap,int pageIndex, int pageSize) throws Exception;
	
	/**
	 * 继教模板汇总统计 列表
	 * @author 
	 * create date 2016-8-10
	 * @param paramMap
	 * @param pageIndex 当前页
	 * @param pageSize 页大小
	 * @return
	 * @throws Exception
	 */
	public PageObject queryModelStatistics(Map<String, Object> paramMap,int pageIndex, int pageSize) throws Exception;
	
	/**
	 * 地区汇总统计 列表
	 * @author 
	 * create date 2016-8-10
	 * @param paramMap
	 * @param pageIndex 当前页
	 * @param pageSize 页大小
	 * @return
	 * @throws Exception
	 */
	public PageObject queryAreaStatistics(Map<String, Object> paramMap,int pageIndex, int pageSize) throws Exception;
	
	 /**
	 * 获取角色对应的权限
	 * @author cl
	 * @create date 2014-4-4
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<SysRoleFuncActivty> queryRoleFuncList(Integer id) throws Exception;
	
	
	List<SysDictionary> querySubjectBySection(String id, String sectionName) throws Exception;
	
	/**
	 * 获取角色列表
	 * @author cl
	 * @create date 2014-4-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<SysRole> queryRoleList(Map<String, Object> param) throws Exception;
	
	/**
	 * 更新角色
	 * @author cl
	 * @create date 2014-4-10
	 * @return
	 */
	public Integer updateRole(SysRole pojo)throws Exception;
	
	/**
	 * 根据CODE查询地区
	 * @author zhangBo
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public SysArea queryAreaByCode(String code) throws Exception;
	/**
	 * 增加机构
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	boolean addOrganizationInfo(Map<String, Object> paramMap) ;
	
	/**
	 * 机构修改
	 * @author yinxiaolong
	 * @param paramMao
	 * @return
	 * @throws Exception
	 */
	boolean updateOrganizationInfo(Map<String,Object> paramMap) throws Exception;
	/**
	 * 机构删除
	 * @author yinxiaolong
	 * @param paramMao
	 * @return
	 */
	boolean deleteOrganizationInfo(Map<String,Object> paramMap) throws Exception;
	

	/**
	 * 查询系统设置的功能设置
	 * @author zxq
	 * @return
	 * @throws Exception
	 */
	public SysSetup selectSysSetupInfo() throws Exception;

	
	/**
	 * 系统设置--功能设置修改
	 * @author zxq
	 * @return
	 */
	public int modifySysSetup(SysSetup pojo) throws Exception;
	
	/**
	 * 查看机构
	 * @author yinxiaolong
	 * @param organizationId
	 * @return
	 * @throws Exception
	 */
	public Organization selectOrganizationInfoById(Integer organizationId) throws Exception;
	
	/**
	 * 接卸excel并拆分数据
	 * @author zhangBo
	 * @param path
	 * @param type
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> parseExcel(String path,String type, Map<String, Object> paramMap) throws Exception;
//	Map<String,Object> parseExcel(File[] files,String path,String type, Map<String, Object> paramMap) throws Exception;
	/**
	 * 将合法数据插入数据库
	 * @author zhangBo
	 * @param toDBpath
	 * @param type
	 * @param account
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> intoDB(String toDBpath,String type,String account,Map<String,Object> params) throws Exception;
	
	String createZipFile(String path,File[] files) throws Exception;
	
	boolean importOrganization(List<OrganizationDto> dtos,String account);
	
	
	boolean delArea(int id) throws Exception;
	
	boolean modifyArea(Map<String,Object> params,int id) throws Exception;
	
	Map<String, Object> parseAreaExcel(InputStream is,String fileType) throws Exception;
	
	void importArea(List<SysArea> areas) throws Exception;

	public Map<String, Object> saveFile(String path, MultipartFile file,
			String savePath) throws Exception;
	
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
	public List<SysFunction> searchSysFunctionRole(Integer id) throws Exception;
	
	/**
	 * 更新角色信息以及角色权限
	 * @author cl
	 * @create date 2014-4-28
	 * @return
	 */
	public Integer modifyRoleFcun(SysRole pojo,List<SysRole> list)throws Exception;

	
	public List<EduUser> selectOrgAdmins(Map<String,Object> paramMap) throws Exception;
	
	public PageObject queryselectOrgAdmins(Map<String, Object> paramMap,int pageIndex, int pageSize) throws Exception;

	public ZTree getById(Map<String, Object> conditions)  throws Exception;
	
	public ZTree getAreaTeacherById(Map<String, Object> conditions)  throws Exception;

	public List<ZTree> getChildAreaList(Map<String, Object> conditions)throws Exception;

	public List<ZTree> getSchoolTypeListOfArea(int parseInt)throws Exception;

	public List<ZTree> getSchoolListOfAreaByType(Map<String, Object> conditions)throws Exception;

	public PageObject queryEduProjectNotrain(Map<String, Object> paramMap,int pageIndex, int pageSize) throws Exception;
	public EduProjectNotrain selectNotraiByPrimaryKey(Integer id) throws Exception ;
	public Integer deleteNotrain(Integer id);
	public Integer updateNotrain(EduProjectNotrain notrain);
	public Integer insertNotrain(EduProjectNotrain notrain);

	public ZTree getAreaById(Map<String, Object> conditions)throws Exception ;

	public List<ZTree> getSchoolList(Map<String, Object> conditions)throws Exception ;

	public List<ZTree> getSchoolTypeList(Map<String, Object> conditions)throws Exception ;

	public List<ZTree> getChildrenAreaById(Map<String, Object> conditions)throws Exception ;

	public boolean enterCredit(Map<String, Object> params)throws Exception ;

	public boolean auditCredit(Map<String, Object> params)throws Exception ;

	/**
	 * 查询系统平台设置详情
	 * @author 曉
	 * @return
	 */
	public SysPlatformSetup selectSysPlatformSetup()throws Exception ;

	/**
	 * 修改系统平台设置
	 * @param pojo
	 * @param path
	 * @return
	 * @throws Exception
	 * 
	 * @author 曉
	 */
	public boolean updatePlatformSetup(SysPlatformSetup pojo, String path)throws Exception ;

	String getAreaRelationById(int id) throws Exception;
	
	List<ZTree> getNodes() throws Exception;
	
	/**
	 * liuyiyou
	 * @return
	 * @throws Exception
	 */
	List<NoticeTree> getNodes(String id) throws Exception;

	List<ZTree> getChildAreaTeacherList(Map<String, Object> paramMap)
			throws Exception;

	public List<ZTree> getSchoolListOfTeacherByType(Map<String, Object> conditions)throws Exception;

	public SysArea selectAreaByCode(String trainScopeId)throws Exception;
	public Map<String, Object> parseFJExcel(InputStream is, String fileType,Map<String, Object> paramMap)
			throws Exception;
	public List<Fjimport> getFjimportList(Map<String, Object> paramMap);
	public List<FjimportHistory> getFjimportHistoryList(Map<String, Object> paramMap);
	public PageObject getFjimportHistoryListPage(
			Map<String, Object> paramMap, int startPage, int pageSize);

	public List<FjTeacherStudyInfo> FJTeacherAchievements(Map<String, Object> params)throws Exception;
	public List<SysArea> getDistrictList();
	public List<SysArea> getAreaListByUpcode(String upcode);
	/**
	 * 福建能力能力提升导入数据
	 * @param param
	 * @param startIndex
	 * @param pnnUserPageLimit
	 * @return
	 * @throws Exception
	 */
	public PageObject getFjimportListPage(Map<String, Object> param,int startIndex, int pnnUserPageLimit)throws Exception;

	public List<Fjimport> queryFjimportList(Map<String, Object> params)throws Exception;

	/**
	 * 查询角色列表
	 * @param userRoleType
	 * @param onlyManager
	 * @return
	 * @throws Exception
	 */
	public List<SysRole> queryRoleListByUser(Map<String, Object> param,Integer userRoleType, boolean onlyManager, boolean onlyShishi,boolean exceptShishi) throws Exception;

	public List<RoleType> getRoleTypeListByUser(Map<String, Object> param,Integer userRoleType);

	public int addRole(SysRole sysRole);

	public int saveTrainingInfo(List<Fjimport> objList) throws Exception;

	//记录系统日志
	public int insertSysLog(HttpServletRequest request,Map<String, Object> params);

	public List<EduDiploma> queryAllProjectDeploma() throws Exception;

	public FjimportActivty getFjimportShangbaoNumAndHegeNum(Map<String, Object> result) throws Exception;

	//查询教师学分汇总信息
	public PageObject getTeacherTrainScorePage(Map<String, Object> param,int startIndex, int pageSize) throws Exception;

	public PageObject getTeacherScoreHistoryListPage(Map<String, Object> param, int startIndex, int pnnUserPageLimit) throws Exception;

	public List<EduTeacherScoreInfo> queryTeacherScoreListNoPage(Map<String, Object> paramMap) throws Exception;

	public int updateTeacherScore(Map<String, Object> paramMap) throws Exception;

	public EduTeacherScoreInfo getTeacherScoreInfoById(Map<String, Object> result) throws Exception;

	public PageObject selectTeacherTrainScoreByTeacherId(Map<String, Object> param, int startIndex, int pageSize) throws Exception;

	public PageObject questionSurverSummaryList(Map<String, Object> param);

	public Integer updateCertificate(EduDiploma pojo);

	EduDiploma queryYearDeplomaById(Integer id, String projectId, int teacherId,
			String certificateView) throws Exception;

	public PageObject getTeacherTrainCreditPage(Map<String, Object> condition, int startIndex, int pnnUserPageLimit);

	public List<EduTeacherScoreInfo> getTeacherTrainRemainCredit(
			Map<String, Object> condition, int startIndex, int pageSize);

	public List<String> getNeedCredit(Map<String, Object> params);

	public int selectInitYear();
}
