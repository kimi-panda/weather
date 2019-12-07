package net.limonova.weather.repository;

import net.limonova.weather.model.WeatherResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ServiceRepository extends JpaRepository<WeatherResourceEntity, Integer> {

    @Override
    @Transactional
    WeatherResourceEntity save(WeatherResourceEntity item);
}
