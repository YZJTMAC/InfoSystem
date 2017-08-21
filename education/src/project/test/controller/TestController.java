package project.test.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aop.test.A;

import project.test.service.ITestService;



@Controller
@RequestMapping("/test")
public class TestController {
	
	private static final Logger log = Logger.getLogger(TestController.class);
	
	@Autowired
	@Qualifier("testService")
	ITestService testService;
	
	@Autowired
	@Qualifier("a")
	A a;
	
	@RequestMapping("/testController.do")
	public void test(){
		log.info("this is a test message!");
		testService.testDao();
		a.a();
	}
	
}
