package by.bsuir.weather.service.impl;

import by.bsuir.weather.model.entity.Weather;
import by.bsuir.weather.model.exception.NotFoundException;
import by.bsuir.weather.dao.WeatherDAO;
import by.bsuir.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
