package project.furtheredu.edumanage.dao.impl;

import java.util.Map;

import framelib.dao.BaseDAOImpl;

import project.furtheredu.edumanage.dao.IEduStatisticYearWriteDao;


@SuppressWarnings("unchecked")
public class EduStatisticYearWriteDaoImpl  extends BaseDAOImpl implements IEduStatisticYearWriteDao{


	@Override
	public Integer insertBySql(Map<String, String> map) {
		return (Integer) this.getSqlMapClientTemplate().insert("insertStatisticYearSql", map);
		
	}

	@Override
	public void deleteBySql(Map<String, String> map) {
		this.getSqlMapClientTemplate().insert("removeStatisticYearSql", map);
		
	}

}
