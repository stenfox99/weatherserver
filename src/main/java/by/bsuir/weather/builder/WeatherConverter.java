package by.bsuir.weather.builder;

import by.bsuir.weather.model.dto.WeatherDTO;
import by.bsuir.weather.model.entity.Weather;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherConverter {

    public WeatherDTO convertToDTO(Weather weather) {
        WeatherDTO weatherDTO = new WeatherDTO();

        weatherDTO.setId(weather.getId());
        weatherDTO.setAirQuality(weather.getAirQuality());
        weatherDTO.setCity(weather.getCity());
        weatherDTO.setDate(weather.getDateWeather());
        weatherDTO.setDescription(weather.getDescription());
        weatherDTO.setHumidity(weather.getHumidity());
        weatherDTO.setPressure(weather.getPressure());
        weatherDTO.setTemp(weather.getTemp());
        weatherDTO.setWindSpeed(weather.getWindSpeed());

        return weatherDTO;
    }

    public List<WeatherDTO> convertToDTO(Collection<Weather> weathers) {
        return weathers.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Weather convertToEntity(WeatherDTO weatherDTO) {
        Weather weather = new Weather();

        weather.setId(weatherDTO.getId());
        weather.setAirQuality(weatherDTO.getAirQuality());
        weather.setCity(weatherDTO.getCity());
        weather.setDateWeather(weatherDTO.getDate());
        weather.setDescription(weatherDTO.getDescription());
        weather.setHumidity(weatherDTO.getHumidity());
        weather.setPressure(weatherDTO.getPressure());
        weather.setTemp(weatherDTO.getTemp());
        weather.setWindSpeed(weatherDTO.getWindSpeed());

        return weather;
    }

    public List<Weather> convertToEntity(Collection<WeatherDTO> weatherDTOS) {
        return weatherDTOS.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
}
