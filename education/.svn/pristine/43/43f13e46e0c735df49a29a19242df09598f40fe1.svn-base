package project.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelUtil {

	
	private static Log log = LogFactory.getLog(ExcelUtil.class);
	
	
	/**
	 * 复制excel文件
	 * @param srcPath 源excel文件路径
	 * @param srcFileName 源excel文件名
	 * @param fileName 复制后的excel文件名
	 * @throws Exception
	 */
	public static void copyExcel(String srcPath, String srcFileName,  String fileName) throws Exception{
		String srcFile = srcPath+"/"+srcFileName;
		String descFile = srcPath+"/"+fileName+".xls";
		
		InputStream is = null;
		OutputStream os = null;
		int len;
		byte []buff = new byte[1024];
		try {
			is = new FileInputStream(srcFile);
			os = new FileOutputStream(descFile);
			
			while((len = is.read(buff)) != -1){
				os.write(buff, 0, len);
			}
		}finally{
			is.close();
			os.close();
		}
	}
	
	
	/**
	 * 导出excel
	 */
	public static void exportExcel(List<Row> rows,String path) throws Exception{
		OutputStream os = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(path));
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			CellStyle cs = wb.createCellStyle();
			setCellStyle(cs);
			HSSFSheet sheet =  wb.getSheetAt(0);
			for(int i = 0;i<rows.size();i++){
				Row row = sheet.createRow(i+1);
				Row r = rows.get(i);
				for(int j = 0;j<r.getLastCellNum();j++){
					Cell  cell = null;
					cell = row.createCell(j);
					Cell c = r.getCell(j);
					cell.setCellValue(DataUtil.getCellValue(c));
				}
			}
			fis.close();
			os = new FileOutputStream(path);
			wb.write(os);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			fis.close();
			os.flush();
			os.close();
		}
	}
	
	/**
	 * 读取配置文件，生成导出excel路径
	 * @param supplierId
	 * @return
	 */
	public static String getExportPath(String fileName){
		Properties pts = PropertiesLoaderUtils.loadStreamProperties("/config/edu/edu.properties");
		String fullPath = pts.getProperty("export_excel_path") + File.separator +fileName + ".xls";
		return fullPath;
	}
	
	
	/**
	 * 设置单元格格式
	 * @param cs
	 */
	public static void setCellStyle(CellStyle cs){
		//居中对齐
		cs.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		//垂直对齐
		cs.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		//自动换行
		cs.setWrapText(true);
		cs.setBorderBottom((short) 1);
		cs.setBorderLeft((short) 1);
		cs.setBorderRight((short) 1);
	}
	
	
	/**
	 * 设置cell的样式与内容
	 * @param row
	 * @param index
	 * @param cs
	 * @param value
	 */
	public static void setCell(XSSFRow row,int index,CellStyle cs,String value){
		XSSFCell c = row.createCell(index);
		c.setCellValue(value);
		c.setCellStyle(cs);
	}
	
	public static void initTitle(XSSFSheet sheet,CellStyle cs){
		XSSFRow r = sheet.createRow(0);
		for(int j = 0;j<6;j++){
			XSSFCell c = r.createCell(j);
			c.setCellStyle(cs);
		}
		for(int j = 0;j<17;j++){
			XSSFCell c = r.createCell(j+5);
			c.setCellStyle(cs);
		}
	}
	
	
	
	/**
	 * 复制excel文件
	 * @param srcPath 源excel文件路径
	 * @param srcFileName 源excel文件名
	 * @param fileName 复制后的excel文件名
	 * @throws Exception
	 */
	public static String copyExcel(String srcPath, String srcFileName, String desPath, String newName) throws Exception{
		log.warn("copyExcel======start=");
		log.warn("srcPath="+srcPath);
		log.warn("srcFileName="+srcFileName);
		log.warn("desPath="+desPath);
		log.warn("newName="+newName);
		log.warn("copyExcel======end=");
		String srcFile = srcPath+File.separator+srcFileName+".xls";
		String descFile = desPath+File.separator+newName+".xls";
		File file = new File(desPath);
		if(!file.exists()){
			file.mkdir();
		}
		InputStream is = null;
		OutputStream os = null;
		int len;
		byte []buff = new byte[1024];
		try {
			log.warn("srcFile="+srcFile);
			log.warn("descFile="+descFile);
			
			is = new FileInputStream(srcFile);
			os = new FileOutputStream(descFile);
			
			while((len = is.read(buff)) != -1){
				os.write(buff, 0, len);
			}
		}finally{
			is.close();
			os.close();
		}
		return descFile;
	}
	
	
	public static void main(String[] args) {
		String srcPath = "d:";
		String srcFileName = "iZOzone.cfg";
		String desPath = "e:"+File.separator+"aaa";
		String newName = "zone.cfg";
		try {
			copyExcel(srcPath, srcFileName, desPath, newName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
