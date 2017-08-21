package project.review.dao;

import java.util.Map;

/**
 * @description ReviewWriteDao的接口
 * @author TMACJ
 *
 */
public interface IReviewWriteDao extends IReviewDao{
	
	/**
	 * @description上传教师信息
	 * @return 布尔值判断是否上传成功
	 */
	public int insertTeacherInfo(Map paraMap);
	
}
