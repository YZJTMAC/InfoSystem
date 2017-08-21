package project.edupm.teachermanage.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.edupm.projectmanage.dao.IEduProjectReadDAO;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduTeacherImportHistory;
import project.edupm.projectmanage.pojo.EduTeacherImportRecord;
import project.edupm.teachermanage.dao.IEduTeacherReadDAOIF;
import project.edupm.teachermanage.dao.IEduTeacherWriteDAOIF;
import project.edupm.teachermanage.dto.EduTeacherImportDTO;
import project.edupm.teachermanage.pojo.EduTeacherImportPOJO;
import project.edupm.teachermanage.pojo.TeacherProScorePOJO;
import project.edupm.teachermanage.service.IEduTeacherServiceIF;
import project.organization.pojo.OrgProTeacherActivity;
import framelib.service.AbsService;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

/**
 * Title: TeacherManageServiceImpl
 * Description: 教师管理service接口实现
 * 
 * @Create_by: zhangxiaoqi
 * @Create_date:2014-04-01
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 */
public class EduTeacherServiceImpl extends AbsService implements IEduTeacherServiceIF{

	//private static final Logger log = Logger.getLogger(EduTeacherServiceImpl.class);

	@Autowired
	@Qualifier("eduTeacherReadDAO")
	IEduTeacherReadDAOIF teacherReadDAO;
	
	@Autowired
	@Qualifier("eduTeacherWriteDAO")
	IEduTeacherWriteDAOIF teacherWriteDAO;

	@Autowired
	@Qualifier("eduProjectReadDAO")
	IEduProjectReadDAO eduProjectReadDAO;
	
	/**
	 * 管理员: 查询教师成绩列表
	 */
	public PageObject selectTeacherProScoreList(Map<String, Object> paramMap, int pageIndex, int pageSize) throws Exception {
		// 包装分页类
		PageObject po = new PageObject();
		// 查询记录条数
		int count = teacherReadDAO.selectTeacherProScoreListCount(paramMap);
		po.setCount(count);
		
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<EduProject> list = teacherReadDAO.selectTeacherScoreList(paramMap);
		
		po.setObjects(list);
		
		return po;
	}


	/**
	 * 管理员: 查询教师成绩详情
	 */
	public PageObject selectTeacherProScoreInfo(Map<String, Object> paramMap, int pageIndex, int pageSize) throws Exception {
		// 包装分页类
		PageObject po = new PageObject();
		// 查询记录条数
		int count = teacherReadDAO.selectTeacherProScoreInfoCount(paramMap);
		po.setCount(count);
		
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<OrgProTeacherActivity> list = teacherReadDAO.selectTeacherProScoreInfo(paramMap);
		if(list!= null && list.size()!= 0){
			po.setObjects(list);
		} else {
			po.setCount(0);
		}
		return po;
	}


	@Override
	public PageObject queryImportTeacherRecord(int startIndex, int pageSize,
			Map<String, Object> param) throws Exception {
		PageObject po = new PageObject();
		po.setCount(eduProjectReadDAO.coutImportTeacherRecord(param));
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		param.put("startIndex", po.getStartIndex());
		param.put("endIndex", pageSize);
		List<EduTeacherImportRecord> records = eduProjectReadDAO.selectTeacherImprotRecord(param);
		po.setObjects(records);
		return po;
	}


	@Override
	public Map<String,Object> queryHistoryAndRecordInfo(int id, String historyType,
			String account,int startIndex,int pageSize) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		List<EduTeacherImportDTO> dtos = new ArrayList<EduTeacherImportDTO>();
		Set<Integer> years = new HashSet<Integer>();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("account", account);
		params.put("historyType", historyType);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 查询倒入记录
		List<EduTeacherImportHistory> histories = teacherReadDAO.selectTeacherImportRecordNoPage(params);
		for(EduTeacherImportHistory h:histories){
			years.add(h.getOptionYear());
			if(h.getId().intValue() == id){
				map.put("year", h.getOptionYear());
				map.put("optDate", sdf2.format(h.getCreateDate()));
				map.put("fileNames", h.getImportFileName());
				map.put("okCount", h.getImportSuccessCount());
				map.put("failCount", h.getImortFailCount());
				map.put("url", h.getImportFailUrl());
			}
		}
		for(EduTeacherImportHistory h:histories){
			if(h.getOptionYear().equals(map.get("year"))){
				EduTeacherImportDTO dto = new EduTeacherImportDTO();
				dto.setDateVal(sdf2.format(h.getCreateDate()));
				dto.setOptDate(sdf.format(h.getCreateDate()));
				dto.setYear(h.getOptionYear());
				dtos.add(dto);
			}
			
		}
		map.put("years", years);
		map.put("dtos", dtos);
		
		Map<String,Object> qryParam = new HashMap<String,Object>();
		qryParam.put("date", map.get("optDate"));
		qryParam.put("historyType", historyType);
		PageObject po = queryTIR(qryParam, startIndex, pageSize);
		map.put("rows", po.getObjects());
		map.put("total", po.getCount());
		map.put("pageSize", po.getPagesize());
		map.put("pages", po.getPages());
		map.put("currentPage", po.getCurrentPage());
		map.put("pageNumbers", po.getPageNumbers());
		map.put("startIndex", po.getStartIndex());
		
		return map;
	}


	/**
	 *  管理员: 查询教师成绩详情列表前判断教师是否已有成绩
	 */
	@Override
	public int queryCountTeacherScore(String projectId) throws Exception {
		return teacherReadDAO.selectCountTeacherScore(projectId);
	}
	
	/**
	 * @param params :key:date,account
	 */
	public PageObject queryTIR(Map<String,Object> params,int startIndex,int pageSize) throws Exception{
		PageObject po = new PageObject();
		po.setCount(teacherReadDAO.countTIR(params));
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		params.put("startIndex", po.getStartIndex());
		params.put("endIndex", pageSize);
		List<EduTeacherImportPOJO> pojos = teacherReadDAO.selectTeacherImportReacords(params);
		po.setObjects(pojos);
		return po;
	}
	
	public Map<String,Object> queryTIR(int startIndex, String historyType, int pageSize,String date,String account) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("date", date);
		params.put("account", account);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		EduTeacherImportHistory history =  teacherReadDAO.selectTIRByDate(params);
		map.put("year", history.getOptionYear());
		map.put("optDate", sdf2.format(history.getCreateDate()));
		map.put("fileNames", history.getImportFileName());
		map.put("okCount", history.getImportSuccessCount());
		map.put("failCount", history.getImortFailCount());
		map.put("url", history.getImportFailUrl());
		params.put("historyType", historyType);
		
		PageObject po = queryTIR(params, startIndex, pageSize);
		
		map.put("rows", po.getObjects());
		map.put("total", po.getCount());
		map.put("pageSize", po.getPagesize());
		map.put("pages", po.getPages());
		map.put("currentPage", po.getCurrentPage());
		map.put("pageNumbers", po.getPageNumbers());
		map.put("startIndex", po.getStartIndex());
		
		return map;
	}


	@Override
	public List<EduTeacherImportDTO> queryDateByYear(String year) throws Exception {
		List<EduTeacherImportDTO> dates = new ArrayList<EduTeacherImportDTO>();
		List<String> list = teacherReadDAO.selectDateByYear(year);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		for(String str:list){
			EduTeacherImportDTO dto = new EduTeacherImportDTO();
			Date d = sdf3.parse(str);
			
			dto.setDateVal(sdf2.format(d));
			dto.setOptDate(sdf.format(d));
			dates.add(dto);
		}
		
		return dates;
	}


	/**
	 * 查看导入成绩
	 */
	@Override
	public List<TeacherProScorePOJO> queryImportScoreInfo(int projectId) throws Exception {
		List<TeacherProScorePOJO> list =  teacherReadDAO.selectInportSoreInfo(projectId);
		if(list!=null && list.size()>0){
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("projectId", projectId);
			for(TeacherProScorePOJO pojo : list){
				/*int orgId = pojo.getOrgId();
				paramMap.put("orgId", orgId);*/
				TeacherProScorePOJO dto = new TeacherProScorePOJO();
				// 查询报名人数和学习人数
				dto = teacherReadDAO.selectCountApplyAndStudyNum(paramMap);
				pojo.setApplyNum(dto.getApplyNum());
				pojo.setStudyNum(dto.getStudyNum());
				// 查询各个成绩段人数
				dto = teacherReadDAO.selectTeacherScores(paramMap);
				pojo.setScoreA(dto.getScoreA());
				pojo.setScoreB(dto.getScoreB());
				pojo.setScoreC(dto.getScoreC());
				pojo.setScoreD(dto.getScoreD());
				pojo.setScoreE(dto.getScoreE());
			}
		}
		return list;
	}


	@Override
	public List<Map<String, Object>> queryTeacherByProId(int projectId) throws Exception {
		
		return teacherReadDAO.selectTeacherInfoByProjectId(projectId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
