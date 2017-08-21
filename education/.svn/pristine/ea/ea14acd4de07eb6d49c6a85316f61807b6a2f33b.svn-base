package project.system.dao;

import java.util.List;
import java.util.Map;

import project.edupm.projectmanage.pojo.EduProjectNotrain;
import project.furtheredu.certificate.pojo.EduDiploma;
import project.organization.dto.OrganizationDto;
import project.system.pojo.EduSchool;
import project.system.pojo.EduTeacherScoreInfo;
import project.system.pojo.Fjimport;
import project.system.pojo.FjimportHistory;
import project.system.pojo.SysArea;
import project.system.pojo.SysPlatformSetup;
import project.system.pojo.SysRole;
import project.system.pojo.SysSetup;

public interface ISysWriteDAO {
	
	boolean insertSysArea(SysArea area) throws Exception;

	/**
	 * 保存证书 
	 * @param pojo
	 * @return
	 */
	Integer insertCertificate(EduDiploma pojo);

	Integer updateCertificate(EduDiploma pojo);
	
	Integer deleteCertificate(Integer id);
	
	/**
	 * 更新角色
	 * @param pojo
	 * @return
	 */
	Integer updateRole(SysRole pojo);
	
	/**
	 * 新增学校记录
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	Integer insertSchool(EduSchool info) throws Exception;
	
	/**
	 * 更新学校记录
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	Integer updateSchool(EduSchool info) throws Exception;
	
	/**
	 * 删除学校记录
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	Integer deleteSchool(EduSchool info) throws Exception;
	/**
	 * 增加机构 
	 * @author yinxiaolong
	 * @return
	 * @throws Exception
	 */
	boolean insertOrganizationInfo(Map<String, Object> paramMap) throws Exception;
	/**
	 * 增加机构时增加的User
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	boolean insertUserInfo(Map<String, Object> paramMap) throws Exception;
	/**
	 * 机构修改
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	boolean updateOrganizationInfo(Map<String,Object> paramMap) throws Exception;
	/**
	 * 机构删除
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	boolean deleteOrganizationInfo(Map<String,Object> paramMap) throws Exception;
	/**
	 * 系统设置--功能设置修改
	 * @author zxq
	 * @return
	 */
	int updateSysSetup(SysSetup pojo) throws Exception;
	/**
	 * 批量导入机构
	 * @author yinxiaolong
	 * @param dtos
	 * @param params
	 * @return
	 * @throws Exception
	 */
	boolean batchOrg(List<OrganizationDto> dtos,Map<String, Object> params) throws Exception;
	/**
	 * 批量导入User
	 * @author yinxiaolong
	 * @param dtos
	 * @param params
	 * @return
	 * @throws Exception
	 */
	boolean batchUser(List<OrganizationDto> dtos,Map<String, Object> params) throws Exception;

	
	int updateSysArea(Map<String,Object> params,int id) throws Exception;
	
	boolean deleteArea(int id) throws Exception;
	
	int insertSysAreaRtnID(SysArea area) throws Exception;
	
	/**
	 * 批量导入学校
	 * @param ids 学校信息集合
	 * @param account 当前登录人
	 * @return
	 * @throws Exception
	 */
	public boolean insertSchool(final List<EduSchool> ids,final String account)
			throws Exception;
	
	/**
	 * 更新角色信息
	 * @param pojo
	 * @return
	 */
	public Integer updateRoleInfo(SysRole pojo)throws Exception;
	
	/**删除角色拥有的权限
	 * @param pojo
	 * @return
	 */
	public Integer deleteRoleFunc(Integer id)throws Exception;
	
	/**增加角色拥有的权限
	 * @param pojo
	 * @return
	 */
	public Integer insertRoleFunc(final List<SysRole> pojo)throws Exception;
	
	/**
	 * 查询所有下级地区
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Integer> selectArea(int id) throws Exception;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteNotrain(Integer id);
	/**
	 * 
	 * @param notrain
	 * @return
	 */
	public Integer updateNotrain(EduProjectNotrain notrain);
	/**
	 * 
	 * @param notrain
	 * @return
	 */
	public Integer insertNotrain(EduProjectNotrain notrain);

	boolean enterCredit(Map<String, Object> params)throws Exception;

	boolean auditCredit(Map<String, Object> params)throws Exception;

	/**
	 * 修改系统平台设置
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	int updatePlatformSetup(SysPlatformSetup pojo)throws Exception;
	
	/**
	 * 
	 * */
	int insertFJimport(Fjimport d);
	int fjimportCountByKey(Fjimport d);
	int updateFjimport(Fjimport d);
	List<Fjimport> getFjimportList(Map<String, Object> params);
	
	/**
	 * 
	 * */
	int insertFJimportHistory(FjimportHistory d);
	List<FjimportHistory> getFjimportHistoryList(Map<String, Object> params);
	int getFjimportHistoryCount(Map<String, Object> params);

	Boolean insertFjTeacherStudyInfo(Map<String, Object> param);

	int getFjimportListCount(Map<String, Object> param)throws Exception;

	List<Fjimport> getFjimportListPage(Map<String, Object> param)throws Exception;

	List<Fjimport> queryFjimportList(Map<String, Object> params)throws Exception;

	int insertRole(SysRole sysRole);

	int insertSysLog(Map<String, Object> params);

	public int deleteTrainingInfoByStatus(List<Fjimport> objList) throws Exception;

	public int updateEduTeacherTrainScoreInfo(Map<String, Object> params) throws Exception;

	public int insertEduTeacherTrainScoreInfo(EduTeacherScoreInfo pojo) throws Exception;
	
}
