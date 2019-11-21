package hfdp.chap1.strategy.demo.implementations;

public class RubberDuck extends Duck {
	public RubberDuck() {
		f = new FlyNoWay();
	}
}
