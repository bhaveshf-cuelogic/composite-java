package hfdp.chap1.strategy.demo.implementations;

import hfdp.chap1.strategy.demo.interfaces.Flyable;

public class FlywithWings implements Flyable {

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("I have "+this.getClass().getSimpleName()+" : Flying with wings");
	}

}
