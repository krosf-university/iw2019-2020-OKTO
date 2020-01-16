package es.uca.iw.okto.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.Ship;

/**
 * ShipRepository
 */
public interface ShipRepository extends JpaRepository<Ship, Long> {
  Page<Ship> findBy(Pageable pageable);

  Ship findByNameIgnoreCase(String name);
}