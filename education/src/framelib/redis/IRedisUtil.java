package framelib.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 操作redis接口
 * @author kong.fanqing
 *
 */
public interface IRedisUtil {
	

	/**存对象**/
	public String setObject(String key, Object obj);
	public String setObject(String key, Serializable value);
	public String setObject(String key, List<? extends Serializable> value);
	public String setObject(String key,Map<?, ?extends Serializable> value);
	public String setObject(String key,Set<?extends Serializable> value);
	/**取对象**/
	public Object getObject(String key);
	/**List集合**/
	public Object lindex(String key,int index);
	public Long llen(String key);
	public Object lpop(String key);
	public Object lrpop(String key);
	public Long lpush(String key,Serializable value);
	public void lpush(String key,List<? extends Serializable> value);
	public Long rpush(String key,Serializable value);
	public void rpush(String key,List<? extends Serializable> value);
	public Long lpushx(String key,Serializable value);
	public void lpushx(String key,List<? extends Serializable> value);
	public Long rpushx(String key,Serializable value);
	public void rpushx(String key,List<? extends Serializable> value);
	public List lrange(String key,int start,int end);
	public Long lrem(String key,int count,Serializable value);
	public String lset(String key,int index,Serializable value);
	public String ltrim(String key,int start,int end);
	/*忽略*/
	public String rpoplpush(String srcKey,String detKey);
	/**Set集合**/
	public Long sadd(String key,Serializable value);
	public void sadd(String key,Set<?extends Serializable> values);
	public Long scard(String key);
	public boolean sismember(String key,Serializable value);
	public Set<? extends Serializable> smembers(String key);
	public Object spop(String key);
	public Object srandmember(String key);
	public Long srem(String key,Serializable value);
	/*******Sorted set************/
	public Long zadd(String key,double score,Serializable value);
	public Long zcard(String key);
	public Long zcount(String key,double min,double max);
	public double zincrby(String key,double incrementscore,Serializable value);
	public Set<? extends Serializable> zrange(String key,int start,int end);
	public Set<? extends Serializable> zrangeByScore(String key,double min,double max);
	public Set<? extends Serializable> zrangeByScore(String key,double min,double max, int offset, int count);
	public Long zrem(String key,Serializable value);
	public Long zremrangeByRank(String key,int start ,int end);
	public Long zremrangeByScore(String key,double start,double end);
	public Set<? extends Serializable> zrevrange(String key,int start,int end);
	public Long zrank(String key,Serializable value);
	public Long zrevrank(String key,Serializable value);
	public double zscore(String key,Serializable value);
	/**********hash 表***********/
	public Long hset(String key,String field,Serializable value);
	//public void hset(String key,Map<String, ?extends Serializable> value);
	public boolean hexists(String key,String field);
	public Long hsetnx(String key,String field,Serializable value);
	public String hmset(String key,Map<String, ? extends Serializable> values);
	public Object hget(String key,String field);
	public List hmget(String key,List<String> fields);
	public Map<String,? extends Serializable> hgetAll(String key);
	public Long hdel(String key,String field);
	public Long hlen(String key);
	public Set<String> hkeys(String key);
	public List hvals(String key);
	/********************String***************************/
	public String set(String key,String value);
	public Long setnx(String key,String value);
	public String setex(String key,int seconds,String value);
	public Long append(String key,String value);
	public String get(String key);
	public String getSet(String key,String value);
	//public Long strlen(String key);
	public Long decr(String key);
	public Long decrBy(String key,long integer);
	public Long incr(String key);
	public Long incrBy(String key,long integer);
	/********************通用**************************/
	//public Pipeline pipeline(String key);
	public Long ttl(String key);
	//public Long move(String key,int dbindex);
	public String type(String key);
	public Long expire(String key,int seconds);
	public Long expireAt(String key,long timestamp);
	//public Long persist(String key);
	//public Map<String, Object> mget(List<String> keys);
	public boolean exists(String key);
	public Long del(String key);
	//public Long del(List<String> keys);
	public Set<String> keys(Integer idKey,String pattern);
	//public String flushAll();
	//public long delKeys(String pattern);
}
