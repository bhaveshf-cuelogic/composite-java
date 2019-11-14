package hfdp.client;

import hfdp.chap1.strategy.demo.Duck;
import hfdp.chap1.strategy.demo.FlyNoWay;
import hfdp.chap1.strategy.demo.RedheadDuck;
import hfdp.chap1.strategy.demo.RubberDuck;

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
