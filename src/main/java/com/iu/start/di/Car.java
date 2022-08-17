package com.iu.start.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Car {
	//자동차는 엔진이 없으면 X
	//자동차는 엔진에 의존적이다
	private Engine engine;
	private Wheel leftWheel;
	private Wheel rightWheel;

	
	//1.
	//private Engine engine  = new Engine();
	

	
	//3.
//	public Car() {
//		this.engine = new Engine();
//	}
//	@Autowired
//	public Car(Engine engine) {
//		this.engine = engine;
//	}
	
	//4.
	//{
	//this.engine = new Engine();
	//}
	
	//5.
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public Car (Wheel leftWheel, Wheel rightWheel) {
		this.leftWheel = leftWheel;
		this.rightWheel = rightWheel;
	}
	

}
