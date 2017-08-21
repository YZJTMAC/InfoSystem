package project.organization.dao.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import project.edupm.projectmanage.pojo.EduProjectTrainingMaterials;
import project.organization.dao.IOrganizationReadDAOIF;
import project.organization.pojo.OrgProTeacherActivity;
import project.organization.pojo.OrgProTeacherScoreActivity;
import project.organization.pojo.OrgProjectInfoActivity;
import project.organization.pojo.Organization;
import project.organization.pojo.OrganizationProject;
import project.organization.pojo.OrganizationProjectActivity;
import project.organization.pojo.ProjectClassActivity;
import project.teacher.teacherProject.pojo.EduUserPojo;
import project.teacher.teachermanage.pojo.TeacherExportActivity;
import framelib.dao.BaseDAOImpl;

/**
 * Title: OrganizationReadDAOImpl
 * Description: 机构ReadDAO接口实现
 * 
 * @Create_by: zhangxiaoqi
 * @Create_date:2014-03-27
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 */
public class OrganizationReadDAOImpl extends BaseDAOImpl implements IOrganizationReadDAOIF{

	public int selectOrgProjectCount(Map<String, Object> paramMap) throws Exception {
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("selectOrgProjectListCount", paramMap);
		if(count==null){
			return 0;
		}
		return count;
	}

	
	@SuppressWarnings("unchecked")
	public List<OrganizationProjectActivity> selectOrgProjectList(Map<String, Object> paramMap) throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectOrgProjectList", paramMap);
	}


	public OrgProjectInfoActivity selectOrgProjectInfoByProjectId(Map<String, Integer> paramMap) throws Exception {
		return (OrgProjectInfoActivity) this.getSqlMapClientTemplate().queryForObject("selectOrgProjectInfoByProjectId", paramMap);
	}


	@SuppressWarnings("unchecked")
	public List<String> selectOrgNameByProjectId(Integer projectId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectOrgNameByProjectId", projectId);
	}

	
	public OrganizationProject selectOrgProject(Map<String, Integer> map)throws Exception {
		return (OrganizationProject) this.getSqlMapClientTemplate().queryForObject("selectOrgProject", map);
	}


	public int selectOrgProjectTeachersCount(Map<String, Object> paramMap)throws Exception {
		int a = (Integer) this.getSqlMapClientTemplate().queryForObject("selectOrgProTeachersCount", paramMap);
		return a;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<OrgProTeacherActivity> selectOrgProjectTeachers(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectOrgProTeachers", paramMap);
	}

	
	public int selectOrgProTeacherScoreCount(Map<String, Object> paramMap) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectOrgProTeacherScoreCount", paramMap);
	}

	
	@SuppressWarnings("unchecked")
	public List<OrgProTeacherScoreActivity> selectOrgProTeacherScore(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectOrgProTeacherScore", paramMap);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> selectOrgByArea(Map params) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_org_by_area",params);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> projectNameList(Map params) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectProjectByParam",params);
	}


	@Override
	public int selectTeacherIdByIdNumberOrgIdProId(Map<String, Object> paramMap)  throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectTeacherIdByIdNumberOrgIdProId", paramMap);
	}


	@SuppressWarnings("unchecked")
	@Override
	public int countOrgByArea(Map params) throws Exception {
		
		return (Integer) this.getSqlMapClientTemplate().queryForObject("count_org_by_area",params);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationProject> selectOPByProjectId(Map<String, Object> params) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("select_OP_by_project_id",params);
	}


	@Override
	public int countOPByProjectId(Map<String, Object> params) throws Exception {
		Object obj = this.getSqlMapClientTemplate().queryForObject("count_OP_by_project_id",params);
		if(obj == null){
			return 0;
		}
		return (Integer)obj;
	}


	@Override
	public int selectOrgIdByUserId(int userId) throws Exception {
		Integer orgId = (Integer)this.getSqlMapClientTemplate().queryForObject("selectOrgIdBuUserId", userId);
		if(orgId==null){
			return 0;
		}else{
			return orgId;
		}
	}


	@Override
	public int selectOrgProTeacherCount(Map<String, Object> map) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectOrgProTeacherCount", map);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectClassActivity> selectClassByCondition(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectClassByCondition", paramMap);
	}


	@Override
	public OrganizationProject selectOrgProClassScope(Map<String, Object> paramMap) throws Exception {
		return (OrganizationProject) this.getSqlMapClientTemplate().queryForObject("selectOrgProClassScope", paramMap);
	}


	@Override
	public int selectOrgProClassCount(Map<String, Object> paramMap) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectOrgProClassCount", paramMap);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> selectAllOrganizations() throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectAllOragnizations");
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<EduUserPojo> selectTeacherInfoByOrgIdProId(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectTeacherInfoByOrgIdProId", paramMap);
	}


	// 机构: 某一项目参训教师列表(无分页)
	@SuppressWarnings("unchecked")
	@Override
	public List<TeacherExportActivity> queryTeacherActivetyListByConditionNoPage(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("queryTeacherActivetyListByConditionNoPage", paramMap);
	}


	// 根据edu_project_commom表version查询教师报名时的任教学科/学段
	@Override
	public TeacherExportActivity queryTeacherByCondition(Map<String, Object> paramMap) throws Exception {
		return (TeacherExportActivity) this.getSqlMapClientTemplate().queryForObject("queryTeacherByCondition", paramMap);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Organization selectOrgProByUserId(int userId)
			throws Exception {
		List<Organization> list = this.getSqlMapClientTemplate().queryForList("selectOrgByUserId",userId);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationProject> selectOrgIdAndNameByProId(Integer projectId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectOrgIdAndNameByProId", projectId);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> selectOrgInfoByCode(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectOrgInfoByCode", paramMap);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationProject> queryOrgByProId(int projectId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("queryOrgByProId", projectId);
	}


	@Override
	public Organization getOrgNameById(int organizationId) throws Exception {
		return (Organization) this.getSqlMapClientTemplate().queryForObject("selectorganizationInfoById",organizationId);
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<EduProjectTrainingMaterials> queryEduProjectTrainingMaterialsByCondition(
			Map<String, Object> params) throws Exception {
		
		 List<EduProjectTrainingMaterials> resultList = Collections.emptyList();
		 resultList = this.getSqlMapClientTemplate().queryForList("queryEduProjectTrainingMaterialsByCondition",params);
		 return resultList;
	}

	@Override
	public int selectSsOrgProjectCount(Map<String, Object> paramMap) throws Exception {
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("selectSsOrgProjectListCount", paramMap);
		if(count==null){
			return 0;
		}
		return count;
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<OrganizationProjectActivity> selectSsOrgProjectList(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectSsOrgProjectList", paramMap);
	}
}
