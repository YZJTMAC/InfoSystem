package project.message.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import framelib.utils.page.PageObject;

import project.message.pojo.EduMessage;
import project.message.pojo.MessageTree;
import project.person.pojo.EduUser;
import project.person.pojo.EduUserActivty;

public interface IMessageServiceIF {
	public int selectMessageCounts(Map<String, Object> paramMap)throws Exception;
	public List<EduMessage> selectMessageListByReceverId(Map<String,Object> paramMap)throws Exception;
	boolean deleteMessage(Map<String,Object> ParamMap) throws Exception;
	boolean updateMessageStatus(Map<String,Object> ParamMap) throws Exception;
	List<EduUser> selectUserList(String receverName) throws Exception;
  //hanlongfei 审核不通过消息
	public List<EduMessage> selectMessageListShenghe(Map<String, Object> paramMap) throws Exception;
	//审核消总息条数
	public int selectMessageShenheCounts(Map<String, Object> paramMap) throws Exception;

	/**
	 * 如果发送通知的时候需要上传附件，则进行文件上传
	 * @author liuyiyou
	 * @param request
	 * @param resultMap
	 * @param ParamMap
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> fileUpload(HttpServletRequest request,Map<String, Object> resultMap,Map<String, Object> ParamMap,MultipartFile files) throws Exception;
	
	
	/**
	 * 根据Id获取消息
	 */
	public EduMessage findMessageById(Integer id);
	
	/**
	 * 收到的消息列表
	 */
	PageObject messageList(Map<String, Object> paramMap, int type, int pageSize,int startIndex, Map<String,Object> resultMap) throws Exception;
	
	
	/**
	 * 我创建的消息列表
	 */
	PageObject myMessageList(Map<String, Object> paramMap, int pageSize,int startIndex, Map<String,Object> resultMap) throws Exception;
	
	/**
	 * 发送消息
	 */
	public Map<String, Object> sendMessageByType(String sendType, String title, String content, String createBy, int messageType, String sendUserName,
												int sendUserId, String receiveUserId, String receiveUserName, Map<String, Object> paramMap, boolean isMultipart, HttpServletRequest request) throws Exception;
	
	/**
	 * 获取节点树
	 */
	public List<MessageTree> getNodeTree(Map<String, Object> paramMap, int receiveRole) throws Exception;
	
	public boolean deleteMessageCreate(Map<String,Object> paramMap) throws Exception;
	/**
	 * 向上级发送消息在edu_message
	 */
	public Integer sendMessageToBoss1(String content,int messageType,String createBy,int sendUserId,String title,String sendUserName);

	/**
	 * 向上级发送消息在edu_message_users
	 */
	public boolean sendMessageToBoss2(Integer messageId,Integer status,String updateBy);
	/**
	 * 向上级发送消息
	 */
	public boolean sendMessageToBoss(String content, int messageType,
			String createBy, int sendUserId, String title, String sendUserName,
			Integer status, String updateBy);
	/**
	 * 发送审核消息通知
	 * TMACJ
	 * @throws Exception 
	 */
	public Integer sendMessageToReview(Map<String, Object> paramMap) throws Exception;
	/**
	 * 得到消息接受者信息
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<EduUserActivty> getReceiveInfo(Map<String, Object> paramMap) throws Exception;
}
