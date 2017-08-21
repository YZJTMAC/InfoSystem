package framelib.context;

import java.util.Locale;

import org.springframework.web.context.WebApplicationContext;

import framelib.common.SessionData;

/**
 * ServiceContext接口是对Spring与Struts通信所需的上下文环境的封装组件

 * 该接口的实现类作为数据封装对象在Spring与Struts间通过线程安全的方式传递

 * 从而实现了两者间的有效通信，本接口中提供了对如下信息的简单封装：
 * 
 * 1.	WebApplicationContext	Spring所需的Web应用的上下文环境
 * 2.	Locale					用户的本地化信息设置
 * 
 */
public interface ServiceContext {

	
	/**WebApplicationContext的获取/设置方法*/
	WebApplicationContext getWebApplicationContext();
	void setWebApplicationContext(WebApplicationContext webApplicationContext);
	
	/**Locale的获取/设置方法*/
	Locale getLocale();
	void setLocale(Locale locale);
	
	public SessionData getDate();
	public void setDate(SessionData date);

	public String getUserIp();
	public void setUserIp(String userIp);
}
