package hfdp.chap1.strategy.demo;

public class FlyNoWay implements Flyable {

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("I have "+this.getClass().getSimpleName()+" : No way, I can't fly");
	}

}
