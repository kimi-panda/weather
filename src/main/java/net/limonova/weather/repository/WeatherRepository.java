package net.limonova.weather.repository;

import net.limonova.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    @Override
    @Transactional
    Weather save(Weather item);

}