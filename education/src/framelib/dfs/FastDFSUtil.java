package framelib.dfs;

import java.io.InputStream;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.UploadStream;

public class FastDFSUtil {
	/**
	 * 删除服务器上的指定文件
	 * @param group_name  组名 例：group1
	 * @param remote_filename  文件名 例：M00/00/00/wKgKeVJyEz_5AjE3AAfttt2_4PQ968.jpg
	 * @return
	 * @throws Exception
	 */
	public static int deleteFile(String groupName,String remoteFileName) throws Exception{
		StorageClient storageClient = FastDFSFactory.getInstance();
		return storageClient.delete_file(groupName, remoteFileName);
	}
	/**
	 * 上传文件到服务器
	 * @param file_buff 文件buffer数组
	 * @param type  上传文件类型
	 * @param meta_list  属性数组 例：meta_list[0]=new NameValuePair("width", "120");meta_list[1] = new NameValuePair("heigth", "120");
	 * @return
	 * @throws Exception
	 */
	public static String[] uploadFile(byte[] file_buff,String type,NameValuePair[] meta_list) throws Exception{
		StorageClient storageClient = FastDFSFactory.getInstance();
		return storageClient.upload_file(file_buff, "jpg", meta_list);
	}
	/**
	 * 
	 * Description:从输入流中获取数据上传到服务器
	 * @Create_by:songxianjia
	 * @Create_date:2013-11-11
	 * @param inputStream  输入流
	 * @param fileSize     文件size
	 * @param extName      文件扩展名
	 * @param meta_list    元数据,可为空
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:baoogu 1.0
	 */
	public static String[] uploadFromStream(InputStream inputStream,long fileSize,String extName,NameValuePair[] meta_list)throws Exception{
		StorageClient storageClient = FastDFSFactory.getInstance();
		UploadStream callback = new UploadStream(inputStream,fileSize);
		return storageClient.upload_file(null, fileSize, callback, extName, meta_list);
	}
	/**
	 * 
	 * Description:从本地文件获取数据上传到服务器
	 * @Create_by:songxianjia
	 * @Create_date:2013-11-12
	 * @param fileName 文件名,包含路径
	 * @param extName  文件扩展名
	 * @param meta_list元数据,可为空
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:baoogu 1.0
	 */
	public static String[] uploadFromFile(String fileName,String extName,NameValuePair [] meta_list)throws Exception{
		StorageClient storageClient = FastDFSFactory.getInstance();
		return storageClient.upload_file(fileName, extName, meta_list);
	}
	/**
	 * 下载文件
	 * @param groupName
	 * @param remoteFileName
	 * @return
	 * @throws Exception
	 */
	public static byte[] downloadFile(String groupName,String remoteFileName)throws Exception{
		StorageClient storageClient = FastDFSFactory.getInstance();
		return storageClient.download_file(groupName, remoteFileName);
	}
	
	public static void main(String []args) throws Exception{
		String [] results = uploadFromFile("E:/deskTop/1.jpg","png",null);
		System.out.println("http:192.168.10.121:80/"+results[0]+"/"+results[1]);
	}
}
