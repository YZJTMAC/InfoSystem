package framelib.redis;

import javax.servlet.http.HttpServletRequest;

import framelib.utils.SpringUtil;

/**
 * 
 * @author kong.fanqing
 *
 */
public class RedisFactory {
	
	/**
	 * 返回redisService，如果redis没有启用，则返回null
	 * @return
	 */
	public static IRedisUtil getIRedisService(HttpServletRequest request){
		return (IRedisUtil)SpringUtil.getWebApplicationContext(request.getSession().getServletContext()).getBean("redisUtil");
	}
	
}
