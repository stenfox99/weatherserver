package by.bsuir.weather.dao;

import by.bsuir.weather.model.entity.Weather;

import java.time.LocalDate;
import java.util.List;

public interface WeatherDAO extends BaseDAO<Weather> {

    List<Weather> getWeatherByCity(String name);
    List<Weather> getWeatherByDate(LocalDate date);
}
