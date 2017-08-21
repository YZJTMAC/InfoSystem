package project.person.dao;

import java.util.List;
import java.util.Map;

import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;

/**
 * 
 * 教师信息控制器
 * @Create_by:dengguo
 * @Create_date:2014-1-8
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 * 
 */
public interface IUserWriteDao {
	
	/**
	 * 保存User
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer insertUser(EduUser user)throws Exception;

	/**
	 * 更新user
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer updateUser(EduUser user) throws Exception;

	public Integer updateUserStatus(String data , String optionBy, Integer status, Integer version) throws Exception;
	public Integer deleteTeacher(String data ) throws Exception;
	
	/**
	 * 更新user
	 * @author cl
	 * @create date 2014-4-10
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer updateOtherUser(EduUserActivty user) throws Exception;
	
	/**
	 * 更新user
	 * @author cl
	 * @create date 2014-4-10
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer updatePsdUser(EduUserActivty user) throws Exception;
	
	/**
	 * 新增管理员记录
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	Integer insertManages(EduUser info) throws Exception;
	
	/**
	 * 更新管理员记录
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	Integer updateManages(EduUser info) throws Exception;
	
	/**
	 * 删除管理员记录
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	Integer deleteManages(EduUser info) throws Exception;

	/**
	 * 教师审核操作
	 * @param id
	 * @param optionBy
	 * @param status
	 * @param memo
	 * @return
	 * @throws Exception
	 */
	Integer updateAuditUser(String id, String optionBy,String optionRealName, Integer status,
			String memo) throws Exception;
	
	/**
	 * 用户注册
	 * @author yinxiaolong
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer registerUser(Map<String, Object> paramMap)throws Exception;
	
	/**
	 * 生成管理员帐号
	 * @param ids 管理员帐号信息集合
	 * @return
	 * @throws Exception
	 */
	public boolean insertManagesList(final List<EduUser> ids)
			throws Exception;
	
	public Integer updateOrgAdmin(EduUser user) throws Exception;
	
	/**
	 * 删除机构管理员
	 * @author yinxiaolong
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean deleteOrgAdminById(Integer id)throws Exception;

	public boolean batchDelMgrsByIds(String[] ids, String account) throws Exception;

	public boolean batchDelMgrsByIds(String[] ids, int roleId) throws Exception;

}
