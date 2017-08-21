package project.furtheredu.edumanage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.common.Common;
import project.edupm.projectmanage.dao.IEduProjectReadDAO;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.service.IEduProjectService;
import project.furtheredu.certificate.pojo.EduDiploma;
import project.furtheredu.edumanage.dao.IEduManageReadDao;
import project.furtheredu.edumanage.dao.IEduManageWriteDao;
import project.furtheredu.edumanage.pojo.EduSignet;
import project.furtheredu.edumanage.pojo.EduTearcherAssess;
import project.furtheredu.edumanage.pojo.TeacherCertificateExportActivity;
import project.furtheredu.edumanage.pojo.TeacherInfoActivity;
import project.furtheredu.edumanage.pojo.TeacherProActivity;
import project.furtheredu.edumanage.service.IEduManageService;
import project.system.dao.ISysReadDAO;
import project.teacher.teachermanage.pojo.EduProjectCommentTeacher;
import framelib.service.AbsService;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

@SuppressWarnings("unchecked")
public class EduManageServiceImpl extends AbsService implements
		IEduManageService {

	private static final Logger log = Logger
			.getLogger(EduManageServiceImpl.class);

	@Autowired
	@Qualifier("eduManageReadDao")
	IEduManageReadDao eduManageReadDao;

	@Autowired
	@Qualifier("eduManageWriteDao")
	IEduManageWriteDao eduManageWriteDao;

	@Autowired
	@Qualifier("eduProjectReadDAO")
	IEduProjectReadDAO eduProjectReadDAO;

	@Autowired
	@Qualifier("sysReadDAO")
	ISysReadDAO sysReadDAO;
	
	@Autowired
	@Qualifier("eduProjectService")
	IEduProjectService eduProjectService;

	@Override
	public Integer modifyAuditEduManageBatch(String data, String account,
			boolean isPass, String memo) {
		String[] idArray = data.split(",");
		for (String id : idArray) {
			if (isPass) {
				eduManageWriteDao.updateEduManageStatus(id, account,
						Common.COMMON_AUDIT_PASS, memo);
			} else {
				eduManageWriteDao.updateEduManageStatus(id, account,
						Common.COMMON_AUDIT_UNPASS, memo);
			}
		}
		return 1;
	}

	@Override
	public Integer modifyAuditEduManageBatch(String data, String account,
			String memo) {
		String[] idArray = data.split(",");
		for (String id : idArray) {
			eduManageWriteDao.updateEduManageStatus(id, account,
					Common.COMMON_AUDIT_DELETE, memo);
		}
		return 1;
	}

	@Override
	public List queryEvaluationInfo(Integer projectId, Integer orgId)
			throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("projectId", projectId);
		paramMap.put("orgId", orgId);
		return eduManageReadDao.selectEvaluationInfo(paramMap);
	}

	@Override
	public List queryEvaluationInfo(Integer projectId) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("projectId", projectId);
		paramMap.put("orgId", null);
		return eduManageReadDao.selectEvaluationInfo(paramMap);
	}

	@Override
	public List queryTeacherCommentActivityByCondition(Integer teacherId)
			throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("teacherId", teacherId);
		return eduManageReadDao
				.selectteacherCommentActivityByCondition(paramMap);
	}

	@Override
	public PageObject queryEvaluationListPage(Map<String, Object> paramMap,
			int startPage, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(eduManageReadDao.selectEvaluationCountByCondition(paramMap));
		PageParser.getPageObject(
				PageParser.getPageInfo(startPage, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<Object> list = eduManageReadDao
				.selectEvaluationListByCondition(paramMap);
		po.setObjects(list);
		return po;
	}

	@Override
	public PageObject queryManageListPage(Map<String, Object> paramMap,
			int startPage, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(eduManageReadDao.selectManageCountByCondition(paramMap));
		PageParser.getPageObject(
				PageParser.getPageInfo(startPage, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<Object> list = eduManageReadDao
				.selectManageListByCondition(paramMap);
		po.setObjects(list);
		return po;
	}

	@Override
	public PageObject queryManageGroupListPage(Map<String, Object> paramMap,
			int startPage, int pageSize) throws Exception {
		PageObject po = new PageObject();
		po.setCount(eduManageReadDao
				.selectManageCountGroupByYearCondition(paramMap));
		PageParser.getPageObject(
				PageParser.getPageInfo(startPage, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<Object> list = eduManageReadDao
				.selectManageListGroupByYearCondition(paramMap);
		po.setObjects(list);
		return po;
	}

	// @Override
	// public Integer saveTagetInfo(EduTargetByYear target) throws Exception {
	// return eduTagetWriteDao.insertTagetInfo(target);
	// }
	//
	// @Override
	// public EduTargetByYear queryTargetInfoById(Integer id) throws Exception {
	// return eduTagetReadDao.selectTargetByKey(id);
	// }
	//
	// @Override
	// public Integer updateTaget(EduTargetByYear target) throws Exception{
	// return eduTagetWriteDao.updateTarget(target);
	// }
	//
	@Override
	public Integer deleteManageById(String ids) throws Exception {
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			eduManageWriteDao.deleteManageById(Integer.valueOf(id));
		}
		return 1;
	}

	/**
	 * 继教学分查询/年度证书打印
	 * 
	 * @author cl create date 2014-4-8
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTearcherAssess> queryTeacherAssess(
			Map<String, Object> paramMap) throws Exception {
		//教师年度学分查询
		List<EduTearcherAssess> list = eduManageReadDao.selectTeacherAssessList(paramMap);

		// 省年度考核设置信息
		Map<String, Object> paramMapPr = new HashMap<String, Object>();
		paramMapPr.put("provinceId", paramMap.get("provinceId"));
		paramMapPr.put("cityId", paramMap.get("cityId"));
		paramMapPr.put("districtId", paramMap.get("districtId"));
		paramMapPr.put("schoolId", paramMap.get("schoolId"));
		List<EduTearcherAssess> listPr = eduManageReadDao.selectTeacherAssessTargetList(paramMapPr);

		// 依次判断角色信息是否达标 省--市--区--校
		for (int i = 0; i < list.size(); i++) {
			String isAssess = "1";

			if (listPr != null && listPr.size() > 0) {
				for (int j = 0; j < listPr.size(); j++) {
					if (list.get(i).getYear().intValue() == listPr.get(j)
							.getYear().intValue()) {
						if (// (list.get(i).getTeacherClassPeriod().floatValue()
							// < listPr.get(j).getClassPeriod().floatValue())||
						(list.get(i).getTeacherClassScore().floatValue() < listPr.get(j).getClassScore().floatValue())) {
							isAssess = "0";
						}
					}
				}
			}

			list.get(i).setIsAssess(isAssess);
		}

		return list;
	}

	/**
	 * 年度考核信息
	 * 
	 * @author cl create date 2014-4-8
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTearcherAssess> queryTeacherAssessTarget(
			Map<String, Object> paramMap) throws Exception {
		return eduManageReadDao.selectTeacherAssessTargetList(paramMap);
	}

	/**
	 * 继教考核详细
	 * 
	 * @author cl create date 2014-4-8
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduTearcherAssess> queryTeacherAssessInfo(
			Map<String, Object> paramMap) throws Exception {
		return eduManageReadDao.selectTeacherAssessInfo(paramMap);
	}

	public List<EduTearcherAssess> queryTeacherAssessNoTrainInfo(
			Map<String, Object> paramMap) throws Exception {
		return eduManageReadDao.selectTeacherAssessNoTrainInfo(paramMap);
	}

	@Override
	public EduDiploma queryDeploma(Map<String, Object> paramMap)
			throws Exception {
		EduDiploma diploma = eduManageReadDao.queryDeplomaByProjectInfo(paramMap);
		if (diploma == null) {
			return null;
		}
		paramMap.put("period", diploma.getTeacherClassPeriod());
		EduProjectCommentTeacher eduProTeaInfo = new EduProjectCommentTeacher();
		eduProTeaInfo.setProjectId(Integer.parseInt(paramMap.get("projectId").toString()));
		if(paramMap.get("teacherId") !=null && !paramMap.get("teacherId").equals("")){
			eduProTeaInfo.setTeacherId(Integer.parseInt(paramMap.get("teacherId").toString()));
		}
		EduProject project = eduProjectReadDAO.selectBaseInfoById(diploma.getProjectId());
		String content = diploma.getContent();
		
		if (content != null && content.length() > 0) {			
			
			//项目证书编码
			if(paramMap.get("type").equals("2")){
				content = content.replace(content.substring(content.indexOf("$"),content.lastIndexOf("$")+1), diploma.getProjectCertificateCode());
			}
			//学时证书编码
			else if(paramMap.get("type").equals("3")){
				content = content.replace(content.substring(content.indexOf("$"),content.lastIndexOf("$")+1), diploma.getPeriodCertificateCode());
			}
			
			content = content.replace("{projectName}", project.getProjectName());
			content = content.replace("{startDate}", project.getStartDate());
			content = content.replace("{endDate}", project.getEndDate());
		}
		if (paramMap != null && paramMap.size() > 0) {
			for (String key : paramMap.keySet()) {
				if (paramMap.get(key) == null) {
					continue;
				}
				content = content.replace("{" + key + "}", paramMap.get(key)
						.toString());
			}
		}
		diploma.setContent(content);
		return diploma;
	}

	/**
	 * 教师项目证书打印--查询已结束或已关闭的项目
	 * 
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TeacherProActivity> queryTeacherProByStatus(
			Map<String, Object> paramMap) throws Exception {

		List<TeacherProActivity> list1 = new ArrayList<TeacherProActivity>();
		// List<TeacherProActivity> list2 = new ArrayList<TeacherProActivity>();

		// 培训类
		list1 = eduManageReadDao.selectTeacherProByStatusTrain(paramMap);
		// 非培训类
		// list2 = eduManageReadDao.selectTeacherProByStatusNoTrain(paramMap);

		// list1.addAll(list2);

		return list1;
	}

	/**
	 * 实施/管理项目证书打印--查询已结束或已关闭的项目
	 * 
	 * @author 曉
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TeacherProActivity> queryProByStatus(
			Map<String, Object> paramMap) throws Exception {
		List<TeacherProActivity> list1 = new ArrayList<TeacherProActivity>();
		// List<TeacherProActivity> list2 = new ArrayList<TeacherProActivity>();

		// 培训类
		list1 = eduManageReadDao.selectSSProByStatusTrain(paramMap);
		/*
		 * if(list1.size()>0){ for(TeacherProActivity activity1 : list1){
		 * activity1.setType(1); } }
		 */

		// 非培训类
		/*
		 * list2 = eduManageReadDao.selectSSProByStatusNoTrain(paramMap);
		 * if(list1.size()>0){ for(TeacherProActivity activity2 : list2){
		 * activity2.setType(0); } }
		 * 
		 * list1.addAll(list2);
		 */

		return list1;
	}

	public PageObject queryProByStatusPage(Map<String, Object> paramMap,
			int startIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = eduManageReadDao.selectSSProByStatusTrainCount(paramMap);
		po.setCount(count);
		PageParser
				.getPageObject(
						PageParser.getPageInfo(startIndex, pageSize,
								po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<TeacherProActivity> list1 = new ArrayList<TeacherProActivity>();
		list1 = eduManageReadDao.selectSSProByStatusTrain(paramMap);
		po.setObjects(list1);
		return po;
	}

	@Override
	public PageObject queryTeacherByProId(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();

		// 培训类
		// if(type == 1){
		int count = eduManageReadDao.selectTeacherByProIdCount_Train(paramMap);
		po.setCount(count);

		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<TeacherInfoActivity> list = eduManageReadDao
				.selectTeacherByProId_Train(paramMap);
		if (list != null && list.size() != 0) {
			po.setObjects(list);
			// }
			/*
			 * } else if(type == 0){// 非培训类 int count =
			 * eduManageReadDao.selectTeacherByProIdCount_NoTrain(paramMap);
			 * po.setCount(count);
			 * 
			 * PageParser.getPageObject(PageParser.getPageInfo(pageIndex,
			 * pageSize, po.getCount()), po); paramMap.put("startIndex",
			 * po.getStartIndex()); paramMap.put("endIndex", pageSize);
			 * 
			 * List<TeacherInfoActivity> list =
			 * eduManageReadDao.selectTeacherByProId_NOTrain(paramMap);
			 * if(list!= null && list.size()!= 0){ po.setObjects(list); }
			 */
		}
		return po;
	}
	

	@Override
	public PageObject queryTeacherCertificate(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();

		// 培训类
		// if(type == 1){
		int count = eduManageReadDao.selectTeacherCount_Train(paramMap);
		po.setCount(count);

		PageParser.getPageObject(
				PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);

		List<TeacherInfoActivity> list = eduManageReadDao
				.selectTeacher_Train(paramMap);
		if (list != null && list.size() != 0) {
			po.setObjects(list);
			
		}
		return po;
	}

	@Override
	public List<TeacherCertificateExportActivity> queryTeacherCertificateActivityListNoPage(
			Map<String, Object> paramMap) throws Exception {
		return eduManageReadDao.selectTeacherCertificateActivetyListByConditionNoPage(paramMap);
	}
	
	@Override
	public Integer addSignet(EduSignet pojo) throws Exception {
		return eduManageWriteDao.insertSignet(pojo);
	}

	@Override
	public Integer addSignetNew(EduSignet pojo) throws Exception {
		return eduManageWriteDao.insertSignetNew(pojo);
	}

	@Override
	public Integer modifySignet(EduSignet pojo) throws Exception {
		return eduManageWriteDao.updateSignet(pojo);
	}

	@Override
	public List<EduSignet> querySignetList(Map<String, Object> paramMap)
			throws Exception {
		return eduManageReadDao.selectSignetList(paramMap);
	}

	@Override
	public List<EduSignet> querySignetListByDictAndRole(
			Map<String, Object> paramMap) throws Exception {
		return eduManageReadDao.selectSignetListByDictAndRole(paramMap);
	}

	public EduDiploma queryTeacherCertificateInfo(Map<String, Object> param)
			throws Exception {
		// TODO Auto-generated method stub
		return eduManageReadDao.queryDeplomaByProjectInfo(param);
	}

	@Override
	public Integer insertYearCertificate(Map<String, Object> param)
			throws Exception {
		return eduManageWriteDao.insertYearCertificate(param);
	}

	@Override
	public List<EduDiploma> selectYearDiploma(Map<String, Object> condition) {
		return eduManageReadDao.selectYearDiploma(condition);
	}

	@Override
	public boolean deleteCertificateById(Map<String, Object> condition) {
		return eduManageWriteDao.deleteCertificateById(condition);
	}

	@Override
	public int updateYearCertificate(Map<String, Object> condition) {
		return eduManageWriteDao.updateCertificateById(condition);
	}

}
