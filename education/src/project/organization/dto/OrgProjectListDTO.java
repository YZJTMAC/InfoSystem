package project.organization.dto;


public class OrgProjectListDTO {

	private Integer id;//项目id
	
	private Integer projectId;
	
	private String projectNo;
	
	private Integer organizationId;//机构id
	
	private String orgName;
	
	private String projectName;
	
	private String startDate;
	
	private String endDate;
	
	private Integer year;
	
	private Integer trainTypeId;

	private String trainTypeName;
	
	private String projectPropertyName;
	
	private Integer planNum;
	
	private Integer status; //项目状态
	
	private Integer projectStatus;//机构下的项目状态
	
	private String trainingAddress;
	
	private String updateDate;
	
	private String trainingHomeAddress;
	
	 private String createBy;
	 private String applyer;
	 private String auditor;

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getApplyer() {
		return applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getTrainTypeId() {
		return trainTypeId;
	}

	public void setTrainTypeId(Integer trainTypeId) {
		this.trainTypeId = trainTypeId;
	}
	
	public String getTrainTypeName() {
		return trainTypeName;
	}

	public void setTrainTypeName(String trainTypeName) {
		this.trainTypeName = trainTypeName;
	}

	public String getProjectPropertyName() {
		return projectPropertyName;
	}

	public void setProjectPropertyName(String projectPropertyName) {
		this.projectPropertyName = projectPropertyName;
	}

	public Integer getPlanNum() {
		return planNum;
	}

	public void setPlanNum(Integer planNum) {
		this.planNum = planNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getTrainingAddress() {
		return trainingAddress;
	}

	public void setTrainingAddress(String trainingAddress) {
		this.trainingAddress = trainingAddress;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getTrainingHomeAddress() {
		return trainingHomeAddress;
	}

	public void setTrainingHomeAddress(String trainingHomeAddress) {
		this.trainingHomeAddress = trainingHomeAddress;
	}

}
