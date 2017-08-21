package framelib.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * Title:AuthInterceptor
 * Description:
 * @Create_by:Vince Yu
 * @Create_date:2012-5-4
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 2012-5-4, 下午08:37:12
	 * 方法描述：对URL的拦截处理
	 * @param request
	 * @param response
	 * @param handler
	 * @return 
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// 取得根目录所对应的绝对路径:
		String currentURL = req.getRequestURI();
		/*if(Pattern.compile("^(/178xf/user/).*(htm)$").matcher(currentURL).matches() == true){
			if(session != null && session.getAttribute(FrameCommon.PNN_SESSION) == null){
				ThreadLocalUtil.setSession((SessionData)session.getAttribute(FrameCommon.PNN_SESSION));
				response.sendRedirect(req.getContextPath() + "/initUserLogin.htm");
				return false;
			}
		}*/
		return true;
	}
}
