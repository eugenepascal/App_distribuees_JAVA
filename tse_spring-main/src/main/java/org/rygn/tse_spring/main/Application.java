package org.rygn.tse_spring.main;

import org.rygn.tse_spring.components.Zoo;
import org.rygn.tse_spring.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		/*
		for (String beanName : applicationContext.getBeanDefinitionNames()) {
        
			System.out.println(beanName);
        }
        */
		
		Zoo zoo = applicationContext.getBean(Zoo.class);
		
		System.out.println(zoo);
	}
}
