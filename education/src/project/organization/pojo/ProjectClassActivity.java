package project.organization.pojo;


public class ProjectClassActivity {

	private Integer classId;
	
	private Integer projectId;
	
	private String projectName;
	
	private Integer year;
	
	private String classSubjectName;
	
	private Integer planNum;
	
	private String className;
	
	private String classType;
	
	private OrganizationProject organizationProject;

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public OrganizationProject getOrganizationProject() {
		return organizationProject;
	}

	public void setOrganizationProject(OrganizationProject organizationProject) {
		this.organizationProject = organizationProject;
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getClassSubjectName() {
		return classSubjectName;
	}

	public void setClassSubjectName(String classSubjectName) {
		this.classSubjectName = classSubjectName;
	}

	public Integer getPlanNum() {
		return planNum;
	}

	public void setPlanNum(Integer planNum) {
		this.planNum = planNum;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}
	
}
