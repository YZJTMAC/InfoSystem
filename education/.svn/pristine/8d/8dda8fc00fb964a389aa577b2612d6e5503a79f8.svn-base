package framelib.utils;


import framelib.common.SessionData;


/**
 * Title:ThreadLocalUtil
 * Description:
 * @Create_by:Vince Yu
 * @Create_date:2012-5-4
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class ThreadLocalUtil{
	public static final ThreadLocal context = new ThreadLocal(); 
	
	  /**
	 * Title:
	 * Description:获取session
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-4
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static SessionData getSessionData() { 
		  SessionData s = (SessionData)context.get(); 
	       return s; 
	 } 
   
  
    /**
     * Title:
     * Description: 加载session
     * @Create_by:Vince Yu
     * @Create_date:2012-5-4
     * @Last_Edit_By:
     * @Edit_Description
     * @Create_Version:178xf 1.0
     */
    public static void  setSession(SessionData session) { 
    	  context.set(session);   
    }   

}
