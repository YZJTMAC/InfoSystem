package project.teacher.teachermanage.pojo;

import java.util.Date;

public class EduTeacherJob {
	
	//学段字典code
	private String sectionDictionaryCode;
	
	//五险一金
	private String wxyj;
	//岗位类别
	private Integer gwlb; 
	//岗位等级
	private Integer gwdj;
	//是否在编
	private Integer sfzb;
	//签订合同情况
	private Integer contract;
	//月平均工资
	private String salary;  
	//教师资格证种类
	private Integer jszgz;
	//普通话等级
	private Integer pthdj;
	//从教起始年月
	private String cjqsny;
	//是否是全日制师范类专业毕业
	private Integer qrzsfzy;
	//近三年培训情况
	private String jsnpxqk;
	//是否是免费师范生
	private Integer mfsfs;
	//是否是特岗教师
	private Integer tgjs;
	//继续教育编号
	private String jxjybh;
	//荣誉称号
	private String rych;
	
	//是否名校长培养对象
	private Integer eliteTrainingType;
	private String eliteTraining;
	//是否教学名师
	private Integer teachingMasterType;
	private String teachingMaster;
	//是否学科带头人
	//private Integer jobSubjectLeader;
	private String jobSubjectLeaderName;
	
	//聘任岗位等级时间
	private String postGrade;
	
	
	//借调分流单位
	private String jdfldw;

	//借调分流时间
	private String jdflTime;
	
	//离岗待退时间
	private String postBack;
		
	//备注
	private String remark;
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWxyj() {
		return wxyj;
	}

	public void setWxyj(String wxyj) {
		this.wxyj = wxyj;
	}

	public Integer getContract() {
		return contract;
	}

	public void setContract(Integer contract) {
		this.contract = contract;
	}

	public String getJsnpxqk() {
		return jsnpxqk;
	}

	public void setJsnpxqk(String jsnpxqk) {
		this.jsnpxqk = jsnpxqk;
	}

	public Integer getGwlb() {
		return gwlb;
	}

	public void setGwlb(Integer gwlb) {
		this.gwlb = gwlb;
	}

	public Integer getGwdj() {
		return gwdj;
	}

	public void setGwdj(Integer gwdj) {
		this.gwdj = gwdj;
	}

	public Integer getSfzb() {
		return sfzb;
	}

	public void setSfzb(Integer sfzb) {
		this.sfzb = sfzb;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Integer getJszgz() {
		return jszgz;
	}

	public void setJszgz(Integer jszgz) {
		this.jszgz = jszgz;
	}

	public Integer getPthdj() {
		return pthdj;
	}

	public void setPthdj(Integer pthdj) {
		this.pthdj = pthdj;
	}


	public String getCjqsny() {
		return cjqsny;
	}

	public void setCjqsny(String cjqsny) {
		this.cjqsny = cjqsny;
	}

	public Integer getQrzsfzy() {
		return qrzsfzy;
	}

	public void setQrzsfzy(Integer qrzsfzy) {
		this.qrzsfzy = qrzsfzy;
	}

	public Integer getMfsfs() {
		return mfsfs;
	}

	public void setMfsfs(Integer mfsfs) {
		this.mfsfs = mfsfs;
	}

	public Integer getTgjs() {
		return tgjs;
	}

	public void setTgjs(Integer tgjs) {
		this.tgjs = tgjs;
	}

	public String getJxjybh() {
		return jxjybh;
	}

	public void setJxjybh(String jxjybh) {
		this.jxjybh = jxjybh;
	}

	public String getRych() {
		return rych;
	}

	public void setRych(String rych) {
		this.rych = rych;
	}
	private Integer adjustId;
	private String adjustName;
	private Integer jobSchoolAdministrationOfficeType;
	public Integer getJobSchoolAdministrationOfficeType() {
		return jobSchoolAdministrationOfficeType;
	}

	public void setJobSchoolAdministrationOfficeType(
			Integer jobSchoolAdministrationOfficeType) {
		this.jobSchoolAdministrationOfficeType = jobSchoolAdministrationOfficeType;
	}

	public String getAdjustName() {
		return adjustName;
	}

	public void setAdjustName(String adjustName) {
		this.adjustName = adjustName;
	}
	public Integer getAdjustId() {
		return adjustId;
	}

	public void setAdjustId(Integer adjustId) {
		this.adjustId = adjustId;
	}
	private Integer teacherStaff;
	public Integer getTeacherStaff() {
		return teacherStaff;
	}

	public void setTeacherStaff(Integer teacherStaff) {
		this.teacherStaff = teacherStaff;
	}
	private String jobQualification;
	private Integer jobCommentPositionType;
	private Integer jobRecruitmentPositionType;
	private Integer userProvinceId;
	private Integer userCityId;
	private Integer userDistrictId;
	public Integer getUserProvinceId() {
		return userProvinceId;
	}

	public void setUserProvinceId(Integer userProvinceId) {
		this.userProvinceId = userProvinceId;
	}

	public Integer getUserCityId() {
		return userCityId;
	}

	public void setUserCityId(Integer userCityId) {
		this.userCityId = userCityId;
	}

	public Integer getUserDistrictId() {
		return userDistrictId;
	}

	public void setUserDistrictId(Integer userDistrictId) {
		this.userDistrictId = userDistrictId;
	}
	private Integer status;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	private Integer gender;
	private String jobNull;
	public String getJobNull() {
		return jobNull;
	}

	public void setJobNull(String jobNull) {
		this.jobNull = jobNull;
	}
	private String educationExperience;

	public String getJobQualification() {
		return jobQualification;
	}

	public void setJobQualification(String jobQualification) {
		this.jobQualification = jobQualification;
	}

	public Integer getJobCommentPositionType() {
		return jobCommentPositionType;
	}

	public void setJobCommentPositionType(Integer jobCommentPositionType) {
		this.jobCommentPositionType = jobCommentPositionType;
	}

	public Integer getJobRecruitmentPositionType() {
		return jobRecruitmentPositionType;
	}

	public void setJobRecruitmentPositionType(Integer jobRecruitmentPositionType) {
		this.jobRecruitmentPositionType = jobRecruitmentPositionType;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getEducationExperience() {
		return educationExperience;
	}

	public void setEducationExperience(String educationExperience) {
		this.educationExperience = educationExperience;
	}
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.id
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private Integer id;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.teacher_id
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private Integer teacherId;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_qualification_type
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobQualificationType;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_certificate_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobCertificateDate;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_certificate_num
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobCertificateNum;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_work_time
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobWorkTime;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_work_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobWorkDate;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_comment_position
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobCommentPosition;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_recruitment_position
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobRecruitmentPosition;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_comment_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobCommentDate;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_recruitment_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobRecruitmentDate;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_school_administration_office
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobSchoolAdministrationOffice;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_former_teaching_section
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobFormerTeachingSection;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_former_teaching_section_type
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private Integer jobFormerTeachingSectionType;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_former_teaching_subject
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobFormerTeachingSubject;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_former_teaching_subject_type
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobFormerTeachingSubjectType;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_subject_leader
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private Integer jobSubjectLeader;
	
	//是否骨干教师
	private Integer jobCoreTeacherType;
	private String jobCoreTeacher;
	
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_whether_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private Integer jobWhetherTeacher;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_whether_grade_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private Integer jobWhetherGradeTeacher;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_county_rural_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private Integer jobCountyRuralTeacher;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_private_school_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private Integer jobPrivateSchoolTeacher;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_special_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private Integer jobSpecialTeacher;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_create_by
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobCreateBy;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_update_by
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private String jobUpdateBy;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_create_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private Date jobCreateDate;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.job_update_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private Date jobUpdateDate;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column edu_teacher_job.version
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	private Integer version;

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.id
	 * @return  the value of edu_teacher_job.id
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.id
	 * @param id  the value for edu_teacher_job.id
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.teacher_id
	 * @return  the value of edu_teacher_job.teacher_id
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public Integer getTeacherId() {
		return teacherId;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.teacher_id
	 * @param teacherId  the value for edu_teacher_job.teacher_id
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_qualification_type
	 * @return  the value of edu_teacher_job.job_qualification_type
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobQualificationType() {
		return jobQualificationType;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_qualification_type
	 * @param jobQualificationType  the value for edu_teacher_job.job_qualification_type
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobQualificationType(String jobQualificationType) {
		this.jobQualificationType = jobQualificationType;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_certificate_date
	 * @return  the value of edu_teacher_job.job_certificate_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobCertificateDate() {
		return jobCertificateDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_certificate_date
	 * @param jobCertificateDate  the value for edu_teacher_job.job_certificate_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobCertificateDate(String jobCertificateDate) {
		this.jobCertificateDate = jobCertificateDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_certificate_num
	 * @return  the value of edu_teacher_job.job_certificate_num
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobCertificateNum() {
		return jobCertificateNum;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_certificate_num
	 * @param jobCertificateNum  the value for edu_teacher_job.job_certificate_num
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobCertificateNum(String jobCertificateNum) {
		this.jobCertificateNum = jobCertificateNum;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_work_time
	 * @return  the value of edu_teacher_job.job_work_time
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobWorkTime() {
		return jobWorkTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_work_time
	 * @param jobWorkTime  the value for edu_teacher_job.job_work_time
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobWorkTime(String jobWorkTime) {
		this.jobWorkTime = jobWorkTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_work_date
	 * @return  the value of edu_teacher_job.job_work_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobWorkDate() {
		return jobWorkDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_work_date
	 * @param jobWorkDate  the value for edu_teacher_job.job_work_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobWorkDate(String jobWorkDate) {
		this.jobWorkDate = jobWorkDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_comment_position
	 * @return  the value of edu_teacher_job.job_comment_position
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobCommentPosition() {
		return jobCommentPosition;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_comment_position
	 * @param jobCommentPosition  the value for edu_teacher_job.job_comment_position
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobCommentPosition(String jobCommentPosition) {
		this.jobCommentPosition = jobCommentPosition;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_recruitment_position
	 * @return  the value of edu_teacher_job.job_recruitment_position
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobRecruitmentPosition() {
		return jobRecruitmentPosition;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_recruitment_position
	 * @param jobRecruitmentPosition  the value for edu_teacher_job.job_recruitment_position
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobRecruitmentPosition(String jobRecruitmentPosition) {
		this.jobRecruitmentPosition = jobRecruitmentPosition;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_comment_date
	 * @return  the value of edu_teacher_job.job_comment_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobCommentDate() {
		return jobCommentDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_comment_date
	 * @param jobCommentDate  the value for edu_teacher_job.job_comment_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobCommentDate(String jobCommentDate) {
		this.jobCommentDate = jobCommentDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_recruitment_date
	 * @return  the value of edu_teacher_job.job_recruitment_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobRecruitmentDate() {
		return jobRecruitmentDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_recruitment_date
	 * @param jobRecruitmentDate  the value for edu_teacher_job.job_recruitment_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobRecruitmentDate(String jobRecruitmentDate) {
		this.jobRecruitmentDate = jobRecruitmentDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_school_administration_office
	 * @return  the value of edu_teacher_job.job_school_administration_office
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobSchoolAdministrationOffice() {
		return jobSchoolAdministrationOffice;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_school_administration_office
	 * @param jobSchoolAdministrationOffice  the value for edu_teacher_job.job_school_administration_office
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobSchoolAdministrationOffice(
			String jobSchoolAdministrationOffice) {
		this.jobSchoolAdministrationOffice = jobSchoolAdministrationOffice;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_former_teaching_section
	 * @return  the value of edu_teacher_job.job_former_teaching_section
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobFormerTeachingSection() {
		return jobFormerTeachingSection;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_former_teaching_section
	 * @param jobFormerTeachingSection  the value for edu_teacher_job.job_former_teaching_section
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobFormerTeachingSection(String jobFormerTeachingSection) {
		this.jobFormerTeachingSection = jobFormerTeachingSection;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_former_teaching_section_type
	 * @return  the value of edu_teacher_job.job_former_teaching_section_type
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public Integer getJobFormerTeachingSectionType() {
		return jobFormerTeachingSectionType;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_former_teaching_section_type
	 * @param jobFormerTeachingSectionType  the value for edu_teacher_job.job_former_teaching_section_type
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobFormerTeachingSectionType(
			Integer jobFormerTeachingSectionType) {
		this.jobFormerTeachingSectionType = jobFormerTeachingSectionType;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_former_teaching_subject
	 * @return  the value of edu_teacher_job.job_former_teaching_subject
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobFormerTeachingSubject() {
		return jobFormerTeachingSubject;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_former_teaching_subject
	 * @param jobFormerTeachingSubject  the value for edu_teacher_job.job_former_teaching_subject
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobFormerTeachingSubject(String jobFormerTeachingSubject) {
		this.jobFormerTeachingSubject = jobFormerTeachingSubject;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_former_teaching_subject_type
	 * @return  the value of edu_teacher_job.job_former_teaching_subject_type
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobFormerTeachingSubjectType() {
		return jobFormerTeachingSubjectType;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_former_teaching_subject_type
	 * @param jobFormerTeachingSubjectType  the value for edu_teacher_job.job_former_teaching_subject_type
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobFormerTeachingSubjectType(
			String jobFormerTeachingSubjectType) {
		this.jobFormerTeachingSubjectType = jobFormerTeachingSubjectType;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_subject_leader
	 * @return  the value of edu_teacher_job.job_subject_leader
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public Integer getJobSubjectLeader() {
		return jobSubjectLeader;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_subject_leader
	 * @param jobSubjectLeader  the value for edu_teacher_job.job_subject_leader
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobSubjectLeader(Integer jobSubjectLeader) {
		this.jobSubjectLeader = jobSubjectLeader;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_core_teacher
	 * @return  the value of edu_teacher_job.job_core_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_whether_teacher
	 * @return  the value of edu_teacher_job.job_whether_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public Integer getJobWhetherTeacher() {
		return jobWhetherTeacher;
	}

	public Integer getJobCoreTeacherType() {
		return jobCoreTeacherType;
	}

	public void setJobCoreTeacherType(Integer jobCoreTeacherType) {
		this.jobCoreTeacherType = jobCoreTeacherType;
	}

	public String getJobCoreTeacher() {
		return jobCoreTeacher;
	}

	public void setJobCoreTeacher(String jobCoreTeacher) {
		this.jobCoreTeacher = jobCoreTeacher;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_whether_teacher
	 * @param jobWhetherTeacher  the value for edu_teacher_job.job_whether_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobWhetherTeacher(Integer jobWhetherTeacher) {
		this.jobWhetherTeacher = jobWhetherTeacher;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_whether_grade_teacher
	 * @return  the value of edu_teacher_job.job_whether_grade_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public Integer getJobWhetherGradeTeacher() {
		return jobWhetherGradeTeacher;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_whether_grade_teacher
	 * @param jobWhetherGradeTeacher  the value for edu_teacher_job.job_whether_grade_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobWhetherGradeTeacher(Integer jobWhetherGradeTeacher) {
		this.jobWhetherGradeTeacher = jobWhetherGradeTeacher;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_county_rural_teacher
	 * @return  the value of edu_teacher_job.job_county_rural_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public Integer getJobCountyRuralTeacher() {
		return jobCountyRuralTeacher;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_county_rural_teacher
	 * @param jobCountyRuralTeacher  the value for edu_teacher_job.job_county_rural_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobCountyRuralTeacher(Integer jobCountyRuralTeacher) {
		this.jobCountyRuralTeacher = jobCountyRuralTeacher;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_private_school_teacher
	 * @return  the value of edu_teacher_job.job_private_school_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public Integer getJobPrivateSchoolTeacher() {
		return jobPrivateSchoolTeacher;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_private_school_teacher
	 * @param jobPrivateSchoolTeacher  the value for edu_teacher_job.job_private_school_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobPrivateSchoolTeacher(Integer jobPrivateSchoolTeacher) {
		this.jobPrivateSchoolTeacher = jobPrivateSchoolTeacher;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_special_teacher
	 * @return  the value of edu_teacher_job.job_special_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public Integer getJobSpecialTeacher() {
		return jobSpecialTeacher;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_special_teacher
	 * @param jobSpecialTeacher  the value for edu_teacher_job.job_special_teacher
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobSpecialTeacher(Integer jobSpecialTeacher) {
		this.jobSpecialTeacher = jobSpecialTeacher;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_create_by
	 * @return  the value of edu_teacher_job.job_create_by
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobCreateBy() {
		return jobCreateBy;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_create_by
	 * @param jobCreateBy  the value for edu_teacher_job.job_create_by
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobCreateBy(String jobCreateBy) {
		this.jobCreateBy = jobCreateBy;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_update_by
	 * @return  the value of edu_teacher_job.job_update_by
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public String getJobUpdateBy() {
		return jobUpdateBy;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_update_by
	 * @param jobUpdateBy  the value for edu_teacher_job.job_update_by
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobUpdateBy(String jobUpdateBy) {
		this.jobUpdateBy = jobUpdateBy;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_create_date
	 * @return  the value of edu_teacher_job.job_create_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public Date getJobCreateDate() {
		return jobCreateDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_create_date
	 * @param jobCreateDate  the value for edu_teacher_job.job_create_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobCreateDate(Date jobCreateDate) {
		this.jobCreateDate = jobCreateDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.job_update_date
	 * @return  the value of edu_teacher_job.job_update_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public Date getJobUpdateDate() {
		return jobUpdateDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.job_update_date
	 * @param jobUpdateDate  the value for edu_teacher_job.job_update_date
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setJobUpdateDate(Date jobUpdateDate) {
		this.jobUpdateDate = jobUpdateDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column edu_teacher_job.version
	 * @return  the value of edu_teacher_job.version
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column edu_teacher_job.version
	 * @param version  the value for edu_teacher_job.version
	 * @abatorgenerated  Thu Mar 27 21:28:59 CST 2014
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}


	public Integer getEliteTrainingType() {
		return eliteTrainingType;
	}

	public void setEliteTrainingType(Integer eliteTrainingType) {
		this.eliteTrainingType = eliteTrainingType;
	}

	public String getEliteTraining() {
		return eliteTraining;
	}

	public void setEliteTraining(String eliteTraining) {
		this.eliteTraining = eliteTraining;
	}

	public Integer getTeachingMasterType() {
		return teachingMasterType;
	}

	public void setTeachingMasterType(Integer teachingMasterType) {
		this.teachingMasterType = teachingMasterType;
	}

	public String getTeachingMaster() {
		return teachingMaster;
	}

	public void setTeachingMaster(String teachingMaster) {
		this.teachingMaster = teachingMaster;
	}

	public String getJobSubjectLeaderName() {
		return jobSubjectLeaderName;
	}

	public void setJobSubjectLeaderName(String jobSubjectLeaderName) {
		this.jobSubjectLeaderName = jobSubjectLeaderName;
	}

	public String getPostGrade() {
		return postGrade;
	}

	public void setPostGrade(String postGrade) {
		this.postGrade = postGrade;
	}


	public String getJdfldw() {
		return jdfldw;
	}

	public void setJdfldw(String jdfldw) {
		this.jdfldw = jdfldw;
	}

	public String getJdflTime() {
		return jdflTime;
	}

	public void setJdflTime(String jdflTime) {
		this.jdflTime = jdflTime;
	}

	public String getPostBack() {
		return postBack;
	}

	public void setPostBack(String postBack) {
		this.postBack = postBack;
	}

	public String getSectionDictionaryCode() {
		return sectionDictionaryCode;
	}

	public void setSectionDictionaryCode(String sectionDictionaryCode) {
		this.sectionDictionaryCode = sectionDictionaryCode;
	}
	
	
}