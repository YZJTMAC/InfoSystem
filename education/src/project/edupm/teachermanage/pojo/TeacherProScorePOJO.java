package project.edupm.teachermanage.pojo;

/**
 * @author 曉
 *
 */
public class TeacherProScorePOJO {

	private Integer projectId;
	
	private String projectName;
	
	private String startDate;
	
	private String endDate;
	
	private String trainTypeName;
	
	private Integer planNum;
	
	private Integer actualNum;
	
	// 查看成绩
	private Integer orgId;
	
	private String orgName;
	
	private Integer applyNum;// 报名人数
	
	private Integer studyNum;// 学习人数
	
	private Integer scoreA;// 90分以上人数
	
	private Integer scoreB;// 80~89人数
	
	private Integer scoreC;// 70~79人数
	
	private Integer scoreD;// 60~69人数
	
	private Integer scoreE;// 60分以下人数

	private String createBy;//创建项目者

	private Integer createByArea;//创建项目者所属地区
	
	private Integer organizationId;//实施机构Id

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

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
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

	public String getTrainTypeName() {
		return trainTypeName;
	}

	public void setTrainTypeName(String trainTypeName) {
		this.trainTypeName = trainTypeName;
	}

	public Integer getPlanNum() {
		return planNum;
	}

	public void setPlanNum(Integer planNum) {
		this.planNum = planNum;
	}

	public Integer getActualNum() {
		return actualNum;
	}

	public void setActualNum(Integer actualNum) {
		this.actualNum = actualNum;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(Integer applyNum) {
		this.applyNum = applyNum;
	}

	public Integer getStudyNum() {
		return studyNum;
	}

	public void setStudyNum(Integer studyNum) {
		this.studyNum = studyNum;
	}

	public Integer getScoreA() {
		return scoreA;
	}

	public void setScoreA(Integer scoreA) {
		this.scoreA = scoreA;
	}

	public Integer getScoreB() {
		return scoreB;
	}

	public void setScoreB(Integer scoreB) {
		this.scoreB = scoreB;
	}

	public Integer getScoreC() {
		return scoreC;
	}

	public void setScoreC(Integer scoreC) {
		this.scoreC = scoreC;
	}

	public Integer getScoreD() {
		return scoreD;
	}

	public void setScoreD(Integer scoreD) {
		this.scoreD = scoreD;
	}

	public Integer getScoreE() {
		return scoreE;
	}

	public void setScoreE(Integer scoreE) {
		this.scoreE = scoreE;
	}
	
}
