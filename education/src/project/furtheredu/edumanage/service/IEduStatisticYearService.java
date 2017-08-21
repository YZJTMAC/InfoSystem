package project.furtheredu.edumanage.service;

import java.util.List;
import java.util.Map;

import framelib.utils.page.PageObject;

public interface IEduStatisticYearService {
	
	public PageObject findStatisticYear(Map<String,Object> param,Integer startIndex, Integer pageSize);
	public Integer insertBySql(String sql);
	public void deleteBySql(String sql);
	List<Map<String, Object>> getStatisticYearBySql(String sql);
}
