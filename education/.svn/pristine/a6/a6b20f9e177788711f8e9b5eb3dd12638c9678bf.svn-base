package project.stats.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;
import project.person.service.IUserService;
import project.stats.service.IStatsService;
import project.system.pojo.ZTree;
import framelib.controller.AbsController;
import framelib.utils.page.PageObject;

@Controller
@RequestMapping("/stats")
public class StatsController  extends AbsController{
	private static final Logger log = Logger.getLogger(StatsController.class);
	
	@Autowired
	@Qualifier("statsService")
	IStatsService statsService;
	
	@Autowired
	@Qualifier("userService")
	IUserService userService;
	
	/**
	 * 继教统计页面
	 */
	@RequestMapping(value = "furtherStatsPage.htm")
	public String furtherStats( HttpServletRequest request) {
		return "stats/furtherStatsPage";
	}
	
	@RequestMapping(value = "schoolStatsPage.htm")
	public String schoolStats( HttpServletRequest request) {
		return "stats/schoolStatsPage";
	}
	
	 
	@RequestMapping(value = "/querySchoolStats.do")
	public @ResponseBody Map<String, Object> querySchoolStats(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("学校统计:地区-学段");
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		try {
			String area_id=request.getParameter("area_id");//地区ID
			String dict_type= request.getParameter("dictionaryTypeId");//字典2类型
//			Integer userId = getAccountId(request);
//			EduUser user = userService.getUserById(userId);
//			Integer provinceId = user.getUserProvinceId();
//			Integer cityId = user.getUserCityId();
//			Integer districtId = user.getUserDistrictId();
//			Integer schoolId = user.getSchoolId();
			
			Integer currentAreaId = 0; //当前省市区学校的Id.
//			if(provinceId !=null){
//				currentAreaId = provinceId;
//			}		
//			if(cityId !=null){
//				currentAreaId = cityId;
//			}		
//			if(districtId !=null){
//				currentAreaId = districtId;
//			}		
//			if(schoolId !=null){
//				currentAreaId = schoolId;
//			}	
			
			EduUserActivty obj = getSessionUserInfo(request);
			int roleId = obj.getRoleId().intValue();
			if(roleId==1){
				currentAreaId = Integer.parseInt(obj.getUserProvinceId());
			}else if(roleId==2){
				currentAreaId = Integer.parseInt(obj.getUserCityId());
			}else if(roleId==3){
				currentAreaId = Integer.parseInt(obj.getUserDistrictId());
			}else if(roleId==4){
				currentAreaId = obj.getSchoolId();
			}
			
			if(area_id.equals("0")){
				area_id=currentAreaId.toString();
			}
			Map<String,Object> conditions = new HashMap<String,Object>();
			conditions.put("area_id", area_id);
			conditions.put("_dict1_type", dict_type);
			
		
			PageObject po =statsService.queryStatsSchool(conditions, 0, 0);//需要对po进行赋值
			
			if(po != null ) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("继教统计查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	
	/**
	 * 继教统计/
	 */
	@RequestMapping(value = "/queryFurtherStats.do")
	public @ResponseBody Map<String, Object> queryTeacherAssessList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("学校统计:地区-学段");
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		try {
			String area_id = request.getParameter("area_id");//地区ID
			String projectYear = request.getParameter("projectYear");//字典2类型
			
			//注释原因：此处为获取登录用户所属区域areaId，可作简化处理
			/*Integer userId = getAccountId(request);
			EduUser user = userService.getUserById(userId);
			Integer provinceId = user.getUserProvinceId();
			Integer cityId = user.getUserCityId();
			Integer districtId = user.getUserDistrictId();
			Integer schoolId = user.getSchoolId();
			Integer currentAreaId = 0; //当前省市区学校的Id.
			if(provinceId !=null){
				currentAreaId = provinceId;
			}		
			if(cityId !=null){
				currentAreaId = cityId;
			}		
			if(districtId !=null){
				currentAreaId = districtId;
			}		
			if(schoolId !=null){
				currentAreaId = schoolId;
			}	
			
			if(area_id.equals("0")){
				area_id = currentAreaId.toString();
			}*/
			
			if(area_id.equals("0")){
				area_id = super.getUserAreaId(request);
			}
			
			Map<String,Object> conditions = new HashMap<String,Object>();
			conditions.put("area_id", area_id);
			conditions.put("year", projectYear);
		
			PageObject po = statsService.queryStatsFuther(conditions, 0, 0);//需要对po进行赋值
			
			if(po != null ) {
				pageInfo.put("success", true);
				pageInfo.put("rows", po.getObjects());
			} else {
				pageInfo.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("继教统计查询失败:" + e.getMessage());
		}
		return pageInfo;
	}
	

	/**
	 * 当前用户的地区ID	conditions.put("_dict1_id", currentAreaId);
	 * 查询的字典类型:conditions.put("_dict2_type", "educational_user");
	 * @param request
	 * @return
	 */
	@RequestMapping("teacherRegionStatsProfession.do")
	public @ResponseBody  Map<String, Object> orgAreaList(HttpServletRequest request){
		log.info("教师统计:地区-职务");
		String _type=request.getParameter("_type");//0地区,1字典
		String _dict1_type= request.getParameter("_dict1_type");//字典1类型
		String _dict1_id= request.getParameter("_dict1_id");//字典1的ID
		String _dict2_type= request.getParameter("dictionaryTypeId");//字典2类型
		
		
		try {
			Map<String, Object> conditions =new HashMap<String,Object>();
			Map<String,Object> result = new HashMap<String,Object>();
			Integer userId = getAccountId(request);
			EduUser user = userService.getUserById(userId);
			Integer provinceId = user.getUserProvinceId();
			Integer cityId = user.getUserCityId();
			Integer districtId = user.getUserDistrictId();
			Integer schoolId = user.getSchoolId();
			Integer currentAreaId = 0; //当前省市区学校的Id.
			if(provinceId !=null){
				currentAreaId = provinceId;
			}		
			if(cityId !=null){
				currentAreaId = cityId;
			}		
			if(districtId !=null){
				currentAreaId = districtId;
			}		
			if(schoolId !=null){
				currentAreaId = schoolId;
			}	
			if(_dict1_id.equals("0")){
				_dict1_id=currentAreaId.toString();
			}
			conditions.put("_type", _type);
			conditions.put("_dict1_id", _dict1_id);
			conditions.put("_dict1_type", _dict1_type);
			conditions.put("_dict2_type", _dict2_type);
			PageObject po =statsService.queryStats( conditions, 0, 0);
			if(po != null ) {
				result.put("success", true);
				result.put("rows",po.getObjects());
			} else {
				result.put("success", false);
			}
			
//			return statsService.queryStats(0, conditions, 0, 0);
			result.put("total",po.getCount());
			result.put("pageSize", po.getPagesize());
			result.put("pages", po.getPages());
			result.put("currentPage", po.getCurrentPage());
			result.put("pageNumbers", po.getPageNumbers());
 
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
