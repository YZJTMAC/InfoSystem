package project.organization.dao;

import java.util.List;
import java.util.Map;

import project.edupm.projectmanage.pojo.EduProjectTrainingMaterials;
import project.organization.pojo.OrgProTeacherActivity;
import project.organization.pojo.OrgProTeacherScoreActivity;
import project.organization.pojo.OrgProjectInfoActivity;
import project.organization.pojo.Organization;
import project.organization.pojo.OrganizationProject;
import project.organization.pojo.OrganizationProjectActivity;
import project.organization.pojo.ProjectClassActivity;
import project.teacher.teacherProject.pojo.EduUserPojo;
import project.teacher.teachermanage.pojo.TeacherExportActivity;

/**
 * Title: IOrganizationReadDAOIF
 * Description: 机构ReadDAO接口
 * 
 * @Create_by: zhangxiaoqi
 * @Create_date:2014-03-27
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 */
public interface IOrganizationReadDAOIF {

	// 机构: 承培项目列表记录总数
	public int selectOrgProjectCount(Map<String, Object> paramMap) throws Exception;

	// 机构: 承培项目列表
	public List<OrganizationProjectActivity> selectOrgProjectList(Map<String, Object> paramMap) throws Exception;

	// 机构: 承培项目详情
	public OrgProjectInfoActivity selectOrgProjectInfoByProjectId(Map<String, Integer> paramMap) throws Exception;
	
	// 机构: 承培项目详情中的此项目所有的承培机构
	public List<String> selectOrgNameByProjectId(Integer projectId)throws Exception;

	public OrganizationProject selectOrgProject(Map<String, Integer> map) throws Exception;

	// 机构: 某一项目参训教师列表记录总数
	public int selectOrgProjectTeachersCount(Map<String, Object> paramMap) throws Exception;

	// 机构: 某一项目参训教师列表
	public List<OrgProTeacherActivity> selectOrgProjectTeachers(Map<String, Object> paramMap) throws Exception;

	// 机构: 承培项目教师评价记录总数
	public int selectOrgProTeacherScoreCount(Map<String, Object> paramMap) throws Exception;

	// 机构: 承培项目教师评价
	public List<OrgProTeacherScoreActivity> selectOrgProTeacherScore(Map<String, Object> paramMap) throws Exception;
	/**
	 * 根据地点查询机构（完整信息）
	 * @return
	 * @throws Exception
	 */
	List<Organization> selectOrgByArea(Map params) throws Exception;
	List<Organization> projectNameList(Map params) throws Exception;

	// 查看身份证号在某机构的某项目中是否存在
	public int selectTeacherIdByIdNumberOrgIdProId(Map<String, Object> paramMap)  throws Exception ;
	
	/**
	 * 根据地点查询机构（完整信息）数量
	 * @return
	 * @throws Exception
	 */
	int countOrgByArea(Map params) throws Exception;
	
	/**
	 * 查询项目所分配的机构
	 * @param params key:projectId,startIndex,pageSize
	 * @return
	 * @throws Exception
	 *	2014-4-3
	 * Devil
	 */
	List<OrganizationProject> selectOPByProjectId(Map<String,Object> params) throws Exception;
	
	int countOPByProjectId(Map<String,Object> params) throws Exception;

	public int selectOrgIdByUserId(int userId)throws Exception;
	
	public Organization selectOrgProByUserId(int userId)throws Exception;
	
	// 查询已报名教师的数量
	public int selectOrgProTeacherCount(Map<String, Object> map) throws Exception;

	// 机构: 查询某一项目下创建的课程
	public List<ProjectClassActivity> selectClassByCondition(Map<String, Object> paramMap) throws Exception;

	// 机构: 查询当前项目可以设置的培训学科
	public OrganizationProject selectOrgProClassScope(Map<String, Object> paramMap) throws Exception;

	//  查询当前机构下某一项目的课程总数
	public int selectOrgProClassCount(Map<String, Object> paramMap) throws Exception;
	
	List<Organization> selectAllOrganizations() throws Exception;

	// 某机构的某项目的参训教师idnumber, realName
	public List<EduUserPojo> selectTeacherInfoByOrgIdProId(Map<String, Object> paramMap) throws Exception;

	// 机构: 某一项目参训教师列表(无分页)
	public List<TeacherExportActivity> queryTeacherActivetyListByConditionNoPage(Map<String, Object> paramMap) throws Exception;

	// 根据edu_project_commom表version查询教师报名时的任教学科/学段
	public TeacherExportActivity queryTeacherByCondition(Map<String, Object> paramMap) throws Exception;

	// 根据proId查询机构id, name
	public List<OrganizationProject> selectOrgIdAndNameByProId(Integer projectId) throws Exception;

	// 查询某一地区的所有机构
	public List<Organization> selectOrgInfoByCode(Map<String, Object> paramMap) throws Exception;

	/**
	 * 根据projectId查询项目下所有的承培机构承培项目信息
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	public List<OrganizationProject> queryOrgByProId(int projectId) throws Exception;
	//机构名称查询
	public Organization getOrgNameById (int organizationId)throws Exception;
	
	List<EduProjectTrainingMaterials> queryEduProjectTrainingMaterialsByCondition(Map<String,Object> params) throws Exception;
	
	public int selectSsOrgProjectCount(Map<String, Object> paramMap) throws Exception;
	
	public List<OrganizationProjectActivity> selectSsOrgProjectList(Map<String, Object> paramMap) throws Exception;
}
