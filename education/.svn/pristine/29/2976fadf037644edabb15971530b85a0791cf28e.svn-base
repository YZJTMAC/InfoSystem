package framelib.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;

/**
 * Title:DataUtils
 * Description:数据拼装，数据处理工具类
 * @Create_by:Vince Yu
 * @Create_date:2012-5-8
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class DataUtils {
	/**
	 * Title:getParameter
	 * Description:得到request.getParameter
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-8
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static String getParameter(HttpServletRequest request, String sParaName, String sDefaultValue)
	{
		String paraValue = null;
		paraValue = request.getParameter(sParaName);
		if (paraValue == null || paraValue.equals("null"))
			paraValue = sDefaultValue;
		return paraValue.trim();
	}
	/**
	 * Title:getMD5Str
	 * Description:md5加密
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-8
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static String getMD5Str(String str) {  
	       MessageDigest messageDigest = null;  
	 
	       try {  
	           messageDigest = MessageDigest.getInstance("MD5");  
	 
	           messageDigest.reset();  
	 
	           messageDigest.update(str.getBytes("UTF-8"));  
	       } catch (NoSuchAlgorithmException e) {  
	           System.out.println("NoSuchAlgorithmException caught!");  
	           System.exit(-1);  
	       } catch (UnsupportedEncodingException e) {  
	           e.printStackTrace();  
	       }  
	 
	       byte[] byteArray = messageDigest.digest();  
	 
	       StringBuffer md5StrBuff = new StringBuffer();  
	 
	       for (int i = 0; i < byteArray.length; i++) {              
	           if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
	               md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));  
	           else  
	               md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
	       }  
	 
	       return md5StrBuff.toString();  
	   }  
	/**
	 * Title:toInt
	 * Description:把对象转换成int类型
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-8
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static int toInt(Object o){
		return o instanceof Number?((Number)o).intValue():NumberUtils.toInt((String)o);
	}
	
	/**
	 * Title:getAllParamsMap
	 * Description:把request 的所有请求参数放入map 对象中 
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-8
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static Map<String, Object> getAllParamsMap(HttpServletRequest request){
		
		Map<String, Object> paramMap = new HashMap<String,Object>();
		Enumeration enumb = request.getParameterNames();
		while(enumb.hasMoreElements()){
			String paraName=(String)enumb.nextElement();
			if(!"-1".equals(String.valueOf(request.getParameter(paraName)))){
				paramMap.put(paraName, request.getParameter(paraName));
			}else{
				paramMap.put(paraName, "");
			}
			
		}
		return paramMap;
	}
	
	/**
	 * Title:isIn
	 * Description:判断字符串数组中是否包含某字符串元素
	 * @param substring 某字符串
	 * @param source 源字符串数组
	 * @return 包含则返回true，否则返回false
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-8
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static boolean isIn(String substring, String[] source) {
		if (source == null || source.length == 0) {
				return false;
		}
		for (int i = 0; i < source.length; i++) {
			String aSource = source[i];
			if (aSource.equals(substring)) {
				return true;
			}
		}
			return false;
	}
	
	
	/**
	 * Title:allNotBlank
	 * Description:验证数据是否为空
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-8
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static boolean allNotBlanks(Object[] strs){
		for (int i = 0; i < strs.length; i++) {
			Object o = strs[i];
			if(o==null||(o instanceof String)&&("".equals(o)))return false;
		}return true;
	}
	
	/**
	 * Title:allNotBlank
	 * Description:验证数据是否为空
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-8
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static boolean allNotBlank(Object str){
		if(str==null||(str instanceof String)&&("".equals(str)))return false;
		return true;
	}
}
