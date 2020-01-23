package es.uca.iw.okto.backend.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.Trip;

/**
 * TripRepository
 */
public interface TripRepository extends JpaRepository<Trip, Long> {

	Trip findByStartAfter(LocalDate start);

}
