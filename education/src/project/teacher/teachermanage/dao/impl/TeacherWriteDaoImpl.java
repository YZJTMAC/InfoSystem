package project.teacher.teachermanage.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.edupm.projectmanage.dao.IEduProjectWriteDAO;
import project.teacher.teacherProject.pojo.EduAudit;
import project.teacher.teacherProject.pojo.EduIndependentStudy;
import project.teacher.teachermanage.dao.ITeacherWriteDao;
import project.teacher.teachermanage.pojo.EduTeacherAdjust;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherJob;
import project.teacher.teachermanage.pojo.EduTeacherMobilize;
import framelib.dao.BaseDAOImpl;

public class TeacherWriteDaoImpl extends BaseDAOImpl implements ITeacherWriteDao {  
	
	@Autowired
	@Qualifier("eduProjectWriteDAO")
	IEduProjectWriteDAO proWriteDao;
	@Override
	public Integer updateTeacherRetirees(EduAudit audit) {
		Object obj = this.getSqlMapClientTemplate().update("update_audit_retirees_status", audit);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public Integer insertTeacherBaseInfo(EduTeacherBasicInfo user) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("teacher_base_insert", user);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	
	@Override
	public Integer insertTeacherAuditInfo(EduAudit audit) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("TeacherAudit_insert", audit);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	
	
	@Override 
	public Integer insertUpVersionBaseInfo(String teacherId, String updateBy, Integer status, Integer version) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("teacherIdA", teacherId);
		param.put("teacherIdB", teacherId);
		param.put("updateBy", updateBy);
		param.put("status", status);
		param.put("version", version);
		Object obj = this.getSqlMapClientTemplate().insert("teacher_base_insert_addversion", param);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	
	@Override 
	public Integer insertUpVersionEduInfo(String eduId, String updateBy, Integer status, Integer version) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("eduId", eduId);
		param.put("updateBy", updateBy);
		param.put("status", status);
		param.put("version", version);
		Object obj = this.getSqlMapClientTemplate().insert("teacher_edu_insert_addversion", param);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	
	@Override 
	public Integer insertUpVersionJobInfo(String teacherId, String updateBy, Integer status, Integer version) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("teacherIdA", teacherId);
		param.put("teacherIdB", teacherId);
		param.put("updateBy", updateBy);
		param.put("version", version);
		param.put("status", status);
		Object obj = this.getSqlMapClientTemplate().insert("teacher_job_insert_addversion", param);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	
	@Override
	public Integer updateTeacherBaseInfoStatus(String teacherId, String updateBy, Integer status ) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("teacherId", teacherId);
		param.put("updateBy", updateBy);
		param.put("status", status);
		Object obj = this.getSqlMapClientTemplate().update("update_batch_base_status", param);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}
	
	@Override
	public Integer updateTeacherEduInfoStatus(String teacherId, String updateBy, Integer status ) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("teacherId", teacherId);
		param.put("updateBy", updateBy);
		param.put("status", status);
		Object obj = this.getSqlMapClientTemplate().update("update_batch_Edu_status", param);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}
	
	@Override
	public Integer updateTeacherJobInfoStatus(String teacherId, String updateBy, Integer status ) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("teacherId", teacherId);
		param.put("updateBy", updateBy);
		param.put("status", status);
		Object obj = this.getSqlMapClientTemplate().update("update_batch_Job_status", param);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}
	
	@Override
	public Integer updateTeacherBaseInfo(EduTeacherBasicInfo user) throws Exception {
		int obj = this.getSqlMapClientTemplate().update("teacher_base_update", user);
		return obj;
	}
	
	
	@Override
	public Integer insertTeacherJob(EduTeacherJob job) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("teacher_job_insert", job);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	
	@Override
	public Integer updateTeacherJob(EduTeacherJob job) throws Exception {
		Object obj = this.getSqlMapClientTemplate().update("teacher_job_update", job);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}
	
	@Override
	public Integer insertTeacherEducation(EduTeacherEducation education) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("teacher_educateion_insert", education);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	
	@Override
	public Integer deleteTeacherEducation(Integer teacherId, Integer version, Integer status) throws Exception {
		EduTeacherEducation education = new EduTeacherEducation();
		education.setTeacherId(teacherId);
		education.setVersion(version);
		education.setStatus(status);
		Object obj = this.getSqlMapClientTemplate().delete("teacher_educateion_delete", education);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}

	@Override
	public boolean updateAudit(Map<String, Object> params) throws Exception {
		int i = this.getSqlMapClientTemplate().update("update_audit",params);
		if(i >0){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateAudit(String ids, Map<String, Object> params)
			throws Exception {
		if(ids.length()>0){
			String[] cids = ids.split(",");
			return proWriteDao.updateAudit(cids, params);
		}
		return false;
	}

	@Override
	public boolean updateTeacherBaseInfoByVersion(int version,int status,int teacherId) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("status", status);
		params.put("version", version);
		params.put("teacherId", teacherId);
		int i = this.getSqlMapClientTemplate().update("update_base_info_by_version",params);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateTeacherEduInfoByVersion(int version,int status,int teacherId) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("status", status);
		params.put("version", version);
		params.put("teacherId", teacherId);
		int i = this.getSqlMapClientTemplate().update("update_edu_info_by_version",params);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateTeacherJobInfoByVersion(int version,int status,int teacherId) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("status", status);
		params.put("version", version);
		params.put("teacherId", teacherId);
		int i = this.getSqlMapClientTemplate().update("update_job_info_by_version",params);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean insertBaseInfoByVersion(Map<String, Object> params)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("teacher_base_addversion",params);
		if(obj != null){
			return true;
		}
		return false;
	}

	@Override
	public boolean insertJobInfoByVersion(Map<String, Object> params)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("teacher_job_addversion",params);
		if(obj != null){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUserVersionById(int userId,int version) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		params.put("version", version);
		int i = this.getSqlMapClientTemplate().update("user_addVersion",params);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBaseInfoStatusByVersion(int teacherId, int version)
			throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("teacherId", teacherId);
		params.put("version", version);
		int i = this.getSqlMapClientTemplate().update("update_base_info_le_new_version",params);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEduInfoStatusByVersion(int teacherId, int version)
			throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("teacherId", teacherId);
		params.put("version", version);
		int i = this.getSqlMapClientTemplate().update("update_edu_info_le_new_version",params);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateJobInfoStatusByVersion(int teacherId, int version)
			throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("teacherId", teacherId);
		params.put("version", version);
		int i = this.getSqlMapClientTemplate().update("update_job_info_le_new_version",params);
		if(i>0){
			return true;
		}
		return false;
	}
	
	/**
	 * 调动管理。新增JOB表数据
	 * @param pojo
	 * @param status 数据状态
	 * @param version 数据版本
	 * @return
	 * @throws Exception
	 */
	public Integer insertUpVersionJobMobilizeInfo(EduTeacherMobilize pojo, Integer status, Integer version) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("teacherId", pojo.getTeacherId());
		param.put("jobCommentPositionType",pojo.getJobCommentPositionType());
		param.put("jobCommentPosition", pojo.getJobCommentPosition());
		param.put("jobRecruitmentPositionType", pojo.getJobRecruitmentPositionType());
		param.put("jobRecruitmentPosition", pojo.getJobRecruitmentPosition());
		param.put("jobSchoolAdministrationOffice", pojo.getJobSchoolAdministrationOffice());
		param.put("jobSchoolAdministrationOfficeType", pojo.getJobSchoolAdministrationOfficeType());
		param.put("jobFormerTeachingSection", pojo.getJobFormerTeachingSection());
		param.put("jobFormerTeachingSectionType", pojo.getJobFormerTeachingSectionType());
		param.put("jobFormerTeachingSubject", pojo.getJobFormerTeachingSubject());
		param.put("jobFormerTeachingSubjectType", pojo.getJobFormerTeachingSubjectType());
		param.put("jobCoreTeacherType", pojo.getJobCoreTeacherType());
		param.put("jobCoreTeacher", pojo.getJobCoreTeacher());
		param.put("jobWhetherTeacher", pojo.getJobWhetherTeacher());
		param.put("jobCountyRuralTeacher", pojo.getJobCountyRuralTeacher());
		param.put("jobCreateBy", pojo.getAuditCreateBy());
		param.put("version", version);
		param.put("status", status);
		Object obj = this.getSqlMapClientTemplate().insert("teacher_job_insert_addversion_mobilize", param);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	
	/**
	 * 编制调整。新增JOB表数据
	 * @param pojo
	 * @param status 数据状态
	 * @param version 数据版本
	 * @return
	 * @throws Exception
	 */
	public Integer insertUpVersionJobAdjustInfo(EduTeacherAdjust pojo, Integer status, Integer version) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("teacherId", pojo.getTeacherId());
		param.put("adjustId", pojo.getNewAdjustId());
		param.put("adjustName", pojo.getNewAdjustName());
		param.put("jobCreateBy", pojo.getAuditCreateBy());
		param.put("version", version);
		param.put("status", status);
		Object obj = this.getSqlMapClientTemplate().insert("teacher_job_insert_addversion_adjust", param);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	
	/**
	 * 调动成功，更新USER新版本
	 * @author cl
	 * @param userId
	 * @param version
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public boolean updateUserVersionForMobilizeById(int version,EduTeacherMobilize pojo) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", pojo.getTeacherId());
		params.put("schoolId", pojo.getNewSchoolId());
		params.put("schoolName", pojo.getNewSchoolName());
		
		params.put("userProvinceId", pojo.getNewProvinceId());
		params.put("userProvinceName", pojo.getNewProvinceName());
		params.put("userCityId", pojo.getNewCityId());
		params.put("userCityName", pojo.getNewCityName());
		params.put("userDistrictId", pojo.getNewDistrictId());
		params.put("userDistrictName", pojo.getNewDistrictName());
		params.put("version", version);
		params.put("status", 8);
		params.put("userSchoolName", pojo.getNewSchoolName());
		int i = this.getSqlMapClientTemplate().update("user_updateVersionForMobilize",params);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public Integer insertIndeptStudy(EduIndependentStudy pojo) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("isCredit", pojo.getIsCredit());
		param.put("isAnnotation", pojo.getIsAnnotation());
		param.put("isYear", pojo.getIsYear());
		param.put("isStudyTypeId", pojo.getIsStudyTypeId());
		param.put("isStudyTypeName", pojo.getIsStudyTypeName());
		param.put("trainFormId", pojo.getTrainFormId());
		param.put("trainFormName", pojo.getTrainFormName());
		param.put("teacherId", pojo.getTeacherId());
		param.put("teacherName", pojo.getTeacherName());
		param.put("createDate", pojo.getCreateDate());
		param.put("status", 1);
		Object obj = this.getSqlMapClientTemplate().insert("insert_teacher_indept_study", param);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}

	@Override
	public boolean deleteIndeptStudy(int isId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", isId);
		Object obj = this.getSqlMapClientTemplate().delete("delete_teacher_indept_study", param);
		if (obj != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateIndeptStudy(Map<String, Object> conditions) {
		int i = this.getSqlMapClientTemplate().update("update_indept_study",conditions);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteSpecialCase(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		Object obj = this.getSqlMapClientTemplate().delete("delete_teacher_special_case", param);
		if (obj != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateSpecialCase(Map<String, Object> conditions) {
		int i = this.getSqlMapClientTemplate().update("update_special_case",conditions);
		if(i>0){
			return true;
		}
		return false;
	}

	
}