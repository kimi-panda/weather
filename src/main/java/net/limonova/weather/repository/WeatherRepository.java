package net.limonova.weather.repository;

import net.limonova.weather.model.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface WeatherRepository extends JpaRepository<WeatherEntity, Integer> {

    @Override
    @Transactional
    WeatherEntity save(WeatherEntity item);

}