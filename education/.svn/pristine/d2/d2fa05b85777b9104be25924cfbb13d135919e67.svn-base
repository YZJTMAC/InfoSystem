package framelib.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

import framelib.utils.DateUtil;


/**
 * Title:Shop
 * Description:店铺信息
 * @Create_by:yinsy
 * @Create_date:2013-10-14
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:baoogu 1.0
 */
public class ShopDTO implements Serializable {

	// Fields
    private static final long serialVersionUID = 459429495955897637L;
	private Integer id;	//PK
	private Integer userInfoId;	//用户ID
	private String companyName;	//公司名称
	private String realName;	//真实姓名
	private Integer sourceType;	//信息添加来源0：前台添加，1：后台添加
	private Integer status;		//店铺状态 0.草稿    1.待审核    2.审核通过    3.审核未通过    4.运营中    5.闭店中    6.封停中    7.已到期
	private String shopName;	//店铺名称
	private String shopDomain;	//店铺域名地址
	private Integer credentialType;	//证件类型1：身份证 2：护照
	private String credentialNo;	//证件号码
	private String companyRegistNo;	//公司注册号
	private String organizationCode;	//组织机构代码
	private String legalRepresentative;	//法人代表
	private Integer companyTypeId;		//企业类型
	private Integer companyMode;			//经营模式0：生产厂家 1：经销批发 2：商业服务 3：招商代理 4：其他
	private String companyModeName;
	private Integer companyProvideServe;	//是否提供对外加工/定制0：是 1：否
	private Integer serviceTypeId;		//服务类型
	private String companyMainProduct;	//主营产品
	private String companyMainCategoryId;	//主营类别
	private Integer companyRunCountryId;	//经营地区国家ID
	private Integer companyRunProvinceId;	//经营地区省ID
	private Integer companyRunCityId;		//经营地区市ID
	private Integer companyRunAreaId;	//经营地区ID
	private String companyRunCountryName;	//经营地区国家
	private String companyRunProvinceName;	//经营地区省
	private String companyRunCityName;		//经营地区市
	private String companyRunAreaName;	//经营地区
	private String companyAddress;	//公司详细地址
	private String companyZipCode;	//邮政编码
	private String companyWebsite;	//公司网址
	private String companySummary;	//公司简介
	private Integer contractId;		//合同ID
	private Integer bankId;			//银行ID
	private Integer bankAccountProvinceId;	//银行账户所属省份
	private Integer bankAccountCityId;		//银行账户所属市
	private Integer bankAccountSubbranchId;	//银行账户所属支行名称
	private String bankAccountName;			//银行开户名
	private String bankPublicAccount;		//对公账号
	private Timestamp openShopTime;		//开通店铺时间
	private String openShopTimeStr;
	private Timestamp applyTime;		//申请时间
	private Timestamp passTime;			//开店申请通过时间
	private Timestamp noPassTime;		//开店申请不通过时间
	private Timestamp saveDraftTime;	//存草稿时间
	private String createBy;			//创建人
	private Timestamp createTime;		//创建时间
	private String modifyBy;			//最后修改人
	private Timestamp modifyTime;		//最后修改时间
	
	private Integer shopBuyTime;	//购买开店时长（保存月份）
	private Double contPrice;		//应付合约金额
	private Integer contId;	//合同ID
	private Map<String, Object> shopAnnexMap;	//店铺附件Map
	private String username;	//用户名
	
	private String bigLogoUrl;//382x382 
	private String logoUrl;//110x110 
	private String smallLogoUrl;//80x80
	private Integer shopCategory;//所属分类的ID (数据源于CMS中B2B品类中一级品类)
	private String shopMain;//店铺主营
	private String shopAnnouncement;//店铺公告	
	private String banner;//店铺首页banner头图 1000x400
	
	/** 店铺认证状态 0：没有认证，1:已认证*/
	private int authenticateStatus;
	/** 店铺保证金 0：没有缴纳，1:已缴纳*/
	private int depositStatus;
	
	private String companyMainCategoryName;//主营类别名称

	
	// Constructors

	/** default constructor */
	public ShopDTO() {
	}
	
	
	public String getCompanyMainCategoryName() {
		return companyMainCategoryName;
	}




	public void setCompanyMainCategoryName(String companyMainCategoryName) {
		this.companyMainCategoryName = companyMainCategoryName;
	}




	public int getAuthenticateStatus() {
		return authenticateStatus;
	}

	public void setAuthenticateStatus(int authenticateStatus) {
		this.authenticateStatus = authenticateStatus;
	}




	public int getDepositStatus() {
		return depositStatus;
	}




	public void setDepositStatus(int depositStatus) {
		this.depositStatus = depositStatus;
	}




	public Integer getId() {
		return this.id;
	}
	
	public String getOpenShopTimeStr() {
//		try {
//			openShopTimeStr = DateUtil.format(openShopTime, DateUtil.dateTimeFormatCH);
//        } catch (Exception e) {
//        	openShopTimeStr = "";
//        }
		return openShopTimeStr;
	}

	public String getCompanyRunCountryName() {
		return companyRunCountryName;
	}

	public void setCompanyRunCountryName(String companyRunCountryName) {
		this.companyRunCountryName = companyRunCountryName;
	}

	public String getCompanyRunProvinceName() {
		return companyRunProvinceName;
	}

	public void setCompanyRunProvinceName(String companyRunProvinceName) {
		this.companyRunProvinceName = companyRunProvinceName;
	}

	public String getCompanyRunCityName() {
		return companyRunCityName;
	}

	public void setCompanyRunCityName(String companyRunCityName) {
		this.companyRunCityName = companyRunCityName;
	}

	public String getCompanyRunAreaName() {
		return companyRunAreaName;
	}

	public void setCompanyRunAreaName(String companyRunAreaName) {
		this.companyRunAreaName = companyRunAreaName;
	}

	public void setCompanyModeName(String companyModeName) {
		this.companyModeName = companyModeName;
	}

	public String getCompanyModeName() {
		if(companyMode!=null){
			if(0==companyMode){
				companyModeName = "生产厂家";
			}else if(1==companyMode){
				companyModeName = "经销批发";
			}else if(2==companyMode){
				companyModeName = "商业服务";
			}else if(3==companyMode){
				companyModeName = "招商代理";
			}else if(4==companyMode){
				companyModeName = "其他";
			}
		}else{
			companyModeName="";
		}
		return companyModeName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserInfoId() {
		return this.userInfoId;
	}

	public void setUserInfoId(Integer userInfoId) {
		this.userInfoId = userInfoId;
	}

	public Integer getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopDomain() {
		return this.shopDomain;
	}

	public void setShopDomain(String shopDomain) {
		this.shopDomain = shopDomain;
	}

	public Integer getCredentialType() {
		return this.credentialType;
	}

	public void setCredentialType(Integer credentialType) {
		this.credentialType = credentialType;
	}

	public String getCredentialNo() {
		return this.credentialNo;
	}

	public void setCredentialNo(String credentialNo) {
		this.credentialNo = credentialNo;
	}

	public String getCompanyRegistNo() {
		return this.companyRegistNo;
	}

	public void setCompanyRegistNo(String companyRegistNo) {
		this.companyRegistNo = companyRegistNo;
	}

	public String getOrganizationCode() {
		return this.organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getLegalRepresentative() {
		return this.legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public Integer getCompanyTypeId() {
		return this.companyTypeId;
	}

	public void setCompanyTypeId(Integer companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	public Integer getCompanyMode() {
		return this.companyMode;
	}

	public void setCompanyMode(Integer companyMode) {
		this.companyMode = companyMode;
	}

	public Integer getCompanyProvideServe() {
		return this.companyProvideServe;
	}

	public void setCompanyProvideServe(Integer companyProvideServe) {
		this.companyProvideServe = companyProvideServe;
	}

	public Integer getServiceTypeId() {
		return this.serviceTypeId;
	}

	public void setServiceTypeId(Integer serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getCompanyMainProduct() {
		return this.companyMainProduct;
	}

	public void setCompanyMainProduct(String companyMainProduct) {
		this.companyMainProduct = companyMainProduct;
	}

	public String getCompanyMainCategoryId() {
		return this.companyMainCategoryId;
	}

	public void setCompanyMainCategoryId(String companyMainCategoryId) {
		this.companyMainCategoryId = companyMainCategoryId;
	}

	public Integer getCompanyRunCountryId() {
		return this.companyRunCountryId;
	}

	public void setCompanyRunCountryId(Integer companyRunCountryId) {
		this.companyRunCountryId = companyRunCountryId;
	}

	public Integer getCompanyRunProvinceId() {
		return this.companyRunProvinceId;
	}

	public void setCompanyRunProvinceId(Integer companyRunProvinceId) {
		this.companyRunProvinceId = companyRunProvinceId;
	}

	public Integer getCompanyRunCityId() {
		return this.companyRunCityId;
	}

	public void setCompanyRunCityId(Integer companyRunCityId) {
		this.companyRunCityId = companyRunCityId;
	}

	public Integer getCompanyRunAreaId() {
		return this.companyRunAreaId;
	}

	public void setCompanyRunAreaId(Integer companyRunAreaId) {
		this.companyRunAreaId = companyRunAreaId;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyZipCode() {
		return this.companyZipCode;
	}

	public void setCompanyZipCode(String companyZipCode) {
		this.companyZipCode = companyZipCode;
	}

	public String getCompanyWebsite() {
		return this.companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCompanySummary() {
		return this.companySummary;
	}

	public void setCompanySummary(String companySummary) {
		this.companySummary = companySummary;
	}

	public Integer getContractId() {
		return this.contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public Integer getBankId() {
		return this.bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public Integer getBankAccountProvinceId() {
		return this.bankAccountProvinceId;
	}

	public void setBankAccountProvinceId(Integer bankAccountProvinceId) {
		this.bankAccountProvinceId = bankAccountProvinceId;
	}

	public Integer getBankAccountCityId() {
		return this.bankAccountCityId;
	}

	public void setBankAccountCityId(Integer bankAccountCityId) {
		this.bankAccountCityId = bankAccountCityId;
	}

	public Integer getBankAccountSubbranchId() {
		return this.bankAccountSubbranchId;
	}

	public void setBankAccountSubbranchId(Integer bankAccountSubbranchId) {
		this.bankAccountSubbranchId = bankAccountSubbranchId;
	}

	public String getBankAccountName() {
		return this.bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getBankPublicAccount() {
		return this.bankPublicAccount;
	}

	public void setBankPublicAccount(String bankPublicAccount) {
		this.bankPublicAccount = bankPublicAccount;
	}

	public Timestamp getOpenShopTime() {
		return this.openShopTime;
	}

	public void setOpenShopTime(Timestamp openShopTime) {
		this.openShopTime = openShopTime;
	}

	public Timestamp getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}

	public Timestamp getPassTime() {
		return this.passTime;
	}

	public void setPassTime(Timestamp passTime) {
		this.passTime = passTime;
	}

	public Timestamp getNoPassTime() {
		return this.noPassTime;
	}

	public void setNoPassTime(Timestamp noPassTime) {
		this.noPassTime = noPassTime;
	}

	public Timestamp getSaveDraftTime() {
		return this.saveDraftTime;
	}

	public void setSaveDraftTime(Timestamp saveDraftTime) {
		this.saveDraftTime = saveDraftTime;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getModifyBy() {
		return this.modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getShopBuyTime() {
		return shopBuyTime;
	}

	public void setShopBuyTime(Integer shopBuyTime) {
		this.shopBuyTime = shopBuyTime;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Double getContPrice() {
		return contPrice;
	}

	public void setContPrice(Double contPrice) {
		this.contPrice = contPrice;
	}

	public Integer getContId() {
		return contId;
	}

	public void setContId(Integer contId) {
		this.contId = contId;
	}

	public Map<String, Object> getShopAnnexMap() {
		return shopAnnexMap;
	}

	public void setShopAnnexMap(Map<String, Object> shopAnnexMap) {
		this.shopAnnexMap = shopAnnexMap;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getBigLogoUrl() {
		return bigLogoUrl;
	}

	public void setBigLogoUrl(String bigLogoUrl) {
		this.bigLogoUrl = bigLogoUrl;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getSmallLogoUrl() {
		return smallLogoUrl;
	}

	public void setSmallLogoUrl(String smallLogoUrl) {
		this.smallLogoUrl = smallLogoUrl;
	}

	public Integer getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(Integer shopCategory) {
		this.shopCategory = shopCategory;
	}

	public String getShopMain() {
		return shopMain;
	}

	public void setShopMain(String shopMain) {
		this.shopMain = shopMain;
	}

	public String getShopAnnouncement() {
		return shopAnnouncement;
	}

	public void setShopAnnouncement(String shopAnnouncement) {
		this.shopAnnouncement = shopAnnouncement;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}
	
}