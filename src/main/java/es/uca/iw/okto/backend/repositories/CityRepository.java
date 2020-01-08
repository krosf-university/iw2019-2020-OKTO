package es.uca.iw.okto.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.City;

/**
 * CityRepository
 */
public interface CityRepository extends JpaRepository<City,Long> {
}