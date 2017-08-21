package project.message.dao.impl;

import java.util.List;
import java.util.Map;

import project.message.dao.IMessageReadDaoIF;
import project.message.pojo.EduMessage;
import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;
import framelib.dao.BaseDAOImpl;

public class MessageReadDaoImpl extends BaseDAOImpl implements IMessageReadDaoIF{

	@Override
	public int selectMessageCounts(Map<String, Object> paramMap) throws Exception {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("selectMessageCountsByStatus",paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EduMessage> selectMessageList(Map<String, Object> paramMap)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectMessageByReceiveUserId",paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EduUser> selectUserList(Map<String, Object> paramMap)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectUserLoginAccount", paramMap);
	}

	@Override
	public List<EduMessage> selectMessageListShenghe(
			Map<String, Object> paramMap) throws Exception {

		return this.getSqlMapClientTemplate().queryForList("selectUserLoginAccountShenghe",paramMap);
	}

	@Override
	public int selectMessageShenheCounts(Map<String, Object> paramMap)
			throws Exception {

		return (Integer) this.getSqlMapClientTemplate().queryForObject("selectMessageCountsByshenheStatus",paramMap);
	}

	@Override
	public EduMessage findMessageById(Integer id) {
		return (EduMessage) this.getSqlMapClientTemplate().queryForObject("findMessageById", id);
	}

	@Override
	public int selectMessageCountByReceiveUserId(Map<String, Object> paramMap) throws Exception {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("selectMessageCountByReceiveUserId",paramMap);
	}

	@Override
	public List<EduMessage> selectNoReadCountByReceiveUserId(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectNoReadCountByReceiveUserId",paramMap);
	}

	@Override
	public int selectCreateMessageCount(Map<String, Object> paramMap) throws Exception {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("selectCreateMessageCount",paramMap);
	}

	@Override
	public List<EduMessage> selectCreateMessageList(Map<String, Object> paramMap) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("selectCreateMessageList",paramMap);
	}

	@Override
	public List<EduUserActivty> selectReceiveInfo(Map<String, Object> paramMap)
			throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("selectReceiveInfo",paramMap);
	}
}
