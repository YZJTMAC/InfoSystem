package project.edupm.projectmanage.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EduModel {
	
	/**
	 * 新增字段：板块信息状态：0：禁用，1：启用. 默认启用
	 * */
	private Integer status;
	
	/**
	 * 非持久化字段：是否被用：0:没有被用 ，1：已被用到 。板块信息是否被项目用到。如果被用到，则不能被禁用。默认没有被用到
	 * */
	private Integer used;
	
	private String excellentRule;
	
	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	private String exchangeRole;
	
	
	
    public String getExchangeRole() {
		return exchangeRole;
	}

	public void setExchangeRole(String exchangeRole) {
		this.exchangeRole = exchangeRole;
	}

	/**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column edu_model.id
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    private Integer id;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column edu_model.model_name
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    private String modelName;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column edu_model.model_code
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    private String modelCode;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column edu_model.train_type
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    private String trainType;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column edu_model.train_hour
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    private String trainHour;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column edu_model.train_score
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    private String trainScore;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column edu_model.start_date
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    private Date startDate;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column edu_model.end_date
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    private Date endDate;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column edu_model.create_by
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    private String createBy;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column edu_model.create_date
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    private Date createDate;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column edu_model.update_by
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    private String updateBy;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column edu_model.update_date
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    private Date updateDate;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column edu_model.memo
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    private String memo;

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column edu_model.id
     *
     * @return the value of edu_model.id
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column edu_model.id
     *
     * @param id the value for edu_model.id
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column edu_model.model_name
     *
     * @return the value of edu_model.model_name
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column edu_model.model_name
     *
     * @param modelName the value for edu_model.model_name
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column edu_model.model_code
     *
     * @return the value of edu_model.model_code
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public String getModelCode() {
        return modelCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column edu_model.model_code
     *
     * @param modelCode the value for edu_model.model_code
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column edu_model.train_type
     *
     * @return the value of edu_model.train_type
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public String getTrainType() {
        return trainType;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column edu_model.train_type
     *
     * @param trainType the value for edu_model.train_type
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column edu_model.train_hour
     *
     * @return the value of edu_model.train_hour
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public String getTrainHour() {
        return trainHour;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column edu_model.train_hour
     *
     * @param trainHour the value for edu_model.train_hour
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public void setTrainHour(String trainHour) {
        this.trainHour = trainHour;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column edu_model.train_score
     *
     * @return the value of edu_model.train_score
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public String getTrainScore() {
        return trainScore;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column edu_model.train_score
     *
     * @param trainScore the value for edu_model.train_score
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public void setTrainScore(String trainScore) {
        this.trainScore = trainScore;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column edu_model.start_date
     *
     * @return the value of edu_model.start_date
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public String getStartDate() throws Exception{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(startDate);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column edu_model.start_date
     *
     * @param startDate the value for edu_model.start_date
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column edu_model.end_date
     *
     * @return the value of edu_model.end_date
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public String getEndDate() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(endDate);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column edu_model.end_date
     *
     * @param endDate the value for edu_model.end_date
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column edu_model.create_by
     *
     * @return the value of edu_model.create_by
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column edu_model.create_by
     *
     * @param createBy the value for edu_model.create_by
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column edu_model.create_date
     *
     * @return the value of edu_model.create_date
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column edu_model.create_date
     *
     * @param createDate the value for edu_model.create_date
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column edu_model.update_by
     *
     * @return the value of edu_model.update_by
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column edu_model.update_by
     *
     * @param updateBy the value for edu_model.update_by
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column edu_model.update_date
     *
     * @return the value of edu_model.update_date
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column edu_model.update_date
     *
     * @param updateDate the value for edu_model.update_date
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column edu_model.memo
     *
     * @return the value of edu_model.memo
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column edu_model.memo
     *
     * @param memo the value for edu_model.memo
     *
     * @abatorgenerated Fri Apr 25 17:44:00 CST 2014
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

	public String getExcellentRule() {
		return excellentRule;
	}

	public void setExcellentRule(String excellentRule) {
		this.excellentRule = excellentRule;
	}
}