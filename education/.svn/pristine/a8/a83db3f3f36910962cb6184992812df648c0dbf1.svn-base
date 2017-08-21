package project.fileupload.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.sf.json.JSONObject;
import project.fileupload.pojo.FileUpload;

public interface IFileUploadService {
	
	/**
	 * 上传单个文件
	 * @param request
	 * @param response
	 * @param type
	 * @param savePath
	 * @param projectId
	 * @param projectName
	 * @param userId
	 * @param accountName
	 * @param roleType
	 * @return
	 * @throws Exception
	 */
	JSONObject fileUploadSingleFile(MultipartFile file,HttpServletRequest request,
			HttpServletResponse response, String type,Integer projectId,
			String projectName, Integer userId,String accountName,Integer roleType,String isCompression) throws Exception;

	// 上传文件
	JSONObject fileUpload(HttpServletRequest request,
			HttpServletResponse response, String type,Integer projectId,
			String projectName, Integer userId,String accountName,Integer roleType) throws Exception;

	
	// 得到上传的文件列表
	List<FileUpload> getFileUploads(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> condition);

	Integer deleteFileById(Integer id);

	List<FileUpload> getOthersFileUploads(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> condition);

	Integer deleteFileByProjectId(Map<String, Object> condition);
	

//	// 得到保存路径
//	String getSavePath(HttpServletRequest request, String projectName,
//			String type, String userName);
//
//	// 得到保存路径
//	String getSavePath(HttpServletRequest request, String projectId,
//			String projectName, String type, String userId, String userName);

}
