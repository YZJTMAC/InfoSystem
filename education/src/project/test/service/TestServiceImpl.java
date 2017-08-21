package project.test.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import project.test.dao.ITestDao;

public class TestServiceImpl implements ITestService{
	
	private Logger log = Logger.getLogger(TestServiceImpl.class);
	
	@Autowired
	@Qualifier("testDao")
	ITestDao testDao;

	@Override
	public void testDao() {
		testDao.testDao("tmacj");
		log.info("======test==========");
	}
	
}
