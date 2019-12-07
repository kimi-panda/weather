package net.limonova.weather.service;

import net.limonova.weather.model.WeatherEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static net.limonova.weather.service.TestData.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@Sql(scripts = {"classpath:initDB.sql","classpath:populateDB.sql"}, config = @SqlConfig(encoding = "UTF-8"))

class WeatherServiceTest {

    @Autowired
    protected WeatherService service;

    @Test
    void create() throws Exception {
        WeatherEntity newWeatherEntity = getNew();
        WeatherEntity created = service.create(newWeatherEntity, CITY_ID2, WEATHER_RESOURCE_ID);
        Integer newId = created.getId();
        newWeatherEntity.setId(newId);
        assertMatch(created, newWeatherEntity);
        assertMatch(service.get(newId), newWeatherEntity);
    }

    @Test
    void getAll() throws Exception {
        List<WeatherEntity> all = service.getAll();
        assertMatch(all, WEATHER1);
    }

    @Test
    void get() throws Exception {
        WeatherEntity actual = service.get(WEATHER_ID);
        assertMatch(actual, WEATHER1);
    }
}