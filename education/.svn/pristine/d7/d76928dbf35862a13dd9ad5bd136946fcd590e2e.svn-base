package project.system.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import framelib.utils.page.PageObject;

import project.message.pojo.NoticeTree;
import project.system.pojo.EduSchool;

public interface ISysSchoolService {

	/**
	 * 查询学校信息列表
	 * 
	 * @param schoolName
	 *            学校名称
	 * @param schoolTypeId
	 *            学校学段
	 * @param schoolProvinceId
	 * @param schoolCityId
	 * @param schoolDistrictId
	 * @return
	 * @throws Exception
	 */
	public List<EduSchool> querySchoolList(String schoolName,
			Integer schoolTypeId, Integer schoolProvinceId,
			Integer schoolCityId, Integer schoolDistrictId , Integer schoolId ) throws Exception;

	/**
	 * 学校管理列表
	 * 
	 * @author cl create date 2014-4-10
	 * @param paramMap
	 * @param pageIndex
	 *            当前页
	 * @param pageSize
	 *            页大小
	 * @return
	 * @throws Exception
	 */
	public PageObject querySysSchool(Map<String, Object> paramMap,
			int pageIndex, int pageSize) throws Exception;
	
	
	/**
	 * @author liuyiyou
	 * @desc: 学校管理列表 导出到excel，使用的查询应该和上面的保持一致，只是不进行分页
	 *
	 * */
	public List<EduSchool> exportSysSchoolToExcel(Map<String, Object> paramMap) throws Exception;

	/**
	 * 新增学校记录
	 * @author cl
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer addSchool(EduSchool pojo) throws Exception;
	
	/**
	 * 查询学校详细
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EduSchool searchSchoolInfo(Integer id)throws Exception;
	
	/**
	 * 更新学校记录
	 * @author cl
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer updateSchool(EduSchool pojo) throws Exception;
	
	/**
	 * 删除学校记录
	 * @author cl
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer deleteSchool(EduSchool pojo) throws Exception;
	
	/**
	 * 导入学校时，验证数据
	 * @author cl
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> searchSchoolExcel(InputStream is, String fileType)
	throws Exception;
	

	/**
	 * 学校导入 提交数据
	 * @param toDBpath 数据正确的excel路径
	 * @param account 登录人，用于creat_by update_by
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> intoDB(String toDBpath,String account) throws Exception;
	
	
	/**
	 * liuyiyou
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<NoticeTree> schoolTree(Map<String, Object> params) throws Exception;

	public EduSchool selectSchoolByName(Map<String, Object> params) throws Exception;

}
