package project.person.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.common.Common;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.service.IEduProjectService;
import project.furtheredu.certificate.pojo.EduDiploma;
import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;
import project.person.pojo.EduUserForgotpassword;
import project.person.service.IUserForgotpasswordService;
import project.person.service.IUserService;
import project.system.pojo.EduSchool;
import project.system.pojo.SysArea;
import project.system.pojo.SysRole;
import project.system.pojo.SysRoleFuncActivty;
import project.system.pojo.SysSetup;
import project.system.service.ISysSchoolService;
import project.system.service.ISysService;
import project.teacher.teacherProject.service.ITeacherProjectServiceIF;
import project.teacher.teachermanage.pojo.EduProjectCommentTeacher;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.service.ITeacherManageService;
import project.util.ApplicationProperties;
import project.util.DataUtil;
import project.util.DateUtil;
import project.util.DesTool;
import project.util.FileUtil;
import project.util.MailSender;
import project.util.SendHttpRequest;
import framelib.controller.AbsController;
import framelib.utils.page.PageObject;

@Controller
@RequestMapping("/person")
public class UserController extends AbsController {
	private static final Logger log = Logger.getLogger(UserController.class);

	@Autowired
	@Qualifier("userService")
	IUserService userService;

	@Autowired
	@Qualifier("sysService")
	ISysService sysService;

	@Autowired
	@Qualifier("schoolService")
	ISysSchoolService schoolService;

	@Autowired
	@Qualifier("userForgotpasswordService")
	IUserForgotpasswordService userForgotpasswordService;

	@Autowired
	@Qualifier("teacherManageService")
	ITeacherManageService teacherManageService;
	
	@Autowired
	@Qualifier("teacherProjectService")
	ITeacherProjectServiceIF teacherProjectServiceIF;
	
	/**
	 * 登录入口
	 * 
	 * @author cl
	 * @create date 2013-4-3
	 * @return
	 */
	@RequestMapping("/login.htm")
	public String toLoginPage(HttpServletRequest request) {

		try {
			StringBuffer uri = request.getRequestURL();
			HttpSession session = request.getSession();
			// 系统功能
			SysSetup pojo = sysService.selectSysSetupInfo();
			if (pojo == null) {
				pojo = new SysSetup();
			}
			session.setAttribute("sysSetup", pojo);
			request.setAttribute("type", super.getOpenRegisterTeacher(request));
			
			EduUserActivty userInfo = (EduUserActivty) session.getAttribute("userinfo");
			//首次登陆系统提示修改密码,修改成功跳转到登陆页面并且销毁session(之前密码修改跳转没有移除session导致用户无法退出系统)
			if(uri.indexOf("/setPersonPsd") < 0 && uri.indexOf("/personPsdPage") < 0  && uri.indexOf("/getMessageCounts") < 0 ) {
				request.getSession().invalidate();
			}
			if(userInfo !=null){
				return "person/index";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("系统运行错误，错误信息：" + e.getMessage());
		}

		return "person/login";
	}

	/**
	 * 首页入口
	 * 
	 * @author cl
	 * @create date 2013-4-3
	 * @return
	 */
	@RequestMapping("/index.htm")
	public String toIndexPage() {
		return "person/index";
	}

	/**
	 * 首页入口
	 * 
	 * @author cl
	 * @create date 2013-4-3
	 * @return
	 */
	@RequestMapping("/index1.htm")
	public String toIndexPage1() {
		return "person/index1";
	}

	/**
	 * 首页入口
	 * 
	 * @author cl
	 * @create date 2013-4-3
	 * @return
	 */
	@RequestMapping("/index2.htm")
	public String toIndexPage2() {
		return "person/index2";
	}

	/**
	 * 首页入口
	 * 
	 * @author cl
	 * @create date 2013-4-3
	 * @return
	 */
	@RequestMapping("/index3.htm")
	public String toIndexPage3() {
		return "person/index3";
	}

	/**
	 * 首页入口
	 * 
	 * @author cl
	 * @create date 2013-4-3
	 * @return
	 */
	@RequestMapping("/index4.htm")
	public String toIndexPage4() {
		return "person/index4";
	}
	
	/**
	 * 首页入口
	 * 
	 * @author cl
	 * @create date 2017-7-31
	 * @return
	 */
	@RequestMapping("/index5.htm")
	public String toIndexPage5() {
		return "person/index5";
	}

	/**
	 * 验证用户登录
	 * 
	 * @author cl
	 * @create date 2014-4-3
	 * @param request
	 * @return
	 * @modify liuyiyou
	 * @desc 教师处于病休、离岗、离退休、死亡状态时不可以登录系统
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/login/exitsUser.do")
	@ResponseBody
	public   JSONObject getUserInfo(HttpServletRequest request) {
//		Map<String, Object> pageInfo = new HashMap<String, Object>();
		JSONObject result = new JSONObject();
		HttpSession session = request.getSession();
		
		
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			String password = request.getParameter("password");
			String loginAccount = request.getParameter("loginAccount");
			if (password.length() == 0) {
				result.put("info", "登录密码为空！");
				result.put("success", false);
				//pageInfo.put("flag", "-1");
				//throw new Exception("登录密码为空！");
				return result;
				
			}
			if (loginAccount.length() == 0) {
				result.put("info", "登录帐号为空！");
				result.put("success", false);
//				pageInfo.put("flag", "-2");
//				throw new Exception("登录帐号为空！");
				return result;
			}
			param.put("status", 0);
			param.put("loginAccount", loginAccount);
			param.put("password", password);
			EduUserActivty info = userService.queryUserInfoByloginAccountAndPsd(param);
			
			if (info == null) {
				result.put("info", "用户名或密码错误！");
				result.put("success", false);
				return result;
//				pageInfo.put("flag", "-3");
//				throw new Exception("用户名或密码错误！");
			}
			
			//***********************************
			
			// 用于福建网络研修社区单点登录,这里将用户id,idno,密钥token参数发送请求用于对方认证身份信息
			String idno = info.getIdNumber();
			if(idno == null){
				idno = "";
			}
			String userId = info.getUserId().toString();
			String pwd = info.getPassword();
			String tn = info.getRealName();
			// 将参数拼接后进行加密处理
			String para = "un="+loginAccount+"&uid="+userId+"&idno="+idno+"&tn="+tn+"&pwd="+pwd+"";
			// 将加密的参数进行url转码,防止发送中文参数进行解析后产生乱码
			para = java.net.URLEncoder.encode(para, "utf-8").toLowerCase(); 
			// 生成密钥的key(双方约定)
			String key = "fjyxtedu"; 
			String des_param = DesTool.toHexString(DesTool.encrypt(para, key)).toUpperCase(); 
			session.setAttribute("des_param", des_param);
			session.setAttribute("token", "586F6783FB86EC878D7CFA324331E63C");
	    
	    //***********************************
			
			// 系统功能
			if(session.getAttribute("sysSetup")==null){
				SysSetup pojo = sysService.selectSysSetupInfo();
				if (pojo == null) {
					pojo = new SysSetup();
				}
				session.setAttribute("sysSetup", pojo);
			}
			

			// 可用登录方式(1:身份证号, 2:用户名, 3:教师编号)
			List<String> isLogin = super.getAccountType(request);
			String isLoginStr = "";
			for (int i = 0; i < isLogin.size(); i++) {
				isLoginStr += isLogin.get(i).toString() + ",";
			}

			if (isLoginStr == "") {
				result.put("info", "系统暂时不允许登录，loginAccount:" + loginAccount);
				result.put("success", false);
				return result;
//				pageInfo.put("flag", "-00");
//				throw new Exception("系统暂时不允许登录，loginAccount:" + loginAccount);
			}

			// 以帐号登录
			if (loginAccount.equals(info.getLoginAccount())) {
				if (!isLoginStr.contains("2")) {
					result.put("info", "不允许以帐号的方式登录，loginAccount:" + loginAccount);
					result.put("success", false);
					return result;
//					pageInfo.put("flag", "-22");
//					throw new Exception("不允许以帐号的方式登录，loginAccount:"
//							+ loginAccount);
				}
			} else if (loginAccount.equals(info.getTeacherNo())) {
				if (!isLoginStr.contains("3")) {
					result.put("info", "不允许以教师编号的方式登录，loginAccount:" + loginAccount);
					result.put("success", false);
					return result;
//					pageInfo.put("flag", "-33");
//					throw new Exception("不允许以教师编号的方式登录，loginAccount:"
//							+ loginAccount);
				}
			} else if (loginAccount.equals(info.getIdNumber())) {
				if (!isLoginStr.contains("1")) {
					result.put("info", "不允许以身份证的方式登录，loginAccount:"
							+ loginAccount);
					result.put("success", false);
					return result;
//					pageInfo.put("flag", "-11");
//					throw new Exception("不允许以身份证的方式登录，loginAccount:"
//							+ loginAccount);
				}
			}

			if (info.getRoleId() == null) {
				result.put("info", "该帐号未分配角色！");
				result.put("success", false);
				return result;
//				pageInfo.put("flag", "-4");
//				throw new Exception("该帐号未分配角色！");
			}
			if (info.getStatus().intValue() == 44) {
				result.put("info", "该用户已被禁用！");
				result.put("success", false);
				return result;
//				pageInfo.put("flag", "-44");
//				throw new Exception("该用户已被禁用！");
			}

			if (info.getRoleId().intValue() == 5
					&& super.getUseTeacherRole(request) == 0) {
				result.put("info", "系统已关闭教师登录！");
				result.put("success", false);
				return result;
//				pageInfo.put("flag", "-55");
//				throw new Exception("系统已关闭教师登录！");
			}else if (info.getRoleId().intValue() == 5
					&& info.getStatus().intValue() < 8) {
				result.put("info", "该用户审核未通过！");
				result.put("success", false);
				return result;
//				pageInfo.put("flag", "-7");
//				throw new Exception("该用户审核未通过！");
			}else if(info.getRoleId().intValue() == 5
					&& info.getStatus().intValue() == 9){
//				pageInfo.put("flag", "-9");
//				throw new Exception("该教师已经退休！ ");
				result.put("info", "该教师已经退休！ ");
				result.put("success", false);
				return result;
			}else if(info.getRoleId().intValue() == 5
					&& info.getStatus().intValue() == 32){
				result.put("info", "该教师已经死亡！ ");
				result.put("success", false);
				return result;
			}else if(info.getRoleId().intValue() == 5
					&& info.getStatus().intValue() == 31){
				result.put("info", "该教师已经退休！ ");
				result.put("success", false);
				return result;
			}else if(info.getRoleId().intValue() == 5
					&& info.getStatus().intValue() == 33){
				result.put("info", "该教师已经离休！ ");
				result.put("success", false);
				return result;
			}else if(info.getRoleId().intValue() == 5
					&& info.getStatus().intValue() == 34){
				result.put("info", "该教师已经离岗！ ");
				result.put("success", false);
				return result;
			}else if(info.getRoleId().intValue() == 5
					&& info.getStatus().intValue() == 35){
				result.put("info", "该教师已经病休！ ");
				result.put("success", false);
				return result;
			}

			if (info.getRoleStatus() == null || info.getRoleStatus() != 1 || (super.getEnableOrg(request)!=1 && info.getRoleId()==6)) {
//				pageInfo.put("flag", "-5");
//				throw new Exception("该角色已被禁用！");
				result.put("info", "该角色已被禁用！");
				result.put("success", false);
				return result;
			}

			session.setAttribute("userinfo", info);

			// 获取角色对应的权限
			List<SysRoleFuncActivty> roles = sysService.queryRoleFuncList(info
					.getRoleTypeId());
			if (roles == null) {
//				pageInfo.put("flag", "-6");
//				throw new Exception("该角色暂无权限！");
				result.put("info", "该角色暂无权限！");
				result.put("success", false);
				return result;
			}
			Set<String> set = new HashSet<String>();

			for (SysRoleFuncActivty role : roles) {
				set.add(role.getFuncCode());
			}
			session.setAttribute("roleUrl", set);

			result.put("success", true);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("用户登录失败，错误信息：" + e.getMessage());
			result.put("success", false);
		}
		return result;
	}
	
	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;
	//二维码QRCode(客户端扫描二维码获取项目证书等信息)
	@RequestMapping("/QRCode.do")
	public String QRCode(HttpServletRequest request,Model model){
		
		HttpSession session = request.getSession();
		Map<String, Object> params = new HashMap<String, Object>();
		EduUserActivty info = null;
		String idNumber = request.getParameter("idNumber");
		String key = "fjyxtedu";
		try {
			if(idNumber != null && idNumber !=""){
				idNumber = DesTool.decrypt(idNumber,key);
				EduUser user = userService.getUserById(idNumber);
				params.put("loginAccount", user.getLoginAccount());
				params.put("password", user.getPassword());
				params.put("status", 0);
				if(user != null){
					info = userService.queryUserInfoByloginAccountAndPsd(params);
				}
			}
			session.setAttribute("userinfo", info);		
			//设置项目证书二维码信息(证书信息)
			String projectId = request.getParameter("projectId");
			String type = request.getParameter("type");
			if(projectId != null){
				EduProject  project = 	eduProjectService.queryProjectBaseInfoById(new Integer(projectId));
				if(info != null){
					EduProjectCommentTeacher  teacherComment = eduProjectService.queryProjectCommentByTeacherId(project,info.getUserId());
					
					model.addAttribute("teacherComment", teacherComment);
				}
				
				EduDiploma eduDiploma = sysService.queryDeplomaById(null, projectId, type,null);

				//设置证书类型
				model.addAttribute("type", type);
				model.addAttribute("project", project);
				model.addAttribute("eduDiploma", eduDiploma);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "person/QRCode";
	}
	
	
	
	// 用于福建网络研修平台对接,实现单点登录
	@RequestMapping("/systemLogin.do")
	public String getLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		JSONObject result = new JSONObject();
		HttpSession session = request.getSession();
		try {
			// 获取对方发起的请求参数
			String req_param = request.getParameter("param");
			String loginAccount = null;
		    String idNumber = null;
		    if(req_param != null){
				try {
					// 用于解密的token
					String key_ = "fjyxtedu";
					String jiemi = java.net.URLDecoder.decode(DesTool.decrypt(req_param,key_), "utf-8");
					// 对请求参数进行解析
					Map<String, String> params = SendHttpRequest.getUrlParams(jiemi);
					Set<String> keySet = params.keySet();
					for (String key : keySet) {
						if("idno".equals(key.toString())){
							idNumber = params.get(key);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		    Map<String, Object> params = new HashMap<String, Object>();
			EduUserActivty info = null;
			// 如果没有idNumber,拦截器则生效
		    EduUser user = userService.getUserById(idNumber);
		    if(user != null){
		    	loginAccount = user.getLoginAccount();
		    	String password = user.getPassword();
		    	params.put("loginAccount", loginAccount);
		    	params.put("password", password);
		    	params.put("status", 0);
		    	info = userService.queryUserInfoByloginAccountAndPsd(params);
		    }
			
			// 系统功能
			if(session.getAttribute("sysSetup")==null){
				SysSetup pojo = sysService.selectSysSetupInfo();
				if (pojo == null) {
					pojo = new SysSetup();
				}
				session.setAttribute("sysSetup", pojo);
			}

			session.setAttribute("userinfo", info);
			// 获取角色对应的权限
			List<SysRoleFuncActivty> roles = sysService.queryRoleFuncList(info.getRoleId());
			if (roles == null) {
				result.put("info", "该角色暂无权限！");
				result.put("success", false);
			}
			Set<String> set = new HashSet<String>();

			for (SysRoleFuncActivty role : roles) {
				set.add(role.getFuncCode());
			}
			session.setAttribute("roleUrl", set);
			result.put("success", true);

		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
		}
		return "person/index";
	}
	// end ------------------------------------------------------------------------
	
	/*
	 * public void sysSetUp(HttpSession session){ try { SysSetup pojo =
	 * sysService.selectSysSetupInfo(); session.setAttribute("sysSetup", pojo);
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	/**
	 * 退出入口
	 * 
	 * @author cl
	 * @create date 2013-4-4
	 * @return
	 */
	@RequestMapping("/nLogin.do")
	public void noLoginPage(HttpSession session) {
		session.removeAttribute("userinfo");
		session.removeAttribute("roleUrl");
	}

	/**
	 * 验证用户登录
	 * 
	 * @author cl
	 * @create date 2014-4-3
	 * @param request
	 * @return
	 */
	@RequestMapping("/login/personSession.do")
	public @ResponseBody
	Map<String, Object> getPersonSession(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			pageInfo.put("realName", super.getRealName(request));
			pageInfo.put("roleName", super.getRoleName(request));
			pageInfo.put("userCityName", super.getUserCityName(request));
			pageInfo.put("success", true);

		} catch (Exception e) {
			log.error("获取用户session失败，错误信息：" + e.getMessage());
			pageInfo.put("success", false);
		}
		return pageInfo;
	}

	/**
	 * 个人信息
	 * 
	 * @author cl
	 * @create date 2013-4-10
	 * @return
	 */
	@RequestMapping("/personInfoPage.htm")
	public String personInfoPage(ModelMap map, HttpServletRequest request) {
		EduUserActivty userInfo = new EduUserActivty();
		userInfo.setLoginAccount(super.getAccount(request));
		userInfo.setRealName(super.getRealName(request));
		userInfo.setIdNumber(super.getUserIdCard(request));
		userInfo.setMail(super.getUserMail(request));
		userInfo.setMobile(super.getUserMobile(request));
		userInfo.setPaswdQuestionType(super.getUserPaswdQuestionType(request));
		userInfo.setPaswdAnswer(super.getUserPaswdAnswer(request));
		userInfo.setRoleName(super.getRoleName(request));
		userInfo.setUserProvinceName(super.getUserProvinceName(request));
		userInfo.setUserCityName(super.getUserCityName(request));
		userInfo.setUserDistrictName(super.getUserDistrictName(request));
		userInfo.setSchoolName(super.getSchoolName(request));
		map.addAttribute("personInfo", userInfo);
//		request.setAttribute("LoginAccount",super.getAccount(request) );
//		request.setAttribute("RealName", super.getRealName(request));
//		request.setAttribute("IdNumber", super.getUserIdCard(request));
//		request.setAttribute("Mail", super.getUserMail(request));
//		request.setAttribute("Mobile", super.getUserMobile(request));
//		request.setAttribute("PaswdQuestionType", super.getUserPaswdQuestionType(request));
//		request.setAttribute("PaswdAnswer", super.getUserPaswdAnswer(request));
		return "person/personInfoPage";
	}

	/**
	 * 修改用户信息
	 * 
	 * @author cl
	 * @create date 2014-4-3
	 * @param request
	 * @return
	 */
	@RequestMapping("/setPersonInfo.do")
	public @ResponseBody
	Map<String, Object> setPersonInfo(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			//EduUserActivty user = new EduUserActivty();
			EduUserActivty user = super.getSessionUserInfo(request);
			user.setRealName(request.getParameter("realName"));
			user.setIdNumber(request.getParameter("idNumber"));
			/*String mail = request.getParameter("mail");
			if(StringUtils.isNotEmpty(mail)){
				user.setMail(mail);
				if(super.getRoleId(request).equals(Common.ROLE_TEACHER_5)){
					Map<String,Object> paramMap = new HashMap<String,Object>();
					paramMap.put("teacherId", super.getAccountId(request));
					EduTeacherBasicInfo basicTeacherInfo = teacherProjectServiceIF.selectTeacherBasicInfoByTeacherId(paramMap);
					basicTeacherInfo.setTeacherId(super.getAccountId(request));
					basicTeacherInfo.setTeacherEmail(mail);
					teacherManageService.saveTeacherBaseInfo(basicTeacherInfo, Common.ROLE_TEACHER_5);
				}
			}*/
			user.setMobile(request.getParameter("mobile"));
			/*user.setPaswdQuestionType(Integer.parseInt(request.getParameter("paswdQuestionType")));
			if (!request.getParameter("paswdQuestionType").equals("0")) {
				user.setPaswdAnswer(request.getParameter("paswdAnswer"));
			}*/
			user.setUserId(super.getAccountId(request));
			user.setUpdateBy(super.getRealName(request));

			Integer flag = userService.updateOhterUser(user);

			if (flag != null && flag.intValue() >= 0) {
				pageInfo.put("success", true);

				// 重新赋值用户session
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("status", 0);
				param.put("loginAccount", super.getAccount(request));
				param.put("password", super.getUserPassword(request));
				EduUserActivty info = userService
						.queryUserInfoByloginAccountAndPsd(param);

				HttpSession session = request.getSession();
				session.removeAttribute("userinfo");
				session.setAttribute("userinfo", info);

			} else {
				pageInfo.put("success", false);
			}

		} catch (Exception e) {
			log.error("修改用户信息错误，错误信息：" + e.getMessage());
			pageInfo.put("success", false);
		}
		return pageInfo;
	}

	/**
	 * 修改密码
	 * 
	 * @author cl
	 * @create date 2013-4-10
	 * @return
	 */
	@RequestMapping("/personPsdPage.htm")
	public String personPsdPage(ModelMap map, HttpServletRequest request) {
		EduUserActivty userInfo = super.getSessionUserInfo(request);
		userInfo.setPassword(super.getUserPassword(request));
		map.put("personInfo", userInfo);
		return "person/personPsdPage";
	}

	/**
	 * 修改用户信息
	 * 
	 * @author cl
	 * @create date 2014-4-3
	 * @param request
	 * @return
	 */
	@RequestMapping("/setPersonPsd.do")
	public @ResponseBody
	Map<String, Object> setPersonPsd(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			EduUserActivty user = new EduUserActivty();
			String mail = request.getParameter("mail");
			String paswdQuestionType = request.getParameter("paswdQuestionType");
			String paswdAnswer = request.getParameter("paswdAnswer");
			if(StringUtils.isNotEmpty(mail)){
				user.setMail(mail);
				//如果是教师角色 设置teacher_mail
				if(super.getRoleId(request).equals(Common.ROLE_TEACHER_5)){
					Map<String,Object> paramMap = new HashMap<String,Object>();
					paramMap.put("teacherId", super.getAccountId(request));
					EduTeacherBasicInfo basicTeacherInfo = teacherProjectServiceIF.selectTeacherBasicInfoByTeacherId(paramMap);
					basicTeacherInfo.setTeacherId(super.getAccountId(request));
					basicTeacherInfo.setTeacherEmail(mail);
					teacherManageService.saveTeacherBaseInfo(basicTeacherInfo, Common.ROLE_TEACHER_5);
				}
			}
			if(StringUtils.isNotEmpty(paswdQuestionType)){
				user.setPaswdQuestionType(Integer.parseInt(paswdQuestionType));
			}
			if(StringUtils.isNotEmpty(paswdAnswer)){
				user.setPaswdAnswer(paswdAnswer);
			}
			user.setPassword(request.getParameter("password"));
			user.setUserId(super.getAccountId(request));
			user.setUpdateBy(super.getRealName(request));
			user.setIsPassword(1);
			Integer flag = userService.updatePsdUser(user);

			if (flag != null && flag.intValue() >= 0) {
				pageInfo.put("success", true);
			} else {
				pageInfo.put("success", false);
			}

		} catch (Exception e) {
			log.error("修改用户密码错误，错误信息：" + e.getMessage());
			pageInfo.put("success", false);
		}
		return pageInfo;
	}

	/**
	 * 管理员管理页面跳转
	 * 
	 * @author cl
	 * @create date 2013-4-14
	 * @return
	 */
	@RequestMapping("/toManagesPage.htm")
	public String toManagesPage(HttpServletRequest request) {
//		 设置默认地区
//		setArea(request);
//		Integer roleId=super.getRoleId(request);
//		request.setAttribute("roleId",roleId );
		return "person/toManagesPage";
	}

	/**
	 * 新增管理员页面跳转
	 * 
	 * @author cl
	 * @create date 2013-4-14
	 * @return
	 */
	@RequestMapping("/toAddManagesPage.htm")
	public String toAddManagesPage() {
		return "person/toAddManagesPage";
	}

	/**
	 * 详情管理员页面跳转
	 * 
	 * @author cl
	 * @create date 2013-4-14
	 * @return
	 */
	@RequestMapping("/toInfoManagesPage.htm")
	public String toInfoManagesPage(ModelMap map, HttpServletRequest request) {
		try {
			if (request.getParameter("id") == null
					|| request.getParameter("id").length() <= 0) {
				throw new Exception("ID为空！");
			}
			EduUser info = new EduUser();
			info = userService.searchManagesInfo(Integer.parseInt(request
					.getParameter("id")));
			if (info.getUserCityName() != null
					&& info.getUserCityName().length() > 0) {
				info.setUserProvinceName(info.getUserProvinceName() + "—"
						+ info.getUserCityName());
			}
			if (info.getUserDistrictName() != null
					&& info.getUserDistrictName().length() > 0) {
				info.setUserProvinceName(info.getUserProvinceName() + "—"
						+ info.getUserDistrictName());
			}
			map.addAttribute("info", info);
		} catch (Exception e) {
			log.error("查看管理员详情失败:" + e.getMessage());
		}

		return "person/toInfoManagesPage";
	}

	/**
	 * 修改管理员页面跳转
	 * 
	 * @author cl
	 * @create date 2013-4-14
	 * @return
	 */
	@RequestMapping("/toModifyManagesPage.htm")
	public String toModifyManagesPage(ModelMap map, HttpServletRequest request) {
		try {
			if (request.getParameter("id") == null
					|| request.getParameter("id").length() <= 0) {
				throw new Exception("ID为空！");
			}
			EduUser info = new EduUser();
			info = userService.searchManagesInfo(Integer.parseInt(request
					.getParameter("id")));
			if (info.getUserCityName() != null
					&& info.getUserCityName().length() > 0) {
				info.setUserProvinceName(info.getUserProvinceName() + "—"
						+ info.getUserCityName());
			}
			if (info.getUserDistrictName() != null
					&& info.getUserDistrictName().length() > 0) {
				info.setUserProvinceName(info.getUserProvinceName() + "—"
						+ info.getUserDistrictName());
			}
			Integer userRoleType = super.getRoleId(request);
//			Map<String, Object> param = getUserLocaltion(request);
			Map<String, Object> param = getArea(request);
			param.put("status", 1);
			List<SysRole> roles = sysService.queryRoleListByUser(param,userRoleType, true, false,false);
			map.addAttribute("info", info);
			map.addAttribute("roles", roles );
		} catch (Exception e) {
			log.error("查看管理员详情失败:" + e.getMessage());
		}
		return "person/toModifyManagesPage";
	}

	/**
	 * 管理员管理（列表）
	 * 
	 * @author cl
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryManages.do")
	public @ResponseBody Map<String, Object> queryTeacherActivetyList(int pageIndex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
//			Map<String, Object> paramMap = new HashMap<String, Object>();
			Map<String, Object> paramMap = super.getArea(request);
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

			if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}
			if (request.getParameter("loginAccount") != null && request.getParameter("loginAccount").length() > 0) {
				paramMap.put("loginAccount", request.getParameter("loginAccount"));
			}
			if (!"null".equals(request.getParameter("roleTypeId")) && request.getParameter("roleTypeId") != null && request.getParameter("roleTypeId").length() > 0) {
				paramMap.put("roleTypeId", request.getParameter("roleTypeId"));
			}
			 if (!"null".equals(request.getParameter("roleId")) &&request.getParameter("roleId") != null && request.getParameter("roleId").length() > 0) {
				paramMap.put("roleId", request.getParameter("roleId"));
			 }
			
			if (request.getParameter("schoolName") != null && request.getParameter("schoolName").length() > 0) {
				paramMap.put("schoolName", request.getParameter("schoolName"));
			}

			if (request.getParameter("userProvinceId") != null && request.getParameter("userProvinceId").length() > 0) {
				paramMap.put("provinceId", request.getParameter("userProvinceId"));
			}

//			paramMap.put("userProvinceId1", super.getUserProvinceId(request));

			if (request.getParameter("userCityId") != null && request.getParameter("userCityId").length() > 0) {
				paramMap.put("cityId", request.getParameter("userCityId"));
			}
			
			if (request.getParameter("schoolId") != null && request.getParameter("schoolId").length() > 0) {
				paramMap.put("schoolId", request.getParameter("schoolId"));
			}

//			paramMap.put("userCityId1", super.getUserCityId(request));

			if (request.getParameter("userDistrictId") != null && request.getParameter("userDistrictId").length() > 0) {
				paramMap.put("districtId", request.getParameter("userDistrictId"));
			}

//			paramMap.put("userDistrictId1", super.getUserDistrictId(request));
//			paramMap.put("schoolId1", super.getSchoolId(request));

			if (request.getParameter("subjectId") != null && request.getParameter("subjectId").length() > 0) {
				paramMap.put("subjectId", request.getParameter("subjectId"));
			}
			
			//paramMap.put("role", super.getRoleId(request));

			pageIndex = (pageIndex - 1) * sizePerPage;

			PageObject po = userService.queryManagesList(paramMap, pageIndex, sizePerPage);
			if (po != null) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
				pageInfo.put("total", po.getCount());
				pageInfo.put("pageSize", po.getPagesize());
				pageInfo.put("pages", po.getPages());
				pageInfo.put("currentPage", po.getCurrentPage());
				pageInfo.put("pageNumbers", po.getPageNumbers());
				pageInfo.put("startIndex", po.getStartIndex());
				pageInfo.put("roleId", super.getRoleId(request));
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			pageInfo.put("success", false);
			e.printStackTrace();
			log.error("管理员管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}

	/**
	 * 添加管理员
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addManages.do")
	public @ResponseBody
	Map<String, Object> addManages(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			EduUser pojo = new EduUser();
			String accLog = super.getAccount(request);
			pojo.setCreateBy(accLog);
			pojo.setUpdateBy(accLog);

			pojo.setRoleId(Integer.parseInt(request.getParameter("roleId")));
			pojo.setLoginAccount(request.getParameter("loginAccount").trim());
			pojo.setPassword(request.getParameter("password"));
			pojo.setRealName(request.getParameter("realName"));
			pojo.setGender(Integer.parseInt(request.getParameter("gender")));
			pojo.setIdNumber(request.getParameter("idNumber"));
			pojo.setMobile(request.getParameter("mobile"));
			pojo.setMail(request.getParameter("mail"));
			pojo.setStatus(Integer.parseInt(request.getParameter("status")));

			if (request.getParameter("userProvinceId") != null
					&& request.getParameter("userProvinceId").length() > 0) {
				pojo.setUserProvinceId(Integer.parseInt(request
						.getParameter("userProvinceId")));
				pojo.setUserProvinceName(request
						.getParameter("userProvinceName"));
			}
			if (request.getParameter("userCityId") != null
					&& request.getParameter("userCityId").length() > 0) {
				pojo.setUserCityId(Integer.parseInt(request
						.getParameter("userCityId")));
				pojo.setUserCityName(request.getParameter("userCityName"));
			}
			if (request.getParameter("userDistrictId") != null
					&& request.getParameter("userDistrictId").length() > 0) {
				pojo.setUserDistrictId(Integer.parseInt(request
						.getParameter("userDistrictId")));
				pojo.setUserDistrictName(request
						.getParameter("userDistrictName"));
			}
			pojo.setUserAddress(request.getParameter("userAddress"));

			if (request.getParameter("schoolId") != null
					&& request.getParameter("schoolId").length() > 0) {
				pojo.setSchoolId(Integer.parseInt(request
						.getParameter("schoolId")));
				
				EduSchool school = schoolService.searchSchoolInfo(Integer.parseInt(request
						.getParameter("schoolId")));
				pojo.setSchoolName(school.getSchoolName());
			}

			Integer flag = userService.addManages(pojo);

			if (flag.intValue() == 0) {
				pageInfo.put("success", true);
			} else {
				pageInfo.put("success", false);
				pageInfo.put("flag", "-1");
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage() == "-4") {
				pageInfo.put("flag", "-4");
				log.error("新增管理员记录失败:帐号已经存在");
			} else {
				pageInfo.put("flag", "-1");
				log.error("新增管理员记录失败:" + e.getMessage());
			}
			pageInfo.put("success", false);

		}

		return pageInfo;
	}

	/**
	 * 更新管理员管理
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/modifyManages.do")
	public @ResponseBody
	Map<String, Object> modifyManages(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			if (request.getParameter("id") == null
					|| request.getParameter("id").length() <= 0) {
				throw new Exception("id为空");
			}
			EduUser pojo = new EduUser();
			String accLog = super.getAccount(request);
			pojo.setCreateBy(accLog);
			pojo.setUpdateBy(accLog);

			if(!StringUtils.isEmpty(request.getParameter("id"))) {
				pojo.setId(Integer.parseInt(request.getParameter("id")));
			}
			if(!StringUtils.isEmpty(request.getParameter("roleId"))) {
				pojo.setRoleId(Integer.parseInt(request.getParameter("roleId")));
			}
			pojo.setLoginAccount(request.getParameter("loginAccount").trim());
			pojo.setPassword(request.getParameter("password"));
			pojo.setRealName(request.getParameter("realName"));
			if(!StringUtils.isEmpty(request.getParameter("gender"))) {
				pojo.setGender(Integer.parseInt(request.getParameter("gender")));
			}
			pojo.setIdNumber(request.getParameter("idNumber"));
			pojo.setMobile(request.getParameter("mobile"));
			pojo.setMail(request.getParameter("mail"));
			if(!StringUtils.isEmpty(request.getParameter("isPassword"))) {
				pojo.setIsPassword(Integer.parseInt(request.getParameter("isPassword")));
			}
			if(!StringUtils.isEmpty(request.getParameter("status"))) {
				pojo.setStatus(Integer.parseInt(request.getParameter("status")));
			}
			pojo.setOldLoginAccount(request.getParameter("oldLoginAccount"));

			if (request.getParameter("schoolId") != null
					&& request.getParameter("schoolId").length() > 0) {
				pojo.setSchoolId(Integer.parseInt(request
						.getParameter("schoolId")));
				
				EduSchool school = schoolService.searchSchoolInfo(Integer.parseInt(request
						.getParameter("schoolId")));
				pojo.setSchoolName(school.getSchoolName());
			}

			if (request.getParameter("userProvinceId") != null
					&& request.getParameter("userProvinceId").length() > 0) {
				pojo.setUserProvinceId(Integer.parseInt(request
						.getParameter("userProvinceId")));
				pojo.setUserProvinceName(request
						.getParameter("userProvinceName"));
			}
			if (request.getParameter("userCityId") != null
					&& request.getParameter("userCityId").length() > 0) {
				pojo.setUserCityId(Integer.parseInt(request
						.getParameter("userCityId")));
				pojo.setUserCityName(request.getParameter("userCityName"));
			}
			if (request.getParameter("userDistrictId") != null
					&& request.getParameter("userDistrictId").length() > 0) {
				pojo.setUserDistrictId(Integer.parseInt(request
						.getParameter("userDistrictId")));
				pojo.setUserDistrictName(request
						.getParameter("userDistrictName"));
			}
			pojo.setUserAddress(request.getParameter("userAddress"));

			Integer flag = userService.updateManages(pojo);

			if (flag.intValue() == 0) {
				pageInfo.put("success", true);
			} else {
				pageInfo.put("success", false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage() == "-4") {
				pageInfo.put("flag", "-4");
				log.error("更新学校记录失败:帐号已经存在");
			} else {
				pageInfo.put("flag", "-1");
				log.error("更新学校记录失败:" + e.getMessage());
			}
			pageInfo.put("success", false);
		}

		return pageInfo;
	}

	/**
	 * 删除学校
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteManages.do")
	public @ResponseBody
	Map<String, Object> deleteManages(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			if (request.getParameter("id") == null
					|| request.getParameter("id").length() <= 0) {
				throw new Exception("id为空");
			}
			EduUser pojo = new EduUser();
			String accLog = super.getAccount(request);
			pojo.setUpdateBy(accLog);
			pojo.setId(Integer.parseInt(request.getParameter("id")));
			pojo.setStatus(0);

			Integer flag = userService.deleteManages(pojo);

			if (flag.intValue() == 0) {
				pageInfo.put("success", true);
			} else {
				pageInfo.put("success", false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			pageInfo.put("success", false);
			log.error("删除管理员记录失败:" + e.getMessage());
		}

		return pageInfo;
	}

	
	/**
	 * Description: 批量删除管理员
	 * 
	 * @author 曉
	 * @param locIdas
	 * @param request
	 * @return
	 */
	@RequestMapping("batchDelMgrs.do")
	public @ResponseBody Map<String, Object> batchDelLocationByLocId(String ids, HttpServletRequest request){
		log.info("批量删除管理员");
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if(userService.batchDelMgrsByIds(ids, super.getAccount(request))){
				result.put("success", true);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("批量删除管理员失败" + e.getMessage());
		}
		
		return result;
	}
	
	
	
	/**
	 * 批量修改管理员
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping("batchModifyMgrs.do")
	public @ResponseBody Map<String, Object> batchModifyManager(String ids, HttpServletRequest request){
		log.info("批量修改管理员!!!");
		Map<String, Object> result = new HashMap<String, Object>();
		String roleId = request.getParameter("roleId");
		try {
			if(userService.batchModifyMgrsByIds(ids, new Integer(roleId))){
				result.put("success", true);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("批量修改管理员失败" + e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * 管理员管理 导出
	 * 
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/exportManagesList.do")
	public void exportTeacherInforList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();

			if (request.getParameter("loginAccount") != null && request.getParameter("loginAccount").length() > 0) {
				paramMap.put("loginAccount", request.getParameter("loginAccount"));
			}

			if (request.getParameter("roleId") != null && request.getParameter("roleId").length() > 0) {
				paramMap.put("roleId", request.getParameter("roleId"));
			}

			if (request.getParameter("userProvinceId") != null && request.getParameter("userProvinceId").length() > 0) {
				paramMap.put("userProvinceId", request.getParameter("userProvinceId"));
			}

			if (request.getParameter("userCityId") != null && request.getParameter("userCityId").length() > 0) {
				paramMap.put("userCityId", request.getParameter("userCityId"));
			}

			if (request.getParameter("userDistrictId") != null && request.getParameter("userDistrictId").length() > 0) {
				paramMap.put("userDistrictId", request.getParameter("userDistrictId"));
			}

			if (request.getParameter("schoolId") != null && request.getParameter("schoolId").length() > 0) {
				paramMap.put("schoolId", request.getParameter("schoolId"));
			}
			
			if (request.getParameter("subjectId") != null && request.getParameter("subjectId").length() > 0) {
				paramMap.put("subjectId", request.getParameter("subjectId"));
			}
			
			paramMap.put("userProvinceId1", super.getUserProvinceId(request));
			
			EduUserActivty obj = super.getSessionUserInfo(request);
			int roleId = obj.getRoleId();
			if(roleId==2){
				paramMap.put("userCityId1", obj.getUserCityId());
			}else if(roleId==3){
				paramMap.put("userCityId1", obj.getUserCityId());
				paramMap.put("userDistrictId1", obj.getUserDistrictId());
			}else if(roleId==4){
				paramMap.put("userCityId1", obj.getUserCityId());
				paramMap.put("userDistrictId1", obj.getUserDistrictId());
				paramMap.put("schoolId1", obj.getSchoolId());
			}
			
			paramMap.put("role", roleId);

			List<EduUser> list = userService.queryManagesList(paramMap);

			String path = request.getRealPath("/") + "template"
					+ File.separator + "download_userManages.xls";

			FileInputStream io = new FileInputStream(path);
			// 创建 excel
			Workbook wb = new HSSFWorkbook(io);

			Sheet sheet = wb.getSheetAt(0);
			for (int i = 0; i < list.size(); i++) {
				Row row = sheet.createRow(i + 1);
				Cell cellA = row.createCell(0);
				cellA.setCellValue(list.get(i).getRealName());

				Cell cellB = row.createCell(1);
				cellB.setCellValue(list.get(i).getLoginAccount());

				Cell cellC = row.createCell(2);
				cellC.setCellValue(list.get(i).getPassword());

				Cell cellD = row.createCell(3);
				cellD.setCellValue(list.get(i).getRoleName());

				Cell cellE = row.createCell(4);
				cellE
						.setCellValue(((list.get(i).getUserProvinceName() == null ? ""
								: list.get(i).getUserProvinceName())
								+ list.get(i).getUserCityName() + list.get(i)
								.getUserDistrictName()+ list.get(i)
								.getSchoolName()));

				Cell cellF = row.createCell(5);
				cellF.setCellValue(list.get(i).getUserStatus());

			}

			exportExcelFromTemplet(request, response, wb,
					"download_userManages");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("管理员管理查询导出错误:" + e);
		}
	}

	/**
	 * 用户注册
	 * 
	 * @author yinxiaolong
	 * @return
	 */
	@RequestMapping("register/userRegister.htm")
	public String userRegisterPage() {
		return "person/userRegister";
	}

	@RequestMapping(value = "register/userRegisterInfo.do")
	public @ResponseBody
	Map<String, Object> userRegister(String userName, String userPwd,
			String realName, String idNumber, String email, String mobile,
			String selctPwdProtection, String pwdProtectionAnswer,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("loginAccount", userName);
		paramMap.put("password", userPwd);
		paramMap.put("realName", realName);
		paramMap.put("idNumber", idNumber);
		paramMap.put("mail", email);
		paramMap.put("mobile", mobile);
		paramMap.put("paswdQuestionType", selctPwdProtection);
		paramMap.put("paswdAnswer", pwdProtectionAnswer);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			if (userService.registerUser(paramMap)) {
				resultMap.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("注册失败:" + e);
		}
		return resultMap;

	}

	@RequestMapping(value = "register/selectAllUserList.do")
	public @ResponseBody
	Map<String, Object> selectAllUserList(String loginAccount,
			HttpServletRequest request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<EduUser> list = userService.selectAllUserList(paramMap);
			if (list.size() > 0) {
				result.put("success", true);
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getLoginAccount().equals(loginAccount)) {
						result.put("nameFalse", false);
					} else {
						result.put("nameFalse", true);
					}
					if (list.get(i).getIdNumber().equals(loginAccount)) {
						result.put("inNumberFalse", false);
					} else {
						result.put("inNumberFalse", true);
					}
					if (list.get(i).getTeacherNo().equals(loginAccount)) {
						result.put("teacherNoFalse", false);
					} else {
						result.put("teacherNoFalse", true);
					}
				}
				result.put("list", list);
			}
		} catch (Exception e) {
			log.error("查询失败:" + e);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 生成管理员管理页面跳转
	 * 
	 * @author cl
	 * @create date 2013-4-25
	 * @return
	 */
	@RequestMapping("/toCreateManagesPage.htm")
	public String toCreateManagesPage() {
		return "person/toCreateManagesPage";
	}

	/**
	 * 生成管理员帐号
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/createManages.do")
	public @ResponseBody
	Map<String, Object> createManages(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		String errorStr = "";
		try {
			if (request.getParameter("flag") == null
					|| request.getParameter("flag").length() <= 0) {
				errorStr = "-1";
				throw new Exception("roleId为空");
			}
			String accLog = super.getAccount(request);
			EduUser pojo = new EduUser();

			List<EduUser> ids = new ArrayList<EduUser>();
			Map<String, Object> paraMap = new HashMap<String, Object>();

			String flagStr = request.getParameter("flag");
			String topStr = request.getParameter("topStr");
			int createNum = 0;

			// 系统管理员、承培机构管理员、专家
			if (flagStr.equals("0") || flagStr.equals("6")
					|| flagStr.equals("20")) {

				createNum = Integer.parseInt(request.getParameter("createNum"));
				for (int i = 0; i < createNum; i++) {
					pojo = new EduUser();
					pojo.setUpdateBy(accLog);
					pojo.setCreateBy(accLog);
					pojo.setStatus(1);
					pojo.setPassword(DataUtil.createRandm(6));
					pojo.setRoleId(Integer.parseInt(flagStr));
					pojo.setRealName("admin");

					if (!flagStr.equals("0")) {// 系统管理员不包含地区信息
						if (super.getUserProvinceId(request) != null
								&& !super.getUserProvinceId(request)
										.equals("0")) {
							pojo.setUserProvinceId(Integer.parseInt(super
									.getUserProvinceId(request)));
							pojo.setUserProvinceName(super
									.getUserProvinceName(request));
						}
						if (super.getUserCityId(request) != null
								&& !super.getUserCityId(request).equals("0")) {
							pojo.setUserCityId(Integer.parseInt(super
									.getUserCityId(request)));
							pojo
									.setUserCityName(super
											.getUserCityName(request));
						}
						if (super.getUserDistrictId(request) != null
								&& !super.getUserDistrictId(request)
										.equals("0")) {
							pojo.setUserDistrictId(Integer.parseInt(super
									.getUserDistrictId(request)));
							pojo.setUserDistrictName(super
									.getUserDistrictName(request));
						}
						if (super.getSchoolId(request) != null
								&& !super.getSchoolId(request).toString()
										.equals("0")) {
							pojo.setSchoolId(super.getSchoolId(request));
							pojo.setSchoolName(super.getSchoolName(request));
						}
					} else {
						if (super.getRoleId(request).intValue() > 1) {
							errorStr = "-7";
							throw new Exception("权限不足，只有系统管理员或者省管理员可以生成系统管理员");
						}
					}

					if (flagStr.equals("20")) {// 专家
						if (request.getParameter("subjectId") == null
								|| request.getParameter("subjectId").length() <= 0
								|| request.getParameter("subjectName") == null
								|| request.getParameter("subjectName").length() <= 0) {
							errorStr = "-4";
							throw new Exception("学科信息为空");
						}
						pojo.setSubjectId(Integer.parseInt(request
								.getParameter("subjectId")));
						pojo
								.setSubjectName(request
										.getParameter("subjectName"));
					}
					while (true) {
						String lg = topStr + DataUtil.createRandm(4);
						pojo.setLoginAccount(lg);
						paraMap.put("loginAccount", lg);
						if (userService.searchLoginAccount(paraMap) <= 0) {
							break;
						}
					}
					ids.add(pojo);
				}

			} else if (flagStr.equals("7")) {// 实施机构 省

				createNum = Integer.parseInt(request.getParameter("createNum"));
				for (int i = 0; i < createNum; i++) {
					pojo = new EduUser();
					pojo.setUpdateBy(accLog);
					pojo.setCreateBy(accLog);
					pojo.setStatus(1);
					pojo.setPassword(DataUtil.createRandm(6));
					pojo.setRoleId(Integer.parseInt(flagStr));
					pojo.setRealName("admin");

					if (super.getUserProvinceId(request) == null
							|| super.getUserProvinceId(request).equals("0")) {
						errorStr = "-6";
						throw new Exception("生成失败，当前登录人地区信息不符合生成该角色");
					}

					pojo.setUserProvinceId(Integer.parseInt(super
							.getUserProvinceId(request)));
					pojo
							.setUserProvinceName(super
									.getUserProvinceName(request));

					while (true) {
						String lg = topStr + DataUtil.createRandm(4);
						pojo.setLoginAccount(lg);
						paraMap.put("loginAccount", lg);
						if (userService.searchLoginAccount(paraMap) <= 0) {
							break;
						}
					}
					ids.add(pojo);
				}

			} else if (flagStr.equals("8")) {// 实施机构 市

				createNum = Integer.parseInt(request.getParameter("createNum"));
				for (int i = 0; i < createNum; i++) {
					pojo = new EduUser();
					pojo.setUpdateBy(accLog);
					pojo.setCreateBy(accLog);
					pojo.setStatus(1);
					pojo.setPassword(DataUtil.createRandm(6));
					pojo.setRoleId(Integer.parseInt(flagStr));
					pojo.setRealName("admin");

					if (super.getUserProvinceId(request) == null
							|| super.getUserProvinceId(request).equals("0")
							|| super.getUserCityId(request) == null
							|| super.getUserCityId(request).equals("0")) {
						errorStr = "-6";
						throw new Exception("生成失败，当前登录人地区信息不符合生成该角色");
					}
					pojo.setUserProvinceId(Integer.parseInt(super
							.getUserProvinceId(request)));
					pojo
							.setUserProvinceName(super
									.getUserProvinceName(request));

					pojo.setUserCityId(Integer.parseInt(super
							.getUserCityId(request)));
					pojo.setUserCityName(super.getUserCityName(request));

					while (true) {
						String lg = topStr + DataUtil.createRandm(4);
						pojo.setLoginAccount(lg);
						paraMap.put("loginAccount", lg);
						if (userService.searchLoginAccount(paraMap) <= 0) {
							break;
						}
					}
					ids.add(pojo);
				}

			} else if (flagStr.equals("9")) {// 实施机构 区

				createNum = Integer.parseInt(request.getParameter("createNum"));
				for (int i = 0; i < createNum; i++) {
					pojo = new EduUser();
					pojo.setUpdateBy(accLog);
					pojo.setCreateBy(accLog);
					pojo.setStatus(1);
					pojo.setPassword(DataUtil.createRandm(6));
					pojo.setRoleId(Integer.parseInt(flagStr));
					pojo.setRealName("admin");

					if (super.getUserProvinceId(request) == null
							|| super.getUserProvinceId(request).equals("0")
							|| super.getUserCityId(request) == null
							|| super.getUserCityId(request).equals("0")
							|| super.getUserDistrictId(request) == null
							|| super.getUserDistrictId(request).equals("0")) {
						errorStr = "-6";
						throw new Exception("生成失败，当前登录人地区信息不符合生成该角色");
					}

					pojo.setUserProvinceId(Integer.parseInt(super
							.getUserProvinceId(request)));
					pojo
							.setUserProvinceName(super
									.getUserProvinceName(request));

					pojo.setUserCityId(Integer.parseInt(super
							.getUserCityId(request)));
					pojo.setUserCityName(super.getUserCityName(request));

					pojo.setUserDistrictId(Integer.parseInt(super
							.getUserDistrictId(request)));
					pojo
							.setUserDistrictName(super
									.getUserDistrictName(request));

					while (true) {
						String lg = topStr + DataUtil.createRandm(4);
						pojo.setLoginAccount(lg);
						paraMap.put("loginAccount", lg);
						if (userService.searchLoginAccount(paraMap) <= 0) {
							break;
						}
					}
					ids.add(pojo);
				}

			} else if (flagStr.equals("10")) {// 实施机构，校
				createNum = Integer.parseInt(request.getParameter("createNum"));
				for (int i = 0; i < createNum; i++) {
					pojo = new EduUser();
					pojo.setUpdateBy(accLog);
					pojo.setCreateBy(accLog);
					pojo.setStatus(1);
					pojo.setPassword(DataUtil.createRandm(6));
					pojo.setRoleId(Integer.parseInt(flagStr));
					pojo.setRealName("admin");

					if (super.getUserProvinceId(request) == null
							|| super.getUserProvinceId(request).equals("0")
							|| super.getUserCityId(request) == null
							|| super.getUserCityId(request).equals("0")
							|| super.getUserDistrictId(request) == null
							|| super.getUserDistrictId(request).equals("0")
							|| super.getSchoolId(request) == null
							|| super.getSchoolId(request).toString()
									.equals("0")) {
						errorStr = "-6";
						throw new Exception("生成失败，当前登录人地区信息不符合生成该角色");
					}

					pojo.setUserProvinceId(Integer.parseInt(super
							.getUserProvinceId(request)));
					pojo
							.setUserProvinceName(super
									.getUserProvinceName(request));
					pojo.setUserCityId(Integer.parseInt(super
							.getUserCityId(request)));
					pojo.setUserCityName(super.getUserCityName(request));
					pojo.setUserDistrictId(Integer.parseInt(super
							.getUserDistrictId(request)));
					pojo
							.setUserDistrictName(super
									.getUserDistrictName(request));

					pojo.setSchoolId(super.getSchoolId(request));
					pojo.setSchoolName(super.getSchoolName(request));

					while (true) {
						String lg = topStr + DataUtil.createRandm(4);
						pojo.setLoginAccount(lg);
						paraMap.put("loginAccount", lg);
						if (userService.searchLoginAccount(paraMap) <= 0) {
							break;
						}
					}
					ids.add(pojo);
				}

			} else if (flagStr.equals("1")) {// 管理员
				String schoolProvinceId = request
						.getParameter("schoolProvinceId");
				String schoolCityId = request.getParameter("schoolCityId");
				String schoolDistrictId = request
						.getParameter("schoolDistrictId");
				String schoolId = request.getParameter("schoolId");

				String schoolProvinceName = request
						.getParameter("schoolProvinceName");
				String schoolCityName = request.getParameter("schoolCityName");
				String schoolDistrictName = request
						.getParameter("schoolDistrictName");
				String schoolName = request.getParameter("schoolName");

				// 生成管理员类型 ALL：全部 TOP：生成当前所属地区的管理员 DOWN： 生成所有下级地区的管理员
				String createType = request.getParameter("createType");

				// 1:只选择省份
				if ((schoolProvinceId != null && schoolProvinceId.length() > 0)
						&& (schoolCityId == null || schoolCityId.length() == 0)) {
					Map<String, Object> paraArea = new HashMap<String, Object>();
					paraArea.put("code", schoolProvinceId);
					List<SysArea> areaList = sysService
							.selectAreaList(paraArea);
					if (areaList == null || areaList.size() == 0) {
						errorStr = "-5";
						throw new Exception("只生成省管理员，检查失败，系统中不存在省份");
					}

					if (createType.equals("TOP")) {
						pojo = new EduUser();
						pojo.setUpdateBy(accLog);
						pojo.setCreateBy(accLog);
						pojo.setStatus(1);
						pojo.setPassword(DataUtil.createRandm(6));
						pojo.setRoleId(Integer.parseInt(flagStr));
						pojo.setRealName("admin");
						while (true) {
							String lg = topStr + areaList.get(0).getAreaCode()
									+ DataUtil.createRandm(4);
							pojo.setLoginAccount(lg);
							paraMap.put("loginAccount", lg);
							if (userService.searchLoginAccount(paraMap) <= 0) {
								break;
							}
						}
						pojo.setUserProvinceId(Integer
								.parseInt(schoolProvinceId));
						pojo.setUserProvinceName(schoolProvinceName);
						ids.add(pojo);
					} else if (createType.equals("ALL")
							|| createType.equals("DOWN")) {
						if (createType.equals("ALL")) {
							pojo = new EduUser();
							pojo.setUpdateBy(accLog);
							pojo.setCreateBy(accLog);
							pojo.setStatus(1);
							pojo.setPassword(DataUtil.createRandm(6));
							pojo.setRoleId(Integer.parseInt(flagStr));
							pojo.setRealName("admin");
							while (true) {
								String lg = topStr
										+ areaList.get(0).getAreaCode()
										+ DataUtil.createRandm(4);
								pojo.setLoginAccount(lg);
								paraMap.put("loginAccount", lg);
								if (userService.searchLoginAccount(paraMap) <= 0) {
									break;
								}
							}
							pojo.setUserProvinceId(Integer
									.parseInt(schoolProvinceId));
							pojo.setUserProvinceName(schoolProvinceName);
							ids.add(pojo);
						}

						// 查询每级省份对应的全部城市
						Map<String, Object> paraAreaCity = new HashMap<String, Object>();
						paraAreaCity.put("belong", areaList.get(0).getCode());
						List<SysArea> areaListCity = sysService
								.selectAreaList(paraAreaCity);

						for (int j = 0; j < areaListCity.size(); j++) {
							EduUser pojoCity = new EduUser();
							pojoCity.setUpdateBy(accLog);
							pojoCity.setCreateBy(accLog);
							pojoCity.setStatus(1);
							pojoCity.setPassword(DataUtil.createRandm(6));
							pojoCity.setRoleId(2);
							pojoCity.setRealName("admin");

							while (true) {
								String lg = topStr
										+ areaListCity.get(j).getAreaCode()
										+ DataUtil.createRandm(4);
								pojoCity.setLoginAccount(lg);
								paraMap.put("loginAccount", lg);
								if (userService.searchLoginAccount(paraMap) <= 0) {
									break;
								}
							}

							pojoCity.setUserProvinceId(Integer
									.parseInt(schoolProvinceId));
							pojoCity.setUserProvinceName(schoolProvinceName);
							pojoCity.setUserCityId(areaListCity.get(j).getId());
							pojoCity.setUserCityName(areaListCity.get(j)
									.getName());

							ids.add(pojoCity);

							// 查询每级城市对应的全部区县
							Map<String, Object> paraAreaDistrict = new HashMap<String, Object>();
							paraAreaDistrict.put("belong", areaListCity.get(j)
									.getCode());
							List<SysArea> areaListDistrict = sysService
									.selectAreaList(paraAreaDistrict);

							for (int s = 0; s < areaListDistrict.size(); s++) {

								EduUser pojoDistrict = new EduUser();
								pojoDistrict.setUpdateBy(accLog);
								pojoDistrict.setCreateBy(accLog);
								pojoDistrict.setStatus(1);
								pojoDistrict.setPassword(DataUtil
										.createRandm(6));
								pojoDistrict.setRoleId(3);
								pojoDistrict.setRealName("admin");

								while (true) {
									String lg = topStr
											+ areaListDistrict.get(s)
													.getAreaCode()
											+ DataUtil.createRandm(4);
									pojoDistrict.setLoginAccount(lg);
									paraMap.put("loginAccount", lg);
									if (userService.searchLoginAccount(paraMap) <= 0) {
										break;
									}
								}

								pojoDistrict.setUserProvinceId(Integer
										.parseInt(schoolProvinceId));
								pojoDistrict
										.setUserProvinceName(schoolProvinceName);
								pojoDistrict.setUserCityId(areaListCity.get(j)
										.getId());
								pojoDistrict.setUserCityName(areaListCity
										.get(j).getName());
								pojoDistrict.setUserDistrictId(areaListDistrict
										.get(s).getId());
								pojoDistrict
										.setUserDistrictName(areaListDistrict
												.get(s).getName());

								ids.add(pojoDistrict);

								// 查询每级区县对应的全部学校
								List<EduSchool> schoolList = schoolService
										.querySchoolList(
												null,
												null,
												Integer
														.parseInt(schoolProvinceId),
												areaListCity.get(j).getId(),
												areaListDistrict.get(s).getId(),
												null);
								for (int m = 0; m < schoolList.size(); m++) {

									EduUser pojoSchool = new EduUser();
									pojoSchool.setUpdateBy(accLog);
									pojoSchool.setCreateBy(accLog);
									pojoSchool.setStatus(1);
									pojoSchool.setPassword(DataUtil
											.createRandm(6));
									pojoSchool.setRoleId(4);
									pojoSchool.setRealName("admin");

									while (true) {
										String lg = topStr + "XX"
												+ DataUtil.createRandm(4);
										pojoSchool.setLoginAccount(lg);
										paraMap.put("loginAccount", lg);
										if (userService
												.searchLoginAccount(paraMap) <= 0) {
											break;
										}
									}

									pojoSchool.setUserProvinceId(Integer
											.parseInt(schoolProvinceId));
									pojoSchool
											.setUserProvinceName(schoolProvinceName);
									pojoSchool.setUserCityId(areaListCity
											.get(j).getId());
									pojoSchool.setUserCityName(areaListCity
											.get(j).getName());
									pojoSchool
											.setUserDistrictId(areaListDistrict
													.get(s).getId());
									pojoSchool
											.setUserDistrictName(areaListDistrict
													.get(s).getName());
									pojoSchool.setSchoolId(schoolList.get(m)
											.getSchoolId());
									pojoSchool.setSchoolName(schoolList.get(m)
											.getSchoolName());
									ids.add(pojoSchool);
								}
							}
						}
					}

				}

				// 选择了省市
				else if ((schoolCityId != null && schoolCityId.length() > 0)
						&& (schoolDistrictId == null || schoolDistrictId
								.length() == 0)) {
					Map<String, Object> paraArea = new HashMap<String, Object>();
					paraArea.put("code", schoolCityId);
					List<SysArea> areaList = sysService
							.selectAreaList(paraArea);
					if (areaList == null || areaList.size() == 0) {
						errorStr = "-5";
						throw new Exception(
								"只生成省管理员，检查失败，系统中不存在地区schoolProvinceId："
										+ schoolProvinceId + "schoolCityId:"
										+ schoolCityId);
					}

					if (createType.equals("TOP")) {
						pojo = new EduUser();
						pojo.setUpdateBy(accLog);
						pojo.setCreateBy(accLog);
						pojo.setStatus(1);
						pojo.setPassword(DataUtil.createRandm(6));
						pojo.setRoleId(2);
						pojo.setRealName("admin");
						while (true) {
							String lg = topStr + areaList.get(0).getAreaCode()
									+ DataUtil.createRandm(4);
							pojo.setLoginAccount(lg);
							paraMap.put("loginAccount", lg);
							if (userService.searchLoginAccount(paraMap) <= 0) {
								break;
							}
						}
						pojo.setUserProvinceId(Integer
								.parseInt(schoolProvinceId));
						pojo.setUserProvinceName(schoolProvinceName);
						pojo.setUserCityId(Integer.parseInt(schoolCityId));
						pojo.setUserCityName(schoolCityName);
						ids.add(pojo);
					} else if (createType.equals("ALL")
							|| createType.equals("DOWN")) {
						if (createType.equals("ALL")) {
							pojo = new EduUser();
							pojo.setUpdateBy(accLog);
							pojo.setCreateBy(accLog);
							pojo.setStatus(1);
							pojo.setPassword(DataUtil.createRandm(6));
							pojo.setRoleId(2);
							pojo.setRealName("admin");
							while (true) {
								String lg = topStr
										+ areaList.get(0).getAreaCode()
										+ DataUtil.createRandm(4);
								pojo.setLoginAccount(lg);
								paraMap.put("loginAccount", lg);
								if (userService.searchLoginAccount(paraMap) <= 0) {
									break;
								}
							}
							pojo.setUserProvinceId(Integer
									.parseInt(schoolProvinceId));
							pojo.setUserProvinceName(schoolProvinceName);
							pojo.setUserCityId(Integer.parseInt(schoolCityId));
							pojo.setUserCityName(schoolCityName);
							ids.add(pojo);
						}

						// 查询每级城市对应的全部区县
						Map<String, Object> paraAreaDistrict = new HashMap<String, Object>();
						paraAreaDistrict.put("belong", schoolCityId);
						List<SysArea> areaListDistrict = sysService
								.selectAreaList(paraAreaDistrict);

						for (int s = 0; s < areaListDistrict.size(); s++) {

							EduUser pojoDistrict = new EduUser();
							pojoDistrict.setUpdateBy(accLog);
							pojoDistrict.setCreateBy(accLog);
							pojoDistrict.setStatus(1);
							pojoDistrict.setPassword(DataUtil.createRandm(6));
							pojoDistrict.setRoleId(3);
							pojoDistrict.setRealName("admin");

							while (true) {
								String lg = topStr
										+ areaListDistrict.get(0).getAreaCode()
										+ DataUtil.createRandm(4);
								pojoDistrict.setLoginAccount(lg);
								paraMap.put("loginAccount", lg);
								if (userService.searchLoginAccount(paraMap) <= 0) {
									break;
								}
							}

							pojoDistrict.setUserProvinceId(Integer
									.parseInt(schoolProvinceId));
							pojoDistrict
									.setUserProvinceName(schoolProvinceName);
							pojoDistrict.setUserCityId(Integer
									.parseInt(schoolCityId));
							pojoDistrict.setUserCityName(schoolCityName);
							pojoDistrict.setUserDistrictId(areaListDistrict
									.get(s).getId());
							pojoDistrict.setUserDistrictName(areaListDistrict
									.get(s).getName());

							ids.add(pojoDistrict);

							// 查询每级区县对应的全部学校
							List<EduSchool> schoolList = schoolService
									.querySchoolList(null, null, Integer
											.parseInt(schoolProvinceId),
											Integer.parseInt(schoolCityId),
											areaListDistrict.get(s).getId(),
											null);
							for (int m = 0; m < schoolList.size(); m++) {

								EduUser pojoSchool = new EduUser();
								pojoSchool.setUpdateBy(accLog);
								pojoSchool.setCreateBy(accLog);
								pojoSchool.setStatus(1);
								pojoSchool.setPassword(DataUtil.createRandm(6));
								pojoSchool.setRoleId(4);
								pojoSchool.setRealName("admin");

								while (true) {
									String lg = topStr + "XX"
											+ DataUtil.createRandm(4);
									pojoSchool.setLoginAccount(lg);
									paraMap.put("loginAccount", lg);
									if (userService.searchLoginAccount(paraMap) <= 0) {
										break;
									}
								}

								pojoSchool.setUserProvinceId(Integer
										.parseInt(schoolProvinceId));
								pojoSchool
										.setUserProvinceName(schoolProvinceName);
								pojoSchool.setUserCityId(Integer
										.parseInt(schoolCityId));
								pojoSchool.setUserCityName(schoolCityName);
								pojoSchool.setUserDistrictId(areaListDistrict
										.get(s).getId());
								pojoSchool.setUserDistrictName(areaListDistrict
										.get(s).getName());
								pojoSchool.setSchoolId(schoolList.get(m)
										.getSchoolId());
								pojoSchool.setSchoolName(schoolList.get(m)
										.getSchoolName());
								ids.add(pojoSchool);
							}
						}
					}

				}

				// 选择了省市区
				else if ((schoolDistrictId != null && schoolDistrictId.length() > 0)
						&& (schoolId == null || schoolId.length() == 0)) {

					Map<String, Object> paraArea = new HashMap<String, Object>();
					paraArea.put("code", schoolDistrictId);
					List<SysArea> areaList = sysService
							.selectAreaList(paraArea);
					if (areaList == null || areaList.size() == 0) {
						errorStr = "-5";
						throw new Exception(
								"只生成省管理员，检查失败，系统中不存在地区schoolProvinceId："
										+ schoolProvinceId + "schoolCityId:"
										+ schoolCityId + "schoolDistrictId:"
										+ schoolDistrictId);
					}

					if (createType.equals("TOP")) {
						pojo = new EduUser();
						pojo.setUpdateBy(accLog);
						pojo.setCreateBy(accLog);
						pojo.setStatus(1);
						pojo.setPassword(DataUtil.createRandm(6));
						pojo.setRoleId(3);
						pojo.setRealName("admin");
						while (true) {
							String lg = topStr + areaList.get(0).getAreaCode()
									+ DataUtil.createRandm(4);
							pojo.setLoginAccount(lg);
							paraMap.put("loginAccount", lg);
							if (userService.searchLoginAccount(paraMap) <= 0) {
								break;
							}
						}
						pojo.setUserProvinceId(Integer
								.parseInt(schoolProvinceId));
						pojo.setUserProvinceName(schoolProvinceName);
						pojo.setUserCityId(Integer.parseInt(schoolCityId));
						pojo.setUserCityName(schoolCityName);
						pojo.setUserDistrictId(Integer
								.parseInt(schoolDistrictId));
						pojo.setUserDistrictName(schoolDistrictName);
						ids.add(pojo);
					} else if (createType.equals("ALL")
							|| createType.equals("DOWN")) {
						if (createType.equals("ALL")) {
							pojo = new EduUser();
							pojo.setUpdateBy(accLog);
							pojo.setCreateBy(accLog);
							pojo.setStatus(1);
							pojo.setPassword(DataUtil.createRandm(6));
							pojo.setRoleId(3);
							pojo.setRealName("admin");
							while (true) {
								String lg = topStr
										+ areaList.get(0).getAreaCode()
										+ DataUtil.createRandm(4);
								pojo.setLoginAccount(lg);
								paraMap.put("loginAccount", lg);
								if (userService.searchLoginAccount(paraMap) <= 0) {
									break;
								}
							}
							pojo.setUserProvinceId(Integer
									.parseInt(schoolProvinceId));
							pojo.setUserProvinceName(schoolProvinceName);
							pojo.setUserCityId(Integer.parseInt(schoolCityId));
							pojo.setUserCityName(schoolCityName);
							pojo.setUserDistrictId(Integer
									.parseInt(schoolDistrictId));
							pojo.setUserDistrictName(schoolDistrictName);
							ids.add(pojo);
						}

						// 查询每级区县对应的全部学校
						List<EduSchool> schoolList = schoolService
								.querySchoolList(null, null, Integer
										.parseInt(schoolProvinceId), Integer
										.parseInt(schoolCityId), Integer
										.parseInt(schoolDistrictId), null);
						for (int m = 0; m < schoolList.size(); m++) {

							EduUser pojoSchool = new EduUser();
							pojoSchool.setUpdateBy(accLog);
							pojoSchool.setCreateBy(accLog);
							pojoSchool.setStatus(1);
							pojoSchool.setPassword(DataUtil.createRandm(6));
							pojoSchool.setRoleId(4);
							pojoSchool.setRealName("admin");

							while (true) {
								String lg = topStr + "XX"
										+ DataUtil.createRandm(4);
								pojoSchool.setLoginAccount(lg);
								paraMap.put("loginAccount", lg);
								if (userService.searchLoginAccount(paraMap) <= 0) {
									break;
								}
							}

							pojoSchool.setUserProvinceId(Integer
									.parseInt(schoolProvinceId));
							pojoSchool.setUserProvinceName(schoolProvinceName);
							pojoSchool.setUserCityId(Integer
									.parseInt(schoolCityId));
							pojoSchool.setUserCityName(schoolCityName);
							pojoSchool.setUserDistrictId(Integer
									.parseInt(schoolDistrictId));
							pojoSchool.setUserDistrictName(schoolDistrictName);
							pojoSchool.setSchoolId(schoolList.get(m)
									.getSchoolId());
							pojoSchool.setSchoolName(schoolList.get(m)
									.getSchoolName());
							ids.add(pojoSchool);
						}

					}

				}

				// 选择了省市区校
				else if ((schoolId != null && schoolId.length() > 0)) {
					EduUser pojoSchool = new EduUser();
					pojoSchool.setUpdateBy(accLog);
					pojoSchool.setCreateBy(accLog);
					pojoSchool.setStatus(1);
					pojoSchool.setPassword(DataUtil.createRandm(6));
					pojoSchool.setRoleId(4);
					pojoSchool.setRealName("admin");

					while (true) {
						String lg = topStr + "XX" + DataUtil.createRandm(4);
						pojoSchool.setLoginAccount(lg);
						paraMap.put("loginAccount", lg);
						if (userService.searchLoginAccount(paraMap) <= 0) {
							break;
						}
					}

					pojoSchool.setUserProvinceId(Integer
							.parseInt(schoolProvinceId));
					pojoSchool.setUserProvinceName(schoolProvinceName);
					pojoSchool.setUserCityId(Integer.parseInt(schoolCityId));
					pojoSchool.setUserCityName(schoolCityName);
					pojoSchool.setUserDistrictId(Integer
							.parseInt(schoolDistrictId));
					pojoSchool.setUserDistrictName(schoolDistrictName);
					pojoSchool.setSchoolId(Integer.parseInt(schoolId));
					pojoSchool.setSchoolName(schoolName);

					ids.add(pojoSchool);

				}
			}

			boolean flag = false;

			if (ids.size() > 0) {
				flag = userService.addManagesList(ids);
			} else {
				errorStr = "-3";
				throw new Exception("需要生成的帐号信息为空");
			}

			if (flag) {
				pageInfo.put("success", true);
				pageInfo.put("counts", ids.size());
			} else {
				pageInfo.put("flag", "-2");// 生成失败
				pageInfo.put("success", false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			pageInfo.put("flag", errorStr);
			pageInfo.put("success", false);
			log.error("生成管理员帐号失败:" + e.getMessage());
		}

		return pageInfo;
	}

	/**
	 * 注册入口
	 * 
	 * @author jiabo
	 * @create date 2014-4-25
	 * @return
	 */
	@RequestMapping("/login/register.htm")
	public String toRegisterPage() {
		return "person/register";
	}

	/**
	 * 用户注册
	 * 
	 * @author cl
	 * @create date 2014-4-3
	 * @param request
	 * @return
	 */
	@RequestMapping("/login/addUser.do")
	public @ResponseBody
	Map<String, Object> addUser(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {

			String loginAccount = request.getParameter("loginAccount");
			String mail = request.getParameter("mail");
			String idNumber = request.getParameter("idNumber");
			String teacherNo = request.getParameter("teacherNo");
			// 检查用户名与邮箱教师编号身份证号是否存在
			if (userService.existUserByLoginAccount(loginAccount)) {
				pageInfo.put("flag", "用户名已经存在！");
				throw new Exception("用户名已经存在！");
			}
			if (userService.existUserByIdNumber(idNumber)) {
				pageInfo.put("flag", "身份证号已经存在！");
				throw new Exception("身份证号已经存在！");
			}
			if (mail != null && !mail.equals("")) {
				if (userService.existUserByMail(mail)) {
					pageInfo.put("flag", "邮箱已经存在！");
					throw new Exception("邮箱已经存在！");
				}
			}
			if (teacherNo != null && !teacherNo.equals("")) {
				if (userService.existUserByTeacherNo(teacherNo)) {
					pageInfo.put("flag", "教師编号已经存在！");
					throw new Exception("教師编号已经存在！");
				}
			}
			//
			String password = request.getParameter("password");
			String realName = request.getParameter("realName");
			String mobile = request.getParameter("mobile");
			String paswdQuestionType = request
					.getParameter("paswdQuestionType");
			String paswdAnswer = request.getParameter("paswdAnswer");
			String roleId = request.getParameter("roleId");

			EduUser user = new EduUser();
			user.setStatus(6);
			user.setLoginAccount(loginAccount);
			user.setPassword(password);
			user.setRealName(realName);
			user.setIdNumber(idNumber);
			user.setMail(mail);
			user.setMobile(mobile);
			user.setPaswdQuestionType(Integer.parseInt(paswdQuestionType));
			user.setPaswdAnswer(paswdAnswer);
			user.setRoleId(Integer.parseInt(roleId));
			user.setCreateDate(new Date());
			user.setVersion(1);
			user.setTeacherNo(teacherNo);
			user.setIsPassword(1);
			Integer uid = userService.userRegister(user);
			teacherManageService.saveOtherInfo(uid, this.getAccount(request));
			if (uid == null || uid == 0) {
				pageInfo.put("flag", "-3");
				throw new Exception("用户注册失败！");
			}

			pageInfo.put("success", true);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("用户注册失败，错误信息：" + e.getMessage());
			pageInfo.put("success", false);
		}
		return pageInfo;
	}

	/**
	 * 增加机构管理员
	 * 
	 * @author yinxiaolong
	 * @param request
	 * @return
	 */
	@RequestMapping("/login/addOrgAdmin.do")
	public @ResponseBody
	Map<String, Object> addOrgAdmin(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			String loginAccount = request.getParameter("loginAccount");
			String mail = request.getParameter("mail");
			String idNumber = request.getParameter("idNumber");
			//String teacherNo = request.getParameter("teacherNo");
			// 检查用户名与邮箱教师编号身份证号是否存在
			if (userService.existUserByLoginAccount(loginAccount)) {
				pageInfo.put("flag", "用户名已经存在！");
				throw new Exception("用户名已经存在！");
			}
			if (userService.existUserByIdNumber(idNumber)) {
				pageInfo.put("flag", "身份证号已经存在！");
				throw new Exception("身份证号已经存在！");
			}
			if (mail != null && !mail.equals("")) {
				if (userService.existUserByMail(mail)) {
					pageInfo.put("flag", "邮箱已经存在！");
					throw new Exception("邮箱已经存在！");
				}
			}
			/*if (teacherNo != null && !teacherNo.equals("")) {
				if (userService.existUserByTeacherNo(teacherNo)) {
					pageInfo.put("flag", "教師编号已经存在！");
					throw new Exception("教師编号已经存在！");
				}
			}*/
			//
			String password = request.getParameter("password");
			String realName = request.getParameter("realName");
			String mobile = request.getParameter("mobile");
			String roleId = request.getParameter("roleId");
			Integer organizationId = Integer.parseInt(request.getParameter("organizationId"));
			EduUser user = new EduUser();
			user.setStatus(1);
			user.setLoginAccount(loginAccount);
			user.setPassword(password);
			user.setRealName(realName);
			user.setIdNumber(idNumber);
			user.setMail(mail);
			user.setMobile(mobile);
			user.setRoleId(Integer.parseInt(roleId));
			user.setCreateDate(new Date());
			user.setVersion(1);
			user.setTeacherNo(this.getRandomCode());
			user.setOrganizationId(organizationId);
//			Map<String, Object> parm = getUserLocaltion(request);
			Map<String, Object> parm = getDetailArea(request);
			if (parm != null) {
				Integer cityId = parm.get("cityId") != null ? (Integer.valueOf((String) parm.get("cityId"))) : null;
				Integer provinceId = parm.get("provinceId") != null ? (Integer.valueOf((String) parm.get("provinceId"))) : null;
				Integer districtId = parm.get("districtId") != null ? (Integer.valueOf((String) parm.get("districtId"))) : null;

				String cityName = parm.get("cityName") != null ? (String) parm.get("cityName") : null;
				String provinceName = parm.get("provinceName") != null ? (String) parm.get("provinceName") : null;
				String districtName = parm.get("districtName") != null ? (String) parm.get("districtName") : null;

				user.setUserCityId(cityId);
				user.setUserCityName(cityName);
				user.setUserDistrictId(districtId);
				user.setUserDistrictName(districtName);
				user.setUserProvinceId(provinceId);
				user.setUserProvinceName(provinceName);
			}
			Integer uid = userService.userRegister(user);
			if (uid == null || uid == 0) {
				pageInfo.put("flag", "-3");
				throw new Exception("增加机构管理员失败！");
			}

			pageInfo.put("success", true);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("增加机构管理员失败，错误信息：" + e.getMessage());
			pageInfo.put("success", false);
		}
		return pageInfo;
	}

	/**
	 * 编辑实施机构管理员页面
	 * @author yinxiaolong
	 * @param request
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "getAdminInfo.htm")
	public String getOrgAdminInfo(HttpServletRequest request, ModelMap result) {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			EduUser user = userService.selectOrgAdminInfo(id);
			result.put("user", user);
			request.setAttribute("roleId", user.getRoleId());
			request.setAttribute("loginAccount", user.getLoginAccount());
			request.setAttribute("password", user.getPassword());
			request.setAttribute("realName", user.getRealName());
			request.setAttribute("idNumber", user.getIdNumber());
			request.setAttribute("mail", user.getMail());
			request.setAttribute("mobile", user.getMobile());
//			Map<String, Object> param = getUserLocaltion(request);
			Map<String, Object> param = getArea(request);
			Integer userRoleType = getRoleTypeId(request);
			
			List<SysRole> roles = sysService.queryRoleListByUser(param,userRoleType, false, true,false);
			result.addAttribute("roles", roles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "person/editOrgAdmin";
	}

	/**
	 * 修改机构管理员信息
	 * 
	 * @author yinxiaolong
	 * @param request
	 * @return
	 */
	@RequestMapping("/org/editOrgAdmin.do")
	public @ResponseBody
	Map<String, Object> editOrgAdmin(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			String roleId = request.getParameter("roleId");
			String loginAccount = request.getParameter("loginAccount");
			String mail = request.getParameter("mail");
			String idNumber = request.getParameter("idNumber");
			String teacherNo = request.getParameter("teacherNo");
			Integer id = Integer.parseInt(request.getParameter("id"));
			// 检查用户名与邮箱教师编号身份证号是否存在
			Map<String, Object> accountMap = new HashMap<String, Object>();
			accountMap.put("loginAccount", loginAccount);
			accountMap.put("id", id);
			if (userService.existAdminById(accountMap)) {
				pageInfo.put("flag", "用户名已经存在！");
				throw new Exception("用户名已经存在！");
			}
			Map<String, Object> idNumMap = new HashMap<String, Object>();
			idNumMap.put("idNumber", idNumber);
			idNumMap.put("id", id);
			if (userService.existAdminIdNumber(idNumMap)) {
				pageInfo.put("flag", "身份证号已经存在！");
				throw new Exception("身份证号已经存在！");
			}
			Map<String, Object> emailMap = new HashMap<String, Object>();
			emailMap.put("mail", mail);
			emailMap.put("id", id);
			if (mail != null && !mail.equals("")) {
				if (userService.existAdminEmail(emailMap)) {
					pageInfo.put("flag", "邮箱已经存在！");
					throw new Exception("邮箱已经存在！");
				}
			}
			Map<String, Object> teacherNoMap = new HashMap<String, Object>();
			teacherNoMap.put("teacherNo", teacherNo);
			teacherNoMap.put("id", id);
			if (teacherNo != null && !teacherNo.equals("")) {
				if (userService.existAdminteacherNo(teacherNoMap)) {
					pageInfo.put("flag", "教師编号已经存在！");
					throw new Exception("教師编号已经存在！");
				}
			}
			
			String updateBy = this.getAccount(request);
			String password = request.getParameter("password");
			String realName = request.getParameter("realName");
			String mobile = request.getParameter("mobile");
			EduUser user = new EduUser();
			user.setId(id);
			if(roleId != null && !"".contains(roleId)){
				user.setRoleId(new Integer(roleId));
			}
			user.setLoginAccount(loginAccount);
			user.setUpdateBy(updateBy);
			user.setPassword(password);
			user.setRealName(realName);
			user.setIdNumber(idNumber);
			user.setMail(mail);
			user.setMobile(mobile);
			user.setVersion(1 + userService.getAdminVersion(id));
			user.setTeacherNo(teacherNo);
			boolean flag = userService.updateOrgAdminInfo(user);
			if (!flag) {
				pageInfo.put("flag", "-3");
				throw new Exception("修改机构管理员失败！");
			}

			pageInfo.put("success", true);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("修改机构管理员失败，错误信息：" + e.getMessage());
			pageInfo.put("success", false);
		}
		return pageInfo;
	}
	
	/**
	 *	删除机构管理员 
	 */
	@RequestMapping("/org/deleteOrgAdmin.do")
	public @ResponseBody
	Map<String, Object> editOrgAdmin(Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (userService.deleteOrgAdminById(id)) {
				result.put("success", true);
			}
		} catch (Exception e) {
			log.error("删除机构管理员失败:" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	// 找回密码部份
	// 邮箱找回页面
	@RequestMapping("/login/findPwdByEmail.htm")
	public String toFindPwdByMailPage() {
		return "person/findpwdbyemail";
	}

	@RequestMapping("/login/chkFindPwdByEmail.do")
	public @ResponseBody
	Map<String, Object> chkFindPwdByEmail(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			String loginAccount = request.getParameter("loginAccount");
			String mail = request.getParameter("mail");
			String randcode = request.getParameter("randcode");
			if (randcode == null
					|| !randcode.equals(request.getSession().getAttribute(
							"rand"))) {
				pageInfo.put("flag", "验证码错误");
				pageInfo.put("success", false);
				return pageInfo;
			}
			EduUser u = userService
					.getUserByLoginAccountOrIdNumber(loginAccount);
			if (u == null) {
				pageInfo.put("flag", "没有此用户，请输入正确的用户名");
				pageInfo.put("success", false);
				return pageInfo;
			}
			if (mail == null || !u.getMail().equals(mail)) {
				pageInfo.put("flag", "邮箱错误，请重新输入您注册时的邮箱");
				pageInfo.put("success", false);
				return pageInfo;
			}
			userForgotpasswordService.deleteByUid(u.getId());
			EduUserForgotpassword ufp = new EduUserForgotpassword();
			Integer code = (int) (Math.random() * 1000000);
			ufp.setCode(String.valueOf(code));
			ufp.setUid(u.getId());
			ufp.setCreateTime(new Date());
			ufp.setCreateIp(request.getRemoteAddr());
			Integer id = userForgotpasswordService.insert(ufp);
			// 根据用户邮件地址发送修改密码链接
			String[] to = { mail };
			String filepath = request.getRealPath("/")
					+ "/static/templat/email/" + "findpwd.vm";
			String ec = FileUtil.readFile(filepath, "utf8");
			// System.out.println(ec);
			String from = ApplicationProperties
					.getPropertyValue("eduSiteTitle").toString();
			ec = ec.replace("${hosturl}", ApplicationProperties
					.getPropertyValue("eduHostPath").toString());
			ec = ec.replace("${id}", id.toString());
			ec = ec.replace("${uid}", u.getId().toString());
			ec = ec.replace("${code}", code.toString());
			ec = ec.replace("${sysSiteTitle}", from);
			MailSender mailSender = new MailSender(from, to, null, from
					+ "，找回密码", ec, null);
			mailSender.send();

			pageInfo.put("success", true);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("用户注册失败，错误信息：" + e.getMessage());
			pageInfo.put("success", false);
		}
		return pageInfo;
	}

	@RequestMapping("/login/toUpdatePasswordByMail.htm")
	public String toEditPwdByMailPage(ModelMap map, HttpServletRequest request) {

		try {
			map.put("flag", true);
			map.put("tip", "");
			String code = request.getParameter("code");
			Integer id = Integer.parseInt(request.getParameter("id"));
			Integer uid = Integer.parseInt(request.getParameter("uid"));
			EduUserForgotpassword ufp = userForgotpasswordService
					.selectByUid(uid);
			if (ufp == null || !ufp.getId().equals(id)) {
				map.put("flag", false);
				map.put("tip", "您没有过邮箱找回密码记录");
				return "person/updatePasswordByMail";
			}
			if (DateUtil.now().getTime() > DateUtil.getDay(ufp.getCreateTime(),
					1).getTime()) {
				map.put("flag", false);
				map.put("tip", "邮件链接失效，请重新找回密码");
				return "person/updatePasswordByMail";
			}
			request.getSession().setAttribute("ufp", ufp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return "person/updatePasswordByMail";
	}

	@RequestMapping("/login/updatePasswordByMail.do")
	public @ResponseBody
	Map<String, Object> editFindPwdByEmail(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			String id = request.getParameter("id");
			String loginAccount = request.getParameter("loginAccount");
			String password = request.getParameter("password");
			EduUser u = userService
					.getUserByLoginAccountOrIdNumber(loginAccount);
			if (u == null) {
				pageInfo.put("flag", "没有此用户，请输入正确的用户名");
				pageInfo.put("success", false);
				return pageInfo;
			}
			if (id == null) {
				Object obj = request.getSession().getAttribute("ufp");
				if (obj == null) {
					pageInfo.put("flag", "错误");
					pageInfo.put("success", false);
					return pageInfo;
				}
				EduUserForgotpassword ufp = (EduUserForgotpassword) obj;
				if (!u.getId().equals(ufp.getUid())) {
					pageInfo.put("flag", "找回密码错误，邮件链接对应的用户与本次操作的用户不一致");
					pageInfo.put("success", false);
					return pageInfo;
				}
				userForgotpasswordService.deleteByUid(u.getId());
				request.getSession().removeAttribute("ufp");
			}

			EduUserActivty ua = new EduUserActivty();
			ua.setUserId(u.getId());
			ua.setPassword(password);
			ua.setIsPassword(1);
			userService.updatePsdUser(ua);
			pageInfo.put("success", true);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("用户找回密码，错误信息：" + e.getMessage());
			pageInfo.put("success", false);
		}
		return pageInfo;
	}

	// 密保找回密码
	@RequestMapping("/login/findPwdByQuestion.htm")
	public String toFindPwdByQuestionPage() {
		return "person/findpwdbyquestion";
	}

	@RequestMapping("/login/chkFindPwdByQuestion.do")
	public @ResponseBody
	Map<String, Object> chkFindPwdByQuestion(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			String loginAccount = request.getParameter("loginAccount");
			String paswdQuestionType = request
					.getParameter("paswdQuestionType");
			String paswdAnswer = request.getParameter("paswdAnswer");
			String randcode = request.getParameter("randcode");
			if (randcode == null
					|| !randcode.equals(request.getSession().getAttribute(
							"rand"))) {
				pageInfo.put("flag", "验证码错误");
				pageInfo.put("success", false);
				return pageInfo;
			}
			EduUser u = userService.getUserByLoginAccountOrIdNumber(loginAccount);
			if (u == null) {
				pageInfo.put("flag", "没有此用户，请输入正确的用户名");
				pageInfo.put("success", false);
				return pageInfo;
			}
			if (u.getPaswdQuestionType() != Integer.parseInt(paswdQuestionType)
					|| !u.getPaswdAnswer().equals(paswdAnswer)) {
				pageInfo.put("flag", "密码提示问题或答案错误，请输入正常答案");
				pageInfo.put("success", false);
				return pageInfo;
			}

			pageInfo.put("user", u);
			pageInfo.put("success", true);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("用户注册失败，错误信息：" + e.getMessage());
			pageInfo.put("success", false);
		}
		return pageInfo;
	}

	/**
	 * 用户密码重置
	 * @return
	 */
	@RequestMapping("/login/resetpwdByIdcard.htm")
	public String toResetpwdByIdcardPage() {
		return "person/resetpwdByIdcard";
	}
	
	private static Map<String,String> teacherInfos = new HashMap<String,String>();
	@RequestMapping("/login/updatePasswordByIdcard.do")
	public @ResponseBody
	Map<String, Object> updatePasswordByIdcard(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			String userName = request.getParameter("userName");
			String loginAccount = request.getParameter("loginAccount");
			String randcode = request.getParameter("randcode");
			if (randcode == null || !randcode.equals(request.getSession().getAttribute("rand"))) {
				pageInfo.put("flag", "验证码错误");
				pageInfo.put("success", false);
				return pageInfo;
			}
			
			EduUser user = userService.getUserByLoginAccountOrIdNumber(loginAccount);
			
			if (user == null) {
				pageInfo.put("flag", "没有此身份证号，请输入正确的账户信息");
				pageInfo.put("success", false);
				return pageInfo;
			}else {
				if (StringUtils.isNotEmpty(userName) && !userName.equals(user.getRealName())) {
					pageInfo.put("flag", "真实姓名和身份证号不匹配！");
					pageInfo.put("success", false);
					return pageInfo;
				}
				if(user.getIsPassword() == null || user.getIsPassword() == 0){
					pageInfo.put("flag", "用户未登陆过系统，请使用初始密码登录系统！");
					pageInfo.put("success", false);
					return pageInfo;
				}
				//当前时间
				String oldTime = teacherInfos.get("checkDate");
				String currentDate = DateUtil.dateToShortStr(new Date());
				if(StringUtils.isNotEmpty(oldTime) && !oldTime.equals(currentDate)){
					teacherInfos.clear();
				}
				if(teacherInfos.containsKey(user.getIdNumber()) && teacherInfos.get(user.getIdNumber()).equals(currentDate)){
					pageInfo.put("flag", "今天您已经重置密码，重置密码每天只限一次！");
					pageInfo.put("success", false);
					return pageInfo;
				}
				//重置密码
				user.setPassword(user.getIdNumber().substring(user.getIdNumber().length()-6));
				user.setIsPassword(Common.DEFAULT_VALUE);
				int result = teacherManageService.saveTeacherUserInfo(user);
				teacherInfos.put("checkDate", DateUtil.dateToShortStr(new Date()));
				teacherInfos.put(user.getIdNumber(), DateUtil.dateToShortStr(new Date()));
				
				pageInfo.put("Message", "用户 "+user.getRealName() +"【 "+user.getIdNumber()+" 】"+"重置了用户密码！");
				pageInfo.put("createDate",new Date());
				pageInfo.put("userIp",SendHttpRequest.getLocalIp(request));
				sysService.insertSysLog(request, pageInfo);
				if(result >=0){
					pageInfo.put("success", true);
					pageInfo.put("user", user);
					pageInfo.put("flag", "密码重置成功,请及时登录系统修改用户密码！");
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			log.error("用户操作失败，错误信息：" + e.getMessage());
			pageInfo.put("success", false);
		}
		return pageInfo;
	}
	
	/**
	 * 设置默认选中的地区
	 */
	private void setArea(HttpServletRequest request) {
		Map<String, Object> map = super.getCode(request);
		int roleId = (Integer) map.get("roleId");
		if (roleId == 1 || roleId == 7) {
			request.setAttribute("areaName", super.getSessionUserInfo(request)
					.getUserProvinceName());
			request.setAttribute("areaId", super.getSessionUserInfo(request)
					.getUserProvinceId());
			request.setAttribute("areaType", "provinceId");
		} else if (roleId == 2 || roleId == 8) {
			request.setAttribute("areaName", super.getSessionUserInfo(request)
					.getUserCityName());
			log.info(super.getSessionUserInfo(request).getUserCityName());
			request.setAttribute("areaId", super.getSessionUserInfo(request)
					.getUserCityId());
			request.setAttribute("areaType", "cityId");
		} else if (roleId == 3 || roleId == 4 || roleId == 9 || roleId == 10) {
			request.setAttribute("areaName", super.getSessionUserInfo(request)
					.getUserDistrictName());
			request.setAttribute("areaId", super.getSessionUserInfo(request)
					.getUserDistrictId());
			request.setAttribute("areaType", "districtId");
		}
	}
	//生成随机编号
	public String getRandomCode(){
		 //SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		 //String date = df.format(new Date());
		 Date  df = new Date();
		 long date = df.getTime();

	     int[] array = {0,1,2,3,4,5,6,7,8,9};
	     Random rand = new Random();
	     for (int i = 10; i > 1; i--) {
	         int index = rand.nextInt(i);
	         int tmp = array[index];
	         array[index] = array[i - 1];
	         array[i - 1] = tmp;
	     }
	     int result = 0;
	     for(int i = 0; i < 6; i++)
	         result = result * 10 + array[i];

	     long code = date+result;
        log.info("code===="+code);	         
		return code+"";
	}
	
	
	@RequestMapping(value = "/getTeacherById.do")
	@ResponseBody
	public Map<String,Object> getTeacherById(@RequestParam("teacherId") Integer id) {
		Map<String,Object> result =new HashMap<String,Object>();
		try {
			EduUser user = userService.getUserById(id);
			result.put("success", true);
			result.put("user", user);
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 教师保存头像
	 * @param imgUrl
	 * @param request
	 * @return
	 */
	@RequestMapping("/savePhoto.do")
	public  @ResponseBody Map<String, Object>savePhoto(Integer teacherId,String imgUrl, HttpServletRequest request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		try {
			if("".equals(imgUrl) || imgUrl == null){
				paramMap.put("success", false);
				return paramMap;
			}
			EduUser user = new EduUser();
			int userid;
			userid = super.getAccountId(request);
			user.setId(teacherId);
            user.setUserImageUrl(imgUrl);
			user.setUpdateBy(String.valueOf(userid));					
						
			int result = teacherManageService.saveTeacherUserInfo(user);
			if(result < 0) {
				paramMap.put("success", false);
			}else {
				EduUserActivty userActivity =  super.getSessionUserInfo(request);
				userActivity.setUserImageUrl(imgUrl);

				request.getSession().setAttribute("userinfo", userActivity);
				paramMap.put("success", true);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paramMap;
	}
	
	
}
