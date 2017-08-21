package project.teacher.teachermanage.controller;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
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

import project.person.pojo.EduUser;
import project.teacher.teacherProject.service.ITeacherProjectServiceIF;
import project.teacher.teachermanage.dao.ITeacherReadDao;
import project.teacher.teachermanage.dto.EduTeacherEduDTO;
import project.teacher.teachermanage.pojo.EduAudit;
import project.teacher.teachermanage.pojo.EduTeacherAdjust;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.pojo.EduTeacherJob;
import project.teacher.teachermanage.pojo.EduTeacherMobilize;
import project.teacher.teachermanage.pojo.TeacherExportActivity;
import project.teacher.teachermanage.service.ITeacherManageService;
import framelib.common.Common;
import framelib.controller.AbsController;
import framelib.utils.page.PageObject;

/**
 * 
 * 教师信息控制器
 * 
 * @Create_by:dengguo
 * @Create_date:2014-1-8
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 * 
 */
@SuppressWarnings("deprecation")
@Controller
@RequestMapping("/teacher/teachermanage")
public class TeacherManageController extends AbsController {
	private static final Logger log = Logger
			.getLogger(TeacherManageController.class);

	@Autowired
	@Qualifier("teacherManageService")
	ITeacherManageService teacherManageService;

	@Autowired
	@Qualifier("teacherProjectService")
	ITeacherProjectServiceIF teacherProjectServiceIF;
	
	@Autowired
	@Qualifier("teacherReadDao")
	ITeacherReadDao teacherReadDao;

	/**
	 * 跳转教师离退休管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "teacherRetireesPage.htm")
	public String teacherRetireesPage(ModelMap map, HttpServletRequest request) {
		map.put("areaName", this.getCode(request).get("areaName"));
		map.put("areaId", this.getCode(request).get("areaId"));
		map.put("areaType", this.getCode(request).get("areaType"));
		return "teacher/teacherRetirees";
	}
	
	/**
	 * 跳转教师病休管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "teacherSickPage.htm")
	public String teacherSickPage(ModelMap map, HttpServletRequest request) {
		map.put("areaName", this.getCode(request).get("areaName"));
		map.put("areaId", this.getCode(request).get("areaId"));
		map.put("areaType", this.getCode(request).get("areaType"));
		return "teacher/teacherSick";
	}
	
	/**
	 * 跳转教师离休管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "teacherDimissionPage.htm")
	public String teacherDimissionPage(ModelMap map, HttpServletRequest request) {
		map.put("areaName", this.getCode(request).get("areaName"));
		map.put("areaId", this.getCode(request).get("areaId"));
		map.put("areaType", this.getCode(request).get("areaType"));
		return "teacher/teacherDimission";
	}
	
	/**
	 * 跳转教师死亡登记管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "teacherDeadPage.htm")
	public String teacherDeadPage(ModelMap map, HttpServletRequest request) {
		map.put("areaName", this.getCode(request).get("areaName"));
		map.put("areaId", this.getCode(request).get("areaId"));
		map.put("areaType", this.getCode(request).get("areaType"));
		return "teacher/teacherDead";
	}
	
	/**
	 * 转到导入教师信息页面
	 * @return
	 */
	@RequestMapping("toImportRetireesTeacherPage.htm")
	public String toImportTeacherPage(){
		return "teacher/uploadRetireesTeacher";
	}

	/**
	 * 跳转教师新增页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "editeTeacherPage.htm")
	public String editeTeacherPage(ModelMap map, Integer teacherId) {
		map.put("teacherId", teacherId);
		return "teacher/editeTeacher";
	}

	/**
	 * 教师预览页面
	 * 
	 * @param map
	 * @param teacherId
	 * @return
	 */
	@RequestMapping(value = "showAndPrintTeacherPage.htm")
	public String showAndPrintTeacherPage(ModelMap map, Integer teahcerId,
			Integer teacherId) {
		map.put("teacherId", teahcerId);
		return "teacher/showAndPrintTeacher";
	}

	/**
	 * 跳转教师审核页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "auditTeacherPage.htm")
	public String auditTeacherPage(ModelMap map, Integer teacherId) {
		map.put("teacherId", teacherId);
		return "teacher/auditTeacher";
	}

	/**
	 * 跳转教师新增页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "createTeacherPage.htm")
	public String createTeacherPage(ModelMap map) {
		return "teacher/createTeacher";
	}

	/**
	 * 跳转教师管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "teacherManagePage.htm")
	public String teacherManagePage(ModelMap map, HttpServletRequest request) {
		map.put("areaName", this.getCode(request).get("areaName"));
		map.put("areaId", this.getCode(request).get("areaId"));
		map.put("areaType", this.getCode(request).get("areaType"));
		return "teacher/teacherManage";
	}

	/**
	 * 跳转教师查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "teacherManageQueryPage.htm")
	public String teacherManageQueryPage(ModelMap map, HttpServletRequest request) {
		map.put("areaName", this.getCode(request).get("areaName"));
		map.put("areaId", this.getCode(request).get("areaId"));
		map.put("areaType", this.getCode(request).get("areaType"));
		return "teacher/teacherManageQuery";
	}
	
	/**
	 * 假删除教师
	 * 
	 * @return
	 */
	@RequestMapping(value = "removeTeacher.do")
	public @ResponseBody
	Map<String, Object> removeTeacher(ModelMap map, String data,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (!StringUtils.isEmpty(data)) {
				Integer userId = teacherManageService.deleteTeacherBatch(data,
						this.getAccount(request));
				if (userId != null && userId.intValue() >= 0) {
					result.put("success", true);
					result.put("userId", userId);
				} else {
					result.put("success", false);
				}
			}
		} catch (Exception e) {
			log.error("逻辑删除 教师  EduUser 表失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	/**
	 * 真删除教师
	 * 
	 * @return
	 */
	@RequestMapping(value = "deleteTeacher.do")
	public @ResponseBody
	Map<String, Object> deleteTeacher(ModelMap map, String data,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (!StringUtils.isEmpty(data)) {
				Integer userId = teacherManageService.deleteTeacher(data);
				if (userId != null && userId.intValue() >= 0) {
					result.put("success", true);
					result.put("userId", userId);
				} else {
					result.put("success", false);
				}
			}
		} catch (Exception e) {
			log.error("逻辑删除 教师  EduUser 表失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}

	/**
	 * 审核教师
	 * 
	 * @return
	 */
	@RequestMapping(value = "auditTeacher.do")
	public @ResponseBody
	Map<String, Object> auditTeacher(ModelMap map, String data, boolean isPass,
			String memo, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (!StringUtils.isEmpty(data)) {
				Integer userId = teacherManageService.modifyAuditTeacherBatch(
						data, this.getAccount(request),this.getRealName(request), isPass, memo);
				if (userId != null && userId.intValue() >= 0) {
					result.put("success", true);
					result.put("userId", userId);
				} else {
					result.put("success", false);
				}
			}
		} catch (Exception e) {
			log.error(" 教师审核失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}

	/**
	 * 保存基本属性
	 * 
	 * @return
	 */
	@RequestMapping(value = "saveTeacher.do")
	public @ResponseBody
	Map<String, Object> saveTeacherUser(ModelMap map, String data,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			EduUser pojo = mapper.readValue(data, EduUser.class);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			// 验证教师Account资料信息
			paramMap.put("loginAccount", pojo.getLoginAccount());
			EduUser eduUserInfo = teacherProjectServiceIF.selectTeacherBasicInfo(paramMap);
			if (eduUserInfo != null && eduUserInfo.getId().intValue() != pojo.getId()) {
				result.put("success", false);
				result.put("msg", -1);
				return result;
			}
			
			// 验证教师身份证信息资料信息
			paramMap.remove("loginAccount");
			paramMap.put("idNumber", pojo.getIdNumber());
			eduUserInfo = teacherProjectServiceIF
					.selectTeacherBasicInfo(paramMap);
			if (eduUserInfo != null && eduUserInfo.getId().intValue() != pojo.getId()) {
				result.put("success", false);
				result.put("msg", -2);
				return result;
			}
			
			// 验证教师编号信息资料信息
			paramMap.remove("idNumber");
			paramMap.put("teacherNo", pojo.getTeacherNo());
			eduUserInfo = teacherProjectServiceIF
					.selectTeacherBasicInfo(paramMap);
			if (eduUserInfo != null
					&& eduUserInfo.getId().intValue() != pojo.getId()) {
				result.put("success", false);
				result.put("msg", -3);
				return result;
			}

			if (pojo != null) {
				pojo.setCreateBy(getAccount(request));
				pojo.setUpdateBy(getAccount(request));
				pojo.setCreateDate(new Date());
				pojo.setUpdateDate(new Date());
			}
			Integer userId = teacherManageService.saveTeacherUserInfo(pojo);

			if(userId != null && userId.intValue() >= 0) {

				result.put("success", true);
				result.put("userId", userId);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			log.error("保存teacher  EduUser 表失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}

	
	/**
	 * 保存基本属性
	 * 
	 * @return
	 */
	@RequestMapping(value = "saveTeacherBaseInfo.do")
	public @ResponseBody
	Map<String, Object> saveTeacherBaseInfo(ModelMap map, String data,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			EduTeacherBasicInfo pojo = mapper.readValue(data,
					EduTeacherBasicInfo.class);
			if (pojo != null) {
				pojo.setTeacherCreateBy(getAccount(request));
				pojo.setTeacherUpdateBy(getAccount(request));
				pojo.setTeacherCreateDate(new Date());
				pojo.setTeacherUpdateDate(new Date());
				pojo.setVersion(1);
			}
			//数据库字段类型是DAte,变量是String,如果传过来的值是"",将不能保存成功，故变量值设置为null
			if("".equals(pojo.getTeacherBornDate())){
				pojo.setTeacherBornDate(null);
			}
			if("".equals(pojo.getPartyTime())){
				pojo.setPartyTime(null);
			}
			Integer eduBaseId = teacherManageService.saveTeacherBaseInfo(pojo, getRoleId(request));
			if (eduBaseId != null && eduBaseId.intValue() >= 0) {
				result.put("success", true);
				result.put("eduBaseId", eduBaseId);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			log.error("保存teacher  BaseInfo 表失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}

	/**
	 * 保存教师教育经历
	 * 
	 * @return
	 */
	@RequestMapping(value = "saveTeacherEdu.do")
	public @ResponseBody
	Map<String, Object> saveTeacherEduInfo(ModelMap map, String data,
			HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> result = new HashMap<String, Object>();
		try {

			EduTeacherEduDTO dto = mapper.readValue(data,
					EduTeacherEduDTO.class);
			if (dto.getEduInfoList() != null && dto.getEduInfoList().size() > 0) {
				Integer userId = teacherManageService.saveTeacherEducation(dto,
						this.getAccount(request), this.getRoleId(request));
			}
			result.put("success", true);
		} catch (Exception e) {
			log.error("保存teacher  Edu 表失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}

	/**
	 * 保存教师工作经历属性
	 * 
	 * @return
	 */
	@RequestMapping(value = "saveTeacherJob.do")
	public @ResponseBody
	Map<String, Object> saveTeacherJobInfo(ModelMap map, String data,
			HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			EduTeacherJob pojo = mapper.readValue(data, EduTeacherJob.class);
			//数据库字段类型是DAte,变量是String,如果传过来的值是"",将不能保存成功，故变量值设置为null
			if("".equals(pojo.getJobCertificateDate())){
				pojo.setJobCertificateDate(null);
			}
			if("".equals(pojo.getJobCommentDate())){
				pojo.setJobCommentDate(null);
			}
			if("".equals(pojo.getJobWorkTime())){
				pojo.setJobWorkTime(null);
			}
			if("".equals(pojo.getJobWorkDate())){
				pojo.setJobWorkDate(null);
			}
			if("".equals(pojo.getJobRecruitmentDate())){
				pojo.setJobRecruitmentDate(null);
			}
			if("".equals(pojo.getCjqsny())){
				pojo.setCjqsny(null);
			}
			if("".equals(pojo.getPostGrade())){
				pojo.setPostGrade(null);
			}
			if("".equals(pojo.getJdflTime())){
				pojo.setJdflTime(null);
			}
			if("".equals(pojo.getPostBack())){
				pojo.setPostBack(null);
			}
			//如果是管理员首先校验是否存在未审核的个人工作记录变更
			Integer roleId = getRoleId(request);
			if(roleId.intValue() != project.common.Common.ROLE_TEACHER_5.intValue()){
				//1、检查是否存在未审核的个人变更记录
				log.info("发起 调动/返聘操作 teacherId" + pojo.getTeacherId() + "1、检查是否存在未审核的个人信息变更记录");
				result.put("auditStatus", project.common.Common.COMMON_AUDIT_UNHANDL);
				result.put("teacherId",pojo.getTeacherId());
				result.put("changeType1", 1);
				result.put("changeType2", 1);
				if(teacherReadDao.selectAuditChangeType(result)>0){
					result.put("flag", -1);
					result.put("success", false);
					return result;
				}	
			}
			
			// 发起教师调动和编制调整后,在未进行审核时不能进行修改操作
			result.put("auditStatus", project.common.Common.COMMON_AUDIT_UNHANDL);
			result.put("teacherId",pojo.getTeacherId());
			result.remove("changeType1");
			result.remove("changeType2");
			result.put("changeType1", 2);
			result.put("changeType2", 2);
			if(teacherReadDao.selectAuditChangeType(result)>0){
				result.put("flag", -2);
				result.put("success", false);
				log.debug(" teacherId" + pojo.getTeacherId() + ",发起教师调动和编制调整后,在未进行审核时不能进行修改操作");
				return result;
			}
			
			//3、发起教师个人离退休后,在未进行审核时不能进行修改操作
			result.remove("changeType1");
			result.remove("changeType2");
			result.put("changeType1", 31);
			result.put("changeType2", 36);
			if(teacherReadDao.selectAuditChangeType(result)>0){
				result.put("flag", -3);
				result.put("success", false);
				log.info(" teacherId" + pojo.getTeacherId() + ",发起教师个人离退休后,在未进行审核时不能进行修改操作");
				return result;
			}
			
			
			//3、发起教师编制后,在未进行审核时不能进行修改操作			
			result.remove("changeType1");
			result.remove("changeType2");
			result.put("changeType1", 50);
			result.put("changeType2", 50);
			if(teacherReadDao.selectAuditChangeType(result)>0){
				result.put("flag", -4);
				result.put("success", false);
				log.info(" teacherId" + pojo.getTeacherId() + ",发起教师编制后,在未进行审核时不能进行修改操作");
				return result;
			}
			if (pojo != null) {
					pojo.setJobCreateBy(getAccount(request));
					pojo.setJobUpdateBy(getAccount(request));
					pojo.setJobCreateDate(new Date());
					pojo.setJobUpdateDate(new Date());
					pojo.setVersion(1);
				}
				// 获取系统开关设置
	//			List<String> sysInfo = getTeacherInfoChangeAudit(request);
				Integer eduJobId = teacherManageService.saveTeacherJobInfo(pojo,
						null, getRoleId(request), getRealName(request));
				if (eduJobId != null && eduJobId.intValue() >= 0) {
					result.put("success", true);
					result.put("eduJobId", eduJobId);
				} else {
					result.put("success", false);
				}
			
		} catch (Exception e) {
			log.error("保存teacher  Job 表失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}

	/**
	 * 创建教师病休/离岗/死亡登记/离退休
	 * 
	 * @return
	 */
	@RequestMapping(value = "teacherRetirees.do")

	public @ResponseBody Map<String,Object> retireesOption(String teacherId , String changeType, String mobilizeMark,  HttpServletRequest request) {

		Map<String, Object> result = new HashMap<String, Object>();
		try {

			Integer eduJobId = teacherManageService.modifyTeacherRetirees(teacherId, changeType, this.getRealName(request), this.getAccount(request), mobilizeMark);
			
			if(eduJobId != null && eduJobId.intValue() >= 0) {

				result.put("success", true);
				result.put("msgcode", eduJobId);
			} else {
				result.put("success", false);
				result.put("msgcode", eduJobId);
			}
		} catch (Exception e) {

			log.error("保存teacher  Job 表失败--->" + e.getMessage());

			log.error("教师离退休操作 失败--->"+e.getMessage());

			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 教师病休/离岗/离退休/死亡登记审核操作
	 * 
	 * @return
	 */
	@RequestMapping(value = "teacherRetireesAudit.do")

	public @ResponseBody Map<String,Object> retireesOptionAudit(String auditId, String teacherId , String changeType, String auditStatus, String auditOption, HttpServletRequest request) {

		Map<String, Object> result = new HashMap<String, Object>();
		try {

			Integer eduJobId = teacherManageService.modifyTeacherRetireesAudit(
					auditId, teacherId, changeType, auditStatus, auditOption,  this.getRealName(request), this
							.getAccount(request));
			
			if(eduJobId != null && eduJobId.intValue() >= 0) {
				result.put("success", true);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {

			log.error("保存teacher  Job 表失败--->" + e.getMessage());

			log.error("教师离退休操作 失败--->"+e.getMessage());

			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}

	/**
	 * 查询已发起病休/离岗/死亡登记/离退休教师列表
	 * 
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryTeacherRetireesActivetyList.do")
	public @ResponseBody
	Map<String, Object> queryTeacherRetireesActivetyList(int pageIndex,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();

		try {
			Map<String, Object> paramMap = getArea(request);
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

			if (!StringUtils.isEmpty(request.getParameter("queryYear"))) {
				paramMap.put("queryYear", request.getParameter("queryYear"));
			}

			if (!StringUtils.isEmpty(request.getParameter("realName"))) {
				paramMap.put("realName", request.getParameter("realName"));
			}

			if (!StringUtils.isEmpty(request.getParameter("idNumber"))) {
				paramMap.put("idNumber", request.getParameter("idNumber"));
			}

			if (!StringUtils.isEmpty(request.getParameter("areaType"))) {
				paramMap.put(request.getParameter("areaType"), request.getParameter("areaId"));
			}

			if (!StringUtils.isEmpty(request.getParameter("changeType"))) {
				paramMap.put("changeType", request.getParameter("changeType"));
			}
			
			if (!StringUtils.isEmpty(request.getParameter("changeTypeRetirees"))) {
				paramMap.put("changeTypeRetirees", request.getParameter("changeTypeRetirees"));
			}

			if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}

			pageIndex = (pageIndex - 1) * sizePerPage;

			// 2查询分页数据
			PageObject po = teacherManageService.queryTeacherRetiressActivetyListPage(paramMap, pageIndex, sizePerPage);
			if (po != null && po.getCount() > 0) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
				pageInfo.put("total", po.getCount());
				pageInfo.put("pageSize", po.getPagesize());
				pageInfo.put("pages", po.getPages());
				pageInfo.put("currentPage", po.getCurrentPage());
				pageInfo.put("pageNumbers", po.getPageNumbers());
				pageInfo.put("startIndex", po.getStartIndex());
			} else {
				pageInfo.put("total", 0);
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师信离退休查询错误:" + e);
		}
		return pageInfo;
	}

	
	
		
		/**
		 * 教师花名册导出
		 * @param pageIndex
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		
		@RequestMapping(value = "exportTeacherInforList.do")
		public void exportTeacherInforList(String arrChk, String queryConditionArray,HttpServletRequest request, HttpServletResponse response) throws Exception {
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				Map<String,Object> paramMap = getCode(request);
				
				// 筛选条件查询
				if(!StringUtils.isEmpty(queryConditionArray)) {
					String[] conditionStr = mapper.readValue(queryConditionArray, String[].class);
					for (int i = 0; i < conditionStr.length; i++) {
						if(StringUtils.isEmpty(conditionStr[i])) 
							continue;
						paramMap.put(conditionStr[i].substring(0, conditionStr[i].indexOf('_')), 
								conditionStr[i].subSequence(conditionStr[i].indexOf('_') + 1, conditionStr[i].length()));
					}
					
				}
				
				if(!StringUtils.isEmpty(arrChk)) {
					paramMap.put("teachers", arrChk);
				}
				
				if(!StringUtils.isEmpty(request.getParameter("projectSubject"))) {
					paramMap.put("projectSubject", request.getParameter("projectSubject"));
				}
				
				if(!StringUtils.isEmpty(request.getParameter("stdutySection"))) {
					paramMap.put("stdutySection", request.getParameter("stdutySection"));
				}
				
				if(!StringUtils.isEmpty(request.getParameter("queryRealName"))) {
					paramMap.put("queryRealName", request.getParameter("queryRealName"));
				}
				
				if(!StringUtils.isEmpty(request.getParameter("queryTeacherNo"))) {
					paramMap.put("queryTeacherNo", request.getParameter("queryTeacherNo"));
				}
				
				if(!StringUtils.isEmpty(request.getParameter("queryIdNumber"))) {
					paramMap.put("queryIdNumber", request.getParameter("queryIdNumber"));
				}
				
				
				// 2查询分页数据
				 List<TeacherExportActivity> list = teacherManageService.queryTeacherActivetyListNoPage(paramMap);
				
				 String path = request.getRealPath("/")+"template"+File.separator+"download_teacher.xls";
				 
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
					 Cell cellE = row.createCell(4);
					 if(getTeacherInfoSafe(request) == 1) {
						 cellC.setCellValue(list.get(i).getIdNumber());
						 cellE.setCellValue(list.get(i).getMobile());
					 } 
					 
					 Cell cellD = row.createCell(3);
					 cellD.setCellValue(list.get(i).getGender() !=null && list.get(i).getGender().intValue() == 1 ? "男" : "女");
					 
					 
					 
					 Cell cellF = row.createCell(5);
					 cellF.setCellValue(list.get(i).getMail());
					 
					 Cell cellG = row.createCell(6);
					 cellG.setCellValue(list.get(i).getUserProvinceName());
					 
					 Cell cellH = row.createCell(7);
					 cellH.setCellValue(list.get(i).getUserCityName());
					 
					 Cell cellI = row.createCell(8);
					 cellI.setCellValue(list.get(i).getUserDistrictName());
					 
					 Cell cellJ = row.createCell(9);
					 cellJ.setCellValue(list.get(i).getSchoolCode());
					 
					 Cell cellK = row.createCell(10);
					 cellK.setCellValue(list.get(i).getSchoolName());
					 
					 Cell cellL = row.createCell(11);
					 cellL.setCellValue(list.get(i).getJobFormerTeachingSubject());
					 
					 Cell cellM = row.createCell(12);
					 cellM.setCellValue(list.get(i).getEducationExperience());
					 
					 Cell cellN = row.createCell(13);
					 cellN.setCellValue(list.get(i).getJobCommentPosition());
					 
					 Cell cellO = row.createCell(14);
					 cellO.setCellValue(list.get(i).getJobRecruitmentPosition());
					 
					 Cell cellP = row.createCell(15);
					 cellP.setCellValue(list.get(i).getJobSchoolAdministrationOffice());
					 
					 Cell cellQ = row.createCell(16);
					 cellQ.setCellValue(list.get(i).getJobCoreTeacher());
					 
					 Cell cellR = row.createCell(17);
					 cellR.setCellValue(list.get(i).getJobWhetherTeacher() != null && list.get(i).getJobWhetherTeacher().equals("1") ? "是" : "否");
					 
					 Cell cells = row.createCell(18);
					 cells.setCellValue(list.get(i).getJobCountyRuralTeacher()!= null && list.get(i).getJobCountyRuralTeacher().equals("1") ? "是" : "否");
					 
				 }
				 
				 exportExcelFromTemplet(request, response, wb, "downLoad_teacher");

				 
			} catch (Exception e) {
				e.printStackTrace();
				log.error("教师信息综合查询导出错误:" + e);
			}
		}
		
		//报表导出(选择任意字段导出)
		@RequestMapping(value = "exportTeachers.do")
		public void exportTeachers(HttpServletRequest request, HttpServletResponse response,String queryConditionArray,String feildsAry,String checkedData,String tIds) throws Exception {
			
			Map<String,Object> paramMap = getCode(request);
			if(!StringUtils.isEmpty(tIds)) {
				paramMap.put("teachers", tIds);
			}
			if(!StringUtils.isEmpty(request.getParameter("queryRealName"))) {
				paramMap.put("queryRealName", request.getParameter("queryRealName"));
			}
			
			if(!StringUtils.isEmpty(request.getParameter("queryTeacherNo"))) {
				paramMap.put("queryTeacherNo", request.getParameter("queryTeacherNo"));
			}
			
			if(!StringUtils.isEmpty(request.getParameter("queryIdNumber"))) {
				paramMap.put("queryIdNumber", request.getParameter("queryIdNumber"));
			}
			if (!StringUtils.isEmpty(request.getParameter("queryJdfldw"))) {
				paramMap.put("jdfldw", request.getParameter("queryJdfldw"));
			}
			
			// 筛选条件查询
			if(!StringUtils.isEmpty(queryConditionArray)) {
				String[] conditionStr =queryConditionArray.split(",");
				for (int i = 0; i < conditionStr.length; i++) {
					if(StringUtils.isEmpty(conditionStr[i])) 
						continue;
					paramMap.put(conditionStr[i].substring(0, conditionStr[i].indexOf('_')), conditionStr[i].subSequence(conditionStr[i].indexOf('_') + 1, conditionStr[i].length()));
					
					String[] temp = conditionStr[i].split("_");
					if(temp != null && temp.length > 0 && "ageA".equals(temp[0])) {
						if("24".equals(temp[1])) {
							paramMap.put("ageA", "BETWEEN 0 and 24");
						} else if("60".equals(temp[1])) {
							paramMap.put("ageA", "BETWEEN 60 and 200");
						} else {
							paramMap.put("ageA", "BETWEEN "+temp[1]+" and " + ((Integer.valueOf(temp[1]).intValue()) + 4));
						}
						continue;
					}
					
					if(temp != null && temp.length > 0 && "workAge".equals(temp[0])) {
						if("40".equals(temp[1])) {
							paramMap.put("workAge", "BETWEEN 40 and 100");
						}  else {
							
							paramMap.put("workAge", "BETWEEN "+(temp[1].split("-"))[0]+" and " + (temp[1].split("-"))[1]);
						}
						continue;
					}
					
					paramMap.put(temp[0], temp[1]);
					
				}
				
			}
			try {
				String[] conditionStr = checkedData.split(",");
				String[] feildStr = feildsAry.split(",");
				
			    List<String> fialList = null;
			    if(conditionStr.length != 0){
			    	//创建标题头
			    	fialList = Arrays.asList(conditionStr);
			    }
			    
			    // 计算该报表的列数
			    //int number = 2 + fialList.size() * 2;
				
				 String path = request.getRealPath("/")+"template"+File.separator+"download_teacher.xls";
				 
				 FileInputStream io = new FileInputStream(path);
				 
				 // 创建 excel
				 Workbook wb = new HSSFWorkbook(io);
				 //Sheet sheet = wb.createSheet();
				 Sheet sheet = wb.getSheetAt(0);
				 
				// 给工作表列定义列宽  暂定3000
				//for (int i = 0; i < number; i++) {
					//sheet.setColumnWidth(i, 3000);
				//}
				 
				// 创建单元格样式
				HSSFCellStyle cellStyle = (HSSFCellStyle) wb.createCellStyle();
				
				// 指定单元格居中对齐
				cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

				// 指定单元格垂直居中对齐
				cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

				// 指定当单元格内容显示不下时自动换行
				cellStyle.setWrapText(true);

				// 设置单元格字体
				HSSFFont font = (HSSFFont) wb.createFont();
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				font.setFontName("宋体");
				font.setFontHeight((short) 200);
				cellStyle.setFont(font);
				 
				HSSFRow rowHead = (HSSFRow) sheet.createRow(0);
				HSSFCell rowHeadCell = null;
				//获取head表头 进行赋值
				for (int i = 0; i < fialList.size(); i++) {
						rowHeadCell = rowHead.createCell(i);
						rowHeadCell.setCellStyle(cellStyle);
						rowHeadCell.setCellValue(new HSSFRichTextString(fialList.get(i).toString()));
				}
				//数据展示区的单元格赋值
				List<TeacherExportActivity> dataList = teacherManageService.queryTeacherActivetyListNoPage(paramMap);
				log.debug(" start export data . . . ");
				for (int i = 0; i < dataList.size(); i++) {
					Row row = sheet.createRow(i + 1);
					Field[] fields = dataList.get(i).getClass().getDeclaredFields();
					//判断导出字段是否勾选
					for (int j = 0; j < fields.length; j++) {
						fields[j].setAccessible(true);
						  for(int k =0;k<feildStr.length;k++){
							  //当选中的属性字段名称和反射获取的字段名称相同时，给当前对象的属性赋值feildStrList
							  if(fields[j].getName().equals(feildStr[k]) ){
						          String fieldName = fields[j].getName();
								  String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
								  Class<? extends TeacherExportActivity> tCls = dataList.get(i).getClass();
				                  Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
				                  //获取遍历对象的属性
				                  Object value = getMethod.invoke(dataList.get(i), new Object[] {});
				                  Cell cell = row.createCell(k);
				                  cell.setCellValue(value == null ? "" : value.toString());
							  }
						  }  
					}
				}
				log.debug(" export data . . . end ");
			    exportExcelFromTemplet(request, response, wb, "downLoad_teacher");
			    log.debug(" export excel . . . complete ");
				 
			} catch (Exception e) {
				e.printStackTrace();
				log.error("教师信息报表导出错误!!!" + e);
			}
		}
	
	/**
	 * 教师信息综合查询
	 * 
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryTeacherActivetyList.do")
	public @ResponseBody
	Map<String, Object> queryTeacherActivetyList(String queryConditionArray,
			int pageIndex, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> pageInfo = new HashMap<String, Object>();

		try {
			Map<String, Object> paramMap = getCode(request);
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

			if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}

			// 筛选条件查询
			if (!StringUtils.isEmpty(queryConditionArray)) {
				String[] conditionStr = mapper.readValue(queryConditionArray,
						String[].class);
				for (int i = 0; i < conditionStr.length; i++) {
					if (StringUtils.isEmpty(conditionStr[i]))
						continue;
					
					String[] temp = conditionStr[i].split("_");
					if(temp != null && temp.length > 0 && "ageA".equals(temp[0])) {
						if("24".equals(temp[1])) {
							paramMap.put("ageA", "BETWEEN 0 and 24");
						} else if("60".equals(temp[1])) {
							paramMap.put("ageA", "BETWEEN 60 and 200");
						} else {
							paramMap.put("ageA", "BETWEEN "+temp[1]+" and " + ((Integer.valueOf(temp[1]).intValue()) + 4));
						}
						continue;
					}
					
					if(temp != null && temp.length > 0 && "workAge".equals(temp[0])) {
						if("40".equals(temp[1])) {
							paramMap.put("workAge", "BETWEEN 40 and 100");
						}  else {
							
							paramMap.put("workAge", "BETWEEN "+(temp[1].split("-"))[0]+" and " + (temp[1].split("-"))[1]);
						}
						continue;
					}
					
					paramMap.put(temp[0], temp[1]);
					                                                       
//					paramMap.put(conditionStr[i].substring(0, conditionStr[i]
//							.indexOf('_')), conditionStr[i].subSequence(
//							conditionStr[i].indexOf('_') + 1, conditionStr[i]
//									.length()));
					
				}

			}

//			if (!StringUtils.isEmpty(request.getParameter("projectSubject"))) {
//				paramMap.put("projectSubject", request.getParameter("projectSubject"));
//			}

//			if (!StringUtils.isEmpty(request.getParameter("stdutySection"))) {
//				paramMap.put("stdutySection", request.getParameter("stdutySection"));
//			}

			if (!StringUtils.isEmpty(request.getParameter("queryRealName"))) {
				paramMap.put("queryRealName", request.getParameter("queryRealName"));
			}

			if (!StringUtils.isEmpty(request.getParameter("queryTeacherNo"))) {
				paramMap.put("queryTeacherNo", request.getParameter("queryTeacherNo"));
			}

			if (!StringUtils.isEmpty(request.getParameter("queryIdNumber"))) {
				paramMap.put("queryIdNumber", request.getParameter("queryIdNumber"));
			}
			if (!StringUtils.isEmpty(request.getParameter("userStatus"))) {
				paramMap.put("userStatus", request.getParameter("userStatus"));
			}
			if (!StringUtils.isEmpty(request.getParameter("queryJdfldw"))) {
				paramMap.put("jdfldw", request.getParameter("queryJdfldw"));
			}
			
			pageIndex = (pageIndex - 1) * sizePerPage;

			// 2查询分页数据
			PageObject po = teacherManageService.queryTeacherActivetyListPage(paramMap, pageIndex, sizePerPage);
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
				//pageInfo.put("total", 0);
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师信息综合查询错误:" + e);
		}
		return pageInfo;
	}

	/**
	 * 跳转信息变更记录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "teacherInfoChangePage.htm")
	public String teacherInfoChangePage() {
		return "teacher/teacherInfoChangePage";
	}

	/**
	 * 跳转信息变更记录详情页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "changeInfoPage.htm")
	public String teacherChangeInfoPage(String auditId, ModelMap map) {
		map.put("auditId", auditId);
		return "teacher/changeInfoPage";
	}

	/**
	 * 教师信息变更记录
	 * 
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryTeacherChangeList.do")
	public @ResponseBody
	Map<String, Object> queryTeacherAssessList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("teacherId", super.getAccountId(request));

			if (request.getParameter("changeType") != null && request.getParameter("changeType").length() > 0) {
				paramMap.put("changeType", request.getParameter("changeType"));
			}

			if (request.getParameter("auditStatus") != null && request.getParameter("auditStatus").length() > 0) {
				paramMap.put("auditStatus", request.getParameter("auditStatus").split(","));
			}

			if (request.getParameter("auditCreateDate") != null && request.getParameter("auditCreateDate").length() > 0) {
				paramMap.put("auditCreateDate", request.getParameter("auditCreateDate"));
			}

			List<EduAudit> po = teacherManageService.queryTeacherChangeList(paramMap);
			
			if (po != null && po.size() > 0) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po);
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("信息变更查询失败:" + e.getMessage());
		}
		return pageInfo;
	}

	/**
	 * 调动管理页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "toMobilizePage.htm")
	public String toMobilize(ModelMap map, HttpServletRequest request) {
		/*try {
			
			List<String> flag=super.getTransferAuditLevel(request);
			boolean isFlag=false;
			for(int i=0;i<flag.size();i++){
				if(Integer.parseInt(flag.get(i))==super.getRoleId(request).intValue()){
					isFlag=true;
					break;
				}
			}
		
			if (isFlag) {
				map.put("info", 1);
			} else {
				map.put("info", 0);
			}
		} catch (Exception e) {
			map.put("info", 0);
		}*/
		return "teacher/toMobilizePage";
	}

	/**
	 * 返聘管理页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "toReWorkPage.htm")
	public String toReWork(ModelMap map, HttpServletRequest request) {
//		map.put("info", 0);
		return "teacher/toReWorkPage";
	}
	
	/**
	 * 调动管理页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "toMobilizeAddPage.htm")
	public String toMobilizeAdd() {
		return "teacher/toMobilizeAddPage";
	}
	
	/**
	 * 返聘管理页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "toReWorkAddPage.htm")
	public String toReWorkAdd() {
		return "teacher/toReWorkAddPage";
	}

	/**
	 * 离退休管理页面跳转
	 * @return
	 */
	@RequestMapping(value = "toRetireesAddPage.htm")
	public String toRetireesAdd() {
		return "teacher/toRetireesAddPage";
	}
	
	/**
	 * 病休休管理页面跳转
	 * @return
	 */
	@RequestMapping(value = "toSickAddPage.htm")
	public String toSickAdd() {
		return "teacher/toSickAddPage";
	}
	
	/**
	 * 离岗管理页面跳转
	 * @return
	 */
	@RequestMapping(value = "toDimissionAddPage.htm")
	public String toDimissionAdd() {
		return "teacher/toDimissionAddPage";
	}
	
	/**
	 * 教师死亡登记管理页面跳转
	 * @return
	 */
	@RequestMapping(value = "toDeadAddPage.htm")
	public String toDeadAdd() {
		return "teacher/toDeadAddPage";
	}
	
	/**
	 * 待审核教师病休/离岗/离退休/死亡登记列表
	 * 
	 * @author cl
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryRetirees.do")
	public @ResponseBody
	Map<String, Object> queryRetirees(int pageIndex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			Map<String, Object> paramMap = super.getArea(request);
			paramMap.put("roleId", super.getRoleId(request));
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

			if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}

			if (!StringUtils.isEmpty(request.getParameter("realName"))) {
				paramMap.put("realName", request.getParameter("realName"));
			}

			if (!StringUtils.isEmpty(request.getParameter("idNumber"))) {
				paramMap.put("idNumber", request.getParameter("idNumber"));
			}

			if (!StringUtils.isEmpty(request.getParameter("pastProvinceId"))) {
				paramMap.put("pastProvinceId", request.getParameter("pastProvinceId"));
			}

			if (!StringUtils.isEmpty(request.getParameter("pastCityId"))) {
				paramMap.put("pastCityId", request.getParameter("pastCityId"));
			}
			
			if (!StringUtils.isEmpty(request.getParameter("pastDistrictId"))) {
				paramMap.put("pastDistrictId", request.getParameter("pastDistrictId"));
			}
			
			if (!StringUtils.isEmpty(request.getParameter("pastSchoolId"))) {
				paramMap.put("pastSchoolId", request.getParameter("pastSchoolId"));
			}
			
			if(!StringUtils.isEmpty(request.getParameter("auditStatus"))){
				paramMap.put("auditStatusStr", request.getParameter("auditStatus").split(","));
			}

			if(!StringUtils.isEmpty(request.getParameter("changeType")) ) {
				if("9".equals((String)request.getParameter("changeType"))) {
					paramMap.put("changeTypeRetiees", project.common.Common.CHANGE_TYPE_40);
				} else {
					paramMap.put("changeType", request.getParameter("changeType"));
				}
			}
			
			//是否允许同级审核
			int roleAudit=super.getTeacherInfoChangeAudit(request);
			if(roleAudit==1){
				paramMap.put("roleAuditY", "1");
			}else{
				paramMap.put("roleAuditN", "0");
			}

			pageIndex = (pageIndex - 1) * sizePerPage;

			PageObject po = teacherManageService.queryMobilizeList(paramMap, pageIndex, sizePerPage);
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
			pageInfo.put("success", false);
			e.printStackTrace();
			log.error("调动管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	/**
	 * 调动管理已发起调动/返聘管理已发起返聘（列表）
	 * 
	 * @author cl
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryMobilize.do")
	public @ResponseBody
	Map<String, Object> queryMobilize(int pageIndex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			Map<String, Object> paramMap = super.getArea(request);
			paramMap.put("roleId", super.getRoleId(request));
			
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

			if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}

			if (!StringUtils.isEmpty(request.getParameter("realName"))) {
				paramMap.put("realName", request.getParameter("realName"));
			}

			if (!StringUtils.isEmpty(request.getParameter("idNumber"))) {
				paramMap.put("idNumber", request.getParameter("idNumber"));
			}

			if (!StringUtils.isEmpty(request.getParameter("pastProvinceId"))) {
				paramMap.put("pastProvinceId", request.getParameter("pastProvinceId"));
			}

			if (!StringUtils.isEmpty(request.getParameter("pastCityId"))) {
				paramMap.put("pastCityId", request.getParameter("pastCityId"));
			}
			if (!StringUtils.isEmpty(request.getParameter("pastDistrictId"))) {
				paramMap.put("pastDistrictId", request.getParameter("pastDistrictId"));
			}
			if (!StringUtils.isEmpty(request.getParameter("pastSchoolId"))) {
				paramMap.put("pastSchoolId", request.getParameter("pastSchoolId"));
			}
			if(!StringUtils.isEmpty(request.getParameter("auditStatus"))){
				paramMap.put("auditStatusStr", request.getParameter("auditStatus").split(","));
			}

			if(!StringUtils.isEmpty(request.getParameter("changeType")) && "40".equals((String)request.getParameter("changeType"))) {
				paramMap.put("changeType", project.common.Common.CHANGE_TYPE_40);
			} else {
				paramMap.put("changeType", project.common.Common.CHANGE_TYPE_2);
			}
			
			//是否允许同级审核
			int roleAudit=super.getTeacherInfoChangeAudit(request);
			if(roleAudit==1){
				paramMap.put("roleAuditY", "1");
			}else{
				paramMap.put("roleAuditN", "0");
			}

			pageIndex = (pageIndex - 1) * sizePerPage;

			PageObject po = teacherManageService.queryMobilizeList(paramMap, pageIndex, sizePerPage);
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
			pageInfo.put("success", false);
			e.printStackTrace();
			log.error("调动管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}

	/**
	 * 调动管理详情页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "toMobilizeInfo.htm")
	public String toMobilizeInfo(ModelMap map, HttpServletRequest request) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("teacherId", request.getParameter("teacherId"));
			paramMap.put("oldVersion", request.getParameter("oldVersion"));
			paramMap.put("newVersion", request.getParameter("newVersion"));
			map.put("click", request.getParameter("click"));
			map.put("info", teacherManageService.queryMobilizeInfo(paramMap));
			map.put("audit",teacherManageService.queryMobilizeAuditInfo(Integer.parseInt(request.getParameter("id"))));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("调动详情查询失败:" + e.getMessage());
		}
		return "teacher/toMobilizeInfoPage";
	}
	
	/**
	 * 我的调动记录详情页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "toTeacherMobilizeInfo.htm")
	public String toTeacherMobilizeInfo(ModelMap map, HttpServletRequest request) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("teacherId", request.getParameter("teacherId"));
			paramMap.put("oldVersion", request.getParameter("oldVersion"));
			paramMap.put("newVersion", request.getParameter("newVersion"));
			map.put("info", teacherManageService.queryMobilizeInfo(paramMap));
			map.put("audit",teacherManageService.queryMobilizeAuditInfo(Integer.parseInt(request.getParameter("id"))));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("我的调动记录情查询失败:" + e.getMessage());
		}
		return "teacher/toTeacherMobilizeInfoPage";
	}

	/**
	 * 查询审核说明
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryAuditInfo.do")
	public @ResponseBody
	Map<String, Object> queryAuditInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			
			EduTeacherMobilize audti = teacherManageService.queryMobilizeAuditInfo(Integer.parseInt(request.getParameter("id")));

			if (audti != null) {
				pageInfo.put("success", true);
				pageInfo.put("auditInfo", audti);
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			pageInfo.put("success", false);
			e.printStackTrace();
			log.error("查询审核说明失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	/**
	 * 调动管理 新建记录（列表）
	 * 
	 * @author cl
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryCreateMobilize.do")
	public @ResponseBody
	Map<String, Object> queryCreateMobilize(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			Map<String, Object> paramMap = super.getArea(request);

			if (!StringUtils.isEmpty(request.getParameter("realName"))) {
				paramMap.put("realName", request.getParameter("realName"));
			}

			if (!StringUtils.isEmpty(request.getParameter("idNumber"))) {
				paramMap.put("idNumber", request.getParameter("idNumber"));
			}
			
			if (!StringUtils.isEmpty(request.getParameter("retiress"))) {
				paramMap.put("retiress", request.getParameter("retiress"));
			}
			
			List<EduTeacherMobilize> po = teacherManageService.queryCreateMobilizeList(paramMap);
			if (po != null) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po);
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			pageInfo.put("success", false);
			e.printStackTrace();
			log.error("新建调动列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}

	/**
	 * 调动管理 新建记录
	 * 
	 * @author cl
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/setCreateMobilize.do")
	public @ResponseBody
	Map<String, Object> setCreateMobilize(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			EduTeacherMobilize pojo = new EduTeacherMobilize();
			pojo.setAuditCreateBy(super.getAccount(request));
			pojo.setTeacherId(Integer.parseInt(request
					.getParameter("teacherId")));

			// 旧版本地址
			if (request.getParameter("pastProvinceId") != null
					&& request.getParameter("pastProvinceId").length() > 0) {
				pojo.setPastProvinceId(Integer.parseInt(request
						.getParameter("pastProvinceId")));
				pojo.setPastProvinceName(request
						.getParameter("pastPovinceName"));
			}

			if (request.getParameter("flag") != null && request.getParameter("flag").length() > 0) {
				pojo.setFlag(request.getParameter("flag"));
			}
			
			if (request.getParameter("pastCityId") != null
					&& request.getParameter("pastCityId").length() > 0) {
				pojo.setPastCityId(Integer.parseInt(request
						.getParameter("pastCityId")));
				pojo.setPastCityName(request.getParameter("pastCityName"));
			}

			if (request.getParameter("pastDistrictId") != null
					&& request.getParameter("pastDistrictId").length() > 0) {
				pojo.setPastDistrictId(Integer.parseInt(request
						.getParameter("pastDistrictId")));
				pojo.setPastDistrictName(request
						.getParameter("pastDistrictName"));
			}

			if (request.getParameter("pastSchoolId") != null
					&& request.getParameter("pastSchoolId").length() > 0) {
				pojo.setPastSchoolId(Integer.parseInt(request
						.getParameter("pastSchoolId")));
				pojo.setPastSchoolName(request.getParameter("pastSchoolName"));
			}

			// 新版本地址
			if (request.getParameter("newProvinceId") != null
					&& request.getParameter("newProvinceId").length() > 0) {
				pojo.setNewProvinceId(Integer.parseInt(request
						.getParameter("newProvinceId")));
				pojo.setNewProvinceName(request.getParameter("newProvinceName"));
			}

			if (request.getParameter("newCityId") != null
					&& request.getParameter("newCityId").length() > 0) {
				pojo.setNewCityId(Integer.parseInt(request
						.getParameter("newCityId")));
				pojo.setNewCityName(request.getParameter("newCityName"));
			}

			if (request.getParameter("newDistrictId") != null
					&& request.getParameter("newDistrictId").length() > 0) {
				pojo.setNewDistrictId(Integer.parseInt(request
						.getParameter("newDistrictId")));
				pojo
						.setNewDistrictName(request
								.getParameter("newDistrictName"));
			}

			if (request.getParameter("newSchoolId") != null
					&& request.getParameter("newSchoolId").length() > 0) {
				pojo.setNewSchoolId(Integer.parseInt(request
						.getParameter("newSchoolId")));
				pojo.setNewSchoolName(request.getParameter("newSchoolName"));
			}

			// (评)教师职称
			if (request.getParameter("jobCommentPositionType") != null
					&& request.getParameter("jobCommentPositionType").length() > 0) {
				pojo.setJobCommentPosition(request
						.getParameter("jobCommentPosition"));
				pojo.setJobCommentPositionType(Integer.parseInt(request
						.getParameter("jobCommentPositionType")));
			}

			// 聘)教师职称
			if (request.getParameter("jobRecruitmentPositionType") != null
					&& request.getParameter("jobRecruitmentPositionType").length() > 0) {
				pojo.setJobRecruitmentPosition(request
						.getParameter("jobRecruitmentPosition"));
				pojo.setJobRecruitmentPositionType(Integer.parseInt(request
						.getParameter("jobRecruitmentPositionType")));
			}

			// 学校行政职务
			if (request.getParameter("jobSchoolAdministrationOfficeType") != null
					&& request.getParameter("jobSchoolAdministrationOfficeType").length() > 0) {
				pojo.setJobSchoolAdministrationOffice(request
						.getParameter("jobSchoolAdministrationOffice"));
				pojo
						.setJobSchoolAdministrationOfficeType(Integer
								.parseInt(request
										.getParameter("jobSchoolAdministrationOfficeType")));
			}
			
			// 当前任教学段
			pojo.setJobFormerTeachingSectionType(request.getParameter("jobFormerTeachingSectionType"));
			pojo.setJobFormerTeachingSection(request.getParameter("jobFormerTeachingSection"));

			// 当前任教学科
			pojo.setJobFormerTeachingSubject(request
					.getParameter("jobFormerTeachingSubject"));
			pojo.setJobFormerTeachingSubjectType(request
					.getParameter("jobFormerTeachingSubjectType"));

			// 是否骨干教师
			if(request.getParameter("jobCoreTeacherType") != null
					&& request.getParameter("jobCoreTeacherType").length() > 0){
				pojo.setJobCoreTeacherType(Integer.parseInt(request.getParameter("jobCoreTeacherType")));
				pojo.setJobCoreTeacher(request.getParameter("jobCoreTeacher"));
			}

			// 是否班主任
			pojo
					.setJobWhetherTeacher(request
							.getParameter("jobWhetherTeacher"));

			// 国培计划农村骨干教师
			pojo.setJobCountyRuralTeacher(request
					.getParameter("jobCountyRuralTeacher"));

			// 调动说明
			pojo.setMobilizeMark(request.getParameter("mobilizeMark"));

			//List<String> flag=super.getTransferAuditLevel(request);
			boolean isFlag=false;
//			for(int i=0;i<flag.size();i++){
//				if(Integer.parseInt(flag.get(i))==0){
//					isFlag=true;
//					break;
//				}
//			}
			if (isFlag) {
				teacherManageService.createMobilizeForNoAudit(pojo);
			} else {
				teacherManageService.createMobilizeForAudit(pojo);
			}

			pageInfo.put("success", true);

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage() == "-1") {
				pageInfo.put("flag", "-1");
				log.error("新建调动错误：该人员存在未审核的个人变更记录,teacher_id:"
						+ request.getParameter("teacherId"));
			} else if (e.getMessage() == "-2") {
				pageInfo.put("flag", "-2");
				log.error("新建调动错误：该人员存在未审核的个人调动记录,teacher_id:"
						+ request.getParameter("teacherId"));
			} else if (e.getMessage() == "-3") {
				pageInfo.put("flag", "-3");
				log.error("新建调动错误：该人员存在未审核的个人离退操作记录,teacher_id:"
						+ request.getParameter("teacherId"));
			} else {
				pageInfo.put("flag", "-0");
				log.error("新建调动错误：teacher_id:"
						+ request.getParameter("teacherId") + "___"
						+ e.getMessage());
			}

			pageInfo.put("success", false);
		}
		return pageInfo;
	}
	
	/**
	 * 调动审核/教师返聘页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "toMobilizeAudit.htm")
	public String toMobilizeAudit(ModelMap map, HttpServletRequest request, String click) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("teacherId", request.getParameter("teacherId"));
			paramMap.put("oldVersion", request.getParameter("oldVersion"));
			paramMap.put("newVersion", request.getParameter("newVersion"));
			map.put("info", teacherManageService.queryMobilizeInfo(paramMap));
			map.put("click", click);
			map.put("audit",teacherManageService.queryMobilizeAuditInfo(Integer.parseInt(request.getParameter("id"))));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("调动审核查询失败:" + e.getMessage());
		}
		return "teacher/toMobilizeAuditPage";
	}
	
	
	/**
	 * 调动/返聘审核
	 * 
	 * @author cl
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/setAuditMobilize.do")
	public @ResponseBody
	Map<String, Object> setAuditMobilize(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			EduTeacherMobilize pojo = new EduTeacherMobilize();
			
			if(request.getParameter("id")==null || request.getParameter("id").length()<=0 || request.getParameter("teacherId")==null || request.getParameter("teacherId").length()<=0){
				throw new Exception("-1");
			}
			
			pojo.setAuditCreateBy(super.getAccount(request));
			pojo.setTeacherId(Integer.parseInt(request.getParameter("teacherId")));
			pojo.setAuditOption(request.getParameter("auditOption"));
			pojo.setAuditId(Integer.parseInt(request.getParameter("id")));
			
			if(request.getParameter("flag")==null || request.getParameter("flag").length()<=0){
				throw new Exception("-2");
			}
			int flag=Integer.parseInt(request.getParameter("flag"));//是否审核通过标识

			//通过
			if (flag == 1) {
				
				// 新版本地址
				if (request.getParameter("newProvinceId") != null && request.getParameter("newProvinceId").length() > 0) {
					pojo.setNewProvinceId(Integer.parseInt(request.getParameter("newProvinceId")));
					pojo.setNewProvinceName(request.getParameter("newProvinceName"));
				}

				if (request.getParameter("newCityId") != null && request.getParameter("newCityId").length() > 0) {
					pojo.setNewCityId(Integer.parseInt(request.getParameter("newCityId")));
					pojo.setNewCityName(request.getParameter("newCityName"));
				}

				if (request.getParameter("newDistrictId") != null && request.getParameter("newDistrictId").length() > 0) {
					pojo.setNewDistrictId(Integer.parseInt(request.getParameter("newDistrictId")));
					pojo.setNewDistrictName(request.getParameter("newDistrictName"));
				}

				if (request.getParameter("newSchoolId") != null && request.getParameter("newSchoolId").length() > 0) {
					pojo.setNewSchoolId(Integer.parseInt(request.getParameter("newSchoolId")));
					pojo.setNewSchoolName(request.getParameter("newSchoolName"));
				}
				
				teacherManageService.modifyMobilizeInfo(pojo);
			} else if(flag == 0) {
				teacherManageService.modifyMobilizeInfoNo(pojo);
			}else{
				throw new Exception("-2");
			}

			pageInfo.put("success", true);

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage() == "-1") {
				pageInfo.put("flag", "-1");
				log.error("审核调动错误：关键信息存在空值,teacher_id:"+ request.getParameter("teacherId")+"----id:"+request.getParameter("id"));
			} else if (e.getMessage() == "-2") {
				pageInfo.put("flag", "-2");
				log.error("审核调动错误：审核是否通过标识错误,flag:"
						+ request.getParameter("flag"));
			}else {
				pageInfo.put("flag", "-0");
				log.error("审核调动错误：teacher_id:"
						+ request.getParameter("teacherId") + "___"
						+ e.getMessage());
			}

			pageInfo.put("success", false);
		}
		return pageInfo;
	}
	
	/**
	 * 调动审核页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "toMobilizeAuditListPage.htm")
	public String toMobilizeAuditListAdd() {
		return "teacher/toMobilizeAuditListPage";
	}
	
	/**
	 * 转向教师病休审核页面 
	 */
	@RequestMapping(value = "toSickAuditListPage.htm")
	public String toSickAuditListAdd() {
		return "teacher/toSickAuditListPage";
	}
	
	/**
	 * 转向教师离岗审核页面 
	 */
	@RequestMapping(value = "toDimissionAuditListPage.htm")
	public String toDimissionAuditListAdd() {
		return "teacher/toDimissionAuditListPage";
	}
	
	/**
	 * 转向教师死亡登记审核页面 
	 */
	@RequestMapping(value = "toDeadAuditListPage.htm")
	public String toDeadAuditListAdd() {
		return "teacher/toDeadAuditListPage";
	}
	
	/**
	 * 转向教师离退休审核页面 
	 */
	@RequestMapping(value = "toRetireesAuditListPage.htm")
	public String toRetireesAuditListAdd() {
		return "teacher/toRetireesAuditListPage";
	}
	
	/**
	 * 转向教师返聘审核页面 
	 */
	@RequestMapping(value = "toReworkAuditListPage.htm")
	public String toReworkAuditListAdd() {
		return "teacher/toReworkAuditListPage";
	}
	
	/**
	 * 编制调整页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "toAdjustPage.htm")
	public String toAdjust(ModelMap map, HttpServletRequest request) {
		return "teacher/toAdjustPage";
	}

	/**
	 * 新增编制调整页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "toAdjustAddPage.htm")
	public String toAdjustAdd() {
		return "teacher/toAdjustAddPage";
	}
	
	/**
	 * 已发起编制调整（列表）
	 * 
	 * @author cl
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryAdjust.do")
	public @ResponseBody
	Map<String, Object> queryAdjust(int pageIndex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			Map<String, Object> paramMap = super.getArea(request);
			paramMap.put("roleId", super.getRoleId(request));
			
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

			if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}

			if (!StringUtils.isEmpty(request.getParameter("realName"))) {
				paramMap.put("realName", request.getParameter("realName"));
			}

			if (!StringUtils.isEmpty(request.getParameter("idNumber"))) {
				paramMap.put("idNumber", request.getParameter("idNumber"));
			}

			if (!StringUtils.isEmpty(request.getParameter("adjustId"))) {
				paramMap.put("adjustId", request.getParameter("adjustId"));
			}

			if(!StringUtils.isEmpty(request.getParameter("auditStatus"))){
				paramMap.put("auditStatusStr", request.getParameter("auditStatus").split(","));
			}
			
			//是否允许同级审核
			int roleAudit=super.getTeacherInfoChangeAudit(request);
			if(roleAudit==1){
				paramMap.put("roleAuditY", "1");
			}else{
				paramMap.put("roleAuditN", "0");
			}

			pageIndex = (pageIndex - 1) * sizePerPage;

			PageObject po = teacherManageService.queryAdjustList(paramMap, pageIndex, sizePerPage);
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
			pageInfo.put("success", false);
			e.printStackTrace();
			log.error("调动管理列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	/**
	 * 编制调整管理 新建记录
	 * 
	 * @author cl
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/setCreateAdjust.do")
	public @ResponseBody
	Map<String, Object> setCreateAdjust(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			EduTeacherAdjust pojo = new EduTeacherAdjust();
			pojo.setAuditCreateBy(super.getAccount(request));
			pojo.setTeacherId(Integer.parseInt(request.getParameter("teacherId")));
			if (request.getParameter("adjustId") != null && request.getParameter("adjustId").length() > 0) {
				pojo.setNewAdjustId(Integer.parseInt(request.getParameter("adjustId")));
				pojo.setNewAdjustName(request.getParameter("adjustName"));
			}

			// 编制调整说明
			pojo.setMobilizeMark(request.getParameter("mobilizeMark"));

			//是否需要审核（暂时与调动相同）
			//List<String> flag=super.getTransferAuditLevel(request);
			boolean isFlag=false;
//			for(int i=0;i<flag.size();i++){
//				if(Integer.parseInt(flag.get(i))==0){
//					isFlag=true;
//					break;
//				}
//			}
			if (isFlag) {
				teacherManageService.createAdjustForNoAudit(pojo);
			} else {
				teacherManageService.createAdjustForAudit(pojo);
			}

			pageInfo.put("success", true);

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage() == "-1") {
				pageInfo.put("flag", "-1");
				log.error("新建编制调整错误：该人员存在未审核的个人变更记录,teacher_id:"
						+ request.getParameter("teacherId"));
			} else if (e.getMessage() == "-2") {
				pageInfo.put("flag", "-2");
				log.error("新建编制调整错误：该人员存在未审核的个人调动记录,teacher_id:"
						+ request.getParameter("teacherId"));
			} else if (e.getMessage() == "-3") {
				pageInfo.put("flag", "-3");
				log.error("新建编制调整错误：该人员存在未审核的个人离退操作记录,teacher_id:"
						+ request.getParameter("teacherId"));
			}else if (e.getMessage() == "-03") {
				pageInfo.put("flag", "-03");
				log.error("新建编制调整错误：该人员存在未审核的个人编制调整操作记录,teacher_id:"
						+ request.getParameter("teacherId"));
			}  else {
				pageInfo.put("flag", "-0");
				log.error("新建编制调整错误：teacher_id:"
						+ request.getParameter("teacherId") + "___"
						+ e.getMessage());
			}

			pageInfo.put("success", false);
		}
		return pageInfo;
	}


	/**
	 * 编制调整审核页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "toAdjustAuditListPage.htm")
	public String toAdjustAuditListAdd() {
		return "teacher/toAdjustAuditListPage";
	}
	
	/**
	 * 编制调整审核
	 * 
	 * @author cl
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/setAuditAdjust.do")
	public @ResponseBody
	Map<String, Object> setAuditAdjust(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			EduTeacherAdjust pojo = new EduTeacherAdjust();
			
			if(request.getParameter("id")==null || request.getParameter("id").length()<=0 || request.getParameter("teacherId")==null || request.getParameter("teacherId").length()<=0){
				throw new Exception("-1");
			}
			
			pojo.setAuditCreateBy(super.getAccount(request));
			pojo.setTeacherId(Integer.parseInt(request.getParameter("teacherId")));
			pojo.setAuditOption(request.getParameter("auditOption"));
			pojo.setAuditId(Integer.parseInt(request.getParameter("id")));
			
			if(request.getParameter("flag")==null || request.getParameter("flag").length()<=0){
				throw new Exception("-2");
			}
			int flag=Integer.parseInt(request.getParameter("flag"));//是否审核通过标识

			//通过
			if (flag == 1) {
				teacherManageService.modifyAdjustInfo(pojo);
			} else if(flag == 0) {
				teacherManageService.modifyAdjustInfoNo(pojo);
			}else{
				throw new Exception("-2");
			}

			pageInfo.put("success", true);

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage() == "-1") {
				pageInfo.put("flag", "-1");
				log.error("编制调整审核错误：关键信息存在空值,teacher_id:"+ request.getParameter("teacherId")+"----id:"+request.getParameter("id"));
			} else if (e.getMessage() == "-2") {
				pageInfo.put("flag", "-2");
				log.error("编制调整审核错误：审核是否通过标识错误,flag:"
						+ request.getParameter("flag"));
			}else {
				pageInfo.put("flag", "-0");
				log.error("编制调整审核错误：teacher_id:"
						+ request.getParameter("teacherId") + "___"
						+ e.getMessage());
			}

			pageInfo.put("success", false);
		}
		return pageInfo;
	}
	
	/**
	 * 我的调动记录页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "teacherMobilizeList.htm")
	public String toTeacherMobilize() {
		return "teacher/toTeacherMobilizePage";
	}
	
	/**
	 * 我的调动记录（列表）
	 * 
	 * @author cl
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryTeacherMobilize.do")
	public @ResponseBody
	Map<String, Object> queryTeacherMobilize(int pageIndex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

			if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}

			if (!StringUtils.isEmpty(request.getParameter("startDate"))) {
				paramMap.put("startDate", request.getParameter("startDate"));
			}

			if (!StringUtils.isEmpty(request.getParameter("endDate"))) {
				paramMap.put("endDate", request.getParameter("endDate"));
			}

			if(!StringUtils.isEmpty(request.getParameter("auditStautsStr"))){
				paramMap.put("auditStautsStr", request.getParameter("auditStautsStr").split(","));
			}

			paramMap.put("teacherId", super.getAccountId(request));

			pageIndex = (pageIndex - 1) * sizePerPage;

			PageObject po = teacherManageService.queryTeacherMobilizeList(paramMap, pageIndex, sizePerPage);
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
			pageInfo.put("success", false);
			e.printStackTrace();
			log.error("我的调动记录列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	
	/**
	 * 教师信息统计——按地区统计（11、12、13） 
	 * @return
	 */
	@RequestMapping(value = "teacherRegionStatsPage.htm")
	public String teacherRegionStat() {
		return "teacher/teacherRegionStatsPage";
	}
	
	/**
	 * 教师信息统计——按学段统计（21、22、23、24）
	 * @return
	 */
	@RequestMapping(value = "teacherSemesterStatsPage.htm")
	public String teacherSemesterStats() {
		return "teacher/teacherSemesterStatsPage";
	}
	

}
