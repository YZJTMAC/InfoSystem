package project.edupm.projectmanage.dao.impl;

import java.util.List;
import java.util.Map;

import framelib.dao.BaseDAOImpl;

import project.edupm.projectmanage.dao.IEduProjectOrgReadDAO;
import project.edupm.projectmanage.pojo.EduProjectOrg;
import project.organization.pojo.OrganizationProject;

@SuppressWarnings("unchecked")
public class IEduProjectOrgReadDAOImpl extends BaseDAOImpl implements IEduProjectOrgReadDAO {


	@Override
	public List<EduProjectOrg> selectOrgProjByParam(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectOrganizationProjectByParam",param);
	}

	@Override
	public Integer selectOrgProjCountByParam(Map<String, Object> param) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("selectOrganizationProjectCountByParam",param);
	}

	
	@Override
	public List<EduProjectOrg> selectOrgProj(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("selectOrganizationProject",param);
	}

	@Override
	public Integer selectOrgProjCount(Map<String, Object> param) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("selectOrganizationProjectCount",param);
	}
	@Override
	public OrganizationProject selectOrgProject(Map<String, Object> param){
		Object obj = this.getSqlMapClientTemplate().queryForObject("selectOrgProject",param);
		if(obj != null){
			return  (OrganizationProject)obj;
		}
		return null;
	}
	@Override
	public boolean updateOrgProjectComment(Map<String, Object> conditions)
			throws Exception {
		int result = this.getSqlMapClientTemplate().update("updateOrgProjectComment",conditions);
		if(result>0){
			return true;
		}
		return false;
	}
}
