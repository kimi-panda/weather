package net.limonova.weather.service;

import net.limonova.weather.model.CityEntity;
import net.limonova.weather.model.WeatherEntity;
import net.limonova.weather.model.WeatherResourceEntity;
import net.limonova.weather.model.WeatherResource;
import net.limonova.weather.repository.CityRepository;
import net.limonova.weather.repository.ServiceRepository;
import net.limonova.weather.repository.WeatherRepository;

import java.io.*;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;

@Service
@Transactional
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final CityRepository cityRepository;
    private final ServiceRepository serviceRepository;

    @Autowired
    public WeatherService(WeatherRepository repository, CityRepository cityRepository, ServiceRepository serviceRepository) {
        this.weatherRepository = repository;
        this.cityRepository = cityRepository;
        this.serviceRepository = serviceRepository;
    }

    public Integer getTemperature(CityEntity city, WeatherResourceEntity weatherResourceEntity) {
        if (weatherResourceEntity.getWeatherResource() == WeatherResource.GISMETEO) {
            try {
                return getTemperatureGismeteo(city.getCodeGismeteo(), weatherResourceEntity.getUrlString());
            } catch (Exception e) {}
        }
        return null;
    }

    public Integer getTemperatureGismeteo(String codeGismeteo, String weather_resource_url) throws Exception {
        URL url = new URL(weather_resource_url.replace("codeGismeteo", codeGismeteo));
        InputStream stream = url.openStream();
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(stream);
        NodeList nodeList = doc.getElementsByTagName("TEMPERATURE");
        int temperature = Integer.parseInt(
                nodeList.item(0).getAttributes().getNamedItem("max").getNodeValue());
        return temperature;
    }

    public WeatherEntity create(WeatherEntity weather, int city_id, int weather_resource_id) {
        CityEntity city = cityRepository.findById(city_id).orElse(null);
        WeatherResourceEntity weatherResourceEntity = serviceRepository.findById(weather_resource_id).orElse(null);
        weather.setCity(city);
        weather.setWeatherResourceEntity(weatherResourceEntity);
        Integer temperature = getTemperature(city, weatherResourceEntity);
        weather.setTemperature(temperature);
        return weatherRepository.save(weather);
    }

    public List<WeatherEntity> getAll() {
        return weatherRepository.findAll();
    }

    public WeatherEntity get(int id) {
        return weatherRepository.findById(id).orElse(null);
    }
}