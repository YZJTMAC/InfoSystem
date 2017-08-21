package project.dictionary.service;

import java.util.List;
import java.util.Map;

import project.system.pojo.SysDictionary;

import framelib.utils.page.PageObject;

public interface IDictionaryService {
	/**
	 * 字典表管理列表
	 * @author yinxiaolong
	 * create date 2014-4-13
	 * @param paramMap
	 * @param pageIndex 
	 * @param pageSize 
	 * @return
	 * @throws Exception
	 */
	public PageObject querySysDictionary(Map<String, Object> paramMap,int pageIndex, int pageSize) throws Exception;
	
	public PageObject querySysDictionaryes(Map<String, Object> paramMap,int pageIndex, int pageSize) throws Exception;
	/**
	 * 增加数据字典信息
	 * @author yinxiaolong
	 * create date 2014-4-13
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	boolean saveDictionaryInfo(Map<String, Object> paramMap) throws Exception;
	/**
	 * 数据字典修改
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	boolean updateDictionaryInfoById(Map<String, Object> paramMap) throws Exception;
	/**
	 *  删除
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	boolean deleteDictionaryInfoById(Map<String, Object> paramMap) throws Exception;
	
	public List<SysDictionary> selectAllSysDictionaryList(Map<String, Object> paramMap) throws Exception;

	PageObject querySysDictionary(Map<String, Object> paramMap)
			throws Exception;

	public SysDictionary selectSysDictionaryInfo(Map<String, Object> dictionaryMap)throws Exception;
}
