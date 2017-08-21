package project.test.dao;


import framelib.dao.BaseDAOImpl;

public class TestDaoImpl extends BaseDAOImpl implements ITestDao{

	@Override
	public void testDao(String name) {
		this.getSqlMapClientTemplate().insert("insertName", name);
	}

}
