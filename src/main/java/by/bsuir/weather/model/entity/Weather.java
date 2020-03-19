package by.bsuir.weather.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Weather implements Serializable {

    private Long id;
    private String city;
    private LocalDate dateWeather;
    private BigDecimal temp;
    private BigDecimal windSpeed;
    private Long pressure;
    private BigDecimal humidity;
    private String description;
    private BigDecimal airQuality;

    private Boolean isDeleted;
    private LocalDate createdDate;

    public Weather() {
    }

    public Weather(Long id, String city, LocalDate date, BigDecimal temp, BigDecimal windSpeed,
                   Long pressure, BigDecimal humidity, String description, BigDecimal airQuality,
                   Boolean isDeleted, LocalDate createdDate) {
        this.id = id;
        this.city = city;
        this.dateWeather = date;
        this.temp = temp;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.humidity = humidity;
        this.description = description;
        this.airQuality = airQuality;
        this.isDeleted = isDeleted;
        this.createdDate = createdDate;
    }

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

    public LocalDate getDateWeather() {
        return dateWeather;
    }

    public void setDateWeather(LocalDate dateWeather) {
        this.dateWeather = dateWeather;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(id, weather.id) &&
                Objects.equals(city, weather.city) &&
                Objects.equals(dateWeather, weather.dateWeather) &&
                Objects.equals(temp, weather.temp) &&
                Objects.equals(windSpeed, weather.windSpeed) &&
                Objects.equals(pressure, weather.pressure) &&
                Objects.equals(humidity, weather.humidity) &&
                Objects.equals(description, weather.description) &&
                Objects.equals(airQuality, weather.airQuality) &&
                Objects.equals(isDeleted, weather.isDeleted) &&
                Objects.equals(createdDate, weather.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, dateWeather, temp, windSpeed, pressure,
                humidity, description, airQuality, isDeleted, createdDate);
    }
}
