package AirTrafficControl;

public class WeatherProvider {
    private WeatherProvider weatherProvider;
    private String weather;

    private void WeatherProvider() {

    }

    public WeatherProvider getProvider() {
        return this.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return this.weather;
    }

}
