package by.bsuir.weather.model.dto;

import by.bsuir.weather.model.serializer.DateDeserializer;
import by.bsuir.weather.model.serializer.DateSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WeatherDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String city;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDate date;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal temp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal windSpeed;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long pressure;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal humidity;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal airQuality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Long getPressure() {
        return pressure;
    }

    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(BigDecimal airQuality) {
        this.airQuality = airQuality;
    }
}
