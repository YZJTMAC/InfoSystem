package project.message.dao.impl;

import java.util.Map;

import com.google.zxing.Result;

import project.message.dao.IMessageWriteDaoIF;
import framelib.dao.BaseDAOImpl;

public class MessageWriteDaoImpl extends BaseDAOImpl implements IMessageWriteDaoIF{

	@Override
	public Integer insertMessage(Map<String, Object> paramMap) throws Exception {
		Object obj =  this.getSqlMapClientTemplate().insert("sendMessage",paramMap);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	
	@Override
	public boolean insertMessageUsers(Map<String, Object> paramMap) throws Exception {
		Object obj =  this.getSqlMapClientTemplate().insert("selectComparisonByName",paramMap);
		if(obj == null){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteMessage(Map<String, Object> paramMap)
			throws Exception {
		boolean flag = false;
		int result = this.getSqlMapClientTemplate().update("deleteMessage",paramMap);
		if(result>0){
			flag = true;
		}
		return flag;
	}
	
	@Override
	public boolean deleteMessageUsers(Map<String, Object> paramMap)
			throws Exception {
		boolean flag = false;
		int result = this.getSqlMapClientTemplate().update("deleteMessageUsers",paramMap);
		if(result>0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateReadMessageStatus(Map<String, Object> paramMap)
			throws Exception {
		Object obj =  this.getSqlMapClientTemplate().insert("readMessage",paramMap);
		if(obj == null){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean batchMessage(Map<String, Object> paramMap) throws Exception {
		Object obj =  this.getSqlMapClientTemplate().insert("batchSendMessage",paramMap);
		if(obj == null){
			return true;
		}
		return false;
	}
	
	@Override
	public Integer insertMessageToBoss1(Map<String, Object> paramMap) {
		Object obj =  this.getSqlMapClientTemplate().insert("sendMessageToBoss1",paramMap);
		if(obj==null) return -1;
		return (Integer)obj;
	}

	@Override
	public boolean insertMessageToBoss2(Map<String, Object> paramMap) {
		Object obj =  this.getSqlMapClientTemplate().insert("sendMessageToBoss2",paramMap);
		if (obj == null) {
			return false;
		}
		return true;
	}

	@Override
	public Integer insertMessageToReview(Map<String, Object> paramMap) {
		Object obj =  this.getSqlMapClientTemplate().insert("sendMessageToReview",paramMap);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	
	
}