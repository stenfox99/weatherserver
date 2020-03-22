package by.bsuir.weather.mapper;

import by.bsuir.weather.model.entity.Weather;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class WeatherMapper implements RowMapper<Weather> {

    private static final String ID = "id";
    private static final String CITY = "city";
    private static final String DATE_WEATHER = "dateWeather";
    private static final String TEMP = "temp";
    private static final String WIND_SPEED = "windSpeed";
    private static final String PRESSURE = "pressure";
    private static final String HUMIDITY  = "humidity";
    private static final String WEATHER_DESCRIPTION = "weatherDescription";
    private static final String AIR_QUALITY = "airQuality";
    private static final String IS_DELETED = "isDeleted";
    private static final String CREATED_DATE = "createdDate";

    @Override
    public Weather mapRow(ResultSet resultSet, int i) throws SQLException {
        Weather weather = new Weather();

        weather.setId(resultSet.getLong(ID));
        weather.setCity(resultSet.getString(CITY));

        Date dateWeather = resultSet.getDate(DATE_WEATHER);
        weather.setDateWeather(dateWeather != null ? dateWeather.toLocalDate() : null);

        weather.setTemp(resultSet.getBigDecimal(TEMP));
        weather.setWindSpeed(resultSet.getBigDecimal(WIND_SPEED));
        weather.setPressure(resultSet.getLong(PRESSURE));
        weather.setHumidity(resultSet.getBigDecimal(HUMIDITY));
        weather.setDescription(resultSet.getString(WEATHER_DESCRIPTION));
        weather.setAirQuality(resultSet.getBigDecimal(AIR_QUALITY));
        weather.setDeleted(resultSet.getBoolean(IS_DELETED));

        weather.setCreatedDate(resultSet.getDate(CREATED_DATE).toLocalDate());

        return weather;
    }
}
