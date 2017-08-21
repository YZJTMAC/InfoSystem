package project.teacher.teachermanage.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.common.Common;
import project.person.dao.IUserWriteDao;
import project.person.pojo.EduUser;
import project.teacher.teacherProject.dao.ITeacherProjectReadDaoIF;
import project.teacher.teacherProject.pojo.EduAudit;
import project.teacher.teacherProject.service.ITeacherProjectServiceIF;
import project.teacher.teachermanage.dao.ITeacherReadDao;
import project.teacher.teachermanage.dao.ITeacherWriteDao;
import project.teacher.teachermanage.dto.EduTeacherEduDTO;
import project.teacher.teachermanage.pojo.EduTeacherAdjust;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherJob;
import project.teacher.teachermanage.pojo.EduTeacherMobilize;
import project.teacher.teachermanage.pojo.EduTeacherVersionPOJO;
import project.teacher.teachermanage.pojo.TeacherExportActivity;
import project.teacher.teachermanage.pojo.TeacherInfoChangeRecord;
import project.teacher.teachermanage.service.ITeacherManageService;
import framelib.service.AbsService;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

@SuppressWarnings("unchecked")
public class TeacherManageServiceImpl extends AbsService implements
		ITeacherManageService {

	private static final Logger log = Logger
			.getLogger(TeacherManageServiceImpl.class);

	@Autowired
	@Qualifier("teacherReadDao")
	ITeacherReadDao teacherReadDao;

	@Autowired
	@Qualifier("userWriteDao")
	IUserWriteDao userWriteDao;

	@Override
	public Integer modifyTeacherRetireesAudit(String auditId, String teahcerId, String changeType, String auditStatus, String auditOption,
			String auditName, String auditAccunt) throws Exception {
		// 1 更新审核记录状态
		Map<String, Object> params = new HashMap<String, Object>();
		if("1".equals(auditStatus)) {
			params.put("status",  Common.COMMON_AUDIT_PASS);
			// 2 更新 user  表 教师状态
			userWriteDao.updateUserStatus(teahcerId, auditAccunt,
					Integer.valueOf(changeType), null);
		} else {
			params.put("status", Common.COMMON_AUDIT_UNPASS);
		}
		
		params.put("auditId", auditId);
		params.put("memo", auditOption);
		params.put("auditor", auditAccunt);
		boolean result = teacherWriteDao.updateAudit(params);
		return result ? 1 : -1;
	}
	
	@Override
	public Integer modifyTeacherRetirees(String teahcerId, String changeType,
			String auditName, String auditAccunt, String mobilizeMark) throws Exception {
 
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", teahcerId);
		EduUser eduUserInfo = teacherProjectServiceIF
				.selectTeacherBasicInfo(paramMap);
		// 判断该教师是否已经为离退状态
		if (eduUserInfo.getStatus().intValue() >= 30 && eduUserInfo.getStatus().intValue() < 40) {
			return -1;
		}
		// 更新教师状态 为 离退休
//		userWriteDao.updateUserStatus(teahcerId, auditAccunt,
//				Common.TEACHER_STATUS_9, null);

		EduAudit edu = new EduAudit();
		edu.setTeacherId(Integer.valueOf(teahcerId));
		edu.setChangeType(Integer.valueOf(changeType));
		edu.setNewCityId(eduUserInfo.getUserCityId());
		edu.setNewCityName(eduUserInfo.getUserCityName());
		edu.setNewProvinceId(eduUserInfo.getUserProvinceId());
		edu.setNewProvinceName(eduUserInfo.getUserProvinceName());
		edu.setNewDistrictId(eduUserInfo.getUserDistrictId());
		edu.setNewDistrictName(eduUserInfo.getUserDistrictName());
		edu.setNewSchoolId(eduUserInfo.getSchoolId());
		edu.setNewSchoolName(eduUserInfo.getSchoolName());
		edu.setAuditCreateBy(auditAccunt);
		edu.setAuditAuditor(auditName);
		edu.setAuditCreateDate(new Date());
		edu.setAuditDate(new Date());
		edu.setOldVersion(eduUserInfo.getVersion());
		edu.setAuditStatus(Common.COMMON_AUDIT_UNHANDL);
		edu.setAuditUpdateBy(auditAccunt);
		edu.setAuditUpdateDate(new Date());
		edu.setMobilizeMark(mobilizeMark);
		return teacherWriteDao.insertTeacherAuditInfo(edu);
	}

	@Autowired
	@Qualifier("teacherWriteDao")
	ITeacherWriteDao teacherWriteDao;

	@Autowired
	@Qualifier("teacherProjectReadDao")
	ITeacherProjectReadDaoIF teacherProjectReadDao;

	@Autowired
	@Qualifier("teacherProjectService")
	ITeacherProjectServiceIF teacherProjectServiceIF;

	@Override
	public PageObject queryTeacherActivetyListPage(
			Map<String, Object> paramMap, int startPage, int pageSize)
			throws Exception {
		PageObject po = new PageObject();
		po.setCount(teacherReadDao
				.selectTeacherActivetyCountByCondition(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(startPage, pageSize, po
				.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<Object> list = teacherReadDao
				.selectTeacherActivetyListByCondition(paramMap);
		po.setObjects(list);
		return po;
	}
	
	@Override
	public List<TeacherExportActivity> queryTeacherActivetyListNoPage(
			Map<String, Object> paramMap)
			throws Exception {
		return teacherReadDao.selectTeacherActivetyListByConditionNoPage(paramMap);
	}

	@Override
	public PageObject queryTeacherRetiressActivetyListPage(
			Map<String, Object> paramMap, int startPage, int pageSize)
			throws Exception {
		PageObject po = new PageObject();
		po.setCount(teacherReadDao
				.selectTeacherRetiressActivetyCountByCondition(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(startPage, pageSize, po
				.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<Object> list = teacherReadDao
				.selectTeacherRetiressActivetyListByCondition(paramMap);
		po.setObjects(list);
		return po;
	}

	public Integer saveTeacherUserInfo(EduUser pojo) throws Exception {
		if (pojo != null && pojo.getId() != null && pojo.getId().intValue() > 0) {
			return userWriteDao.updateUser(pojo);
		} else {
			pojo.setRoleId(Common.ROLE_TEACHER_5);
			Integer userId = userWriteDao.insertUser(pojo);
			saveOtherInfo(userId, pojo.getCreateBy());
			return userId;
		}
	}
	
	/**
	 * 第一次教师新增时，插入其他 空白信息
	 */
	public void saveOtherInfo(Integer userId, String teacherCreateBy) throws Exception {
		EduTeacherBasicInfo base = new EduTeacherBasicInfo();
		base.setTeacherId(userId);
		base.setVersion(1);
		base.setStatus(project.common.Common.DATA_VALID);
		base.setTeacherCreateBy(teacherCreateBy);
		base.setTeacherCreateDate(new Date());
		base.setTeacherUpdateBy(teacherCreateBy);
		base.setTeacherUpdateDate(new Date());
		Integer eduBaseId = teacherWriteDao.insertTeacherBaseInfo(base);
		
		EduTeacherEducation edu = new EduTeacherEducation();
		edu.setTeacherId(userId);
		edu.setEducationCreateBy(teacherCreateBy);
		edu.setEducationUpdateBy(teacherCreateBy);
		edu.setEducationCreateDate(new Date());
		edu.setEducationUpdateDate(new Date());
		edu.setVersion(1);
		edu.setSort(1);
		edu.setStatus(project.common.Common.DATA_VALID);
		saveTeacherEducation(edu);
		
		EduTeacherJob job = new EduTeacherJob();
		job.setTeacherId(userId);
		job.setJobCreateBy(teacherCreateBy);
		job.setJobUpdateBy(teacherCreateBy);
		job.setJobCreateDate(new Date());
		job.setJobUpdateDate(new Date());
		job.setVersion(1);
		job.setStatus(project.common.Common.DATA_VALID);
		Integer eduJobId = teacherWriteDao.insertTeacherJob(job);
	}
	 
	public Integer saveTeacherBaseInfo(EduTeacherBasicInfo pojo, Integer roleId) throws Exception {
		//验证是否已经存在记录
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		if(roleId.intValue() != Common.ROLE_TEACHER_5.intValue()) {
			pojo.setStatus(Common.DATA_VALID);
			paramMap.put("status", Common.DATA_VALID);
		}
		
		paramMap.put("teacherId", pojo.getTeacherId());
		EduTeacherBasicInfo basicInfo = teacherProjectServiceIF.selectTeacherBasicInfoByTeacherId(paramMap);
		
		// 保存user电话 和邮箱
		if(pojo.getTeacherEmail()!= null || pojo.getTeacherPhoneNum() != null) {
			EduUser user = new EduUser();
			user.setId(pojo.getTeacherId());
			if(pojo.getTeacherEmail()!= null) 
				user.setMail(pojo.getTeacherEmail());
			if(pojo.getTeacherPhoneNum() != null) 
				user.setMobile(pojo.getTeacherPhoneNum());
			userWriteDao.updateUser(user);
		}
		
		if (basicInfo != null) {
			pojo.setVersion(basicInfo.getVersion());
			return teacherWriteDao.updateTeacherBaseInfo(pojo);
		} else {
			return teacherWriteDao.insertTeacherBaseInfo(pojo);
		}
	}

	/**
	 * 判断两个对象是否相等
	 * @param objA
	 * @param objB
	 * @return true 相等
	 */
	private boolean compare(Object objA, Object objB) {
		boolean flag = false;
		if (objA == null && objB == null) {
			flag = true;
		} else if (objA != null && objB == null) {
			flag = false;
		} else if (objA == null && objB != null) {
			flag = false;
		} else if (objA instanceof String) {
			flag = ((String) objA).equals((String) objB);
		} else if (objA instanceof Integer) {
			flag = ((Integer) objA).intValue() == ((Integer) objB).intValue();
		} else if (objA instanceof Long) {
			flag = ((Long) objA).intValue() == ((Long) objB).intValue();
		} else if (objA instanceof Date) {
			flag = ((Date) objA).getTime() == ((Date) objB).getTime();
		}
		return flag;
	}

	private boolean test(List<String> sysInfo, EduTeacherJob oldJob,
			EduTeacherJob newJob) {
		boolean flag = false;
		if (oldJob == null && newJob == null) {
			return true;
		} else if (oldJob != null && newJob == null) {
			return false;
		} else if (oldJob == null && newJob != null) {
			return false;
		}
		for (String str : sysInfo) {
			switch (Integer.valueOf(str)) {
			// 1 教师资格证书号
			case 1:
				flag = compare(oldJob.getJobCertificateNum(), newJob.getJobCertificateNum());
				break;
			// 2:任教时间
			case 2:
				flag = compare(oldJob.getJobWorkDate(), newJob.getJobWorkDate());
				break;
			case 3:
				// 3: (评)教师职称
				flag = compare(oldJob.getJobCommentPositionType(), newJob.getJobCommentPositionType());
				break;
			case 4:
				// 4: (聘)教师职称
				flag = compare(oldJob.getJobRecruitmentPositionType(), newJob.getJobRecruitmentPositionType());
				break;
			case 5:
				// 5: 学校行政职务
				flag = compare(oldJob.getJobSchoolAdministrationOffice(), newJob.getJobSchoolAdministrationOffice());
				break;
			case 6:
				// 6: 当前任教学段学科
				boolean flagA = compare(oldJob.getJobFormerTeachingSectionType(), newJob.getJobFormerTeachingSectionType());
				boolean flagB = compare(oldJob.getJobFormerTeachingSubjectType(), newJob.getJobFormerTeachingSubjectType());
				flag = flagA && flagB;
				break;
			case 7:
				// 7: 是否骨干教师
				flag = compare(oldJob.getJobCoreTeacher(), newJob.getJobCoreTeacher());
				break;
			case 8:
				// 8: 是否班主任
				flag = compare(oldJob.getJobWhetherTeacher(), newJob.getJobWhetherTeacher() );
				break;
			case 9:
				// 9: 国培计划农村骨干教师
				flag = compare(oldJob.getJobCountyRuralTeacher(), newJob.getJobCountyRuralTeacher());
				break;
			}
			if(!flag) {
				return flag;
			}
		}
		return flag;
	}

	public Integer saveTeacherJobInfo(EduTeacherJob pojo, List<String> sysInfo,
			Integer roleId, String optionName) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("teacherId", pojo.getTeacherId());

		if (roleId.intValue() != Common.ROLE_TEACHER_5.intValue()) {
			paramMap.put("status", Common.DATA_VALID);
			pojo.setStatus(Common.DATA_VALID);
		}

		// 教师JOB信息
		EduTeacherJob jobInfo = teacherProjectServiceIF
				.selectTeacherJobInfoByTeacherId(paramMap);
//		boolean flag = test(sysInfo, jobInfo, pojo);
		
		if (jobInfo != null) {
			// 针对用户状态 在职 && 数据必须有效
			paramMap.put("userId", pojo.getTeacherId());
			EduUser eduUserInfo = teacherProjectServiceIF
					.selectTeacherBasicInfo(paramMap);
			if (roleId.intValue() == Common.ROLE_TEACHER_5.intValue()
					&& jobInfo.getStatus().intValue() != Common.DATA_NO_VALID
//					&& !flag
					&& eduUserInfo.getStatus().intValue() == Common.TEACHER_STATUS_8
							.intValue()) {
				
				// 1 判断是否为编制变更申请， 否则为信息变更申请
				Integer changType = Common.CHANGE_TYPE_1;
				//当教师修改工作信息时，不再判别是否为基本信息变更还是编制变更;
				//因为教师在修改时如果修改了编制，编制是需要审核的，就让在信息变更中审核，不单独在教师编制中审核;只有单独在发起编制变更时，再需要编制审核。
				/*if(!compare(jobInfo.getAdjustId(), pojo.getAdjustId())) {
					changType = Common.CHANGE_TYPE_50;
				}*/
				
				// 2 提升到编辑版本（status：0）
				Integer currentVersion = addVersion(pojo.getTeacherId()
						.toString(), pojo.getJobUpdateBy(), optionName, eduUserInfo, changType, jobInfo, pojo);

				pojo.setVersion(currentVersion + 1);
				pojo.setStatus(Common.DATA_NO_VALID);
				return teacherWriteDao.insertTeacherJob(pojo);
			} else {
				// 否则正常更新
				return teacherWriteDao.updateTeacherJob(pojo);
			}
		} else {
			pojo.setStatus(Common.DATA_VALID);
			return teacherWriteDao.insertTeacherJob(pojo);
		}
	}

	/**
	 * 根据系统开关 增加新版本 （版本status 为 无效数据）
	 * @param teacherId
	 * @param optionBy
	 * @param OptionName
	 * @param eduUserInfo
	 * @param changeType 变更申请类型 1 信息变更  50 编制调整
	 * @return
	 * @throws Exception
	 */
	private Integer addVersion(String teacherId, String optionBy,
			String OptionName, EduUser eduUserInfo, Integer changeType, EduTeacherJob jobInfo, EduTeacherJob pojo) throws Exception {
		// 查询user 表的版本记录
		EduTeacherVersionPOJO version = teacherReadDao
				.selectTeacherAllVersion(Integer.valueOf(teacherId));

		// 更新旧数据状态
		// teacherWriteDao.updateTeacherBaseInfoStatus(teacherId, optionBy,
		// Common.TEACHER_STATUS_0);
		// teacherWriteDao.updateTeacherEduInfoStatus(teacherId, optionBy,
		// Common.TEACHER_STATUS_0);
		// teacherWriteDao.updateTeacherJobInfoStatus(teacherId, optionBy,
		// Common.TEACHER_STATUS_0);

		// 通过审核 需要生成 教师基本信息新版本
		//当教师修改工作信息时，不再保存教师基本信息和教育经历信息，因为教师的工作信息修改时，是需要上级审核的，
		//基本信息和教育经历信息是不需要审核的。
		/*teacherWriteDao.insertUpVersionBaseInfo(teacherId, optionBy,
				Common.DATA_NO_VALID, version.getUserVersion() + 1);

		// 教育经历 存在多条情况
		List<EduTeacherEducation> edulist = teacherProjectReadDao
				.selectTeacherEducationByTeacherId(Integer.valueOf(teacherId),
						null);

		// 通过审核 需要生成 教师教育经历版本
		for (EduTeacherEducation obj : edulist) {
			teacherWriteDao.insertUpVersionEduInfo(obj.getId().toString(),
					optionBy, Common.DATA_NO_VALID,
					version.getUserVersion() + 1);
		}*/

		// 通过审核 需要生成 教师工作经历新版本
		 //teacherWriteDao.insertUpVersionJobInfo(teacherId, optionBy,
		 //Common.DATA_NO_VALID, version.getUserVersion() + 1);

		// 创建信息变更审核申请
		EduAudit auditHis = new EduAudit();
		auditHis.setAuditStatus(Common.COMMON_AUDIT_UNHANDL);
		auditHis.setTeacherId(Integer.valueOf(teacherId));
		auditHis.setAuditAuditor(optionBy);
		auditHis.setOldVersion(version.getUserVersion());
		auditHis.setNewVersion(version.getUserVersion() + 1);
		auditHis.setAuditDate(new Date());
		auditHis.setAuditCreateBy(optionBy);
		auditHis.setAuditCreateDate(new Date());
		auditHis.setAuditUpdateDate(new Date());
		auditHis.setAuditUpdateBy(optionBy);
		auditHis.setChangeType(changeType);
		auditHis.setNewProvinceId(eduUserInfo.getUserProvinceId());
		auditHis.setNewProvinceName(eduUserInfo.getUserProvinceName());
		auditHis.setNewCityId(eduUserInfo.getUserCityId());
		auditHis.setNewCityName(eduUserInfo.getUserCityName());
		auditHis.setNewDistrictId(eduUserInfo.getUserDistrictId());
		auditHis.setNewDistrictName(eduUserInfo.getUserDistrictName());
		auditHis.setNewSchoolId(eduUserInfo.getSchoolId());
		auditHis.setNewSchoolName(eduUserInfo.getSchoolName());
		
		// 更新审核记录
		teacherWriteDao.insertTeacherAuditInfo(auditHis);

		return version.getUserVersion();
	}
	
	public Integer saveTeacherEducation(EduTeacherEduDTO dto, String optionName, Integer roleId) throws Exception {
		Integer version = 0;
		Integer status = 1;

		Map<String,Object> paramMap = new HashMap<String,Object>();
		if(roleId.intValue() != Common.ROLE_TEACHER_5.intValue()) {
			paramMap.put("status", Common.DATA_VALID);
		}
		
		paramMap.put("teacherId", dto.getTeacherId());
		List<EduTeacherEducation> educationInfo = teacherProjectServiceIF.selectTeacherEducationByTeacherId(paramMap);
		if(educationInfo != null && educationInfo.size() > 0) {
			version = educationInfo.get(0).getVersion();
			status = educationInfo.get(0).getStatus();
		} else {
			EduTeacherVersionPOJO versionObj = teacherReadDao.selectTeacherAllVersion(dto.getTeacherId());
			version = versionObj.getEduVersion();
		}
		
		teacherWriteDao.deleteTeacherEducation(dto.getTeacherId(), version, status);
		for (int i = 0; i <dto.getEduInfoList().size(); i++) {
			EduTeacherEducation pojo = dto.getEduInfoList().get(i);
			//数据库字段类型是DAte,变量是String,如果传过来的值是"",将不能保存成功，故变量值设置为null
			if("".equals(pojo.getEducationGraduationTime())){
				pojo.setEducationGraduationTime(null);
			}
			
			pojo.setEducationCreateBy(optionName);
			pojo.setEducationUpdateBy(optionName);
			pojo.setEducationCreateDate(new Date());
			pojo.setEducationUpdateDate(new Date());
			pojo.setVersion(version);
			pojo.setSort(i + 1);
			pojo.setStatus(status);
			teacherWriteDao.insertTeacherEducation(pojo);
		}

		return 1;
	}

	@Override
	public Integer deleteTeacherBatch(String data, String optionBy)
			throws Exception {
		String[] idArray = data.split(",");
		for (String id : idArray) {
			userWriteDao.updateUserStatus(id, optionBy,
					Common.TEACHER_STATUS_0, null);
		}
		return 1;
	}
	
	
	@Override
	public Integer deleteTeacher(String data) throws Exception {
		// TODO Auto-generated method stub
		
		String[] idArray = data.split(",");
		for (String id : idArray) {
			userWriteDao.deleteTeacher(id);
		}
		return 1;
	}

	/**
	 * 教师信息审核
	 */
	@Override
	public Integer modifyAuditTeacherBatch(String data, String optionBy,String optionRealName,
			boolean isPass, String memo) throws Exception {
		try {
			String[] idArray = data.split(",");
			for (String id : idArray) {
				if (isPass) {
					// 审核通过变成在职
					userWriteDao.updateAuditUser(id, optionBy,optionRealName,
							Common.TEACHER_STATUS_8, memo);
				} else {
					userWriteDao.updateAuditUser(id, optionBy,optionRealName,
							Common.TEACHER_STATUS_7, memo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	/**
	 * 信息变更列表
	 * 
	 * @author cl create date 2014-4-10
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<project.teacher.teachermanage.pojo.EduAudit> queryTeacherChangeList(
			Map<String, Object> paramMap) throws Exception {
		return teacherReadDao.selectTeacherChangeList(paramMap);
	}

	@Override
	public PageObject queryTeacherChangeRecord(Map<String, Object> paramMap,
			int startIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(teacherReadDao.selectCountChangeRecord(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize,
				po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<TeacherInfoChangeRecord> records = teacherReadDao
				.selectChangeRecord(paramMap);
		po.setObjects(records);
		return po;
	}

	@Override
	public boolean procAuditChangeRecord(Map<String, Object> params)
			throws Exception {
		boolean ok = false;
		Integer id = (Integer) params.get("auditId");
		Integer status = (Integer) params.get("status");
		String updateBy = params.get("auditor").toString();
		EduAudit audit = teacherReadDao.selectEduAuditById(id);
		// 查询user 表的版本记录
		EduTeacherVersionPOJO version = teacherReadDao.selectTeacherAllVersion(audit.getTeacherId());
		// 审核不通过时，将旧版本信息复制，以新版本号+1为版本号，同时更新user表中的version
		//当教师修改工作信息时，不再保存教师基本信息和教育经历信息，因为教师的工作信息修改时，是需要上级审核的，
		//基本信息和教育经历信息是不需要审核的。所以审核的时候，就只需修改教师工作经历信息就好了。
		if (status == 12) {
			Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("oldVersion",version.getUserVersion());
			pars.put("updateBy", updateBy);
			pars.put("teacherId", audit.getTeacherId());
			pars.put("newVersion", version.getUserVersion()+1);
			//teacherWriteDao.insertBaseInfoByVersion(pars);
			teacherWriteDao.insertJobInfoByVersion(pars);
			// int curVersion =
			// teacherReadDao.selectTeacherAllVersion(audit.getTeacherId()).getUserVersion();
			/*List<EduTeacherEducation> edus = teacherReadDao
					.selectAllInfoByVersionAndTeacherId(pars);*/
			/*int newVersion = version.getUserVersion() + 1;*/
			/*for (EduTeacherEducation edu : edus) {
				edu.setVersion(newVersion);
				edu.setId(null);
				edu.setTeacherId(audit.getTeacherId());
				edu.setEducationUpdateBy(updateBy);
				edu.setEducationUpdateDate(new Date());
				teacherWriteDao.insertTeacherEducation(edu);
			}*/
			// 提升user版本
			teacherWriteDao.updateUserVersionById(audit.getTeacherId(),
					version.getUserVersion() + 2);
			/*// 将之前的信息状态变为无效
			teacherWriteDao.updateBaseInfoStatusByVersion(audit.getTeacherId(),
					newVersion);*/
			teacherWriteDao.updateJobInfoStatusByVersion(audit.getTeacherId(),
					version.getUserVersion());
			/*teacherWriteDao.updateEduInfoStatusByVersion(audit.getTeacherId(),
					newVersion);*/
		} else if (status == 13) {// 审核通过时，通过版本号，将新信息状态置为有效，同时更新user表中的version
			/*teacherWriteDao.updateTeacherBaseInfoByVersion(audit
					.getNewVersion(), Common.DATA_VALID, audit.getTeacherId());
			teacherWriteDao.updateTeacherEduInfoByVersion(
					audit.getNewVersion(), Common.DATA_VALID, audit
							.getTeacherId());*/
			teacherWriteDao.updateTeacherJobInfoByVersion(
					(version.getUserVersion()+1), Common.DATA_VALID, audit
							.getTeacherId());
			// 提升user版本
			teacherWriteDao.updateUserVersionById(audit.getTeacherId(), (version.getUserVersion()+1));
			/*// 将之前的信息状态变为无效
			teacherWriteDao.updateBaseInfoStatusByVersion(audit.getTeacherId(),
					audit.getNewVersion());*/
			teacherWriteDao.updateJobInfoStatusByVersion(audit.getTeacherId(),
					version.getUserVersion());
			/*teacherWriteDao.updateEduInfoStatusByVersion(audit.getTeacherId(),
					audit.getNewVersion());*/
		}
		ok = teacherWriteDao.updateAudit(params);
		return ok;
	}

	@Override
	public boolean procBatchAuditChangeRecord(int status, String auditId,
			String memo, String auditor) throws Exception {
		boolean ok = false;
		String[] ids = auditId.split(",");
		for (String id : ids) {
			EduAudit audit = teacherReadDao.selectEduAuditById(Integer
					.parseInt(id));
			// 查询user 表的版本记录
			EduTeacherVersionPOJO version = teacherReadDao
					.selectTeacherAllVersion(audit.getTeacherId());
			// 审核不通过时，将旧版本信息复制，以新版本号+1为版本号，同时更新user表中的version
			if (status == 12) {
				Map<String, Object> pars = new HashMap<String, Object>();
				pars.put("oldVersion", version.getUserVersion());
				pars.put("updateBy", auditor);
				pars.put("teacherId", audit.getTeacherId());
				pars.put("newVersion", version.getUserVersion()+1);
				//teacherWriteDao.insertBaseInfoByVersion(pars);
				teacherWriteDao.insertJobInfoByVersion(pars);
				// int curVersion =
				// teacherReadDao.selectTeacherAllVersion(audit.getTeacherId()).getUserVersion();
				/*List<EduTeacherEducation> edus = teacherReadDao
						.selectAllInfoByVersionAndTeacherId(pars);*/
				/*int newVersion = version.getUserVersion() + 1;*/
				/*for (EduTeacherEducation edu : edus) {
					edu.setVersion(newVersion);
					edu.setId(null);
					edu.setTeacherId(audit.getTeacherId());
					edu.setEducationUpdateBy(auditor);
					edu.setEducationUpdateDate(new Date());
					teacherWriteDao.insertTeacherEducation(edu);
				}*/
				// 提升user版本
				teacherWriteDao.updateUserVersionById(audit.getTeacherId(),
						version.getUserVersion() + 2);
				// 将之前的信息状态变为无效
				/*teacherWriteDao.updateBaseInfoStatusByVersion(audit
						.getTeacherId(), newVersion);*/
				teacherWriteDao.updateJobInfoStatusByVersion(audit.getTeacherId(), version.getUserVersion());
				/*teacherWriteDao.updateEduInfoStatusByVersion(audit
						.getTeacherId(), newVersion);*/
				
			} else if (status == 13) {// 审核通过时，通过版本号，将新信息状态置为有效，同时更新user表中的version
				/*teacherWriteDao.updateTeacherBaseInfoByVersion(audit
						.getNewVersion(), Common.DATA_VALID, audit
						.getTeacherId());
				teacherWriteDao.updateTeacherEduInfoByVersion(audit
						.getNewVersion(), Common.DATA_VALID, audit
						.getTeacherId());*/
				System.out.println((version.getUserVersion()+1) + "     ----   " + audit.getTeacherId());
				teacherWriteDao.updateTeacherJobInfoByVersion((version.getUserVersion()+1)
						, Common.DATA_VALID, audit.getTeacherId());
				// 提升user版本
				teacherWriteDao.updateUserVersionById(audit.getTeacherId(),
						version.getUserVersion()+1);
				// 将之前的信息状态变为无效
				/*teacherWriteDao.updateBaseInfoStatusByVersion(audit
						.getTeacherId(), audit.getNewVersion());*/
				teacherWriteDao.updateJobInfoStatusByVersion(audit.getTeacherId(), version.getUserVersion());
				/*teacherWriteDao.updateEduInfoStatusByVersion(audit
						.getTeacherId(), audit.getNewVersion());*/
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("status", status);
			//params.put("auditId", auditId);
			params.put("memo", memo);
			params.put("auditor", auditor);
			ok = teacherWriteDao.updateAudit(auditId,params);
		}
		return ok;
	}
	
	@Override
	public Integer saveTeacherEducation(EduTeacherEducation edu) throws Exception {
		return teacherWriteDao.insertTeacherEducation(edu);
	}
	
	/**
	 * 调动管理列表
	 * 
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @param pageIndex
	 *            当前页
	 * @param pageSize
	 *            页大小
	 * @return
	 * @throws Exception
	 */
	public PageObject queryMobilizeList(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(teacherReadDao.selectMobilizeCount(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po
				.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<EduTeacherMobilize> list = teacherReadDao
				.selectMobilizeList(paramMap);
		po.setObjects(list);
		return po;
	}
	
	/**
	 * 我的调动记录列表
	 * 
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @param pageIndex
	 *            当前页
	 * @param pageSize
	 *            页大小
	 * @return
	 * @throws Exception
	 */
	public PageObject queryTeacherMobilizeList(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(teacherReadDao.selectTeacherMobilizeCount(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po
				.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<EduTeacherMobilize> list = teacherReadDao
				.selectTeacherMobilizeList(paramMap);
		po.setObjects(list);
		return po;
	}
	
	/**
	 * 编制调整管理列表
	 * 
	 * @author cl
	 * @create date 2014-4-26
	 * @param paramMap
	 * @param pageIndex
	 *            当前页
	 * @param pageSize
	 *            页大小
	 * @return
	 * @throws Exception
	 */
	public PageObject queryAdjustList(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(teacherReadDao.selectAdjustCount(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po
				.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<EduTeacherAdjust> list = teacherReadDao
				.selectAdjustList(paramMap);
		po.setObjects(list);
		return po;
	}

	/**
	 * 调动管理 记录详情
	 * 
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduTeacherMobilize queryMobilizeInfo(Map<String, Object> paramMap)
			throws Exception {
		EduTeacherMobilize pojo = new EduTeacherMobilize();
		pojo = teacherReadDao.selectMobilizeInfo(paramMap);
		if (pojo == null) {
			pojo = new EduTeacherMobilize();
		}
		return pojo;
	}

	/**
	 * 调动管理 新建调动 记录列表
	 * 
	 * @author cl
	 * @create date 2014-4-15
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTeacherMobilize> queryCreateMobilizeList(
			Map<String, Object> paramMap) throws Exception {
		return teacherReadDao.selectCreateMobilizeList(paramMap);
	}

	/**
	 * 调动管理 新建调动--需要审核
	 * 
	 * @author cl
	 * @create date 2014-4-16
	 * @return
	 * @throws Exception
	 */
	public Integer createMobilizeForAudit(EduTeacherMobilize pojo)
			throws Exception {
		
		Map<String, Object> teacherData=new HashMap<String, Object>();
		//1、检查是否存在未审核的个人变更记录
		log.info("发起 调动/返聘操作 teacherId" + pojo.getTeacherId() + "1、检查是否存在未审核的个人变更记录");
		teacherData.put("auditStatus", Common.COMMON_AUDIT_UNHANDL);
		teacherData.put("teacherId",pojo.getTeacherId());
		teacherData.put("changeType1", 1);
		teacherData.put("changeType2", 1);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			log.info("发起 调动/返聘操作 teacherId" + pojo.getTeacherId() + "存在未审核的个人变更记录,调动、返聘操作失败！");
			throw new Exception("-1");
		}
		
		//2、检查是否存在未审核的个人调动记录
		log.info("发起 调动/返聘操作 teacherId" + pojo.getTeacherId() + "2、检查是否存在未审核的个人调动记录");
		teacherData.remove("changeType1");
		teacherData.remove("changeType2");
		teacherData.put("changeType1", 2);
		teacherData.put("changeType2", 2);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			log.info("发起 调动/返聘操作 teacherId" + pojo.getTeacherId() + "存在未审核的个人调动记录,调动、返聘操作失败！");
			throw new Exception("-2");
		}
		
		//3、检查是否存在未审核的个人离退操作记录
		log.info("发起 调动/返聘操作 teacherId" + pojo.getTeacherId() + "3、检查是否存在未审核的个人离退操作记录");
		teacherData.remove("changeType1");
		teacherData.remove("changeType2");
		teacherData.put("changeType1", 31);
		teacherData.put("changeType2", 36);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			log.info("发起 调动/返聘操作 teacherId" + pojo.getTeacherId() + "存在未审核的个人离退操作记录,调动、返聘操作失败！");
			throw new Exception("-3");
		}
		
		//3、检查是否存在未审核的个人编制调整记录
		log.info("发起 调动/返聘操作 teacherId" + pojo.getTeacherId() + "3、检查是否存在未审核的个人编制调整记录");
		teacherData.remove("changeType1");
		teacherData.remove("changeType2");
		teacherData.put("changeType1", 50);
		teacherData.put("changeType2", 50);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			log.info("发起 调动/返聘操作 teacherId" + pojo.getTeacherId() + "存在未审核的个人编制调整记录,调动、返聘操作失败！");
			throw new Exception("-03");
		}
		
		// 查询user 表的版本记录
		EduTeacherVersionPOJO version = teacherReadDao
				.selectTeacherAllVersion(pojo.getTeacherId());
		
		/*int versionNew=0;
		Integer[] arrVersion={version.getBaseVersion(),version.getEduVersion(),version.getJobVersion(),version.getUserVersion()};
		
		 for (Integer integer : arrVersion) {
			 //判断最大时 取最大数
             if (integer.intValue() > versionNew)
             {
            	 versionNew = integer.intValue();
             }
		}
		log.info("发起 调动/返聘操作 teacherId" + pojo.getTeacherId() + "4、检查数据版本 并提升版本  新版本号：" +  versionNew + 1);
		// 4、需要生成 教师基本信息新版本 数据状态为无效数据
		teacherWriteDao.insertUpVersionBaseInfo(pojo.getTeacherId().toString(),
				pojo.getAuditCreateBy(), Common.DATA_NO_VALID, versionNew + 1);

		// 5、教育经历 存在多条情况 数据状态为无效数据
		List<EduTeacherEducation> edulist = teacherProjectReadDao
				.selectTeacherEducationByTeacherId(pojo.getTeacherId(), null);
		for (EduTeacherEducation obj : edulist) {
			teacherWriteDao.insertUpVersionEduInfo(obj.getId().toString(), pojo
					.getAuditCreateBy(), Common.DATA_NO_VALID, versionNew + 1);
		}*/

		// 6、需要生成 教师工作经历新版本 数据状态为无效数据
		teacherWriteDao.insertUpVersionJobMobilizeInfo(pojo,
				Common.DATA_NO_VALID, (version.getUserVersion() + 1));

		//7、 创建信息变更审核申请
		EduAudit auditHis = new EduAudit();
		auditHis.setAuditStatus(Common.COMMON_AUDIT_UNHANDL);
		auditHis.setTeacherId(pojo.getTeacherId());
		
		auditHis.setOldVersion(version.getUserVersion());
		auditHis.setNewVersion(version.getUserVersion() + 1);
		
		auditHis.setAuditUpdateDate(new Date());
		auditHis.setAuditUpdateBy(pojo.getAuditCreateBy());
		auditHis.setAuditCreateBy(pojo.getAuditCreateBy());
		auditHis.setAuditCreateDate(new Date());
		
		// 生成返聘 或者 调动的审核记录
		if(!StringUtils.isEmpty(pojo.getFlag()) && "rework".equals(pojo.getFlag())) {
			auditHis.setChangeType(Common.CHANGE_TYPE_40);
		} else {
			auditHis.setChangeType(Common.CHANGE_TYPE_2);
		}
		auditHis.setMobilizeMark(pojo.getMobilizeMark());

		auditHis.setPastProvinceId(pojo.getPastProvinceId());
		auditHis.setPastProvinceName(pojo.getPastProvinceName());
		auditHis.setPastCityId(pojo.getPastCityId());
		auditHis.setPastCityName(pojo.getPastCityName());
		auditHis.setPastDistrictId(pojo.getPastDistrictId());
		auditHis.setPastDistrictName(pojo.getPastDistrictName());
		auditHis.setPastSchoolId(pojo.getPastSchoolId());
		auditHis.setPastSchoolName(pojo.getPastSchoolName());
		
		auditHis.setNewProvinceId(pojo.getNewProvinceId());
		auditHis.setNewProvinceName(pojo.getNewProvinceName());
		auditHis.setNewCityId(pojo.getNewCityId());
		auditHis.setNewCityName(pojo.getNewCityName());
		auditHis.setNewDistrictId(pojo.getNewDistrictId());
		auditHis.setNewDistrictName(pojo.getNewDistrictName());
		auditHis.setNewSchoolId(pojo.getNewSchoolId());
		auditHis.setNewSchoolName(pojo.getNewSchoolName());

		teacherWriteDao.insertTeacherAuditInfo(auditHis);
		log.info("发起 调动/返聘操作 teacherId" + pojo.getTeacherId() + "5、操作结束");
		return (version.getUserVersion() + 1);
	}

	/**
	 * 调动管理 新建调动--不需要审核
	 * 
	 * @author cl
	 * @create date 2014-4-16
	 * @return
	 * @throws Exception
	 */
	public Integer createMobilizeForNoAudit(EduTeacherMobilize pojo)
			throws Exception {
		//数据状态为有效数据
		
		Map<String, Object> teacherData=new HashMap<String, Object>();
		//1、检查是否存在未审核的个人变更记录
		teacherData.put("auditStatus", Common.COMMON_AUDIT_UNHANDL);
		teacherData.put("teacherId",pojo.getTeacherId());
		teacherData.put("changeType1", 1);
		teacherData.put("changeType2", 1);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			throw new Exception("-1");
		}
		
		//2、检查是否存在未审核的个人调动记录
		teacherData.remove("changeType1");
		teacherData.remove("changeType2");
		teacherData.put("changeType1", 2);
		teacherData.put("changeType2", 2);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			throw new Exception("-2");
		}
		
		//3、检查是否存在未审核的个人离退操作记录
		teacherData.remove("changeType1");
		teacherData.remove("changeType2");
		teacherData.put("changeType1", 31);
		teacherData.put("changeType2", 36);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			throw new Exception("-3");
		}
		
		//3、检查是否存在未审核的个人编制调整记录
		teacherData.remove("changeType1");
		teacherData.remove("changeType2");
		teacherData.put("changeType1", 50);
		teacherData.put("changeType2", 50);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			throw new Exception("-03");
		}
		
		// 查询user 表的版本记录
		EduTeacherVersionPOJO version = teacherReadDao
				.selectTeacherAllVersion(pojo.getTeacherId());
		
		/*int versionNew=0;
		Integer[] arrVersion={version.getBaseVersion(),version.getEduVersion(),version.getJobVersion(),version.getUserVersion()};
		
		 for (Integer integer : arrVersion) {
			 //判断最大时 取最大数
             if (integer.intValue() > versionNew)
             {
            	 versionNew = integer.intValue();
             }
		}
		 

		// 4、需要生成 教师基本信息新版本
		teacherWriteDao.insertUpVersionBaseInfo(pojo.getTeacherId().toString(),
				pojo.getAuditCreateBy(), Common.DATA_VALID, versionNew + 1);

		// 5、教育经历 存在多条情况
		List<EduTeacherEducation> edulist = teacherProjectReadDao
				.selectTeacherEducationByTeacherId(pojo.getTeacherId(), null);
		for (EduTeacherEducation obj : edulist) {
			teacherWriteDao.insertUpVersionEduInfo(obj.getId().toString(), pojo
					.getAuditCreateBy(), Common.DATA_VALID, versionNew + 1);
		}*/

		// 6、需要生成 教师工作经历新版本
		teacherWriteDao.insertUpVersionJobMobilizeInfo(pojo,
				Common.DATA_VALID, (version.getUserVersion() + 1));

		//7、 创建信息变更审核申请
		EduAudit auditHis = new EduAudit();
		auditHis.setTeacherId(pojo.getTeacherId());
		auditHis.setAuditStatus(Common.COMMON_AUDIT_AUTOPASS);
		auditHis.setMobilizeMark(pojo.getMobilizeMark());
		auditHis.setAuditUpdateBy(pojo.getAuditCreateBy());
		auditHis.setAuditCreateBy(pojo.getAuditCreateBy());
		auditHis.setOldVersion(version.getUserVersion());
		auditHis.setNewVersion(version.getUserVersion() + 1);
		auditHis.setAuditUpdateDate(new Date());
		auditHis.setAuditCreateDate(new Date());
		if(!StringUtils.isEmpty(pojo.getFlag()) && "rework".equals(pojo.getFlag())) {
			auditHis.setChangeType(Common.CHANGE_TYPE_40);
		} else {
			auditHis.setChangeType(Common.CHANGE_TYPE_2);
		}

		auditHis.setPastProvinceId(pojo.getPastProvinceId());
		auditHis.setPastProvinceName(pojo.getPastProvinceName());
		auditHis.setPastCityId(pojo.getPastCityId());
		auditHis.setPastCityName(pojo.getPastCityName());
		auditHis.setPastDistrictId(pojo.getPastDistrictId());
		auditHis.setPastDistrictName(pojo.getPastDistrictName());
		auditHis.setPastSchoolId(pojo.getPastSchoolId());
		auditHis.setPastSchoolName(pojo.getPastSchoolName());
		
		auditHis.setNewProvinceId(pojo.getNewProvinceId());
		auditHis.setNewProvinceName(pojo.getNewProvinceName());
		auditHis.setNewCityId(pojo.getNewCityId());
		auditHis.setNewCityName(pojo.getNewCityName());
		auditHis.setNewDistrictId(pojo.getNewDistrictId());
		auditHis.setNewDistrictName(pojo.getNewDistrictName());
		auditHis.setNewSchoolId(pojo.getNewSchoolId());
		auditHis.setNewSchoolName(pojo.getNewSchoolName());

		teacherWriteDao.insertTeacherAuditInfo(auditHis);
		
		//8、 提升user版本
		teacherWriteDao.updateUserVersionForMobilizeById((version.getUserVersion() + 1),pojo);
		
		// 将之前的信息状态变为无效
		/*teacherWriteDao.updateBaseInfoStatusByVersion(pojo
				.getTeacherId(), (versionNew + 1));*/
		teacherWriteDao.updateJobInfoStatusByVersion(pojo
				.getTeacherId(), (version.getUserVersion()));
		/*teacherWriteDao.updateEduInfoStatusByVersion(pojo
				.getTeacherId(), (versionNew + 1));*/

		return (version.getUserVersion() + 1);
	}
	
	/**
	 * 调动审核审核通过
	 * @return
	 * @throws Exception
	 */
	public Integer modifyMobilizeInfo(EduTeacherMobilize pojo)throws Exception {
		// 查询user 表的版本记录
		EduTeacherVersionPOJO version = teacherReadDao
				.selectTeacherAllVersion(pojo.getTeacherId());
		
		/*int versionNew=0;
		Integer[] arrVersion={version.getBaseVersion(),version.getEduVersion(),version.getJobVersion(),version.getUserVersion()};
		
		 for (Integer integer : arrVersion) {
			 //判断最大时 取最大数
             if (integer.intValue() > versionNew)
             {
            	 versionNew = integer.intValue();
             }
		}
		
		teacherWriteDao.updateTeacherBaseInfoByVersion(versionNew, Common.DATA_VALID, pojo
				.getTeacherId());
		teacherWriteDao.updateTeacherEduInfoByVersion(versionNew
				, Common.DATA_VALID, pojo
				.getTeacherId());*/
		teacherWriteDao.updateTeacherJobInfoByVersion(version.getUserVersion()+1
				, Common.DATA_VALID, pojo
				.getTeacherId());
		
		// 提升user版本
		teacherWriteDao.updateUserVersionForMobilizeById(version.getUserVersion()+1,pojo);
		
		// 将之前的信息状态变为无效
		/*teacherWriteDao.updateBaseInfoStatusByVersion(pojo
				.getTeacherId(), version.getBaseVersion());*/
		teacherWriteDao.updateJobInfoStatusByVersion(pojo
				.getTeacherId(), version.getUserVersion());
		/*teacherWriteDao.updateEduInfoStatusByVersion(pojo
				.getTeacherId(), version.getEduVersion());*/
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", Common.COMMON_AUDIT_PASS);
		params.put("auditId", pojo.getAuditId());
		params.put("memo", pojo.getAuditOption());
		params.put("auditor", pojo.getAuditCreateBy());
		teacherWriteDao.updateAudit(params);
		
		return 0;
	}
	
	/**
	 * 调动审核审核不通过
	 * @return
	 * @throws Exception
	 */
	public Integer modifyMobilizeInfoNo(EduTeacherMobilize pojo)throws Exception{
		
		// 查询user 表的版本记录
		EduTeacherVersionPOJO version = teacherReadDao
				.selectTeacherAllVersion(pojo.getTeacherId());
		
		/*int versionNew=0;
		Integer[] arrVersion={version.getBaseVersion(),version.getEduVersion(),version.getJobVersion(),version.getUserVersion()};
		
		 for (Integer integer : arrVersion) {
			 //判断最大时 取最大数
             if (integer.intValue() > versionNew)
             {
            	 versionNew = integer.intValue();
             }
		}*/
		
		
		Map<String, Object> pars = new HashMap<String, Object>();
		pars.put("oldVersion", version.getUserVersion());//如果不通过，旧的版本应该是user表里的版本
		pars.put("updateBy", pojo.getAuditCreateBy());
		pars.put("teacherId", pojo.getTeacherId());
		pars.put("newVersion", (version.getUserVersion()+1));
		//teacherWriteDao.insertBaseInfoByVersion(pars);
		teacherWriteDao.insertJobInfoByVersion(pars);
		
		/*List<EduTeacherEducation> edus = teacherReadDao
				.selectAllInfoByVersionAndTeacherId(pars);
		int newVersion =(versionNew+1);
		for (EduTeacherEducation edu : edus) {
			edu.setVersion(newVersion);
			edu.setId(null);
			edu.setTeacherId(pojo.getTeacherId());
			edu.setEducationUpdateBy(pojo.getAuditCreateBy());
			edu.setEducationUpdateDate(new Date());
			teacherWriteDao.insertTeacherEducation(edu);
		}*/
		// 提升user版本
		teacherWriteDao.updateUserVersionById(pojo.getTeacherId(),
				version.getUserVersion()+2);
		
		// 将之前的信息状态变为无效
		/*teacherWriteDao.updateBaseInfoStatusByVersion(pojo
				.getTeacherId(), newVersion);*/
		teacherWriteDao.updateJobInfoStatusByVersion(pojo
				.getTeacherId(), version.getUserVersion());
		/*teacherWriteDao.updateEduInfoStatusByVersion(pojo
				.getTeacherId(), newVersion)*/;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", Common.COMMON_AUDIT_UNPASS);
		params.put("auditId", pojo.getAuditId());
		params.put("memo", pojo.getAuditOption());
		params.put("auditor", pojo.getAuditCreateBy());
		teacherWriteDao.updateAudit(params);
		return 0;
	}

	/**
	 * 调动管理 审核相关信息
	 * 
	 * @author cl
	 * @create date 2014-4-20
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public EduTeacherMobilize queryMobilizeAuditInfo(Integer id)
			throws Exception {
		return teacherReadDao.selectMobilizeAudit(id);
	}
	
	/**
	 * 新建编制调整--不需要审核
	 * 
	 * @author cl
	 * @create date 2014-4-27
	 * @return
	 * @throws Exception
	 */
	public Integer createAdjustForNoAudit(EduTeacherAdjust pojo)
			throws Exception {
		//数据状态为有效数据
		
		Map<String, Object> teacherData=new HashMap<String, Object>();
		//1、检查是否存在未审核的个人变更记录
		teacherData.put("auditStatus", Common.COMMON_AUDIT_UNHANDL);
		teacherData.put("teacherId",pojo.getTeacherId());
		teacherData.put("changeType1", 1);
		teacherData.put("changeType2", 1);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			throw new Exception("-1");
		}
		
		//2、检查是否存在未审核的个人调动记录
		teacherData.remove("changeType1");
		teacherData.remove("changeType2");
		teacherData.put("changeType1", 2);
		teacherData.put("changeType2", 2);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			throw new Exception("-2");
		}
		
		//3、检查是否存在未审核的个人离退操作记录
		teacherData.remove("changeType1");
		teacherData.remove("changeType2");
		teacherData.put("changeType1", 31);
		teacherData.put("changeType2", 36);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			throw new Exception("-3");
		}
		
		//3、检查是否存在未审核的个人编制调整记录
		teacherData.remove("changeType1");
		teacherData.remove("changeType2");
		teacherData.put("changeType1", 50);
		teacherData.put("changeType2", 50);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			throw new Exception("-03");
		}
		
		// 查询user 表的版本记录
		EduTeacherVersionPOJO version = teacherReadDao
				.selectTeacherAllVersion(pojo.getTeacherId());
		
		/*int versionNew=0;
		Integer[] arrVersion={version.getBaseVersion(),version.getEduVersion(),version.getJobVersion(),version.getUserVersion()};
		
		 for (Integer integer : arrVersion) {
			 //判断最大时 取最大数
             if (integer.intValue() > versionNew)
             {
            	 versionNew = integer.intValue();
             }
		}*/
		 

		/*// 4、需要生成 教师基本信息新版本
		teacherWriteDao.insertUpVersionBaseInfo(pojo.getTeacherId().toString(),
				pojo.getAuditCreateBy(), Common.DATA_VALID, versionNew + 1);

		// 5、教育经历 存在多条情况
		List<EduTeacherEducation> edulist = teacherProjectReadDao
				.selectTeacherEducationByTeacherId(pojo.getTeacherId(), null);
		for (EduTeacherEducation obj : edulist) {
			teacherWriteDao.insertUpVersionEduInfo(obj.getId().toString(), pojo
					.getAuditCreateBy(), Common.DATA_VALID, versionNew + 1);
		}*/

		// 6、需要生成 教师工作经历新版本
		teacherWriteDao.insertUpVersionJobAdjustInfo(pojo,
				Common.DATA_VALID, (version.getUserVersion()+ 1));

		//7、 创建信息变更审核申请
		EduAudit auditHis = new EduAudit();
		auditHis.setTeacherId(pojo.getTeacherId());
		auditHis.setAuditStatus(Common.COMMON_AUDIT_AUTOPASS);
		auditHis.setMobilizeMark(pojo.getMobilizeMark());
		auditHis.setAuditCreateBy(pojo.getAuditCreateBy());
		auditHis.setOldVersion(version.getUserVersion());
		auditHis.setNewVersion(version.getUserVersion() + 1);
		auditHis.setChangeType(Common.CHANGE_TYPE_50);
		
		auditHis.setAuditUpdateBy(pojo.getAuditCreateBy());
		auditHis.setAuditUpdateDate(new Date());
		auditHis.setAuditCreateDate(new Date());
	
		if(teacherWriteDao.insertTeacherAuditInfo(auditHis)==-1){
			throw new Exception("操作失败，新增audit表失败");
		}
		
		
		//8、 提升user版本
		teacherWriteDao.updateUserVersionById(pojo.getTeacherId(),(version.getUserVersion() + 1));
		
		// 将之前的信息状态变为无效
		/*teacherWriteDao.updateBaseInfoStatusByVersion(pojo
				.getTeacherId(), (versionNew + 1));*/
		teacherWriteDao.updateJobInfoStatusByVersion(pojo
				.getTeacherId(), (version.getUserVersion() + 1));
		/*teacherWriteDao.updateEduInfoStatusByVersion(pojo
				.getTeacherId(), (versionNew + 1));*/

		return (version.getUserVersion() + 1);
	}
	
	/**
	 * 新建编制调整--需要审核
	 * 
	 * @author cl
	 * @create date 2014-4-16
	 * @return
	 * @throws Exception
	 */
	public Integer createAdjustForAudit(EduTeacherAdjust pojo)
			throws Exception {
		
		Map<String, Object> teacherData=new HashMap<String, Object>();
		//1、检查是否存在未审核的个人变更记录
		teacherData.put("auditStatus", Common.COMMON_AUDIT_UNHANDL);
		teacherData.put("teacherId",pojo.getTeacherId());
		teacherData.put("changeType1", 1);
		teacherData.put("changeType2", 1);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			throw new Exception("-1");
		}
		
		//2、检查是否存在未审核的个人调动记录
		teacherData.remove("changeType1");
		teacherData.remove("changeType2");
		teacherData.put("changeType1", 2);
		teacherData.put("changeType2", 2);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			throw new Exception("-2");
		}
		
		//3、检查是否存在未审核的个人离退操作记录
		teacherData.remove("changeType1");
		teacherData.remove("changeType2");
		teacherData.put("changeType1", 31);
		teacherData.put("changeType2", 36);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			throw new Exception("-3");
		}
		
		//3、检查是否存在未审核的个人编制调整记录
		teacherData.remove("changeType1");
		teacherData.remove("changeType2");
		teacherData.put("changeType1", 50);
		teacherData.put("changeType2", 50);
		if(teacherReadDao.selectAuditChangeType(teacherData)>0){
			throw new Exception("-03");
		}
		
		// 查询user 表的版本记录
		EduTeacherVersionPOJO version = teacherReadDao
				.selectTeacherAllVersion(pojo.getTeacherId());
		/*
		int versionNew=0;
		Integer[] arrVersion={version.getBaseVersion(),version.getEduVersion(),version.getJobVersion(),version.getUserVersion()};
		
		 for (Integer integer : arrVersion) {
			 //判断最大时 取最大数
             if (integer.intValue() > versionNew)
             {
            	 versionNew = integer.intValue();
             }
		}*/

		/*// 4、需要生成 教师基本信息新版本 数据状态为无效数据
		teacherWriteDao.insertUpVersionBaseInfo(pojo.getTeacherId().toString(),
				pojo.getAuditCreateBy(), Common.DATA_NO_VALID, versionNew + 1);

		// 5、教育经历 存在多条情况 数据状态为无效数据
		List<EduTeacherEducation> edulist = teacherProjectReadDao
				.selectTeacherEducationByTeacherId(pojo.getTeacherId(), null);
		for (EduTeacherEducation obj : edulist) {
			teacherWriteDao.insertUpVersionEduInfo(obj.getId().toString(), pojo
					.getAuditCreateBy(), Common.DATA_NO_VALID, versionNew + 1);
		}
*/
		// 6、需要生成 教师工作经历新版本 数据状态为无效数据
		teacherWriteDao.insertUpVersionJobAdjustInfo(pojo,
				Common.DATA_NO_VALID, (version.getUserVersion()  + 1));
		
		//7、 创建信息变更审核申请
		EduAudit auditHis = new EduAudit();
		auditHis.setTeacherId(pojo.getTeacherId());
		auditHis.setAuditStatus(Common.COMMON_AUDIT_UNHANDL);
		auditHis.setMobilizeMark(pojo.getMobilizeMark());
		auditHis.setAuditCreateBy(pojo.getAuditCreateBy());
		auditHis.setOldVersion(version.getUserVersion());
		auditHis.setNewVersion((version.getUserVersion() + 1));
		auditHis.setChangeType(Common.CHANGE_TYPE_50);
		auditHis.setAuditUpdateBy(pojo.getAuditCreateBy());
		auditHis.setAuditUpdateDate(new Date());
		auditHis.setAuditCreateDate(new Date());

		if(teacherWriteDao.insertTeacherAuditInfo(auditHis)==-1){
			throw new Exception("操作失败，新增audit表失败");
		}

		return (version.getUserVersion() + 1);
	}

	/**
	 * 新建编制调整审核--审核不通过
	 * @return
	 * @throws Exception
	 */
	public Integer modifyAdjustInfoNo(EduTeacherAdjust pojo)throws Exception{
		
		// 查询user 表的版本记录
		EduTeacherVersionPOJO version = teacherReadDao
				.selectTeacherAllVersion(pojo.getTeacherId());
		
		/*int versionNew=0;
		Integer[] arrVersion={version.getBaseVersion(),version.getEduVersion(),version.getJobVersion(),version.getUserVersion()};
		
		 for (Integer integer : arrVersion) {
			 //判断最大时 取最大数
             if (integer.intValue() > versionNew)
             {
            	 versionNew = integer.intValue();
             }
		}*/
		
		
		Map<String, Object> pars = new HashMap<String, Object>();
		pars.put("oldVersion", version.getUserVersion());//如果不通过，旧的版本应该是user表里的版本
		pars.put("updateBy", pojo.getAuditCreateBy());
		pars.put("teacherId", pojo.getTeacherId());
		pars.put("newVersion", version.getUserVersion()+1);
		//teacherWriteDao.insertBaseInfoByVersion(pars);
		teacherWriteDao.insertJobInfoByVersion(pars);
		
		/*List<EduTeacherEducation> edus = teacherReadDao
				.selectAllInfoByVersionAndTeacherId(pars);
		int newVersion =(versionNew+1);
		for (EduTeacherEducation edu : edus) {
			edu.setVersion(newVersion);
			edu.setId(null);
			edu.setTeacherId(pojo.getTeacherId());
			edu.setEducationUpdateBy(pojo.getAuditCreateBy());
			edu.setEducationUpdateDate(new Date());
			teacherWriteDao.insertTeacherEducation(edu);
		}*/
		// 提升user版本
		teacherWriteDao.updateUserVersionById(pojo.getTeacherId(),
				version.getUserVersion()+2);
		
		// 将之前的信息状态变为无效
		/*teacherWriteDao.updateBaseInfoStatusByVersion(pojo
				.getTeacherId(), newVersion);*/
		teacherWriteDao.updateJobInfoStatusByVersion(pojo
				.getTeacherId(), version.getUserVersion());
		/*teacherWriteDao.updateEduInfoStatusByVersion(pojo
				.getTeacherId(), newVersion);*/
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", Common.COMMON_AUDIT_UNPASS);
		params.put("auditId", pojo.getAuditId());
		params.put("memo", pojo.getAuditOption());
		params.put("auditor", pojo.getAuditCreateBy());
		
		if(!teacherWriteDao.updateAudit(params)){
			throw new Exception("操作失败，更新audit表失败");
		}
	
		return 0;
	}

	/**
	 * 新建编制调整审核--审核通过
	 * @return
	 * @throws Exception
	 */
	public Integer modifyAdjustInfo(EduTeacherAdjust pojo)throws Exception {
		// 查询user 表的版本记录
		EduTeacherVersionPOJO version = teacherReadDao
				.selectTeacherAllVersion(pojo.getTeacherId());
		
		/*int versionNew=0;
		Integer[] arrVersion={version.getBaseVersion(),version.getEduVersion(),version.getJobVersion(),version.getUserVersion()};
		
		 for (Integer integer : arrVersion) {
			 //判断最大时 取最大数
             if (integer.intValue() > versionNew)
             {
            	 versionNew = integer.intValue();
             }
		}*/
		
		/*teacherWriteDao.updateTeacherBaseInfoByVersion(versionNew, Common.DATA_VALID, pojo
				.getTeacherId());
		teacherWriteDao.updateTeacherEduInfoByVersion(versionNew
				, Common.DATA_VALID, pojo
				.getTeacherId());*/
		teacherWriteDao.updateTeacherJobInfoByVersion((version.getUserVersion() + 1)
				, Common.DATA_VALID, pojo
				.getTeacherId());
		
		// 提升user版本
		teacherWriteDao.updateUserVersionById(pojo.getTeacherId(),(version.getUserVersion() + 1));
		
		// 将之前的信息状态变为无效
		/*teacherWriteDao.updateBaseInfoStatusByVersion(pojo
				.getTeacherId(), version.getBaseVersion());*/
		teacherWriteDao.updateJobInfoStatusByVersion(pojo
				.getTeacherId(), version.getUserVersion());
		/*teacherWriteDao.updateEduInfoStatusByVersion(pojo
				.getTeacherId(), version.getEduVersion());*/
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", Common.COMMON_AUDIT_PASS);
		params.put("auditId", pojo.getAuditId());
		params.put("memo", pojo.getAuditOption());
		params.put("auditor", pojo.getAuditCreateBy());
		
		if(!teacherWriteDao.updateAudit(params)){
			throw new Exception("操作失败，更新audit表失败");
		}
		
		return 0;
	}

	

}
