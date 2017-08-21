package project.review.dto;
/**
 * @description 评选活动DTO
 * @author TMACJ
 *
 */
public class ComparisonActivityDto {

	private String name;	//活动名	
	
	private String category;	//分类（评优，名师，骨干）
	
	private String year;	//当前年度
	
	private String activityCreateTime;	//活动创建日期
	
	private String activityEndTime;	//活动截止日期
	
	private String signupStartTime;	//报名开始日期
	
	private String signupEndTime;	//报名截止日期
	
	private String reviewEndTime; 	//评审截止日期
	
	private String resultPublishTime; //评审结果发布时间
	
	private String reviewScope;	//评审范围（省/市/区）
	
	private Integer enrollment;	//规定报名人数（要做非空和非0验证）
	
	private String text;	//备注文本
	
	private String filePath;	//文件路径(图片，文件等)
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getActivityCreateTime() {
		return activityCreateTime;
	}

	public void setActivityCreateTime(String activityCreateTime) {
		this.activityCreateTime = activityCreateTime;
	}

	public String getActivityEndTime() {
		return activityEndTime;
	}

	public void setActivityEndTime(String activityEndTime) {
		this.activityEndTime = activityEndTime;
	}

	public String getSignupStartTime() {
		return signupStartTime;
	}

	public void setSignupStartTime(String signupStartTime) {
		this.signupStartTime = signupStartTime;
	}

	public String getSignupEndTime() {
		return signupEndTime;
	}

	public void setSignupEndTime(String signupEndTime) {
		this.signupEndTime = signupEndTime;
	}

	public String getReviewEndTime() {
		return reviewEndTime;
	}

	public void setReviewEndTime(String reviewEndTime) {
		this.reviewEndTime = reviewEndTime;
	}

	public String getResultPublishTime() {
		return resultPublishTime;
	}

	public void setResultPublishTime(String resultPublishTime) {
		this.resultPublishTime = resultPublishTime;
	}

	public String getReviewScope() {
		return reviewScope;
	}

	public void setReviewScope(String reviewScope) {
		this.reviewScope = reviewScope;
	}

	public Integer getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Integer enrollment) {
		this.enrollment = enrollment;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
