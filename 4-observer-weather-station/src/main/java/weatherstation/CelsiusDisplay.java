package weatherstation;

public class CelsiusDisplay implements Observer, DisplayElement {

	private float celsiusTemp = 0.0f;
	private WeatherData weatherData;

	public CelsiusDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update() {
		float temp = weatherData.getTemperature();
		celsiusTemp = (temp - 32) * 0.5556f;
		display();
	}

	public void display() {
		System.out.println("Temperature in C = " + celsiusTemp);
	}
}
