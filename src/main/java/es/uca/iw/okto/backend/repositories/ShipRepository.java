package es.uca.iw.okto.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.Ship;

/**
 * ShipRepository
 */
public interface ShipRepository extends JpaRepository<Ship, Long> {

	Ship findByNameIgnoreCase(String name);

}
