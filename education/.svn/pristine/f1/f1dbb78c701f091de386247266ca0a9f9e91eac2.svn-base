package project.message.dao.impl;

import java.util.List;
import java.util.Map;

import framelib.dao.BaseDAOImpl;
import project.message.dao.INoticeReadDao;
import project.message.pojo.EduNotice;
import project.message.pojo.EduNoticeFile;
import project.message.pojo.EduNoticeUser;

public class NoticeReadDaoImpl extends BaseDAOImpl implements INoticeReadDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<EduNotice> noticeList(Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList("selectNoticeList",
				paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EduNotice> myNoticeList(Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList("selectMyNoticeList",
				paramMap);
	}

	@Override
	public Integer selectNoticeCount(Map<String, Object> paramMap) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject(
				"selectNoticeCount", paramMap);
	}
	
	@Override
	public Integer selectMyNoticeListCount(Map<String, Object> paramMap) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject(
				"selectMyNoticeListCount", paramMap);
	}
	

	@Override
	public Integer readNoticeCount(Map<String, Object> paramMap) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject(
				"readNoticeCount", paramMap);
	}

	@Override
	public EduNotice selectById(Integer id) {
		return (EduNotice) this.getSqlMapClientTemplate().queryForObject(
				"selectById", id);
	}

	@Override
	public List<EduNoticeUser> getNoticeUser(Map<String, Object> paramMap) {
		return  this.queryForList("getNoticeUser", paramMap);
	}

	@Override
	public List<String> readNoticeIds(Map<String, Object> paramMap) {
		return  this.queryForList("readNoticeIds", paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EduNoticeFile> selectNoticeFilesByNoticeId(Integer noticeId) {
		return this.getSqlMapClientTemplate().queryForList("selectNoticeFilesByNoticeId",
				noticeId);
	}
	

}
