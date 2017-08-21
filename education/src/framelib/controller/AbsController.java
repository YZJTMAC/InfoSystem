package framelib.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.common.util.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import project.edupm.projectmanage.service.IEduProjectService;
import project.person.pojo.EduUserActivty;
import project.system.dao.ISysReadDAO;
import project.system.pojo.SysArea;
import project.system.pojo.SysSetup;
import project.system.service.ISysSchoolService;
import framelib.common.SessionData;
import framelib.utils.SessionUtil;

/**
 * Title:AbsController Description:
 * 
 * @Create_by:Vince Yu
 * @Create_date:2012-5-4
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public abstract class AbsController {

	private static WebApplicationContext wac = null;
	@Autowired
	@Qualifier("sysReadDAO")
	ISysReadDAO sysReadDAO; 
	
	@Autowired
	@Qualifier("schoolService")
	ISysSchoolService schoolService;
	
	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	protected Object getBean(String name, HttpServletRequest request) {
		ServletContext context = request.getSession().getServletContext();
		WebApplicationContext webApplicationContext = this.getWebApplicationContext(context);
		return webApplicationContext.getBean(name);
	}

	public void exportExcelFromTemplet(HttpServletRequest request, HttpServletResponse response, Workbook wb, String fileName) throws IOException {
		if(StringUtils.isEmpty(fileName)) {
			fileName = "exportExcel";
		}
		String headerStr =fileName;
		headerStr = new String(headerStr.getBytes("gb2312"), "iso-8859-1");// headerString为中文时转码   
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Disposition","attachment;filename="+headerStr+".xls");//指定下载的文件名
		/* response.setContentType("application/vnd.ms-excel"); */
		 response.setContentType("application/msexcel;charset=UTF-8"); 
		 wb.write(response.getOutputStream());
	}
	/**
	 * zhaobichao 2014-11-05 添加一个同名方法，就增加了一个文件类型，看是否导出xls、xls
	 * 
	 * @param request
	 * @param response
	 * @param wb
	 * @param fileName
	 * @param fileType
	 * @throws IOException
	 */
	public void exportExcelFromTemplet(HttpServletRequest request, HttpServletResponse response, Workbook wb, String fileName,String fileType) throws IOException {
		if(StringUtils.isEmpty(fileName)) {
			fileName = "exportExcel";
		}
		response.setHeader("Content-Disposition","attachment;filename="+fileName+"."+fileType);//指定下载的文件名
		 response.setContentType("application/vnd.ms-excel"); 
		 wb.write(response.getOutputStream());
	}
	
	/**
	 * web环境下运行时获取Spring的WebApplicationContext
	 * 
	 * @param context
	 *            ServletContext
	 * @return WebApplicationContext
	 */
	public synchronized WebApplicationContext getWebApplicationContext(ServletContext context) {
		if (context == null) {
			return null;
		}
		if (wac == null) {
			wac = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		}
		return wac;
	}

	/**
	 * 将对象转化成json 格式 并装配到 response
	 * 
	 * @param response
	 * @param obj
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void objectToJsonForResponse(HttpServletResponse response, Object obj) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mm = new ObjectMapper();
		String result = mm.writeValueAsString(obj);
		response.setContentType("application/x-json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	public void objectToTextForResponse(HttpServletResponse response, Object obj) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mm = new ObjectMapper();
		String result = mm.writeValueAsString(obj);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}



	public SessionData getSessionData(HttpServletRequest request) {
		SessionData sessionData = SessionUtil.getSessionData(request);
		return sessionData;
	}
	
	/**
	 * 获取登录人的可视范围
	 * @return
	 */
	public Map<String , Object> getViewAreaMap(HttpServletRequest request) {
		 Map<String , Object> parm = new HashMap<String , Object>();
		 EduUserActivty obj = getSessionUserInfo(request);
		 if(!StringUtils.isEmpty(obj.getUserDistrictId())) {
			 parm.put("districtId", obj.getUserDistrictId());
			 return parm;
		 } else if(!StringUtils.isEmpty(obj.getUserCityId())) {
			 parm.put("cityId", obj.getUserCityId());
			 return parm;
		 } else if(!StringUtils.isEmpty(obj.getUserProvinceId())) {
			 parm.put("provinceId", obj.getUserProvinceId());
			 return parm;
		 } else {
			 parm.put("seeNoThing", "1=2");
		 }
		 return parm;
	}
	
	public EduUserActivty getSessionUserInfo(HttpServletRequest request) {
		EduUserActivty obj = (EduUserActivty) request.getSession().getAttribute("userinfo");
		return obj;
	}
	/**
	 * 获取登录名
	 * @param request
	 * @return String
	 * @author zhangBo
	 * @Last_Edit_By
	 * @Create_date:2014-3-25
	 * @version:1.0
	 */
	public String getAccount(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getLoginAccount();
		} else {
			return null;
		}
		
	}
	
	/**
	 * 获取登录人的id
	 * @param request
	 * @return int
	 * @author zxq
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public int getAccountId(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getUserId();
		} else {
			return 0;
		}
	}
	
	/**
	 * 获取登录人的姓名
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public String getRealName(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getRealName();
		} else {
			return "";
		}
	}
	
	/**
	 * 获取登录人角色名称
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public String getRoleName(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getRoleName();
		} else {
			return "";
		}
	}
	
	/**
	 * 获取登录人所属城市
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public String getUserCityName(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getUserCityName();
		} else {
			return "";
		}
	}
	
	/**
	 * 获取登录人的所属省
	 * @author yinxiaolong
	 * @param request
	 * @return
	 */
	public String getUserProvinceName(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getUserProvinceName();
		} else {
			return "";
		}
	}
	/**
	 * 获取登录人的所属区
	 * @author yinxiaolong
	 * @param request
	 * @return
	 */
	public String getUserDistrictName(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getUserDistrictName();
		} else {
			return "";
		}
	}
	
	/**
	 * 获取登录人的所属区学校
	 * @author cl
	 * @param request
	 * @return
	 */
	public String getSchoolName(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getSchoolName();
		} else {
			return "";
		}
	}
	
	/**
	 * 获取机构id
	 * @author yinxiaolong
	 * @param request
	 * @return
	 */
	public Integer getOrganizationId(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getOrganizationId();
		} else {
			return 0;
		}
	}
	/**
	 * 获取登录人学校ID
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public Integer getSchoolId(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getSchoolId();
		} else {
			return 0;
		}
	}
	
	/**
	 * 获取登录人省份ID
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public String getUserProvinceId(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getUserProvinceId();
		} else {
			return "0";
		}
	}
	
	/**
	 * 获取登录人城市ID
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public String getUserCityId(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getUserCityId();
		} else {
			return "0";
		}
	}
	
	/**
	 * 获取登录人区ID
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public String getUserDistrictId(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getUserDistrictId();
		} else {
			return "0";
		}
	}
	
	/**
	 * 获取登录人邮箱
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public String getUserMail(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getMail();
		} else {
			return "";
		}
	}
	
	/**
	 * 获取登录人手机
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public String getUserMobile(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getMobile();
		} else {
			return "";
		}
	}
	
	/**
	 * 获取登录人身份证
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public String getUserIdCard(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getIdNumber();
		} else {
			return "";
		}
	}
	
	/**
	 * 获取登录人密保问题
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public Integer getUserPaswdQuestionType(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getPaswdQuestionType();
		} else {
			return 0;
		}
	}
	
	/**
	 * 获取登录人角色ID
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-10
	 * @version:1.0
	 */
	public Integer getRoleId(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getRoleId();
		} else {
			return 0;
		}
	}
	
	public Integer getRoleTypeId(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getRoleTypeId();
		} else {
			return 0;
		}
	}
	
	/**
	 * 获取登录人密保答案
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public String getUserPaswdAnswer(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getPaswdAnswer();
		} else {
			return "";
		}
	}
	
	/**
	 * 获取登录人登录密码
	 * @param request
	 * @return string
	 * @author cl
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public String getUserPassword(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null){
			return obj.getPassword();
		} else {
			return "";
		}
	}
	
	/**
	 * 根据登陆人roleId获取相应地区code
	 * @param request
	 * @return Map<String, Object>
	 * @author zxq
	 * @Last_Edit_By
	 * @Create_date:2014-04-04
	 * @version:1.0
	 */
	public Map<String, Object> getCode(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(obj!=null){
			int userId = obj.getUserId();
			int roleId = obj.getRoleId();
			paramMap.put("userid", userId);
			if(roleId == 1 || roleId == 7){// 省管理员/省实施机构管理员
				paramMap.put("provinceId", obj.getUserProvinceId());
				paramMap.put("areaId", obj.getUserProvinceId());
				paramMap.put("areaName", obj.getUserProvinceName()); 
				paramMap.put("areaType", "provinceId"); 
				paramMap.put("role", 1);
			} else if(roleId == 2 || roleId == 8){// 市管理员/市实施机构管理员
				paramMap.put("cityId", obj.getUserCityId());
				paramMap.put("areaId", obj.getUserCityId());
				paramMap.put("areaName", obj.getUserCityName());
				paramMap.put("areaType", "cityId"); 
				paramMap.put("role", 2);
			} else if(roleId == 3 || roleId == 9){// 区管理员/区实施机构管理员
				paramMap.put("districtId", obj.getUserDistrictId());
				paramMap.put("areaId", obj.getUserDistrictId());
				paramMap.put("areaName", obj.getUserDistrictName());
				paramMap.put("areaType", "districtId"); 
				paramMap.put("role", 3);
			} else if(roleId == 4 || roleId == 10){// 校管理员/校实施机构管理员
				paramMap.put("schoolId", obj.getSchoolId());
				paramMap.put("areaId", obj.getSchoolId());
				paramMap.put("areaName", obj.getSchoolName());
				paramMap.put("areaType", "schoolId"); 
				paramMap.put("role", 4);
			}
			paramMap.put("roleId", roleId);
			return paramMap;
		} else {
			return null;
		}
	}
	
	public Map<String, Object> getUserLocaltion(HttpServletRequest request){
		EduUserActivty obj =  getSessionUserInfo(request);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(obj!=null){
			if(obj.getUserProvinceId() != null || obj.getUserProvinceName() != null) {
				paramMap.put("provinceId", obj.getUserProvinceId());
				paramMap.put("provinceName", obj.getUserProvinceName()); 
			}
			
			if(obj.getUserCityId() != null || obj.getUserCityName() != null) {
				paramMap.put("cityId", obj.getUserCityId());
				paramMap.put("cityName", obj.getUserCityName());
			}
			
			if(obj.getUserDistrictId() != null || obj.getUserDistrictName() != null) {
				paramMap.put("districtId", obj.getUserDistrictId());
				paramMap.put("districtName", obj.getUserDistrictName());
			}
			
			if(obj.getSchoolId() != null || obj.getSchoolName() != null) {
				paramMap.put("schoolId", obj.getSchoolId());
				paramMap.put("schoolName", obj.getSchoolName());
			}
			return paramMap;
		} else {
			return null;
		}
	}
	
	
	/**
	 * 系统功能设置
	 * @param request
	 * @author zxq
	 * @Create_date:2014-04-15
	 * @version:1.0
	 */
	public SysSetup getSessionSysSetup(HttpServletRequest request) {
		SysSetup obj = (SysSetup) request.getSession().getAttribute("sysSetup");
		return obj;
	}
	
	
	/**
	 * 可用登录方式(1:身份证号, 2:用户名, 3:教师编号)
	 * @author zxq
	 * @param request
	 * @Create_date:2014-04-15
	 * @return
	 */
	public List<String> getAccountType(HttpServletRequest request){
		List<String> list = new ArrayList<String>();
		String accountType = getSessionSysSetup(request).getAccountType();
		for(int i=0; i<(accountType.length()+1)/2; i++){
			list.add(accountType.split(",")[i]);
		}
		return list;
	}
	
	
	/**
	 * 是否关闭教师登录(1: 不关闭, 0:关闭)
	 * @author zxq
	 * @param request
	 * @Create_date:2014-04-15
	 * @return
	 */
	public int getUseTeacherRole(HttpServletRequest request){
		int useTeacherRole = getSessionSysSetup(request).getUseTeacherRole();
		return useTeacherRole;
	}
	
	/**
	 * 是否关闭承培机构登录(1: 不关闭, 0:关闭)
	 * @author zxq
	 * @param request
	 * @Create_date:2014-04-15
	 * @return
	 */
	public int getEnableOrg(HttpServletRequest request){
		int enableOrg = getSessionSysSetup(request).getEnableOrg() == null ? 0 :getSessionSysSetup(request).getEnableOrg();
		return enableOrg;
	}
	
	
	/**
	 * 是否开放注册教师(1:是 0:否)
	 * @author zxq
	 * @param request
	 * @Create_date:2014-04-15
	 * @return
	 */
	public int getOpenRegisterTeacher(HttpServletRequest request){
		int openRegisterTeacher = getSessionSysSetup(request).getOpenRegisterTeacher();
		return openRegisterTeacher;
	}
	
	
	/**
	 * 教师信息变动审核(1: 允许同级审核, 0: 不允许)(包括：教师信息审核、调动审核、离退休审核等等) 
	 * @author zxq
	 * @param request
	 * @Create_date:2014-04-28
	 * @return
	 */
	public int getTeacherInfoChangeAudit(HttpServletRequest request){
		int teacherInfoChangeAudit = getSessionSysSetup(request).getTeacherInfoChangeAudit();
		return teacherInfoChangeAudit;
	}
	
	
	/**
	 * 教师信息导出安全(1: 允许查看/导出身份证号和手机号, 0: 不允许)
	 * @author zxq
	 * @param request
	 * @Create_date:2014-04-28
	 * @return
	 */
	public int getTeacherInfoSafe(HttpServletRequest request){
		int teacherInfoSafe = getSessionSysSetup(request).getTeacherInfoSafe();
		return teacherInfoSafe;
	}
	
	
	/**
	 * 教师信息变更审核项(1:教师资格证书号, 2:任教时间, 3: (评)教师职称, 4: (聘)教师职称 5: 学校行政职务, 
	 * 			   6: 当前任教学段学科, 7: 是否骨干教师, 8: 是否班主任, 9: 国培计划农村骨干教师)
	 * @author zxq
	 * @param request
	 * @Create_date:2014-04-15
	 * @return
	 
	public List<String> getTeacherInfoChangeAudit(HttpServletRequest request){
		List<String> list = new ArrayList<String>();
		String teacherInfoChangeAudit = getSessionSysSetup(request).getTeacherInfoChangeAudit().toString();
		for(int i=0; i<(teacherInfoChangeAudit.length()+1)/2; i++){
			list.add(teacherInfoChangeAudit.split(",")[i]);
		}
		return list;
	}
	*/
	
	
	/**
	 * 无效, 不再使用
	 * 
	 * 教师信息审核级别(4: 校级, 2: 区县级, 2: 市级, 1: 省级)
	 * @author zxq
	 * @param request
	 * @Create_date:2014-04-15
	 * @return
	 */
	@Deprecated
	public List<String> getTeacherInfoAuditLevel(HttpServletRequest request){
		List<String> list = new ArrayList<String>();
		String teacherInfoAuditLevel = getSessionSysSetup(request).getTeacherInfoAuditLevel();
		for(int i=0; i<(teacherInfoAuditLevel.length()+1)/2; i++){
			list.add(teacherInfoAuditLevel.split(",")[i]);
		}
		return list;
	}
	
	
	/**
	 * 无效, 不再使用
	 * 
	 * 调动审核级别(0:不审核, 3: 区县级, 2: 市级, 1: 省级)
	 * @author zxq
	 * @param request
	 * @Create_date:2014-04-15
	 * @return
	 */
	@Deprecated
	public List<String> getTransferAuditLevel(HttpServletRequest request){
		List<String> list = new ArrayList<String>();
		String transferAuditLevel = getSessionSysSetup(request).getTransferAuditLevel();
		for(int i=0; i<(transferAuditLevel.length()+1)/2; i++){
			list.add(transferAuditLevel.split(",")[i]);
		}
		return list;
	}
	
	
	/**
	 * 无效, 不再使用
	 * 
	 * 离退休审核级别(0:不审核, 3: 区县级, 2: 市级, 1: 省级)
	 * @author zxq
	 * @param request
	 * @Create_date:2014-04-15
	 * @return
	 */
	@Deprecated
	public List<String> getRetiredAuditLevel(HttpServletRequest request){
		List<String> list = new ArrayList<String>();
		String retiredAuditLevel = getSessionSysSetup(request).getRetiredAuditLevel();
		for(int i=0; i<(retiredAuditLevel.length()+1)/2; i++){
			list.add(retiredAuditLevel.split(",")[i]);
		}
		return list;
	}
	
	
	/**
	 * 无效, 不再使用
	 * 
	 * 继教信息审核级别(0:不审核, 3: 区县级, 2: 市级, 1: 省级)
	 * @author zxq
	 * @param request
	 * @Create_date:2014-04-15
	 * @return
	 */
	@Deprecated
	public List<String> getFurthereduAuditLevel(HttpServletRequest request){
		List<String> list = new ArrayList<String>();
		String furthereduAuditLevel = getSessionSysSetup(request).getFurthereduAuditLevel();
		for(int i=0; i<(furthereduAuditLevel.length()+1)/2; i++){
			list.add(furthereduAuditLevel.split(",")[i]);
		}
		return list;
	}
	
	
	/**
	 * 无效, 不再使用
	 * 
	 * 年度考核设定所在级别(4:校级, 3: 区县级, 2: 市级, 1: 省级, 0: 不限制)
	 * @author zxq
	 * @param request
	 * @Create_date:2014-04-15
	 * @return
	 */
	@Deprecated
	public List<String> getYearAppraisalLevel(HttpServletRequest request){
		List<String> list = new ArrayList<String>();
		String yearAppraisalLevel = getSessionSysSetup(request).getYearAppraisalLevel();
		for(int i=0; i<(yearAppraisalLevel.length()+1)/2; i++){
			list.add(yearAppraisalLevel.split(",")[i]);
		}
		return list;
	}
	
	/**
	 * 通过roleId 获取登录人areaId
	 * @param request
	 * @return
	 */
	public String getUserAreaId(HttpServletRequest request){
		String areaId = "";
		EduUserActivty obj =  getSessionUserInfo(request);
		int roleId = obj.getRoleId();
		if(roleId == 1 || roleId == 7){
			areaId = obj.getUserProvinceId();
		}else if(roleId == 2 || roleId == 8){
			areaId = obj.getUserCityId();
		}else if(roleId == 3 || roleId == 9){
			areaId = obj.getUserDistrictId();
		}else if(roleId == 4){
			areaId = obj.getSchoolId().toString();
		}
		return areaId;
	}
	
	
	/**
	 * 获取机构id
	 * @param request
	 * @return
	 */
	public Integer getOrgId(HttpServletRequest request) {
		EduUserActivty obj =  getSessionUserInfo(request);
		if(obj!=null && obj.getOrganizationId() != null){
			return obj.getOrganizationId();
		} else {
			return 0;
		}
	}
	
	  /*
	   * 生成继教板块编码
	   * 继教信息板块编码规则
	   *  * 一、继教信息板块编码（共12位） 编码规则：培训级别代码（2位）+年份代码（2位）+地区代码（6位）+版块序号（2位）
		 * 编码示例：GP1535000001 编码说明： 1.
		 * 培训级别有六类，国家级培训（GP）、省级培训（SP）、地市级培训（DP）、区县级培训（XP）、校本培训（XB）、其它培训（OP）； 2.
		 * 年份代码按年份编排，15代表2015年，以后年份依次顺延； 3.
		 * 地区代码以全国统一地区编码为准，例如350000代表福建省、350100代表福州、350102代表鼓楼区； 4.
		 * 版块序号，从01-99系统自动排序。
	   */
	 public String getRegionCoding(String code,HttpServletRequest request) throws Exception{String ScopeId = null;
		String areaCode = null;
		String model = null;
		String modelCode = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		EduUserActivty obj = getSessionUserInfo(request);
		if (obj.getRoleId() == 1) {
			ScopeId = this.getUserProvinceId(request);
		} else if (obj.getRoleId() == 2) {
			ScopeId = this.getUserCityId(request);
		} else if (obj.getRoleId() == 3) {
			ScopeId = this.getUserDistrictId(request);
		} else {
			return modelCode;
		}
		/*
		 * else if(obj.getRoleId()==4){ Integer sd =this.getSchoolId(request);
		 * EduSchool sc=schoolService.searchSchoolInfo(sd); }
		 */

		if (ScopeId != null) {
			if (code.equals("1")) {
				model = "GP";
			} else if (code.equals("2")) {
				model = "SP";
			} else if (code.equals("3")) {
				model = "DP";
			} else if (code.equals("4")) {
				model = "XP";
			} else if (code.equals("5")) {
				model = "XB";
			} else {
				model = "OP";
			}
		} else {
			return modelCode;
		}
		//根据区ID查询区信息
		SysArea areaInfo = sysReadDAO.selectAreaByProScopeId(ScopeId);
		if (areaInfo != null) {
			areaCode = areaInfo.getAreaCode();
			Calendar calendar = Calendar.getInstance();
			String year = (calendar.get(Calendar.YEAR) + "").substring(2, 4);

			//查询最后一条的模板编码，最后两位加1
			String lastModeCode = eduProjectService.qryModelInfo(resultMap);
			//如果为空，就从01开始
			String lastCode = "01";			
			DecimalFormat df = new DecimalFormat("00");  
			if (lastModeCode !=null && lastModeCode.length()>=12) {
				lastCode = df.format((Integer.parseInt((lastModeCode.substring(10,lastModeCode.length()))) + 1));
				modelCode = model + year + areaCode + lastCode;
			} else {
				modelCode = model + year + areaCode + lastCode;
			}

		}
		else{
			return modelCode;
		}
		return modelCode;
	}
	 
	 /**
	  * 通过roleId 获取登录人所属区域
	  * @param request
	  * @return
	  */
	 public Map<String, Object> getArea(HttpServletRequest request){
		 EduUserActivty obj =  getSessionUserInfo(request);
		 Map<String, Object> paramMap = new HashMap<String, Object>();
		 if(obj!=null){
			 int roleId = obj.getRoleId();
			 if(roleId == 1 || roleId == 7){
				 paramMap.put("provinceId", obj.getUserProvinceId());
			 }else if(roleId == 2 || roleId == 8){
				 paramMap.put("provinceId", obj.getUserProvinceId());
				 paramMap.put("cityId", obj.getUserCityId());
			 }else if(roleId == 3 || roleId == 9){
				 paramMap.put("provinceId", obj.getUserProvinceId());
				 paramMap.put("cityId", obj.getUserCityId());
				 paramMap.put("districtId", obj.getUserDistrictId());
			 }else if(roleId == 4 || roleId == 10){
				 paramMap.put("provinceId", obj.getUserProvinceId());
				 paramMap.put("cityId", obj.getUserCityId());
				 paramMap.put("districtId", obj.getUserDistrictId());
				 paramMap.put("schoolId", obj.getSchoolId());
			 }
			 return paramMap;
			 
		}else{
			return null;
		}
	} 
	 
	 /**
	  * 获取登录用户所属的区域详细信息
	  * @param request
	  * @return
	  */
	 public Map<String, Object> getDetailArea(HttpServletRequest request){
		 EduUserActivty obj =  getSessionUserInfo(request);
		 Map<String, Object> paramMap = new HashMap<String, Object>();
		 if(obj!=null){
			 //省行政管理员/省实施机构管理员
			 paramMap.put("provinceId", obj.getUserProvinceId());
			 paramMap.put("provinceName", obj.getUserProvinceName());
			 
			 int roleId = obj.getRoleId().intValue();
			 if(roleId == 2 || roleId == 8){
				 paramMap.put("cityId", obj.getUserCityId());
				 paramMap.put("cityName", obj.getUserCityName());
			 }else if(roleId == 3 || roleId == 9){
				 paramMap.put("cityId", obj.getUserCityId());
				 paramMap.put("cityName", obj.getUserCityName());
				 paramMap.put("districtId", obj.getUserDistrictId());
				 paramMap.put("districtName", obj.getUserDistrictName());
			 }else if(roleId == 4){
				 paramMap.put("cityId", obj.getUserCityId());
				 paramMap.put("cityName", obj.getUserCityName());
				 paramMap.put("districtId", obj.getUserDistrictId());
				 paramMap.put("districtName", obj.getUserDistrictName());
				 paramMap.put("schoolId", obj.getSchoolId());
				 paramMap.put("schoolName", obj.getSchoolName());
			 }
			 return paramMap;
			 
		}else{
			return null;
		}
	} 
}



 
