package project.person.service;

import java.util.List;
import java.util.Map;

import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;
import framelib.utils.page.PageObject;

public interface IUserService {

	/**
	 * 登录获取用户信息
	 * 
	 * @param param
	 *            用户名、密码
	 * @author cl
	 * @create date 2013-4-3
	 * @return
	 * @throws Exception
	 */
	public EduUserActivty queryUserInfoByloginAccountAndPsd(
			Map<String, Object> param) throws Exception;

	/**
	 * 更新用户信息
	 * 
	 * @param param
	 * @author cl
	 * @create date 2013-4-10
	 * @return
	 * @throws Exception
	 */
	public Integer updateOhterUser(EduUserActivty user) throws Exception;

	/**
	 * 更新用户密码
	 * 
	 * @param param
	 * @author cl
	 * @create date 2013-4-10
	 * @return
	 * @throws Exception
	 */
	public Integer updatePsdUser(EduUserActivty user) throws Exception;

	/**
	 * 管理员管理列表
	 * 
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @param pageIndex
	 *            当前页
	 * @param pageSize
	 *            页大小
	 * @return
	 * @throws Exception
	 */
	public PageObject queryManagesList(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception;
	
	/**
	 * 管理员管理列表
	 * 
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduUser> queryManagesList(Map<String, Object> paramMap)
			throws Exception;

	/**
	 * 新增管理员记录
	 * 
	 * @author cl
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer addManages(EduUser pojo) throws Exception;

	/**
	 * 查询管理员详细
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EduUser searchManagesInfo(Integer id) throws Exception;

	/**
	 * 更新管理员记录
	 * 
	 * @author cl
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer updateManages(EduUser pojo) throws Exception;

	/**
	 * 删除管理员记录
	 * 
	 * @author cl
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer deleteManages(EduUser pojo) throws Exception;
	
	/**
	 * 用户注册 
	 * @param user
	 * @return
	 */
	public Integer userRegister(EduUser user) throws Exception;

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

	boolean registerUser(Map<String, Object> paramMap) throws Exception;

	/**
	 * 注册验证用户名
	 * 
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduUser> selectAllUserList(Map<String, Object> paramMap)
			throws Exception;
	
	/**
	 * 生成管理员帐号
	 * @param ids 管理员帐号信息集合
	 * @author cl
	 * @createDate 2014-4-26
	 * @return
	 * @throws Exception
	 */
	public boolean addManagesList(final List<EduUser> ids)
			throws Exception;
	
	/**
	 * 检查用户名是否存在
	 * 
	 * @author cl
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer searchLoginAccount(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * @author yinxiaolong
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EduUser selectOrgAdminInfo(Integer id) throws Exception;
	
	/**
	 * 修改机构管理员信息
	 * @author yinxiaolong
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean updateOrgAdminInfo(EduUser user) throws Exception;
	
	/**
	 * @author yinxiaolong
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	public int getAdminVersion(Integer id)throws Exception;
	/**
	 * @author yinxiaolong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	boolean existAdminById(Map<String, Object> map) throws Exception;
	
	/**
	 * @author yinxiaolong
	 * 检查身份证号是否存在
	 * @param mail
	 * @return
	 * @throws Exception
	 */
	boolean existAdminIdNumber(Map<String, Object> map) throws Exception;
	
	/**
	 * @author yinxiaolong
	 * @param emailMap
	 * @return
	 * @throws Exception
	 */
	boolean existAdminEmail(Map<String, Object> emailMap) throws Exception;
	/**
	 * @author yinxiaolong
	 * @param teacherNoMap
	 * @return
	 * @throws Exception
	 */
	boolean existAdminteacherNo(Map<String, Object> teacherNoMap)throws Exception;
	

	public Integer getIdByLoginAccountAndMail(Map<String, Object> paramMap) throws Exception;

	EduUser getUserById(Integer id) throws Exception;
/**
 *  删除机构管理员
 * @author yinxiaolong
 * @param loginAccount
 * @return
 * @throws Exception
 */
	public EduUser getUserByLoginAccountOrIdNumber(String loginAccount) throws Exception ;
	
	boolean deleteOrgAdminById(Integer id)throws Exception ;

	public PageObject getUserList(Map<String, Object> conditions, int pageIndex, int pageSize) throws Exception;

	public List<EduUser> getUserListByParam(String[] params) throws Exception;

	
	public PageObject getRegionUserList(Map<String, Object> conditions,
			int pageIndex, int pageSize)throws Exception;

	public PageObject getRegionUserListNotrain(Map<String, Object> conditions,
			int pageIndex, int pageSize)throws Exception;

	public PageObject getRegionUserListNotrainEntered(
			Map<String, Object> conditions, int pageIndex, int pageSize)throws Exception;

	public PageObject getRegionUserListTrain(Map<String, Object> conditions,
			int pageIndex, int pageSize)throws Exception;

	public boolean batchDelMgrsByIds(String ids, String account) throws Exception;
	
	// 根据idNumber查询用户身份信息,用于福建网络研修平台对接实现单点登录
	public EduUser getUserById(String idNumber) throws Exception;

	public boolean batchModifyMgrsByIds(String ids, int roleId) throws Exception;

	 

}
