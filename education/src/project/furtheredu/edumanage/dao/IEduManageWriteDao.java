package project.furtheredu.edumanage.dao;

import java.util.Map;

import project.furtheredu.edumanage.pojo.EduSignet;

public interface IEduManageWriteDao {

	Integer deleteManageById(Integer id) throws Exception;

	Integer updateEduManageStatus(String id, String account, Integer status, String memo);
	
	/**
	 * 新增电子印章
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	Integer insertSignet(EduSignet pojo) throws Exception;
	
	/**
	 * 新增电子印章
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	Integer insertSignetNew(EduSignet pojo) throws Exception;
	
	/**
	 * 修改电子印章
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	Integer updateSignet(EduSignet pojo) throws Exception;

	/**
	 * 新增年度证书
	 * @param param
	 * @return
	 */
	Integer insertYearCertificate(Map<String, Object> param);

	/**
	 * 删除年度证书
	 * @param condition
	 * @return
	 */
	boolean deleteCertificateById(Map<String, Object> condition);

	/**
	 * 修改年度证书
	 * @param condition
	 * @return
	 */
	int updateCertificateById(Map<String, Object> condition);
	 
}
