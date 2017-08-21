package project.edupm.projectmanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;
import project.edupm.projectmanage.dao.IEduProjectOrgReadDAO;
import project.edupm.projectmanage.pojo.EduProjectOrg;
import project.edupm.projectmanage.pojo.EduProjectSummary;
import project.edupm.projectmanage.service.IEduProjectOrgService;
import project.edupm.projectmanage.service.ISummaryService;
import project.organization.pojo.OrganizationProject;

public class IEduProjectOrgServiceImpl implements IEduProjectOrgService {

	@Autowired
	@Qualifier("projectOrgDao")
	IEduProjectOrgReadDAO projectOrgDao;
	
	@Autowired
	@Qualifier("summaryService")
	ISummaryService summaryService;
	
	
	@Override
	public PageObject selectCPOrgProjOfClose(Map<String, Object> param,Integer startIndex,Integer pageSize) {
		PageObject po = new PageObject();
		Integer count = projectOrgDao.selectOrgProjCountByParam(param);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		param.put("startIndex", po.getStartIndex());
		param.put("endIndex", pageSize);
		List<EduProjectOrg> proList = projectOrgDao.selectOrgProjByParam(param);
		po.setObjects(proList);
		return po;
	}


	@Override
	public PageObject selectCPOrgProj(Map<String, Object> param,
			Integer startIndex, Integer pageSize,Integer userId) {
		PageObject po = new PageObject();
		Integer count = projectOrgDao.selectOrgProjCount(param);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		param.put("startIndex", po.getStartIndex());
		param.put("endIndex", pageSize);
		List<EduProjectOrg> proList = projectOrgDao.selectOrgProj(param);
		EduProjectSummary eps = new EduProjectSummary();
		for(EduProjectOrg eo:proList){
			Map<String,Object> map = new HashMap<String, Object>();
			eo.setExtendInfo(map);
			eps.setProjectId(eo.getId());
			eps.setCreateBy(userId);
			EduProjectSummary summary = summaryService.getSummaryByParam(eps);
			if(summary!=null){
				eo.getExtendInfo().put("summaryId", summary.getId());
			}else{
				eo.getExtendInfo().put("summaryId", 0);
				System.out.println(summary);
			}
		}
		po.setObjects(proList);
		return po;
	}


	@Override
	public OrganizationProject selectOrgProject(Integer projectId, Integer orgId) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("projectId", projectId);
		params.put("orgId", orgId);
		OrganizationProject o = projectOrgDao.selectOrgProject(params);
		return o;
	}


	@Override
	public boolean updateOrgProjectComment(Map<String, Object> conditions) throws Exception{
		return projectOrgDao.updateOrgProjectComment(conditions);
	}
	

	
}
