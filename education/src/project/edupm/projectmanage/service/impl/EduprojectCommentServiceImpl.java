package project.edupm.projectmanage.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.edupm.projectmanage.dao.IEduProjectCommentWriteDAO;
import project.edupm.projectmanage.dao.IEduProjectCommentReadDAO;

import project.edupm.projectmanage.service.IEduProjectCommentService;
import project.furtheredu.edumanage.pojo.EduProjectComment;
@SuppressWarnings("unchecked")
public class EduprojectCommentServiceImpl implements IEduProjectCommentService {

	private static final Logger log = Logger.getLogger(EduprojectCommentServiceImpl.class);

	private static final List<EduProjectComment> IEduProjectCommentReadDAO = null;
	
	@Autowired
	@Qualifier("eduProjectCommentWriteDAO")
	IEduProjectCommentWriteDAO eduProjectCommentWriteDAO;
	
	@Autowired  
	@Qualifier("eduProjectCommentReadDAO")
	IEduProjectCommentReadDAO eduProjectCommentReadDAO;
	                           
	@Override
	public EduProjectComment selectUnpassReason(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return eduProjectCommentReadDAO.selectUnpassReason(id);
	}

	@Override
	public boolean cancelRegistrationAll(Map<String, Object> conditions) {
		// TODO Auto-generated method stub
		return eduProjectCommentWriteDAO.cancelRegistrationAll(conditions);
	}

}
