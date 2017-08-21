package project.furtheredu.edumanage.dao.impl;

import java.util.List;
import java.util.Map;

import framelib.dao.BaseDAOImpl;

import project.furtheredu.edumanage.dao.IEduStatisticModelReadDao;
import project.statistic.pojo.EduStatisticModel;


@SuppressWarnings("unchecked")
public class EduStatisticModelReadDaoImpl  extends BaseDAOImpl implements IEduStatisticModelReadDao{


	@Override
	public List<EduStatisticModel> selectByParam(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectEduStatisticModelByParam", param);
	}

	@Override
	public Integer selectCountByParam(Map<String, Object> param) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("selectEduStatisticModelCountByParam", param);
	}

}
