package project.teacher.teacherProject.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.cxf.common.util.StringUtils;
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
import project.dictionary.service.IDictionaryService;
import project.edupm.projectmanage.controller.SummaryController;
import project.edupm.projectmanage.dto.EduProjectDTO;
import project.edupm.projectmanage.pojo.EduPaper;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduProjectComment;
import project.edupm.projectmanage.pojo.EduQuestion;
import project.edupm.projectmanage.pojo.EduResponse;
import project.edupm.projectmanage.pojo.EduResponseQuestion;
import project.edupm.projectmanage.service.IEduProjectService;
import project.edupm.projectmanage.service.ISummaryService;
import project.fileupload.pojo.FileType;
import project.fileupload.service.IFileUploadService;
import project.furtheredu.certificate.pojo.EduDiploma;
import project.furtheredu.edumanage.service.IEduManageService;
import project.organization.pojo.Organization;
import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;
import project.system.pojo.EduCreditLend;
import project.system.pojo.EduTeacherScoreInfo;
import project.system.pojo.SysArea;
import project.system.pojo.SysDictionary;
import project.system.service.ISysService;
import project.teacher.teacherProject.pojo.EduAudit;
import project.teacher.teacherProject.pojo.EduIndependentStudy;
import project.teacher.teacherProject.pojo.EduProjectPojo;
import project.teacher.teacherProject.pojo.EduProjectTrainTargetActitity;
import project.teacher.teacherProject.pojo.EduTeacherOldSchool;
import project.teacher.teacherProject.service.ITeacherProjectServiceIF;
import project.teacher.teachermanage.dao.ITeacherReadDao;
import project.teacher.teachermanage.dao.ITeacherWriteDao;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherJob;
import project.teacher.teachermanage.pojo.EduTeacherMobilize;
import project.teacher.teachermanage.pojo.EduTeacherVersionPOJO;
import project.teacher.teachermanage.service.ITeacherManageService;
import project.util.DataUtil;
import project.util.DesTool;
import framelib.controller.AbsController;
import framelib.utils.DateUtil;
import framelib.utils.StringUtil;
import framelib.utils.page.PageObject;

/**
 * 教师正在参加培训的项目
 * 
 * @Create_by:yinxiaolong
 * @Create_date:2014-3-27
 * @Last_Edit_By:
 * @Edit_Description
 * @version:1.0
 * 
 */
@Controller
@RequestMapping("/teacher/teacherProject")
public class TeacherController extends AbsController{
	private static final Logger log = Logger.getLogger(TeacherController.class);
	
	
	@Autowired
	@Qualifier("fileUploadService")
	IFileUploadService fileUploadService;
	
	@Autowired
	@Qualifier("summaryService")
	ISummaryService summaryService;
	
	@Autowired
	@Qualifier("teacherProjectService")
	ITeacherProjectServiceIF teacherProjectServiceIF;
	
	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;
	
	@Autowired
	@Qualifier("teacherManageService")
	ITeacherManageService teacherManageService;
	
	@Autowired
	@Qualifier("sysService")
	ISysService sysService;
	
	
	@Autowired
	@Qualifier("teacherReadDao")
	ITeacherReadDao teacherReadDao;
	
	@Autowired
	@Qualifier("teacherWriteDao")
	ITeacherWriteDao teacherWriteDao;
	

	@Autowired
	@Qualifier("eduManageService")
	IEduManageService eduManageService;
	

	@Autowired
	@Qualifier("dictionaryService")
	IDictionaryService dictionaryService;
	/**
	 * 市管理员教师信息导入页面跳转
	 * @return
	 */
	@RequestMapping(value = "importTeacherPage.htm")
	public String importTeacherPage() {
		return "teacher/importTeacher";
	}
	
	@RequestMapping(value = "teacherInfoChangeCommon.htm")
	public String teacherInfoChangeCommon(String auditId, ModelMap map) {
		map.put("auditId", auditId);
		return "teacher/teacherInfoChangeCommon";
	}
	
	
	/**
	 * 正在参加的项目培训页面列表
	 * @return
	 */
	@RequestMapping(value = "teacherProjectListPage.htm")
	public String teacherProjectListPage() {
		return "teacher/teacherProject";
	}
	
	/**
	 * 跳转到老师培训总结的页面
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "toTeacherProSummaryList.htm")
	public String toTeacherProSummaryList(HttpServletRequest request, HttpServletResponse response,ModelMap map){
		return "teacher/summary/teacherSummaryList";
	}
	
	/**
	 * 问卷调查项目列表
	 * */
	@RequestMapping(value="searchTeacherCloseProjectList.do")
	public @ResponseBody Map<String, Object> searchTeacherProjectFinish(HttpServletRequest request,
			@RequestParam(value="projectName",required=false) String projectName,
			@RequestParam(value="startTime",required=false) String startTime,
			@RequestParam(value="endTime",required=false) String endTime,
			@RequestParam(value="pageIndex",required=false) Integer pageIndex,
			String start, String end){
		Map<String,Object> result = new HashMap<String,Object>();
		int teacherId = this.getAccountId(request);
		Integer sizePerPage = 10;
		Integer startIndex = 0;
		startIndex = (pageIndex - 1) * sizePerPage;
		if("".equals(projectName)){
			projectName = null;
		}
		PageObject po = teacherProjectServiceIF.selectProjectTeacherJoinFinishByPage(projectName, start, end, teacherId, startIndex, sizePerPage);
		
		result.put("rows",po.getObjects());
		result.put("total",po.getCount());
		result.put("pageSize", po.getPagesize());
		result.put("pages", po.getPages());
		result.put("currentPage", po.getCurrentPage());
		result.put("pageNumbers", po.getPageNumbers());
		return result;
	}
	
	
	
	
	
	
	/**
	 * 省管理员查看教师的培训总结跳转，改为ajax,具体的请求参看{@link SummaryController#teacherProSummaryList()}
	 * @param sno
	 * @param school
	 * @param projectId
	 * @param name
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "teacherProSummaryList.htm")
	public String teacherProSummaryList(String sno,String school,Integer projectId,
			String name,HttpServletRequest request, HttpServletResponse response,ModelMap map) throws Exception {
		EduProject project = eduProjectService.queryProjectBaseInfoById(projectId);
		map.put("project", project);
		return "teacher/teacherProSummaryList";
	}
	
	/**
	 * 正在参加的培训项目列表
	 */
	@RequestMapping(value = "teacherProjectList.do")
	public @ResponseBody Map<String, Object> selectTeacherProjectList(HttpServletRequest request, HttpServletResponse response)  {
		//session  中的值teacherId
		/*int teacherId = this.getAccountId(request);*/
		int teacherId = super.getAccountId(request);
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		try {
			List<EduProjectPojo> projectList = teacherProjectServiceIF.selectTeacherProjectListByTeacherId(teacherId);
			if(projectList.size()>0){
				pageInfo.put("success",true);
				pageInfo.put("projectList", projectList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师正在参加的培训项目列表查询错误"+e);
		}
		return pageInfo;
	}
	/**
	 *项目详细信息页面跳转
	 *@return
	 */
	@RequestMapping(value = "teacherProjectInfoPage.htm")
	public String teacherProjectInfo(int projectId,HttpServletRequest request){
		try {
			EduProjectDTO dto = eduProjectService.qryProFullInfo(projectId);
//		map.put("info", dto);
			request.setAttribute("info", dto);
			request.setAttribute("roleId", getRoleId(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "teacher/teacherProjectInfo";
		return "teacher/new_ViewProjectInfo";
	}
	/**
	 * 正在参加的培训项目查看
	 */
	@RequestMapping(value = "teacherProjectInfo.do")
	public @ResponseBody Map<String, Object> selectTeacherProjectInfo(Integer projectId,HttpServletRequest request, HttpServletResponse response)  {
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		int teacherId = this.getAccountId(request);
		try {
			EduProjectPojo projectInfo = teacherProjectServiceIF.selectTeacherProjectByProjectId(teacherId,projectId);
			//培训对象
			List<EduProjectPojo> pojoList = teacherProjectServiceIF.selectTeacherProjectTariInfoByProjectId(teacherId, projectId);
			if(projectInfo!=null||pojoList.size()>0){
				pageInfo.put("success",true);
				pageInfo.put("projectInfo", projectInfo);
				pageInfo.put("pojoList",pojoList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师正在参加的培训项目详情查询错误"+e);
		}
		return pageInfo;
	}
	
	
	/**
	 * 我的教师信息页面跳转
	 * @return
	 */
	@RequestMapping(value = "teacherInfoPage.htm")
	public String teacherInfoPage(ModelMap model, HttpServletRequest request) {
		model.put("user", this.getSessionUserInfo(request));
		return "teacher/teacherInfo";
	}
	
	/**
	 * 我的教师工作信息查询
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "teacherJobInfo.do")
	public @ResponseBody Map<String, Object> queryTeacherJob(String teacherId, HttpServletRequest request, HttpServletResponse response)  {
		//session中的值
		String loginAccount = this.getAccount(request);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(teacherId)) {
			paramMap.put("userId", teacherId);
		} else {
			paramMap.put("loginAccount", loginAccount);
		}
		
		if(getRoleId(request).intValue() != Common.ROLE_TEACHER_5.intValue()) {
			paramMap.put("status", Common.DATA_VALID);
		}
		
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		try {
			//教师资料信息
			EduUser eduUserInfo = teacherProjectServiceIF.selectTeacherBasicInfo(paramMap);
			paramMap.put("teacherId", eduUserInfo.getId());
			//教师JOB信息
			EduTeacherJob jobInfo = teacherProjectServiceIF.selectTeacherJobInfoByTeacherId(paramMap);
			if(eduUserInfo!=null){
				pageInfo.put("success",true);
				pageInfo.put("eduUserInfo",eduUserInfo);
				pageInfo.put("jobInfo",jobInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师信息查询错误"+e);
		}
		return pageInfo;
	}
	
	/**
	 * add by yinxiaolong
	 * 我的教师信息查询
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "teacherInfoList.do")
	public @ResponseBody Map<String, Object> queryResearchTeacherList(String teacherId, HttpServletRequest request, HttpServletResponse response)  {
		//session中的值
		String loginAccount = this.getAccount(request);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(teacherId)) {
			paramMap.put("userId", teacherId);
		} else {
			paramMap.put("loginAccount", loginAccount);
		}
		
		if(getRoleId(request).intValue() != Common.ROLE_TEACHER_5.intValue()) {
			paramMap.put("status", Common.DATA_VALID);
		}
		
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		try {
			//教师资料信息
			EduUser eduUserInfo = teacherProjectServiceIF.selectTeacherBasicInfo(paramMap);
			paramMap.put("teacherId", eduUserInfo.getId());
			//教师基本信息
			EduTeacherBasicInfo basicInfo = teacherProjectServiceIF.selectTeacherBasicInfoByTeacherId(paramMap);
			//教师教育经历
			List<EduTeacherEducation> educationInfo = teacherProjectServiceIF.selectTeacherEducationByTeacherId(paramMap);
			//教师JOB信息
			EduTeacherJob jobInfo = teacherProjectServiceIF.selectTeacherJobInfoByTeacherId(paramMap);
			//历次学校记录
			List<EduTeacherOldSchool> oldSchool = teacherProjectServiceIF.selectTeacherOldSchoolInfoByTeacherId(paramMap);
			//教师审核情况
//			paramMap.put("lastVersion", "lastVersion");
//			List<EduAudit> auditInfo = teacherProjectServiceIF.selectTeacherAuditInfoByTeacherId(paramMap);
//			paramMap.remove("lastVersion");
			List<EduAudit> auditHistroy = teacherProjectServiceIF.selectTeacherAuditInfoByTeacherId(paramMap);
			if(eduUserInfo!=null||basicInfo!=null||educationInfo!=null||jobInfo!=null||oldSchool!=null){
				pageInfo.put("success",true);
				pageInfo.put("eduUserInfo",eduUserInfo);
				pageInfo.put("basicInfo",basicInfo);
				pageInfo.put("educationInfo",educationInfo);
				pageInfo.put("jobInfo",jobInfo);
				pageInfo.put("oldSchool",oldSchool);
//				pageInfo.put("auditInfo", auditInfo);
				pageInfo.put("auditHistroy", auditHistroy);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师信息查询错误"+e);
		}
		return pageInfo;
	}
	
	/**
	 * add by dengguo
	 * 我的教师信息历史版本比对查询
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "teacherJobChangeHisInfo.do")
	public @ResponseBody Map<String, Object> queryTeacherJobChangeHis(String auditId, HttpServletRequest request, HttpServletResponse response)  {
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		
		if(StringUtils.isEmpty(auditId)) {
			pageInfo.put("success", false);
			return pageInfo;
		}
		
		//session中的值
		Map<String,Object> paramMap = new HashMap<String,Object>();
		try {
			paramMap.put("id", auditId);
			paramMap.put("changeType", "2");
			
			List<project.teacher.teachermanage.pojo.EduAudit>  auditPojoList = teacherManageService.queryTeacherChangeList(paramMap);
			
			if(auditPojoList == null && auditPojoList.size() == 0) {
				pageInfo.put("success", false);
				return pageInfo;
			}
			
			project.teacher.teachermanage.pojo.EduAudit auditPojo = auditPojoList.get(0);
			paramMap.put("userId", auditPojo.getTeacherId());
			paramMap.put("teacherId", auditPojo.getTeacherId());
		
			//教师资料信息
			EduUser eduUserInfo = teacherProjectServiceIF.selectTeacherBasicInfo(paramMap);
			//教师JOB信息
			EduTeacherJob oldJobInfo = teacherProjectServiceIF.selectTeacherJobInfoByTeacherIdAndVersion(auditPojo.getTeacherId(), auditPojo.getOldVersion());
			EduTeacherJob newJobInfo = teacherProjectServiceIF.selectTeacherJobInfoByTeacherIdAndVersion(auditPojo.getTeacherId(), auditPojo.getNewVersion());
			
			if(eduUserInfo!=null){
				pageInfo.put("success",true);
				pageInfo.put("eduUserInfo",eduUserInfo);
				pageInfo.put("oldJobInfo", oldJobInfo);
				pageInfo.put("newJobInfo", newJobInfo);
				pageInfo.put("auditOption", auditPojo.getAuditOption());
				pageInfo.put("mobilizeMark", auditPojo.getMobilizeMark());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师信息查询错误"+e);
		}
		return pageInfo;
	}
	
	/**
	 * add by dengguo
	 * 我的教师信息历史版本比对查询
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "teacherHisInfo.do")
	public @ResponseBody Map<String, Object> queryTeacherHis(String auditId, HttpServletRequest request, HttpServletResponse response)  {
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		
		if(StringUtils.isEmpty(auditId)) {
			pageInfo.put("success", false);
			return pageInfo;
		}
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		try {
			paramMap.put("id", auditId);
			List<project.teacher.teachermanage.pojo.EduAudit>  auditPojoList = teacherManageService.queryTeacherChangeList(paramMap);
			
			if(auditPojoList == null && auditPojoList.size() == 0) {
				pageInfo.put("success", false);
				return pageInfo;
			}
			
			project.teacher.teachermanage.pojo.EduAudit auditPojo = auditPojoList.get(0);
			paramMap.put("userId", auditPojo.getTeacherId());
			paramMap.put("teacherId", auditPojo.getTeacherId());
			
			//教师资料信息
			EduUser eduUserInfo = teacherProjectServiceIF.selectTeacherBasicInfo(paramMap);
			//教师基本信息
			EduTeacherBasicInfo oldBasicInfo = teacherProjectServiceIF.selectTeacherBasicInfoByTeacherIdAndVersion(auditPojo.getTeacherId(), auditPojo.getOldVersion());
			
			//教师基本信息
			EduTeacherBasicInfo newBasicInfo = teacherProjectServiceIF.selectTeacherBasicInfoByTeacherIdAndVersion(auditPojo.getTeacherId(), auditPojo.getNewVersion());
			
			//教师教育经历
			List<EduTeacherEducation> oldEducationInfo = teacherProjectServiceIF.selectTeacherEducationByTeacherIdAndVersion(auditPojo.getTeacherId(), auditPojo.getOldVersion());
			
			List<EduTeacherEducation> newEducationInfo = teacherProjectServiceIF.selectTeacherEducationByTeacherIdAndVersion(auditPojo.getTeacherId(), auditPojo.getNewVersion());
			
			//教师JOB信息
			EduTeacherJob oldJobInfo = teacherProjectServiceIF.selectTeacherJobInfoByTeacherIdAndVersion(auditPojo.getTeacherId(), auditPojo.getOldVersion());
			EduTeacherJob newJobInfo = teacherProjectServiceIF.selectTeacherJobInfoByTeacherIdAndVersion(auditPojo.getTeacherId(), auditPojo.getNewVersion());
			
			if(eduUserInfo!=null){
				pageInfo.put("success",true);
				pageInfo.put("eduUserInfo",eduUserInfo);
				pageInfo.put("oldBasicInfo",oldBasicInfo);
				pageInfo.put("newBasicInfo",newBasicInfo);
				pageInfo.put("oldEducationInfo",oldEducationInfo);
				pageInfo.put("newEducationInfo",newEducationInfo);
				pageInfo.put("oldJobInfo", oldJobInfo);
				pageInfo.put("newJobInfo", newJobInfo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师信息查询错误"+e);
		}
		return pageInfo;
	}
	
	/**
	 * add by yinxiaolong
	 *加入培训项目详细信息页面跳转
	 *@return  全部项目
	 */
	@RequestMapping(value = "teacherAddProjectPage.htm")
	public String teacherAddProject(){
		return "teacher/teacherAddProject";
	}
	/*
	 * 我的项目
	 */
	@RequestMapping(value = "teacherMyProject.htm")
	public String teacherMyProject(){
		return "teacher/teacherMyProject";
	}
	
	/**
	 * 转向项目报名页面
	 * */
	@RequestMapping("teacherProjectCommon.htm")
	public String toAllProject(int flag,HttpServletRequest request){
		request.setAttribute("areaId", super.getUserAreaId(request));
		request.setAttribute("roleId", super.getRoleId(request));
		request.setAttribute("flag", flag);
		return "teacher/teacherProjectCommon";
	}
	/**
	 * add by zhudi
	 *跳转到教师成绩查询
	 *@return  全部项目
	 */
	@RequestMapping(value = "toScoreQuery.htm")
	public String toScoreQuery(){
		return "teacher/scoreQuery";
	}
	/**
	 * add by zhudi
	 *跳转到教师学分借贷
	 *@return  全部项目
	 */
	@RequestMapping(value = "toCreditLend.htm")
	public String toCreditLend(){
		return "teacher/creditLend";
	}
	/**
	 * add by zhudi
	 *跳转到教师添加学分借贷
	 *@return  全部项目
	 */
	@RequestMapping(value = "toCreditLendAdd.htm")
	public String toCreditLendAdd(){
		return "teacher/creditLendAdd";
	}
	/**
	 * add by zhudi
	 *跳转到教师修改学分借贷
	 *@return  全部项目
	 */
	@RequestMapping(value = "toCreditLendUpdate.htm")
	public String toCreditLendUpdate(){
		return "teacher/creditLendUpdate";
	}
	/**
	 * add by zhudi
	 *管理员查看教师借贷情况
	 *@return  全部项目
	 */
	@RequestMapping(value = "searchTeacherCreditLend.htm")
	public String toTeacherCreditLend(){
		return "teacher/searchTeacherCreditLend";
	}
	
	/**
	 *  查询参与的各级培训项目
	 */
	@RequestMapping("queryAllProject.do")
	public @ResponseBody Map<String,Object> allProject(String projectName,int startIndex,
			String start,String end,String flag,HttpServletRequest request){
		
		Map<String,Object> result = new HashMap<String,Object>();
//		Map<String, Object> conditions = super.getCode(request);
		Map<String, Object> conditions = new HashMap<String,Object>();
		String projectScopeName = request.getParameter("projectScopeName");
		flag = request.getParameter("flag");
		
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
		conditions.put("start", start == null || start == "" ? null : start);
		conditions.put("end", end == null || end == "" ? null : end);
		conditions.put("teacherId", this.getAccountId(request));
		conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		conditions.put("provinceId", this.getUserLocaltion(request).get("provinceId"));
		conditions.put("projectScopeName", projectScopeName==null?null:projectScopeName.length()==0?null:projectScopeName);
		
		int roleId = super.getRoleId(request);
		/*if(roleId == 1 || roleId == 7){
			conditions.put("pid", super.getUserAreaId(request));
		}else if(roleId == 2 || roleId == 8){
			conditions.put("cid", super.getUserAreaId(request));
		}else if(roleId == 3 || roleId == 9){
			conditions.put("did", super.getUserAreaId(request));
		}else if(roleId == 4){
			conditions.put("sid", super.getSessionUserInfo(request).getSchoolId());
		}*/
		
		try {
			PageObject po = null;
			
			if("6".equals(flag)){
				// 我的培训项目
				po = teacherProjectServiceIF.teacherMyProject(conditions,startIndex,sizePerPage);
			}else if("7".equals(flag)){
				//查询自由报名培训项目
				po = teacherProjectServiceIF.projectList(conditions,startIndex,sizePerPage);
			}else{
				//查询国培，省，地市，区县，校本项目
				po = teacherProjectServiceIF.teacherProjectCommonAll(conditions,flag,startIndex,sizePerPage);
			}
			String accLog = super.getAccount(request);
			Integer orgId = super.getOrganizationId(request);
			String areaId=super.getUserAreaId(request);
			result.put("areaId",areaId);
			result.put("roleId", roleId);
			result.put("orgId",orgId);
			result.put("accLog",accLog);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
			DataUtil.setOk(result);
		} catch (Exception e) {
			log.info("项目查询失败！"+e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * 国培
	 */
	@RequestMapping(value = "teacherProjectGuoPei.htm")
	public String teacherOtherProject(){
		return "teacher/teacherProjectGuoPei";
	}
	/*
	 * 省培
	 */
	@RequestMapping(value = "teacherProjectShengPei.htm")
	public String teacherAddProjectGuoPei(){
		return "teacher/teacherProjectShengPei";
	}
	/*
	 * 校本
	 */
	@RequestMapping(value = "teacherProjectXiaoBen.htm")
	public String teacherAddProjectAll(){
		return "teacher/teacherProjectXiaoBen";
	}
	
	/**
	 * add by yinxiaolong
	 * 教师加入培训项目列表
	 * @return 全部项目
	 */
	@RequestMapping("teacherAddProjectList.do")
	public @ResponseBody Map<String, Object> projectList(HttpServletRequest request,int startIndex,int start,int end,String projectName){
		//session  中的值teacherId
		int teacherId = this.getAccountId(request);
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = new HashMap<String, Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request
					.getParameter("sizePerPage"));
		}
		startIndex = (startIndex - 1) * sizePerPage;
		conditions.put("teacherId", teacherId);
		conditions.put("start", start);
		conditions.put("end", end);
		conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		conditions.put("end", end);
		conditions.put("provinceId", this.getUserLocaltion(request).get("provinceId"));
		try {
			PageObject po = teacherProjectServiceIF.projectList(conditions,startIndex,sizePerPage);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
		} catch (Exception e) {
			log.error("教师加入培训项目列表查询失败-->"+e);
			e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * 
	 * 我的项目
	 */
	
	@RequestMapping("teacherMyProject.do")
	public @ResponseBody Map<String, Object> teacherMyProject(HttpServletRequest request,int startIndex,int start,int end,String projectName){
		//session  中的值teacherId
		int teacherId = this.getAccountId(request);
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = new HashMap<String, Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request
					.getParameter("sizePerPage"));
		}
		startIndex = (startIndex - 1) * sizePerPage;
		conditions.put("teacherId", teacherId);
		conditions.put("start", start);
		conditions.put("end", end);
		conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		conditions.put("end", end);
		conditions.put("provinceId", this.getUserLocaltion(request).get("provinceId"));
		try {
			PageObject po = teacherProjectServiceIF.teacherMyProject(conditions,startIndex,sizePerPage);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
		} catch (Exception e) {
			log.error("教师加入培训项目列表查询失败-->"+e);
			e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * 
	 * 国培项目
	 */
	
	@RequestMapping("teacherProjectGuoPei.do")
	public @ResponseBody Map<String, Object> teacherOtherProject(HttpServletRequest request,int startIndex,int start,int end,String projectName){
		//session  中的值teacherId
		int teacherId = this.getAccountId(request);
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = new HashMap<String, Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request
					.getParameter("sizePerPage"));
		}
		startIndex = (startIndex - 1) * sizePerPage;
		conditions.put("teacherId", teacherId);
		conditions.put("start", start);
		conditions.put("end", end);
		conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		conditions.put("end", end);
		conditions.put("provinceId", this.getUserLocaltion(request).get("provinceId"));
		try {
			PageObject po = teacherProjectServiceIF.teacherOtherProject(conditions,startIndex,sizePerPage);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
		} catch (Exception e) {
			log.error("教师加入培训项目列表查询失败-->"+e);
			e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * 
	 * 省培
	 */
	
	@RequestMapping("teacherAddProjectGuoPei.do")
	public @ResponseBody Map<String, Object> teacherAddProjectGuoPei(HttpServletRequest request,int startIndex,int start,int end,String projectName){
		//session  中的值teacherId
		int teacherId = this.getAccountId(request);
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = new HashMap<String, Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request
					.getParameter("sizePerPage"));
		}
		startIndex = (startIndex - 1) * sizePerPage;
		conditions.put("teacherId", teacherId);
		conditions.put("start", start);
		conditions.put("end", end);
		conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		conditions.put("end", end);
		conditions.put("provinceId", this.getUserLocaltion(request).get("provinceId"));
		try {
			PageObject po = teacherProjectServiceIF.teacherAddProjectGuoPei(conditions,startIndex,sizePerPage);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
		} catch (Exception e) {
			log.error("教师加入培训项目列表查询失败-->"+e);
			e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * 
	 * 校本
	 */
	
	@RequestMapping("teacherProjectXiaoBen.do")
	public @ResponseBody Map<String, Object> teacherProjectXiaoBen(HttpServletRequest request,int startIndex,int start,int end,String projectName){
		//session  中的值teacherId
		int teacherId = this.getAccountId(request);
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = new HashMap<String, Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request
					.getParameter("sizePerPage"));
		}
		startIndex = (startIndex - 1) * sizePerPage;
		conditions.put("teacherId", teacherId);
		conditions.put("start", start);
		conditions.put("end", end);
		conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		conditions.put("end", end);
		conditions.put("provinceId", this.getUserLocaltion(request).get("provinceId"));
		try {
			PageObject po = teacherProjectServiceIF.teacherProjectXiaoBen(conditions,startIndex,sizePerPage);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
		} catch (Exception e) {
			log.error("教师加入培训项目列表查询失败-->"+e);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 查询教师工作调动记录
	 * @param request
	 * @param startIndex
	 * @param start
	 * @param end
	 * @param projectName
	 * @return
	 */
	@RequestMapping("jobtransferHistoryList.do")
	public @ResponseBody Map<String, Object> jobtransferHistoryList(Integer teacherId, HttpServletRequest request){
		//session  中的值teacherId
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<EduTeacherMobilize>  edujob = teacherProjectServiceIF.selectJobtransferHistoryByTeacherId(teacherId);
			if(edujob != null) {
				result.put("success", true);
				result.put("rows",edujob);
			} else {
				result.put("success", true);
			}
		} catch (Exception e) {
			log.error("查询教师工作调动记录失败-->"+e);
			e.printStackTrace();
		}
		return result;
	}
	
	
	@RequestMapping("teacherProjectInfo.htm")
	public String projectInfo(int projectId,ModelMap map){
		try {
			EduProjectDTO dto = eduProjectService.qryProFullInfo(projectId);
			if(dto.getProjectAttchement() != null && dto.getProjectAttchement().length()>0){
				map.put("files", dto.getProjectAttchement().split(","));
				map.put("names", dto.getFileName().split(","));
			}else{
				map.put("files", "");
				map.put("names", "");
			}
			List<String> orgs = eduProjectService.getAllOrgByProjectId(projectId);
			map.put("info", dto);
			map.put("orgs", orgs);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return "teacher/teacherAddProjectInfo";
		return "teacher/new_ViewProjectInfo";
		
	}
	
	/**
	 * 自由报名项目下查询项目信息
	 * */
	@RequestMapping(value = "teacherAddProjectStatus.do")
	public @ResponseBody Map<String, Object> researchTeacherAddProjectStatus(Integer projectId, HttpServletRequest request, HttpServletResponse response)  {
		//session中获得登陆用户的id
		int teacherId = this.getAccountId(request);
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			EduProjectComment comment = teacherProjectServiceIF.selectTeacherStatusByTeacherId(projectId,teacherId);
			if(comment!=null){
				result.put("success", true);
				result.put("info", comment);
			}
		} catch (Exception e) {
			log.error("教师加入项目审核状态查询失败-->"+e);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 自由报名项目报名
	 * */
	@RequestMapping("teacherRealyAddProjectInfo.htm")
	public String teacherRealyAddProjectInfo(int projectId,ModelMap map){
		try {
			int proId =  projectId;
			EduProjectDTO dto = eduProjectService.qryProFullInfo(proId);
			map.put("info", dto);
			if(dto.getProjectAttchement() != null && dto.getProjectAttchement().length()>0){
				map.put("files", dto.getProjectAttchement().split(","));
				map.put("names", dto.getFileName().split(","));
			}else{
				map.put("files", "");
				map.put("names", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "teacher/new_teacherRealyAddProject";
	}
	
	
	
	//报名之前查看该项目是否需要审核
	@RequestMapping("selectProMustAudit.do")
	public @ResponseBody Map<String, Object> selectProMustAudit(String projectId, HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("projectId", projectId);
		Map<String,Object> result = new HashMap<String,Object>();
			try {
				EduProjectTrainTargetActitity info = teacherProjectServiceIF.selectProMustAudit(paramMap);
				result.put("success", true);
				if(info.getMustAudit()!=null||!info.getMustAudit().equals("")){
					result.put("info", info.getMustAudit());
				}
			} catch (Exception e) {
				log.error("报名之前查看该项目是否需要审核查询失败-->"+e);
				e.printStackTrace();
			}
		return result;
	}
	
	/**
	 * 自由报名项目报名
	 * */
	@RequestMapping("createTeacherAddProject.do")
	public @ResponseBody Map<String, Object> createArea(String projectId, String type,HttpServletRequest request, HttpServletResponse response){
		//session 中获取teacherId
		int teacherId = this.getAccountId(request);
		String loginAccount = this.getAccount(request);
		int status = 11;
		EduTeacherVersionPOJO version = teacherReadDao.selectTeacherAllVersion(Integer.valueOf(teacherId));
		int jobVersion = version.getJobVersion();
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			EduProject pro = eduProjectService.queryProjectBaseInfoById(Integer.parseInt(projectId));
			if(teacherProjectServiceIF.insertCommentTeacherInfo(pro.getOrganizationId(), projectId, teacherId,jobVersion,loginAccount,status,type)){
				result.put("success", true);
			}
		} catch (Exception e) {
			log.error("教师项目培训报名失败"+e);
			e.printStackTrace();
		}
		return result;
	}
	
	//教师报名项目培训--不需要审核
	/*@RequestMapping("createTeacherAddProject2.do")
	public @ResponseBody Map<String, Object> createArea2(String projectId,String type, HttpServletRequest request, HttpServletResponse response){
		//session 中获取teacherId
		int teacherId = this.getAccountId(request);
		String loginAccount = this.getAccount(request);
		int status = 13;
		EduTeacherVersionPOJO version = teacherReadDao.selectTeacherAllVersion(Integer.valueOf(teacherId));
		int jobVersion = version.getJobVersion();
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(teacherProjectServiceIF.insertCommentTeacherInfo2(projectId, teacherId,jobVersion,loginAccount,status,type)){
			result.put("success", true);
			}
		} catch (Exception e) {
			log.error("教师项目培训不需要审核报名失败---------"+e);
			e.printStackTrace();
		}
		return result;
	}*/
	
	/**
	 * 教师查看培训详情汇总
	 *@return
	 */
	@RequestMapping(value = "teacherTrainScorePage.htm")
	public String teacherTrainScorePage(HttpServletRequest request){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("teacherId", getAccountId(request));
		paramMap.put("idNumber", getUserIdCard(request));
		try {
			EduTeacherScoreInfo eduTeacherSocre = sysService.getTeacherScoreInfoById(paramMap);
			request.setAttribute("eduTeacherSocre", eduTeacherSocre);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "teacher/teacherTrainScorePage";
	}
	
	
	@RequestMapping("toTeacherTrainScore.htm")
	public String toTeacherTrainScore(HttpServletRequest request,String teacherId) {
		request.setAttribute("teacherId", teacherId);
		return "teacher/teacherProjectTrainScore";
	}
	
	/**
	 * 教师查看自己培训成绩页面
	 *@return
	 */
	@RequestMapping(value = "teacherOverProjectPage.htm")
	public String teacherOverProject(){
		return "teacher/teacherOverProject";
	}
	
	/**
	 * add by gaofan
	 * 教师评价页面
	 *@return
	 */
	@RequestMapping(value = "teacherOverCommentProjectPage.htm")
	public String teacherOverCommentProject(){
		return "teacher/teacherOverCommentProject";
	}
	
	
	@RequestMapping(value = "teacherSummaryProjectPage.htm")
	public String teacherSummaryProject(HttpServletRequest request,int startIndex,int start,int end,String projectName,ModelMap map){
		int teacherId = this.getAccountId(request);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request
					.getParameter("sizePerPage"));
		}
		startIndex = (startIndex - 1) * sizePerPage;
		paramMap.put("teacherId", teacherId);
		paramMap.put("start", start);
		paramMap.put("end", end);
		paramMap.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		try {
			PageObject po = teacherProjectServiceIF.selectTeacherOverProjectListByTeacherId(paramMap, startIndex, sizePerPage);
			map.put("PageObject", po);
		} catch (Exception e) {
			log.error("教师结束的项目列表查询失败"+e);
			e.printStackTrace();
		}
		return "teacher/teacherSummayProject";
	}
	/**
	 * 教师：培训项目总结下项目列表/查看培训成绩/教师评价
	 * @return
	 */
	@RequestMapping("teacherOverProjectList.do")
	public @ResponseBody Map<String, Object> teacherOverProjectList(HttpServletRequest request,int startIndex,String start,String end,String projectName){
		//session  中的值teacherId
		int teacherId = this.getAccountId(request);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		Map<String,Object> result = new HashMap<String,Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		startIndex = (startIndex - 1) * sizePerPage;
		paramMap.put("teacherId", teacherId);
		paramMap.put("start", start == null || start == "" ? null : start);
		paramMap.put("end", end == null || end == "" ? null : end);
		
		paramMap.put("startIndex", startIndex);
		paramMap.put("endIndex", sizePerPage);
		
		paramMap.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		try {
			PageObject po = teacherProjectServiceIF.selectTeacherOverProjectListByTeacherId(paramMap, startIndex, sizePerPage);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
		} catch (Exception e) {
			log.error("教师结束的项目列表查询失败"+e);
			e.printStackTrace();
		}
		return result;
	}
	//已结束的培训项目查看
	@RequestMapping("teacherOverProjectInfo.htm")
	public String OverPprojectInfo(HttpServletRequest request,int projectId,ModelMap map){
//		try {
//			
//			EduProjectDTO dto = eduProjectService.qryProFullInfo(projectId);
//			map.put("info", dto);
//			Map<String, Object> condition = new HashMap<String,Object>();
//			condition.put("projectId", projectId);
//			condition.put("type", "declare");
//			List<FileUpload>  files = 	fileUploadService.getFileUploads(request, null, condition);
//			map.put("files", files);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "teacher/teacherOverProjectInfo";
		
		return "redirect:/teacher/teacherProject/teacherProjectInfo.htm?projectId="+projectId+"&click=23";
	}
	
	//已结束项目培训教师评价
	@RequestMapping("createTeacherComment.do")
	public @ResponseBody Map<String, Object> createCommentScore(String projectId,String projectScore, HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		int teacherId = this.getAccountId(request);
		paramMap.put("projectId", projectId);
		paramMap.put("projectScore", projectScore);
		paramMap.put("teacherId", teacherId);
		try {
			if(teacherProjectServiceIF.insertTeacherCommentScore(paramMap)){
			result.put("success", true);
			}
		} catch (Exception e) {
			log.error("已结束项目教师评价失败"+e);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 教师去学习--查询机构--and培训机构URL
	 */
	@RequestMapping(value = "teacherProjectOrganization.do")
	public @ResponseBody Map<String, Object> selectTeacherProjectOrganizationList(String projectId,String organizationId,HttpServletRequest request, HttpServletResponse response)  {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		Map<String,Object> resultMap = new HashMap<String,Object>();
		int teacherId = this.getAccountId(request);
		String teacherUuid = "";
		try {
			//加密的token
			String key = "teacher!"; 
			teacherUuid = DesTool.toHexString(DesTool.encrypt(this.getUserIdCard(request), key)).toUpperCase();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		paramMap.put("teacherId", teacherId);
		paramMap.put("projectId", projectId);
		paramMap.put("organizationId", organizationId);
		paramMap.put("status", 1);
		
		try {
			EduTeacherJob jobInfo = teacherProjectServiceIF.selectTeacherJobInfoByTeacherId(paramMap);
			List<Organization> infoList = teacherProjectServiceIF.selectProjectOrganizationList(paramMap);
			if(infoList.size()>0){
				resultMap.put("name", infoList.get(0).getProjectName());
			}
			List<Organization> orgs = new ArrayList<Organization>();
			//筛选出教师可以选择的机构（根据机构分配的地区与学科）
			for(Organization o:infoList){
				SysArea area =  sysService.queryAreaByCode(o.getAreaCode());
				
				if(o.getSubjectIds() == null && o.getSubjectIds().length() ==0 && o.getAreaCode() == null && o.getAreaCode().length() ==0){
					orgs.add(o);
				}else{
//					if(o.getSubjectIds().contains(jobInfo.getJobFormerTeachingSubjectType()) ){//学科是否符合
					if(DataUtil.containsStr(o.getSubjectIds(), jobInfo.getJobFormerTeachingSubjectType())){
						if(o.getAreaCode().equals(this.getUserAreaId(area.getType(),request))){//地区是否符合
							orgs.add(o);
						}
					}
				}
			}
			
			if(orgs.size()>0){
				resultMap.put("success",true);
				resultMap.put("infoList", orgs);
				resultMap.put("teacherUuid",teacherUuid);
			}else{
				resultMap.put("success",false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师去学习--查询机构---查询错误--"+e);
		}
		return resultMap;
	}
	private String getUserAreaId(String type,HttpServletRequest request){
		if(type.equals("0")){
			return super.getUserProvinceId(request);
		}else if(type.equals("1")){
			return super.getUserCityId(request);
		}else{
			return super.getUserDistrictId(request);
		}
	}
	
	
		
		//教师去学习更新机构id
		@RequestMapping("teacherGoStatySelectOrg.do")
		public @ResponseBody Map<String, Object> createorganizationId(String projectId,String organizationId, HttpServletRequest request, HttpServletResponse response){
			int teacherId = this.getAccountId(request);
			String loginAccount = this.getAccount(request);
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("projectId", projectId);
			paramMap.put("organizationId", organizationId);
			paramMap.put("teacherId", teacherId);
			paramMap.put("loginAccount", loginAccount);
			try {
				if(teacherProjectServiceIF.insertTeacherOrganizationId(paramMap)){
				result.put("success", true);
				}
			} catch (Exception e) {
				log.error("已结束项目教师评价失败"+e);
				e.printStackTrace();
			}
			return result;
		}
		
		/**
		 * 跳转教师修改信息页面
		 * @return
		 */
		@RequestMapping(value = "updateTeacherPage.htm")
		public String editeTeacherPage(ModelMap map, Integer teacherId,HttpServletRequest request) {
			map.put("teacherId", teacherId);
			EduUserActivty userinfo = super.getSessionUserInfo(request);
			map.put("userinfo", userinfo);
			return "teacher/updateTeacher";
		}
		
		/**
		 * 转到项目页面调查页面
		 * @return
		 */
		@RequestMapping("/teacherPaperAndAssessListPage.htm")
		public String toProjectPaperAndAssessManage(){
			return "teacher/teacherPaperAndAssessManage";
		}
		/**
		 * 转到项目调查列表页面
		 * @return
		 */
		@RequestMapping("/teacherPaperListPage.htm")
		public String teacherPaperListPage(Integer proId, HttpServletRequest request){
			try{
				EduProjectDTO dto=eduProjectService.qryProFullInfo(proId);
				request.setAttribute("info", dto);
			}catch (Exception e) {
				log.error("查看调查问卷失败--->"+e.getMessage());
				e.printStackTrace();
			}
			request.setAttribute("proId", proId);
			return "teacher/teacherPaperManage";
		}
		/**
		 * 调查问卷列表
		 * @return
		 */
		@RequestMapping("/paperList.do")
		public @ResponseBody Map<String, Object> paperList(int startIndex,Integer proId,HttpServletRequest request){
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String, Object> conditions = super.getCode(request);
			startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
			conditions.put("projectId", proId);
			try {
				Map<Integer,Integer> map=new HashMap<Integer,Integer>();
				PageObject po = eduProjectService.paperList(conditions,startIndex,Common.PNN_USER_PAGE_LIMIT);
				for (EduPaper paper : (List<EduPaper>)po.getObjects()) {
					if(paper.getStatus()==Common.PAPER_STA_NOSTART||paper.getStatus()==Common.PAPER_STA_START){
						int diff=DateUtil.compare_date(DateUtil.format(new Date()),paper.getEndDate());
						if(diff>=0){
							paper.setStatus(Common.PAPER_STA_END);
							eduProjectService.updatePaper(paper);
						}
					}
				}
				conditions.clear();
				HttpSession session = request.getSession();
				if(session.getAttribute("userinfo")!=null){
					EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
					conditions.put("username", info.getLoginAccount());
				}
				conditions.put("projectId", proId);
				PageObject pop=eduProjectService.selectEduResponseListByCondition(conditions,0,Common.PAPER_Q_LIMIT);
				List<EduResponse> list=(List<EduResponse>)pop.getObjects();
				if(list!=null){
					for (EduResponse eduResponse:list) {
						map.put(eduResponse.getPaperId(), eduResponse.getId());
					}
				}
				result.put("total",po.getCount());
				result.put("map",map);
				result.put("rows",po.getObjects());
				result.put("pageSize", po.getPagesize());
				result.put("pages", po.getPages());
				result.put("currentPage", po.getCurrentPage());
				result.put("pageNumbers", po.getPageNumbers());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		/**
		 * 调查问卷预览
		 * 
		 */
		@RequestMapping("/paperPrepview.htm")
		public String toPreview(int paperId,HttpServletRequest request){
			Map<String,Object> conditions = super.getCode(request);
			//获取当前调查问卷
			try {
				EduPaper paper = eduProjectService.selectEduPaperById(paperId);
				//获取问题
				conditions.put("paperId", paper.getId());
				Map<Integer,Object> map = new HashMap<Integer,Object>();
				PageObject pgQuestion = eduProjectService.selectEduQuestionListByPapid(conditions, 0, Common.PAPER_Q_LIMIT);
				if(pgQuestion!=null&&pgQuestion.getObjects()!=null){
					for (EduQuestion eduQuestion:(List<EduQuestion>)pgQuestion.getObjects()) {
						conditions.clear();
						conditions.put("questionId", eduQuestion.getId());
						PageObject pgQuestionOption =eduProjectService.selectEduQuestionOptionsListByQid(conditions, 0, Common.PAPER_Q_LIMIT);
						if(pgQuestionOption!=null&&pgQuestionOption.getObjects()!=null){
							map.put(eduQuestion.getId(), pgQuestionOption.getObjects());
						}
					}
				}
				request.setAttribute("map", map);
				request.setAttribute("paper", paper);
				request.setAttribute("pgq", pgQuestion.getObjects());
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "teacher/paperPreview";
		}
		
		/**
		 * 提交问卷
		 * 
		 */
		@RequestMapping("/tjPaper.do")
		public @ResponseBody Map<String,Object> tjPaper(int paperId,int projectId,HttpServletRequest request,HttpServletResponse response){
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String, Object> conditions = super.getCode(request);
			conditions.put("paperId", paperId);
			try {
				HttpSession session = request.getSession();
				EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
				PageObject pgQuestion = eduProjectService.selectEduQuestionListByPapid(conditions, 0, Common.PAPER_Q_LIMIT);
				EduResponse eduResponse=new EduResponse();
				eduResponse.setCreateDate(DateUtil.getSystemTimeFormat("yyyy-MM-dd HH:mm:ss"));
				eduResponse.setIpaddress(StringUtil.getIpAddr(request));
				eduResponse.setUsername(info.getLoginAccount());
				eduResponse.setName(info.getRealName());
				eduResponse.setPaperId(paperId);
				eduResponse.setProjectId(projectId);
				eduProjectService.insertResponse(eduResponse);
				for(EduQuestion eq : (List<EduQuestion>)pgQuestion.getObjects())
				{
					StringBuffer sb = new StringBuffer();
					List<String> answers = new ArrayList<String>();
					 if(eq.getQuestionType()==Common.PAPER_Q_CHECKBOX){
					  //多选
						String[] tjas = request.getParameterValues("questionType_" + eq.getId());
						if(tjas != null && tjas.length > 0)
						{
//							sb.append("|");
							for(String tj : tjas)
							{
//								sb.append(Integer.parseInt(tj));
								answers.add(tj);
//								sb.append("|");
							}
						}
					}else if(eq.getQuestionType()==Common.PAPER_Q_RADIO){
						answers.add(request.getParameter("questionType_" + eq.getId()));
//						sb.append(request.getParameter("questionType_" + eq.getId()));
					}else{
					  //其它
						answers.add(request.getParameter("questionType_" + eq.getId()));
//						sb.append(request.getParameter("questionType_" + eq.getId()));
					}
				
					 for(String answer :answers){
						 EduResponseQuestion eduResponseQuestion=new EduResponseQuestion();
							eduResponseQuestion.setCreateDate(DateUtil.getSystemTimeFormat("yyyy-MM-dd"));
							eduResponseQuestion.setAnswer(answer);
							eduResponseQuestion.setQuestionId(eq.getId());
							eduResponseQuestion.setResponseId(eduResponse.getId());
							eduResponseQuestion.setUsername(info.getLoginAccount());
							eduProjectService.insertResponseQuestion(eduResponseQuestion);
					 }
//					EduResponseQuestion eduResponseQuestion=new EduResponseQuestion();
//					eduResponseQuestion.setCreateDate(DateUtil.getSystemTimeFormat("yyyy-MM-dd"));
//					eduResponseQuestion.setAnswer(sb.toString());
//					eduResponseQuestion.setQuestionId(eq.getId());
//					eduResponseQuestion.setResponseId(eduResponse.getId());
//					eduResponseQuestion.setUsername(info.getLoginAccount());
//					eduProjectService.insertResponseQuestion(eduResponseQuestion);
				}
				EduPaper eduPaper = eduProjectService.selectEduPaperById(paperId);
				eduPaper.setAttendedNum(eduPaper.getAttendedNum()+1);
				eduProjectService.updatePaper(eduPaper);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}
		/**
		 * 查看我的问卷
		 * 
		 */
		@RequestMapping("/myPaperView.htm")
		public String myPaperView(int paperId,HttpServletRequest request){
			Map<String,Object> conditions = super.getCode(request);
			//获取当前调查问卷
			try {
				EduPaper paper = eduProjectService.selectEduPaperById(paperId);
				//获取问题
				conditions.put("paperId", paper.getId());
				HttpSession session = request.getSession();
				EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
				String username=info.getLoginAccount();
				Map<Integer,Object> map = new HashMap<Integer,Object>();
				Map<Integer,Object> mapERQ = new HashMap<Integer,Object>();
				PageObject pgQuestion = eduProjectService.selectEduQuestionListByPapid(conditions, 0, Common.PAPER_Q_LIMIT);
				if(pgQuestion!=null&&pgQuestion.getObjects()!=null){
					for (EduQuestion eduQuestion:(List<EduQuestion>)pgQuestion.getObjects()) {
						conditions.clear();
						conditions.put("questionId", eduQuestion.getId());
						conditions.put("username", username);
						PageObject eduRQuestion=eduProjectService.selectEduResponseQuestionListByCondition(conditions, 0, 100);
						if(eduRQuestion!=null&&eduRQuestion.getObjects()!=null&&eduRQuestion.getCount()>0){
//							EduResponseQuestion eduResponseQuestion=(EduResponseQuestion)eduRQuestion.getObjects().get(0);
							for(Object eduResponseQuestion : eduRQuestion.getObjects()){
								if(mapERQ.containsKey(eduQuestion.getId())){
									mapERQ.put(eduQuestion.getId(), mapERQ.get(eduQuestion.getId())+"|"+ ((EduResponseQuestion)eduResponseQuestion).getAnswer()+"|");
								}else{
									mapERQ.put(eduQuestion.getId(), ((EduResponseQuestion)eduResponseQuestion).getAnswer());
								}
							}
						}
						PageObject pgQuestionOption =eduProjectService.selectEduQuestionOptionsListByQid(conditions, 0, Common.PAPER_Q_LIMIT);
						if(pgQuestionOption!=null&&pgQuestionOption.getObjects()!=null){
							map.put(eduQuestion.getId(), pgQuestionOption.getObjects());
						}
					}
				}
				request.setAttribute("map", map);
				request.setAttribute("mapERQ", mapERQ);
				request.setAttribute("paper", paper);
				request.setAttribute("pgq", pgQuestion.getObjects());
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "teacher/myPaperView";
		}
		
		/**
		 * 调查问卷列表
		 * @return
		 */
		@RequestMapping("/checkIsForcePaper.do")
		public @ResponseBody Map<String, Object> checkIsForcePaper(Integer projectId,HttpServletRequest request){
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String, Object> conditions = super.getCode(request);
			HttpSession session = request.getSession();
			EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
			String username=info.getLoginAccount();
			conditions.put("projectId", projectId);
			conditions.put("userName", username);
			conditions.put("isForce", 0);//是否强制执行，0是1否
			try {
				int count = eduProjectService.checkIsForcePaper(conditions);
				if(count>0){
					result.put("success", true);
				}
				else{
					result.put("success", false);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		/**
		 * 教师借贷列表
		 * @return
		 */
		@RequestMapping("/queryTeacherLendCredit.do")
		public @ResponseBody Map<String, Object> queryTeacherLendCredit(HttpServletRequest request){
			
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String, Object> conditions = super.getCode(request);
			String lendYear = request.getParameter("lendYear");
			String lendStatus = request.getParameter("lendStatus");
			String id = request.getParameter("id");
			HttpSession session = request.getSession();
			EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
			
			String teacherId = request.getParameter("teacherId") ;
			int teacher_id;
			if(teacherId == null || teacherId.equals("null")){
				teacher_id = info.getUserId();
			}else{//学分查询中跳转(查询指定教师)
				teacher_id = Integer.parseInt(teacherId);
				String queryYear = request.getParameter("queryYear");
				conditions.put("lendYear", queryYear);//教师Id
			}
			
			if(lendStatus != null){
				String statusStr[] = lendStatus.split(",");
				StringBuffer statusSb = new StringBuffer();
				for(String s : statusStr){
					statusSb.append(Common.CREDIT_LEND_COMMON_STATUS.get(s));
					statusSb.append(",");
				}
				conditions.put("lendStatus", statusSb.toString().substring(0, statusSb.toString().lastIndexOf(',')));//借贷状态
			}
			conditions.put("teacherId", teacher_id);//教师Id
			conditions.put("lendYear", StringUtils.isEmpty(lendYear)?null:lendYear);//借贷年份
			conditions.put("id", StringUtils.isEmpty(id)?null:Integer.parseInt(id));//Id
			try {
				PageObject pageObject= teacherProjectServiceIF.queryTeacherLendCredit(conditions);
				result.put("rows", pageObject.getObjects());
				Map<String,Object> condition = new HashMap<String,Object>();
				condition.put("year", lendYear);
				List<EduDiploma> list = eduManageService.selectYearDiploma(condition);
				float repayRate = 0;
				if(list.size() > 0){
					repayRate = list.get(0).getRepayRate();
				}
				if(id != null){//如果存在id，查询特定一条记录
					result.put("rows", pageObject.getObjects().get(0));
					float repayCredit = (float) (((EduCreditLend)pageObject.getObjects().get(0)).getLendCredit() * repayRate);
					result.put("repayCredit",  dorounded(repayCredit));
				}else{
					result.put("rows", pageObject.getObjects());
					result.put("repayRate", repayRate == 0 ? " 未设置 " : repayRate);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		
		/**
		 * 查询教师某一条借贷具体信息
		 * @return
		 */
		@RequestMapping("/queryTeacherLendCreditById.do")
		public @ResponseBody Map<String, Object> queryTeacherLendCreditById(HttpServletRequest request){
			
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String, Object> conditions = super.getCode(request);
			String id = request.getParameter("id");
			conditions.put("id", id);
			PageObject pageObject= teacherProjectServiceIF.queryTeacherLendCredit(conditions);
			result.put("rows", pageObject.getObjects().get(0));
			return result;
		}
		
		/**
		 * 申请借贷学分
		 * @return
		 * @throws Exception 
		 */
		@RequestMapping("/insertLendCredit.do")
		public @ResponseBody Map<String, Object> insertLendCredit(HttpServletRequest request) throws Exception{
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String, Object> conditions = super.getCode(request);
			String lendYear = request.getParameter("lendYear");
			String lendReason = request.getParameter("lendReason");
			String lendCredit = request.getParameter("lendCredit");
			String lendFormId = request.getParameter("lendFormId");
			String lendFormName = request.getParameter("lendFormName");
			HttpSession session = request.getSession();
			EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
			int teacher_id =info.getUserId();

			conditions.put("teacherId", teacher_id);//教师Id
			conditions.put("trainFormId", lendFormId);//培训类型
			conditions.put("trainFormName", lendFormName);//培训类型
			conditions.put("lastYear", Integer.parseInt(StringUtils.isEmpty(lendYear)?null:lendYear) - 1);//借贷年份的前一年
			conditions.put("lendStatus","0,1,3");
			//借贷年份的前一年是否有借贷记录
			PageObject pageObject= teacherProjectServiceIF.queryTeacherLendCredit(conditions);
			
			conditions.put("lendYear", StringUtils.isEmpty(lendYear)?null:lendYear);//借贷年份
			conditions.put("lendReason", StringUtils.isEmpty(lendReason)?null:lendReason);//借贷原因
			conditions.put("lendCredit", StringUtils.isEmpty(lendCredit)?null:lendCredit);//借贷学分
			conditions.put("lendStatus",null);
			
			if(pageObject.getObjects().size() > 0){
				result.put("success", false);
				result.put("message", "近两年已经有借贷记录，无法再借贷。");
			}else{
				try {
					boolean isSuccess = teacherProjectServiceIF.insertLendCredit(conditions);
					if(isSuccess){
						result.put("success", true);
					}else{
						result.put("success", false);
						result.put("message", "借贷失败");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			return result;
		}
		
		/**
		 * 修改借贷学分
		 * @return
		 * @throws Exception 
		 */
		@RequestMapping("/updateLendCredit.do")
		public @ResponseBody Map<String, Object> updateLendCredit(HttpServletRequest request) throws Exception{
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String, Object> conditions = super.getCode(request);
			String lendYear = request.getParameter("lendYear");
			String lendReason = request.getParameter("lendReason");
			String lendCredit = request.getParameter("lendCredit");
			String id = request.getParameter("id");
			String lendFormId = request.getParameter("lendFormId");
			String lendFormName = request.getParameter("lendFormName");

			HttpSession session = request.getSession();
			EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
			int teacher_id =info.getUserId();


			conditions.put("lendYear", StringUtils.isEmpty(lendYear)?null:lendYear);//借贷年份
			conditions.put("teacherId", teacher_id);//教师Id
			conditions.put("trainFormId", lendFormId);//培训形式id
			PageObject pageObject= teacherProjectServiceIF.queryTeacherLendCredit(conditions);
			if(pageObject.getObjects().size() > 1){//检测该年度该培训形势下是否有学分借贷
				result.put("success", false);
				result.put("message", lendYear+"年度在"+lendFormName+"下已经进行过学分借贷");
				return result;
			}else if(pageObject.getObjects().size() == 1){
				if(((EduCreditLend)pageObject.getObjects().get(0)).getId() != Integer.parseInt(id)){
					result.put("success", false);
					result.put("message", lendYear+"年度在"+lendFormName+"下已经进行过学分借贷");
					return result;
				}
			}
			
			conditions.put("id", StringUtils.isEmpty(id)?null:id);//借贷id
			conditions.put("lendReason", StringUtils.isEmpty(lendReason)?null:lendReason);//借贷原因
			conditions.put("lendCredit", StringUtils.isEmpty(lendCredit)?null:lendCredit);//借贷学分
			conditions.put("trainFormName", lendFormName);//培训形式name
			
			try {
				boolean isSuccess = teacherProjectServiceIF.updateLendCredit(conditions);
				if(isSuccess){
					result.put("success", true);
				}else{
					result.put("success", false);
					result.put("message", "修改学分借贷失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		/**
		 * 教师学习项目得分列表
		 * @return
		 */
		@RequestMapping("/queryTeacherScore.do")
		public @ResponseBody Map<String, Object> queryTeacherScore(HttpServletRequest request){
			
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String, Object> conditions = super.getCode(request);
			String teacherId = request.getParameter("teacherId") ;
			String queryYear = request.getParameter("queryYear");
			int teacher_id;
			if(teacherId == null || teacherId.equals("null")){
				teacher_id = getAccountId(request);
			}else{
				teacher_id = Integer.parseInt(teacherId);
			}
			conditions.put("teacherId", teacher_id);//教师Id
			conditions.put("startYear",queryYear+"-01-01");//查询年度
			conditions.put("endYear",(Integer.parseInt(queryYear)+1)+"-01-01");//查询年度
			conditions.put("year", queryYear);//查询年度所需学分和学时使用
			List<EduDiploma> list = eduManageService.selectYearDiploma(conditions);
			try {
				PageObject pageObject= teacherProjectServiceIF.queryTeacherScore(conditions);
				result.put("rows", pageObject.getObjects());
				
				//设置要求学分
				//获得用户地区
				String code = "";
				if(getRoleId(request) == 1){
					code = getUserProvinceId(request);
				}else if(getRoleId(request) == 2){
					code = getUserCityId(request);
				}else{
					code = getUserDistrictId(request);
				}
				SysArea area = sysService.selectAreaByCode(code);
				if(list.size() > 0){
					String needCredit = list.get(0).getNeedCredit1();
					Map<String,Float> mapNeed = new HashMap<String,Float>();
					for(String need : needCredit.split(",")){
						mapNeed.put(need.split("-")[0], Float.parseFloat(need.split("-")[1]));
					}
					result.put("needCredit", mapNeed.toString().substring(1, mapNeed.toString().length() - 1));
//					Integer schoolID = getAccountId(request);
					if(Common.DIRECT_UNIT.contains(String.valueOf(getSchoolId(request))) && area.getAreaCode().equals("220802")){
						result.put("needCredit", "网络培训="+list.get(0).getNeedPeriod() * 0.7);
					}
				}else{
					result.put("needCredit", "未设置");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		/**
		 * 偿还借贷学分
		 * @return
		 * @throws Exception 
		 * @throws NumberFormatException 
		 */
		@RequestMapping("/repayLendCredit.do")
		public @ResponseBody Map<String, Object> repayLendCredit(HttpServletRequest request) throws NumberFormatException, Exception{
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String, Object> conditions = super.getCode(request);
			String repayCredit = request.getParameter("repayCredit");
			String id = request.getParameter("id");
			String repayYear = request.getParameter("repayYear");
			String trainFormId = request.getParameter("trainFormId");
			HttpSession session = request.getSession();
			EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
			int teacher_id =info.getUserId();
			float total = getTotalCredit(Integer.parseInt(repayYear) + 1,teacher_id, Integer.parseInt(trainFormId));//取得今年取得的总学分，repayYear是借贷的年限。偿还年度应为第二年
			float remainCredit = getRemain(Integer.parseInt(repayYear), teacher_id, Integer.parseInt(trainFormId),request);
			total += remainCredit;
			
			if(total < Float.parseFloat(repayCredit)){
				result.put("success", false);//1 ：本年度学分不够偿还借贷学分
				result.put("message", "本年度累计学分不够偿还借贷学分，请继续努力学习");
			}else{
				try {
					conditions.put("id", StringUtils.isEmpty(id)?null:id);//借贷id
					conditions.put("repayCredit", StringUtils.isEmpty(repayCredit)?null:repayCredit);//偿还学分
					conditions.put("status",Common.CREDIT_LEND_COMMON_STATUS.get("已偿还"));
					boolean isSuccess = teacherProjectServiceIF.repayLendCredit(conditions);
					if(isSuccess){
						result.put("success", true);
					}else{
						result.put("success", false);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		}
		
		/**
		 * 查询去年剩余学分
		 * @return
		 * @throws Exception 
		 * @throws NumberFormatException 
		 */
		@RequestMapping("/queryRemainScore.do")
		public @ResponseBody Map<String, Object> queryRemainScore(HttpServletRequest request) throws NumberFormatException, Exception{
			Map<String,Object> result = new HashMap<String,Object>();
			HttpSession session = request.getSession();
			EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
			String teacherId = request.getParameter("teacherId") ;
			int teacher_id;
			if(teacherId == null || teacherId.equals("null")){//查询登录系统用户
				teacher_id = info.getUserId();
			}else{//查询指定用户
				teacher_id = Integer.parseInt(teacherId);
			}
			String queryYear = request.getParameter("queryYear");
			Map<String,Float> creditMap = new HashMap<String,Float>();
			for(SysDictionary form : getTrainForm()){
				float remain = getRemain(Integer.parseInt(queryYear) - 1, teacher_id, form.getDictionaryId(),request);
				creditMap.put(form.getDictionaryName(), dorounded(remain));
			}
			
			result.put("remainCredit", creditMap.toString().substring(1, creditMap.toString().length() - 1));
			return result;
		}
		/**
		 * 获得year年前，应该获得学分
		 * @param year
		 * @return
		 * @throws Exception 
		 */
		public Map<String,Float> getNeedCredit(String year) throws Exception{
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("year", year);
			List<String> str = sysService.getNeedCredit(params);//获得所需学分
			Map<String,Float> m = new HashMap<String,Float>();
			for(String s: str){
				String[] sArr = s.split(",");
				for(String ss : sArr){
					if(m.get(ss.split("-")[0]) != null){
						m.put(ss.split("-")[0], Float.parseFloat(ss.split("-")[1]) + m.get(ss.split("-")[0]));
					}else{
						m.put(ss.split("-")[0], Float.parseFloat(ss.split("-")[1]));
					}
				}
			}
			for(SysDictionary form : getTrainForm()){
				if(!m.containsKey(form.getDictionaryName())){
					m.put(form.getDictionaryName(), (float)0);
				}
			}
			return m;
		}
		/**
		 * 获得系统中培训过形式
		 * @return
		 * @throws Exception
		 */
		public List<SysDictionary> getTrainForm() throws Exception{
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("dictionaryTypeId", "training_from"); 
			params.put("status", "1"); 
			List<SysDictionary> trainForms = (List<SysDictionary>)dictionaryService.querySysDictionaryes(params,0, Common.PNN_USER_PAGE_LIMIT).getObjects();
			return trainForms;
		}
		/**
		 * 保留小数点后两位
		 * @param n
		 * @return
		 */
		public float dorounded(float n){
			BigDecimal   b1   =   new   BigDecimal(n); 
			return b1.setScale(2,   BigDecimal.ROUND_HALF_UP).floatValue();
			
		}
		/**
		 * 教师成绩是否合格
		 * @return
		 * @throws Exception 
		 */
		@RequestMapping("/teacherPrintQualified.do")
		public @ResponseBody Map<String, Object> teacherPrintQualified(HttpServletRequest request) throws Exception{
			//获得用户地区
			String code = "";
			if(getRoleId(request) == 1){
				code = getUserProvinceId(request);
			}else if(getRoleId(request) == 2){
				code = getUserCityId(request);
			}else{
				code = getUserDistrictId(request);
			}
			SysArea area = sysService.selectAreaByCode(code);
			String message = "";
			Map<String, Object> condition = super.getCode(request);
			Map<String,Object> result = new HashMap<String,Object>();
			int teacherId = getAccountId(request);
			String diplomaId = request.getParameter("diplomaId");
			condition.put("id", diplomaId);
			List<EduDiploma> list = eduManageService.selectYearDiploma(condition);
			EduDiploma pojo = list.get(0);
			condition.clear();
			condition.put("teacherId", teacherId);
			condition.put("lendStatus", 1);
			condition.put("lendYear", pojo.getYear() - 1);
			//检测教师是否还有未偿还借贷
			if(!Common.AUTO_CREDIT_lEND.contains(area.getAreaCode())){
				PageObject pageObject= teacherProjectServiceIF.queryTeacherLendCredit(condition);
				if(pageObject.getObjects().size() > 0){//检测该年度该培训形势下是否有学分借贷
					result.put("success", false);
					result.put("message", "您还有未偿还的学分借贷，请偿还后再打印证书。");
					return result;
				}
			}
			Map<String,Float> m = getNeedCredit(String.valueOf(pojo.getYear()));
			//获得各种形式所需学分
			String creditStr[] =  pojo.getNeedCredit1().split(",");
			if(Common.DIRECT_UNIT.contains(String.valueOf(getSchoolId(request))) && area.getAreaCode().equals("220802")){
				creditStr = new String[1];
				creditStr[0] = "网络培训-"+pojo.getNeedPeriod() * 0.7;
			}
			
			for(SysDictionary form : getTrainForm()){
				if(m.get(form.getDictionaryName()) == null){
					m.put(form.getDictionaryName(), (float) 0);
				}
				for(String credit : creditStr){
					if(form.getDictionaryName().equals(credit.split("-")[0])){
						float total = getTotalCredit(pojo.getYear(), teacherId,form.getDictionaryId());//今年获得学分
						float remainCredit = getRemain(pojo.getYear() - 1, teacherId, form.getDictionaryId(),request);
						float lend  = getLendCredit(pojo.getYear(), teacherId,form.getDictionaryId());//今年借贷学分
						float repay = getRepayCredit(pojo.getYear(), teacherId, form.getDictionaryId());//今年偿还学分
						float totalCredit = total + remainCredit +lend - repay;
						if(Common.AUTO_CREDIT_lEND.contains(area.getAreaCode())){
							condition.clear();
							//1.偿还去年借贷记录
							condition.put("lendStatus", 1);//状态
							condition.put("teacherId", getAccountId(request));//教师Id
							condition.put("lendYear", pojo.getYear() - 1);//年份
							condition.put("trainFormId", form.getDictionaryId());//培训形式id
							PageObject pageObject3= teacherProjectServiceIF.queryTeacherLendCredit(condition);
							if(pageObject3.getObjects().size() > 0){
								EduCreditLend c = (EduCreditLend) pageObject3.getObjects().get(0);
								if(totalCredit >= c.getLendCredit() * pojo.getRepayRate()){
									condition.put("id",c.getId());//借贷id
									condition.put("repayCredit", c.getLendCredit() * pojo.getRepayRate());//偿还学分
									condition.put("status",Common.CREDIT_LEND_COMMON_STATUS.get("已偿还"));
									teacherProjectServiceIF.repayLendCredit(condition);
									message += form.getDictionaryName() + "已偿还" + c.getLendCredit() * pojo.getRepayRate()+";";
									totalCredit -= c.getLendCredit() * pojo.getRepayRate();
								}else{
									result.put("success", false);
									result.put("message", message + form.getDictionaryName() + " 所得学分暂时不够偿还去年借贷学分");
									return result;
								}
							}
							
							//1.查看去年有借贷记录
							condition.put("lendStatus", "1,3");//教师Id
							PageObject pageObject2= teacherProjectServiceIF.queryTeacherLendCredit(condition);
							boolean haveLend = pageObject2.getObjects().size() > 0;
						
							//3.今年不够进行接待
							Float creditLend = Float.parseFloat(credit.split("-")[1]) - totalCredit;
							if(creditLend > 0){
								if(haveLend){
									result.put("success", false);
									result.put("message", message + "成绩未达标，且"+(pojo.getYear() - 1)+"年度在"+form.getDictionaryName()+"下已经进行过学分借贷");
									return result;
								}else{
									condition.clear();
									condition.put("lendYear", pojo.getYear());
									condition.put("lendCredit", creditLend);
									condition.put("teacherId", getAccountId(request));
									condition.put("trainFormId", form.getDictionaryId());
									condition.put("trainFormName", form.getDictionaryName());
									condition.put("lendReason", "自动借贷");
									condition.put("lendStatus", 1);
									if(!teacherProjectServiceIF.insertLendCredit(condition)){
										result.put("success", false);
										result.put("message", "打印失败");
										return result;
									}
									totalCredit += creditLend;
									message+= form.getDictionaryName() +"借贷了" +creditLend+"学分"+";";
								}
							}
						}
						
						if(Float.parseFloat(credit.split("-")[1]) > totalCredit){
							result.put("success", false);
							result.put("message", "成绩未达标，请继续努力。");
							return result;
						}
					}
				}
			}
				result.put("success", true);
				result.put("message", message == "" ? "成绩合格，请打印":message);
			return result;
		}
		
		
		/**
		 * 检查借贷的学分是多少
		 * @return
		 * @throws Exception 
		 * @throws NumberFormatException 
		 */
		@RequestMapping("/checkLendCredit.do")
		public @ResponseBody Map<String, Object> checkLendCredit(HttpServletRequest request) throws NumberFormatException, Exception{
			Map<String, Object> condition = super.getCode(request);
			Map<String,Object> result = new HashMap<String,Object>();
			int teacherId = getAccountId(request);
			String lendCredit = request.getParameter("lendCredit");
			String lendYear = request.getParameter("lendYear");
			String trainForm = request.getParameter("trainForm");
			float total = getTotalCredit(Integer.parseInt(lendYear), teacherId, Integer.parseInt(trainForm));//今年获得学分
			float remainCredit = getRemain(Integer.parseInt(lendYear) - 1, teacherId, Integer.parseInt(trainForm),request);
			total = dorounded(total + remainCredit);
			float totalAll = total + Float.parseFloat(lendCredit);
			float needCredit = 0;
			String trainType = "";
			condition.put("year", lendYear);
			List<EduDiploma> list = eduManageService.selectYearDiploma(condition);
			if(list.size() == 0 ){
				result.put("success", false);
				result.put("message", "管理员还未设置年度要求学分。");
				return result;
			}
			EduDiploma pojo = list.get(0);
			for(SysDictionary form : getTrainForm()){
				if(Integer.parseInt(trainForm) == form.getDictionaryId()){
					trainType = form.getDictionaryName();
					String s = pojo.getNeedCredit1();
					String s2 = s.substring(s.indexOf(trainType)).split(",")[0].substring(s.substring(s.indexOf(trainType)).split(",")[0].indexOf("-")+1);
					needCredit = Float.parseFloat(s2);
				
				}
			}
			
			if(total >= needCredit){
				result.put("success", false);
				result.put("message", "您本年度在 "+trainType+" 获得总学分为："+total+",已达到最低要求："+needCredit+"学分。无需借贷");
				return result;
			}
			if(totalAll ==needCredit){
				result.put("success", true);
			}else if(totalAll > needCredit){
				result.put("success", false);
				result.put("message", "本年度在 "+trainType+" 获得总学分为："+total+",本年度应完成至少"+needCredit+"学分。您最多只能借贷"+ (dorounded(needCredit - total))+"学分");
			}else{result.put("success", false);
				result.put("message", "本年度在 "+trainType+" 获得总学分为："+total+",本年度应完成至少"+needCredit+"学分。您至少需要借贷"+ (dorounded(needCredit - total))+"学分");
			}
			
			return result;
		}
		
		/**
		 * 查询年度总学分(本年度取得的的总学分)
		 * @param year	查询的年度
		 * @return
		 */
		public Float getTotalCredit(int queryYear,int teacherId, int trainForm){

			Float result = null;
			Map<String, Object> conditions = new HashMap<String, Object>();
			conditions.put("teacherId", teacherId);//教师Id
			conditions.put("year",queryYear);//查询年度
			conditions.put("startYear",queryYear+"-01-01");//查询開始年度
			conditions.put("endYear",(queryYear+1)+"-01-01");//查询結束年度
			conditions.put("trainForm", trainForm);//培训形式
			try {
				if(trainForm == 5){
					result= teacherProjectServiceIF.queryTeacherTotalIsCreditByYear(conditions);
				}else{
					result= teacherProjectServiceIF.queryTeacherTotalCreditByYear(conditions);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		/**
		 * 查询年度借贷
		 * @param year	查询的年度
		 * @return
		 */
		public Float getLendCredit(int queryYear,int teacherId, int trainForm){

			Float result = null;
			Map<String, Object> conditions = new HashMap<String, Object>();
			conditions.put("teacherId", teacherId);//教师Id
			conditions.put("lendYear",queryYear);//查询年度
			conditions.put("lendStatus","1,3");//借贷状态
			conditions.put("trainForm",trainForm);//培训形式
			try {
				result= teacherProjectServiceIF.queryTeacherLendCreditByYear(conditions);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		/**
		 * 查询年度还贷学分
		 * @param year	查询的年度
		 * @return
		 */
		public Float getRepayCredit(int queryYear,int teacherId,int trainForm){

			Float result = null;
			Map<String, Object> conditions = new HashMap<String, Object>();
			conditions.put("teacherId", teacherId);//教师Id
			conditions.put("lendYear",queryYear - 1);//查询年度
			conditions.put("lendStatus",3);//借贷状态
			conditions.put("trainForm",trainForm);//培训形式
			try {
				result= teacherProjectServiceIF.queryTeacherRepayCreditByYear(conditions);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		/**
		 * 查询年度总学时(本年度取得的的总学时)
		 * @param year	查询的年度
		 * @return
		 */
		public Float getTotalPeriod(int queryYear,int teacherId){

			Float result = null;
			Map<String, Object> conditions = new HashMap<String, Object>();
			conditions.put("teacherId", teacherId);//教师Id
			conditions.put("startYear",queryYear+"-01-01");//查询年度
			conditions.put("endYear",(queryYear+1)+"-01-01");//查询年度
			try {
				result= teacherProjectServiceIF.queryTeacherTotalPeriodByYear(conditions);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		@RequestMapping("/getTotal.do")
		public  @ResponseBody Map<String, Object> getTotal(HttpServletRequest request) throws Exception {
			Map<String, Object> result = new HashMap<String, Object>();
			String reditStr = request.getParameter("creditStr").replace(" ", "");
			String creditArr[] = reditStr.split(",");
			Map<String,Float> map = new HashMap<String, Float>();
			if(reditStr.length() > 0){
				for(String s : creditArr){
					BigDecimal   b1   =   new   BigDecimal(Float.parseFloat(s.split("=")[1])); 
					float cre1 = b1.setScale(1,   BigDecimal.ROUND_HALF_UP).floatValue();
					if(map.containsKey(s.split("=")[0])){
						BigDecimal   b2   =   new   BigDecimal(cre1 +map.get(s.split("=")[0])); 
						map.put(s.split("=")[0], b2.setScale(1,   BigDecimal.ROUND_HALF_UP).floatValue());
					}else{
						map.put(s.split("=")[0], cre1);
					}
				}
			}
			for(SysDictionary form : getTrainForm()){
				if(!map.containsKey(form.getDictionaryName())){
					map.put(form.getDictionaryName(), (float)0);
				}
			}
			result.put("credit", map.toString().substring(1, map.toString().length() - 1));
			return result;
		}
		
		/**
		 * 教师借贷列表
		 * @return
		 */
		@RequestMapping("/queryTeacherLendCreditByArea.do")
		public @ResponseBody Map<String, Object> queryTeacherLendCreditByArea(HttpServletRequest request){
			
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String, Object> conditions = super.getCode(request);
			String lendYear = request.getParameter("lendYear");
			HttpSession session = request.getSession();
			EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
			int roleId = info.getRoleId();
			if(roleId == 1){
				conditions.put("provinceId", info.getUserProvinceId());
			}else if(roleId == 2){
				conditions.put("cityId", info.getUserCityId());
			}else if(roleId == 3){
				conditions.put("districtId", info.getUserDistrictId());
			}else if(roleId == 4){
				conditions.put("schoolId", info.getSchoolId());
			}else{
				conditions.put("userId", info.getUserId());
			}
			
			conditions.put("lendYear", StringUtils.isEmpty(lendYear)?null:lendYear);//借贷年份
			PageObject pageObject= teacherProjectServiceIF.queryAllTeacherLendCreditByArea(conditions);
			result.put("rows", pageObject.getObjects());
			return result;
		}
		
		/**
		 * 教师自主研修申报与查询
		 * @return
		 */
		@RequestMapping("/toDeclareIndependentStudy.htm")
		public String toDeclareIndependentStudy(HttpServletRequest request){
			return "teacher/toDeclareIndependentStudy";
		}
		/**
		 * 教师特殊情况申报
		 * @return
		 */
		@RequestMapping("/toSpecialCase.htm")
		public String toSpecialCase(HttpServletRequest request){
			return "teacher/toSpecialCase";
		}
		/**
		 * 教师自主研修申报
		 * @return
		 */
		@RequestMapping("/toDeclareDepStudyAdd.htm")
		public String toDeclareDepStudyAdd(HttpServletRequest request){
			return "teacher/toDeclareDepStudyAdd";
		}
		/**
		 * 教师特殊研修申报
		 * @return
		 */
		@RequestMapping("/toSpecialCaseAdd.htm")
		public String toSpecialCaseAdd(HttpServletRequest request){
			return "teacher/toSpecialCaseAdd";
		}

		/**
		 * 申请自主研修
		 * @return
		 * @throws Exception 
		 */
		@RequestMapping("/addInpedtStudy.do")
		public @ResponseBody Map<String, Object> addInpedtStudy(HttpServletRequest request,HttpServletResponse response,EduIndependentStudy eis, MultipartHttpServletRequest mrequest) throws Exception{
			Map<String,Object> result = new HashMap<String,Object>();
			eis.setTeacherId(String.valueOf(getAccountId(mrequest)));
			eis.setTeacherName(getRealName(mrequest));
			eis.setCreateDate(DateUtil.getSystemTimeFormat("yyyy-MM-dd"));
			eis.setTrainFormId("5");
			eis.setTrainFormName("自主研修");
			List<MultipartFile> files = mrequest.getFiles("file");
			int isId = teacherWriteDao.insertIndeptStudy(eis);
			if(isId > 0){
				if(files.size()>0 && files.get(0).getSize() >0){
					result = fileUploadService.fileUpload(request, response, FileType.INDEPENDENTSTDY, isId, eis.getIsStudyTypeName(),
						getAccountId(request), getAccount(request), getRoleId(request));
					if((Boolean) result.get("success")){
						//成功
						result.put("success", true);
						result.put("message", "新增成功");
					}else{
						//上传文件失败，但是添加自主成功，需删除
						teacherWriteDao.deleteIndeptStudy(isId);
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
		 * 自主研修查询
		 * @return
		 * @throws Exception 
		 */
		@RequestMapping("/queryTeacherIndeptStudy.do")
		public @ResponseBody Map<String, Object> queryTeacherIndeptStudy(HttpServletRequest request) throws Exception{
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String,Object> condition = new HashMap<String,Object>();
			String queryYear = request.getParameter("queryYear");
			String teacherName = request.getParameter("teacherName");
			String status = request.getParameter("status");
			condition.put("queryYear", queryYear);//查询年限
			condition.put("status", status);//状态
			if(getRoleId(request) == 1){//省级行政
				condition.put("provinceId", getUserProvinceId(request));
			}else if(getRoleId(request) == 2){//市级行政
				condition.put("cityId", getUserCityId(request));
			}else if(getRoleId(request) == 3){//区县级行政
				condition.put("districtId", getUserDistrictId(request));
			}else if(getRoleId(request) == 4){//学校
				condition.put("schoolId", getSchoolId(request));
			}else if(getRoleId(request) == 5){//教师
				condition.put("teacherId", getAccountId(request));
			}
			condition.put("teacherName", teacherName);
			String id = request.getParameter("id");
			if(id != null){
				condition.clear();
				condition.put("id", id);
			}
			
			PageObject pageObject = teacherReadDao.queryTeacherIndeptStudyList(condition);
			result.put("rows", pageObject.getObjects());
			return result;
		}
		
		/**
		 * 删除自主研修申报
		 */
		@RequestMapping("indeptStudyDelete.do")
		public @ResponseBody  Map<String,Object> indeptStudyDelete(
				HttpServletRequest request,HttpServletResponse response) throws Exception{
			Map<String,Object> result = new HashMap<String, Object>();
			Map<String,Object> condition = super.getCode(request);
			String id = request.getParameter("id"); 
			
			condition.put("id", id);
			if(teacherWriteDao.deleteIndeptStudy(Integer.parseInt(id))){
				condition.clear();
				condition.put("isId", id);
				fileUploadService.deleteFileByProjectId(condition);
				result.put("success", true);
			}else{
				result.put("success", false);
			}
			return result;
		}
		/**
		 * 跳转到审核界面
		 */
		@RequestMapping("/toAuditIndeptStudy.htm")
		public String toAuditIndeptStudy(){
			return "teacher/auditIndeptStudy";
		}
		/**
		 * 审核
		 */
		@RequestMapping("auditIndeptStudy.do")
		public @ResponseBody Map<String,Object> auditCreditLend(HttpServletRequest request){
			Map<String, Object> result = new HashMap<String, Object>();
			Map<String, Object> conditions = super.getCode(request);
			conditions.put("id", request.getParameter("id"));
			conditions.put("auditId", getAccountId(request));
			conditions.put("auditName", getRealName(request));
			conditions.put("auditDate", DateUtil.getSystemTimeFormat("yyyy-MM-dd"));
			conditions.put("command", request.getParameter("memo"));
			conditions.put("status", Integer.parseInt(request.getParameter("audtiStatus"))==1?2:3);
			
			try {
				if(teacherWriteDao.updateIndeptStudy(conditions)){
					DataUtil.setOk(result);
				}
			} catch (Exception e) {
				log.info("审核失败！"+e.getMessage());
				DataUtil.setFail(result);
				e.printStackTrace();
			}
			return result;
		}
		/**
		 * 教师自主研修项目得分列表
		 * @return
		 */
		@RequestMapping("/queryTeacherIsScore.do")
		public @ResponseBody Map<String, Object> queryTeacherIsScore(HttpServletRequest request){
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String, Object> conditions = super.getCode(request);
			String teacherId = request.getParameter("teacherId") ;
			String status = request.getParameter("status") ;
			int teacher_id;
			if(teacherId == null || teacherId.equals("null")){
				teacher_id = getAccountId(request);
			}else{
				teacher_id = Integer.parseInt(teacherId);
			}
			conditions.put("teacherId", teacher_id);//教师Id
			conditions.put("status", status);//审核状态
			conditions.put("queryYear", request.getParameter("queryYear"));//查询年度所需学分和学时使用
			try {
				PageObject pageObject = teacherReadDao.queryTeacherIndeptStudyList(conditions);
				result.put("rows", pageObject.getObjects());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		/**
		 * 申请特殊研修
		 * @return
		 * @throws Exception 
		 */
		@RequestMapping("/addSpecialCase.do")
		public @ResponseBody Map<String, Object> addSpecialCase(HttpServletRequest request,HttpServletResponse response,
				EduProjectComment epc, MultipartHttpServletRequest mrequest) throws Exception{
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("id", epc.getProjectId());
			List<EduProject> po = eduProjectService.getSpecialProject(params);
			params.clear();
			params.put("projectId", epc.getProjectId());
			params.put("teacherId", getAccountId(mrequest));
			params.put("status", 13);
			params.put("teacherTrainStatusId", 13);
			String now = DateUtil.getSystemTimeFormat("yyyy-MM-dd");
			params.put("createDate", epc.getCreateDate1()+now.substring(4));
			params.put("teacherTrainStatusName", "合格");
			params.put("createBy", getRealName(mrequest));
			params.put("teacherScoreAuditStatusId", 13);
			params.put("teacherScoreAuditStatusName", "合格");
			params.put("examine", 0);
			params.put("teacherClassScore", po.get(0).getClassScore());
			
			List<MultipartFile> files = mrequest.getFiles("file");
			int id = eduProjectService.addProjectComment(params);
			if(id > 0){
				if(files.size()>0 && files.get(0).getSize() >0){
					result = fileUploadService.fileUpload(request, response, FileType.SPECIAL_CASE_TEMPLATE, id, po.get(0).getProjectName(),
						getAccountId(request), getAccount(request), getRoleId(request));
					if((Boolean) result.get("success")){
						//成功
						result.put("success", true);
						result.put("message", "新增成功");
					}else{
						//上传文件失败，但是添加自主成功，需删除
						teacherWriteDao.deleteIndeptStudy(id);
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
		@RequestMapping("/getSpecialProject.do")
		public @ResponseBody Map<String, Object> getSpecialProject(HttpServletRequest request){
			Map<String,Object> result = new HashMap<String,Object>();
			List<EduProject> po = eduProjectService.getSpecialProject(null);
			result.put("rows", po);
			return result;
		}
		/**
		 * 查询教师特殊研修
		 * @return
		 */
		@RequestMapping("/queryTeacherSpecialCase.do")
		public @ResponseBody Map<String, Object> queryTeacherSpecialCase(HttpServletRequest request){
			Map<String,Object> result = new HashMap<String,Object>();
			Map<String, Object> conditions = super.getCode(request);
			String queryYear = request.getParameter("queryYear");
			String teacherName = request.getParameter("teacherName");
			String status = request.getParameter("status") ;
			if(getRoleId(request) == 1){//省级行政
				conditions.put("provinceId", getUserProvinceId(request));
			}else if(getRoleId(request) == 2){//市级行政
				conditions.put("cityId", getUserCityId(request));
			}else if(getRoleId(request) == 3){//区县级行政
				conditions.put("districtId", getUserDistrictId(request));
			}else if(getRoleId(request) == 4){//学校
				conditions.put("schoolId", getSchoolId(request));
			}else if(getRoleId(request) == 5){//教师
				conditions.put("teacherId", getAccountId(request));
			}
			conditions.put("status", status);//审核状态
			conditions.put("queryYear", queryYear);//查询年度所需学分和学时使用
			conditions.put("teacherName", teacherName);//查询年度所需学分和学时使用
			try {

				String id = request.getParameter("id");
				if(id != null){
					conditions.clear();
					conditions.put("id", id);
				}
				PageObject pageObject = teacherReadDao.queryTeacherSpecialCaseList(conditions);
				result.put("rows", pageObject.getObjects());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		/**
		 * 删除特殊研修
		 */
		@RequestMapping("specialCaseDelete.do")
		public @ResponseBody  Map<String,Object> specialCaseDelete(
				HttpServletRequest request,HttpServletResponse response) throws Exception{
			Map<String,Object> result = new HashMap<String, Object>();
			Map<String,Object> condition = super.getCode(request);
			String id = request.getParameter("id"); 
			
			condition.put("id", id);
			if(teacherWriteDao.deleteSpecialCase(Integer.parseInt(id))){
				condition.clear();
				condition.put("projectId", id);
				condition.put("type", FileType.SPECIAL_CASE_TEMPLATE);
				fileUploadService.deleteFileByProjectId(condition);
				result.put("success", true);
			}else{
				result.put("success", false);
			}
			return result;
		}
		/**
		 * 跳转到特殊研修审核界面
		 */
		@RequestMapping("/toAuditSpecialCase.htm")
		public String toAuditSpecialCase(){
			return "teacher/auditSpecialCase";
		}
		/**
		 * 审核特殊研修
		 */
		@RequestMapping("auditSpecialCase.do")
		public @ResponseBody Map<String,Object> auditSpecialCase(HttpServletRequest request){
			Map<String, Object> result = new HashMap<String, Object>();
			Map<String, Object> conditions = super.getCode(request);
			conditions.put("id", request.getParameter("id"));
			conditions.put("updateId", getAccountId(request));
			conditions.put("updateName", getRealName(request));
			conditions.put("updateDate", DateUtil.getSystemTimeFormat("yyyy-MM-dd"));
			conditions.put("auditMemo", request.getParameter("memo"));
			conditions.put("examine", Integer.parseInt(request.getParameter("audtiStatus"))==1?1:2);
			
			try {
				if(teacherWriteDao.updateSpecialCase(conditions)){
					DataUtil.setOk(result);
				}
			} catch (Exception e) {
				log.info("审核失败！"+e.getMessage());
				DataUtil.setFail(result);
				e.printStackTrace();
			}
			return result;
		}
		
		/**
		 * 
		 * @param year 查询年限结余年限
		 * @return 
		 * @throws Exception 
		 */
		public float getRemain(int year,int teacherId,int trainFormId,HttpServletRequest request) throws Exception{
			//
			SysArea area = sysService.selectAreaByCode(getUserDistrictId(request));
			int sYear = sysService.selectInitYear();
			List<SysDictionary> forms = getTrainForm();
			String trainFormName = "";
			for(SysDictionary form : forms){
				if(form.getDictionaryId() == trainFormId){
					trainFormName = form.getDictionaryName();
				}
			}
			float remainCredit = 0;
			while(sYear <= year){
				Map<String, Object> params = new HashMap<String, Object>();
				//+学习得到的学分
				//+借贷的学分
				//+偿还的学分
				params.put("year", sYear);
				params.put("repayYear", sYear - 1);
				params.put("teacherId", teacherId);
				params.put("trainFormId", trainFormId);
				List<EduTeacherScoreInfo> teacerRemain = new ArrayList<EduTeacherScoreInfo>();
				if(trainFormId == 5){//自主研修
					teacerRemain = teacherReadDao.getTeacherIsTrainRemainCredit(params, 0, 10);
				}else{
					teacerRemain = sysService.getTeacherTrainRemainCredit(params, 0, 10);//获得结余学分
				}
				Map<String,Float> m = getNeedCredit(String.valueOf(year));
				float getCredit = 0;
				if(teacerRemain.size() > 0){
					getCredit = (Float.parseFloat(teacerRemain.get(0).getRemainCredit()));
					if(area != null && !Common.AUTO_CREDIT_lEND.contains(area.getAreaCode())){
						if(trainFormId == 5){//东丰自主研修上限4学分
							getCredit = getCredit > 4 ? 4 : getCredit;
						}else if(trainFormId == 4){//东丰县校本研修上限8学分
							getCredit = getCredit > 8 ? 8 : getCredit;
						}
					}
					getCredit -= m.get(trainFormName);
				}
				remainCredit += getCredit > 0 ? getCredit : 0 ;
				sYear++;
			}
			return remainCredit;
		}
}
