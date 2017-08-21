package project.edupm.projectclass.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.common.Common;
import project.edupm.projectclass.pojo.EduProjectClass;
import project.edupm.projectclass.pojo.OrgClass;
import project.edupm.projectclass.service.IProjectClassService;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.service.IEduProjectService;
import project.util.DataUtil;
import framelib.controller.AbsController;
import framelib.utils.page.PageObject;



@Controller
@RequestMapping("edupm/projectclass")
public class ProjectClassController extends AbsController{
	
	private static Log log = LogFactory.getLog(ProjectClassController.class);
	
	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;
	
	@Autowired
	@Qualifier("eduProjectClassService")
	IProjectClassService eduProjectClassService;
	
	/*@Autowired
	@Qualifier("organizationService")
	IOrganizationServiceIF orgService;
	
	private int selectOrgIdByUserId(int userId) {
		int rtn = 0;
		try {
			rtn = orgService.selectOrgIdByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询orgId失败");
		}
		return rtn;
	}*/
	/**
	 * 机构: 创建其分配项目下的课程
	 * @param request
	 * @return
	 *//*
	@RequestMapping("orgCreateClass.do")
	public @ResponseBody Map<String, Object> orgCreateClass(HttpServletRequest request){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		
		int projectId = Integer.parseInt(request.getParameter("proId"));
		String clazz = request.getParameter("clazz");
		ObjectMapper mapper = new ObjectMapper();
		Integer userId = getAccountId(request);
		paramMap.put("userId", userId);
		int organizationId = selectOrgIdByUserId(userId);
		try {
			EduProjectClass projectClass = mapper.readValue(clazz, EduProjectClass.class);
			projectClass.setUpdateDate(new Date());
			projectClass.setCreateDate(new Date());
			if(projectClass.getId() == null){
				projectClass.setCreateBy(super.getAccount(request));
				if(eduProjectClassService.saveClassByOrg(projectId, projectClass)){
					DataUtil.setOk(result);
				}
			}else{
				projectClass.setUpdateBy(super.getAccount(request));
				if(eduProjectClassService.modifyClassByOrg(projectClass)){
					DataUtil.setOk(result);
				}
			}
			
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
		
	}*/
	
	@RequestMapping("toClassListPage.htm")
	public String toClassListPage(@RequestParam("proId")int proId,ModelMap map){
		try {
			EduProject dto = eduProjectService.queryProjectBaseInfoById(proId);
			map.put("planNum", dto.getPlanNum());
			map.put("name", dto.getProjectName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/projectClassMgr";
	}
	
	
	@RequestMapping("createClass.do")
	public @ResponseBody Map<String, Object> createClass(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		
		int projectId = Integer.parseInt(request.getParameter("proId"));
		String clazz = request.getParameter("clazz");
		ObjectMapper mapper = new ObjectMapper();
		try {
			EduProjectClass projectClass = mapper.readValue(clazz, EduProjectClass.class);
			projectClass.setUpdateDate(new Date());
			projectClass.setCreateDate(new Date());
			
			Integer userId = getAccountId(request);
			projectClass.setUserId(userId);
			
			int roleId = getSessionUserInfo(request).getRoleId();
			projectClass.setRoleId(roleId);
			if(projectClass.getId() == null){
				projectClass.setCreateBy(super.getAccount(request));
				if(eduProjectClassService.saveClass(projectId, projectClass)){
					DataUtil.setOk(result);
				}
			}else{
				projectClass.setUpdateBy(super.getAccount(request));
				if(eduProjectClassService.modifyClass(projectClass)){
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
	 * 项目课程列表
	 * @param proId
	 * @param startIndex
	 * @return
	 */
	@RequestMapping("qryClasses.do")
	public @ResponseBody Map<String, Object> queryClassesList(int proId,int startIndex,String className,int classSubjectId){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("classSubjectId", classSubjectId==0?null:classSubjectId);
		params.put("className", className==null?null:className.equals("")?null:className);
		startIndex = (startIndex - 1) * Common.PNN_USER_PAGE_LIMIT;
		params.put("startIndex", startIndex);
		try {
			PageObject po = eduProjectClassService.projectClasses(proId, params, startIndex, Common.PNN_USER_PAGE_LIMIT);
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
	
	@RequestMapping("deleteClass.do")
	public @ResponseBody Map<String, Object> deleteClass(int classId){
		Map<String, Object> result = new HashMap<String,Object>();
		try {
			if(eduProjectClassService.deleteClass(classId)){
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		
		return result;
	}
	@RequestMapping("qryClassInfo.do")
	public @ResponseBody Map<String, Object> qryClassInfo(int classId){
		Map<String, Object> result = new HashMap<String,Object>();
		try {
			EduProjectClass clazz = eduProjectClassService.qryClassById(classId);
			if(clazz!= null){
				result.put("obj", clazz);
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
	
	@RequestMapping("toOrgClassPage.htm")
	public String toOrgClassPage(ModelMap map,HttpServletRequest request){
		int proId = Integer.parseInt(request.getParameter("proId"));
		try {
			List<OrgClass> classes = eduProjectClassService.projectClassByOrg(proId);
			EduProject dto = eduProjectService.queryProjectBaseInfoById(proId);
			map.put("planNum", dto.getPlanNum());
			map.put("name", dto.getProjectName());
			map.put("class", classes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/orgClassList";
	}
	
//	@RequestMapping("qryClassByOrg.do")
//	public Map<String,Object> qryClassByOrg(int projectId){
//		Map<String,Object> result = new HashMap<String,Object>();
//		try {
//			List<OrgClass> classes = eduProjectClassService.projectClassByOrg(projectId);
//			DataUtil.setOk(result);
//			result.put("objs", classes);
//		} catch (Exception e) {
//			DataUtil.setFail(result);
//			e.printStackTrace();
//		}
//		return result;
//	}
}


