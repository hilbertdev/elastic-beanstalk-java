package com.example.services;

public class TemperatureConverter {
    final double const_celsius = 23.5;

    public double ConvertToFahrenHeit(int roomTemp) {
        double fahrenheit = const_celsius * 9 / 5 + 32;
        return fahrenheit;
    }
}
