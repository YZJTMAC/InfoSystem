package project.stats.service;

import java.util.Map;

import framelib.utils.page.PageObject;

/**
 * 
 * @author ben
 *
 */
public interface IStatsService {
	/**
	 * @param type 教师统计查询类型:0地区,1字典
	 * @param proParam 
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public PageObject queryStats(Map<String,Object> proParam,Integer startIndex,Integer pageSize)throws Exception;

	/**
	 * 学校统计
	 * @param i
	 * @param conditions
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public PageObject queryStatsSchool(Map<String, Object> conditions,Integer startIndex,Integer pageSize)throws Exception;

	public PageObject queryStatsFuther(Map<String, Object> conditions,Integer startIndex,Integer pageSize)throws Exception;
}