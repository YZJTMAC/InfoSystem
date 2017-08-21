package project.edupm.projectclass.dao.impl;

import java.util.HashMap;
import java.util.Map;

import project.edupm.projectclass.dao.IProjectClassWriteDAO;
import project.edupm.projectclass.pojo.EduProjectClass;
import framelib.dao.BaseDAOImpl;

public class ProjectClassRWriteDAOImpl extends BaseDAOImpl implements IProjectClassWriteDAO{

	@Override
	public int insertClass(EduProjectClass clazz) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("insert_class",clazz);
		return (Integer)obj;
	}

	@Override
	public boolean insertProjectClassCategory(int projectId, int classId)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectId", projectId);
		params.put("classId", classId);
		params.put("status", 1);
		Object obj = this.getSqlMapClientTemplate().insert("insert_project_class_category",params);
		if(obj == null){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteClassById(int classId) throws Exception {
		int i = this.getSqlMapClientTemplate().delete("delete_class_By_id",classId);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteClassProjectCategory(int classId) throws Exception {
		int i = this.getSqlMapClientTemplate().delete("delete_class_category_by_class_id",classId);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateClass(EduProjectClass clazz) throws Exception {
		int i = this.getSqlMapClientTemplate().update("update_class_ByPrimaryKeyWithBLOBs",clazz);
		if(i > 0){
			return true;
		}
		return false;
	}


}
