package by.bsuir.weather.service.impl;

import by.bsuir.weather.model.entity.Weather;
import by.bsuir.weather.model.exception.NotFoundException;
import by.bsuir.weather.dao.WeatherDAO;
import by.bsuir.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WeatherService_Impl implements WeatherService {
    private WeatherDAO weatherDAO;

    @Autowired
    public WeatherService_Impl(WeatherDAO weatherDAO) {
        this.weatherDAO = weatherDAO;
    }

    @Override
    public boolean add(Weather object) {
        return weatherDAO.add(object);
    }

    @Override
    public Weather update(Weather object, Long id) {
        if (!weatherDAO.update(object, id)) {
            throw new NotFoundException("Selected weather wasn't found");
        }
        object.setId(id);
        return object;
    }

    @Override
    public boolean delete(Long id) {
        return weatherDAO.delete(id);
    }

    @Override
    public Optional<Weather> getObjectById(Long id) {
        return weatherDAO.getObjectById(id);
    }

    @Override
    public List<Weather> getObjects() {
        return weatherDAO.getObjects();
    }

    @Override
    public List<Weather> getWeatherByCity(String name) {
        return weatherDAO.getWeatherByCity(name);
    }

    @Override
    public List<Weather> getWeatherByDate(LocalDate date) {
        return weatherDAO.getWeatherByDate(date);
    }

    @Override
    public List<Weather> getObjects(LocalDate date, String city) {
        List<Weather> weathersInCity = new ArrayList<>();
        List<Weather> weathersOnDate = new ArrayList<>();

        if (Objects.nonNull(date)) {
            weathersOnDate = getWeatherByDate(date.plusDays(1));                              //plus day can be removed, related with db settings
        }

        if (!StringUtils.isEmpty(city)) {
            weathersInCity = getWeatherByCity(city);
        }

        if (Objects.nonNull(date) && !StringUtils.isEmpty(city)) {
            List<Weather> result = new ArrayList<>(weathersOnDate);
            result.retainAll(weathersInCity);
            return result;
        } else if (Objects.nonNull(date) && StringUtils.isEmpty(city)) {
            return weathersOnDate;
        } else if (Objects.isNull(date) && !StringUtils.isEmpty(city)) {
            return weathersInCity;
        } else {
            return getObjects();
        }
    }
}
