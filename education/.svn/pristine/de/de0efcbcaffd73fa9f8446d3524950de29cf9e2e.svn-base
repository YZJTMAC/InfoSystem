package project.furtheredu.eduTarget.service;

import java.util.List;
import java.util.Map;

import project.furtheredu.eduTarget.pojo.EduTargetByYear;
import project.person.pojo.EduUser;
import project.teacher.teachermanage.dto.EduTeacherEduDTO;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import project.teacher.teachermanage.pojo.EduTeacherEducation;
import project.teacher.teachermanage.pojo.EduTeacherJob;

import framelib.utils.page.PageObject;


/**
 * 物流订单处理service
 * @author dengguo
 *
 */
public interface IEduTargetService {
	
	/**
	 * 教师信息综合查询
	 * @param paramMap 
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public PageObject queryTagetListPage(Map<String,Object> paramMap, int startPage, int pageSize) throws Exception;

	public Integer saveTagetInfo(EduTargetByYear target) throws Exception;

	/**
	 * 查询年度目标设置
	 * @param id
	 * @return
	 * @throws Exception
	 */
	EduTargetByYear queryTargetInfoById(Integer id) throws Exception;

	Integer updateTaget(EduTargetByYear target) throws Exception;

	Integer deleteTargetById(Integer id) throws Exception;

	/**
	 * 查询继教考核年度设置
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<Object> queryTagetListNoPage(Map<String, Object> paramMap)
			throws Exception;
	
 }
