package project.furtheredu.edumanage.service;

import java.util.Map;

import framelib.utils.page.PageObject;

public interface IEduStatisticModelService {
	
	public PageObject findStatisticModel(Map<String,Object> param,Integer startIndex, Integer pageSize);
	
	public void insertBySql(String sql);
	public void deleteBySql(String sql);
}
