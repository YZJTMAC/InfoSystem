package project.message.dao;

import java.util.Map;

/**
 * 通知写Dao
 * @author liuyiyou
 *
 */
public interface INoticeWriteDao {
	
	/**
	 * 插入通知
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int insertNotice(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 插入通知所属地区
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public boolean insertNoticeArea(Map<String, Object> paramMap) throws Exception;

	public boolean readNotice(Map<String, Object> paramMap);
	
	boolean deleteNotice(Map<String, Object> paramMap);
	
	boolean deleteNoticeUser(Map<String, Object> paramMap);
	
	boolean deleteNoticeArea(Map<String, Object> paramMap);

	boolean noticeDeleteFromOther(Map<String, Object> paramMap);
	
	public boolean addNoticeFile(Map<String, Object> paramMap) throws Exception;
}
