package es.uca.iw.okto.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.Tour;

/**
 * TourRepository
 */
public interface TourRepository extends JpaRepository<Tour,Long> {
}