package project.edupm.projectmanage.pojo;


public class EduTeacherAudit {
	
    private Integer id;
    
    private Integer projectId;
    
    private String projectName;
    
    private Integer shenheNum;
    
	private Integer weishenheNum;
    
    private Integer planNum;
    
    private String startDate;
    
    private String endDate;

    private String createBy;
    
    private Integer organizationId;//实施机构Id

    private String organizationName;
    
    private Integer attendNum;
    
	private String applyer;
	
	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
	public Integer getShenheNum() {
		return shenheNum;
	}

	public void setShenheNum(Integer shenheNum) {
		this.shenheNum = shenheNum;
	}

	public Integer getWeishenheNum() {
		return weishenheNum;
	}

	public void setWeishenheNum(Integer weishenheNum) {
		this.weishenheNum = weishenheNum;
	}
    
    public String getApplyer() {
		return applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}

    public Integer getAttendNum() {
		return attendNum;
	}

	public void setAttendNum(Integer attendNum) {
		this.attendNum = attendNum;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getPlanNum() {
		return planNum;
	}

	public void setPlanNum(Integer planNum) {
		this.planNum = planNum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
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
}