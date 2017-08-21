package project.system.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;

import com.ibatis.sqlmap.client.SqlMapExecutor;



import project.edupm.projectmanage.pojo.EduProjectNotrain;
import project.furtheredu.certificate.pojo.EduDiploma;
import project.organization.dto.OrganizationDto;
import project.system.dao.ISysWriteDAO;
import project.system.pojo.EduSchool;
import project.system.pojo.EduTeacherScoreInfo;
import project.system.pojo.Fjimport;
import project.system.pojo.FjimportHistory;
import project.system.pojo.SysArea;
import project.system.pojo.SysPlatformSetup;
import project.system.pojo.SysRole;
import project.system.pojo.SysSetup;
import framelib.dao.BaseDAOImpl;

public class SysWriteDAOImpl extends BaseDAOImpl implements ISysWriteDAO{

	@Override
	public boolean insertSysArea(SysArea area) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("area_insert",area);
		if(obj != null){
			int id = (Integer)obj;
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("code", id);
			int i =this.updateSysArea(params, id);
			if(i >0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	@Override
	public Integer updateCertificate(EduDiploma pojo) {
		Object object = this.getSqlMapClientTemplate().insert("certificate_update",pojo);
		if(object != null){
			return 0;
		}
		return 0;
	}
	
	@Override
	public Integer deleteCertificate(Integer id) {
		Object obj = this.getSqlMapClientTemplate().delete("certificate_delete",id);
		if(obj != null){
			return 0;
		}
		return -1;
	}

	@Override
	public Integer insertCertificate(EduDiploma pojo) {
		Integer id = (Integer)this.getSqlMapClientTemplate().insert("certificate_insert",pojo);
		if(id != null){
			return id;
		}
		return -1;
	}

	/**
	 * 更新角色
	 * @param pojo
	 * @return
	 */
	public Integer updateRole(SysRole pojo) {
		Object obj = this.getSqlMapClientTemplate().update("updateRole", pojo);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * 新增学校记录
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public Integer insertSchool(EduSchool info) throws Exception {
		Integer id = (Integer)this.getSqlMapClientTemplate().insert("insert_school",info);
		if(id == null){
			return 0;
		}
		return -1;
	}

	/**
	 * 删除学校记录
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public Integer deleteSchool(EduSchool info) throws Exception {
		Integer id = (Integer)this.getSqlMapClientTemplate().update("delete_school",info);
		if(id != null){
			return 0;
		}
		return -1;
	}

	/**
	 * 更新学校记录
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public Integer updateSchool(EduSchool info) throws Exception {
		Integer id = (Integer)this.getSqlMapClientTemplate().update("update_school",info);
		if(id != null){
			return 0;
		}
		return -1;
	}

	@Override
	public boolean insertOrganizationInfo(Map<String, Object> paramMap)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("insertOrganizationInfo",paramMap);
		if(obj == null){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateOrganizationInfo(Map<String, Object> paramMap)
			throws Exception {
		boolean flag = false;
		int result = this.getSqlMapClientTemplate().update("updateOrganization",paramMap);
		if(result>0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteOrganizationInfo(Map<String, Object> paramMap)
			throws Exception {
		boolean flag = false;
		int result = this.getSqlMapClientTemplate().update("deleteOrganization",paramMap);
		if(result>0){
			flag = true;
		}
		return flag;
	}

	
	/**
	 * 系统设置--功能设置修改
	 * @author zxq
	 * @return
	 */
	@Override
	public int updateSysSetup(SysSetup pojo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().update("updateSysSetup", pojo);
	}
/**
 * 批量导入机构
 * @author yinxiaolong
 */
	@Override
	public boolean batchOrg(final List<OrganizationDto> dtos, final Map<String, Object> params) throws Exception {
		Object obj = this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {
			@Override
			public Object doInSqlMapClient(SqlMapExecutor arg0)throws SQLException {
				arg0.startBatch();
				for(OrganizationDto val : dtos){
					params.put("organizationName", val.getOrganizationName());
					params.put("contacts", val.getContacts());
					params.put("contactsType", val.getContactsType());
					params.put("organizationAdderss", val.getOrganizationAdderss());
					params.put("memo", val.getMemo());
					params.put("type", val.getType());
					params.put("provinceId", val.getOrganizationProvinceId());
					params.put("provinceName", val.getOrganizationProvinceName());
					params.put("cityId", val.getOrganizationCityId());
					params.put("cityName", val.getOrganizationCityName());
					params.put("districtId", val.getOrganizationDistrictId());
					params.put("districtName", val.getOrganizationDistrictName());
					arg0.update("insert_organization_info",params);
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
	/**
	 * 批量导入User
	 * @author yinxiaolong
	 */
	@Override
	public boolean batchUser(final List<OrganizationDto> dtos,
			final Map<String, Object> params) throws Exception {
		Object obj = this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {
			@Override
			public Object doInSqlMapClient(SqlMapExecutor arg0)throws SQLException {
				arg0.startBatch();
				for(OrganizationDto val : dtos){
					//user
					params.put("loginAccount", val.getContacts());
					params.put("realName", val.getContacts());
					params.put("mobile", val.getContactsType());
					params.put("password", val.getContactsType());
					
					
					arg0.update("insertOrgUserInfo",params);
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

	@Override
	public int updateSysArea(Map<String, Object> params, int id)
			throws Exception {
		params.put("id", id);
		return this.getSqlMapClientTemplate().update("update_area",params);
	}

	@Override
	public boolean deleteArea(int id) throws Exception {
		List<Integer> ids = this.selectArea(id);
		int i = this.getSqlMapClientTemplate().update("delete_area",ids);
		if(i>0){
			return true;
		}
		return false;
	}
	/**
	 * 查询所有下级地区
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> selectArea(int id) throws Exception{
		List<Integer> ids = this.getSqlMapClientTemplate().queryForList("select_all_belong",id);
		ids.add(id);
		return ids;
	}

	@Override
	public int insertSysAreaRtnID(SysArea area) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("area_insert",area);
		if(obj != null){
			int id = (Integer)obj;
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("code", id);
			int i =this.updateSysArea(params, id);
			if(i >0){
				return id;
			}
		}
		return 0;
	}
	
	/**
	 * 批量导入学校
	 * @param ids 学校信息集合
	 * @param account 当前登录人
	 * @return
	 * @throws Exception
	 */
	public boolean insertSchool(final List<EduSchool> ids,final String account)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {

			@Override
			public Object doInSqlMapClient(SqlMapExecutor arg0) throws SQLException {
				arg0.startBatch();
				for(EduSchool id:ids){
					id.setCreateBy(account);
					id.setUpdateBy(account);
					arg0.insert("insert_school", id);
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
	public boolean insertUserInfo(Map<String, Object> paramMap)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("insertOrgUserInfo",paramMap);
		if(obj == null){
			return true;
		}
		return false;
	}

	/**
	 * 更新角色信息
	 * @param pojo
	 * @return
	 */
	public Integer updateRoleInfo(SysRole pojo)throws Exception {
		Integer id = (Integer)this.getSqlMapClientTemplate().update("updateRoleInfo",pojo);
		if(id != null){
			return 0;
		}
		return -1;
	}

	/**删除角色拥有的权限
	 * @param pojo
	 * @return
	 */
	public Integer deleteRoleFunc(Integer id) throws Exception {
		Integer ids = (Integer)this.getSqlMapClientTemplate().update("delete_role_func",id);
		if(ids != null){
			return 0;
		}
		return -1;
	}

	/**增加角色拥有的权限
	 * @param pojo
	 * @return
	 */
	public Integer insertRoleFunc(final List<SysRole> pojo) throws Exception {
		Object obj = this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {

			@Override
			public Object doInSqlMapClient(SqlMapExecutor arg0) throws SQLException {
				arg0.startBatch();
				for(SysRole id:pojo){
					arg0.insert("insert_role_func", id);
				}
				
				return arg0.executeBatch();
			}
			
		});
		if(obj != null && (Integer)obj>0){
			return 1;
		}
		return -1;
	}
	
	@Override
	public Integer deleteNotrain(Integer id) {
		Object obj = this.getSqlMapClientTemplate().delete("deleteNotrainByPrimaryKey",id);
		if(obj != null){
			return 0;
		}
		return -1;
	}
	@Override
	public Integer updateNotrain(EduProjectNotrain notrain) {
		Object object = this.getSqlMapClientTemplate().insert("updateNotrainByPrimaryKeySelective",notrain);
		if(object != null){
			return 0;
		}
		return 0;
	}
	@Override
	public Integer insertNotrain(EduProjectNotrain notrain) {
		Integer id = (Integer)this.getSqlMapClientTemplate().insert("notrain_insert",notrain);
		if(id == null){
			return id;
		}
		return -1;
	}

	@Override
	public boolean enterCredit(Map<String, Object> params) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("enterCredit",params);
		if(obj == null){
			return true;
		}
		return false;
	}

	@Override
	public boolean auditCredit(Map<String, Object> params) throws Exception {
		Object isTrainProject =  params.get("isTrainProject");
		Object obj = null;
		if(isTrainProject !=null){
			  obj = this.getSqlMapClientTemplate().update("auditCreditTrain",params);
		}else {
			  obj = this.getSqlMapClientTemplate().update("auditCredit",params);
		}
		if(obj != null){
			return true;
		}
		return false;
	}

	/**
	 * 修改系统平台设置
	 */
	@Override
	public int updatePlatformSetup(SysPlatformSetup pojo) throws Exception {
		return this.getSqlMapClientTemplate().update("updatePlatformSetup", pojo);
	}
	
	@Override
	public int insertFJimport(Fjimport d) {
		int result;
		result = (Integer) this.getSqlMapClientTemplate().insert("fjimport_insert", d);
		return result;
	}

	@Override
	public int fjimportCountByKey(Fjimport d) {
		int result;
		result = (Integer)this.getSqlMapClientTemplate().queryForObject("fjimport_count_by_key", d);
		return result;
	}

	@Override
	public int updateFjimport(Fjimport d) {
		int result = 0;
		result = this.getSqlMapClientTemplate().update("fjimport_update", d);
		return result;
	}

	@Override
	public List<Fjimport> getFjimportList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Fjimport> result = (List<Fjimport>)this.getSqlMapClientTemplate().queryForList("select_import_list", params);
		
		return result;
	}

	@Override
	public int insertFJimportHistory(FjimportHistory d) {
		Integer result = (Integer)getSqlMapClientTemplate().insert("insert_fjimport_history", d);
		
		return result;
	}

	@Override
	public List<FjimportHistory> getFjimportHistoryList(
			Map<String, Object> params) {
		List<FjimportHistory> result = (List<FjimportHistory>)this.getSqlMapClientTemplate().queryForList("select_fjimport_history_list", params);
		return result;
	}

	@Override
	public int getFjimportHistoryCount(Map<String, Object> params) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("select_fjimport_history_count", params);
	
	}

	public Boolean insertFjTeacherStudyInfo(Map<String, Object> param) {
		// TODO Auto-generated method stub
		 Object object = this.getSqlMapClientTemplate().insert("insert_fjTeacherStudyInfo", param);
		 if(object != null) {
				return true;
			}
		return false;
	}
	
	
	public int getFjimportListCount(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlMapClientTemplate().queryForObject("select_fjimport_count", param);
	}

	public List<Fjimport> getFjimportListPage(Map<String, Object> param)
			throws Exception {
		// TODO Auto-generated method stub
		List<Fjimport> result = (List<Fjimport>)this.getSqlMapClientTemplate().queryForList("select_fjimport_list", param);
		return result;
	}
	/**
	 * 查询历史导入记录
	 */
	public List<Fjimport> queryFjimportList(Map<String, Object> params)
			throws Exception {
		// TODO Auto-generated method stub
		List<Fjimport> result = (List<Fjimport>)this.getSqlMapClientTemplate().queryForList("select_oldfjimport_list", params);
		return result;
	}

	public int insertRole(SysRole sysRole) {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlMapClientTemplate().insert("insert_sys_role",sysRole);
	}

	public int insertSysLog(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlMapClientTemplate().insert("sys_log_insert",params);
	}

	public int deleteTrainingInfoByStatus(List<Fjimport> objList)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().delete("delete_nlts_by_status",objList);
	}

	public int updateEduTeacherTrainScoreInfo(Map<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = this.getSqlMapClientTemplate().update("update_teacher_train_score", params);
		return result;
	}

	public int insertEduTeacherTrainScoreInfo(EduTeacherScoreInfo pojo) throws Exception {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlMapClientTemplate().insert("insert_teacher_train_score",pojo);
	}

}
