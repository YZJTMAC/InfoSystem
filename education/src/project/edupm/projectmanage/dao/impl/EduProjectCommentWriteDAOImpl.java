package project.edupm.projectmanage.dao.impl;

import java.util.Map;

import project.edupm.projectmanage.dao.IEduProjectCommentWriteDAO;
import framelib.dao.BaseDAOImpl;

public class EduProjectCommentWriteDAOImpl extends BaseDAOImpl implements IEduProjectCommentWriteDAO {

	@Override
	public boolean cancelRegistrationAll(Map<String, Object> conditions) {
		if(this.getSqlMapClientTemplate().delete("cancel_registration_all", conditions) < 0){
			return false;
		}
		return true;
	}

}
