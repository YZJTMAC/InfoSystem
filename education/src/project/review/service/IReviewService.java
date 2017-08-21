package project.review.service;

import java.util.Map;

import project.master.pojo.EduComparison;


/**
 * @description IReviewService接口
 * @author TMACJ
 *
 */
public interface IReviewService {
	/**
	 * 上报教师信息
	 * @return 是否上报成功
	 */
	public int addInformationForTeacher(Map param1,Map param2);
		
}
