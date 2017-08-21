package framelib.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.WebApplicationContext;

import framelib.context.ServiceContext;
import framelib.security.ThreadLocalWrapper;

/**
 * AbstractService时开发平台面向后续开发人员提供的Service层的基类。该类提供了如下功能：

 * 
 * 1.	为子类提供了与StrutsAction通信的线程安全的信道
 * 2.	通过信道初始化了系统的上下文环境信息
 * 2.	确保WebApplicationContext信息的正确初始化
 * 4.	确认了Service层初始化后的配置信息的完整性校验

 * 5.	确认了Service层实例销毁时占用资源的正确销毁

 * 6.	为子类方便读取Spring配置的messageSource信息提供了接口

 * 
 */
public class AbsService  implements InitializingBean, DisposableBean{
	
//	private static final Log log = LogFactory.getLog(AbstractService.class);
	
    //webApplicationContext的变量
    protected WebApplicationContext webApplicationContext ;
    protected ThreadLocalWrapper wrapper;
    
    /**
     * 构造器
     * 提供了如下功能：
     * 1.	初始化ThreadLocalWrapper变量，以便后续获取ServiceContext
     * 2.	获取ServiceContext，以便从中读取WebApplicationContext
     * 3.	初始化webApplicationContext变量，以便子类方便读取Spring管理的资源

     */
	public AbsService() {
		wrapper = ThreadLocalWrapper.getInstance();
		webApplicationContext = wrapper.getContext().getWebApplicationContext();
	}
	
	public ServiceContext getContext(){
		return wrapper.getContext();
	}
	


    /**
     * 通过messageId和上下文中的Locale信息，从Spring的messageSource中读取详细信息
     * @param msgId	String message的id值

     * @return str String
     */
    protected String getMessage(String msgId){
    	return webApplicationContext.getMessage(msgId, null, getContext().getLocale());
    }    
    
    /**
     * 通过messageId，message动态参数和上下文中的Locale信息，
     * 从Spring的messageSource中读取详细信息
     * @param msgId	String message的id值

     * @param args	String[]
     * @return	str String
     */
    protected String getMessage(String msgId, Object args[]){
    	return webApplicationContext.getMessage(msgId, args, getContext().getLocale());
    }
    
    
    
    /**
     * 2011-5-20, 下午04:33:08
     * 方法描述：获取用户的IP
     * @return
     */
    public String getUserIp(){
    	return getContext().getUserIp();
    }
    /**
     * 通过messageId，message动态参数和上下文中的Locale信息，从Spring的messageSource中读取详细信息。
     * 如果指定的信息不存在，则返回默认信息
     * @param msgId	String message的id值

     * @param args String[] 参数数组
     * @param defaultMsg String  message的默认值

     * @return str String
     */
    protected String getMessage(String msgId, Object args[], String defaultMsg){
    	return webApplicationContext.getMessage(msgId, args, defaultMsg, getContext().getLocale());
    }

	public void afterPropertiesSet() throws Exception {
	    // TODO Auto-generated method stub
	    
    }

	public void destroy() throws Exception {
	    // TODO Auto-generated method stub
	    
    }

}