package in.kittu.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.kittu.core.model.Employee;

public class Application {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ConfigBeans.xml");
		Employee e = (Employee)ac.getBean("eb");
		
		System.out.println(e.getEmpid());
		System.out.println(e.getEname());
		System.out.println(e.getSalary());
	}

}
