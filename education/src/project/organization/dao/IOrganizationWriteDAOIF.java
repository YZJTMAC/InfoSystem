package project.organization.dao;

import java.util.List;
import java.util.Map;

import project.edupm.projectmanage.pojo.EduProjectTrainingMaterials;
import project.organization.dto.OrgProjectListDTO;
import project.organization.dto.OrganizationDto;
import project.organization.pojo.OrganizationProject;
import project.organization.pojo.ProjectCommonActivity;

/**
 * Title: IOrganizationWriteDAOIF
 * Description: 机构WriteDAO接口
 * 
 * @Create_by: zhangxiaoqi
 * @Create_date:2014-03-27
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 */
public interface IOrganizationWriteDAOIF {

	// 机构: 加锁
	public OrganizationProject selectOrgProjectForLock(Map<String, Object> paramMap) throws Exception;

	// 机构: 设置承培项目培训平台地址
	public boolean updateOrgProject(Map<String, Object> paramMap) throws Exception;

	// 机构: 项目状态设置
	public Integer updateOrgProjetStatus(Map<String, Object> paramMap) throws Exception;

	// 机构: 上传教师培训成绩
	public int updateTeacherScore(List<ProjectCommonActivity> list) throws Exception;
	
	boolean insertOrgProject(OrganizationProject op) throws Exception;
	
	/**
	 * 设置培训机构培训人数，学科，范围
	 * @param params
	 * @return
	 * @throws Exception
	 */
	int updateOP(Map<String, Object> params) throws Exception;

	// 查询已报名教师的数量
	public int selectOrgProTeacherCount(Map<String, Object> map) throws Exception;

	// 更新机构某一项目的参培人数
	public boolean updateOrgProActualNum(Map<String, Object> paramMap) throws Exception;

	public OrgProjectListDTO selectOrgProUrl(Map<String, Object> paramMap);
	
	/**
	 * 批量导入实施机构
	 * @author 曉
	 * @param dtos
	 * @return
	 */
	public boolean insertSSOrgs(List<OrganizationDto> dtos) throws Exception;
	
	
	/**
	 * 实施机构上传培训材料
	 * @param eduProjectTrainingMaterials
	 * @return
	 * @throws Exception
	 */
	public boolean insertTrainingMaterials(EduProjectTrainingMaterials eduProjectTrainingMaterials) throws Exception;
	
	
	/**
	 * 实施机构上传培训材料
	 * @param eduProjectTrainingMaterials
	 * @return
	 * @throws Exception
	 */
	public boolean delteTrainingMaterials(Map<String,Object> params) throws Exception;

}
