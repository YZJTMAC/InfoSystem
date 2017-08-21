package framelib.dao;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
/**
 * 继承org.springframework.orm.hibernate3.support.HibernateDaoSupport,供用户自定义的DAO继承
 * AbstractDAO 封装了hibernateDAO常用的一些方法功能,供用户自定义DAO使用
 * 
 */
public class AbsDAO<T, PK extends Serializable> extends SqlMapClientDaoSupport {

	// private static final Log log = LogFactory.getLog(AbstractDAO.class);

	/**
	 * 初始化 Dao
	 * 
	 * @see org.springframework.dao.support.DaoSupport#initDao()
	 */

	protected void initDao() throws Exception {
		super.initDao();

	}

	/**
	 * 缩减列的长度，使数据库不至于超长
	 * @param values
	 * @param colLengthDefine
	 */
	protected void shinkColumn(Map<String, Object> values, Map<String, Integer> colLengthDefine) {
		if(colLengthDefine != null) {
			for(Entry<String, Object> value: values.entrySet()) {
				if(value.getValue() instanceof String) {
					if(colLengthDefine.get(value.getKey().toLowerCase()) != null) {
						int thisColLength = colLengthDefine.get(value.getKey().toLowerCase());
						String thisColValue = (String)value.getValue(); 
						if(thisColValue.length() > thisColLength) {
							value.setValue(thisColValue.substring(0, thisColLength));
						}
					}
				}
			}
		}
	}	

}
