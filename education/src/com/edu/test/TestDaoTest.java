package com.edu.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import project.test.service.ITestService;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("file:D:/workspace4/education/config/config/spring/applicationContext.xml")  
public class TestDaoTest {
	
	@Resource(name="testService")
	ITestService testService;
	
	@Test
	public void test(){
		testService.testDao();
		System.out.println("=====");
	}
}
