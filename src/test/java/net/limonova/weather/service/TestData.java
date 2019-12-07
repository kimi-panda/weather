package net.limonova.weather.service;

import net.limonova.weather.model.CityEntity;
import net.limonova.weather.model.WeatherEntity;
import net.limonova.weather.model.WeatherResource;
import net.limonova.weather.model.WeatherResourceEntity;

import java.time.Month;
import java.util.List;

import static java.time.LocalDateTime.of;
import static net.limonova.weather.model.AbstractBaseEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;

public class TestData {
    public static final int CITY_ID = START_SEQ;
    public static final int CITY_ID2 = START_SEQ;
    public static final CityEntity CITY1 = new CityEntity(CITY_ID, "Yakutsk", "24959");
    public static final CityEntity CITY2 = new CityEntity(CITY_ID2, "Chelyabinsk", "28642");

    public static final int WEATHER_RESOURCE_ID = START_SEQ+2;
    public static final WeatherResourceEntity WEATHER_RESOURCE1 = new WeatherResourceEntity(
            WEATHER_RESOURCE_ID, WeatherResource.GISMETEO, "http://informer.gismeteo.ru/xml/codeGismeteo-1.xml");

    public static final int WEATHER_ID = START_SEQ + 3;
    public static final WeatherEntity WEATHER1 = new WeatherEntity(
            WEATHER_ID, of(2019, Month.MAY, 30, 10, 0), CITY1, WEATHER_RESOURCE1, 15);

    public static WeatherEntity getNew() {
        return new WeatherEntity(null, of(2019, Month.MAY, 30, 11, 0), CITY2, WEATHER_RESOURCE1, 25);
    }

    public static void assertMatch(WeatherEntity actual, WeatherEntity expected) {
        assertThat(actual).isEqualTo(expected);
    }


    public static void assertMatch(Iterable<WeatherEntity> actual, Iterable<WeatherEntity> expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<WeatherEntity> actual, WeatherEntity... expected) {
        assertMatch(actual, List.of(expected));
    }


}
