package project.organization.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import project.edupm.projectmanage.dto.EduProjectDTO;
import project.edupm.projectmanage.pojo.EduProjectProcess;
import project.edupm.projectmanage.service.IEduProjectOrgService;
import project.edupm.projectmanage.service.IEduProjectService;
import project.edupm.projectmanage.service.ISummaryService;
import project.organization.pojo.OrgProjectInfoActivity;
import project.organization.pojo.Organization;
import project.organization.pojo.OrganizationProject;
import project.organization.pojo.ProjectClassActivity;
import project.organization.service.IOrganizationServiceIF;
import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;
import project.person.service.IUserService;
import project.system.pojo.EduSchool;
import project.system.pojo.SysDictionary;
import project.system.pojo.SysSetup;
import project.system.pojo.ZTree;
import project.system.service.ISysSchoolService;
import project.system.service.ISysService;
import project.teacher.teacherProject.service.ITeacherProjectServiceIF;
import project.teacher.teachermanage.pojo.EduProjectCommentTeacher;
import project.teacher.teachermanage.pojo.TeacherExportActivity;
import project.util.ApplicationProperties;
import project.util.DataUtil;
import project.util.ResponseUtil;
import framelib.controller.AbsController;
import framelib.utils.FileUtils;
import framelib.utils.page.PageObject;


/**
 * Title: OrganizationController
 * Description: 机构
 * 
 * @Create_by: zhangxiaoqi
 * @Create_date:2014-03-27
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 */
@Controller
@RequestMapping("/org")
public class OrganizationController extends AbsController{

	private static Log log = LogFactory.getLog(OrganizationController.class);
	
	@Autowired
	@Qualifier("schoolService")
	ISysSchoolService schoolService;
	
	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;
	
	
	@Autowired
	@Qualifier("eduProjectOrgService")
	IEduProjectOrgService eduProjectOrgService;
	
	@Autowired
	@Qualifier("organizationService")
	IOrganizationServiceIF orgService;
	

	@Autowired
	@Qualifier("userService")
	IUserService userService;
	
	@Autowired
	@Qualifier("sysService")
	ISysService sysService;
	
	
	@Autowired
	@Qualifier("summaryService")
	ISummaryService summaryService;
	
	@Autowired
	@Qualifier("dictionaryService")
	IDictionaryService dictionaryService;
	
	@Autowired
	@Qualifier("teacherProjectService")
	ITeacherProjectServiceIF teacherProjectServiceIF;
	
	/**
	 * 转向参训教师成绩修改页面
	 * */
	@RequestMapping("orgScoreModifyPage.htm")
	public String orgScoreModifyPage(){
		return "organization/orgScoreModify";
	}
	
	/**
	 * 查看已发布的培训成绩
	 * @return
	 */
	@RequestMapping("orgScorePublishedViewPage.htm")
	public String orgScorePublishedViewPage(){
		return "organization/orgScorePublishedView";
	}
	/**
 	 * 跳转到成绩修改项目列表页面
 	 * @return
 	 */
	@RequestMapping("orgScorePublishPage.htm")
	public String orgScorePublishPage(){
		return "organization/orgScorePublish";
	}
	/**
	 * 跳转到公布页面
	 * @return
	 */
	@RequestMapping("orgScorePublishPages.htm")
	public String orgScorePublishPages(){
		return "organization/orgScorePublishi";
	}

	/**
	 * 培训成绩公布规则页面
	 * */
	@RequestMapping("orgScorePublishRulePage.htm")
	public String orgScorePublishRulePage(){
		return "organization/orgScorePublishRule";
	}


	/**
	 * 跳转到机构:承培项目管理列表页面
	 * @return
	 */
	@RequestMapping("orgProjectListPage.htm")
	public String orgPrjoectListPage(){
		return "organization/orgProjectList";
	}
	
	
	/**
	 * 跳转到机构:承培项目详情页面
	 * @return
	 */
	@RequestMapping("orgProjectInfoPage.htm")
	public String orgProjectInfoPage(){
		return "organization/orgProjectInfo";
	}
	
	
	/**
	 * 跳转到机构:设置承培项目页面
	 * @return
	 */
	@RequestMapping("orgProjectModifyPage.htm")
	public String orgProjectModifyPage(){
		return "organization/orgProjectModify";
	}
	
	
	/**
	 * 跳转到机构:项目状态设置页面
	 * @return
	 */
	@RequestMapping("orgProjectStatusPage.htm")
	public String orgProjectStatusPage(){
		return "organization/orgProjectStatusList";
	}
	
	/**
	 * 跳转到机构:项目状态设置页面
	 * @return
	 */
	@RequestMapping("ssOrgProjectStatusPage.htm")
	public String ssOrgProjectStatusPage(){
		return "organization/ssOrgProjectStatusList";
	}
	
	
	/**
	 * 跳转到机构:参训教师管理页面
	 * @return
	 */
	@RequestMapping("orgProjectTeacherListPage.htm")
	public String orgProjectTeacherListPage(){
		return "organization/orgProjectTeacherList";
	}
	
	
	/**
	 * 跳转到机构:某一项目下参训教师管理页面
	 * @return
	 */
	@RequestMapping("orgProjectTeachersPage.htm")
	public String orgProjectTeachersPage(HttpServletRequest request, ModelMap map){
		String projectName = request.getParameter("projectName");
		try {
			projectName = new String(projectName.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			log.error("projectName转码失败");
			e.printStackTrace();
		}
		map.put("projectName", projectName);
		return "organization/orgProjectTeachers";
	}
	
	
	/**
	 * 跳转到机构:某一项目下参训教师对此项目评价页面
	 * @return
	 */
	@RequestMapping("orgProTeacherScoreListPage.htm")
	public String orgProTeacherScorePage(){
		return "organization/orgProTeacherScoreList";
	}
	
	
	/**
	 * 跳转到机构: 上传培训成绩列表页面
	 * @return
	 */
	@RequestMapping("orgUploadScoreListPage.htm")
	public String orgUploadScoreLis(){
		return "organization/orgUploadScoreList";
	}
	
	
	/**
	 * 跳转到机构: 上传培训成绩页面
	 * @return
	 */
	@RequestMapping("orgUploadScorePage.htm")
	public String orgUploadScorePage(){
		return "organization/orgUploadScore";
	}
	
	
	/**
	 * 跳转到机构课程设置列表
	 * @return
	 */
	@RequestMapping("toSetClassListPage.htm")
	public String toSetClassListPage(){
		return "organization/projectClassList";
	}
	
	/**
	 * 跳转到: 教师成绩列表页面
	 * @return
	 */
	@RequestMapping("toTeacherScoreViewPage.htm")
	public String toTeacherScoreViewPage(){
		return "organization/teacherScoreView";
	}
	
	
	
	/**
	 * 跳转到: 教师成绩查询下的项目列表页面
	 * @return
	 */
	@RequestMapping("toTeacherScoreProjectListPage.htm")
	public String toTeacherProjectListByAdminPage(){
		return "organization/teacherScoreProjectList";
	}
	
	
	/**
	 * 管理员: 教师成绩查询下的项目列表
	 * @param request
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("findTeacherScoreProjectList.do")
	public @ResponseBody Map<String,Object> findTeacherScoreProjectListByAdmin(int pageIndex, int pageSize, HttpServletRequest request){
		log.info("教师成绩查询下的项目列表");
		
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		
		String year = request.getParameter("projectYear");
		String projectName = request.getParameter("projectName");
		
		conditions.put("year", year == ""?null:year);
		conditions.put("projectName",projectName==null?null:projectName.length()==0?null:projectName);
		
		int roleId = super.getRoleId(request);
		if(roleId == 1 || roleId == 2 || roleId == 3){
			conditions.put("createById", this.getAccountId(request));
		}
		
		try {
			pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
			PageObject po = eduProjectService.queryTeacherProjectListByAdmin(conditions, pageIndex, pageSize);
			
			String areaId = super.getUserAreaId(request);
			Integer orgId = super.getOrganizationId(request);
			
			result.put("roleId", roleId);
			result.put("areaId", areaId);
			result.put("orgId", orgId);
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
	
	/**
	 * 获取机构列表 
	 * @return
	 */
	@RequestMapping("queryOrgList.do")
	public @ResponseBody Map<String, Object> queryOrgList(HttpServletRequest request, ModelMap map){
		Map<String, Object> param = getUserLocaltion(request);
		List objList = new ArrayList();
		param.put("type", 2);
		
		try {
			objList = orgService.selectOrgByArea(param);
		} catch (Exception e) {
			log.info("查询机构列表");
			e.printStackTrace();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(objList != null) {
			resultMap.put("rows", objList);
			resultMap.put("success", true);
		} else {
			resultMap.put("success", false);
		}
		
		return resultMap;
	}
	/**
	 * 获取项目名称列表 
	 * @return
	 */
	@RequestMapping("projectNameList.do")
	public @ResponseBody Map<String, Object> projectNameList(HttpServletRequest request, ModelMap map){
		Map<String, Object> param = getUserLocaltion(request);
		List objList = new ArrayList();
		
		
		try {
			objList = orgService.projectNameList(param);
		} catch (Exception e) {
			log.info("查询机构列表");
			e.printStackTrace();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(objList != null) {
			resultMap.put("rows", objList);
			resultMap.put("success", true);
		} else {
			resultMap.put("success", false);
		}
		
		return resultMap;
	}
	
	/**
	 * 获取项目性质 
	 * @return
	 */
	@RequestMapping("queryXiangMuList.do")
	public @ResponseBody Map<String, Object> queryXiangMuList(HttpServletRequest request, ModelMap map){
		Map<String, Object> param = getUserLocaltion(request);
		String status="1";
		int pageIndex=1;
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		
			paramMap.put("dictionaryTypeId", "project_nature");  //training_type
			paramMap.put("flag", Common.QUERY_DICTIONRAY_BY_ROLE);  
			paramMap.put("loginAccount", getAccount(request));  
			//paramMap.put("roleId", getRoleTypeId(request));  
			
		
		
		if (!StringUtils.isEmpty(status)) { 
			paramMap.put("status", status);
		}
		
		pageIndex = (pageIndex - 1) * sizePerPage;
		try {
			PageObject po = dictionaryService.querySysDictionary(paramMap,pageIndex, sizePerPage);
			if (po != null) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
				pageInfo.put("total", po.getCount());
				pageInfo.put("pageSize", po.getPagesize());
				pageInfo.put("pages", po.getPages());
				pageInfo.put("currentPage", po.getCurrentPage());
				pageInfo.put("pageNumbers", po.getPageNumbers());
				pageInfo.put("startIndex", po.getStartIndex());
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("字典表系统管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	/**
	 * 获取项目类型 
	 * @return
	 */
	@RequestMapping("queryXiangMuNeiXingList.do")
	public @ResponseBody Map<String, Object> queryXiangMuNeiXingList(HttpServletRequest request, ModelMap map){
		Map<String, Object> param = getUserLocaltion(request);
		String status="1";
		int pageIndex=1;
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		
			paramMap.put("dictionaryTypeId", "training_type");  //educational_user
		
		
		if (!StringUtils.isEmpty(status)) { 
			paramMap.put("status", status);
		}
		
		pageIndex = (pageIndex - 1) * sizePerPage;
		try {
			PageObject po = dictionaryService.querySysDictionaryes(paramMap,
					pageIndex, sizePerPage);
			if (po != null) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
				pageInfo.put("total", po.getCount());
				pageInfo.put("pageSize", po.getPagesize());
				pageInfo.put("pages", po.getPages());
				pageInfo.put("currentPage", po.getCurrentPage());
				pageInfo.put("pageNumbers", po.getPageNumbers());
				pageInfo.put("startIndex", po.getStartIndex());
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("字典表系统管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	@RequestMapping("queryXxlx.do")
	public @ResponseBody Map<String, Object> queryXxlx(HttpServletRequest request, ModelMap map){
		Map<String, Object> param = getUserLocaltion(request);
		String status="1";
		int pageIndex=1;
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
		
		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		
		paramMap.put("dictionaryTypeId", "school_type");  //educational_user
		
		
		if (!StringUtils.isEmpty(status)) { 
			paramMap.put("status", status);
		}
		
		pageIndex = (pageIndex - 1) * sizePerPage;
		try {
			PageObject po = dictionaryService.querySysDictionaryes(paramMap,
					pageIndex, sizePerPage);
			if (po != null) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
				pageInfo.put("total", po.getCount());
				pageInfo.put("pageSize", po.getPagesize());
				pageInfo.put("pages", po.getPages());
				pageInfo.put("currentPage", po.getCurrentPage());
				pageInfo.put("pageNumbers", po.getPageNumbers());
				pageInfo.put("startIndex", po.getStartIndex());
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("字典表系统管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	/**
	 * 获取项目类型 
	 * @return
	 */
	@RequestMapping("queryXueLiList.do")
	public @ResponseBody Map<String, Object> queryXueLiList(HttpServletRequest request, ModelMap map){
		Map<String, Object> param = getUserLocaltion(request);
		String status="1";
		int pageIndex=1;
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		
			paramMap.put("dictionaryTypeId", "educational_user");  
		
		
		if (!StringUtils.isEmpty(status)) { 
			paramMap.put("status", status);
		}
		
		pageIndex = (pageIndex - 1) * sizePerPage;
		try {
			PageObject po = dictionaryService.querySysDictionaryes(paramMap,
					pageIndex, sizePerPage);
			if (po != null) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
				pageInfo.put("total", po.getCount());
				pageInfo.put("pageSize", po.getPagesize());
				pageInfo.put("pages", po.getPages());
				pageInfo.put("currentPage", po.getCurrentPage());
				pageInfo.put("pageNumbers", po.getPageNumbers());
				pageInfo.put("startIndex", po.getStartIndex());
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("字典表系统管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	
	@RequestMapping("queryZhiWuList.do")
	public @ResponseBody Map<String, Object> queryZhiWuList(HttpServletRequest request, ModelMap map){
		Map<String, Object> param = getUserLocaltion(request);
		String status="1";
		int pageIndex=1;
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		
			paramMap.put("dictionaryTypeId", "office_type");  
		
		
		if (!StringUtils.isEmpty(status)) { 
			paramMap.put("status", status);
		}
		
		pageIndex = (pageIndex - 1) * sizePerPage;
		try {
			PageObject po = dictionaryService.querySysDictionaryes(paramMap,
					pageIndex, sizePerPage);
			if (po != null) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
				pageInfo.put("total", po.getCount());
				pageInfo.put("pageSize", po.getPagesize());
				pageInfo.put("pages", po.getPages());
				pageInfo.put("currentPage", po.getCurrentPage());
				pageInfo.put("pageNumbers", po.getPageNumbers());
				pageInfo.put("startIndex", po.getStartIndex());
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("字典表系统管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	@RequestMapping("queryZhiChengList.do")
	public @ResponseBody Map<String, Object> queryZhiChengList(HttpServletRequest request, ModelMap map){
		Map<String, Object> param = getUserLocaltion(request);
		String status="1";
		int pageIndex=1;
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		
			paramMap.put("dictionaryTypeId", "teacher_professional");  
		
		
		if (!StringUtils.isEmpty(status)) { 
			paramMap.put("status", status);
		}
		
		pageIndex = (pageIndex - 1) * sizePerPage;
		try {
			PageObject po = dictionaryService.querySysDictionaryes(paramMap,
					pageIndex, sizePerPage);
			if (po != null) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
				pageInfo.put("total", po.getCount());
				pageInfo.put("pageSize", po.getPagesize());
				pageInfo.put("pages", po.getPages());
				pageInfo.put("currentPage", po.getCurrentPage());
				pageInfo.put("pageNumbers", po.getPageNumbers());
				pageInfo.put("startIndex", po.getStartIndex());
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("字典表系统管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	@RequestMapping("queryPxxsList.do")
	public @ResponseBody Map<String, Object> queryPxxsList(HttpServletRequest request, ModelMap map){
		Map<String, Object> param = getUserLocaltion(request);
		String status="1";
		int pageIndex=1;
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
		
		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		
		paramMap.put("dictionaryTypeId", "training_from");  
		
		
		if (!StringUtils.isEmpty(status)) { 
			paramMap.put("status", status);
		}
		
		pageIndex = (pageIndex - 1) * sizePerPage;
		try {
			PageObject po = dictionaryService.querySysDictionaryes(paramMap,
					pageIndex, sizePerPage);
			if (po != null) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
				pageInfo.put("total", po.getCount());
				pageInfo.put("pageSize", po.getPagesize());
				pageInfo.put("pages", po.getPages());
				pageInfo.put("currentPage", po.getCurrentPage());
				pageInfo.put("pageNumbers", po.getPageNumbers());
				pageInfo.put("startIndex", po.getStartIndex());
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("字典表系统管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	/**
	 * 跳转到机构某一项目下课程设置
	 * @return
	 */
	@RequestMapping("toProClassPage.htm")
	public String toClassListPage(HttpServletRequest request, ModelMap map){
		String projectName = request.getParameter("projectName");
		try {
			projectName = new String(projectName.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			log.error("projectName转码失败");
			e.printStackTrace();
		}
		String planNum = request.getParameter("planNum");
		ProjectClassActivity activity = new ProjectClassActivity();
		activity.setProjectName(projectName);
		activity.setPlanNum(Integer.parseInt(planNum));
		map.put("info", activity);
		return "organization/projectClass";
	}
	
	
	/**
	 * 跳转到机构培训项目过程管理页面
	 * @return
	 */
	@RequestMapping("toOrgProProcessListPage.htm")
	public String toOrgProProcessPage(){
		return "organization/orgProProcessList";
	}
	
	/**
	 * 跳转到实施机构培训总结的页面
	 * @param pageSize
	 * @param startIndex
	 * @param projectName
	 * @param year
	 * @param projectId
	 * @param request
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping("toShiShiSummaryList.htm")
	public String toSummaryList(Integer pageSize,Integer startIndex,String projectName,
			String year,Integer projectId,HttpServletRequest request,HttpSession session,
			ModelMap map){
		return "organization/summary/shiShiSummaryList";
	}
	
	@RequestMapping("toChengPeiSummaryList.htm")
	public String toChengPeiSummaryList(Integer pageSize,Integer startIndex,String projectName,
			String year,Integer projectId,HttpServletRequest request,HttpSession session,
			ModelMap map){
		return "organization/summary/chengPeiSummaryList";
	}
	
	
	@RequestMapping("toTeacherSummaryList.htm")
	public String toTeacherSummaryList(Integer pageSize,Integer startIndex,String projectName,
			String year,Integer projectId,HttpServletRequest request,HttpSession session,
			ModelMap map){
		return "organization/summary/chengPeiSummaryList";
	}
	
	@RequestMapping("searchChengPeiCloseProjectList.do")
	public  @ResponseBody Map<String, Object> searchChengPeiCloseProjectList(
			HttpServletRequest request,int startIndex,int start,int end,String projectName){
		int teacherId = this.getAccountId(request);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		Map<String,Object> result = new HashMap<String,Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request
					.getParameter("sizePerPage"));
		}
		startIndex = (startIndex - 1) * sizePerPage;
		paramMap.put("teacherId", teacherId);
		paramMap.put("start", start);
		paramMap.put("end", end);
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
		/*public  @ResponseBody Map<String, Object> searchChengPeiCloseProjectList(int pageIndex,String projectName,
				String year,Integer projectId,
				HttpServletRequest request,HttpSession session, ModelMap map){
		EduUserActivty userInfo= (EduUserActivty) session.getAttribute("userinfo");
		Integer orgId = userInfo.getOrganizationId();
		
		Map<String,Object> paramMap = new HashMap<String, Object>();
		PageObject po = new PageObject();
		Map<String, Object> result = new HashMap<String, Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		
		paramMap.put("projectName", projectName== null? null:projectName.equals("")?null:projectName);
		paramMap.put("beginYear", startTime== null? null:startTime.equals("")?null:startTime);
		paramMap.put("endYear", endTime== null? null:endTime.equals("")?null:endTime);
		paramMap.put("pid", userInfo.getUserProvinceId());
		paramMap.put("cid", userInfo.getUserCityId());
		paramMap.put("did", userInfo.getUserDistrictId());
		paramMap.put("organizationId", orgId);
		paramMap.put("status", Common.PROJECT_COMMON_STATUS.get("已结束"));
		po = eduProjectOrgService.selectCPOrgProj(paramMap, pageIndex, 10,userInfo.getUserId());
		
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
		result.put("userId", userInfo.getUserId());
		return result;*/
		
		
	}
	
	
	
	/**
	 * 查询实施机构的培训总结
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("searchShiShiCloseProjectList.do")
	public  @ResponseBody Map<String, Object> searchShiShiCloseProjectList(String status,int pageIndex,String projectName,
			String year,Integer projectId,
			HttpServletRequest request,HttpSession session, ModelMap map) throws Exception{
		EduUserActivty userInfo= (EduUserActivty) session.getAttribute("userinfo");
		
		Map<String,Object> paramMap = new HashMap<String, Object>();
		PageObject po = new PageObject();
		Map<String, Object> result = new HashMap<String, Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		
		paramMap.put("pid", userInfo.getUserProvinceId());
		paramMap.put("cid", userInfo.getUserCityId());
		paramMap.put("did", userInfo.getUserDistrictId());
		//实施机构管理员只能查看本实施机构的项目 不允许查看不是本机构的项目
		if(userInfo.getOrganizationId() != null && !"".equals(userInfo.getOrganizationId())){
			paramMap.put("organizationId", userInfo.getOrganizationId());
		}
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
		if("".equals(projectName)){
			projectName = null;
		}
		paramMap.put("projectName", projectName);
		//paramMap.put("status", Common.PROJECT_COMMON_STATUS.get("已结束"));
		paramMap.put("status", status);
		po = eduProjectService.findProjectByParam(paramMap, pageIndex, 15);
		SysSetup pojo = sysService.selectSysSetupInfo();
		if(po != null && po.getCount() > 0) {
			result.put("success", true);
			result.put("isHide", pojo.getEnableOrg());
			result.put("rows",po.getObjects());
		} else {
			result.put("success", false);
		}
		result.put("total",po.getCount());
		result.put("pageSize", po.getPagesize());
		result.put("pages", po.getPages());
		result.put("currentPage", po.getCurrentPage());
		result.put("pageNumbers", po.getPageNumbers());
		result.put("userId", userInfo.getUserId());
		
		map.put("roleId", userInfo.getRoleId());
		map.put("pageObject", po);
		map.put("projectName", projectName);
		map.put("years", Common.YEARS);
		
		return result;
	}
	
	
	
	/**
	 *
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("searchCloseProjectList.do")
	public  @ResponseBody Map<String, Object> toOrgProSummaryPage(int pageIndex,String projectName,
			String year,Integer projectId,
			HttpServletRequest request,HttpSession session, ModelMap map) throws Exception{
		EduUserActivty userInfo= (EduUserActivty) session.getAttribute("userinfo");
		Integer orgId = userInfo.getOrganizationId();
		
		Map<String,Object> paramMap = new HashMap<String, Object>();
		PageObject po = new PageObject();
		Map<String, Object> result = new HashMap<String, Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		
		paramMap.put("pid", userInfo.getUserProvinceId());
		paramMap.put("cid", userInfo.getUserCityId());
		paramMap.put("did", userInfo.getUserDistrictId());
		
		if(userInfo.getRoleId()>=Common.ROLE_ORGANIZTION_SHISHI_SHENG&&userInfo.getRoleId()<=Common.ROLE_ORGANIZTION_SHISHI_XIAO){
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
			paramMap.put("projectName", projectName);
			paramMap.put("status", Common.PROJECT_COMMON_STATUS.get("已结束"));
			
			po = eduProjectService.findProjectByParam(paramMap, pageIndex, 15);
		}else if(userInfo.getRoleId().equals(Common.ROLE_ORGANIZTION_CHENGPEI)){//承配机构
			
			
		}else if(userInfo.getRoleId().equals(Common.ROLE_TEACHER_5)){
			Map<String,Object> param = new HashMap<String, Object>();
			param.put("teacherId", userInfo.getUserId());
			param.put("porjectName", projectName);
			param.put("status", Common.PROJECT_COMMON_STATUS.get("已结束"));
			po = eduProjectService.selectTeacherProj(param, pageIndex, 20);
		}
		
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
		result.put("userId", userInfo.getUserId());
		
		map.put("roleId", userInfo.getRoleId());
		map.put("pageObject", po);
		map.put("projectName", projectName);
		map.put("years", Common.YEARS);
		
		return result;
	}
	
	/**
	 * 跳转项目总结报告
	 * @return
	 */
	@RequestMapping(value = "orgProSummaryReportList.htm")
	public String queryEvaluationListPage(ModelMap map, String year) {
		map.put("year", year);
		return "organization/orgProSummaryReportList";
	}
	
	/**
	 * 查询某个项目下所有承培机构的项目总结
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("toChengPeiSummaryListPage.htm")
	public String toOrgProSummaryPage(HttpServletRequest request,HttpSession session,
			ModelMap map,Integer pid) throws Exception{
		int startIndex = 0;
		int pageSize = 2000;
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("projectId", pid);
		paramMap.put("type", 2);
		PageObject pageObject = summaryService.selectOrgSummayByPage(paramMap, startIndex, pageSize);
		map.put("pageObject", pageObject);
		map.put("pid", pid);
		return "organization/orgProChengPeiSummaryList";
	}
	
	
	/**
	 * 机构: 某一项目下课程设置列表
	 * @param pageIndex
	 * @param projectId
	 * @param request
	 * @return
	 */
	@RequestMapping("selectOrgProClass.do")
	public @ResponseBody Map<String, Object> selectOrgProClass(int pageIndex, int projectId, HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Integer classSubjectId = Integer.parseInt(request.getParameter("classSubjectId"));
		paramMap.put("projectId", projectId);
		String className = request.getParameter("className");
		paramMap.put("classSubjectId", classSubjectId==0?null:classSubjectId);
		paramMap.put("className", className==null?null:className.equals("")?null:className);
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		Integer userId = getAccountId(request);
		paramMap.put("userId", userId);
		int organizationId = super.getOrgId(request);
		paramMap.put("organizationId", organizationId);
		paramMap.put("startIndex", pageIndex);
		try {
			PageObject po = orgService.selectOrgProClass(paramMap, pageIndex, Common.PNN_USER_PAGE_LIMIT);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/**
	 * 项目课程列表
	 * @param startIndex
	 * @param start
	 * @param end
	 * @param projectName
	 * @return
	 */
	@RequestMapping("orgProClassList.do")
	public @ResponseBody Map<String, Object> projectClasses(int startIndex,int start,int end,String projectName,HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		paramMap.put("startTime", start);
		paramMap.put("endTime", end);
		paramMap.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		Integer userId = getAccountId(request);
		paramMap.put("userId", userId);
		int organizationId = super.getOrgId(request);
		paramMap.put("organizationId", organizationId);
		try {
			PageObject po = orgService.selectOrgProClassList(startIndex, Common.PNN_USER_PAGE_LIMIT, paramMap);
			result.put("rows",po.getObjects());
			result.put("total",po.getCount());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}

	
	/**
	 * 机构: 导入教师成绩
	 * @param request
	 * @param path
	 * @return
	 */
	@RequestMapping("importTeachersScore.do")
	public @ResponseBody Map<String,Object> importStep4(HttpServletRequest request,String path){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			paramMap.put("projectId", request.getParameter("projectId"));
			//paramMap.put("orgId", selectOrgIdByUserId(super.getAccountId(request)));
			paramMap.put("orgId", super.getOrgId(request));
			path = ApplicationProperties.getPropertyValue("upload_path")+path.replace("/", File.separator);
			result  = sysService.intoDB(path, "uploadScore", super.getAccount(request), paramMap);
			DataUtil.setOk(result);
		} catch (Exception e) {
			log.info("导入教师成绩失败！");
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}

	
	/**
	 * 机构: 检测数据
	 * @param file
	 * @param proId
	 * @return	
	 */
	@RequestMapping("testData.do")
	public @ResponseBody Map<String, Object> testData(HttpServletRequest request, Integer projectId, String path){
		//String path = request.getRealPath("/")+"uploadFile"+File.separator+super.getAccount(request);
		Map<String, Object> result = new HashMap<String,Object>();
		Map<String, Object> paramMap = new HashMap<String,Object>();
		//int organizationId = selectOrgIdByUserId(super.getAccountId(request));
		//paramMap.put("orgId", organizationId);
		//paramMap.put("roleId", super.getRoleId(request));
		
		paramMap.put("projectId", projectId);
		paramMap.put("orgId", super.getOrgId(request));
		try {
			result = sysService.parseExcel(path, "uploadScore", paramMap);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			log.error("检测数据失败"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	
	 /**
	 * 机构: 删除上传文件
	 * @param file
	 * @param proId
	 * @return	
	 */
	@RequestMapping("delUploadFile.do")
	public @ResponseBody Map<String, Object> delUploadFile(HttpServletRequest request, String filePath){
		log.info("删除上传文件");
		Map<String, Object> result = new HashMap<String,Object>();
		try {
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			boolean rtn = orgService.delUploadFile(projectPath + filePath);
			if(rtn){
				result.put("success", true);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("删除上传文件失败!");
		}
		return result;
	}
 
	/**
	 * 上传地区信息
	 * @param file
	 * @param proId
	 * @return	
	 */
	@RequestMapping("uploadFile.do")
	public void importTeacher(HttpServletRequest request, HttpServletResponse response, String upload){
		Map<String, Object> result = new HashMap<String,Object>();
//		String path = ApplicationProperties.getPropertyValue("upload_path");
		String path = ApplicationProperties.getPropertyValue("upload_file_path") + File.separator;
		String savePath = request.getParameter("savePath");
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = null;
			if(upload.equals("first")){
				file = multipartRequest.getFile("ff");
			} else {
				file = multipartRequest.getFile("again");
			}
			result = orgService.saveFile(request, path, file, savePath);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			log.error("导入失败！"+e.getMessage());
			e.printStackTrace();
		}
		ResponseUtil.renderText(response, JSONObject.fromObject(result).toString());
	}
	
	
	
	/**
	 * 机构: 上传培训成绩列表
	 * @param pageIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("orgUploadScoreList.do")
	public @ResponseBody Map<String, Object> orgUploadScoreList(int pageIndex, HttpServletRequest request){
		log.info("机构: 上传培训成绩列表");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		int organizationId = super.getOrgId(request);
		String projectName = request.getParameter("projectName");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		paramMap.put("organizationId", organizationId);
		paramMap.put("projectName", projectName== null? null:projectName.equals("")?null:projectName);
		paramMap.put("startTime", startTime== null? null:startTime.equals("")?null:startTime);
		paramMap.put("endTime", endTime== null? null:endTime.equals("")?null:endTime);

		Map<String, Object> result = new HashMap<String, Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			PageObject po = orgService.selectOrgProjectList(paramMap, pageIndex, Common.PNN_USER_PAGE_LIMIT);
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
		} catch (Exception e) {
			result.put("success", false);
			result.put("total",0);
			e.printStackTrace();
			log.error("机构orgId:" + organizationId +"查询上传培训成绩列表页面失败!" + e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * 机构:承培项目教师评价
	 * @param pageIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("orgProTeacherScore.do")
	public @ResponseBody Map<String, Object> orgProTeacherScore(int pageIndex, HttpServletRequest request){
		log.info("机构: 承培项目教师评价");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		int organizationId = super.getOrgId(request);
		String projectName = request.getParameter("projectName");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		paramMap.put("organizationId", organizationId);
		paramMap.put("projectName", projectName== null? null:projectName.equals("")?null:projectName);
		paramMap.put("startTime", startTime== null? null:startTime.equals("")?null:startTime);
		paramMap.put("endTime", endTime== null? null:endTime.equals("")?null:endTime);

		Map<String, Object> result = new HashMap<String, Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			PageObject po = orgService.selectOrgProTeacherScore(paramMap, pageIndex, Common.PNN_USER_PAGE_LIMIT);
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
		} catch (Exception e) {
			result.put("success", false);
			result.put("total",0);
			e.printStackTrace();
			log.error("机构orgId:" + organizationId +"查询承培项目教师评价失败!" + e.getMessage());
		}
		return result;
	}
		
	
	/**
	 * 机构:导出某一项目某些条件下的参训教师
	 * @param request
	 * @param response
	 */
	@RequestMapping("exportTeacher.do")
	public void exportTeacher(HttpServletRequest request, HttpServletResponse response){
		log.info("机构:导出某一项目某些条件下的参训教师");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		int organizationId = super.getOrgId(request);
		String provinceId = request.getParameter("provinceId");
		String cityId = request.getParameter("cityId");
		String districtId = request.getParameter("districtId");
		String schoolId = request.getParameter("schoolId");
		String subject = request.getParameter("subject");
		paramMap.put("organizationId", organizationId);
		paramMap.put("orgId", organizationId);
		paramMap.put("projectId", request.getParameter("projectId"));
		paramMap.put("provinceId", provinceId== null? null:provinceId.equals("")?null:provinceId.equals("null")?null:provinceId);
		paramMap.put("cityId", cityId== null? null:cityId.equals("")?null:cityId.equals("null")?null:cityId);
		paramMap.put("districtId", districtId== null? null:districtId.equals("")?null:districtId.equals("null")?null:districtId);
		paramMap.put("schoolId", schoolId== null? null:schoolId.equals("")?null:schoolId.equals("null")?null:schoolId);
		paramMap.put("teachingSubject", subject== null? null:subject.equals("")?null:subject.equals("null")?null:subject);
		
		try {
			
			int rtn = super.getTeacherInfoSafe(request);
			
			List<TeacherExportActivity> list = orgService.queryTeacherActivetyListNoPage(paramMap);
			
			String path = request.getRealPath("/")+"template"+File.separator+"download_teacher_org.xls";
			
			FileInputStream io = new FileInputStream(path);
			// 创建 excel
			Workbook wb = new HSSFWorkbook(io);
			 
			Sheet sheet = wb.getSheetAt(0);
			for (int i = 0; i < list.size(); i++) {
				Row row = sheet.createRow(i + 1);
				Cell cellA = row.createCell(0);
				cellA.setCellValue(list.get(i).getTeacherNo());
				 
				Cell cellB = row.createCell(1);
				cellB.setCellValue(list.get(i).getRealName());
			 
				Cell cellC = row.createCell(2);
				if(rtn == 1){
					cellC.setCellValue(list.get(i).getIdNumber());
				} else {
					cellC.setCellValue("");
				}
			 
				Cell cellD = row.createCell(3);
				cellD.setCellValue(list.get(i).getGender().intValue() == 0 ? "女" : "男");
			 
				Cell cellE = row.createCell(4);
				if(rtn == 1){
					cellE.setCellValue(list.get(i).getMobile());
				} else {
					cellE.setCellValue("");
				}
			 
				Cell cellF = row.createCell(5);
				cellF.setCellValue(list.get(i).getMail());
			 
				Cell cellG = row.createCell(6);
				cellG.setCellValue(list.get(i).getUserProvinceName());
			 
				Cell cellH = row.createCell(7);
				cellH.setCellValue(list.get(i).getUserCityName());
			 
				Cell cellI = row.createCell(8);
				cellI.setCellValue(list.get(i).getUserDistrictName());
			 
				Cell cellJ = row.createCell(9);
				cellJ.setCellValue(list.get(i).getSchoolName());
			 
				// 学段/学科
				/*Cell cellK = row.createCell(10);
				cellK.setCellValue(list.get(i).getTeachingSection()+"/"+list.get(i).getTeachingSubject());*/
				
				// 学段
				Cell cellK = row.createCell(10);
				cellK.setCellValue(list.get(i).getTeachingSection());
				
				// 学科
				Cell cellL = row.createCell(11);
				cellL.setCellValue(list.get(i).getTeachingSubject());
			 
				Cell cellM = row.createCell(12);
				cellM.setCellValue(list.get(i).getEducationExperience());
			 
				Cell cellN = row.createCell(13);
				cellN.setCellValue(list.get(i).getJobCommentPosition());
			 
				Cell cellO = row.createCell(14);
				cellO.setCellValue(list.get(i).getJobRecruitmentPosition());
			 
				Cell cellP = row.createCell(15);
				cellP.setCellValue(list.get(i).getJobSchoolAdministrationOffice());
				
				// 当前任教学段/学科
				/*Cell cellP = row.createCell(15);
				cellP.setCellValue(list.get(i).getJobFormerTeachingSection()+"/"+list.get(i).getJobFormerTeachingSubject());*/
				
				Cell cellQ = row.createCell(16);
				cellQ.setCellValue(list.get(i).getJobFormerTeachingSection());
				
				Cell cellR = row.createCell(17);
				cellR.setCellValue(list.get(i).getJobFormerTeachingSubject());
				
				Cell cellS = row.createCell(18);
				cellS.setCellValue(list.get(i).getJobCoreTeacher());
				
				Cell cellT = row.createCell(19);
				cellT.setCellValue(list.get(i).getJobWhetherTeacher() != null && list.get(i).getJobWhetherTeacher().equals("1") ? "是" : "否");
			 
				Cell cellU = row.createCell(20);
				cellU.setCellValue(list.get(i).getJobCountyRuralTeacher()!= null && list.get(i).getJobCountyRuralTeacher().equals("1") ? "是" : "否");
			
			}
			
			exportExcelFromTemplet(request, response, wb, "downLoad_teacher");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("机构:"+organizationId+" 导出某一项目某些条件下的参训教师失败!" + e.getMessage());
		}
	}
	
	
	/**
	 * 机构:某一项目参训教师列表
	 * @param pageIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("orgProjectTeachers.do")
	public @ResponseBody Map<String, Object> selectOrgProjectTeachers(int pageIndex, HttpServletRequest request){
		log.info("机构:某一项目参训教师列表页面");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		int organizationId = super.getOrgId(request);
		String provinceId = request.getParameter("provinceId");
		String cityId = request.getParameter("cityId");
		String districtId = request.getParameter("districtId");
		String schoolId = request.getParameter("schoolId");
		String subject = request.getParameter("subject");
		paramMap.put("organizationId", organizationId);
		paramMap.put("orgId", organizationId);
		paramMap.put("projectId", request.getParameter("projectId"));
		paramMap.put("provinceId", provinceId== null? null:provinceId.equals("")?null:provinceId.equals("null")?null:provinceId);
		paramMap.put("cityId", cityId== null? null:cityId.equals("")?null:cityId.equals("null")?null:cityId);
		paramMap.put("districtId", districtId== null? null:districtId.equals("")?null:districtId.equals("null")?null:districtId);
		paramMap.put("schoolId", schoolId== null? null:schoolId.equals("")?null:schoolId.equals("null")?null:schoolId);
		paramMap.put("teachingSubject", subject== null? null:subject.equals("")?null:subject.equals("null")?null:subject);
		
		// 是否允许查看教师身份证号和手机号
		int rtn = super.getTeacherInfoSafe(request);
		paramMap.put("rtn", rtn);
		
		Map<String, Object> result = new HashMap<String, Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			PageObject po = orgService.selectOrgProjectTeachers(paramMap, pageIndex, Common.PNN_USER_PAGE_LIMIT);
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
		} catch (Exception e) {
			result.put("success", false);
			result.put("total",0);
			e.printStackTrace();
			log.error("机构orgId:" + organizationId +"查询某一项目参训教师列表页面失败" + e.getMessage().toString());
		}
		return result;
	}
	
	
	/**
	 * 机构:项目状态设置 暂停/继续
	 * @param request
	 * @return
	 */
	@RequestMapping("modifyOrgProjectStatus.do")
	public @ResponseBody Map<String, Object> modifyOrgProjectStatus(HttpServletRequest request){
		log.info("机构:项目状态设置");
		Map<String, Object> result = new HashMap<String, Object>();
		int orgId = super.getOrgId(request);
		Integer projectId = Integer.parseInt(request.getParameter("projectId").toString());
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orgId", orgId);
		paramMap.put("projectId", projectId);
		paramMap.put("status", request.getParameter("status"));
		paramMap.put("oldStatus", request.getParameter("oldStatus"));
		try {
			String rtn = orgService.modifyOrgProjectStatus(paramMap);
			if(rtn.equals("true")){
				result.put("success", true);
			} else if(rtn.equals("noURL")){
				result.put("success", "noURL");
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("机构id:"+orgId+"设置项目projectId:"+projectId+"状态失败"+ e.getMessage().toString());
		}
	
		
		return result;
	}
	
	/**
	 * 机构: 设置承培项目培训平台地址
	 * @param projectId
	 * @param updateDate
	 * @param trainingAddress
	 * @return
	 */
	@RequestMapping("ssOrgProjectModify.do")
	public @ResponseBody Map<String, Object> modifySsOrgProject(HttpServletRequest request, String organizationName, Integer projectId, String trainingAddress, String trainingHomeAddress){
		log.info("机构:设置承培项目");
		Map<String, Object> result = new HashMap<String, Object>();
		int orgId = super.getOrgId(request);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orgId", orgId);
		paramMap.put("projectId", projectId);
		paramMap.put("trainingAddress", trainingAddress);
		paramMap.put("trainingHomeAddress", trainingHomeAddress);
		paramMap.put("updateBy", getAccount(request));
//		paramMap.put("updateDate", updateDate);
		try {
//			if(optionFlag.equals("null") || StringUtils.isEmpty(optionFlag)) {
//				//1 为实施机构获取项目配置信息（学科、计划培训人数）
//				EduProjectDTO project = eduProjectService.qryProFullInfo(projectId);
//				
//				Organization o = new Organization();
//				o.setProjectId(projectId.toString());
//				o.setOrganizationId(orgId);
//				o.setTrainingAddress(trainingAddress);
//				o.setOrganizationName(organizationName);
//				o.setTrainingAddress(trainingAddress);
//				o.setTrainingHomeAddress(request.getParameter("trainingHomeAddress"));
//				//培训学科
//				o.setSubjectIds(project.getSubjectId());
//				o.setSubjectName(project.getSubjectName());
//				//计划人数
//				o.setPlanNum(project.getPlanNum());
//				o.setAreaCode(project.getTrainScopeId());
//				o.setAreaName(project.getTrainScopeName());
//				List<Organization> orgList = new ArrayList<Organization>();
//				orgList.add(o);
//				
//				// 设置项目培训范围
//				
//				return eduProjectService.assginOrg(super.getAccount(request), projectId, orgList);
//			} else {
				if(orgService.modifyOrgProject(paramMap)){
					result.put("success", true);
				} else {
					result.put("success", false);
				}
//			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("机构id:"+orgId+",设置承培项目失败"+e.getMessage().toString());
		}
		
		return result;
	}
	
	/**
	 * 机构: 设置承培项目培训平台地址
	 * @param projectId
	 * @param updateDate
	 * @param trainingAddress
	 * @return
	 */
	@RequestMapping("orgProjectModify.do")
	public @ResponseBody Map<String, Object> modifyOrgProject(HttpServletRequest request, Integer projectId, String updateDate, String trainingAddress){
		log.info("机构:设置承培项目");
		Map<String, Object> result = new HashMap<String, Object>();
		String updateBy = getAccount(request);
		int orgId = super.getOrgId(request);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orgId", orgId);
		paramMap.put("projectId", projectId);
		paramMap.put("trainingAddress", trainingAddress);
		paramMap.put("trainingHomeAddress", request.getParameter("trainingHomeAddress"));
		paramMap.put("updateBy", updateBy);
		paramMap.put("updateDate", updateDate);
		try {
			if(orgService.modifyOrgProject(paramMap)){
				result.put("success", true);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("机构id:"+orgId+",设置承培项目失败"+e.getMessage().toString());
		}
		
		return result;
	}
	
	
	/**
	 * 机构: 查询承培项目详情
	 * @param projectId
	 * @return
	 */
	@RequestMapping("orgProjectInfo.do")
	public @ResponseBody Map<String, Object> selectOrgProjectInfo(HttpServletRequest request, Integer projectId){
		log.info("机构:机构承培项目详情");
		int orgId = super.getOrgId(request);
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			OrgProjectInfoActivity dto = orgService.selectOrgProjectInfoByProjectId(projectId, orgId);
			result.put("success", true);
			result.put("obj", dto);
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("承培项目id:"+projectId+", 详情查询失败!"+e.getMessage().toString());
		}
		return result;
	}
	/**
	 * 实施机构已结束项目列表
	 * @param pageIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("closeProjectList.do")
	public @ResponseBody Map<String, Object> selectCloseProjectList(int pageIndex, HttpServletRequest request,HttpSession session){
		log.info("实施机构已结束项目列表");
		EduUserActivty userInfo= (EduUserActivty) session.getAttribute("userinfo");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//Integer userId = getAccountId(request);
		//int organizationId = selectOrgIdByUserId(userId);
		String projectName = request.getParameter("projectName");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		paramMap.put("projectName", projectName== null? null:projectName.equals("")?null:projectName);
		paramMap.put("beginYear", startTime== null? null:startTime.equals("")?null:startTime);
		paramMap.put("endYear", endTime== null? null:endTime.equals("")?null:endTime);
		paramMap.put("status", Common.PROJECT_COMMON_STATUS.get("已结束"));
		int roleId = super.getRoleId(request);
		if(roleId == 1 || roleId == 7){
			paramMap.put("pid", super.getUserAreaId(request));
		}else if(roleId == 2 || roleId == 8){
			paramMap.put("cid", super.getUserAreaId(request));
		}else if(roleId == 3 || roleId == 9){
			paramMap.put("cid", super.getUserCityId(request));
			paramMap.put("did", super.getUserAreaId(request));
		}
		//实施机构管理员只能查看本实施机构的项目 不允许查看不是本机构的项目
		if(userInfo.getOrganizationId() != null && !"".equals(userInfo.getOrganizationId())){
			paramMap.put("organizationId", userInfo.getOrganizationId());
		}
		//paramMap.put("createBy", userInfo.getLoginAccount());
		Map<String, Object> result = new HashMap<String, Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			PageObject po = eduProjectService.findProjectByParam(paramMap, pageIndex, Common.PNN_USER_PAGE_LIMIT);
			if(po != null && po.getCount() > 0) {
				result.put("success", true);
				result.put("rows",po.getObjects());
			} else {
				result.put("success", false);
			}
			String areaId = super.getUserAreaId(request);
			Integer orgId = super.getOrganizationId(request);
			result.put("areaId", areaId);
			result.put("orgId", orgId);
			result.put("total",po.getCount());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
			result.put("roleType", userInfo.getRoleId());
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("查询承培项目列表失败" + e.getMessage().toString());
		}
		return result;
	}
	/**
	 * 培训项目过程管理列表和提交培训材料管理列表
	 * @param pageIndex
	 * @param request
	 * @return
	 */
	/*@RequestMapping("proAndProcessList.do")
	public @ResponseBody Map<String, Object> selectProAndProcessListList(String status,int pageIndex, HttpServletRequest request,HttpSession session){
		EduUserActivty userInfo= (EduUserActivty) session.getAttribute("userinfo");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//Integer userId = getAccountId(request);
		//int organizationId = selectOrgIdByUserId(userId);
		String projectName = request.getParameter("projectName");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		paramMap.put("projectName", projectName== null? null:projectName.equals("")?null:projectName);
		paramMap.put("start", startTime== null? null:startTime.equals("")?null:startTime);
		paramMap.put("end", endTime== null? null:endTime.equals("")?null:endTime);
		paramMap.put("status", status);
		int roleId = super.getRoleId(request);
		if(roleId == 1 || roleId == 7){
			paramMap.put("pid", super.getUserAreaId(request));
		}else if(roleId == 2 || roleId == 8){
			paramMap.put("cid", super.getUserAreaId(request));
		}else if(roleId == 3 || roleId == 9){
			paramMap.put("cid", super.getUserCityId(request));
			paramMap.put("did", super.getUserAreaId(request));
		}
		//只允许创建项目地区可以查看到项目
		if(roleId == 1 || roleId == 2 || roleId == 3){
			paramMap.put("createByArea", super.getUserAreaId(request));
		}
		//实施机构管理员只能查看本实施机构的项目 不允许查看不是本机构的项目
		if(super.getOrganizationId(request) != null && !"".equals(super.getOrganizationId(request))){
			paramMap.put("organizationId", super.getOrganizationId(request));
		}
		paramMap.put("areaId", super.getUserAreaId(request));
		Map<String, Object> result = new HashMap<String, Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			PageObject po = eduProjectService.findProjectByParam(paramMap, pageIndex, Common.PNN_USER_PAGE_LIMIT);
			if(po != null && po.getCount() > 0) {
				result.put("success", true);
				result.put("rows",po.getObjects());
			} else {
				result.put("success", false);
			}
			String areaId = super.getUserAreaId(request);
			Integer orgId = super.getOrganizationId(request);
			result.put("areaId", areaId);
			result.put("orgId", orgId);
			result.put("total",po.getCount());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
			result.put("roleType", userInfo.getRoleId());
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("查询培训项目过程管理列表失败" + e.getMessage().toString());
		}
		return result;
	}*/
	
	/**
	 * 实施机构-承培项目管理列表
	 * @param pageIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("ssOrgProjectList.do")
	public @ResponseBody Map<String, Object> selectSsOrgProjectList(int pageIndex, HttpServletRequest request){
		log.info("机构:机构承培项目管理列表页面");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		Integer ssOrgId = super.getOrgId(request);
		String projectName = request.getParameter("projectName");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		
		//项目审核通过后，项目管理交由申报人
		paramMap.put("applyerId", this.getAccountId(request));
		paramMap.put("projectName", projectName== null? null:projectName.equals("")?null:projectName);
		paramMap.put("startTime", startTime== null? null:startTime.equals("")?null:startTime);
		paramMap.put("endTime", endTime== null? null:endTime.equals("")?null:endTime);
		Map<String, Object> result = new HashMap<String, Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			PageObject po = orgService.selectSsOrgProjectList(paramMap, pageIndex, Common.PNN_USER_PAGE_LIMIT);
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
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("机构orgId:" + ssOrgId +"查询承培项目列表失败" + e.getMessage().toString());
		}
		return result;
	}
	
	/**
	 * 机构承培项目管理列表
	 * @param pageIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("orgProjectList.do")
	public @ResponseBody Map<String, Object> selectOrgProjectList(int pageIndex, HttpServletRequest request){
		log.info("机构:机构承培项目管理列表页面");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//Integer userId = getAccountId(request);
		//int organizationId = selectOrgIdByUserId(userId);
		int organizationId = super.getOrgId(request);
		String projectName = request.getParameter("projectName");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		paramMap.put("organizationId", organizationId);
		paramMap.put("projectName", projectName== null? null:projectName.equals("")?null:projectName);
		paramMap.put("startTime", startTime== null? null:startTime.equals("")?null:startTime);
		paramMap.put("endTime", endTime== null? null:endTime.equals("")?null:endTime);
		Map<String, Object> result = new HashMap<String, Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			PageObject po = orgService.selectOrgProjectList(paramMap, pageIndex, Common.PNN_USER_PAGE_LIMIT);
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
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("机构orgId:" + organizationId +"查询承培项目列表失败" + e.getMessage().toString());
		}
		return result;
	}
	
	
	/**
	 * 已不再使用
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unused")
	private int selectOrgIdByUserId(int userId) {
		int rtn = 0;
		try {
			rtn = orgService.selectOrgIdByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询orgId失败");
		}
		return rtn;
	}
	

	/**
	 * 实施机构成绩发布: 发布成绩. 暂保存发布规则.在成绩查看时才计算.
	 * @param request
	 * @return
	 */
	@RequestMapping("orgScorePublishRuleSave.do")
	public @ResponseBody Map<String, Object> orgScorePublishRuleSave(HttpServletRequest request){
		log.info("实施机构成绩发布: 发布成绩");
		Map<String, Object> result = new HashMap<String, Object>();
		String pubRule = request.getParameter("pubRule");
		String publishRuleScore = request.getParameter("publishRuleScore");
		String viewRule = request.getParameter("viewRule");
		String projectId = request.getParameter("projectId");
     	
		try {
			EduProjectDTO projectDto = eduProjectService.qryProFullInfo(Integer.parseInt(projectId));
			List<EduProjectCommentTeacher> eduTeaComList = eduProjectService.queryProjectCommentTeachers(Integer.parseInt(projectId));
			Map<String,Object> paraMap = new HashMap<String,Object>();
			paraMap.put("eduModelType", projectDto.getEduModelType());
			/*1，学时证明及项目证书编号设置证书时，各代码可以任意组合。先生成后六位学员编号，前面的规则根据学时、项目证书规则生成。
			  2，防止学员编号重复，使用在同一继教板块下全部项目的学员的数量作为证书编号的后六位，后边证书编号依次顺延,学员编号上限为999999。*/
			String lastNum = eduProjectService.getAllProjectComment(paraMap).toString();
			if(Integer.parseInt(lastNum)>999999){
				result.put("success", false);
				result.put("msg", "-1");
				return result;
			}
			DecimalFormat df = new DecimalFormat("000000");
			//List<EduProjectCommentTeacher> eduList = new ArrayList<EduProjectCommentTeacher>();
			for(EduProjectCommentTeacher eduTeaCom:eduTeaComList){
				EduProjectCommentTeacher teacherInfo = new EduProjectCommentTeacher();
				teacherInfo.setProjectId(Integer.parseInt(projectId));
				teacherInfo.setTeacherId(eduTeaCom.getTeacherId());
				lastNum = df.format(Integer.parseInt(lastNum)+1);
				teacherInfo.setPeriodCertificateCode(lastNum);
				teacherInfo.setProjectCertificateCode(lastNum);
				//eduList.add(teacherInfo);
				//一条一条的更新比较慢以后可以优化，以一次性集合更新比较好				
				eduProjectService.updateProjectCommentTeachers(teacherInfo);
			}
			//想法是是把所有的对象放到一个集合中，一次性提交更新，但问题是不知道怎么样在ibatis中set每一个变量值，如果后续有更好的解决方法再实现。
			//eduProjectService.updateProjectCommentTeachers(eduList);
			
			projectDto.setScorePublishRule(pubRule);
			projectDto.setScoreLevelRule(publishRuleScore);
			projectDto.setViewScoreRule(viewRule);
			projectDto.setIsScorePublished(1);
			//put("已结束", 50);// 培训成绩发布, 公布成绩操作触发
			projectDto.setStatus(Common.PROJECT_COMMON_STATUS.get("已结束"));
			boolean isSucceed =eduProjectService.updateProject(projectDto);
			if(isSucceed){ //更新教师学时,培训状态
				Map<String, Object> conditions = new HashMap<String,Object>();
				conditions.put("pubRule", pubRule);
				conditions.put("publishRuleScore", publishRuleScore);
				conditions.put("projectId", projectId);
				conditions.put("classPeriod", projectDto.getClassPeriod()); 
				eduProjectService.updateProjectComment(conditions);
				
				//根据继教版块兑换规则修改教师学分
				eduProjectService.modifyTeacherScoresByProjectIds(projectId, projectDto.getExchangeRule(), projectDto.getExcellentRule());
				
				result.put("success", true);
			}else{
				result.put("success", false);
			}
			
			
			
			return result;
			 
		} catch (Exception e) {
			log.info(" 失败！ 实施机构成绩发布: 发布成绩"+e.getMessage());
			e.printStackTrace();
			return result;
		}
	}
	
	/**
	 * 培训成绩修改下查询项目列表
	 */
	@RequestMapping("orgScorePublishListUpdate.do")
	public @ResponseBody Map<String, Object> queryProjectListByStatusUpdate(int pageIndex, int pageSize, HttpServletRequest request){
		log.info("培训成绩修改下查询项目列表");

		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		String year = request.getParameter("projectYear");
		String projectName = request.getParameter("projectName");
		
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		
		conditions.put("year", year == ""?null:year);
		
		conditions.put("projectName",projectName==null?null:projectName.length()==0?null:projectName);
		int roleId = super.getRoleId(request);
		//只允许项目创建者可以查看项目
		if(roleId == 1 || roleId == 2 || roleId == 3){
			conditions.put("createById", super.getAccountId(request));
		}
		
		//项目审核通过前，由同一实施机构下所有管理员管理本实施机构的项目；审核通过后，由申报人管理本实施机构的项目
		if(super.getOrganizationId(request) != null && !"".equals(super.getOrganizationId(request))){
//			conditions.put("organizationId", super.getOrganizationId(request));
			conditions.put("applyerId", this.getAccountId(request));
		}
		try {
			PageObject po = eduProjectService.queryProjectListByStatusUpdate(conditions, pageIndex, pageSize);
			if(po.getCount() >0){
				result.put("success",true);
			}else{
				result.put("success",false);
				return result;
			}
			String areaId = super.getUserAreaId(request);
			Integer orgId = super.getOrganizationId(request);
			result.put("areaId", areaId);
			result.put("orgId", orgId);
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
	/** 
	 * 学分审核 查询培训类项目列表
	 * @param pageIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("orgScorePublishList.do")
	public @ResponseBody Map<String, Object> orgScorePublishList(int pageIndex, int pageSize, HttpServletRequest request){
		log.info("查询培训类项目列表");

		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		String year = request.getParameter("projectYear");
		String projectName = request.getParameter("projectName");
		String isScorePublished = request.getParameter("isScorePublished");
		String eduModeType = request.getParameter("eduModeType");
		
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		
		conditions.put("eduModelType", eduModeType == null? null : eduModeType);
		conditions.put("year", year == ""?null:year);
		conditions.put("isScorePublished", isScorePublished == null?null:isScorePublished);
		conditions.put("projectName",projectName==null?null:projectName.length()==0?null:projectName);
		
		int roleId = super.getRoleId(request);
		if(roleId == 1 || roleId == 2 || roleId == 3){
//			conditions.put("createByArea", super.getUserAreaId(request));
			conditions.put("createById", this.getAccountId(request));
		}
		if(super.getOrganizationId(request) != null && !"".equals(super.getOrganizationId(request))){
//			conditions.put("organizationId", super.getOrganizationId(request));
			conditions.put("applyerId", this.getAccountId(request));
		}
		
		try {
			PageObject po = eduProjectService.queryProjectListByStatus(conditions, pageIndex, pageSize);
			if(po.getCount() >0){
				result.put("success",true);
			}else{
				result.put("success",false);
				return result;
			}
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
	 * 学分审核按继教信息板块的条件查询
	 * 
	 */
	
	@RequestMapping("showInfoListes.do")
	public @ResponseBody Map<String, Object> showInfoListes(int pageIndex, int pageSize, HttpServletRequest request){
		log.info("实施机构成绩发布: 查询项目列表");
		
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		String year = request.getParameter("projectYear");
		String projectName = request.getParameter("projectName");
		String eduModeType =request.getParameter("eduModeType");
		String isScorePublished = request.getParameter("isScorePublished");
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		
		/*conditions.put("eduModelType", eduModeType == null?null:eduModeType);*/
		if(eduModeType!=null&&eduModeType!=""){
			conditions.put("eduModelType", eduModeType);
		}
		
		conditions.put("isScorePublished", isScorePublished == null?null:isScorePublished);
		
		conditions.put("year", year == null?null:year);
		
		conditions.put("projectName",projectName==null?null:projectName.length()==0?null:projectName);
		
		try {
			PageObject po = eduProjectService.queryProjectListByStatus(conditions, pageIndex, pageSize);
			if(po.getCount() >0){
				result.put("success",true);
			}else{
				result.put("success",false);
				return result;
			}
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
	
	/**
	 * 培训成绩公布
	 * 
	 */                
	@RequestMapping("orgScorePublishListes.do")
	public @ResponseBody Map<String, Object> orgScorePublishListes(int pageIndex, int pageSize, HttpServletRequest request){
		log.info("培训成绩公布: 查询项目列表");
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		String year = request.getParameter("projectYear");
		String projectName = request.getParameter("projectName");
		String isScorePublished = request.getParameter("isScorePublished");
		
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		
		conditions.put("year", year==null||year == ""?null:year);
		conditions.put("isScorePublished", isScorePublished);
		//查询成绩未公布项目列表 0为未公布 1为公布
		if(isScorePublished !=null && "0".equals(isScorePublished)){
			conditions.put("status", Common.PROJECT_COMMON_STATUS.get("进行中"));
		}
		
		conditions.put("projectName",projectName==null?null:projectName.length()==0?null:projectName);
		int roleId = super.getRoleId(request);
		if(roleId == 1 || roleId == 2 || roleId == 3){
//			conditions.put("createByArea", super.getUserAreaId(request));
			conditions.put("createById", super.getAccountId(request));
		}
		//项目审核通过前，由同一实施机构下所有管理员管理本实施机构的项目；审核通过后，由申报人管理本实施机构的项目
		if(super.getOrganizationId(request) != null && !"".equals(super.getOrganizationId(request))){
//			conditions.put("organizationId", super.getOrganizationId(request));
			conditions.put("applyerId", this.getAccountId(request));
		}
		try {
			PageObject po = eduProjectService.queryProjectListByStatuses(conditions, pageIndex, pageSize);
			
			String areaId = super.getUserAreaId(request);
			Integer orgId = super.getOrganizationId(request);
			result.put("areaId", areaId);
			result.put("orgId", orgId);
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
	
	/**
	 * 成绩审核教师列表/成绩修改教师列表/已公布成绩的教师列表/教师成绩查询列表/培训结果审核的教师列表
	 * */
	@RequestMapping("orgScoreModifyList.do")
	public @ResponseBody  Map<String, Object> orgScoreModifyList( int pageIndex, int pageSize, HttpServletRequest request){
		log.info("教师列表");
		Map<String,Object> result = new HashMap<String,Object>();
		pageIndex = (pageIndex - 1) * pageSize;
		String projectId = request.getParameter("projectId");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		String school = request.getParameter("school");
		//学校类型，小学教育学校、初中教育学校、高中教育学校，ztree树中，点击学校类型时，查询相应的信息。
		String schoolType = request.getParameter("schoolType");
		String teacherName = request.getParameter("teacherName");
		
		Map<String, Object> conditions =new HashMap<String,Object>();
		conditions.put("projectId", projectId);
		conditions.put("userProvinceId", province);
		conditions.put("userCityId", city);
		conditions.put("userDistrictId", district);
		conditions.put("schoolId", school);
		conditions.put("schoolType", schoolType);
		conditions.put("realName",teacherName==null?null:teacherName.length()==0?null:teacherName);
		
		//针对校管理员查询教师成绩处理，仅查询当前学校下教师
		int roleId = super.getRoleId(request);
		if(roleId == 4){
			conditions.put("userProvinceId", super.getUserProvinceId(request));
			conditions.put("userCityId", super.getUserCityId(request));
			conditions.put("userDistrictId", super.getUserDistrictId(request));
			conditions.put("schoolId", super.getSchoolId(request));
		}
		
		try {
			PageObject po = userService.getUserList(conditions, pageIndex, pageSize);//eduProjectService.(conditions, pageIndex, pageSize);//queryProjectListByStatus
			if(po.getCount() >0){
				result.put("success",true);
			}else{
				result.put("success",false);
				return result;
			}
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
	
	
	/**
	 * 培训类项目的地区树,哈尔滨[校:10/师:20].
	 * 师:20,是count所有edu_project_comment.project_id=projectId 
	 * @param request
	 * @return
	 */
	@RequestMapping("orgAreaList.do")
	public @ResponseBody  List<ZTree> orgAreaList(HttpServletRequest request){
		log.info("实施机构成绩发布: 查询地区层级结构");
		String projectId = request.getParameter("projectId");
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String isSchool = request.getParameter("isSchool");
		String name = request.getParameter("name");
		String level = request.getParameter("level");
		
		String n = request.getParameter("n");
		String lv = request.getParameter("lv");
		
		String pid = request.getParameter("pid");
		if(pid == null){
			
		}
		
		List<ZTree> areas = new ArrayList<ZTree>();
		Map<String,Object> result = new HashMap<String,Object>();
		Integer userId = getAccountId(request);
		try {
			Map<String, Object> conditions =new HashMap<String,Object>();
			conditions.put("projectId", projectId);
			
			if(isSchool!=null && isSchool.equalsIgnoreCase("true")){ //学校类型
				conditions.put("pid", pid);
				conditions.put("type", type);
				List<ZTree> schools = sysService.getSchoolListOfAreaByType(conditions);
 				return schools;
	  		}else if(isSchool!=null && isSchool.equalsIgnoreCase("school")){ //学校类型
	  			//alert('xx小学');
	  		}else{
	  			//alert('省市县校');
	  			EduUser user = userService.getUserById(userId);
				Integer provinceId = user.getUserProvinceId();
				Integer cityId = user.getUserCityId();
				Integer districtId = user.getUserDistrictId();
				Integer schoolId = user.getSchoolId();
				
				Integer currentAreaId = 0; //当前省市区学校的Id.
				Integer areaLevel = 0;//地区的层级. 0省,1市,2区,3学校
				if(id ==null){
					if(provinceId !=null){
						currentAreaId = provinceId;
					}		
					if(cityId !=null){
						currentAreaId = cityId;
						areaLevel =1;
					}		
					if(districtId !=null){
						currentAreaId = districtId;
						areaLevel=2;
					}		
					if(schoolId !=null){
						currentAreaId = schoolId;
						areaLevel=3;
					}		
					
					ZTree sa  = new ZTree();
					conditions.put("id", currentAreaId);
					 areas.add(sysService.getById(conditions));
					 return areas;
				}
				
				if(type !=null){
					if(type.equalsIgnoreCase("2")){
		 				List<ZTree> schools = sysService.getSchoolTypeListOfArea(Integer.parseInt(id));
		 				return schools;
					}	
				}
				conditions.put("id", id);
				List<ZTree> childAreaList = sysService.getChildAreaList( conditions);
				return childAreaList;	
	  		}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 培训类项目的地区树,哈尔滨[校:10/师:20]. 教师报名
	 * 师:20,是count所有edu_project_comment.project_id=projectId 
	 * @param request
	 * @return
	 */
	@RequestMapping("orgTeacherForReportList.do")
	public @ResponseBody  List<ZTree> orgTeacherForReportList(HttpServletRequest request){
		log.info("查询地区层级结构");
		String projectId = request.getParameter("projectId");
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String isSchool = request.getParameter("isSchool");
		String name = request.getParameter("name");
		String level = request.getParameter("level");
		
		String n = request.getParameter("n");
		String lv = request.getParameter("lv");
		
		String pid = request.getParameter("pid");
		if(pid == null){
			
		}
		
		List<ZTree> areas = new ArrayList<ZTree>();
		Map<String,Object> result = new HashMap<String,Object>();
		Integer userId = getAccountId(request);
		try {
			Map<String, Object> conditions =new HashMap<String,Object>();
			conditions.put("projectId", projectId);
			
			if(isSchool!=null && isSchool.equalsIgnoreCase("true")){ //学校类型
				conditions.put("pid", pid);
				conditions.put("type", type);
				//List<ZTree> schools = sysService.getSchoolListOfAreaByType(conditions);
				List<ZTree> schools = sysService.getSchoolListOfTeacherByType(conditions);
 				return schools;
	  		}else if(isSchool!=null && isSchool.equalsIgnoreCase("school")){ //学校类型
	  			//alert('xx小学');
	  		}else{
	  			//alert('省市县校');
	  			EduUser user = userService.getUserById(userId);
				Integer provinceId = user.getUserProvinceId();
				Integer cityId = user.getUserCityId();
				Integer districtId = user.getUserDistrictId();
				Integer schoolId = user.getSchoolId();
				
				Integer currentAreaId = 0; //当前省市区学校的Id.
				Integer areaLevel = 0;//地区的层级. 0省,1市,2区,3学校
				if(id ==null){
					if(provinceId !=null){
						currentAreaId = provinceId;
					}		
					if(cityId !=null){
						currentAreaId = cityId;
						areaLevel =1;
					}		
					if(districtId !=null){
						currentAreaId = districtId;
						areaLevel=2;
					}		
					if(schoolId !=null){
						currentAreaId = schoolId;
						areaLevel=3;
					}		
					
					ZTree sa  = new ZTree();
					conditions.put("id", currentAreaId);
					areas.add(sysService.getAreaTeacherById(conditions));
					// areas.add(sysService.getById(conditions));
					 return areas;
				}
				
				if(type !=null){
					if(type.equalsIgnoreCase("2")){
		 				List<ZTree> schools = sysService.getSchoolTypeListOfArea(Integer.parseInt(id));
		 				return schools;
					}	
				}
				conditions.put("id", id);
				//List<ZTree> childAreaList = sysService.getChildAreaList( conditions);
				List<ZTree> childAreaList = sysService.getChildAreaTeacherList( conditions);
				return childAreaList;	
	  		}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 单纯的查地区树,不跟项目关联.
	 * 哈尔滨[校:10/师:20] 师->根据地区id来count所有edu_user中的教师
	 * @param request
	 * @return
	 */
	@RequestMapping("orgRegionList.do")
	public @ResponseBody  List<ZTree> orgAreaUserList(HttpServletRequest request){
		log.info("实施机构成绩发布: 查询地区层级结构");
		List<ZTree> areas = new ArrayList<ZTree>();
		String rootId = request.getParameter("rootId"); //当前树的根地区id.
		String id = request.getParameter("id"); //当前areaId
		String type = request.getParameter("type");
		String isSchool = request.getParameter("isSchool");
		String pid = request.getParameter("pid");
		try {
			Map<String, Object> conditions =new HashMap<String,Object>();
			
			//取根地区
			if(rootId!=null && !"".equals(rootId)){
				 conditions.put("id", rootId);
				 ZTree  rootArea = new ZTree();
				 if(isSchool!=null && isSchool.equalsIgnoreCase("true")){
					 List<EduSchool> school = schoolService.querySchoolList(null, null, null, null,null, Integer.parseInt(rootId));
					 if(school !=null && school.size() >0){
//						 private String id; // 编号
//							private String pId; // 父节点
//							private String isParent; // 是否父节点
//							private String name; // 节点名称
//							private String open; // 是否打开
//							private String type;
//							private String isSchool;//是否是学校
						 rootArea.setId(school.get(0).getSchoolId().toString());
						 rootArea.setName(school.get(0).getSchoolName());
						 rootArea.setIsParent("false");
						 rootArea.setIsSchool("school");
					 }
				 }else{
					 rootArea = sysService.getAreaById(conditions);
				 }
				 wrapWithCountInfo(rootArea);
				 areas.add(rootArea);
				 return areas;
			}
			if(id == null){
				//alert('省市县校');
				Integer userId = getAccountId(request);
	  			EduUser user = userService.getUserById(userId);
				Integer provinceId = user.getUserProvinceId();
				Integer cityId = user.getUserCityId();
				Integer districtId = user.getUserDistrictId();
				Integer schoolId = user.getSchoolId();
				
				Integer currentAreaId = 0; //当前省市区学校的Id.
				Integer areaLevel = 0;//地区的层级. 0省,1市,2区,3学校
					if(provinceId !=null){
						currentAreaId = provinceId;
					}		
					if(cityId !=null){
						currentAreaId = cityId;
						areaLevel =1;
					}		
					if(districtId !=null){
						currentAreaId = districtId;
						areaLevel=2;
					}		
					if(schoolId !=null){
						currentAreaId = schoolId;
						areaLevel=3;
					}		
					
					conditions.put("id", currentAreaId);
					 areas.add(sysService.getAreaById(conditions));
					 return areas;
			
			}
			//取下级地区列表
			if(id!=null){
				if(isSchool!=null && isSchool.equalsIgnoreCase("true")){ //学校类型
					conditions.put("pid", pid);
					conditions.put("type", type);
					List<ZTree> schools = sysService.getSchoolList(conditions);
	 				return schools;
		  		}else{
					if(type !=null){
						if(type.equalsIgnoreCase("2")){
							conditions.put("id", id);
			 				List<ZTree> schools = sysService.getSchoolTypeList(conditions);
			 				return schools;
						}	
					}
					conditions.put("id", id);
					List<ZTree> childAreaList = sysService.getChildrenAreaById( conditions);
					return childAreaList;	
		  		}
			}
			
		 
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
	private void wrapWithCountInfo(ZTree rootArea) {
		// TODO Auto-generated method stub
		
	}

	@RequestMapping("orgScoreUpdate.do")
	public @ResponseBody boolean orgScoreUpdate(HttpServletRequest request){
		log.info("实施机构成绩发布: 修改成绩.保存");
 
		String pid = request.getParameter("pid");
		String tid = request.getParameter("tid");
		String [] id=tid.split(",");
		
		String ids="";
		for (int i = 0; i < id.length; i++) {
			if(i==id.length-1){
				ids +=id[i];
			}else{
			 ids += id[i]+",";
			}
		}
		String score = request.getParameter("score");
		String period = request.getParameter("period");
		/*Integer score=1;*/
		Map<String, Object> conditions =new HashMap<String,Object>();
		conditions.put("projectId", pid);
		conditions.put("teacherId", ids);
		conditions.put("score", score);
		conditions.put("period", period);
		
		try { 
			boolean isSucceed =eduProjectService.updateTeacherScore(conditions);
			return isSucceed;
			 
		} catch (Exception e) {
			log.info(" 审核失败！"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * 单个审核
	 */
	@RequestMapping("auditSingleScore.do")
	public @ResponseBody boolean auditSingle(HttpServletRequest request){
		log.info("成绩审核");
		
		/*String pid = request.getParameter("pid");
		String tid = request.getParameter("tid");
		String [] id=tid.split(",");
		
		String ids="";
		for (int i = 0; i < id.length; i++) {
			if(i==id.length-1){
				ids +=id[i];
			}else{
				ids += id[i]+",";
			}
		}*/
		String score = request.getParameter("examine");
		String pid = request.getParameter("pid");
		String commentId = request.getParameter("commentId");
		String opinion = request.getParameter("opinion");
		Map<String, Object> conditions =new HashMap<String,Object>();
		conditions.put("projectId", pid);
		conditions.put("commentId", commentId);
		conditions.put("score", score);
		conditions.put("opinion", opinion);
		
		try { 
			boolean isSucceed =eduProjectService.updateTeacherScores(conditions);
			return isSucceed;
			
		} catch (Exception e) {
			log.info(" 审核失败！"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 批量审核教师成绩信息
	 * @param ids
	 * @return
	 */
	@RequestMapping("batchAuditScores.do")
	public @ResponseBody Map<String,Object> batchAudit(String ids,int status,String auditMemo,HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("updateBy", super.getAccount(request));
			params.put("status", status);
			params.put("auditMemo", auditMemo);
			boolean batchResult=eduProjectService.batchAuditTeacherScores(ids,params);
			if(batchResult){
				DataUtil.setOk(result);
			}
			else{
				DataUtil.setFail(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("批量审核失败！"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * 全部审核/全部取消审核成绩
	 */
	@RequestMapping("auditAllScores.do")
	public @ResponseBody Map<String, Object> auditAllScores(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		log.info("成绩审核");
		String examine = request.getParameter("examine");		
		String projectId = request.getParameter("projectId");
		String opinion = request.getParameter("opinion");
		Map<String, Object> conditions =new HashMap<String,Object>();
		conditions.put("projectId", projectId);
		conditions.put("examine", examine);
		conditions.put("opinion", opinion);
		
		try { 
			boolean isSucceed =eduProjectService.auditAllTeacherScores(conditions);
			if(isSucceed){
				DataUtil.setOk(result);				
			}
			else{
				DataUtil.setFail(result);
			}
			
		} catch (Exception e) {
			log.info(" 审核失败！"+e.getMessage());
			e.printStackTrace();
			DataUtil.setFail(result);			
		}
		return result;
	}
	
	/**
	 * 批量修改成绩
	 * */
	@RequestMapping("orgScoreBatchUpdate.do")
	public @ResponseBody boolean orgScoreBatchUpdate(HttpServletRequest request){
		log.info("批量修改成绩");
		String projectId = request.getParameter("projectId");
		String method = request.getParameter("method");
		String addScore = request.getParameter("addScore");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String period = request.getParameter("period");
		Map<String, Object> conditions =new HashMap<String,Object>();
		conditions.put("projectId", projectId);
		conditions.put("method", method);
		conditions.put("score", addScore);
		conditions.put("start", start);
		conditions.put("end", end);
		//修改培训学时
		conditions.put("period", period);
		try {
			boolean isSucceed = eduProjectService.ScoreBatchUpdate(conditions);
			return isSucceed;
			 
		} catch (Exception e) {
			log.info("批量修改成绩失败:"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("orgRegionUserList.do")
	public @ResponseBody  Map<String, Object> orgRegionUserList( int pageIndex, int pageSize, HttpServletRequest request){
		log.info("查询地区下的教师列表");
		Map<String,Object> result = new HashMap<String,Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		String school = request.getParameter("school");
		String teacherName = request.getParameter("teacherName");
		
		Map<String, Object> conditions =new HashMap<String,Object>();
		conditions.put("userProvinceId", province);
		conditions.put("userCityId", city);
		conditions.put("userDistrictId", district);
		conditions.put("schoolId", school);
		conditions.put("realName",teacherName==null?null:teacherName.length()==0?null:teacherName);
		
		try {
			PageObject po = userService.getRegionUserList(conditions, pageIndex, pageSize); 
			if(po.getCount() >0){
				result.put("success",true);
			}else{
				result.put("success",false);
				return result;
			}
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
	
	/**
	 * 非培训类项目教师列表
	 * @param pageIndex
	 * @param pageSize
	 * @param request
	 * @return
	 */
	@RequestMapping("orgRegionUserListNotrain.do")
	public @ResponseBody  Map<String, Object> orgRegionUserListNotrain( int pageIndex, int pageSize, HttpServletRequest request){
		log.info("查询地区下的教师列表, 非培训类项目/校本项目");
		String projectType =request.getParameter("projectType"); 
		String projectId = request.getParameter("projectId"); 
		String queryType=request.getParameter("queryType");
		
		Map<String,Object> result = new HashMap<String,Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		String school = request.getParameter("school");
		//学校类型，小学教育学校、初中教育学校、高中教育学校，ztree树中，点击学校类型时，查询相应的信息。
		String schoolType = request.getParameter("schoolType");
		String teacherName = request.getParameter("teacherName");
		
		Map<String, Object> conditions =new HashMap<String,Object>();
		conditions.put("queryType", queryType);
		conditions.put("projectType", projectType);
		conditions.put("projectId", projectId);
		
		conditions.put("userProvinceId", province);
		conditions.put("userCityId", city);
		conditions.put("userDistrictId", district);
		conditions.put("schoolId", school);
		conditions.put("schoolType", schoolType);
		conditions.put("realName",teacherName==null?null:teacherName.length()==0?null:teacherName);
		
		try {
			PageObject po = new PageObject();
			if(queryType.equalsIgnoreCase("creditNotEntered")){ //未登记
				 po = userService.getRegionUserListNotrain(conditions, pageIndex, pageSize); 
			}else if(queryType.equalsIgnoreCase("creditAlreadyEntered")){ //已登记
				 po = userService.getRegionUserListNotrainEntered(conditions, pageIndex, pageSize); 
			}else{ //查学分审核的用户
				Integer userId = getAccountId(request);
	  			EduUser user = userService.getUserById(userId);
				Integer provinceId = user.getUserProvinceId();
				Integer cityId = user.getUserCityId();
				Integer districtId = user.getUserDistrictId();
				Integer schoolId = user.getSchoolId();
				if(provinceId !=null){
					conditions.put("userProvinceId", provinceId.toString());
				}		
				if(cityId !=null){
					conditions.put("userCityId", cityId.toString());
				}		
				if(districtId !=null){
					conditions.put("userDistrictId", districtId.toString());
				}		
				if(schoolId !=null){
					conditions.put("schoolId", schoolId.toString());
				}		
				
				if(queryType.equalsIgnoreCase("creditNotAudit")){ //未审核
					conditions.put("notAudit", "ture");//未审核
					 po = userService.getRegionUserListNotrainEntered(conditions, pageIndex, pageSize); 
				}else if(queryType.equalsIgnoreCase("creditAlreadyAudited")){ //已审核
					conditions.put("alreadyAudit", "ture");//已审核
					 po = userService.getRegionUserListNotrainEntered(conditions, pageIndex, pageSize); 
				}
				 
			}  
			if(po.getCount() >0){
				result.put("success",true);
			}else{
				result.put("success",false);
				return result;
			}
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
	
	
	/**
	 * 学分审核：培训类项目教师列表
	 * @param pageIndex
	 * @param pageSize
	 * @param request
	 * @return
	 */
	@RequestMapping("orgRegionUserListTrain.do")
	public @ResponseBody  Map<String, Object> orgRegionUserListTrain( int pageIndex, int pageSize, HttpServletRequest request){
		log.info("培训类项目教师学分审核列表");
		String projectType =request.getParameter("projectType"); 
		String projectId = request.getParameter("projectId"); 
		String notAudit=request.getParameter("notAudit");//取未曾审核过学分的学员
		String alreadyAudit=request.getParameter("alreadyAudit");//取已审核过学分的学员
		
		Map<String,Object> result = new HashMap<String,Object>();
		pageIndex = (pageIndex - 1) * pageSize;
		
		String periodSortType = request.getParameter("periodSortType");
		String scoreSortType = request.getParameter("scoreSortType");
		String queryStatus = request.getParameter("queryStatus");
		String queryIdNumber = request.getParameter("queryIdNumber");
		String queryRealName = request.getParameter("queryRealName");
		String areaType = request.getParameter("areaType");
		String areaId = request.getParameter("areaId");
		
//		Map<String, Object> conditions =new HashMap<String,Object>();
		Map<String, Object> conditions = super.getArea(request);
		conditions.put("notAudit", notAudit);
		conditions.put("alreadyAudit", alreadyAudit);
		conditions.put("projectType", projectType);
		conditions.put("projectId", projectId);
		
//		conditions.put("provinceId", super.getUserProvinceId(request));
//		conditions.put("cityId", super.getUserCityId(request));
//		conditions.put("districtId", super.getUserDistrictId(request));
//		conditions.put("schoolId", super.getSchoolId(request));
		
		conditions.put("periodSortType", periodSortType);
		conditions.put("scoreSortType", scoreSortType);
		conditions.put("queryStatus", queryStatus);
		conditions.put("queryIdNumber", queryIdNumber);
		conditions.put("queryRealName", queryRealName);
		
		if(!StringUtils.isEmpty(areaType)) {
			if(areaType.equals("cityId")){
				conditions.put("cityId", areaId);
			}
			else if(areaType.equals("districtId")){
				conditions.put("districtId", areaId);
			}
			else if(areaType.equals("schoolId")){
				conditions.put("schoolId", areaId);
			}
		}
		
		
		try {
			PageObject po = userService.getRegionUserListTrain(conditions, pageIndex, pageSize); 
			result.put("success",true);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
		} catch (Exception e) {
			log.info("项目查询失败！"+e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	 
	@RequestMapping("savaOrUpdateProcessReport.do")
	public void savaOrUpdateProcessReport(boolean isChange,MultipartHttpServletRequest mrequest,Integer projectId,Integer id,String title,String content,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		log.debug("写入用户项目培训过程报告");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String projectPath = request.getSession().getServletContext().getRealPath("/"); 
		//文件保存路径应该是:总结报告路径/项目id/老师或者机构的id
		String savePath = ApplicationProperties.getPropertyValue("upload_process_file")+File.separator+projectId+File.separator+getAccountId(mrequest)+File.separator;//获取保存文件的路径
		List<MultipartFile> files = mrequest.getFiles("file");
		String fullName = "";
		EduProjectProcess epp = new EduProjectProcess();
		epp.setProjectId(projectId);
		EduProjectProcess ep = eduProjectService.getProcessByParam(epp);
		if(ep==null){
			ep= new EduProjectProcess();
			ep.setProjectId(projectId);
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
		ep.setContent(ep.getContent());
		ep.setId(ep.getId());
		ep.setProjectId(ep.getProjectId());
		ep.setTitle(ep.getTitle());
		ep.setCreateDate(new Date());
		ep.setCreator(userInfo.getUserId());
		eduProjectService.writeProcess(ep);
		resultMap.put("success", true);
		resultMap.put("info", "上传成功");
		//ResponseUtil.renderText(response, JSONObject.fromObject(result).toString());
		ResponseUtil.renderText(response, JSONObject.fromObject(resultMap).toString());
		return ;
		
	}
	@RequestMapping("viewProcessReport.do")
	public @ResponseBody Map<String, Object> viewProcessReport(HttpServletRequest request,HttpSession session,
			HttpServletResponse response,ModelMap map,Integer pid) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		EduProjectProcess epp = new EduProjectProcess();
		epp.setProjectId(pid);
		epp = eduProjectService.getProcessByParam(epp);
		result.put("epp", epp);
		return result;
	}
	
	
	@RequestMapping("processDeleteFile.do")
	public @ResponseBody Map<String, Object> teacherSummaryDeleteFile(HttpServletRequest request,HttpSession session,
			HttpServletResponse response,ModelMap map,
			@RequestParam(value="id",required=true)Integer id,
			@RequestParam(value="pid",required=true)Integer pid,
			@RequestParam(value="title",required=true)String title) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String projectPath = request.getSession().getServletContext().getRealPath("/"); 
			String savePath = ApplicationProperties.getPropertyValue("upload_process_file")+File.separator+pid+File.separator+getAccountId(request)+File.separator;//获取保存文件的路径
			
			EduProjectProcess epp = new EduProjectProcess();
			epp.setId(id);
			epp.setProjectId(pid);
			epp = eduProjectService.getProcessByParam(epp);
			if(epp!=null){
				boolean isDelete = FileUtils.deleteFile(projectPath+savePath+title);
				if(isDelete){
					//删除成功之后再更新数据库，否则引起不一致问题
					String[] fileNames = epp.getAttchementTitle().split("\\^");
					String newFileName = "";
					String split = "";
					for(String fileName:fileNames){
						if(title.equals(fileName)){
						}else{
							newFileName += (split+fileName);
							split = "^";
						}
					}
					epp.setAttchementTitle(newFileName);
					eduProjectService.writeProcess(epp);
					result.put("success", true);
				}
				
				return result;
			}
			
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		result.put("success", false);
		return result;
	}
	
	
	@RequestMapping("delete.do")
	public @ResponseBody boolean delete(String name,Integer id){
		String str =name;
		if(str.indexOf("\"")==0) str = str.substring(1,str.length());   //去掉第一个 "
		if(str.lastIndexOf("\"")==(str.length()-1)) str = str.substring(0,str.length()-1);  //去掉最后一个 " 
        
		EduProjectProcess epp = new EduProjectProcess();
		epp.setProjectId(id);
		epp = eduProjectService.getProcessByParam(epp);
		
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
	   
	   int i= eduProjectService.writeProcess(epp);
	   
	   if(i>0){
		   return true;
	   }
	   
		return false;
	}
	
	/**
	 * 查询项目结项评价
	 * @return
	 */
	@RequestMapping(value = "selectOrgProjectCommet.do")
	public @ResponseBody Map<String,Object> selectOrgProjectCommet(String projectId, String orgId, HttpServletRequest request) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(!StringUtils.isEmpty(projectId) && !StringUtils.isEmpty(orgId)){
				OrganizationProject obj =eduProjectOrgService.selectOrgProject(Integer.valueOf(projectId), Integer.valueOf(orgId));
				if(obj.getComment() != null && obj.getComment().length() !=0) {
					result.put("success", true);
					result.put("obj", obj);
				} else {
					result.put("obj", obj);
					result.put("success", false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	/**
	 * 添加结项评价
	 * @return
	 */
	@RequestMapping(value = "updateOrgProjectComment.do")
	public @ResponseBody boolean updateOrgProjectComment(HttpServletRequest request) {
		log.info("添加结项评价");
		String projectId = request.getParameter("projectId");
		String orgId = request.getParameter("orgId");
		String comment = request.getParameter("comment");
		String commentContent = request.getParameter("commentContent");
		Map<String, Object> conditions =new HashMap<String,Object>();
		conditions.put("projectId", projectId);
		conditions.put("orgId", orgId);
		conditions.put("comment", comment);
		conditions.put("commentContent", commentContent);
		
		try {
			boolean isSucceed =eduProjectOrgService.updateOrgProjectComment(conditions);
			return isSucceed;
			 
		} catch (Exception e) {
			log.info(" 添加失败！");
			e.printStackTrace();
			return false;
		}
	}
	
	/***
	 * 根据类型查询字典表
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("queryDictionaryByType.do")
	public @ResponseBody Map<String, Object> queryDictionaryByType(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String type = request.getParameter("dictionaryType");
		String id = request.getParameter("dictionaryId");
		String status = request.getParameter("status");
		paramMap.put("dictionaryType", type);  
		paramMap.put("dictionaryId", id);  
		paramMap.put("status", status);  
		
		
		try {
			List<SysDictionary> po = dictionaryService.selectAllSysDictionaryList(paramMap);
			result.put("rows", po);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("字典表系统管理列表查询失败:" + e.getMessage());
		}
		return result;
	}
	
      public static void main(String[] args) {
    	  String projectNo = "35000015SP0301";
    	//中间的字符串，地区代码（6位）+年份代码（2位）+培训级别代码（2位）+项目类型代码（2位）+院校、机构代码（2位）+项目编号（2位）
    	  String between = projectNo.substring(0, 6)+projectNo.substring(6,8)+projectNo.substring(8,10)+projectNo.substring(10,12)+projectNo.substring(12,14);
		System.out.println(between);
	}
}
