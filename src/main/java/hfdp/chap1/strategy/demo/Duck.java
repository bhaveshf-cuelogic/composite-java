package hfdp.chap1.strategy.demo;

public class Duck {
	Flyable f;
	
	public void performFly() {
		f.fly();
	}
	
	public void setFlyBehavior(Flyable f) {
		this.f = f;
	}
}
