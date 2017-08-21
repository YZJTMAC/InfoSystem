package framelib.utils.page;

import javax.servlet.http.HttpServletRequest;

import framelib.common.Common;

/**
 * 
 * @author GaoMingJie
 * @date 2013-07-16
 */
public class PageControl {

	/**
	 * 获取分页的当前页数
	 * 
	 * @param request
	 * @return int
	 */
	public static int getPageNum(HttpServletRequest request) {
		int pageNum = 0;
		try {
			pageNum = Integer.parseInt(request.getParameter("pagenum"));
		} catch (Exception e) {
			pageNum = 1;
		}
		return pageNum;
	}

	public static int getPageNum(HttpServletRequest request, int defaultValue) {
		String paramName = "pagenum";
		int pagenum = 0;
		try {
			pagenum = Integer.parseInt(request.getParameter(paramName));
		} catch (Exception e) {
			pagenum = defaultValue;
		}
		return pagenum;
	}

	/**
	 * 获取分页的每页显示条数
	 * 
	 * @param request
	 * @return int
	 */
	public static int getPageSize(HttpServletRequest request) {
		int pageSize = 0;
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		} catch (Exception e) {
			pageSize = Common.PNN_USER_PAGE_LIMIT;
		}
		return pageSize;
	}
}
