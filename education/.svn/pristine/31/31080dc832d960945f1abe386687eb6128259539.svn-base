package project.edupm.projectclass.dao;

import java.util.List;
import java.util.Map;

import project.edupm.projectclass.pojo.EduProjectClass;
import project.edupm.projectclass.pojo.OrgClass;


public interface IProjectClassReadDAO {
	
	/**
	 * 项目课程--无分页
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	List<EduProjectClass> selectClassByProId(int proId) throws Exception;
	
	
	/**
	 * 项目课程--有分页
	 * @param proId
	 * @return
	 * @throws Exception
	 */
	List<EduProjectClass> selectClassByProId(Map<String, Object> params) throws Exception;
	
	int countClassByProId(Map<String, Object> params) throws Exception;
	
	EduProjectClass selectClassById(int classId) throws Exception;
	
	List<OrgClass> selectClassByOrg(int projectId) throws Exception;
	
}
