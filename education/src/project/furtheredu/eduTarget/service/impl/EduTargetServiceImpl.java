package project.furtheredu.eduTarget.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.baoogu.payment.sxy.dao.PayDao;

import framelib.service.AbsService;
import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

import project.common.Common;
import project.furtheredu.eduTarget.dao.IEduTagetReadDao;
import project.furtheredu.eduTarget.dao.IEduTagetWriteDao;
import project.furtheredu.eduTarget.pojo.EduTargetByYear;
import project.furtheredu.eduTarget.service.IEduTargetService;
import project.person.dao.IUserWriteDao;
import project.person.pojo.EduUser;
import project.teacher.constant.TeacherConstant;
import project.teacher.teachermanage.dao.ITeacherReadDao;
import project.teacher.teachermanage.dao.ITeacherWriteDao;
import project.teacher.teachermanage.dto.EduTeacherEduDTO;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherJob;
import project.teacher.teachermanage.pojo.EduTeacherVersionPOJO;
import project.teacher.teachermanage.service.ITeacherManageService;

@SuppressWarnings("unchecked")
public class EduTargetServiceImpl extends AbsService implements IEduTargetService {

	private static final Logger log = Logger.getLogger(EduTargetServiceImpl.class);
	
	@Autowired
	@Qualifier("eduTagetReadDao")
	IEduTagetReadDao eduTagetReadDao;
	
	@Autowired
	@Qualifier("eduTagetWriteDao")
	IEduTagetWriteDao eduTagetWriteDao;
	
	@Override
	public PageObject queryTagetListPage(
			Map<String, Object> paramMap, int startPage, int pageSize)
			throws Exception {
		PageObject po = new PageObject();
		po.setCount(eduTagetReadDao.selectTagetCountByCondition(paramMap));
		PageParser.getPageObject(PageParser.getPageInfo(startPage, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<Object> list =  eduTagetReadDao.selectTagetListByCondition(paramMap);
		po.setObjects(list);
		return po;
	}
	
	@Override
	public  List<Object>  queryTagetListNoPage(	Map<String, Object> paramMap)
			throws Exception {
		return eduTagetReadDao.selectTagetListByConditionNoPage(paramMap);
	}
	
	@Override
	public Integer saveTagetInfo(EduTargetByYear target) throws Exception {
		//检查所选年度所选地区是否已经存在信息
		Map<String,Object> queryMap=new HashMap<String, Object>();
		Map<String,Object> pojo=new HashMap<String, Object>();
		pojo.put("year", target.getYear());
		/*queryMap.put("year", target.getYear());
		
			queryMap.put("provinceId", target.getProvinceId());
		
			queryMap.put("cityId", target.getCityId());
		
			queryMap.put("districtId", target.getDistrictId());
		
			queryMap.put("schoolId", target.getSchoolId());*/		
		pojo.put("provinceId", target.getProvinceId());
		pojo.put("cityId", target.getCityId());
		pojo.put("districtId", target.getDistrictId());
		pojo.put("schoolId", target.getSchoolId());	
		if(eduTagetReadDao.selectTagetCountByCondition2(pojo)>0){
			throw new Exception("-1");
		}
		return eduTagetWriteDao.insertTagetInfo(target);
	}
	
	@Override
	public EduTargetByYear queryTargetInfoById(Integer id) throws Exception {
		return eduTagetReadDao.selectTargetByKey(id);
	}
	
	@Override
	public Integer updateTaget(EduTargetByYear target) throws Exception{
		//检查所选年度所选地区是否已经存在信息
		Map<String,Object> queryMap=new HashMap<String, Object>();
		queryMap.put("year", target.getYear());
		queryMap.put("provinceId", target.getProvinceId());
		queryMap.put("cityId", target.getCityId());
		queryMap.put("districtId", target.getDistrictId());
		queryMap.put("schoolId", target.getSchoolId());
		if(target.getType().intValue()==1 && eduTagetReadDao.selectTagetCountByCondition(queryMap)>0){
			throw new Exception("-1");
		}
		return eduTagetWriteDao.updateTarget(target);
	}
	
	@Override
	public Integer deleteTargetById(Integer id) throws Exception{
		return eduTagetWriteDao.deleteTargetById(id);
	}

}
