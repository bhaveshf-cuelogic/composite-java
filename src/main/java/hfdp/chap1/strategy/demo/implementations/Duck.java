package hfdp.chap1.strategy.demo.implementations;

import hfdp.chap1.strategy.demo.interfaces.Flyable;

public class Duck {
	Flyable f;
	
	public void performFly() {
		f.fly();
	}
	
	public void setFlyBehavior(Flyable f) {
		this.f = f;
	}
}
