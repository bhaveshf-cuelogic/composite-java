package hfdp.chap1.strategy.client;

import hfdp.chap1.strategy.demo.implementations.Duck;
import hfdp.chap1.strategy.demo.implementations.FlyNoWay;
import hfdp.chap1.strategy.demo.implementations.RedheadDuck;
import hfdp.chap1.strategy.demo.implementations.RubberDuck;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duck d;
		
		d = new RubberDuck();
		d.performFly();
		
		d = new RedheadDuck();
		d.performFly();
		System.out.println("Cutting Readhead's wings now, so it can't fly");
		d.setFlyBehavior(new FlyNoWay());
		d.performFly();
	}

}
