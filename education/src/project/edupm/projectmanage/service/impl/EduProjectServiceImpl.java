package project.edupm.projectmanage.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.multipart.MultipartFile;

import project.common.Common;
import project.dictionary.dao.IDictionaryReadDao;
import project.edupm.projectclass.dao.IProjectClassReadDAO;
import project.edupm.projectclass.pojo.EduProjectClass;
import project.edupm.projectmanage.dao.IEduProjectReadDAO;
import project.edupm.projectmanage.dao.IEduProjectWriteDAO;
import project.edupm.projectmanage.dto.EduProjectDTO;
import project.edupm.projectmanage.dto.ProjectClassesDTO;
import project.edupm.projectmanage.pojo.CanSign;
import project.edupm.projectmanage.pojo.EduModel;
import project.edupm.projectmanage.pojo.EduModelPOJO;
import project.edupm.projectmanage.pojo.EduOrgProjectStatus;
import project.edupm.projectmanage.pojo.EduPaper;
import project.edupm.projectmanage.pojo.EduProject;
import project.edupm.projectmanage.pojo.EduProjectAllocateByArea;
import project.edupm.projectmanage.pojo.EduProjectAudit;
import project.edupm.projectmanage.pojo.EduProjectAuditPOJO;
import project.edupm.projectmanage.pojo.EduProjectForAudit;
import project.edupm.projectmanage.pojo.EduProjectProcess;
import project.edupm.projectmanage.pojo.EduProjectTrainTarget;
import project.edupm.projectmanage.pojo.EduQuestion;
import project.edupm.projectmanage.pojo.EduQuestionOptions;
import project.edupm.projectmanage.pojo.EduResponse;
import project.edupm.projectmanage.pojo.EduResponseQuestion;
import project.edupm.projectmanage.pojo.EduTeacherAudit;
import project.edupm.projectmanage.pojo.EduTeacherForReport;
import project.edupm.projectmanage.pojo.EduTeacherImportHistory;
import project.edupm.projectmanage.pojo.EduTeacherProject;
import project.edupm.projectmanage.pojo.ProjectReportInfo;
import project.edupm.projectmanage.pojo.SsOrgProjectAuditActivity;
import project.edupm.projectmanage.service.IEduProjectService;
import project.organization.dao.IOrganizationReadDAOIF;
import project.organization.dao.IOrganizationWriteDAOIF;
import project.organization.pojo.OrgProTeacherActivity;
import project.organization.pojo.Organization;
import project.organization.pojo.OrganizationProject;
import project.person.dao.IUserReadDAO;
import project.person.dao.IUserWriteDao;
import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;
import project.system.dao.ISysReadDAO;
import project.system.dao.ISysWriteDAO;
import project.system.pojo.EduSchool;
import project.system.pojo.SysArea;
import project.system.pojo.SysDictionary;
import project.system.service.ISysService;
import project.teacher.teacherProject.pojo.EduProjectPojo;
import project.teacher.teachermanage.dao.ITeacherReadDao;
import project.teacher.teachermanage.dao.ITeacherWriteDao;
import project.teacher.teachermanage.dto.TeacherDTO;
import project.teacher.teachermanage.pojo.EduProjectCommentTeacher;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherJob;
import project.teacher.teachermanage.pojo.EduTeacherVersionPOJO;
import project.util.DataUtil;
import project.util.ExcelUtil;
import project.util.RandomNumberUtil;
import framelib.utils.DateUtil;
import framelib.utils.FileUtils;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;
/**
 * @author it
 *
 */
@SuppressWarnings("unchecked")
public class EduProjectServiceImpl implements IEduProjectService {
	
	private static final Logger log = Logger.getLogger(EduProjectServiceImpl.class);

	private static final List<EduProject> IEduProjectReadDAO = null;
	
	@Autowired
	@Qualifier("eduProjectWriteDAO")
	IEduProjectWriteDAO proWriteDao;
	
	
	
	@Autowired
	@Qualifier("eduProjectReadDAO")
	IEduProjectReadDAO eduProjectReadDAO;
	
	@Autowired
	@Qualifier("organizationReadDAO")
	IOrganizationReadDAOIF orgReadDAO;
	
	@Autowired
	@Qualifier("eduProjectClassReadDAO")
	IProjectClassReadDAO classReadDAO;
	
	
	@Autowired
	@Qualifier("sysReadDAO")
	ISysReadDAO sysReadDAO; 
	
	@Autowired
	@Qualifier("userWriteDao")
	IUserWriteDao userWriteDao;
	
	@Autowired
	@Qualifier("teacherWriteDao")
	ITeacherWriteDao teacherWriteDao;
	
	@Autowired
	@Qualifier("teacherReadDao")
	ITeacherReadDao teacherReadDao;
	
	@Autowired
	@Qualifier("sysService")
	ISysService sysService;
	
	@Autowired
	@Qualifier("userReadDao")
	IUserReadDAO userReadDao;
	
	@Autowired
	@Qualifier("sysWriteDAO")
	ISysWriteDAO sysWriteDAO;
	
	@Autowired
	@Qualifier("organizationWriteDAO")
	IOrganizationWriteDAOIF orgWriteDAO;

	@Autowired
	@Qualifier("dictionaryReadDao")
	IDictionaryReadDao dictionaryReadDao; 
	

	/**
	 * 创建项目
	 * @author zhangBo
	 * @create_date 2014年3月28日
	 */
	@Override
	public boolean saveProject(EduProjectDTO dto,List<MultipartFile> files,String path) throws Exception {
		String attechement = "";
		String names = "";
		
		String sid = dto.getTrainScopeId();
		SysArea area = sysReadDAO.selectAreaByCode(sid);
		
		//下面是项目编码的生成规则
				/*二、项目编码（共14位）
				编制规则：地区代码（6位）+年份代码（2位）+培训级别代码（2位）+项目类型代码（2位）+项目序号（2位）
				编码示例：GP153500000101
				编码说明： 
				1. 培训级别有六类，国家级培训（GP）、省级培训（SP）、地市级培训（DP）、区县级培训（XP）、校本培训（XB）、其它培训（OP）；
				2. 年份代码按年份编排，15代表2015年，以后年份依次顺延；
				3. 地区代码以全国统一地区编码为准，例如350000代表福建省、350100代表福州、350102代表鼓楼区；
				4. 项目类型代码，按照信息系统中项目类型依次排序，01-99；
				5. 版块序号，从01-99系统自动排序。*/
		
		String projectScopeLevel;//培训级别
		if(dto.getProjectScopeId() == 1){
			projectScopeLevel = "GP";//国培项目
		}
		else if(dto.getProjectScopeId() == 2){
			projectScopeLevel = "SP";//省级培训项目
		}
		else if(dto.getProjectScopeId() == 3){
			projectScopeLevel = "DP";//地市级培训项目
		}
		else if(dto.getProjectScopeId() == 4){
			projectScopeLevel = "XP";//区县级培训项目
		}
		else if(dto.getProjectScopeId() == 5){
			projectScopeLevel = "XB";//校本培训项目
		}
		else{
			projectScopeLevel = "OP";//其它
		}
		
		Map<String,Object> dictionaryMap = new HashMap<String, Object>();
		dictionaryMap.put("dictionaryName", dto.getProjectPropertyName());//字典名称
		dictionaryMap.put("dictionaryId", dto.getProjectPropertyId());//字典Id
		dictionaryMap.put("status", 1);//状态		
		//查询字典信息
		SysDictionary sysDictionary = dictionaryReadDao.selectSysDictionaryInfo(dictionaryMap);
		String dictionaryCode = sysDictionary.getDictionaryCode();
		
		Map<String,Object> projectMap = new HashMap<String, Object>();
		projectMap.put("year", dto.getYear());//培训年度
		projectMap.put("projectScopeId", dto.getProjectScopeId());//项目性质
		projectMap.put("projectPropertyId", dto.getProjectPropertyId());//培训类型
		projectMap.put("trainScopeId", dto.getTrainScopeId());//培训范围
		//根据新增项目的培训年度、项目性质、培训类型、培训范围获取相同的项目信息，在项目最后加1,01-99
		EduProjectPojo projectInfo = eduProjectReadDAO.selectprojectInfo(projectMap);
		String lastNum = "01";
		DecimalFormat df = new DecimalFormat("00");
		if(projectInfo != null && !"".equals(projectInfo)){
			lastNum = projectInfo.getProjectNo().substring(projectInfo.getProjectNo().length()-2,projectInfo.getProjectNo().length());
			lastNum = df.format((Integer.parseInt(lastNum) + 1));
		}
		String lastYear = dto.getYear()+"";
		//编制规则：地区代码（6位）+年份代码（2位）+培训级别代码（2位）+项目类型代码（2位）+项目序号（2位）
		String projectNo = area.getAreaCode() +lastYear.substring(lastYear.length()-2,lastYear.length()) 
		           +projectScopeLevel + dictionaryCode + lastNum;
		//把项目编码保存进去
		dto.setProjectNo(projectNo);
		
		//更正字段意义：表示创建者所属区域，非培训范围区域
		/*if(area.getType().equals("0")){
			dto.setPid(area.getId());
			dto.setCid(0);
			dto.setDid(0);
		}else if(area.getType().equals("1")){
			dto.setPid(Integer.parseInt(area.getUpLvCode()));
			dto.setCid(area.getId());
			dto.setDid(0);
		}else{
			dto.setDid(area.getId());
			dto.setCid(Integer.parseInt(area.getUpLvCode()));
			dto.setPid(Integer.parseInt(sysReadDAO.selectAreaByCode(area.getUpLvCode()).getUpLvCode()));
		}*/
		
		/*if(files.size()>0 && files.get(0).getSize() >0){
			path = path+dto.getProjectNo()+File.separator;
			path = path+File.separator;
			String projectNO = dto.getProjectNo();
			for(MultipartFile file:files){
				if(file.getSize()>0){
					names += file.getOriginalFilename()+",";
					String name = FileUtils.write(file, path);
					attechement += projectNO+"/"+name+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length())+",";
				}
			}
			dto.setProjectAttchement(attechement.substring(0, attechement.length()-1));
			dto.setFileName(names.substring(0, names.length()-1));
		}*/
		
		
		
		
		
		EduProject pro = new EduProject();
		BeanUtils.copyProperties(dto, pro);
		pro.setStatus(Common.PROJECT_COMMON_STATUS.get("待申报"));
		pro.setHasStopSign(0);
		int projectId = proWriteDao.insertProject(pro);
		dto.setPid(projectId);
		
		if(projectId != 0){//向project表中插入记录成功
			boolean proOk = true;
			EduProjectTrainTarget target = new EduProjectTrainTarget();
			BeanUtils.copyProperties(dto, target);
			target.setProjectId(projectId);
			boolean targetOk = proWriteDao.insertProjectTrainTarget(target);
			
			if(proOk && targetOk){
				return true;
			}
		}else{
			throw new Exception("project表添加失败");
		}
		return false;
	}
	
	/**
	 * 项目列表
	 * @author zhangBo
	 * @create_date 2014年3月28日
	 */
	@Override
	public PageObject projectList(Map<String, Object> conditions,int startIndex,int pageSize) throws Exception{
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.selectCountByConditions(conditions);
		po.setCount(count);
//		if(count == 0){
//			return po;
//		}
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProject> proList = eduProjectReadDAO.selectProjectList(conditions);
		po.setObjects(proList);
		return po;
	}
	
	
	/**
	 * 项目详情
	 * @author zhangBo
	 * @create_date 2014年3月28日
	 */
//	public OrganizationProjectActivity queryProInfoById(int proId) throws Exception{
//		OrganizationProjectActivity activity = orgReadDAO.selectOrgProjectInfoByProjectId(proId);
//		List<String> orgNames = orgReadDAO.selectOrgNameByProjectId(proId);
//		activity.setOrgList(orgNames);
//		return activity;
//	}

	@Override
	public boolean modifyProById(int proId) throws Exception {
		return proWriteDao.updateProjectById(proId);
	}

	@Override
	public EduProjectDTO qryProFullInfo(int proId) throws Exception {
		return eduProjectReadDAO.selectProFullInfoById(proId);
	}
	
	/**
	 * 设置报名方式
	 * @author zhangBo
	 */
	@Override
	public boolean setProSignUpWay(int proId, String way) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("way", way);
		params.put("proId", proId);
		return proWriteDao.updateProSignUpWay(params);
	}

	
	@Override
	public Map<String, Object> importTeacher(List<TeacherDTO> dtos,String account,Map<String,Object> param) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
//		Map<String, Object> result = parseExcel(file.getInputStream(),account);
//		Map<String, Object> result = sysService.parseExcel(account, "teacher",null);
//		List<TeacherDTO> dtos = (List<TeacherDTO>) result.get("toDB");
//		List<XSSFRow> rows = (List<XSSFRow>)result.get("toExl");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf1.parse(param.get("date").toString());
//		Date date = (Date) param.get("date");
		log.info("导入教师时间---->"+date);
		if(dtos.size()>0){
			List<EduUser> users = new ArrayList<EduUser>();
			List<EduTeacherBasicInfo> basicInfos = new ArrayList<EduTeacherBasicInfo>();
			List<EduTeacherEducation> educations = new ArrayList<EduTeacherEducation>();
			List<EduTeacherEducation> topeducations = new ArrayList<EduTeacherEducation>();
			List<EduTeacherJob> jobs = new ArrayList<EduTeacherJob>();
			for(TeacherDTO dto:dtos){
				EduUser user = new EduUser();
				EduTeacherBasicInfo basic = new EduTeacherBasicInfo();
				EduTeacherEducation topEducation = null;//最高学历
				EduTeacherEducation education = new EduTeacherEducation();
				EduTeacherJob job = new EduTeacherJob();
				
				dto.setCreateBy(account);
				dto.setCreateDate(date);
				dto.setUpdateBy(account);
				dto.setUpdateDate(date);
				
				basic.setTeacherCreateBy(account);
				basic.setTeacherCreateDate(date);
				basic.setTeacherUpdateBy(account);
				basic.setTeacherUpdateDate(date);
				
				BeanUtils.copyProperties(dto, user);
				BeanUtils.copyProperties(dto, basic);
				BeanUtils.copyProperties(dto, education);
				BeanUtils.copyProperties(dto, job);
				//如果用户名为空 就随机产生一个
				if(dto.getLoginAccount()==null || "".equals(dto.getLoginAccount())){
					user.setLoginAccount("T"+RandomNumberUtil.randomLong(13));
				}
				//如果教师编号为空 就随机产生一个
				if(dto.getTeacherNo()==null || "".equals(dto.getTeacherNo())){
					user.setTeacherNo(RandomNumberUtil.randomLong(13));

				}
				//获得模板中的身份证号码
				String idNum = dto.getIdNum();
				user.setIdNumber(idNum);
				user.setPassword(idNum.substring(idNum.length()-6,idNum.length()));
				user.setRoleId(5);
				user.setCreateDate(date);
				user.setUpdateDate(date);
				user.setStatus(6);
				if(dto.getSchoolCityId() != null){
					user.setUserCityId(Integer.parseInt(dto.getSchoolCityId()));
					user.setUserCityName(dto.getSchoolCityName());
				}
				if(dto.getSchoolProvinceId() != null){
					user.setUserProvinceId(Integer.parseInt(dto.getSchoolProvinceId()));
					user.setUserProvinceName(dto.getSchoolProvinceName());
				}
				if(dto.getSchoolDistrictId() != null){
					user.setUserDistrictId(Integer.parseInt(dto.getSchoolDistrictId()));
					user.setUserDistrictName(dto.getSchoolDistrictName());
				}
				users.add(user);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				if(!StringUtils.isEmpty(dto.getBirth())) {
					basic.setTeacherBornDate(dto.getBirth());
				}
				basic.setTeacherPhoneNum(dto.getMobile());
				basic.setTeacherEmail(dto.getMail());
				basic.setTeacherNation(dto.getMz());
				basic.setTeacherCountry(dto.getCountry()== null ? null : Integer.valueOf(dto.getCountry()));
				basicInfos.add(basic);
				
				
				education.setEducationCreateDate(date);
				education.setEducationUpdateDate(date);
				education.setEducationCreateBy(account);
				education.setEducationUpdateBy(account);
				educations.add(education);
				
				//最高学历
				topEducation = (EduTeacherEducation)education.clone();
				topEducation.setEducationExperienceType(dto.getTopEducationExperienceType());
				topEducation.setEducationExperience(dto.getTopEducationExperience());
				topEducation.setEducationDegreeType(dto.getTopEducationDegreeType());
				topEducation.setEducationDegree(dto.getTopEducationDegree());
				topEducation.setEducationGraduationTime(dto.getTopEducationGraduationTime());
				topEducation.setEducationGraduationSchool(dto.getTopEducationGraduationSchool());
				topEducation.setEducationGraduationProfession(dto.getTopEducationGraduationProfession());
				topeducations.add(topEducation);
				
				//job.setJobCoreTeacher(dto.getJobCoreTeacher());
				job.setJobCreateBy(account);
				job.setJobCreateDate(date);
				job.setJobUpdateBy(account);
				job.setJobUpdateDate(date);
//				job.setJobSpecialTeacher(Integer.parseInt(dto.getTgjs()));
				int istg=  dto.getTgjs()==null?0:1;
				job.setJobSpecialTeacher(istg);
				//特岗教师
				if(istg == 1){
					job.setTgjs(dto.getTgjs()==null? null : Integer.valueOf(dto.getTgjs()));
				}
				//参加工作时间
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
				if(!StringUtils.isEmpty(dto.getJobWorkTime())) {
					job.setJobWorkTime(dto.getJobWorkTime());
				}
				jobs.add(job);
			}
			
			for(int i = 0;i<users.size();i++){
				//teacher_Id
				int tId;
				try {
					tId = userWriteDao.insertUser(users.get(i));
					if(tId != -1){
						EduTeacherBasicInfo info = basicInfos.get(i);
						info.setTeacherId(tId);
						info.setVersion(1);
						info.setStatus(1);
						if(teacherWriteDao.insertTeacherBaseInfo(info) == -1){
							log.error("教师基本信息保存失败");
							throw new Exception("教师基本信息保存失败！");
						}
						EduTeacherEducation edu = educations.get(i);
						edu.setTeacherId(tId);
						edu.setVersion(1);
						edu.setSort(1);
						edu.setStatus(1);
						if(teacherWriteDao.insertTeacherEducation(edu) == -1){
							log.error("教师教育信息保存失败");
							throw new Exception("教师教育信息保存失败！");
						}
						//最高学历
						EduTeacherEducation topEdu = topeducations.get(i);
						topEdu.setTeacherId(tId);
						topEdu.setVersion(1);
						topEdu.setSort(2);
						topEdu.setStatus(1);
						if(teacherWriteDao.insertTeacherEducation(topEdu) == -1){
							log.error("教师教育信息保存失败");
							throw new Exception("教师教育信息保存失败！");
						}
						EduTeacherJob job = jobs.get(i);
						job.setTeacherId(tId);
						job.setVersion(1);
						job.setStatus(1);
						if(teacherWriteDao.insertTeacherJob(job) == -1){
							log.error("教师工作信息保存失败");
							throw new Exception("教师工作信息保存失败！");
						}
					}else{
						log.error("edu_user 用户保存失败");
						throw new Exception("用户保存失败！");						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					throw new Exception(e.getMessage());
				}
				
			}
		}
//		map.put("toExl", rows.size());
		map.put("toDB", dtos.size());
		return map;
	}

	@Override
	public boolean modifyProById(EduProjectDTO dto,String deleted,List<MultipartFile> files,String path) throws Exception {
		boolean ok1 = false;
		boolean ok2 = false;
		EduProject pro = new EduProject();
		BeanUtils.copyProperties(dto, pro);
		
		EduProjectTrainTarget target = new EduProjectTrainTarget();
		BeanUtils.copyProperties(dto, target);
		target.setProjectId(pro.getId());
		ok1 = proWriteDao.updateProject(pro);
		ok2 = proWriteDao.updateTrainTargetById(target);
		
		return ok1 &&ok2;
	}
	
//	@Override
//	public List<EduProjectClass> projectClassNoPage(int proId) throws Exception {
//		return null;
//	}

//	@Override
//	public PageObject projectClasses(int proId) throws Exception {
//		return null;
//	}

	@Override
	public PageObject classesListForProject(int startIndex,int pageSize,Map<String, Object> conditions) throws Exception {
		PageObject po = new PageObject();
		List<ProjectClassesDTO> dtos = new ArrayList<ProjectClassesDTO>();
		int count = eduProjectReadDAO.selectCountByConditions(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		//项目列表
		List<EduProject> proList = eduProjectReadDAO.selectProjectList(conditions);
		for(EduProject pro:proList){
			ProjectClassesDTO dto = new ProjectClassesDTO();
			dto.setProjectId(pro.getId());
			dto.setProjectName(pro.getProjectName());
			dto.setYear(pro.getYear());
			//项目对应的课程
			List<EduProjectClass> proClasses = classReadDAO.selectClassByProId(pro.getId());
			if(proClasses!= null && proClasses.size()>0){
				StringBuilder sb = new StringBuilder();
				for(EduProjectClass clazz:proClasses){
					String name = clazz.getClassName();
					if(name != null && name.length() >0){
						sb.append(name);
						sb.append(",");
					}
				}
				if(sb.length() > 0){
					dto.setClasses(sb.toString().substring(0,sb.length()-1));
				}
			}
			dtos.add(dto);
		}
		po.setObjects(dtos);
		return po;
	}

	@Override
	public EduProject queryProjectBaseInfoById(int proId) throws Exception {
		return eduProjectReadDAO.selectBaseInfoById(proId);
	}
	
	

	@Override
	public List<Organization> getOrgsByArea(EduProjectDTO pro) throws Exception {
		Map params = new HashMap();
		String[]  areaCode = pro.getTrainScopeId().split(",");
		List<String> provinceIds = new ArrayList<String>();
		List<String> cityIds = new ArrayList<String>();
		List<String> districtIds = new ArrayList<String>();
		for(String code:areaCode){
			SysArea area = sysReadDAO.selectAreaByCode(code);
			String t = area.getType();
			if(t.equals("0")){
				provinceIds.add(code);
			}else if(t.equals("1")){
				cityIds.add(code);
			}else{
				districtIds.add(code);
			}
		}
		if(provinceIds.size()>0){
			params.put("provinceIds", provinceIds);
		}
		if(cityIds.size()>0){
			params.put("cityIds", cityIds);
		}
		if(districtIds.size()>0){
			params.put("districtIds", districtIds);
		}
		List<Organization> orgs = orgReadDAO.selectOrgByArea(params);
		return orgs;
	}

	@Override
	public PageObject proListForAudit(Map<String, Object> conditions, int status, int startIndex,int pageSize)
			throws Exception {
		PageObject po = new PageObject();
		List<Integer> projectIds = new ArrayList<Integer>();
		
		if(status==1){//待审核
			projectIds = eduProjectReadDAO.selectUnAuditProjectIds(conditions);
		}else if(status==2){//审核完成
			projectIds = eduProjectReadDAO.selectHasFinishedAuditProjectIds(conditions);
		}
		
		if(projectIds!=null && projectIds.size()>0){
			conditions.put("projectIds", projectIds);
			
			int count = eduProjectReadDAO.selectCountProListForAudit(conditions);
			po.setCount(count);
			PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
			conditions.put("startIndex", po.getStartIndex());
			conditions.put("endIndex", pageSize);
			List<EduProjectAudit> pros = eduProjectReadDAO.selectProListForAudit(conditions);
			po.setObjects(pros);
			
		}else{
			po.setCount(0);
			PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		}
		return po;
	}
	/*
	 * 成绩审核
	 * 
	 */
	@Override
	public PageObject proListForAuditSH(Map<String, Object> conditions,int startIndex,int pageSize)
			throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.selectCountProjectForAudit(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProjectAudit> pros = eduProjectReadDAO.selectProListForAuditSH(conditions);
		po.setObjects(pros);
		return po;
	}

	
	 /**
	  * 培训结果审核的项目列表
	  */
	@Override
	public PageObject proListForAuditTeacher(Map<String, Object> conditions, int startIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.selectCountProjectForAuditTeacher(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduTeacherAudit> pros = eduProjectReadDAO.selectProListForAuditTeacher(conditions);
		po.setObjects(pros);
		return po;
	}
	
	@Override
	public PageObject teachersForAudit(Map<String, Object> conditions,
			int startIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.selectCountTeacherForAudit(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<OrgProTeacherActivity> teachers = eduProjectReadDAO.selectTeacherByProjectId(conditions);
		po.setObjects(teachers);
		return po;
	}

	@Override
	public boolean auditTeacher(Map<String, Object> params) throws Exception {
		return proWriteDao.updateComment(params);
	}
	/*
	 * 新教师报名审核
	 * 	wych
	 */
	@Override
	public boolean deleteTeacher(String projectId,int teacherId,int schoolId) throws Exception {
		return proWriteDao.deleteTeacher(projectId,teacherId,schoolId);
	}

	@Override
	public String getUnpassReason(int id) throws Exception {
		return eduProjectReadDAO.selectUnpassReason(id);
	}

	@Override
	public boolean modifyProjectStatus(int projectId, int status)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", status);
		params.put("projectId", projectId);
		boolean flag = proWriteDao.updateProjectStatus(params);
		
		//启动项目
		int rtn = -1;
		if(status == 40){
			//TODO 启动项目判断是否已经结束报名
//			EduProjectDTO dto = this.qryProFullInfo(projectId);
			rtn = orgWriteDAO.updateOrgProjetStatus(params);
			return flag && (rtn>0?true:false);
		}
		return  flag;
	}

	@Override
	public boolean batchAuditTeacher(String ids,Map<String, Object> params) throws Exception {
		if(ids.length()>0){
			String[] cids = ids.split(",");
			return proWriteDao.batchAudit(cids, params);
		}
		return false;
	}

	@Override
	public boolean hasTeacherEnter(int projectId) throws Exception {
		int i = eduProjectReadDAO.selectCountForSetSignWay(projectId);
		if(i >0){
			return true;
		}
		return false;
	}

	@Override
	public boolean hasAllocate(int projectId, int organizationId)
			throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("projectId", projectId);
		params.put("organizationId", organizationId);
		int i = eduProjectReadDAO.selectCountForAllocate(params);
		if(i > 0){
			return true;
		}
		return false;
	}
	/**
	 * 取消项目分配的机构
	 */
	@Override
	public boolean cancelOP(int id) throws Exception {
		return proWriteDao.deleteOPById(id);
	}
	/**
	 * 之前是得到eud_project_comment的id集合，现在改成得到eud_project_comment的teacher_id的集合 
	因为在service中调用该方法的名字叫：getAllTeachers，不知道之前开发人员怎么命名的，
	还有就是为什么要去掉后面的那些isNotEmpty,如果不传递该参数，下面的压根运行不到
	再有就是，为什么分页和不分页需要些两个查询？可以根据传递的startIndex或者其他参数来判断是否是分页啊
	 */
	@Override
	public String getAllTeachers(Map<String, Object> params) throws Exception {
		List<String> ids = eduProjectReadDAO.selectAllTeacherRecord(params);
		if(ids != null && ids.size()>0){
			StringBuilder sb = new StringBuilder();
			for(String id:ids){
				sb.append(id);
				sb.append(",");
			}
			return sb.toString().substring(0,sb.length()-1);
		}
		return "";
	}
/**
 * 获取项目全部的培训机构 -- 无分页
 */
	@Override
	public List<String> getAllOrgByProjectId(int projectId) throws Exception {
		
		return eduProjectReadDAO.selectAllOrgByProjectId(projectId);
	}

//@Override
//public String saveProjectAttechment(List<MultipartFile> files, String projectNO)
//		throws Exception {
//	
//	return null;
//}
@Override
public boolean isReduplicatedProName(String projectName) throws Exception {
	List<String> nos = eduProjectReadDAO.selectProjectName();
	if(nos.contains(projectName)){
		return true;
	}
	return false;
}

@Override
public boolean isReduplicatedTrinProName(String projectName,Integer type) throws Exception {
	List<String> nos = eduProjectReadDAO.selectTrainProjectName(type);
	if(nos.contains(projectName)){
		return true;
	}
	return false;
}

	
@Override
public boolean isReduplicated(String projectNo) throws Exception {
	List<String> nos = eduProjectReadDAO.selectProjectNo();
	if(nos.contains(projectNo)){
		return true;
	}
	return false;
}

@Override
public boolean isTrainReduplicated(String projectNo,Integer type) throws Exception {
	List<String> nos = eduProjectReadDAO.selectTrainProjectNo(type);
	if(nos.contains(projectNo)){
		return true;
	}
	return false;
}


public int getIndex(String name, Row row) throws Exception {
	for (int i = 0; i < row.getLastCellNum(); i++) {

		if(DataUtil.getCellValue(row.getCell(i)).equals(name)){
			return i;
		}
		
	}
	return 0;
}
/**
 * 导入教师--解析EXCEL
 * @param file
 * @param loginAccount
 * @return
 * @throws Exception
 */
public Map<String, Object> parseExcel(InputStream is,String fileType) throws Exception{
	Map<String, Object> result = new HashMap<String, Object>();
	//正确的数据
	List<TeacherDTO> dtos = new ArrayList<TeacherDTO>();
	List<Row> dbRows = new ArrayList<Row>();
	//地区数据
//	List<SysArea> areas = sysReadDAO.selectAllAreas();
	//政治面貌
	List<SysDictionary> politicalDic = sysReadDAO.selectDicByDicType("political_status");
	//学段
	List<SysDictionary> sections = sysReadDAO.selectDicByDicType("stduty_section");
	//学科
	List<SysDictionary> subjects = sysReadDAO.selectDicByDicType("project_subject");
	//国籍
	List<SysDictionary> countrys = sysReadDAO.selectDicByDicType("country_type");
	//教师岗位类别
	List<SysDictionary> workType = sysReadDAO.selectDicByDicType("gwlb_type");
	//教师岗位等级
	List<SysDictionary> workLv = sysReadDAO.selectDicByDicType("gwdj_type");
	//教师资格证种类
	List<SysDictionary> diplomaType = sysReadDAO.selectDicByDicType("jszgz_type");
	//合同类型
	List<SysDictionary> teacherContract = sysReadDAO.selectDicByDicType("contract_type");
	//普通话级别
	List<SysDictionary> mandarinLv = sysReadDAO.selectDicByDicType("pthdj_type");
	//免费师范生 
	List<SysDictionary> freeTeacher = sysReadDAO.selectDicByDicType("mfsfs_type");
	//特岗教师
	List<SysDictionary> specialTeacher = sysReadDAO.selectDicByDicType("tgjs_type");
	//编制类别
	List<SysDictionary> bzlb = sysReadDAO.selectDicByDicType("teacher_staff");
	
	//学校行政职务
	List<SysDictionary> xzzw = sysReadDAO.selectDicByDicType("office_type");
	
	//教师职称
	List<SysDictionary> jszc = sysReadDAO.selectDicByDicType("teacher_professional");
	
	// 是否名校长培养对象
	List<SysDictionary> mspydx = sysReadDAO.selectDicByDicType("mspydx_type");
	// 教学名师
	List<SysDictionary> jxms = sysReadDAO.selectDicByDicType("jxms_type");
	// 学科带头人
	List<SysDictionary> xkdtr = sysReadDAO.selectDicByDicType("xkdtr_type");
	// 骨干教师
	List<SysDictionary> ggjs = sysReadDAO.selectDicByDicType("ggjs_type");
	
	//学校名称
	List<EduSchool> schools = sysReadDAO.selectAllSchool();
	//数据不合格的row
	List<Row> rows = new ArrayList<Row>();
	Workbook wb = null;
	if(fileType.equalsIgnoreCase("xls")){
		wb = new HSSFWorkbook(is);
		
	}else{
		wb = new HSSFWorkbook(is);
	}
	Sheet sheet = wb.getSheetAt(0);
	Row rowOne = sheet.getRow(0);
	List<String> checkExcUNList = new ArrayList<String>();
	List<String> checkExcNoList = new ArrayList<String>();
	List<String> checkExcIdNumList = new ArrayList<String>();
	for(int i = 1;i<=sheet.getLastRowNum();i++){
//		//基本信息
//		EduTeacherBasicInfo basic = new EduTeacherBasicInfo();
//		//教育信息
//		EduTeacherEducation edu = new EduTeacherEducation();
//		
//		EduUser user = new EduUser();
		TeacherDTO dto = new TeacherDTO();
		
		Row row = sheet.getRow(i);
		int errCell = 60;
		if(row != null){
			if(row.getCell(errCell)==null){
				row.createCell(errCell);
			}
			//空数据
			if(DataUtil.getCellValue(row.getCell(getIndex("教师姓名", rowOne))).length() == 0 && DataUtil.getCellValue(row.getCell(getIndex("身份证号", rowOne))).length() == 0
					&&DataUtil.getCellValue(row.getCell(getIndex("用户名", rowOne))).length() == 0 && DataUtil.getCellValue(row.getCell(getIndex("密码", rowOne))).length() == 0
					&& DataUtil.getCellValue(row.getCell(getIndex("教师编号", rowOne))).length() == 0 
					&& DataUtil.getCellValue(row.getCell(getIndex("性别", rowOne))).length() == 0 && DataUtil.getCellValue(row.getCell(getIndex("政治面貌", rowOne))).length() == 0 
					&& DataUtil.getCellValue(row.getCell(getIndex("教师资格证书号", rowOne))).length() == 0 
					&& DataUtil.getCellValue(row.getCell(getIndex("手机号码", rowOne))).length() == 0 && DataUtil.getCellValue(row.getCell(getIndex("邮箱", rowOne))).length() == 0 
					&& DataUtil.getCellValue(row.getCell(getIndex("学段", rowOne))).length() == 0 
					&& DataUtil.getCellValue(row.getCell(getIndex("学科", rowOne))).length() == 0 && DataUtil.getCellValue(row.getCell(getIndex("第一学历", rowOne))).length() == 0 
					&& DataUtil.getCellValue(row.getCell(getIndex("获得学位", rowOne))).length() == 0 
					&& DataUtil.getCellValue(row.getCell(getIndex("毕业时间", rowOne))).length() == 0 && DataUtil.getCellValue(row.getCell(getIndex("毕业院校", rowOne))).length() == 0 
					&& DataUtil.getCellValue(row.getCell(getIndex("毕业专业", rowOne))).length() == 0 
					&& DataUtil.getCellValue(row.getCell(getIndex("(评)教师职称", rowOne))).length() == 0 && DataUtil.getCellValue(row.getCell(getIndex("(聘)教师职称", rowOne))).length() == 0 
					&& DataUtil.getCellValue(row.getCell(getIndex("学校行政职务", rowOne))).length() == 0 && DataUtil.getCellValue(row.getCell(getIndex("是否骨干教师", rowOne))).length() == 0 
					&& DataUtil.getCellValue(row.getCell(getIndex("是否为班主任", rowOne))).length() == 0 && DataUtil.getCellValue(row.getCell(getIndex("国培计划农村骨干教师", rowOne))).length() == 0 
					&& DataUtil.getCellValue(row.getCell(getIndex("国籍/地区", rowOne))).length() == 0 && DataUtil.getCellValue(row.getCell(getIndex("岗位类别", rowOne))).length() == 0 
					&& DataUtil.getCellValue(row.getCell(getIndex("岗位等级", rowOne))).length() == 0 && DataUtil.getCellValue(row.getCell(getIndex("是否在编", rowOne))).length() == 0){
				continue;
			}
//			String province = DataUtil.getCellValue(row.getCell(0));
//			if(province.length()>0){
//				if(DataUtil.validateArea(areas, province, "0")){
//					dto.setSchoolProvinceName(province);
//					dto.setSchoolProvinceId(DataUtil.getAreaCodeByName(areas, province,"0"));
//				}else{
//					row.getCell(errCell).setCellValue("省在系统中不存在或错误！");
//					rows.add(row);
//					continue;
//				}
//			}
//			String city = DataUtil.getCellValue(row.getCell(1));
//			if(province.length()>0 && city.length()>0){
//				if(DataUtil.validateArea(areas, city, dto.getSchoolProvinceId())){
//					dto.setSchoolCityName(city);
//					dto.setSchoolCityId(DataUtil.getAreaCodeByName(areas, city,"1"));
//				}else{
//					row.getCell(errCell).setCellValue("市在系统中不存在或错误！");
//					rows.add(row);
//					continue;
//				}
//			}else if(province.length() >0 && city.length() ==0){
//				row.getCell(errCell).setCellValue("市在系统中不存在或错误！");
//				rows.add(row);
//				continue;
//			}
//			String district  = DataUtil.getCellValue(row.getCell(2));
//			if(province.length()>0 && city.length()>0 && district.length()>0){
//				if(DataUtil.validateArea(areas, district, dto.getSchoolCityId())){
//					dto.setSchoolDistrictName(city);
//					dto.setSchoolDistrictId(DataUtil.getAreaCodeByName(areas, district,"2"));
//				}else{
//					row.getCell(errCell).setCellValue("地区在系统中不存在或错误！");
//					rows.add(row);
//					continue;
//				}
//			}else if(district.length() > 0 && (city.length() ==0 || province.length() == 0)){
//				row.getCell(errCell).setCellValue("地区在系统中不存在或错误！");
//				rows.add(row);
//				continue;
//			}
//			String school = DataUtil.getCellValue(row.getCell(3));
//			
//			if(school.length() >0){
//				Integer schoolId = DataUtil.validateSchoolName(schools, school);
//				if(schoolId != 0){
//					dto.setSchoolName(school);
//					dto.setSchoolId(schoolId);
//				}else{
//					row.getCell(errCell).setCellValue("学校在系统中不存在或错误！");
//					log.info("学校名称不正确");
//					rows.add(row);
//					continue;
//				}
//			}
			String teacherName = DataUtil.getCellValue(row.getCell(getIndex("教师姓名", rowOne)));
			if(teacherName.length() >0 && teacherName.length() <14){
				String realTeacherName = teacherName.replaceAll(" ", "");
				dto.setRealName(realTeacherName);
			}else{
				row.getCell(errCell).setCellValue("教师姓名为空或错误！");
				log.info("教师姓名不正确");
				rows.add(row);
				continue;
			}
			String IDCard = DataUtil.getCellValue(row.getCell(getIndex("身份证号", rowOne))); 
			if(IDCard.length() > 0){
				// 检查身份证号码在系统中是否存在
				boolean b = userReadDao.existUserByIdNumber(IDCard);
				if(b){
					row.getCell(errCell).setCellValue("该身份证号码在系统中已经存在！");
					log.info("该身份证号码在系统中已经存在！");
					rows.add(row);
					continue;
				}
				if(!checkExcIdNumList.contains(IDCard)){
					checkExcIdNumList.add(IDCard);
				if(DataUtil.validateIDCard(dtos,IDCard)){
					dto.setIdNum(IDCard.toUpperCase());
				}else{
					row.getCell(errCell).setCellValue("身份证号为空或错误！");
					log.info("身份证号不正确");
					rows.add(row);
					continue;
				}
				}
				else{
					row.getCell(errCell).setCellValue("模板中有重复的身份证号码！");
					log.info("模板中有重复的身份证号码");
					rows.add(row);
					continue;
				}
			}else{
				row.getCell(errCell).setCellValue("身份证号为空或错误！");
				log.info("身份证号不正确");
				rows.add(row);
				continue;
			}
			String userName = DataUtil.getCellValue(row.getCell(getIndex("用户名", rowOne)));
			//如果模板用户名不为空，进行校验
			if(userName.length()>0 && !"".equals(userName)){
						
			//用来校验模板中是否有重复的用户名
			if(!checkExcUNList.contains(userName)){
				checkExcUNList.add(userName);
				// 查询所有用户名
				List<String> userNames = sysReadDAO.selectAllUserName();
			int rr = DataUtil.validateUserName(userName, userNames);
			if(rr==0){
				dto.setLoginAccount(userName);
			}else if(rr ==-1){
				row.getCell(errCell).setCellValue("用户名错误,4-20位，字母数字下划线，字母开头");
				log.info("用户名错误");
				rows.add(row);
				continue;
			}else{
				row.getCell(errCell).setCellValue("用户名重复！");
				log.info("用户名重复");
				rows.add(row);
				continue;
			}
			}
			else{
				row.getCell(errCell).setCellValue("模板数据中有重复的用户名！");
				log.info("模板数据中有重复的用户名！");
				rows.add(row);
				continue;
			}
			}
			//教师导入 密码初始化身份证后六位
			/*String pwd = DataUtil.getCellValue(row.getCell(getIndex("密码", rowOne)));
			if(pwd.length()>0){
				if(DataUtil.validatePwd(pwd)){
					dto.setPassword(pwd);
				}else{
					row.getCell(errCell).setCellValue("密码格式不正确！");
					log.info("密码不正确");
					rows.add(row);
					continue;
				}
			}else{
				dto.setPassword(DataUtil.createPwd());
//				row.getCell(errCell).setCellValue("密码不能为空！");
//				log.info("密码不正确");
//				rows.add(row);
//				continue;
			}*/
			//教师编号
			String teacherCode = DataUtil.getCellValue(row.getCell(getIndex("教师编号", rowOne)));
			//如果模板教师编号不为空，进行校验
				if (teacherCode.length() > 0 && !"".equals(teacherCode)) {

					if (!checkExcNoList.contains(teacherCode)) {
						checkExcNoList.add(teacherCode);
						List<String> userNos = sysReadDAO.selectAllUserNo();
						// Set<String> userNames = new HashSet<String>();
						int re = DataUtil.validateTCode(userNos,
								teacherCode);
						/*
						 * if(DataUtil.validateTCode(dtos, teacherCode)){
						 * dto.setTeacherNo(teacherCode); }
						 */
						if (re==0) {
							dto.setTeacherNo(teacherCode);
						}
						else if(re == -1){
							row.getCell(errCell).setCellValue("教师编号错误，1-14位的数字！");
							log.info("教师编号错误，1-14位的数字！");
							rows.add(row);
							continue;
						}
						else{
							row.getCell(errCell).setCellValue("教师编号重复！");
							log.info("教师编号重复");
							rows.add(row);
							continue;
						}
					} else {
						row.getCell(errCell).setCellValue("模板中教师编号重复！");
						log.info("模板中教师编号重复！");
						rows.add(row);
						continue;
					}
				}
			/*String sex = DataUtil.getCellValue(row.getCell(getIndex("性别", rowOne)));
			int gender = DataUtil.maleOrFemale(sex);
			if(gender == -1){
				row.getCell(errCell).setCellValue("模板中性别输入错误，请输入男或女！");
				log.info("模板中性别输入错误，请输入男或女！");
				rows.add(row);
				continue;
			}
			else{
				dto.setGender(gender);
			}*/
		    //性别从身份证中获得
				int sex = 0;
				if(IDCard.length()==15){
					sex = Integer.parseInt(IDCard.substring(14));
				}if(IDCard.length()==18){
					sex = Integer.parseInt(IDCard.substring(16,IDCard.length()-1));
				}
				if(sex % 2 == 0){
					dto.setGender(0);
				}
				else{
					dto.setGender(1);
				}
				
			//政治面貌
			String political = DataUtil.getCellValue(row.getCell(getIndex("政治面貌", rowOne)));
			SysDictionary dic = null;
			if(political.length()>0){
				dic = DataUtil.validateDic(politicalDic, political);
				if(dic != null){
					dto.setTeacherPoliticalStatus(String.valueOf(dic.getDictionaryId()));
			}else{
				row.getCell(errCell).setCellValue("政治面貌系统中不存在！");
				rows.add(row);
				continue;
			}
			}
			//入党时间
			String partyTime = DataUtil.getCellValue(row.getCell(getIndex("入党时间", rowOne)));
			if(partyTime.length() >0){
				if(partyTime.length()== 10 && DataUtil.validatedate(partyTime)){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Date d;
					try {
						d = sdf.parse(partyTime);
						dto.setPartyTime(partyTime);
					} catch (Exception e) {
						row.getCell(errCell).setCellValue("入党时间格式不正确！例：2009/7/1！");
						rows.add(row);
						continue;
					}
				}else{
					row.getCell(errCell).setCellValue("入党时间格式不正确！例：2009/7/1！");
					rows.add(row);
					continue;
				}
			}
			/*else{
				row.getCell(errCell).setCellValue("请输入政治面貌！");
				rows.add(row);
				continue;
			}*/
			
			//教师资格证编号
			String certificateNum = DataUtil.getCellValue(row.getCell(getIndex("教师资格证书号", rowOne)));
			if(certificateNum.length() >0){
			if(certificateNum.length() >0 && certificateNum.length() <=20){
				dto.setJobCertificateNum(certificateNum);
			}
			else{
				row.getCell(errCell).setCellValue("模板中教师资格证书号错误，请输入1-20位字符！");
				log.info("模板中教师资格证书号错误，请输入1-20位字符！");
				rows.add(row);
				continue;
			}
			}
			
			String phone = DataUtil.getCellValue(row.getCell(getIndex("手机号码", rowOne)));
			if(phone.length()>0){
				if(DataUtil.validatePhone(phone)){
					dto.setMobile(phone);
				}
				else{
					row.getCell(errCell).setCellValue("模板中手机号错误，请输入11位有效的手机号码！");
					log.info("模板中手机号错误，请输入11位有效的手机号码！");
					rows.add(row);
					continue;
				}
			}
			
			String mail = DataUtil.getCellValue(row.getCell(getIndex("邮箱", rowOne)));
			if(mail.length()>0){
			if(DataUtil.validateMail(mail)){
				dto.setMail(mail);
			}
			else{
				row.getCell(errCell).setCellValue("模板中邮箱错误，请输入有效的邮箱！");
				log.info("模板中邮箱错误，请输入有效的邮箱！");
				rows.add(row);
				continue;
			}
			}
			//学段
			String section = DataUtil.getCellValue(row.getCell(getIndex("学段", rowOne)));
			if(section.length()>0){
				dic = DataUtil.validateDic(sections, section);
				if(dic != null){
					dto.setJobFormerTeachingSectionType(dic.getDictionaryId());
					dto.setJobFormerTeachingSection(dic.getDictionaryName());
				}else{
					row.getCell(errCell).setCellValue("学段系统中不存在！");
					rows.add(row);
					continue;
				}
				
			}else{
				row.getCell(errCell).setCellValue("学段为必填项！");
				rows.add(row);
				continue;
			}
			
			//学科
			String subject = DataUtil.getCellValue(row.getCell(getIndex("学科", rowOne)));
			String[] subs = subject.split(",");
			StringBuilder subName = new StringBuilder();
			StringBuilder subId = new StringBuilder();
			boolean flag = false;
			if(subs.length>0){
				for(String str:subs){
					dic = DataUtil.validateDic(subjects, str);
					if(dic != null){
						subName.append(dic.getDictionaryName());
						subName.append(",");
						subId.append(dic.getDictionaryId());
						subId.append(",");
					}else{
						flag = true;
						break;
					}
				}
			}else{
				row.getCell(errCell).setCellValue("学科系统中不存在！");
				rows.add(row);
				continue;
			}
			if(flag){
				row.getCell(errCell).setCellValue("学科系统中不存在！");
				rows.add(row);
				continue;
			}
			if(subName.length()>0 && subId.length() > 0){
				dto.setJobFormerTeachingSubject(subName.toString().substring(0,subName.length()-1));
				dto.setJobFormerTeachingSubjectType(subId.toString().substring(0,subId.length()-1));
			}
			//第一学历
			final String FIRST_EDUCATION = "第一学历";
			String firstEbg = DataUtil.getCellValue(row.getCell(getIndex(FIRST_EDUCATION, rowOne)));
			Set<String> ebgs = project.common.Common.TEACHER_DIM_EDUCATION_BACKGROUND_DEAN.keySet();
			if(firstEbg.length()>0){
				if(project.common.Common.TEACHER_DIM_EDUCATION_BACKGROUND_DEAN.containsValue(firstEbg)){
					dto.setEducationExperience(firstEbg);
					dto.setEducationExperienceType(Integer.parseInt(DataUtil.getKeyByValue(firstEbg, project.common.Common.TEACHER_DIM_EDUCATION_BACKGROUND_DEAN)));
				}else{
					row.getCell(errCell).setCellValue("学历系统中不存在！");
					rows.add(row);
					continue;
				}
			}
			//学位
			String degree = DataUtil.getCellValue(row.getCell(getIndex(FIRST_EDUCATION, rowOne) + 1));
			Set<String> degrees = project.common.Common.TEACHER_DIM_DEGREE_DEAN.keySet();
			if(project.common.Common.TEACHER_DIM_DEGREE_DEAN.containsValue(degree)){
				dto.setEducationDegree(degree);
				dto.setEducationDegreeType(Integer.parseInt(DataUtil.getKeyByValue(degree, project.common.Common.TEACHER_DIM_DEGREE_DEAN)));
			}
			//毕业时间
			String graduationDate = DataUtil.getCellValue(row.getCell(getIndex(FIRST_EDUCATION, rowOne) + 2));
			if(graduationDate.length() >0){
				if(graduationDate.length()== 10 && DataUtil.validatedate(graduationDate)){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Date d;
					try {
						d = sdf.parse(graduationDate);
						dto.setEducationGraduationTime(graduationDate);
					} catch (Exception e) {
						row.getCell(errCell).setCellValue("毕业时间格式不正确！例：2009/7/1！");
						rows.add(row);
						continue;
					}
				}else{
					row.getCell(errCell).setCellValue("毕业时间格式不正确！例：2009/7/1！");
					rows.add(row);
					continue;
				}
				
			}
			//毕业院校
			String graduationSchool = DataUtil.getCellValue(row.getCell(getIndex(FIRST_EDUCATION, rowOne) + 3));
			dto.setEducationGraduationSchool(graduationSchool);
			//专业
			String profession = DataUtil.getCellValue(row.getCell(getIndex(FIRST_EDUCATION, rowOne) + 4));
			dto.setEducationGraduationProfession(profession);
			
			//最高学历
			final String TOP_EDUCATION = "最高学历"; 
			String topEbg = DataUtil.getCellValue(row.getCell(getIndex(TOP_EDUCATION, rowOne)));
			//Set<String> ebgs = project.common.Common.TEACHER_DIM_EDUCATION_BACKGROUND_DEAN.keySet();
			if(topEbg.length()>0){
				if(project.common.Common.TEACHER_DIM_EDUCATION_BACKGROUND_DEAN.containsValue(topEbg)){
					dto.setTopEducationExperience(topEbg);
					dto.setTopEducationExperienceType(Integer.parseInt(DataUtil.getKeyByValue(topEbg, project.common.Common.TEACHER_DIM_EDUCATION_BACKGROUND_DEAN)));
				}else{
					row.getCell(errCell).setCellValue("学历系统中不存在！");
					rows.add(row);
					continue;
				}
			}
			
		
			//学位
			String topdegree = DataUtil.getCellValue(row.getCell(getIndex(TOP_EDUCATION, rowOne) + 1));
			//Set<String> degrees = project.common.Common.TEACHER_DIM_DEGREE_DEAN.keySet();
			if(project.common.Common.TEACHER_DIM_DEGREE_DEAN.containsValue(topdegree)){
				dto.setTopEducationDegree(topdegree);
				dto.setTopEducationDegreeType(Integer.parseInt(DataUtil.getKeyByValue(topdegree, project.common.Common.TEACHER_DIM_DEGREE_DEAN)));
			}
			//毕业时间
			String topgraduationDate = DataUtil.getCellValue(row.getCell(getIndex(TOP_EDUCATION, rowOne) + 2));
			if(topgraduationDate.length() >0){
				if(topgraduationDate.length()== 10 && DataUtil.validatedate(topgraduationDate)){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Date d;
					try {
						d = sdf.parse(topgraduationDate);
						dto.setTopEducationGraduationTime(topgraduationDate);
					} catch (Exception e) {
						row.getCell(errCell).setCellValue("毕业时间格式不正确！例：2009/7/1！");
						rows.add(row);
						continue;
					}
				}else{
					row.getCell(errCell).setCellValue("毕业时间格式不正确！例：2009/7/1！");
					rows.add(row);
					continue;
				}
				
			}
			//毕业院校
			String topgraduationSchool = DataUtil.getCellValue(row.getCell(getIndex(TOP_EDUCATION, rowOne) + 3));
			dto.setTopEducationGraduationSchool(topgraduationSchool);
			//专业
			String topprofession = DataUtil.getCellValue(row.getCell(getIndex(TOP_EDUCATION, rowOne) + 4));
			dto.setTopEducationGraduationProfession(topprofession);
			
			//评 教师职称
			String professionalC = DataUtil.getCellValue(row.getCell(getIndex("(评)教师职称", rowOne) + getIndex("教师职称", rowOne)));
			if(professionalC.length()>0){
				dic = DataUtil.validateDic(jszc, professionalC);
				if(dic != null){
					dto.setJobCommentPosition(professionalC);
					dto.setJobCommentPositionType(dic.getDictionaryId());
				}else{
					row.getCell(errCell).setCellValue("评 教师职称不正确！");
					rows.add(row);
					continue;
				}
			}
			//(评)职称时间
			String jobCommentDate = DataUtil.getCellValue(row.getCell(getIndex("(评)职称时间", rowOne)));
			if(jobCommentDate.length() >0){
				if(jobCommentDate.length()== 10 && DataUtil.validatedate(jobCommentDate)){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Date d;
					try {
						d = sdf.parse(jobCommentDate);
						dto.setJobCommentDate(jobCommentDate);
					} catch (Exception e) {
						row.getCell(errCell).setCellValue("(评)职称时间格式不正确！例：2009/7/1！");
						rows.add(row);
						continue;
					}
				}else{
					row.getCell(errCell).setCellValue("(评)职称时间格式不正确！例：2009/7/1！");
					rows.add(row);
					continue;
				}
			}
			
			//聘 教师职称
			String professionalR = DataUtil.getCellValue(row.getCell(getIndex("(聘)教师职称", rowOne)));
			if(professionalR.length()>0){
				dic = DataUtil.validateDic(jszc, professionalR);
				if(dic != null){
					dto.setJobRecruitmentPosition(professionalR);
					dto.setJobRecruitmentPositionType(dic.getDictionaryId());
				}else{
					row.getCell(errCell).setCellValue("聘 教师职称不正确！");
					rows.add(row);
					continue;
				}
			}
			
			//(聘)职称时间
			String jobRecruitmentDate = DataUtil.getCellValue(row.getCell(getIndex("(聘)职称时间", rowOne) + getIndex("聘任时间", rowOne)));
			if(jobRecruitmentDate.length() >0){
				if(jobRecruitmentDate.length()== 10 && DataUtil.validatedate(jobRecruitmentDate)){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Date d;
					try {
						d = sdf.parse(jobRecruitmentDate);
						dto.setJobRecruitmentDate(jobRecruitmentDate);
					} catch (Exception e) {
						row.getCell(errCell).setCellValue("(聘)职称时间格式不正确！例：2009/7/1！");
						rows.add(row);
						continue;
					}
				}else{
					row.getCell(errCell).setCellValue("(聘)职称时间格式不正确！例：2009/7/1！");
					rows.add(row);
					continue;
				}
			}
			
			//行政职务
			String position = DataUtil.getCellValue(row.getCell(getIndex("学校行政职务", rowOne)));
			if(position.length()>0){
				dic = DataUtil.validateDic(xzzw, position);
				if(dic != null){
					dto.setJobSchoolAdministrationOffice(position);
					dto.setJobSchoolAdministrationOfficeType(dic.getDictionaryId());
				}else{
					row.getCell(errCell).setCellValue("行政职务不正确！");
					rows.add(row);
					continue;
				}
			}
			//骨干教师
			String jobCoreTeacher = DataUtil.getCellValue(row.getCell(getIndex("是否骨干教师", rowOne)));
			if(jobCoreTeacher.length()>0 && !jobCoreTeacher.equals("否")){
				dic = DataUtil.validateDic(ggjs, jobCoreTeacher);
				if(dic != null){
					dto.setJobCoreTeacherType(dic.getDictionaryId());
					dto.setJobCoreTeacher(jobCoreTeacher);
				}else{
					row.getCell(errCell).setCellValue("是否骨干教师格式不正确！");
					rows.add(row);
					continue;
				}
			}
			//班主任
			String isClassCharger = DataUtil.getCellValue(row.getCell(getIndex("是否为班主任", rowOne)));
			if(isClassCharger.length()>0){
				int yesOrNo = DataUtil.yesOrNo(isClassCharger);
				if(yesOrNo != -1){
					dto.setJobWhetherTeacher(yesOrNo);
				}else{
					row.getCell(errCell).setCellValue("是否是班主任格式不正确！请填写是或者否");
					rows.add(row);
					continue;
				}
			}
			//国培计划农村骨干教师
			String isCountryCoreTeacher = DataUtil.getCellValue(row.getCell(getIndex("国培计划农村骨干教师", rowOne) + getIndex("是否为乡村教师", rowOne)));
			if(isCountryCoreTeacher.length()>0){
				int yesOrNo = DataUtil.yesOrNo(isCountryCoreTeacher);
				if(yesOrNo != -1){
					dto.setJobCountyRuralTeacher(yesOrNo);
				}else{
					row.getCell(errCell).setCellValue("是否是国家骨干教师格式不正确！请填写是或者否");
					rows.add(row);
					continue;
				}
			}
			
			//国籍
			String country = DataUtil.getCellValue(row.getCell(getIndex("国籍/地区", rowOne)));
			if(country.length() != 0 ){
				dic = DataUtil.validateDic(countrys, country);
				if(dic != null){
					dto.setCountry(dic.getDictionaryId());
					
				}else{
					row.getCell(errCell).setCellValue("国籍不正确！");
					rows.add(row);
					continue;
				}
			}
			//籍贯
			String teacherNativePlace = DataUtil.getCellValue(row.getCell(getIndex("籍贯", rowOne)));
			if(teacherNativePlace.length()>0){
				dto.setTeacherNativePlace(teacherNativePlace);
			}
			//岗位类别
			String workTypeStr = DataUtil.getCellValue(row.getCell(getIndex("岗位类别", rowOne)));
			if(workTypeStr.length() !=0 ){
				dic = DataUtil.validateDic(workType, workTypeStr);
				if(dic != null){
					dto.setGwlb(dic.getDictionaryId());
				}else{
					row.getCell(errCell).setCellValue("岗位类别不正确！");
					rows.add(row);
					continue;
				}
			}
			//岗位等级
			String workLvStr = DataUtil.getCellValue(row.getCell(getIndex("岗位等级", rowOne)));
			if(workLvStr.length() !=0 ){
				dic = DataUtil.validateDic(workLv, workLvStr);
				if(dic != null){
					dto.setGwdj(dic.getDictionaryId());
				}else{
					row.getCell(errCell).setCellValue("岗位等级不正确！");
					rows.add(row);
					continue;
				}
			}
			
			//聘任岗位等级时间
			String postGrade = DataUtil.getCellValue(row.getCell(getIndex("聘任岗位等级时间", rowOne)));
			if(postGrade.length() >0){
				if(postGrade.length()== 10 && DataUtil.validatedate(postGrade)){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Date d;
					try {
						d = sdf.parse(postGrade);
						dto.setPostGrade(postGrade);
					} catch (Exception e) {
						row.getCell(errCell).setCellValue("聘任岗位等级时间格式不正确！例：2009/7/1！");
						rows.add(row);
						continue;
					}
				}else{
					row.getCell(errCell).setCellValue("聘任岗位等级时间格式不正确！例：2009/7/1！");
					rows.add(row);
					continue;
				}
			}
			
			//是否在编
			String isB = DataUtil.getCellValue(row.getCell(getIndex("是否在编", rowOne)));
			if(isB.length()>0){
				int yesOrNo = DataUtil.yesOrNo(isB);
				if( yesOrNo != -1){
					dto.setSfzb(yesOrNo);
				}else{
					row.getCell(errCell).setCellValue("是否在编格式不正确！请填写是或者否");
					rows.add(row);
					continue;
				}
			}
			
			//签订合同情况
			String contract = DataUtil.getCellValue(row.getCell(getIndex("签订合同情况", rowOne)));
			if(contract.length() != 0  ){
				dic = DataUtil.validateDic(teacherContract, contract);
				if(dic != null){
					dto.setContract(dic.getDictionaryId());
				}else{
					row.getCell(errCell).setCellValue("合同不正确！");
					rows.add(row);
					continue;
				}
			}
			//月平均工资
			String salary = DataUtil.getCellValue(row.getCell(getIndex("月平均工资", rowOne)));
			if(salary.length() != 0 ){
				if(DataUtil.validateNum(salary)){
					dto.setSalary(salary);
				}else{
					row.getCell(errCell).setCellValue("月平均工资不正确！格式：2000.0或3000.1");
					rows.add(row);
					continue;
				}
			}
			//五险一金
			String insurance = DataUtil.getCellValue(row.getCell(getIndex("五险一金", rowOne)));
			if(insurance.length() !=0){
				dto.setWxyj(insurance);
			}
			//教师资格证种类
			String CA = DataUtil.getCellValue(row.getCell(getIndex("教师资格证种类", rowOne)));
			if(CA.length()>0){
				dic = DataUtil.validateDic(diplomaType, CA);
				if(dic != null){
					dto.setJszgz(dic.getDictionaryId());
				}else{
					row.getCell(errCell).setCellValue("教师资格证种类 格式不正确！");
					rows.add(row);
					continue;
				}
			}
			
			//普通话等级
			String CB = DataUtil.getCellValue(row.getCell(getIndex("普通话等级", rowOne)));
			if(CB.length() > 0){
				dic = DataUtil.validateDic(mandarinLv, CB);
				if(dic != null){
					dto.setPthdj(dic.getDictionaryId());
				}else{
					row.getCell(errCell).setCellValue("普通话等级格式不正确！");
					rows.add(row);
					continue;
				}
			}
			
			
			//从教起始时间
			String CC = DataUtil.getCellValue(row.getCell(getIndex("从教起始时间", rowOne)));
			if(CC.length() >0){
				if(CC.length()== 10 && DataUtil.validatedate(CC)){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Date d;
					try {
						d = sdf.parse(CC);
						dto.setCjqsny(CC);
					} catch (Exception e) {
						row.getCell(errCell).setCellValue("从教起始时间格式不正确！例：2009/7/1！");
						rows.add(row);
						continue;
					}
				}else{
					row.getCell(errCell).setCellValue("从教起始时间格式不正确！例：2009/7/1！");
					rows.add(row);
					continue;
				}
			}
			
			//本校任教起始时间
			String teachingTime = DataUtil.getCellValue(row.getCell(getIndex("本校任教起始时间", rowOne)));
			if(teachingTime.length() >0){
				if(teachingTime.length()== 10 && DataUtil.validatedate(teachingTime)){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Date d;
					try {
						d = sdf.parse(teachingTime);
						dto.setJobWorkDate(teachingTime);
					} catch (Exception e) {
						row.getCell(errCell).setCellValue("本校任教起始时间格式不正确！例：2009/7/1！");
						rows.add(row);
						continue;
					}
				}else{
					row.getCell(errCell).setCellValue("本校任教起始时间格式不正确！例：2009/7/1！");
					rows.add(row);
					continue;
				}
			}
			
			//借调分流单位
			String jdfldw = DataUtil.getCellValue(row.getCell(getIndex("借调分流单位", rowOne)));
			if(jdfldw.length()>0){
				dto.setJdfldw(jdfldw);
			}
			
			//借调分流时间(时间)
			String jdflTime = DataUtil.getCellValue(row.getCell(getIndex("借调分流时间", rowOne)));
			if(jdflTime.length() >0){
				if(jdflTime.length()== 10 && DataUtil.validatedate(jdflTime)){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Date d;
					try {
						d = sdf.parse(jdflTime);
						dto.setJdflTime(jdflTime);
					} catch (Exception e) {
						row.getCell(errCell).setCellValue("借调分流时间格式不正确！例：2009/7/1！");
						rows.add(row);
						continue;
					}
				}else{
					row.getCell(errCell).setCellValue("借调分流时间格式不正确！例：2009/7/1！");
					rows.add(row);
					continue;
				}
			}
			//离岗待退时间(时间)
			String postBack = DataUtil.getCellValue(row.getCell(getIndex("离岗待退时间", rowOne)));
			if(postBack.length() >0){
				if(postBack.length()== 10 && DataUtil.validatedate(postBack)){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Date d;
					try {
						d = sdf.parse(postBack);
						dto.setPostBack(postBack);
					} catch (Exception e) {
						row.getCell(errCell).setCellValue("离岗待退时间格式不正确！例：2009/7/1！");
						rows.add(row);
						continue;
					}
				}else{
					row.getCell(errCell).setCellValue("离岗待退时间格式不正确！例：2009/7/1！");
					rows.add(row);
					continue;
				}
			}
			//是否全日制师范类专业毕业
			String CD = DataUtil.getCellValue(row.getCell(getIndex("是否全日制师范类专业毕业", rowOne)));
			
			if(CD.length()>0){
				int yeaOrNo = DataUtil.yesOrNo(CD);
				if( yeaOrNo != -1){
					dto.setQrzsfzy(yeaOrNo);
				}else{
					row.getCell(errCell).setCellValue("是否全日制师范类专业毕业格式不正确！请填写是或者否");
					rows.add(row);
					continue;
				}
			}
			//近三年专任教师接受培训情况
			String CE = DataUtil.getCellValue(row.getCell(getIndex("近三年专任教师接受培训情况", rowOne)));
			if(CE.length()>0){
				dto.setJsnpxqk(CE);
			}
			
			//是否属于免费师范生
			String CF = DataUtil.getCellValue(row.getCell(getIndex("是否属于免费师范生", rowOne)));
			
			if(CF.length()>0 && !CF.equals("否")){
				dic = DataUtil.validateDic(freeTeacher, CF);
				if(dic != null){
					dto.setMfsfs(dic.getDictionaryId());
				}else{
					row.getCell(errCell).setCellValue("是否属于免费师范生格式不正确！");
					rows.add(row);
					continue;
				}
			}
			//是否是特岗教师
			String CG = DataUtil.getCellValue(row.getCell(getIndex("是否是特岗教师", rowOne)));
			
			if(CG.length()>0 && !CG.equals("否")){
				dic = DataUtil.validateDic(specialTeacher, CG);
				if(dic != null){
					dto.setTgjs(dic.getDictionaryId());
				}else{
					row.getCell(errCell).setCellValue("是否是特岗教师格式不正确！");
					rows.add(row);
					continue;
				}
			}
			//继教编号
			String CH = DataUtil.getCellValue(row.getCell(getIndex("继续教育编号", rowOne)));
			if(CH.length()>0){
				dto.setJxjybh(CH);
			}
			
			//荣誉称号
			String CI = DataUtil.getCellValue(row.getCell(getIndex("荣誉称号", rowOne)));
			if(CI.length()>0){
				dto.setRych(CI);
			}
			//编制类别
			String CJ = DataUtil.getCellValue(row.getCell(getIndex("编制类别", rowOne)));
			if(CJ.length()>0){
				dic = DataUtil.validateDic(bzlb, CJ);
				if(dic != null){
//					dto.setTeacherStaff(dic.getDictionaryId());
					dto.setAdjustId(dic.getDictionaryId()); 
					dto.setAdjustName(dic.getDictionaryName());
				}else{
					row.getCell(errCell).setCellValue("编制类别不正确！");
					rows.add(row);
					continue;
				}
			}
			//学校编码
			String CK = DataUtil.getCellValue(row.getCell(getIndex("单位标识码/学校编码（请查询单位标识码表）", rowOne)  + getIndex("学校代码/机构代码", rowOne)));
			EduSchool s = DataUtil.validateSchool(schools, CK);
			if(CK.length()>0 && s != null){
				dto.setSchoolProvinceId(String.valueOf(s.getSchoolProvinceId()));
				dto.setSchoolCityName(s.getSchoolCityName());
				dto.setSchoolProvinceName(s.getSchoolProvinceName());
				dto.setSchoolDistrictName(s.getSchoolDistrictName());
				dto.setSchoolCityId(String.valueOf(s.getSchoolCityId()));
				dto.setSchoolDistrictId(String.valueOf(s.getSchoolDistrictId()));
				dto.setSchoolId(s.getSchoolId());
				dto.setSchoolName(s.getSchoolName());
			}else{
				row.getCell(errCell).setCellValue("学校编码不正确！");
				rows.add(row);
				continue;
			}
			
			//出生日期
			//String CL = DataUtil.getCellValue(row.getCell(getIndex("出生日期", rowOne)));
			//出生日期,出生日期从身份证号中获得
			String CL = "";
			if(IDCard.length()==15){
				CL = "19" + IDCard.substring(6, 12);
			}
			if(IDCard.length()==18){
				CL = IDCard.substring(6, 14);
			}
			if(CL.length()>0){
				if(DataUtil.validateNum2(CL) && CL.length()==8){
					dto.setBirth(CL);
				}else{
					row.getCell(errCell).setCellValue("出生日期不正确！格式：20130901");
					rows.add(row);
					continue;
				}
			}
			//民族
			String CM = DataUtil.getCellValue(row.getCell(getIndex("民族", rowOne)));
			
			if(CM.length()>0){
				dto.setMz(CM);
			}
			
			//参加工作时间
			String CN = DataUtil.getCellValue(row.getCell(getIndex("参加工作时间", rowOne)));
			if(CN.length() >0){
				if(CN.length()== 10 && DataUtil.validatedate(CN)){
					try {
						dto.setJobWorkTime(CN);
					} catch (Exception e) {
						row.getCell(errCell).setCellValue("参加工作时间格式不正确！例：2009/7/1！");
						rows.add(row);
						continue;
					}
				}else{
					row.getCell(errCell).setCellValue("参加工作时间格式不正确！例：2009/7/1！");
					rows.add(row);
					continue;
				}
				
			}
			//是否名校长培养对象
			String eliteTraining = DataUtil.getCellValue(row.getCell(getIndex("是否名校长培养对象", rowOne)));
			if(eliteTraining.length()>0 && !eliteTraining.equals("否")){
				dic = DataUtil.validateDic(mspydx, eliteTraining);
				if(dic != null){
					dto.setEliteTrainingType(dic.getDictionaryId());
					dto.setEliteTraining(eliteTraining);
				}else{
					row.getCell(errCell).setCellValue("是否名校长培养对象格式不正确！");
					rows.add(row);
					continue;
				}
			}
			
			//是否教学名师
			String teachingMaster = DataUtil.getCellValue(row.getCell(getIndex("是否教学名师", rowOne)));
			if(teachingMaster.length()>0 && !teachingMaster.equals("否")){
				dic = DataUtil.validateDic(jxms, teachingMaster);
				if(dic != null){
					dto.setTeachingMasterType(dic.getDictionaryId());
					dto.setTeachingMaster(teachingMaster);
				}else{
					row.getCell(errCell).setCellValue("是否教学名师格式不正确！");
					rows.add(row);
					continue;
				}
			}
			//是否学科带头人
			String jobSubjectLeader = DataUtil.getCellValue(row.getCell(getIndex("是否学科带头人", rowOne)));
			if(jobSubjectLeader.length()>0 && !jobSubjectLeader.equals("否")){
				dic = DataUtil.validateDic(xkdtr, jobSubjectLeader);
				if(dic != null){
					dto.setJobSubjectLeader(dic.getDictionaryId());
					dto.setJobSubjectLeaderName(jobSubjectLeader);
				}else{
					row.getCell(errCell).setCellValue("是否学科带头人格式不正确！");
					rows.add(row);
					continue;
				}
			}
			//备注
			String remark = DataUtil.getCellValue(row.getCell(getIndex("备注", rowOne)));
			if(remark.length()>0){
				dto.setRemark(remark);
			}
			
			dbRows.add(row);
			dtos.add(dto);
		}else{
			break;
		}
	}
	//存数据库的数据
	result.put("toDB", dtos);
	result.put("toDBRow", dbRows);
	//错误的数据
	result.put("toExl", rows);
	return result;
}

@Override
public Map<String, Object> parseStudentExcel(InputStream is, String fileType,Map<String,Object> params)
		throws Exception {
	Map<String, Object> result = new HashMap<String, Object>();
	int projectId = Integer.parseInt(params.get("projectId").toString());
	
	//正确的数据
	List<Integer> ids = new ArrayList<Integer>();
	List<Row> dbRows = new ArrayList<Row>();
	//数据不合格的row
	List<Row> rows = new ArrayList<Row>();
	
	Workbook wb = null;
	if(fileType.equalsIgnoreCase("xls")){
		wb = new HSSFWorkbook(is);
		}else{
			wb = new HSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		int max = sheet.getLastRowNum();
		for(int i = 1;i<=max+1;i++){
			Row row = sheet.getRow(i);
			if(row!=null){
				if(row.getCell(11) == null){
					row.createCell(11);
				}
				String name = DataUtil.getCellValue(row.getCell(0));
				//String no = DataUtil.getCellValue(row.getCell(1));//教师编号
				String id = DataUtil.getCellValue(row.getCell(1));
				String province = DataUtil.getCellValue(row.getCell(2));
				String city = DataUtil.getCellValue(row.getCell(3));
				String district = DataUtil.getCellValue(row.getCell(4));
				String school = DataUtil.getCellValue(row.getCell(5));
				String schoolCode = DataUtil.getCellValue(row.getCell(6));
				String subject = DataUtil.getCellValue(row.getCell(7));
				String phone = DataUtil.getCellValue(row.getCell(8));
				String email = DataUtil.getCellValue(row.getCell(9));
				if(name.length()==0 && id.length() ==0 && province.length()==0
						&& city.length() == 0 && district.length() == 0 && school.length() == 0&& schoolCode.length() == 0&& subject.length() == 0 && phone.length() == 0 && email.length() == 0){
					continue;
				}
				if(id.length() == 0){
					rows.add(row);
					continue;
				}
				Map<String,Object> param = new HashMap<String,Object>();
				param.put("name", name.length()>0?name:null);
				//param.put("no", no.length()>0?no:null);
				param.put("id", id.length()>0?id:null);
				param.put("province", province.length()>0?province:null);
				param.put("city", city.length()>0?city:null);
				param.put("district", district.length()>0?district:null);
				param.put("school", school.length()>0?school:null);
				param.put("schoolCode", schoolCode.length()>0?schoolCode:null);
//				param.put("phone", phone.length()>0?phone:null);
//				param.put("email",email.length()>0?email:null);
				param.put("subject", subject.length()>0?subject:null);
				//userId
				int n = userReadDao.countUserByCondition(param);
				if(n>0){
					StringBuffer failMsg = new StringBuffer("");
					if(canSign(projectId, n, failMsg)){
						if(!hasSign(n, projectId)){//是否已经参加项目
							dbRows.add(row);
							ids.add(n);
						}else{
							row.getCell(11).setCellValue("该教师已经报名！");
							rows.add(row);
							continue;
						}
						
					}else{
						row.getCell(11).setCellValue(failMsg.toString());
						rows.add(row);
						continue;
					}
					
				}else{
					row.getCell(11).setCellValue("没有查到该教师，请仔细核对教师信息！");
					rows.add(row);
					continue;
				}
			}
		}
		//去重，不能重复报名
		Set<Integer> set = new HashSet<Integer>();
		for(Integer id:ids){
			set.add(id);
		}
		ids.clear();
		for(Integer id:set){
			ids.add(id);
		}
		//存数据库的数据
		result.put("toDB", ids);
		result.put("toDBRow", dbRows);
		//错误的数据
		result.put("toExl", rows);
		return result;
	}

/**
 * 解析导入教师离退记录
 * @param is
 * @param fileType
 * @return
 * @throws Exception
 */
@Override
public Map<String, Object> parseRetireesTeacherExcel(InputStream is, String fileType,Map<String,Object> params)
		throws Exception {
	Map<String, Object> result = new HashMap<String, Object>();
	//正确的数据
	List<Integer> ids = new ArrayList<Integer>();
	List<Row> dbRows = new ArrayList<Row>();
	//数据不合格的row
	List<Row> rows = new ArrayList<Row>();
	Workbook wb = null;
	if(fileType.equalsIgnoreCase("xls")){
		wb = new HSSFWorkbook(is);
		}else{
			wb = new HSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		int max = sheet.getLastRowNum();
		for(int i = 1;i<max+1;i++){
			Row row = sheet.getRow(i);
			if(row!=null){
				String name = DataUtil.getCellValue(row.getCell(0));
				String idNumber = DataUtil.getCellValue(row.getCell(1));
				String changeType = DataUtil.getCellValue(row.getCell(2));
				if(changeType.length()==0 && idNumber.length() == 0){
					row.createCell(3).setCellValue("未指定离退休类型（离休/退休）");
					rows.add(row);
					continue;
				}
				Map<String,Object> param =  (Map<String, Object>) ((HashMap<String, Object>) params).clone();
				param.put("name", name.length()>0?name:null);
				param.put("id", idNumber.length()>0?idNumber:null);
				param.put("changeType", changeType.length()>0?changeType:null);
				param.put("retirees", 1);
				// 验证教师  是否存在系统  且 不处于离退状态
				if((!StringUtils.isEmpty(name) || !StringUtils.isEmpty(idNumber)) &&  !StringUtils.isEmpty(changeType)) {
					int n = userReadDao.countUserByRetiree(param);
					if(n>0){
						// 验证是否已经提交离退申请
						param.clear();
						param.put("teacherId", n);
						param.put("auditStatus", Common.COMMON_AUDIT_UNHANDL);
						param.put("changeTypeRetiees","changeTypeRetiees");
						int count = teacherReadDao.selectMobilizeCount(param);
						if(count > 0) {
							row.createCell(3).setCellValue("已经存在改教师的未审核离退休记录");
							rows.add(row);
						} else {
							dbRows.add(row);
							ids.add(n);
						}
					} else {
						row.createCell(3).setCellValue("未查询到该教师存在系统中的记录");
						rows.add(row);
					}
				}else{
					row.createCell(3).setCellValue("该教师已经处于离退休状态");
					rows.add(row);
				}
				
			}
		}
		//去重
		Set<Integer> set = new HashSet<Integer>();
		for(Integer id:ids){
			set.add(id);
		}
		ids.clear();
		for(Integer id:set){
			ids.add(id);
		}
		//存数据库的数据
		result.put("toDB", ids);
		result.put("toDBRow", dbRows);
		//错误的数据
		result.put("toExl", rows);
		return result;
	}


	@Override
	public boolean procBatchSignUp(List<Integer> ids, int projectId,String account,String type)
			throws Exception {
		//去除已经报名的老师
		List<Integer> tids = eduProjectReadDAO.selectTeacherIdsByProjectId(projectId);
		ids.removeAll(tids);
		return proWriteDao.insertCommentBatch(ids, projectId,account,type);
	}

	public boolean procWrite2ImportTeacherHistory(String account,String realName,Date date,int total,int toExl,String names,String failUrl, String type) throws Exception{
		boolean flag = false;
		EduTeacherImportHistory history = new EduTeacherImportHistory();
		history.setCreateBy(account);
		history.setOptionRealName(realName);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		history.setOptionYear(cal.get(Calendar.YEAR));
		history.setImortFailCount(toExl);
		history.setImportSuccessCount(total);
		history.setImportFailUrl(failUrl);
		history.setCreateDate(date);
		history.setImportFileName(names);
		history.setHistoryType(type);
		flag = proWriteDao.insertImportTeacherHistory(history);
		return flag;
	}

	@Override
	public PageObject selectModelList(Map<String, Object> paramMap,
			int startIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.selectModelCountByParamMap(paramMap);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<EduModel> proList = eduProjectReadDAO.selectModelList(paramMap);
		
		//这里进行处理
		List<Integer> modelListIds = Collections.EMPTY_LIST;
		modelListIds = 	eduProjectReadDAO.selectModelListIds();
		
		for (EduModel eduModel : proList) {
			if(modelListIds.isEmpty()){
				eduModel.setUsed(0);
			}else{
				for (Integer eduModeId : modelListIds) {  //1.2
					// 如果项目中已经使用了该继教板块，则设置为已用
					if (eduModel.getId().equals(eduModeId) ) {
						eduModel.setUsed(1);
						break;
					} else {
						eduModel.setUsed(0);
					}
				}
			}
			
		}
		
		po.setObjects(proList);
		return po;
	}

	@Override
	public boolean insertModelInfo(Map<String, Object> paramMap)
			throws Exception {
		return proWriteDao.insertModelInfo(paramMap);
	}
	
	@Override
	public 	String checkModelName(String modelName) throws Exception{
		return proWriteDao.checkModelName(modelName);
	}
	
	@Override
	public String checkModelName(int modelId, String modelName)
			throws Exception {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("modelId", modelId);
		param.put("modelName", modelName);
		return proWriteDao.checkModelName(param);
	}
	
	@Override
	public 	String checkModelCode(String modelCode) throws Exception{
		return proWriteDao.checkModelCode(modelCode);
	}
	
	@Override
	public 	String checkModelCode(int modelId,String code) throws Exception{
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("modelId", modelId);
		param.put("modelCode", code);
		return proWriteDao.checkModelCode(param);
	}

	@Override
	public EduModel qryModelInfo(int id) throws Exception {
		return eduProjectReadDAO.selectModelInfoById(id);
	}
	
	@Override
	public List<Object> queryProjectListByStatus(Map<String, Object> conditions) throws Exception {
		List<Object> proList = eduProjectReadDAO.selectProjectListByCondition(conditions);
		return proList;
	}
	
	@Override
	public PageObject queryProjectListByStatus(Map<String, Object> conditions,
			int startIndex, int pageSize) throws Exception {
		
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.countProjectByStatus(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProject> proList = eduProjectReadDAO.selectProjectListByStatus(conditions);
		po.setObjects(proList);
		return po;
	}
	/*
	 * 
	 * 
	 * 报名审核
	 */

	@Override
	public PageObject ProjectByRegistration(Map<String, Object> conditions,
			int startPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.ProjectByRegistrationCount(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startPage, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProject> proList = eduProjectReadDAO.ProjectByRegistration(conditions);
		po.setObjects(proList);
		return po;
	}
	@Override
	public PageObject queryProjectListByStatusUpdate(Map<String, Object> conditions,
			int startIndex, int pageSize) throws Exception {
		
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.countProjectByStatusPage(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProject> proList = eduProjectReadDAO.selectProjectListByStatusUpdate(conditions);
		po.setObjects(proList);
		return po;
	}
	 /**
	  * 查询已发布成绩的项目列表
	  * 
	  */
	@Override
	public PageObject queryProjectListByStatuses(Map<String, Object> conditions,
			int startIndex, int pageSize) throws Exception {
		
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.countProjectPublicByStatus(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProject> proList = eduProjectReadDAO.selectProjectPublicListByStatus(conditions);
		po.setObjects(proList);
		return po;
	}
	
	
	@Override
	public PageObject queryProjectListByStatus(Map<String, Object> conditions,int startIndex, int pageSize,String queryFlag) throws Exception {
		
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.countProjectByStatus(conditions,queryFlag);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProject> proList = eduProjectReadDAO.selectProjectListByStatus(conditions,queryFlag);
		po.setObjects(proList);
		return po;
	}
	
	@Override
	public PageObject paperList(Map<String, Object> conditions, int startIndex,
			int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.selectPaperCountByConditions(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduPaper> ppList = eduProjectReadDAO.selectPaperListByPid(conditions);
		po.setObjects(ppList);
		return po;
	}

	@Override
	public int insertPaper(EduPaper eduPaper) throws Exception {
		return proWriteDao.insertPaper(eduPaper);
	}

	@Override
	public int insertQuestion(EduQuestion eduQuestion) throws Exception {
		return proWriteDao.insertQuestion(eduQuestion);
	}

	@Override
	public int insertQuestionOptions(EduQuestionOptions eduQuestionOptions)
			throws Exception {
		return proWriteDao.insertQuestionOptions(eduQuestionOptions);
	}

	@Override
	public boolean updatePaper(EduPaper eduPaper) throws Exception {
		return proWriteDao.updatePaper(eduPaper);
	}

	@Override
	public boolean updateQuestion(EduQuestion eduQuestion) throws Exception {
		return proWriteDao.updateQuestion(eduQuestion);
	}

	@Override
	public boolean updateQuestionOptions(EduQuestionOptions eduQuestionOptions)
			throws Exception {
		return proWriteDao.updateQuestionOptions(eduQuestionOptions);
	}

	@Override
	public EduPaper selectEduPaperById(int papId) throws Exception {
		return eduProjectReadDAO.selectEduPaperById(papId);
	}

	@Override
	public EduQuestion selectEduQuestionById(int eqId) throws Exception {
		return eduProjectReadDAO.selectEduQuestionById(eqId);
	}

	@Override
	public EduQuestionOptions selectEduQuestionOptionsById(int eqoId)
			throws Exception {
		return eduProjectReadDAO.selectEduQuestionOptionsById(eqoId);
	}

	@Override
	public PageObject selectEduQuestionListByPapid(
			Map<String, Object> conditions, int startIndex, int pageSize)
			throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.selectEduQuestionCountByConditionsByPapid(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduQuestion> ppList = eduProjectReadDAO.selectEduQuestionListByPapid(conditions);
		po.setObjects(ppList);
		return po;
	}

	@Override
	public PageObject selectEduQuestionOptionsListByQid(
			Map<String, Object> conditions, int startIndex, int pageSize)
			throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.selectEduQuestionOptionsCountByConditionsByQid(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduQuestionOptions> ppList = eduProjectReadDAO.selectEduQuestionOptionsListByQid(conditions);
		po.setObjects(ppList);
		return po;
	}
	/**
	 * 申报项目
	 */
	@Override
	public Map<String,Object> procDeclareProject(int projectId,int accountId,List<MultipartFile> files,String path) throws Exception {
		String attechement = "";
		String names = "";
		String projectNO = eduProjectReadDAO.selectProFullInfoById(projectId).getProjectNo();
		Map<String,Object> resultMap = new HashMap<String, Object>();
//		String projectNO = dto.getProjectNo();
		Map<String, Object> params = new HashMap<String, Object>();
		EduProject pro = new EduProject();
//		if (!FileUtils.isFileExists(files)) {
//			// 需要上传文件
//			resultMap.put("success", false);
//			resultMap.put("info", "请上传文件");
//			return resultMap;
//		}
//		
//		File dir = new File(path);
//		if(!dir.exists()){
//			dir.mkdir();
//		}
//		path = path+projectNO+File.separator;
//		
		
//		for (MultipartFile file : files) {
//
//			// 空文件检查
//			if (FileUtils.isEmptyFile(files)) {
//				resultMap.put("success", false);
//				resultMap.put("info", "待上传的文件列表中有空文件");
//				return resultMap;
//			}
//			// 待上传文件有重复文件检查
//			if (FileUtils.isTheSameNameFile(files)) {
//				resultMap.put("success", false);
//				resultMap.put("info", "待上传的文件列表中有重复文件");
//				return resultMap;
//			}
//		
//			try {
//				if(file.getSize()>0){
//					names += file.getOriginalFilename()+",";
//					String name = FileUtils.write(file, path);
//					attechement += projectNO+"/"+name+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length())+",";
//				}
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			pro.setProjectAttchement(attechement.substring(0, attechement.length()-1));
//			pro.setFileName(names.substring(0, names.length()-1));
//		}
		pro.setProjectAttchement("setProjectAttchement");
		pro.setFileName("setFileName");
		pro.setId(projectId);
		params.put("status", Common.PROJECT_COMMON_STATUS.get("未审批"));
		params.put("projectId", projectId);
		proWriteDao.updateProject(pro);
		boolean ok1 = proWriteDao.updateProjectStatus(params);
		
		//以下代码是引起bug：2303的原因，但是不知道注释掉后有没有其他的影响，先删除再说
		//删除后，审核页面出不来
		EduProjectAuditPOJO audit = new EduProjectAuditPOJO();
		audit.setProjectId(projectId);
		audit.setApplicantId(accountId);
		boolean ok2 = proWriteDao.insertProjectAudit(audit);
		
		if(ok1&&ok2){
			resultMap.put("success", true);
			resultMap.put("info", "申报成功");
		}else{
			resultMap.put("success", false);
			resultMap.put("info", "申报失败");
		}
//		return ok1 && ok2;
		return resultMap;
	}
	
	
	/**
	 * 重新申报项目
	 */
	@Override
	public Map<String,Object> procDeclareProjectAgain(int projectId,String accountName,int accountId,List<MultipartFile> files,String path) throws Exception {
		String attechement = "";
		String names = "";
		String projectNO = eduProjectReadDAO.selectProFullInfoById(projectId).getProjectNo();
		Map<String,Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		EduProject pro = new EduProject();
		if (!FileUtils.isFileExists(files)) {
			// 需要上传文件
			resultMap.put("success", false);
			resultMap.put("info", "请上传文件");
			return resultMap;
		}
		
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdir();
		}
		path = path+projectNO+File.separator;
		
		
		for (MultipartFile file : files) {

			// 空文件检查
			if (FileUtils.isEmptyFile(files)) {
				resultMap.put("success", false);
				resultMap.put("info", "待上传的文件列表中有空文件");
				return resultMap;
			}
			// 待上传文件有重复文件检查
			if (FileUtils.isTheSameNameFile(files)) {
				resultMap.put("success", false);
				resultMap.put("info", "待上传的文件列表中有重复文件");
				return resultMap;
			}
			try {
				if(file.getSize()>0){
					names += file.getOriginalFilename()+",";
					String name = FileUtils.write(file, path);
					attechement += projectNO+"/"+name+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length())+",";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			pro.setProjectAttchement(attechement.substring(0, attechement.length()-1));
			pro.setFileName(names.substring(0, names.length()-1));
		}

		pro.setId(projectId);
		params.put("status", Common.PROJECT_COMMON_STATUS.get("未审批"));
		params.put("projectId", projectId);
		proWriteDao.updateProject(pro);
		boolean ok1 = proWriteDao.updateProjectStatus(params);
		
		EduProjectAuditPOJO audit = new EduProjectAuditPOJO();
		audit.setApplicantId(accountId);
		audit.setProjectId(projectId);
		audit.setAuditorId(accountId);
		audit.setAuditStatus(-1);//还未审核
		audit.setAuditorRealName(accountName);
		boolean ok2 = proWriteDao.updateProjectAudit(audit);
		
		if(ok1&&ok2){
			resultMap.put("success", true);
			resultMap.put("info", "申报成功");
		}else{
			resultMap.put("success", false);
			resultMap.put("info", "申报失败");
		}
		return resultMap;
	}
	
	/**
	 * 审核项目
	 */
	public boolean procAuditProject(int status,String memo,int projectId,int accountId,String realName, String loginAccount) throws Exception{
		Map<String, Object> params = new HashMap<String, Object>();
		Integer ss = status==1?Common.PROJECT_COMMON_STATUS.get("待启动"):Common.PROJECT_COMMON_STATUS.get("审批不通过");
		params.put("status", ss);
		params.put("projectId", projectId);
		boolean ok1 = proWriteDao.updateProjectStatus(params);
		
		EduProjectAuditPOJO audit = new EduProjectAuditPOJO();
		audit.setProjectId(projectId);
		audit.setAuditorId(accountId);
		audit.setAuditStatus(status);
		audit.setMemo(memo);
		audit.setAuditorRealName(realName);
		audit.setAuditDate(new Date());
		boolean ok2 = proWriteDao.updateProjectAudit(audit);
		
		//对审核通过的项目添加至edu_organization_project中
		if(status == 1){
			//为实施机构获取项目配置信息（学科、计划培训人数）
			EduProjectDTO project = eduProjectReadDAO.selectProFullInfoById(projectId);
			
			Organization o = new Organization();
			o.setProjectId(projectId+"");
			o.setOrganizationId(project.getOrgId());			
			o.setOrganizationName(project.getOrganizationName());
			o.setTrainingAddress("http://");
			o.setTrainingHomeAddress("http://");
			//培训学科
			o.setSubjectIds(project.getSubjectId());
			o.setSubjectName(project.getSubjectName());
			//计划人数
			o.setPlanNum(project.getPlanNum());
			o.setAreaCode(project.getTrainScopeId());
			o.setAreaName(project.getTrainScopeName());
			
			List<Organization> orgList = new ArrayList<Organization>();
			orgList.add(o);
			
			Map<String, Object> result = assginOrg(loginAccount, projectId, orgList);
			return ok1 && ok2 && (Boolean)result.get("success");
		}
		
		return ok1 && ok2;
	}
	
	public EduProjectAuditPOJO procQueryAuditInfo(int projectId) throws Exception{
		return eduProjectReadDAO.selectAuditInfo(projectId);
	}

	@Override
	public List<EduProjectAllocateByArea> queryAllocateInfo(int areaId,String type,int projectId,String schoolName)
			throws Exception {
		List<EduProjectAllocateByArea> list = new ArrayList<EduProjectAllocateByArea>();
		
		Map<String,Object> pram = new HashMap<String,Object>();
		pram.put("belong", areaId);
		//层级下的地区
		
		if(type.equals("2")){
			if(schoolName==null||schoolName.equals("")){
				return eduProjectReadDAO.selectSchool(areaId,projectId);
			}else{
				return eduProjectReadDAO.selectSchool(areaId,projectId,schoolName);
			}

		}else{
//			List<SysArea> areas = sysReadDAO.selectAreaByBelong(pram);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("projectId", projectId);
//			for(SysArea area:areas){
//				EduProjectAllocateByArea aba = new EduProjectAllocateByArea();
//				aba.setAreaId(area.getId());
//				aba.setAreaName(area.getName());
//				map.put("areaId", area.getId());
//				EduProjectAllocateByArea tt =  eduProjectReadDAO.selectAllocateByAreaAndProject(map);
//				if(tt != null){
//					aba.setAllocateFactNum(tt.getAllocateFactNum());
//					aba.setAllocatePlanNum(tt.getAllocatePlanNum());
//					aba.setStatus(tt.getStatus());
//				}
//				list.add(aba);
				list = eduProjectReadDAO.selectAllocateByAreaId(areaId,projectId);
//			}
			
//			return eduProjectReadDAO.selectAllocateByAreaId(areaId,projectId);
			return list;
		}
	}	
	@Override
	public List<EduProjectAllocateByArea> queryAllocateInfo(int areaId,String type,int projectId,int schoolId)
			throws Exception {
		List<EduProjectAllocateByArea> list = new ArrayList<EduProjectAllocateByArea>();
		
		Map<String,Object> pram = new HashMap<String,Object>();
		pram.put("belong", areaId);
		//层级下的地区
		
		if(type.equals("2")){
			if(schoolId==0){
				return eduProjectReadDAO.selectSchool(areaId,projectId);
			}else{
				return eduProjectReadDAO.selectSchool(areaId,projectId,schoolId);
			}

		}else{
//			List<SysArea> areas = sysReadDAO.selectAreaByBelong(pram);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("projectId", projectId);
//			for(SysArea area:areas){
//				EduProjectAllocateByArea aba = new EduProjectAllocateByArea();
//				aba.setAreaId(area.getId());
//				aba.setAreaName(area.getName());
//				map.put("areaId", area.getId());
//				EduProjectAllocateByArea tt =  eduProjectReadDAO.selectAllocateByAreaAndProject(map);
//				if(tt != null){
//					aba.setAllocateFactNum(tt.getAllocateFactNum());
//					aba.setAllocatePlanNum(tt.getAllocatePlanNum());
//					aba.setStatus(tt.getStatus());
//				}
//				list.add(aba);
				list = eduProjectReadDAO.selectAllocateByAreaId(areaId,projectId);
//			}
			
//			return eduProjectReadDAO.selectAllocateByAreaId(areaId,projectId);
			return list;
		}
	}
	
	@Override
	public List<EduProjectAllocateByArea> queryAllocateInfoes(int areaId,String type,int projectId,String schoolName,Integer schoolTypeId)
			throws Exception {
		List<EduProjectAllocateByArea> list = new ArrayList<EduProjectAllocateByArea>();
		
		Map<String,Object> pram = new HashMap<String,Object>();
		pram.put("belong", areaId);
		//层级下的地区
		
		if(type.equals("2")){
			if(schoolName==null||schoolName.equals("")||schoolTypeId==null||schoolTypeId.equals("")){
				/*return eduProjectReadDAO.selectSchool(areaId,projectId);*/
				return eduProjectReadDAO.selectSchooles(areaId,projectId,schoolName,schoolTypeId);
			}else{
				return eduProjectReadDAO.selectSchooles(areaId,projectId,schoolName,schoolTypeId);
			}
			
		}else{
//			List<SysArea> areas = sysReadDAO.selectAreaByBelong(pram);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("projectId", projectId);
//			for(SysArea area:areas){
//				EduProjectAllocateByArea aba = new EduProjectAllocateByArea();
//				aba.setAreaId(area.getId());
//				aba.setAreaName(area.getName());
//				map.put("areaId", area.getId());
//				EduProjectAllocateByArea tt =  eduProjectReadDAO.selectAllocateByAreaAndProject(map);
//				if(tt != null){
//					aba.setAllocateFactNum(tt.getAllocateFactNum());
//					aba.setAllocatePlanNum(tt.getAllocatePlanNum());
//					aba.setStatus(tt.getStatus());
//				}
//				list.add(aba);
			list = eduProjectReadDAO.selectAllocateByAreaId(areaId,projectId);
//			}
			
//			return eduProjectReadDAO.selectAllocateByAreaId(areaId,projectId);
			return list;
		}
	}

	/**
	 * @author liuyiyou
	 * 不能简单的更新，需要在更新之前，需要先确定该继教板块是否被使用
	 */
	@Override
	public boolean updateModelInfoById(Map<String,Object> paramMap) throws Exception {
		String id = paramMap.get("id").toString();//继教板块id
		List<EduProject> eduProjects = Collections.EMPTY_LIST;
		//查询该继教板块是否被使用
		eduProjects =  eduProjectReadDAO.getEduProjectByEduModelType(id);
		if(eduProjects.isEmpty()){
			return proWriteDao.updateModelInfo(paramMap);
		}
		return false;
	}
	
	public boolean deleteModelInfoById(Integer id)throws Exception{
		Integer result = proWriteDao.deleteModelInfoById(id);
		if(result>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean saveOrUpdateAllocate(EduProjectAllocateByArea allocate) throws Exception {
		Integer areaId = null;
		
		if(allocate.getType() == 0){//地区
			areaId = allocate.getAreaId();
		}else{//学校
			areaId = sysReadDAO.selectSysSchoolInfo(allocate.getAreaId()).getSchoolDistrictId();
		}
		String type = sysReadDAO.selectAreaByCode(areaId.toString()).getType();
		if(type.equals("1")){//分配市级
			if(proWriteDao.countAllocateByProject(allocate)>0){
				return proWriteDao.updateAllocate(allocate);
			}else{
				return proWriteDao.insertAllocate(allocate);
			}
		}
		else if(type.equals("0")){
			if(proWriteDao.countAllocateByProject(allocate)>0){
				return proWriteDao.updateAllocate(allocate);
			}else{
				return proWriteDao.insertAllocate(allocate);
			}	
		}
		else{//分配区级与校级
			EduProjectAllocateByArea alc = new EduProjectAllocateByArea();
			alc.setAreaId(Integer.parseInt(sysReadDAO.selectAreaByCode(areaId.toString()).getUpLvCode()));
			alc.setType(0);
			alc.setProjectId(allocate.getProjectId());
			int count = proWriteDao.countAllocateByProject(alc);
			String projectAreaId = eduProjectReadDAO.selectProFullInfoById(allocate.getProjectId()).getTrainScopeId();
			String projectAreaType = sysReadDAO.selectAreaByCode(projectAreaId).getType();
			
			if(count>0 || projectAreaType.equals("1") || projectAreaType.equals("2")){//已分配人数 或者是市级区级的项目
				if(proWriteDao.countAllocateByProject(allocate)>0){
					//boolean b = 
					return proWriteDao.updateAllocate(allocate);
				}else{
					return proWriteDao.insertAllocate(allocate);
				}
			}
		}
		
		
		return false;
//		return proWriteDao.updateAllocate(allocate);
	}

	@Override
	public EduProjectAllocateByArea selectAllocateByArea(
			EduProjectAllocateByArea allocate) throws Exception {
		return eduProjectReadDAO.selectAllocate(allocate);
	}
	@Override
	public int insertResponse(EduResponse eduResponse) throws Exception {
		return proWriteDao.insertResponse(eduResponse);
	}

	@Override
	public boolean updateResponse(EduResponse eduResponse) throws Exception {
		return proWriteDao.updateResponse(eduResponse);
	}

	@Override
	public int insertResponseQuestion(EduResponseQuestion responseQuestion)
			throws Exception {
		return proWriteDao.insertResponseQuestion(responseQuestion);
	}

	@Override
	public boolean updateResponseQuestion(EduResponseQuestion responseQuestion)
			throws Exception {
		return proWriteDao.updateResponseQuestion(responseQuestion);
	}

	@Override
	public boolean modifyAllocateByArea(EduProjectAllocateByArea allocate)
			throws Exception {
		return proWriteDao.updateAllocate(allocate);
	}

	@Override
	public EduResponse selectEduResponseById(Integer id) throws Exception {
		return eduProjectReadDAO.selectEduResponseById(id);
	}

	@Override
	public EduResponseQuestion selectEduResponseQuestionById(Integer id)
			throws Exception {
		return eduProjectReadDAO.selectEduResponseQuestionById(id);
	}


	@Override
	public PageObject selectEduResponseListByCondition(
			Map<String, Object> conditions,int startIndex,
			int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.countEduResponseByCondition(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduResponse> ppList = eduProjectReadDAO.selectEduResponseListByCondition(conditions);
		po.setObjects(ppList);
		
		return po;
	}

	@Override
	public PageObject selectEduResponseQuestionListByCondition(
			Map<String, Object> conditions,int startIndex,
			int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.countEduResponseQuestionByCondition(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduResponseQuestion> ppList = eduProjectReadDAO.selectEduResponseQuestionListByCondition(conditions);
		po.setObjects(ppList);
		return po;
	}

	/**
	 * 实施机构 --> 承培机构任务分配列表查询
	 */
	@Override
	public PageObject selectProjectByStatus(Map<String, Object> paramMap, Integer pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.countSelectProjectsByStatus(paramMap);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		
		List<SsOrgProjectAuditActivity> proList = eduProjectReadDAO.selectProjectsByStatus(paramMap);
		if(proList!=null && proList.size()>0){
			for(SsOrgProjectAuditActivity activity : proList){

				//List<String> orgList = orgReadDAO.selectOrgNameByProjectId(activity.getProjectId());
				List<OrganizationProject> orgList = orgReadDAO.selectOrgIdAndNameByProId(activity.getProjectId());
				if(orgList!=null && orgList.size()>0){

					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					for(OrganizationProject pojo : orgList){
						sb1.append(pojo.getOrganizationId());
						sb1.append(",");
						
						sb2.append(pojo.getOrganizationName());
						sb2.append(",");
					}
					
					if(sb1.length() > 0){
						activity.setOrganizationId(sb1.toString().substring(0,sb1.length()-1));
					}
					
					if(sb2.length() > 0){
						activity.setOrganizationName(sb2.toString().substring(0,sb2.length()-1));
					}
				}
			}
		}
		po.setObjects(proList);
		return po;
	}
	
	/**
	 * 根据项目培训范围查询此地区级别及其以上地区级别的机构
	 */
	@Override
	public List<Organization> queryOrgByProScopeId(String trainScopeId) throws Exception {
		List<Organization> orgList = new ArrayList<Organization>();
		
		SysArea area = sysReadDAO.selectAreaByProScopeId(trainScopeId);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("trainScopeId", trainScopeId);
		if(area.getType().equals("0")){//省
			paramMap.put("type", 0);
			orgList = orgReadDAO.selectOrgInfoByCode(paramMap);
			
		} else if(area.getType().equals("1")){// 市
			paramMap.put("type", 1);
			orgList = orgReadDAO.selectOrgInfoByCode(paramMap);
			
			paramMap.put("type", 0);
			paramMap.put("trainScopeId", area.getUpLvCode());
			orgList.addAll(orgReadDAO.selectOrgInfoByCode(paramMap));
			
		} else if(area.getType().equals("2")){// 区
			paramMap.put("type", 2);
			orgList = orgReadDAO.selectOrgInfoByCode(paramMap);
			
			paramMap.put("type", 1);
			paramMap.put("trainScopeId", area.getUpLvCode());
			orgList.addAll(orgReadDAO.selectOrgInfoByCode(paramMap));
			
			SysArea area2 = sysReadDAO.selectAreaByProScopeId(area.getUpLvCode());
			paramMap.put("type", 0);
			paramMap.put("trainScopeId", area2.getUpLvCode());
			orgList.addAll(orgReadDAO.selectOrgInfoByCode(paramMap));
		}
		
		return orgList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public PageObject procTeacherListForReport(Map<String, Object> param,int startIndex,int pageSize) throws Exception {
		PageObject po = new PageObject();
		/*int areaId = (Integer)param.get("areaId");
		po.setCount(eduProjectReadDAO.countTeacherByArea(areaId));*/
		po.setCount(eduProjectReadDAO.countTeacherByAreaes(param));
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		param.put("startIndex", po.getStartIndex());
		param.put("endIndex", pageSize);
		
		//查询出地区的所有老师
		List<EduTeacherForReport> all = null;
		if(po.getCount() > 0){
			all = eduProjectReadDAO.selectTeacherByArea(param);
		}
		
//		List<EduProjectComment> has = eduProjectReadDAO.selectTeacherByAreaAndProject(param);
//		List<Integer> hasIds = new ArrayList<Integer>();
//		for(EduProjectComment t:has){
//			hasIds.add(t.getTeacherId());
//		}
//		//已报名的老师
//		List<Integer> index = new ArrayList<Integer>();
//		for(int i = 0;i<all.size();i++){
//			EduTeacherForReport t = all.get(i);
//			if(hasIds.contains(t.getId())){
//				index.add(i);
//			}
//		}
//		for(Integer i:index){
//			EduTeacherForReport report = all.get(i);
//			String status = "";
//			for(EduProjectComment c:has){
//				if(c.getTeacherId().equals(report.getId())){
//					if(c.getStatus().equals(13)){
//						status = "已报名已审核通过";
//					}else if(c.getStatus().equals(12)){
//						status = "未通过审核";
//					}else{
//						status = "等待审核";
//					}
//					break;
//				}
//			}
//			report.setStatus(status);
//		}
		po.setObjects(all);
		return po;
	}

	@Override
	public PageObject queryProjectListSuccessByStatus(Map<String, Object> conditions,
			int startIndex, int pageSize)
			throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.countProjectSuccess(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProject> proList = eduProjectReadDAO.selectProjectSuccessListByStatus(conditions);
		po.setObjects(proList);
		return po;
	}

	@Override
	public EduTeacherVersionPOJO queryAllTeacherVersion(int teacherId)
			throws Exception {
		EduTeacherVersionPOJO version = teacherReadDao.selectTeacherAllVersion(teacherId);
		return version;
	}

	@Override
	public boolean apply(int areaId, int projectId,int type) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("projectId", projectId);
		params.put("areaId", areaId);
		int num = eduProjectReadDAO.countTeacherByAreaAndProject(params);
		
		
//		params.put("type", type);
		EduProjectAllocateByArea allocate = new EduProjectAllocateByArea();
		allocate.setAreaId(areaId);
		allocate.setProjectId(projectId);
		allocate.setType(type);
		allocate.setStatus(1);
		allocate.setAllocateFactNum(num);
		//判断是否分配了名额
		int count = eduProjectReadDAO.countAllocateByProject(allocate);
		if(count == 0){
			return false;
		}
		if(type == 0){
			String areaType = sysReadDAO.selectAreaByCode(String.valueOf(areaId)).getType();
			if(areaType.equals("1")){
				if(!eduProjectReadDAO.downLvSchoolHasAllocated(areaId, projectId)){//判断学校是否全部上报
					return false;
				}
			}else{
				if(!eduProjectReadDAO.downLvAreaHasAllocated(areaId, projectId)){//判断下级地区是否已经全部上报
					return false;
				}
				
			}
		}
//		return proWriteDao.updateAllocate(allocate);
		return this.saveOrUpdateAllocate(allocate);
	}
	
	@Override
	public boolean updateProject(EduProjectDTO dto) {
		try {
			EduProject ep = eduProjectReadDAO.selectBaseInfoById(dto.getId());
			ep.setScorePublishRule(dto.getScorePublishRule());
			ep.setScoreLevelRule(dto.getScoreLevelRule());
			ep.setViewScoreRule(dto.getViewScoreRule());
			ep.setIsScorePublished(dto.getIsScorePublished());
			ep.setStatus(dto.getStatus());
			return proWriteDao.updateProject(ep);
		} catch (Exception e) {
 			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean updateProject(EduProject eduProject) {
		try {
			return proWriteDao.updateProject(eduProject);
		} catch (Exception e) {
 			e.printStackTrace();
		}
		return false;
	}

	
	/**
	 * 指定承培机构
	 */
	@Override
	public Map<String, Object> assginOrg(String account, int projectId, List<Organization> list) throws Exception {

		Map<String, Object> result = new HashMap<String, Object>();
		
		List<OrganizationProject> orgList = orgReadDAO.selectOrgIdAndNameByProId(projectId);
		
		for(OrganizationProject pojo : orgList){
			int orgId = pojo.getOrganizationId();
			for(int i=0; i<list.size(); i++){
				Organization org = list.get(i);
				if(org.getOrganizationId().intValue()==orgId){
					list.remove(i);
					break;
				}
			}
		}
		
		if(list!=null && list.size()>0){
			boolean rtn = proWriteDao.insertProForOrg(account, projectId, list);
			result.put("success", rtn);
		} else {
			result.put("success", false);
		}
		return result;
	}
	
	@Override
	public boolean updateTeacherScore(Map<String, Object> conditions)
			throws Exception {
		return proWriteDao.updateTeacherScore(conditions);
	}
	@Override
	public boolean updateTeacherScores(Map<String, Object> conditions)
			throws Exception {
		return proWriteDao.updateTeacherScores(conditions);
	}
	@Override
	public Integer countEduResponseQuestionByCondition(
			Map<String, Object> conditions) throws Exception {
		return eduProjectReadDAO.countEduResponseQuestionByCondition(conditions);
	}
	
	@Override
	public boolean ScoreBatchUpdate(Map<String, Object> conditions) throws Exception {
		return proWriteDao.ScoreBatchUpdate(conditions);
	}
	
	@Override
	public boolean isReport(int projectId) throws Exception {
		boolean flag = true;
		EduProjectDTO dto =  eduProjectReadDAO.selectProFullInfoById(projectId);
		String areaId = dto.getTrainScopeId();
		if(dto.getSignUpWay() == 3){
			if(eduProjectReadDAO.hasReport(projectId, 0, Integer.parseInt(areaId))){
				flag = true;
			}
			else{
				flag = false;
				
		}
		}
		return flag;
	}
	@Override
	public boolean setStopSign(int projectId) throws Exception {
		boolean flag = false;
		EduProjectDTO dto =  eduProjectReadDAO.selectProFullInfoById(projectId);
		String areaId = dto.getTrainScopeId();
		if(dto.getSignUpWay() == 3){
			//if(eduProjectReadDAO.hasReport(projectId, 0, Integer.parseInt(areaId))){
				flag = proWriteDao.updateProjectByProjectId(projectId);
			//}
		}else{
			flag = proWriteDao.updateProjectByProjectId(projectId);
		}
		
		return flag;
	}

	@Override
	public PageObject queryProjectByStatusForStart(Map<String, Object> conditions,int startIndex, int pageSize) throws Exception {
		
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.countProjectByStatusForStart(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProject> list = eduProjectReadDAO.selectProjectByStatusForStart(conditions);
		po.setObjects(list);
		return po;
	}

	@Override
	public EduOrgProjectStatus queryOrgStatus(int projectId)
			throws Exception {
		return eduProjectReadDAO.selectOrgProjectStatus(projectId);
	}

	/**
	 * 判断教师是否可以报名
	 * @param projectId 项目ID
	 * @param teacherId 教师ID
	 * @return
	 * @throws Exception
	 */
	public boolean canSign(int projectId, int teacherId, StringBuffer failMsg) throws Exception {

		CanSign project=eduProjectReadDAO.selectCanSginProject(projectId);
		List<CanSign>teacher=eduProjectReadDAO.selectCanSginTeacher(teacherId);
		if(project==null || teacher==null || teacher.size()==0){
			failMsg.append("教师信息不存在！");
			return false;
		}
		
		//比较培训范围
		boolean isTran=false;
		if((project.getTrainScopeId().intValue()==0)||(project.getTrainScopeId().intValue()==teacher.get(0).getProvinceId().intValue())||(project.getTrainScopeId().intValue()==teacher.get(0).getCityId().intValue())||(project.getTrainScopeId().intValue()==teacher.get(0).getDistrictId().intValue())){
			isTran=true;
		}
		//比较学历educationBackgroundId
		boolean isEducation=false;
		for(int i=0;i<teacher.size();i++){
			if((project.getEducationBackgroundId().intValue()==0)||(teacher.get(i).getEducationBackgroundId().intValue()==project.getEducationBackgroundId().intValue())){
				isEducation=true;
				break;
			}
		}
		//比较学校行政职务positionId
		boolean isPosition=false;
		if(project.getPositionId()==null||(project.getPositionId().intValue()==0)||(project.getPositionId().intValue()==teacher.get(0).getPositionId().intValue())){
			isPosition=true;
		}
		//比较(聘)教师职称professionalTitleId
		boolean isProfessionalTitle=false;
		if(project.getProfessionalTitleId()==null||(project.getProfessionalTitleId().intValue()==0)||(project.getProfessionalTitleId().intValue()==teacher.get(0).getProfessionalTitleId().intValue())){
			isProfessionalTitle=true;
		}
//		//比较是否为班主任isClassCharger
//		boolean isClassCharger=true;
//		if(project.getIsClassCharger().intValue()==teacher.get(0).getIsClassCharger().intValue()){
//			isClassCharger=true;
//		}
		//比较学科、学段subjectId
		boolean isSubject=false;
		String[] arr_teacher=teacher.get(0).getSubjectId().split(",");
		String[] arr_project=project.getSubjectId().split(",");
		if(arr_project.length==0){
			isSubject=true;
		}else if(arr_teacher.length>0){
			if(DataUtil.ArrayExist(arr_project, arr_teacher)){
				isSubject=true;
			}
		}
		
		if(isTran && isEducation && isPosition && isProfessionalTitle && isSubject){
			return true;
		}
		
		failMsg.append("教师");
		if(!isTran){
			failMsg.append("所属区域 ");
		}
		if(!isEducation){
			failMsg.append("学历 ");
		}
		if(!isPosition){
			failMsg.append("学校行政职务 ");
		}
		if(!isProfessionalTitle){
			failMsg.append("(聘)教师职称 ");
		}
		if(!isSubject){
			failMsg.append("学科");
		}
		failMsg.append("不符合报名条件！");
		
		return false;
	}

	@Override
	public List<EduModelPOJO> queryEduModel(Map<String, Object> param) throws Exception {
		
		return eduProjectReadDAO.selectModelNoPage(param);
	}

	@Override
	public boolean procReportByUpLvId(int areaId, int projectId)
			throws Exception {
		EduProjectAllocateByArea aba = new EduProjectAllocateByArea();
		aba.setAreaId(areaId);
		aba.setType(0);
		aba.setStatus(1);
		aba.setProjectId(projectId);
		//上级地区上报名额
		SysArea sysArea = sysReadDAO.selectAreaByCode(String.valueOf(areaId));
		/*if((sysArea.getCode().equals("1"))){
			
		
		
		//所有下级地区ID
		
		List<Integer> ids = sysWriteDAO.selectArea(areaId);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("areaId", areaId);
		param.put("projectId", projectId);
		List<Integer> schoolIds = eduProjectReadDAO.selectSchoolIdByArea(param);
		
//		Map<String,Object> param = new HashMap<String,Object>();
//		param.put("projectId", projectId);
//		param.put("areaId", areaId);
		
		//int num = eduProjectReadDAO.countTeacherByAreaAndProject(params);
		
		
//		boolean flag = true;
//		if(ids.size()>0){
//			flag = proWriteDao.updateAllocateByAreaIds(projectId, ids,0);
//		}
//		if(schoolIds.size()>0){
//			flag = proWriteDao.updateAllocateByAreaIds(projectId, schoolIds,1);
//		}
		//已经分配的地区ID
//		List<Integer> hasAllocate =  eduProjectReadDAO.selectAreaIdsHasAllocate(projectId, ids, 0);
		//已经分配的学校ID
//		List<Integer> hasAllocateSid =  eduProjectReadDAO.selectAreaIdsHasAllocate(projectId, schoolIds, 1);
//		ids.removeAll(hasAllocate);
//		schoolIds.removeAll(hasAllocateSid);
		//未分配的地区
//		List<EduProjectAllocateByArea> list = new ArrayList<EduProjectAllocateByArea>();
		for(Integer i:ids){
			this.apply(i, projectId, 0);
//			EduProjectAllocateByArea paba = new EduProjectAllocateByArea();
//			paba.setProjectId(projectId);
//			paba.setAreaId(i);
//			paba.setAllocateFactNum(0);
//			paba.setAllocatePlanNum(0);
//			paba.setStatus(1);//已上报
//			paba.setType(0);
//			list.add(paba);
		}
		
		//未分配的学校
//		List<EduProjectAllocateByArea> schools = new ArrayList<EduProjectAllocateByArea>();
		
		for(Integer i:schoolIds){
			this.apply(i, projectId, 1);
//			EduProjectAllocateByArea paba = new EduProjectAllocateByArea();
//			paba.setProjectId(projectId);
//			paba.setAreaId(i);
//			paba.setAllocateFactNum(0);
//			paba.setAllocatePlanNum(0);
//			paba.setStatus(1);//已上报
//			paba.setType(1);
//			schools.add(paba);
		}
//		if(list.size()>0){
//			flag = proWriteDao.bathInsertAllocate(list);
//		}
//		if(schools.size()>0){
//			flag = proWriteDao.bathInsertAllocate(schools);
//		}
		}*/
		//sysarea type(0:省，1：市，2区)
		if(sysArea.getType().equals("2")){
			EduProjectAllocateByArea allocateByArea = proWriteDao.selectSchoolSumNumByUpLvId(projectId, 1, areaId);
			aba.setAllocateFactNum(allocateByArea.getAllocateFactNum());
		 	aba.setAllocatePlanNum(allocateByArea.getAllocatePlanNum());
		}else{
		 	EduProjectAllocateByArea allocateByArea = proWriteDao.selectSumNumByUpLvId(projectId, 0, areaId);
		 	aba.setAllocateFactNum(allocateByArea.getAllocateFactNum());
		 	aba.setAllocatePlanNum(allocateByArea.getAllocatePlanNum());
		}
		//更新所有下级地区上报状态
//		return saveOrUpdateAllocate(aba) && flag;
		return this.saveOrUpdateAllocate(aba);
	}
	
	public PageObject selectTeacherProj(Map<String, Object> param,Integer startIndex,Integer pageSize){
		PageObject po = new PageObject();
		List<EduTeacherProject> list = eduProjectReadDAO.selectEduTeacherProjByParam(param);
		Integer count = list.size();
		if(count==null){
			count = 0;
		}
		po.setCount(count);
		
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		param.put("startIndex", po.getStartIndex());
		param.put("endIndex", pageSize);
		
		
		po.setObjects(list);
		return po;
	}
	
	
	/**
	 * 查询项目审核记录
	 * @param projectId 项目ID
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public List<EduProjectAuditPOJO> queryProjectAudit(int projectId)
			throws Exception {
		return eduProjectReadDAO.selectProjectAudit(projectId);
	}
 

	@Override
	public PageObject findProjectByParam(Map<String, Object> proParam,Integer startIndex,Integer pageSize) {
		PageObject po = new PageObject();
		
		Integer count = eduProjectReadDAO.selectProjectCountByParam(proParam);
		if(count==null){
			count = 0;
		}
		po.setCount(count);
		
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		proParam.put("startIndex", po.getStartIndex());
		proParam.put("endIndex", pageSize);
		
		List<EduProject> list = eduProjectReadDAO.selectProjectByParam(proParam);
		po.setObjects(list);
		return po;
		
	}

	@Override
	public boolean updateProjectStatus(int id, int status)
			throws Exception {
		return proWriteDao.updateProjectStatus(id, status);
	}

	/**
	 * 查询上报名额详情
	 * @param queryMap 查询条件
	 * @author cl
	 * @return
	 * @throws Exception
	 */
	public List<ProjectReportInfo> queryProjectReportInfo(
			Map<String, Object> queryMap) throws Exception {
		return eduProjectReadDAO.selectProjectReportInfo(queryMap);
	}

	@Override
	public PageObject queryProjectListForAudit(Map<String, Object> paramMap,
			Integer pageIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.countProjectForAudit(paramMap);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(pageIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<EduProjectForAudit> proList = eduProjectReadDAO.selectProjectForAudit(paramMap);
		po.setObjects(proList);
		return po;
	}

	@Override
	public PageObject queryModelListForSet(Map<String, Object> params,Integer startIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.selectCountEduModelForSet(params);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		params.put("startIndex", po.getStartIndex());
		params.put("endIndex", pageSize);
		List<EduModel> proList = eduProjectReadDAO.selectEduModelForSet(params);
		po.setObjects(proList);
		return po;
		
		
	}

	@Override
	public void setRole(Map<String, Object> condition) throws Exception {
		if(proWriteDao.updateEduProjectRule(condition)){
			
			List<Integer> proIds = eduProjectReadDAO.selectProjectIdsConditions(condition);
			int rule = Integer.parseInt((String)condition.get("rule"));
			if(proIds!=null && proIds.size()>0){
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("proIds", proIds);
				if(rule==1){
					params.put("period_rule", Float.parseFloat((String)condition.get("commonPeriod")));
					params.put("commonRule", "rule");
					proWriteDao.batchModifyTeacherScoresByProjectIds(params);
				}else{
					params.put("period_rule", Float.parseFloat((String)condition.get("excellentPeriod")));
					params.put("excellentRule", "rule");
					proWriteDao.batchModifyTeacherScoresByProjectIds(params);
				}
			}
		}
	}

	@Override
	public PageObject queryProjectByAuditStatus(Map<String, Object> conditions,
			int startIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.countProjectByAuditStatus(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProject> proList = eduProjectReadDAO.selectProjectByAuditStatus(conditions);
		po.setObjects(proList);
		return po;
		
	}
	
	/**
	 * 是否已经参加了项目
	 * @param teacherId
	 * @param projectId
	 * @return
	 * @throws Exception
	 *	2014-5-14
	 * Devil
	 */
	private boolean hasSign(int teacherId,int projectId) throws Exception{
		return eduProjectReadDAO.hasSign(teacherId, projectId);
	}

	@Override
	public void updateProjectComment(Map<String, Object> conditions)
			throws Exception {
			proWriteDao.updateProjectComment(conditions);
	}
	
	/**
	 * 导入教师，解析EXCEL
	 */
	@Override
	@Deprecated
	public Map<String, Object> parseTeacherExcel(InputStream is, String fileType)
			throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		//正确的数据
		List<TeacherDTO> dtos = new ArrayList<TeacherDTO>();
		List<Row> dbRows = new ArrayList<Row>();
		//地区数据
		List<SysArea> areas = sysReadDAO.selectAllAreas();
		//政治面貌
		List<SysDictionary> politicalDic = sysReadDAO.selectDicByDicType("political_status");
		//学段
		List<SysDictionary> sections = sysReadDAO.selectDicByDicType("stduty_section");
		//学科
		List<SysDictionary> subjects = sysReadDAO.selectDicByDicType("project_subject");
		
		//数据不合格的row
		List<Row> rows = new ArrayList<Row>();
		Workbook wb = null;
		if(fileType.equalsIgnoreCase("xls")){
			wb = new HSSFWorkbook(is);
			
		}else{
			wb = new HSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		for(int i = 2;i<sheet.getLastRowNum();i++){
			Row row = sheet.getRow(i);
			if(row != null){
				if(row.getCell(39)==null){
					row.createCell(39);
				}
				if(DataUtil.getCellValue(row.getCell(0)).length() == 0 && DataUtil.getCellValue(row.getCell(1)).length() == 0
						&&DataUtil.getCellValue(row.getCell(2)).length() == 0 && DataUtil.getCellValue(row.getCell(3)).length() == 0
						&& DataUtil.getCellValue(row.getCell(4)).length() == 0 
						&& DataUtil.getCellValue(row.getCell(5)).length() == 0 && DataUtil.getCellValue(row.getCell(6)).length() == 0 
						&& DataUtil.getCellValue(row.getCell(7)).length() == 0 
						&& DataUtil.getCellValue(row.getCell(8)).length() == 0 && DataUtil.getCellValue(row.getCell(9)).length() == 0 
						&& DataUtil.getCellValue(row.getCell(10)).length() == 0 
						&& DataUtil.getCellValue(row.getCell(11)).length() == 0 && DataUtil.getCellValue(row.getCell(12)).length() == 0 
						&& DataUtil.getCellValue(row.getCell(13)).length() == 0 
						&& DataUtil.getCellValue(row.getCell(14)).length() == 0 && DataUtil.getCellValue(row.getCell(15)).length() == 0 
						&& DataUtil.getCellValue(row.getCell(16)).length() == 0 
						&& DataUtil.getCellValue(row.getCell(17)).length() == 0 && DataUtil.getCellValue(row.getCell(18)).length() == 0 
						&& DataUtil.getCellValue(row.getCell(19)).length() == 0 && DataUtil.getCellValue(row.getCell(20)).length() == 0 
						&& DataUtil.getCellValue(row.getCell(21)).length() == 0 && DataUtil.getCellValue(row.getCell(22)).length() == 0 
						&& DataUtil.getCellValue(row.getCell(23)).length() == 0 && DataUtil.getCellValue(row.getCell(24)).length() == 0 
						&& DataUtil.getCellValue(row.getCell(25)).length() == 0 && DataUtil.getCellValue(row.getCell(26)).length() == 0){
					continue;
				}
				TeacherDTO dto = new TeacherDTO();
			}
		}
		
		
		return null;
	}
	
	@Override
	public Integer writeProcess(EduProjectProcess epp) {
		EduProjectProcess searchEpp = eduProjectReadDAO.selectProcessById(epp.getId());
		if(searchEpp==null){
			return proWriteDao.insertEduProjectProcess(epp);
		}
		return proWriteDao.updateEduProjectProcess(epp);
	}

	@Override
	public EduProjectProcess getProcessByParam(EduProjectProcess epp) {
		List<EduProjectProcess> list = eduProjectReadDAO.selectProcessByParam(epp);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 上报名额时判断下级是否已经上报
	 * @param areaId 本级地区ID
	 * @param type 分配类型
	 * @return
	 */
	@Deprecated
	protected boolean upLvHasAllocated(int areaId,int type) throws Exception{
		boolean had = false;
		Map<String,Object> pram = new HashMap<String, Object>();
		if(type == 0){//地区
			pram.put("code", areaId);
		}else{//学校
			 pram.put("code", sysReadDAO.selectSysSchoolInfo(areaId).getDistrictId());
		}
		
		List<SysArea> areas = sysReadDAO.selectAreaByBelong(pram);
		
		
		
		return had;
	}
	
	@Override
	public EduProjectAllocateByArea queryAllocateInfo(int projectId,int type,int areaId) throws Exception{
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("type", type);
		param.put("areaId", areaId);
		param.put("projectId", projectId);
		return eduProjectReadDAO.selectAllocateByAreaAndProject(param);
	}
	
	/**
	 * 是否分配了名额且不为0
	 */
	@Override
	public boolean hasAllocate(int projectId,int areaId,int type) throws Exception{
		boolean flag = false;
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("projectId", projectId);
		params.put("areaId", areaId);
		params.put("type", type);
		flag = eduProjectReadDAO.hasAllocate(params);
		return flag;
	}
	@Override
	public Integer countProject(Map<String, Object> conditions) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		Integer count = eduProjectReadDAO.countProject(conditions);
		return count;
	}
	/*
	 * 判断机构与项目是否有关联
	 */
	@Override
	public boolean isOrg(int projectId,int orgId) throws Exception{
		boolean flag = false;
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("orgId", orgId);
		params.put("projectId", projectId);
		flag = eduProjectReadDAO.selectCountOrgAndProject(params);
		return flag;
	}

	@Override
	public List<EduProject> selectshishijigou() throws Exception {
	
		return eduProjectReadDAO.selectshishijigou();
	}

	

	@Override
	public PageObject districtAudit(Map<String, Object> conditions,
			int startIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.districtAuditCount(conditions);
		
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", startIndex);
		conditions.put("endIndex", pageSize);
		List<EduProjectAudit> pros = eduProjectReadDAO.districtAudit(conditions);
		po.setObjects(pros);
		return po;
	}
	/*
	 * 市审核报名
	 * wych
	 */
	@Override
	public PageObject cityAudit(Map<String, Object> conditions, int startIndex,
			int pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.cityAuditCount(conditions);
		
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", startIndex);
		conditions.put("endIndex", pageSize);
		List<EduProjectAudit> pros = eduProjectReadDAO.cityAudit(conditions);
		po.setObjects(pros);
		return po;
	}
	/*
	 * 省审核报名
	 * wych
	 */
	@Override
	public PageObject provinceAudit(Map<String, Object> conditions,
			int startIndex, int pageSize) throws Exception {
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.provinceAuditCount(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", startIndex);
		conditions.put("endIndex", pageSize);
		List<EduProjectAudit> pros = eduProjectReadDAO.provinceAudit(conditions);
		po.setObjects(pros);
		return po;
	}

	
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

	@Override
	public List<Object> queryProjectListByCreateBy(Map<String, Object> conditions)throws Exception{
		List<Object> proList = eduProjectReadDAO.selectProjectListByCreateBy(conditions);
		return proList;
	}

	@Override
	public boolean batchAuditTeacherScores(String ids, Map<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		//return proWriteDao.updateTeacherScores(conditions);
		if(ids.length()>0){
			String[] cids = ids.split(",");
			return proWriteDao.batchAuditTeacherScores(cids, params);
		}
		return false;
	}

	@Override
	public boolean auditAllTeacherScores(Map<String, Object> conditions)
			throws Exception {
		// TODO Auto-generated method stub
		return proWriteDao.auditAllTeacherScores(conditions);
	}

	@Override
	public List<OrgProTeacherActivity> downTeacherExcl(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return eduProjectReadDAO.downTeacherExcl(paramMap);
	}

	@Override
	public String qryModelInfo(Map<String,Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return eduProjectReadDAO.qryModelInfo(paramMap);
	}

	@Override
	public List<EduProjectCommentTeacher> queryProjectCommentTeachers(
			int projectId) throws Exception {
		// TODO Auto-generated method stub
		return eduProjectReadDAO.queryProjectCommentTeachers(projectId);
	}

	@Override
	public void updateProjectCommentTeachers(EduProjectCommentTeacher teacherInfo) throws Exception {
		// TODO Auto-generated method stub
		proWriteDao.updateProjectCommentTeachers(teacherInfo);
	}

	@Override
	public void updateProjectCommentTeachers(
			List<EduProjectCommentTeacher> eduList) throws Exception {
		// TODO Auto-generated method stub
		proWriteDao.updateProjectCommentTeachers(eduList);
	}

	@Override
	public void updateProjectCommentTeachers(Map<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		proWriteDao.updateProjectCommentTeachers(map);
	}

	public EduProjectCommentTeacher queryProjectCommentByTeacherId(EduProject  project,
			Integer teacherId) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("teacherId", teacherId);
		paramMap.put("projectId", project.getId());
		
		return eduProjectReadDAO.selectTeacherCommentfoById(paramMap);
	}

	@Override
	public Integer checkIsForcePaper(Map<String, Object> conditions) {
		Integer count = eduProjectReadDAO.checkIsForcePaper(conditions);
		return count;
	}

	public boolean updateProjectCertificateAll(Map<String, Object> param)
			throws Exception {
		// TODO Auto-generated method stub
		return proWriteDao.updateProjectCertificateAll(param);
	}

	public boolean updateTeacherProjectComment(Map<String, Object> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return proWriteDao.updateTeacherProjectComment(paramMap);
	}

	
	 /**
	  * 查询教师成绩模块中的项目列表
	  * 
	  */
	@Override
	public PageObject queryTeacherProjectListByAdmin(Map<String, Object> conditions,
			int startIndex, int pageSize) throws Exception {
		
		PageObject po = new PageObject();
		int count = eduProjectReadDAO.selectCountTeacherProjectList(conditions);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		conditions.put("startIndex", po.getStartIndex());
		conditions.put("endIndex", pageSize);
		List<EduProject> proList = eduProjectReadDAO.selectTeacherProjectList(conditions);
		po.setObjects(proList);
		return po;
	}

	public Integer getAllProjectComment(Map<String, Object> paraMap) throws Exception {
		// TODO Auto-generated method stub
		return eduProjectReadDAO.getAllProjectComment(paraMap);
	}

	/**
	 * 更新教师培训结果
	 */
	@Override
	public void updateProjectCommentTrainStatus(EduProjectDTO dto, String projectId, String ids, int trainStatusId) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("projectId", projectId);
		params.put("ids", StringUtils.isEmpty(ids) ? null : ids.split(","));
		params.put("trainStatusId", trainStatusId);
		params.put("trainStatusName", Common.TRAIN_STATUS.get(trainStatusId));
		
		if(proWriteDao.updateProjectCommentTrainStatus(params)){
			params.remove("trainStatusId");
			params.remove("trainStatusName");
			
			String commonRule = dto.getExchangeRule();
			String excellentRule = dto.getExcellentRule();
			
			if(trainStatusId==2){//优秀
				if(excellentRule!=null){
					params.put("period_rule", excellentRule);
					params.put("excellentRule", "rule");
					proWriteDao.modifyTeacherClassScore(params);
				}
				
			}else{
				if(commonRule!=null){
					params.put("period_rule", commonRule);
					proWriteDao.modifyTeacherClassScore(params);
				}
			}
		}
	}

	/**
	 * 根据项目id更新教师学分
	 */
	@Override
	public void modifyTeacherScoresByProjectIds(String projectId, String commonRule, String excellentRule) throws Exception {
		Map<String,Object> param = new HashMap<String,Object>();
		
		List<Integer> proIds = new ArrayList<Integer>();
		proIds.add(Integer.parseInt(projectId));
		
		param.put("proIds", proIds);
		if(commonRule!=null){
			param.put("period_rule", commonRule);
			proWriteDao.batchModifyTeacherScoresByProjectIds(param);
		}
		
		if(excellentRule!=null){
			param.put("period_rule", excellentRule);
			param.put("excellentRule", "rule");
			proWriteDao.batchModifyTeacherScoresByProjectIds(param);
		}
	}

	
		
		/**
		 * 导出excel
		 * @param rows
		 * @param srcPath
		 * @param srcFileName
		 * @param desPath
		 * @param newName
		 * @return
		 * @throws Exception
		 */
		public void createExl(List<Row> rows,String srcPath,String srcFileName,String desPath,String newName) throws Exception{
			//拷贝模板
			String newFile = ExcelUtil.copyExcel(srcPath, srcFileName, desPath, newName);
			//导出excel
			ExcelUtil.exportExcel(rows, newFile);
		}

		@Override
		public Map<String, Object> parsePaperQuestionExcel(InputStream is, String fileType, Map<String,Object> params) {
			Map<String, Object> result;
			try {
				result = new HashMap<String, Object>();
				//正确的数据
				List<Row> dbRows = new ArrayList<Row>();
				//数据不合格的row
				List<Row> rows = new ArrayList<Row>();
				
				Workbook wb = null;
				if(fileType.equalsIgnoreCase("xls")){
					wb = new HSSFWorkbook(is);
					}else{
						wb = new HSSFWorkbook(is);
					}
					Sheet sheet = wb.getSheetAt(0);
					int max = sheet.getLastRowNum();
					for(int i = 1;i<=max+1;i++){
						Row row = sheet.getRow(i);
						if(row!=null){
							int last = 9;
							
							String question_type = DataUtil.getCellValue(row.getCell(0));//
							String title = DataUtil.getCellValue(row.getCell(1));//
							String requiredAnswer = DataUtil.getCellValue(row.getCell(2));//
							
							List<String> answerList = new ArrayList<String>();
							for(int n = 3; n <= 8 ; n++){
								String answer = DataUtil.getCellValue(row.getCell(n));
								answer = (answer.trim()==null||"".equals(answer.trim()))?null:answer;
								if(answer == null) continue;
								answerList.add(answer);
							}
							for(int m = 9 ; m < 100 ; m++){
								String res = DataUtil.getCellValue(row.getCell(m));
								if((res.trim()==null||"".equals(res.trim()))?false:true){
									if(row.getCell(last) == null){
										row.createCell(last);
									}
									row.getCell(last).setCellValue("行"+(i+1)+"：请在给定的单元格填写数据");
									rows.add(row);
									break;
								}
							}
							
							if(row.getCell(last) == null){
								row.createCell(last);
							}
							if(question_type.length() != 1 || Integer.parseInt(question_type) > 3
									|| Integer.parseInt(question_type) < 0 ){
								row.getCell(last).setCellValue("行"+(i+1)+"：请正确填写题型编号");
								rows.add(row);
								continue;
							}
							if(title.length() == 0 || title == null){
								row.getCell(last).setCellValue("行"+(i+1)+"：题干不能为空");
								rows.add(row);
								continue;
							}
							if(!(requiredAnswer.equals("是") || requiredAnswer.equals("否") || requiredAnswer.equals(""))){
								row.getCell(last).setCellValue("行"+(i+1)+"：是否必答栏只能填‘是’或‘否’或不填");
								rows.add(row);
								continue;
							}
							if("0".equals(question_type)){//如果是填空题
								if(answerList.size() > 0){
									row.getCell(last).setCellValue("行"+(i+1)+"：填空题，请勿填写选项");
									rows.add(row);
									continue;
								}
							}
							if("1".equals(question_type)){//如果是问答题
								if(answerList.size() > 0){
									row.getCell(last).setCellValue("行"+(i+1)+"：问答题，请勿填写选项");
									rows.add(row);
									continue;
								}
							}
							if("2".equals(question_type)){//如果是单选题
								if(answerList.size() <= 1){
									row.getCell(last).setCellValue("行"+(i+1)+"：单选题，请至少填写两个选项");
									rows.add(row);
									continue;
								}
							}
							if("3".equals(question_type)){//如果是多选题
								if(answerList.size() <= 1){
									row.getCell(last).setCellValue("行"+(i+1)+"：多选题，请至少填写两个选项");
									rows.add(row);
									continue;
								}
							}
							dbRows.add(row);
						}
					}
					if(rows.size() > 0){
						dbRows.clear();
					}
					result.put("toDBRow", dbRows);
					//错误的数据
					result.put("toExl", rows);
					return result;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			}

		
		@Override
		public void batchInsertPaperQuestion(List<Row> rows,
				Map<String, Object> params) {
			try {
				if(rows != null){
					int rank = 1;
					for(Row row : rows){
						EduQuestion eq = new EduQuestion();
						eq.setQuestionType(Integer.parseInt(DataUtil.getCellValue(row.getCell(0))));
						eq.setTitle(DataUtil.getCellValue(row.getCell(1)).trim());
						String requiredAnswer = DataUtil.getCellValue(row.getCell(2));
						if("".equals(requiredAnswer) || "是".equals(requiredAnswer)){
							requiredAnswer = "Y";
						}else{
							requiredAnswer = "N";
						}
						eq.setRequiredAnswer(requiredAnswer);
						eq.setCreateDate(DateUtil.getSystemTimeFormat("yyyy-MM-dd"));
						eq.setUsername((String)params.get("uName"));
						eq.setRank(rank++);
						eq.setPaperId(Integer.parseInt((String)params.get("paperId")));
				
						eq.setShowStyle(2);
						eq.setSta(0);

						int id = proWriteDao.insertQuestion(eq);	
						
						List<String> listEqos = new ArrayList<String>();
						listEqos.add(DataUtil.getCellValue(row.getCell(3)));
						listEqos.add(DataUtil.getCellValue(row.getCell(4)));
						listEqos.add(DataUtil.getCellValue(row.getCell(5)));
						listEqos.add(DataUtil.getCellValue(row.getCell(6)));
						listEqos.add(DataUtil.getCellValue(row.getCell(7)));
						listEqos.add(DataUtil.getCellValue(row.getCell(8)));
						int count1 = 1;
						for(String answer :listEqos){
							if(!"".equals(answer)){
								EduQuestionOptions eqo = new EduQuestionOptions();
								eqo.setContent(answer.trim());
								eqo.setCreateDate(eq.getCreateDate());
								eqo.setQuestionId(id);
								eqo.setRank(count1++);
								eqo.setUsername(eq.getUsername());
								proWriteDao.insertQuestionOptions(eqo);
							}
						}
					}
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public PageObject queryCreditLendListForAudit(
				Map<String, Object> conditions, int startPage, int pageSize)
				throws Exception {
			PageObject po = new PageObject();
			int count = eduProjectReadDAO.countCreditLendForAudit(conditions);
			po.setCount(count);
			PageParser.getPageObject(PageParser.getPageInfo(startPage, pageSize, po.getCount()), po);
			conditions.put("startIndex", po.getStartIndex());
			conditions.put("endIndex", pageSize);
			List<EduProjectForAudit> proList = eduProjectReadDAO.selectCreditLendForAudit(conditions);
			po.setObjects(proList);
			return po;
		}

		@Override
		public boolean procAuditCreditLend(Map<String, Object> conditions)
				throws Exception {
			return proWriteDao.updateCreditLendStatus(conditions);
		}

		@Override
		public List<EduProject> getSpecialProject(Map<String, Object> params) {
			return eduProjectReadDAO.getSpecialProject(params);
		}

		@Override
		public int addProjectComment(Map<String, Object> params) {
			return proWriteDao.insertProjectComment(params);
			}


		
}