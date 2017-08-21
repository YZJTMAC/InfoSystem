import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;


public class Tes {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/spring/common/beans.xml");
		context.getBean("eduMasterService");
	}
}
