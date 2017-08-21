package framelib.exception;

import framelib.common.FrameCommon;
import framelib.utils.PropReader;



/**
 * SystemException继承了java.lang.RuntimeException，标志着该类并非强制后续开发人员来处理的异常

 * System更多的意味着框架的概念，而非传统的业务逻辑概念，所以本类更多是面向框架角度来封装异常行为

 * 
 * 类设计的初衷是为了满足以下两点需求：
 * 与Struts的ActionMessage能够方便的整合

 * 能够全面的保留系统产生异常的所有信息，以便用户调试程序　
 * 
 * 故此，我们在类中引入了两个常用的实例变量：

 * ActionMessage actionError
 * Throwable throwable
 * 
 * 
 */
public class SystemException extends RuntimeException {
	/**为能够全面的保留系统产生异常的所有信息，以便用户调试程序而引入的实例变量*/
	private Throwable throwable;
	
	
	/**为抛出的错误信息中传入参数
	 * @param msgId 参数ID
	 * @param obj 替换文字集合
	 * @return 抛出的错误信息
	 */
	private static String makeError(String msgId , Object[] obj){
		String msgValue = "";
		try {
			msgValue = new PropReader(FrameCommon.PNN_CONFIG_EXCEPTION).getString(msgId);
			String[] values = msgValue.split("\\{");
			for(int i = 0; i < values.length; i++){
				msgValue = msgValue.replace("{" + String.valueOf(i) + "}", obj.length-1<i?"":obj[i].toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msgValue;
	}
	
	/**
	 * 构造函数

	 * 
	 * @param msgId String	资源文件中的信息编号
	 * @throws Exception 
	 */
	public SystemException(String msgId) throws Exception {
		//调用父类的构造函数
		super(new PropReader(FrameCommon.PNN_CONFIG_EXCEPTION).getString(msgId));
	}
	

	/**
	 * 构造函数

	 * 
	 * @param msgId		String		资源文件中的信息编号
	 * @param arguments	Object[]	资源文件中的信息所需的额外参数
	 * @throws Exception 

	 */
	public SystemException(String msgId, Object arguments[]) throws Exception {
		//调用父类的构造函数

		super(makeError(msgId, arguments));
		
	}
	/**
	 * 构造函数

	 * 
	 * @param msgId		String		资源文件中的信息编号
	 * @param throwable	Throwable	抛出的异常信息

	 */
	public SystemException(String msgId, Throwable throwable) {
		//调用父类的构造函数

		super(msgId);
		this.throwable = throwable;
	}

	/**
	 * 构造函数

	 * 根据输入参数，初始化类实例变量

	 * 
	 * @param msgId			String		资源文件中的信息编号
	 * @param arguments		Object[]	资源文件中的信息所需的额外参数

	 * @param throwable		Throwable	抛出的异常信息

	 */
	public SystemException(String msgId, Object arguments[], Throwable throwable) {
		super(makeError(msgId, arguments));
		this.throwable = throwable;
	}


	/**
	 * 返回异常对象
	 * 
	 * @return	Throwable	异常对象
	 */
	public Throwable getThrowable() {
		return throwable;
	}

	/**
	 * 设置异常对象
	 * 
	 * @param throwable	Throwable	异常对象
	 */
	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
	
	
}
