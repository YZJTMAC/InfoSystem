package project.furtheredu.certificate.pojo;

import java.util.Date;


public class EduDiploma {
	
	// 项目证书 项目id
	
	private Integer projectId;

	private String type;// 证书类型1:年度证书, 2:项目证书, 3:学时证书

	private Integer id;

	private String title;

	private Integer year;

	private Integer status;

	private String head;

	private String content;

	private String foot;

	private Integer positionRight;

	private Integer positionTop;

	private Integer positionWidth;

	private Integer positionHeight;

	private String seal;

	private String createBy;

	private String updateBy;

	private Date createDate;

	private Date updateDate;
	
	private Integer backgroundImg;
	
	//设置二维码背景
	private Integer qrbackgroundImg;

	private Float needCredit;//所需总学分
	private Float needPeriod;//所需总学时
	private String needCredit1;//所需远程学分
	private String needPeriod1;//所需远程学分
	private Float needCredit2;//所需集中学分
	private Float needPeriod2;//所需集中学分
	private Float needCredit3;//所需校本学分
	private Float needPeriod3;//所需校本学分
	private String startDate;
	private String endDate;
	private String changeRate;//学时学分转换比例
	private float repayRate;//偿还学分比例
	
	

	public Integer getQrbackgroundImg() {
		return qrbackgroundImg;
	}

	public void setQrbackgroundImg(Integer qrbackgroundImg) {
		this.qrbackgroundImg = qrbackgroundImg;
	}

	private String signetUrl;
	
	//设置二维码图片位置
	private Integer qrcodeRight;

	private Integer qrcodeTop;

	private Integer qrcodeWidth;

	private Integer qrcodeHeight;
	
	private String qrcode;
	
	//学时证书和项目证书二维码验证背景标题
	private String periodCertificateTitle;
	
	//学时、项目证书编码规则   start------
	private String projectPrefix;
	
	private String isProjectPrefix;
    
    private String isAreaCode;
    private String areaCode;
    
    private String isYearCode;
    private String yearCode;
    
    private String isProjectScopeCode;
    private String projectScopeCode;
    
    private String isProjectTrainTypeCode;
    private String projectTrainTypeCode;
    
    private String isOrgCode;
    private String orgCode;
    
    private String projectCode;
    
    private String oldProjectCode;
    
  //学时、项目证书编码规则   end------
    
    public String getOldProjectCode() {
		return oldProjectCode;
	}

	public void setOldProjectCode(String oldProjectCode) {
		this.oldProjectCode = oldProjectCode;
	}

	//生成证书图片的冗余字段
    //学时编码
  	private String periodCertificateCode;
  	//证书编码
  	private String projectCertificateCode;
  	//学分
  	private String teacherClassScore;
  	//学时
  	private String teacherClassPeriod;
  	
  	//证书编号位置及大小设置
  	private Integer certificateCodeRight;

	private Integer certificateCodeTop;
  	
	private Integer certificateCodeFontType;
	
	private String certificateCodeFontStyle;
	
	private Integer certificateCodeFontSize;
	
	//学员姓名信息设置
	private Integer teacherRight;

	private Integer teacherTop;
  	
	private Integer teacherFontType;
	
	private String teacherFontStyle;
	
	private Integer teacherFontSize;
  	
	//学时证书保存路径
	private String periodCertificateUrl;
	//项目证书保存路径
	private String projectCertificateUrl;
	
	private String qrcodeUrl;
	
	private String backgroundImgUrl;

	public String getBackgroundImgUrl() {
		return backgroundImgUrl;
	}

	public void setBackgroundImgUrl(String backgroundImgUrl) {
		this.backgroundImgUrl = backgroundImgUrl;
	}

	public String getPeriodCertificateUrl() {
		return periodCertificateUrl;
	}

	public void setPeriodCertificateUrl(String periodCertificateUrl) {
		this.periodCertificateUrl = periodCertificateUrl;
	}

	public String getProjectCertificateUrl() {
		return projectCertificateUrl;
	}

	public void setProjectCertificateUrl(String projectCertificateUrl) {
		this.projectCertificateUrl = projectCertificateUrl;
	}

	public String getQrcodeUrl() {
		return qrcodeUrl;
	}

	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}

	public String getPeriodCertificateCode() {
		return periodCertificateCode;
	}

	public void setPeriodCertificateCode(String periodCertificateCode) {
		this.periodCertificateCode = periodCertificateCode;
	}

	public String getProjectCertificateCode() {
		return projectCertificateCode;
	}

	public void setProjectCertificateCode(String projectCertificateCode) {
		this.projectCertificateCode = projectCertificateCode;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getIsProjectPrefix() {
		return isProjectPrefix;
	}

	public void setIsProjectPrefix(String isProjectPrefix) {
		this.isProjectPrefix = isProjectPrefix;
	}

	public String getIsAreaCode() {
		return isAreaCode;
	}

	public void setIsAreaCode(String isAreaCode) {
		this.isAreaCode = isAreaCode;
	}

	public String getIsYearCode() {
		return isYearCode;
	}

	public void setIsYearCode(String isYearCode) {
		this.isYearCode = isYearCode;
	}

	public String getProjectPrefix() {
		return projectPrefix;
	}

	public void setProjectPrefix(String projectPrefix) {
		this.projectPrefix = projectPrefix;
	}

	public String getPeriodCertificateTitle() {
		return periodCertificateTitle;
	}

	public void setPeriodCertificateTitle(String periodCertificateTitle) {
		this.periodCertificateTitle = periodCertificateTitle;
	}

	public Integer getQrcodeRight() {
		return qrcodeRight;
	}

	public void setQrcodeRight(Integer qrcodeRight) {
		this.qrcodeRight = qrcodeRight;
	}

	public Integer getQrcodeTop() {
		return qrcodeTop;
	}

	public void setQrcodeTop(Integer qrcodeTop) {
		this.qrcodeTop = qrcodeTop;
	}

	public Integer getQrcodeWidth() {
		return qrcodeWidth;
	}

	public void setQrcodeWidth(Integer qrcodeWidth) {
		this.qrcodeWidth = qrcodeWidth;
	}

	public Integer getQrcodeHeight() {
		return qrcodeHeight;
	}

	public void setQrcodeHeight(Integer qrcodeHeight) {
		this.qrcodeHeight = qrcodeHeight;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public Integer getBackgroundImg() {
		return backgroundImg;
	}

	public void setBackgroundImg(Integer backgroundImg) {
		this.backgroundImg = backgroundImg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSignetUrl() {
		return signetUrl;
	}

	public void setSignetUrl(String signetUrl) {
		this.signetUrl = signetUrl;
	}

	// 电子印章 id
	private Integer signetId;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getSignetId() {
		return signetId;
	}

	public void setSignetId(Integer signetId) {
		this.signetId = signetId;
	}

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to
	 * the database column edu_diploma.id
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.id
	 * 
	 * @return the value of edu_diploma.id
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.id
	 * 
	 * @param id
	 *            the value for edu_diploma.id
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.title
	 * 
	 * @return the value of edu_diploma.title
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.title
	 * 
	 * @param title
	 *            the value for edu_diploma.title
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.year
	 * 
	 * @return the value of edu_diploma.year
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.year
	 * 
	 * @param year
	 *            the value for edu_diploma.year
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.status
	 * 
	 * @return the value of edu_diploma.status
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.status
	 * 
	 * @param status
	 *            the value for edu_diploma.status
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.head
	 * 
	 * @return the value of edu_diploma.head
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public String getHead() {
		return head;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.head
	 * 
	 * @param head
	 *            the value for edu_diploma.head
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setHead(String head) {
		this.head = head;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.content
	 * 
	 * @return the value of edu_diploma.content
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.content
	 * 
	 * @param content
	 *            the value for edu_diploma.content
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.foot
	 * 
	 * @return the value of edu_diploma.foot
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public String getFoot() {
		return foot;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.foot
	 * 
	 * @param foot
	 *            the value for edu_diploma.foot
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setFoot(String foot) {
		this.foot = foot;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.position_right
	 * 
	 * @return the value of edu_diploma.position_right
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public Integer getPositionRight() {
		return positionRight;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.position_right
	 * 
	 * @param positionRight
	 *            the value for edu_diploma.position_right
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setPositionRight(Integer positionRight) {
		this.positionRight = positionRight;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.position_top
	 * 
	 * @return the value of edu_diploma.position_top
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public Integer getPositionTop() {
		return positionTop;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.position_top
	 * 
	 * @param positionTop
	 *            the value for edu_diploma.position_top
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setPositionTop(Integer positionTop) {
		this.positionTop = positionTop;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.position_width
	 * 
	 * @return the value of edu_diploma.position_width
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public Integer getPositionWidth() {
		return positionWidth;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.position_width
	 * 
	 * @param positionWidth
	 *            the value for edu_diploma.position_width
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setPositionWidth(Integer positionWidth) {
		this.positionWidth = positionWidth;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.position_height
	 * 
	 * @return the value of edu_diploma.position_height
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public Integer getPositionHeight() {
		return positionHeight;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.position_height
	 * 
	 * @param positionHeight
	 *            the value for edu_diploma.position_height
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setPositionHeight(Integer positionHeight) {
		this.positionHeight = positionHeight;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.seal
	 * 
	 * @return the value of edu_diploma.seal
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public String getSeal() {
		return seal;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.seal
	 * 
	 * @param seal
	 *            the value for edu_diploma.seal
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setSeal(String seal) {
		this.seal = seal;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.create_by
	 * 
	 * @return the value of edu_diploma.create_by
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.create_by
	 * 
	 * @param createBy
	 *            the value for edu_diploma.create_by
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.update_by
	 * 
	 * @return the value of edu_diploma.update_by
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.update_by
	 * 
	 * @param updateBy
	 *            the value for edu_diploma.update_by
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.create_date
	 * 
	 * @return the value of edu_diploma.create_date
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.create_date
	 * 
	 * @param createDate
	 *            the value for edu_diploma.create_date
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the
	 * value of the database column edu_diploma.update_date
	 * 
	 * @return the value of edu_diploma.update_date
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the
	 * value of the database column edu_diploma.update_date
	 * 
	 * @param updateDate
	 *            the value for edu_diploma.update_date
	 * 
	 * @abatorgenerated Wed Apr 02 11:32:49 CST 2014
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getIsProjectScopeCode() {
		return isProjectScopeCode;
	}

	public void setIsprojectScopeCode(String isProjectScopeCode) {
		this.isProjectScopeCode = isProjectScopeCode;
	}

	public String getIsProjectTrainTypeCode() {
		return isProjectTrainTypeCode;
	}

	public void setIsProjectTrainType(String isProjectTrainTypeCode) {
		this.isProjectTrainTypeCode = isProjectTrainTypeCode;
	}

	public String getIsOrgCode() {
		return isOrgCode;
	}

	public void setIsOrgCode(String isOrgCode) {
		this.isOrgCode = isOrgCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getYearCode() {
		return yearCode;
	}

	public void setYearCode(String yearCode) {
		this.yearCode = yearCode;
	}

	public String getProjectScopeCode() {
		return projectScopeCode;
	}

	public void setProjectScopeCode(String projectScopeCode) {
		this.projectScopeCode = projectScopeCode;
	}

	public String getProjectTrainTypeCode() {
		return projectTrainTypeCode;
	}

	public void setProjectTrainTypeCode(String projectTrainTypeCode) {
		this.projectTrainTypeCode = projectTrainTypeCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Integer getCertificateCodeRight() {
		return certificateCodeRight;
	}

	public void setCertificateCodeRight(Integer certificateCodeRight) {
		this.certificateCodeRight = certificateCodeRight;
	}

	public Integer getCertificateCodeTop() {
		return certificateCodeTop;
	}

	public void setCertificateCodeTop(Integer certificateCodeTop) {
		this.certificateCodeTop = certificateCodeTop;
	}

	public String getCertificateCodeFontStyle() {
		return certificateCodeFontStyle;
	}

	public void setCertificateCodeFontStyle(String certificateCodeFontStyle) {
		this.certificateCodeFontStyle = certificateCodeFontStyle;
	}


	public Integer getTeacherRight() {
		return teacherRight;
	}

	public void setTeacherRight(Integer teacherRight) {
		this.teacherRight = teacherRight;
	}

	public Integer getTeacherTop() {
		return teacherTop;
	}

	public void setTeacherTop(Integer teacherTop) {
		this.teacherTop = teacherTop;
	}

	public String getTeacherFontStyle() {
		return teacherFontStyle;
	}

	public void setTeacherFontStyle(String teacherFontStyle) {
		this.teacherFontStyle = teacherFontStyle;
	}


	public String getTeacherClassScore() {
		return teacherClassScore;
	}

	public void setTeacherClassScore(String teacherClassScore) {
		this.teacherClassScore = teacherClassScore;
	}

	public String getTeacherClassPeriod() {
		return teacherClassPeriod;
	}

	public void setTeacherClassPeriod(String teacherClassPeriod) {
		this.teacherClassPeriod = teacherClassPeriod;
	}

	public Integer getCertificateCodeFontSize() {
		return certificateCodeFontSize;
	}

	public void setCertificateCodeFontSize(Integer certificateCodeFontSize) {
		this.certificateCodeFontSize = certificateCodeFontSize;
	}

	public Integer getTeacherFontSize() {
		return teacherFontSize;
	}

	public void setTeacherFontSize(Integer teacherFontSize) {
		this.teacherFontSize = teacherFontSize;
	}

	public Integer getCertificateCodeFontType() {
		return certificateCodeFontType;
	}

	public void setCertificateCodeFontType(Integer certificateCodeFontType) {
		this.certificateCodeFontType = certificateCodeFontType;
	}

	public Integer getTeacherFontType() {
		return teacherFontType;
	}

	public void setTeacherFontType(Integer teacherFontType) {
		this.teacherFontType = teacherFontType;
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

	public void setIsProjectScopeCode(String isProjectScopeCode) {
		this.isProjectScopeCode = isProjectScopeCode;
	}

	public void setIsProjectTrainTypeCode(String isProjectTrainTypeCode) {
		this.isProjectTrainTypeCode = isProjectTrainTypeCode;
	}

	public Float getNeedCredit() {
		return needCredit;
	}

	public void setNeedCredit(Float needCredit) {
		this.needCredit = needCredit;
	}

	public Float getNeedPeriod() {
		return needPeriod;
	}

	public void setNeedPeriod(Float needPeriod) {
		this.needPeriod = needPeriod;
	}

	public String getNeedCredit1() {
		return needCredit1;
	}

	public void setNeedCredit1(String needCredit1) {
		this.needCredit1 = needCredit1;
	}

	public String getNeedPeriod1() {
		return needPeriod1;
	}

	public void setNeedPeriod1(String needPeriod1) {
		this.needPeriod1 = needPeriod1;
	}

	public Float getNeedCredit2() {
		return needCredit2;
	}

	public void setNeedCredit2(Float needCredit2) {
		this.needCredit2 = needCredit2;
	}

	public Float getNeedPeriod2() {
		return needPeriod2;
	}

	public void setNeedPeriod2(Float needPeriod2) {
		this.needPeriod2 = needPeriod2;
	}

	public Float getNeedCredit3() {
		return needCredit3;
	}

	public void setNeedCredit3(Float needCredit3) {
		this.needCredit3 = needCredit3;
	}

	public Float getNeedPeriod3() {
		return needPeriod3;
	}

	public void setNeedPeriod3(Float needPeriod3) {
		this.needPeriod3 = needPeriod3;
	}

	public String getChangeRate() {
		return changeRate;
	}

	public void setChangeRate(String changeRate) {
		this.changeRate = changeRate;
	}

	public float getRepayRate() {
		return repayRate;
	}

	public void setRepayRate(float repayRate) {
		this.repayRate = repayRate;
	}
	
}