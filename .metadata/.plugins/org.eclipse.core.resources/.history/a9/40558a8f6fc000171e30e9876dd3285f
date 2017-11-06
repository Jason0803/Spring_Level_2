package spring.service.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import spring.service.domain.User;

public class UserTestApp02 {
	public static void main(String[] args) {
		
	ApplicationContext factory = new ClassPathXmlApplicationContext(
			new String[ ] {
					"config/userservice.xml",
					"config/userservice02.xml"
			});			
		
		System.out.println("\n=================================================");
		User user01 = (User)factory.getBean("user05");
		System.out.println(user01);
		
		System.out.println("\n=================================================");
		User user02 = (User)factory.getBean("user06");
		System.out.println(user02);
		
		System.out.println("\n=================================================");
		User user03 = (User)factory.getBean("user07");
		System.out.println(user03);
		
		System.out.println("\n=================================================");
		User user04 = (User)factory.getBean("user08");
		System.out.println(user04);
		

	}

}
