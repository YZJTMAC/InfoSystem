package project.system.pojo;

public class SysSetup {

	private Integer id;
	
	
	private String accountType;// 可用登录方式
	
	private Integer useTeacherRole;// 是否停用教师角色
	
	private Integer openRegisterTeacher;// 是否开放注册教师
	
	private Integer teacherInfoChangeAudit;// 教师信息变动审核
	
	private Integer teacherInfoSafe;// 教师信息导出安全
	
	private Integer enableOrg;// 是否启用承陪机构 （1 启用 （默认）  0禁用）
	
	public Integer getEnableOrg() {
		return enableOrg;
	}

	public void setEnableOrg(Integer enableOrg) {
		this.enableOrg = enableOrg;
	}

	private String teacherModuleAutherId;// 教师信息模块管理授权
	
	private String teacherModuleAutherName;
	
	private String furthereduModuleAutherId;// 继教信息模块管理授权
	
	private String furthereduModuleAutherName;
	
	private String teacherInfoAuditLevel;// 教师信息审核级别	(没用)

	private String transferAuditLevel;// 调动审核级别		(没用)
	
	private String retiredAuditLevel;// 离退休审核级别		(没用)
	
	private String furthereduAuditLevel;// 继教信息审核级别	(没用)
	
	private String yearAppraisalLevel;// 年度考核设定所在级别	(没用)

	private String createBy;
	
	private String createDate;
	
	private String updateBy;
	
	private String updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Integer getUseTeacherRole() {
		return useTeacherRole;
	}

	public void setUseTeacherRole(Integer useTeacherRole) {
		this.useTeacherRole = useTeacherRole;
	}

	public Integer getOpenRegisterTeacher() {
		return openRegisterTeacher;
	}

	public void setOpenRegisterTeacher(Integer openRegisterTeacher) {
		this.openRegisterTeacher = openRegisterTeacher;
	}

	public Integer getTeacherInfoChangeAudit() {
		return teacherInfoChangeAudit;
	}

	public void setTeacherInfoChangeAudit(Integer teacherInfoChangeAudit) {
		this.teacherInfoChangeAudit = teacherInfoChangeAudit;
	}

	public Integer getTeacherInfoSafe() {
		return teacherInfoSafe;
	}

	public void setTeacherInfoSafe(Integer teacherInfoSafe) {
		this.teacherInfoSafe = teacherInfoSafe;
	}

	public String getTeacherModuleAutherId() {
		return teacherModuleAutherId;
	}

	public void setTeacherModuleAutherId(String teacherModuleAutherId) {
		this.teacherModuleAutherId = teacherModuleAutherId;
	}

	public String getTeacherModuleAutherName() {
		return teacherModuleAutherName;
	}

	public void setTeacherModuleAutherName(String teacherModuleAutherName) {
		this.teacherModuleAutherName = teacherModuleAutherName;
	}

	public String getFurthereduModuleAutherId() {
		return furthereduModuleAutherId;
	}

	public void setFurthereduModuleAutherId(String furthereduModuleAutherId) {
		this.furthereduModuleAutherId = furthereduModuleAutherId;
	}

	public String getFurthereduModuleAutherName() {
		return furthereduModuleAutherName;
	}

	public void setFurthereduModuleAutherName(String furthereduModuleAutherName) {
		this.furthereduModuleAutherName = furthereduModuleAutherName;
	}

	public String getTeacherInfoAuditLevel() {
		return teacherInfoAuditLevel;
	}

	public void setTeacherInfoAuditLevel(String teacherInfoAuditLevel) {
		this.teacherInfoAuditLevel = teacherInfoAuditLevel;
	}

	public String getTransferAuditLevel() {
		return transferAuditLevel;
	}

	public void setTransferAuditLevel(String transferAuditLevel) {
		this.transferAuditLevel = transferAuditLevel;
	}

	public String getRetiredAuditLevel() {
		return retiredAuditLevel;
	}

	public void setRetiredAuditLevel(String retiredAuditLevel) {
		this.retiredAuditLevel = retiredAuditLevel;
	}

	public String getFurthereduAuditLevel() {
		return furthereduAuditLevel;
	}

	public void setFurthereduAuditLevel(String furthereduAuditLevel) {
		this.furthereduAuditLevel = furthereduAuditLevel;
	}

	public String getYearAppraisalLevel() {
		return yearAppraisalLevel;
	}

	public void setYearAppraisalLevel(String yearAppraisalLevel) {
		this.yearAppraisalLevel = yearAppraisalLevel;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
