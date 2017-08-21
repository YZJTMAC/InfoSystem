package project.person.dao.impl;

import framelib.dao.BaseDAOImpl;
import project.person.dao.IUserForgotpasswordWriteDAO;
import project.person.pojo.EduUserForgotpassword;

public class UserForgotpasswordWriteDAOImpl extends BaseDAOImpl implements IUserForgotpasswordWriteDAO {

	@Override
	public Integer insert(EduUserForgotpassword uf) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("insert", uf);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}

	@Override
	public Integer deleteByUid(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().delete("deleteByUid", uid);
	}

	@Override
	public Integer update(EduUserForgotpassword uf) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().update("update", uf);
	}

}
