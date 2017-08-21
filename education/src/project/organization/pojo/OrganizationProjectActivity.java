package project.organization.pojo;

import java.util.List;

import project.edupm.projectmanage.pojo.EduProject;

public class OrganizationProjectActivity extends EduProject {

	// 机构项目列表
	private Integer organizationId;
	private Integer projectId;//项目Id
	
	private Integer projectStatus;// 机构下的项目状态
	
	private String trainingHomeAddress;// 培训平台首页地址
	
	private String orgName;
	
	// 机构项目详情
	private String gradeName;
	
	private String sex;
	
	private String educationBackgroundName;
	
	private String positionName;
	
	private String professionalTitleName;
	
	private String mustAudit;
	
	 private String isClassCharger;
	 
	 private String subjectName;
	 
	 private String stdutySection;
	 
	 private String isFree;
	 
	 private String trainingAddress;
	 
	 private String updateDate;
	 
	 private Integer organiztionType;
	 
	 
	 public Integer getOrganiztionType() {
		return organiztionType;
	}

	public void setOrganiztionType(Integer organiztionType) {
		this.organiztionType = organiztionType;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getTrainingHomeAddress() {
		return trainingHomeAddress;
	}

	public void setTrainingHomeAddress(String trainingHomeAddress) {
		this.trainingHomeAddress = trainingHomeAddress;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getIsClassCharger() {
		return isClassCharger;
	}

	public void setIsClassCharger(String isClassCharger) {
		this.isClassCharger = isClassCharger;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getStdutySection() {
		return stdutySection;
	}

	public void setStdutySection(String stdutySection) {
		this.stdutySection = stdutySection;
	}

	public String getIsFree() {
		return isFree;
	}

	public void setIsFree(String isFree) {
		this.isFree = isFree;
	}

	public String getChargingStandard() {
		return chargingStandard;
	}

	public void setChargingStandard(String chargingStandard) {
		this.chargingStandard = chargingStandard;
	}

	private String chargingStandard;
	
	// 项目分配给的机构
	private List<String> orgList;
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEducationBackgroundName() {
		return educationBackgroundName;
	}

	public void setEducationBackgroundName(String educationBackgroundName) {
		this.educationBackgroundName = educationBackgroundName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getProfessionalTitleName() {
		return professionalTitleName;
	}

	public void setProfessionalTitleName(String professionalTitleName) {
		this.professionalTitleName = professionalTitleName;
	}

	public String getMustAudit() {
		return mustAudit;
	}

	public void setMustAudit(String mustAudit) {
		this.mustAudit = mustAudit;
	}

	public List<String> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<String> orgList) {
		this.orgList = orgList;
	}

	public String getTrainingAddress() {
		return trainingAddress;
	}

	public void setTrainingAddress(String trainingAddress) {
		this.trainingAddress = trainingAddress;
	}
	
}
