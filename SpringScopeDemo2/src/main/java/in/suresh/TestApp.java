package in.suresh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.suresh.model.Address;
import in.suresh.model.Person;

public class TestApp {
	
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("springbean.xml");
		Person p1 = (Person) container.getBean("person");
		Person p2 = (Person) container.getBean("person"); 
		Person p3 = (Person) container.getBean("person");
		Person p4 = (Person) container.getBean("person");
	
		Address a1 = (Address) container.getBean("address");
		Address a2 = (Address) container.getBean("address");
		Address a3 = (Address) container.getBean("address");
		Address a4 = (Address) container.getBean("address");
	}

}
