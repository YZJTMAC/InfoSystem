package project.edupm.projectmanage.dao;

import java.util.List;
import java.util.Map;

import project.edupm.projectmanage.pojo.EduProjectOrg;
import project.organization.pojo.OrganizationProject;

public interface IEduProjectOrgReadDAO {
	
	public List<EduProjectOrg> selectOrgProjByParam(Map<String,Object> param);
	
	public Integer selectOrgProjCountByParam(Map<String,Object> param);
	
	public List<EduProjectOrg> selectOrgProj(Map<String,Object> param);
	
	public Integer selectOrgProjCount(Map<String,Object> param);
	public OrganizationProject selectOrgProject(Map<String, Object> param);
	/**
	 * 
	 * 修改评价
	 * @param param
	 * @return
	 */
	public boolean updateOrgProjectComment(Map<String, Object> conditions)
			throws Exception ;
}
