package AirTrafficControl;

import Hanger.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"SUN", "FOG", "RAIN", "SNOW"};

    private  WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int height = coordinates.getHeight();
        int lat = coordinates.getLatitude();
        int lng = coordinates.getLongitude();

        if (height > 95) {return weather[0];}
        int pos = height + lat + lng % 4;
        switch (pos) {
            case 0:
                return weather[0];
            case 1:
                return weather[1];
            case 2:
                return weather[2];
            default:
                return weather[3];
        }
    }
}
