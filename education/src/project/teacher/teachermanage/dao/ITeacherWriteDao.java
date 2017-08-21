package project.teacher.teachermanage.dao;

import java.util.Map;

import project.teacher.teacherProject.pojo.EduAudit;
import project.teacher.teacherProject.pojo.EduIndependentStudy;
import project.teacher.teachermanage.pojo.EduTeacherAdjust;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherJob;
import project.teacher.teachermanage.pojo.EduTeacherMobilize;

public interface ITeacherWriteDao {
	
	public Integer insertTeacherBaseInfo(EduTeacherBasicInfo user) throws Exception;
	
	public Integer insertTeacherJob(EduTeacherJob job) throws Exception;
	
	public Integer insertTeacherEducation(EduTeacherEducation education) throws Exception;

	public Integer updateTeacherJob(EduTeacherJob job) throws Exception;

	public Integer updateTeacherBaseInfo(EduTeacherBasicInfo user) throws Exception;

	public Integer deleteTeacherEducation(Integer teacherId, Integer vserion, Integer status)
			throws Exception;

	/**
	 * 提升基本信息版本
	 * @param teacherId
	 * @param updateBy
	 * @return
	 * @throws Exception
	 */
	public Integer insertUpVersionBaseInfo(String teacherId, String updateBy, Integer status, Integer version) throws Exception;

	/**
	 * 更新基本信息版本状态
	 * @param teacherId
	 * @param updateBy
	 * @param status
	 * @return
	 * @throws Exception
	 */
	Integer updateTeacherBaseInfoStatus(String teacherId, String updateBy,
			Integer status) throws Exception;

	/**
	 * 更新教育经历信息版本状态
	 * @param teacherId
	 * @param updateBy
	 * @param status
	 * @return
	 * @throws Exception
	 */
	Integer updateTeacherEduInfoStatus(String teacherId, String updateBy,
			Integer status) throws Exception;

	/**
	 * 更新工作经历
	 * @param teacherId
	 * @param updateBy
	 * @param status
	 * @return
	 * @throws Exception
	 */
	Integer updateTeacherJobInfoStatus(String teacherId, String updateBy,
			Integer status) throws Exception;

	Integer insertUpVersionJobInfo(String teacherId, String updateBy , Integer status, Integer version)
			throws Exception;

	Integer insertUpVersionEduInfo(String teacherId, String updateBy, Integer status, Integer version)
			throws Exception;

	/**
	 * 新增审核记录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Integer insertTeacherAuditInfo(EduAudit user) throws Exception;

	/**
	 * 教师离退操作
	 * @param edu
	 */
	public Integer updateTeacherRetirees(EduAudit edu);
	
	/**
	 * 审核变更记录
	 * @param params
	 * @return
	 * @throws Exception
	 */
	boolean updateAudit(Map<String,Object> params) throws Exception;
	boolean updateAudit(String ids, Map<String, Object> params) throws Exception;
	
	/**
	 * 通过版本号，更新基本信息
	 * @param version
	 * @return
	 * @throws Exception
	 */
	boolean updateTeacherBaseInfoByVersion(int version,int status,int teacherId) throws Exception;
	
	/**
	 * 通过版本号，更新教育信息
	 * @param version
	 * @return
	 * @throws Exception
	 */
	boolean updateTeacherEduInfoByVersion(int version,int status,int teacherId) throws Exception;
	
	/**
	 * 通过版本号，更新工作信息
	 * @param version
	 * @return
	 * @throws Exception
	 */
	boolean updateTeacherJobInfoByVersion(int version,int status,int teacherId) throws Exception;
	
	/**
	 * 通过版本号，提升基本信息
	 * @param params
	 * @return
	 * @throws Exception
	 */
	boolean insertBaseInfoByVersion(Map<String,Object> params) throws Exception;
	
	/**
	 * 通过版本号，提升工作信息
	 * @param params
	 * @return
	 * @throws Exception
	 */
	boolean insertJobInfoByVersion(Map<String,Object> params) throws Exception;
	
	boolean updateUserVersionById(int userId,int version) throws Exception;
	
	/**
	 * 将小于版本号的记录状态置为无效--基本信息
	 * @param teacherId
	 * @param version
	 * @return
	 * @throws Exception
	 */
	boolean updateBaseInfoStatusByVersion(int teacherId,int version) throws Exception;
	/**
	 * 将小于版本号的记录状态置为无效--教育信息
	 * @param teacherId
	 * @param version
	 * @return
	 * @throws Exception
	 */
	boolean updateEduInfoStatusByVersion(int teacherId,int version) throws Exception;
	/**
	 * 将小于版本号的记录状态置为无效--工作信息
	 * @param teacherId
	 * @param version
	 * @return
	 * @throws Exception
	 */
	boolean updateJobInfoStatusByVersion(int teacherId,int version) throws Exception;
	
	/**
	 * 调动管理。新增JOB表数据
	 * @param pojo
	 * @param status 数据状态
	 * @param version 数据版本
	 * @return
	 * @throws Exception
	 */
	public Integer insertUpVersionJobMobilizeInfo(EduTeacherMobilize pojo, Integer status, Integer version) throws Exception;
	
	/**
	 * 编制调整。新增JOB表数据
	 * @param pojo
	 * @param status 数据状态
	 * @param version 数据版本
	 * @return
	 * @throws Exception
	 */
	public Integer insertUpVersionJobAdjustInfo(EduTeacherAdjust pojo, Integer status, Integer version) throws Exception;
	
	/**
	 * 调动成功，更新USER新版本
	 * @author cl
	 * @param userId
	 * @param version
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public boolean updateUserVersionForMobilizeById(int version,EduTeacherMobilize pojo) throws Exception;
	
	/**
	 * 新增教师自主学习
	 */
	public Integer insertIndeptStudy(EduIndependentStudy pojo) throws Exception;

	/**
	 * 删除教师自主研修
	 */
	public boolean deleteIndeptStudy(int isId);

	/**
	 * 修改自主研修
	 */
	public boolean updateIndeptStudy(Map<String, Object> conditions);

	/**
	 * 删除教师特殊研修
	 */
	public boolean deleteSpecialCase(int id);

	/**
	 * 修改教师特殊研修
	 */
	public boolean updateSpecialCase(Map<String, Object> conditions);

}
