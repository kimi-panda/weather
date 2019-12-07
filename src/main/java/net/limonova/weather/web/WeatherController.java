package net.limonova.weather.web;

import net.limonova.weather.model.WeatherEntity;
import net.limonova.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService service;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/weatherList")
    public String updateOrCreate(HttpServletRequest request) throws Exception {
        WeatherEntity weather = new WeatherEntity(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), 15);
        service.create(weather,
                Integer.valueOf(request.getParameter("cityId")),
                Integer.valueOf(request.getParameter("weather_resource")));
        request.setAttribute("weather", service.getAll());

        return "weather";
    }
}