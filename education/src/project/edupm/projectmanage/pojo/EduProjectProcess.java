package project.edupm.projectmanage.pojo;

import java.util.Date;

public class EduProjectProcess {
	private Integer id;
	private Integer projectId;
	private String projectName;
	private String title;
	private String content;
	private String attchementUrl;
	private String attchementTitle;
	private Date createDate;
	private Integer creator;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getAttchementUrl() {
		return attchementUrl;
	}

	public void setAttchementUrl(String attchementUrl) {
		this.attchementUrl = attchementUrl;
	}

	public String getAttchementTitle() {
		return attchementTitle;
	}

	public void setAttchementTitle(String attchementTitle) {
		this.attchementTitle = attchementTitle;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

}