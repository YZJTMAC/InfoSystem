package project.edupm.projectmanage.dao.impl;

import project.edupm.projectmanage.dao.IEduProjectCommentReadDAO;
import project.furtheredu.edumanage.pojo.EduProjectComment;
import framelib.dao.BaseDAOImpl;
@SuppressWarnings("unchecked")
public class EduProjectCommentReadDAOImpl extends BaseDAOImpl implements IEduProjectCommentReadDAO {

	@Override
	public EduProjectComment selectUnpassReason(Integer id) throws Exception {
		EduProjectComment object = (EduProjectComment) this.getSqlMapClientTemplate().queryForObject("select_unpass_reason",id);
		if(object != null){
			return  object;
		}
		return null;
	}

}
