package com.example.weather;

public class WeatherFormatter {
    public String format(String location, String rawWeather) {
        return "Weather Report for " + location + ": " + rawWeather;
    }
}
