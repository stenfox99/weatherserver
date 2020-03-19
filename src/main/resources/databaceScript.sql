CREATE DATABASE IF NOT EXISTS WeatherServer;

USE WeatherServer;

CREATE TABLE IF NOT EXISTS Weather(
	  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	  city VARCHAR(50),
    dateWeather DATE,
    temp DOUBLE,
    windSpeed DOUBLE,
    pressure BIGINT,
    humidity DOUBLE,
    weatherDescription VARCHAR(255),
    airQuality DOUBLE,
    isDeleted TINYINT,
    createdDate DATE
);