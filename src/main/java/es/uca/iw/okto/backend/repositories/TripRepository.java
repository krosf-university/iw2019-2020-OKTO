package es.uca.iw.okto.backend.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.Trip;

/**
 * TripRepository
 */
public interface TripRepository extends JpaRepository<Trip, Long> {
  Page<Trip> findBy(Pageable pageable);

  Trip findByStartAfter(LocalDate start);

  Page<Trip> findByStartAfterOrEndAfterOrShipNameContainingIgnoreCase(LocalDate Start, LocalDate End, String ship, Pageable pageable);
}
