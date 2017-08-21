package project.person.dao.impl;

import java.util.List;
import java.util.Map;

import project.person.dao.IUserReadDAO;
import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;
import framelib.dao.BaseDAOImpl;

@SuppressWarnings("unchecked")
public class UserReadDAOImpl extends BaseDAOImpl implements IUserReadDAO {

	/**
	 * 检查用户登录 并获取用户信息
	 * 
	 * @param param
	 *            用户名、密码
	 * @author cl
	 * @create date 2013-4-3
	 * @return
	 * @throws Exception
	 */
	public EduUserActivty existUser(Map<String, Object> param) throws Exception {
		return (EduUserActivty) this.getSqlMapClientTemplate().queryForObject(
				"existUserByLoginAccountAndPsd", param);

	}

	/**
	 * 管理员管理 记录总数
	 * 
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectManagesCount(Map<String, Object> paramMap)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject(
				"selectManagesCount", paramMap);
		return count;
	}

	/**
	 * 管理员管理 记录列表
	 * 
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */

	public List<EduUser> selectManagesList(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectManagesList", paramMap);
	}
	
	/**
	 * 管理员管理 记录列表(不分页)
	 * 
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */

	public List<EduUser> selectManagesListNoLimit(Map<String, Object> paramMap)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectManagesListNoLimit",
				paramMap);
	}

	/**
	 * 管理员管理  记录总数(检查帐号是否存在等。。。)
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectManagesInfoCount(Map<String, Object> paramMap)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject(
				"selectManagesInfoCount", paramMap);
		return count;
	}

	 /**
	 * 管理员管理 查看详情
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduUser selectSysManagesInfo(Integer id) throws Exception {
		return  (EduUser)this.getSqlMapClientTemplate().queryForObject("selectSysManagesInfo", id);
	}

	@Override
	public int countUserByCondition(Map<String, Object> params)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_user_by_conditions",params);
		if(obj != null){
			return (Integer)obj;
		}
		return 0;
	}
	
	@Override
	public boolean existUserByMail(String mail)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject("existUserByMail",mail);
		if(count > 0){
			return true;
		}
		return false;
	}
	@Override
	public boolean existUserByLoginAccount(String loginAccount)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject("existUserByLoginAccount",loginAccount);
		if(count > 0){
			return true;
		}
		return false;
	}
	@Override
	public boolean existUserByTeacherNo(String teacherNo)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject("existUserByTeacherNo",teacherNo);
		if(count > 0){
			return true;
		}
		return false;
	}
	@Override
	public boolean existUserByIdNumber(String idNumber)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject("existUserByIdNumber",idNumber);
		if(count > 0){
			return true;
		}
		return false;
	}
	@Override
	public Integer getIdByLoginAccountAndMail(Map<String, Object> paramMap)
			throws Exception {
		 Integer uid = (Integer) this.getSqlMapClientTemplate().queryForObject("getIdByLoginAccountAndMail",paramMap);
		return uid;
	}
	
	@Override
	public List<EduUser> selectAllUserList(Map<String, Object> paramMap)
			throws Exception {
		List<EduUser> list = this.getSqlMapClientTemplate().queryForList("selectAllUserList",paramMap);
		return list;
	}
	
	
	
	/**
	 * 检查帐号是否存在等 （是否已经包含身份证号、教师编号、用户帐号）
	 * @author cl
	 * @create date 2014-4-14
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int searchManagesLoginAccountCount(Map<String, Object> paramMap)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject(
				"selectLoginAccountCount", paramMap);
		return count;
	}
/**
 * @author yinxiaolong
 */
	@Override
	public EduUser selectOrgAdminInfo(Integer id) throws Exception {
		return (EduUser) this.getSqlMapClientTemplate().queryForObject("org_admin_info",id);
	}

@Override
public int getAdminVersion(Integer id) throws Exception {
	return (Integer) this.getSqlMapClientTemplate().queryForObject("get_user_version",id);
}

	@Override
	public EduUser getUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return (EduUser) this.getSqlMapClientTemplate().queryForObject("getUserById", id);
	}

	@Override
	public EduUser getUserByLoginAccountOrIdNumber(String loginAccount) throws Exception {
		// TODO Auto-generated method stub
		return (EduUser) this.getSqlMapClientTemplate().queryForObject("getUserByLoginAccountOrIdNumber", loginAccount);
	}

@Override
public boolean existAdminById(Map<String, Object> map) throws Exception {
	int count = (Integer) this.getSqlMapClientTemplate().queryForObject("get_exist_admin",map);
	if(count > 0){
		return true;
	}
	return false;
}

@Override
public boolean existAdminIdNumber(Map<String, Object> map) throws Exception {
	int count = (Integer) this.getSqlMapClientTemplate().queryForObject("exist_admin_IdNumber",map);
	if(count > 0){
		return true;
	}
	return false;
}

@Override
public boolean existAdminEmail(Map<String, Object> emailMap) throws Exception {
	int count = (Integer) this.getSqlMapClientTemplate().queryForObject("exist_admin_email",emailMap);
	if(count > 0){
		return true;
	}
	return false;
}

@Override
public boolean existAdminteacherNo(Map<String, Object> teacherNoMap)
		throws Exception {
	int count = (Integer) this.getSqlMapClientTemplate().queryForObject("exist_admin_teacherNo",teacherNoMap);
	if(count > 0){
		return true;
	}
	return false;
}

@Override
public int getUserCount(Map<String, Object> conditions) throws Exception {
	Object obj = this.getSqlMapClientTemplate().queryForObject("count_mgr_select_user",conditions);
	if(obj == null){
		return 0;
	}
	return (Integer)obj;
}

 

@Override
public List<EduUser> getUserList( Map<String, Object> conditions) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("mgr_select_user_list",conditions);
}

@Override
public List<EduUser> getAllUserByParam( String[] roleIds) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("getAllUserByParam",roleIds);
}


@Override
public int getRegionUserCount(Map<String, Object> conditions) throws Exception {
	Object obj = this.getSqlMapClientTemplate().queryForObject("getRegionUserCount",conditions);
	if(obj == null){
		return 0;
	}
	return (Integer)obj;
}

@Override
public List<EduUser> getRegionUserList(Map<String, Object> conditions)
		throws Exception {
	return this.getSqlMapClientTemplate().queryForList("getRegionUserList",conditions);
}

@Override
public int getRegionUserCountNotrain(Map<String, Object> conditions)
		throws Exception {
	Object obj = this.getSqlMapClientTemplate().queryForObject("getRegionUserCountNotrain",conditions);
	if(obj == null){
		return 0;
	}
	return (Integer)obj;
}

@Override
public List<EduUser> getRegionUserListNotrain(Map<String, Object> conditions)
		throws Exception {
	return this.getSqlMapClientTemplate().queryForList("getRegionUserListNotrain",conditions);
}

@Override
public int getRegionUserCountNotrainEntered(Map<String, Object> conditions)
		throws Exception {
	Object obj = this.getSqlMapClientTemplate().queryForObject("count_getRegionUserNotrainEntered",conditions);
	if(obj == null){
		return 0;
	}
	return (Integer)obj;
}

@Override
public List<EduUser> getRegionUserListNotrainEntered(
		Map<String, Object> conditions) throws Exception {
	return this.getSqlMapClientTemplate().queryForList("getRegionUserListNotrainEntered",conditions);
}

@Override
public int getRegionUserListTrainCount(Map<String, Object> conditions)
		throws Exception {
	Object obj = this.getSqlMapClientTemplate().queryForObject("count_getRegionUserListTrain",conditions);
	if(obj == null){
		return 0;
	}
	return (Integer)obj;
}

@Override
public List<EduUser> getRegionUserListTrain(Map<String, Object> conditions)
		throws Exception {
	return this.getSqlMapClientTemplate().queryForList("getRegionUserListTrain",conditions);
}

// 根据idNumber查询用户信息,用于福建网络研修平台对接实现单点登录
public EduUser queryUserByIdNumber(String idNumber) throws Exception {
	return (EduUser) this.getSqlMapClientTemplate().queryForObject("queryUserByIdNumber",idNumber);
}

/**
 * 教师离退休管理，导入离退休教师，是否已离退休
 * @param conditions
 * @return
 * @throws Exception
 */
@Override
public int countUserByRetiree(Map<String, Object> conditions) throws Exception {
	Object obj = this.getSqlMapClientTemplate().queryForObject("count_user_by_Retiree",conditions);
	if(obj != null){
		return (Integer)obj;
	}
	return 0;
}

	/**
	 * 获取指定范围及角色下用户
	 */
	@Override
	public List<EduUser> getUsersByRoleAndArea(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("getUsersByRoleAndArea", paramMap);
	}

	/**
	 * 获取指定项目下参训教师及项目申报人
	 */
	@Override
	public List<EduUser> selectUsersByProjectId(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectUsersByProjectId", paramMap);
	} 
}
