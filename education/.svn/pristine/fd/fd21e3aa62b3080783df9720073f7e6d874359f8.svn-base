package project.system.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import project.common.Common;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.service.IEduProjectService;
import project.organization.dao.IOrganizationReadDAOIF;
import project.organization.pojo.Organization;
import project.person.pojo.EduUserActivty;
import project.system.pojo.EduSchool;
import project.system.pojo.EduTeacherScoreInfo;
import project.system.pojo.FjTeacherStudyInfo;
import project.system.pojo.Fjimport;
import project.system.pojo.FjimportActivty;
import project.system.pojo.FjimportHistory;
import project.system.pojo.SysArea;
import project.system.pojo.SysDictionary;
import project.system.pojo.SysFunction;
import project.system.pojo.SysPlatformSetup;
import project.system.pojo.SysRole;
import project.system.pojo.SysSetup;
import project.system.pojo.TrainingDTO;
import project.system.service.ISysSchoolService;
import project.system.service.ISysService;
import project.teacher.teacherProject.service.ITeacherProjectServiceIF;
import project.teacher.teachermanage.pojo.TeacherExportActivity;
import project.util.ApplicationProperties;
import project.util.DataUtil;
import project.util.DateUtil;
import project.util.DesTool;
import project.util.ResponseUtil;
import framelib.controller.AbsController;
import framelib.utils.FileUtils;
import framelib.utils.page.PageObject;
/**
 * 系统管理
 * 
 * @author zhangBo
 * @version 1.0
 *@Create_Date 2014年3月27日
 */

@Controller
@RequestMapping("sys")
public class SysController extends AbsController {
	private static final Logger log = Logger.getLogger(SysController.class);

	@Autowired
	@Qualifier("sysService")
	ISysService sysService;
	
	@Autowired
	@Qualifier("schoolService")
	ISysSchoolService schoolService;
	
	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;

	@RequestMapping("commonAreaSelect.htm")
	public String toLoginPage() {
		return "common/commonAreaSelect";
	}
	@Autowired
	@Qualifier("organizationReadDAO")
	IOrganizationReadDAOIF orgReadDAO;
	
	@Autowired
	@Qualifier("teacherProjectService")
	ITeacherProjectServiceIF teacherProjectServiceIF;
	

	/**
	 * 上传头像
	 * 
	 * @param file
	 * @param proId
	 * @return
	 */
	@RequestMapping("uploadUserPhoto.do")
	public void uploadUserPhoto(HttpServletRequest request,
			HttpServletResponse response, String upload) {
		Map<String, Object> result = new HashMap<String, Object>();
//		String path = ApplicationProperties.getPropertyValue("upload_path");
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		String path = projectPath + ApplicationProperties.getPropertyValue("upload_file_path");
		
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = multipartRequest.getFile("photoFile");
			result = sysService.saveFile(path, file, null);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			log.error("导入失败！" + e.getMessage());
			e.printStackTrace();
		}
		ResponseUtil.renderText(response, JSONObject.fromObject(result)
				.toString());
	}

	/**
	 * 地区查询 add by dengguo 当前登陆人的可视范围
	 * 
	 * @param startIndex
	 * @return
	 */
	@RequestMapping("curLoginAreaList.do")
	public @ResponseBody
	Map<String, Object> areaList(int belong, String area,
			HttpServletRequest request) {
		Map<String, Object> result = getViewAreaMap(request);
		try {
			Map<String, Object> parm = new HashMap<String, Object>();
			EduUserActivty obj = getSessionUserInfo(request);
			if (!StringUtils.isEmpty(obj.getUserDistrictId())
					&& !StringUtils.isEmpty(area) && area.equals("districtId")) {
				parm.put("code", obj.getUserDistrictId());
			} else if (!StringUtils.isEmpty(obj.getUserCityId())
					&& !StringUtils.isEmpty(area) && area.equals("cityId")) {
				parm.put("code", obj.getUserCityId());
			} else if (!StringUtils.isEmpty(obj.getUserProvinceId())
					&& !StringUtils.isEmpty(area) && area.equals("provinceId")) {
				parm.put("code", obj.getUserProvinceId());
			} else {
				parm.put("belong", belong);
			}

			List<SysArea> list = sysService.selectAreaList(parm);
			
			
			
			
			if (list != null && list.size() != 0) {
				result.put("success", true);
				result.put("obj", list);
				result.put("area", area);
				result.put("areaId", parm.get("code"));
				result.put("roleId", this.getRoleId(request));
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
	
	/**<!-- 教师调动页面重新单独使用一个查询地区学校的页面，因为教师调动需要跨市区校 -->
	 * 地区查询 add by dengguo 当前登陆人的可视范围
	 * 
	 * @param startIndex
	 * @return
	 */
	@RequestMapping("curLoginAreaListNew.do")
	public @ResponseBody
	Map<String, Object> areaListNew(int belong, String area,
			HttpServletRequest request) {
		Map<String, Object> result = getViewAreaMap(request);
		try {
			Map<String, Object> parm = new HashMap<String, Object>();
			EduUserActivty obj = getSessionUserInfo(request);
		/*	if (!StringUtils.isEmpty(obj.getUserDistrictId())
					&& !StringUtils.isEmpty(area) && area.equals("districtId")) {
				parm.put("code", obj.getUserDistrictId());
			} else if (!StringUtils.isEmpty(obj.getUserCityId())
					&& !StringUtils.isEmpty(area) && area.equals("cityId")) {
				parm.put("code", obj.getUserCityId());
			} else*/ if (!StringUtils.isEmpty(obj.getUserProvinceId())
					&& !StringUtils.isEmpty(area) && area.equals("provinceId")) {
				parm.put("code", obj.getUserProvinceId());
			} else {
				parm.put("belong", belong);
			}

			List<SysArea> list = sysService.selectAreaList(parm);
			
			
			
			
			if (list != null && list.size() != 0) {
				result.put("success", true);
				result.put("obj", list);
				result.put("area", area);
				result.put("areaId", parm.get("code"));
				result.put("roleId", this.getRoleId(request));
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
	 * 地区查询 add by zhangxiaoqi
	 * 
	 * @param startIndex
	 * @return
	 */
	@RequestMapping("areaList.do")
	public @ResponseBody
	Map<String, Object> areaList(int belong, HttpServletRequest request) {
		Map<String, Object> result = getViewAreaMap(request);
		try {
			Map<String, Object> parm = new HashMap<String, Object>();
			parm.put("belong", belong);
			List<SysArea> list = sysService.selectAreaList(parm);
			if (list != null && list.size() != 0) {
				result.put("success", true);
				result.put("obj", list);
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

	@RequestMapping("queryDicByType.do")
	public @ResponseBody
	Map<String, Object> queryProjectClass(String dicType) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			List<SysDictionary> dics = sysService.queryDicByDicType(dicType);
			result.put("success", true);
			result.put("rows", dics);
		} catch (Exception e) {
			log.error("查询" + dicType + "失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}

	@RequestMapping("createArea.do")
	public @ResponseBody
	Map<String, Object> createArea(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		String json = request.getParameter("area");
		try {
			SysArea area = mapper.readValue(json, SysArea.class);
			area.setCreateBy(super.getAccount(request));
			area.setUpdateBy(super.getAccount(request));
			if (sysService.addArea(area)) {
				DataUtil.setOk(result);
			}
			else{
				DataUtil.setFail(result);
			}
		} catch (Exception e) {
			log.error("地区添加失败-->" + e.getMessage());
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 地区管理
	 * 
	 * @param belong
	 * @param type
	 * @return 2014-3-30 zhangBo
	 */
	@RequestMapping("areaMgr.do")
	public @ResponseBody
	Map<String, Object> areaMgr(int startIndex, int belong,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			PageObject po = sysService.qryAreaList(startIndex,
					Common.PNN_USER_PAGE_LIMIT, belong);
			result.put("total", po.getCount());
			result.put("rows", po.getObjects());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
			result.put("areaId", super.getUserAreaId(request));
			if(po.getObjects().size()!=0){
				result.put("type", ((SysArea)((List)po.getObjects()).get(0)).getType());
			}else{
				result.put("type", 0);
			}
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("地区列表失败" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("toAreaMgrPage.htm")
	public String toAreaMgrPage(int belong,String type,HttpServletRequest request) {
		int id =belong;
		if(belong == -1){
			Map<String,Object> map = super.getCode(request);
			Object uu = map.get("areaId");
			int rr = (Integer)map.get("roleId");
			if(rr == 0){
				id=0;
				request.setAttribute("belong", 0);
			}else{
				id = Integer.parseInt(uu.toString());
				request.setAttribute("belong", uu);
			}
		}
		
		try {
			String relation = sysService.getAreaRelationById(id);
			request.setAttribute("relation", relation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "system/areaMgr";
	}

	/**
	 * 项目汇总统计入口
	 * 
	 * @param belong
	 * @param type
	 * @return
	 */
	@RequestMapping("toProjectStatisticsPage.htm")
	public String toProjectStatisticsPage(ModelMap map, HttpServletRequest request) {
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
		return "system/projectStatisticsList";
	}

	/**
	 * 项目汇总统计
	 * 
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryProjectStatistics.do")
	public @ResponseBody
	Map<String, Object> queryTeacherActivetyList(int pageIndex,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

			if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}

			if (!StringUtils.isEmpty(request.getParameter("projectName"))) {
				paramMap.put("projectName", request.getParameter("projectName"));
			}

			if (!StringUtils.isEmpty(request.getParameter("status"))) {
				paramMap.put("status", request.getParameter("status"));
			}

			if (!StringUtils.isEmpty(request.getParameter("year"))) {
				paramMap.put("year", request.getParameter("year"));
			}
			if(!StringUtils.isEmpty(request.getParameter("eduModelType"))){
				paramMap.put("eduModelType",request.getParameter("eduModelType"));
			}
			if(!StringUtils.isEmpty(request.getParameter("projectScope"))){
				paramMap.put("projectScope",request.getParameter("projectScope"));
			}
			if(!StringUtils.isEmpty("areaId")){
				paramMap.put("areaId", request.getParameter("areaId"));
			}

			EduUserActivty activty = super.getSessionUserInfo(request);
			paramMap.put("roleId", activty.getRoleId());
			paramMap.put("provinceId", activty.getUserProvinceId());
			paramMap.put("cityId", activty.getUserCityId());
			paramMap.put("districtId", activty.getUserDistrictId());
			paramMap.put("schoolId", activty.getSchoolId());

			pageIndex = (pageIndex - 1) * sizePerPage;

			PageObject po = sysService.queryProjectStatistics(paramMap, pageIndex, sizePerPage);
			pageInfo.put("rows", po.getObjects());
			pageInfo.put("total", po.getCount());
			pageInfo.put("pageSize", po.getPagesize());
			pageInfo.put("pages", po.getPages());
			pageInfo.put("currentPage", po.getCurrentPage());
			pageInfo.put("pageNumbers", po.getPageNumbers());
			pageInfo.put("startIndex", po.getStartIndex());
			if (po != null && po.getCount()>0) {
				pageInfo.put("success", true);				
			}
			else {
				pageInfo.put("success", false);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("项目汇总统计失败:" + e.getMessage());
		}
		return pageInfo;
	}
	/**
	 * 继教模板培训项目信息统计
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/queryModelStatistics.do")
	public @ResponseBody Map<String, Object> queryProjectStatistics(int pageIndex,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
		if(!StringUtils.isEmpty(request.getParameter("modelId"))){
			paramMap.put("modelId", request.getParameter("modelId"));
		}
		if(!StringUtils.isEmpty(request.getParameter("modelProjectScope"))){
			paramMap.put("modelProjectScope", request.getParameter("modelProjectScope"));
		}
		if(!StringUtils.isEmpty(request.getParameter("modelYear"))){
			paramMap.put("year", request.getParameter("modelYear"));
		}
		if(!StringUtils.isEmpty(request.getParameter("areaId"))){
			paramMap.put("areaId", request.getParameter("areaId"));
		}
		
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		
		pageIndex = (pageIndex - 1) * sizePerPage;
		
		PageObject po = sysService.queryModelStatistics(paramMap, pageIndex, sizePerPage);
			pageInfo.put("rows", po.getObjects());
			pageInfo.put("total", po.getCount());
			pageInfo.put("pageSize", po.getPagesize());
			pageInfo.put("pages", po.getPages());
			pageInfo.put("currentPage",po.getCurrentPage());
			pageInfo.put("pageNumbers", po.getPageNumbers());
			pageInfo.put("startIndex", po.getStartIndex());
			
			if(po != null && po.getCount() > 0 ){
				pageInfo.put("success", true);
			}
			else{
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("继教模板统计培训信息异常！");
		}
		return pageInfo;		
	}
	
	@RequestMapping(value = "/queryAreaStatistics.do")
	public @ResponseBody Map<String, Object> queryAreaStatisticsList(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> paraMap = new HashMap<String, Object>();
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		if(!StringUtils.isEmpty(request.getParameter("areaId"))){
			paraMap.put("areaId", request.getParameter("areaId"));
		}
		if(!StringUtils.isEmpty(request.getParameter("areaYear"))){
			paraMap.put("year", request.getParameter("areaYear"));
		}
		if(!StringUtils.isEmpty(request.getParameter("areaProjectScope"))){
			paraMap.put("projectScopeId", request.getParameter("areaProjectScope"));
		}
		try {
			PageObject po = sysService.queryAreaStatistics(paraMap,0,0);
			if(po != null){
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
			}
			else{
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("地区统计培训信息异常！");
			pageInfo.put("success", false);
		}
		return pageInfo;
	}

	/**
	 * 通过学段查询学科
	 * 
	 * @return
	 */
	@RequestMapping("querySubject.do")
	public @ResponseBody
	Map<String, Object> querySubjectBySection(String id, String sectionName) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<SysDictionary> subjects = sysService.querySubjectBySection(id, sectionName);
			result.put("rows", subjects);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 角色管理跳转页面
	 * 
	 * @author cl
	 * @return
	 */
	@RequestMapping("toRolePage.htm")
	public String toRolePage() {
		return "system/toRolePage";
	}

	/**
	 * 角色类型查询
	 * 
	 */
	@RequestMapping(value = "/queryRoleTypeList.do")
	public @ResponseBody Map<String, Object> queryRoleTypeList(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		Integer userRoleType = super.getRoleId(request);
		
		String isDisTeacher = request.getParameter("isDisTeacher");
		if(isDisTeacher != null && !"".equals(isDisTeacher)){
			param.put("isDisTeacher", isDisTeacher);
		}
		param.put("status", request.getParameter("status"));
		List<project.system.pojo.RoleType> rt = sysService.getRoleTypeListByUser(param,userRoleType);
		if(rt != null && rt.size() > 0) {
			result.put("rows", rt);
			result.put("success", true);
		}else {
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 角色管理
	 * 
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryRoleList.do")
	public @ResponseBody
	Map<String, Object> queryTeacherAssessList(HttpServletRequest request,
			HttpServletResponse response,boolean onlyManager, boolean onlyShishi,boolean exceptShishi,Model model) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		Map<String, Object> param = super.getArea(request);
		Integer userRoleType = super.getRoleId(request);
		
		param.put("roleType", userRoleType);
		param.put("status", request.getParameter("status"));
		try {
			List<SysRole> po = sysService.queryRoleListByUser(param,userRoleType, onlyManager, onlyShishi,exceptShishi);
			if (po != null && po.size() > 0) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po);
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("角色管理查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	
	/**
	 * 添加角色
	 */
	@RequestMapping(value = "addRole.do")
	public @ResponseBody
	Map<String, Object> addRole(HttpServletRequest request, String roleType, 
			String roleName) {
		Map<String, Object> result = new HashMap<String, Object>();
		EduUserActivty user = getSessionUserInfo(request);
		
		SysRole sysRole = new SysRole();
		sysRole.setRoleType(new Integer(roleType));
		sysRole.setRoleName(roleName);
		sysRole.setStatus(1);
		if(user.getUserProvinceId() != null){
		}
		if(user.getUserProvinceId() != null){
			sysRole.setCreateProvinceId(new Integer(user.getUserProvinceId()));
		}
		if(user.getUserCityId() != null){
			sysRole.setCreateCityId(new Integer(user.getUserCityId()));
		}
		if(user.getUserDistrictId() != null){
			sysRole.setCreateDistrictId(new Integer(user.getUserDistrictId()));
		}
		if(user.getSchoolId() != null){
			sysRole.setCreateSchoolId(new Integer(user.getSchoolId()));
		}
		sysRole.setCreateById(user.getUserId());
		sysRole.setCreateDate(new Date());
		sysRole.setUpdateById(0);
		sysRole.setUpdateDate(new Date());
		int ret = sysService.addRole(sysRole);
		if(ret != 0) {
			result.put("success", true);
		}else {
			result.put("success", false);
		}
		
		return result;
	}
	

	/**
	 * 删除教师
	 * 
	 * @return
	 */
	@RequestMapping(value = "setRoleStauts.do")
	public @ResponseBody
	Map<String, Object> removeTeacher(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {

			SysRole pojo = new SysRole();
			if (request.getParameter("id") == null
					|| request.getParameter("id").length() == 0) {
				throw new Exception("角色ID为空！");
			}
			if (request.getParameter("status") == null
					|| request.getParameter("status").length() == 0) {
				throw new Exception("角色状态为空！");
			}
			pojo.setId(Integer.parseInt(request.getParameter("id")));
			pojo.setStatus(Integer.parseInt(request.getParameter("status")));
			pojo.setUpdateBy(super.getRealName(request));

			Integer flag = sysService.updateRole(pojo);
			if (flag != null && flag.intValue() >= 0) {
				result.put("success", true);
			} else {
				result.put("success", false);
			}

		} catch (Exception e) {
			log.error("更新角色状态失败:" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}

	/**
	 * 承培机构系统管理页面跳转
	 * @author yinxiaolong
	 * @return
	 */
	@RequestMapping(value="cpOrganizationList.htm")
	public String toCpOrganizationListPage(){
		return "system/cpOrganizationManagePage";
	}

	/**
	 * 实施机构系统管理页面跳转
	 * @author yinxiaolong
	 * 
	 * @return
	 */
	@RequestMapping(value = "organizationList.htm")
	public String toOrganizationListPage(HttpServletRequest request) {
//		Integer roleId=super.getRoleId(request);
//		request.setAttribute("roleId", roleId);
		return "system/organizationManagePage";
	}

	/**
	 * 机构管理列表
	 * 
	 * @author yinxiaolong
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/organizationList.do")
	public @ResponseBody Map<String,Object> queryOrganizationList(int type,int pageIndex,
				HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> pageInfo = new HashMap<String, Object>();

//		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = getArea(request);
		paramMap.put("type", type);
//		String organizationProvinceId = this.getUserProvinceId(request);
//		String organizationProvinceName = this.getUserProvinceName(request);
//		String organizationCityId = this.getUserCityId(request);
//		String organizationCityName = this.getUserCityName(request);
//		String organizationDistrictId = this.getUserDistrictId(request);
//		String organizationDistrictName = this.getUserDistrictName(request);
//		paramMap.put("organizationProvinceId", organizationProvinceId);
//		paramMap.put("organizationProvinceName", organizationProvinceName);
//		paramMap.put("organizationCityId", organizationCityId);
//		paramMap.put("organizationCityName", organizationCityName);
//		paramMap.put("organizationDistrictId", organizationDistrictId);
//		paramMap.put("organizationDistrictName", organizationDistrictName);
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}
		if (!StringUtils.isEmpty(request.getParameter("organizationName"))) {
			paramMap.put("organizationName", request.getParameter("organizationName"));
		}
		
		pageIndex = (pageIndex - 1) * sizePerPage;
		
		try {
			PageObject po = sysService.querySysOrganization(paramMap, pageIndex, sizePerPage);
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
			log.error("机构系统管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}

	/**
	 * 增加实施机构信息页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "addOrganizationInfo.htm")
	public String addOrganizationListPage() {
		return "system/addOrganizationManageInfo";
	}
	
	/**
	 * 增加承培机构信息页面跳转
	 * @return
	 */
	@RequestMapping(value="addCpOrganizationInfo.htm")
	public String addCpOrganizationListPage(){
		return "system/addCpOrganizationManageInfo";
	}

	/**
	 * 实施机构增加
	 * @author yinxiaolong
	 * @param organizationName
	 * @param contacts
	 * @param contactsType
	 * @param organizationAdderss
	 * @param memo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("saveOrganizationInfo.do")
	public @ResponseBody Map<String, Object> addOrganization(int type,String organizationName,
			String contacts,String contactsType,String organizationAdderss,String orgCode,
			String memo, HttpServletRequest request, HttpServletResponse response){
		EduUserActivty obj = getSessionUserInfo(request);
		Map<String, Object> paramMap = new HashMap<String, Object>();
//		String organizationProvinceId = this.getUserProvinceId(request);
//		String organizationProvinceName = this.getUserProvinceName(request);
//		String organizationCityId = this.getUserCityId(request);
//		String organizationCityName = this.getUserCityName(request);
//		String organizationDistrictId = this.getUserDistrictId(request);
//		String organizationDistrictName = this.getUserDistrictName(request);
//		paramMap.put("organizationProvinceId", organizationProvinceId);
//		paramMap.put("organizationProvinceName", organizationProvinceName);
//		paramMap.put("organizationCityId", organizationCityId);
//		paramMap.put("organizationCityName", organizationCityName);
//		paramMap.put("organizationDistrictId", organizationDistrictId);
//		paramMap.put("organizationDistrictName", organizationDistrictName);
		
		paramMap.put("organizationProvinceId", obj.getUserProvinceId());
		paramMap.put("organizationProvinceName", obj.getUserProvinceName());
		
		int roleId = obj.getRoleId().intValue();
		if(roleId == 2){
			paramMap.put("organizationCityId", obj.getUserCityId());
			paramMap.put("organizationCityName", obj.getUserCityName());
		}else if(roleId == 3){
			paramMap.put("organizationCityId", obj.getUserCityId());
			paramMap.put("organizationCityName", obj.getUserCityName());
			paramMap.put("organizationDistrictId", obj.getUserDistrictId());
			paramMap.put("organizationDistrictName", obj.getUserDistrictName());
		}
		
		paramMap.put("organizationName", organizationName);
		paramMap.put("contacts", contacts);
		paramMap.put("contactsType", contactsType);
		paramMap.put("organizationAdderss", organizationAdderss);
		paramMap.put("orgCode",orgCode);
		paramMap.put("memo", memo);
		paramMap.put("createBy", obj.getLoginAccount());
		paramMap.put("type", type);
		paramMap.put("loginAccount", contacts);
		paramMap.put("realName", contacts);
		paramMap.put("mobile", contactsType);
		paramMap.put("password", contactsType);
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			//数据库所有机构
			List<Organization> orgList = orgReadDAO.selectAllOrganizations();
			boolean valOrgCode = true;
			for(Organization org : orgList){
				if(org.getOrgCode()!=null && org.getOrgCode().equals(orgCode)){
					valOrgCode = false;
					break;
				}
			}
			if(valOrgCode){
				if (sysService.addOrganizationInfo(paramMap)) {
					result.put("success", true);
				}
			}
			else{
				result.put("success", false);
				result.put("resultReason", "所填写单位编码在系统中已存在!");
			}
		
		}catch (Exception e) {
			log.error("机构增加失败:" + e);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 机构修改
	 * 
	 * @author yinxiaolong
	 * @param organizationId
	 * @param organizationName
	 * @param contacts
	 * @param contactsType
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("editOrganizationInfo.do")
	public @ResponseBody Map<String, Object> updateArea(String organizationId, String organizationName, String contacts, String contactsType,
			String orgCode,String oldOrgCode,HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("organizationId", organizationId);
		paramMap.put("organizationName", organizationName);
		paramMap.put("contacts", contacts);
		paramMap.put("contactsType", contactsType);
		paramMap.put("orgCode", orgCode);
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			//数据库所有机构
			List<Organization> orgList = orgReadDAO.selectAllOrganizations();
			boolean valOrgCode = true;
			if(orgCode.equalsIgnoreCase("")){
				result.put("success", false);
				result.put("resultReason", "机构编码不能为空!");
			}else{
				
				if(!orgCode.equals(oldOrgCode)){
					for(Organization org : orgList){
						if(org.getOrgCode()!=null && org.getOrgCode().equals(orgCode)){
							valOrgCode = false;
							break;
						}
					}
				} 
				
				if(valOrgCode){
					//添加机构
					if(organizationId!=null && orgCode!=null){
						if (sysService.updateOrganizationInfo(paramMap)) {
							result.put("success", true);
						}
					}
				}
				else{
					result.put("success", false);
					result.put("resultReason", "所填写单位编码在系统中已存在!");
					/*	if(organizationId!=null) {
				   //编辑机构
					if (sysService.updateOrganizationInfo(paramMap)) {
						result.put("success", true);
					}
				}else {
					result.put("success", false);
					result.put("resultReason", "所填写单位编码在系统中已存在!");
				}*/
				}
			}
		} catch (Exception e) {
			log.error("机构修改失败:" + e);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 机构删除
	 * 
	 * @author yinxiaolong
	 * @param organizationId
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("deleteOrganizationInfo.do")
	public @ResponseBody Map<String, Object> deleteArea(String organizationId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("organizationId", organizationId);
		Map<String, Object> result = new HashMap<String, Object>();
		List<EduProject> dd = eduProjectService.selectshishijigou();
		boolean flag = false;
		for(EduProject ep:dd){
			if(organizationId.equals(String.valueOf(ep.getOrganizationId()))){
				flag = true;
			}
		}
		if(!flag){
			sysService.deleteOrganizationInfo(paramMap);
			result.put("info", "删除成功");
		}else{
			result.put("info", "该实施机构已经被使用");
		}
		return result;
	}

	/**
	 * 设置机构管理员页面跳转
	 * @author yinxiaolong
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/toOrgAdminsList.htm")
	public String toOrgAdminsListPage(HttpServletRequest request){
		String type = request.getParameter("type");
		String orgName = "";
		try {
			Organization org = sysService.selectOrganizationInfoById(Integer.parseInt(request.getParameter("organizationId")));
			orgName = org.getOrganizationName();
		} catch (Exception e1) {
			orgName = "获得实施机构名称失败";
		}
		request.setAttribute("name", orgName);
//		request.setAttribute("organizationId", request.getParameter("organizationId"));
		
		if(type.equals("1")){
			return "system/addCpOrgAdmins";
		}else{
			return "system/addSsOrgAdmins";
		}
	}
	
	/**
	 * 查看机构管理员
	 * @author yinxiaolong
	 * @param type
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getOrgAdminsList.do")
	public @ResponseBody Map<String,Object> queryOrgAdminsList(int organizationId,int pageIndex,
				HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("organizationId", organizationId);
		int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

		if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
			sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
		}

		pageIndex = (pageIndex - 1) * sizePerPage;
		try {
			PageObject po = sysService.queryselectOrgAdmins(paramMap, pageIndex, sizePerPage);
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
			log.error("机构系统管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	/**
	 * 转向添加实施机构管理员页面
	 * @author yinxiaolong 
	 * @return
	 */
	@RequestMapping(value = "addOrgAdminsPage.htm")
	public String addOrgAdminsInfoPage(HttpServletRequest request) {
		String type = request.getParameter("type");
		/*Integer roleId=null;;
		Integer roleID=super.getRoleId(request);
		if(roleID==1){
			roleId=7;
		}else if(roleID==2){
			roleId=8;
		}else if(roleID==3){
			roleId=9;
		}
		request.setAttribute("roleId", roleId);*/
		if(type.equals("1")){
			return "person/addCpOrgAdmin";
		}else{
			return "person/addSsOrgAdmin";
		}
	}
	
	@RequestMapping(value = "addOrgAdmins.htm")
	public String toAddOrgAdminsInfoPage(HttpServletRequest request){
		String type=request.getParameter("type");
		try {
			request.setAttribute("name", new String(request.getParameter("organizationName").getBytes("iso-8859-1"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(type.equals("1")){
			return "person/addCpOrgAdmin";
		}else{
			return "person/addSsOrgAdmin";
		}
	}
	
	/**
	 * @author yinxiaolong 机构系统管理查看页面跳转
	 * @return
	 */
	@RequestMapping(value = "organizationInfo.htm")
	public String toOrganizationInfoPage() {
		return "system/organizationManageInfo";
	}
	
	/**
	 * 转向实施机构详情页面
	 * */
	@RequestMapping(value = "organizationInfoPage.htm")
	public String toOrganizationInfoPageByTeahcer() {
		return "system/organizationManageInfoByTeacher";
	}

	/**
	 * 查看机构
	 * 
	 * @author yinxiaolong
	 * @param organizationId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getOrganizationInfo.do")
	public @ResponseBody Map<String, Object> getOrganizationInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("organizationId");
		Integer organizationId = Integer.valueOf(id);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Organization info = sysService.selectOrganizationInfoById(organizationId);
			if (info != null) {
				resultMap.put("success", true);
				resultMap.put("info", info);
			}
		} catch (Exception e) {
			log.error("机构查看失败:" + e);
			e.printStackTrace();
		}

		return resultMap;
	}

	/**
	 * 跳转到机构: 上传机构第一步页面
	 * 
	 * @return
	 */
	@RequestMapping("importOrganizationsPage.htm")
	public String importOrganizations(ModelMap map, HttpServletRequest request, String type) {
		map.put("type", type);
		if(type.equals("1")){
			return "system/importOrganizations";
		} else {
			return "system/importSSOrgs";
		}
	}

	/**
	 * 检测数据
	 * @author yinxiaolong
	 * @param request
	 * @param path
	 * @return
	 */
	@RequestMapping("importOrganizations.do")
	public @ResponseBody Map<String, Object> importOrganzations(HttpServletRequest request,
			String path, String type) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> param = getUserLocaltion(request);
			param.put("type", type);
			
			result = sysService.parseExcel(path, "orgainzations", param);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("导入失败！" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 检测数据--实施机构
	 * @author 曉
	 * @param request
	 * @param path
	 * @return
	 */
	@RequestMapping("importSSOrgs.do")
	public @ResponseBody Map<String, Object> importSSOrgs(HttpServletRequest request,
			String path, String type) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			
//			Map<String, Object> param = getUserLocaltion(request);
			Map<String, Object> param = super.getDetailArea(request);
			param.put("type", type);
			
			result = sysService.parseExcel(projectPath + path, "SSOrgs", param);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("导入失败！" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 导入实施机构第四步
	 * 
	 * @author yinxiaolong
	 * @param request
	 * @param path
	 * @return
	 */
	@RequestMapping("importOrgsStep4.do")
	public @ResponseBody Map<String, Object> importOrgsStep4(HttpServletRequest request, String path, String type) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> params =  super.getDetailArea(request);
		    params.put("type", type);
//			path = ApplicationProperties.getPropertyValue("upload_path")+ path.replace("/", File.separator);

		    String projectPath = request.getSession().getServletContext().getRealPath("/");
		    path = projectPath + ApplicationProperties.getPropertyValue("upload_file_path")+path.replace("/",File.separator);
			result = sysService.intoDB(path, "ssOrg", super.getAccount(request), params);
			DataUtil.setOk(result);
		} catch (Exception e) {
			log.info("导入机构失败！");
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 导入机构第四步
	 * 
	 * @author yinxiaolong
	 * @param request
	 * @param path
	 * @return
	 */
	@RequestMapping("importOrganizations4.do")
	public @ResponseBody Map<String, Object> importStep4(HttpServletRequest request, String path, String type) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> params = getUserLocaltion(request);
		    params.put("type", type);
			path = ApplicationProperties.getPropertyValue("upload_path")+ path.replace("/", File.separator);

			result = sysService.intoDB(path, "organization", super.getAccount(request), params);
			DataUtil.setOk(result);
		} catch (Exception e) {
			log.info("导入机构失败！");
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 跳转到系统功能设置页面
	 * 
	 * @author zxq
	 * @return
	 */
	@RequestMapping("toSysSetupPage.htm")
	public String toSysSetupPage() {
		return "system/sysSetupPage";
	}

	/**
	 * 系统设置--功能设置查询
	 * 
	 * @author zxq
	 * @return
	 */
	@RequestMapping("sysSetupInfo.do")
	public @ResponseBody Map<String, Object> sysSetupInfo(HttpServletRequest request) {
		log.info("系统管理员查看系统功能设置");
		String account = super.getAccount(request);
//		int roleId = super.getRoleId(request);
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			SysSetup pojo = sysService.selectSysSetupInfo();
			result.put("success", true);
			result.put("obj", pojo);
//			result.put("roleId", roleId);
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("系统管理员:" + account + " 查看系统功能设置失败");
		}
		return result;
	}

	/**
	 * 系统设置--功能设置修改
	 * 
	 * @author zxq
	 * @return
	 */
	@RequestMapping("modifySysSetup.do")
	public @ResponseBody Map<String, Object> modifySysSetup(HttpServletRequest request, String data) {
		log.info("系统管理员修改系统功能设置");
		String account = super.getAccount(request);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			SysSetup pojo = mapper.readValue(data, SysSetup.class);
			pojo.setUpdateBy(account);
			int rtn = sysService.modifySysSetup(pojo);
			if (rtn > 0) {
				result.put("success", true);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("系统管理员:" + account + " 修改系统功能设置失败");
		}
		return result;
	}

	@RequestMapping("delArea.do")
	public @ResponseBody Map<String, Object> deleteArea(int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (sysService.delArea(id)) {
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("areaInfo.do")
	public @ResponseBody
	Map<String, Object> queryAreaById(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			SysArea area = sysService.queryAreaByCode(id);
			result.put("obj", area);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("modifyArea.do")
	public @ResponseBody
	Map<String, Object> modifyArea(String areaCode, String name, int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("areaCode", areaCode);
		try {
			if (sysService.modifyArea(params, id)) {
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 检测上传的地区信息
	 */
	@RequestMapping("checkAreaData.do")
	public @ResponseBody
	Map<String, Object> checkAreaData(HttpServletRequest request,String path) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			result = sysService.parseExcel(projectPath + path, "area", null);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 提交上传的地区信息
	 */
	@RequestMapping("importAreaStep4.do")
	public @ResponseBody
	Map<String, Object> importAreaStep4(HttpServletRequest request, String path) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			
			path = projectPath + ApplicationProperties.getPropertyValue("upload_file_path")+ path.replace("/", File.separator);
			result = sysService.intoDB(path, "area", super.getAccount(request), null);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("toImprotAreaPage.htm")
	public String toImprotAreaPage() {
		return "system/uploadArea";
	}

	@RequestMapping("dataDetail.htm")
	public void dataDetail(HttpServletRequest request,
			HttpServletResponse response) {
		// response.setContentType("application/msexcel;charset=UTF-8");
		// response.setHeader("Content-Disposition","inline;filename="+new
		// Date().getTime()+".xlsx");
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		String fileName = request.getParameter("name");
		String path = ApplicationProperties.getPropertyValue("upload_file_path");
		String filePath = projectPath + path + fileName;
		FileUtils.downloadFile(filePath, response);

		// File file =new File(path+fileName);
		// InputStream is = null;
		// OutputStream os = null;
		// if(file.exists()){
		// try {
		// is = new FileInputStream(file);
		// os = response.getOutputStream();
		// byte[] bts = new byte[1024];
		// int i = -1;
		// while((i = is.read(bts)) != -1){
		// os.write(i);
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }finally{
		// try {
		// is.close();
		// os.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }

		// }
	}

	/**
	 * 角色管理-- 编辑权限跳转页面
	 * 
	 * @author cl
	 * @return
	 */
	@RequestMapping("toRoleInfoPage.htm")
	public String toRoleInfoPage(HttpServletRequest request) {
//		request.setAttribute("roleType", request.getParameter("roleType"));
		return "system/toRolePageInfo";
	}
	
	@RequestMapping("toViewRoleInfoPage.htm")
	public String toViewRoleInfoPage(HttpServletRequest request) {
		request.setAttribute("roleType", request.getParameter("roleType"));
		return "system/toViewRolePageInfo";
	}

	/**
	 * 获取系统模块及角色拥有的权限
	 * 
	 * @param startIndex
	 * @return
	 */
	@RequestMapping("sysFunctionWithRole.do")
	public @ResponseBody
	Map<String, Object> searchSysFunctionWithRole(HttpServletRequest request) {
		Map<String, Object> result = getViewAreaMap(request);
		try {
			if(request.getParameter("id")==null || request.getParameter("id").length()<=0){
				throw new Exception("角色ID 为空！");
			}
			Map<String, Object> info = new HashMap<String, Object>();
			List<SysFunction> list = sysService.selectSysFunction();
			List<SysFunction> listRole = sysService.searchSysFunctionRole(Integer.parseInt(request.getParameter("id")));
			info.put("func", list);
			info.put("role", listRole);
			result.put("success", true);
			result.put("obj", info);

		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 为角色设置权限，以及修改角色信息
	 * 
	 * @param startIndex
	 * @return
	 */
	@RequestMapping("setFunctionRole.do")
	public @ResponseBody
	Map<String, Object> SetSysFunctionWithRole(HttpServletRequest request) {
		Map<String, Object> result = getViewAreaMap(request);
		try {
			if(request.getParameter("id")==null || request.getParameter("id").length()<=0){
				throw new Exception("角色ID 为空！");
			}
			SysRole pojo=new SysRole();
			pojo.setId(Integer.parseInt(request.getParameter("id")));
			pojo.setStatus(Integer.parseInt(request.getParameter("status")));
			pojo.setRemark(request.getParameter("remark"));
			pojo.setRoleName(request.getParameter("roleName"));
			pojo.setUpdateBy(super.getAccount(request));
			int userId = super.getAccountId(request);
			List<SysRole> roleList=new ArrayList<SysRole>();
			if(request.getParameter("funcStr")!=null && request.getParameter("funcStr").length()>0){
				String[] roleStr=request.getParameter("funcStr").split(",");
				SysRole info=new SysRole();
				for(int i=0;i<roleStr.length;i++){
					info=new SysRole();
					info.setRoleId(pojo.getId());
					info.setFuncId(Integer.parseInt(roleStr[i]));
					info.setCreateById(userId);
					roleList.add(info);
				}
			}
			sysService.modifyRoleFcun(pojo, roleList);
			result.put("success", true);

		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			
			if(e.getMessage()=="-1"){
				result.put("flag", "-1");
				log.error("设置角色权限失败，更新角色信息失败!roleId:"+request.getParameter("id"));
			}else if(e.getMessage()=="-2"){
				result.put("flag", "-2");
				log.error("设置角色权限失败，删除角色现有的角色权限失败!roleId:"+request.getParameter("id"));
			}
			else if(e.getMessage()=="-3"){
				result.put("flag", "-3");
				log.error("设置角色权限失败，新增角色权限失败!roleId:"+request.getParameter("id"));
			}else{
				result.put("flag", "-0");
				log.error("设置角色权限失败!roleId:"+request.getParameter("id"));
			}
		}
		return result;
	}
	
	
	/**
	 * 跳转到系统平台设置页面
	 * @author 曉
	 * @return
	 */
	@RequestMapping("toSysPlatformSetupPage.htm")
	public String toSysPlatformSetupPage(){
		return "system/sysPlatformSetup";
	}
	
	
	/**
	 * 查询系统平台设置详情并写入session
	 * @author 曉
	 * @return
	 */
	@RequestMapping("platform/sysPlatformSetupInfo.do")
	public @ResponseBody Map<String, Object> sysPlatformSetupInfo(HttpServletRequest request){
		log.info("查询系统平台设置详情");
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			SysPlatformSetup pojo = sysService.selectSysPlatformSetup();
			
/*//			// 重新写入session
//			HttpSession session = request.getSession();
//			session.removeAttribute("platformSetup");
//			session.setAttribute("platformSetup", pojo);
*/			
			result.put("success", true);
			result.put("obj", pojo);
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			
			log.error("查看系统功能设置失败!" + e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * 修改系统平台设置
	 * @param pojo
	 * @param request
	 * @param response
	 * @param mrequest
	 * 
	 * @author 曉
	 */
	@RequestMapping("savePlatformSetup.do")
	public void savePlatformSetup(SysPlatformSetup pojo, HttpServletRequest request,HttpServletResponse response,MultipartHttpServletRequest mrequest){
		Map<String,Object> result = new HashMap<String,Object>();
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		String path = ApplicationProperties.getPropertyValue("platform_file_path");
		path = projectPath + path;
		try {
			MultipartFile sysLogoFile = mrequest.getFile("sysLogoFile");
			MultipartFile loginLogoFile = mrequest.getFile("loginLogoFile");
			if(sysLogoFile != null && sysLogoFile.getSize()>0){
				result = sysService.saveFile(path, sysLogoFile, null);
				pojo.setSysLogo("/"+result.get("filePath").toString());
			}
			if(loginLogoFile != null && loginLogoFile.getSize()>0){
				result = sysService.saveFile(path, loginLogoFile, null);
				pojo.setLoginLogo("/"+result.get("filePath").toString());
			}
			
			pojo.setUpdateBy(super.getAccount(request));
			
			if(sysService.updatePlatformSetup(pojo, path)){
				/* 重新写入session
				HttpSession session = request.getSession();
				session.removeAttribute("platformSetup");
				session.setAttribute("platformSetup", pojo);*/
				
				Common common = new Common();
				common.initByHand();
				
				result.put("success", true);
			}else{
				result.put("success", false);
			}
			response.getWriter().write(result.get("success").toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			
			log.error("修改系统平台设置失败--->"+e.getMessage());
		}
	}
	
	
	/**
	 * 导入地区数据
	 * @return
	 */
	@RequestMapping("fjimportMgr.htm")
	public String fjimportMgr(String id, ModelMap map) {
		map.put("id", id);
		return "system/fjimportMgr";
	}
	/**
	 * 导入能力提升数据
	 * @return
	 */
	@RequestMapping("fjimport.htm")
	public String fjimport() {
		return "system/fjimport";
	}
	
	/**
	 * 导入历史--能力提升数据
	 * @return
	 */
	@RequestMapping("fjimportHistory.htm")
	public String fjimportHistory() {
		return "system/fjimportHistory";
	}
	
	
	
	/**
	 * 福建继教能力提升数据导入检测
	 * @param request
	 * @param path
	 * @param type
	 * @return
	 */
	@RequestMapping("fjimport.do")
	public @ResponseBody Map<String, Object> fjimport(HttpServletRequest request,
			String path, String type) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			//Map<String, Object> param = new HashMap<String, Object>();
/*			Map<String, Object> param = getUserLocaltion(request);*/
			Map<String, Object> param = getDetailArea(request);
			//param.put("type", type);
			
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			result = sysService.parseExcel(projectPath + path, "fjimport", param);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("导入失败！" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 查询继教能力提升导入数据
	 * @param request
	 * @param id
	 * @param startIndex
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("fjimportList.do")
	public @ResponseBody Map<String, Object> fjimportList(HttpServletRequest request, Integer id,int startIndex) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(request.getParameter("schoolName"))) {
				param.put("schoolName", request.getParameter("schoolName"));
			}
			if (!StringUtils.isEmpty(request.getParameter("schoolProvinceId"))) {
				param.put("provinceId", request .getParameter("schoolProvinceId"));
			}

			if (!StringUtils.isEmpty(request.getParameter("schoolCityId"))) {
				param.put("cityId", request.getParameter("schoolCityId"));
			}
			if (!StringUtils.isEmpty(request.getParameter("schoolDistrictId"))) {
				param.put("districtId", request.getParameter("schoolDistrictId"));
			}
			param.put("id", id);
			param.put("proviceName", getUserProvinceName(request));
			param.put("cityName", getUserCityName(request));
			param.put("districtName", getUserDistrictName(request));
			//param.put("schoolName", getSchoolName(request));
			
			startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
			PageObject po;
			po = sysService.getFjimportListPage(param, startIndex, Common.PNN_USER_PAGE_LIMIT);
			//List<Fjimport> list = sysService.getFjimportList(param);
			List<Fjimport> list = (List<Fjimport>) po.getObjects();
			if(list == null || list.size() == 0) {
				DataUtil.setFail(result);
			}else {
				result.put("rows", list);
				result.put("total", po.getCount());
				result.put("pageSize", po.getPagesize());
				result.put("pages", po.getPages());
				result.put("currentPage", po.getCurrentPage());
				result.put("pageNumbers", po.getPageNumbers());
				result.put("startIndex", po.getStartIndex());
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("导入失败！" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 查询导入历史记录
	 * @param request
	 * @param startIndex
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("fjimportHistoryList.do")
	public @ResponseBody Map<String, Object> fjimportHistoryList(HttpServletRequest request,int startIndex) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		Date impDate= null, nextDay= null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");	
		String importDate = request.getParameter("importDate");
		if(!StringUtils.isEmpty(importDate)) {
			try {
				impDate = sdf1.parse(importDate);
				Calendar cal = Calendar.getInstance();
				cal.setTime(impDate);
				cal.add(Calendar.DATE, 1);
				nextDay = cal.getTime();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		param.put("importDate", impDate);
		param.put("nextDay", nextDay);
		String loginAccount = super.getAccount(request);
		param.put("loginAccount", loginAccount);
		param.put("historyType", "eduNltsTrainTeacher");
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		PageObject po;
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
			
			po = sysService.getFjimportHistoryListPage(param, startIndex, Common.PNN_USER_PAGE_LIMIT);
			List<FjimportHistory> list = (List<FjimportHistory>) po.getObjects();
			if(list == null || list.size() == 0) {
				DataUtil.setFail(result);
			}else {
				for(FjimportHistory h:list) {
					h.setCreateDateStr(sdf.format(h.getCreateDate()));
				}
				
				result.put("rows", list);
				 DataUtil.setOk(result);
				
			}
			result.put("total", po.getCount());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
			result.put("startIndex", po.getStartIndex());
		  
			
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("导入失败！" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 导入继教能力提升数据
	 * @param request
	 * @param path
	 * @param type
	 * @return
	 */
	@RequestMapping("importFJ4.do")
	public @ResponseBody Map<String, Object> importFJStep4(HttpServletRequest request, String path, String type) {
		Map<String, Object> result = new HashMap<String, Object>();
		//EduUserActivty obj =  getSessionUserInfo(request);
		try {
			Map<String, Object> params = getDetailArea(request);
		    params.put("type", type);
//			path = ApplicationProperties.getPropertyValue("upload_path")+ path.replace("/", File.separator);
		    
		    String projectPath = request.getSession().getServletContext().getRealPath("/");
			path = projectPath + ApplicationProperties.getPropertyValue("upload_file_path")+ path.replace("/", File.separator);

			result = sysService.intoDB(path, "fjimport", super.getAccount(request), params);
			DataUtil.setOk(result);
		} catch (Exception e) {
			log.info("导入能力提升数据失败！");
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 福建能力提升查询导入记录接口
	 * @param request
	 * @param path
	 * @param type 传入地区的名称
	 * @return
	 */
	@RequestMapping("/queryFJTeacherWorkInfo.do")
    public void query(HttpServletRequest request,HttpServletResponse response, Model model,String name,String code) {
        Map<String, Object> result = new HashMap<String, Object>();        
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("name", name);
            params.put("code", code);
            /**
             * 1,返回当前区域的Id 
             * 2,返回统计汇总结果(上报人数,登录人数,参训率,有效学习人数,学习率,合格人数,合格率发布资源数,组织活动数,工作坊数,提交作业数,项目简报)
             */
            List<FjTeacherStudyInfo> fjteacherInfo   = sysService.FJTeacherAchievements(params);
            response.setContentType("application/json; charset=utf-8");
            //将List对象转换为json对象
            JSONArray json = JSONArray.fromObject(fjteacherInfo); 
            String str = json.toString();//将json对象转换为字符串
            String callback = request.getParameter("callbackparam");             
            response.getWriter().write(callback + "(" + str + ")");           
        } catch (Exception e) {
            DataUtil.setFail(result);
            e.printStackTrace();
        }
        
    }
	
	/**
	 * 管理员: 导出教师信息模板，为学科学段政治面貌赋上默认值（从数据字典中查询）
	 * @param request
	 * @param path
	 */
	@RequestMapping("downFjTemplate.do")
	public void downTeachersTemplate(HttpServletRequest request,
			HttpServletResponse response) {
		//EduUserActivty user =  getSessionUserInfo(request);
		//int districtModel = userDistrictMode(user);
		
		//List<SysArea> provinceList = new ArrayList<SysArea>();
		//List<SysArea> cityList = new ArrayList<SysArea>();
		//List<SysArea> districtList = new ArrayList<SysArea>();
		//List<EduSchool> schoolList = new ArrayList<EduSchool>();
		
		/*switch(districtModel) {
			case 1: 
				provinceList = new ArrayList<SysArea>();
				SysArea pro = new SysArea();
				pro.setName(user.getUserProvinceName());
				provinceList.add(pro);
				
				cityList = sysService.getAreaListByUpcode(user.getUserProvinceId());
				districtList = sysService.getDistrictList();
			try {
				schoolList = schoolService.querySchoolList(null, null, Integer.valueOf(user.getUserProvinceId()), null, null, null);
			} catch (NumberFormatException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			} catch (Exception e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
				;break;
			case 2: 
				provinceList = new ArrayList<SysArea>();
				cityList = new ArrayList<SysArea>();
				SysArea pro1 = new SysArea();
				pro1.setName(user.getUserProvinceName());
				provinceList.add(pro1);
				
				SysArea city = new SysArea();
				city.setName(user.getUserCityName());
				cityList.add(city);
				
				districtList = sysService.getAreaListByUpcode(user.getUserCityId());
			try {
				schoolList = schoolService.querySchoolList(null, null,
						Integer.valueOf(user.getUserProvinceId()),
						Integer.valueOf(user.getUserCityId()), null, null);
			} catch (NumberFormatException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (Exception e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
				
				;break;
			case 3: 
				provinceList = new ArrayList<SysArea>();
				cityList = new ArrayList<SysArea>();
				SysArea pro2 = new SysArea();
				pro2.setName(user.getUserProvinceName());
				provinceList.add(pro2);
				
				SysArea city1 = new SysArea();
				city1.setName(user.getUserCityName());
				cityList.add(city1);
				
				SysArea district = new SysArea();
				district.setName(user.getUserDistrictName());
				districtList.add(district);
				
			try {
				schoolList = schoolService.querySchoolList(null, null, Integer.valueOf(user.getUserProvinceId()), 
						Integer.valueOf(user.getUserCityId()), Integer.valueOf(user.getUserDistrictId()), null);
			} catch (NumberFormatException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				
				;break;
			case 4: 
				provinceList = new ArrayList<SysArea>();
				cityList = new ArrayList<SysArea>();
				SysArea pro3 = new SysArea();
				pro3.setName(user.getUserProvinceName());
				provinceList.add(pro3);
				
				SysArea city2 = new SysArea();
				city2.setName(user.getUserCityName());
				cityList.add(city2);
				
				SysArea district1 = new SysArea();
				district1.setName(user.getUserDistrictName());
				districtList.add(district1);
				
			try {
				schoolList = schoolService.querySchoolList(user.getSchoolName(), null, 
						Integer.valueOf(user.getUserProvinceId()),
						Integer.valueOf(user.getUserCityId()), 
						Integer.valueOf(user.getUserDistrictId()), 
						user.getSchoolId());
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				;break;
			default:;break;
		}*/
		
		
		// 查找数据字典中学段
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dictionaryType", "school_type");//学校类型		
		paramMap.put("status", 1);//启用状态
		try {
			// 查找数据字典中学段			
			//List<SysDictionary> sysDictionaryList = dictionaryService.selectAllSysDictionaryList(paramMap);
			String path = request.getRealPath("/") + "template"
					+ File.separator + "fjimport.xls";

			FileInputStream io = new FileInputStream(path);
			// 创建 excel
			Workbook wb = new HSSFWorkbook(io);
			Sheet sheet = wb.getSheetAt(1);
			
			
			Row titleRow = sheet.getRow(0);
			//置空列
			//DataUtil.setColumEmpty(sheet, DataUtil.getIndex("省", titleRow),1);
			//DataUtil.setColumEmpty(sheet, DataUtil.getIndex("市", titleRow),1);
			//DataUtil.setColumEmpty(sheet, DataUtil.getIndex("区县", titleRow),1);
			//DataUtil.setColumEmpty(sheet, DataUtil.getIndex("学校", titleRow),1);
			
//			List<SysArea> provinceList;
//			List<SysArea> cityList;
//			List<SysArea> districtList;
//			List<EduSchool> schoolList;
			
			/*for(int i=0; i<provinceList.size(); i++) {
				Row row = sheet.getRow(i + 1);
				if (row == null) {
					row = sheet.createRow(i + 1);
				}
				Cell cellA = row.getCell(DataUtil.getIndex("省", titleRow));
				if(cellA == null){
					cellA = row.createCell(DataUtil.getIndex("省", titleRow));
				}
				cellA.setCellValue(provinceList.get(i).getName());
			}
			
			for(int i=0; i<cityList.size(); i++) {
				Row row = sheet.getRow(i + 1);
				if (row == null) {
					row = sheet.createRow(i + 1);
				}
				Cell cellA = row.getCell(DataUtil.getIndex("市", titleRow));
				if(cellA == null){
					cellA = row.createCell(DataUtil.getIndex("市", titleRow));
				}
				cellA.setCellValue(cityList.get(i).getName());
			}
			
			
			for(int i=0; i<districtList.size(); i++) {
				Row row = sheet.getRow(i + 1);
				if (row == null) {
					row = sheet.createRow(i + 1);
				}
				Cell cellA = row.getCell(DataUtil.getIndex("区县", titleRow));
				if(cellA == null){
					cellA = row.createCell(DataUtil.getIndex("区县", titleRow));
				}
				cellA.setCellValue(districtList.get(i).getName());
			}
			

			for(int i=0; i<schoolList.size(); i++) {
				Row row = sheet.getRow(i + 1);
				if (row == null) {
					row = sheet.createRow(i + 1);
				}
				Cell cellA = row.getCell(DataUtil.getIndex("学校", titleRow));
				if(cellA == null){
					cellA = row.createCell(DataUtil.getIndex("学校", titleRow));
				}
				cellA.setCellValue(schoolList.get(i).getSchoolName());
			}*/
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("provinceName", getUserProvinceName(request));
			params.put("cityName", getUserCityName(request));
			params.put("districtName", getUserDistrictName(request));
			
			// 此处查询继教能力提升最新的数据
			List<Fjimport> fjteacherInfo = sysService.queryFjimportList(params);
			Sheet sheet1 = wb.getSheetAt(0);
			for (int i = 0; i < fjteacherInfo.size(); i++) {
				Fjimport fjTeacher = fjteacherInfo.get(i);
				Row row = sheet1.createRow(i + 1);
				Cell cellA = row.createCell(0);
				cellA.setCellValue(fjTeacher.getCityName());

				Cell cellB = row.createCell(1);
				cellB.setCellValue(fjTeacher.getDistrictName());

				Cell cellC = row.createCell(2);
				cellC.setCellValue(fjTeacher.getSchoolName());

				Cell cellD = row.createCell(3);
				if(fjTeacher.getShangbaoNum() != null){
					cellD.setCellValue(fjTeacher.getShangbaoNum());
				}
				Cell cellE = row.createCell(4);
				cellE.setCellValue(fjTeacher.getDengluNum());
				Cell cellF = row.createCell(5);
				cellF.setCellValue(fjTeacher.getCanxunlv());
				Cell cellH = row.createCell(6);
				cellH.setCellValue(fjTeacher.getYouxiaoxuexiNum());
				Cell cellI = row.createCell(7);
				cellI.setCellValue(fjTeacher.getXuexilv());
				Cell cellJ = row.createCell(8);
				if(fjTeacher.getHegenum() != null){
					cellJ.setCellValue(fjTeacher.getHegenum());
				}
				Cell cellK = row.createCell(9);
				cellK.setCellValue(fjTeacher.getHegelv());
				Cell cellL = row.createCell(10);
				cellL.setCellValue(fjTeacher.getKechengzuoyeNum());
				Cell cellM = row.createCell(11);
				cellM.setCellValue(fjTeacher.getGongzuofangNum());
				Cell cellN = row.createCell(12);
				cellN.setCellValue(fjTeacher.getYanxiuhuodongNum());
				Cell cellO = row.createCell(13);
				cellO.setCellValue(fjTeacher.getYanxiuhuodongcanyuNum());
				Cell cellP = row.createCell(14);
				cellP.setCellValue(fjTeacher.getShijianyanxiuNum());
				Cell cellQ = row.createCell(15);
				cellQ.setCellValue(fjTeacher.getXiaomujianbaoNum());
			}
			
			exportExcelFromTemplet(request, response, wb, "fjimport","xls");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("下载能力提升模板错误:" + e);
		}
	}
	
	private int userDistrictMode(EduUserActivty user) {
		int districtMode = 0;
		  if(user.getUserProvinceId() != null){
			  districtMode++;
		  }
		  if(user.getUserCityId() != null) {
			  districtMode++;
		  }
		  if(user.getUserDistrictId() != null) {
			  districtMode++;
		  }
		  if(user.getSchoolId() != null) {
			  districtMode++;
		  }
		return districtMode;
	}
	
	//------------------------------------------------------------------------------------------------------
	public ObjectMapper mapper = new ObjectMapper();
	public JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
	}
	
	// 能力提升平台接口(将培训机构学员的成绩信息写入到系统中)
	@SuppressWarnings("unchecked")
	@RequestMapping("/inputTrainingInfo.json")
	public @ResponseBody Map<String, Object> getTrainingInfo(HttpServletRequest request,HttpServletResponse response, 
			Model model, String jsonData) {
		
		response.setContentType("application/json; charset=utf-8");
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> schoolList = new ArrayList<String>();
		String time = request.getParameter("time");
		//解析安全认证码,验证通过后处理请求数据
		String token = request.getParameter("token");
		String decrypt = "";
		try {
			decrypt = DesTool.decrypt(token, "nltsyxtj");
			result.put("orgInfo",decrypt);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//机构安全认证码集合
		Map<String, Object> tokenMap = new HashMap<String, Object>();
		//teacheredu
		tokenMap.put("63488EF571EAE54F2C0582D7603FBBC4","01:30:00-02:00:00");
		//yanxiuwang
		tokenMap.put("A1D7D3B534267BC56587191A12D73BD2","02:00:00-02:30:00");
		//aopengwang
		tokenMap.put("D82A1E41973F6927CDC29059582F110E","02:30:00-03:00:00");
		//jijiaowang
		tokenMap.put("4265A58D4BD62A86924E0F1C8EC9D26A","03:00:00-03:30:00");
		//gaojiaoshe
		tokenMap.put("E8D354E7F85869BEECE0AA67A8256689","03:30:00-04:00:00");
		if(tokenMap.get(token) == null || !DateUtil.isInDate(time, tokenMap.get(token).toString().split("-")[0], tokenMap.get(token).toString().split("-")[1])){
			result.put("Result", "FAIL");
			result.put("Message", "该统计执行不在系统指定时间内   " + time);
			sysService.insertSysLog(request, result);
			return result;
		}
			List<Fjimport> resultList = new ArrayList<Fjimport>();
			List<TrainingDTO> dataList = null;
			mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ; 
			JavaType javaType = getCollectionType(ArrayList.class,TrainingDTO.class);
			try {
				dataList = (List<TrainingDTO>) mapper.readValue(jsonData,javaType);
			} catch (Exception e) {
				e.printStackTrace();
				result.put("Result", "FAIL");
				result.put("Message", "json Parse Error");
				sysService.insertSysLog(request, result);
				return result;
			} 
			
			for (TrainingDTO dto : dataList) {
				dto.setCreateTime(new Date());
				result.put("schoolName", dto.getSchoolName());
				EduSchool school = null;
				try {
					school = schoolService.selectSchoolByName(result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Fjimport pojo = new Fjimport();
				if(null != school){
					try {
						result.put("schoolId", school.getSchoolId());
						result.put("eduModelName",Common.EDU_MODEL_SEARCH_STR);
						result.put("startYear",Common.START_YEAR);
						FjimportActivty fjimportActivty = sysService.getFjimportShangbaoNumAndHegeNum(result);
						if(null != fjimportActivty){
							// 上报人数
							pojo.setShangbaoNum(fjimportActivty.getShangbaoNum());
							// 合格人数
							pojo.setHegenum(fjimportActivty.getHegenum());
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					pojo.setProvinceId(school.getSchoolProvinceId().toString());
					pojo.setProvinceName(school.getSchoolProvinceName().toString());
					pojo.setCityId(school.getSchoolCityId().toString());
					pojo.setCityName(school.getSchoolCityName());
					pojo.setDistrictId(school.getSchoolDistrictId().toString());
					pojo.setDistrictName(school.getSchoolDistrictName());
					pojo.setSchoolId(school.getSchoolId().toString());
					pojo.setSchoolName(school.getSchoolName());
					pojo.setOrgName(decrypt);
					pojo.setCreateTime(new Date());
					// 登录人数
					pojo.setDengluNum(dto.getLoginNum());
					// 有效学习人数
					pojo.setYouxiaoxuexiNum(dto.getEffectiveNum());
					// 课程作业数
					pojo.setKechengzuoyeNum(dto.getCourseAssignments());
					// 工作坊数
					pojo.setGongzuofangNum(dto.getWorkShopNum());
					// 研修活动数
					pojo.setYanxiuhuodongNum(dto.getTrainingActivitiesNum());
					// 研修活动参与数
					pojo.setYanxiuhuodongcanyuNum(dto.getTrainingActivitiesJoinNum());
					// 实践研修成果数
					pojo.setShijianyanxiuNum(dto.getStudyResultsNum());
					// 项目简报数
					pojo.setXiaomujianbaoNum(dto.getProjectBriefNum());
					resultList.add(pojo);
				}else{
					schoolList.add(dto.getSchoolName());
				}
				
			}
			// 已经插入多少条数据
			try {
				int count = sysService.saveTrainingInfo(resultList);
				result.put("Result", "OK");
				result.put("Message", "学校统计结果录入成功! 插入成功" + count + "条数据!");
				if(schoolList.size() > 0){
					result.put("Message", schoolList+"学校在系统中不存在！ 插入成功" + count + "条数据!");
				}
				sysService.insertSysLog(request, result);
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				result.put("Result", "FAIL");
				result.put("Message", "学校统计结果录入失败！");
				sysService.insertSysLog(request, result);
				return result;
			}
	}
	
	@RequestMapping("eduTeacherTrainScore.htm")
	public String toEduTeacherScoreHistory() {
		return "system/eduTeacherTrainScoreHistory";
	}
	
	
	@RequestMapping("queryTeacherTraningScoreInfo.htm")
	public String toTeacherScoreCount(HttpServletRequest request,String id,String flag) {
		request.setAttribute("id", id);
		request.setAttribute("flag", flag);
		return "system/teacherTraningScoreList";
	}
	
	/**
	 * 导入培训学员信息
	 * @return
	 */
	@RequestMapping("importTeacherTrain.htm")
	public String importTeacherTrain() {
		return "system/importTeacherTrain";
	}
	
	/**
	 * 培训学员学情数据导入检测
	 * @param request
	 * @param path
	 * @param type
	 * @return
	 */
	@RequestMapping("checkTeacherTrainScore.do")
	public @ResponseBody Map<String, Object> checkTeacherTrainScore(HttpServletRequest request,String path, String type) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> param = getDetailArea(request);
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			result = sysService.parseExcel(projectPath + path, "import_teacher_train_score", param);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("培训学员学情数据导入检测失败！" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 导入培训学员学情数据
	 * @param request
	 * @param path
	 * @param type
	 * @return
	 */
	@RequestMapping("importTeacherTrainScore.do")
	public @ResponseBody Map<String, Object> importTeacherTrainScore(HttpServletRequest request, String path, String type) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> params = getDetailArea(request);
		    params.put("type", type);
		    
		    String projectPath = request.getSession().getServletContext().getRealPath("/");
			path = projectPath + ApplicationProperties.getPropertyValue("upload_file_path")+ path.replace("/", File.separator);

			result = sysService.intoDB(path, "import_teacher_train_score", super.getAccount(request), params);
			DataUtil.setOk(result);
		} catch (Exception e) {
			log.info("导入培训学员学情数据失败！");
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 查询导入历史记录
	 * @param request
	 * @param startIndex
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("queryTeacherTrainHistoryList.do")
	public @ResponseBody Map<String, Object> queryTeacherTrainHistoryList(HttpServletRequest request,int startIndex) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		Date impDate= null, nextDay= null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");	
		String importDate = request.getParameter("importDate");
		if(!StringUtils.isEmpty(importDate)) {
			try {
				impDate = sdf1.parse(importDate);
				Calendar cal = Calendar.getInstance();
				cal.setTime(impDate);
				cal.add(Calendar.DATE, 1);
				nextDay = cal.getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		param.put("importDate", impDate);
		param.put("nextDay", nextDay);
		param.put("historyType", "teacherTrainScore");
		String loginAccount = super.getAccount(request);
		param.put("loginAccount", loginAccount);
	
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
			
			PageObject po = sysService.getTeacherScoreHistoryListPage(param, startIndex, Common.PNN_USER_PAGE_LIMIT);
			List<FjimportHistory> list = (List<FjimportHistory>) po.getObjects();
			if(list == null || list.size() == 0) {
				DataUtil.setFail(result);
			}else {
				for(FjimportHistory h:list) {
					h.setCreateDateStr(sdf.format(h.getCreateDate()));
				}
				
				result.put("rows", list);
				 DataUtil.setOk(result);
				
			}
			result.put("total", po.getCount());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
			result.put("startIndex", po.getStartIndex());
		  
			
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("导入失败！" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	
	//学员推优意见（暂定为推优后不可更改）
	@RequestMapping("addTeacherScoreComment.do")
	public @ResponseBody Map<String, Object> addTeacherScoreComment(HttpServletRequest request, String idNumber,String comment, String status) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if(org.apache.commons.lang.StringUtils.isNotEmpty(idNumber)){
				result.put("idNumber", idNumber);
			}
			if(org.apache.commons.lang.StringUtils.isNotEmpty(comment)){
				result.put("pushComment", comment);
			}
			//EduTeacherScoreInfo eduTeacherSocre = sysService.getTeacherScoreInfoById(result);
			int count = sysService.updateTeacherScore(result);
			if(count != 0){
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
	
	//洮北区学分信息汇总查询	
	@RequestMapping("queryTeacherTraningScoreInfo.do")
	public @ResponseBody Map<String, Object> queryTeacherTraningScoreList(HttpServletRequest request, Integer id,String flag,int startIndex) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(request.getParameter("flag"))) {
				param.put("flag", request.getParameter("flag"));
			}
			if (!StringUtils.isEmpty(request.getParameter("idNumber"))) {
				param.put("idNumber", request.getParameter("idNumber").trim());
			}
			if (!StringUtils.isEmpty(request.getParameter("teacherName"))) {
				param.put("teacherName", request.getParameter("teacherName").trim());
			}
			if (!StringUtils.isEmpty(request.getParameter("schoolName"))) {
				param.put("schoolName", request.getParameter("schoolName").trim());
			}
			if(!StringUtils.isEmpty(request.getParameter("areaId")) && !StringUtils.isEmpty(request.getParameter("areaType"))){
				if(request.getParameter("areaType").equals("provinceId")){
					param.put("provinceId", request.getParameter("areaId"));
				}else if(request.getParameter("areaType").equals("cityId")){
					param.put("cityId", request.getParameter("areaId"));
				}else if(request.getParameter("areaType").equals("districtId")){
					param.put("districtId", request.getParameter("areaId"));
				}else if(request.getParameter("areaType").equals("schoolId")){
					param.put("schoolId", request.getParameter("areaId"));
				}	
			}
			
			param.put("id", id);
			param.put("proviceName", getUserProvinceName(request));
			param.put("cityName", getUserCityName(request));
			param.put("districtName", getUserDistrictName(request));
			
			startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
			PageObject pageList = sysService.getTeacherTrainScorePage(param, startIndex, Common.PNN_USER_PAGE_LIMIT);
			result.put("rows", pageList.getObjects());
			result.put("total", pageList.getCount());
			result.put("pageSize", pageList.getPagesize());
			result.put("pages", pageList.getPages());
			result.put("currentPage", pageList.getCurrentPage());
			result.put("pageNumbers", pageList.getPageNumbers());
			result.put("startIndex", pageList.getStartIndex());
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("学分信息汇总查询！" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("toTeacherTrainScore.htm")
	public String toTeacherTrainScore(HttpServletRequest request,String teacherId) {
		request.setAttribute("teacherId", teacherId);
		return "system/teacherProjectTrainScore";
	}
	
	/**
	 * 查询教师参培项目学分信息
	 * @param request
	 * @param id
	 * @param startIndex
	 * @return
	 */
	@RequestMapping("queryTeacherTraningScoreByTeacherId.do")
	public @ResponseBody Map<String, Object> queryTeacherTraningScoreByTeacherId(HttpServletRequest request,String teacherId,int startIndex,int pageSize) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("teacherId", teacherId);
			startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
			PageObject pageList = sysService.selectTeacherTrainScoreByTeacherId(param, startIndex, pageSize);
			result.put("rows", pageList.getObjects());
			result.put("total", pageList.getCount());
			result.put("startIndex", pageList.getStartIndex());
			result.put("pageSize", pageList.getPagesize());
			result.put("pages", pageList.getPages());
			result.put("currentPage", pageList.getCurrentPage());
			result.put("pageNumbers", pageList.getPageNumbers());
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("查询项目学分信息失败！" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	//导出学分汇总信息
	@RequestMapping("exportTeacherTraningScoreInfo.do")
	public @ResponseBody Map<String, Object> exportTeacherTraningScoreList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String schoolName = request.getParameter("schoolName").trim();
			String teacherIds = request.getParameter("teacherIds").trim();
			String teacherName = request.getParameter("teacherName").trim();
			String idNumber = request.getParameter("queryIdNumber").trim();
			String areaId = request.getParameter("areaId").trim();
			String areaType = request.getParameter("areaType").trim();
			
			Map<String,Object> paramMap = getCode(request);
			paramMap.put("id", request.getParameter("id"));
			if (!StringUtils.isEmpty(request.getParameter("flag"))) {
				paramMap.put("flag", request.getParameter("flag"));
			}
			if(!StringUtils.isEmpty(teacherIds)) {
				paramMap.put("teachers", teacherIds);
			}
			
			if(!StringUtils.isEmpty(idNumber)) {
				paramMap.put("idNumber", idNumber);
			}
			
			if (!StringUtils.isEmpty(teacherName)) {
				paramMap.put("teacherName", teacherName);
			}
			
			if (!StringUtils.isEmpty(schoolName)) {
				paramMap.put("schoolName", schoolName);
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
			
			paramMap.put("status", Common.DATA_VALID);
			// 2查询分页数据
			 List<EduTeacherScoreInfo> list = sysService.queryTeacherScoreListNoPage(paramMap);
			
			 String path = request.getRealPath("/")+"template"+File.separator+"download_teacher_train_score.xls";
			 
			 FileInputStream io = new FileInputStream(path);
			 // 创建 excel
			 Workbook wb = new HSSFWorkbook(io);
			 
			 Sheet sheet = wb.getSheetAt(0);
			 for (int i = 0; i < list.size(); i++) {
				 Row row = sheet.createRow(i + 1);
				 Cell cellA = row.createCell(0);
				 cellA.setCellValue(list.get(i).getTeacherName());
				 
				 Cell cellB = row.createCell(1);
				 cellB.setCellValue(list.get(i).getIdNumber());
				 
				 Cell cellC = row.createCell(2);
				 cellC.setCellValue(list.get(i).getSchoolName());
				 Cell cellE = row.createCell(3);
				 cellE.setCellValue(list.get(i).getTeacherSubject());
				 
				 Cell cellD = row.createCell(4);
				 cellD.setCellValue(list.get(i).getCourseWorkNum());
				 
				 Cell cellF = row.createCell(5);
				 cellF.setCellValue(list.get(i).getWorkShopNum());
				 
				 Cell cellG = row.createCell(6);
				 cellG.setCellValue(list.get(i).getTrainActivitNum());
				 
				 Cell cellH = row.createCell(7);
				 cellH.setCellValue(list.get(i).getTrainActivitJoinNum());
				 
				 Cell cellI = row.createCell(8);
				 cellI.setCellValue(list.get(i).getPracticeActivitNum());
				 
				 Cell cellJ = row.createCell(9);
				 cellJ.setCellValue(list.get(i).getProjectReportNum());
				 
				 Cell cellk = row.createCell(10);
				 cellk.setCellValue(list.get(i).getTotalScore());
				 
			 }
			 
			 exportExcelFromTemplet(request, response, wb, "download_teacher_train_score");

			 
		} catch (Exception e) {
			e.printStackTrace();
			log.error("学分汇总信息导出错误:" + e);
		}
		return result;
	}
	
	
	
	
	
}

