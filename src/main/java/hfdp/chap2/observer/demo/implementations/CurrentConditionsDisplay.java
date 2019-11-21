package hfdp.chap2.observer.demo.implementations;

import hfdp.chap2.observer.demo.interfaces.DisplayElement;
import hfdp.chap2.observer.demo.interfaces.Observer;
import hfdp.chap2.observer.demo.interfaces.Subject;

public class CurrentConditionsDisplay implements DisplayElement, Observer {
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData; //in the future we may want to un-register ourselves as an observer and it would be handy to already have a reference to the subject
		weatherData.registerObserver(this);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Current conditions: " + temperature+ "F degrees and " + humidity + "% humidity");
	}

}
