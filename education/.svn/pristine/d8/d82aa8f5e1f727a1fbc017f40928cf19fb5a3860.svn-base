package project.organization.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;

import project.edupm.projectmanage.pojo.EduProjectTrainingMaterials;
import project.organization.dao.IOrganizationWriteDAOIF;
import project.organization.dto.OrgProjectListDTO;
import project.organization.dto.OrganizationDto;
import project.organization.pojo.OrganizationProject;
import project.organization.pojo.ProjectCommonActivity;

import com.ibatis.sqlmap.client.SqlMapExecutor;

import framelib.dao.BaseDAOImpl;

/**
 * Title: OrganizationWriteDAOImpl
 * Description: 机构WriteDAO接口实现
 * 
 * @Create_by: zhangxiaoqi
 * @Create_date:2014-03-27
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 */
public class OrganizationWriteDAOImpl extends BaseDAOImpl implements IOrganizationWriteDAOIF{

	public OrganizationProject selectOrgProjectForLock(Map<String, Object> paramMap)throws Exception {
		return (OrganizationProject) this.getSqlMapClientTemplate().queryForObject("selectOrgProject_forLock", paramMap);
	}


	public boolean updateOrgProject(Map<String, Object> paramMap) {
		Object obj = this.getSqlMapClientTemplate().update("updateOrgProject", paramMap);
		if(obj != null){
			int i = Integer.parseInt(obj.toString());
			if(i>0){
				return true;
			} else {
				return false;
			}
		}
		return false; 
	}


	public Integer updateOrgProjetStatus(Map<String, Object> paramMap)throws Exception {
		return (Integer)this.getSqlMapClientTemplate().update("updateOrgProjectStatus", paramMap);
	}


	public int updateTeacherScore(final List<ProjectCommonActivity> list) throws Exception {
		Object obj = this.getSqlMapClientTemplate().execute(
				new SqlMapClientCallback<Object>() {
					public Object doInSqlMapClient(SqlMapExecutor arg0)throws SQLException {
						arg0.startBatch();
						for (ProjectCommonActivity pojo : list) {
//							Map<String, Object> paramMap = new HashMap<String, Object>();
//							paramMap.put("projectId", pojo.getProjectId());
//							paramMap.put("orgId", pojo.getOrganizationId());
//							paramMap.put("teacherId", pojo.getTeacherId());
							arg0.update("updateTeacherScore", pojo);
						}
						arg0.executeBatch();
						return null;
					}
				});
		if (obj == null) {
			return 1;// 插入成功
		} else {
			return 0;
		}
	}


	@Override
	public boolean insertOrgProject(OrganizationProject op) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("inser_project_org", op);
		if(obj == null){
			return true;
		}
		return false;
	}


	@Override
	public int updateOP(Map<String, Object> params) throws Exception {
		return  this.getSqlMapClientTemplate().update("setOP",params);
	}


	@Override
	public boolean updateOrgProActualNum(Map<String, Object> paramMap) throws Exception {
		int rtn  = this.getSqlMapClientTemplate().update("updateOrgProActualNum", paramMap);
		if (rtn >= 0) {
			return true;// 更新成功
		} else {
			return false;
		}
	}
	
	@Override
	public int selectOrgProTeacherCount(Map<String, Object> map) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("selectOrgProTeacherCount", map);
	}


	@Override
	public OrgProjectListDTO selectOrgProUrl(Map<String, Object> paramMap) {
		OrgProjectListDTO dto = (OrgProjectListDTO) this.getSqlMapClientTemplate().queryForObject("selectOrgProUrl", paramMap);
		return dto;
		/*if (obj == null) {
			return false; 
		} else {
			return true;
		}*/
	}


	@Override
	public boolean insertSSOrgs(final List<OrganizationDto> dtos) throws Exception {
		Object obj = this.getSqlMapClientTemplate().execute(
				new SqlMapClientCallback<Object>() {
					public Object doInSqlMapClient(SqlMapExecutor arg0)throws SQLException {
						arg0.startBatch();
						for (OrganizationDto pojo : dtos) {
							arg0.update("insert_ssorg", pojo);
						}
						arg0.executeBatch();
						return null;
					}
				});
		if (obj == null) {
			return true;// 插入成功
		} else {
			return false;
		}
	}

	/**
	 * 实施机构上传培训材料
	 * @param eduProjectTrainingMaterials
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean insertTrainingMaterials(EduProjectTrainingMaterials eduProjectTrainingMaterials) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("insert_edu_project_training_materials", eduProjectTrainingMaterials);
		if(obj != null){
			return true;
		}
		return false;
	}


	@Override
	public boolean delteTrainingMaterials(Map<String, Object> params)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().delete("deleteEduProjectTrainingMaterialsByCondition",params);
		if(obj != null){
			return true;
		}
		return false;
	}

}
