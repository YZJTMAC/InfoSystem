package project.message.dao;

import java.util.List;
import java.util.Map;

import project.message.pojo.EduNotice;
import project.message.pojo.EduNoticeFile;
import project.message.pojo.EduNoticeUser;

/**
 * 通知Read相关dao
 * @author liuyiyou
 *
 */
public interface INoticeReadDao {

	/**
	 * 通知列表
	 * @param paramMap
	 * @return
	 */
	List<EduNotice> noticeList(Map<String, Object> paramMap);
	
	Integer selectNoticeCount(Map<String, Object> paramMap);
	
	
	Integer selectMyNoticeListCount(Map<String, Object> paramMap) ;

	/**
	 * 通知详细内容
	 * @param id
	 * @return
	 */
	EduNotice selectById(Integer id);

	Integer readNoticeCount(Map<String, Object> paramMap);

	List<EduNoticeUser> getNoticeUser(Map<String, Object> paramMap);

	List<EduNotice> myNoticeList(Map<String, Object> paramMap);

	List<String> readNoticeIds(Map<String, Object> paramMap);

	List<EduNoticeFile> selectNoticeFilesByNoticeId(Integer noticeId);

}
