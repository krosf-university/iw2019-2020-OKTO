package es.uca.iw.okto.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import es.uca.iw.okto.backend.models.City;

/**
 * CityRepository
 */
public interface CityRepository extends JpaRepository<City,Long> {
    Page<City> findBy(Pageable pageable);

    City findByNameIgnoreCase(String name);
}