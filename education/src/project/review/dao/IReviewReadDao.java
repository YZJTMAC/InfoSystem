package project.review.dao;

import java.util.List;
import java.util.Map;

import project.master.pojo.EduComparison;

/**
 * @description ReviewReadDao的接口
 * @author TMACJ
 *
 */
public interface IReviewReadDao extends IReviewDao{
	
	/**
	 * 查询活动列表
	 * @return 返回活动List
	 */
	public List selectAllActivity();
	/**
	 * 查询某一个活动中的所有老师列表
	 * @return 返回老师List
	 */
	public List selectAllTeacherInActivity();
	/**
	 * @param paraMap
	 * @return EduComparison
	 * 根据活动名查找活动
	 */
	public EduComparison selectComparisonByName(Map paraMap);
}
