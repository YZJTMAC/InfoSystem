package framelib.common;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 *Title:SimpleRequestListener
 *Description:监听HttpServletRequest的创建及销毁
 *@Create_by:songxianjia
 *@Create_date:2013-8-16
 *@Last_Edit_By:
 *@Edit_Description
 *@version:178xf 1.0
 */
public class SimpleRequestListener implements ServletRequestListener {
    
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		ServletRequestHolder.reset(request);
	}

	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		ServletRequestHolder.setRequest(request);
	}

}
