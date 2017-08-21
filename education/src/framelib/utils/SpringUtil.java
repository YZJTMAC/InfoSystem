package framelib.utils;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
/**
 *  以抽象类singleton方式定义的Spring Bean 定义获取的工具类。
 *  
 *  抽象类方式保障类不被初始化，而直接调用相应的静态方法。
 *  singleton方式保障WebApplicationContext不被初始化多次。
 *  
 *  SpringUtil中定义了两个静态方法，用户获取ApplicationContext，如下：
 *  
 *  1.	getWebApplicationContext	用于在web环境下获取WebApplicationContext
 *  2.	getFileApplicationContext	用于在独立应用程序运行环境下获取ApplicationContext
 * 
 */
public abstract class SpringUtil {

	/**定义变量**/
	private static WebApplicationContext wac = null;
	
	/**
	 * web环境下运行时获取Spring的WebApplicationContext
	 * 
	 * @param 	context ServletContext
	 * @return 	WebApplicationContext
	 */
	public synchronized static WebApplicationContext getWebApplicationContext(
			ServletContext context) {
		if (context == null) {
			return null;
		}
		if (wac == null) {
			wac = WebApplicationContextUtils
					.getRequiredWebApplicationContext(context);
		}
		return wac;
	}

	/**
	 * 在独立应用程序运行环境下获取ApplicationContext，主要用于单体测试目的
	 * 
	 * @param 	file	String
	 * @return	ApplicationContext
	 */
	public static ApplicationContext getFileApplicationContext(String file) {
		return new ClassPathXmlApplicationContext(file);
	}

}

