package project.edupm.projectmanage.pojo;

public class EduProject {
	
	private String exchangeRule;  //全员兑换规则
	private String excellentRule;//优秀全员兑换规则
	private String exchangeWay;//兑换方式
	private Integer allocatePlanNum;
	private Integer organizationId;
	private String organizationName;
	private Integer districtExamine;
	private Integer ifAudit;
	//对于层级上报的项目，分配名额是否已经上报的状态
	private Integer isReportStatus;
	public Integer getisReportStatus() {
		return isReportStatus;
	}

	public void setisReportStatus(Integer isReportStatus) {
		this.isReportStatus = isReportStatus;
	}

	private Integer schoolCityId;
	private Integer cityPass;
	private Integer provinceUnPass;
	private Integer nuIfAudit;
	private Integer districtId;
	private String districtMemo;
    public String getDistrictMemo() {
		return districtMemo;
	}

	public void setDistrictMemo(String districtMemo) {
		this.districtMemo = districtMemo;
	}

	public String getCityMemo() {
		return cityMemo;
	}

	public void setCityMemo(String cityMemo) {
		this.cityMemo = cityMemo;
	}

	public String getProvinceMemo() {
		return provinceMemo;
	}

	public void setProvinceMemo(String provinceMemo) {
		this.provinceMemo = provinceMemo;
	}

	private String cityMemo;
    private String provinceMemo;
	
	
	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Integer getNuIfAudit() {
		return nuIfAudit;
	}

	public void setNuIfAudit(Integer nuIfAudit) {
		this.nuIfAudit = nuIfAudit;
	}

	public Integer getProvinceUnPass() {
		return provinceUnPass;
	}

	public void setProvinceUnPass(Integer provinceUnPass) {
		this.provinceUnPass = provinceUnPass;
	}

	public Integer getProvincePass() {
		return provincePass;
	}

	public void setProvincePass(Integer provincePass) {
		this.provincePass = provincePass;
	}

	private Integer provincePass;
	
	
	public Integer getCityPass() {
		return cityPass;
	}

	public void setCityPass(Integer cityPass) {
		this.cityPass = cityPass;
	}

	public Integer getCityUnPass() {
		return cityUnPass;
	}

	public void setCityUnPass(Integer cityUnPass) {
		this.cityUnPass = cityUnPass;
	}

	public Integer getQuPass() {
		return quPass;
	}

	public void setQuPass(Integer quPass) {
		this.quPass = quPass;
	}

	public Integer getQuUnPass() {
		return quUnPass;
	}

	public void setQuUnPass(Integer quUnPass) {
		this.quUnPass = quUnPass;
	}

	private Integer cityUnPass;
	private Integer quPass;
	private Integer quUnPass;
	private Integer printXueshiCertificate;
	private Integer printProjectCertificate;

	public Integer getPrintXueshiCertificate() {
		return printXueshiCertificate;
	}

	public void setPrintXueshiCertificate(Integer printXueshiCertificate) {
		this.printXueshiCertificate = printXueshiCertificate;
	}

	public Integer getPrintProjectCertificate() {
		return printProjectCertificate;
	}

	public void setPrintProjectCertificate(Integer printProjectCertificate) {
		this.printProjectCertificate = printProjectCertificate;
	}

	public Integer getSchoolCityId() {
		return schoolCityId;
	}

	public void setSchoolCityId(Integer schoolCityId) {
		this.schoolCityId = schoolCityId;
	}

	public Integer getSchoolProvinceId() {
		return schoolProvinceId;
	}

	public void setSchoolProvinceId(Integer schoolProvinceId) {
		this.schoolProvinceId = schoolProvinceId;
	}

	private Integer schoolProvinceId;
	public Integer getCountstudent() {
		return countstudent;
	}

	public void setCountstudent(Integer countstudent) {
		this.countstudent = countstudent;
	}

	private Integer countstudent;//上报人数
	public Integer getIfAudit() {
		return ifAudit;
	}

	public void setIfAudit(Integer ifAudit) {
		this.ifAudit = ifAudit;
	}

	public Integer getDistrictExamine() {
		return districtExamine;
	}

	public void setDistrictExamine(Integer districtExamine) {
		this.districtExamine = districtExamine;
	}

	public Integer getCityExamine() {
		return cityExamine;
	}

	public void setCityExamine(Integer cityExamine) {
		this.cityExamine = cityExamine;
	}

	public Integer getProvinceExamine() {
		return provinceExamine;
	}

	public void setProvinceExamine(Integer provinceExamine) {
		this.provinceExamine = provinceExamine;
	}

	private Integer cityExamine;
	private Integer provinceExamine;
	
	
	
	private Integer orgId;
	
    private Integer id;
    private Integer num;
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

	private Integer pass;
    private Integer unPass;
    
    
    
    public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	private Integer areaId;
    
    
    
    private Integer projectId;
    
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
    
    public Integer getAllocatePlan() {
		return allocatePlan;
	}

	public void setAllocatePlan(Integer allocatePlan) {
		this.allocatePlan = allocatePlan;
	}

	private Integer allocatePlan;

    public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	private Integer schoolId;
	
	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getSchoolDistrictId() {
		return schoolDistrictId;
	}

	public void setSchoolDistrictId(Integer schoolDistrictId) {
		this.schoolDistrictId = schoolDistrictId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	private Integer schoolDistrictId;

	private String schoolName;
	
	private String projectNo;

    private String projectName;

    private Integer year;

    private String startDate;

    public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	private String endDate;

    private Integer projectScopeId;

    private String projectScopeName;

    private Integer projectPropertyId;

    private String projectPropertyName;

    private String trainScopeId;

    private String trainScopeName;

    private Integer trainTypeId;

    private String trainTypeName;

//    private Integer trainTargetId;

    private Integer classPeriod;

    private Float classScore;

    private String projectAttchement;

    private Integer signUpWay;

    private Integer status;

    private String createBy;
    
    //培训项目创建人id
    private Integer CreateById;
    
    private Integer createByArea;   

	private String createDate;

    private String updateBy;
    private String updateDate;
    
    private String fileName;
    
    private Integer eduModelType;
    
    private String eduModelName;
    
    private Integer pid;
    private Integer cid;
    private Integer did;
    
    
    
    
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

	//实施机构
    private String actualizeOrg;
    
    //教师查看成绩规则:提交项目总结,完成对承培机构评价,完成项目调查与评估';
    private String viewScoreRule;
   
    //'成线发布规则:0公布分数默认.1按是否合格发布.2按等级公布';
    private String  scorePublishRule;
    
    //'合格成绩分数,取得学时最低分数,成绩等级化分60|60,70,80'; 
    private String scoreLevelRule; 

    //'是否已发布过成绩.默认为0未发布.1.已发布成绩.';
    private Integer  isScorePublished;

    //报名人数
    private Integer attendNum;
    
    private Integer hasStopSign;
    
    public Integer getHasStopSign() {
		return hasStopSign;
	}

	public void setHasStopSign(Integer hasStopSign) {
		this.hasStopSign = hasStopSign;
	}

	//学习人数
    private Integer learningNum;
    
    //报名人数
    private Integer signNum;
    
    private String applyer;
    
    private String applyDate;
    
    private String auditDate;
    

	public String getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}

	private String auditor;
    
    private String auditStatus;
    
    
    
    
    public Integer getSignNum() {
		return signNum;
	}

	public void setSignNum(Integer signNum) {
		this.signNum = signNum;
	}

	public String getApplyer() {
		return applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}

	public String getApplyDate() {
		if(applyDate != null && applyDate.length()>0){
			return applyDate.substring(0,applyDate.lastIndexOf("."));
		}
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		
		this.applyDate = applyDate;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public String getEduModelName() {
		return eduModelName;
	}

	public void setEduModelName(String eduModelName) {
		this.eduModelName = eduModelName;
	}

	public String getActualizeOrg() {
		return actualizeOrg;
	}

	public void setActualizeOrg(String actualizeOrg) {
		this.actualizeOrg = actualizeOrg;
	}

	public Integer getEduModelType() {
		return eduModelType;
	}

	public void setEduModelType(Integer eduModelType) {
		this.eduModelType = eduModelType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
     * 
     * 
     *
     * 
     */
    private String memo;
    
    
    private Integer planNum;
    
    public Integer getPlanNum() {
		return planNum;
	}

	public void setPlanNum(Integer planNum) {
		this.planNum = planNum;
	}

	/**
     * 
     * 
     *
     * 
     *
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * 
     *
     * @param id the value for edu_project.id
     *
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public String getProjectNo() {
        return projectNo;
    }

    /**
     * 
     * 
     *
     * @param projectNo the value for edu_project.project_no
     *
     * 
     */
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 
     * 
     *
     * @param projectName the value for edu_project.project_name
     *
     * 
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 
     * 
     *
     * @param year the value for edu_project.year
     *
     * 
     */
    public void setYear(Integer year) {
        this.year = year;
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

	public Integer getProjectScopeId() {
        return projectScopeId;
    }

    /**
     * 
     * 
     *
     * @param projectScopeId the value for edu_project.project_scope_id
     *
     * 
     */
    public void setProjectScopeId(Integer projectScopeId) {
        this.projectScopeId = projectScopeId;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public String getProjectScopeName() {
        return projectScopeName;
    }

    /**
     * 
     * 
     *
     * @param projectScopeName the value for edu_project.project_scope_name
     *
     * 
     */
    public void setProjectScopeName(String projectScopeName) {
        this.projectScopeName = projectScopeName;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public Integer getProjectPropertyId() {
        return projectPropertyId;
    }

    /**
     * 
     * 
     *
     * @param projectPropertyId the value for edu_project.project_property_id
     *
     * 
     */
    public void setProjectPropertyId(Integer projectPropertyId) {
        this.projectPropertyId = projectPropertyId;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public String getProjectPropertyName() {
        return projectPropertyName;
    }

    /**
     * 
     * 
     *
     * @param projectPropertyName the value for edu_project.project_property_name
     *
     * 
     */
    public void setProjectPropertyName(String projectPropertyName) {
        this.projectPropertyName = projectPropertyName;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public String getTrainScopeId() {
        return trainScopeId;
    }

    /**
     * 
     * 
     *
     * @param trainScopeId the value for edu_project.train_scope_id
     *
     * 
     */
    public void setTrainScopeId(String trainScopeId) {
        this.trainScopeId = trainScopeId;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public String getTrainScopeName() {
        return trainScopeName;
    }

    /**
     * 
     * 
     *
     * @param trainScopeName the value for edu_project.train_scope_name
     *
     * 
     */
    public void setTrainScopeName(String trainScopeName) {
        this.trainScopeName = trainScopeName;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public Integer getTrainTypeId() {
        return trainTypeId;
    }

    /**
     * 
     * 
     *
     * @param trainTypeId the value for edu_project.train_type_id
     *
     * 
     */
    public void setTrainTypeId(Integer trainTypeId) {
        this.trainTypeId = trainTypeId;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public String getTrainTypeName() {
        return trainTypeName;
    }

    /**
     * 
     * 
     *
     * @param trainTypeName the value for edu_project.train_type_name
     *
     * 
     */
    public void setTrainTypeName(String trainTypeName) {
        this.trainTypeName = trainTypeName;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
//    public Integer getTrainTargetId() {
//        return trainTargetId;
//    }

    /**
     * 
     * 
     *
     * @param trainTargetId the value for edu_project.train_target_id
     *
     * 
     */
//    public void setTrainTargetId(Integer trainTargetId) {
//        this.trainTargetId = trainTargetId;
//    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public Integer getClassPeriod() {
        return classPeriod;
    }

    /**
     * 
     * 
     *
     * @param classPeriod the value for edu_project.class_period
     *
     * 
     */
    public void setClassPeriod(Integer classPeriod) {
        this.classPeriod = classPeriod;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public Float getClassScore() {
        return classScore;
    }

    /**
     * 
     * 
     *
     * @param classScore the value for edu_project.class_score
     *
     * 
     */
    public void setClassScore(Float classScore) {
        this.classScore = classScore;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public String getProjectAttchement() {
        return projectAttchement;
    }

    /**
     * 
     * 
     *
     * @param projectAttchement the value for edu_project.project_attchement
     *
     * 
     */
    public void setProjectAttchement(String projectAttchement) {
        this.projectAttchement = projectAttchement;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public Integer getSignUpWay() {
        return signUpWay;
    }

    /**
     * 
     * 
     *
     * @param signUpWay the value for edu_project.sign_up_way
     *
     * 
     */
    public void setSignUpWay(Integer signUpWay) {
        this.signUpWay = signUpWay;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * 
     *
     * @param status the value for edu_project.status
     *
     * 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 
     * 
     *
     * @param createBy the value for edu_project.create_by
     *
     * 
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    
    /**
     * 创建项目的人的所在地区
     * @return
     */    
    public Integer getCreateByArea() {
		return createByArea;
	}

    /**
     * 创建项目的人的所在地区
     * 
     */
	public void setCreateByArea(Integer createByArea) {
		this.createByArea = createByArea;
	}

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 
     * 
     *
     * @param createDate the value for edu_project.create_date
     *
     * 
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 
     * 
     *
     * @param updateBy the value for edu_project.update_by
     *
     * 
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * 
     * 
     *
     * @param updateDate the value for edu_project.update_date
     *
     * 
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 
     * 
     *
     * 
     *
     * 
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 
     * 
     *
     * @param memo the value for edu_project.memo
     *
     * 
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

	public String getViewScoreRule() {
		return viewScoreRule;
	}

	public void setViewScoreRule(String viewScoreRule) {
		this.viewScoreRule = viewScoreRule;
	}

	public String getScorePublishRule() {
		return scorePublishRule;
	}

	public void setScorePublishRule(String scorePublishRule) {
		this.scorePublishRule = scorePublishRule;
	}

	public String getScoreLevelRule() {
		return scoreLevelRule;
	}

	public void setScoreLevelRule(String scoreLevelRule) {
		this.scoreLevelRule = scoreLevelRule;
	}

	public Integer getIsScorePublished() {
		return isScorePublished;
	}

	public void setIsScorePublished(Integer isScorePublished) {
		this.isScorePublished = isScorePublished;
	}

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

	public Integer getSingNum() {
		return signNum;
	}

	public void setSingNum(Integer singNum) {
		this.signNum = singNum;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAllocatePlanNum(Integer allocatePlanNum) {
		this.allocatePlanNum = allocatePlanNum;
	}

	public Integer getAllocatePlanNum() {
		return allocatePlanNum;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getCreateById() {
		return CreateById;
	}

	public void setCreateById(Integer createById) {
		CreateById = createById;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getExchangeRule() {
		return exchangeRule;
	}

	public String getExcellentRule() {
		return excellentRule;
	}

	public String getExchangeWay() {
		return exchangeWay;
	}

	public void setExchangeWay(String exchangeWay) {
		this.exchangeWay = exchangeWay;
	}

	public void setExchangeRule(String exchangeRule) {
		this.exchangeRule = exchangeRule;
	}

	public void setExcellentRule(String excellentRule) {
		this.excellentRule = excellentRule;
	}

	
}