
package weatherstation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WeatherDataTest {

    @Test
    public void testScenario() {
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay = new CurrentConditionsDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        Observer forecastDisplay = new ForecastDisplay(weatherData);
        Observer celsiusDisplay = new CelsiusDisplay(weatherData);
        Observer feelsLikeDisplay = new FeelsLikeDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        weatherData.removeObserver(forecastDisplay);
        weatherData.setMeasurements(62, 90, 28.1f);

        weatherData.removeObserver(feelsLikeDisplay);
        weatherData.registerObserver(forecastDisplay);
        weatherData.setMeasurements(72, 80, 22.1f);

    }

}
