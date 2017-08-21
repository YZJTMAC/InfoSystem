package project.edupm.projectmanage.pojo;

import java.util.Map;

import project.organization.pojo.OrganizationProject;

public class EduProjectOrg extends OrganizationProject{
	private String projectName;
	private String startDate;
	private String endDate;
	private Integer status;
	
	private Integer pid;
	private Integer cid;
	private Integer did;
	private String year;
	
	private Map<String,Object> extendInfo;
	
	
	

	public Map<String, Object> getExtendInfo() {
		return extendInfo;
	}

	public void setExtendInfo(Map<String, Object> extendInfo) {
		this.extendInfo = extendInfo;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
