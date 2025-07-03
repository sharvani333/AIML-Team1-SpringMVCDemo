package com.example.weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherDataProvider {
    // 🔐 Replace with your actual OpenWeatherMap API key
    private static final String API_KEY = "d353f9e324013fb89c3c004172f8255c";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public String getWeather(String location) {
        try {
            String url = BASE_URL + "?q=" + location + "&appid=" + API_KEY + "&units=metric";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());

            // Check if city not found
            if (root.has("cod") && root.get("cod").asInt() == 404) {
                return "❌ City not found: " + location;
            }

            // Handle invalid API key or bad response
            if (!root.has("main") || !root.has("weather")) {
                return "⚠️ Unexpected response structure:\n" + response.body();
            }

            // Extract and validate data
            JsonNode weatherArray = root.get("weather");
            if (!weatherArray.isArray() || weatherArray.size() == 0) {
                return "⚠️ Weather information not available.";
            }

            String weather = weatherArray.get(0).get("description").asText();
            double temp = root.get("main").get("temp").asDouble();
            String country = root.has("sys") && root.get("sys").has("country")
                    ? root.get("sys").get("country").asText()
                    : "Unknown";

            return String.format("%s, %.1f°C, %s", country, temp, weather);

        } catch (Exception e) {
            return "💥 Error fetching weather: " + e.getMessage();
        }
    }
}
