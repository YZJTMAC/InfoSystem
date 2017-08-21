package framelib.mq;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title:SpringJmsConsumerMain
 * Description:
 * @Create_by:Vince Yu
 * @Create_date:2012-5-5
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class SpringJmsConsumerMain {
	
	 public static void main(String[] args) {

	        BeanFactory factory = new ClassPathXmlApplicationContext(
	                "config/spring/activeMQ/spring-jms.xml");
 
	        SpringJmsConsumer consumer = null;

	        consumer = (SpringJmsConsumer) factory.getBean("consumer");

	        System.out.println("message = " + consumer.receive().toString());

	    }


}
