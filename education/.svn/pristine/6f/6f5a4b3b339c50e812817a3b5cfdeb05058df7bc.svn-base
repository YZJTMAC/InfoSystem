package project.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.views.AbstractView;

import framelib.controller.AbsController;

//性能监控
public class MonitorInterceptor extends AbsController implements HandlerInterceptor{

	private static Log log = LogFactory.getLog(MonitorInterceptor.class);
	//使用线程池 
	private NamedThreadLocal<Long> threadLocal = new NamedThreadLocal<Long>("MonitorExecute");
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		long beginTime = System.currentTimeMillis();	
		threadLocal.set(beginTime);
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - threadLocal.get();
		log.debug("accessed user: " + getAccount(request));
		log.debug("current request " + String.format("%s execute cost %d ms." , "【 "+request.getRequestURI() +" 】", executeTime));
	}
	
}
