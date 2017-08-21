package project.furtheredu.edumanage.dao;

import java.util.List;
import java.util.Map;

import project.statistic.pojo.EduStatisticModel;



public interface IEduStatisticModelReadDao {
	public List<EduStatisticModel> selectByParam(Map<String,Object> param);
	public Integer selectCountByParam(Map<String,Object> param);
}
