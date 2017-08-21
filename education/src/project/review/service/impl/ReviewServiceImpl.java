package project.review.service.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.master.pojo.EduComparison;
import project.review.dao.IReviewReadDao;
import project.review.dao.IReviewWriteDao;
import project.review.service.IReviewService;
/**
 * @description 这是一个ReviewService实现类
 * @author TMACJ
 *
 */
public class ReviewServiceImpl implements IReviewService{

	private static final Logger log = Logger.getLogger(ReviewServiceImpl.class);
	
	@Autowired
	@Qualifier("reviewReadDao")
	IReviewReadDao reviewReadDao;

	@Autowired
	@Qualifier("reviewWriteDao")
	IReviewWriteDao reviewWriteDao;

	@Override
	public int addInformationForTeacher(Map para1Map,Map para2Map) {
		EduComparison eduComparison = reviewReadDao.selectComparisonByName(para1Map);
		Integer id = Integer.getInteger(eduComparison.getId());
		if(id!=null){
			para2Map.put("comparisonId", id);
			int result = reviewWriteDao.insertTeacherInfo(para2Map);
			return result;
		}	
		return -1;
	}
	

	
}
