package project.review.dto;
/**
 * 教师DTO
 * @author TMACJ
 *
 */
public class TeacherDto {
	
	private String activityName;	//活动名称
	
	private String category;	//类别（评优，名师，骨干）
	
	private String year;	//年度
	
	private String name;	//教师姓名
	
	private String IDCardNo;	//身份证号码
	
	private String reviewStatus;	//评审状态

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIDCardNo() {
		return IDCardNo;
	}

	public void setIDCardNo(String iDCardNo) {
		IDCardNo = iDCardNo;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	
}
