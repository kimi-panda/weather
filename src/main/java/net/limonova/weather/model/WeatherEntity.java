package net.limonova.weather.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather", uniqueConstraints = {@UniqueConstraint(columnNames = {"city_id", "weather_resource_id", "date_time"},
        name = "weather_unique_city_weather_resource_datetime_idx")})
public class WeatherEntity extends AbstractBaseEntity {

    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private CityEntity city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "weather_resource_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private WeatherResourceEntity weatherResourceEntity;

    @Column(name = "temperature")
    @Range(min = -100, max = 100)
    private int temperature;

    public WeatherEntity() {
    }

    public WeatherEntity(LocalDateTime dateTime, int temperature) {
        this(null, dateTime, null, null, temperature);
    }

    public WeatherEntity(LocalDateTime dateTime, CityEntity city, WeatherResourceEntity weatherResourceEntity, int temperature) {
        this(null, dateTime, city, weatherResourceEntity, temperature);
    }

    public WeatherEntity(Integer id, LocalDateTime dateTime, CityEntity city, WeatherResourceEntity weatherResourceEntity, int temperature) {
        super(id);
        this.dateTime = dateTime;
        this.city = city;
        this.weatherResourceEntity = weatherResourceEntity;
        this.temperature = temperature;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public WeatherResourceEntity getWeatherResourceEntity() {
        return weatherResourceEntity;
    }

    public void setWeatherResourceEntity(WeatherResourceEntity weatherResourceEntity) {
        this.weatherResourceEntity = weatherResourceEntity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "WeatherEntity{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", city='" + city +
                ", weatherResourse=" + weatherResourceEntity +
                ", temperature=" + temperature +
                '}';
    }
}
