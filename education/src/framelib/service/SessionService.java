package framelib.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import framelib.common.Common;

import framelib.common.ServletRequestHolder;
import framelib.common.SessionData;
import framelib.utils.MemcachedClientIF;
import framelib.utils.SpringUtil;

public class SessionService {

	private static SessionService instance = null;

	/*private SockIOPool pool = null;

	private String poolName = "sidsock";*/
    
	private ServletContext servletContext;
	
	public static synchronized SessionService getInstance(ServletContext servletContext) {
		if (instance == null) {
			instance = new SessionService(servletContext);
		}
		return instance;
	}

	private SessionService(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public Map getSession(String id) {
		
	//	removeSession(id);
		MemcachedClientIF mc = this.getMemCachedClient();

		Map session = (Map) mc.get(id);
		if (session == null) {
			session = new HashMap();
			mc.add(id, session);
		}
		return session;
	}

	public void saveSession(String id, Map session) {
		MemcachedClientIF mc = this.getMemCachedClient();
		/**
		 * 修改时间：2013.12.14 16:00
		 * 修改原因：方便测试用，session有效期改为10分钟过期时间
		 */
		mc.replace(id, 30*60,session);//过期时间修改为30分钟
	}
    
	public void removeSession(String id) {
		MemcachedClientIF mc = this.getMemCachedClient();
		mc.delete(id);
	}

	private MemcachedClientIF getMemCachedClient() {
		MemcachedClientIF mc = (MemcachedClientIF)(SpringUtil.getWebApplicationContext(
				servletContext).getBean("clientMemcached"));
		return mc;
	}

	/*protected void finalize() {
		if (this.pool != null) {
			this.pool.shutDown();
		}
	}*/
	
	public static SessionData getSessionData(String sid){
	    HttpServletRequest request = ServletRequestHolder.getRequest();
	    Map session = SessionService.getInstance(request.getSession().getServletContext()).getSession(sid );
        return (SessionData) session.get("sessionData");
	}
	
   public static void setSessionData(String sid,SessionData sessionData){
        HttpServletRequest request = ServletRequestHolder.getRequest();
        SessionService instance2 = SessionService.getInstance(request.getSession().getServletContext());
        Map session = instance2.getSession(sid );
        session.put("sessionData",sessionData);
        instance2.saveSession(sid, session);
   }
   
   public static String getSessionDataKey(){
       HttpServletRequest request = ServletRequestHolder.getRequest();
       return (String) request.getSession().getAttribute(Common.USER_SESSION);
   }

}
