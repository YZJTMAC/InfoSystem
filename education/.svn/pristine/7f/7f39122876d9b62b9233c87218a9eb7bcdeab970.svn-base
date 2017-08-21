package framelib.redis.impl;

import javax.servlet.http.HttpServletRequest;

import framelib.redis.IRedisCacheConfirmer;
import framelib.redis.IRedisUtil;
import framelib.redis.RedisFactory;


/**
 * 缓存确保类---模板类
 * @author kong.fanqing
 *
 */
public abstract class RedisCacheAbstractConfirmer implements IRedisCacheConfirmer {

	public Object getCacheObject(HttpServletRequest request) {
		IRedisUtil redisService = RedisFactory.getIRedisService(request);
		Object obj = null;
		if(redisService == null) {
			//不启用缓存，则直接调用getObject的返回对象
			obj = this.getObject();
		} else {
			//取得缓存key
			String redisKey = this.getRedisKey();			
			//从缓存中取得对象
			obj = redisService.getObject(redisKey);
			//如果没有取得对象
			if(obj == null) {
				//调用getObject的返回对象
				obj = this.getObject();
				if(obj != null) {
					//将对象返回缓存中
					redisService.setObject(redisKey, obj);
				}
			}
		}
		return obj;
	}

}
