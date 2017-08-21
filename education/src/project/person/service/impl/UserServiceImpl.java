package project.person.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.person.dao.IUserReadDAO;
import project.person.dao.IUserWriteDao;
import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;
import project.person.service.IUserService;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

public class UserServiceImpl implements IUserService {

	@Autowired
	@Qualifier("userReadDao")
	IUserReadDAO userReadDao;

	@Autowired
	@Qualifier("userWriteDao")
	IUserWriteDao userWriteDao;

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
			Map<String, Object> param) throws Exception {
		EduUserActivty userInfo = new EduUserActivty();

		userInfo = userReadDao.existUser(param);
		return userInfo;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param param
	 * @author cl
	 * @create date 2013-4-10
	 * @return
	 * @throws Exception
	 */
	public Integer updateOhterUser(EduUserActivty user) throws Exception {
		return userWriteDao.updateOtherUser(user);
	}

	/**
	 * 更新用户密码
	 * 
	 * @param param
	 * @author cl
	 * @create date 2013-4-10
	 * @return
	 * @throws Exception
	 */
	public Integer updatePsdUser(EduUserActivty user) throws Exception {
		return userWriteDao.updatePsdUser(user);
	}

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
	public PageObject queryManagesList(Map<String, Object> paramMap, int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(userReadDao.selectManagesCount(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<EduUser> list = userReadDao.selectManagesList(paramMap);
		po.setObjects(list);
		return po;
	}
	
	/**
	 * 新增管理员记录
	 * 
	 * @author cl
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer addManages(EduUser pojo) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("loginAccount", pojo.getLoginAccount());
		// 检查帐号是否存在
		if (userReadDao.selectManagesInfoCount(paramMap) > 0) {
			throw new Exception("-4");
		}
		return userWriteDao.insertManages(pojo);
	}

	/**
	 * 删除管理员记录
	 * 
	 * @author cl
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer deleteManages(EduUser pojo) throws Exception {
		return userWriteDao.deleteManages(pojo);
	}

	/**
	 * 查询管理员详细
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EduUser searchManagesInfo(Integer id) throws Exception {
		return userReadDao.selectSysManagesInfo(id);
	}

	/**
	 * 更新管理员记录
	 * 
	 * @author cl
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer updateManages(EduUser pojo) throws Exception {
		if (!pojo.getLoginAccount().equals(pojo.getOldLoginAccount())) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("loginAccount", pojo.getLoginAccount());
			// 检查帐号是否存在
			if (userReadDao.selectManagesInfoCount(paramMap) > 0) {
				throw new Exception("-4");
			}
		}
		return userWriteDao.updateManages(pojo);
	}

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
			throws Exception {
		return userReadDao.selectManagesListNoLimit(paramMap);
	}

	@Override
	public Integer userRegister(EduUser user) throws Exception {
		// TODO Auto-generated method stub
		return userWriteDao.insertUser(user);
	}

	@Override
	public boolean existUserByMail(String mail) throws Exception {
		// TODO Auto-generated method stub
		return userReadDao.existUserByMail(mail);
	}

	@Override
	public boolean existUserByIdNumber(String idNumber) throws Exception {
		// TODO Auto-generated method stub
		return userReadDao.existUserByIdNumber(idNumber);
	}

	@Override
	public boolean existUserByTeacherNo(String teacherNo) throws Exception {
		// TODO Auto-generated method stub
		return userReadDao.existUserByTeacherNo(teacherNo);
	}

	@Override
	public boolean existUserByLoginAccount(String loginAccount)
			throws Exception {
		// TODO Auto-generated method stub
		return userReadDao.existUserByLoginAccount(loginAccount);
	}

	@Override
	public boolean registerUser(Map<String, Object> paramMap) throws Exception {
		if (userWriteDao.registerUser(paramMap) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<EduUser> selectAllUserList(Map<String, Object> paramMap)
			throws Exception {
		return userReadDao.selectAllUserList(paramMap);
	}

	/**
	 * 生成管理员帐号
	 * 
	 * @param ids
	 *            管理员帐号信息集合
	 * @author cl
	 * @createDate 2014-4-26
	 * @return
	 * @throws Exception
	 */
	public boolean addManagesList(List<EduUser> ids) throws Exception {
		return userWriteDao.insertManagesList(ids);
	}

	/**
	 * 检查用户名是否存在（用户名不包括身份证、教师编号、登录帐号）
	 * 
	 * @author cl
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer searchLoginAccount(Map<String, Object> paramMap)
			throws Exception {
		return userReadDao.searchManagesLoginAccountCount(paramMap);
	}

	@Override
	public Integer getIdByLoginAccountAndMail(Map<String, Object> paramMap)
			throws Exception {
		return userReadDao.getIdByLoginAccountAndMail(paramMap);
	}

	@Override
	public EduUser getUserById(Integer id) throws Exception {
		return userReadDao.getUserById(id);
	}

	/**
	 * @author yinxiaolong
	 */
	@Override
	public boolean updateOrgAdminInfo(EduUser user) throws Exception {
		int result = userWriteDao.updateOrgAdmin(user);
		if (result == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author yinxiaolong
	 */
	@Override
	public EduUser selectOrgAdminInfo(Integer id) throws Exception {
		return userReadDao.selectOrgAdminInfo(id);
	}

	@Override
	public int getAdminVersion(Integer id) throws Exception {
		return userReadDao.getAdminVersion(id);
	}

	@Override
	public boolean existAdminById(Map<String, Object> map) throws Exception {
		return userReadDao.existAdminById(map);
	}

	@Override
	public boolean existAdminIdNumber(Map<String, Object> map) throws Exception {
		return userReadDao.existAdminIdNumber(map);
	}

	@Override
	public boolean existAdminEmail(Map<String, Object> emailMap)
			throws Exception {
		return userReadDao.existAdminEmail(emailMap);
	}

	@Override
	public boolean existAdminteacherNo(Map<String, Object> teacherNoMap)
			throws Exception {
		return userReadDao.existAdminteacherNo(teacherNoMap);
	}

	@Override
	public EduUser getUserByLoginAccountOrIdNumber(String loginAccount)
			throws Exception {
		// TODO Auto-generated method stub
		return userReadDao.getUserByLoginAccountOrIdNumber(loginAccount);
	}

	@Override
	public boolean deleteOrgAdminById(Integer id) throws Exception {
		return userWriteDao.deleteOrgAdminById(id);
	}

	@Override
	public PageObject getUserList(Map<String, Object> conditions,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = userReadDao.getUserCount(conditions);
		po.setCount(count);
		PageParser.getPageObject(
				PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduUser> proList = userReadDao.getUserList(conditions);
		po.setObjects(proList);
		return po;

	}
	
	@Override
	public List<EduUser> getUserListByParam(String[] roleIds) throws Exception{
		return userReadDao.getAllUserByParam(roleIds);
	}

	@Override
	public PageObject getRegionUserList(Map<String, Object> conditions,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = userReadDao.getRegionUserCount(conditions);
		po.setCount(count);
		PageParser.getPageObject(
				PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduUser> proList = userReadDao.getRegionUserList(conditions);
		po.setObjects(proList);
		return po;

	}

	/**
	 * 学分未登记的学员
	 */
	@Override
	public PageObject getRegionUserListNotrain(Map<String, Object> conditions,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = userReadDao.getRegionUserCountNotrain(conditions);
		po.setCount(count);
		PageParser.getPageObject(
				PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduUser> proList = userReadDao.getRegionUserListNotrain(conditions);
		po.setObjects(proList);
		return po;
	}

	/**
	 * 学分已登记的学员
	 */
	@Override
	public PageObject getRegionUserListNotrainEntered(
			Map<String, Object> conditions, int pageIndex, int pageSize)
			throws Exception {
		PageObject po = new PageObject();
		int count = userReadDao.getRegionUserCountNotrainEntered(conditions);
		po.setCount(count);
		PageParser.getPageObject(
				PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduUser> proList = userReadDao.getRegionUserListNotrainEntered(conditions);
		po.setObjects(proList);
		return po;
	}

	@Override
	public PageObject getRegionUserListTrain(Map<String, Object> conditions,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = userReadDao.getRegionUserListTrainCount(conditions);
		po.setCount(count);
		PageParser.getPageObject(
				PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduUser> proList = userReadDao.getRegionUserListTrain(conditions);
		po.setObjects(proList);
		return po;
	}

	@Override
	public boolean batchDelMgrsByIds(String mgrIds, String account) throws Exception {
		String[] ids = mgrIds.split(",");
		return userWriteDao.batchDelMgrsByIds(ids, account);
	}

	// 查询用户身份信息(用于福建网络研修平台对接实现单点登录)
	public EduUser getUserById(String idNumber) throws Exception {
		return userReadDao.queryUserByIdNumber(idNumber);
	}

	//批量修改管理员角色
	public boolean batchModifyMgrsByIds(String ids, int roleId)
			throws Exception {
		// TODO Auto-generated method stub
		String[] mgrIds = ids.split(",");
		return userWriteDao.batchDelMgrsByIds(mgrIds, roleId);
	}

	 
}
