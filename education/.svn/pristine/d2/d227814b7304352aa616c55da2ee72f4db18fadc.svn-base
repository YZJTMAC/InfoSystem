package project.fileupload.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Icon;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import project.fileupload.dao.FileUploadReadDao;
import project.fileupload.dao.FileUploadWriteDao;
import project.fileupload.pojo.FileType;
import project.fileupload.pojo.FileUpload;
import project.util.ApplicationProperties;
import project.util.DateUtil;
import project.util.ImageUtil;
import framelib.utils.FileUtils;
import framelib.utils.page.Constants;

public class FileUploadServiceImpl implements IFileUploadService {

	@Autowired
	@Qualifier(value = "fileUploadReadDao")
	private FileUploadReadDao fileUploadReadDao;

	@Autowired
	@Qualifier(value = "fileUploadWriteDao")
	private FileUploadWriteDao fileUploadWriteDao;

	@Override
	public JSONObject fileUploadSingleFile(MultipartFile file,HttpServletRequest request,
			HttpServletResponse response, String type, Integer projectId,
			String projectName, Integer userId, String accountName,
			Integer roleType,String isCompression) throws Exception {

		String projectPath = request.getSession().getServletContext().getRealPath("/");
		String uploadPath = ApplicationProperties.getPropertyValue("upload_file_path") + File.separator;

		Integer result = -1;
		JSONObject resultMap = new JSONObject();
	
		

		// 上传文件成功后得打的文件名
		String descPath = uploadPath + type + File.separator;
		String newFileName = FileUtils.write(file,projectPath + descPath);
		
		// 上传文件类型
		String fileType = file.getOriginalFilename().substring(
				file.getOriginalFilename().lastIndexOf("."),
				file.getOriginalFilename().length());
		String originName = file.getOriginalFilename();
		
		//图片尺寸处理
		if(isCompression != null && isCompression.equals("1")){
			try
			{
				newFileName = ImageUtil.getFixedIcon(projectPath,descPath+newFileName+fileType,newFileName,Constants.WIDTH,Constants.HEIGHT);
			}
			catch(Exception e)
			{
				System.out.println("exception : " +e);
			}
		}
		

		FileUpload fileUpload = new FileUpload();
		fileUpload.setName(originName);
		fileUpload.setRoleId(roleType);
		fileUpload.setUrl(descPath.replaceAll("\\\\", "/") + newFileName + fileType);
		fileUpload.setProjectId(projectId);
		fileUpload.setProjectName(projectName);
		fileUpload.setType(type);
		fileUpload.setUserId(userId);
		fileUpload.setUserName(accountName);
		fileUpload.setCreateDate(DateUtil.dateToLongStr(new Date()));
		result = fileUploadWriteDao.insertFile(fileUpload);
		if (result > -1) {
			resultMap.put("success", true);
			resultMap.put("info", "上传成功");
			resultMap.put("file", fileUpload);
		} else {
			resultMap.put("success", false);
			resultMap.put("info", "上传失败");
		}

		return resultMap;

	}

	@Override
	public JSONObject fileUpload(HttpServletRequest request,
			HttpServletResponse response, String type, Integer projectId,
			String projectName, Integer userId, String accountName,
			Integer roleType) throws Exception {
		String projectPath = request.getSession().getServletContext()
				.getRealPath("/");
		String uploadPath = ApplicationProperties
				.getPropertyValue("upload_file_path") + File.separator;
		Integer result = -1;
		JSONObject resultMap = new JSONObject();
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
		List<MultipartFile> files = mrequest.getFiles("file");
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("projectId", projectId);
		condition.put("type", type);
		condition.put("roleId", roleType);
		condition.put("userId", userId);
		List<FileUpload> hasUploadFiles = fileUploadReadDao
				.getFileListByCondition(condition);
		List<String> fileNames = new ArrayList<String>();
		for (FileUpload file : hasUploadFiles) {
			fileNames.add(file.getName());
		}
		if (!FileUtils.isFileExists(files)) {
			// 需要上传文件
			resultMap.put("success", false);
			resultMap.put("info", "请上传文件");
			return resultMap;
		}
		Double progress = null;
		FileUpload fileUpload = null;
		for (MultipartFile file : files) {

			// 空文件检查
			if (FileUtils.isEmptyFile(files)) {
				resultMap.put("success", false);
				resultMap.put("info", "待上传的文件列表中有空文件");
				return resultMap;
			}
			// 待上传文件有重复文件检查
			if (FileUtils.isTheSameNameFile(files)) {
				resultMap.put("success", false);
				resultMap.put("info", "待上传的文件列表中有重复文件");
				return resultMap;
			}

			for (String name : fileNames) {
				if (file.getOriginalFilename().equals(name)) {
					resultMap.put("success", false);
					resultMap.put("info", "您已经上传过该文件");
					return resultMap;
				}
				
				//是否存在后缀名
				int fileExt = file.getOriginalFilename().lastIndexOf(".");
				if (fileExt < 0) {
					resultMap.put("success", false);
					resultMap.put("info", "文件扩展名不正确");
					return resultMap;
				}
			}

			// 上传文件成功后得打的文件名
			String newFileName = FileUtils.write(file,projectPath + uploadPath + File.separator + type + File.separator);
			// 上传文件类型

			String fileType = file.getOriginalFilename().substring(
					file.getOriginalFilename().lastIndexOf("."),
					file.getOriginalFilename().length());
			String originName = file.getOriginalFilename();
			fileUpload = new FileUpload();
			fileUpload.setName(originName);
			fileUpload.setRoleId(roleType);
			fileUpload.setUrl(uploadPath.replaceAll("\\\\", "/") + type + "/" + newFileName
					+ fileType);
			fileUpload.setProjectId(projectId);
			fileUpload.setProjectName(projectName);
			fileUpload.setType(type);
			fileUpload.setUserId(userId);
			fileUpload.setUserName(accountName);
			fileUpload.setCreateDate(DateUtil.dateToLongStr(new Date()));
			result = fileUploadWriteDao.insertFile(fileUpload);
			progress = (Double)request.getSession().getAttribute("progress");
		}
		if (result > -1) {
			resultMap.put("progress", progress);
			resultMap.put("fileNum", hasUploadFiles.size());
			resultMap.put("file", fileUpload);
			resultMap.put("success", true);
			resultMap.put("info", "上传成功");
		} else {
			resultMap.put("success", false);
			resultMap.put("info", "上传失败");
		}

		return resultMap;

	}

	@Override
	public List<FileUpload> getFileUploads(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> condition) {
		return fileUploadReadDao.getFileListByCondition(condition);
	}

	@Override
	public Integer deleteFileById(Integer id) {
		return fileUploadWriteDao.deleteFileById(id);
	}

	public List<FileUpload> getOthersFileUploads(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return fileUploadReadDao.getOthersFileUploads(condition);
	}

	@Override
	public Integer deleteFileByProjectId(Map<String, Object> condition) {
		if(condition.size() == 0){
			return -1;
		}
		return fileUploadWriteDao.deleteFileByProjectId(condition);
	}

}
