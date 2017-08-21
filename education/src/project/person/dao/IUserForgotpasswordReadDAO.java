package project.person.dao;


import project.person.pojo.EduUserForgotpassword;

public interface IUserForgotpasswordReadDAO {
	
	
	public EduUserForgotpassword selectByUid(Integer uid)
			throws Exception;
	
}
