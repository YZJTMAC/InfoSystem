package framelib.context.impl;

import java.util.Locale;

import org.springframework.web.context.WebApplicationContext;

import framelib.common.SessionData;
import framelib.context.ServiceContext;
/**
 * ServiceContextImpl是对Spring与Struts通信所需的上下文环境的封装组件ServiceContext的具体实现

 * 该实现类作为数据封装对象在Spring与Struts间通过线程安全的方式传递从而实现了两者间的有效通信，本接口
 * 中提供了对如下信息的简单封装：
 * 
 * 2.	WebApplicationContext	Spring所需的Web应用的上下文环境
 * 3.	Locale					用户的本地化信息设置
 * 
 * 变量以实例变量的方式定义，类对象通过线程安全的方式传递，从而实现两层间的有效通信
 * 
 * @see 
 * 
 */
public class ServiceContextImpl implements ServiceContext {
	/**Spring所需的Web应用的上下文环境WebApplicationContext的实例变量定义*/
	private WebApplicationContext webApplicationContext = null;
	/**用户的本地化信息设置Locale的实例变量定义*/
	private Locale locale = null;
	/**用户所有信息集合*/
	private SessionData date = null;
	/**用户IP地址*/
	private String UserIp = null;
	/**Spring所需的Web应用的上下文环境WebApplicationContext的获取方法(getter)*/
	public WebApplicationContext getWebApplicationContext() {
		return webApplicationContext;
	}
	/**Spring所需的Web应用的上下文环境WebApplicationContext的设置方法(setter)*/
	public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
		this.webApplicationContext = webApplicationContext;
	}
	/**户的本地化信息设置Locale的获取方法(getter)*/
	public Locale getLocale() {
		return locale;
	}
	/**户的本地化信息设置Locale的设置方法(setter)*/
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	/**
	 * @return Returns the date.
	 */
	public SessionData getDate() {
		return date;
	}
	/**
	 * @param date The date to set.
	 */
	public void setDate(SessionData date) {
		this.date = date;
	}
	/**
	 * @return Returns the userIp.
	 */
	public String getUserIp() {
		return UserIp;
	}
	/**
	 * @param userIp The userIp to set.
	 */
	public void setUserIp(String userIp) {
		UserIp = userIp;
	}
}
