package project.edupm.projectmanage.controller;

import java.io.File;
import java.io.FileInputStream;
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

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
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
import project.edupm.projectmanage.dao.IEduProjectCommentReadDAO;
import project.edupm.projectmanage.dao.IEduProjectReadDAO;
import project.edupm.projectmanage.dto.EduProjectDTO;
import project.edupm.projectmanage.pojo.EduModel;
import project.edupm.projectmanage.pojo.EduModelPOJO;
import project.edupm.projectmanage.pojo.EduOrgProjectStatus;
import project.edupm.projectmanage.pojo.EduPaper;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduProjectAllocateByArea;
import project.edupm.projectmanage.pojo.EduProjectAuditPOJO;
import project.edupm.projectmanage.pojo.EduQuestion;
import project.edupm.projectmanage.pojo.EduQuestionOptions;
import project.edupm.projectmanage.pojo.EduResponseQuestion;
import project.edupm.projectmanage.pojo.EduTeacherForReport;
import project.edupm.projectmanage.pojo.ProjectReportInfo;
import project.edupm.projectmanage.service.IEduProjectCommentService;
import project.edupm.projectmanage.service.IEduProjectService;
import project.fileupload.pojo.FileType;
import project.fileupload.pojo.FileUpload;
import project.fileupload.service.IFileUploadService;
import project.message.service.IMessageServiceIF;
import project.organization.pojo.OrgProTeacherActivity;
import project.organization.pojo.Organization;
import project.organization.pojo.OrganizationProject;
import project.organization.service.IOrganizationServiceIF;
import project.person.pojo.EduUserActivty;
import project.system.dao.ISysReadDAO;
import project.system.pojo.EduSchool;
import project.system.pojo.SysArea;
import project.system.service.ISysSchoolService;
import project.system.service.ISysService;
import project.teacher.teacherProject.service.ITeacherProjectServiceIF;
import project.teacher.teachermanage.pojo.EduTeacherVersionPOJO;
import project.util.ApplicationProperties;
import project.util.DataUtil;
import project.util.ResponseUtil;
import framelib.controller.AbsController;
import framelib.utils.DateUtil;
import framelib.utils.FileUtils;
import framelib.utils.StringUtil;
import framelib.utils.page.PageObject;

/**
 * 项目管理
 * 
 * @Create_by:dengguo
 * @Create_date:2014-3-25
 * @Last_Edit_By:
 * @Edit_Description
 * @version:1.0
 * 
 */
@SuppressWarnings("deprecation")
@Controller
@RequestMapping("/edupm")
public class ProjectController extends AbsController{
	
	private static final Logger log = Logger.getLogger(ProjectController.class);
	
	@Autowired
	@Qualifier("fileUploadService")
	IFileUploadService fileUploadService;
	
	@Autowired
	@Qualifier("messageService")
	IMessageServiceIF messageService;
	
	
	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;
	
	@Autowired
	@Qualifier("eduProjectCommentService")
	IEduProjectCommentService eduProjectCommentService;
	
	@Autowired
	@Qualifier("sysReadDAO")
	ISysReadDAO sysReadDAO; 
	
	
	@Autowired
	@Qualifier("eduProjectReadDAO")
	IEduProjectReadDAO eduProjectReadDAO;
	
	@Autowired
	@Qualifier("eduProjectCommentReadDAO")
	IEduProjectCommentReadDAO eduProjectCommentReadDAO;
	
	@Autowired
	@Qualifier("organizationService")
	IOrganizationServiceIF orgService;
	
	
	@Autowired
	@Qualifier("sysService")
	ISysService sysService; 
	
	@Autowired
	@Qualifier("teacherProjectService")
	ITeacherProjectServiceIF teacherProjectServiceIF;
	
	
	@Autowired
	@Qualifier("schoolService")
	ISysSchoolService schoolService;
	
	@Autowired
	@Qualifier("dictionaryService")
	IDictionaryService dictionaryService;
	
	
	/**
	 * 添加项目
	 * @return
	 */
	@RequestMapping(value = "projectmanage/savePro.do")
	public void projectManagePage(ModelMap map,EduProjectDTO dto,HttpServletRequest request,HttpServletResponse response,MultipartHttpServletRequest mrequest) {
		try {
			
			String path = ApplicationProperties.getPropertyValue("project_attchement_path");
			List<MultipartFile> files = mrequest.getFiles("file");
			dto.setCreateByArea(Integer.parseInt(super.getUserAreaId(mrequest)));
			dto.setCreateBy(getAccount(request));
			dto.setCreateById(getAccountId(request));
			dto.setUpdateBy(getAccount(request));
			dto.setCreateDate(DateUtil.getSystemTimeFormat("yyyy-MM-dd"));
			dto.setUpdateDate(DateUtil.getSystemTimeFormat("yyyy-MM-dd"));
			
			//创建者所属区域
			EduUserActivty obj =  super.getSessionUserInfo(request);
			int roleId = obj.getRoleId();
			if(roleId == 1){
				dto.setPid(Integer.parseInt(obj.getUserProvinceId()));
			}else if(roleId == 2){
				dto.setPid(Integer.parseInt(obj.getUserProvinceId()));
				dto.setCid(Integer.parseInt(obj.getUserCityId()));
			}else if(roleId == 3){
				dto.setPid(Integer.parseInt(obj.getUserProvinceId()));
				dto.setCid(Integer.parseInt(obj.getUserCityId()));
				dto.setDid(Integer.parseInt(obj.getUserDistrictId()));
			}
			
			JSONObject result = new JSONObject();
			//上传项目模板
			if(eduProjectService.saveProject(dto,files,path)){
				if(files.size()>0 && files.get(0).getSize() >0){
					result = fileUploadService.fileUpload(request, response, FileType.DECLARE_TEMPLATE, dto.getPid(), dto.getProjectName(),
						getAccountId(request), getAccount(request), getRoleId(request));
				}
				result.put("success", true);
			}else{
				result.put("success", false);
			}
			ResponseUtil.renderText(response, JSONObject.fromObject(result));
		} catch (Exception e) {
			log.error("项目发布失败--->"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 转到项目添加页面
	 * @return
	 */
	@RequestMapping("projectmanage/toAddProPage.htm")
	public String toAddProjectPage(HttpServletRequest request){
		request.setAttribute("areaType", super.getCode(request).get("areaType"));
		request.setAttribute("areaName", super.getCode(request).get("areaName"));
		request.setAttribute("areaId", super.getCode(request).get("areaId"));
		return "project/projectAdd";
	}
	
	/**
	 * 转到项目列表页面
	 * @return
	 */
	@RequestMapping("projectmanage/toProjectListPage.htm")
	public String toProjectListPage(){
		return "project/projectManage";
	}
	
	/**
	 * 转到 项目 申报页面
	 * @return
	 */
	@RequestMapping("projectmanage/toProjectDeclarePage.htm")
	public String toProjectDeclarePage(){
		return "project/toProjectDeclare";
	}
	
	/**
	 * 转到项目 审核页面
	 * @return
	 */
	@RequestMapping("projectmanage/toProjectAuditPage.htm")
	public String toProjectAuditPage(){
		return "project/new_projectAudit";
	}
	
	/**
	 * 项目列表
	 * @return
	 */
	@RequestMapping("projectmanage/projectList.do")
	public @ResponseBody Map<String, Object> projectList(int startIndex,int start,int end,String projectName,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		conditions.put("start", start);
		conditions.put("end", end);
		conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		try {
			PageObject po = eduProjectService.projectList(conditions,startIndex,Common.PNN_USER_PAGE_LIMIT);
			result.put("total",po.getCount());
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
	 * 项目详情
	 * @param proId
	 * @param map
	 * @return
	 * @modfiy liuyiyou
	 */
	@RequestMapping("projectmanage/projectInfo.htm")
	public String projectInfo(int proId,String createBy,String auditStatus,ModelMap map,HttpServletRequest request){
		try {
//			OrganizationProjectActivity activity = eduProjectService.queryProInfoById(proId);
			//String createby=request.getParameter("createBy");
			String auditzt=request.getParameter("auditStatus");
			String applyer=request.getParameter("applyer");
			String loginName = super.getAccount(request);
			
			EduProjectDTO dto = eduProjectService.qryProFullInfo(proId);
			//List<String> orgs = eduProjectService.getAllOrgByProjectId(proId);
			String  orgss=dto.getOrganizationName();
			List<EduProjectAuditPOJO> auditList=eduProjectService.queryProjectAudit(proId);
			Map<String, Object> condition = new HashMap<String,Object>();
			condition.put("projectId", proId);
			condition.put("type", FileType.DECLARE);
			condition.put("userName", applyer == null?null:applyer.equals("")?null:applyer);
			List<FileUpload>  files = 	fileUploadService.getFileUploads(request, null, condition);
			map.put("files", files);
//			if(dto.getProjectAttchement() != null && dto.getProjectAttchement().length()>0){
//				map.put("files", dto.getProjectAttchement().split(","));
//				map.put("names", dto.getFileName().split(","));
//			}else{
//				map.put("files", "");
//				map.put("names", "");
//			}
			//审核状态， 没什么用，应该是从数据库中查，而不是从前台传
			map.put("auditzt", auditzt);
			//项目创建人
			map.put("createBy", dto.getCreateBy());
			//项目申报人
			map.put("applyer", applyer);
			//登陆用户名
			map.put("loginame", loginName);
			//项目相关信息
			map.put("info", dto);
			//机构名称，猜测之前应该是使用List<String> orgs = eduProjectService.getAllOrgByProjectId(proId);
			//因为前台使用了for循环。后面需求变了之后，改成从dto中查询
			map.put("orgs", orgss);
			//审批记录
			map.put("audit", auditList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/projectInfo";
	}
	
	/**
	 * 删除项目
	 * @param proId
	 * @return
	 */
	@RequestMapping("projectmanage/delProject.do")
	public @ResponseBody Map<String, Object> delPro(HttpServletRequest request,HttpServletResponse response,int proId){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("projectId", proId);
			List<FileUpload> files = fileUploadService.getFileUploads(request,response, condition);
			if(eduProjectService.modifyProById(proId)){
				for (FileUpload file : files) {
					String projectPath = request.getSession().getServletContext().getRealPath("/");
					boolean isDelete = FileUtils.deleteFile(projectPath + file.getUrl());
					Integer isSuccess = fileUploadService.deleteFileById(file.getId());
					if (isSuccess > -1 && isDelete) {
						result.put("success", true);
					} else {
						result.put("success", false);
					}
				}
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
//		return "redirect:toProjectListPage.htm";
		return result;
	}
	/**
	 * 转到编辑项目页面
	 * @return
	 */
	@RequestMapping("projectmanage/toModifyProPage.htm")
	public String toModifyPage(HttpServletRequest request){
		return "project/projectModify";
	}
	
	/**
	 * 编辑项目
	 * @param dto
	 * @return
	 */
	@RequestMapping("projectmanage/modifyPro.do")
	public void modifyPro(EduProjectDTO dto,HttpServletResponse response,HttpServletRequest request,MultipartHttpServletRequest mrequest){
		Map<String, Object> result = new HashMap<String,Object>();
		List<MultipartFile> files = mrequest.getFiles("file");
		String path = request.getRealPath("/");
		try {
			if(eduProjectService.modifyProById(dto,request.getParameter("deleted"),files,path)){
				if(files.size()>0 && files.get(0).getSize() >0){
					JSONObject reseult = fileUploadService.fileUpload(request, response, FileType.DECLARE_TEMPLATE, dto.getId(), dto.getProjectName(),
							getAccountId(request), getAccount(request), getRoleId(request));
					ResponseUtil.renderText(response, JSONObject.fromObject(reseult));
				}
				DataUtil.setOk(result);
			}
			
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		try {
			response.getWriter().write(result.get("success").toString());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
//		return result;
	}
	
	/**
	 * 查询项目详细信息(包括培训对象信息)
	 * @param proId
	 * @return
	 */
	@RequestMapping("projectmanage/qryFullInfo.do")
	public @ResponseBody Map<String, Object> proFullInfo(HttpServletRequest request,HttpServletResponse response,int proId){
		Map<String, Object> result = new HashMap<String,Object>();
		try {
			EduProjectDTO dto = eduProjectService.qryProFullInfo(proId);
			Map<String, Object> condition = new HashMap<String, Object>();
			Integer userId = getAccountId(request);
			condition.put("projectId", proId);
			condition.put("type", FileType.DECLARE_TEMPLATE);
			condition.put("roleId", getRoleId(request));
			condition.put("userId", userId);
			List<FileUpload> files = fileUploadService.getFileUploads(request,response, condition);
			result.put("files", files);
			result.put("success", true);
			result.put("dto", dto);
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 转到设置报名方式页面
	 * @return
	 */
	@RequestMapping("projectmanage/toSetSignUpWay.htm")
	public String toSetSignUpWayPage(){
		return "project/projectSignUpWay";
	}
	
	/**
	 * 设置报名方式
	 * @param way
	 * @param proId
	 * @return
	 */
	@RequestMapping("projectmanage/setWay.do")
	public @ResponseBody Map<String,Object> setSignUpWay(String way,int proId){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(eduProjectService.hasTeacherEnter(proId)){
				//已经有老师报名，不能更改报名方式
				result.put("success",-1);
				return result;
			}else if(eduProjectService.setProSignUpWay(proId, way)){
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("设置报名方式失败--->"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 转到导入教师信息页面
	 * @return
	 */
	@RequestMapping("projectmanage/toImportTeacherPage.htm")
	public String toImportTeacherPage(){
		return "project/uploadTeacher";
	}
	
	/**
	 * 导入教师信息
	 * @param file
	 * @param proId
	 * @return
	 */
//	@RequestMapping("projectmanage/importTeacher.do")
	public @ResponseBody Map<String, Object> importTeacher(MultipartFile file,int proId,HttpServletRequest request){
		Map<String, Object> result = new HashMap<String,Object>();
		try {
//			eduProjectService.importTeacher(file,super.getAccount(request),proId);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("导入失败！"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("projectmanage/toSetClassListPage.htm")
	public String toSetClassPage(){
		return "project/projectListForClass";
	}
	
	/**
	 * 项目课程列表--包含项目信息
	 * @param startIndex
	 * @param start
	 * @param end
	 * @param projectName
	 * @return
	 */
	@RequestMapping("projectmanage/proClassList.do")
	public @ResponseBody Map<String, Object> projectClasses(int startIndex,int start,int end,String projectName,HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> conditions = super.getCode(request);
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
//		EduUserActivty activty = super.getSessionUserInfo(request);
//		conditions.put("roleId", activty.getRoleId());
//		conditions.put("provinceId", activty.getUserProvinceId());
//		conditions.put("cityId", activty.getUserCityId());
//		conditions.put("districtId", activty.getUserDistrictId());
//		conditions.put("schoolId", activty.getSchoolId());
		conditions.put("start", start);
		conditions.put("end", end);
		
		conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		try {
			PageObject po = eduProjectService.classesListForProject(startIndex, Common.PNN_USER_PAGE_LIMIT, conditions);
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
	
	@RequestMapping("projectmanage/toProjectAllocatePage.htm")
	public String toProjectAllocatePage(){
		return "project/projectListForAllocate";
	}
	
	/**
	 * 转到通过项目范围查询机构列表
	 * @return
	 */
	@RequestMapping("projectmanage/toOrgListByAreaPage.htm")
	public String toOrgListByAreaPage(HttpSession session) {
		return "project/orgListByArea";
	}
	/**
	 * 根据项目培训范围列出培训机构，同时初始化选择地点，选择学科
	 * @param proId
	 * @param request
	 * @param startIndex
	 * @return
	 *	2014-4-3
	 * zhangBo
	 */
	@RequestMapping("projectmanage/orgListByArea.do")
	public @ResponseBody Map<String, Object> OrgListByArea(int proId,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
//		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			EduProjectDTO dto = eduProjectService.qryProFullInfo(proId);
			List<Organization> orgs = eduProjectService.getOrgsByArea(dto);
			result.put("rows", orgs);
			result.put("projectName", dto.getProjectName());
			result.put("planNum", dto.getPlanNum());
			result.put("trainScopeName", dto.getTrainScopeName());
			result.put("trainScopeId", dto.getTrainScopeId());
			result.put("subjectName", dto.getSubjectName());
			result.put("subjectId", dto.getSubjectId());
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 指定机构
	 * @param request
	 * @return
	 *	2014-4-3
	 * zhangBo
	 */
	@RequestMapping("projectmanage/saveOP.do")
	public @ResponseBody Map<String,Object> saveOP(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		int organizationId = Integer.parseInt(request.getParameter("orgId"));
		String orgName = request.getParameter("orgName");
		OrganizationProject op = new OrganizationProject();
		op.setProjectId(projectId);
		op.setOrganizationId(organizationId);
		op.setOrganizationName(orgName);	
		try {
			op.setProjectStatus(Common.PROJECT_DIM_PROJECT_STATUS.get("准备中"));
			op.setCreateBy(super.getAccount(request));
			op.setUpdateBy(super.getAccount(request));
			eduProjectService.modifyProjectStatus(projectId,Common.PROJECT_DIM_PROJECT_STATUS.get("准备中"));
			if(eduProjectService.hasAllocate(projectId, organizationId)){
				result.put("success", -1);
				return result;
			}else{
				EduProjectDTO dto = eduProjectService.qryProFullInfo(projectId);
				op.setAreaCode(dto.getTrainScopeId());
				op.setAreaName(dto.getTrainScopeName());
				op.setClassSubjectId(dto.getSubjectId());
				op.setClassSubjectName(dto.getSubjectName());
				if(orgService.saveOP(op)){
					DataUtil.setOk(result);
				}
			}
		} catch (Exception e) {
			log.error("分配机构失败！"+e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 查询项目分配的机构
	 * @param startIndex
	 * @param start
	 * @param end
	 * @param projectName
	 * @return
	 *	2014-4-3
	 * zhangBo
	 */
	@RequestMapping("projectmanage/poList.do")
	public @ResponseBody Map<String, Object> poList(int startIndex,String projectId){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> conditions = new HashMap<String, Object>();
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		conditions.put("projectId", projectId);
		try {
			PageObject po = orgService.selectOPByProjectId(conditions,startIndex, Common.PNN_USER_PAGE_LIMIT);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
			DataUtil.setOk(result);
		} catch (Exception e) {
			log.error("指定培训机构项目列表失败！"+e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 对机构分配任务
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/setOPOtherInfo.do")
	public @ResponseBody Map<String, Object> setOtherInfoOfOP(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String,Object>();
		int projectId = Integer.parseInt(request.getParameter("proId"));
		String planNum = request.getParameter("planNum");
		String subjectName = request.getParameter("subjectName");
		String subjectId = request.getParameter("subjectId");
		String areaName = request.getParameter("areaName");
		String areaCode = request.getParameter("areaCode");
		String id = request.getParameter("id");
		params.put("id", id);
		params.put("planNum", planNum);
		params.put("subjectName", subjectName==null?null:subjectName.length()==0?null:subjectName);
		params.put("areaName", areaName==null?null:areaName.length()==0?null:areaName);
		params.put("subjectId", subjectId==null?null:subjectId.length()==0?null:subjectId);
		params.put("areaCode", areaCode==null?null:areaCode.length()==0?null:areaCode);
		try {
			//分配任务时，同时修改项目状态为准备中，老师可以报名
			if(orgService.setOP(params) && eduProjectService.modifyProjectStatus(projectId,Common.PROJECT_COMMON_STATUS.get("筹备中"))){
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			log.error("机构任务分配失败！"+e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 转向教师报名审核下项目列表页面
	 */
	@RequestMapping("projectmanage/toAuditPage.htm")
	public String toAuditPage(){
		return "project/proListForAudit";
	}
	
	/**
	 * 转向培训成绩审核下项目列表页面
	 */
	@RequestMapping("projectmanage/toShenHePages.htm")
	public String toShenHePages(){
		return "project/proListShenHe";
	}
	
	/**
	 * 转向培训结果审核下项目列表页面
	 */
	@RequestMapping("projectmanage/toProListAuditTeacher.htm")
	public String toProListAuditTeacher(){
		return "project/proListAuditTeacher";
	}
	
	/**
	 * 教师报名审核项目列表
	 * @param startIndex
	 * @param start
	 * @param end
	 * @param projectName
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/proListForAudit.do")
	public @ResponseBody Map<String, Object> proListForAudit(int startIndex,String start,String end,int status,String projectName,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = new HashMap<String,Object>();
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		conditions.put("start", start == null || start == "" ? null : start);
		conditions.put("end", end == null || end == "" ? null : end);
		conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		String areaId = super.getUserAreaId(request);
		int roleId = super.getRoleId(request);

		//只允许项目创建者可以查看到项目
		if (roleId == 1 || roleId == 2 || roleId == 3) {
//			conditions.put("createByArea", super.getUserAreaId(request));
			conditions.put("createById", this.getAccountId(request));
		}
		
		try {
			PageObject po = eduProjectService.proListForAudit(conditions, status, startIndex, Common.PNN_USER_PAGE_LIMIT);
			result.put("areaId", areaId);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
			DataUtil.setOk(result);
		} catch (Exception e) {
			log.error("教师报名审核项目列表失败！"+e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 培训成绩审核项目列表
	 * 
	 */
	@RequestMapping("projectmanage/proListForAuditSH.do")
	public @ResponseBody Map<String, Object> proListForAuditSH(int startIndex,String start,String end,String projectName,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = new HashMap<String,Object>();
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		conditions.put("start", start==null||start==""?null:start);
		conditions.put("end", end==null||end==""?null:end);
		conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		
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
			PageObject po = eduProjectService.proListForAuditSH(conditions, startIndex, Common.PNN_USER_PAGE_LIMIT);
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
			log.error("培训成绩审核项目列表失败！"+e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/**
	 * 培训结果审核项目列表
	 * 
	 */
	@RequestMapping("projectmanage/proListForAuditTeacher.do")
	public @ResponseBody Map<String, Object> proListForAuditTeacher(int startIndex,String start,String end,String projectName,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = new HashMap<String,Object>();
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		conditions.put("start", start == null || start == "" ? null : start);
		conditions.put("end", end == null || end == "" ? null : end);
		conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
		
		int roleId = super.getRoleId(request);
		if(roleId == 1 || roleId == 2 || roleId == 3){
			conditions.put("createById", super.getAccountId(request));
		}
		try {
			PageObject po = eduProjectService.proListForAuditTeacher(conditions, startIndex, Common.PNN_USER_PAGE_LIMIT);
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
			log.error("培训结果审核项目列表失败！"+e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 培训结果审核教师列表
	 */
	@RequestMapping("projectmanage/toTeacherTrainModify.htm")
	public String toTeacherTrainListForAudit(){
		return "project/toTeacherTrainModify";
	}
	
	@RequestMapping("projectmanage/toTeacherListForAudit.htm")
	public String toTeacherListForAudit(){
		return "project/teacherListForAudit";
	}
	
	/**
	 * 培训成绩审核选择教师页面
	 * */
	@RequestMapping("projectmanage/toTeacherListForAudites.htm")
	public String toTeacherListForAudites(){
		return "project/teacherListForAudites";
	}
	
	//查询报名情况
	
	@RequestMapping("projectmanage/toTeacherListForAuditchaxunbaoming.htm")
	public String toTeacherListForAuditeschxunbaoming(){
		return "project/teacherListForAuditesChaxunbaoming";
	}
	
	//重新上报
	@RequestMapping("projectmanage/toTeacherListForAuditchongxinshangbao.htm")
	public String toTeacherListForAuditeshangbao(){
		return "project/teacherListForAuditesCXBM";
	}
	
	/**
	 * 培训结果审核-->审核教师培训状态
	 */
	@RequestMapping("projectmanage/auditTeacherTrainStatus.do")
	public @ResponseBody Map<String, Object> auditTeacherTrainStatus(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			String ids = request.getParameter("ids");
			String projectId = request.getParameter("projectId");
			int paramProjectId = Integer.parseInt(request.getParameter("paramProjectId"));
			int trainStatusId = Integer.parseInt(request.getParameter("trainStatusId"));
			
			EduProjectDTO dto = eduProjectService.qryProFullInfo(paramProjectId);
			
			eduProjectService.updateProjectCommentTrainStatus(dto, projectId, ids, trainStatusId);
			DataUtil.setOk(result);
			
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("培训结果审核失败！"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 审核报名教师/培训名额上报下某一项目下参训教师
	 * @return
	 */
	@RequestMapping("projectmanage/teacherListForAudit.do")
	public @ResponseBody Map<String, Object> teacherListForAudit(HttpServletRequest request,int pageIndex){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
		//注释未使用到的参数
//		String provinceId = request.getParameter("provinceId");
//		String cityId = request.getParameter("cityId");
//		String districtId = request.getParameter("districtId");
//		String schoolId = request.getParameter("schoolId");
//		String status = request.getParameter("status");
//		String subject = request.getParameter("subject");
		String proId = request.getParameter("projectId");
		String areaId = request.getParameter("areaId");
		String areaType = request.getParameter("areaType");
		String queryIdNumber = request.getParameter("queryIdNumber");
		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		
		paramMap.put("areaId", areaId==null?null:areaId.length()==0?null:areaId);
		paramMap.put("projectId", proId);
		if(!StringUtils.isEmpty(queryIdNumber)) {
			paramMap.put("queryIdNumber", queryIdNumber);
		}
		if(!StringUtils.isEmpty(areaType)) {
			//paramMap.put("areaId", areaId);
			//当选择培训区域时
			if(areaType.equals("cityId")){
				paramMap.put("cityId", areaId);
			}
			else if(areaType.equals("districtId")){
				paramMap.put("districtId", areaId);
			}
			else if(areaType.equals("schoolId")){
				paramMap.put("schoolId", areaId);
			}
		}
//		paramMap.put("teachingSubject", subject== null? null:subject.equals("")?null:subject);
//		paramMap.put("provinceId", provinceId== null? null:provinceId.equals("")?null:provinceId.equals("null")?null:provinceId);
//		paramMap.put("cityId", cityId== null? null:cityId.equals("")?null:cityId.equals("null")?null:cityId);
//		paramMap.put("districtId", districtId== null? null:districtId.equals("")?null:districtId.equals("null")?null:districtId);
//		paramMap.put("schoolId", schoolId== null? null:schoolId.equals("")?null:schoolId.equals("null")?null:schoolId);
//		if(status==null || status.equals("")){
//			paramMap.put("status", null);
//		}else if(status.equals("11") || status.equals("12")){
//			paramMap.put("status", status);
//		}else if(status.equals("13")){
//			paramMap.put("status", 13);
//		}else if(status.equals("90")){//通过未学习
//			paramMap.put("status", 13);
//			paramMap.put("orgId", 0);
//		}else if(status.equals("91")){//已学习
//			paramMap.put("status", 13);
//			paramMap.put("orgId", 1);
//		}
		pageIndex = (pageIndex - 1) * sizePerPage;
		
		try {
			EduProject pro = eduProjectService.queryProjectBaseInfoById(Integer.parseInt(proId));
			PageObject po = eduProjectService.teachersForAudit(paramMap, pageIndex, sizePerPage);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
			result.put("projectName", pro.getProjectName());
			result.put("planNum",pro.getPlanNum());
			DataUtil.setOk(result);
		} catch (Exception e) {
			log.error("根据项目查询老师列表失败"+e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 培训名额上报下导出某一项目参训教师
	 * @return
	 */
	@RequestMapping("projectmanage/downTeacherExcl.do")
	public void downTeacherExcl(HttpServletRequest request,HttpServletResponse response){
		try {
			Map<String,Object> paramMap = new HashMap<String,Object>();
			
			//注释未使用到的参数
	//		String provinceId = request.getParameter("provinceId");
	//		String cityId = request.getParameter("cityId");
	//		String districtId = request.getParameter("districtId");
	//		String schoolId = request.getParameter("schoolId");
	//		String subject = request.getParameter("subject");
	//		String status = request.getParameter("status");
			String proId = request.getParameter("projectId");
			String areaId = request.getParameter("areaId");
			paramMap.put("areaId", areaId==null?null:areaId.length()==0?null:areaId);
			String areaType = request.getParameter("areaType");
			String queryIdNumber = request.getParameter("queryIdNumber");
			
			paramMap.put("projectId", proId);
			if(!StringUtils.isEmpty(queryIdNumber)) {
				paramMap.put("queryIdNumber", queryIdNumber);
			}
			if(!StringUtils.isEmpty(areaType)) {
				if(areaType.equals("cityId")){
					paramMap.put("cityId", areaId);
				}
				else if(areaType.equals("districtId")){
					paramMap.put("districtId", areaId);
				}
				else if(areaType.equals("schoolId")){
					paramMap.put("schoolId", areaId);
				}
			}
	//		paramMap.put("provinceId", provinceId== null? null:provinceId.equals("")?null:provinceId.equals("null")?null:provinceId);
	//		paramMap.put("cityId", cityId== null? null:cityId.equals("")?null:cityId.equals("null")?null:cityId);
	//		paramMap.put("districtId", districtId== null? null:districtId.equals("")?null:districtId.equals("null")?null:districtId);
	//		paramMap.put("schoolId", schoolId== null? null:schoolId.equals("")?null:schoolId.equals("null")?null:schoolId);
	//		paramMap.put("teachingSubject", subject== null? null:subject.equals("")?null:subject);
	//		if(status==null || status.equals("")){
	//			paramMap.put("status", null);
	//		}else if(status.equals("11") || status.equals("12")){
	//			paramMap.put("status", status);
	//		}else if(status.equals("13")){
	//			paramMap.put("status", 13);
	//		}else if(status.equals("90")){//通过未学习
	//			paramMap.put("status", 13);
	//			paramMap.put("orgId", 0);
	//		}else if(status.equals("91")){//已学习
	//			paramMap.put("status", 13);
	//			paramMap.put("orgId", 1);
	//		}
			List<OrgProTeacherActivity> list = eduProjectService.downTeacherExcl(paramMap);
			String path = request.getRealPath("/") + "template" + File.separator + "download_examine.xls";
			
			FileInputStream io = new FileInputStream(path);
			// 创建 excel
			Workbook wb = new HSSFWorkbook(io);
	        String projectName=null;
			Sheet sheet = wb.getSheetAt(0);
			for (int i = 0; i < list.size(); i++) {
				projectName=list.get(i).getProjectName();
				Row row = sheet.createRow(i + 1);
				Cell cellA = row.createCell(0);
				cellA.setCellValue(list.get(i).getRealName());
				
				Cell cellA1 = row.createCell(1);
				cellA1.setCellValue(list.get(i).getGender());
				
				Cell cellI = row.createCell(2);
				cellI.setCellValue(list.get(i).getIdNumber());
	
				Cell cellB = row.createCell(3);
				cellB.setCellValue(list.get(i).getTeachingSubject());
				
				Cell cellB1 = row.createCell(4);
				cellB1.setCellValue(list.get(i).getJobSchoolAdministrationOffice());
	
				Cell cellC = row.createCell(5);
				cellC.setCellValue(list.get(i).getSchoolProvinceName());
	
				Cell cellD = row.createCell(6);
				cellD.setCellValue(list.get(i).getSchoolCityName());
	
				Cell cellE = row.createCell(7);
				cellE.setCellValue(list.get(i).getSchoolDistrictName());
	
				Cell cellF = row.createCell(8);
				cellF.setCellValue(list.get(i).getSchoolName());
				Cell cellG = row.createCell(9);
				cellG.setCellValue(list.get(i).getMobile());
				Cell cellH = row.createCell(10);
				cellH.setCellValue(list.get(i).getStatuses());
			}
	
			exportExcelFromTemplet(request, response, wb, projectName);
			
		} catch (Exception e) {
			log.error("导出失败"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	/**
	 * 教师报名信息审核--单个审核不通过需要发通知给教师
	 * @param commentId  
	 * @param status
	 * @return
	 */
	@RequestMapping("projectmanage/auditTeacher.do")
	public @ResponseBody Map<String, Object> auditTeacher(int commentId,int status,String auditMemo,HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("commentId", commentId);
		params.put("status", status);
		params.put("auditMemo", auditMemo);
		params.put("updateBy", super.getAccount(request));
		try {
			if(eduProjectService.auditTeacher(params)){
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 取消教师报名
	 * wych
	 */
	@RequestMapping("projectmanage/deleteTeacher.do")
	public @ResponseBody Map<String, Object> deleteTeacher(String teacherIds,String projectId,int schoolID,HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		
		Integer schoolId=schoolID;
		//不符合报名条件的教师ID
		if(schoolId==null){
			schoolId=null;
		}
		params.put("updateBy", super.getAccount(request));
		
		List<Integer> tids = new ArrayList<Integer>();
		
			for(String teacherId:teacherIds.split(",")){
				int tid = Integer.parseInt(teacherId);
			
				try {
					if(eduProjectService.deleteTeacher(projectId,tid,schoolID)){
						DataUtil.setOk(result);
                       }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return result;
	}
	/**
	 * 获取报名未通过原因
	 * @param id
	 * @return
	 */
	@RequestMapping("projectmanage/getUnpassReason.do")
	public @ResponseBody Map<String, Object> getUnpassReason(Integer id,HttpServletRequest request){
		Map<String, Object> result = new HashMap<String,Object>();
		try {
			String reason = eduProjectService.getUnpassReason(id);
			result.put("reason", reason);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("查询审核原因失败！"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 批量审核教师报名信息
	 * @param ids
	 * @return
	 */
	@RequestMapping("projectmanage/batchAudit.do")
	public @ResponseBody Map<String,Object> batchAudit(String ids,int status,String auditMemo,HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("updateBy", super.getAccount(request));
			params.put("status", status);
			params.put("auditMemo", auditMemo);
			eduProjectService.batchAuditTeacher(ids,params);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("批量审核失败！"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 取消指定的机构
	 * @param id
	 * @param projectId
	 * @return
	 */
	@RequestMapping("projectmanage/cancelOP.do")
	public @ResponseBody Map<String,Object> cancelOP(int id,int projectId){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if(eduProjectService.hasTeacherEnter(projectId)){//有教师报名
				result.put("success", -1);
				return result;
			}else{
				if(eduProjectService.cancelOP(id)){
					DataUtil.setOk(result);
				}
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 判断是否已经有教师报名
	 * @param projectId
	 * @return
	 */
	@RequestMapping("projectmanage/hasTeacherEnter.do")
	public @ResponseBody Map<String,Object> hasTeacherEnter(int projectId){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(eduProjectService.hasTeacherEnter(projectId)){
				result.put("has", true);
			}else{
				result.put("has", false);
			}
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 批量取消审核
	 * @param ids
	 * @return
	 */
	@RequestMapping("projectmanage/batchCancelAudit.do")
	public @ResponseBody Map<String,Object> batchCancelAudit(String ids,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("updateBy", super.getAccount(request));
		params.put("status", Common.COMMON_AUDIT_UNHANDL);
		try {
			if(eduProjectService.batchAuditTeacher(ids,params)){
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 教师报名审核--审核全部, 此外批量审核，批量取消审核，全部取消审核都是用的该代码
	 * @param request
	 * @return
	 * @modify  liuyiyou  再次修改的别怪我，我在原来的基础上修改的
	 */
	@RequestMapping("projectmanage/auditAll.do")
	public @ResponseBody
	Map<String, Object> auditAll(HttpServletRequest request, Integer type) {
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String provinceId = request.getParameter("provinceId");
		String cityId = request.getParameter("cityId");
		String districtId = request.getParameter("districtId");
		String schoolId = request.getParameter("schoolId");
		String subject = request.getParameter("subject");
		String status = request.getParameter("status");
		String areaId = request.getParameter("areaId");
		paramMap.put("areaId", areaId==null?null:areaId.length()==0?null:areaId);
		paramMap.put("projectId", request.getParameter("projectId"));
		paramMap.put("provinceId", provinceId== null? null:provinceId.equals("")?null:provinceId);
		paramMap.put("cityId", cityId== null? null:cityId.equals("")?null:cityId);
		paramMap.put("districtId", districtId== null? null:districtId.equals("")?null:districtId);
		paramMap.put("schoolId", schoolId== null? null:schoolId.equals("")?null:schoolId);
		paramMap.put("teachingSubject", subject== null? null:subject.equals("")?null:subject);
		if(status==null || status.equals("")){
			paramMap.put("status", null);
			paramMap.put("orgId", null);
		}else if(status.equals("11") || status.equals("12")){
			paramMap.put("status", status);
		}else if(status.equals("90")){//通过未学习
			paramMap.put("status", 13);
			paramMap.put("orgId", 0);
		}else if(status.equals("91")){//已学习
			paramMap.put("status", 13);
			paramMap.put("orgId", 1);
		}
		try {
			String ids = eduProjectService.getAllTeachers(paramMap);
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("status", request.getParameter("auditSatus"));
			params.put("auditMemo", request.getParameter("auditMemo"));
			params.put("updateBy", super.getAccount(request));
			eduProjectService.batchAuditTeacher(ids,params);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 教师报名审核--全部取消审核
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/cancelAuditAll.do")
	public @ResponseBody Map<String,Object> cancelAuditAll(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String provinceId = request.getParameter("provinceId");
		String cityId = request.getParameter("cityId");
		String districtId = request.getParameter("districtId");
		String schoolId = request.getParameter("schoolId");
		String subject = request.getParameter("subject");
		String status = request.getParameter("status");
		String areaId = request.getParameter("areaId");
		paramMap.put("areaId", areaId==null?null:areaId.length()==0?null:areaId);
		paramMap.put("projectId", request.getParameter("projectId"));
		paramMap.put("provinceId", provinceId== null? null:provinceId.equals("")?null:provinceId);
		paramMap.put("cityId", cityId== null? null:cityId.equals("")?null:cityId);
		paramMap.put("districtId", districtId== null? null:districtId.equals("")?null:districtId);
		paramMap.put("schoolId", schoolId== null? null:schoolId.equals("")?null:schoolId);
		paramMap.put("teachingSubject", subject== null? null:subject.equals("")?null:subject);
		if(status==null || status.equals("")){
			paramMap.put("status", null);
			paramMap.put("orgId", null);
		}else if(status.equals("11") || status.equals("12")){
			paramMap.put("status", status);
		}else if(status.equals("90")){//通过未学习
			paramMap.put("status", 13);
			paramMap.put("orgId", 0);
		}else if(status.equals("91")){//已学习
			paramMap.put("status", 13);
			paramMap.put("orgId", 1);
		}
		try {
			String ids = eduProjectService.getAllTeachers(paramMap);
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("status", Common.COMMON_AUDIT_UNHANDL);
			params.put("updateBy", super.getAccount(request));
			eduProjectService.batchAuditTeacher(ids,params);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 设置默认选中的地区
	 */
	private void setArea(HttpServletRequest request){
		Map<String,Object> map = super.getCode(request);
		int roleId = (Integer) map.get("roleId");
		if(roleId == 1 || roleId == 7){
			request.setAttribute("areaName", super.getSessionUserInfo(request).getUserProvinceName());
			request.setAttribute("areaId", super.getSessionUserInfo(request).getUserProvinceId());
			request.setAttribute("areaType", "provinceId");
		}else if(roleId == 2 || roleId == 8){
			request.setAttribute("areaName", super.getSessionUserInfo(request).getUserCityName());
			request.setAttribute("areaId", super.getSessionUserInfo(request).getUserCityId());
			request.setAttribute("areaType", "cityId");
		}else if(roleId == 3 || roleId == 4 || roleId == 9 || roleId == 10){
			request.setAttribute("areaName", super.getSessionUserInfo(request).getUserDistrictName());
			request.setAttribute("areaId", super.getSessionUserInfo(request).getUserDistrictId());
			request.setAttribute("areaType", "districtId");
		}
	}
	
	
	/**
	 * 根据项目培训范围 地区查询
	 * 
	 * @param startIndex
	 * @return
	 */
	@RequestMapping("projectmanage/curAreaList.do")
	public @ResponseBody 
	Map<String, Object> areaListByTranScope(int belong, String area,@RequestParam("projectId")int projectId,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String,Object>();
		try {
			EduProject pro = eduProjectService.queryProjectBaseInfoById(projectId);
			SysArea sysArea = sysService.queryAreaByCode(pro.getTrainScopeId());
			if(sysArea.getType().equals("0")){
				result.put("provinceId",sysArea.getCode());
			}else if(sysArea.getType().equals("1")){
				result.put("cityId",sysArea.getCode());
			}else{
				result.put("districtId",sysArea.getCode());
			}
			Map<String, Object> parm = new HashMap<String, Object>();
			if(area.equals("root")){
				parm.put("code", pro.getTrainScopeId());
			}else{
				parm.put("belong", belong);
			}
			
//			EduUserActivty obj = getSessionUserInfo(request);
//			if (!StringUtils.isEmpty(obj.getUserDistrictId())
//					&& !StringUtils.isEmpty(area) && area.equals("districtId")) {
//				parm.put("code", obj.getUserDistrictId());
//			} else if (!StringUtils.isEmpty(obj.getUserCityId())
//					&& !StringUtils.isEmpty(area) && area.equals("cityId")) {
//				parm.put("code", obj.getUserCityId());
//			} else if (!StringUtils.isEmpty(obj.getUserProvinceId())
//					&& !StringUtils.isEmpty(area) && area.equals("provinceId")) {
//				parm.put("code", obj.getUserProvinceId());
//			} else {
//				parm.put("belong", belong);
//			}

			List<SysArea> list = sysService.selectAreaList(parm);
			if (list != null && list.size() != 0) {
				result.put("success", true);
				result.put("obj", list);
				result.put("area", area);
				result.put("areaId", parm.get("code"));
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("地区查询失败" + e.getMessage());
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 验证项目名称唯一性
	 * @param projectNO
	 * @return
	 */
	@RequestMapping("projectmanage/validateProjectName.do")
	public @ResponseBody Map<String,Object> validateProjectName(String projectName){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(eduProjectService.isReduplicatedProName(projectName)){//已经存在
				result.put("ok",false);
			}else{
				result.put("ok", true);
			}
		} catch (Exception e) {
			result.put("ok", false);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 验证项目编号唯一性
	 * @param projectNO
	 * @return
	 */
	@RequestMapping("projectmanage/validateProjectNO.do")
	public @ResponseBody Map<String,Object> validateProjectNO(String projectNO){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(eduProjectService.isReduplicated(projectNO)){//已经存在
				result.put("ok",false);
			}else{
				result.put("ok", true);
			}
		} catch (Exception e) {
			result.put("ok", false);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 验证校本和非培训类项目名称唯一性
	 * @param projectNO
	 * @return
	 */
	@RequestMapping("projectmanage/validateTrainProjectName.do")
	public @ResponseBody Map<String,Object> validateTrainProjectName(String projectName,Integer type){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(eduProjectService.isReduplicatedTrinProName(projectName,type)){//已经存在
				result.put("ok",false);
			}else{
				result.put("ok", true);
			}
		} catch (Exception e) {
			result.put("ok", false);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 验证项目编号唯一性
	 * @param projectNO
	 * @return
	 */
	@RequestMapping("projectmanage/validateTrainProjectNO.do")
	public @ResponseBody Map<String,Object> validateTrainProjectNO(String projectNO,Integer type){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(eduProjectService.isTrainReduplicated(projectNO,type)){//已经存在
				result.put("ok",false);
			}else{
				result.put("ok", true);
			}
		} catch (Exception e) {
			result.put("ok", false);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 转到培训名额上报下教师导入页面
	 * @return
	 */
	@RequestMapping("projectmanage/toBatchSignUpPage.htm")
	public String toBatchSignUpPage(){
		return "project/uploadStudent";
	}
	
	/**
	 * 报名导入第一步 检测数据
	 * @return
	 */
	@RequestMapping("projectmanage/batchSignUpStep1.do")
	public @ResponseBody Map<String,Object> batchSignUpStep1(HttpServletRequest request,String path){
		Map<String,Object> result = new HashMap<String,Object>();
//		path = request.getRealPath("/")+"uploadFile"+File.separator+super.getAccount(request);
		String projectId = request.getParameter("projectId");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("projectId", projectId);
		try {
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			result = sysService.parseExcel(projectPath + path, "student", params);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 提交导入的数据
	 */
	@RequestMapping("projectmanage/batchSignUpStep4.do")
	public @ResponseBody Map<String,Object> batchSignUpStep4(String path,int projectId,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("projectId", projectId);
		params.put("account", super.getAccount(request));
		String type = request.getParameter("type");
		params.put("type", type);
//		path = ApplicationProperties.getPropertyValue("upload_path")+path.replace("/",File.separator);
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		path = projectPath + ApplicationProperties.getPropertyValue("upload_file_path")+path.replace("/",File.separator); 
		
		try {
			result = sysService.intoDB(path, "student", super.getAccount(request), params);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 调查问卷列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("projectmanage/paperList.do")
	public @ResponseBody Map<String, Object> paperList(int startIndex,Integer proId,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		conditions.put("projectId", proId);
		try {
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
			result.put("total",po.getCount());
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
	 * 转到项目调查与评估列表页面
	 * @return
	 */
	@RequestMapping("projectmanage/toProjectPaperAndAssessListPage.htm")
	public String toProjectPaperAndAssessManage(){
		return "project/projectPaperAndAssessManage";
	}
	/**
	 * 转到调查问卷管理页面
	 * @return
	 */
	@RequestMapping("projectmanage/toProjectPaperListPage.htm")
	public String toProjectPaperListPage(Integer proId, ModelMap map,HttpServletRequest request){
		try{
			EduProjectDTO dto=eduProjectService.qryProFullInfo(proId);
			request.setAttribute("proId", proId);
			if(dto!=null){
				request.setAttribute("projectName", dto.getProjectName());
				request.setAttribute("planNum", dto.getPlanNum());
				request.setAttribute("startDate", dto.getStartDate());
				request.setAttribute("endDate", dto.getEndDate());
			}
			/*map.put("proId", proId);
			map.put("info", dto);*/
		}catch (Exception e) {
			log.error("查看调查问卷失败--->"+e.getMessage());
			e.printStackTrace();
		}
		
		return "project/projectPaperManage";
	}
	
	/**
	 * 更新继教板块信息状态
	 */
	@RequestMapping("projectmanage/upateModeInfo.do")
	@ResponseBody
	public  Map<String, Object> upateModeInfo(HttpServletRequest request) throws Exception{
		Integer id  = null;
		Integer status = null;
		if (!StringUtils.isEmpty(request.getParameter("id"))) {
			id = Integer.valueOf(request
					.getParameter("id"));
		}
		if (!StringUtils.isEmpty(request.getParameter("status"))) {
			status = Integer.valueOf(request
					.getParameter("status"));
		}
		EduModel info = eduProjectService.qryModelInfo(id);
		
		Map<String,Object> paramMap = new HashMap<String, Object>();
		String loginAccount = this.getAccount(request);
		paramMap.put("id", info.getId());
		paramMap.put("modelName", info.getModelName());
		paramMap.put("modelCode", info.getModelCode());
		paramMap.put("trainType", info.getTrainType());
		paramMap.put("trainHour", info.getTrainHour());
		paramMap.put("trainScore", info.getTrainScore());
		paramMap.put("startDate", info.getStartDate());
		paramMap.put("endDate", info.getEndDate());
		paramMap.put("memo", info.getMemo());
		paramMap.put("loginAccount", loginAccount);
		paramMap.put("status",status);
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			if(eduProjectService.updateModelInfoById(paramMap)){
				result.put("success", true);
			}
		} catch (Exception e) {
			log.error("继教模板修改失败:"+e);
			e.printStackTrace();
		}
			
		return result;
	}
	
	
	/**
	 * 更新继教板块信息状态
	 */
	@RequestMapping("projectmanage/deleteModeInfo.do")
	@ResponseBody
	public  Map<String, Object> deleteModeInfo(HttpServletRequest request) throws Exception{
		Integer id  = null;
		if (!StringUtils.isEmpty(request.getParameter("id"))) {
			id = Integer.valueOf(request
					.getParameter("id"));
		}
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			if(eduProjectService.deleteModelInfoById(id)){
				result.put("success", true);
			}
		} catch (Exception e) {
			log.error("删除模板修改失败:"+e);
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 跳转到继教信息板块设置
	 * @author yinxiaolong
	 * @return
	 */
	@RequestMapping("projectmanage/toModelListPage.htm")
	public String toModelListPage(){
		
		return "project/modelManagePage";
	}
	/**
	 * 得到继教信息板块设置列表
	 * @param request
	 * @param startIndex
	 * @return
	 */
	@RequestMapping("projectmanage/getModelList.do")
	public @ResponseBody Map<String, Object> modelList(HttpServletRequest request,int startIndex){
		Map<String,Object> paramMap = super.getArea(request);
		
		Map<String,Object> result = new HashMap<String,Object>();
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		startIndex = (startIndex - 1) * sizePerPage;
		
		try {
			PageObject po = eduProjectService.selectModelList(paramMap, startIndex, sizePerPage);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
		} catch (Exception e) {
			log.error("继教模板设置列表查询失败"+e);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 跳转到继教信息板块设置增加
	 * @author yinxiaolong
	 * @return
	 */
	@RequestMapping("projectmanage/addModelInfo.htm")
	public String toAddModelListPage(HttpServletRequest request){
		return "project/addModelInfo";
	}
	
	/**
	 * 继教信息板块设置增加
	 * @author yinxiaolong
	 * @param modelName
	 * @param modelCode
	 * @param trainType
	 * @param trainHour
	 * @param trainScore
	 * @param startDate
	 * @param endDate
	 * @param memo
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("projectmanage/addModelInfo.do")
	public @ResponseBody  Map<String,Object> addModelInfo(String modelName,String modelCode,
			String trainType,String trainHour,String trainScore,
			String startDate,String endDate,String memo,String status,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		Map<String,Object> result = new HashMap<String, Object>();
		/*
		 * 一、继教信息板块编码（共12位） 编码规则：培训级别代码（2位）+年份代码（2位）+地区代码（6位）+版块序号（2位）
		 * 编码示例：GP1535000001 编码说明： 1.
		 * 培训级别有六类，国家级培训（GP）、省级培训（SP）、地市级培训（DP）、区县级培训（XP）、校本培训（XB）、其它培训（OP）； 2.
		 * 年份代码按年份编排，15代表2015年，以后年份依次顺延； 3.
		 * 地区代码以全国统一地区编码为准，例如350000代表福建省、350100代表福州、350102代表鼓楼区； 4.
		 * 版块序号，从01-99系统自动排序。
		 */
		modelCode = super.getRegionCoding(modelCode, request);
		if (modelCode == null) {
			result.put("success", false);
			result.put("info", "继教板块编码生成失败");
		} else {

			String newmodelName = eduProjectService.checkModelName(modelCode);
			try {
				if (newmodelName != null) {
					result.put("success", false);
					result.put("info", "该名称已经存在");
				} else {
					String loginAccount = this.getAccount(request);
					Map<String, Object> paramMap = new HashMap<String, Object>();

					paramMap.put("modelName", modelName);
					paramMap.put("modelCode", modelCode);
					paramMap.put("trainType", trainType);
					paramMap.put("trainHour", trainHour);
					paramMap.put("trainScore", trainScore);
					paramMap.put("startDate", startDate);
					paramMap.put("endDate", endDate);
					paramMap.put("memo", memo);
					paramMap.put("status", status);
					paramMap.put("loginAccount", loginAccount);
					try {
						if (eduProjectService.insertModelInfo(paramMap)) {
							result.put("success", true);
						} else {
							result.put("success", false);
						}
					} catch (Exception e) {
						log.error("继教模板设置增加失败:" + e);
						e.printStackTrace();
					}
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 跳转到继教信息板块设置编辑
	 * @author yinxiaolong
	 * @return
	 */
	@RequestMapping("projectmanage/editModelInfo.htm")
	public String toEditModelPage(){
		return "project/editModelInfo";
	}
	
	
	@RequestMapping("projectmanage/selectModelInfo.do")
	public @ResponseBody Map<String, Object> editModelInfo(int id,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			EduModel info = eduProjectService.qryModelInfo(id);
			if(info!=null){
				result.put("success", true);
				result.put("info", info);
			}
		} catch (Exception e) {
			log.error("继教模板查询失败:"+e);
			e.printStackTrace();
		}
		return result;
		
	}
	
	/**
	 * 继教板块编码是否存在--增加继教板块的时候
	 * **/
	@RequestMapping("projectmanage/isModelNameExists.do")
	public @ResponseBody Map<String, Object> isModelNameExists(String modelName,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			String  newmodelName  = eduProjectService.checkModelName(modelName);
			if(newmodelName!=null){
				result.put("success", false);
				result.put("info", "该名称已经存在");
			}else{
				result.put("success", true);
			}
		} catch (Exception e) {
			log.error("继教模板查询失败:"+e);
			e.printStackTrace();
		}
		return result;
		
	}
	
	/**
	 * 继教板块编码是否存在--增加继教板块的时候
	 * **/
	@RequestMapping("projectmanage/isModelNameExistsInEdit.do")
	public @ResponseBody Map<String, Object> isModelNameExistsInEdit(int modelId,String modelName,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			String  newmodelName  = eduProjectService.checkModelName(modelId,modelName);
			if(newmodelName!=null){
				result.put("success", false);
				result.put("info", "该名称已经存在");
			}else{
				result.put("success", true);
			}
		} catch (Exception e) {
			log.error("继教模板查询失败:"+e);
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	/**
	 * 继教板块编码是否存在--增加的时候
	 * **/
	@RequestMapping("projectmanage/isModelCodeExists.do")
	public @ResponseBody Map<String, Object> isModelCodeExists(String code,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			String  newmodelName  = eduProjectService.checkModelCode(code);
			if(newmodelName!=null){
				result.put("success", false);
				result.put("info", "该编码已经存在");
			}else{
				result.put("success", true);
			}
		} catch (Exception e) {
			log.error("继教模板查询失败:"+e);
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	/**
	 * 继教板块编码是否存在--修改继教板块的时候
	 * **/
	@RequestMapping("projectmanage/isModelCodeExistsInEdit.do")
	public @ResponseBody Map<String, Object> isModelCodeExistsInEdit(int modelId,String code,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			String  newmodelCode  = eduProjectService.checkModelCode(modelId,code);
			if(newmodelCode!=null){
				result.put("success", false);
				result.put("info", "该编码已经存在");
			}else{
				result.put("success", true);
			}
		} catch (Exception e) {
			log.error("继教模板查询失败:"+e);
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	
	/**
	 * 继教模板修改
	 * @author yinxiaolong
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("projectmanage/editModelInfo.do")
	public @ResponseBody Map<String, Object> editModelInfo(int id,String modelName,String modelCode,
			String trainType,String trainHour,String trainScore,
			String startDate,String endDate,String status,String memo,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> paramMap = new HashMap<String, Object>();
		String loginAccount = this.getAccount(request);
		paramMap.put("id", id);
		paramMap.put("modelName", modelName);
		paramMap.put("modelCode", modelCode);
		paramMap.put("trainType", trainType);
		paramMap.put("trainHour", trainHour);
		paramMap.put("trainScore", trainScore);
		paramMap.put("startDate", startDate);
		paramMap.put("endDate", endDate);
		paramMap.put("status", status);
		paramMap.put("memo", memo);
		paramMap.put("loginAccount", loginAccount);
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			if(eduProjectService.updateModelInfoById(paramMap)){
				result.put("success", true);
			}
		} catch (Exception e) {
			log.error("继教模板修改失败:"+e);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 继教模板设置查看
	 * @author yinxiaolong
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("projectmanage/selectModelInfo.htm")
	public String selectModelInfo(int id,ModelMap map){
		try {
			EduModel dto = eduProjectService.qryModelInfo(id);
			map.put("info", dto);
		} catch (Exception e) {
			log.error("继教模板设置查询失败:"+e);
			e.printStackTrace();
		}
		return "project/modelInfo";
	}
	
	/**
	 * 跳转培训项目查询列表
	 * @return
	 */
	@RequestMapping("projectmanage/toProjectManagePage.htm")
	public String toProjectManagePage(){
		return "project/projectManage_new";
	}
	
	@RequestMapping("projectmanage/toProjectManageOtherPage.htm")
	public String toProjectManageOtherPage(){
		return "project/projectManage_other";
	}
	
	/**
	 * 发送消息 项目列表 
	 */
	@RequestMapping("projectmanage/queryProjectByStatusAll.do")
	public @ResponseBody Map<String,Object> queryProjectByStatus(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = new HashMap<String,Object>();
		 
		EduUserActivty obj = this.getSessionUserInfo(request);
		int roleId = obj.getRoleId();
		
		//管理员查看自己创建的项目
		if(roleId==1 || roleId==2 || roleId==3 || roleId==4){
			conditions.put("createById", obj.getUserId());
		}
		//项目审核通过前，由同一实施机构下所有管理员管理本实施机构的项目；审核通过后，由申报人管理本实施机构的项目
		if(obj.getOrganizationId() != null && !"".equals(obj.getOrganizationId())){
//			conditions.put("organizationId", obj.getOrganizationId());
			conditions.put("applyerId", obj.getUserId());
		}
		
		try {
			List<Object> list =  eduProjectService.queryProjectListByCreateBy(conditions);
			result.put("rows",list);
		} catch (Exception e) {
			log.info("项目查询失败！"+e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 通过状态查询项目（创建、待申报、培训材料提交、培训过程管理、项目调查与评估、行政管理员/实施机构管理员培训项目总结、培训项目关闭）
	 * @param status
	 * @param pageSize
	 * @param startIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/queryProjectByStatus.do")
	public @ResponseBody Map<String,Object> queryProjectByStatus(String status,int pageSize,int startIndex,String flag, HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		String year = request.getParameter("year");
		String projectName = request.getParameter("projectName");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String projectScopeId = request.getParameter("projectScopeId");
		String trainType = request.getParameter("projectTrainType");
		String signUpWay = request.getParameter("signUpWay");
		String eduModelType = request.getParameter("eduModelType");
		String projectPropertyId = request.getParameter("projectPropertyId");
		String unset = request.getParameter("unset");
		

		
		startIndex = (startIndex - 1) * pageSize;
		conditions.put("signUpWay", signUpWay==null?null:signUpWay.length()==0?null:signUpWay.split(","));
		conditions.put("status", status==null?null:status.length()==0?null:status.split(","));
		conditions.put("year", year==null?null:year.length()==0?null:year);
		conditions.put("start", (start=="" || start == null)?null:start);
		conditions.put("end", (end=="" || start == null)?null:end);
		conditions.put("projectName",projectName==null?null:projectName.length()==0?null:projectName);
		conditions.put("trainTypeId", trainType==null?null:trainType.length()==0?null:trainType);
		conditions.put("eduModelType", eduModelType==null?null:eduModelType.equals("null")?null:eduModelType.length()==0?null:eduModelType);
		conditions.put("projectScopeId", projectScopeId==null?null:projectScopeId.length()==0?null:projectScopeId);
		conditions.put("projectPropertyId", projectPropertyId==null?null:projectPropertyId.length()==0?null:projectPropertyId);
		if(Boolean.parseBoolean(unset)){
			conditions.put("unset", unset);
		}
		
		int roleId = super.getRoleId(request);

		//省级可以查看全部的项目,市级可以查看该市和下级区的项目,区级可以查看自己的项目
//		if(roleId == 1){//如果是省级管理员，它能看到省市县所有管理员创建得项目
//			conditions.put("createById", null);
//		}
//		if(roleId == 2){
//			conditions.put("createByArea", super.getUserAreaId(request));
//		}
//		if(roleId == 3){
//			conditions.put("createById", this.getAccountId(request));
//		}
		//管理员查看自己创建的项目
		if(roleId==1 || roleId==2 || roleId==3){
			conditions.put("createById", this.getAccountId(request));
		}
		//项目审核通过前，由同一实施机构下所有管理员管理本实施机构的项目；审核通过后，由申报人管理本实施机构的项目
		if(super.getOrganizationId(request) != null && !"".equals(super.getOrganizationId(request))){
			if("Y".equals(flag)){//查询申报人管理的项目
				conditions.put("applyerId", super.getAccountId(request));
			}else{
				conditions.put("organizationId", super.getOrganizationId(request));
			}
		}
		
		try {
			//String queryFlag = request.getParameter("queryFlag");
			PageObject po = null;
			/*if(queryFlag != null && roleId != 1 && roleId != 7){
				if(roleId == 4){
					conditions.put("sid", super.getSessionUserInfo(request).getSchoolId());
				}
				po = eduProjectService.queryProjectListByStatus(conditions, startIndex, pageSize,queryFlag);
			}else{*/
				po = eduProjectService.queryProjectListByStatus(conditions, startIndex, pageSize);
			//}
			String accLog = super.getAccount(request);
			Integer orgId = super.getOrganizationId(request);
	    	String areaId=super.getUserAreaId(request);
			result.put("areaId",areaId);
			result.put("roleType",super.getRoleId(request));
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
	 * 
	 * 学校报名
	 */
	
	@RequestMapping("projectmanage/ProjectByRegistration.do")
	public @ResponseBody Map<String,Object> ProjectByRegistration(String status,int pageSize,int startIndex,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		String queryFlag = request.getParameter("queryFlag");
		
		String year = request.getParameter("year");
	
		String projectName = request.getParameter("projectName");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String signUpWay = request.getParameter("signUpWay");
		conditions.put("signUpWay", signUpWay==null?null:signUpWay.length()==0?null:signUpWay.split(","));
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		conditions.put("status", status.split(","));
		conditions.put("year", year == null?null:year);
		conditions.put("start", start==null?null:start);
		conditions.put("end", end==null?null:end);
		conditions.put("projectName",projectName==null?null:projectName.length()==0?null:projectName);
		//实施机构管理员只能查看本实施机构的项目 不允许查看不是本机构的项目
		if(super.getOrganizationId(request) != null && !"".equals(super.getOrganizationId(request))){
			conditions.put("organizationId", super.getOrganizationId(request));
		}
			try {
			PageObject po = null;
			po = eduProjectService.ProjectByRegistration(conditions, startIndex, pageSize);
			String accLog = super.getAccount(request);
			Integer orgId = super.getOrganizationId(request);
			String areaId=super.getUserAreaId(request);
			result.put("areaId",areaId);
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
	
	
	@RequestMapping("projectmanage/districtAudit.do")
	public @ResponseBody Map<String, Object> districtAudit(int startIndex,int start,int end,String projectName,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		//  1:省管理员 2:市管理员3:区管理员 4:校管理员
		Integer roleId=super.getRoleId(request);
		if(roleId==3){
			Map<String, Object> conditions = super.getCode(request);
			startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
			conditions.put("start", start);
			conditions.put("end", end);
			
			conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
			try {
				PageObject po = eduProjectService.districtAudit(conditions, startIndex, Common.PNN_USER_PAGE_LIMIT);
			    String areaId = super.getUserAreaId(request);
			    result.put("areaId", areaId);
				result.put("total",po.getCount());
				result.put("rows",po.getObjects());
				result.put("pageSize", po.getPagesize());
				result.put("pages", po.getPages());
				result.put("currentPage", po.getCurrentPage());
				result.put("pageNumbers", po.getPageNumbers());
				DataUtil.setOk(result);
			} catch (Exception e) {
				log.error("教师报名审核项目列表失败！"+e.getMessage());
				DataUtil.setFail(result);
				e.printStackTrace();
			}
		}else if(roleId==2){

			Map<String, Object> conditions = super.getCode(request);
			startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
			conditions.put("start", start);
			conditions.put("end", end);
			
			conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
			try {
				PageObject po = eduProjectService.cityAudit(conditions, startIndex, Common.PNN_USER_PAGE_LIMIT);
				String areaId = super.getUserAreaId(request);
			    result.put("areaId", areaId);
				result.put("total",po.getCount());
				result.put("rows",po.getObjects());
				result.put("pageSize", po.getPagesize());
				result.put("pages", po.getPages());
				result.put("currentPage", po.getCurrentPage());
				result.put("pageNumbers", po.getPageNumbers());
				DataUtil.setOk(result);
			} catch (Exception e) {
				log.error("教师报名审核项目列表失败！"+e.getMessage());
				DataUtil.setFail(result);
				e.printStackTrace();
			}
		
		}else if(roleId==1){

			Map<String, Object> conditions = super.getCode(request);
			startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
			conditions.put("start", start);
			conditions.put("end", end);
			
			conditions.put("projectName", projectName == null?null:projectName.equals("")?null:projectName);
			try {
				PageObject po = eduProjectService.provinceAudit(conditions, startIndex, Common.PNN_USER_PAGE_LIMIT);
				String areaId = super.getUserAreaId(request);
			    result.put("areaId", areaId);
				result.put("total",po.getCount());
				result.put("rows",po.getObjects());
				result.put("pageSize", po.getPagesize());
				result.put("pages", po.getPages());
				result.put("currentPage", po.getCurrentPage());
				result.put("pageNumbers", po.getPageNumbers());
				DataUtil.setOk(result);
			} catch (Exception e) {
				log.error("教师报名审核项目列表失败！"+e.getMessage());
				DataUtil.setFail(result);
				e.printStackTrace();
			}
		
		}
		
		
		return result;
	}
	/**
	 * 通过状态查询项目,培训名额分配,培训名额上报
	 * @param status
	 * @param pageSize
	 * @param startIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/otherProject.do")
	public @ResponseBody Map<String,Object> otherProject(String projectName,int pageSize,int startIndex,
			String status,String start,String end,String projectScopeName,String queryFlag,HttpServletRequest request){
		
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = new HashMap<String,Object>();
		/*String year = request.getParameter("year");
		String projectName = request.getParameter("projectName");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String projectScopeId = request.getParameter("projectScopeId");
		String trainType = request.getParameter("PXXS");
		String signUpWay = request.getParameter("signUpWay");
		conditions.put("signUpWay", signUpWay==null?null:signUpWay.length()==0?null:signUpWay.split(","));
		conditions.put("flag", flag==null?null:flag);
		conditions.put("year", year == null?null:year);*/
		
		String signUpWay = request.getParameter("signUpWay");
		conditions.put("signUpWay", signUpWay==null?null:signUpWay.length()==0?null:signUpWay.split(","));
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		conditions.put("status", status.split(","));
		conditions.put("start", (start==null || start=="")?null:start);
		
		conditions.put("projectScopeName", projectScopeName==null?null:projectScopeName.length()==0?null:projectScopeName);
		
		conditions.put("end", (end==null || end=="")?null:end);
		conditions.put("projectName",projectName==null?null:projectName.length()==0?null:projectName);
		
		int roleId = super.getRoleId(request);
		if(roleId == 1 || roleId == 2 || roleId == 3 || roleId == 4){
			conditions.put("createById", super.getAccountId(request));
			conditions.put("selectAreaId", super.getUserAreaId(request));
		}
		//项目审核通过前，由同一实施机构下所有管理员管理本实施机构的项目；审核通过后，由申报人管理本实施机构的项目
		if(super.getOrganizationId(request) != null && !"".equals(super.getOrganizationId(request))){
//			conditions.put("organizationId", super.getOrganizationId(request));
			conditions.put("applyerId", super.getAccountId(request));
		}
		try {			
			PageObject po = eduProjectService.queryProjectListByStatus(conditions, startIndex, pageSize,queryFlag);
			
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
	
	
	/**
	 * 项目启动/关闭
	 * @param projectId
	 * @param status
	 * @return
	 */
	@RequestMapping("projectmanage/changeProjectStatus.do")
	public @ResponseBody Map<String,Object> changeProjectStatus(int projectId,int status){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			boolean ok = eduProjectService.modifyProjectStatus(projectId, status);
			if(ok){
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 项目申报
	 */
	@RequestMapping("projectmanage/declareProject.do")
	public void declareProject(int projectId, HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Map<String, Object> condition = new HashMap<String,Object>();
		condition.put("projectId", projectId);
		condition.put("type", FileType.DECLARE);
			try {
			List<FileUpload>  files = 	fileUploadService.getFileUploads(request, null, condition);
				if(files.size()==0){
					resultMap.put("success", false);
					resultMap.put("info", "请上传相关文件！");
				}else{
					resultMap = eduProjectService.procDeclareProject(projectId,
							super.getAccountId(request), null, null);
				}
				ResponseUtil.renderText(response,
						JSONObject.fromObject(resultMap));
			} catch (Exception e) {
				log.info("项目申报失败！" + e.getMessage());
				e.printStackTrace();
				resultMap.put("success", false);
				//resultMap.put("info", "内部错误");
				ResponseUtil.renderText(response,
						JSONObject.fromObject(resultMap));
			}
	}

	
	
	/**
	 * 项目申报文件查看
	 * @param proId
	 * @param createBy
	 * @param auditStatus
	 * @param map
	 * @param request
	 */
	@RequestMapping("projectmanage/projectDeclareView.do")
	public @ResponseBody Map<String, Object>  projectDeclareView(int proId,ModelMap map,
			HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			EduProjectDTO dto = eduProjectService.qryProFullInfo(proId);
			result.put("project", dto);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	/**
	 * 下载申报书
	 * @param pid
	 * @param request
	 * @param filePathName
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("projectmanage/projectDeclareDownload.do")
	@ResponseBody
	public void downloadFile(String pid,HttpServletRequest request,String filePathName,HttpServletResponse response) throws IOException{
		String path = ApplicationProperties.getPropertyValue("project_attchement_path");
		path = path+File.separator+filePathName.replace("/", "\\");
		FileUtils.downloadFile(path, response);
	}
	
	//删除申报书
	//实施机构删除培训总结中的文件
		@RequestMapping("projectmanage/projectDeclareDeleteFile.do")
		public @ResponseBody Map<String, Object> shishiSummaryDeleteFile(HttpServletRequest request,HttpSession session,
				HttpServletResponse response,ModelMap map,
				@RequestParam(value="id",required=true)Integer id,
				@RequestParam(value="pid",required=true)Integer pid,
				@RequestParam(value="title",required=true)String title) throws Exception {
			
			Map<String, Object> result = new HashMap<String, Object>();
			Map<String, Object> proParam = new HashMap<String, Object>();
			proParam.put("id", id);
			try {
			EduProject eduProject = (EduProject) eduProjectService
					.findProjectByParam(proParam, 0, 10).getObjects().get(0);
			String[] fileNames = eduProject.getFileName().split(",");
			String newFileName = "";
			String split = "";
			for (String fileName : fileNames) {
				if (title.equals(fileName)) {
				} else {
					newFileName += (split + fileName);
					split = ",";
				}
			}
			eduProject.setFileName(newFileName);
			eduProjectService.updateProject(eduProject);
			result.put("success", true);
			return result;
				
			} catch (Exception e) {
				result.put("success", false);
				e.printStackTrace();
			}
			result.put("success", false);
			return result;
		}
		

	/**
	 * 审核项目
	 * @param projectId 项目ID
	 * @param audtiStatus 审核状态
	 * @param memo 审核说明 
	 * @return
	 *	2014-4-26
	 * @author zhangBo
	 */
	@RequestMapping("projectmanage/auditProject.do")
	public @ResponseBody Map<String,Object> auditProject(int projectId,int audtiStatus,String memo,HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if(eduProjectService.procAuditProject(audtiStatus, memo, projectId, super.getAccountId(request), super.getRealName(request), super.getAccount(request))){
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
	 * 项目审核详情
	 * @param projectId
	 * @return
	 *	2014-4-27
	 * zhangBo
	 */
	@RequestMapping("projectmanage/projectAuditInfo.do")
	public @ResponseBody Map<String,Object> queryAuditInfo(int projectId){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			result.put("obj", eduProjectService.procQueryAuditInfo(projectId));
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.info("审核详情查询失败！"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 分配名额---项目列表
	 * @return
	 *	2014-4-27
	 * zhangBo
	 */
	@RequestMapping("projectmanage/toAllocateByAreaPage.htm")
	public String toAllocateByAreaPage(int flag,HttpServletRequest request){
		request.setAttribute("areaId", super.getUserAreaId(request));
		request.setAttribute("roleId", super.getRoleId(request));
		request.setAttribute("flag", flag);
		return "project/projectForAllocateByArea";
	}
	
	/**
	 * 通过项目的培训范围分配名额
	 * @param projectId
	 * @return
	 *	2014-4-27
	 * zhangBo
	 */
	@RequestMapping("projectmanage/toAllocatePage.htm")
	public String toAllocatePage(int projectId,int flag,int click,HttpServletRequest request){
		request.setAttribute("projectId",projectId );
		Integer roleId=super.getRoleId(request);
		try {
			EduProjectDTO dto = eduProjectService.qryProFullInfo(projectId);
			request.setAttribute("name", dto.getProjectName());
			
			request.setAttribute("flag", flag);
			request.setAttribute("click", click);
			request.setAttribute("planNum", dto.getPlanNum());
			request.setAttribute("roleId", roleId);
			SysArea pa = sysService.queryAreaByCode(dto.getTrainScopeId());
			SysArea ua = sysService.queryAreaByCode(super.getUserAreaId(request));
			//登录人的可视范围和项目范围比较
			if(Integer.parseInt(pa.getType())>Integer.parseInt(ua.getType())){
				request.setAttribute("areaId", dto.getTrainScopeId());
			}else{
				request.setAttribute("areaId", super.getUserAreaId(request));
			}
			String areaId = request.getAttribute("areaId").toString();
			EduProjectAllocateByArea aba = eduProjectService.queryAllocateInfo(projectId, 0,Integer.parseInt(areaId));
			request.setAttribute("num", aba==null?0:aba.getAllocatePlanNum());
			if(dto.getTrainScopeId().equals(areaId)){
				request.setAttribute("num",dto.getPlanNum());
			}
			request.setAttribute("area", sysService.queryAreaByCode(areaId).getName());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/allocateByArea";
	}
	
	/**
	 * 地区分配名额/上报列表
	 * @param areaId
	 * @return
	 */
	@RequestMapping("projectmanage/queryAllocateInfo.do")
	public @ResponseBody Map<String,Object> queryAllocateInfo(int areaId,int projectId,String schoolName,HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		int num=0;
		try {
			List<EduProjectAllocateByArea> pojos = new ArrayList<EduProjectAllocateByArea>();
			if(super.getRoleId(request) == 4){
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("projectId", projectId);
				params.put("areaId", areaId);
				 num = eduProjectReadDAO.countTeacherByAreaAndProject(params);
				 pojos = eduProjectService.queryAllocateInfo(areaId,"2",projectId,schoolService.searchSchoolInfo(areaId).getSchoolName());
				 result.put("type", 2);
				 result.put("num", num);
			}else{
				SysArea area =  sysService.queryAreaByCode(String.valueOf(areaId));
				pojos = eduProjectService.queryAllocateInfo(areaId,area.getType(),projectId,schoolName);
				result.put("type", area.getType());
			}
			EduProjectAllocateByArea paramDto = new EduProjectAllocateByArea();
			paramDto.setAreaId(areaId);
			paramDto.setProjectId(projectId);
			paramDto.setAllocateFactNum(num);
			//EduProjectAllocateByArea allocate = eduProjectService.selectAllocateByArea(paramDto);
			result.put("rows",pojos);
//			result.put("areaName", allocate.getAreaName());
//			result.put("planNum", allocate.getAllocatePlanNum());
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 地区分配名额列表
	 * @param areaId
	 * @return
	 */
	@RequestMapping("projectmanage/queryAllocateInfoes.do")
	public @ResponseBody Map<String,Object> queryAllocateInfoes(int areaId,int projectId,String schoolName,Integer schoolTypeId,HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> code=super.getCode(request);
		try {
			Map<String, Object> conditions = new HashMap<String, Object>();
			conditions.put("id", projectId);
			Integer yibaomingCount= eduProjectService.countProject(conditions);
			request.setAttribute("count",yibaomingCount);
			List<EduProjectAllocateByArea> pojos = new ArrayList<EduProjectAllocateByArea>();
			if(super.getRoleId(request) == 4){
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("projectId", projectId);
				params.put("areaId", areaId);
				int num = eduProjectReadDAO.countTeacherByAreaAndProject(params);
				pojos = eduProjectService.queryAllocateInfoes(areaId,"2",projectId,schoolService.searchSchoolInfo(areaId).getSchoolName(),schoolTypeId);
				result.put("type", 2);
				result.put("num", num);
				
				
			}else{
				SysArea area =  sysService.queryAreaByCode(String.valueOf(areaId));
				pojos = eduProjectService.queryAllocateInfoes(areaId,area.getType(),projectId,schoolName,schoolTypeId);
				result.put("type", area.getType());
			}
			EduProjectAllocateByArea paramDto = new EduProjectAllocateByArea();
			paramDto.setAreaId(areaId);
			paramDto.setProjectId(projectId);
			//EduProjectAllocateByArea allocate = eduProjectService.selectAllocateByArea(paramDto);
			result.put("rows",pojos);
//			result.put("areaName", allocate.getAreaName());
//			result.put("planNum", allocate.getAllocatePlanNum());
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 分配名额
	 * @param areaId
	 * @param planNum
	 * @param projectId
	 * @return
	 */
	@RequestMapping("projectmanage/allocate.do")
	public @ResponseBody Map<String,Object> allocate(int areaId,int planNum,int projectId,int type){
		Map<String, Object> result = new HashMap<String, Object>();
		EduProjectAllocateByArea dto = new EduProjectAllocateByArea();
		dto.setAllocatePlanNum(planNum);
		dto.setAreaId(areaId);
		dto.setProjectId(projectId);
		dto.setType(type);
		dto.setStatus(0);
		/*if(planNum == 0){
			dto.setStatus(1);
		}*/
		try {
			if(eduProjectService.saveOrUpdateAllocate(dto)){
				DataUtil.setOk(result);
			}else{
				DataUtil.setFail(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 分配名额
	 * @param areaId
	 * @param planNum
	 * @param projectId
	 * @return
	 */
	@RequestMapping("projectmanage/allocateAverage.do")
	public @ResponseBody Map<String,Object> allocateAverage(String areaIds,int planNum,int projectId,int type){
		
		
		Map<String, Object> result = new HashMap<String, Object>();	
		EduProjectAllocateByArea dto = new EduProjectAllocateByArea();
		
		String idArray[] = areaIds.split(",");
		/*dto.setAllocatePlanNum(0);
		
		dto.setProjectId(projectId);
		dto.setType(type);
		dto.setStatus(0);
		try {
			for(int i=0; i<idArray.length; i++) {
				dto.setAreaId(Integer.valueOf(idArray[i]));
				eduProjectService.saveOrUpdateAllocate(dto);
			}
			
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}*/
		
		dto.setProjectId(projectId);
		dto.setType(type);
		dto.setStatus(0);
		dto.setAllocatePlanNum(planNum);
		try {
			for(int i=0; i<idArray.length; i++) {
				dto.setAreaId(Integer.valueOf(idArray[i]));
				eduProjectService.saveOrUpdateAllocate(dto);
			}
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
	
		return result;
	}
	
	
	/**
	 * 跳转到: 实施机构 --> 承培机构任务分配页面
	 * @author zxq
	 * @return
	 */
	@RequestMapping("projectmanage/toOrgTaskingPage.htm")
	public String toOrgTaskingPage(HttpServletRequest request, ModelMap map){
		map.put("enableOrg", this.getEnableOrg(request));
		return "project/orgTasking";
	}
	
	
	/**
	 * 实施机构 --> 承培机构任务分配
	 * @author 曉
	 * @param status
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/selectProjectByStatus.do")
	public @ResponseBody Map<String,Object> selectProjectByStatus(Integer pageIndex, Integer status, HttpServletRequest request){
		log.info("实施机构 --> 承培机构任务分配列表查询");
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		String projectName = request.getParameter("projectName");
		String year = request.getParameter("year");
		String trainType = request.getParameter("trainType");  
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		Map<String, Object> paramMap = super.getCode(request);
		paramMap.put("projectName", projectName==null?null:projectName.length()==0?null:projectName);
		paramMap.put("year", year==null? null:year.length()==0?null:year);
		paramMap.put("trainType", trainType==null? null:trainType.length()==0?null:trainType);
		paramMap.put("startDate", startDate==null? null:startDate.length()==0?null:startDate);
		paramMap.put("endDate", endDate==null? null:endDate.length()==0?null:endDate);
		paramMap.put("status", status);
		
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		
		try {
			PageObject po = eduProjectService.selectProjectByStatus(paramMap, pageIndex, Common.PNN_USER_PAGE_LIMIT);
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
			log.error("实施机构 --> 承培机构任务分配列表查询" + e.getMessage());
		}
		
		return result;
	}
	
	
	/**
	 * 根据项目培训范围查询此地区及其以上级别地区的承培机构
	 * @param trainScopeId
	 * @return
	 */
	@RequestMapping("projectmanage/queryOrgByProScopeId.do")
	public @ResponseBody Map<String, Object> queryOrgByProScopeId(String trainScopeId){
		log.info("根据项目培训范围查询此地区级别及其以上地区级别的承培机构");
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<Organization> list;
		try {
			list = eduProjectService.queryOrgByProScopeId(trainScopeId);
			if(list!=null && list.size()>0){
				result.put("success", true);
				result.put("obj", list);
				result.put("total", list.size());
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			log.error("根据项目培训范围查询此地区级别及其以上地区级别的承培机构失败!" + e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/**
	 * 指定承培机构
	 * @param orgIds
	 * @return
	 */
	@RequestMapping("projectmanage/assignOrg.do")
	public @ResponseBody Map<String, Object> assignOrg(int projectId, String data, HttpServletRequest request){
		log.info("指定承培机构");
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			
			JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Organization.class);
			List<Organization> orgList = mapper.readValue(data, javaType);
			result = eduProjectService.assginOrg(super.getAccount(request), projectId, orgList);
			
		} catch (Exception e) {
			result.put("success", false);
			log.error("指定承培机构失败!" + e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}

	
	/**
	 * 跳转到给承培机构分配任务页面
	 * @return
	 */
	@RequestMapping("projectmanage/toAssignTaskPage.htm")
	public String toAssignTaskPage(){
		return "project/assignTasking";
	}
	
	
	/**
	 * 根据projectId查询项目下所有的承培机构承培项目信息
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("projectmanage/queryOrgByProId.do")
	public @ResponseBody Map<String, Object> queryOrgByProId(int proId){
		log.info("根据projectId查询项目下所有的承培机构承培项目信息");
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<OrganizationProject> list = orgService.queryOrgByProId(proId);
			result.put("success", true);
			result.put("obj", list);
		} catch (Exception e) {
			result.put("success", false);
			log.error("根据projectId查询项目下所有的承培机构承培项目信息失败!" + e.getMessage());
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	
	/**
	 * 开始筹备项目
	 * @param projectId
	 * @return
	 */
	/*@RequestMapping("projectmanage/prepareProject.do")
	public @ResponseBody Map<String,Object> prepareProject(HttpServletRequest request,int projectId){
		Map<String, Object> result = new HashMap<String, Object>();
		
		EduProjectDTO project = null;
		try {
			project = eduProjectService.qryProFullInfo(projectId);
			//如果培训形式是面授 是不用对接培训平台大的 就直接把实施机构插入到edu_organization_project表中 
			//状态为30 这样在承培平台设置时 面授就可以不用对接设置 直接是准备就绪 以后的流程就和远程的一样了
			if(project.getTrainTypeId() == 2){
				Organization o = new Organization();
				o.setProjectId(projectId+"");
				o.setOrganizationId(project.getOrgId());			
				o.setOrganizationName(project.getOrganizationName());
				o.setTrainingAddress("http://");
				o.setTrainingHomeAddress("http://");
				//培训学科
				o.setSubjectIds(project.getSubjectId());
				o.setSubjectName(project.getSubjectName());
				//计划人数
				o.setPlanNum(project.getPlanNum());
				o.setAreaCode(project.getTrainScopeId());
				o.setAreaName(project.getTrainScopeName());
				List<Organization> orgList = new ArrayList<Organization>();
				orgList.add(o);
				Map<String, Object> mResult = eduProjectService.assginOrg("", projectId, orgList);
				if(mResult.get("success") == "false" || mResult.get("success") == "exist"){
					DataUtil.setFail(result);
					return result;
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			DataUtil.setFail(result);
			return result;
		}
		
		try {
			boolean ok = eduProjectService.modifyProjectStatus(projectId, Common.PROJECT_COMMON_STATUS.get("筹备中"));
			if(ok){
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}*/
	
	/**
	 * 启动试卷
	 * @param paperId
	 * @return
	 */
	@RequestMapping("projectmanage/staPaper.do")
	public @ResponseBody Map<String, Object> staPaper(int paperId){
		return updatePaper(paperId, Common.PAPER_STA_START);
	}
	/**
	 * 关闭试卷
	 * @param paperId
	 * @return
	 */
	@RequestMapping("projectmanage/closePaper.do")
	public @ResponseBody Map<String, Object> closePaper(int paperId){
		return updatePaper(paperId, Common.PAPER_STA_END);
	}
	/**
	 * 删除项目
	 * @param paperId
	 * @return
	 */
	@RequestMapping("projectmanage/delPaper.do")
	public @ResponseBody Map<String, Object> delPaper(int paperId){
		return updatePaper(paperId, Common.PAPER_STA_DELETE);
	}
	
	/**
	 * 转到培训名额上报页面
	 * @return
	 */
	@RequestMapping("projectmanage/toProjectListForReportPage.htm")
	public String toProjectListForReportPage(HttpServletRequest request){
//		request.setAttribute("areaId", super.getUserAreaId(request));
//		request.setAttribute("roleId", super.getRoleId(request));
		return "project/new_projectListForReport";
	}
	
	/**
	 * 转向培训名额上报下的地区上报页面
	 */
	@RequestMapping("projectmanage/toProjectReportByAreaPage.htm")
	public String toReportByArea(int projectId,HttpServletRequest request){
		
		try {
			EduProjectDTO dto = eduProjectService.qryProFullInfo(projectId);
			request.setAttribute("name", dto.getProjectName());
			request.setAttribute("num", dto.getPlanNum());
			if(super.getRoleId(request) == 4){
			
				request.setAttribute("areaId", super.getUserAreaId(request));
			}else{
				SysArea pa = sysService.queryAreaByCode(dto.getTrainScopeId());
				SysArea ua = sysService.queryAreaByCode(super.getUserAreaId(request));
				
				//登录人的可视范围和项目范围比较
				if(Integer.parseInt(pa.getType())>Integer.parseInt(ua.getType())){
					request.setAttribute("areaId", dto.getTrainScopeId());
				}else{
					request.setAttribute("areaId", super.getUserAreaId(request));
				}
			}
			if(super.getRoleId(request) == 4){
				String areaId = request.getAttribute("areaId").toString();
				EduProjectAllocateByArea aba = eduProjectService.queryAllocateInfo(projectId, 1,Integer.parseInt(areaId));
				request.setAttribute("num", aba==null?0:aba.getAllocatePlanNum());
				if(dto.getTrainScopeId().equals(areaId)){
					request.setAttribute("num",dto.getPlanNum());
				}
				EduSchool ss = schoolService.searchSchoolInfo(Integer.parseInt(areaId));
				request.setAttribute("area", ss==null?"":ss.getSchoolName());

			}else{
				String areaId = request.getAttribute("areaId").toString();
				EduProjectAllocateByArea aba = eduProjectService.queryAllocateInfo(projectId, 0,Integer.parseInt(areaId));
				request.setAttribute("num", aba==null?0:aba.getAllocatePlanNum());
				if(dto.getTrainScopeId().equals(areaId)){
					request.setAttribute("num",dto.getPlanNum());
				}
				SysArea ss = sysService.queryAreaByCode(areaId);
				request.setAttribute("area", ss==null?"":ss.getName());
				
			}
			//request.setAttribute("areaId", dto.getTrainScopeId());
			request.setAttribute("planNum", dto.getPlanNum());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/projectReportByArea";
	}
	
	//查询上报情况
	
	@RequestMapping("projectmanage/chaxunshangbao.htm")
	public String chaxunshangbao(int projectId,HttpServletRequest request){
		
		
		
		try {
			EduProjectDTO dto = eduProjectService.qryProFullInfo(projectId);
			request.setAttribute("name", dto.getProjectName());
			request.setAttribute("num", dto.getPlanNum());
			if(super.getRoleId(request) == 4){
				request.setAttribute("areaId", super.getUserAreaId(request));
			}else{
				SysArea pa = sysService.queryAreaByCode(dto.getTrainScopeId());
				SysArea ua = sysService.queryAreaByCode(super.getUserAreaId(request));
				
				//登录人的可视范围和项目范围比较
				if(Integer.parseInt(pa.getType())>Integer.parseInt(ua.getType())){
					request.setAttribute("areaId", dto.getTrainScopeId());
				}else{
					request.setAttribute("areaId", super.getUserAreaId(request));
				}
			}
			if(super.getRoleId(request) == 4){
				String areaId = request.getAttribute("areaId").toString();
				EduProjectAllocateByArea aba = eduProjectService.queryAllocateInfo(projectId, 1,Integer.parseInt(areaId));
				request.setAttribute("num", aba==null?0:aba.getAllocatePlanNum());
				if(dto.getTrainScopeId().equals(areaId)){
					request.setAttribute("num",dto.getPlanNum());
				}
				EduSchool ss = schoolService.searchSchoolInfo(Integer.parseInt(areaId));
				request.setAttribute("area", ss==null?"":ss.getSchoolName());

			}else{
				String areaId = request.getAttribute("areaId").toString();
				EduProjectAllocateByArea aba = eduProjectService.queryAllocateInfo(projectId, 0,Integer.parseInt(areaId));
				request.setAttribute("num", aba==null?0:aba.getAllocatePlanNum());
				if(dto.getTrainScopeId().equals(areaId)){
					request.setAttribute("num",dto.getPlanNum());
				}
				SysArea ss = sysService.queryAreaByCode(areaId);
				request.setAttribute("area", ss==null?"":ss.getName());
				
			}
			
			
			
//			request.setAttribute("areaId", dto.getTrainScopeId());
			request.setAttribute("planNum", dto.getPlanNum());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/projectChaxunbaom";
	}
	
	
	
	
	/**
	 * 培训名额上报明细
	 * @param projectId
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/toProjectReportByAreaInfoPage.htm")
	public String toReportByAreaInfo(HttpServletRequest request){
		try {
			int projectId=Integer.parseInt(request.getParameter("projectId"));
			EduProjectDTO dto = eduProjectService.qryProFullInfo(projectId);
			request.setAttribute("name", dto.getProjectName());
			request.setAttribute("num", dto.getPlanNum());
			request.setAttribute("area", dto.getTrainScopeName());
			request.setAttribute("areaId", dto.getTrainScopeId());
			request.setAttribute("planNum", dto.getPlanNum());
			String type=request.getParameter("type");
			if(super.getRoleId(request).intValue() == 4){
				type = "2";
			}
			int areaId=Integer.parseInt(request.getParameter("areaId"));
			Map<String,Object> queryMap=new HashMap<String, Object>();
			queryMap.put("projectId", projectId);
			if(type=="2"){
				queryMap.put("schoolId", areaId);
			}else{
				queryMap.put("areaId", areaId);
			}
			List<ProjectReportInfo> info=eduProjectService.queryProjectReportInfo(queryMap);
			
			request.setAttribute("info", info);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/projectReportByAreaInfo";
	}
	
	/**
	 * 上报名额
	 * @param areaId
	 * @param projectId
	 * @return
	 */
	@RequestMapping("projectmanage/toReport.do")
	public @ResponseBody Map<String,Object> report(int areaId,int projectId,int type,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String, Object>();
//		EduProjectAllocateByArea allocate = new EduProjectAllocateByArea();
//		allocate.setStatus(1);
//		allocate.setProjectId(projectId);
//		allocate.setAreaId(areaId);
//		allocate.setType(type);
		
		try {
			if(eduProjectService.apply(areaId,projectId,type)){
				result.put("success", true);
			}else{
				result.put("success", false);
			}
			
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 转到选择教师页面
	 * @param projectId
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/toSelectTeacherPages.htm")
	public String toSelectTeacherPage(int projectId,int areaId,int count,HttpServletRequest request){
		try {
			String areaIds = areaId+"";
			
			EduSchool ss = schoolService.searchSchoolInfo(areaId);
			request.setAttribute("area", ss.getSchoolName());
			/*String areaId = request.getAttribute("areaId").toString();*/
			EduProjectAllocateByArea aba = eduProjectService.queryAllocateInfo(projectId, 1,Integer.parseInt(areaIds));
			request.setAttribute("num", aba==null?0:aba.getAllocatePlanNum());
			EduProjectDTO dto = eduProjectService.qryProFullInfo(projectId);
			request.setAttribute("subjectId", dto.getSubjectId());
			Map<String, Object> conditions = new HashMap<String, Object>();
			conditions.put("id", projectId);
			conditions.put("schoolId", areaId);
			count=aba.getAllocatePlanNum();
			Integer districtID=Integer.parseInt(super.getUserDistrictId(request));
			Integer yibaomingCount= eduProjectService.countProject(conditions);
			int remainingNumber=count-yibaomingCount;
			request.setAttribute("remainingNumber", remainingNumber);
			request.setAttribute("count",yibaomingCount);
			request.setAttribute("name", dto.getProjectName());
			request.setAttribute("districtID", districtID);
			/*request.setAttribute("num", dto.getPlanNum());*/
			/*request.setAttribute("area", dto.getTrainScopeName());*/
			request.setAttribute("areaId", areaId);
			request.setAttribute("planNum", dto.getPlanNum());
			request.setAttribute("projectId", projectId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "project/new_selectTeacherByArea";
	}
	
	/**
	 * 转到选择教师页面
	 * @param projectId
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/toSelectTeacherPage.htm")
	public String toSelectTeacherPage(int projectId,HttpServletRequest request){
		try {
			EduProjectDTO dto = eduProjectService.qryProFullInfo(projectId);
			request.setAttribute("name", dto.getProjectName());
			request.setAttribute("num", dto.getPlanNum());
			request.setAttribute("area", dto.getTrainScopeName());
			request.setAttribute("areaId", request.getParameter("areaId"));
			request.setAttribute("planNum", dto.getPlanNum());
			request.setAttribute("projectId", projectId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "project/new_selectTeacherByArea";
	}
	
	//重新上报
	
	/**
	 * 转到选择教师页面
	 * @param projectId
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/toSelectTeacherPageCXBM.htm")
	public String toSelectTeacherPagea(int projectId,HttpServletRequest request){
		try {
			EduProjectDTO dto = eduProjectService.qryProFullInfo(projectId);
			request.setAttribute("name", dto.getProjectName());
			request.setAttribute("num", dto.getPlanNum());
			request.setAttribute("area", dto.getTrainScopeName());
			request.setAttribute("areaId", request.getParameter("areaId"));
			request.setAttribute("planNum", dto.getPlanNum());
			request.setAttribute("projectId", projectId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "project/new_selectTeacherByAreaCXBMss";
	}
	
	
	
	
	
	
	
	/**
	 *上报名额--选择教师
	 * @param areaId
	 * @param projectId
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("projectmanage/queryTeacherListByArea.do")
	public @ResponseBody Map<String,Object> selectTeachersByArea(int areaId,int projectId,String realName,String subject,int startIndex,int pageSize,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String, Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		/*String realName=request.getParameter("realName");
		String subject=request.getParameter("subject");*/
		param.put("areaId", areaId);
		param.put("projectId", projectId);
		param.put("realName", realName==null?null:realName.length()==0?null:realName);
		param.put("jobFormerTeachingSubject", subject==null?null:subject.length()==0?null:subject);
		int teacherStatus = Integer.parseInt(request.getParameter("reportType"));//报名类型是0，重新上报是1
		
		
		//重新上报查询，审核不通过的，再次上报
		if(teacherStatus == 1 ){
			param.put("teacherStatus", 12);
		}
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			PageObject po = eduProjectService.procTeacherListForReport(param, startIndex, Common.PNN_USER_PAGE_LIMIT);
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
	 * 上报名额--教师报名
	 * @param teacherId
	 * @param projectId
	 * @return
	 */
	@RequestMapping("projectmanage/signUp.do")
	public @ResponseBody Map<String,Object> signUp(int areaId,int teacherId,String projectId,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
//		String type = request.getParameter("type");
		
		List<EduProjectAllocateByArea> pojos = new ArrayList<EduProjectAllocateByArea>();
		//if(super.getRoleId(request) == 4){
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("projectId", projectId);
			params.put("areaId", areaId);
			try{
				int num = eduProjectReadDAO.countTeacherByAreaAndProject(params);
				pojos = eduProjectService.queryAllocateInfo(areaId,"2",Integer.parseInt(projectId),schoolService.searchSchoolInfo(areaId).getSchoolName());
				
				if(pojos.size() <=0 || pojos.get(0).getAllocatePlanNum() == null || (int)pojos.get(0).getAllocatePlanNum() <=0){
					result.put("success", false);
					result.put("result", "未给本地区分配名额！");
					return result;
				}
				
				//教师报名数大于分配名额数
				if(num >= (int)pojos.get(0).getAllocatePlanNum()){
					result.put("success", false);
					result.put("result", "报名数大于分配数，不能进行批量报名，请选择合适的报名数量！");
					return result;
				}
			}
			catch (Exception e) {
				result.put("success", false);
				result.put("result", "请联系技术人员！");
				return result;
			}
		//}
		
		String type ="0";
		try {
			EduTeacherVersionPOJO version = eduProjectService.queryAllTeacherVersion(teacherId);
			int jobVersion = version.getJobVersion();
			
			StringBuffer failMsg = new StringBuffer("");
			if(eduProjectService.canSign(Integer.parseInt(projectId), teacherId, failMsg)){
				//填充edu_project_comment表字段organizationId
				EduProject pro = eduProjectService.queryProjectBaseInfoById(Integer.parseInt(projectId));
				
				if(teacherProjectServiceIF.insertCommentTeacherInfo(pro.getOrganizationId(), projectId, teacherId,jobVersion,super.getAccount(request),Common.COMMON_AUDIT_UNHANDL,type)){
					result.put("sign", true);
				}else{
					result.put("sign", false);
					result.put("result", "插入数据失败。");
				}
			}else{
				result.put("sign", false);
				result.put("result", "不符合报名条件。");
			}
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			result.put("result", "数据异常。");
			e.printStackTrace();
		}
		return result;
			
	}
	
	
	private Map<String, Object> updatePaper(int paperId,int sta){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			EduPaper eduPaper=new EduPaper();
			eduPaper.setId(paperId);
			eduPaper.setStatus(sta);
			if(eduProjectService.updatePaper(eduPaper)){
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
//		return "redirect:toProjectListPage.htm";
		return result;
	}
	
	
	/**
	 * 审批通过的项目列表
	 * @author yinxiaolong
	 * @param status
	 * @param pageSize
	 * @param startIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/queryProjectSuccess.do")
	public @ResponseBody Map<String,Object> queryProjectSuccessList(int pageSize,int startIndex,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		String projectName = request.getParameter("projectName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		String status = request.getParameter("statusVal");//审批通过||不通过
		String loginAccount = this.getAccount(request);
		conditions.put("loginAccount", loginAccount);
		conditions.put("status", status.split(","));
		conditions.put("start", startDate==null?null:startDate);
		conditions.put("end", endDate==null?null:endDate);
		conditions.put("projectName",projectName==null?null:projectName.length()==0?null:projectName);
		
		int roleId = super.getRoleId(request);
		if(roleId == 1 || roleId == 7){
			conditions.put("pid", super.getUserAreaId(request));
		}else if(roleId == 2 || roleId == 8){
			conditions.put("cid", super.getUserAreaId(request));
		}else if(roleId == 3 || roleId == 9){
			conditions.put("cid", super.getUserCityId(request));
			conditions.put("did", super.getUserAreaId(request));
		}
		//实施机构管理员只能查看本实施机构的项目 不允许查看不是本机构的项目
		if(super.getOrganizationId(request) != null && !"".equals(super.getOrganizationId(request))){
			conditions.put("organizationId", super.getOrganizationId(request));
		}
		
		try {
//			PageObject po = eduProjectService.queryProjectListByStatus(conditions, startIndex, pageSize);
			PageObject po = eduProjectService.queryProjectByAuditStatus(conditions, startIndex, pageSize);
			Integer orgId = super.getOrganizationId(request);
			String accLog = super.getAccount(request);
			String areaId=super.getUserAreaId(request);
			result.put("areaId",areaId);
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
			log.info("审批通过项目查询失败！"+e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 转到编辑项目页面
	 * @return
	 */
	@RequestMapping("projectmanage/toModifyDeclareProPage.htm")
	public String toModifyProjectPage(HttpServletRequest request){
		setArea(request);
		return "project/projectDeclareModify";
	}
	/**
	 * 转到项目调查明细列表
	 * @return
	 */
	@RequestMapping("projectmanage/toProjectPaperDetailPage.htm")
	public String toProjectPaperDetailPage(Integer proId,Integer paperId, ModelMap map){
		try{
			EduProjectDTO dto=eduProjectService.qryProFullInfo(proId);
			EduPaper paper=eduProjectService.selectEduPaperById(paperId);
			map.put("proId", proId);
			map.put("paper", paper);
			map.put("info", dto);
		}catch (Exception e) {
			log.error("查看调查问卷失败--->"+e.getMessage());
			e.printStackTrace();
		}
		
		return "project/projectPaperDetailManage";
	}
	/**
	 * 调查问卷明细列表
	 * @return
	 */
	@RequestMapping("projectmanage/paperDetailList.do")
	public @ResponseBody Map<String, Object> paperDetailList(int startIndex,Integer proId,Integer paperId,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		conditions.put("projectId", proId);
		conditions.put("paperId", paperId);
		try {
			PageObject po = eduProjectService.selectEduResponseListByCondition(conditions, startIndex, Common.PNN_USER_PAGE_LIMIT);
			result.put("total",po.getCount());
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
	 * 查看某人的问卷
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("projectmanage/myPaperView.htm")
	public String myPaperView(int paperId,String username,HttpServletRequest request){
		Map<String,Object> conditions = super.getCode(request);
		//获取当前调查问卷
		try {
			EduPaper paper = eduProjectService.selectEduPaperById(paperId);
			//获取问题
			conditions.put("paperId", paper.getId());
			Map<Integer,Object> map = new HashMap<Integer,Object>();
			Map<Integer,Object> mapERQ = new HashMap<Integer,Object>();
			PageObject pgQuestion = eduProjectService.selectEduQuestionListByPapid(conditions, 0, Common.PAPER_Q_LIMIT);
			if(pgQuestion!=null&&pgQuestion.getObjects()!=null){
				for (EduQuestion eduQuestion:(List<EduQuestion>)pgQuestion.getObjects()) {
					conditions.clear();
					conditions.put("questionId", eduQuestion.getId());
					conditions.put("username", username);
					PageObject eduRQuestion=eduProjectService.selectEduResponseQuestionListByCondition(conditions, 0, 1);
					if(eduRQuestion!=null&&eduRQuestion.getObjects()!=null&&eduRQuestion.getObjects().size()>0){
						EduResponseQuestion eduResponseQuestion=(EduResponseQuestion)eduRQuestion.getObjects().get(0);
						mapERQ.put(eduQuestion.getId(), eduResponseQuestion.getAnswer());
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
		return "project/myPaperView";
	}
	
	/**
	 * 查看问卷结果报告
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("projectmanage/paperReport.htm")
	public String paperReport(int paperId,HttpServletRequest request){
		Map<String,Object> conditions = super.getCode(request);
		//获取当前调查问卷
		try {
			EduPaper paper = eduProjectService.selectEduPaperById(paperId);
			//获取问题
			conditions.put("paperId", paper.getId());
			Map<Integer,Integer> map = new HashMap<Integer,Integer>();
			Map<Integer,Object> mapQP = new HashMap<Integer,Object>();
			PageObject pgQuestion = eduProjectService.selectEduQuestionListByPapid(conditions, 0, Common.PAPER_Q_LIMIT);
			List<EduQuestion> qList=new ArrayList<EduQuestion>();
			if(pgQuestion!=null&&pgQuestion.getObjects()!=null){
				for (EduQuestion eduQuestion:(List<EduQuestion>)pgQuestion.getObjects()) {
					if(eduQuestion.getQuestionType()!=Common.PAPER_Q_CHECKBOX&&eduQuestion.getQuestionType()!=Common.PAPER_Q_RADIO){
						//pgQuestion.getObjects().remove(eduQuestion);
						continue;
					}
					qList.add(eduQuestion);
					conditions.put("questionId", eduQuestion.getId());

				  PageObject pgQuestionOption =eduProjectService.selectEduQuestionOptionsListByQid(conditions, 0, Common.PAPER_Q_LIMIT);
					if(pgQuestionOption!=null&&pgQuestionOption.getObjects()!=null){
						mapQP.put(eduQuestion.getId(), pgQuestionOption.getObjects());
						for (EduQuestionOptions eduQuestionOptions:(List<EduQuestionOptions>)pgQuestionOption.getObjects()) { 
							String  answer=String.valueOf(eduQuestionOptions.getId());
							if(answer!=null){
								conditions.put("answer", answer);
							}
							Integer count=eduProjectService.countEduResponseQuestionByCondition(conditions);
							map.put(eduQuestionOptions.getId(), count);
						}
					}
				}
			}
			request.setAttribute("map", map);
			request.setAttribute("mapQP", mapQP);
			request.setAttribute("paper", paper);
			request.setAttribute("pgq",qList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/paperReport";
	}
	
	/**
	 * 是否上报
	 * @param projectId
	 * @return
	 */
	@RequestMapping("projectmanage/isReport.do")
	public @ResponseBody Map<String,Object> isReport(int projectId){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(eduProjectService.isReport(projectId)){
				result.put("success", true);
			}else{
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 结束项目报名
	 * @param projectId
	 * @return
	 */
	@RequestMapping("projectmanage/stopSign.do")
	public @ResponseBody Map<String,Object> stopSign(int projectId){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(eduProjectService.setStopSign(projectId)){
				result.put("success", true);
			}else{
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		return result;
	}
	
	/** 
	 *转向培训项目启动下项目列表页面
	 * */
	@RequestMapping("projectmanage/toStartProjectPage.htm")
	public String toStartProjectPage(HttpServletRequest request){
		return "project/new_startProject";
	}
	
	/**
	 * 启动项目列表/培训项目关闭列表
	 * @return
	 */
	@RequestMapping("projectmanage/projectListForStart.do")
	public @ResponseBody Map<String,Object> projectListForStart(int startIndex,int pageSize,String status,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		String year = request.getParameter("year");
		String projectName = request.getParameter("projectName");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String projectScopeId = request.getParameter("projectScopeId");
		String trainType = request.getParameter("projectTrainType");
		String signUpWay = request.getParameter("signUpWay");
		
		
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		conditions.put("signUpWay", signUpWay==null?null:signUpWay.length()==0?null:signUpWay.split(","));
		conditions.put("status", status);
		conditions.put("year", year==null?null:year.length()==0?null:year);
		conditions.put("start", start==null || start == ""?null:start);
		conditions.put("end", end==null || end == ""?null:end);
		conditions.put("projectName",projectName==null?null:projectName.length()==0?null:projectName);
		conditions.put("trainTypeId", trainType==null?null:trainType.length()==0?null:trainType);
		conditions.put("projectScopeId", projectScopeId);
		int roleId = super.getRoleId(request);
		//只允许创建项目者可以查看到项目
		if(roleId == 1 || roleId == 2 || roleId == 3){
//			conditions.put("createByArea", super.getUserAreaId(request));
			conditions.put("createById", super.getAccountId(request));
		}
		//项目审核通过前，由同一实施机构下所有管理员管理本实施机构的项目；审核通过后，由申报人管理本实施机构的项目
		if(super.getOrganizationId(request) != null && !"".equals(super.getOrganizationId(request))){
//			conditions.put("organizationId", super.getOrganizationId(request));
			conditions.put("applyerId", this.getAccountId(request));
		}
		try{
			PageObject po = eduProjectService.queryProjectByStatusForStart(conditions,startIndex, pageSize);
			String areaId=super.getUserAreaId(request);
			result.put("areaId",areaId);
			result.put("orgId", super.getOrganizationId(request));
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 项目启动 查询分配机构项目状态
	 * @param projectId
	 * @return
	 */
	@RequestMapping("projectmanage/queryOrgStatus.do")
	public @ResponseBody Map<String,Object> queryOrgProjectStatus(int projectId){
		Map<String, Object> result = new HashMap<String,Object>();
		try {
//			EduProjectDTO dto = eduProjectService.qryProFullInfo(projectId);
			EduOrgProjectStatus obj = eduProjectService.queryOrgStatus(projectId);
			
			result.put("obj", obj);
//			result.put("projectName", dto.getProjectName());
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 查询继教信息模块
	 * @return
	 */
	@RequestMapping("projectmanage/queryEduModelNoPage.do")
	public @ResponseBody Map<String,Object> queryEduModelNoPage(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			Map<String,Object> param =  super.getArea(request);
			
			List<EduModelPOJO> list = eduProjectService.queryEduModel(param);
			result.put("rows", list);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 上报上级地区
	 * @return
	 */
	@RequestMapping("projectmanage/reportByUpLvId.do")
	public @ResponseBody Map<String,Object> reportByUpLvId(HttpServletRequest request,int projectId,int areaId){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(eduProjectService.procReportByUpLvId(areaId, projectId)){
				result.put("success", true);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 审核未通过编辑项目、修改项目状态、待申报-10
	 * @author yinxiaolong
	 * @param dto
	 * @return
	 */
	@RequestMapping("projectmanage/modifyProjrct.do")
	public void updateProject(EduProjectDTO dto,HttpServletResponse response,HttpServletRequest request,MultipartHttpServletRequest mrequest){
		Map<String, Object> result = new HashMap<String,Object>();
		List<MultipartFile> files = mrequest.getFiles("file");
		String path = request.getRealPath("/");
		int id = dto.getId();
		int status = 10;
		try {
			boolean flag = eduProjectService.updateProjectStatus(id, status);
			if(eduProjectService.modifyProById(dto,request.getParameter("deleted"),files,path)&&flag){
				DataUtil.setOk(result);
			}
			
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		try {
			response.getWriter().write(result.get("success").toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return result;
	}
	
	/**
	 * 培训项目审核列表查询
	 * @param status
	 * @param pageSize
	 * @param startIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/queryProjectForAudit.do")
	public @ResponseBody Map<String,Object> queryProjectForAudit(String status,int pageSize,int startIndex,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
//		Map<String,Object> conditions = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		String projectName = request.getParameter("projectName");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String projectScopeId = request.getParameter("projectScopeId");
		String trainType = request.getParameter("PXXS");
		
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		conditions.put("status", status.split(","));
		conditions.put("start", (start==null || start== "")?null:start);
		conditions.put("end", (end==null || end== "")?null:end);
		conditions.put("projectName",projectName==null?null:projectName.length()==0?null:projectName);
		conditions.put("trainTypeId", trainType==null?null:trainType.length()==0?null:trainType);
		conditions.put("projectScopeId", projectScopeId);
		
		int roleId = super.getRoleId(request);
	    if(roleId == 1 || roleId == 2 || roleId == 3){
//			conditions.put("createByArea", super.getUserAreaId(request));
			conditions.put("createById", this.getAccountId(request));
		}
		try {
			PageObject po = eduProjectService.queryProjectListForAudit(conditions, startIndex, pageSize);
			String accLog = super.getAccount(request);
			Integer orgId = super.getOrganizationId(request);
	    	String areaId=super.getUserAreaId(request);
			result.put("areaId",areaId);
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
			log.info("项目审核列表查询失败！"+e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 转到设置兑换规则页面
	 * @return
	 */
	@RequestMapping("projectmanage/toSetExchangeRolePage.htm")
	public String toSetExchangeRolePage(){
		return "project/exchangePeriodToCredit";
	}
	
	/**
	 * 设置兑换规则：继教信息模块列表
	 * @return
	 */
	@RequestMapping("projectmanage/queryModelForSet.do")
	public @ResponseBody Map<String,Object> queryModelForSetExchangeRole(HttpServletRequest request,int startIndex,int pageSize){
		Map<String,Object> result = new HashMap<String, Object>();
		Map<String,Object> params = super.getArea(request);
		
		String name = request.getParameter("modelName");
		params.put("modelName",name==null?null:name.length()==0?null:name);
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			PageObject po =eduProjectService.queryModelListForSet(params, startIndex, pageSize);
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
	 * 设置兑换规则
	 * @param id
	 * @param period
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/setExchangeRule.do")
	public @ResponseBody Map<String,Object> setExchangeRole(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String rule = request.getParameter("rule");
		String way = request.getParameter("way");
		String creditExchangeRule = request.getParameter("creditExchangeRule");
		String preiodExchangeRule = request.getParameter("preiodExchangeRule");
		creditExchangeRule = creditExchangeRule==null?null:creditExchangeRule.length()==0?null:creditExchangeRule;
		preiodExchangeRule = preiodExchangeRule==null?null:preiodExchangeRule.length()==0?null:preiodExchangeRule;
		String modelId = request.getParameter("modelId");
		String scopeId = request.getParameter("scopeId");
		String propertyId = request.getParameter("propertyId");
		String formId = request.getParameter("formId");
		String ids = request.getParameter("ids");
		String unset = request.getParameter("unset");
		condition.put("id", id==null?null:id.length()==0?null:id);
		condition.put("rule", rule==null?null:rule.length()==0?null:rule);
		
		if(way.equals("1")){
			if(rule.equals("1")){
				condition.put("commonPeriod", preiodExchangeRule);
			}else{
				condition.put("excellentPeriod", preiodExchangeRule);
			}
		}else{
			if(rule.equals("1")){
				condition.put("commonPeriod", creditExchangeRule);
			}else{
				condition.put("excellentPeriod", creditExchangeRule);
			}
		}
		
		condition.put("modelId", modelId==null?null:modelId.length()==0?null:modelId);
		condition.put("scopeId", scopeId==null?null:scopeId.length()==0?null:scopeId);
		condition.put("propertyId", propertyId==null?null:propertyId.length()==0?null:propertyId);
		condition.put("formId", formId==null?null:formId.length()==0?null:formId);
		condition.put("ids", ids==null?null:ids.length()==0?null:ids);
		condition.put("exchangeWay", way);//兑换方式：1：学时兑换学分；2：学分兑换学时
		if(Boolean.parseBoolean(unset)){
			condition.put("unset", unset);
		}
		
		
		int roleId = super.getRoleId(request);
		//管理员查看自己创建的项目
		if(roleId==1 || roleId==2 || roleId==3){
			condition.put("createById", this.getAccountId(request));
		}
		
		try {
			eduProjectService.setRole(condition);
			result.put("success", true);
			
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 关闭项目
	 * @return
	 */
	@RequestMapping("projectmanage/toEndProjectPage.htm")
	public String toEndProjectPage(){
		return "project/new_endProject";
	}
	
	/**
	 * 项目申报页面
	 * @return
	 */
	@RequestMapping("projectmanage/toNewProjectDeclarePage.htm")
	public String toNewProjectDeclarePage(){
		return "project/new_projectDeclare";
	}
	
	/**
	 * 跳转到借贷学分审核界面
	 */
	@RequestMapping("projectmanage/toAuditCreditLend.htm")
	public String toAuditCreditLend(){
		return "project/auditCreditLend";
	}
	
	
	
	/**
	 * 判断是否分配了名额并且名额不为0
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/hasAllocateGt.do")
	public @ResponseBody Map<String,Object> queryHasAllocate(HttpServletRequest request,int projectId){
		Map<String,Object> result = new HashMap<String, Object>();
		String areaId = super.getUserAreaId(request);
		int roleId = super.getRoleId(request);
		int type = 0;
		if(roleId == 4){//校管理员
			type = 1;
		}
		
		//如果登陆人是实施机构，那么要判断是否关闭了承培机构，
		//如果关闭了，要判断此项目的实施机构是否与登陆人对应的实施机构相同，
		//如果没关闭，按原来的逻辑处理
		
		//是否启用承培机构
		int enable = super.getEnableOrg(request);
		//登陆人为实施机构
		try {
			if(enable == 0 && roleId>=7 && roleId <=10){
				Integer orgId = super.getOrganizationId(request);
				result.put("success", eduProjectService.isOrg(projectId, orgId));
				result.put("msg", -1);
			}else{
				result.put("success", eduProjectService.hasAllocate(projectId, Integer.parseInt(areaId), type));
				String projectAreaId = eduProjectService.qryProFullInfo(projectId).getTrainScopeId();
				
				if(projectAreaId.equals(areaId)){//上报地区与所在地区相同,可以点击上报按钮
					result.put("success", true);
				}
			}
			
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		/*if(roleId == 1){//省级管理员
			result.put("success", true);
		}*/
		return result;
	}
	
	/**
	 * 上报名额  批量报名
	 */
	@RequestMapping("projectmanage/bathSignUp.do")
	public @ResponseBody Map<String,Object> bathSignUp(int areaId,String teacherIds,String projectId,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
//		String type = request.getParameter("type");
		//批量选择的教师数
		int bacthNum = teacherIds.split(",").length;
		List<EduProjectAllocateByArea> pojos = new ArrayList<EduProjectAllocateByArea>();
		
		//if(super.getRoleId(request) == 4){
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("projectId", projectId);
			params.put("areaId", areaId);
			try{
				//已报名数量
				int num = eduProjectReadDAO.countTeacherByAreaAndProject(params);
				pojos = eduProjectService.queryAllocateInfo(areaId,"2",Integer.parseInt(projectId),schoolService.searchSchoolInfo(areaId).getSchoolName());
				//教师报名数大于分配名额数
				int num2 = (int)pojos.get(0).getAllocatePlanNum() - num;
				if(bacthNum > num2){
					result.put("result","报名数大于分配数，不能进行批量报名，请选择合适的报名数量！");
					result.put("success", false);				 
					return result;
				}
			}catch (Exception e) {
				result.put("result","报名数大于分配数，不能进行批量报名，请选择合适的报名数量！");
				result.put("success", false);				
				return result;
			}
		//}
		String type ="0";
		//不符合报名条件的教师ID
		List<Integer> tids = new ArrayList<Integer>();
		try {
			for(String teacherId:teacherIds.split(",")){
				int tid = Integer.parseInt(teacherId);
				EduTeacherVersionPOJO version = eduProjectService.queryAllTeacherVersion(tid);
				int jobVersion = version.getJobVersion();
				
				StringBuffer failMsg = new StringBuffer("");
				if(eduProjectService.canSign(Integer.parseInt(projectId), tid, failMsg)){
					EduProject pro = eduProjectService.queryProjectBaseInfoById(Integer.parseInt(projectId));
					if(teacherProjectServiceIF.insertCommentTeacherInfo(pro.getOrganizationId(), projectId, tid,jobVersion,super.getAccount(request),Common.COMMON_AUDIT_UNHANDL,type)){
						result.put("sign", true);						
					}else{
						result.put("sign", false);						
					}
				}else{
					tids.add(tid);
					//result.put("sign", false);
				}
			}
			
			List<EduTeacherForReport> teachers = new ArrayList<EduTeacherForReport>();
			if(tids.size() !=0){
				teachers = teacherProjectServiceIF.queryTeacherByIds(tids);
			}
			result.put("teachers", teachers);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		return result;
			
	}
	
	/**
	 * 教师申请学分借贷列表查询
	 * @param status
	 * @param pageSize
	 * @param startIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("projectmanage/queryCreditLendForAudit.do")
	public @ResponseBody Map<String,Object> queryCreditLendForAudit(String status,int pageSize,int startIndex,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> conditions = super.getCode(request);
		String teacherName = request.getParameter("teacherName");
		
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		conditions.put("status", status);
		conditions.put("teacherName",teacherName==null?null:teacherName.length()==0?null:teacherName);
		
		int roleId = super.getRoleId(request);
		
	    if(roleId == 1){
			conditions.put("provinceId", super.getUserAreaId(request));
		}
	    if(roleId == 2){
			conditions.put("cityId", super.getUserAreaId(request));
		}
	    if(roleId == 3){
			conditions.put("districtId", super.getUserAreaId(request));
		}
	    if(roleId == 4){
			conditions.put("schoolId", this.getSchoolId(request));
	    }
		try {
			PageObject po = eduProjectService.queryCreditLendListForAudit(conditions, startIndex, pageSize);
			
			
			result.put("rows",po.getObjects());
			DataUtil.setOk(result);
		} catch (Exception e) {
			log.info("项目审核列表查询失败！"+e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 审核教师学分借贷
	 */
	@RequestMapping("projectmanage/auditCreditLend.do")
	public @ResponseBody Map<String,Object> auditCreditLend(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> conditions = super.getCode(request);
		conditions.put("id", request.getParameter("id"));
		conditions.put("auditId", super.getSessionUserInfo(request).getUserId());
		conditions.put("auditName", super.getSessionUserInfo(request).getRealName());
		conditions.put("command", request.getParameter("memo"));
				
		conditions.put(
				"status", 
				Integer.parseInt(request.getParameter("audtiStatus"))==1?Common.CREDIT_LEND_COMMON_STATUS.get("审批通过"):Common.CREDIT_LEND_COMMON_STATUS.get("审批不通过")
				);
		
		try {
			if(eduProjectService.procAuditCreditLend(conditions)){
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
	 * 审核教师学分借贷
	 */
	@RequestMapping("projectmanage/cancelRegistrationAll.do")
	public @ResponseBody Map<String,Object> cancelRegistrationAll(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> conditions = super.getCode(request);
		conditions.put("projectId", request.getParameter("projectId"));
		if(StringUtil.isEmpty(request.getParameter("projectId"))){
			result.put("success", false);
			return result;
		}
		if(eduProjectCommentService.cancelRegistrationAll(conditions)){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		return result;
	}
	
}
