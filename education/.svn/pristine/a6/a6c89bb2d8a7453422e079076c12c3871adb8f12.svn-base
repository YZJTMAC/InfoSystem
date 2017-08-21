package project.dictionary.dao.impl;

import java.util.Map;

import framelib.dao.BaseDAOImpl;

import project.dictionary.dao.IDictionaryWriteDao;

public class DictionaryWriteDaoImpl extends BaseDAOImpl implements IDictionaryWriteDao{

	@Override
	public boolean insertDictionarInfo(Map<String, Object> paramMap)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("insertDictionaryInfo",paramMap);
		if(obj == null){
			return true;
		}
		return false;
	}

	@Override
	public Integer selectUsedDictionaryInfoByCondition(
			Map<String, Object> paramMap) {
		Integer obj = (Integer)this.getSqlMapClientTemplate().queryForObject("selectUsedDictionaryInfo",paramMap);
		if(obj == null){
			return -1;
		} else {
			return obj;
		}
	}

	@Override
	public boolean updateDictionaryInfo(Map<String, Object> paramMap)
			throws Exception {
		boolean flag = false;
		int result = this.getSqlMapClientTemplate().update("updateDictionary",paramMap);
		if(result>0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteDictionaryInfoById(Map<String, Object> paramMap)
			throws Exception {
		boolean flag = false;
		int result = this.getSqlMapClientTemplate().update("deleteDictionaryInfo",paramMap);
		if(result>0){
			flag = true;
		}
		return flag;
	}
	

}
