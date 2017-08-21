package framelib.tag;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Title:ToolbarTag Description:自定义标签，主要用作权限控制
 * 
 * @Create_by:guoxz
 * @Create_date:2013-10-21
 * @Last_Edit_By:
 * @Edit_Description
 * @version:BMP 1.0
 * 
 */
public class ToolbarTag extends TagSupport {
	private String uri; // 功能的uri
	private String alias; // 功能别名

	@SuppressWarnings("unchecked")
	public int doStartTag() {
		// 获取session 对象
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		Object obj = request.getSession().getAttribute("roleUrl");
		if (obj != null) {
			Set<String> uris = (Set<String>) obj;

			// 判断标签里的uri 在session 知否存在
			if (uris.contains(uri)) {
				return EVAL_PAGE; // 可以输出body里的代码
			}

		}

		return SKIP_BODY; // 跳过body,body部分不会显示
	}

	/**
	 * @return Returns the uri.
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri
	 *            The uri to set.
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return Returns the alias.
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias
	 *            The alias to set.
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
}
