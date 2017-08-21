package project.edupm.projectmanage.dao.impl;

import framelib.dao.BaseDAOImpl;
import project.edupm.projectmanage.dao.ISummaryWriteDAO;
import project.edupm.projectmanage.pojo.EduProjectSummary;

public class ISummaryWriteDAOImpl extends BaseDAOImpl implements ISummaryWriteDAO{

	@Override
	public Integer insertEduProjectSummary(EduProjectSummary eduProjectSummary) {
		Object obj = this.getSqlMapClientTemplate().insert("summay_insert", eduProjectSummary);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}

	@Override
	public Integer updateEduProjectSummary(EduProjectSummary eduProjectSummary) {
		return this.getSqlMapClientTemplate().update("summay_updateByPrimaryKeySelective", eduProjectSummary);
	}
}
