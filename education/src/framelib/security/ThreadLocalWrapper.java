package framelib.security;

import framelib.context.ServiceContext;
import framelib.context.impl.ServiceContextImpl;
/**
 * 为了解决线程安全问题，框架中引入了java技术中的ThreadLocal技术。通过该技术可以有效的解决线程
 * 安全问题，同时也会在Struts与Spring层间建立额外的通信信道。

 * 
 * 在具体应用中，Service层除了自身的环境信息外，还需要额外的用户信息，本地化信息和Spring自身的

 * WebApplicationContext等信息。其中WebApplicationContext虽然自身是线程安全的，但是考虑
 * 到应用的WebApplicationContext(需要servletConfig信息来初始化)而非
 * ClassPathXMLApplicationContext，则需要Struts与Spring有额外的信息通信方式。

 * 由于Service层根据具体的业务需求，需要更多的了解Locale信息/用户信息以便进一步进行更为详细的
 * 操作，而本地化信息和用户信息都是线程相关的信息。

 * 
 * ThreadLocalWrapper在实现过程中采用了singleton的模式

 * 
 * @Create_by:Vince Yu
 * @Create_date:2012-5-4
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class ThreadLocalWrapper {

	/**ThreadLocalWrapper的singleton的模式所需的实例变量定义*/
	private static ThreadLocalWrapper self;
	
	/**内部静态类ThreadLocalContext的实例变量定义*/
	private static ThreadLocalContext tlc = new ThreadLocalContext(null);
	
	/**ThreadLocalWrapper的构造函数*/
	private ThreadLocalWrapper() {}
	
	/**
	 * singleton的模式组成部分，用来确保获取唯一的ThreadLocalWrapper的单体实例

	 * 本方法中没有采用DCL(double-checking lock)模式，是因为其并不能从根本上解决问题
	 * synchronized确保多线程环境下，用户获取当前类的实例唯一
	 * 
	 * @return	ThreadLocalWrapper	返回当前类的实例
	 */
	public synchronized static ThreadLocalWrapper getInstance() {
		//如果self变量为空，则初始化变量

		if(self == null)
			self = new ThreadLocalWrapper();
		
		//返回变量self
		return self;
	}

	/**
	 * ServiceContext信息的设置接口(setter)
	 * 
	 * @param context	ServiceContext
	 */
	public void setContext(ServiceContext context) {
		tlc.set(context);
	}

	/**
	 * ServiceContext信息的读取接口(getter)
	 * 
	 * @param context	ServiceContext
	 */
	public ServiceContext getContext() {
		return (ServiceContext)tlc.get();
	}

	/**
	 * 内部静态类ThreadLocalContext，继承了ThreadLocal，是在框架里面对该类的简单封装。

	 * 类内提供了两个构造方法，覆盖了initialValue方法，从而保证在类初始化的时候能够准确初
	 * 始化ServiceContextImpl
	 * 
	 * @see java.lang.ThreadLocal
	 */
	private static class ThreadLocalContext extends ThreadLocal {
		/**
		 * 覆盖父类的接口，从而保证在ThreadLocalContext初始化过后能够正确初始化
		 * ServiceContextImpl
		 * 
		 * @see java.lang.ThreadLocal#initialValue()
		 */
		public Object initialValue() {
			return new ServiceContextImpl();
		}

		/**构造函数*/
		private ThreadLocalContext() {}

		/**
		 * 构造函数

		 * 留作扩展，以便通过现有的ThreadLocalContext构造ThreadLocalContext，通常情况下参数为null即可
		 * 
		 * @param threadlocalcontext	ThreadLocalContext
		 */
		ThreadLocalContext(ThreadLocalContext threadlocalcontext) {
			this();
		}
	}
}
