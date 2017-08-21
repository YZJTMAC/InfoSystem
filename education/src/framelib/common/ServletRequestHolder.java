package framelib.common;

import javax.servlet.http.HttpServletRequest;
/**
 *Title:ServletRequestHolder
 *Description:关联request与线程，提供存取方法
 *@Create_by:songxianjia
 *@Create_date:2013-8-16
 *@Last_Edit_By:
 *@Edit_Description
 *@version:178xf 1.0
 */
public class ServletRequestHolder {
	private static final ThreadLocal<HttpServletRequest> requests = new ThreadLocal<HttpServletRequest>();
    /**
     * 绑定request到线程
     * @param request
     */
	public static void setRequest(HttpServletRequest request) {
		requests.set(request);
	}
    /**
     * 删除线程绑定的request
     * @param request
     */
	public static void reset(HttpServletRequest request) {
		requests.remove();
	}
    /**
     * 获取当前线程绑定的request
     * @return
     */
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) requests.get();
	}
}
