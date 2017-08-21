package project.edupm.projectclass.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.common.Common;
import project.edupm.projectclass.dao.IProjectClassReadDAO;
import project.edupm.projectclass.dao.IProjectClassWriteDAO;
import project.edupm.projectclass.pojo.EduProjectClass;
import project.edupm.projectclass.pojo.OrgClass;
import project.edupm.projectclass.service.IProjectClassService;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

public class ProjectClassServiceImpl implements IProjectClassService{
	
	@Autowired
	@Qualifier("eduProjectClassWriteDAO")
	IProjectClassWriteDAO projectClassWriteDAO;
	
	@Autowired
	@Qualifier("eduProjectClassReadDAO")
	IProjectClassReadDAO projectClassReadDAO;

	@Override
	public boolean saveClass(int projectId, EduProjectClass clazz)
			throws Exception {
		clazz.setStatus(Common.DATA_VALID);
		int classId = projectClassWriteDAO.insertClass(clazz);
		
		if(classId != 0){
			return projectClassWriteDAO.insertProjectClassCategory(projectId, classId);
		}else{
			throw new Exception("课程添加失败！");
		}
	}
	
	@Override
	public PageObject projectClasses(int proId,Map<String, Object> params,int startIndex,int pageSize) throws Exception {
		PageObject po = new PageObject();
		params.put("proId", proId);
		int count = projectClassReadDAO.countClassByProId(params);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		params.put("startIndex", po.getStartIndex());
		params.put("endIndex", pageSize);
		List<EduProjectClass> classes = projectClassReadDAO.selectClassByProId(params);
		po.setObjects(classes);
		return po;
	}

	@Override
	public boolean deleteClass(int classId) throws Exception {
		boolean ok = projectClassWriteDAO.deleteClassById(classId);
		boolean ok2 = projectClassWriteDAO.deleteClassProjectCategory(classId);
		if(ok && ok2){
			return true;
		}
		return false;
	}

	@Override
	public EduProjectClass qryClassById(int classId) throws Exception {
		return projectClassReadDAO.selectClassById(classId);
	}

	@Override
	public boolean modifyClass(EduProjectClass clazz) throws Exception {
		clazz.setUpdateDate(new Date());
		return projectClassWriteDAO.updateClass(clazz);
	}

	@Override
	public List<OrgClass> projectClassByOrg(int projectId) throws Exception {
		List<OrgClass> list = projectClassReadDAO.selectClassByOrg(projectId);
		String n = "";
		StringBuilder sb = new StringBuilder();
		Map<String,Object> map = new HashMap<String,Object>();
//		OrgClass oc = new OrgClass();
		for(OrgClass c:list){
			if(c.getOrgName().equals(n)){
				sb.append(c.getClasses());
				sb.append(",");
			}else{
				sb = new StringBuilder();
				sb.append(c.getClasses());
				sb.append(",");
				n = c.getOrgName();
			}
			map.put(c.getOrgName(), sb.toString().substring(0, sb.length()-1));
		}
		Set<String> set = map.keySet();
		List<OrgClass> rr = new ArrayList<OrgClass>();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String key = it.next();
			OrgClass oc = new OrgClass();
			oc.setOrgName(key);
			oc.setClasses(map.get(key).toString());
			rr.add(oc);
		}
		return rr;
	}

}
