package project.master.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import project.fileupload.pojo.FileType;
import project.fileupload.service.IFileUploadService;
import project.master.pojo.EduComparison;
import project.master.pojo.EduComparisonComment;
import project.master.pojo.EduComparisonMaster;
import project.master.service.IEduMasterService;
import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;
import project.system.controller.SysSchoolController;
import project.system.pojo.EduSchool;
import project.system.pojo.SysArea;
import project.system.service.ISysService;
import project.util.ApplicationProperties;
import project.util.DataUtil;
import framelib.controller.AbsController;
import framelib.utils.DateUtil;
import framelib.utils.StringUtil;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

@Controller
@RequestMapping("/master")
public class MasterController extends AbsController {
	private static final Logger log = Logger.getLogger(SysSchoolController.class);
	
	@Autowired
	@Qualifier("eduMasterService")
	IEduMasterService eduMasterService;
	
	@Autowired
	@Qualifier("fileUploadService")
	IFileUploadService fileUploadService;
	
	@Autowired
	@Qualifier("sysService")
	ISysService sysService;
	
	/**
	 * 跳转到专家管理
	 * @return
	 */
	@RequestMapping("toMasterManage.htm")
	public String toMasterManage(HttpServletRequest request){
		request.setAttribute("comparisonId", request.getParameter("id"));
		return "master/manageMaster";
	}
	
	/**
	 * 跳转到专家库
	 * @return
	 */
	@RequestMapping("toMasterDatabase.htm")
	public String toMasterDatabase(HttpServletRequest request){
		return "master/masterDatabase";
	}
	
	/**
	 * 跳转到评比活动管理
	 * @return
	 */
	@RequestMapping("toManageComparison.htm")
	public String toManageComparison(HttpServletRequest request){
		return "master/manageComparison";
	}
	
	/**
	 * 跳转到评比活动列表
	 * @return
	 */
	@RequestMapping("toComparisonList.htm")
	public String toComparisonList(HttpServletRequest request){
		return "master/comparisonList";
	}

	/**
	 * 跳转到创建评比活动
	 * @return
	 */
	@RequestMapping("toCreateComparison.htm")
	public String toCreateComparison(HttpServletRequest request){
		String provinceId = getUserProvinceId(request);
		request.setAttribute("provinceId", provinceId);
		return "master/createComparison";
	}
	
	/**
	 * 跳转到评选活动通知
	 * @return
	 */
	@RequestMapping("toReceiveComparison.htm")
	public String toReceiveComparison(HttpServletRequest request){
		return "master/receiveComparison";
	}
	
	/**
	 * 跳转到评比活动报名
	 * @return
	 */
	@RequestMapping("toSignUpComparison.htm")
	public String toSignUpComparison(HttpServletRequest request){
		String comparisonId = request.getParameter("comparisonId");//要报名的评比活动
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("comparisonId", comparisonId);
		PageObject pageObject = eduMasterService.queryComparison(condition);
		EduComparison eduComparison = (EduComparison) pageObject.getObjects().get(0);
		request.setAttribute("comparisonName", eduComparison.getComparisonName());
		request.setAttribute("comparisonId", comparisonId);
		request.setAttribute("areaName", this.getCode(request).get("areaName"));
		request.setAttribute("areaId", this.getCode(request).get("areaId"));
		request.setAttribute("areaType", this.getCode(request).get("areaType"));
		request.setAttribute("signUpPage", true);
		return "master/signUpComparison";
	}
	/**
	 * 跳转到评比活动报名查看
	 * @return
	 */
	@RequestMapping("viewSignUpComparison.htm")
	public String viewSignUpComparison(HttpServletRequest request){
		String comparisonId = request.getParameter("comparisonId");//要报名的评比活动
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("comparisonId", comparisonId);
		PageObject pageObject = eduMasterService.queryComparison(condition);
		EduComparison eduComparison = (EduComparison) pageObject.getObjects().get(0);
		request.setAttribute("comparisonName", eduComparison.getComparisonName());
		request.setAttribute("comparisonId", comparisonId);
		request.setAttribute("areaName", this.getCode(request).get("areaName"));
		request.setAttribute("areaId", this.getCode(request).get("areaId"));
		request.setAttribute("areaType", this.getCode(request).get("areaType"));
		request.setAttribute("signUpPage", false);
		return "master/signUpComparison";
	}
	/**
	 * 跳转到评比活动报名查看
	 * @return
	 */
	@RequestMapping("toExpertScoreList.htm")
	public String toExpertScoreList(HttpServletRequest request){
		return "master/expertScoreList";
	}
	
	/**
	 * 跳转专家评分列表
	 * @return
	 */
	@RequestMapping("toJudgeList.htm")
	public String toJudgeList(HttpServletRequest request){
		String comparisonId = request.getParameter("comparisonId");//要报名的评比活动
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("comparisonId", comparisonId);
		PageObject pageObject = eduMasterService.queryComparison(condition);
		EduComparison eduComparison = (EduComparison) pageObject.getObjects().get(0);
		request.setAttribute("comparisonName", eduComparison.getComparisonName());
		request.setAttribute("comparisonId", comparisonId);
		return "master/judgeList";
	}
	
	/**
	 * 跳转教师列表（根据项目ID）
	 * @author TMACJ
	 * @return
	 */
	@RequestMapping("queryTeacherList.htm")
	public String queryTeacherList(HttpServletRequest request){
		String comparisonId = request.getParameter("comparisonId");//要报名的评比活动
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("comparisonId", comparisonId);
		PageObject pageObject = eduMasterService.queryComparison(condition);
		EduComparison eduComparison = (EduComparison) pageObject.getObjects().get(0);
		request.setAttribute("comparisonName", eduComparison.getComparisonName());
		request.setAttribute("comparisonId", comparisonId);
		return "master/teacherList";
	}
	
	/**
	 * 跳转教师列表（根据项目）
	 * @return
	 */
	@RequestMapping("queryTeacherComment.htm")
	public String queryTeacherComment(HttpServletRequest request){
		String comparisonId = request.getParameter("comparisonId");//要报名的评比活动
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("comparisonId", comparisonId);
		PageObject pageObject = eduMasterService.queryComparison(condition);
		EduComparison eduComparison = (EduComparison) pageObject.getObjects().get(0);
		request.setAttribute("comparisonName", eduComparison.getComparisonName());
		request.setAttribute("comparisonId", comparisonId);
		return "master/teacherComment";
	}
	/**
	 * 查看专家对某个项目的打分详情
	 * 
	 * @author cl
	 * @return
	 */
	@RequestMapping("toJudgeDetail.htm")
	public String toJudgeDetail(HttpServletRequest request) {
		request.setAttribute("masterId", request.getParameter("masterId"));
		request.setAttribute("comparisonId", request.getParameter("comparisonId"));
		return "master/judgeDetail";
	}
	
	/**
	 * 导入专家跳转页面
	 * 
	 * @author cl
	 * @return
	 */
	@RequestMapping("toUploadMaster.htm")
	public String toUploadMaster(HttpServletRequest request) {
		return "master/toUploadMaster";
	}
	
	
	/**
	 * 添加评比活动
	 * addComparison
	 * @throws Exception 
	 */
	@RequestMapping("addComparison.do")
	public @ResponseBody Map<String,Object> addComparison(HttpServletRequest request,HttpServletResponse response,EduComparison ec, MultipartHttpServletRequest mrequest) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonName = ec.getComparisonName();
		String comparisonType = ec.getComparisonTypeId();
		String comparisonYear = ec.getComparisonYear();
		String comparisonTypeName = ec.getComparisonTypeName();
		String comparisonNum = ec.getComparisonPlanNum();
		String signupStartDate = ec.getSignupStartDate();
		String signupEndDate = ec.getSignupEndDate();
		String auditStartDate  = ec.getAuditStartDate();
		String auditEndDate  = ec.getAuditEndDate();
		String publishDate = ec.getPublishDate();
		String memo = request.getParameter("memo");
		String schools = ec.getSchools();
		condition.put("comparisonName",comparisonName);
		condition.put("comparisonType",comparisonType);
		condition.put("comparisonTypeName",comparisonTypeName);
		condition.put("comparisonYear",comparisonYear);
		condition.put("auditStartDate",auditStartDate);
		condition.put("auditEndDate",auditEndDate);
		condition.put("publishDate",publishDate);
		condition.put("comparisonNum",comparisonNum);
		condition.put("signupStartDate",signupStartDate);
		condition.put("signupEndDate",signupEndDate);
		condition.put("memo",memo);
		condition.put("createBy",getAccountId(request));
		condition.put("schools", schools);
		condition.put("createLevel", getRoleId(mrequest));//创建该项目的级别(级别和用户类型编号一样)
		
		
		List<MultipartFile> files = mrequest.getFiles("file");
		int comparisonId = eduMasterService.addComparison(condition);
		if(comparisonId > 0){
			if(files.size()>0 && files.get(0).getSize() >0){
				result = fileUploadService.fileUpload(request, response, FileType.COMPARISON, comparisonId, ec.getComparisonName(),
					getAccountId(request), getAccount(request), getRoleId(request));
				if((Boolean) result.get("success")){
//					//成功
					result.put("success", true);
					result.put("message", "新增成功");
				}else{
//					//上传文件失败，但是添加自主成功，需删除
					condition.clear();
					condition.put("id", comparisonId);
					eduMasterService.deleteComparison(condition);
					result.put("success", false);
					result.put("message", result.get("info"));
				}
			}else{
				result.put("success", true);
				result.put("message", "新增成功");
			}
		}else{
			result.put("success", false);
			result.put("message", "新增失败");
		}
		
		return result;
	}
	
	/**
	 * 修改评比活动
	 * addComparison
	 */
	@RequestMapping("updateComparison.do")
	public @ResponseBody Map<String,Object> updateComparison(HttpServletRequest request,HttpServletResponse response,EduComparison ec, MultipartHttpServletRequest mrequest) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonName = ec.getComparisonName();
		String comparisonType = ec.getComparisonTypeId();
		String comparisonYear = ec.getComparisonYear();
		String comparisonTypeName = ec.getComparisonTypeName();
		String comparisonNum = ec.getComparisonPlanNum();
		String signupStartDate = ec.getSignupStartDate();
		String signupEndDate = ec.getSignupEndDate();
		String auditStartDate  = ec.getAuditStartDate();
		String auditEndDate  = ec.getAuditEndDate();
		String publishDate = ec.getPublishDate();
		String memo = request.getParameter("memo");
		String schools = ec.getSchools();
		condition.put("comparisonName",comparisonName);
		condition.put("comparisonType",comparisonType);
		condition.put("comparisonTypeName",comparisonTypeName);
		condition.put("comparisonYear",comparisonYear);
		condition.put("auditStartDate",auditStartDate);
		condition.put("auditEndDate",auditEndDate);
		condition.put("publishDate",publishDate);
		condition.put("comparisonNum",comparisonNum);
		condition.put("signupStartDate",signupStartDate);
		condition.put("signupEndDate",signupEndDate);
		condition.put("memo",memo);
		condition.put("createBy",getAccountId(request));
		condition.put("id", ec.getId());
		condition.put("schools", schools);
		
		
		List<MultipartFile> files = mrequest.getFiles("file");
		int comparisonId = eduMasterService.updateComparison(condition);
		if(comparisonId > 0){
			if(files.size()>0 && files.get(0).getSize() >0){
				result = fileUploadService.fileUpload(request, response, FileType.COMPARISON, Integer.parseInt(ec.getId()), ec.getComparisonName(),
					getAccountId(request), getAccount(request), getRoleId(request));
				if((Boolean) result.get("success")){
//					//成功
					result.put("success", true);
					result.put("message", "修改成功");
				}else{
//					//上传文件失败，但是添加自主成功，需删除
//					teacherWriteDao.deleteIndeptStudy(isId);
//					result.put("success", false);
//					result.put("message", result.get("info"));
				}
			}else{
				result.put("success", true);
				result.put("message", "修改成功");
			}
		}else{
			result.put("success", false);
			result.put("message", "新增失败");
		}
		
		return result;
	}
	
	/**
	 * 删除评比活动
	 * addComparison
	 */
	@RequestMapping("deleteComparison.do")
	public @ResponseBody Map<String,Object> deleteComparison(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String id = request.getParameter("id");
		condition.put("id",id);
		if(eduMasterService.deleteComparison(condition)){
			result.put("success", true);
			result.put("message", "删除成功");
		}else{
			result.put("success", false);
			result.put("message", "删除失败！");
		}
		return result;
	}

	/**
	 * 查询评比活动
	 * @param request
	 * @return
	 */
	@RequestMapping("queryComparison.do")
	public @ResponseBody Map<String,Object> queryComparison(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		String comparisonName = request.getParameter("comparisonName");
		String comparisonType = request.getParameter("comparisonType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		Integer startIndex = 0;
		Integer pageSize = 10;
		if(id != null){//查询单个
			condition.put("comparisonId", id);
		}else{
			startIndex = Integer.parseInt(request.getParameter("startIndex"));
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			startIndex = (startIndex - 1) * pageSize;
			condition.put("startIndex", startIndex);
			condition.put("pageSize", pageSize);
		}
		condition.put("status", StringUtils.isEmpty(status) ? null : status);
		condition.put("comparisonName", StringUtils.isEmpty(comparisonName) ? null : comparisonName);
		condition.put("comparisonType", StringUtils.isEmpty(comparisonType) ? null : comparisonType);
		condition.put("startDate", StringUtils.isEmpty(startDate) ? null : startDate);
		condition.put("endDate", StringUtils.isEmpty(endDate) ? null : endDate);
		if(getRoleId(request) == 4){
			condition.put("schoolId", getSchoolId(request));
			condition.put("schoolName", getSchoolName(request));
		}
		PageObject pageObject = eduMasterService.queryComparison(condition);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, pageObject.getCount()), pageObject);
		result.put("success",true);
		result.put("rows", pageObject.getObjects());
		result.put("total", pageObject.getCount());
		result.put("pageSize", pageObject.getPagesize());
		result.put("pages", pageObject.getPages());
		result.put("currentPage", pageObject.getCurrentPage());
		result.put("pageNumbers", pageObject.getPageNumbers());
		result.put("startIndex", pageObject.getStartIndex());
		return result;
	}
	
	/**
	 * 查询评比活动(校级查询)
	 * @param request
	 * @return
	 */
	@RequestMapping("queryComparisonBySchool.do")
	public @ResponseBody Map<String,Object> queryComparisonBySchool(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		String comparisonName = request.getParameter("comparisonName");
		String comparisonType = request.getParameter("comparisonType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		if(id != null){//查询单个
			condition.put("id", id);
		}
		condition.put("status", StringUtils.isEmpty(status) ? null : status);
		condition.put("comparisonName", StringUtils.isEmpty(comparisonName) ? null : comparisonName);
		condition.put("comparisonType", StringUtils.isEmpty(comparisonType) ? null : comparisonType);
		condition.put("startDate", StringUtils.isEmpty(startDate) ? null : startDate);
		condition.put("endDate", StringUtils.isEmpty(endDate) ? null : endDate);
		condition.put("schools", getAccountId(request));
		PageObject pageObject = eduMasterService.queryComparison(condition);
		result.put("rows", pageObject.getObjects());
		return result;
	}
	/**
	 * 根据类型（省，市，县区）查询评比活动
	 * @author TMACJ
	 * @param request
	 * @return
	 */
	@RequestMapping("queryComparisonByType.do")
	public @ResponseBody Map<String,Object> queryComparisonByType(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		String comparisonName = request.getParameter("comparisonName");
		String comparisonType = request.getParameter("comparisonType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		Integer startIndex = 0;
		Integer pageSize = 10;
		EduUserActivty obj = getSessionUserInfo(request);//比较role_id和create_level的值，过滤掉不符合的项目活动
		String roleId = String.valueOf(obj.getRoleId().intValue());
		if(id != null){//查询单个
			condition.put("id", id);
		}else{
			startIndex = Integer.parseInt(request.getParameter("startIndex"));
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			startIndex = (startIndex - 1) * pageSize;
			condition.put("startIndex", startIndex);
			condition.put("pageSize", pageSize);
		}
		
		condition.put("status", StringUtils.isEmpty(status) ? null : status);
		condition.put("comparisonName", StringUtils.isEmpty(comparisonName) ? null : comparisonName);
		condition.put("comparisonType", StringUtils.isEmpty(comparisonType) ? null : comparisonType);
		condition.put("startDate", StringUtils.isEmpty(startDate) ? null : startDate);
		condition.put("endDate", StringUtils.isEmpty(endDate) ? null : endDate);
		condition.put("roleId", StringUtils.isEmpty(roleId) ? null : roleId);
		
		PageObject pageObject = eduMasterService.queryComparisonByType(condition);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, pageObject.getCount()), pageObject);
		result.put("success",true);
		result.put("total", pageObject.getCount());
		result.put("pageSize", pageObject.getPagesize());
		result.put("pages", pageObject.getPages());
		result.put("currentPage", pageObject.getCurrentPage());
		result.put("pageNumbers", pageObject.getPageNumbers());
		result.put("startIndex", pageObject.getStartIndex());
		result.put("rows", pageObject.getObjects());
		return result;
	}
	
	/**
	 * 查询教师
	 * @param request
	 * @return
	 */
	@RequestMapping("queryComparisonTeacher.do")
	public @ResponseBody Map<String,Object> queryComparisonTeacher(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String teacherId = request.getParameter("teacherId");
		String comparisonId = request.getParameter("comparisonId");
		String teacherName = request.getParameter("teacherName");
		Integer startIndex = Integer.parseInt(request.getParameter("startIndex"));
		Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
		startIndex = (startIndex - 1) * pageSize;
		condition.put("teacherName", StringUtils.isEmpty(teacherName)?null:teacherName);
		condition.put("startIndex", startIndex);
		condition.put("pageSize", pageSize);
		condition.put("comparisonId", comparisonId);
		if(getRoleId(request) == 4){
			condition.put("schoolId", getSchoolId(request));
		}
		
		if(teacherId != null){//查询某一个报名教师
			condition.put("teacherId", teacherId);
		}
		PageObject pageObject = eduMasterService.queryComparisonTeacher(condition);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, pageObject.getCount()), pageObject);
		result.put("success",true);
		result.put("rows", pageObject.getObjects());
		result.put("total", pageObject.getCount());
		result.put("pageSize", pageObject.getPagesize());
		result.put("pages", pageObject.getPages());
		result.put("currentPage", pageObject.getCurrentPage());
		result.put("pageNumbers", pageObject.getPageNumbers());
		result.put("startIndex", pageObject.getStartIndex());
		
		return result;
	}
	/**
	 * 教师报名评比活动（逐个）
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("signUpComparisonTeacher.do")
	public @ResponseBody Map<String,Object> signUpComparisonTeacher(HttpServletRequest request,HttpServletResponse response,EduComparisonComment ecc, MultipartHttpServletRequest mrequest) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("comparisonId", request.getParameter("comparisonId"));
		if(getRoleId(mrequest) == 4){
			condition.put("schoolId", getSchoolId(mrequest));
		}
//		PageObject po =  eduMasterService.queryComparison(condition);
//		EduComparison ec = (EduComparison) po.getObjects().get(0);
//		if(Integer.parseInt(ec.getSignupNum()) >= Integer.parseInt(ec.getComparisonPlanNum())){
//			result.put("success", false);
//			result.put("message", "已报名人数已达上限");
//			return result;
//		}
		
		condition.put("idNumber", request.getParameter("idNumber"));
		condition.put("subjectId", request.getParameter("subjectId"));
		condition.put("subjectName", request.getParameter("subjectName"));
		condition.put("sectionId", request.getParameter("sectionId"));
		condition.put("sectionName", request.getParameter("sectionName"));
		condition.put("teacherName", request.getParameter("teacherName"));
		condition.put("phone", request.getParameter("phone"));
		condition.put("schoolId", request.getParameter("schoolId"));
		condition.put("schoolName", request.getParameter("schoolName"));
		condition.put("teacherImg", request.getParameter("imageSrcTemp"));
		condition.put("createBy", getAccountId(mrequest));
		condition.put("memo", request.getParameter("memo"));
		condition.put("status", "1");//添加教师，此时为报名状态为1
		List<MultipartFile> files = mrequest.getFiles("file");
		int id = eduMasterService.signUpComparisonTeacher(condition);
		if(id > 0){
			if(files.size()>0 && files.get(0).getSize() >0){
				result = fileUploadService.fileUpload(request, response, FileType.COMPARISON_SIGNUP, id, ecc.getTeacherName(),
					getAccountId(request), getAccount(request), getRoleId(request));
				if((Boolean) result.get("success")){
//					//成功
					result.put("success", true);
					result.put("message", "添加成功");
				}else{
//					//上传文件失败，但是添加自主成功，需删除
//					teacherWriteDao.deleteIndeptStudy(isId);
//					result.put("success", false);
//					result.put("message", result.get("info"));
				}
			}else{
				result.put("success", true);
				result.put("message", "添加成功");
			}
		}else{
			result.put("success", false);
			result.put("message", "添加失败");
		}
		return result;
	}
	
	/**
	 * 教师取消报名评比活动（逐个）
	 * @param request
	 * @return
	 */
	@RequestMapping("canelSignUpComparisonTeacher.do")
	public @ResponseBody Map<String,Object> canelSignUpComparisonTeacher(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		String teacherId = request.getParameter("teacherId");
		condition.put("comparisonId", comparisonId);
		condition.put("teacherId", teacherId);
		condition.put("updateBy", getAccountId(request));
		
		if(eduMasterService.canelSignUpComparisonTeacher(condition)){
			result.put("success",true);
			result.put("message","取消成功");
		}else{
			result.put("success",false);
			result.put("message","取消失败");
		}
		return result;
	}
	/**
	 * 教师报名评比活动（批量）
	 * @param request
	 * @return
	 */
	@RequestMapping("signupComparisonBatch.do")
	public @ResponseBody Map<String,Object> signupComparisonBatch(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		String teacherIds = request.getParameter("teacherIds");
		
		//查询是否有已经报名的教师
		condition.put("status", "11,12,13,3");
		condition.put("comparisonId", comparisonId);
		condition.put("teacherIds", teacherIds);
		condition.put("createBy", getAccountId(request));
		List<EduComparisonComment> list = eduMasterService.querySignUpComparisonTeacher(condition);
		if(list.size() > 0){//包含已经报名的教师
			result.put("success",false);
			result.put("message","存在已报名教师");
		}else{
			if(eduMasterService.signUpComparisonTeacherBatch(condition)){
				result.put("success",true);
				result.put("message","报名成功");
			}else{
				result.put("success",false);
				result.put("message","报名失败");
			}
		}
		return result;
	}
	/**
	 * 教师取消报名评比活动（批量）
	 * @param request
	 * @return
	 */
	@RequestMapping("canelSignupComparisonBatch.do")
	public @ResponseBody Map<String,Object> canelSignupComparisonBatch(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		String teacherIds = request.getParameter("teacherIds");
		
		//查询是否有已经报名的教师
		condition.put("status", "0,2");
		condition.put("comparisonId", comparisonId);
		condition.put("teacherIds", teacherIds);
		condition.put("updateBy", getAccountId(request));
		List<EduComparisonComment> list = eduMasterService.querySignUpComparisonTeacher(condition);
		if(list.size() > 0){//包含已经报名的教师
			result.put("success",false);
			result.put("message","存在未报名教师");
		}else{
			if(eduMasterService.canelSignUpComparisonTeacherBatch(condition)){
				result.put("success",true);
				result.put("message","取消报名成功");
			}else{
				result.put("success",false);
				result.put("message","取消报名失败");
			}
		}
		return result;
	}
	/**
	 * 查看教师报名评比活动
	 * @param request
	 * @return
	 */
	@RequestMapping("queryComparisonCommntTeacher.do")
	public @ResponseBody Map<String,Object> queryComparisonCommntTeacher(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		String teacherName = request.getParameter("teacherName");
		String areaId = request.getParameter("areaId");
		String areaType = request.getParameter("areaType");
		Integer startIndex = Integer.parseInt(request.getParameter("startIndex"));
		Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
		startIndex = (startIndex - 1) * pageSize;
		if(areaType.equals("provinceId")){
			condition.put("provinceId", areaId);
		}else if(areaType.equals("cityId")){
			condition.put("cityId", areaId);
		}else if(areaType.equals("districtId")){
			condition.put("districtId", areaId);
		}else if(areaType.equals("schoolId")){
			condition.put("schoolId", areaId);
		}
		condition.put("teacherName", StringUtils.isEmpty(teacherName)?null:teacherName);
		condition.put("status", "11,12,13,3");
		condition.put("comparisonId", comparisonId);
		condition.put("startIndex", startIndex);
		condition.put("pageSize", pageSize);
		
		List<EduComparisonComment> list = eduMasterService.querySignUpComparisonTeacher(condition);
		PageObject po = new PageObject();
		po.setCount(eduMasterService.querySignUpComparisonTeacherCount(condition));
		po.setObjects(list);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		result.put("success",true);
		result.put("rows", po.getObjects());
		result.put("total", po.getCount());
		result.put("pageSize", po.getPagesize());
		result.put("pages", po.getPages());
		result.put("currentPage", po.getCurrentPage());
		result.put("pageNumbers", po.getPageNumbers());
		result.put("startIndex", po.getStartIndex());
		return result;
	}
	/**
	 * 根据ID查看教师报名评比活动（目前暂时无分页功能）
	 * @author TMACJ
	 * @param request
	 * @return
	 *//*
	@RequestMapping("queryComparisonCommntTeacherById.do")
	public @ResponseBody Map<String,Object> queryComparisonCommntTeacherById(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		condition.put("comparisonId", comparisonId);
		PageObject po = eduMasterService.querySignUpComparisonTeacherById(condition);
		result.put("success",true);
		result.put("rows", po.getObjects());
		return result;
	}*/
	/**
	 * 为项目创建专家
	 * @param request
	 * @return
	 */
	@RequestMapping("createMaster.do")
	public @ResponseBody Map<String,Object> createMaster(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		String masterNum = request.getParameter("masterNum");
		String roleId = request.getParameter("roleId");
		condition.put("comparisonId", comparisonId);
		condition.put("masterNum", masterNum);
		condition.put("createBy", getAccountId(request));
		condition.put("roleId", roleId);
		if(eduMasterService.createMaster(condition)){
			result.put("success", true);
			result.put("message", "创建成功");
		}else{
			result.put("success", false);
			result.put("message", "创建失败");
		}
		return result;
	}
	/**
	 * 为项目创建专家(逐条)
	 * @param request
	 * @return
	 */
	@RequestMapping("createMasterOne.do")
	public @ResponseBody Map<String,Object> createMasterOne(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String roleId = request.getParameter("roleId");
		String masterImg = request.getParameter("masterImg");
		String masterName = request.getParameter("masterName");
		String loginAccount = request.getParameter("loginAccount");
		String password = request.getParameter("password");
		condition.put("roleId", roleId);
		condition.put("masterImg", masterImg);
		condition.put("realName", masterName);
		condition.put("loginAccount", loginAccount);
		condition.put("password", password);
		condition.put("createBy", getAccountId(request));
		condition.put("status", 8);
		
		List<EduUser> userList = eduMasterService.queryMaster(condition);
		
		if(userList.size() > 0){
			result.put("success", false);
			result.put("type", 1);
			result.put("message", "该用户名已经存在");
			return result;
		}
		
		if(eduMasterService.createMasterOne(condition)){
			result.put("success", true);
			result.put("message", "创建成功");
		}else{
			result.put("success", false);
			result.put("message", "创建失败");
		}
		return result;
	}
	
	/**
	 * 查找活动专家
	 * @param request
	 * @return
	 */
	@RequestMapping("queryComparisonMaster.do")
	public @ResponseBody Map<String,Object> queryComparisonMaster(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		String roleId = request.getParameter("roleId");
		String masterId = request.getParameter("masterId");
		String masterName = request.getParameter("masterName");
		String loginAccount = request.getParameter("loginAccount");
		Integer startIndex = 0;
		Integer pageSize = 10;
		if(masterId == null){
			startIndex = Integer.parseInt(request.getParameter("startIndex"));
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			startIndex = (startIndex - 1) * pageSize;
			condition.put("startIndex", startIndex);
			condition.put("pageSize", pageSize);
		}
		
		condition.put("comparisonId", comparisonId);
		condition.put("roleId", roleId);
		condition.put("masterId", masterId);
		condition.put("masterName", StringUtils.isEmpty(masterName)?null:masterName);
		condition.put("loginAccount", StringUtils.isEmpty(loginAccount)?null:loginAccount);
		PageObject pageObject  = eduMasterService.queryComparisonMaster(condition);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, pageObject.getCount()), pageObject);
		result.put("success",true);
		result.put("rows", pageObject.getObjects());
		result.put("total", pageObject.getCount());
		result.put("pageSize", pageObject.getPagesize());
		result.put("pages", pageObject.getPages());
		result.put("currentPage", pageObject.getCurrentPage());
		result.put("pageNumbers", pageObject.getPageNumbers());
		result.put("startIndex", pageObject.getStartIndex());
		return result;
	}
	/**
	 * 为专家添加活动
	 * @param request
	 * @return
	 */
	@RequestMapping("saveComparisonToMaster.do")
	public @ResponseBody Map<String,Object> saveComparisonToMaster(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonIds = request.getParameter("comparisonIds");
		String masterId = request.getParameter("masterId");
		condition.put("comparisonIds", comparisonIds);
		condition.put("masterId", masterId);
		condition.put("createBy", getAccountId(request));
		//设置新的选项前。删除
		eduMasterService.deleteComparisonToMaster(condition);
		if(eduMasterService.saveComparisonToMaster(condition)){
			result.put("success", true);
			result.put("message", "保存成功");
		}else{
			result.put("success", false);
			result.put("message", "保存失败");
		}
		
		return result;
	}
	
	/**
	 * 查询评比活动(专家分配评比活动)
	 * @param request
	 * @return
	 */
	@RequestMapping("queryComparisonCheck.do")
	public @ResponseBody Map<String,Object> queryComparisonCheck(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String masterId = request.getParameter("masterId");
		String status = request.getParameter("status");
		condition.put("status", status);
		condition.put("masterId", masterId);
		PageObject pageObject = eduMasterService.queryComparisonCheck(condition);
		
		result.put("rows", pageObject.getObjects());
		return result;
	}
	
	/**
	 * 设置专家状态
	 * @param request
	 * @return
	 */
	@RequestMapping("setMasterStatus.do")
	public @ResponseBody Map<String,Object> setMasterStatus(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		condition.put("status", status);
		condition.put("id", id);
		if(eduMasterService.setMasterStatus(condition)){
			result.put("success", true);
			result.put("message", "设置成功");
		}else{
			result.put("success", false);
			result.put("message", "设置失败");
		}
		return result;
	}
	/**
	 * 刪除活動的文件
	 * @param request
	 * @return
	 */
	@RequestMapping("delComprisonFile.do")
	public @ResponseBody Map<String,Object> delComprisonFile(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String id = request.getParameter("id");
		condition.put("id", id);
		if(eduMasterService.delComprisonFile(condition)){
			result.put("success", true);
		}else{
			result.put("success", false);
			result.put("message", "设置失败");
		}
		return result;
	}
	

	/**
	 * 设置活動状态
	 * @param request
	 * @return
	 */
	@RequestMapping("setComparisonStatus.do")
	public @ResponseBody Map<String,Object> setComparisonStatus(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		String roleId = request.getParameter("roleId");
		condition.put("status", status);
		condition.put("roleId", roleId);
		condition.put("updateBy", getAccountId(request));
		condition.put("id", id);
		if(eduMasterService.setComparisonStatus(condition)){
			if(status.equals("2")){
				condition.clear();
//				eduMasterService.updateComparisonMasterDisable(condition);
				condition.put("status", 5);
				condition.put("conditionStatus", 4);
				condition.put("comparisonId", id);
				eduMasterService.updateComparisonCommentStatus(condition);
			}
			result.put("success", true);
			result.put("message", "设置成功");
		}else{
			result.put("success", false);
			result.put("message", "设置失败");
		}
		return result;
	}
	/**
	 * 获得地区
	 * @param request
	 * @return
	 */
	@RequestMapping("getArea.do")
	public @ResponseBody Map<String,Object> getArea(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String fatherCode = request.getParameter("id");
		String code = request.getParameter("code");
		condition.put("fatherCode", fatherCode);
		condition.put("code", code);
		List<SysArea> list = eduMasterService.getArea(condition);
		result.put("rows", list);
		return result;
	}
	/**
	 * 获得学校
	 * @param request
	 * @return
	 */
	@RequestMapping("getSchool.do")
	public @ResponseBody Map<String,Object> getSchool(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String areaType = request.getParameter("areaType");
		String areaId = request.getParameter("areaId");
		if(areaType.equals("provinceId")){
			condition.put("provinceId", areaId);
		}else if(areaType.equals("cityId")){
			condition.put("cityId", areaId);
		}else if(areaType.equals("districtId")){
			condition.put("districtId", areaId);
		}
		condition.put("areaId", areaId);
		List<EduSchool> list = eduMasterService.getSchool(condition);
		result.put("rows", list);
		return result;
	}
	
	/**
	 * 教师报名评比活动（逐个）
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("updateSignUpComparisonTeacher.do")
	public @ResponseBody Map<String,Object> updateSignUpComparisonTeacher(HttpServletRequest request,HttpServletResponse response,EduComparisonComment ecc, MultipartHttpServletRequest mrequest) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("comparisonId", request.getParameter("comparisonId"));
		condition.put("idNumber", request.getParameter("idNumber"));
		condition.put("section", request.getParameter("section"));
		condition.put("teacherName", request.getParameter("teacherName"));
		condition.put("subject", request.getParameter("subject"));
		condition.put("phone", request.getParameter("phone"));
		condition.put("schoolName", request.getParameter("schoolName"));
		String teacherImg = request.getParameter("imageSrcTemp");
		condition.put("teacherImg", StringUtils.isEmpty(teacherImg)?null:teacherImg);
		condition.put("updateBy", getAccountId(mrequest));
		condition.put("memo", request.getParameter("memo"));
		condition.put("id", request.getParameter("id"));
		condition.put("status", "1");//添加教师，此时为报名状态为1
		List<MultipartFile> files = mrequest.getFiles("file");
		int id = eduMasterService.updateSignUpComparisonTeacher(condition);
		if(id > 0){
			if(files.size()>0 && files.get(0).getSize() >0){
				result = fileUploadService.fileUpload(request, response, FileType.COMPARISON_SIGNUP, Integer.parseInt(request.getParameter("id")), ecc.getTeacherName(),
					getAccountId(request), getAccount(request), getRoleId(request));
				if((Boolean) result.get("success")){
//					//成功
					result.put("success", true);
					result.put("message", "修改成功");
				}else{
//					//上传文件失败，但是添加自主成功，需删除
//					teacherWriteDao.deleteIndeptStudy(isId);
//					result.put("success", false);
//					result.put("message", result.get("info"));
				}
			}else{
				result.put("success", true);
				result.put("message", "修改成功");
			}
		}else{
			result.put("success", false);
			result.put("message", "新增失败");
		}
		return result;
	}
	
	/**
	 * 删除录入教师
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("deleteComparisonTeacher.do")
	public @ResponseBody Map<String,Object> deleteComparisonTeacher(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("id", request.getParameter("teacherId"));
			if(eduMasterService.canelSignUpComparisonTeacher(condition)){
				result.put("success", true);
				result.put("message", "删除成功");
			}else{
				result.put("success", false);
				result.put("message", "删除失败");
			}
		return result;
	}
	
	/**
	 * 修改教师状态
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("updateComparisonCommentStatus.do")
	public @ResponseBody Map<String,Object> updateComparisonCommentStatus(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		condition.put("comparisonId", comparisonId);
		if(getRoleId(request) == 4){
			condition.put("schoolId", getSchoolId(request));
		}
		PageObject po =  eduMasterService.queryComparison(condition);
		EduComparison ec = (EduComparison) po.getObjects().get(0);
		if(Integer.parseInt(ec.getSignupNum()) >= Integer.parseInt(ec.getComparisonPlanNum())){
			result.put("success", false);
			result.put("message", "已报名人数已达上限");
			return result;
		}
		
		condition.put("id", request.getParameter("teacherId"));
		condition.put("status", request.getParameter("status"));
			if(eduMasterService.updateComparisonCommentStatus(condition)){
				result.put("success", true);
				result.put("message", "修改成功");
			}else{
				result.put("success", false);
				result.put("message", "修改失败");
			}
		return result;
	}
	/**
	 * 查询审核意见
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("queryMemo.do")
	public @ResponseBody Map<String,Object> queryMemo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("id", request.getParameter("id"));
		List<EduComparisonComment> list = eduMasterService.queryMemo(condition);
		result.put("rows", list);
		result.put("success", true);
		return result;
	}
	/**
	 * 查询审核意见
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("queryComparisonByMaster.do")
	public @ResponseBody Map<String,Object> queryComparisonByMaster(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String status = request.getParameter("status");
		String comparisonName = request.getParameter("comparisonName");
		String comparisonType = request.getParameter("comparisonType");
		condition.put("id", getAccountId(request));//专家的ID
		Integer startIndex = 0;
		Integer pageSize = 10;
		startIndex = Integer.parseInt(request.getParameter("startIndex"));
		pageSize = Integer.parseInt(request.getParameter("pageSize"));
		startIndex = (startIndex - 1) * pageSize;
		condition.put("startIndex", startIndex);
		condition.put("pageSize", pageSize);
		condition.put("status", StringUtils.isEmpty(status) ? null : status);
		condition.put("comparisonName", StringUtils.isEmpty(comparisonName) ? null : comparisonName);
		condition.put("comparisonType", StringUtils.isEmpty(comparisonType) ? null : comparisonType);
		PageObject pageObject = eduMasterService.queryComparisonByMaster(condition);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, pageObject.getCount()), pageObject);
		result.put("success",true);
		result.put("rows", pageObject.getObjects());
		result.put("total", pageObject.getCount());
		result.put("pageSize", pageObject.getPagesize());
		result.put("pages", pageObject.getPages());
		result.put("currentPage", pageObject.getCurrentPage());
		result.put("pageNumbers", pageObject.getPageNumbers());
		result.put("startIndex", pageObject.getStartIndex());
		return result;
	}
	
	/**
	 * 专家给教师打分
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("judgeScore.do")
	public @ResponseBody Map<String,Object> judgeScore(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("masterId", getAccountId(request));//专家的ID
		condition.put("teacherId", request.getParameter("teacherId"));//教师的ID
		condition.put("comparisonId", request.getParameter("comparisonId"));//活动的ID
		condition.put("score", request.getParameter("score"));//教师的ID
		condition.put("isPass", request.getParameter("isPass"));//是否通过
		condition.put("memo", request.getParameter("memo"));//评审意见
		condition.put("createBy", getAccountId(request));//评审意见
		if(eduMasterService.judgeScore(condition)){
			result.put("success", true);
			result.put("message", "评分成功");
		}else{
			result.put("success", false);
			result.put("message", "评分失败");
		}
		return result;
	}
	/**
	 * 查询教师评分
	 * @param request
	 * @return
	 */
	@RequestMapping("queryComparisonTeacherScore.do")
	public @ResponseBody Map<String,Object> queryComparisonTeacherScore(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		String teacherName = request.getParameter("teacherName");
		Integer startIndex = Integer.parseInt(request.getParameter("startIndex"));
		Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
		String judgeType = request.getParameter("judgeType");
		startIndex = (startIndex - 1) * pageSize;
		condition.put("teacherName", StringUtils.isEmpty(teacherName)?null:teacherName);
		condition.put("startIndex", startIndex);
		condition.put("pageSize", pageSize);
		condition.put("comparisonId", comparisonId);
		condition.put("masterId", getAccountId(request));
		if(!StringUtil.isEmpty(judgeType)){
			if(Integer.parseInt(judgeType) == 1)condition.put("judgeType", "is not");
			if(Integer.parseInt(judgeType) == 0)condition.put("judgeType", "is");
		}
		
		PageObject pageObject = eduMasterService.queryComparisonTeacherScore(condition);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, pageObject.getCount()), pageObject);
		result.put("success",true);
		result.put("rows", pageObject.getObjects());
		result.put("total", pageObject.getCount());
		result.put("pageSize", pageObject.getPagesize());
		result.put("pages", pageObject.getPages());
		result.put("currentPage", pageObject.getCurrentPage());
		result.put("pageNumbers", pageObject.getPageNumbers());
		result.put("startIndex", pageObject.getStartIndex());
		
		return result;
	}
	
	/**
	 * 查询教师评分
	 * @param request
	 * @return
	 */
	@RequestMapping("quertTeacherComment.do")
	public @ResponseBody Map<String,Object> quertTeacherComment(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		String teacherName = request.getParameter("teacherName");
		String teacherId = request.getParameter("teacherId");
		String status = request.getParameter("status");
		String lvIsAudit = request.getParameter("lvIsAudit");
		String roleId = request.getParameter("roleId");
		Integer startIndex = 0;
		Integer pageSize = 10;
		if(teacherId == null){
			startIndex = Integer.parseInt(request.getParameter("startIndex"));
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			startIndex = (startIndex - 1) * pageSize;
			condition.put("startIndex", startIndex);
			condition.put("pageSize", pageSize);
		}
		condition.put("status", status);
		condition.put("comparisonId", comparisonId);
		condition.put("teacherName", StringUtils.isEmpty(teacherName)?null:teacherName);
		condition.put("teacherId", StringUtils.isEmpty(teacherId)?null:teacherId);
		
		condition.put("lvIsAudit", StringUtils.isEmpty(lvIsAudit)?null:lvIsAudit);
		if(roleId != null){
			if(roleId.equals("3")){
				condition.put("districtId", getUserDistrictId(request));
			}else if(roleId.equals("2")){
				condition.put("cityId", getUserCityId(request));
			}
		}
		
		PageObject pageObject = eduMasterService.queryTeacherComment(condition);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, pageObject.getCount()), pageObject);
		result.put("success",true);
		result.put("rows", pageObject.getObjects());
		result.put("total", pageObject.getCount());
		result.put("pageSize", pageObject.getPagesize());
		result.put("pages", pageObject.getPages());
		result.put("currentPage", pageObject.getCurrentPage());
		result.put("pageNumbers", pageObject.getPageNumbers());
		result.put("startIndex", pageObject.getStartIndex());
		
		return result;
	}
	/**
	 * 查询各个专家给该教师打分
	 * @param request
	 * @return
	 */
	@RequestMapping("queryMasterScore.do")
	public @ResponseBody Map<String,Object> queryMasterScore(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		String teacherId = request.getParameter("teacherId");
		condition.put("comparisonId", comparisonId);
		condition.put("teacherId", teacherId);
		List<EduComparisonComment> list= eduMasterService.queryMasterScore(condition);
		result.put("success",true);
		result.put("rows", list);
		
		return result;
	}
	/**
	 * 修改专家
	 * @param request
	 * @return
	 */
	@RequestMapping("updateMasterOne.do")
	public @ResponseBody Map<String,Object> updateMasterOne(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String masterImg = request.getParameter("masterImg");
		String masterName = request.getParameter("masterName");
		String loginAccount = request.getParameter("loginAccount");
		String password = request.getParameter("password");
		String masterId = request.getParameter("masterId");
		condition.put("masterImg", StringUtils.isEmpty(masterImg)?null:masterImg);
		condition.put("realName", masterName);
		condition.put("loginAccount", loginAccount);
		condition.put("password", password);
		condition.put("updateBy", getAccountId(request));
		condition.put("masterId", masterId);
		
		List<EduUser> userList = eduMasterService.queryMaster(condition);
		
		if(userList.size() > 0 && userList.get(0).getId() != Integer.parseInt(masterId)){
			result.put("success", false);
			result.put("type", 1);
			result.put("message", "该用户名已经存在");
			return result;
		}
		
		if(eduMasterService.updateMasterOne(condition)){
			result.put("success", true);
			result.put("message", "修改成功");
		}else{
			result.put("success", false);
			result.put("message", "修改失败");
		}
		return result;
	}
	
	/**
	 * 检测日期
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("checkDate.do")
	public @ResponseBody Map<String,Object> checkDate(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException{
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		String type = request.getParameter("type");
		condition.put("comparisonId", comparisonId);
		PageObject pageObject = eduMasterService.queryComparison(condition);
		EduComparison ec = (EduComparison) pageObject.getObjects().get(0);

		String signupStartDate = ec.getSignupStartDate();
		String sighupEndDate = ec.getSignupEndDate();
		String auditStartDate = ec.getAuditStartDate();
		String auditEndDate = ec.getAuditEndDate();
		String now = DateUtil.getSystemTimeFormat("yyyy-MM-dd");
		
		
		if(type.equals("signup")){
			if(now.compareTo(signupStartDate) < 0){
				result.put("success", false);
				result.put("message", "未到开始报名日期");
				return result;
			}
			
			if(sighupEndDate.compareTo(now) < 0){
				result.put("success", false);
				result.put("message", "已过报名截止日期");
				return result;
			}
		}else if(type.equals("audit")){
			if(now.compareTo(auditStartDate) < 0){
				result.put("success", false);
				result.put("message", "未到开始审核日期");
				return result;
			}
			
			if(auditEndDate.compareTo(now) < 0){
				result.put("success", false);
				result.put("message", "已过审核截止日期");
				return result;
			}
		}
		result.put("success", true);
		return result;
	}
	
	/**
	 * 导出专家数据模板
	 * @throws IOException 
	 */
	@RequestMapping("downMasterTemplate.do")
	public void downMasterTemplate(HttpServletRequest request,HttpServletResponse response) throws IOException {

		try {
			String path = request.getRealPath("/") + "template"
					+ File.separator + "import_master.xls";
			FileInputStream io = new FileInputStream(path);
			// 创建 excel
			Workbook wb = new HSSFWorkbook(io);
			exportExcelFromTemplet(request, response, wb, "import_master","xls");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("导出专家模板错误:" + e);
		}
	}
	/**
	 *	检测上传的专家
	 */
	@RequestMapping("/checkUploadMaster.do")
	public @ResponseBody Map<String,Object> checkUploadMaster(HttpServletRequest request,String path){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			result = sysService.parseExcel(projectPath + path, "master", null);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 提交批量导入专家信息
	 */
	@RequestMapping("/submitUploadMaster.do")
	public @ResponseBody Map<String,Object> submitUploadMaster(HttpServletRequest request,String path){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("account", super.getAccount(request));
		
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		path = projectPath + ApplicationProperties.getPropertyValue("upload_file_path")+path.replace("/",File.separator);
		try {
			result = eduMasterService.intoDB(path, super.getAccount(request));
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 查看某一专家对某一活动的评审列表
	 */
	@RequestMapping("/quertJudgeDetail.do")
	public @ResponseBody Map<String,Object> quertJudgeDetail(HttpServletRequest request,String path){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		String masterId = request.getParameter("masterId");
		Integer startIndex = Integer.parseInt(request.getParameter("startIndex"));
		Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
		startIndex = (startIndex - 1) * pageSize;
		condition.put("startIndex", startIndex);
		condition.put("pageSize", pageSize);
		condition.put("comparisonId", comparisonId);
		condition.put("masterId", masterId);
		PageObject pageObject = eduMasterService.quertJudgeDetail(condition);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, pageObject.getCount()), pageObject);
		result.put("success",true);
		result.put("rows", pageObject.getObjects());
		result.put("total", pageObject.getCount());
		result.put("pageSize", pageObject.getPagesize());
		result.put("pages", pageObject.getPages());
		result.put("currentPage", pageObject.getCurrentPage());
		result.put("pageNumbers", pageObject.getPageNumbers());
		result.put("startIndex", pageObject.getStartIndex());
		
		return result;
	}
	

	/**
	 * 查看可用专家
	 */
	@RequestMapping("/queryMaster.do")
	public @ResponseBody Map<String,Object> queryMaster(HttpServletRequest request,String path){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		condition.put("comparisonId", comparisonId);
		condition.put("status", "8");
		List<EduComparisonMaster> list = eduMasterService.queryMasterAvailable(condition);
		result.put("success", true);
		result.put("rows", list);
		return result;
	}
	/**
	 * 为活动分配专家
	 * @param request
	 * @return
	 */
	@RequestMapping("saveMasterToComparison.do")
	public @ResponseBody Map<String,Object> saveMasterToComparison(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String comparisonId = request.getParameter("comparisonId");
		String masterIds = request.getParameter("masterIds");
		condition.put("comparisonId", comparisonId);
		condition.put("masterIds", masterIds);
		condition.put("createBy", getAccountId(request));
		//设置新的选项前。删除
		eduMasterService.deleteComparisonToMaster(condition);
		if(eduMasterService.saveComparisonToMaster(condition)){
			result.put("success", true);
			result.put("message", "保存成功");
		}else{
			result.put("success", false);
			result.put("message", "保存失败");
		}
		
		return result;
	}
	
	
/**
 * 根据ID更新报名教师状态
 */
@RequestMapping("updateTeacherStatus.do")
public @ResponseBody Map<String,Object> modifiyTeacherStatus(HttpServletRequest request) {
	Map<String, Object> condition = new HashMap<String, Object>();
	Map<String,Object> resultMap = new HashMap<String, Object>();
	Integer comparisonId = Integer.parseInt(request.getParameter("comparisonId"));
	Integer id = Integer.parseInt(request.getParameter("teacherId"));
	String memoName = request.getParameter("memoName");
	String memoVal = request.getParameter("memoVal");
	String memoDateName = request.getParameter("memoDateName");
	String reviewResult = request.getParameter("reviewResult");
	String status = "";
	condition.put("comparisonId", comparisonId);
	PageObject po = eduMasterService.queryComparison(condition);
	EduComparison comparison = (EduComparison) po.getObjects().get(0);
	if(reviewResult.equals("unPass")){
		status = "2";
	}else{
		if(getRoleId(request) == 1){
			status = "13";
		}else if(getRoleId(request) == 2){
			status = "12";
		}else if(getRoleId(request) == 3){
			status = "11";
		}
		
		if(Integer.parseInt(comparison.getCreateLevel()) == getRoleId(request)){
			status = "4";
		}

	}

	condition.put("id", id);
	condition.put("memoName", memoName);
	condition.put("memoVal", memoVal);
	condition.put("status", status);
	condition.put("memoDateName", memoDateName);
	boolean bResult = eduMasterService.updateTeacherStatus(condition);
	resultMap.put("success", bResult);
	return resultMap;
}
}
