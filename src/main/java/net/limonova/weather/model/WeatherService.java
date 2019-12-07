package net.limonova.weather.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "services")
public class WeatherService extends AbstractBaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "weatherServiceEnum")
    private WeatherServiceEnum weatherServiceEnum;

    @Column(name = "url_string")
    private String urlString;

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public WeatherServiceEnum getWeatherServiceEnum() {
        return weatherServiceEnum;
    }

    public void setWeatherServiceEnum(WeatherServiceEnum weatherServiceEnum) {
        this.weatherServiceEnum = weatherServiceEnum;
    }

    public WeatherService() {
    }

    public WeatherService(Integer id, WeatherServiceEnum weatherServiceEnum, String urlString) {
        super(id);
        this.weatherServiceEnum = weatherServiceEnum;
        this.urlString = urlString;
    }

    @Override
    public String toString() {
        return "WeatherService{" +
                "urlString='" + urlString + '\'' +
                ", weatherServiceEnum='" + weatherServiceEnum + '\'' +
                ", id=" + id +
                '}';
    }
}
