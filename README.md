## 🌦️ Weather Web App

A simple and interactive weather web application built with **Spring Boot**, using **OpenWeatherMap API** to fetch real-time weather data and display it via a clean UI built with **HTML (Thymeleaf)**.

---

## 🚀 Features

- 🌍 Get real-time weather data by entering any city name.
- 📦 Integrated OpenWeatherMap API.
- 💻 Built using Spring Boot (v2.7.18) and Thymeleaf.
- 🧪 Includes unit testing using JUnit.
- 📁 Uses XML-based bean configuration (`beans.xml`).
- 👓 Pretty UI output using HTML templates (`index.html`, `weather.html`).

---

## 🛠️ Technologies Used

- Java 8+
- Spring Boot
- Maven
- Thymeleaf (for HTML UI rendering)
- OpenWeatherMap API
- JUnit (for testing)

---

## 🧾 Project Structure

```

weather-xml-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/weather/
│   │   │       ├── WeatherApp.java
│   │   │       ├── WeatherController.java
│   │   │       ├── WeatherDataProvider.java
│   │   │       ├── WeatherFormatter.java
│   │   │       └── WeatherService.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── index.html
│   │       │   └── weather.html
│   │       └── beans.xml
│   └── test/
│       └── java/com/example/weather/
│           └── AppTest.java
├── pom.xml
└── README.md

````

---

## 🌐 API Reference

- [OpenWeatherMap API](https://openweathermap.org/api)
- Replace `your_api_key_here` in `WeatherDataProvider.java` with your actual API key.

---

## 🧪 Running the Application

### 1. Build the JAR
```bash
mvn clean package
````

### 2. Run the App

```bash
java -jar target/weather-web-app-1.0.0.jar
```

### 3. Open in Browser

```
http://localhost:8080
```

## 4. Output

🌤️ Weather Console App
Type 'exit' to quit.

Enter city name: city_name
🌤️ Weather in "city_name"
🌡️ Temperature: 32.1°C
💧 Humidity: 53%
🌬️ Wind Speed: 3.5 m/s
☁️ Condition: overcast clouds
        🔙 Back

## 👩‍💻 Author

Sharvani Cheruku
