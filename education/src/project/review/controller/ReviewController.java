package project.review.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import project.fileupload.pojo.FileType;
import project.fileupload.service.IFileUploadService;
import project.master.pojo.EduComparison;
import project.review.service.IReviewService;
import project.teacher.teacherProject.controller.TeacherController;

import framelib.controller.AbsController;
import framelib.utils.page.PageObject;

@Controller
@RequestMapping("/review/reviewManagement")
public class ReviewController extends AbsController{

	private static final Logger log = Logger.getLogger(ReviewController.class);
	
	@Autowired
	@Qualifier("reviewService")
	IReviewService reviewService;
	
	@Autowired
	@Qualifier("fileUploadService")
	IFileUploadService fileUploadService;
	
	/**
	 * 跳转到上传信息界面
	 */
	@RequestMapping("toReportInformation.htm")
	public String toReportInformationPage(HttpServletRequest request){
		String comparisonName = request.getParameter("comparisonName");//要报名的评比活动
		request.setAttribute("comparisonName",comparisonName);
		return "review/reportInformation";
	}
	
	@RequestMapping("/reportInformation.do")
	public void reportInformationForTeacher(HttpServletRequest request,ModelMap map,MultipartHttpServletRequest mrequest,HttpServletResponse response) throws Exception{
		Map<String,Object> paraMap1 = new HashMap<String,Object>();
		Map<String,Object> paraMap2 = new HashMap<String,Object>();
		String comparisonName = (String)request.getAttribute("comparisonName");
		paraMap1.put("comparisonName", comparisonName);
		paraMap2.put("teacherName", request.getParameter("name"));
		paraMap2.put("idcard", Integer.getInteger(request.getParameter("idcard")));
		paraMap2.put("period", request.getParameter("period"));
		paraMap2.put("subject", request.getParameter("subject"));
		paraMap2.put("attachmentPath", request.getParameter("attachment"));
		paraMap2.put("remark", request.getParameter("remark"));
		int result = reviewService.addInformationForTeacher(paraMap1, paraMap2);
		if(result!=-1){
			List<MultipartFile> files = mrequest.getFiles("file");
			if(files.size()>0 && files.get(0).getSize() >0){
				 Map resultMap = fileUploadService.fileUpload(request, response, FileType.COMPARISON_SIGNUP, result, comparisonName,
					getAccountId(request), getAccount(request), getRoleId(request));
				 if((Boolean) resultMap.get("success")){
//						//成功
					 map.put("success", true);
					 map.put("message", "添加成功");
					}else{
//						//上传文件失败，但是添加自主成功，需删除
//						teacherWriteDao.deleteIndeptStudy(isId);
//						result.put("success", false);
//						result.put("message", result.get("info"));
					}
			}
		}
	}
	
}
