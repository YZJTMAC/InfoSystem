package project.stats.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.edupm.projectmanage.dao.IEduProjectReadDAO;
import project.stats.service.IStatsService;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

public class StatsServiceImpl implements IStatsService{

	@Autowired
	@Qualifier("eduProjectReadDAO")
	IEduProjectReadDAO eduProjectReadDAO;
	
	/**
	 * 教师统计
	 */
	@Override
	public PageObject queryStats( Map<String, Object> conditions, Integer startIndex, Integer pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = 0;//eduProjectReadDAO.selectCountByConditions(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<Map<String,Object>> proList = eduProjectReadDAO.queryStats(conditions);
		po.setObjects(proList);
		return po;
	}

	/**
	 * 学校统计
	 */
	@Override
	public PageObject queryStatsSchool(Map<String, Object> conditions, Integer startIndex, Integer pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = 0;//eduProjectReadDAO.selectCountByConditions(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<Map<String,Object>> proList = eduProjectReadDAO.queryStatsSchool(conditions);
		po.setObjects(proList);
		return po;
	}

	/**
	 * 继教统计
	 */
	@Override
	public PageObject queryStatsFuther(Map<String, Object> conditions,
			Integer startIndex, Integer pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = 0;//eduProjectReadDAO.selectCountByConditions(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<Map<String,Object>> proList = eduProjectReadDAO.queryStatsFuther(conditions);
		po.setObjects(proList);
		return po;
	}

}
