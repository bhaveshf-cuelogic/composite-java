package hfdp.chap1.strategy.demo;

public class RubberDuck extends Duck {
	public RubberDuck() {
		f = new FlyNoWay();
	}
}
