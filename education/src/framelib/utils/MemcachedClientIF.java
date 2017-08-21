package framelib.utils;


/**
 * Title:MemcachedClientIF
 * Description: memcached操作接口
 * @Create_by:Vince Yu
 * @Create_date:2012-5-5
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public interface MemcachedClientIF {
	public boolean set(String key,long exp,Object value);
	
	public Object get(String key);
	
	public boolean delete(String key);
	
	
	boolean add(String key,Object value);
	
	boolean add(String key,long exp,Object value);
	
	public boolean isCacheEnabled();
	
	public boolean replace(String key,int exp,Object session);
	
}
