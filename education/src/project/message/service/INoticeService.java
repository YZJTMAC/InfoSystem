package project.message.service;

import java.util.List;
import java.util.Map;

import project.message.pojo.EduNotice;
import project.message.pojo.EduNoticeFile;
import project.message.pojo.EduNoticeUser;
import framelib.utils.page.PageObject;

/**
 * 通知Service
 * 
 * @author liuyiyou
 * 
 */
public interface INoticeService {

	/**
	 * 发送通知
	 * @param ParamMap
	 * @return int :通知Id
	 * @throws Exception
	 */
	int sendNotice(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 通知地区，一条通知有多个地区。登录用户可查看该地区以及下级地区的通知
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	boolean addArea(Map<String,Object> paramMap) throws Exception;
	
	/**
	 * 收到的通知列表
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	PageObject noticeList(Map<String, Object> paramMap,int pageSize,int startIndex)
			throws Exception;
	
	/**
	 * 收到的通知列表
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	PageObject myNoticeList(Map<String,Object> paramMap,int pageSize,int startIndex) throws Exception;
	
	Integer selectNoticeCount(Map<String, Object> paramMap) throws Exception;

	Integer readNoticeCount(Map<String, Object> paramMap);
	
	EduNotice noticeDetail(Integer id);
	
	
	boolean readNotice(Map<String,Object> paramMap) throws Exception;
	
	List<EduNoticeUser> getNoticeUser(Map<String, Object> paramMap);

	boolean deleteNotice(Map<String, Object> paramMap);

	boolean noticeDeleteFromOther(Map<String, Object> paramMap);
	
	List<String> readNoticeIds(Map<String, Object> paramMap);
	
	boolean addNoticeFile(Map<String, Object> paramMap) throws Exception;
	
	List<EduNoticeFile> selectNoticeFilesByNoticeId(Integer noticeId);
	
}
