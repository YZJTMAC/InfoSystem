package project.dictionary.dao.impl;

import java.util.List;
import java.util.Map;

import framelib.dao.BaseDAOImpl;
import project.dictionary.dao.IDictionaryReadDao;
import project.system.pojo.EduSchool;
import project.system.pojo.SysDictionary;

public class DictionaryReadDaoImpl extends BaseDAOImpl implements IDictionaryReadDao{

	@Override
	/**
	 * 字典表管理列表分页
	 * @author yinxiaolong
	 * @create date 2014-4-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectSysDictionaryCount(Map<String, Object> paramMap)
			throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject("selectSysDictionaryCount", paramMap);
		return count;
	}
	/**
	 * 字典表管理列表
	 * @author yinxiaolong
	 * @create date 2014-4-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SysDictionary> selectSysDictionaryList(Map<String, Object> paramMap)
			throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectSysDictionaryList", paramMap);
	}
	/**
	 * 为教师信息模板查询字典
	 * @author zhaobichao
	 * @create date 2014-11-24
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SysDictionary> selectSysDictionaryTemList(Map<String, Object> paramMap)
			throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectSysDictionaryTemList", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SysDictionary> selectAllSysDictionaryList(
			Map<String, Object> paramMap) throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectSysAllDictionaryList", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SysDictionary> selectSysDictionaryListes(
			Map<String, Object> paramMap) throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectSysDictionaryListes", paramMap);
	}
	@Override
	public SysDictionary selectSysDictionaryInfo(Map<String, Object> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return  (SysDictionary)this.getSqlMapClientTemplate().queryForObject("selectSysDictionaryInfo", paramMap);
	}
	
}
