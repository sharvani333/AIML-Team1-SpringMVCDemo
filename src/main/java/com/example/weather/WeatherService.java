package com.example.weather;

public class WeatherService {
    private WeatherDataProvider dataProvider;
    private WeatherFormatter formatter;

    // Setter methods for XML injection
    public void setDataProvider(WeatherDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public void setFormatter(WeatherFormatter formatter) {
        this.formatter = formatter;
    }

    public void showWeather(String location) {
        String rawData = dataProvider.getWeather(location);
        String output = formatter.format(location, rawData);
        System.out.println(output);
    }
}
