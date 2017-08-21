package project.furtheredu.eduTarget.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.furtheredu.eduTarget.dao.IEduTagetReadDao;
import project.furtheredu.eduTarget.pojo.EduTargetByYear;
import project.teacher.teachermanage.dao.ITeacherReadDao;
import project.teacher.teachermanage.pojo.EduTeacherVersionPOJO;

import framelib.dao.BaseDAOImpl;

/**
 * 
 * @Create_by:dengguo
 * @Create_date:2014-3-27
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 * 
 */

public class EduTagetReadDaoImpl extends BaseDAOImpl implements IEduTagetReadDao { 
	
	@Override  
	public Integer selectTagetCountByCondition(Map<String, Object> param) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectTargetListCount", param);
	}
	//在年度考核设置添加，校验该地区是否已经存在年度考核设置。
	@Override  
	public Integer selectTagetCountByCondition2(Map<String, Object> param) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectTargetListCount2", param);
	}
	@Override
	public List<Object> selectTagetListByCondition(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectTargetList", param);
	}
	
	@Override
	public List<Object> selectTagetListByConditionNoPage(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectTargetInfo", param);
	}
	
	@Override
	public EduTargetByYear selectTargetByKey(Integer id) {
		return (EduTargetByYear)this.getSqlMapClientTemplate().queryForObject("selectTargetByKey", id);
	}
	 
}