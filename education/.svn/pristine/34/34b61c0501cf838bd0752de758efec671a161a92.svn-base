package project.furtheredu.edumanage.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.common.Common;
import project.dictionary.service.IDictionaryService;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduProjectComment;
import project.edupm.projectmanage.service.IEduProjectService;
import project.fileupload.service.IFileUploadService;
import project.furtheredu.certificate.pojo.EduDiploma;
import project.furtheredu.eduTarget.service.IEduTargetService;
import project.furtheredu.edumanage.pojo.EduSignet;
import project.furtheredu.edumanage.pojo.EduTearcherAssess;
import project.furtheredu.edumanage.pojo.TeacherCertificateExportActivity;
import project.furtheredu.edumanage.pojo.TeacherProActivity;
import project.furtheredu.edumanage.service.IEduManageService;
import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;
import project.person.service.IUserService;
import project.system.pojo.EduTeacherScoreInfo;
import project.system.pojo.SysArea;
import project.system.pojo.SysDictionary;
import project.system.service.ISysService;
import project.teacher.teacherProject.service.ITeacherProjectServiceIF;
import project.teacher.teachermanage.dao.ITeacherReadDao;
import project.util.ApplicationProperties;
import project.util.DesTool;
import project.util.certificate.ConverterPDF;
import project.util.qrcodetool.QRCodeUtil;
import framelib.controller.AbsController;
import framelib.utils.page.PageObject;

/**
 * 教师信息控制器
 * @Create_by:dengguo
 * @Create_date:2014-1-8
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 * 
 */

@Controller
@RequestMapping("/furtheredu/edumanage") 
public class EduManageController extends AbsController{
	private static final Logger log = Logger.getLogger(EduManageController.class);
	
	@Autowired
	@Qualifier("eduManageService")
	IEduManageService eduManageService;
	
	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;
	
	@Autowired
	@Qualifier("eduTargetService")
	IEduTargetService eduTargetService;
	

	@Autowired
	@Qualifier("sysService")
	ISysService sysService;

	@Autowired
	@Qualifier("teacherReadDao")
	ITeacherReadDao teacherReadDao;
	
	@Autowired
	@Qualifier("dictionaryService")
	IDictionaryService dictionaryService;
	
	@Autowired
	@Qualifier("userService")
	IUserService userService;
	
	@Autowired
	@Qualifier("fileUploadService")
	IFileUploadService fileUploadService;
	
	@Autowired
	@Qualifier("teacherProjectService")
	ITeacherProjectServiceIF teacherProjectServiceIF;
	
	
	/**
	 * 跳转继教信息管理页面
	 * @return
	 */
	@RequestMapping(value = "eduManagePage.htm")
	public String teacherManagePage(ModelMap map, HttpServletRequest request) {
		map.put("areaName", this.getCode(request).get("areaName"));
		map.put("areaId", this.getCode(request).get("areaId"));
		map.put("areaType", this.getCode(request).get("areaType"));
		return "furtheredu/eduManage";
	}
	
	/**
	 * 跳转项目评价查询
	 * @return
	 */
	@RequestMapping(value = "evaluationListPage.htm")
	public String queryEvaluationListPage(ModelMap map, String year) {
		map.put("year", year);
		return "furtheredu/evaluationList";
	}
	
	/**
	 * 跳转教师年度考核查询
	 * @return
	 */
	@RequestMapping(value = "eduManageGroupPage.htm")
	public String teacherManageGroupPage(ModelMap map, String year, HttpServletRequest request) {
		map.put("areaName", this.getCode(request).get("areaName"));
		request.setAttribute("areaName", this.getCode(request).get("areaName"));
		map.put("areaId", this.getCode(request).get("areaId"));
		request.setAttribute("areaId", this.getCode(request).get("areaId"));
		map.put("areaType", this.getCode(request).get("areaType"));
		request.setAttribute("areaType",this.getCode(request).get("areaType"));
		map.put("year", year);
		map.addAllAttributes(this.getUserLocaltion(request));
		return "furtheredu/eduManageAuditByYear";
	}
	
	
	/**
	 * 审核教师
	 * @return
	 */
	@RequestMapping(value = "auditEduInfo.do")
	public @ResponseBody Map<String,Object> auditTeacher(String memo, String data, boolean isPass, HttpServletRequest request) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(!StringUtils.isEmpty(data)){
				Integer userId = eduManageService.modifyAuditEduManageBatch(data, this.getAccount(request), isPass, memo);
				if(userId != null && userId.intValue() >= 0) {
					result.put("success", true);
					result.put("userId", userId);
				} else {
					result.put("success", false);
				}
			}
		} catch (Exception e) {
			log.error(" 教师审核失败--->"+e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 教师培训记录
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "teacherComment.do")
	public @ResponseBody Map<String,Object> queryTeacherCommentActivityByCondition(String teacherId, HttpServletRequest request) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List list = eduManageService.queryTeacherCommentActivityByCondition(Integer.valueOf(teacherId));
			if(list != null ) {
				result.put("success", true);
				result.put("rows", list);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			log.error(" 教师培训记录--->"+e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 项目评价报表
	 * @return
	 */
	@RequestMapping(value = "evaluationInfo.do")
	public @ResponseBody Map<String,Object> queryEvaluationInfo(String projectId, String orgId, HttpServletRequest request) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(!StringUtils.isEmpty(projectId) && !StringUtils.isEmpty(orgId)){
			    //Object obj = eduManageService.queryEvaluationInfo(Integer.valueOf(projectId), Integer.valueOf(orgId));
				Object obj = eduManageService.queryEvaluationInfo(Integer.valueOf(projectId));
				if(obj != null ) {
					result.put("success", true);
					result.put("obj", obj);
				} else {
					result.put("success", false);
				}
			}
		} catch (Exception e) {
			log.error(" 教师审核失败--->"+e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 删除继教信息
	 * */
	@RequestMapping(value = "deleteManage.do")
	public @ResponseBody Map<String,Object> deleteTarget(String memo, String data, HttpServletRequest request) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(!StringUtils.isEmpty(data)){
				Integer userId = eduManageService.modifyAuditEduManageBatch(data, this.getAccount(request), memo);
				if(userId != null && userId.intValue() >= 0) {
					result.put("success", true);
					result.put("userId", userId);
				} else {
					result.put("success", false);
				}
			}
		} catch (Exception e) {
			log.error("删除年度 考核设置失败--->"+e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 项目评价查询
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */  
	@RequestMapping(value = "queryEvaluationList.do")
	public @ResponseBody Map<String, Object> queryEvaluationList(String fromYear, String toYear, String projectName,
			int pageIndex, HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		EduUserActivty userInfo = super.getSessionUserInfo(request);
		
		if(!StringUtils.isEmpty(fromYear)) {
			paramMap.put("fromYear", fromYear);
		}
		
		if(!StringUtils.isEmpty(toYear)) {
			paramMap.put("toYear", toYear);
		}
		 
		if(!StringUtils.isEmpty(projectName)) {
			paramMap.put("projectName", projectName);
		}
		
		//只允许项目创建者可以查看到项目
		int roleId = userInfo.getRoleId();
		if(roleId == 1 || roleId == 2 || roleId == 3){
//			paramMap.put("createByArea", super.getUserAreaId(request));
			paramMap.put("createById", this.getAccountId(request));
		}
		//项目审核通过前，由同一实施机构下所有管理员管理本实施机构的项目；审核通过后，由申报人管理本实施机构的项目
		if(userInfo.getOrganizationId() != null && !"".equals(userInfo.getOrganizationId())){
//			paramMap.put("organizationId", super.getOrganizationId(request));
			paramMap.put("applyerId", this.getAccountId(request));
		} 
		
		try {
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
			if(!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}
			pageIndex = (pageIndex - 1) * sizePerPage;
			
			// 2查询分页数据
			PageObject po = eduManageService.queryEvaluationListPage(paramMap, pageIndex, sizePerPage);
			if(po != null && po.getCount() > 0) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
				
			} else {
				pageInfo.put("success", false);
			}
			pageInfo.put("areaId", super.getUserAreaId(request));
			pageInfo.put("total", po.getCount());
			pageInfo.put("pageSize", po.getPagesize());
			pageInfo.put("pages", po.getPages());
			pageInfo.put("currentPage", po.getCurrentPage());
			pageInfo.put("pageNumbers", po.getPageNumbers());
			pageInfo.put("startIndex", po.getStartIndex());
			pageInfo.put("roleType", userInfo.getRoleId());;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("项目综合评分查询错误:" + e);
		}
		return pageInfo;
	}
	
	/**
	 * 继教信息管理
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryManageList.do")
	public @ResponseBody Map<String, Object> queryTeacherActivetyList(String projectName,String queryYearStart, 
			String queryYearEnd, String queryStatus,  String queryIdNumber,
			 String queryRealName, String areaId, String areaType,
			int pageIndex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> pageInfo = new HashMap<String,Object>();
//		Map<String,Object> paramMap = new HashMap<String,Object>();
		Map<String,Object> paramMap = super.getArea(request);
		
		if(!StringUtils.isEmpty(projectName)) {
			paramMap.put("projectName", projectName);
		}
		if(!StringUtils.isEmpty(queryYearStart)) {
			paramMap.put("queryYearStart", queryYearStart);
		}
		if(!StringUtils.isEmpty(queryYearEnd)) {
			paramMap.put("queryYearEnd", queryYearEnd);
		}
		if(!StringUtils.isEmpty(queryStatus)) {
			paramMap.put("queryStatus", queryStatus);
		}
		if(!StringUtils.isEmpty(queryIdNumber)) {
			paramMap.put("queryIdNumber", queryIdNumber);
		}
		if(!StringUtils.isEmpty(queryRealName)) {
			paramMap.put("queryRealName", queryRealName);
		}
		
//		paramMap.put("provinceId", super.getUserProvinceId(request));
//		paramMap.put("cityId", super.getUserCityId(request));
//		paramMap.put("districtId", super.getUserDistrictId(request));
//		paramMap.put("schoolId", super.getSchoolId(request));
		paramMap.put("organizationId", super.getOrganizationId(request));
		
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
		try {
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
			if(!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}
			pageIndex = (pageIndex - 1) * sizePerPage;
			
			// 2查询分页数据
			PageObject po = eduManageService.queryManageListPage(paramMap, pageIndex, sizePerPage);
			/*if(po != null && po.getCount() > 0) {*/
			pageInfo.put("orgId", super.getOrganizationId(request));
			pageInfo.put("areaId",super.getUserAreaId(request));
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
				pageInfo.put("total", po.getCount());
				pageInfo.put("pageSize", po.getPagesize());
				pageInfo.put("pages", po.getPages());
				pageInfo.put("currentPage", po.getCurrentPage());
				pageInfo.put("pageNumbers", po.getPageNumbers());
				pageInfo.put("startIndex", po.getStartIndex());
			/*} else {
				pageInfo.put("success", false);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师信息综合查询错误:" + e);
		}
		return pageInfo;
	}
	
	/**
	 * 教师年度考核查询
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryManageGroupByList.do")
	public @ResponseBody Map<String, Object> queryTeacherActivetyList(String areaId, String areaType,String queryYear, String realName,String queryPId, String queryCityId, String queryOtherId,
			int pageIndex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		Map<String,Object> paramMap = super.getCode(request);
		
		if(!StringUtils.isEmpty(queryYear)) {
			paramMap.put("queryYear", queryYear);
		}
		if(!StringUtils.isEmpty(realName)) {
			paramMap.put("realName", realName);
		}
		if(!StringUtils.isEmpty(areaType)) {
			if(areaType.equals("provinceId")){
				paramMap.put("provinceId", areaId);
			}
			else if(areaType.equals("cityId")){
				paramMap.put("cityId", areaId);
			}
			else if(areaType.equals("districtId")){
				paramMap.put("districtId", areaId);
			}
			else if(areaType.equals("schoolId")){
				paramMap.put("schoolId", areaId);
			}
		} 
		
		try {
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
			if(!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}
			pageIndex = (pageIndex - 1) * sizePerPage;
			
			// 2查询分页数据
			PageObject po = eduManageService.queryManageGroupListPage(paramMap, pageIndex, sizePerPage);
			
			// 3查询年度考核设置
			List<Object>  yearTagrt = new ArrayList<Object>();
			if(!StringUtils.isEmpty(request.getParameter("qid"))) {
				paramMap.clear();
				paramMap.put("queryYear", queryYear);
				paramMap.put("qid", request.getParameter("qid"));
				yearTagrt.addAll(eduTargetService.queryTagetListNoPage(paramMap));
			}
			if(!StringUtils.isEmpty(request.getParameter("cid"))) {
				paramMap.clear();
				paramMap.put("queryYear", queryYear);
				paramMap.put("cid", request.getParameter("cid"));
				yearTagrt.addAll(eduTargetService.queryTagetListNoPage(paramMap));
			}
			if(!StringUtils.isEmpty(request.getParameter("did"))) {
				paramMap.clear();
				paramMap.put("queryYear", queryYear);
				paramMap.put("did", request.getParameter("did"));
				yearTagrt.addAll(eduTargetService.queryTagetListNoPage(paramMap));
			}
			if(!StringUtils.isEmpty(request.getParameter("sid"))) {
				paramMap.clear();
				paramMap.put("queryYear", queryYear);
				paramMap.put("sid", request.getParameter("sid"));
				yearTagrt.addAll(eduTargetService.queryTagetListNoPage(paramMap));
			}
			
			//if(po != null && po.getCount() > 0) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
				pageInfo.put("total", po.getCount());
				pageInfo.put("pageSize", po.getPagesize());
				pageInfo.put("pages", po.getPages());
				pageInfo.put("currentPage", po.getCurrentPage());
				pageInfo.put("pageNumbers", po.getPageNumbers());
				pageInfo.put("startIndex", po.getStartIndex());
			/*} else {
				pageInfo.put("success", false);
			}*/
			pageInfo.put("yearTagrt", yearTagrt);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师年度考核查询:" + e);
		}
		return pageInfo;
	}
	
	
	
	/**
	 * 跳转继教考核查询
	 * @author cl
	 * @create date 2014-4-8
	 * @return
	 */
	@RequestMapping(value = "teacherAssessWithYear.htm")
	public String toTeacherAssessWithYear() {
		return "furtheredu/teacherAssessWithYear";
	}
	
	/**
	 * 继教学分查询/年度证书打印
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryTeacherAssess.do")
	public @ResponseBody Map<String, Object> queryTeacherAssessList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		try {
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("teacherId", super.getAccountId(request));
			paramMap.put("provinceId", super.getUserProvinceId(request));
			paramMap.put("cityId", super.getUserCityId(request));
			paramMap.put("districtId", super.getUserDistrictId(request));
			paramMap.put("schoolId", super.getSchoolId(request));
		
			List<EduTearcherAssess>  po = eduManageService.queryTeacherAssess(paramMap);
			if(po != null && po.size()>0) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po);
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("继教考核查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	/**
	 * 跳转继教考核详细查询
	 * @author cl
	 * @create date 2014-4-8
	 * @return
	 */
	@RequestMapping(value = "teacherAssessWithYearInfo.htm")
	public String toTeacherAssessWithYearInfo() {
		return "furtheredu/teacherAssessWithYearInfo";
	}
	
	/**
	 * 继教考核详情查询
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryTeacherAssessInfo.do")
	public @ResponseBody Map<String, Object> queryTeacherAssessInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		try {
			Map<String,Object> paramMap = new HashMap<String,Object>();
//			Map<String,Object> paramMap = super.getCode(request);
			EduUserActivty u = super.getSessionUserInfo(request);
			paramMap.put("cityId", u.getUserCityId());
			paramMap.put("provinceId", u.getUserProvinceId());
			paramMap.put("teacherId", super.getAccountId(request));
			paramMap.put("year", request.getParameter("year"));
			List<EduTearcherAssess>  po = eduManageService.queryTeacherAssessInfo(paramMap);
			List<EduTearcherAssess>  po1 = eduManageService.queryTeacherAssessTarget(paramMap);
			List<EduTearcherAssess> po2 = eduManageService.queryTeacherAssessNoTrainInfo(paramMap);
			if(po != null && po.size()>0) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po);
				pageInfo.put("rows1", po1);
				pageInfo.put("rows3", po2);
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("继教考核详情查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	/**
	 * add by zhudi
	 *跳转到教师成绩查询
	 *@return  全部项目
	 */
	@RequestMapping(value = "toScoreQuery.htm")
	public String toScoreQuery(){
		return "furtheredu/scoreQuery";
	}
	
	/**
	 * 跳转到年度证书打印列表
	 * @author zxq
	 * @create date 2014-4-9
	 * @return
	 */
	@RequestMapping("toTeacherPrinterCertificatePage.htm")
	public String toTeacherPrinterCertificatePage(){
		return "furtheredu/teacherPrinterCertificate";
	}
	
	
	/**
	 * 批量打印证书
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping("batchPrinterCertificatePage.json")
	public String batchPrinterCertificatePage(HttpServletRequest request,HttpServletResponse response, ModelMap map){
		List<String> urls = new ArrayList<String>();
		/*根据选中的教师id加载证书信息*/
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String projectId = request.getParameter("projectId");
		String type = request.getParameter("type");
		List<EduDiploma> certificateInfos = new ArrayList<EduDiploma>();
		String[] teacherIds = request.getParameter("teacherIds").split(",");
		log.info("batchPrintePDFCertificate batchProduct start . . . . . . . " + teacherIds.length);
		EduUser user = new EduUser();
		for(int i=0;i<teacherIds.length;i++){
			String teacherId = teacherIds[i];
			try {
				user = userService.getUserById(teacherId);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			paramMap.put("projectId", StringUtils.isEmpty(projectId)|| "null".equals(projectId) ? null : projectId);
			paramMap.put("teacherId", StringUtils.isEmpty(teacherId)|| "null".equals(teacherId) ? null : teacherId);
			paramMap.put("type", "2");
			if(user != null){
				paramMap.put("name", user.getRealName());
			}
			Map<String,Object> result = new HashMap<String,Object>();
			try {
				//设置证书编号,二维码和学时和项目证书路径
				String baseImageUrl = "certificate/project_"+projectId+"/"+projectId+"_"+teacherId;
				paramMap.put("qrcodeUrl",baseImageUrl+"_QRCode.jpg" );
				log.info("batchPrintePDFCertificate single save qrcodeUrl start . . . . . . . " + teacherId);
				eduProjectService.updateTeacherProjectComment(paramMap);
				log.info("batchPrintePDFCertificate single save qrcodeUrl end . . . . . . . " + teacherId);
				//查询学员证书信息
				EduDiploma certificateInfo = eduManageService.queryDeploma(paramMap);
				certificateInfos.add(certificateInfo);
				String key = "fjyxtedu";
				String encryptIdNumber = DesTool.toHexString(DesTool.encrypt(user.getIdNumber(), key)).toUpperCase();
				
				String webPath = request.getSession().getServletContext().getRealPath("/");
				String basePath  = ApplicationProperties.getPropertyValue("eduHostPath");
				String imageServer = (webPath + ApplicationProperties.getPropertyValue("upload_file_path") + File.separator).replace("\\", "/");
				
				if(certificateInfo!=null){
					// 设置二维码信息
					String encoderContent = basePath+"/person/QRCode.do?idNumber="+encryptIdNumber+"&projectId="+projectId+"&type="+type;
					//设置项目证书(待区分)
					QRCodeUtil.encode(encoderContent, null, imageServer,projectId, teacherId,true);
					request.setAttribute("certificateInfos", certificateInfos);
				}else{
					result.put("success", false);
				}
					
			} catch (Exception e) {
				log.error("batchPrintePDFCertificate batchProduct ------ >"+e.getMessage()+e.toString());
				e.printStackTrace();
			}
		}
		log.info("batchPrintePDFCertificate batchProduct end . . . . . . . " + teacherIds.length);	
		request.setAttribute("urls", urls);
		request.setAttribute("count", urls.size());
		return "furtheredu/teacherPrintCommon";
	}
	
	/**
	 * 导出项目证书PDF
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping("batchPrintePDFCertificatePage.json")
	public String batchProductCertificate(HttpServletRequest request,HttpServletResponse response, ModelMap map){
		String commonUrl = request.getParameter("commonUrl");
		String eduHostPath = ApplicationProperties.getPropertyValue("pdfPath");
		String projectId = request.getParameter("projectId");
		String teacherIds = request.getParameter("teacherIds");
		String type = request.getParameter("type");
		log.info("batchPrintePDFCertificate transfer start . . . . . . . " + teacherIds);
		List<URL> urls = new ArrayList<URL>();
		try {
			URL url_refer = new URL(eduHostPath+commonUrl+"?projectId="+projectId+"&teacherIds="+teacherIds+"&type="+type);
			urls.add(url_refer);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			log.error("batchPrintePDFCertificate commonUrl ------ >"+e.getMessage()+e.toString());
			e.printStackTrace();
		} 
		request.setAttribute("urls", urls);
		try {
			ConverterPDF.runConverter(urls, "项目证书pdf文件","",request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("batchPrintePDFCertificate transfer ------ >"+e.getMessage()+e.toString());
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 跳转到教师打印项目证书
	 * @author zxq
	 * @create date 2014-4-9
	 * @return
	 */
	@RequestMapping("toPrinterCertificatePage.json")
	public String toPrinterCertificatePage(HttpServletRequest request,ModelMap map){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String projectId = request.getParameter("projectId");
		String teacherId = request.getParameter("teacherId");
		String type = request.getParameter("type");
		EduUser user = new EduUser();
		try {
			user = userService.getUserById(teacherId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		paramMap.put("projectId", StringUtils.isEmpty(projectId)|| "null".equals(projectId) ? null : projectId);
		paramMap.put("teacherId", StringUtils.isEmpty(teacherId)|| "null".equals(teacherId) ? null : teacherId);
		paramMap.put("type", type);
		if(user != null){
			paramMap.put("name", user.getRealName());
		}
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			//设置证书编号,二维码和学时和项目证书路径
			String baseImageUrl = "certificate/project_"+projectId+"/"+projectId+"_"+teacherId;
			paramMap.put("qrcodeUrl",baseImageUrl+"_QRCode.jpg" );
			eduProjectService.updateTeacherProjectComment(paramMap);
			//查询学员证书信息
			EduDiploma certificateInfo = eduManageService.queryDeploma(paramMap);
			String key = "fjyxtedu";
			String encryptIdNumber = DesTool.toHexString(DesTool.encrypt(user.getIdNumber(), key)).toUpperCase();
			
			String webPath = request.getSession().getServletContext().getRealPath("/");
			String basePath  = ApplicationProperties.getPropertyValue("eduHostPath");
			String imageServer = (webPath + ApplicationProperties.getPropertyValue("upload_file_path") + File.separator).replace("\\", "/");
			
			if(certificateInfo!=null){
				// 设置二维码信息
				String encoderContent = basePath+"/person/QRCode.do?idNumber="+encryptIdNumber+"&projectId="+projectId+"&type="+type;
				//设置项目证书(待区分)
				QRCodeUtil.encode(encoderContent, null, imageServer,projectId, teacherId,true);
				request.setAttribute("certificateInfo", certificateInfo);
			}else{
				result.put("success", false);
				result.put("obj", null);
			}
				
		} catch (Exception e) {
			log.error("查询证书失败--->"+e.getMessage()+e.toString());
			e.printStackTrace();
			result.put("success", false);
		}
		return "furtheredu/teacherPrintPreview";
	}
	
	/*
	 * 学员证书打印
	 */
	@RequestMapping("printePDFCertificate.json")
	public String singleProductCertificate(HttpServletRequest request,HttpServletResponse response, ModelMap map){
		String diplomaId = request.getParameter("diplomaId");
		String commonUrl = request.getParameter("commonUrl");
		String eduHostPath = ApplicationProperties.getPropertyValue("pdfPath");
		String projectId = request.getParameter("projectId");
		String teacherId = request.getParameter("teacherId");
		String teacherName = request.getParameter("teacherName");
		HttpSession session = request.getSession();
		EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
		if(teacherName == null){
			teacherName = info.getRealName();
		}
		if(teacherId == null){
			teacherId = String.valueOf(info.getUserId());
		}
		String type = request.getParameter("type");
		List<URL> urls = new ArrayList<URL>();
		try {
			URL url_refer = new URL(eduHostPath+commonUrl+"?projectId="+projectId+"&teacherId="+teacherId+"&type="+type+"&printPDF=true&diplomaId="+diplomaId);
			urls.add(url_refer);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		request.setAttribute("urls", urls);
		try {
			ConverterPDF.runConverter(urls, teacherName,projectId,request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 跳转到教师打印年度证书
	 * @author zd
	 * @create date 2017-5-10
	 * @return
	 */
	@RequestMapping("toPrinterYearCertificatePage.json")
	public String toPrinterYearCertificatePage(HttpServletRequest request,ModelMap map){
		String diplomaId = request.getParameter("diplomaId");
		String type = request.getParameter("type");
		String teacherId = request.getParameter("teacherId");
		EduUser user = new EduUser();
		try {
			user = userService.getUserById(teacherId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String teacherName = user.getRealName();
		try {
			//设置证书编号,二维码和学时和项目证书路径
			EduDiploma pojo = sysService.queryYearDeplomaById(Integer.parseInt(diplomaId), teacherName,Integer.parseInt(teacherId), type);
			pojo.setType(type);
			request.setAttribute("certificateInfo",pojo );
			String qrcodeUrl = "certificate/project_"+diplomaId+"/"+diplomaId+"_"+"QRCode.jpg";
			request.setAttribute("qrcodeUrl", qrcodeUrl);			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "furtheredu/teacherPrintPreview";
	}
	

	
	/**
	 * 证书预览
	 * add by zxq
	 * @param year                                    
	 * @return
	 */
	@RequestMapping("queryCertificateByYear.do")
	public @ResponseBody Map<String,Object> queryProjectClass(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String projectId = request.getParameter("projectId");
		String teacherId = request.getParameter("teacherId");
		String type = request.getParameter("type");
		EduUser user = new EduUser();
		try {
			user = userService.getUserById(teacherId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		paramMap.put("projectId", StringUtils.isEmpty(projectId)|| "null".equals(projectId) ? null : projectId);
		paramMap.put("teacherId", StringUtils.isEmpty(teacherId)|| "null".equals(teacherId) ? null : teacherId);
		paramMap.put("type", type);
		if(user != null){
			paramMap.put("name", user.getRealName());
		}
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			//设置证书编号,二维码和学时和项目证书路径
			String baseImageUrl = "certificate/project_"+projectId+"/"+projectId+"_"+teacherId;
			paramMap.put("qrcodeUrl",baseImageUrl+"_QRCode.jpg" );
			eduProjectService.updateTeacherProjectComment(paramMap);
			//查询学员证书信息
			//EduDiploma certificateInfo = eduManageService.queryTeacherCertificateInfo(paramMap);
			EduDiploma certificateInfo = eduManageService.queryDeploma(paramMap);
			String key = "fjyxtedu";
			String encryptIdNumber = DesTool.toHexString(DesTool.encrypt(user.getIdNumber(), key)).toUpperCase();
			
			String webPath = request.getSession().getServletContext().getRealPath("/");
			String basePath  = ApplicationProperties.getPropertyValue("eduHostPath");
			String imageServer = (webPath + ApplicationProperties.getPropertyValue("upload_file_path") + File.separator).replace("\\", "/");
			
			if(certificateInfo!=null){
				// 设置二维码信息
				String encoderContent = basePath+"/person/QRCode.do?idNumber="+encryptIdNumber+"&projectId="+projectId+"&type="+type;
				//设置项目证书(待区分)
				QRCodeUtil.encode(encoderContent, null, imageServer,projectId, teacherId,true);
				result.put("success", true);
				result.put("obj", certificateInfo);
				result.put("teacherId", teacherId);
			}else{
				result.put("success", false);
				result.put("obj", null);
			}
			
		} catch (Exception e) {
			log.error("查询证书失败--->"+e.getMessage()+e.toString());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	
	
	/**
	 * 跳转到教师项目证书打印页面
	 * @author 曉
	 * @return
	 */
	@RequestMapping("toTeacherProPrinterCertificatePage.htm")
	public String toTeacherProPrinterCertificatePage(){
		return "furtheredu/teacherProPrinterCertificate";
	}
	
	/**
	 * 跳转到教师项目证书打印页面
	 * @author 曉
	 * @return
	 */
	@RequestMapping("toProPrinterCertificateSetPage.htm")
	public String toProPrinterCertificateSetPage(HttpServletRequest request){
		String areaCode = request.getParameter("areaCode");
		return "furtheredu/teacherProCertificateSet";
	}
	
	/**
	 * 跳转到教师年度证书设置
	 * @author oreo-zhu
	 * @return
	 */
	@RequestMapping("toYearPrinterCertificateSetPage.htm")
	public String toYearPrinterCertificateSetPage(HttpServletRequest request){
		String areaCode = request.getParameter("areaCode");
		return "furtheredu/teacherYearCertificateSet";
	}
	
	
	/**
	 * 教师项目证书打印--查询已结束或已关闭的项目
	 * @author 曉
	 * @param paramMap
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryTeacherProByStatus.do")
	public @ResponseBody Map<String, Object> queryTeacherProByStatus(HttpServletRequest request){
		log.info("教师项目证书打印--查询已结束或已关闭的项目");
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String projectName = request.getParameter("projectName");
		String year = request.getParameter("year");
		String trainTypeId = request.getParameter("trainType");
		paramMap.put("projectName", projectName== null? null:projectName.equals("")?null:projectName);
		paramMap.put("year", year== null? null:year.equals("")?null:year);
		paramMap.put("trainTypeId", trainTypeId== null? null:trainTypeId.equals("")?null:trainTypeId);
		
		int teacherId = super.getAccountId(request);
		paramMap.put("teacherId", teacherId);
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<TeacherProActivity> list = eduManageService.queryTeacherProByStatus(paramMap);
			
			if(list != null && list.size() > 0) {
				result.put("success", true);
				result.put("rows",list);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("教师项目证书打印--查询已结束或已关闭的项目失败" + e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("toSignet.htm")
	public String toSignet(){
		return "furtheredu/toSignet";
	}
	
	
	/**
	 * 电子印章列表
	 */
	@RequestMapping("querySignetList.do")
	public @ResponseBody Map<String, Object> querySignetList(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String,Object> paramMap = this.getUserLocaltion(request);
			if(request.getParameter("flag")!=null && request.getParameter("flag").length()>0){
				paramMap.put("flag", request.getParameter("flag"));
			}
			Integer roleId = super.getRoleId(request);
			if(roleId!=null){
				paramMap.put("roleId", roleId);
			}
			paramMap.put("createBy", getAccount(request));
			
			List<EduSignet> list = eduManageService.querySignetListByDictAndRole(paramMap);
			
			if(list != null && list.size() > 0) {
				String accLog = super.getAccount(request);
				result.put("accLog",accLog);
				result.put("success", true);
				result.put("rows",list);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("电子印章查询失败" + e.getMessage());
		}
		return result;
	}
	

	/**
	 * 项目证书设置下项目列表/项目证书打印下项目列表
	 * @author 曉
	 * @param request
	 * @return
	 */
	@RequestMapping("queryProByStatus.do")
	public @ResponseBody Map<String, Object> queryProListBySS(HttpServletRequest request,Integer startIndex){
		log.info("查询项目证书设置/项目证书打印下项目列表");
		Map<String, Object> result = new HashMap<String, Object>();
		startIndex = (startIndex - 1) *10;
		String projectName = request.getParameter("projectName");
		String year = request.getParameter("year");
		String trainTypeId = request.getParameter("trainType");
		String proProperty = request.getParameter("projectProperty");
		String proScope = request.getParameter("projectScope");
		String print= request.getParameter("print");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("print", print);
		paramMap.put("projectName", projectName== null? null:projectName.equals("")?null:projectName);
		paramMap.put("year", year== null? null:year.equals("")?null:year);
		paramMap.put("trainTypeId", trainTypeId== null? null:trainTypeId.equals("")?null:trainTypeId);
		paramMap.put("proProperty", proProperty== null? null:proProperty.equals("")?null:proProperty);
		paramMap.put("proScope", proScope== null? null:proScope.equals("")?null:proScope);
		
		int roleId = super.getRoleId(request);
		if(roleId == 1 || roleId == 2 || roleId == 3){
//			paramMap.put("createByArea", super.getUserAreaId(request));
			paramMap.put("createById", super.getAccountId(request));
		}
		if(super.getOrganizationId(request) != null && !"".equals(super.getOrganizationId(request))){
//			paramMap.put("organizationId", super.getOrganizationId(request));
			paramMap.put("applyerId", super.getAccountId(request));
		}
		
		result.put("userAreaId", super.getUserAreaId(request));
		try {
			PageObject po = eduManageService.queryProByStatusPage(paramMap, startIndex, 10);
			result.put("total",po.getCount());
			result.put("rows",po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
//			if(list != null && list.size() > 0) {
//				result.put("success", true);
//				result.put("rows",list);
//			} else {
//				result.put("success", false);
//			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("实施/管理项目证书打印--查询已结束或已关闭的项目失败" + e.getMessage());
		}
		return result;
	}

	/**
	 * 上传电子印章
	 */
	@RequestMapping("saveSignet.do")
	public @ResponseBody Map<String, Object> saveSignet(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			EduUserActivty obj = super.getSessionUserInfo(request);
			EduSignet pojo = new EduSignet();
			pojo.setCreateBy(obj.getLoginAccount());
			pojo.setUpdateBy(obj.getLoginAccount());
			pojo.setRoleId(obj.getRoleId());
			pojo.setUserId(obj.getUserId());
			
			int roleId = obj.getRoleId().intValue();
			if(roleId == 1 || roleId == 7){
				pojo.setUserProvinceId(obj.getUserProvinceId());
			}else if(roleId == 2 || roleId == 8){
				pojo.setUserProvinceId(obj.getUserProvinceId());
				pojo.setUserCityId(obj.getUserCityId());
			}else if(roleId == 3 || roleId == 9){
				pojo.setUserProvinceId(obj.getUserProvinceId());
				pojo.setUserCityId(obj.getUserCityId());
				pojo.setUserDistrictId(obj.getUserDistrictId());
			}
			 
//			if(super.getUserProvinceId(request)!=null){
//				pojo.setUserProvinceId(super.getUserProvinceId(request));
//			}else{
//				pojo.setUserProvinceId(null);
//			}
//			if(super.getUserDistrictId(request)!=null){
//				pojo.setUserDistrictId(super.getUserDistrictId(request));
//			}else{
//				pojo.setUserDistrictId(null);
//			}
//			if(super.getUserCityId(request)!=null){
//				pojo.setUserCityId(super.getUserCityId(request));
//			}else{
//				pojo.setUserCityId(null);
//			}
			
			pojo.setFlag(1);
			pojo.setSignetName(request.getParameter("signetName"));
			pojo.setSignetUrl(request.getParameter("signetUrl"));
			//addSignet 改成了 addSignetNew ，新插入增加了角色id和用户id
		
			if(eduManageService.addSignetNew(pojo).intValue()!=-1) {
				result.put("success", true);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("电子印章查询失败" + e.getMessage());
		}
		return result;
	}
	
	/**
	 * 删除电子印章
	 */
	@RequestMapping("updateSignet.do")
	public @ResponseBody Map<String, Object> updateSignet(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			EduSignet pojo=new EduSignet();
			pojo.setUpdateBy(super.getRealName(request));
			pojo.setFlag(Integer.parseInt(request.getParameter("flag")));
			pojo.setId(Integer.parseInt(request.getParameter("id")));
			if(eduManageService.modifySignet(pojo).intValue()!=-1) {
				result.put("success", true);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("电子印章查询失败" + e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * 跳转到实施机构项目证书打印页面
	 * @author 曉
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("tossPrinterCertificatePage.htm")
	public String tossPrinterCertificatePage(Integer projectId) throws Exception{
		return "furtheredu/ssPrinterCertificateList";
	}
	
	/**
	 * 跳转到实施/管理查询项目下有成绩的参培教师-彻底解决乱码问题
	 * @author liuyiyou
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	@RequestMapping("toSSPrinterCertificatePage.htm")
	public String toSSPrinterCertificatePage(HttpServletRequest request, ModelMap map) throws NumberFormatException, Exception{
//		String proId = request.getParameter("proId");
//		EduProject  project = 	eduProjectService.queryProjectBaseInfoById(Integer.valueOf(proId));
//		map.put("proName", project.getProjectName());
		return "furtheredu/ssPrinterCertificate";
	}
	
	
	/**
	 * 项目证书打印某一项目下参训教师
	 * @author 曉
	 * @param pageIndex
	 * @param type
	 * @param request
	 * @return
	 */
	@RequestMapping("queryTeacherByProId.do")
	public @ResponseBody Map<String, Object> queryTeacherByProId(int pageIndex, int sizePerPage,HttpServletRequest request){
		log.info("项目证书打印某一项目下参训教师");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String proId = request.getParameter("proId");
		String teacherName = request.getParameter("teacherName");
		paramMap.put("teacherName", teacherName== null? null:teacherName.equals("")?null:teacherName);
		paramMap.put("proId", proId== null? null:proId.equals("")?null:proId);
		
		//此处用意不明且没有应用到sql查询中，暂时注释掉
		/*try {
			EduProject eduProject = eduProjectService.queryProjectBaseInfoById(new Integer(proId));
			if(eduProject.getProjectNo() != null){
				paramMap.put("projectNo",eduProject.getProjectNo());
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}*/
		Map<String, Object> result = new HashMap<String, Object>();
		sizePerPage = Common.PNN_USER_PAGE_LIMIT;
		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		pageIndex = (pageIndex - 1) * sizePerPage;
		try {
			PageObject po = eduManageService.queryTeacherByProId(paramMap, pageIndex, sizePerPage);
			EduProject eduProject = eduProjectService.queryProjectBaseInfoById(new Integer(proId));
			result.put("projectName", eduProject==null ? "" : eduProject.getProjectName());
			
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
			log.error("实施/管理项目证书打印--查询已结束或已关闭的项目下教师失败" + e.getMessage());
		}
		return result;
	}
	
	/**
	 * 项目证书查询
	 * 查询每个老师对应的证书
	 * */
	@RequestMapping("certificateQuery.htm")
	public String toCertificateQuery(ModelMap map, HttpServletRequest request) throws Exception{
		int roleId = super.getRoleId(request);
		if(roleId!=5){
			map.put("areaName", this.getCode(request).get("areaName"));
			map.put("areaId", this.getCode(request).get("areaId"));
			map.put("areaType", this.getCode(request).get("areaType"));
			
		}else{
			map.put("areaName", super.getSchoolName(request));
			map.put("areaId", super.getSchoolId(request));
			map.put("areaType", "schoolId"); 
		}
		return "furtheredu/certificateQuery";
	}
	
	/**
	 * 添加年度证书
	 * */
	@RequestMapping("addYearCertificate.htm")
	public String addYearCertificate(HttpServletRequest request) throws Exception{
		return "furtheredu/addYearCertificate";
	}
	
	/**
	 * 添加年度证书
	 * */
	@RequestMapping("toSearchCredit.htm")
	public String toSearchCredit(ModelMap map,HttpServletRequest request) throws Exception{
		map.put("areaName", this.getCode(request).get("areaName"));
		map.put("areaId", this.getCode(request).get("areaId"));
		map.put("areaType", this.getCode(request).get("areaType"));
		return "furtheredu/toSearchCredit";
	}
	
	/**
	 * 修改年度证书
	 * */
	@RequestMapping("updateYearCertificate.htm")
	public String updateYearCertificate(HttpServletRequest request) throws Exception{
		return "furtheredu/updateYearCertificate";
	}
	
	/**
	 * 证书查询下参训教师
	 */
	@RequestMapping("queryCertificateByTeacher.do")
	public @ResponseBody Map<String, Object> queryCertificateByTeacher(int pageIndex, int sizePerPage, HttpServletRequest request){
		log.info("证书查询参训教师");
		Map<String, Object> paramMap = super.getArea(request);
		
		String eduModelType = request.getParameter("queryModelType");
		String projectScope = request.getParameter("queryProjectScope");
		String idcard = request.getParameter("idcard");
		String teacherName = request.getParameter("teacherName");
		String projectName = request.getParameter("queryProjectName");
		String queryYearStart = request.getParameter("queryYearStart");
		String queryYearEnd = request.getParameter("queryYearEnd");
		String queryStatus = request.getParameter("queryStatus");
		String areaId = request.getParameter("areaId");
		String areaType = request.getParameter("areaType");
		
		paramMap.put("teacherName", teacherName== null? null:teacherName.equals("")?null:teacherName);
		paramMap.put("idCard", idcard== null? null:idcard.equals("")?null:idcard);
		paramMap.put("projectName", projectName);
		paramMap.put("queryYearStart", queryYearStart);
		paramMap.put("queryYearEnd", queryYearEnd);
		paramMap.put("queryStatus", queryStatus);
		paramMap.put("eduModelType", eduModelType);
		paramMap.put("projectScope", projectScope);
		
		//paramMap.put("organizationId", super.getOrganizationId(request));
		if(super.getRoleId(request) == 5){
			paramMap.put("idCard", super.getUserIdCard(request));
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
		
		Map<String, Object> result = new HashMap<String, Object>();
		pageIndex = (pageIndex - 1) * sizePerPage;
		try {
			PageObject po = eduManageService.queryTeacherCertificate(paramMap, pageIndex, sizePerPage);
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
			log.error("证书查询参训教师失败" + e.getMessage());
		}
		return result;
	}
	
	/**
	 * 导出教师证书
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "exportTeacherCertificateList.do")
	public void exportTeacherInforList(String queryConditionArray, String[] teacherArray, String[] fieldArray, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Map<String,Object> paramMap = super.getArea(request);
			
			String areaId = request.getParameter("areaId");
			String areaType = request.getParameter("areaType");
			
			// 页面查询条件
			if(!StringUtils.isEmpty(queryConditionArray)) {
				String[] conditionStr = mapper.readValue(queryConditionArray, String[].class);
				for(int i = 0; i < conditionStr.length; i++) {
					String[] temp = conditionStr[i].split("_");
					
					if(temp.length>1 && !StringUtils.isEmpty(temp[1])) {
						paramMap.put(temp[0], temp[1]);
					}
				}
			}
			
			if(super.getRoleId(request) == 5){
				paramMap.put("queryIdNumber", super.getUserIdCard(request));
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
			
			// 选中教师
			if(teacherArray!=null && teacherArray.length>0) {
				List<EduProjectComment> checkList = new ArrayList<EduProjectComment>();
				EduProjectComment pc = null;
				for(String str : teacherArray){
					pc = new EduProjectComment();
					pc.setTeacherId(Integer.parseInt(str.split("_")[0]));
					pc.setProjectId(Integer.parseInt(str.split("_")[1]));
					checkList.add(pc);
				}
				
				paramMap.put("checkList", checkList);
			}
			
			String path = request.getRealPath("/")+"template"+File.separator+"download_teacherCertificate.xls";
			FileInputStream io = new FileInputStream(path);
			// 创建 excel
			Workbook wb = new HSSFWorkbook(io);
			Sheet sheet = wb.getSheetAt(0);
			 
			// 创建单元格样式
			HSSFCellStyle cellStyle = (HSSFCellStyle) wb.createCellStyle();
			// 指定单元格居中对齐
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			// 指定单元格垂直居中对齐
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			// 指定当单元格内容显示不下时自动换行
			cellStyle.setWrapText(true);
			
			// 设置单元格字体
			HSSFFont font = (HSSFFont) wb.createFont();
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontName("宋体");
			font.setFontHeight((short) 230);
			cellStyle.setFont(font);
			
			//选中字段和表头索引相对应
			String[] fieldName = new String[fieldArray.length];
			
			//head表头赋值
			HSSFRow rowHead = (HSSFRow) sheet.createRow(0);
			HSSFCell rowHeadCell = null;
			for(int i=0; i<fieldArray.length; i++) {
				rowHeadCell = rowHead.createCell(i);
				rowHeadCell.setCellStyle(cellStyle);
				rowHeadCell.setCellValue(fieldArray[i].split("_")[0]);
				
				fieldName[i] = fieldArray[i].split("_")[1];
			}
			
			// 查询数据
			List<TeacherCertificateExportActivity> dataList = eduManageService.queryTeacherCertificateActivityListNoPage(paramMap);
			TeacherCertificateExportActivity certificate = null;
			log.debug(" query data . . . ");
			for (int i = 0; i < dataList.size(); i++) {
				 certificate = dataList.get(i);
				 
				 Row row = sheet.createRow(i + 1);
				 Field[] fields = certificate.getClass().getDeclaredFields();
				 
				 for(int j=0; j<fieldName.length; j++) {
					 fields[j].setAccessible(true);
					 String getMethodName = "get" + fieldName[j].substring(0, 1).toUpperCase() + fieldName[j].substring(1);
					 Class<? extends TeacherCertificateExportActivity> tc = certificate.getClass();
					 Method getMethod = tc.getMethod(getMethodName, new Class[] {});
	                 //获取遍历对象的属性
	                 Object value = getMethod.invoke(certificate, new Object[] {});
	                 
	                 Cell cell = row.createCell(j);
	                 cell.setCellValue(value == null ? "" : value.toString());
				 }
			}
			log.debug(" start export data . . . ");
			exportExcelFromTemplet(request, response, wb, "downLoad_teacherCertificate");
			log.debug(" end export data . . . ");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师证书信息导出错误:" + e);
		}
	}
	
	/**
	 * 新增年度证书
	 */
	@RequestMapping("addYearCertificate.do")
	public @ResponseBody  Map<String,Object> addYearCertificate(
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		Map<String,Object> condition = super.getCode(request);
		String year = request.getParameter("year"); 
		String diplomaStartDate = request.getParameter("diplomaStartDate"); 
		String diplomaEndDate = request.getParameter("diplomaEndDate"); 
		String repayRate = request.getParameter("repayRate"); 

		String creditStr = request.getParameter("creditStr"); 
		String periodStr = request.getParameter("periodStr"); 
		String[] credit = creditStr.split(",");//1-1,2-2,4-3,
		String[] period = periodStr.split(",");//1-1,2-2,4-3,

		float diplomaCredit = 0;
		float diplomaPeriod = 0;
		for(int i = 0 ; i < credit.length ; i++){
			Float  c_num  = Float.parseFloat(credit[i].split("-")[1]);
			Float  p_num  = Float.parseFloat(period[i].split("-")[1]);
			diplomaCredit += c_num;
			diplomaPeriod += p_num;
		}
		
		
		String title = request.getParameter("diplomaTitle"); 
		/**
		 * 设置年度证书前置编码
		 * PX + 年份
		 */
		String projectPrefixCode = "PX"+year;
		
		HttpSession session = request.getSession();
		EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
		
		condition.put("year", year);
		condition.put("startDate", diplomaStartDate);
		condition.put("endDate", diplomaEndDate);
		condition.put("needCredit", diplomaCredit);
		condition.put("needPeriod", diplomaPeriod);
		condition.put("needCredit1", creditStr.substring(0, creditStr.lastIndexOf(',')));
		condition.put("needPeriod1", periodStr.substring(0, periodStr.lastIndexOf(',')));
		condition.put("repayRate", Float.parseFloat(repayRate));
		condition.put("createBy", info.getRealName());
		condition.put("content",  project.common.Common.getYearCertifacte());
		condition.put("title", title);
		condition.put("status", 0);
		condition.put("positionRight", 630);
		condition.put("positionTop", 450);
		condition.put("positionWidth", 148);
		condition.put("positionHeight", 148);
		condition.put("qrcodeRight", 170);
		condition.put("qrcodeTop", 480);
		condition.put("qrcodeWidth", 100);
		condition.put("qrcodeHeight", 100);
		condition.put("projectPrefixCode", projectPrefixCode);
		
		
		
		if(eduManageService.selectYearDiploma(condition).size() > 0){
			result.put("success", false);
			result.put("message", year+"年度证书已经存在");
		}else{
			if (eduManageService.insertYearCertificate(condition) != -1) {
				result.put("success", true);
			} else {
				result.put("success", false);
				result.put("message", "年度证书保存失败");
			}
		}
		return result;
	}
	
	
	/**
	 * 查询年度证书
	 */
	@RequestMapping("queryYearCertificateList.do")
	public @ResponseBody  Map<String,Object> queryYearCertificateList(
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		Map<String,Object> condition = super.getCode(request);
		String year = request.getParameter("year"); 
		String id = request.getParameter("id"); //查询单个证书信息使用
		String code = "";
		if(getRoleId(request) == 1){
			code = getUserProvinceId(request);
		}else if(getRoleId(request) == 2){
			code = getUserCityId(request);
		}else{
			code = getUserDistrictId(request);
		}
		SysArea area = sysService.selectAreaByCode(code);
		condition.put("year", year);
		condition.put("id", id);
		List<EduDiploma> list = eduManageService.selectYearDiploma(condition);
		if(Common.DIRECT_UNIT.contains(String.valueOf(getSchoolId(request))) && area.getAreaCode().equals("220802")){
			for(EduDiploma e : list){
				e.setNeedCredit1("远程培训-"+e.getNeedPeriod() * 0.7);
			}
		}
		
		if(id != null && list.size() > 0){
			result.put("obj", list.get(0));
			result.put("success", true);
		}
		result.put("rows", list);

		
		
		
		return result;
	}
	
	/**
	 * 删除年度证书
	 */
	@RequestMapping("yearCertificateDelete.do")
	public @ResponseBody  Map<String,Object> yearCertificateDelete(
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		Map<String,Object> condition = super.getCode(request);
		String id = request.getParameter("id"); 
		
		condition.put("id", id);
		if(eduManageService.deleteCertificateById(condition)){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		
		
		return result;
	}
	
	/**
	 * 修改年度证书
	 */
	@RequestMapping("updateYearCertificate.do")
	public @ResponseBody  Map<String,Object> updateYearCertificate(
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		Map<String,Object> condition = super.getCode(request);
		String id = request.getParameter("id"); 
		String year = request.getParameter("year"); 
		String diplomaStartDate = request.getParameter("diplomaStartDate"); 
		String diplomaEndDate = request.getParameter("diplomaEndDate"); 
		String repayRate = request.getParameter("repayRate"); 

		String creditStr = request.getParameter("creditStr"); 
		String periodStr = request.getParameter("periodStr"); 
		String[] credit = creditStr.split(",");//1-1,2-2,4-3,
		String[] period = periodStr.split(",");//1-1,2-2,4-3,

		float diplomaCredit = 0;
		float diplomaPeriod = 0;
		for(int i = 0 ; i < credit.length ; i++){
			Float  c_num  = Float.parseFloat(credit[i].split("-")[1]);
			Float  p_num  = Float.parseFloat(period[i].split("-")[1]);
			diplomaCredit += c_num;
			diplomaPeriod += p_num;
		}
		
		String title = request.getParameter("diplomaTitle"); 
		HttpSession session = request.getSession();
		EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
		condition.put("year", year);
		condition.put("startDate", diplomaStartDate);
		condition.put("endDate", diplomaEndDate);		
		condition.put("title", title);
		condition.put("needCredit", diplomaCredit);
		condition.put("needPeriod", diplomaPeriod);
		condition.put("needCredit1", creditStr.substring(0, creditStr.lastIndexOf(',')));
		condition.put("needPeriod1", periodStr.substring(0, periodStr.lastIndexOf(',')));
		condition.put("repayRate", Float.parseFloat(repayRate));
		condition.put("createBy", info.getRealName());
		List<EduDiploma> list = eduManageService.selectYearDiploma(condition);
		if(list.size() > 0 && list.get(0).getId() != Integer.parseInt(id)){
			result.put("success", false);
			result.put("message", year+"年度证书已经存在");
		}else{
			condition.put("id", id);
			if (eduManageService.updateYearCertificate(condition) != -1) {
				result.put("success", true);
			} else {
				result.put("success", false);
				result.put("message", "年度证书修改失败");
			}
		}
		return result;
	}
	
	/**
	 * 学分查询
	 */
	@RequestMapping("queryCreditList.do")
	public @ResponseBody  Map<String,Object> queryCreditList(
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		Map<String,Object> condition = super.getCode(request);
		
		if (!StringUtils.isEmpty(request.getParameter("idNumber"))) {
			condition.put("idNumber", request.getParameter("idNumber").trim());
		}
		if (!StringUtils.isEmpty(request.getParameter("teacherName"))) {
			condition.put("teacherName", request.getParameter("teacherName").trim());
		}
		if (!StringUtils.isEmpty(request.getParameter("schoolName"))) {
			condition.put("schoolName", request.getParameter("schoolName").trim());
		}
		if (!StringUtils.isEmpty(request.getParameter("queryYear"))) {
			condition.put("startYear", request.getParameter("queryYear").trim() + "-01-01");
			condition.put("endYear", (Integer.parseInt(request.getParameter("queryYear").trim()) + 1) + "-01-01");
		}
		int startIndex = Integer.parseInt(request.getParameter("startIndex"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		if(!StringUtils.isEmpty(request.getParameter("areaId")) && !StringUtils.isEmpty(request.getParameter("areaType"))){
			if(request.getParameter("areaType").equals("provinceId")){
				condition.put("provinceId", request.getParameter("areaId"));
			}else if(request.getParameter("areaType").equals("cityId")){
				condition.put("cityId", request.getParameter("areaId"));
			}else if(request.getParameter("areaType").equals("districtId")){
				condition.put("districtId", request.getParameter("areaId"));
			}else if(request.getParameter("areaType").equals("schoolId")){
				condition.put("schoolId", request.getParameter("areaId"));
			}	
		}
		condition.put("proviceName", getUserProvinceName(request));
		condition.put("cityName", getUserCityName(request));
		condition.put("districtName", getUserDistrictName(request));
		
		startIndex = (startIndex - 1) * pageSize;
		PageObject pageList = sysService.getTeacherTrainCreditPage(condition, startIndex, pageSize);
		
		List<EduTeacherScoreInfo> list = (List<EduTeacherScoreInfo>) pageList.getObjects();
		List<EduTeacherScoreInfo> rows = new ArrayList<EduTeacherScoreInfo>();
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("year", request.getParameter("queryYear").trim());
		for(EduTeacherScoreInfo ets : list){
			Map<String,Float> studyMap = new HashMap<String,Float>();
			Map<String,Float> remainMap = new HashMap<String,Float>();
			if(!ets.getScore1().equals("")){//网络研修=45.0,校本研修=30.0,集中研修=37.0
				String score[] = ets.getScore1().split(",");
				for(String s : score){
					studyMap.put(s.split("=")[0], Float.parseFloat(s.split("=")[1]));
				}
			}
			float isCredit = teacherReadDao.queryTeacherIndeptStudyCredit(params);
			ets.setTotalScore(String.valueOf(Float.parseFloat(ets.getTotalScore()) + isCredit));
			
			for(SysDictionary form : getTrainForm()){
				if(form.getDictionaryId() == 5){//将自主研修加入进去
					studyMap.put(form.getDictionaryName(), isCredit);
				}
				if(!studyMap.containsKey(form.getDictionaryName())){
					studyMap.put(form.getDictionaryName(), (float)0);
				}
				float remain = getRemain(Integer.parseInt(request.getParameter("queryYear")) - 1, ets.getTeacherId(), form.getDictionaryId(),request);
				remainMap.put(form.getDictionaryName(), dorounded(remain));
				
			}
			ets.setRemainCredit(remainMap.toString().substring(1,remainMap.toString().length() - 1));
			ets.setScore1(studyMap.toString().substring(1,studyMap.toString().length() - 1));
			rows.add(ets);
		}
		
		
		result.put("rows", rows);
		result.put("total", pageList.getCount());
		result.put("pageSize", pageList.getPagesize());
		result.put("pages", pageList.getPages());
		result.put("currentPage", pageList.getCurrentPage());
		result.put("pageNumbers", pageList.getPageNumbers());
		result.put("startIndex", pageList.getStartIndex());
		
		return result;
	}
	
	//导出教师学分
		@RequestMapping("exportTeacherCredit.do")
		public @ResponseBody Map<String, Object> exportTeacherCredit(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> result = new HashMap<String, Object>();
			try {
				String teacherIds = request.getParameter("teacherIds");
				String idNumber = request.getParameter("idNumber");
				String teacherName = request.getParameter("teacherName");
				String schoolName = request.getParameter("schoolName");
				String areaId = request.getParameter("areaId");
				String areaType = request.getParameter("areaType");
				String queryYear = request.getParameter("queryYear");
				int sizePerPage = Integer.parseInt(request.getParameter("sizePerPage"));
				int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
				

				Map<String,Object> paramMap = getCode(request);
				if(!StringUtils.isEmpty(teacherIds)) {
					paramMap.put("teacherIds", teacherIds.trim());
				}
				
				if(!StringUtils.isEmpty(idNumber)) {
					paramMap.put("idNumber", idNumber.trim());
				}
				
				if (!StringUtils.isEmpty(teacherName)) {
					paramMap.put("teacherName", teacherName.trim());
				}
				
				if (!StringUtils.isEmpty(schoolName)) {
					paramMap.put("schoolName", schoolName.trim());
				}
				if (!StringUtils.isEmpty(queryYear)) {
					paramMap.put("startYear", queryYear + "-01-01");
					paramMap.put("endYear", (Integer.parseInt(queryYear) + 1) + "-01-01");
				}
				
				if(!StringUtils.isEmpty(areaId) && !StringUtils.isEmpty(areaType)){
					if(areaType.equals("provinceId")){
						paramMap.put("provinceId", areaId);
					}else if(areaType.equals("cityId")){
						paramMap.put("cityId", areaId);
					}else if(areaType.equals("districtId")){
						paramMap.put("districtId", areaId);
					}else if(areaType.equals("schoolId")){
						paramMap.put("schoolId", areaId);
					}	
				}
				
				if(teacherIds == "" || teacherIds == null){//未选中任意选框，查询所有
					paramMap.put("queryAll", "true");
				}
				
				
				// 2查询分页数据
				pageIndex = (pageIndex - 1) * sizePerPage;
				PageObject pageList = sysService.getTeacherTrainCreditPage(paramMap, pageIndex, sizePerPage);
				List<EduTeacherScoreInfo> list = (List<EduTeacherScoreInfo>) pageList.getObjects();
				List<EduTeacherScoreInfo> rows = new ArrayList<EduTeacherScoreInfo>();
				
				
				
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("year", request.getParameter("queryYear").trim());
			for(EduTeacherScoreInfo ets : list){
					Map<String,Float> remainMap = new HashMap<String,Float>();
					Map<String,Float> studyMap = new TreeMap<String,Float>();
					if(!ets.getScore1().equals("")){
						String score[] = ets.getScore1().split(",");
						for(String s : score){
							studyMap.put(s.split("=")[0], Float.parseFloat(s.split("=")[1]));
						}
					}
					float isCredit = teacherReadDao.queryTeacherIndeptStudyCredit(params);
					ets.setTotalScore(String.valueOf(Float.parseFloat(ets.getTotalScore()) + isCredit));
					for(SysDictionary form : getTrainForm()){
						if(form.getDictionaryId() == 5){//将自主研修加入进去
							studyMap.put(form.getDictionaryName(), isCredit);
						}
						if(!studyMap.containsKey(form.getDictionaryName())){
							studyMap.put(form.getDictionaryName(), (float)0);
						}
						float remain = getRemain(Integer.parseInt(queryYear) - 1, ets.getTeacherId(), form.getDictionaryId(),request);
						remainMap.put(form.getDictionaryName(), remain);
					}
					ets.setScore1(studyMap.toString().substring(1,studyMap.toString().length() - 1));
					ets.setRemainCredit(remainMap.toString().substring(1,remainMap.toString().length() - 1));
					rows.add(ets);
				}
				
				 String path = request.getRealPath("/")+"template"+File.separator+"download_teacher_score.xls";
				 
				 FileInputStream io = new FileInputStream(path);
				 // 创建 excel
				 Workbook wb = new HSSFWorkbook(io);
				 
				 Sheet sheet = wb.getSheetAt(0);
				 for (int i = 0; i < rows.size(); i++) {
					 Row row = sheet.createRow(i + 1);
					 Cell cellA = row.createCell(0);
					 cellA.setCellValue(rows.get(i).getTeacherName());
					 
					 Cell cellB = row.createCell(1);
					 cellB.setCellValue(rows.get(i).getSchoolName());
					 
					 Cell cellC = row.createCell(2);
					 cellC.setCellValue(rows.get(i).getIdNumber());
					 
					 Cell cellD = row.createCell(3);
					 cellD.setCellValue(queryYear == null ? "" : queryYear);

					 Cell cellE = row.createCell(4);
					 cellE.setCellValue(rows.get(i).getRemainCredit() == null || rows.get(i).getRemainCredit() == ""? "无结余" : rows.get(i).getRemainCredit());

					 Cell cellF = row.createCell(5);
					 cellF.setCellValue(rows.get(i).getTotalScore());

					 Cell cellG = row.createCell(6);
					 cellG.setCellValue(rows.get(i).getScore1());
					 
				 }
				 
				 exportExcelFromTemplet(request, response, wb, "download_teacher_score");

				 
			} catch (Exception e) {
				e.printStackTrace();
				log.error("教师学分导出错误:" + e);
			}
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
		 * 
		 * @param year 查询年限结余年限
		 * @return 
		 * @throws Exception 
		 */
		public float getRemain(int year,int teacherId,int trainFormId,HttpServletRequest request) throws Exception{
			//
			String code = "";
			if(getRoleId(request) == 1){
				code = getUserProvinceId(request);
			}else if(getRoleId(request) == 2){
				code = getUserCityId(request);
			}else{
				code = getUserDistrictId(request);
			}
			SysArea area = sysService.selectAreaByCode(code);
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
					if(Common.AUTO_CREDIT_lEND.contains(area.getAreaCode())){
						if(trainFormId == 5){
							getCredit = getCredit > 4 ? 4 : getCredit;
						}else if(trainFormId == 4){
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
