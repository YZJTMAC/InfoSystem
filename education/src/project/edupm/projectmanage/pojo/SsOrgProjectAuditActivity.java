package project.edupm.projectmanage.pojo;


public class SsOrgProjectAuditActivity {

	private Integer projectId;
	
	private String projectName;
	
	private Integer projectScopeId;
	
	private Integer trainScopeId;

	private String trainScopeName;
	
	private Integer planNum;
	
	private String organizationId;
	
	private String organizationName;
	
	private String projectPropertyName;
	
	private String trainTypeName;
	
	private String createBy;
	
	private String createDate;
	
	private String auditorRealName;
	
	private String auditStatus;

	public Integer getTrainScopeId() {
		return trainScopeId;
	}

	public void setTrainScoopeId(Integer trainScopeId) {
		this.trainScopeId = trainScopeId;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getProjectScopeId() {
		return projectScopeId;
	}

	public void setProjectScopeId(Integer projectScopeId) {
		this.projectScopeId = projectScopeId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTrainScopeName() {
		return trainScopeName;
	}

	public void setTrainScopeName(String trainScopeName) {
		this.trainScopeName = trainScopeName;
	}

	public Integer getPlanNum() {
		return planNum;
	}

	public void setPlanNum(Integer planNum) {
		this.planNum = planNum;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getProjectPropertyName() {
		return projectPropertyName;
	}

	public void setProjectPropertyName(String projectPropertyName) {
		this.projectPropertyName = projectPropertyName;
	}

	public String getTrainTypeName() {
		return trainTypeName;
	}

	public void setTrainTypeName(String trainTypeName) {
		this.trainTypeName = trainTypeName;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate.substring(0, createDate.length()-1);
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getAuditorRealName() {
		return auditorRealName;
	}

	public void setAuditorRealName(String auditorRealName) {
		this.auditorRealName = auditorRealName;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	
}
