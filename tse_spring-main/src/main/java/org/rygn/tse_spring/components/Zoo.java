package org.rygn.tse_spring.components;

import org.rygn.tse_spring.interfaces.Bird;
import org.rygn.tse_spring.interfaces.Canine;
import org.rygn.tse_spring.interfaces.Feline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Zoo {

	@Autowired
	private Bird bird;
	
	@Autowired
	private Canine canine;
	
	@Autowired
	private Feline feline;

	@Override
	public String toString() {
		return "Zoo [bird=" + bird + ", canine=" + canine + ", feline=" + feline + "]";
	}
}
