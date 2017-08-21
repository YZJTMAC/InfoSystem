package project.furtheredu.edumanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.furtheredu.edumanage.dao.IEduStatisticModelReadDao;
import project.furtheredu.edumanage.dao.IEduStatisticModelWriteDao;
import project.furtheredu.edumanage.service.IEduStatisticModelService;
import project.statistic.pojo.EduStatisticModel;
import framelib.service.AbsService;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;


public class EduStaticModelServieImpl extends AbsService implements
		IEduStatisticModelService {

	@Autowired
	@Qualifier("eduStatisticModelReadDao")
	IEduStatisticModelReadDao eduStatisticModelReadDao;
	@Autowired
	@Qualifier("eduStatisticModelWriteDao")
	IEduStatisticModelWriteDao eduStatisticModelWriteDao;
	
	
	
	@Override
	public PageObject findStatisticModel(Map<String, Object> param,Integer startIndex, Integer pageSize) {
		PageObject po = new PageObject();
		po.setCount(eduStatisticModelReadDao.selectCountByParam(param));
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		param.put("startIndex", po.getStartIndex());
		param.put("endIndex", pageSize);
		List<EduStatisticModel> list = eduStatisticModelReadDao.selectByParam(param);
		po.setObjects(list);
		return po;
	}



	@Override
	public void insertBySql(String sql) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("sql", sql);
		eduStatisticModelWriteDao.insertBySql(map);
		
	}



	@Override
	public void deleteBySql(String sql) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("sql", sql);
		eduStatisticModelWriteDao.deleteBySql(map);
	}
	
}
