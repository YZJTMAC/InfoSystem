package project.message.dao;

import java.util.List;
import java.util.Map;

import project.message.pojo.EduMessage;
import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;

public interface IMessageReadDaoIF {
	public int selectMessageCounts(Map<String, Object> paramMap) throws Exception;
	public List<EduMessage> selectMessageList(Map<String, Object> paramMap) throws Exception;
	public List<EduUser> selectUserList(Map<String, Object> paramMap) throws Exception;
	public List<EduMessage> selectMessageListShenghe(Map<String, Object> paramMap) throws Exception;
	public int selectMessageShenheCounts(Map<String, Object> paramMap) throws Exception;
	public EduMessage findMessageById(Integer id);
	public int selectMessageCountByReceiveUserId(Map<String, Object> paramMap) throws Exception;
	public List<EduMessage> selectNoReadCountByReceiveUserId(Map<String, Object> paramMap) throws Exception;
	public int selectCreateMessageCount(Map<String, Object> paramMap) throws Exception;
	public List<EduMessage> selectCreateMessageList(Map<String, Object> paramMap) throws Exception;
	public List<EduUserActivty> selectReceiveInfo(Map<String, Object> paramMap) throws Exception;
}
