package net.limonova.weather.web;

import net.limonova.weather.model.Weather;
import net.limonova.weather.model.WeatherServiceEnum;
import net.limonova.weather.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Controller
public class MainController {

    @Autowired
    private MainService service;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/weatherList")
    public String updateOrCreate(HttpServletRequest request) throws Exception {
        Weather weather = new Weather(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), 15);
        service.create(weather,
                Integer.valueOf(request.getParameter("cityId")),
                Integer.valueOf(request.getParameter("service")));
        request.setAttribute("weather", service.getAll());

        return "weather";
    }
}