package project.edupm.projectclass.dao.impl;

import java.util.List;
import java.util.Map;

import project.edupm.projectclass.dao.IProjectClassReadDAO;
import project.edupm.projectclass.pojo.EduProjectClass;
import project.edupm.projectclass.pojo.OrgClass;
import framelib.dao.BaseDAOImpl;

@SuppressWarnings("unchecked")
public class ProjectClassReadDAOImpl extends BaseDAOImpl implements IProjectClassReadDAO{

	
	@Override
	public List<EduProjectClass> selectClassByProId(int proId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_classes_by_project_id",proId);
	}

	@Override
	public List<EduProjectClass> selectClassByProId(Map<String, Object> params)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_classes_by_project_id_page",params);
		
	}

	@Override
	public int countClassByProId(Map<String, Object> params) throws Exception {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("count_classes_by_project_id_page",params);
	}

	@Override
	public EduProjectClass selectClassById(int classId) throws Exception {
		Object object = this.getSqlMapClientTemplate().queryForObject("select_class_ByPrimaryKey",classId);
		if(object != null){
			return (EduProjectClass)object;
		}
		return null;
	}

	@Override
	public List<OrgClass> selectClassByOrg(int projectId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_class_by_org",projectId);
	}

}
