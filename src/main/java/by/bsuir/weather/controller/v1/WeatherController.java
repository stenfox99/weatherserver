package by.bsuir.weather.controller.v1;

import by.bsuir.weather.builder.WeatherConverter;
import by.bsuir.weather.model.dto.WeatherDTO;
import by.bsuir.weather.model.entity.Weather;
import by.bsuir.weather.model.exception.NotFoundException;
import by.bsuir.weather.model.exception.SaveException;
import by.bsuir.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/v1/weather")
public class WeatherController {

    private final WeatherConverter weatherConverter;
    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
        weatherConverter = new WeatherConverter();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createWeather(@RequestBody WeatherDTO weatherDTO) {
        Weather weather = weatherConverter.convertToEntity(weatherDTO);
        boolean isInserted = weatherService.add(weather);
        if (!isInserted) {
            throw new SaveException("Can't save your entity");
        }
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WeatherDTO updateWeather(@RequestBody WeatherDTO weatherDTO,
                                    @PathVariable("id") Long id) {
        Weather weather = weatherConverter.convertToEntity(weatherDTO);
        Weather newWeather = weatherService.update(weather, id);
        return weatherConverter.convertToDTO(newWeather);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWeather(@PathVariable("id") Long id) {
        if (!weatherService.delete(id)) {
            throw new NotFoundException("Selected wasn't wasn't found");
        }

    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WeatherDTO getWeatherById(@PathVariable("id") Long id) {
        Weather weather = weatherService
                .getObjectById(id)
                .orElseThrow(() -> new NotFoundException("Selected wasn't wasn't found"));
        return weatherConverter.convertToDTO(weather);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WeatherDTO> getWeathers(@QueryParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
                                        @QueryParam("city") String city) {
        List<Weather> weathers =
                weatherService
                        .getObjects(Objects.nonNull(date) ? new java.sql.Date(date.getTime()).toLocalDate() : null, city);
        return weatherConverter.convertToDTO(weathers);
    }
}
