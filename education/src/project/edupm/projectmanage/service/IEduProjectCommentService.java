package project.edupm.projectmanage.service;

import java.util.Map;

import project.furtheredu.edumanage.pojo.EduProjectComment;


public interface IEduProjectCommentService  {
	
	EduProjectComment selectUnpassReason(Integer id) throws Exception;

	boolean cancelRegistrationAll(Map<String, Object> conditions);

}
