package net.limonova.weather.repository;

import net.limonova.weather.model.WeatherService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ServiceRepository extends JpaRepository<WeatherService, Integer> {

    @Override
    @Transactional
    WeatherService save(WeatherService item);
}
