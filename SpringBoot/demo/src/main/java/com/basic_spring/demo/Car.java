package com.basic_spring.demo;

import org.springframework.stereotype.Component;

@Component
public class Car {
	private Engine engine;
	public Car(Engine engine) {
		this.engine = engine;
	}
	public void drive() {
		engine.start();
		System.out.println("Now ur car is moving forward.");
	}
}
