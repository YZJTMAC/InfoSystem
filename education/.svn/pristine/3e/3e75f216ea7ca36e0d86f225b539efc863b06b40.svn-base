package project.furtheredu.certificate.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.dictionary.service.IDictionaryService;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduProjectNotrain;
import project.edupm.projectmanage.service.IEduProjectService;
import project.fileupload.service.IFileUploadService;
import project.furtheredu.certificate.pojo.EduDiploma;
import project.furtheredu.edumanage.service.IEduManageService;
import project.furtheredu.edumanage.service.IEduStatisticModelService;
import project.furtheredu.edumanage.service.IEduStatisticYearService;
import project.organization.pojo.Organization;
import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;
import project.person.service.IUserService;
import project.system.pojo.EduSchool;
import project.system.pojo.SysArea;
import project.system.pojo.SysDictionary;
import project.system.service.ISysSchoolService;
import project.system.service.ISysService;
import project.util.ApplicationProperties;
import project.util.certificate.ConverterPDF;
import project.util.qrcodetool.QRCodeUtil;
import framelib.common.Common;
import framelib.controller.AbsController;
import framelib.utils.page.PageObject;

/**
 * 
 * 证书控制器
 * @Create_by:dengguo
 * @Create_date:2014-1-8
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 * 
 */

@Controller
@RequestMapping("/furtheredu/certificate") 
public class CertificateController extends AbsController{
	private static final Logger log = Logger.getLogger(CertificateController.class);
	
	@Autowired
	@Qualifier("userService")
	IUserService userService;
	
	@Autowired
	@Qualifier("sysService")
	ISysService sysService;
	
	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;
	
	@Autowired
	@Qualifier("schoolService")
	ISysSchoolService schoolService;
	
	@Autowired
	@Qualifier("eduStatisticModelService")
	IEduStatisticModelService eduStatisticModelService;
	
	
	@Autowired
	@Qualifier("eduStatisticYearService")
	IEduStatisticYearService eduStatisticYearService;
	
	@Autowired
	@Qualifier("dictionaryService")
	IDictionaryService dictionaryService;
	
	@Autowired
	@Qualifier("fileUploadService")
	IFileUploadService fileUploadService;

	@Autowired
	@Qualifier("eduManageService")
	IEduManageService eduManageService;
	
	/**
	 * 跳转到学时证书设置页面
	 * @param map
	 * @param id
	 * @param projectId
	 * @param click
	 * @return
	@RequestMapping("periodCertificateSetPage.htm")
	public String periodCertificateSetPage(ModelMap map, String id, String projectId, String click){
		map.put("id", id);
		map.put("projectId", projectId);
		map.put("click", click);
		return "furtheredu/periodCertificateSet";
	}*/
	
	/**
	 * 跳转年度年度证书模板设置页面
	 */
	@RequestMapping(value = "certificateListPage.htm")
	public String certificateListPage(ModelMap map) {
		return "furtheredu/certificateList";
	}
	
	/**
	 * 跳转到项目证书设置页面
	 */
	@RequestMapping(value = "certificateAddPage.htm")
	public String certificateAddPage(ModelMap map, String id, String projectId, String click, String type,HttpServletRequest request,HttpServletResponse response) {
		map.put("id", id);
		map.put("projectId", projectId);
		map.put("click", click);
		map.put("type", type);// 证书类型   
		try {
			
			EduProject eduProject = eduProjectService.queryProjectBaseInfoById(new Integer(projectId));
			Organization orgInfo = sysService.selectOrganizationInfoById(eduProject.getOrganizationId());
			//获取项目编号
			SysArea area = sysService.selectAreaByCode(eduProject.getTrainScopeId());
			// 地区代码
			map.put("areaCode", area.getAreaCode());
			Map<String,Object> dictionaryMap = new HashMap<String, Object>();
			dictionaryMap.put("dictionaryName", eduProject.getProjectPropertyName());//字典名称
			dictionaryMap.put("dictionaryId", eduProject.getProjectPropertyId());//字典Id
			dictionaryMap.put("status", 1);//状态		
			//查询字典信息
			SysDictionary sysDictionary = dictionaryService.selectSysDictionaryInfo(dictionaryMap);
			//培训级别代码
			String projectTrainTypeCode = sysDictionary.getDictionaryCode();
			
			//年份代码
			String yearCode = eduProject.getYear().toString();
			map.put("yearCode", yearCode.substring(yearCode.length()-2, yearCode.length()));
			//培训级别
			if(eduProject.getProjectScopeId() == 1){
				map.put("projectScopeCode", "GP");
			}
			else if(eduProject.getProjectScopeId() == 2){
				map.put("projectScopeCode", "SP");
			}
			else if(eduProject.getProjectScopeId() == 3){
				map.put("projectScopeCode", "DP");
			}
			else if(eduProject.getProjectScopeId() == 4){
				map.put("projectScopeCode", "XP");
			}
			else if(eduProject.getProjectScopeId() == 5){
				map.put("projectScopeCode", "XB");
			}
			else{
				map.put("projectScopeCode", "OP");
			}
			
			//培训类型代码
			map.put("projectTrainTypeCode", projectTrainTypeCode);
			//机构代码
			map.put("orgCode", orgInfo.getOrgCode());
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(type.equals("2") || type.equals("1")){// 项目/年度证书设置
			return "furtheredu/certificateAdd";
//		} 
		
//		else if(type.equals("3")){// 学时证书设置
//			return "furtheredu/periodCertificateSet";
//		}
//		return null;
	}
	
	/**
	 * 跳转到年度证书设置页面
	 */
	@RequestMapping(value = "yearCertificateAddPage.htm")
	public String yearCertificateAddPage(HttpServletRequest request,HttpServletResponse response) {
		String id = request.getParameter("id");
			return "furtheredu/yearCertificateAdd";
	}
	
	/**
	 * 证书预览打印
	 */
	@RequestMapping(value = "certificateShowPage.json")
	public String certificateShowPage(HttpServletRequest request,HttpServletResponse response,ModelMap map, Integer id, String projectId, String type) {
		map.put("id", id);
		map.put("projectId", projectId);
		map.put("type", type);
		//是否保存标识 0为保存状态 1为 查询状态
		String certificateView = request.getParameter("certificateView");
		String webPath = request.getSession().getServletContext().getRealPath("/");
		String basePath  = ApplicationProperties.getPropertyValue("eduHostPath");
		String imageServer = (webPath + ApplicationProperties.getPropertyValue("upload_file_path") + File.separator).replace("\\", "/");
		
		try {
			EduDiploma pojo = sysService.queryDeplomaById(id, projectId, type,certificateView);
			//获得域名				
			String encoderContent = basePath+"/person/QRCode.do?projectId="+projectId+"&type="+type;
			QRCodeUtil.encode(encoderContent, null, imageServer,projectId,null, true);
			if(!type.equals("1")){
				EduProject eduProject = eduProjectService.queryProjectBaseInfoById(new Integer(projectId));
				String trainScopeId = eduProject.getTrainScopeId();
				SysArea area = sysService.selectAreaByCode(trainScopeId);
				map.addAttribute("areaCode", area.getAreaCode());
			}
			
			String qrcodeUrl = "certificate/project_"+projectId+"/"+projectId+"_"+"QRCode.jpg";
			request.setAttribute("qrcodeUrl", qrcodeUrl);
			
			if(pojo != null) {
				request.setAttribute("obj", pojo);
			} else {
				//项目证书、年度证书默认模板
				if(type.equals("1") || type.equals("2")){
					request.setAttribute("obj", project.common.Common.getDefaultCertifacte());
				}
				else if(type.equals("3")){
					request.setAttribute("obj", project.common.Common.getDefaultPeriodCertifacte());
				}
			}
			
		} catch (Exception e) {
			log.error("查询证书失败--->"+e.getMessage()+e.toString());
			e.printStackTrace();
		}
		
		return "furtheredu/certificatePrint";
	}
	
	/*
	 * 学员证书设置PDF下载预览
	 */
	@RequestMapping("printePDFCertificateSet.json")
	public String singleProductCertificate(HttpServletRequest request,HttpServletResponse response, ModelMap map){
		String pdfPath = ApplicationProperties.getPropertyValue("pdfPath");
		String id = request.getParameter("diplomaId");
		String commonUrl = request.getParameter("commonUrl");
		String projectId = request.getParameter("projectId");
		String projectName = request.getParameter("projectName");
		String type = request.getParameter("type");
		List<URL> urls = new ArrayList<URL>();
		try {
			URL url_refer = null;
			if("1".equals(type)){
				url_refer = new URL(pdfPath+commonUrl+"?id="+id+"&type="+type+"&certificateView=1");
			}else{
				url_refer = new URL(pdfPath+commonUrl+"?projectId="+projectId+"&type="+type+"&certificateView=1");
			}
			
			urls.add(url_refer);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		request.setAttribute("urls", urls);
		try {
			ConverterPDF.runConverter(urls, projectName,projectId,request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 学分登记首页
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "creditEnterListPage.htm")
	public String creditEnterListPage(ModelMap map, String id) {
		map.put("id", id);
		return "furtheredu/creditEnterList";
	}
	
	/**
	 * 非培训类学分登记
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "creditEnterNoTrainPage.htm")
	public String creditEnterNoTrainPage(ModelMap map, String id) {
		map.put("id", id);
		return "furtheredu/creditEnterNoTrain";
	}
	
	/**
	 * 校本学分登记
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "creditEnterSchoolPage.htm")
	public String creditEnterSchoolPage(ModelMap map, String id) {
		map.put("id", id);
		return "furtheredu/creditEnterSchool";
	}
	 
			
	
	/**
	 * 学分审核
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "creditAudtitListPage.htm")
	public String creditAudtitListPage(ModelMap map,/* String id,*/HttpServletRequest request) {
		map.put("areaId", super.getUserAreaId(request));
		return "furtheredu/creditAuditList";
	}
 
	/**
	 * 非培训类学分审核
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "creditAuditNoTrainPage.htm")
	public String creditAuditNoTrainPage(ModelMap map, String id) {
		map.put("id", id);
		return "furtheredu/creditAuditNoTrain";
	}
	
	/**
	 * 培训类学分审核
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "creditAuditTrainPage.htm")
	public String creditAuditTrain(ModelMap map, /*String id,*/ HttpServletRequest request) {
//		map.put("id", id);
		map.put("areaName", this.getCode(request).get("areaName"));
		map.put("areaId", this.getCode(request).get("areaId"));
		map.put("areaType", this.getCode(request).get("areaType"));
		return "furtheredu/creditAuditTrain";
	}
	 
	
	/**
	 * 年度证书模板列表
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryCertificateList.do")
	public @ResponseBody Map<String, Object> queryCertificateList(String queryYear, int pageIndex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		Map<String,Object> paramMap = this.getUserLocaltion(request);
		if(!StringUtils.isEmpty(queryYear)) {
			paramMap.put("queryYear", queryYear);
		}
		 
		try {
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
			if(!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}
			pageIndex = (pageIndex - 1) * sizePerPage;
			
			// 2查询分页数据
			PageObject po = sysService.queryDeplomaListPage(paramMap, pageIndex, sizePerPage);
			if(po != null && po.getCount() > 0) {
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
			log.error("证书查询错误:" + e);
		}
		return pageInfo;
	}
	
	/**
	 * 保存证书设置
	 * */
	@RequestMapping(value = "addCertificate.do")
	public @ResponseBody
	Map<String, Object> addCertificate(String data, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		String oldProjectCode = request.getParameter("oldProjectCode");
		try {
			EduDiploma pojo = mapper.readValue(data, EduDiploma.class);
			Set<String> ProjectCodes = new HashSet<String>(); 
			/*学员证书编号重复校验暂取消,确定业务后重新修改*/
			/*List<EduDiploma> EduDiplomas = sysService.queryAllProjectDeploma();
			for (EduDiploma eduDiploma : EduDiplomas) {
				if((!"".equals(eduDiploma.getProjectCode()) && eduDiploma.getProjectCode() != null ) || !oldProjectCode.equals(pojo.getProjectCode())){
					ProjectCodes.add(eduDiploma.getProjectCode());
				}
			}*/
			StringBuilder projectCode= new StringBuilder();
			
			if(pojo.getIsProjectPrefix().equals("1")){
				projectCode.append(pojo.getProjectPrefix());
			}
			if (pojo.getIsAreaCode().equals("1")) {
				projectCode.append(pojo.getAreaCode());
			}
			if (pojo.getIsYearCode().equals("1")) {
				projectCode.append(pojo.getYearCode());
			}
			if (pojo.getIsProjectScopeCode().equals("1")) {
				projectCode.append(pojo.getProjectScopeCode());
			}
			if (pojo.getIsProjectTrainTypeCode().equals("1")) {
				projectCode.append(pojo.getProjectTrainTypeCode());
			}
			if (pojo.getIsOrgCode().equals("1")) {
				projectCode.append(pojo.getOrgCode());
			}
			pojo.setProjectCode(projectCode.toString());			
			if (pojo != null) {
				if(pojo.getProjectId() != null) {
					pojo.setYear(null);
				}
				pojo.setCreateBy(getAccount(request));
				pojo.setUpdateBy(getAccount(request));
				pojo.setCreateDate(new Date());
				pojo.setUpdateDate(new Date());
			}
			if(oldProjectCode.equals(pojo.getProjectCode()) || !ProjectCodes.contains(pojo.getProjectCode())){
				
				Integer userId = -1;
				if(pojo.getId() != null ) {
					userId = sysService.modifyCertificate(pojo);
				} else {
					pojo.setStatus(project.common.Common.DATA_VALID);
					userId = sysService.saveCertificate(pojo);
				}
				
				//批量设置学员证书编号
				param.put("projectId", pojo.getProjectId());
				if("2".equals(pojo.getType())){
					param.put("certificateProjectCode", pojo.getProjectCode());
				}else if("3".equals(pojo.getType())){
					param.put("certificatePeriodCode", pojo.getProjectCode());
				}
				if(oldProjectCode == null || !oldProjectCode.equals(pojo.getProjectCode())){
					eduProjectService.updateProjectCertificateAll(param);
				}
				if (userId != null && userId.intValue() >= 0) {
					result.put("success", true);
					result.put("userId", userId);
				} else {
					result.put("success", false);
				}
			}else {
				result.put("success", false);
				result.put("msg", "-1");
			}
		} 
		catch (Exception e) {
			log.error("保存  证书 表失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	
	@RequestMapping(value = "deleteCertificate.do")
	public @ResponseBody
	Map<String, Object> removeCertificate(Integer id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer eduJobId = sysService.removeDeplomaById(id);
			if (eduJobId != null && eduJobId.intValue() >= 0) {
				result.put("success", true);
				result.put("eduJobId", eduJobId);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			log.error("保存  删除失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}

	/**
	 * 查询证书模板
	 * */
	@RequestMapping("queryCertificate.do")
	public @ResponseBody Map<String,Object> queryProjectClass(HttpServletRequest request,Integer id, String projectId, String type,String certificateView,Model model){
		Map<String,Object> result = new HashMap<String,Object>();
		String webPath = request.getSession().getServletContext().getRealPath("/");
		String basePath  = ApplicationProperties.getPropertyValue("eduHostPath");
		String imageServer = (webPath + ApplicationProperties.getPropertyValue("upload_file_path") + File.separator).replace("\\", "/");
		
		try {
			EduDiploma pojo = sysService.queryDeplomaById(id, projectId, type,certificateView);
			//获得域名				
			String encoderContent = basePath+"/person/QRCode.do?projectId="+projectId+"&type="+type;
			QRCodeUtil.encode(encoderContent, null, imageServer,projectId,null, true);
			
			EduProject eduProject = eduProjectService.queryProjectBaseInfoById(new Integer(projectId));
			String trainScopeId = eduProject.getTrainScopeId();
			SysArea area = sysService.selectAreaByCode(trainScopeId);
			model.addAttribute("areaCode", area.getAreaCode());
			
			String qrcodeUrl = "certificate/project_"+projectId+"/"+projectId+"_"+"QRCode.jpg";
			result.put("qrcodeUrl", qrcodeUrl);
			
			if(pojo != null) {
				result.put("success", true);
				result.put("obj", pojo);
			} else {
					result.put("success", false);
					//项目证书、年度证书默认模板
					if(type.equals("1") || type.equals("2")){
						result.put("obj", project.common.Common.getDefaultCertifacte());
					}
					else if(type.equals("3")){
						result.put("obj", project.common.Common.getDefaultPeriodCertifacte());
					}
			}
				
			
		} catch (Exception e) {
			log.error("查询证书失败--->"+e.getMessage()+e.toString());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 转到校本培训项目
	 * @return
	 */
	@RequestMapping("notrainListPage.htm")
	public String toNotrainListPage(){
		return "furtheredu/notrainList";
	}
	/**
	 * 转到非培训类项目页面
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("mnotrainListPage.htm")
	public String toMnotrainListPage(Integer startIndex,Integer pageSize,ModelMap m) throws Exception{

		return "furtheredu/mnotrainList";
	}
	
	
	/**
	 * 转到学分查询页面
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("toSearchScore.htm")
	public String toSearchScore(Integer startIndex,Integer pageSize,ModelMap m) throws Exception{

		return "furtheredu/scoreList";
	}
	
	/**
	 * 学分查询
	 */
	@RequestMapping(value = "searchScore.do")
	public @ResponseBody Map<String, Object> searchScore(Integer pageIndex,Integer pageSize,
			HttpServletRequest request,String viewType,String teacherName,Integer beginScore,
			Integer endScore,String year, String beginYear,String endYear,Integer modelId,
			HttpServletResponse response) throws Exception {
//		String provinceId = super.getUserProvinceId(request);
//		String cityId = super.getUserCityId(request);
//		if(cityId != null && cityId.equals("0")) {
//			cityId = null;
//		}
//		
//		String districtId = super.getUserDistrictId(request);
//		if(districtId != null && districtId.equals("0")) {
//			districtId = null;
//		}
//		Integer schoolId = super.getSchoolId(request);
		
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		Map<String,Object> param = super.getArea(request);
//		Map<String,Object> param = new HashMap<String,Object>();
//		param.put("provinceId", provinceId);
//		param.put("cityId", cityId);
//		param.put("districtId", districtId);
//		param.put("schoolId", schoolId);
//		int startIndex = 0;
//		if(pageIndex==null||pageSize==null){
//			pageIndex = 1;
//			pageSize = 10;
//		}else{
//			startIndex = (pageIndex-1)*pageSize;
//		}
		
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
		if(pageSize!=null && pageSize!=0) {
			sizePerPage = Integer.valueOf(pageSize);
		}
		pageIndex = (pageIndex - 1) * sizePerPage;
		
		if(beginScore!=null) {
			param.put("beginScore", beginScore);
		}
		if(endScore!=null) {
			param.put("endScore", endScore);
		}
		if(!StringUtils.isEmpty(teacherName)) {
			param.put("teacherName", teacherName);
		}
		
		PageObject po = new PageObject();
		if("BK".equals(viewType)){
			if(modelId!=null && modelId!=0){
				param.put("modelId", modelId);
			}
			
			po = eduStatisticModelService.findStatisticModel(param, pageIndex, pageSize);
		}else{
			if(!StringUtils.isEmpty(year)) {
				param.put("year", year);
			}
			if(!StringUtils.isEmpty(beginYear)) {
				param.put("beginYear", beginYear);
			}
			if(!StringUtils.isEmpty(endYear)) {
				param.put("endYear", endYear);
			}
//			if(endYear==null){
//				endYear = beginYear;
//				param.put("endYear", endYear);
//			}

			po = eduStatisticYearService.findStatisticYear(param, pageIndex, pageSize);
		}
		
		pageInfo.put("pageObject", po);
		pageInfo.put("success", true);
		pageInfo.put("rows", po.getObjects());
		pageInfo.put("total", po.getCount());
		pageInfo.put("pageSize", po.getPagesize());
		pageInfo.put("pages", po.getPages());
		pageInfo.put("currentPage", po.getCurrentPage());
		pageInfo.put("pageNumbers", po.getPageNumbers());
		pageInfo.put("startIndex", po.getStartIndex());
		
		return pageInfo;
	}
	
	
	
	
	
	

	/**
	 * 校本培训项目/非培训类项目列表
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryNotrainList.do")
	public @ResponseBody Map<String, Object> queryNotrainList(String projectName,Integer typeId,String queryYear,Integer modelId, int pageIndex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		
		if(!StringUtils.isEmpty(projectName)) {
			paramMap.put("projectName", projectName);
		}
		
		Integer userId = getAccountId(request);
		EduUser user = userService.getUserById(userId);
		Integer provinceId = user.getUserProvinceId();
		Integer cityId = user.getUserCityId();
		Integer districtId = user.getUserDistrictId();
		Integer schoolId = user.getSchoolId();
		paramMap.put("pid", provinceId);
		paramMap.put("cid", cityId);
		paramMap.put("did", districtId);
		paramMap.put("sid", schoolId);
		
		if(modelId!=null&&modelId!=0) {
			paramMap.put("modelId", modelId);
		}
		if(!StringUtils.isEmpty(queryYear)&&!queryYear.equals("0")) {
			paramMap.put("year", queryYear);
		}
		paramMap.put("typeId", typeId);
		
		try {
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
			if(!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}
			pageIndex = (pageIndex - 1) * sizePerPage;
			
			PageObject po = sysService.queryEduProjectNotrain(paramMap, pageIndex, sizePerPage);
			if(po != null && po.getCount() > 0) {
				pageInfo.put("areaId", super.getUserAreaId(request));
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
			log.error("校本培训项目查询错误:" + e);
		}
		return pageInfo;
	}
	
	@RequestMapping(value = "deleteNotrain.do")
	public @ResponseBody
	Map<String, Object> removeNotrain(Integer id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer notrainId = sysService.deleteNotrain(id);
			if (notrainId != null && notrainId.intValue() >= 0) {
				result.put("success", true);
				result.put("notrainId", notrainId);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			log.error("保存  删除失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	/**
	 * 非培训项目
	 * @param notrain
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "addMnotrain.do")
	public @ResponseBody
	Map<String, Object> addMnotrain(EduProjectNotrain notrain, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		try {

			Integer notrainId = -1;
			if(notrain.getScopeId()!=null){
				Integer scopId=notrain.getScopeId();
				String scopName=notrain.getScopeName();
				SysArea sysArea=sysService.queryAreaByCode(scopId.toString());
				if(sysArea!=null&&scopName.equals(sysArea.getName())){
					if(sysArea.getType().equals("0")){
						Integer pId =	Integer.parseInt(super.getUserProvinceId(request));
						
					 notrain.setPid(scopId);
					 notrain.setCreateByArea(pId);
					 notrain.setCid(null);
					 notrain.setDid(null);
					 notrain.setSid(null);
					}else if(sysArea.getType().equals("1")){
							Integer cityId=	Integer.parseInt(super.getUserCityId(request));
						SysArea sysArea1=sysService.queryAreaByCode(sysArea.getUpLvCode());
						 notrain.setPid(sysArea1.getId());
						 notrain.setCid(scopId);
						 notrain.setCreateByArea(cityId);
						 notrain.setDid(null);
						 notrain.setSid(null);
					}else{
						Integer dId=	Integer.parseInt(super.getUserDistrictId(request));
						SysArea sysArea1=sysService.queryAreaByCode(sysArea.getUpLvCode());
						SysArea sysArea2=sysService.queryAreaByCode(sysArea1.getUpLvCode());
						 notrain.setPid(sysArea2.getId());
						 notrain.setCid(sysArea1.getId());
						 notrain.setDid(scopId);
						 notrain.setCreateByArea(dId);
						 notrain.setSid(null);
					}
				}else{
					EduSchool eduSchool=schoolService.searchSchoolInfo(scopId);
					if(eduSchool!=null){
						 notrain.setPid(eduSchool.getSchoolProvinceId());
						 notrain.setCid(eduSchool.getSchoolCityId());
						 notrain.setDid(eduSchool.getSchoolDistrictId());
						 notrain.setSid(scopId);
					}
				}
			}
			if(notrain.getId() != null ) {
				notrainId = sysService.updateNotrain(notrain);
			}else{
				notrain.setTypeName("非培训类项目");
				notrain.setTypeId(project.common.Common.NOTRAIN_TYPE_TWO);
				notrainId=sysService.insertNotrain(notrain);
			}
			if (notrainId != null && notrainId.intValue() >= 0) {
				result.put("success", true);
				result.put("notrainId", notrainId);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			log.error("保存继教非培训类项目表失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 跳转非培训项目
	 */
	@RequestMapping(value = "mnotrainAddPage.htm")
	public String mnotrainAddPage(ModelMap map,HttpServletRequest request) {
		map.put("areaName", this.getCode(request).get("areaName"));
		request.setAttribute("areaNames", this.getCode(request).get("areaName"));
		map.put("areaId", this.getCode(request).get("areaId"));
		request.setAttribute("areaIdes",this.getCode(request).get("areaId"));
		map.put("areaType", this.getCode(request).get("areaType"));
		return "furtheredu/mnotrainAdd";
	}
	/**
	 * 跳转编辑非培训项目
	 */
	@RequestMapping(value = "mnotrainUpdPage.htm")
	public String mnotrainUpdPage(ModelMap map, Integer id,HttpServletRequest request) {
		try {
			EduProjectNotrain notrain=sysService.selectNotraiByPrimaryKey(id);
			map.put("notrain", notrain);
			map.put("areaName", this.getCode(request).get("areaName"));
			map.put("areaId", this.getCode(request).get("areaId"));
			map.put("areaType", this.getCode(request).get("areaType"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "furtheredu/mnotrainUpdate";
	}
	
	/**
	 * 添加/编辑校本培训项目
	 * */
	@RequestMapping(value = "addNotrain.do")
	public @ResponseBody
	Map<String, Object> addNotrain(EduProjectNotrain notrain, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer notrainId = -1;
			if(notrain.getId() != null ) {
				notrainId = sysService.updateNotrain(notrain);
			}else{
				HttpSession session = request.getSession();
				EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
				Integer scid=info.getSchoolId();
				String scname=info.getSchoolName();
				notrain.setScopeId(scid);
				notrain.setScopeName(scname);
				if(info.getUserProvinceId()!=null){
					notrain.setPid(Integer.parseInt(info.getUserProvinceId()));
				}
				if(info.getUserCityId()!=null){
					notrain.setCid(Integer.parseInt(info.getUserCityId()));
				}
				if(info.getUserDistrictId()!=null){
					notrain.setDid(Integer.parseInt(info.getUserDistrictId()));
				}
				if(info.getSchoolId()!=null){
					notrain.setSid(info.getSchoolId());
				}
				notrain.setTypeName("校本培训项目");
				notrain.setTypeId(project.common.Common.NOTRAIN_TYPE_ONE);
				notrainId=sysService.insertNotrain(notrain);
			}
			
			if (notrainId != null && notrainId.intValue() >= 0) {
				result.put("success", true);
				result.put("notrainId", notrainId);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			log.error("保存继教校本项目表失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 跳转添加校本培训项目页面
	 */
	@RequestMapping(value = "notrainAddPage.htm")
	public String notrainAddPage() {
		return "furtheredu/notrainAdd";
	}
	/**
	 * 跳转编辑校本培训项目
	 */
	@RequestMapping(value = "notrainUpdPage.htm")
	public String notrainUpdPage(ModelMap map, Integer id) {
		try {
			EduProjectNotrain notrain=sysService.selectNotraiByPrimaryKey(id);
			map.put("notrain", notrain);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "furtheredu/notrainUpdate";
	}
	
	/**
	 * 跳转年度证书打印
	 */
	@RequestMapping(value = "yearCertificatePrint.htm")
	public String yearCertificatePrint() {
		return "furtheredu/yearCertificatePrint";
	}
	
	@RequestMapping("enterCredit.do")
	public @ResponseBody boolean enterCredit(Integer projectId, Integer teacherId, Float score){
//		teacherId:teacherId,
//		projectId:projectId,
//		score:score
		Map<String,Object> params = new HashMap<String,Object>();
		
		try {
			params.put("projectId", projectId);
			params.put("teacherId", teacherId);
			params.put("score", score);
			
			return  sysService.enterCredit(params);
		} catch (Exception e) {
			log.error("查询证书失败--->"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 培训类项目审核学分
	 * @param projectId
	 * @param teacherId
	 * @param score
	 * @return
	 */
	@RequestMapping("auditCredit.do")
	public @ResponseBody boolean auditCredit(Integer id,Integer projectId,Integer status,String statusName, Float score,HttpServletResponse response){
		 
		log.info("审核学分");
		Map<String,Object> params = new HashMap<String,Object>();
		try {
			params.put("id", id);
			params.put("projectId", projectId);
			params.put("status", status);
			params.put("statusName", statusName);
			params.put("score", score);
 			return  sysService.auditCredit(params);
			
		} catch (Exception e) {
			log.error("审核学分失败--->"+e.getMessage());
			e.printStackTrace();
		}
		 return false;
	}
	
	/**
	 * 培训类项目审核学分
	 * @param projectId
	 * @param teacherId
	 * @param score
	 * @return
	 */
	@RequestMapping("auditCreditTrain.do")
	public @ResponseBody Map<String, Object> auditCreditTrain(String ids,Integer projectId,Integer status,String statusName, String score){
		log.info("审核学分");
		Map<String,Object> params = new HashMap<String,Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			params.put("ids", StringUtils.isEmpty(ids) ? null : ids.split(","));
			params.put("projectId", projectId);
			params.put("status", status);
			params.put("statusName", statusName);
			params.put("score", score);
			params.put("isTrainProject", true);
			
			if(sysService.auditCredit(params)){
				result.put("success", true);
			}else{
				result.put("success", false);
			}
			
		} catch (Exception e) {
			log.error("审核学分失败--->"+e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		
		return result;
	}
	
	/**
	 * 设置证书设置
	 * */
	@RequestMapping(value = "updateCertificate.do")
	public @ResponseBody
	Map<String, Object> updateCertificate(String data, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> result = new HashMap<String, Object>();
			EduDiploma pojo = mapper.readValue(data, EduDiploma.class);
			HttpSession session = request.getSession();
			EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
			pojo.setUpdateBy(info.getRealName());
			pojo.setUpdateDate(new Date());
			
			if(sysService.updateCertificate(pojo) == 0){
				result.put("success", true);
			}else{
				result.put("success", false);
			}
			
		return result;
	}
	@RequestMapping("/hasSetCertificate.do")
	public @ResponseBody Map<String, Object> hasSetCertificate(HttpServletRequest request){
		Map<String, Object> condition = super.getCode(request);
		Map<String,Object> result = new HashMap<String,Object>();
		String diplomaId = request.getParameter("diplomaId");
		condition.put("id", diplomaId);
		List<EduDiploma> list = eduManageService.selectYearDiploma(condition);
		EduDiploma pojo = list.get(0);
		
		
		if(pojo.getStatus() == 1){
			result.put("success", true);
		}else{
			result.put("success", false);
			result.put("message", "还未设置年度证书。");
		}
		
		return result;
	}
}
