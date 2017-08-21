package project.furtheredu.eduTarget.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.furtheredu.eduTarget.pojo.EduTargetByYear;
import project.furtheredu.eduTarget.service.IEduTargetService;
import project.person.pojo.EduUser;
import project.teacher.teachermanage.dto.EduTeacherEduDTO;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherJob;
import project.teacher.teachermanage.service.ITeacherManageService;

import framelib.common.Common;
import framelib.controller.AbsController;
import framelib.utils.page.PageObject;

/**
 * 
 * 教师信息控制器
 * @Create_by:dengguo
 * @Create_date:2014-1-8
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 * 
 */

@Controller
@RequestMapping("/furtheredu/edutarget")
public class EduTargetController extends AbsController{
	private static final Logger log = Logger.getLogger(EduTargetController.class);
	
	@Autowired
	@Qualifier("eduTargetService")
	IEduTargetService eduTargetService;
	
//	/**
//	 * 跳转教师新增页面
//	 * @return
//	 */
//	@RequestMapping(value = "editeTeacherPage.htm")
//	public String editeTeacherPage(ModelMap map, Integer teacherId) {
//		map.put("teacherId", teacherId);
//		return "teacher/editeTeacher";
//	}
//	
//	/**
//	 * 跳转教师新增页面
//	 * @return
//	 */
//	@RequestMapping(value = "createTeacherPage.htm")
//	public String createTeacherPage(ModelMap map) {
//		return "teacher/createTeacher";
//	}
	
	/**
	 * 跳转年度考核设置页面
	 * @return
	 */
	@RequestMapping(value = "targetManagePage.htm")
	public String teacherManagePage(ModelMap map, HttpServletRequest request) {
		map.put("areaName", this.getCode(request).get("areaName"));
		request.setAttribute("areaName", this.getCode(request).get("areaName"));
		map.put("areaId", this.getCode(request).get("areaId"));
		map.put("areaType", this.getCode(request).get("areaType"));
		return "furtheredu/targetManage";
	}
	
	
	@RequestMapping(value = "updateTarget.do")
	public @ResponseBody Map<String,Object> updateTarget(ModelMap map, String data, HttpServletRequest request) {
		Map<String,Object> result = new HashMap<String,Object>();
		ObjectMapper mapper = new ObjectMapper();
		EduTargetByYear pojo=new EduTargetByYear();
		try {
			pojo = mapper.readValue(data, EduTargetByYear.class);
			if(pojo != null){
				pojo.setUpdateBy(getAccount(request));
				pojo.setUpdateDate(new Date());
			}
			Integer userId = eduTargetService.updateTaget(pojo);
			if(userId != null && userId.intValue() >= 0) {
				result.put("success", true);
				result.put("userId", userId);
			} else {
				throw new Exception("-0");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(e.getMessage()=="-1"){
				result.put("flag", "-1");
				log.error("更新年度 考核设置失败:已经存在"+pojo.getYear().toString()+pojo.getProvinceName()+pojo.getCityName()+pojo.getDistrictName()+pojo.getSchoolName()+"的信息！");
			}
			else{
				result.put("flag", "-0");
				log.error("更新年度 考核设置失败:"+e.getMessage());
			}
			
			result.put("success", false);
		}
		return result;
	}
	
	@RequestMapping(value = "deleteTarget.do")
	public @ResponseBody Map<String,Object> deleteTarget(ModelMap map, Integer id, HttpServletRequest request) {
		Map<String,Object> result = new HashMap<String,Object>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			if(id != null){
				Integer userId = eduTargetService.deleteTargetById(id);
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
	
	@RequestMapping(value = "saveTarget.do")
	public @ResponseBody Map<String,Object> saveTarget(ModelMap map, String data, HttpServletRequest request) {
		Map<String,Object> result = new HashMap<String,Object>();
		ObjectMapper mapper = new ObjectMapper();
		EduTargetByYear pojo=new EduTargetByYear();
		try {
			 pojo = mapper.readValue(data, EduTargetByYear.class);
			 if(pojo != null){		
				pojo.setCreateDate(new Date());
				pojo.setUpdateDate(new Date());
			}
			 /*if(pojo.getProvinceId()!=null&&pojo.getCityId()==null&&pojo.getDistrictId()==null&&pojo.getSchoolId()==null){
				pojo.setCityId("");
				pojo.setDistrictId("");
				pojo.setSchoolId("");
			 }else if(pojo.getProvinceId()!=null&&pojo.getCityId()!=null&&pojo.getDistrictId()==null&&pojo.getSchoolId()==null){
				 pojo.setDistrictId("");
				 pojo.setSchoolId("");
			 }else if(pojo.getProvinceId()!=null&&pojo.getCityId()!=null&&pojo.getDistrictId()!=null&&pojo.getSchoolId()==null){
				 pojo.setSchoolId("");
			 }*/
			
			
			Integer userId = eduTargetService.saveTagetInfo(pojo);
			if(userId != null && userId.intValue() >= 0) {
				result.put("success", true);
				result.put("userId", userId);
			} else {
				throw new Exception("-0");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(e.getMessage()=="-1"){
				result.put("flag", "-1");
				log.error("保存年度 考核设置失败:已经存在"+pojo.getYear().toString()+pojo.getProvinceName()+pojo.getCityName()+pojo.getDistrictName()+pojo.getSchoolName()+"的信息！");
			}
			else{
				result.put("flag", "-0");
				log.error("保存年度 考核设置失败:"+e.getMessage());
			}
			
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 年度考核设置
	 * @param map
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "findTargetInfo.do")
	public @ResponseBody Map<String,Object> findTargetInfo( Integer id, HttpServletRequest request) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			EduTargetByYear pojo  = eduTargetService.queryTargetInfoById(id);
			if(pojo != null) {
				result.put("success", true);
				result.put("obj", pojo);
			} else {
				result.put("success", false);
			}
		} catch (Exception e) {
			log.error("查询 年度考核设置失败--->"+e.getMessage());
			e.printStackTrace();
			result.put("success", false);
		}
		return result;
	}
	
	/**
	 * 年度考核设置查询
	 * @param pageIndex
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryTargetList.do")
	public @ResponseBody Map<String, Object> queryTeacherActivetyList(int pageIndex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String year=request.getParameter("year");
	    String provinceId=request.getParameter("provinceId");
	    String cityId=request.getParameter("cityId");
	    String districtId=request.getParameter("districtId");
	    String schoolId=request.getParameter("schoolId");
		if(!StringUtils.isEmpty(year)) {
			paramMap.put("year", year);
		}
		if(!StringUtils.isEmpty(provinceId)) {
			paramMap.put("provinceId", provinceId);
				}
		if(!StringUtils.isEmpty(cityId)) {
			paramMap.put("cityId", cityId);
		}
		if(!StringUtils.isEmpty(districtId)) {
			paramMap.put("districtId", districtId);
				}
		if(!StringUtils.isEmpty(schoolId)) {
			paramMap.put("schoolId", schoolId);
		}
		paramMap.put((String)(getCode(request).get("areaType")), (getCode(request).get("areaId")));
		try {
			int sizePerPage = Common.PNN_USER_PAGE_LIMIT;
			if(!StringUtils.isEmpty(request.getParameter("sizePerPage"))) {
				sizePerPage = Integer.valueOf(request.getParameter("sizePerPage"));
			}
			pageIndex = (pageIndex - 1) * sizePerPage;
			
			// 2查询分页数据
			PageObject po = eduTargetService.queryTagetListPage(paramMap, pageIndex, sizePerPage);
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
			log.error("教师信息综合查询错误:" + e);
		}
		return pageInfo;
	}
}
