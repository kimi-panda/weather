package net.limonova.weather.repository;

import net.limonova.weather.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CityRepository extends JpaRepository<CityEntity, Integer> {

    @Override
    @Transactional
    CityEntity save(CityEntity item);
}
