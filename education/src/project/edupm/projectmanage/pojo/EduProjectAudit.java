package project.edupm.projectmanage.pojo;


public class EduProjectAudit {
	
    private Integer id;
    
    private Integer projectId;
    
    private String projectName;
    
    private Integer shenheNum;
    
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

	private Integer weishenheNum;
    
    
    private Integer planNum;
    
    private String startDate;
    
    private String endDate;

    private Integer pass;
    
    private Integer unPass;
    
    private Integer unAudit;

    private Integer hasStopSign;
    
    private String createBy;
    
    private Integer createByArea;
  
    private Integer organizationId;//实施机构Id

    private String organizationName;
    
	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	private Integer examine;
    
	private String applyer;
	
	private String auditor;
	
    
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

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	private Integer teacherId;
    
    public Integer getAttendNum() {
		return attendNum;
	}

	public void setAttendNum(Integer attendNum) {
		this.attendNum = attendNum;
	}

	public Integer getLearningNum() {
		return learningNum;
	}

	public void setLearningNum(Integer learningNum) {
		this.learningNum = learningNum;
	}

	private Integer attendNum;
    
    private Integer learningNum;
	
	

   	public Integer getExamine() {
   		return examine;
   	}

   	public void setExamine(Integer examine) {
   		this.examine = examine;
   	}
    
    
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	public Integer getCreateByArea() {
		return createByArea;
	}

	public void setCreateByArea(Integer createByArea) {
		this.createByArea = createByArea;
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

	public Integer getPass() {
		return pass;
	}

	public void setPass(Integer pass) {
		this.pass = pass;
	}

	public Integer getUnPass() {
		return unPass;
	}

	public void setUnPass(Integer unPass) {
		this.unPass = unPass;
	}

	public Integer getUnAudit() {
		return unAudit;
	}

	public void setUnAudit(Integer unAudit) {
		this.unAudit = unAudit;
	}

	public Integer getHasStopSign() {
		return hasStopSign;
	}

	public void setHasStopSign(Integer hasStopSign) {
		this.hasStopSign = hasStopSign;
	}
  
}