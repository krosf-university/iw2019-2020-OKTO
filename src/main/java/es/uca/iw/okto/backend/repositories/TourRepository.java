package es.uca.iw.okto.backend.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.Tour;

/**
 * TourRepository
 */
public interface TourRepository extends JpaRepository<Tour, Long> {
  Page<Tour> findBy(Pageable pageable);

  Tour findByStartAfter(LocalDate start);
}