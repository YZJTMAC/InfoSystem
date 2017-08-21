package framelib.utils;

import javax.servlet.http.HttpServletRequest;
/**
 * Title:FormatUtil
 * Description:公用格式化方法
 * @Create_by:Vince Yu
 * @Create_date:2012-5-8
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class MainUtil {
	
	public static String getIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for"); 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("Proxy-Client-IP"); 
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("WL-Proxy-Client-IP"); 
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getRemoteAddr(); 
	    }
	    return ip;
	}
	
}
