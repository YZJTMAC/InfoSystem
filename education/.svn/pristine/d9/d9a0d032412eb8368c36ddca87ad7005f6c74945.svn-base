package framelib.mq;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title:SpringJmsProducerMain
 * Description:
 * @Create_by:Vince Yu
 * @Create_date:2012-5-5
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class SpringJmsProducerMain {
	/**
	 * 2011-5-16, 下午05:17:02
	 * 方法描述：
	 */
		public static void main(String[] args) {

	        BeanFactory factory = new ClassPathXmlApplicationContext(
	                "config/spring/activeMQ/spring-jms.xml");

	        SpringJmsProducer producer = null;

	        producer = (SpringJmsProducer) factory.getBean("producer");

	        producer.send("hello world,jms");
	       // producer.send(new App("liulina","1"));

	    }


	
}

