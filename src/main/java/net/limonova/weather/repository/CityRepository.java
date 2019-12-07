package net.limonova.weather.repository;

import net.limonova.weather.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CityRepository extends JpaRepository<City, Integer> {

    @Override
    @Transactional
    City save(City item);
}
