package project.furtheredu.edumanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.furtheredu.edumanage.dao.IEduStatisticModelReadDao;
import project.furtheredu.edumanage.dao.IEduStatisticYearReadDao;
import project.furtheredu.edumanage.dao.IEduStatisticYearWriteDao;
import project.furtheredu.edumanage.service.IEduStatisticModelService;
import project.furtheredu.edumanage.service.IEduStatisticYearService;
import project.statistic.pojo.EduStatisticModel;
import project.statistic.pojo.EduStatisticYear;
import framelib.service.AbsService;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;


public class EduStaticYearServieImpl extends AbsService implements
		IEduStatisticYearService {

	@Autowired
	@Qualifier("eduStatisticYearReadDao")
	IEduStatisticYearReadDao eduStatisticYearReadDao;
	@Autowired
	@Qualifier("eduStatisticYearWriteDao")
	IEduStatisticYearWriteDao eduStatisticYearWriteDao;
	
	
	
	@Override
	public PageObject findStatisticYear(Map<String, Object> param,Integer startIndex, Integer pageSize) {
		PageObject po = new PageObject();
		po.setCount(eduStatisticYearReadDao.selectCountByParam(param));
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		param.put("startIndex", po.getStartIndex());
		param.put("endIndex", pageSize);
		List<EduStatisticYear> list = eduStatisticYearReadDao.selectByParam(param);
		po.setObjects(list);
		return po;
	}
	@Override
	public Integer insertBySql(String sql) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("sql", sql);
		return eduStatisticYearWriteDao.insertBySql(map);
		
	}



	@Override
	public void deleteBySql(String sql) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("sql", sql);
		eduStatisticYearWriteDao.deleteBySql(map);
	}
	
	@Override
	public List<Map<String,Object>> getStatisticYearBySql(String sql)
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("sql", sql);
		return eduStatisticYearReadDao.getStatisticYearBySql(map);
	}
}
