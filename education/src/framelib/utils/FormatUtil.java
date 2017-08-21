package framelib.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static org.apache.commons.lang.StringUtils.EMPTY;
import static org.apache.commons.lang.StringUtils.isEmpty;
import static org.apache.commons.lang.math.NumberUtils.*;
/**
 * Title:FormatUtil
 * Description:公用格式化方法
 * @Create_by:Vince Yu
 * @Create_date:2012-5-8
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class FormatUtil {
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * Title:StringToDate
	 * Description:将页面传回的日期字符串转换成java.util.date
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-8
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static Date StringToDate(String str) throws ParseException {
		if (isEmpty(str)) {
			return null;
		}
		try {
			return format.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Title:DateToString
	 * Description:Date类型转String
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-8
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static String DateToString(Date date) {
		return date==null?EMPTY:format.format(date);
	}
	/**
	 * Title:deCode
	 * Description:对输入进来的参数进行decode操作
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-8
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static String deCode(String str){
		if(isEmpty(str)){
			return EMPTY;
		}else {
			try {
				return new String(str.getBytes("GBK"),"ASCII");
			} catch (Exception e) {
				return "\u5b57\u7b26\u4e32\u8f6c\u7801\u5f02\u5e38";
			}
		}
	}
	
	/**
	 * Title:formatValueMap
	 * Description:
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-8
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static Map<String, String> formatValueMap(Map<String, String[]> valueMap){
		Map<String, String> map = new HashMap<String, String>();
		Object[] os = valueMap.keySet().toArray();
		for (int i = 0; i < os.length; i++) {
			String key = (String)os[i];
			if(valueMap.get(key)!=null&&valueMap.get(key).length!=INTEGER_ZERO){
				map.put(key, valueMap.get(key)[INTEGER_ZERO]);
			}
		}
		return map;
	}
	
	/**
	 * Title:javaScriptEscape
	 * Description:将字符串中的特殊字符进行转义
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-8
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static String javaScriptEscape(String input) {
		  if (input == null) {
		   return input;
		  }
		  StringBuffer filtered = new StringBuffer(input.length());
		  char prevChar = '\u0000';
		  char c;
		  for (int i = 0; i < input.length(); i++) {
		   c = input.charAt(i);
		   if (c == '"') {
		    filtered.append("\\\"");
		   }
		   else if (c == '\'') {
		    filtered.append("\\'");
		   }
		   else if (c == '\\') {
		    filtered.append("\\\\");
		   }
		   else if (c == '\t') {
		    filtered.append("\\t");
		   }
		   else if (c == '\n') {
		    if (prevChar != '\r') {
		     filtered.append("\\n");
		    }
		   }
		   else if (c == '\r') {
		    filtered.append("\\n");
		   } else if (c == '\f') {
		                filtered.append("\\f");
		  } else if (c == '/') {
		                filtered.append("\\/");
		            }
		   else {
		    filtered.append(c);
		   }
		   prevChar = c;
		  }
		  return filtered.toString();
		 }


}
