package project.system.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
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
import org.springframework.web.bind.annotation.ResponseBody;

import project.common.Common;
import project.dictionary.service.IDictionaryService;
import project.system.pojo.EduSchool;
import project.system.pojo.SysDictionary;
import project.system.service.ISysSchoolService;
import project.system.service.ISysService;
import project.util.ApplicationProperties;
import project.util.DataUtil;
import framelib.controller.AbsController;
import framelib.utils.page.PageObject;

/**
 * 系统管理
 * 
 * @author zhangBo
 * @version 1.0
 *@Create_Date 2014年3月27日
 */

@Controller
@RequestMapping("/sys")
public class SysSchoolController extends AbsController {
	private static final Logger log = Logger
			.getLogger(SysSchoolController.class);

	@Autowired
	@Qualifier("schoolService")
	ISysSchoolService schoolService;
	

	@Autowired
	@Qualifier("sysService")
	ISysService sysService;
	
	@Autowired
	@Qualifier("dictionaryService")
	IDictionaryService dictionaryService;

	@RequestMapping("querySchool.do")
	public @ResponseBody
	Map<String, Object> queryProjectClass(HttpServletRequest request, String schoolName,
			Integer schoolTypeId, Integer schoolProvinceId,
			Integer schoolCityId, Integer schoolDistrictId) {
		Integer schoolId = this.getSchoolId(request);
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			List<EduSchool> school = schoolService.querySchoolList(schoolName,
					schoolTypeId, schoolProvinceId, schoolCityId,
					schoolDistrictId, schoolId);
			result.put("success", true);
			result.put("rows", school);
		} catch (Exception e) {
			log.error("查询 学校失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}

	/*<!-- 教师调动页面重新单独使用一个查询地区学校的页面，因为教师调动需要跨市区校 -->*/
	@RequestMapping("querySchoolNew.do")
	public @ResponseBody
	Map<String, Object> queryProjectClassNew(HttpServletRequest request, String schoolName,
			Integer schoolTypeId, Integer schoolProvinceId,
			Integer schoolCityId, Integer schoolDistrictId) {
		Integer schoolId = null;
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			List<EduSchool> school = schoolService.querySchoolList(schoolName,
					schoolTypeId, schoolProvinceId, schoolCityId,
					schoolDistrictId, schoolId);
			result.put("success", true);
			result.put("rows", school);
		} catch (Exception e) {
			log.error("查询 学校失败--->" + e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	/**
	 * 学校管理跳转页面
	 * 
	 * @author cl
	 * @return
	 */
	@RequestMapping("toSetSchoolPage.htm")
	public String toSetSchoolPage() {
		return "system/toSchoolPage";
	}

	/**
	 * 新增学校跳转页面
	 * 
	 * @author cl
	 * @return
	 */
	@RequestMapping("toAddSchoolPage.htm")
	public String toAddSchoolPage() {
		return "system/toAddSchoolPage";
	}
	
	/**
	 * 导入学校跳转页面
	 * 
	 * @author cl
	 * @return
	 */
	@RequestMapping("toUploadPage.htm")
	public String toUploadPage() {
		return "system/toUploadPage";
	}

	/**
	 * 学校管理（列表）
	 * 
	 * @author cl
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/querySysSchool.do")
	public @ResponseBody
	Map<String, Object> queryTeacherActivetyList(int pageIndex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			Map<String, Object> paramMap = getArea(request);
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

			if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}

			if (!StringUtils.isEmpty(request.getParameter("schoolName"))) {
				paramMap.put("schoolName", request.getParameter("schoolName"));
			}
			if (!StringUtils.isEmpty(request.getParameter("schoolCode"))) {
				paramMap.put("schoolCode", request.getParameter("schoolCode"));
			}
			if (!StringUtils.isEmpty(request.getParameter("schoolTypeId"))) {
				paramMap.put("schoolTypeId", request.getParameter("schoolTypeId"));
			}
			
			if (!StringUtils.isEmpty(request.getParameter("schoolNatureId"))) {
				paramMap.put("schoolNatureId", request.getParameter("schoolNatureId"));
			}

			if (!StringUtils.isEmpty(request.getParameter("schoolProvinceId"))) {
				paramMap.put("schoolProvinceId", request.getParameter("schoolProvinceId"));
			}

			if (!StringUtils.isEmpty(request.getParameter("schoolCityId"))) {
				paramMap.put("schoolCityId", request.getParameter("schoolCityId"));
			}
			
			if (!StringUtils.isEmpty(request.getParameter("schoolDistrictId"))) {
				paramMap.put("schoolDistrictId", request.getParameter("schoolDistrictId"));
			}
//			if (super.getRoleId(request) > 0) {
//				paramMap.put("roleId", super.getRoleId(request));
//			}
//			paramMap.put("provinceId", super.getUserProvinceId(request));
//			paramMap.put("cityId", super.getUserCityId(request));
//			paramMap.put("districtId", super.getUserDistrictId(request));
			
//			paramMap.put("schoolProvinceId", super.getUserProvinceId(request));
//			paramMap.put("schoolCityId", super.getUserCityId(request));
//			paramMap.put("schoolDistrictId", super.getUserDistrictId(request));
			
//			paramMap.put("userSchoolId", super.getSchoolId(request));

			pageIndex = (pageIndex - 1) * sizePerPage;

			PageObject po = schoolService.querySysSchool(paramMap, pageIndex, sizePerPage);
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
			log.error("学校管理，学校列表查询失败:" + e.getMessage());
		}
		return pageInfo;
	}

	
	/**
	 * 导出学校到excel：其中pageIndex没有用，只是为了让前段发起的请求一致，不做修改
	 * 
	 * @author liuyiyou
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportSysSchoolToExcel.do")
	public @ResponseBody Map<String, Object> exportSysSchoolToExcel(int pageIndex,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			Map<String, Object> paramMap = getArea(request);
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;

			if (!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}

			if (!StringUtils.isEmpty(request.getParameter("schoolName"))) {
				paramMap.put("schoolName", request.getParameter("schoolName"));
			}
			if (!StringUtils.isEmpty(request.getParameter("schoolCode"))) {
				paramMap.put("schoolCode", request.getParameter("schoolCode"));
			}
			if (!StringUtils.isEmpty(request.getParameter("schoolTypeId"))) {
				paramMap.put("schoolTypeId", request.getParameter("schoolTypeId"));
			}
			
			if (!StringUtils.isEmpty(request.getParameter("schoolNatureId"))) {
				paramMap.put("schoolNatureId", request.getParameter("schoolNatureId"));
			}

			if (!StringUtils.isEmpty(request.getParameter("schoolProvinceId"))) {
				paramMap.put("schoolProvinceId", request.getParameter("schoolProvinceId"));
			}

			if (!StringUtils.isEmpty(request.getParameter("schoolCityId"))) {
				paramMap.put("schoolCityId", request.getParameter("schoolCityId"));
			}
			if (!StringUtils.isEmpty(request.getParameter("schoolDistrictId"))) {
				paramMap.put("schoolDistrictId", request.getParameter("schoolDistrictId"));
			}
//			if (super.getRoleId(request) > 0) {
//				paramMap.put("roleId", super.getRoleId(request));
//			}
			
//			paramMap.put("userSchoolId", super.getSchoolId(request));

			List<EduSchool> list = 	schoolService.exportSysSchoolToExcel(paramMap);
			String path = request.getRealPath("/") + "template"
					+ File.separator + "download_school.xls";

			FileInputStream io = new FileInputStream(path);
			// 创建 excel
			Workbook wb = new HSSFWorkbook(io);

			Sheet sheet = wb.getSheetAt(0);
			for (int i = 0; i < list.size(); i++) {
				EduSchool school = list.get(i);
				Row row = sheet.createRow(i + 1);
				Cell cellA = row.createCell(0);
				cellA.setCellValue(school.getSchoolName());

				Cell cellB = row.createCell(1);
				cellB.setCellValue(school.getSchoolTypeName());

				Cell cellC = row.createCell(2);
				cellC.setCellValue(school.getSchoolCode());


				Cell cellE = row.createCell(3);
				cellE.setCellValue(school.getSchoolProvinceName() == null ? "": school.getSchoolProvinceName());

				Cell cellF = row.createCell(4);
				cellF.setCellValue(school.getSchoolCityName() == null ? "" : school.getSchoolCityName());
				
				Cell cellG = row.createCell(5);
				cellG.setCellValue(school.getSchoolDistrictName() == null ? "" : school.getSchoolDistrictName());
			}

			exportExcelFromTemplet(request, response, wb,
					"download_school");
			
			pageInfo.put("success", true);
			
		} catch (Exception e) {
			pageInfo.put("success", false);
			e.printStackTrace();
			log.error("学校管理，学校列表导出失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	/**
	 * 新增学校
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addSchool.do")
	public @ResponseBody
	Map<String, Object> addSchool(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			EduSchool pojo = new EduSchool();
			String accLog = super.getAccount(request);
			pojo.setCreateBy(accLog);
			pojo.setUpdateBy(accLog);
			pojo.setSchoolName(request.getParameter("schoolName"));
			pojo.setSchoolTypeId(Integer.parseInt(request
					.getParameter("schoolTypeId")));
			if (request.getParameter("schoolProvinceId") != null
					&& request.getParameter("schoolProvinceId").length() > 0) {
				pojo.setSchoolProvinceId(Integer.parseInt(request
						.getParameter("schoolProvinceId")));
				pojo.setSchoolProvinceName(request
						.getParameter("schoolProvinceName"));
			}
			if (request.getParameter("schoolCityId") != null
					&& request.getParameter("schoolCityId").length() > 0) {
				pojo.setSchoolCityId(Integer.parseInt(request
						.getParameter("schoolCityId")));
				pojo.setSchoolCityName(request.getParameter("schoolCityName"));
			}
			if (request.getParameter("schoolDistrictId") != null
					&& request.getParameter("schoolDistrictId").length() > 0) {
				pojo.setSchoolDistrictId(Integer.parseInt(request
						.getParameter("schoolDistrictId")));
				pojo.setSchoolDistrictName(request
						.getParameter("schoolDistrictName"));
			}
			pojo.setSchoolContacts(request.getParameter("schoolContacts"));
			pojo.setSchoolContactsAddress(request
					.getParameter("schoolContactsAddress"));
			pojo.setSchoolContactsType(request
					.getParameter("schoolContactsType"));
			pojo.setSchoolTypeName(request.getParameter("schoolTypeName"));
			pojo.setSchoolMemo(request.getParameter("schoolMemo"));
			pojo.setStatus(1);
			if (request.getParameter("schoolNatureId") != null
					&& request.getParameter("schoolNatureId").length() > 0) {
				pojo.setSchoolNatureId(Integer.parseInt(request
						.getParameter("schoolNatureId")));
				pojo.setSchoolNatureName(request
						.getParameter("schoolNatureName"));
			}
			
			if (request.getParameter("areaTypeId") != null
					&& request.getParameter("areaTypeId").length() > 0) {
				pojo.setAreaTypeId(Integer.parseInt(request
						.getParameter("areaTypeId")));
				pojo.setAreaTypeName(request
						.getParameter("areaTypeName"));
			}
			
			pojo.setSchoolCode(request.getParameter("schoolCode"));
			//学校办别
			if(request.getParameter("schoolEstablishTypeId")!=null) {
				pojo.setEstablishTypeId(Integer.parseInt(request.getParameter("schoolEstablishTypeId")));
				pojo.setEstablishTypeName(request.getParameter("schoolEstablishName"));
			}
			
			Integer flag = schoolService.addSchool(pojo);

			if (flag.intValue() == 0) {
				pageInfo.put("success", true);
			} else {
				pageInfo.put("success", false);
			}

		} catch (Exception e) {
			pageInfo.put("success", false);
			
			if(e.getMessage().equals("-1")){
				pageInfo.put("error", "-1");
				log.error("新增学校记录失败:学校编码应全部为4-16位数字");
			}else if(e.getMessage().equals("-2")){
				pageInfo.put("error", "-2");
				log.error("新增学校记录失败:学校编码应全部为4-16位数字");
			}else if(e.getMessage().equals("-3")){
				pageInfo.put("error", "-3");
				log.error("新增学校记录失败:学校编码已经存在");
			}else{
				pageInfo.put("error", "-0");
				log.error("新增学校记录失败:" + e.getMessage());
			}
		}

		return pageInfo;
	}
	
	/**
	 * 查看学校详情
	 * 
	 * @author cl
	 * @create date 2013-4-13
	 * @return
	 */
	@RequestMapping("/querySchoolInfo.htm")
	public String querySchoolInfo(ModelMap map, HttpServletRequest request) {
		try {
			if(request.getParameter("id")==null || request.getParameter("id").length()<=0){
				throw new Exception("ID为空！");
			}
			EduSchool info=new EduSchool();
			info=schoolService.searchSchoolInfo(Integer.parseInt(request.getParameter("id")));
			if(info.getSchoolCityName()!=null && info.getSchoolCityName().length()>0){
				info.setSchoolProvinceName(info.getSchoolProvinceName()+"—"+info.getSchoolCityName());
			}
			if(info.getSchoolDistrictName()!=null && info.getSchoolDistrictName().length()>0){
				info.setSchoolProvinceName(info.getSchoolProvinceName()+"—"+info.getSchoolDistrictName());
			}
			map.addAttribute("info", info);
		} catch (Exception e) {
			log.error("查看学校详情失败:" + e.getMessage());
		}
		
		return "system/toInfoSchoolPage";
	}
	
	/**
	 * 修改学校信息
	 * 
	 * @author cl
	 * @create date 2013-4-13
	 * @return
	 */
	@RequestMapping("/modifySchoolInfo.htm")
	public String modifySchoolInfo(ModelMap map, HttpServletRequest request) {
		try {
			if(request.getParameter("id")==null || request.getParameter("id").length()<=0){
				throw new Exception("ID为空！");
			}
			EduSchool info=new EduSchool();
			info=schoolService.searchSchoolInfo(Integer.parseInt(request.getParameter("id")));
			if(info.getSchoolCityName()!=null && info.getSchoolCityName().length()>0){
				info.setSchoolProvinceName(info.getSchoolProvinceName()+"—"+info.getSchoolCityName());
			}
			if(info.getSchoolDistrictName()!=null && info.getSchoolDistrictName().length()>0){
				info.setSchoolProvinceName(info.getSchoolProvinceName()+"—"+info.getSchoolDistrictName());
			}
			map.addAttribute("info", info);
		} catch (Exception e) {
			log.error("查看学校详情失败:" + e.getMessage());
		}
		
		return "system/toModifySchoolPage";
	}
	
	/**
	 * 更新学校
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/modifySchool.do")
	public @ResponseBody
	Map<String, Object> modifySchool(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		try {
			if(request.getParameter("schoolId")==null || request.getParameter("schoolId").length()<=0){
				throw new Exception("school_id为空");
			}
			EduSchool pojo = new EduSchool();
			String accLog = super.getAccount(request);
			pojo.setUpdateBy(accLog);
			pojo.setSchoolId(Integer.parseInt(request.getParameter("schoolId")));
			pojo.setSchoolName(request.getParameter("schoolName"));
			if(request.getParameter("schoolTypeId")!=null && request.getParameter("schoolTypeId").length()>0){
				pojo.setSchoolTypeId(Integer.parseInt(request.getParameter("schoolTypeId")));
				pojo.setSchoolTypeName(request.getParameter("schoolTypeName"));
			}
			
			if (request.getParameter("schoolProvinceId") != null
					&& request.getParameter("schoolProvinceId").length() > 0) {
				pojo.setSchoolProvinceId(Integer.parseInt(request
						.getParameter("schoolProvinceId")));
				pojo.setSchoolProvinceName(request
						.getParameter("schoolProvinceName"));
			}
			if (request.getParameter("schoolCityId") != null
					&& request.getParameter("schoolCityId").length() > 0) {
				pojo.setSchoolCityId(Integer.parseInt(request
						.getParameter("schoolCityId")));
				pojo.setSchoolCityName(request.getParameter("schoolCityName"));
			}
			if (request.getParameter("schoolDistrictId") != null
					&& request.getParameter("schoolDistrictId").length() > 0) {
				pojo.setSchoolDistrictId(Integer.parseInt(request
						.getParameter("schoolDistrictId")));
				pojo.setSchoolDistrictName(request
						.getParameter("schoolDistrictName"));
			}
			pojo.setSchoolContacts(request.getParameter("schoolContacts"));
			pojo.setSchoolContactsAddress(request
					.getParameter("schoolContactsAddress"));
			pojo.setSchoolContactsType(request
					.getParameter("schoolContactsType"));
			pojo.setSchoolMemo(request.getParameter("schoolMemo"));
			if(request.getParameter("schoolNatureId")!=null && request.getParameter("schoolNatureId").length()>0){
				pojo.setSchoolNatureId(Integer.parseInt(request.getParameter("schoolNatureId")));
				pojo.setSchoolNatureName(request.getParameter("schoolNatureName"));
				
			}
			
			if (request.getParameter("areaTypeId") != null
					&& request.getParameter("areaTypeId").length() > 0) {
				pojo.setAreaTypeId(Integer.parseInt(request
						.getParameter("areaTypeId")));
				pojo.setAreaTypeName(request
						.getParameter("areaTypeName"));
			}
			
			String schoolCode=request.getParameter("schoolCode");
			
			pojo.setSchoolCode(schoolCode);
			pojo.setOldSchoolCode(request.getParameter("oldSchoolCode"));
			//学校办别
			if(request.getParameter("schoolEstablishTypeId")!=null) {
				pojo.setEstablishTypeId(Integer.parseInt(request.getParameter("schoolEstablishTypeId")));
				pojo.setEstablishTypeName(request.getParameter("schoolEstablishName"));
			}
			
			Integer flag = schoolService.updateSchool(pojo);

			if (flag.intValue() == 0) {
				pageInfo.put("success", true);
			} else {
				pageInfo.put("success", false);
			}

		} catch (Exception e) {
			pageInfo.put("success", false);
			
			if(e.getMessage().equals("-1")){
				pageInfo.put("error", "-1");
				log.error("更新学校记录失败:学校编码应全部为4-16位数字");
			}else if(e.getMessage().equals("-2")){
				pageInfo.put("error", "-2");
				log.error("更新学校记录失败:学校编码应全部为4-16位数字");
			}else if(e.getMessage().equals("-3")){
				pageInfo.put("error", "-3");
				log.error("更新学校记录失败:学校编码已经存在");
			}else{
				pageInfo.put("error", "-0");
				log.error("更新学校记录失败:" + e.getMessage());
			}
		}

		return pageInfo;
	}
	
	/**
	 * 删除学校
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteSchool.do")
	public @ResponseBody
	Map<String, Object> deleteSchool(HttpServletRequest request) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		EduSchool pojo = new EduSchool();
		try {
			if(request.getParameter("schoolId")==null || request.getParameter("schoolId").length()<=0){
				throw new Exception("school_id为空");
			}
			
			String accLog = super.getAccount(request);
			pojo.setUpdateBy(accLog);
			pojo.setSchoolId(Integer.parseInt(request.getParameter("schoolId")));
			pojo.setStatus(0);
			
			Integer flag = schoolService.deleteSchool(pojo);

			if (flag.intValue() == 0) {
				pageInfo.put("success", true);
			} else {
				pageInfo.put("flag", "0");
				pageInfo.put("success", false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			if(e.getMessage().equals("-1")){
				pageInfo.put("flag", "-1");
				log.error("删除学校记录失败:该学校已经被引用！schoolId:"+pojo.getSchoolId());
			}else{
				pageInfo.put("flag", "0");
				log.error("删除学校记录失败:" + e.getMessage());
			}
			pageInfo.put("success", false);
		}

		return pageInfo;
	}
	
	/**
	 * 管理员: 导出教师信息模板，为学科学段政治面貌赋上默认值（从数据字典中查询）
	 * @param request
	 * @param path
	 */
	@RequestMapping("downSchoolTemplate.do")
	public void downTeachersTemplate(HttpServletRequest request,
			HttpServletResponse response) {

		// 查找数据字典中学段
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dictionaryType", "school_type");//学校类型		
		paramMap.put("status", 1);//启用状态
		try {
			// 查找数据字典中学段			
			List<SysDictionary> sysDictionaryList = dictionaryService.selectAllSysDictionaryList(paramMap);
			String path = request.getRealPath("/") + "template"
					+ File.separator + "import_school.xls";

			FileInputStream io = new FileInputStream(path);
			// 创建 excel
			Workbook wb = new HSSFWorkbook(io);
			Sheet sheet = wb.getSheetAt(2);
			int m = 0;	
			
			Row titleRow = sheet.getRow(0);
			//置空学校类型列
			DataUtil.setColumEmpty(sheet, DataUtil.getIndex("学校类型", titleRow),1);
			
			for (int i = 0; i < sysDictionaryList.size(); i++) {
				// 查找数据字典中学段，为学校模板学校类型赋值
				if (sysDictionaryList.get(i).getDictionaryType().equals("school_type")) {
					Row row = sheet.getRow(m + 1);
					if (row == null) {
						row = sheet.createRow(m + 1);
					}
					Cell cellA = row.getCell(0);
					if(cellA == null){
						cellA = row.createCell(0);
					}
					cellA.setCellValue(sysDictionaryList.get(i).getDictionaryName());
					m += 1;
				}
			}
			exportExcelFromTemplet(request, response, wb, "import_school","xls");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("教师信息模板，查询学科学段错误:" + e);
		}
	}
	
	/**
	 *	检测上传的学校信息 
	 */
	@RequestMapping("/checkUploadSchool.do")
	public @ResponseBody Map<String,Object> checkUploadSchool(HttpServletRequest request,String path){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			result = sysService.parseExcel(projectPath + path, "school", null);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 提交学校信息
	 */
	@RequestMapping("/submitUploadSchool.do")
	public @ResponseBody Map<String,Object> submitUploadSchool(HttpServletRequest request,String path){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("account", super.getAccount(request));
		
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		path = projectPath + ApplicationProperties.getPropertyValue("upload_file_path")+path.replace("/",File.separator);
		try {
			result = schoolService.intoDB(path, super.getAccount(request));
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}


}
