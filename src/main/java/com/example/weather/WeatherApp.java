package com.example.weather;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        WeatherService service = context.getBean("weatherService", WeatherService.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("🌤️ Weather Console App");
        System.out.println("Type 'exit' to quit.\n");

        while (true) {
            System.out.print("Enter city name: ");
            String city = scanner.nextLine().trim();

            if (city.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye! 👋");
                break;
            }

            service.showWeather(city);
            System.out.println(); // for spacing
        }

        scanner.close();
    }
}
