package project.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.person.dao.IUserForgotpasswordReadDAO;
import project.person.dao.IUserForgotpasswordWriteDAO;
import project.person.pojo.EduUserForgotpassword;
import project.person.service.IUserForgotpasswordService;

public class UserForgotpasswordServiceImpl implements IUserForgotpasswordService {

	@Autowired
	@Qualifier("userForgotpasswordReadDao")
	IUserForgotpasswordReadDAO userForgotpasswordReadDao;

	@Autowired
	@Qualifier("userForgotpasswordWriteDao")
	IUserForgotpasswordWriteDAO userForgotpasswordWriteDao;
	@Override
	public EduUserForgotpassword selectByUid(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		return userForgotpasswordReadDao.selectByUid(uid);
	}

	@Override
	public Integer insert(EduUserForgotpassword uf) throws Exception {
		// TODO Auto-generated method stub
		return userForgotpasswordWriteDao.insert(uf);
	}

	@Override
	public Integer deleteByUid(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		return userForgotpasswordWriteDao.deleteByUid(uid);
	}

	@Override
	public Integer update(EduUserForgotpassword uf) throws Exception {
		// TODO Auto-generated method stub
		return userForgotpasswordWriteDao.update(uf);
	}

}
