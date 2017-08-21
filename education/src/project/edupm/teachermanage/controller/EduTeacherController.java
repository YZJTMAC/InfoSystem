package project.edupm.teachermanage.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.common.Common;
import project.dictionary.service.IDictionaryService;
import project.edupm.projectmanage.service.IEduProjectService;
import project.edupm.teachermanage.dto.EduTeacherImportDTO;
import project.edupm.teachermanage.pojo.TeacherProScorePOJO;
import project.edupm.teachermanage.service.IEduTeacherServiceIF;
import project.person.pojo.EduUserActivty;
import project.system.pojo.SysDictionary;
import project.system.service.ISysService;
import project.teacher.teachermanage.service.ITeacherManageService;
import project.util.ApplicationProperties;
import project.util.DataUtil;
import framelib.controller.AbsController;
import framelib.utils.page.PageObject;

/**
 * Title: TeacherController
 * Description: 教师管理controller
 * 
 * @Create_by: zhangxiaoqi
 * @Create_date:2014-04-01
 * @Last_Edit_By:	
 * @Edit_Description
 * @version: 1.0
 */
@SuppressWarnings("deprecation")
@Controller
@RequestMapping("/edupm/teachermanage")
public class EduTeacherController  extends AbsController {
	
	private static final Logger log = Logger.getLogger(EduTeacherController.class);
	
	@Autowired
	@Qualifier("eduTeacherService")
	IEduTeacherServiceIF teacherService;
	
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
	@Qualifier("dictionaryService")
	IDictionaryService dictionaryService;
	
	/**
	 * 跳转到: 培训成绩导入列表
	 * @return
	 */
	@RequestMapping("toTeacherProScoreListPage.htm")
	public String toTeacherProScoreListPage(){
		return "teacher/teacherProScoreList";
	}
	
	
	/**
	 * 跳转到: 管理员查询教师成绩详情列表
	 * @return
	 */
	@RequestMapping("toTeacherProScoreInfoPage.htm")
	public String toTeacherProScoreInfoPage(){
		return "teacher/teacherProScoreInfo";
	}
	
	
	/**
	 * 跳转到: 管理员导入教师成绩页面
	 * @return
	 */
	@RequestMapping("toImportTeacherScorePage.htm")
	public String toImportTeacherScorePage(){
		return "teacher/importTeacherScore";
	}
	
	
	/**
	 * 跳转到查看导入成绩页面
	 * @return
	 */
	@RequestMapping("toImportScoreInfoPage.htm")
	public String toImportScoreInfoPage(){
		return "teacher/importScoreInfo";
	}
	
	
	/**
	 * 查看导入成绩
	 * @param projectId
	 * @return
	 */
	@RequestMapping("queryImportScoreInfo.do")
	public @ResponseBody Map<String, Object> queryImportScoreInfo(int projectId){
		
		log.info("查看导入成绩");
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<TeacherProScorePOJO> list = teacherService.queryImportScoreInfo(projectId);
			if(list!=null && list.size()>0){
				result.put("success", true);
				result.put("obj", list);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("查看导入成绩失败!"+e.getMessage());
		}
		return result;
	}
	
	/**
	 * 培训成绩导入 导出某一项目下教师信息模板
	 * @param request
	 * @param path
	 */
	@RequestMapping("downTeachersScoreTemplate.do")
	public void downTeachersScoreTemplate(HttpServletRequest request,HttpServletResponse response){
		try {
			List<Map<String, Object>> list = teacherService.queryTeacherByProId(Integer.parseInt(request.getParameter("projectId")));
			String path = request.getRealPath("/") + "template" + File.separator + "upload_score.xls";

			FileInputStream io = new FileInputStream(path);
			// 创建 excel
			Workbook wb = new HSSFWorkbook(io);

			Sheet sheet = wb.getSheetAt(0);
			for (int i = 0; i < list.size(); i++) {
				Row row = sheet.createRow(i + 1);
				Cell cellA = row.createCell(0);
				cellA.setCellValue(list.get(i).get("realName").toString());

				Cell cellB = row.createCell(1);
				cellB.setCellValue(list.get(i).get("idNumber").toString());
		}
			exportExcelFromTemplet(request, response, wb,"upload_score","xls");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("管理员管理查询导出错误:" + e);
		}
	}
	
	/**
	 * 管理员: 提交教师成绩
	 * @param request
	 * @param path
	 * @return
	 */
	@RequestMapping("importTeachersScore.do")
	public @ResponseBody Map<String,Object> importTeachersScore(HttpServletRequest request,String path){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			paramMap.put("projectId", request.getParameter("projectId"));
			//paramMap.put("roleId", super.getRoleId(request));
//			path = ApplicationProperties.getPropertyValue("upload_path")+path.replace("/", File.separator);
			
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			path = projectPath + ApplicationProperties.getPropertyValue("upload_file_path")+path.replace("/", File.separator);
			result  = sysService.intoDB(path, "uploadScore_admin", super.getAccount(request), paramMap);
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
		Map<String, Object> result = new HashMap<String,Object>();
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("projectId", projectId);
		//paramMap.put("roleId", super.getRoleId(request));
		
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		try {
			result = sysService.parseExcel(projectPath + path, "uploadScore", paramMap);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			log.error("检测数据失败"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 管理员: 查询教师成绩详情列表前判断教师是否已有成绩
	 * @param pageIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("teacherProScoreInfo.do")
	public @ResponseBody Map<String, Object> queryCountTeacherScore(int pageIndex, HttpServletRequest request){
		log.info("查询此项目下参训教师是否已有成绩");
		
		String loginName = super.getAccount(request);
		Map<String, Object> result = new HashMap<String, Object>();
		
		// 查询此项目下参训教师是否已有成绩
		int count;
		try {
			count = teacherService.queryCountTeacherScore(request.getParameter("projectId"));
			if(count > 0){
				result = teacherProScoreInfo(pageIndex, request);
			} else {
				result.put("scoreCount", "0");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			e.printStackTrace();
			log.error("管理员loginName:" + loginName +"查询教师成绩列表页面失败!" + e.getMessage());
		}
		
		return result;
	}
	

	/**
	 * 管理员: 查询教师成绩详情列表
	 * @param pageIndex
	 * @param request
	 * @return
	 */
	public @ResponseBody Map<String, Object> teacherProScoreInfo(int pageIndex, HttpServletRequest request){
		log.info("管理员: 查询教师成绩详情列表");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String loginName = super.getAccount(request);
		String teacherName = request.getParameter("teacherName");
		String idNumber = request.getParameter("idNumber");
		String subject = request.getParameter("subject");
		String provinceId = request.getParameter("provinceId");
		String cityId = request.getParameter("cityId");
		String districtId = request.getParameter("districtId");
		String schoolId = request.getParameter("schoolId");
		paramMap.put("projectId", request.getParameter("projectId"));
		paramMap.put("teacherName", teacherName== null? null:teacherName.equals("")?null:teacherName);
		paramMap.put("idNumber", idNumber== null? null:idNumber.equals("")?null:idNumber);
		paramMap.put("provinceId", provinceId== null? null:provinceId.equals("")?null:provinceId);
		paramMap.put("cityId", cityId== null? null:cityId.equals("")?null:cityId);
		paramMap.put("districtId", districtId== null? null:districtId.equals("")?null:districtId);
		paramMap.put("schoolId", schoolId== null? null:schoolId.equals("")?null:schoolId);
		paramMap.put("teachingSubject", subject== null? null:subject.equals("")?null:subject);

		Map<String, Object> result = new HashMap<String, Object>();
		pageIndex = (pageIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			
			PageObject po = teacherService.selectTeacherProScoreInfo(paramMap, pageIndex, Common.PNN_USER_PAGE_LIMIT);
			if(po != null && po.getCount() > 0) {
				result.put("success", true);
				result.put("total",po.getCount());
				result.put("rows",po.getObjects());
				result.put("pageSize", po.getPagesize());
				result.put("pages", po.getPages());
				result.put("currentPage", po.getCurrentPage());
				result.put("pageNumbers", po.getPageNumbers());
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("管理员loginName:" + loginName +"查询教师成绩列表页面失败!" + e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * 培训成绩导入查询项目列表
	 * @param pageIndex
	 * @param request
	 * @return
	 */
	@RequestMapping("teacherProScoreList.do")
	public @ResponseBody Map<String, Object> teacherProScoreList(int startIndex,int pageSize,String status, HttpServletRequest request){
		log.info("查询成绩导入项目列表");

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
		conditions.put("start", start==null||start==""?null:start);
		conditions.put("end", end==null||end==""?null:end);
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
		try {
			PageObject po = teacherService.selectTeacherProScoreList(conditions, startIndex, pageSize);
			String areaId = super.getUserAreaId(request);
			Integer orgId = super.getOrganizationId(request);
			if(po != null && po.getCount() > 0) {
				result.put("success", true);
				result.put("areaId", areaId);
				result.put("orgId", orgId);
				result.put("total",po.getCount());
				result.put("rows",po.getObjects());
				result.put("pageSize", po.getPagesize());
				result.put("pages", po.getPages());
				result.put("currentPage", po.getCurrentPage());
				result.put("pageNumbers", po.getPageNumbers());
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
			log.error("管理员loginName:"  +"查询教师成绩列表页面失败!" + e.getMessage());
		}
		return result;
	}
	
	/**
	 * 管理员: 导出教师信息模板，为学科学段政治面貌赋上默认值（从数据字典中查询）
	 * @param request
	 * @param path
	 */
	@RequestMapping("downTeachersTemplate.do")
	public void downTeachersTemplate(HttpServletRequest request,
			HttpServletResponse response) {

		// 查找数据字典中学段
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//paramMap.put("stduty_section", "stduty_section");//学段
		//paramMap.put("project_subject", "project_subject");//学科
		//paramMap.put("political_status", "political_status");//政治面貌
		paramMap.put("status", 1);//启用状态
		try {
			// 查找数据字典中学段
			PageObject po = dictionaryService.querySysDictionary(paramMap);
			List<SysDictionary> sysDictionaryList = (List<SysDictionary>) po.getObjects();
			String path = request.getRealPath("/") + "template"
					+ File.separator + "import_teacher.xls";

			FileInputStream io = new FileInputStream(path);
			// 创建 excel
			Workbook wb = new HSSFWorkbook(io);
			Sheet sheet = wb.getSheetAt(2);
			Row titleRow = sheet.getRow(0);
			//置空列
			for(int i=1; i<titleRow.getLastCellNum(); i++) {
				if(i==DataUtil.getIndex("身份证件类型", titleRow)
						|| i==DataUtil.getIndex("民族", titleRow) 
						|| i==DataUtil.getIndex("五险一金", titleRow)
						|| i==DataUtil.getIndex("专业技术职务", titleRow)
						|| i==DataUtil.getIndex("近三年专任教师接受培训情况", titleRow)
						|| i==DataUtil.getIndex("荣誉称号", titleRow)) {
						continue;
				}
				DataUtil.setColumEmpty(sheet, i,1);
				
			}			
//	        DataUtil.setColumEmpty(sheet, 14,1);//学段
//	        DataUtil.setColumEmpty(sheet, 15,1);//学科
//	        DataUtil.setColumEmpty(sheet, 4,1);//政治面貌
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			for(SysDictionary dic:sysDictionaryList) {
				map.put(dic.getDictionaryType(), 0);
			}
	        
		
			for (SysDictionary dic:sysDictionaryList) {
				
				// 查找数据字典中学段，为教师模板学段赋值
				if (dic.getDictionaryType().equals("stduty_section")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("主要任课学段", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("主要任课学段", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					//m += 1;
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				// 查找数据字典中学科，为教师模板学科赋值
				if (dic.getDictionaryType().equals("project_subject")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("任教课程", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("任教课程", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				// 查找数据字典中学科，为教师模板政治面貌赋值
				if (dic.getDictionaryType().equals("political_status")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("政治面貌", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("政治面貌", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				// 身份证件类型
//				if (dic.getDictionaryType().equals("political_status")) {
//					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
//					Cell cellA = row.getCell(DataUtil.getIndex("身份证件类型", titleRow));
//					cellA.setCellValue(dic.getDictionaryName());
//					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
//				}
				
				// 国籍/地区
				if (dic.getDictionaryType().equals("country_type")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("国籍/地区", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("国籍/地区", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				
				// 民族
//				if (dic.getDictionaryType().equals("political_status")) {
//					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
//					Cell cellA = row.getCell(DataUtil.getIndex("民族", titleRow));
//					cellA.setCellValue(dic.getDictionaryName());
//					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
//				}
				
				// 最高学历
				if (dic.getDictionaryType().equals("educational_user")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("最高学历", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("最高学历", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				// 最高学位
				if (dic.getDictionaryType().equals("academic_degree")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("最高学位", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("最高学位", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				
				// 签订合同情况
				if (dic.getDictionaryType().equals("contract_type")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("签订合同情况", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("签订合同情况", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				// 岗位类别
				if (dic.getDictionaryType().equals("gwlb_type")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("岗位类别", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("岗位类别", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				
				// 岗位等级
				if (dic.getDictionaryType().equals("gwdj_type")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("岗位等级", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("岗位等级", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				
				// 行政职务
				if (dic.getDictionaryType().equals("office_type")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("行政职务", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("行政职务", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				// 五险一金
//				if (dic.getDictionaryType().equals("political_status")) {
//					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
//					Cell cellA = row.getCell(DataUtil.getIndex("五险一金", titleRow));
//					cellA.setCellValue(dic.getDictionaryName());
//					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
//				}
				
				// 教师资格证种类
				if (dic.getDictionaryType().equals("jszgz_type")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("教师资格证种类", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("教师资格证种类", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				// 普通话等级
				if (dic.getDictionaryType().equals("pthdj_type")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("普通话等级", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("普通话等级", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				// 专业技术职务
//				if (dic.getDictionaryType().equals("political_status")) {
//					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
//					Cell cellA = row.getCell(DataUtil.getIndex("专业技术职务", titleRow));
//					cellA.setCellValue(dic.getDictionaryName());
//					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
//				}
				
				// 近三年专任教师接受培训情况
//				if (dic.getDictionaryType().equals("political_status")) {
//					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
//					Cell cellA = row.getCell(DataUtil.getIndex("近三年专任教师接受培训情况", titleRow));
//					cellA.setCellValue(dic.getDictionaryName());
//					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
//				}
				
				// 是否属于免费师范生
				if (dic.getDictionaryType().equals("mfsfs_type")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("是否属于免费师范生", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("是否属于免费师范生", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				//是否名校长培养对象
				if (dic.getDictionaryType().equals("mspydx_type")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("是否名校长培养对象", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("是否名校长培养对象", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				//是否教学名师
				if (dic.getDictionaryType().equals("jxms_type")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("是否教学名师", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("是否教学名师", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				//是否学科带头人
				if (dic.getDictionaryType().equals("xkdtr_type")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("是否学科带头人", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("是否学科带头人", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				//是否骨干教师
				if (dic.getDictionaryType().equals("ggjs_type")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("是否骨干教师", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("是否骨干教师", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				// 是否是特岗教师
				if (dic.getDictionaryType().equals("tgjs_type")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("是否是特岗教师", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("是否是特岗教师", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				
				// 荣誉称号
//				if (dic.getDictionaryType().equals("political_status")) {
//					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
//					Cell cellA = row.getCell(DataUtil.getIndex("荣誉称号", titleRow));
//					cellA.setCellValue(dic.getDictionaryName());
//					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
//				}
				
				// 编制类别
				if (dic.getDictionaryType().equals("teacher_staff")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("编制类别", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("编制类别", titleRow));	
					}
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}
				// 教师职称
				if (dic.getDictionaryType().equals("teacher_professional")) {
					Row row = sheet.getRow(map.get(dic.getDictionaryType())+1);
					Cell cellA = row.getCell(DataUtil.getIndex("教师职称", titleRow));
					if(cellA == null) {
						cellA = row.createCell(DataUtil.getIndex("教师职称", titleRow));
						
					}
					
					cellA.setCellValue(dic.getDictionaryName());
					map.put(dic.getDictionaryType(), map.get(dic.getDictionaryType())+1);
					continue;
				}

				
			}
			exportExcelFromTemplet(request, response, wb, "import_teacher","xls");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师信息模板，查询学科学段错误:" + e);
		}
	}
	
	/**
	 * 导入教师检测数据
	 * @param file
	 * @param proId
	 * @return
	 */
	@RequestMapping("importTeacher.do")
	public @ResponseBody Map<String, Object> importTeacher(HttpServletRequest request,String path){
		Map<String, Object> result = new HashMap<String,Object>();
		try {
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			result = sysService.parseExcel(projectPath + path, "teacher",null);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("导入失败！"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 导入离退教师记录
	 * @param request
	 * @param path
	 * @return
	 */
	@RequestMapping("importTeacherRetirees.do")
	public @ResponseBody Map<String, Object> importTeacherRetirees(HttpServletRequest request,String path){
		Integer roleId = super.getRoleId(request);
		Map<String, Object> paramMap = new HashMap<String,Object>();
		Map<String, Object> result = new HashMap<String,Object>();
		if(roleId == 1){// 省管理员
			paramMap.put("provinceId", super.getUserProvinceId(request));
		} else if(roleId == 2){// 市管理员
			paramMap.put("cityId", super.getUserCityId(request));
		} else if(roleId == 3){// 区管理员
			paramMap.put("districtId", super.getUserDistrictId(request));
		} else if(roleId == 4){// 校管理员
			paramMap.put("schoolId", super.getSchoolId(request));
		}
		try {
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			result = sysService.parseExcel(projectPath + path, "retirees",paramMap);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			log.error("导入失败！"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 转到导入教师信息页面
	 * @return
	 */
	@RequestMapping("toImportTeacherPage.htm")
	public String toImportTeacherPage(){
		return "project/uploadTeacher";
	}
	
	/**
	 * 转到教师信息变更审核页面
	 * @return
	 */
	@RequestMapping("toTeacherInfoChangeAuditPage.htm")
	public String toTeacherInfoChangeAuditPage(HttpServletRequest request){
//		setArea(request);
		return "teacher/teacherInfoChangeAudit";
	}
	
	
	/**
	 * 教师信息变更列表
	 * @return
	 */
	@RequestMapping("qryChangeRecordList.do")
	public @ResponseBody Map<String,Object> queryChangeListForAudit(HttpServletRequest request, int startIndex,int pageSize,String name,String idNo,String areaId,String status){
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		if(name.trim().length()>0){
			paramMap.put("name", name);
		}
		if(idNo.length()>0){
			paramMap.put("IDNo", idNo);
		}
		if(status.length()>0){
			paramMap.put("auditStatus", status);
		}
		
		if(areaId.length()>0){
			paramMap.put("area", areaId);
		}else {
			EduUserActivty userActivity = super.getSessionUserInfo(request);
			int role = userActivity.getRoleId();
			if(role == 0 || role == 1) {
				paramMap.put("area", userActivity.getUserProvinceId());
			}else if(role == 2) {
				paramMap.put("area", userActivity.getUserCityId());
			}else if(role == 3){
				paramMap.put("area", userActivity.getUserDistrictId());
			}else {
				paramMap.put("area", userActivity.getSchoolId());
			}
		}
		
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			PageObject po = teacherManageService.queryTeacherChangeRecord(paramMap, startIndex, pageSize);
			pageInfo.put("rows", po.getObjects());
			pageInfo.put("total", po.getCount());
			pageInfo.put("pageSize", po.getPagesize());
			pageInfo.put("pages", po.getPages());
			pageInfo.put("currentPage", po.getCurrentPage());
			pageInfo.put("pageNumbers", po.getPageNumbers());
			pageInfo.put("startIndex", po.getStartIndex());
			pageInfo.put("success", true);
		} catch (Exception e) {
			pageInfo.put("success", false);
			e.printStackTrace();
		}
		return pageInfo;
	}
	
	/**
	 * 信息变更审核详情
	 */
	@RequestMapping("viewDetail.htm")
	public String toViewChangeDetail(int auditId,ModelMap map){
		map.put("auditId", auditId);
		return "teacher/teacherInfoChangeDetail";
	}
	
	/**
	 * 信息变更审核
	 */
	@RequestMapping("auditRecord.do")
	public @ResponseBody Map<String,Object> audit(int status,int auditId,String memo,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("status", status);
		params.put("auditId", auditId);
		params.put("memo", memo);
		params.put("auditor", super.getAccount(request));
		try {
			if(teacherManageService.procAuditChangeRecord(params)){
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
	 * 信息变更 批量审核
	 * @param status
	 * @param auditId
	 * @param memo
	 * @param request
	 * @return
	 */
	@RequestMapping("batchAuditRecord.do")
	public @ResponseBody Map<String,Object> batchAudit(int status,String ids,String memo,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(teacherManageService.procBatchAuditChangeRecord(status, ids, memo, super.getAccount(request))){
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 教师信息导入页面
	 */
	@RequestMapping("toImportRecordPage.htm")
	public String toTeacherImportRecordPage(){
		return "teacher/teacherImportRecord";
	}
	
	/**
	 * 审核导入历史记录 
	 * @return
	 */
	@RequestMapping("toAdutiImportRecordPage.htm")
	public String toAdutiImportRecordPage(){
		return "teacher/auditImportRecord";
	}
	
	/**
	 * 导入离退教师记录
	 * @param request
	 * @param path
	 * @return
	 */
	@RequestMapping("importRetireesTeacherStep4.do")
	public @ResponseBody Map<String,Object> importRetireesStep4(HttpServletRequest request,String path, String names, String toExlPath){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
//			path = ApplicationProperties.getPropertyValue("upload_path")+path.replace("/", File.separator);
			
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			path = projectPath + ApplicationProperties.getPropertyValue("upload_file_path")+path.replace("/", File.separator);
			Map<String , Object> param = new HashMap<String , Object>();
			param.put("realName", this.getRealName(request));
			param.put("names", names);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			log.info("导入离退休教师时间Begin------>"+sdf.format(date));
			param.put("date", sdf.format(date));			
			param.put("exlPath", toExlPath);
			result  = sysService.intoDB(path, "retirees", super.getAccount(request), param);
			DataUtil.setOk(result);
		} catch (Exception e) {
			log.info("导入离退休教师失败！");
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 导入教师第四步
	 * @param request
	 * @param path
	 * @return
	 */
	@RequestMapping("importTeacherStep4.do")
	public @ResponseBody Map<String,Object> importStep4(HttpServletRequest request,String path){
		Map<String,Object> result = new HashMap<String,Object>();
		String names = request.getParameter("names");
		String toExl = request.getParameter("toExlPath");
		Map<String,Object> param = new HashMap<String,Object>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.info("导入教师时间Begin------>"+sdf.format(date));
		param.put("date", sdf.format(date));
		param.put("realName", super.getRealName(request));
		param.put("names", names);
		param.put("exlPath", toExl);
		try {
//			path = ApplicationProperties.getPropertyValue("upload_path")+path.replace("/",File.separator);
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			path = ApplicationProperties.getPropertyValue("upload_file_path")+path.replace("/",File.separator);
			
			result  = sysService.intoDB(projectPath + path, "teacher", super.getAccount(request), param);
//			boolean flag = eduProjectService.write2ImportTeacherHistory(super.getAccountId(request), date);
			DataUtil.setOk(result);
		} catch (Exception e) {
			log.info("导入教师失败！");
			result.put("errMsg", e.getMessage());			
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 打包下载
	 * @param path
	 * @param response
	 */
	@RequestMapping("downZip.htm")
	public void downZip(String path,HttpServletResponse response,HttpServletRequest request){
		response.setContentType("application/zip;charset=UTF-8");
		 response.setHeader("Content-Disposition","attachment;filename=edu_export.zip");
		String projectPath = request.getSession().getServletContext().getRealPath("/");
 
		path = projectPath + ApplicationProperties.getPropertyValue("upload_file_path")+path.replace("/", File.separator);
		String zipPath = path.split("toExl")[0];
		File file = new File(path);
		path = path.replace("toExl", "toDB");
		File f2 = new File(path);
		File[] files = {file,f2};
		OutputStream out = null;
		InputStream in = null;
		try {
			String zipFile = sysService.createZipFile(zipPath, files);
			out = response.getOutputStream();
			in = new FileInputStream(new File(zipFile));
			byte[] bts = new byte[1024];
			int bytesRead = -1;
			while((bytesRead=in.read(bts)) != -1){
				out.write(bts, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log.info(path);
	}
	
	/**
	 * 教师信息导入记录
	 */
	@RequestMapping("importTeacherRecords.do")
	public @ResponseBody Map<String,Object> importTeacherRecord(int startIndex, String historyType, HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		param.put("account", super.getAccount(request));
		param.put("historyType", historyType);
		PageObject po;
		try {
			po = teacherService.queryImportTeacherRecord(startIndex, Common.PNN_USER_PAGE_LIMIT, param);
			result.put("rows", po.getObjects());
			result.put("total", po.getCount());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
			result.put("startIndex", po.getStartIndex());
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 导入历史记录页面
	 */
	@RequestMapping("toImportRecordsListPage.htm")
	public String toRecordsListPage(String click, ModelMap mode){
		mode.put("click", click);
		return "teacher/importRecordsList";
	}
	
	/**
	 * 查询导入历史记录
	 */
	@RequestMapping("queryImprotRecordInfo.do")
	public @ResponseBody Map<String,Object> queryImportRecordInfo(int historyId, String historyType, HttpServletRequest request,int startIndex){
		Map<String,Object> result = new HashMap<String,Object>();
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			result = teacherService.queryHistoryAndRecordInfo(historyId, historyType, super.getAccount(request),startIndex,Common.PNN_USER_PAGE_LIMIT);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("queryRecordsByDate.do")
	public @ResponseBody Map<String,Object> queryRecordByDate(String date,String historyType , int startIndex,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("date", date);
		params.put("account", super.getAccount(request));
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		try {
			result = teacherService.queryTIR(startIndex, historyType, Common.PNN_USER_PAGE_LIMIT, date, super.getAccount(request));
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 打包下载
	 * @param path
	 * @param response
	 */
	@RequestMapping("downFailFile.htm")
	public void downFailZip(String path,HttpServletResponse response,HttpServletRequest request){
		response.setContentType("application/zip;charset=UTF-8");
		response.setHeader("Content-Disposition","attachment;filename=edu_export.zip");
//		path = ApplicationProperties.getPropertyValue("upload_path")+path.replace("/", File.separator);
		
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		path = projectPath + ApplicationProperties.getPropertyValue("upload_file_path")+path.replace("/", File.separator);
		String zipPath = path.split("toExl")[0];
		File file = new File(path);
		File[] files = {file};
		OutputStream out = null;
		InputStream in = null;
		try {
			String zipFile = sysService.createZipFile(zipPath, files);
			out = response.getOutputStream();
			in = new FileInputStream(new File(zipFile));
			byte[] bts = new byte[1024];
			int bytesRead = -1;
			while((bytesRead=in.read(bts)) != -1){
				out.write(bts, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log.info(path);
	}
	
	@RequestMapping("queryDateByYear.do")
	public @ResponseBody Map<String,Object> queryDateByYear(String year){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<EduTeacherImportDTO> dates = teacherService.queryDateByYear(year);
			result.put("dtos", dates);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
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
		if(roleId == 1){
			request.setAttribute("areaName", super.getSessionUserInfo(request).getUserProvinceName());
			request.setAttribute("areaId", super.getSessionUserInfo(request).getUserProvinceId());
			request.setAttribute("areaType", "provinceId");
		}else if(roleId == 2){
			request.setAttribute("areaName", super.getSessionUserInfo(request).getUserCityName());
			request.setAttribute("areaId", super.getSessionUserInfo(request).getUserCityId());
			request.setAttribute("areaType", "cityId");
		}else if(roleId == 3 || roleId == 4){
			request.setAttribute("areaName", super.getSessionUserInfo(request).getUserDistrictName());
			request.setAttribute("areaId", super.getSessionUserInfo(request).getUserDistrictId());
			request.setAttribute("areaType", "districtId");
		}
	}
	
	
	
}
