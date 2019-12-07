package net.limonova.weather.model;

import javax.persistence.*;

@Entity
@Table(name = "weather_resources")
public class WeatherResourceEntity extends AbstractBaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private WeatherResource weatherResource;

    @Column(name = "url_string")
    private String urlString;

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public WeatherResource getWeatherResource() {
        return weatherResource;
    }

    public void setWeatherResource(WeatherResource weatherResource) {
        this.weatherResource = weatherResource;
    }

    public WeatherResourceEntity() {
    }

    public WeatherResourceEntity(Integer id, WeatherResource weatherResource, String urlString) {
        super(id);
        this.weatherResource = weatherResource;
        this.urlString = urlString;
    }

    @Override
    public String toString() {
        return "WeatherResourceEntity{" +
                "urlString='" + urlString + '\'' +
                ", weatherResource='" + weatherResource + '\'' +
                ", id=" + id +
                '}';
    }
}
