package by.bsuir.weather.dao.impl;

import by.bsuir.weather.mapper.WeatherMapper;
import by.bsuir.weather.model.entity.Weather;
import by.bsuir.weather.dao.WeatherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class WeatherDAO_Impl implements WeatherDAO {
    private static final String FIELDS =
            "weather.id, weather.city, weather.dateWeather, weather.temp, weather.windSpeed, " +
            "weather.pressure, weather.humidity, weather.weatherDescription, weather.airQuality, " +
            "weather.createdDate, weather.isDeleted";

    private static final String SAVE = "INSERT INTO Weather(city, temp, windSpeed, pressure, " +
            "humidity, weatherDescription, airQuality, isDeleted, createdDate) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, 0, CURDATE())";

    private static final String UPDATE = "UPDATE Weather w SET " +
            "w.city = ?, w.dateWeather = ?, w.temp = ?, w.windSpeed = ?, w.pressure = ?, w.humidity = ?," +
            "w.weatherDescription = ?,w.airQuality = ? WHERE w.id = ?";

    private static final String DELETE = "UPDATE Weather w SET w.isDeleted = 1 WHERE w.id = ?";

    private static final String GET_ALL = "SELECT " + FIELDS + " FROM weather WHERE weather.isDeleted = 0";

    private static final String GET_BY_ID = "SELECT " + FIELDS + " FROM weather WHERE weather.id = ? and weather.isDeleted = 0";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WeatherDAO_Impl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean add(Weather object) {
        Object[] parameters = {object.getCity(), object.getTemp(),
                object.getWindSpeed(), object.getPressure(), object.getHumidity(),
                object.getDescription(), object.getAirQuality()};
        return jdbcTemplate.update(SAVE, parameters, new WeatherMapper()) > 0;

    }

    @Override
    public boolean update(Weather object, Long id) {
        Object[] parameters = {object.getCity(), object.getDateWeather(), object.getTemp(),
                object.getWindSpeed(), object.getPressure(), object.getHumidity(),
                object.getDescription(), object.getAirQuality(), id};
        return jdbcTemplate.update(UPDATE, parameters, new WeatherMapper()) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update(DELETE, id) > 0;
    }

    @Override
    public Optional<Weather> getObjectById(Long id) {
        List<Weather> weathers = jdbcTemplate.query(GET_BY_ID, new WeatherMapper(), id);
        return weathers.isEmpty() ? Optional.empty() : Optional.of(weathers.get(0));
    }

    @Override
    public List<Weather> getObjects() {
        return jdbcTemplate.query(GET_ALL, new WeatherMapper());
    }
}
