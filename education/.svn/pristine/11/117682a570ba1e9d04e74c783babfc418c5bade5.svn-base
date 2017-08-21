package project.furtheredu.edumanage.dao.impl;

import java.util.Map;

import framelib.dao.BaseDAOImpl;

import project.furtheredu.edumanage.dao.IEduStatisticModelWriteDao;


@SuppressWarnings("unchecked")
public class EduStatisticModelWriteDaoImpl  extends BaseDAOImpl implements IEduStatisticModelWriteDao{



	@Override
	public void insertBySql(Map<String, String> map) {
		this.getSqlMapClientTemplate().insert("insertStatisticModelSql", map);
		
	}

	@Override
	public void deleteBySql(Map<String, String> map) {
		this.getSqlMapClientTemplate().insert("removeStatisticModelSql", map);
		
	}


}
