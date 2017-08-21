package project.edupm.projectmanage.controller;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.common.Common;
import project.edupm.projectmanage.pojo.EduPaper;
import project.edupm.projectmanage.pojo.EduQuestion;
import project.edupm.projectmanage.pojo.EduQuestionOptions;
import project.edupm.projectmanage.pojo.EduQustionSummary;
import project.edupm.projectmanage.service.IEduProjectService;
import project.person.pojo.EduUserActivty;
import project.system.service.ISysService;
import project.util.ApplicationProperties;
import project.util.DataUtil;
import framelib.controller.AbsController;
import framelib.utils.DateUtil;
import framelib.utils.page.PageObject;
@SuppressWarnings("deprecation")
@Controller
@RequestMapping("/edupm/paper")
public class PaperController extends AbsController{
	private static final Logger log = Logger.getLogger(ProjectController.class);

	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;
	

	@Autowired
	@Qualifier("sysService")
	ISysService sysService; 
	
	
	/**
	 * 添加调查问卷
	 */
	@RequestMapping(value = "addPaper.htm")
	public String doAddPaper(Integer proId,HttpServletRequest request,ModelMap map){
//		setArea(request);
		HttpSession session = request.getSession();
		if(session.getAttribute("userinfo")!=null){
			EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
			/*map.put("username", info.getLoginAccount());*/
			request.setAttribute("username", info.getLoginAccount());
		}
		/*map.put("proId", proId);*/
		request.setAttribute("proId", proId);
		return "project/addPaper";
	}
	
	/**
	 * 问卷调查汇总
	 * @author cl
	 * @return
	 */
	@RequestMapping("toQuestionSurverSummary.htm")
	public String toQuestionSurverSummary(ModelMap map, HttpServletRequest request) {
		map.put("areaName", this.getCode(request).get("areaName"));
		map.put("areaId", this.getCode(request).get("areaId"));
		map.put("areaType", this.getCode(request).get("areaType"));
		return "project/toQuestionSurverSummary";
	}
	
	/**
	 * 添加调查问卷
	 * */
	@RequestMapping("addPapertoBase.do")
	public @ResponseBody Map<String,Object> addPapertoBase(	
		EduPaper paper,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		if(paper.getIsforce()==null){
			paper.setIsforce(Common.PAPER_FORCE_NO);
		}
		paper.setCreateDate(DateUtil.getSystemTimeFormat("yyyy-MM-dd"));
		try {
			int i = eduProjectService.insertPaper(paper);
			if(i==1){
				result.put("SUEECSS", "success");
			}else{
				result.put("SUEECSS", "fail");
			}
			
		} catch (Exception e) {
			log.error("添加调查问卷失败--->"+e.getMessage());
			result.put("SUEECSS", "fail");
		}
		return result;
	}
	
	/**
	 * 编辑调查问卷
	 */
	@RequestMapping(value = "toUpdatePaper.htm")
	public String toUpdatePaper(int paperId,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			EduPaper eduPaper = eduProjectService.selectEduPaperById(paperId);
			
			request.setAttribute("eduPaper", eduPaper);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/updatePaper";
	}
	
	/**
	 * 修改调查问卷
	 * */
	@RequestMapping("updatePaper.do")
	public @ResponseBody Map<String,Object> updatePaper(EduPaper eduPaper,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(eduPaper.getIsforce()==null){
				eduPaper.setIsforce(Common.PAPER_FORCE_NO);
			}
			eduProjectService.updatePaper(eduPaper);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 获取调查问卷问题列表
	 * */
	@RequestMapping("getQuestion.do")
	public @ResponseBody Map<String,Object> getQuestion(
			int startIndex,int start,int end,String paperId,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> conditions = super.getCode(request);
		try {
			startIndex =0;
			conditions.put("start", start);
			conditions.put("end", end);
			conditions.put("paperId", paperId);
			PageObject page = eduProjectService.selectEduQuestionListByPapid(conditions, startIndex, Common.PAPER_Q_LIMIT);
			result.put("rows",page.getObjects());
			result.put("success", "success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("success", "fail");
		}
		
		return result;
	}
	
	
	
	/*
	 * 删除调查问卷
	 */
	@RequestMapping("deletePaper.do")
	public @ResponseBody Map<String,Object> deletePaper(int proId,int paperId,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> conditions = new HashMap<String,Object>();
		
		return result;
	}
	
	/**
	 *问题添加页面
	 */
	@RequestMapping("toAddQuestion.htm")
	public String toAddQuestion(int paperId,HttpServletRequest request){
		try {
			EduPaper eduPaper = eduProjectService.selectEduPaperById(paperId);
			request.setAttribute("eduPaper", eduPaper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/addQuestion";
	}
	
	@RequestMapping("AddQuestion.do")
	public ModelAndView addQuestion(EduQuestion eduQuestion,String paperId,HttpServletRequest request,ModelMap map){
		Map<String,Object> result = new HashMap<String,Object>();
		EduPaper eduPaper;
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("userinfo")!=null){
				EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
				eduQuestion.setUsername(info.getLoginAccount());
			}
			
			eduPaper = eduProjectService.selectEduPaperById(eduQuestion.getPaperId());
			result.put("eduPaper", eduPaper);
			eduQuestion.setCreateDate(DateUtil.getSystemTimeFormat("yyyy-MM-dd"));
			eduQuestion.setPaperId(eduPaper.getId());
			int id = eduProjectService.insertQuestion(eduQuestion);
			
			/**
			 * 保存选项
			 */
			for(String option:eduQuestion.getOption().split(",")){
				EduQuestionOptions eqo = new EduQuestionOptions();
				eqo.setQuestionId(id);
				eqo.setCreateDate(DateUtil.getSystemTimeFormat("yyyy-MM-dd"));
				eqo.setRank(eduQuestion.getRank());
				eqo.setContent(option);
				eqo.setUsername(eduQuestion.getUsername());
				eduProjectService.insertQuestionOptions(eqo);
			}
			map.put("paperId",paperId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  new ModelAndView("redirect:toUpdatePaper.htm?click=8");
	}
	
	/**
	 * 编辑问题页面
	 */
	@RequestMapping("toUpdateQuestion.htm")
	public String toUpdateQuestion(int qid,HttpServletRequest request){
		Map<String,Object> conditions = super.getCode(request);
		try {
			
			EduQuestion eq = eduProjectService.selectEduQuestionById(qid);
			conditions.put("questionId", eq.getId());
			PageObject pa = eduProjectService.selectEduQuestionOptionsListByQid(conditions, 0, Common.PAPER_Q_LIMIT);
			EduPaper equp = eduProjectService.selectEduPaperById(eq.getPaperId());
			request.setAttribute("equ", eq);
			request.setAttribute("paper", equp);
			request.setAttribute("oplist", pa.getObjects());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/projectQuestionModify";
	}
	@RequestMapping("UpdateQuestion.do")
	public @ResponseBody ModelAndView UpdateQuestion(EduQuestion eduQuestion,String paperId,String optionId,
			HttpServletRequest request,ModelMap map){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("userinfo")!=null){
				EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
				eduQuestion.setUsername(info.getLoginAccount());
			}
			//optionId顺序与opiont内容顺序一直 如果对应ID为空则说明为新添加的选项
			eduProjectService.updateQuestion(eduQuestion);
			String[] arrOPId = optionId.split(",");
			String[] arrOptxt = eduQuestion.getOption().split(",");
			if(arrOPId.length==arrOptxt.length){
				for(int i=0;i<arrOptxt.length;i++){
					EduQuestionOptions eqo = eduProjectService.selectEduQuestionOptionsById(Integer.parseInt(arrOPId[i]));
					eqo.setCreateDate(DateUtil.getSystemTimeFormat("yyyy-MM-dd"));
					eqo.setRank(eduQuestion.getRank());
					eqo.setContent(arrOptxt[i]);
					eqo.setUsername(eduQuestion.getUsername());
					eduProjectService.updateQuestionOptions(eqo);
				}
			}
		
			map.put("paperId",paperId);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  new ModelAndView("redirect:toUpdatePaper.htm?click=8");
	}
	
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
	
	/**
	 * 调查问卷预览页面
	 */
	@RequestMapping("toPaperPrepview.htm")
	public String toPreview(int paperId,HttpServletRequest request){
		Map<String,Object> conditions = super.getCode(request);
		//获取当前调查问卷
		try {
			EduPaper paper = eduProjectService.selectEduPaperById(paperId);
			//获取问题
			conditions.put("paperId", paper.getId());
			Map<Integer,Object> map = new HashMap<Integer,Object>();
			PageObject pgQuestion = eduProjectService.selectEduQuestionListByPapid(conditions, 0, Common.PAPER_Q_LIMIT);
			if(pgQuestion!=null&&pgQuestion.getObjects()!=null){
				for (EduQuestion eduQuestion:(List<EduQuestion>)pgQuestion.getObjects()) {
					conditions.clear();
					conditions.put("questionId", eduQuestion.getId());
					PageObject pgQuestionOption =eduProjectService.selectEduQuestionOptionsListByQid(conditions, 0, Common.PAPER_Q_LIMIT);
					if(pgQuestionOption!=null&&pgQuestionOption.getObjects()!=null){
						map.put(eduQuestion.getId(), pgQuestionOption.getObjects());
					}
				}
			}
			request.setAttribute("map", map);
			request.setAttribute("paper", paper);
			request.setAttribute("pgq", pgQuestion.getObjects());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/paperPreview";
	}
	
	/**
	 * 删除试题
	 * @param paperId
	 * @return
	 */
	@RequestMapping("delQuestion.do")
	public @ResponseBody Map<String, Object> delPaper(int qId){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			EduQuestion eduQuestion=new EduQuestion();
			eduQuestion.setId(qId);
			eduQuestion.setSta(Common.PAPER_Q_STA_DELETE);
			if(eduProjectService.updateQuestion(eduQuestion)){
				DataUtil.setOk(result);
			}
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
//		return "redirect:toProjectListPage.htm";
		return result;
	}
	
	/**
	 * 调研问卷问题导入 跳转页面
	 * 
	 * @author cl
	 * @return
	 */
	@RequestMapping("toUploadQuestions.htm")
	public String toUploadPage(String paperId,HttpServletRequest request) {
		request.setAttribute("paperId", paperId);
		return "project/toUploadQuestions";
	}
	
	/**
	 * 管理员: 导出调查问卷试题模板
	 * @param request
	 * @param path
	 */
	@RequestMapping("downPaperQuestion.do")
	public void downTeachersTemplate(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			String path = request.getRealPath("/") + "template"
					+ File.separator + "import_paper_questions.xls";
			FileInputStream io = new FileInputStream(path);
			// 创建 excel
			Workbook wb = new HSSFWorkbook(io);
			exportExcelFromTemplet(request, response, wb, "import_paper_questions","xls");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("导出调查问卷试题模错误:" + e);
		}
	}
	/**
	 *	检测上传的调查问卷试题 
	 */
	@RequestMapping("/checkUploadPaperQuestion.do")
	public @ResponseBody Map<String,Object> checkUploadSchool(HttpServletRequest request,String path){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			result = sysService.parseExcel(projectPath + path, "question", null);
			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 提交调研问题
	 */
	@RequestMapping("/submitUploadPaperQuestion.do")
	public @ResponseBody Map<String,Object> submitUploadPaperQuestion(HttpServletRequest request,String path,String paperId){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("account", super.getAccount(request));
		params.put("paperId", paperId);
		HttpSession session = request.getSession();
		if(session.getAttribute("userinfo")!=null){
			EduUserActivty info=(EduUserActivty)session.getAttribute("userinfo");
			params.put("uName", info.getLoginAccount());
		}
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		path = projectPath + ApplicationProperties.getPropertyValue("upload_file_path")+path.replace("/",File.separator);
		try {
			result = sysService.intoDB(path, "question", super.getAccount(request), params);

			DataUtil.setOk(result);
		} catch (Exception e) {
			DataUtil.setFail(result);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 调研问卷答题情况汇总
	 */
	@RequestMapping("/questionSurverSummaryList.do")
	public @ResponseBody Map<String,Object> questionSurverSummaryList(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();

		String  model= StringUtils.isEmpty(request.getParameter("model"))?null:request.getParameter("model");
		String  project = StringUtils.isEmpty(request.getParameter("project"))?null:request.getParameter("project");
		String  areaId = StringUtils.isEmpty(request.getParameter("areaId"))?null:request.getParameter("areaId");
		String  gender = StringUtils.isEmpty(request.getParameter("gender"))?null:request.getParameter("gender");
		String  subs   = StringUtils.isEmpty(request.getParameter("subs"))?null:request.getParameter("subs");
		String  ageStart = StringUtils.isEmpty(request.getParameter("ageStart"))?null:request.getParameter("ageStart");
		String  ageEnd = StringUtils.isEmpty(request.getParameter("ageEnd"))?null:request.getParameter("ageEnd");
		String  areaType = StringUtils.isEmpty(request.getParameter("areaType"))?null:request.getParameter("areaType");
		
		if("provinceId".equals(areaType)){
			params.put("provinceId", areaId);
		}else if("cityId".equals(areaType)){
			params.put("cityId", areaId);
		}else if("districtId".equals(areaType)){
			params.put("districtId", areaId);
		}else if("schoolId".equals(areaType)){
			params.put("schoolId", areaId);
		}
		if(areaId!=null || gender!=null ||subs!= null || ageStart!=null || ageEnd != null){
			params.put("needUser", "true");
		}
		params.put("modelId",model);
		params.put("projectId",project);
		params.put("areaId",areaId);
		params.put("gender",gender);
		params.put("subs",subs);
		params.put("ageStart",ageStart);
		params.put("ageEnd",ageEnd);
		
		PageObject page = sysService.questionSurverSummaryList(params);
//		result.put("rows", page.getObjects());
		List<EduQustionSummary> list = (List<EduQustionSummary>)page.getObjects();
		int arr[] = new int[100];
		if(list.size() > 0 ){
			int total = 0;
			int n = 0;
			String title = list.get(0).getTitle();
			for(int i = 0 ; i < list.size() ; i++){
				if(!title.equals(list.get(i).getTitle())){
					arr[n++] = total;
					title = list.get(i).getTitle();
					total = 0;
				}
				total += list.get(i).getPickNum();
			}
			arr[n] = total;
			
			int m = 0;
			title = list.get(0).getTitle();
			for(int i = 0 ; i < list.size() ; i++){
				if(!title.equals(list.get(i).getTitle())){
					m++;
					title = list.get(i).getTitle();
				}
				String res = String.valueOf(((double)list.get(i).getPickNum() / arr[m]) * 100);
				BigDecimal   b2   =   new   BigDecimal(Float.parseFloat(res)); 
				list.get(i).setRate(String.valueOf(b2.setScale(1,   BigDecimal.ROUND_HALF_UP).floatValue()));
			}
		}
		
		
		result.put("rows", list);
		result.put("totalNum", arr[0]);
		return result;
	}
}
 