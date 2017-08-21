package project.review.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import project.master.pojo.EduComparison;
import project.review.controller.ReviewController;
import project.review.dao.IReviewDao;
import project.review.dao.IReviewReadDao;
import framelib.dao.BaseDAOImpl;

/**
 * @description ReviewDao具体实现类
 * @author TMACJ
 *
 */

public class ReviewReadDaoImpl extends BaseDAOImpl implements IReviewReadDao{
	
	private static final Logger log = Logger.getLogger(ReviewReadDaoImpl.class);

	@Override
	public List selectAllActivity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAllTeacherInActivity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EduComparison selectComparisonByName(Map paraMap) {
		return (EduComparison) this.getSqlMapClientTemplate().queryForObject("selectComparisonByName",paraMap);
	}
}
