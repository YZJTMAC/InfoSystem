package framelib.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import framelib.common.Common;
import framelib.common.SessionData;
import framelib.service.SessionService;

/**
 * Title:SessionUtil Description:
 * 
 * @Create_by:Vince Yu
 * @Create_date:2012-5-7
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class SessionUtil {

	/**
	 * Title:获取session Description:
	 * 
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-7
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}

	/**
	 * Title:从memcached中获取SessionDate Description:
	 * 
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-7
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static SessionData getSessionDataByMC(HttpServletRequest request,
	        String uid) {
		MemcachedClientIF mc = (MemcachedClientIF) (SpringUtil
		        .getWebApplicationContext(request.getSession()
		                .getServletContext()).getBean("clientMemcached"));
		return (SessionData) mc.get(uid);
	}

	/**
	 * 获取sessiondata数据
	 * 
	 * @param request
	 * @return
	 */
	public static SessionData getSessionData(HttpServletRequest request,String sid) {
		/*String sid = (String) request.getSession().getAttribute(
		        Common.USER_SESSION);
		if (sid == null || "".equals(sid)) {
			return null;
		}*/
		
		Map map = SessionService.getInstance(request.getSession().getServletContext()).getSession(sid);
		if (map == null) {
			return null;
		}
		SessionService.getInstance(request.getSession().getServletContext()).saveSession(sid, map);
		return (SessionData) map.get("sessionData");
	}
	
	/**
	 * 获取sessiondata数据
	 * 
	 * @param request
	 * @return
	 */
	public static SessionData getSessionData(HttpServletRequest request) {
		String sid = (String) request.getSession().getAttribute(
		        Common.USER_SESSION);
		if (sid == null || "".equals(sid)) {
			return null;
		}
		Map map = SessionService.getInstance(
		        request.getSession().getServletContext()).getSession(sid);
		if (map == null) {
			return null;
		}
		SessionService.getInstance(
		        request.getSession().getServletContext()).saveSession(sid, map);
		return (SessionData) map.get("sessionData");
	}
	
	/**
	 * 获取sessiondata数据
	 * 
	 * @param request
	 * @return
	 */
	public static SessionData getSessionDataBySid(HttpServletRequest request,String sid) {
		//String sid = (String) request.getSession().getAttribute(sid);
		/*if (sid == null || "".equals(sid)) {
			return null;
		}*/
		Map map = SessionService.getInstance(
		        request.getSession().getServletContext()).getSession(sid);
		if (map == null) {
			return null;
		}
		return (SessionData) map.get("sessionData");
	}
	
}
