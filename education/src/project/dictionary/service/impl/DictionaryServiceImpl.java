package project.dictionary.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;
import project.dictionary.dao.IDictionaryReadDao;
import project.dictionary.dao.IDictionaryWriteDao;
import project.dictionary.service.IDictionaryService;
import project.system.pojo.SysDictionary;

public class DictionaryServiceImpl implements IDictionaryService{
@Autowired
@Qualifier("dictionaryReadDao")
IDictionaryReadDao dictionaryReadDao;
@Autowired
@Qualifier("dictionaryWriteDao")
IDictionaryWriteDao dictionaryWriteDao;
	@Override
	public PageObject querySysDictionary(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(dictionaryReadDao.selectSysDictionaryCount(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po
				.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<SysDictionary> list = dictionaryReadDao.selectSysDictionaryList(paramMap);
		po.setObjects(list);
		return po;
	}
	@Override
	public PageObject querySysDictionary(Map<String, Object> paramMap) throws Exception {
		PageObject po = new PageObject();		
		List<SysDictionary> list = dictionaryReadDao.selectSysDictionaryTemList(paramMap);
		po.setObjects(list);
		return po;
	}
	@Override
	public PageObject querySysDictionaryes(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(dictionaryReadDao.selectSysDictionaryCount(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po
				.getCount()), po);
		/*paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);*/
		List<SysDictionary> list = dictionaryReadDao.selectSysDictionaryListes(paramMap);
		po.setObjects(list);
		return po;
	}
	@Override
	public boolean saveDictionaryInfo(Map<String, Object> paramMap)
			throws Exception {
		return dictionaryWriteDao.insertDictionarInfo(paramMap);
	}
	@Override
	public boolean updateDictionaryInfoById(Map<String, Object> paramMap)
			throws Exception {
		return dictionaryWriteDao.updateDictionaryInfo(paramMap);
	}
	@Override
	public boolean deleteDictionaryInfoById(Map<String, Object> paramMap)
			throws Exception {
		String dictionaryType = (String)paramMap.get("dictionaryType");
		String id = (String)paramMap.get("dictionaryCode");
		// 判断字典是否被占用
		if(!StringUtils.isEmpty(dictionaryType)) {
			// 学段
			if("stduty_section".equals(dictionaryType)) {
				Integer result = 0;
				
				// 教师工作经历表
				paramMap.put("whereSql", "job_former_teaching_section_type = " + id );
				paramMap.put("tableName", "edu_teacher_job");
				result = dictionaryWriteDao.selectUsedDictionaryInfoByCondition(paramMap);
				if(result.intValue() > 0) return false;	
				
				// 项目培训信息表
				paramMap.put("whereSql", "stduty_section_id = " + id );
				paramMap.put("tableName", "edu_project_train_target");
				result = dictionaryWriteDao.selectUsedDictionaryInfoByCondition(paramMap);
				if(result.intValue() > 0) return false;	
				
			//学科	
			} else if("project_subject".equals(dictionaryType)) {
				Integer result = 0;
				
				// 教师工作经历表
				paramMap.put("whereSql", "job_former_teaching_section_type like '%"+id+"%'"  );
				paramMap.put("tableName", "edu_teacher_job");
				result = dictionaryWriteDao.selectUsedDictionaryInfoByCondition(paramMap);
				if(result.intValue() > 0) return false;	
				
				// 项目培训信息表
				paramMap.put("whereSql", "subject_id like '%"+id+"%'");
				paramMap.put("tableName", "edu_project_train_target");
				result = dictionaryWriteDao.selectUsedDictionaryInfoByCondition(paramMap);
				if(result.intValue() > 0) return false;	
				// 学历
			} else if("educational_user".equals(dictionaryType)) {
				Integer result = 0;
				
				// 教师学历表
				paramMap.put("whereSql", "education_experience_type = "+id );
				paramMap.put("tableName", "edu_teacher_education");
				result = dictionaryWriteDao.selectUsedDictionaryInfoByCondition(paramMap);
				if(result.intValue() > 0) return false;	
				
				// 项目培训信息表
				paramMap.put("whereSql", "education_background_id = "+id);
				paramMap.put("tableName", "edu_project_train_target");
				result = dictionaryWriteDao.selectUsedDictionaryInfoByCondition(paramMap);
				if(result.intValue() > 0) return false;	
				// 学位
			} else if("academic_degree".equals(dictionaryType)) {
				Integer result = 0;
				
				// 教师学历表
				paramMap.put("whereSql", "education_degree_type = "+id  );
				paramMap.put("tableName", "edu_teacher_education");
				result = dictionaryWriteDao.selectUsedDictionaryInfoByCondition(paramMap);
				if(result.intValue() > 0) return false;	
				
				// 项目培训信息表
				paramMap.put("whereSql", "education_background_id = "+id );
				paramMap.put("tableName", "edu_project_train_target");
				result = dictionaryWriteDao.selectUsedDictionaryInfoByCondition(paramMap);
				if(result.intValue() > 0) return false;	
			}

			
			
		} else {
			return false;
		}
		return dictionaryWriteDao.deleteDictionaryInfoById(paramMap);
	}
	@Override
	public List<SysDictionary> selectAllSysDictionaryList(
			Map<String, Object> paramMap) throws Exception {
		return dictionaryReadDao.selectAllSysDictionaryList(paramMap);
	}
	public SysDictionary selectSysDictionaryInfo(
			Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return dictionaryReadDao.selectSysDictionaryInfo(paramMap);
	}

}
