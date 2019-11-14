package hfdp.chap1.strategy.demo;

public class FlywithWings implements Flyable {

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("I have "+this.getClass().getSimpleName()+" : Flying with wings");
	}

}
