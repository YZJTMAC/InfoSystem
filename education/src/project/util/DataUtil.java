package project.util;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import project.system.pojo.EduSchool;
import project.system.pojo.SysArea;
import project.system.pojo.SysDictionary;
import project.teacher.teachermanage.dto.TeacherDTO;

public class DataUtil {
	private static Log log = LogFactory.getLog(DataUtil.class);
	
	
	/**
	 * 将身份证号或者手机号中间几位用*替换
	 * @param str
	 * @return
	 */
	public static String replaceStr(String str){
		if(str.length() == 11){
			str = new StringBuffer().append(str.substring(0,3)).append("****").append(str.substring(7)).toString();
		} else if(str.length()==15){
			str = new StringBuffer().append(str.substring(0,6)).append("******").append(str.substring(12)).toString();	
		} else if(str.length() == 18){
			str = new StringBuffer().append(str.substring(0,6)).append("********").append(str.substring(14)).toString();
		}
		return str;
	}
	
	
	public static void setOk(Map<String,Object> result){
		result.put("success", true);
	}
	
	public static void setFail(Map<String,Object> result){
		result.put("success", false);
	}
	
	
	/**
	 * 根据不同类型读取Cell中的值
	 * @param cell
	 * @return
	 */
	public static String getCellValue(Cell cell){
		if(cell == null){
			log.info("cell中的内容为："+"");
			return "";
		}
		DecimalFormat df = new DecimalFormat("0"); 
		int type = cell.getCellType();
		if(type == Cell.CELL_TYPE_BOOLEAN){
			return String.valueOf(cell.getBooleanCellValue());
		}else if(type == Cell.CELL_TYPE_NUMERIC){
			double d = cell.getNumericCellValue();
			
			CellDateFormatter dateFormat = new CellDateFormatter("yyyy年MM月dd日");//带有年月日的日期格式没有用到
			if(cell.getCellStyle().getDataFormat() == 31){
				return dateFormat.format(cell.getDateCellValue());
			}else if (HSSFDateUtil.isCellDateFormatted(cell)) {
				CellDateFormatter fmt = new CellDateFormatter("yyyy/MM/dd");
				return fmt.format(cell.getDateCellValue());
			}else{
			
				return df.format(d);
			}
		}else{
			log.info("cell中的内容为："+cell.getStringCellValue());
			return cell.getStringCellValue();
		}
	}
	
	/**
	 * 验证地点信息
	 * @param areas
	 * @param name
	 * @param upLvCode
	 * @return
	 */
	public static boolean validateArea(List<SysArea> areas,String name,String upLvCode) {
		if(name != null &&name.length()>0){
			for(SysArea area:areas){
				if(area.getName().equals(name) && area.getUpLvCode() != null && area.getUpLvCode().equals(upLvCode)){
					log.info("地点验证通过");
					return true;
				}
			}
		}
		log.info("地点验证不通过");
		return false;
	}
	
	public static String getAreaCodeByName(List<SysArea> areas,String name,String areaId){
		for(SysArea area:areas){
			if(area.getName().equals(name) && area.getUpLvCode().equals(areaId)){
				return area.getCode();
			}
		}
		return null;
	}
	/**
	 * 验证身份证号
	 * @param IDCard
	 * @return
	 *	2014-4-1
	 * Devil
	 */
	public static boolean validateIDCard(List<TeacherDTO> dtos,String IDCard){
		String regex = "^(\\d{15}|\\d{17}[\\dx])$";//15位数字或者18数字加x
		if(IDCard.toLowerCase().matches(regex)){
			log.info("身份证号验证通过");
			for(TeacherDTO dto:dtos){
				if(dto.getIdNum().equals(IDCard)){
					return false;
				}
			}
			return true;
		}
		log.info("身份证号验证不通过");
		return false;
	}
	
	public static boolean validateIDCard(String IDCard){
		String regex = "^(\\d{14}[\\dx]|\\d{17}[\\dx])$";//15位数字或者18数字加x
		if(IDCard.toLowerCase().matches(regex)){
			log.info("身份证号验证通过");
			return true;
		}
		log.info("身份证号验证不通过");
		return false;
	}
	/**
	 * 验证用户名（重复与规则）
	 * @param userName
	 * @return
	 *	2014-4-1
	 * Devil
	 */
	public static int validateUserName(String userName,List<String> userNames){
		 String reg = "^[a-zA-Z]\\w{3,19}$";//4-20位，字母数字下划线，字母开头
		if(!userName.matches(reg)){
			return -1;
		}else{
			//用户名规则与重复
			for(String name:userNames){
				if(name.equals(userName)){
					log.info("用户名验证不通过");
					return -2;
				}
			}
		}
		log.info("用户名验证通过");
		return 0;
	}
	/**
	 * 验证教师编号是否有重复
	 * @param dtos
	 * @param code
	 * @return
	 *	2014-4-1
	 * Devil
	 */
	public static int validateTCode(List<String> dtos,String code){
		 String reg = "^\\d{1,14}$";//1-14位数字
			if(!code.matches(reg)){
				return -1;
			}
			else{
		for(String dto:dtos){
			if(dto!=null&&!"".equals(dto)){
			if(dto.equals(code)){				
				log.info("教师编号重复！");
				return -2;
			}
			}
		}
			}
		return 0;
	}
	/**
	 * 判断是与否
	 * @param str
	 * @return
	 *	2014-4-1
	 * Devil
	 */
	public static int yesOrNo(String str){
		int i = -1;
		if(str!=null && str.length()>0){
			if(str.equals("是")){
				i = 1;
			}else if(str.equals("否")){
				i = 0;
			}
		}
		return i;
	}	
	
	/**
	 * 判断性别
	 * @return
	 */
	public static int maleOrFemale(String sex) {
		int i = -1;
		if(sex!=null && sex.length() > 0){
			if(sex.equals("男")){
				i = 1;
			}else if(sex.equals("女")){
				i = 0;
			}
		}
		return i;
	}
	
	/**
	 * 验证字典
	 * @param politicalDic
	 * @param political
	 * @return
	 */
	public static SysDictionary validateDic(List<SysDictionary> politicalDic,String str){
		if(str != null && str.length()>0){
			for(SysDictionary dic:politicalDic){
				if(dic.getDictionaryName().equals(str)){
					return dic;
				}
			}
		}
			return null;
	}
	/**
	 * 生成随机密码
	 * @return
	 */
	public static String createPwd(){
		 String result="";  
	        for(int i=0;i<6;i++){  
	            int intVal=(int)(Math.random()*26+97);  
	            result=result+(char)intVal;  
	        }  
	        return result;
	}
	
	/**
	 * 生成随机数
	 * @return
	 */
	public static String createRandm(int length){
		String b = "";
		for (int i = 0; i < length; i++) {
			b += (int) (10 * (Math.random())) + "";
		}
		return b;
	}
	
	public static boolean validatePhone(String phone){
		String reg = "^[\\d]{11}$";
		return phone.matches(reg);
	}
	
	public static boolean  validateMail(String mail) {
		String reg = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
		return mail.matches(reg);
	}

	/**
	 * 验证成绩 
	 * @param score
	 * @return
	 */
	public static boolean validateScore(String score) {
		String reg = "^(([1-9]{1}\\d{0,9})|([0]{1}))(\\.(\\d){1,2})?$";
		return score.matches(reg);
	}
	
	/**
	 * 验证合格不合格
	 * @param status
	 * @return
	 */
	public static int validateStatus(String status){
		if(status.equals("合格")){
			return 1;
		} else if(status.equals("不合格")){
			return 0;
		} else {
			return -1;
		}
		
	}
	
	/**
	 * 验证中文
	 * @param name
	 * @return
	 */
	public static boolean validateName(String name){
		String reg = "^[\u4e00-\u9faf]+$";
		return name.matches(reg);
	}
	
	/**
	 * 验证学校名称
	 * @param names
	 * @param name
	 * @return
	 */
	public static Integer validateSchoolName(List<EduSchool> names,String name){
		
		for(EduSchool s:names){
			if(s.getSchoolName().equals(name)){
				return s.getSchoolId();
			}
		}
		return 0;
	}
	
	/**
	 * 验证地点
	 * @param areas
	 * @param name
	 * @return
	 */
	public static boolean validateExcelArea(List<SysArea> areas,String name,String code){
		for(SysArea area:areas){
			if(area.getName().equals(name) && area.getUpLvCode().equals(code)){
				return true;
			}
		}
		log.info("Excel中没有相应的数据");
		return false;
	}
	

	public static boolean validateExcelCityArea(List<SysArea> areas,String name,String code){
		for(SysArea area:areas){
			if(area.getName().equals(name)){
				return true;
			}
		}
		log.info("Excel中没有相应的数据");
		return false;
	}
	
	 /**
	 * 获得指定数值在父类数组中是否存在
	 * @param arrayParent 传进数组（父）
	 * @param sonStr 传进数
	 * @return 如果存在，返回true
	 */
     public static boolean ArrayExist(String[] arrayParent, String sonStr)
     {
         
    	 boolean exist = false;
         String[] ArrayParent = arrayParent;
         for (int i = 0; i < ArrayParent.length; i++)
         {
             if (ArrayParent[i].equals(sonStr))
             {
                 exist = true;
                 break;
             }
         }
         return exist;
         
     }
     
     /**
 	 * 获得子类数组在父类数组中是否存在
 	 * @param ArrayParent 传进数组（父）
 	 * @param ArraySon 传进数组（子）
 	 * @return 如果存在，返回true
 	 */
     public static boolean ArrayExist(String[] ArrayParent, String[] ArraySon)
     {
    	 boolean exist = false;
         for (int i = 0; i < ArrayParent.length; i++)
         {
             for (int j = 0; j < ArraySon.length; j++)
             {
                 if (ArrayParent[i].equals(ArraySon[j]))
                 {
                     exist = true;
                     break;
                 }
             }
         }
         return exist;
     }
     
     /**
      * 是否有匹配的字符串
      * @param parent
      * @param child
      * @return
      */
     public static boolean containsStr(String parent,String child){
    	 for(String s:parent.split(",")){
    		 for(String c:child.split(",")){
    			 if(c.equals(s)){
    				 return true;
    			 }
    		 }
    	 }
    	 return false;
     }
     
     /**
      * 验证小数
      * @param str
      * @return
      */
     public static boolean validateNum(String str){
// 		String reg = "^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$";
    	 String reg = "\\d+\\.?\\d+$|^\\d+";
 		return str.matches(reg);
 	}
     
     /**
      * 验证密码 
      */
     public static boolean validatePwd(String str){
    	 String reg = "^[\\@A-Za-z0-9\\!\\#\\$\\%\\^\\&\\*\\.\\~]{6,16}$";
    	 return str.matches(reg);
     }
     
     /**
      * 验证数字
      * @param str
      * @return
      */
     public static boolean validateNum2(String str){
  		String reg = "^[0-9]*$";
  		return str.matches(reg);
  	}
     
     /**
      * 验证日期格式 yyyy/MM/dd
      * @param str
      * @return
      */
     public static boolean validatedate(String str){
  		String reg = "[0-9]{4}/[0-9]{2}/[0-9]{2}";
  		return str.matches(reg);
  	}
     
     public static EduSchool validateSchool(List<EduSchool> schools,String schoolCode){
    	 if(schoolCode == null || schoolCode.length()==0){
    		 return null;
    	 }
    	 for(EduSchool s:schools){
    		 //学校编码
    		 if(s.getSchoolCode() != null && s.getSchoolCode().equals(schoolCode)){
    			 return s;
    		 }
    	 }
    	 return null;
     }
     
    
     /**
      * 验证数字字母
      * @param orgCode
      * @return
      */
    public static boolean validateOrgCode(String orgCode) {
    	String reg = "^[A-Za-z0-9]+$";
 		return orgCode.matches(reg);
 	}
     
     
    public static void main(String[] args) {
    	String a = "123456789012345";
    	if(validateIDCard(a)){
    		System.out.println(1);
    	}
    	
	}

     /**
      * 通过Map的value 得到key
      * @param value
      * @param map
      * @return
      */
     public static String getKeyByValue(Object value,Map<String,String> map){
    	 Set<String> set = map.keySet();
    	 Iterator<String> it = set.iterator();
    	 String key = null;
    	 while(it.hasNext()){
    		 key = it.next();
    		 if(map.get(key).equals(value)){
    			 return key;
    		 }
    	 }
    	 return key;
     }
    
     /**
      * 获取标题所在列
	  *
      * */
     public static int getIndex(String name, Row row) throws Exception {
    		for (int i = 0; i < row.getLastCellNum(); i++) {

    			if(DataUtil.getCellValue(row.getCell(i)).equals(name)){
    				return i;
    			}
    			
    		}
    		return 0;
    }
     
    /**
     * 将某列置空
     * */ 
    public static void setColumEmpty(Sheet sheet, int column, int startRow) {	
		//将要修改的列(除第一行外),置空
		//置空第一列
		Row tmpRow = null;
		Cell tmpCell = null;
		for(int i=0;;i++) {
			tmpRow = sheet.getRow(startRow+i);
			if (tmpRow == null) {
				break;
			}
			tmpCell = tmpRow.getCell(column);
			if(tmpCell == null) {
				break;
			}
			tmpCell.setCellValue("");
		}
    	
    }
     
}
