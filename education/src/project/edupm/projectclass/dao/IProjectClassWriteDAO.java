package project.edupm.projectclass.dao;

import project.edupm.projectclass.pojo.EduProjectClass;

public interface IProjectClassWriteDAO {
	
	int insertClass(EduProjectClass clazz) throws Exception;
	
	boolean insertProjectClassCategory(int projectId,int classId) throws Exception;
	
	boolean deleteClassById(int classId) throws Exception;
	
	boolean deleteClassProjectCategory(int classId) throws Exception;
	
	boolean updateClass(EduProjectClass clazz) throws Exception;
}
