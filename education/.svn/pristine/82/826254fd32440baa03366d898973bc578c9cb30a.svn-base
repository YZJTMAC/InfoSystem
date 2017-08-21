package framelib.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import project.person.pojo.EduUserActivty;
import project.util.ApplicationProperties;

public class SessionOptionInterceptor extends HandlerInterceptorAdapter {

	private static final Logger log = Logger.getLogger(SessionOptionInterceptor.class);
	
	private String eduPath = ApplicationProperties.getPropertyValue("eduHostPath").toString();
	
	private static final int SESSION_LOGIN_OUT_STATUS = 900;
	private static final int SYS_ERROR_STATUS = 800;
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		StringBuffer uri = request.getRequestURL();
		
		// 页面 500 异常请求转发
		if(ex != null) {
			log.error(ex.getCause());
			ex.printStackTrace();
			if(uri.indexOf(".htm") > 0) {
				try{
					response.sendRedirect(eduPath + "/page/error/500.htm");
				}catch(Exception e){
					log.error(e.getCause());
				}
				log.info("500错误htm 请求 跳转首页 uri：" + uri);
			}
			
			// ajax 请求拦截 跳转
			if(uri.indexOf(".do") > 0) {
				response.setStatus(500);
				response.getWriter().append(eduPath + "/page/error/500.htm");
				log.info("500错误ajax 请求 跳转首页 uri：" + uri);
			}
		}
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		StringBuffer uri = request.getRequestURL();
		if(uri.indexOf("/login") > 0 ) {
			return super.preHandle(request, response, handler);
		}
		if(uri.indexOf("/register/") > 0 ) {
			return super.preHandle(request, response, handler);
		}
		if(uri.indexOf("/config/") > 0 ) {
			return super.preHandle(request, response, handler);
		}
		
		if(uri.indexOf(".htm") > 0) {
			if(!isLogin(request)) {
				response.sendRedirect(eduPath );
				log.info("前用户未登陆，htm 请求 跳转首页 uri：" + uri);
				return false;
			} else {
				request.setAttribute("click", request.getParameter("click"));
			}
		}
		
		// ajax 请求拦截 跳转
		if(uri.indexOf(".do") > 0) {
			if(!isLogin(request)) {
				response.setStatus(SESSION_LOGIN_OUT_STATUS);
				log.info("前用户未登陆，ajax 请求 跳转首页 uri：" + uri);
				response.getWriter().append(eduPath);
				return false;
			}
		}
		if(uri.indexOf(".json") > 0) {
				return true;
		}

	 	if(uri.indexOf("/setPersonPsd") < 0 && uri.indexOf("/personPsdPage") < 0  && uri.indexOf("/getMessageCounts") < 0 ) {
			if(!isPassword(request)){
				log.warn("第一次登陆，跳转到修改密码页面：" + uri);
				response.sendRedirect(eduPath + "/person/personPsdPage.htm?click=1");
				return false;
			}
		} 
		return super.preHandle(request, response, handler);
	}
	
	private boolean isLogin(HttpServletRequest request) {
		EduUserActivty obj = (EduUserActivty) request.getSession().getAttribute("userinfo");
		/**
		 * 当页面发起的请求来自福建研修平台,
		 * 请求路径为/education/person/systemLogin.do 则不拦截
		 * 该判断只对福建研修平台发起的请求进行判断
		 * person/systemLogin.do是福建研修平台的请求
		 * person/QRCode.do打印证书二维码扫一扫的请求 
		 */
		if(request.getRequestURI().equals(request.getContextPath()+"/person/systemLogin.do") || request.getRequestURI().equals(request.getContextPath()+"/person/QRCode.do")){
			return true;
		}
		if(request.getRequestURI().equals(request.getContextPath()+"/sys/queryFJTeacherWorkInfo.do")){
			return true;
		}
		if(obj ==null) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * 判断密码是不是还没有修改:true:没有修改
	 * @param request
	 * @return
	 */
	private boolean isPassword(HttpServletRequest request) {
		EduUserActivty obj = (EduUserActivty) request.getSession().getAttribute("userinfo");
		/**
		 * 当页面发起的请求来自福建研修平台,
		 * 请求路径为/education/person/systemLogin.do 则不拦截
		 * 该判断只对福建研修平台发起的请求进行判断
		 * person/systemLogin.do是福建研修平台的请求
		 * person/QRCode.do打印证书二维码扫一扫的请求
		 */
		if(request.getRequestURI().equals(request.getContextPath()+"/person/systemLogin.do") || request.getRequestURI().equals(request.getContextPath()+"/person/QRCode.do")){
			return true;
		} 
		if(request.getRequestURI().equals(request.getContextPath()+"/sys/queryFJTeacherWorkInfo.do")){
			return true;
		}
		if(obj.getIsPassword()==null || obj.getIsPassword() ==0) {
			return false;
		} else {
			return true;
		}
	}

}
