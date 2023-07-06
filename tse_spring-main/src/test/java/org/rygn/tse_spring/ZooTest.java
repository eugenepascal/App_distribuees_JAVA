package org.rygn.tse_spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rygn.tse_spring.components.Zoo;
import org.rygn.tse_spring.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(ApplicationConfig.class)
public class ZooTest {

	@Autowired
	private Zoo zoo;
	
	@Test
	public void testToString() {
		
		Assertions.assertTrue(zoo.toString().contains("Dog instance"));
		
		Assertions.assertTrue(zoo.toString().contains("Cat instance"));
		
		Assertions.assertTrue(zoo.toString().contains("Owl instance"));
	}
}
