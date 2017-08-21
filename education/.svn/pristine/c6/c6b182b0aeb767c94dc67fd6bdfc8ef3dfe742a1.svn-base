package project.furtheredu.edumanage.dao.impl;


import java.util.HashMap;
import java.util.Map;

import project.furtheredu.edumanage.dao.IEduManageWriteDao;
import project.furtheredu.edumanage.pojo.EduSignet;
import framelib.dao.BaseDAOImpl;

public class EduManageWriteDaoImpl extends BaseDAOImpl implements IEduManageWriteDao {  
	
	@Override
	public Integer updateEduManageStatus(String id, String account,
			Integer status, String memo) {
		if(id == null && account == null) {
			return -1;
		}
		Map<String, Object> param = new HashMap<String, Object> ();
		param.put("id", id);
		param.put("updateBy", account);
		param.put("status", status);
		param.put("memo", memo);
		Object obj = this.getSqlMapClientTemplate().update("comment_audit", param);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}

	@Override
	public Integer deleteManageById(Integer id) throws Exception {
		Object obj = this.getSqlMapClientTemplate().delete("comment_delete", id);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * 新增电子印章
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer insertSignet(EduSignet pojo) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("insert_signet", pojo);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}

	/**
	 * 新增电子印章
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer insertSignetNew(EduSignet pojo) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("insert_signet_new", pojo);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	
	/**
	 * 修改电子印章
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer updateSignet(EduSignet pojo) throws Exception {
		Object obj = this.getSqlMapClientTemplate().update("update_signet", pojo);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public Integer insertYearCertificate(Map<String, Object> param) {
		Object obj = this.getSqlMapClientTemplate().insert("insert_year_certificate", param);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}

	@Override
	public boolean deleteCertificateById(Map<String, Object> condition) {
		Integer obj = this.getSqlMapClientTemplate().delete("delete_certificate", condition);
		if (obj == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int updateCertificateById(Map<String, Object> condition) {
		Integer obj = this.getSqlMapClientTemplate().update("update_certificate", condition);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
}