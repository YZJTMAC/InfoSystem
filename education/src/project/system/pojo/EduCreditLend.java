package project.system.pojo;

public class EduCreditLend {
	private int id;
	private String lendYear;
	private String lendDate;
	private String lendReason;
	private Float lendCredit;
	private Float lendPeriod;
	private String lendStatus;
	private String lendCommand;
	private int teacherId;
	private String teacherName;
	private String teacherIdNumber;
	private String repayDate;
	private Float repayCredit;
	private String trainFormId;
	private String trainFormName;
	private String schoolName;
	private String idNumber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLendYear() {
		return lendYear;
	}
	public void setLendYear(String lendYear) {
		this.lendYear = lendYear;
	}
	public String getLendDate() {
		return lendDate;
	}
	public void setLendDate(String lendDate) {
		this.lendDate = lendDate;
	}
	public String getLendReason() {
		return lendReason;
	}
	public void setLendReason(String lendReason) {
		this.lendReason = lendReason;
	}
	public Float getLendCredit() {
		return lendCredit;
	}
	public void setLendCredit(Float lendCredit) {
		this.lendCredit = lendCredit;
	}
	public String getLendStatus() {
		return lendStatus;
	}
	public void setLendStatus(String lendStatus) {
		this.lendStatus = lendStatus;
	}
	public String getLendCommand() {
		return lendCommand;
	}
	public void setLendCommand(String lendCommand) {
		this.lendCommand = lendCommand;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getRepayDate() {
		return repayDate;
	}
	public void setRepayDate(String repayDate) {
		this.repayDate = repayDate;
	}
	public Float getRepayCredit() {
		return repayCredit;
	}
	public void setRepayCredit(Float repayCredit) {
		this.repayCredit = repayCredit;
	}
	public String getTrainFormId() {
		return trainFormId;
	}
	public void setTrainFormId(String trainFormId) {
		this.trainFormId = trainFormId;
	}
	public String getTrainFormName() {
		return trainFormName;
	}
	public void setTrainFormName(String trainFormName) {
		this.trainFormName = trainFormName;
	}
	public Float getLendPeriod() {
		return lendPeriod;
	}
	public void setLendPeriod(Float lendPeriod) {
		this.lendPeriod = lendPeriod;
	}
	public String getTeacherIdNumber() {
		return teacherIdNumber;
	}
	public void setTeacherIdNumber(String teacherIdNumber) {
		this.teacherIdNumber = teacherIdNumber;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

}
