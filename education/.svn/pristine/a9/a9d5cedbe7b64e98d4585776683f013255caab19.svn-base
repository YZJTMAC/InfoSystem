package project.edupm.projectclass.service;

import java.util.List;
import java.util.Map;

import framelib.utils.page.PageObject;
import project.edupm.projectclass.pojo.EduProjectClass;
import project.edupm.projectclass.pojo.OrgClass;


public interface IProjectClassService {
	/**
	 * 添加课程
	 * @param projectId
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public boolean saveClass(int projectId,EduProjectClass clazz) throws Exception;
	
	/**
	 * 获取项目课程--有分页(无项目信息)
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	public PageObject projectClasses(int proId,Map<String, Object> params,int startIndex,int pageSize) throws Exception;
	
	public boolean deleteClass(int classId) throws Exception;
	
	public EduProjectClass qryClassById(int classId) throws Exception;
	
	public boolean modifyClass(EduProjectClass clazz) throws Exception;
	
	public  List<OrgClass> projectClassByOrg(int projectId) throws Exception;
}
