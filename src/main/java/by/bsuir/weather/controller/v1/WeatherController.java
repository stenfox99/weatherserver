package by.bsuir.weather.controller.v1;

import by.bsuir.weather.builder.WeatherConverter;
import by.bsuir.weather.model.dto.WeatherDTO;
import by.bsuir.weather.model.entity.Weather;
import by.bsuir.weather.model.exception.NotFoundException;
import by.bsuir.weather.model.exception.SaveException;
import by.bsuir.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(111111);
        if (weatherService.delete(id)) {
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
    public String getWeathers() {
        return "aaaaaa";
    }
}
