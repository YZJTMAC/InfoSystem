package project.furtheredu.edumanage.pojo;

/**
 * 教师证书导出信息
 *
 */
public class TeacherCertificateExportActivity {
	 private String modelName; //继教版块名称 
	
	 private String projectName; //项目名称 
	 
	 private String userProvinceName;
	 
	 private String userCityName;
	 
	 private String userDistrictName;
	 
	 private Integer teacherClassPeriod ;  //所获学时
	 
	 private Integer teacherClassScore;  //所获学分
	 
	 private String organizationName;   //院校机构
	 
	 private String jobFormerTeachingSection;  //任教学段
	 
	 private String jobFormerTeachingSubject;  //任教学科
	 
	 private String trainStatus;  //教师培训状态
	 
	 private String periodCertificateCode; //学时证书编号
	 
	 private String auditStatus;  //学分审核状态
	 
	 private String projectCertificateCode; //项目证书编号
	 
	 private String realName;	//姓名 
	 
	 private String idNumber;  //身份证号
	 
	 private String gender;  //性别
	 
	 private String school;	//学校 
	 
	 private String jobRecruitmentPosition;    //(聘)教师职称
	 
	 private String jobSchoolAdministrationOffice;   //学校行政职务
	 
	 private String mobile;	//手机 
	 
	 private String email; 	//邮箱

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getJobFormerTeachingSubject() {
		return jobFormerTeachingSubject;
	}

	public void setJobFormerTeachingSubject(String jobFormerTeachingSubject) {
		this.jobFormerTeachingSubject = jobFormerTeachingSubject;
	}

	public String getPeriodCertificateCode() {
		return periodCertificateCode;
	}

	public void setPeriodCertificateCode(String periodCertificateCode) {
		this.periodCertificateCode = periodCertificateCode;
	}

	public String getProjectCertificateCode() {
		return projectCertificateCode;
	}

	public void setProjectCertificateCode(String projectCertificateCode) {
		this.projectCertificateCode = projectCertificateCode;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getJobRecruitmentPosition() {
		return jobRecruitmentPosition;
	}

	public void setJobRecruitmentPosition(String jobRecruitmentPosition) {
		this.jobRecruitmentPosition = jobRecruitmentPosition;
	}

	public String getJobSchoolAdministrationOffice() {
		return jobSchoolAdministrationOffice;
	}

	public void setJobSchoolAdministrationOffice(
			String jobSchoolAdministrationOffice) {
		this.jobSchoolAdministrationOffice = jobSchoolAdministrationOffice;
	}

	public String getTrainStatus() {
		return trainStatus;
	}

	public void setTrainStatus(String trainStatus) {
		this.trainStatus = trainStatus;
	}

	public String getUserProvinceName() {
		return userProvinceName;
	}

	public void setUserProvinceName(String userProvinceName) {
		this.userProvinceName = userProvinceName;
	}

	public String getUserCityName() {
		return userCityName;
	}

	public void setUserCityName(String userCityName) {
		this.userCityName = userCityName;
	}

	public String getUserDistrictName() {
		return userDistrictName;
	}

	public void setUserDistrictName(String userDistrictName) {
		this.userDistrictName = userDistrictName;
	}

	public Integer getTeacherClassPeriod() {
		return teacherClassPeriod;
	}

	public void setTeacherClassPeriod(Integer teacherClassPeriod) {
		this.teacherClassPeriod = teacherClassPeriod;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getModelName() {
		return modelName;
	}

	public String getProjectName() {
		return projectName;
	}

	public Integer getTeacherClassScore() {
		return teacherClassScore;
	}

	public String getJobFormerTeachingSection() {
		return jobFormerTeachingSection;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setTeacherClassScore(Integer teacherClassScore) {
		this.teacherClassScore = teacherClassScore;
	}

	public void setJobFormerTeachingSection(String jobFormerTeachingSection) {
		this.jobFormerTeachingSection = jobFormerTeachingSection;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
}
