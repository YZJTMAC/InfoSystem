package project.teacher.teacherProject.dao.impl;

import java.util.HashMap;
import java.util.Map;

import project.teacher.teacherProject.dao.ITeacherProjectWriteDaoIF;
import framelib.dao.BaseDAOImpl;

public class TeacherProjectWriteDaoImpl extends BaseDAOImpl implements ITeacherProjectWriteDaoIF{
	
	@Override
	public boolean insertCommentTeacherInfo2(String projectId, Integer teacherId,int jobVersion,String loginAccount,int status,String type)
			throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("teacherId", teacherId);
		paramMap.put("projectId", projectId);
		paramMap.put("version", jobVersion);
		
		paramMap.put("loginAccount", loginAccount);
		paramMap.put("status", status);
		paramMap.put("type", type);
		Object obj = this.getSqlMapClientTemplate().insert("teacherAddProjectBaoming2",paramMap);
		if(obj == null){
			return true;
		}
		return false;
	}

	@Override
	public boolean insertCommentTeacherInfo(Integer organizationId, String projectId, Integer teacherId,int jobVersion,String loginAccount,int status,String type)
			throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("teacherId", teacherId);
		paramMap.put("projectId", projectId);
		paramMap.put("version", jobVersion);
		
		paramMap.put("loginAccount", loginAccount);
		paramMap.put("status", status);
		paramMap.put("type", type);
		paramMap.put("organizationId", organizationId);
		Object obj = this.getSqlMapClientTemplate().insert("teacherAddProjectBaoming",paramMap);
		if(obj == null){
			return true;
		}
		return false;
	}

	@Override
	public boolean insertTeacherComment(Map<String, Object> paramMap)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("addTeacherCommentPro",paramMap);
		if(obj == null){
			return true;
		}
		return false;
	}

	@Override
	public boolean insertTeacherOrganizationId(Map<String, Object> paramMap)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("addTeacherOrganizationId",paramMap);
		if(obj == null){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断教师是否已经报名
	 */
	@Override
	public int countTeacherSignInfo(String projectId, Integer teacherId,int jobVersion,String loginAccount,int status,String type) throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("teacherId", teacherId);
		paramMap.put("projectId", projectId);
		paramMap.put("version", jobVersion);
		
		paramMap.put("loginAccount", loginAccount);
		paramMap.put("status", status);
		paramMap.put("type", type);
		Object obj = super.getSqlMapClientTemplate().queryForObject("CountTeacherSignInfo", paramMap);
		return obj==null?0:(Integer)obj;
	}
	
	@Override
	public int updateTeacherSignInfo(String projectId, Integer teacherId,int jobVersion,String loginAccount,int status,String type){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("teacherId", teacherId);
		paramMap.put("projectId", projectId);
		paramMap.put("version", jobVersion);
		
		paramMap.put("loginAccount", loginAccount);
		paramMap.put("status", status);
		paramMap.put("type", type);
		return super.getSqlMapClientTemplate().update("updateTeacherSign", paramMap);
	}

	@Override
	public boolean insertLendCredit(Map<String, Object> conditions) {
		// TODO Auto-generated method stub
		Object obj = this.getSqlMapClientTemplate().insert("insert_teacher_lend_credit", conditions);
		if(obj == null){
			return false;
		}
		return true;
	}

	@Override
	public boolean updateLendCredit(Map<String, Object> conditions) {
		// TODO Auto-generated method stub
				Object obj = this.getSqlMapClientTemplate().update("update_teacher_lend_credit", conditions);
				if(obj == null){
					return false;
				}
				return true;
	}

	@Override
	public boolean repayLendCredit(Map<String, Object> conditions) {
		// TODO Auto-generated method stub
		Object obj = this.getSqlMapClientTemplate().update("repay_lend_credit", conditions);
		if(obj == null){
			return false;
		}
		return true;
}
	

}
