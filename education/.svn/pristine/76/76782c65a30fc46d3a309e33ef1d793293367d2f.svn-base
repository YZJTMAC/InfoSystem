package framelib.common;

import java.util.List;

import framelib.dto.ShopDTO;
import framelib.dto.UserInfoDTO;



/**
 * Title:SessionData
 * Description:
 * @Create_by:Vince Yu
 * @Create_date:2012-5-4
 * @Last_Edit_By:2013-12-2 zhangyan
 * @Edit_Description:
 *  2013-12-2 Zhang Yan 新增firstGetCookieShopCart成员变量，用以判断当前用户是不是第一次从cookie的购物车中取数据  
 * @version:178xf 1.0
 * 
 */
@SuppressWarnings("serial")
public class SessionData implements java.io.Serializable {
	
	private UserInfoDTO userInfoDTO;//当前登录用户 
	private ShopDTO shopDTO; 
    //paramName,lableName,extValue,permission,indexNo,type,flag
	private int id;
	private String nickName;
	private String email;
	private String avatar;
	private String passStrength;
	private String securityEmail;
	private String lastLoginIp;
	private String lastLoginTime;
	private String currentLoginIp;
	private String currentLoginTime;
	private List<String> urls;  //用户具备的url集合
	private List<Integer> roleIds;  //用户具备的角色id
	private int userType;//用户类型 1：后端用户 2：前端用户
	//判断当前用户是不是第一次从session中取数据
	private boolean firstLogin = true;
	
	// zhangy 2013-12-2 判断当前用户是不是第一次从cookie的购物车中取数据  
    private boolean firstGetCookieShopCart = false;
    
    
    private String encryptedStr;//用户多系统之间跳转的加密串
    
	public String getEncryptedStr() {
		return encryptedStr;
	}
	public void setEncryptedStr(String encryptedStr) {
		this.encryptedStr = encryptedStr;
	}
	//sex,province,city,county,birthday
	//与ExtValue.properties顺序相同,也就是与保存顺序相同
	/**
     * @return Returns the currentLoginIp.
     */
    public String getCurrentLoginIp() {
    	return currentLoginIp;
    }
	/**
     * @param currentLoginIp The currentLoginIp to set.
     */
    public void setCurrentLoginIp(String currentLoginIp) {
    	this.currentLoginIp = currentLoginIp;
    }
	/**
     * @return Returns the currentLoginTime.
     */
    public String getCurrentLoginTime() {
    	return currentLoginTime;
    }
	/**
     * @param currentLoginTime The currentLoginTime to set.
     */
    public void setCurrentLoginTime(String currentLoginTime) {
    	this.currentLoginTime = currentLoginTime;
    }
	/**
     * @return Returns the passStrength.
     */
    public String getPassStrength() {
    	return passStrength;
    }
	/**
     * @param passStrength The passStrength to set.
     */
    public void setPassStrength(String passStrength) {
    	this.passStrength = passStrength;
    }
	/**
     * @return Returns the securityEmail.
     */
    public String getSecurityEmail() {
    	return securityEmail;
    }
	/**
     * @param securityEmail The securityEmail to set.
     */
    public void setSecurityEmail(String securityEmail) {
    	this.securityEmail = securityEmail;
    }
	/**
     * @return Returns the lastLoginIp.
     */
    public String getLastLoginIp() {
    	return lastLoginIp;
    }
	/**
     * @param lastLoginIp The lastLoginIp to set.
     */
    public void setLastLoginIp(String lastLoginIp) {
    	this.lastLoginIp = lastLoginIp;
    }
	/**
     * @return Returns the lastLoginTime.
     */
    public String getLastLoginTime() {
    	return lastLoginTime;
    }
	/**
     * @param lastLoginTime The lastLoginTime to set.
     */
    public void setLastLoginTime(String lastLoginTime) {
    	this.lastLoginTime = lastLoginTime;
    }
	/**
     * @return Returns the avatar.
     */
    public String getAvatar() {
    	return avatar;
    }
	/**
     * @param avatar The avatar to set.
     */
    public void setAvatar(String avatar) {
    	this.avatar = avatar;
    }
	/**
     * @return Returns the id.
     */
    public int getId() {
    	return id;
    }
	/**
     * @param id The id to set.
     */
    public void setId(int id) {
    	this.id = id;
    }
	/**
     * @return Returns the nickName.
     */
    public String getNickName() {
    	return nickName;
    }
	/**
     * @param nickName The nickName to set.
     */
    public void setNickName(String nickName) {
    	this.nickName = nickName;
    }
	/**
     * @return Returns the email.
     */
    public String getEmail() {
    	return email;
    }
	/**
     * @param email The email to set.
     */
    public void setEmail(String email) {
    	this.email = email;
    }
	public List<String> getUrls() {
		return urls;
	}
	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
	public List<Integer> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
    public boolean isFirstLogin() {
        return firstLogin;
    }
    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }
    
    public boolean getFirstGetCookieShopCart() {
        return firstGetCookieShopCart;
    }
    public void setFirstGetCookieShopCart(boolean firstGetCookieShopCart) {
        this.firstGetCookieShopCart = firstGetCookieShopCart;
    }
	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
	}
	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}
	public ShopDTO getShopDTO() {
		return shopDTO;
	}
	public void setShopDTO(ShopDTO shopDTO) {
		this.shopDTO = shopDTO;
	}
	
}
