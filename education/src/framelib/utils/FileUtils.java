package framelib.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;



/**
 * Title:FileUtils
 * Description:
 * @Create_by:Vince Yu
 * @Create_date:2012-5-14
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class FileUtils {
	private static final Logger log = Logger.getLogger(FileUtils.class);
	//计数器，防止目录太多，产生死循环
	private static int counter = 0;
	/***
	 * 
	 * 2011-8-24, 下午05:28:32
	 * 方法描述：下载文件 支持所有文件
	 * @param filePathName 文件路径+文件名
	 * @param response
	 * @Create_by 沙创
	 */
	public static void downloadFile(String filePathName,HttpServletResponse response){
		int pos = filePathName.lastIndexOf("/");
		String filepath = filePathName.substring(0, pos+1);
		String filename = filePathName.substring(pos+1);
		downloadFile(filepath, filename, response);
	}
	
	/***
	 * 
	 * 2011-7-27, 下午03:00:46
	 * 方法描述：下载文件 支持所有文件
	 * @param filepath 文件路径
	 * @param filename 文件名
	 * @param response 
	 * @Create_by 沙创
	 */
	public static void downloadFile(String filepath,String filename,HttpServletResponse response)
	{
		OutputStream outputStream = null;
		File file = new File(filepath+filename);
		FileInputStream fis = null;
		byte[] buffer = new byte[4096];
		int bytesRead = 0;
		try {
			outputStream = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (file.exists()) {
				response.setContentType("application/data;charset=UTF-8");
				response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("gb2312"), "ISO8859-1" ));
				response.setHeader("Content-Length", ""+file.length());  
				fis = new FileInputStream(file);
				while ((bytesRead = fis.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				outputStream.flush();
				fis.close();
				outputStream.close();
				
			}else{
				outputStream.write(new String("文件已经不存在").getBytes());
			}
		} catch (Exception ee) {
		}finally{
			
		}
	}
	
	
	/**
	 * Title:getFileSizes
	 * Description:取得文件大小
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-14
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static long getFileSizes(File f) throws Exception{//取得文件大小
        long s=0;
        if (f.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(f);
           s= fis.available();
        }
        return s;
    }
	
	
	/**
	 * Title:FormetFileSize
	 * Description:转换文件大小---M
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-14
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static double FormetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        /*if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }*/
        return Double.parseDouble(df.format((double) fileS / 1048576));
    }
	
	/**
	 * 上传文件
	 * @param file
	 * @param path
	 * @return
	 */
	public static String write(MultipartFile file,String path) throws Exception{
		String name = String.valueOf(new Date().getTime());
//		boolean success = true;
		InputStream is = null;
		BufferedOutputStream fos = null;
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		String fullPath = "";
		fullPath = path+name+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length());
		File f = new File(fullPath);
		if(!f.exists()){
			try {
				is = file.getInputStream();
				fos = new BufferedOutputStream(new FileOutputStream(f));
				byte[] bits = new byte[1024];
				int c = -1;
				while((c = is.read(bits))!=-1){
					fos.write(bits,0,c);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
//				success = false;
			} catch (IOException e) {
				e.printStackTrace();
//				success = false;
			}finally{
				try {
					fos.flush();
					is.close();
					fos.close();
					log.info("文件上传完成");
				} catch (IOException e) {
					e.printStackTrace();
//					success = false;
				}
			}
		}else{
			log.error("文件已经存在！");
//			success = false;
		}
		return name;
	}
	
	
	public static String writes(MultipartFile  file,String path,String fileName) throws Exception{
		//String name = String.valueOf(new Date().getTime());
		String name = fileName;
//		boolean success = true;
		InputStream is = null;
		BufferedOutputStream fos = null;
		File dir = new File(path);
		if(!dir.exists() && !dir.isDirectory()){
			dir.mkdirs();
		}
		String fullPath = "";
		fullPath = path+fileName;
		File f = new File(fullPath);
		if(!f.exists()){
			try {
				is = file.getInputStream();
				fos = new BufferedOutputStream(new FileOutputStream(f));
				byte[] bits = new byte[1024];
				int c = -1;
				while((c = is.read(bits))!=-1){
					fos.write(bits,0,c);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
//				success = false;
			} catch (IOException e) {
				e.printStackTrace();
//				success = false;
			}finally{
				try {
					fos.flush();
					is.close();
					fos.close();
					log.info("文件上传完成");
				} catch (IOException e) {
					e.printStackTrace();
//					success = false;
				}
			}
		}else{
			log.error("文件已经存在！");
//			success = false;
		}
		return name;
	}
	
    /** 
     *  根据路径删除指定的目录或文件，无论存在与否 
     *@param sPath  要删除的目录或文件 
     *@return 删除成功返回 true，否则返回 false。 
     */  
    public static boolean deleteFolder(String sPath) {  
        boolean flag = false;  
        File file = new File(sPath);  
        // 判断目录或文件是否存在  
        if (!file.exists()) {  // 不存在返回 false  
        	log.info("文件不在在！");
            return flag;  
        } else {  
            // 判断是否为文件  
            if (file.isFile()) {  // 为文件时调用删除文件方法  
                return deleteFile(sPath);  
            } else {  // 为目录时调用删除目录方法  
                return deleteDirectory(sPath);  
            }  
        }  
    }  
	
    
    /** 
     * 删除单个文件 
     * @param   sPath    被删除文件的文件名 
     * @return 单个文件删除成功返回true，否则返回false 
     */  
    public static boolean deleteFile(String sPath) {  
        boolean flag = false;  
        File file = new File(sPath);  
        // 路径为文件且不为空则进行删除  
        if (file.isFile() && file.exists()) {  
            file.delete();  
            flag = true;  
        }  
        return flag;  
    }
    
    
    
    /** 
     * 删除目录（文件夹）以及目录下的文件 
     * @param   sPath 被删除目录的文件路径 
     * @return  目录删除成功返回true，否则返回false 
     */  
    public static boolean deleteDirectory(String sPath) {  
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
        if (!sPath.endsWith(File.separator)) {  
            sPath = sPath + File.separator;  
        }  
        File dirFile = new File(sPath);  
        //如果dir对应的文件不存在，或者不是一个目录，则退出  
        if (!dirFile.exists() || !dirFile.isDirectory()) {  
            return false;  
        }  
       boolean flag = true;  
        //删除文件夹下的所有文件(包括子目录)  
        File[] files = dirFile.listFiles();  
        for (int i = 0; i < files.length; i++) {  
            //删除子文件  
            if (files[i].isFile()) {  
                flag = deleteFile(files[i].getAbsolutePath());  
                if (!flag) break;  
            } //删除子目录  
            else {  
                flag = deleteDirectory(files[i].getAbsolutePath());  
                if (!flag) break;  
            }  
        }  
        if (!flag) return false;  
        //删除当前目录  
        if (dirFile.delete()) {  
            return true;  
        } else {  
            return false;  
        }  
    } 
    
    /**
	 * 压缩文件-由于out要在递归调用外,所以封装一个方法用来
	 * 调用ZipFiles(ZipOutputStream out,String path,File... srcFiles)
	 * 压缩文件-File
	 * @param zipFile  zip文件
	 * @param srcFiles 被压缩源文件
	 * @author Devil
	 * 
	 */
	public static void ZipFiles(File zip,File... srcFiles) throws Exception{
		counter = 0;
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip));
		ZipFiles(out,"improt_data",srcFiles);
		out.close();
		log.info("压缩完毕");
	}

	public static void ZipFiles(ZipOutputStream out,String path,File... srcFiles) throws Exception{
		FileInputStream in = null;
		try {
			counter++;
			if(counter>5){
				log.info("压缩目录层级数"+counter);
				throw new Exception("目录数量超出预期！");
			}
			path = path.replaceAll("\\*", "/");
			if(!path.endsWith("/")){
				path+="/";
			}
			byte[] buf = new byte[1024];
			for(int i=0;i<srcFiles.length;i++){
				if(srcFiles[i].exists()){
					if(srcFiles[i].isDirectory()){
						File[] files = srcFiles[i].listFiles();
						String srcPath = srcFiles[i].getName();
						srcPath = srcPath.replaceAll("\\*", "/");
						if(!srcPath.endsWith("/")){
							srcPath+="/";
						}
						out.putNextEntry(new ZipEntry(path+srcPath));
						ZipFiles(out,path+srcPath,files);
					}else{
						in = new FileInputStream(srcFiles[i]);
						log.info(path + srcFiles[i].getName());
						out.putNextEntry(new ZipEntry(path + srcFiles[i].getName()));
						int len;
						while((len=in.read(buf))>0){
							out.write(buf,0,len);
						}
						out.closeEntry();
						in.close();
					}
				}
			}
		} catch (Exception e) {
			log.error("压缩失败！");
			e.printStackTrace();
		}
	}
    
	 /**
     * 检查待上传的文件是否存在
     * */
	  public static boolean isFileExists(List<MultipartFile> files){
	    	return files!=null && files.size()>0;
	  }
	    
	 /**
     * 检查待上传的文件是否存在
     * */
    public static boolean isFileExists(MultipartFile file){
    	return file!=null && file.getSize()>0;
    }
    
    /**
     * 检查上传的文件中是否有同名的文件
     * */
    public static boolean isTheSameNameFile(List<MultipartFile> files){
		List<String> fileNamesList = new ArrayList<String>();
		Set<String> fileNameSet = new HashSet<String>();
		for (MultipartFile file : files){
			fileNamesList.add(file.getOriginalFilename());
			fileNameSet.add(file.getOriginalFilename());
		}
		if (fileNamesList.size() != fileNameSet.size()) {
			return true;
		}
		
    	return false;
    	
    }
    
    /**
     * 检查上传的文件中是否为空
     * */
    public static boolean isEmptyFile(List<MultipartFile> files){
    	for (MultipartFile file : files){
    		if(file.isEmpty())
    			return true;
    	}
    	return false;
    }
    
    
    public static void main(String[] args) {
    	String path1 = "d:/mysql";
    	File f1 = new File(path1);
    	String path2 = "d:/log";
    	File f2 = new File(path2);
		File[] files = {f1,f2};
//		ZipFiles(files, new File("d:/java.zip"));
		try {
			ZipFiles(new File("d:/edu_data.zip"), files);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		deleteFolder(path);
	}
}
