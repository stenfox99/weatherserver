package by.bsuir.weather.service;

import by.bsuir.weather.model.entity.Weather;

import java.time.LocalDate;
import java.util.List;

public interface WeatherService extends BaseService<Weather> {

    List<Weather> getWeatherByCity(String name);
    List<Weather> getWeatherByDate(LocalDate date);
    List<Weather> getObjects(LocalDate date, String city);
}
