package net.limonova.weather.service;

import net.limonova.weather.model.City;
import net.limonova.weather.model.Weather;
import net.limonova.weather.model.WeatherService;
import net.limonova.weather.model.WeatherServiceEnum;
import net.limonova.weather.repository.CityRepository;
import net.limonova.weather.repository.ServiceRepository;
import net.limonova.weather.repository.WeatherRepository;

import java.io.*;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;

@Service
@Transactional
public class MainService {

    private final WeatherRepository weatherRepository;
    private final CityRepository cityRepository;
    private final ServiceRepository serviceRepository;

    @Autowired
    public MainService(WeatherRepository repository, CityRepository cityRepository, ServiceRepository serviceRepository) {
        this.weatherRepository = repository;
        this.cityRepository = cityRepository;
        this.serviceRepository = serviceRepository;
    }

    public Integer getTemperature(City city, WeatherService service) {
        if (service.getWeatherServiceEnum() == WeatherServiceEnum.GISMETEO) {
            try {
                return getTemperatureGismeteo(city.getCodeGismeteo(), service.getUrlString());
            } catch (Exception e) {}
        }
        return null;
    }

    public Integer getTemperatureGismeteo(String codeGismeteo, String service_url) throws Exception {
        URL url = new URL(service_url.replace("codeGismeteo", codeGismeteo));
        InputStream stream = url.openStream();
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(stream);
        NodeList nodeList = doc.getElementsByTagName("TEMPERATURE");
        int temperature = Integer.parseInt(
                nodeList.item(0).getAttributes().getNamedItem("max").getNodeValue());
        return temperature;
    }

    public Weather create(Weather weather, int city_id, int service_id) {
        Assert.notNull(weather, "weather must not be null");
        City city = cityRepository.findById(city_id).orElse(null);
        WeatherService service = serviceRepository.findById(service_id).orElse(null);
        Assert.notNull(city, "city must not be null");
        weather.setCity(city);
        Assert.notNull(service, "service must not be null");
        weather.setService(service);
        Integer temperature = getTemperature(city, service);
        Assert.notNull(temperature, "temperature must not be null");
        weather.setTemperature(temperature);
        return weatherRepository.save(weather);
    }

    public List<Weather> getAll() {
        return weatherRepository.findAll();
    }
}