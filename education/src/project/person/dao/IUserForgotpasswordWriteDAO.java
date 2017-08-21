package project.person.dao;

import project.person.pojo.EduUserForgotpassword;


public interface IUserForgotpasswordWriteDAO {
	
	public Integer insert(EduUserForgotpassword uf)throws Exception;

	public Integer deleteByUid(Integer uid) throws Exception;

	public Integer update(EduUserForgotpassword uf) throws Exception;
	

}
