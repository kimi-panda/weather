package net.limonova.weather.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather", uniqueConstraints = {@UniqueConstraint(columnNames = {"city_id", "service_id", "date_time"}, name = "weather_unique_city_service_datetime_idx")})
public class Weather extends AbstractBaseEntity {

    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private WeatherService service;

    @Column(name = "temperature")
    @Range(min = -100, max = 100)
    private int temperature;

    public Weather() {
    }

    public Weather(LocalDateTime dateTime, int temperature) {
        this(null, dateTime, null, null, temperature);
    }

    public Weather(Integer id, LocalDateTime dateTime, City city, WeatherService service, int temperature) {
        super(id);
        this.dateTime = dateTime;
        this.city = city;
        this.service = service;
        this.temperature = temperature;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public WeatherService getService() {
        return service;
    }

    public void setService(WeatherService service) {
        this.service = service;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", city='" + city +
                ", service=" + service +
                ", temperature=" + temperature +
                '}';
    }
}
