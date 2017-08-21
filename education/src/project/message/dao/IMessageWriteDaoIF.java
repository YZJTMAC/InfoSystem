package project.message.dao;

import java.util.Map;

public interface IMessageWriteDaoIF {
	
	public boolean deleteMessage(Map<String, Object> paramMap) throws Exception;
	
	public boolean deleteMessageUsers(Map<String, Object> paramMap) throws Exception;
	
	public boolean updateReadMessageStatus(Map<String, Object> paramMap) throws Exception;
	
	public Integer insertMessage(Map<String, Object> paramMap) throws Exception;
	
	public boolean insertMessageUsers(Map<String, Object> paramMap) throws Exception;

	public boolean batchMessage(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 写入发送到上级报名通知在edu_message表
	 * @param paramMap
	 * @return 如果插入成功返回插入数据的id，否则返回-1
	 */
	public Integer insertMessageToBoss1(Map<String, Object> paramMap);
	/**
	 * 写入发送到上级报名通知在edu_message_users表
	 * @param paramMap
	 * @return boolean标志位是否插入成功
	 */
	public boolean insertMessageToBoss2(Map<String, Object> paramMap);
	
	/**
	 * 插入审核信息通知
	 * TMACJ
	 */
	public Integer insertMessageToReview(Map<String,Object> paramMap);
}
