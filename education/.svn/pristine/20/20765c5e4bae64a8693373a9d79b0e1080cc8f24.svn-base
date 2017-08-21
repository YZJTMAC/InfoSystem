package project.edupm.projectmanage.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

import project.edupm.projectmanage.dao.ISummaryReadDAO;
import project.edupm.projectmanage.dao.impl.ISummaryWriteDAOImpl;
import project.edupm.projectmanage.pojo.EduOrgSummary;
import project.edupm.projectmanage.pojo.EduProjectSummary;
import project.edupm.projectmanage.service.ISummaryService;
import project.teacher.teacherProject.pojo.TeacherSummary;

public class ISummaryServiceImpl implements ISummaryService {
	@Autowired
	@Qualifier("summaryReadDAO")
	ISummaryReadDAO summaryReadDAO;
	
	
	@Autowired
	@Qualifier("summaryWriteDAO")
	ISummaryWriteDAOImpl summaryWriteDAO;
	
	@Override
	public Integer saveSummary(EduProjectSummary eps) {
		return summaryWriteDAO.insertEduProjectSummary(eps);
	}

	@Override
	public EduProjectSummary getSummaryById(Integer id) {
		return summaryReadDAO.selectSummaryById(id);
	}

	@Override
	public Integer updateSummary(EduProjectSummary eps) {
		return summaryWriteDAO.updateEduProjectSummary(eps);
	}

	@Override
	public Integer writeSummary(EduProjectSummary eps) {
		EduProjectSummary searchEps = summaryReadDAO.selectSummaryById(eps.getId());
		if(searchEps==null){
			return summaryWriteDAO.insertEduProjectSummary(eps);
		}
		
		return summaryWriteDAO.updateEduProjectSummary(eps);
	}

	@Override
	public EduProjectSummary getSummaryByParam(EduProjectSummary eps) {
		List<EduProjectSummary> list = summaryReadDAO.selectSummaryByParam(eps);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<EduOrgSummary> selectOrgSummaryByParam(Map<String, Object> paramMap) {
		return summaryReadDAO.selectOrgSummaryByParam(paramMap);
	}

	@Override
	public Integer selectOrgSummaryCountByParam(Map<String, Object> paramMap) {
		return summaryReadDAO.selectOrgSummaryByParam(paramMap).size();
	}

	@Override
	public PageObject selectOrgSummayByPage(Map<String, Object> paramMap,
			int startPage, int pageSize) throws Exception {
		PageObject po = new PageObject();
		Integer count = summaryReadDAO.selectOrgSummaryByParam(paramMap).size();
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startPage, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<EduOrgSummary> list = summaryReadDAO.selectOrgSummaryByParam(paramMap);
		if(list!= null && list.size()!= 0){
			po.setObjects(list);
		}else{
			po.setCount(0);
		}
		return po;
	}

	@Override
	public Integer selectTeacherSummaryCountByParam(Map<String, Object> paramMap) {
		return null;
	}

	@Override
	public List<TeacherSummary> selectTeacherSummaryByParam(
			Map<String, Object> paramMap) {
		return null;
	}

	@Override
	public PageObject selectTeacherSummayByPage(Map<String, Object> paramMap,
			int startPage, int pageSize) throws Exception {
		PageObject po = new PageObject();
		//冗余查询，查询一次即可
//		Integer count = summaryReadDAO.selectTeacherSummaryByParam(paramMap).size();
		List<TeacherSummary> list = summaryReadDAO.selectTeacherSummaryByParam(paramMap);
		po.setCount(list.size());
		PageParser.getPageObject(PageParser.getPageInfo(startPage, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
//		List<TeacherSummary> list = summaryReadDAO.selectTeacherSummaryByParam(paramMap);
		if(list!= null && list.size()!= 0){
			po.setObjects(list);
		}else{
			po.setCount(0);
		}
		return po;
	}

}
