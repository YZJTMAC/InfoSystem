package project.dictionary.dao;

import java.util.Map;

public interface IDictionaryWriteDao {
	/**
	 *  数据字典增加
	 *  @author yinxiaolong
	 * @create date 2014-4-13
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	boolean insertDictionarInfo(Map<String, Object> paramMap) throws Exception;
	/**
	 * 数据字典修改
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	boolean updateDictionaryInfo(Map<String,Object> paramMap) throws Exception;
	/**删除
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	boolean deleteDictionaryInfoById(Map<String,Object> paramMap) throws Exception;
	
	/**
	 * 判断字典是否被使用
	 * @param paramMap
	 * @return
	 */
	Integer selectUsedDictionaryInfoByCondition(Map<String, Object> paramMap);
}
