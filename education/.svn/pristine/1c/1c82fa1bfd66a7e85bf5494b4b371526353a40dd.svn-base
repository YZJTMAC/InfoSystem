package project.dictionary.dao;

import java.util.List;
import java.util.Map;

import project.system.pojo.EduSchool;
import project.system.pojo.SysDictionary;

public interface IDictionaryReadDao {
	/**字典表管理列表分页
	 * @author yinxiaolong
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectSysDictionaryCount(Map<String, Object> paramMap) throws Exception;
	/**
	 * 字典表管理列表
	 * @author yinxiaolong
	 * @create date 2014-4-13
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<SysDictionary> selectSysDictionaryList(Map<String, Object> paramMap) throws Exception;
	public List<SysDictionary> selectSysDictionaryListes(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 字典表增加验证是否重复
	 * @author yinxiaolong
	 * @create date 2014-4-13
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<SysDictionary> selectAllSysDictionaryList(Map<String, Object> paramMap) throws Exception;
	public List<SysDictionary> selectSysDictionaryTemList(
			Map<String, Object> paramMap) throws Exception;
	public SysDictionary selectSysDictionaryInfo(
			Map<String, Object> paramMap) throws Exception;
	
}
