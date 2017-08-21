package framelib.utils;

import net.rubyeye.xmemcached.MemcachedClient;



/**
 * Title:ClientXmemcached
 * Description:memcached客户端操作封装类
 * @Create_by:Vince Yu
 * @Create_date:2012-5-5
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class ClientXmemcached implements MemcachedClientIF {
    private MemcachedClient memcachedClient;
    private boolean cacheEnabled = true;
    
    public boolean isCacheEnabled() {
		return cacheEnabled;
	}
	public void setCacheEnabled(boolean cacheEnabled) {
		this.cacheEnabled = cacheEnabled;
	}
	
    public boolean set(String key,long exp,Object value){
        try {
            return this.memcachedClient.set(key, (int)exp/1000, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Object get(String key){
        try {
            return this.memcachedClient.get(key);
        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean add(String key,long exp,Object value){
        try {
            return this.memcachedClient.add(key, (int)(exp/1000), value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean delete(String key) {
        try {
            return this.memcachedClient.delete(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean replace(String key,int exp,Object session){
    	try {
			return this.memcachedClient.replace(key, exp, session);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    public boolean add(String key, Object value) {
        return add(key, 0, value);
    }
    
    public void setMemcachedClient(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
        this.memcachedClient.setEnableHeartBeat(false);
        //this.memcachedClient.setOpTimeout(2000);
    }

}
