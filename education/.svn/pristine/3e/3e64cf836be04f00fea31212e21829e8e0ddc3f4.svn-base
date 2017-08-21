package project.person.dao.impl;

import framelib.dao.BaseDAOImpl;
import project.person.dao.IUserForgotpasswordReadDAO;
import project.person.pojo.EduUserForgotpassword;

public class UserForgotpasswordReadDAOImpl extends BaseDAOImpl implements IUserForgotpasswordReadDAO {

	@Override
	public EduUserForgotpassword selectByUid(Integer uid) throws Exception {
		return (EduUserForgotpassword) this.getSqlMapClientTemplate().queryForObject("selectByUid", uid);
	}

}
