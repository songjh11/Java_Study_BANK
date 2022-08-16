package com.iu.start.start.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	//자동차는 엔진이 없으면 X
	//자동차는 엔진에 의존적이다
	private Engine engine;
	private Wheel leftWheel;
	private Wheel rightWheel;

	
	//1.
	//private Engine engine  = new Engine();
	
	//2.
	//Car car = new Car();
	//car.engine = new Engine();<-private라 안됨
	
	//3.
//	public Car() {
//		this.engine = new Engine();
//	}
	@Autowired
	public Car(Engine engine) {
		this.engine = engine;
	}
	
	//4.
	//{
	//this.engine = new Engine();
	//}
	
	//5.
	public Engine getEngine() {
		return engine;
	}
	
	@Autowired
	public void setEngine(Engine engine, Wheel leftWheel, Wheel rightWheel) {
		this.engine = engine;
		this.leftWheel = leftWheel;
		this.rightWheel = rightWheel;
	}
	
	

}
