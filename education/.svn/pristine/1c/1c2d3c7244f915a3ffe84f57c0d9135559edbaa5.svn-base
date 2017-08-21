package project.person.dao;

import java.util.List;
import java.util.Map;

import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;

public interface IUserReadDAO {
	
	/**
	 * 检查用户登录  并获取用户信息
	 * @param param 用户名、密码
	 * @author cl
	 * @create date 2013-4-3
	 * @return 
	 * @throws Exception
	 */
	public EduUserActivty existUser(Map<String, Object> param)
			throws Exception;
	
	/**
	 * 管理员管理  记录总数
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectManagesCount(Map<String, Object> paramMap) throws Exception;

	 /**
	 * 管理员管理  记录列表
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduUser> selectManagesList(Map<String, Object> paramMap) throws Exception;
	
	
	/**
	 * 管理员管理 记录列表(不分页)
	 * 
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduUser> selectManagesListNoLimit(Map<String, Object> paramMap)throws Exception;
	
	/**
	 * 管理员管理  记录总数(检查帐号是否存在等。。。)
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectManagesInfoCount(Map<String, Object> paramMap) throws Exception;
	
	 /**
	 * 管理员管理 查看详情
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduUser selectSysManagesInfo(Integer id) throws Exception;
	
	int countUserByCondition(Map<String,Object> params) throws Exception;

	/**
	 * 检查邮箱是否存在
	 * @param mail
	 * @return
	 * @throws Exception
	 */
	boolean existUserByMail(String mail) throws Exception;
	/**
	 * 检查身份证号是否存在
	 * @param mail
	 * @return
	 * @throws Exception
	 */
	boolean existUserByIdNumber(String idNumber) throws Exception;
	/**
	 * 检查教师编号是否存在
	 * @param mail
	 * @return
	 * @throws Exception
	 */
	boolean existUserByTeacherNo(String teacherNo) throws Exception;
	/**
	 * 检查登录名是否存在
	 * @param mail
	 * @return
	 * @throws Exception
	 */
	boolean existUserByLoginAccount(String loginAccount) throws Exception;
	/**
	 * 注册验证用户名
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduUser> selectAllUserList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 检查帐号是否存在等 （是否已经包含身份证号、教师编号、用户帐号）
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int searchManagesLoginAccountCount(Map<String, Object> paramMap)
			throws Exception;
	/**
	 * @author yinxiaolong
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EduUser selectOrgAdminInfo(Integer id) throws Exception;
	
	/**
	 * 获取最大版本号
	 * @author yinxiaolong
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int getAdminVersion(Integer id)throws Exception;
	
	/**
	 * 修改、验证管理员重复
	 * @author yinxiaolong
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean existAdminById(Map<String, Object> map) throws Exception;
	
	
	boolean existAdminIdNumber(Map<String, Object> map) throws Exception;
	
	boolean existAdminEmail(Map<String, Object> emailMap) throws Exception;
	
	boolean existAdminteacherNo(Map<String, Object> teacherNoMap) throws Exception;

	Integer getIdByLoginAccountAndMail(Map<String, Object> paramMap) throws Exception;
	public EduUser getUserById(Integer id) throws Exception ;

	public EduUser getUserByLoginAccountOrIdNumber(String loginAccount) throws Exception ;

 

	public int getUserCount(Map<String, Object> conditions) throws Exception;

	public List<EduUser> getUserList(Map<String, Object> conditions) throws Exception;
	
	public List<EduUser> getAllUserByParam( String[] roleIds) throws Exception;
	

	public int getRegionUserCount(Map<String, Object> conditions)throws Exception;

	public List<EduUser> getRegionUserList(Map<String, Object> conditions)throws Exception;

	public int getRegionUserCountNotrain(Map<String, Object> conditions)throws Exception;

	public List<EduUser> getRegionUserListNotrain(Map<String, Object> conditions)throws Exception;

	public int getRegionUserCountNotrainEntered(Map<String, Object> conditions)throws Exception;

	public List<EduUser> getRegionUserListNotrainEntered(
			Map<String, Object> conditions)throws Exception;

	public int getRegionUserListTrainCount(Map<String, Object> conditions)throws Exception;

	public List<EduUser> getRegionUserListTrain(Map<String, Object> conditions)throws Exception;

	// 查询用户身份信息(用于福建网络研修平台对接实现单点登录)
	public EduUser queryUserByIdNumber(String idNumber)throws Exception;
 
	/**
	 * 教师离退休管理，导入离退休教师，是否已离退休
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public int countUserByRetiree(Map<String, Object> conditions) throws Exception;
	
	/**
	 * 获取指定范围及角色下用户
	 */
	public List<EduUser> getUsersByRoleAndArea(Map<String, Object> conditions) throws Exception;
	
	/**
	 * 获取指定项目下参训教师及项目申报人
	 */
	public List<EduUser> selectUsersByProjectId(Map<String, Object> conditions) throws Exception;
}
