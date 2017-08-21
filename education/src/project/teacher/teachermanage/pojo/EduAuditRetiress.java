package project.teacher.teachermanage.pojo;

import java.util.Date;

public class EduAuditRetiress {
	private String auditCreateBy;
	private String auditAuditor;
	
	public String getAuditCreateBy() {
		return auditCreateBy;
	}
	public void setAuditCreateBy(String auditCreateBy) {
		this.auditCreateBy = auditCreateBy;
	}
	public String getAuditAuditor() {
		return auditAuditor;
	}
	public void setAuditAuditor(String auditAuditor) {
		this.auditAuditor = auditAuditor;
	}
	private Integer auditId;
	public Integer getAuditId() {
		return auditId;
	}
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}
	private Integer teacherId;
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	private String realName;
	private String idNumber;
	private Integer gender;
	private String newProvinceName;
	private String newCityName;
	private String newDistrictName;
	private String newSchoolId;
	private String newSchoolName;
	public String getNewSchoolName() {
		return newSchoolName;
	}
	public void setNewSchoolName(String newSchoolName) {
		this.newSchoolName = newSchoolName;
	}
	private String jobFormerTeachingSubject;
	private String jobFormerTeachingSection;
	private Date auditCreateDate;
	private Integer auditStatus;
	private Integer changeType;
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getNewProvinceName() {
		return newProvinceName;
	}
	public void setNewProvinceName(String newProvinceName) {
		this.newProvinceName = newProvinceName;
	}
	public String getNewCityName() {
		return newCityName;
	}
	public void setNewCityName(String newCityName) {
		this.newCityName = newCityName;
	}
	public String getNewDistrictName() {
		return newDistrictName;
	}
	public void setNewDistrictName(String newDistrictName) {
		this.newDistrictName = newDistrictName;
	}
	public String getNewSchoolId() {
		return newSchoolId;
	}
	public void setNewSchoolId(String newSchoolId) {
		this.newSchoolId = newSchoolId;
	}
	public String getJobFormerTeachingSubject() {
		return jobFormerTeachingSubject;
	}
	public void setJobFormerTeachingSubject(String jobFormerTeachingSubject) {
		this.jobFormerTeachingSubject = jobFormerTeachingSubject;
	}
	public String getJobFormerTeachingSection() {
		return jobFormerTeachingSection;
	}
	public void setJobFormerTeachingSection(String jobFormerTeachingSection) {
		this.jobFormerTeachingSection = jobFormerTeachingSection;
	}
	public Date getAuditCreateDate() {
		return auditCreateDate;
	}
	public void setAuditCreateDate(Date auditCreateDate) {
		this.auditCreateDate = auditCreateDate;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Integer getChangeType() {
		return changeType;
	}
	public void setChangeType(Integer changeType) {
		this.changeType = changeType;
	}
	
}
