package framelib.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import project.system.service.ISysService;
 
/**
 * Title:AppContextFactory
 * Description:启动spring的factory工厂
 * @Create_by:guoxz
 * @Create_date:2013-12-7
 * @Last_Edit_By:
 * @Edit_Description
 * @version:BMP 1.0
 *
 */
public class AppContextFactory {  

	public static ClassPathXmlApplicationContext ctx;
	
	public static ApplicationContext getApplicationContext() {
		System.out.println("加载配置文件");
		if (ctx == null) {
	//		 ApplicationContext app = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
		//	ctx = new ClassPathXmlApplicationContext(new String[] {"classpath*:config\\spring\\applicationContext.xml"});
			ctx = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
		}
		if(ctx != null){
			System.out.println("-----------------加载结束");
			
		}else{
			System.out.println("----------------加载出错");
		}
		return ctx;
	}
	
	public static Object getBean(String name) {
		if(ctx == null) {
			getApplicationContext();
		}
		return ctx.getBean(name);
	}
	
	public static void main(String[] args) {
		ISysService sysService = (ISysService) AppContextFactory.getBean("sysService");
		System.out.println(sysService);
	}
}
 
