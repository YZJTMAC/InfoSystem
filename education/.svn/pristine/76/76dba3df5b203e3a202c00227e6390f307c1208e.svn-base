package project.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import project.fileupload.pojo.FileUpload;
import project.fileupload.service.IFileUploadService;
import project.util.ApplicationProperties;
import project.util.ResponseUtil;
import framelib.controller.AbsController;
import framelib.utils.FileUtils;

/**
 * 培训总结文件上传
 * 
 * @author liuyiyou
 * 
 */
@Controller
@RequestMapping("fileupload")
public class FileUploadController extends AbsController {

	private static final Logger log = Logger
			.getLogger(FileUploadController.class);

	@Autowired
	@Qualifier("fileUploadService")
	IFileUploadService fileUploadService;

	@RequestMapping("/saveFiles.do")
	public void savaOrUpdateSummary(HttpServletRequest request,
			HttpServletResponse response, Integer projectId,
			String projectName, String type) throws Exception {
		Integer roleType = getRoleId(request);
		String accountName = getAccount(request);
		Integer userId = getAccountId(request);
		JSONObject reseult = fileUploadService.fileUpload(request, response,
				type, projectId, projectName, userId, accountName, roleType);
		ResponseUtil.renderText(response, reseult.toString());
		return;
	}

	/**
	 * 上传证书模板背景
	 * 
	 * @param request
	 * @param response
	 * @param projectId
	 * @param projectName
	 * @param type
	 * @throws Exception
	 */
	@RequestMapping("/saveSingleFile.do")
	public void saveSingleFile(HttpServletRequest request,
			HttpServletResponse response, Integer projectId,
			String projectName, String type,String isCompression) throws Exception {
		String accountName = getAccount(request);
		Integer roleType = getRoleId(request);
		Integer userId = getAccountId(request);
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
		MultipartFile file = mrequest.getFile("certificateFile");
		JSONObject reseult = fileUploadService.fileUploadSingleFile(file,request,
				response, type, projectId, projectName, userId, accountName,
				roleType,isCompression);
		ResponseUtil.renderText(response, reseult.toString());
		return;
	}

	/**
	 * 上传二维码背景
	 * 
	 * @param request
	 * @param response
	 * @param projectId
	 * @param projectName
	 * @param type
	 * @throws Exception
	 */
	@RequestMapping("/saveQRCodeFile.do")
	public void saveQRCodeFile(HttpServletRequest request,
			HttpServletResponse response, Integer projectId,
			String projectName, String type) throws Exception {
		String accountName = getAccount(request);
		Integer roleType = getRoleId(request);
		Integer userId = getAccountId(request);
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
		MultipartFile file = mrequest.getFile("QRCodeFile");
		JSONObject reseult = fileUploadService.fileUploadSingleFile(file,request,
				response, type, projectId, projectName, userId, accountName,
				roleType,null);
		ResponseUtil.renderText(response, reseult.toString());
		return;
	}
	
	/**
	 * 查看文件，登陆用户查看自己的文件
	 * 
	 * @see FileUploadController#otherViewFiles(HttpServletRequest,
	 *      HttpServletResponse, String, String, String, String)
	 *      的不同之处在于，后者可以查看其他人的文件
	 * @param request
	 * @param response
	 * @param projectId
	 * @param type
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/viewFiles.do")
	@ResponseBody
	public JSONObject viewSummary(HttpServletRequest request,
			HttpServletResponse response, String projectId, String type,
			String roleId,String teacherId) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		Integer userId = getAccountId(request);
		condition.put("projectId", projectId);
		condition.put("type", type);
		condition.put("roleId", roleId);
		if(teacherId != null){
			condition.put("userId", teacherId);
		}else{
			condition.put("userId", userId);
		}
		List<FileUpload> files = fileUploadService.getFileUploads(request,
				response, condition);
		JSONObject result = new JSONObject();
		result.put("files", files);
		return result;
	}
	
	
	/**
	 * 查看已上传二维码背景
	 */
	@RequestMapping("/viewQRCodeFiles.do")
	@ResponseBody
	public JSONObject viewQRCodeFile(HttpServletRequest request,
			HttpServletResponse response, String projectId, String type,String id,
			String roleId) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("projectId", projectId);
		condition.put("type", type);
		condition.put("roleId", roleId);
		condition.put("id", id);
		List<FileUpload> files = fileUploadService.getFileUploads(request,
				response, condition);
		JSONObject result = new JSONObject();
		result.put("files", files);
		return result;
	}
	

	/**
	 * 他人查看：应该是某某查看项目id为projectId，上传人为userId，文件类型为type的文件列表
	 * 
	 * @param request
	 * @param response
	 * @param projectId
	 * @param type
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/otherViewFiles.do")
	@ResponseBody
	public JSONObject otherViewFiles(HttpServletRequest request,
			HttpServletResponse response, String projectId, String type,
			String roleId, String userId) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		// Integer userId = getAccountId(request);
		condition.put("projectId", projectId);
		condition.put("type", type);
		condition.put("roleId", roleId);
		condition.put("userId", userId);
		List<FileUpload> files = fileUploadService.getFileUploads(request,
				response, condition);
		JSONObject result = new JSONObject();
		result.put("files", files);
		return result;
	}

	//行政管理员查看实施管理员上传的文件
	@RequestMapping("/viewOthersFiles.do")
	@ResponseBody
	public JSONObject ViewOrgFiles(HttpServletRequest request,
			HttpServletResponse response, String projectId, String type,
			String roleId, String userId) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		userId = new Integer(getAccountId(request)).toString();
		condition.put("projectId", projectId);
		condition.put("type", type);
		condition.put("roleId", roleId);
		condition.put("userId", userId);
		List<FileUpload> files = fileUploadService.getOthersFileUploads(request, response, condition);
		JSONObject result = new JSONObject();
		result.put("files", files);
		return result;
	}
	@RequestMapping("downloadFiles.do")
	@ResponseBody
	public void downloadFile(HttpServletRequest request, String filePathName,
			HttpServletResponse response) throws IOException {
		String projectPath = request.getSession().getServletContext()
				.getRealPath("/");
		FileUtils.downloadFile(projectPath + filePathName, response);
	}
	
	@RequestMapping("isFileExist.do")
	@ResponseBody
	public Map<String, Object> isFileExist(HttpServletRequest request, String fileUrl,
			HttpServletResponse response) throws IOException {
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		Map<String,Object> resultMap = new HashMap<String,Object>();
		File file = new File(projectPath+fileUrl);
		if(file.exists()){
			resultMap.put("success", true);
		}else{
			resultMap.put("success", false);
		}
		return resultMap;
	}
	
	// 教师删除培训总结中的文件
	@RequestMapping("deleteFile.do")
	public @ResponseBody
	Map<String, Object> teacherSummaryDeleteFile(HttpServletRequest request,
			HttpSession session, HttpServletResponse response, ModelMap map,
			@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "pid", required = true) Integer pid,
			@RequestParam(value = "filePath", required = true) String filePath)
			throws Exception {

		Map<String, Object> result = new HashMap<String, Object>();
		String projectPath = request.getSession().getServletContext()
				.getRealPath("/");
		boolean isDelete = FileUtils.deleteFile(projectPath + filePath);
		Integer isSuccess = fileUploadService.deleteFileById(id);
		if (isSuccess > -1 && isDelete) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}

		return result;
	}

	@RequestMapping("/viewSingleFile.do")
	@ResponseBody
	public JSONObject viewSingleFile(HttpServletRequest request,
			HttpServletResponse response, Integer id) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("id", id);
		List<FileUpload> files = fileUploadService.getFileUploads(request,
				response, condition);
		JSONObject result = new JSONObject();
		result.put("files", files);
		return result;
	}

	@RequestMapping("/kindEditorUpload.do")
	public void kindEditorUpload(HttpServletRequest request,
			HttpServletResponse response) throws FileUploadException {

		// 文件保存目录路径
		String projectPath = request.getSession().getServletContext()
				.getRealPath("/");
		String uploadPath = ApplicationProperties
				.getPropertyValue("upload_file_path") + File.separator;
		
		
		String savePath = projectPath + uploadPath.replaceAll("\\\\", "/") ;

		

		// 文件保存目录URL
		String saveUrl = request.getContextPath()+ File.separator + uploadPath.replaceAll("\\\\", "/") ;

		// 定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "gif,jpg,jpeg,png,bmp,doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

		// 最大文件大小
		long maxSize = 1000000;

		response.setContentType("text/html; charset=UTF-8");

		if (!ServletFileUpload.isMultipartContent(request)) {
			ResponseUtil.renderText(response, getError("请选择文件。"));
			return;
		}
		// 检查目录
		File uploadDir = new File(savePath);
		if (!uploadDir.isDirectory()) {
			System.out.println("savePath:" + savePath);
			ResponseUtil.renderText(response, getError("上传目录不存在。"));
			return;
		}
		// 检查目录写权限
		if (!uploadDir.canWrite()) {
			ResponseUtil.renderText(response, getError("上传目录没有写权限"));
			return;
		}

		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		if (!extMap.containsKey(dirName)) {
			ResponseUtil.renderText(response, getError("目录名不正确。"));
			return;
		}
		// 创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List items = upload.parseRequest(request);
		Iterator itr = items.iterator();
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			String fileName = item.getName();
			long fileSize = item.getSize();
			if (!item.isFormField()) {
				// 检查文件大小
				if (item.getSize() > maxSize) {
					ResponseUtil.renderText(response, getError("上传文件大小超过限制"));
					return;
				}
				// 检查扩展名
				String fileExt = fileName.substring(
						fileName.lastIndexOf(".") + 1).toLowerCase();
				if (!Arrays.<String> asList(extMap.get(dirName).split(","))
						.contains(fileExt)) {
					ResponseUtil.renderText(
							response,
							getError("上传文件扩展名是不允许的扩展名。\n只允许"
									+ extMap.get(dirName) + "格式。"));
					return;
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newFileName = df.format(new Date()) + "_"
						+ new Random().nextInt(1000) + "." + fileExt;
				try {
					File uploadedFile = new File(savePath, newFileName);
					item.write(uploadedFile);
				} catch (Exception e) {
					ResponseUtil.renderText(response, getError("上传文件失败。"));
					return;
				}

				JSONObject obj = new JSONObject();
				obj.put("error", 0);
				System.out.println("返回路径："+ saveUrl+newFileName);
				obj.put("url", saveUrl + newFileName);

				ResponseUtil.renderText(response, obj.toString());
			}
		}

	}

	private String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toString();
	}

}
