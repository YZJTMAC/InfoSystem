package framelib.redis;

import javax.servlet.http.HttpServletRequest;

/**
 * redis cache数据取得确保器
 *	    该接口用于取得缓存数据时用，如果缓存中没有对应的数据，
 * @author kong.fanqing
 *
 */
public interface IRedisCacheConfirmer {

	/**
	 * 取得redis key
	 * @return
	 */
	public String getRedisKey();
	/**
	 * 当缓存中没有数据时调用
	 * @return
	 */
	public Object getObject();
	/**
	 * 取得缓存数据
	 * @return
	 */
	public Object getCacheObject(HttpServletRequest request);
}
