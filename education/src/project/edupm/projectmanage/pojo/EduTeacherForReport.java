package project.edupm.projectmanage.pojo;

public class EduTeacherForReport {
	
	private Integer tid;
	private Integer projectId;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	private Integer id;
	private String name;
	private String idNO;
	private String province;
	private String city;
	private String district;
	private Integer schoolId;
	private String schoolName;
	private String subject;
	private String status;
	private String mobile;
	private String signStatus;
	
	//下面这6个用在教师报名审核,主要用来显示当前审核状态与上级上审核状态--liuyiyou
	private String districtExamine;
	private String cityExamine;
	private String provinceExamine;
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
	public String getDistrictExamine() {
		return districtExamine;
	}
	public void setDistrictExamine(String districtExamine) {
		this.districtExamine = districtExamine;
	}
	public String getCityExamine() {
		return cityExamine;
	}
	public void setCityExamine(String cityExamine) {
		this.cityExamine = cityExamine;
	}
	public String getProvinceExamine() {
		return provinceExamine;
	}
	public void setProvinceExamine(String provinceExamine) {
		this.provinceExamine = provinceExamine;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNO() {
		return idNO;
	}
	public void setIdNO(String idNO) {
		this.idNO = idNO;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSignStatus() {
		return signStatus;
	}
	public void setSignStatus(String signStatus) {
		this.signStatus = signStatus;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

}
