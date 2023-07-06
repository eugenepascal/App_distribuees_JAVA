package org.rygn.tse_spring.components;

import org.rygn.tse_spring.interfaces.Feline;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Feline {

	@Override
	public String toString() {
		return "Cat instance";
	}
}
