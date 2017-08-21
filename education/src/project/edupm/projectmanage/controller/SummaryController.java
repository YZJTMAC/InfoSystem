package project.edupm.projectmanage.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
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

import project.common.Common;
import project.edupm.projectmanage.pojo.EduProjectSummary;
import project.edupm.projectmanage.service.IEduProjectService;
import project.edupm.projectmanage.service.ISummaryService;
import project.person.pojo.EduUserActivty;
import project.person.service.IUserService;
import project.system.pojo.SysSetup;
import project.system.service.ISysService;
import project.util.ApplicationProperties;
import project.util.ResponseUtil;
import framelib.controller.AbsController;
import framelib.utils.FileUtils;
import framelib.utils.page.PageObject;

/**
 * 项目培训总结:包括教师培训总结、实施结构培训总结
 * @author liuyiyou
 *
 */
@Controller
@RequestMapping("/edupm")
public class SummaryController extends AbsController{
	
	private static final Logger log = Logger.getLogger(SummaryController.class);

	@Autowired
	@Qualifier("sysService")
	ISysService sysService;
	
	
	@Autowired
	@Qualifier("userService")
	IUserService userService;
	
	@Autowired
	@Qualifier("summaryService")
	ISummaryService summaryService;
	
	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;
	
	
	
	/**
	 * 跳转到行政的项目总结页面
	 * @param pageSize
	 * @param startIndex
	 * @param projectName
	 * @param year
	 * @param projectId
	 * @param request
	 * @param session
	 * @param map
	 * @author 姚吟
	 * @return
	 */
	@RequestMapping("toXingZhengSummaryList.htm")
	public String toXingZhengSummaryList(Integer pageSize,Integer startIndex,
			String projectName,String year,Integer projectId,HttpServletRequest request,HttpSession session,
			ModelMap map){
		return "organization/summary/xingZhengSummaryList";
	}
	
	
	
	/**
	 * 跳转到行管理员培训总结页面
	 * @author 姚吟
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("searchXingZhengCloseProjectList.do")
	public  @ResponseBody Map<String, Object> toOrgProSummaryPage(String status,int pageIndex,String projectName,
			String year,Integer projectId,
			HttpServletRequest request,HttpSession session, ModelMap map) throws Exception{
		EduUserActivty userInfo= (EduUserActivty) session.getAttribute("userinfo");
		
		Map<String,Object> paramMap = new HashMap<String, Object>();
		PageObject po = new PageObject();
		Map<String, Object> result = new HashMap<String, Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		
		
		//paramMap.put("createBy", userInfo.getLoginAccount());
		if(year!=null){
			String[] arr = year.split(",");
			if(arr.length==2){
				paramMap.put("beginYear", arr[0]);
				paramMap.put("endYear", arr[1]);
				map.put("year", arr);
				map.put("beginYear", arr[0]);
				map.put("endYear", arr[1]);
			}
		}
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		paramMap.put("start", startTime== null? null:startTime.equals("")?null:startTime);
		paramMap.put("end", endTime== null? null:endTime.equals("")?null:endTime);
		paramMap.put("projectName", projectName== null? null:projectName.equals("")?null:projectName);
		paramMap.put("status", status);
		paramMap.put("pid", userInfo.getUserProvinceId());
		paramMap.put("cid", userInfo.getUserCityId());
		paramMap.put("did", userInfo.getUserDistrictId());
		
		po = eduProjectService.findProjectByParam(paramMap, pageIndex, Common.PNN_USER_PAGE_LIMIT);
		SysSetup pojo = sysService.selectSysSetupInfo();
		if(po != null && po.getCount() > 0) {
			result.put("success", true);
			result.put("isHide", pojo.getEnableOrg());
			result.put("rows",po.getObjects());
		} else {
			result.put("success", false);
		}
		result.put("areaId",super.getUserAreaId(request));
		result.put("total",po.getCount());
		result.put("pageSize", po.getPagesize());
		result.put("pages", po.getPages());
		result.put("currentPage", po.getCurrentPage());
		result.put("pageNumbers", po.getPageNumbers());

		map.put("roleId", userInfo.getRoleId());
		map.put("pageObject", po);
		map.put("projectName", projectName);
		map.put("years", Common.YEARS);
		result.put("userId", userInfo.getUserId());
		return result;
	}
	
	
	@RequestMapping("summary/deleteSummary.do")
	public @ResponseBody boolean delete(String name,Integer id){
		String str =name;
		if(str.indexOf("\"")==0) str = str.substring(1,str.length());   //去掉第一个 "
		if(str.lastIndexOf("\"")==(str.length()-1)) str = str.substring(0,str.length()-1);  //去掉最后一个 " 
        
		EduProjectSummary epp = new EduProjectSummary();
		epp.setId(id);
		epp = summaryService.getSummaryByParam(epp);
		
		String xsl=epp.getAttchementTitle();
		
	    String[] names= xsl.split(","); 
	    
	    String Str ="";
	    
	    List list=new ArrayList();
	    
	    for (Object object : names) {
	    	if(str.equals(object)){
	    		list.add(object);
	    	}else{
	    		
	    		Str +=object+",";
	    	}
			
		}
	    epp.setAttchementTitle(Str);
	   int i= summaryService.writeSummary(epp);
	   if(i>0){
		   return true;
	   }
	   
		return false;
		
	}
	
	
	/**
	 * 保存或者更新培训总结
	 * @param isChange
	 * @param projectId
	 * @param id
	 * @param type  0:实施结构总结 、1：教师总结
	 * @param title
	 * @param content
	 * @param request
	 * @param session
	 * @param mrequest
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("summary/savaOrUpdateSummary.do")
	public	 void savaOrUpdateSummary(
			@RequestParam(value = "isChange", required = false) boolean isChange,
			@RequestParam(value = "projectId", required = false) Integer projectId,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "type", required = false) Integer type,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "content", required = false) String content,
			HttpServletRequest request, HttpSession session,
			HttpServletResponse response) throws IOException {
		log.debug("更新项目总结");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
		String projectPath = request.getSession().getServletContext()
				.getRealPath("/");
		// 文件保存路径应该是:总结报告路径/项目id/老师或者机构的id
		String savePath = ApplicationProperties
				.getPropertyValue("upload_summary_file")
				+ File.separator
				+ projectId
				+ File.separator
				+ getAccountId(mrequest)
				+ File.separator;// 获取保存文件的路径
		List<MultipartFile> files = mrequest.getFiles("file");
		EduProjectSummary eps = new EduProjectSummary();
		if(id==null){
			id=-1;
		}
		eps.setId(id);
		eps.setProjectId(projectId);
		eps.setType(type);
		String fullName = "";
		EduProjectSummary ep = summaryService.getSummaryByParam(eps);
		if (ep == null) {
			ep = new EduProjectSummary();
			ep.setProjectId(projectId);
			ep.setType(type);
		}
		if (!FileUtils.isFileExists(files)) {
			// 需要上传文件
			resultMap.put("success", false);
			resultMap.put("info", "请上传文件");
			ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
			return ;
//			return resultMap;
		}

		for (MultipartFile file : files) {

			// 空文件检查
			if (FileUtils.isEmptyFile(files)) {
				resultMap.put("success", false);
				resultMap.put("info", "待上传的文件列表中有空文件");
				ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
				return ;
			}
			// 待上传文件有重复文件检查
			if (FileUtils.isTheSameNameFile(files)) {
				resultMap.put("success", false);
				resultMap.put("info", "待上传的文件列表中有重复文件");
				ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
				return ;
			}
			try {
				fullName = file.getOriginalFilename();
				System.out.println("fileName:"+ fullName);
				//检查待上传的文件在已经上传的文件中是否存在
				if (StringUtils.isNotBlank(ep.getAttchementTitle())) {
					String[] fileNames = ep.getAttchementTitle().split("\\^");
					for(String name:fileNames){
						if(fullName.equals(name)){
							resultMap.put("success", false);
							resultMap.put("info", "您已经上传过该文件");
							ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
							return ;
						}
					}
					//不能放在else中，因为else在该循环zh
					FileUtils.writes(file, projectPath + savePath,
							fullName);
					ep.setAttchementTitle(ep.getAttchementTitle() + "^"
							+ fullName);
							
				}else{
					 FileUtils.writes(file, projectPath + savePath,
							fullName);
					ep.setAttchementTitle(fullName);
				}
				
				savePath = savePath.replaceAll("\\\\", "/");
				ep.setAttchementUrl(savePath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		EduUserActivty userInfo = (EduUserActivty) session
				.getAttribute("userinfo");
		ep.setCreateDate(new Date());
		ep.setCreateBy(userInfo.getUserId());
		try {
			summaryService.writeSummary(ep);
			resultMap.put("success", true);
			resultMap.put("info", "上传成功");
			ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
			return ;
		} catch (Exception e) {
			resultMap.put("success", false);
			e.printStackTrace();
		}
	
	}
	
	
	
	
	/**
	 * 老师查看自己的培训总结
	 * @param request
	 * @param session
	 * @param response
	 * @param map
	 * @param summaryId
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("summary/teacherViewSummary.do")
	public @ResponseBody Map<String, Object> teacherViewSummary(HttpServletRequest request,HttpSession session,
			HttpServletResponse response,ModelMap map,
			@RequestParam(value="projectId",required=false)Integer projectId,
			@RequestParam(value="type",required=false)Integer type) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		EduUserActivty userInfo= (EduUserActivty) session.getAttribute("userinfo");
		
		EduProjectSummary eps = new EduProjectSummary();
		eps.setCreateBy(userInfo.getUserId());
		eps.setType(type);
		eps.setProjectId(projectId);
		eps = summaryService.getSummaryByParam(eps);
		result.put("eps", eps);
		return result;
	}
	
	//实施机构删除培训总结中的文件
	@RequestMapping("summary/shishiSummaryDeleteFile.do")
	public @ResponseBody Map<String, Object> shishiSummaryDeleteFile(HttpServletRequest request,HttpSession session,
			HttpServletResponse response,ModelMap map,
			@RequestParam(value="id",required=true)Integer id,
			@RequestParam(value="pid",required=true)Integer pid,
			@RequestParam(value="title",required=true)String title) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String projectPath = request.getSession().getServletContext().getRealPath("/"); 
			String savePath = ApplicationProperties.getPropertyValue("upload_summary_report_file")+File.separator+pid+File.separator+getAccountId(request)+File.separator;//获取保存文件的路径
			EduProjectSummary eps = new EduProjectSummary();
			eps.setId(id);
			eps.setProjectId(pid);
			EduProjectSummary ep=summaryService.getSummaryByParam(eps);
			if(ep!=null){
				boolean isDelete = FileUtils.deleteFile(projectPath+savePath+title);
//				if(isDelete){
					//删除成功之后再更新数据库，否则引起不一致问题
					String[] fileNames = ep.getAttchementTitle().split("\\^");
					String newFileName = "";
					String split = "";
					for(String fileName:fileNames){
						if(title.equals(fileName)){
						}else{
							newFileName += (split+fileName);
							split = "^";
						}
					}
					ep.setAttchementTitle(newFileName);
					summaryService.writeSummary(ep);
					result.put("success", true);
//				}
				
				return result;
			}
			
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		result.put("success", false);
		return result;
	}
	
	
	
	//教师删除培训总结中的文件
	@RequestMapping("summary/teacherSummaryDeleteFile.do")
	public @ResponseBody Map<String, Object> teacherSummaryDeleteFile(HttpServletRequest request,HttpSession session,
			HttpServletResponse response,ModelMap map,
			@RequestParam(value="id",required=true)Integer id,
			@RequestParam(value="pid",required=true)Integer pid,
			@RequestParam(value="title",required=true)String title) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String projectPath = request.getSession().getServletContext().getRealPath("/"); 
			String savePath = ApplicationProperties.getPropertyValue("upload_summary_file")+File.separator+pid+File.separator+getAccountId(request)+File.separator;//获取保存文件的路径
			EduProjectSummary eps = new EduProjectSummary();
			eps.setId(id);
			eps.setProjectId(pid);
			EduProjectSummary ep=summaryService.getSummaryByParam(eps);
			if(ep!=null){
				boolean isDelete = FileUtils.deleteFile(projectPath+savePath+title);
				//不能根据是否删除成功再确定是否删除文件名
//				if(isDelete){
					//删除成功之后再更新数据库，否则引起不一致问题
					String[] fileNames = ep.getAttchementTitle().split("\\^");
					String newFileName = "";
					String split = "";
					for(String fileName:fileNames){
						if(title.equals(fileName)){
						}else{
							newFileName += (split+fileName);
							split = "^";
						}
					}
					ep.setAttchementTitle(newFileName);
					summaryService.writeSummary(ep);
					result.put("success", true);
//				}
				
				return result;
			}
			
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		result.put("success", false);
		return result;
	}
	
	
	
	/**
	 * 承配机构查看自己的培训总结
	 * @param request
	 * @param session
	 * @param response
	 * @param map
	 * @param summaryId
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("summary/chengPeiViewSummary.do")
	public @ResponseBody Map<String, Object> chengPeiViewSummary(HttpServletRequest request,HttpSession session,
			HttpServletResponse response,ModelMap map,
			@RequestParam(value="projectId",required=false)Integer projectId,
			@RequestParam(value="type",required=false)Integer type) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		EduUserActivty userInfo= (EduUserActivty) session.getAttribute("userinfo");
		
		EduProjectSummary eps = new EduProjectSummary();
		eps.setCreateBy(userInfo.getUserId());
		eps.setType(type);
		eps.setProjectId(projectId);
		eps = summaryService.getSummaryByParam(eps);
		result.put("eps", eps);
		return result;
	}
	
	/**
	 * 实施机构查看自己的培训总结
	 * @param request
	 * @param session
	 * @param response
	 * @param map
	 * @param summaryId
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("summary/shiShiViewSummary.do")
	public @ResponseBody Map<String, Object> shiShiViewSummary(HttpServletRequest request,HttpSession session,
			HttpServletResponse response,ModelMap map,
			@RequestParam(value="projectId",required=false)Integer projectId,
			@RequestParam(value="type",required=false)Integer type) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		EduUserActivty userInfo= (EduUserActivty) session.getAttribute("userinfo");
		
		EduProjectSummary eps = new EduProjectSummary();
		eps.setCreateBy(userInfo.getUserId());
		eps.setType(type);
		eps.setProjectId(projectId);
		eps = summaryService.getSummaryByParam(eps);
		
		result.put("eps", eps);
		return result;
	}
	
	
	@RequestMapping("summary/shengViewSummary.do")
	public @ResponseBody Map<String, Object> shengViewSummary(HttpServletRequest request,HttpSession session,
			HttpServletResponse response,ModelMap map,
			@RequestParam(value="projectId",required=false)Integer projectId,
			@RequestParam(value="type",required=false)Integer type) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		EduProjectSummary eps = new EduProjectSummary();
		eps.setType(type);
		eps.setProjectId(projectId);
		eps = summaryService.getSummaryByParam(eps);
		
		result.put("eps", eps);
		return result;
	}
	
	
	
	/***
	 * 查看培训总结根据总结的ID
	 * @param summaryId
	 * @return
	 */
	@RequestMapping("summary/viewSummary.do")
	public @ResponseBody Map<String, Object> viewSummary(Integer summaryId){
		Map<String, Object> result = new HashMap<String, Object>();
		EduProjectSummary eps = new EduProjectSummary();
		eps.setId(summaryId);
		eps = summaryService.getSummaryByParam(eps);
		result.put("eps", eps);
		return result;
	}
	
	
	
	
	@RequestMapping("summary/otherViewTeacherSummary.do")
	public @ResponseBody Map<String, Object> otherViewTeacherSummary(
			HttpServletRequest request,HttpSession session,
			HttpServletResponse response,ModelMap map,
			Integer pid,Integer uid,Integer summaryId,Integer type) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		EduProjectSummary eps = new EduProjectSummary();
		eps.setProjectId(pid);
		eps.setType(type);
		eps.setId(summaryId);
		eps = summaryService.getSummaryByParam(eps);
		result.put("eps", eps);
		return result;
	}
	
	@RequestMapping("summary/viewChengPeiSummary.do")
	public @ResponseBody Map<String, Object> viewChengPeiSummary(HttpServletRequest request,HttpSession session,
			HttpServletResponse response,ModelMap map,Integer summaryId,Integer type) {
		Map<String, Object> result = new HashMap<String, Object>();
		EduProjectSummary eps = new EduProjectSummary();
		eps.setType(type);
		eps.setId(summaryId);
		eps = summaryService.getSummaryByParam(eps);
		result.put("eps", eps);
		return result;
	}
	
	
	/**
	 * 项目总结报告
	 * */
	@RequestMapping("summary/savaOrUpdateSummaryReport.do")
	public void savaOrUpdateSummaryReport(boolean isChange,Integer projectId,Integer id,String title,String content,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		log.debug("写入用户项目总结报告");
//		String projectPath = request.getSession().getServletContext().getRealPath("/"); 
//		String savePath = ApplicationProperties.getPropertyValue("upload_summary_file")+File.separator;//获取保存文件的路径
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		MultipartFile file = multipartRequest.getFile("attchmentPath");
//		EduProjectSummary eps = new EduProjectSummary();
//		Map<String, Object>  result = new HashMap<String, Object>();
//		if(file!=null&&!file.isEmpty()){
//			String fileName = null;
//			try {
//				fileName = FileUtils.write(file,projectPath+savePath);
//				String fullName = file.getOriginalFilename();
//				int dot = fullName.lastIndexOf('.');   
//	            if ((dot >-1) && (dot < (fullName.length() - 1))) {   
//	            	fileName += fullName.substring(dot);   
//	            }  
//	            eps.setAttchementTitle(fileName);
//	            savePath=savePath.replaceAll("\\\\", "/");
//				eps.setAttchementUrl(savePath);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}else{
//			if(isChange){
//				eps.setAttchementUrl("");
//				eps.setAttchementTitle("");
//			}
//		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
		String projectPath = request.getSession().getServletContext()
				.getRealPath("/");
		// 文件保存路径应该是:总结报告路径/项目id/老师或者机构的id
		String savePath = ApplicationProperties
				.getPropertyValue("upload_summary_report_file")
				+ File.separator
				+ projectId
				+ File.separator
				+ getAccountId(mrequest)
				+ File.separator;// 获取保存文件的路径
		List<MultipartFile> files = mrequest.getFiles("file");
		EduProjectSummary eps = new EduProjectSummary();
		eps.setProjectId(projectId);
		eps.setType(4);
		String fullName = "";
		EduProjectSummary ep = summaryService.getSummaryByParam(eps);
		if (ep == null) {
			ep = new EduProjectSummary();
			ep.setProjectId(projectId);
			ep.setType(4);
		}
		if (!FileUtils.isFileExists(files)) {
			// 需要上传文件
			resultMap.put("success", false);
			resultMap.put("info", "请上传文件");
			ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
			return ;
		}

		for (MultipartFile file : files) {

			// 空文件检查
			if (FileUtils.isEmptyFile(files)) {
				resultMap.put("success", false);
				resultMap.put("info", "待上传的文件列表中有空文件");
				ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
				return ;
			}
			// 待上传文件有重复文件检查
			if (FileUtils.isTheSameNameFile(files)) {
				resultMap.put("success", false);
				resultMap.put("info", "待上传的文件列表中有重复文件");
				ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
				return ;
			}
			
			try {
				fullName = file.getOriginalFilename();
				System.out.println(fullName);
				//检查待上传的文件在已经上传的文件中是否存在
				if (StringUtils.isNotBlank(ep.getAttchementTitle())) {
					String[] fileNames = ep.getAttchementTitle().split("\\^");
					for(String name:fileNames){
						if(fullName.equals(name)){
							resultMap.put("success", false);
							resultMap.put("info", "您已经上传过该文件");
							ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
							return ;
						}
					}
					
					FileUtils.writes(file, projectPath + savePath,
							fullName);
					ep.setAttchementTitle(ep.getAttchementTitle() + "^"
							+ fullName);
							
				}else{
					 FileUtils.writes(file, projectPath + savePath,
							fullName);
					 ep.setAttchementTitle(fullName);
				}
				
				savePath = savePath.replaceAll("\\\\", "/");
				ep.setAttchementUrl(savePath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		EduUserActivty userInfo= (EduUserActivty) session.getAttribute("userinfo");
//		eps.setContent(content);
//		eps.setId(id);
		ep.setProjectId(projectId);
		ep.setType(4);
//		eps.setTitle(title);
		ep.setCreateDate(new Date());
		ep.setCreateBy(userInfo.getUserId());
		summaryService.writeSummary(ep);
		resultMap.put("success", true);
		resultMap.put("info", "上传成功");
		ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
		return ;
	}

	/**
	 * 查看项目总结报告
	 * */
	@RequestMapping("summary/viewSummaryReport.do")
	public @ResponseBody Map<String, Object> viewSummaryReport(HttpServletRequest request,HttpSession session,
			HttpServletResponse response,ModelMap map,Integer pid,Integer uid) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		EduProjectSummary eps = new EduProjectSummary();
		eps.setProjectId(pid);
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", pid);
		/*PageObject po = eduProjectService.findProjectByParam(paramMap, 1, 15);
		if(po.getObjects().size()>0){
			EduProject p = (EduProject) po.getObjects().get(0);
			EduUser eduUser = userService.getUserByLoginAccountOrIdNumber(p.getCreateBy());
			if(eduUser!=null){
				eps.setCreateBy(eduUser.getId());
			}else{
				System.out.println("请检查用户数据");
			}
			
		}*/
		eps.setType(4);
		eps = summaryService.getSummaryByParam(eps);
		result.put("eps", eps);
		return result;
	}
	
	@RequestMapping("summary/downloadSummary.do")
	@ResponseBody
	public void downloadFile(HttpServletRequest request,String filePathName,HttpServletResponse response) throws IOException{
		String projectPath = request.getSession().getServletContext().getRealPath("/"); 
		FileUtils.downloadFile(projectPath+ filePathName, response);
	}
	
	
	
	/**
	 * 行政管理员/实施机构管理员查看教师的培训总结
	 * @author liuyiyou
	 * @param sno
	 * @param school
	 * @param projectId
	 * @param name
	 * @param request
	 * @param response
	 * @param map
	 * @throws Exception
	 */
	@RequestMapping(value="summary/teacherProSummaryList.do")
	public  @ResponseBody Map<String, Object> teacherProSummaryList(String sno,String school,String projectId,
			String name,Integer pageSize,Integer pageIndex,HttpServletRequest request, HttpServletResponse response,ModelMap map) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(sno))
			paramMap.put("sno", sno);
		if(StringUtils.isNotBlank(name))
			paramMap.put("name", name);
		if(StringUtils.isNotBlank(school))
			paramMap.put("school", school);
		if(StringUtils.isNotBlank(projectId))
			paramMap.put("projectId", projectId);
		
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
		pageIndex = (pageIndex - 1) * sizePerPage;
		PageObject po  = summaryService.selectTeacherSummayByPage(paramMap, pageIndex, sizePerPage);
		if(po != null && po.getCount() > 0) {
			result.put("success", true);
			result.put("rows",po.getObjects());
		} else {
			result.put("success", false);
		}
		result.put("total",po.getCount());
		result.put("pageSize", po.getPagesize());
		result.put("pages", po.getPages());
		result.put("currentPage", po.getCurrentPage());
		result.put("pageNumbers", po.getPageNumbers());

		return result;
	}
}
