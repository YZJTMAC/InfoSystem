package framelib.dao;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

public abstract class BaseDAOImpl extends SqlMapClientDaoSupport{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private enum OpType{
		INSERT,UPDATE,DELETE
	}

	public <T> List<T> executeQueryForList(String selStmName, String cntStmName, T obj) {
		throw new java.lang.RuntimeException("Not supported");
	}


	@SuppressWarnings("unchecked")
	protected <T> List<T> queryForList(String statementName,Object parameterObject){
            try{              
                DataSource dataSource = getSqlMapClientTemplate().getDataSource();              
                Connection conn = dataSource.getConnection();
            }catch(Throwable t){
                t.printStackTrace();
            }
		return getSqlMapClientTemplate().queryForList(statementName, parameterObject);
	}


	protected Object queryForObject(String statementName,Object parameterObject){
		return getSqlMapClientTemplate().queryForObject(
				statementName, parameterObject);
	}

	
	protected int executeUpdate(String statementName, Object parameterObject)
			throws DataAccessException {
		return getSqlMapClientTemplate().update(statementName,
				parameterObject);
	}

	
	protected Object executeInsert(String statementName, Object parameterObject){
		return getSqlMapClientTemplate().insert(statementName,
				parameterObject);
	}

	
	public Integer executeInsertBatch(final String sqlID, final List<?> stList) {
		Integer result =Integer.valueOf(-1);

		if (checkConditionNotNull(sqlID, stList)) {
			result = executeBatchOperate(sqlID, stList,OpType.INSERT);
		}

		return result;
	}


	private boolean checkConditionNotNull(final String sqlID, final List<?> stList) {
		return (sqlID != null) && (stList != null) && !stList.isEmpty();
	}


	private Integer executeBatchOperate(final String sqlID, final List<?> stList,final OpType opType) {
		return (Integer) getSqlMapClientTemplate().execute(
				new SqlMapClientCallback() {
					public Object doInSqlMapClient(SqlMapExecutor executor)
							throws SQLException {
						Integer result = Integer.valueOf(-1);
						executor.startBatch();
						for (int i = 0; i < stList.size(); i++) {
							switch(opType){
							case DELETE:
								executor.delete(sqlID, stList.get(i));
								break;
							case INSERT:
								executor.insert(sqlID, stList.get(i));
								break;
							case UPDATE:
								executor.update(sqlID, stList.get(i));
								break;
							}
						}
						result = new Integer(executor.executeBatch());
						return result;
					}
				});
	}


	public Integer executeUpdateBatch(final String sqlID, final List<?> stList){
		Integer result = Integer.valueOf(-1);

		if (checkConditionNotNull(sqlID, stList)) {
			result = executeBatchOperate(sqlID, stList, OpType.UPDATE);
		}

		return result;
	}

	public Integer executeDeleteBatch(final String sqlID, final List<?> stList){
		Integer result = Integer.valueOf(-1);

		if (checkConditionNotNull(sqlID, stList)) {
			result = executeBatchOperate(sqlID, stList, OpType.DELETE);
		}

		return result;
	}
	
	public PageObject getPageObject(int pageNum, int pageSize,
			String countSqlId, String listSqlId, Map<String, Object> sqlMap) {
		PageObject po = new PageObject();
		// 查询符合条件的记录条数
		int count = (Integer) queryForObject(countSqlId, sqlMap);
		po.setCount(count);
		List list = null;
		if(count >0){
			PageParser.getPageObject(PageParser.getPageInfo((pageNum - 1)
					* pageSize, pageSize, po.getCount()), po);
			sqlMap.put("startIndex", po.getStartIndex());
			sqlMap.put("pageSize", po.getPagesize());
			// 当前面list
			list = queryForList(listSqlId, sqlMap);
		}
		
		if (list == null) {
			list = new ArrayList();
		}
		po.setObjects(list);
		return po;
	}
}
