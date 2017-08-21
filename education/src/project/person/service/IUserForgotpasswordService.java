package project.person.service;

import project.person.pojo.EduUserForgotpassword;


public interface IUserForgotpasswordService {
	
	public EduUserForgotpassword selectByUid(Integer uid)
			throws Exception;
	public Integer insert(EduUserForgotpassword uf)throws Exception;

	public Integer deleteByUid(Integer uid) throws Exception;

	public Integer update(EduUserForgotpassword uf) throws Exception;
}
