package project.edupm.projectmanage.service;

import java.util.Map;

import project.organization.pojo.OrganizationProject;

import framelib.utils.page.PageObject;

public interface IEduProjectOrgService {
	
	/**
	 * 查询承配机构能看到的已关闭的项目
	 * @param param
	 * @return
	 */
	public PageObject selectCPOrgProjOfClose(Map<String, Object> param,
			Integer startIndex, Integer pageSize);
	
	public PageObject selectCPOrgProj(Map<String, Object> param,
			Integer startIndex, Integer pageSize,Integer userId);
	
	/**
	 * 
	 * 查询机构的结项评价
	 */
	public OrganizationProject selectOrgProject(Integer projectId, Integer orgId);
	/**
	 * 修改评价
	 * @param projectId
	 * @param orgId
	 * @return
	 */
	public boolean updateOrgProjectComment(Map<String, Object> conditions) throws Exception;
}
