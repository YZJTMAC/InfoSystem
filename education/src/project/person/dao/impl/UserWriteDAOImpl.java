package project.person.dao.impl;


import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;

import project.person.dao.IUserWriteDao;
import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;

import com.ibatis.sqlmap.client.SqlMapExecutor;

import framelib.dao.BaseDAOImpl;

/**
 * 
 * @Create_by:dengguo
 * @Create_date:2014-3-28
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 * 
 */
public class UserWriteDAOImpl  extends BaseDAOImpl implements IUserWriteDao{

	@Override
	public Integer updateUserStatus(String id, String optionBy, Integer status, Integer version) throws Exception {
		if(id == null && optionBy == null) {
			return -1;
		}
		Map<String, Object> param = new HashMap<String, Object> ();
		param.put("id", id);
		param.put("updateBy", optionBy);
		param.put("version", version);
		param.put("status", status);
		return updateUserStatus(param);
	}
	
	@Override
	public Integer deleteTeacher(String data) throws Exception {
		// TODO Auto-generated method stub
		if(data == null ) {
			return -1;
		}
		return deleteTeacherStatus(data);
	}
	
	@Override
	public Integer updateAuditUser(String id, String optionBy, String optionRealName, Integer status, String memo) throws Exception {
		if(id == null && optionBy == null) {
			return -1;
		}
		Map<String, Object> param = new HashMap<String, Object> ();
		param.put("id", id);
		param.put("optionBy", optionRealName);
		param.put("updateBy", optionBy);
		param.put("auditDate", new Date());
		param.put("status", status);
		param.put("memo", memo);
		return updateUserStatus(param);
	}
	
	public Integer updateUserStatus(Map<String, Object> param) throws Exception {
		Object obj = this.getSqlMapClientTemplate().update("update_user_versionOrStatus", param);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	public Integer deleteTeacherStatus(String id) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		int i = this.getSqlMapClientTemplate().delete("deleteTeacheres", paramMap);
		if (i>0) {
			return i;
		} else {
			return -1;
		}
	}


	@Override
	public Integer insertUser(EduUser user) throws Exception {
		Object obj;
		try {
			obj = this.getSqlMapClientTemplate().insert("user_insert", user);
			if (obj != null) {
				return (Integer) obj;
			} else {
				return -1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("用户保存失败！请检查身份证号为："+user.getIdNumber()+" 的用户的身份证号码、用户名、教师编号是否已经存在，谢谢！");
		}
		
	}
	
	@Override
	public Integer updateUser(EduUser user) throws Exception {
		Object obj = this.getSqlMapClientTemplate().update("user_update", user);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * 更新user
	 * @author cl
	 * @create date 2014-4-10
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer updateOtherUser(EduUserActivty user) throws Exception {
		Object obj = this.getSqlMapClientTemplate().update("user_other_update", user);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * 更新user
	 * @author cl
	 * @create date 2014-4-10
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer updatePsdUser(EduUserActivty user) throws Exception {
		Object obj = this.getSqlMapClientTemplate().update("user_psd_update", user);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * 删除管理员记录
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public Integer deleteManages(EduUser info) throws Exception {
		Integer id = (Integer)this.getSqlMapClientTemplate().update("delete_sys_manages",info);
		if(id != null){
			return 0;
		}
		return -1;
	}

	/**
	 * 新增管理员记录
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public Integer insertManages(EduUser info) throws Exception {
		Integer id = (Integer)this.getSqlMapClientTemplate().insert("insert_sys_manages",info);
		if(id == null){
			return 0;
		}
		return -1;
	}

	/**
	 * 更新管理员记录
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public Integer updateManages(EduUser info) throws Exception {
		Integer id = (Integer)this.getSqlMapClientTemplate().update("update_sys_manages",info);
		if(id != null){
			return 0;
		}
		return -1;
	}

	@Override
	public Integer registerUser(Map<String, Object> paramMap) throws Exception {
		Integer count = (Integer) this.getSqlMapClientTemplate().insert("user_register", paramMap);
			return count;
	}
	
	/**
	 * 生成管理员帐号
	 * @param ids 管理员帐号信息集合
	 * @return
	 * @throws Exception
	 */
	public boolean insertManagesList(final List<EduUser> ids)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {

			@Override
			public Object doInSqlMapClient(SqlMapExecutor arg0) throws SQLException {
				arg0.startBatch();
				for(EduUser id:ids){
					arg0.insert("user_insert",id);
				}
				
				return arg0.executeBatch();
			}
			
		});
		if(obj != null && (Integer)obj>0){
			return true;
		}
		return false;
	}

	@Override
	public Integer updateOrgAdmin(EduUser user) throws Exception {
		Object obj = this.getSqlMapClientTemplate().update("org_update_admin_info", user);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public boolean deleteOrgAdminById(Integer id) throws Exception {
		int count = this.getSqlMapClientTemplate().update("org_update_admin_status",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean batchDelMgrsByIds(final String[] ids, final String account) throws Exception {
		Object obj = this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {
			
			@Override
			public Object doInSqlMapClient(SqlMapExecutor arg0) throws SQLException {
				arg0.startBatch();
				for(String id:ids){
					EduUser user = new EduUser();
					user.setUpdateBy(account);
					user.setId(Integer.parseInt(id));
					user.setStatus(0);
					arg0.update("delete_sys_manages", user);
				}
				return arg0.executeBatch();
			}
		});
		if(obj != null){
			int i = (Integer)obj;
			if(i>0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	public boolean batchDelMgrsByIds(final String[] ids, final int roleId) throws Exception {
		// TODO Auto-generated method stub
		Object obj = this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {
				
				@Override
				public Object doInSqlMapClient(SqlMapExecutor arg0) throws SQLException {
					arg0.startBatch();
					for(String id:ids){
						EduUser user = new EduUser();
						user.setId(Integer.parseInt(id));
						//修改角色id
						user.setRoleId(roleId);
						arg0.update("update_sys_manages", user);
					}
					return arg0.executeBatch();
				}
			});
			if(obj != null){
				int i = (Integer)obj;
				if(i>0){
					return true;
				}else{
					return false;
				}
			}
			return false;
	}

	
	
	
}
