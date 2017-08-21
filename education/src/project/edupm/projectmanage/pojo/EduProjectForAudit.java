package project.edupm.projectmanage.pojo;

public class EduProjectForAudit {
	private int id;
	private String projectName;
	private String orgName;
	private String planNum;
	private Integer status;
	
	//项目申报人
	private String applyer;
	//申报时间
	private String applyTime;
	
	
	public String getApplyer() {
		return applyer;
	}
	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getPlanNum() {
		return planNum;
	}
	public void setPlanNum(String planNum) {
		this.planNum = planNum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	private String createBy;


	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	private Integer createByArea;
	/**
	 * 创建项目人所属的区域
	 * @return
	 */
	public Integer getCreateByArea() {
		return createByArea;
	}
	/**
	 * 创建项目人所属的区域
	 * @param createByArea
	 */
	public void setCreateByArea(Integer createByArea) {
		this.createByArea = createByArea;
	}
}
