package project.teacher.teachermanage.pojo;

import project.person.pojo.EduUser;

/**
 * 教师综合信息查询
 * @author dengguo
 *
 */
public class TeacherExportActivity extends EduUser{ 
	// 学段
    private Integer teachingSectionType;
	private String teachingSection;
	
	// 学科
	private String teachingSubject;
    
    //    最高学历
	//private String educationExperience;
	//private String educationDegree;
	
    //    (评)教师职称
	private String jobCommentPosition;
	
    //    (聘)教师职称
	private String jobRecruitmentPosition;
	
	//    学校行政职务
	private String jobSchoolAdministrationOffice;
	
	//    当前任教学段/学科
	private String jobFormerTeachingSection;
	private String jobFormerTeachingSubject;
	
	//    是否骨干教师
	private String jobCoreTeacher;
	
	//    是否为班主任
	private String jobWhetherTeacher;
	
	//    国培计划农村骨干教师
	private String jobCountyRuralTeacher;
	
	//	 是否为特级教师
	private String jobSpecialTeacher;
	
	
//  学校代码
	private String schoolCode;
	
	
	
	//private String loginAccount;
	private String idNumber;
	private String realName;
	private String sex;
	private String mail;
	private String mobile;
	private String teacherNo;
	private String schoolName;
	private String userProvinceName;
	private String userDistrictName;
	private String userCityName;
	private String jobCertificateNum;
	

	private String teacherNativePlace;   //籍贯
	
	private String jszgz;   //教师资格证书
	
	private String educationExperience;   //第一学历
	
	private String educationDegree;   //第一学位
	
	private String educationGraduationTime;   //毕业时间(第一学位)
	
	private String educationGraduationSchool;   //毕业院校(第一学位)
	
	private String educationGraduationProfession;   //毕业专业(第一学位)
	
	private String topEducationExperience;   //最高学历
	
	private String topEducationDegree;   //最高学位
	
	private String topEducationGraduationTime;   //毕业时间(最高学位)
	
	private String topEducationGraduationSchool;   //毕业院校(最高学位)
	
	private String topEducationGraduationProfession;   //毕业专业(最高学位)
	
	private String qrzsfzy;   //是否全日制师范专业毕业
	
	private String mfsfs;   //是否属于免费师范生
	
	private String teacherPoliticalStatus;   //政治面貌
	
	private String partyTime;   //入党时间
	
	private String teacherNation;   //民族
	
	private String eliteTraining;   //名校长培养对象
	
	private String teachingMaster;   //教学名师
	
	private String jobSubjectLeaderName;   //学科带头人
	
	private String contract;   //签订合同情况
	
	private String adjustName;   //编制类别
	
	private String rych;   //荣誉称号荣誉称号
	
	private String jxjybh;   //继续教育编号
	
	private String jsnpxqk;   //专任教师接受培训情况
	
	private String cjqsny;   //从教起始时间
	
	private String pthdj;   //普通话等级
	
	private String jobCommentDate;   //(评)职称时间
	
	private String jobRecruitmentDate;   //(聘)职称时间
	
	private String sfzb;   //是否在编
	
	private String gwlb;   //岗位类别
	
	private String gwdj;   //岗位等级岗位等级
	
	private String postGrade;   //聘任岗位等级时间
	
	private String jobWorkTime;   //参加工作时间
	
	private String jobWorkDate;   //本校任教起始时间
	
	private String postBack;   //离岗待退时间
	
	private String jdfldw;   //借调分流单位
	
	private String jdflTime;   //借调分流时间
	
	private String remark;   //备注
	
	private String salary;
	

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getTeacherNativePlace() {
		return teacherNativePlace;
	}

	public void setTeacherNativePlace(String teacherNativePlace) {
		this.teacherNativePlace = teacherNativePlace;
	}

	public String getJszgz() {
		return jszgz;
	}

	public void setJszgz(String jszgz) {
		this.jszgz = jszgz;
	}

	public String getEducationGraduationTime() {
		return educationGraduationTime;
	}

	public void setEducationGraduationTime(String educationGraduationTime) {
		this.educationGraduationTime = educationGraduationTime;
	}

	public String getEducationGraduationSchool() {
		return educationGraduationSchool;
	}

	public void setEducationGraduationSchool(String educationGraduationSchool) {
		this.educationGraduationSchool = educationGraduationSchool;
	}

	public String getEducationGraduationProfession() {
		return educationGraduationProfession;
	}

	public void setEducationGraduationProfession(
			String educationGraduationProfession) {
		this.educationGraduationProfession = educationGraduationProfession;
	}

	public String getTopEducationExperience() {
		return topEducationExperience;
	}

	public void setTopEducationExperience(String topEducationExperience) {
		this.topEducationExperience = topEducationExperience;
	}

	public String getTopEducationDegree() {
		return topEducationDegree;
	}

	public void setTopEducationDegree(String topEducationDegree) {
		this.topEducationDegree = topEducationDegree;
	}

	public String getTopEducationGraduationTime() {
		return topEducationGraduationTime;
	}

	public void setTopEducationGraduationTime(String topEducationGraduationTime) {
		this.topEducationGraduationTime = topEducationGraduationTime;
	}

	public String getTopEducationGraduationSchool() {
		return topEducationGraduationSchool;
	}

	public void setTopEducationGraduationSchool(String topEducationGraduationSchool) {
		this.topEducationGraduationSchool = topEducationGraduationSchool;
	}

	public String getTopEducationGraduationProfession() {
		return topEducationGraduationProfession;
	}

	public void setTopEducationGraduationProfession(
			String topEducationGraduationProfession) {
		this.topEducationGraduationProfession = topEducationGraduationProfession;
	}

	public String getQrzsfzy() {
		return qrzsfzy;
	}

	public void setQrzsfzy(String qrzsfzy) {
		this.qrzsfzy = qrzsfzy;
	}

	public String getMfsfs() {
		return mfsfs;
	}

	public void setMfsfs(String mfsfs) {
		this.mfsfs = mfsfs;
	}

	public String getTeacherPoliticalStatus() {
		return teacherPoliticalStatus;
	}

	public void setTeacherPoliticalStatus(String teacherPoliticalStatus) {
		this.teacherPoliticalStatus = teacherPoliticalStatus;
	}

	public String getPartyTime() {
		return partyTime;
	}

	public void setPartyTime(String partyTime) {
		this.partyTime = partyTime;
	}

	public String getTeacherNation() {
		return teacherNation;
	}

	public void setTeacherNation(String teacherNation) {
		this.teacherNation = teacherNation;
	}

	public String getEliteTraining() {
		return eliteTraining;
	}

	public void setEliteTraining(String eliteTraining) {
		this.eliteTraining = eliteTraining;
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

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getAdjustName() {
		return adjustName;
	}

	public void setAdjustName(String adjustName) {
		this.adjustName = adjustName;
	}

	public String getRych() {
		return rych;
	}

	public void setRych(String rych) {
		this.rych = rych;
	}

	public String getJxjybh() {
		return jxjybh;
	}

	public void setJxjybh(String jxjybh) {
		this.jxjybh = jxjybh;
	}

	public String getJsnpxqk() {
		return jsnpxqk;
	}

	public void setJsnpxqk(String jsnpxqk) {
		this.jsnpxqk = jsnpxqk;
	}

	public String getCjqsny() {
		return cjqsny;
	}

	public void setCjqsny(String cjqsny) {
		this.cjqsny = cjqsny;
	}

	public String getPthdj() {
		return pthdj;
	}

	public void setPthdj(String pthdj) {
		this.pthdj = pthdj;
	}

	public String getJobCommentDate() {
		return jobCommentDate;
	}

	public void setJobCommentDate(String jobCommentDate) {
		this.jobCommentDate = jobCommentDate;
	}

	public String getJobRecruitmentDate() {
		return jobRecruitmentDate;
	}

	public void setJobRecruitmentDate(String jobRecruitmentDate) {
		this.jobRecruitmentDate = jobRecruitmentDate;
	}

	public String getSfzb() {
		return sfzb;
	}

	public void setSfzb(String sfzb) {
		this.sfzb = sfzb;
	}

	public String getGwlb() {
		return gwlb;
	}

	public void setGwlb(String gwlb) {
		this.gwlb = gwlb;
	}

	public String getGwdj() {
		return gwdj;
	}

	public void setGwdj(String gwdj) {
		this.gwdj = gwdj;
	}

	public String getPostGrade() {
		return postGrade;
	}

	public void setPostGrade(String postGrade) {
		this.postGrade = postGrade;
	}

	public String getJobWorkTime() {
		return jobWorkTime;
	}

	public void setJobWorkTime(String jobWorkTime) {
		this.jobWorkTime = jobWorkTime;
	}

	public String getJobWorkDate() {
		return jobWorkDate;
	}

	public void setJobWorkDate(String jobWorkDate) {
		this.jobWorkDate = jobWorkDate;
	}

	public String getPostBack() {
		return postBack;
	}

	public void setPostBack(String postBack) {
		this.postBack = postBack;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEducationDegree() {
		return educationDegree;
	}

	public void setEducationDegree(String educationDegree) {
		this.educationDegree = educationDegree;
	}

	public String getJobCertificateNum() {
		return jobCertificateNum;
	}

	public void setJobCertificateNum(String jobCertificateNum) {
		this.jobCertificateNum = jobCertificateNum;
	}

	public Integer getTeachingSectionType() {
		return teachingSectionType;
	}

	public void setTeachingSectionType(Integer teachingSectionType) {
		this.teachingSectionType = teachingSectionType;
	}

	public String getTeachingSection() {
		return teachingSection;
	}

	public void setTeachingSection(String teachingSection) {
		this.teachingSection = teachingSection;
	}

	public String getEducationExperience() {
		return educationExperience;
	}

	public void setEducationExperience(String educationExperience) {
		this.educationExperience = educationExperience;
	}

	public String getJobCommentPosition() {
		return jobCommentPosition;
	}

	public void setJobCommentPosition(String jobCommentPosition) {
		this.jobCommentPosition = jobCommentPosition;
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

	public String getJobFormerTeachingSection() {
		return jobFormerTeachingSection;
	}

	public void setJobFormerTeachingSection(String jobFormerTeachingSection) {
		this.jobFormerTeachingSection = jobFormerTeachingSection;
	}

	public String getJobFormerTeachingSubject() {
		return jobFormerTeachingSubject;
	}

	public void setJobFormerTeachingSubject(String jobFormerTeachingSubject) {
		this.jobFormerTeachingSubject = jobFormerTeachingSubject;
	}

	public String getJobCoreTeacher() {
		return jobCoreTeacher;
	}

	public void setJobCoreTeacher(String jobCoreTeacher) {
		this.jobCoreTeacher = jobCoreTeacher;
	}


	public String getTeachingSubject() {
		return teachingSubject;
	}

	public void setTeachingSubject(String teachingSubject) {
		this.teachingSubject = teachingSubject;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	/*public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}*/

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getUserProvinceName() {
		return userProvinceName;
	}

	public void setUserProvinceName(String userProvinceName) {
		this.userProvinceName = userProvinceName;
	}

	public String getUserDistrictName() {
		return userDistrictName;
	}

	public void setUserDistrictName(String userDistrictName) {
		this.userDistrictName = userDistrictName;
	}

	public String getUserCityName() {
		return userCityName;
	}

	public void setUserCityName(String userCityName) {
		this.userCityName = userCityName;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJobWhetherTeacher() {
		return jobWhetherTeacher;
	}

	public void setJobWhetherTeacher(String jobWhetherTeacher) {
		this.jobWhetherTeacher = jobWhetherTeacher;
	}

	public String getJobCountyRuralTeacher() {
		return jobCountyRuralTeacher;
	}

	public void setJobCountyRuralTeacher(String jobCountyRuralTeacher) {
		this.jobCountyRuralTeacher = jobCountyRuralTeacher;
	}

	public String getJobSpecialTeacher() {
		return jobSpecialTeacher;
	}

	public void setJobSpecialTeacher(String jobSpecialTeacher) {
		this.jobSpecialTeacher = jobSpecialTeacher;
	}
	
    
}