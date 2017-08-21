package project.furtheredu.edumanage.dao.impl;

import java.util.List;
import java.util.Map;

import framelib.dao.BaseDAOImpl;

import project.furtheredu.edumanage.dao.IEduStatisticYearReadDao;
import project.statistic.pojo.EduStatisticYear;


@SuppressWarnings("unchecked")
public class EduStatisticYearReadDaoImpl  extends BaseDAOImpl implements IEduStatisticYearReadDao{


	@Override
	public List<EduStatisticYear> selectByParam(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectEduStatisticYearByParam", param);
	}

	@Override
	public Integer selectCountByParam(Map<String, Object> param) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("selectEduStatisticYearCountByParam", param);
	}
	
	@Override
	public List<Map<String,Object>> getStatisticYearBySql(Map<String, String> param)
	{
		return this.getSqlMapClientTemplate().queryForList("getStatisticYearBySql", param);
	}

}
