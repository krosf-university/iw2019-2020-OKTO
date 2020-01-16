package es.uca.iw.okto.backend.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.Scale;

/**
 * ScaleRepository
 */
public interface ScaleRepository extends JpaRepository<Scale, Long> {
  Page<Scale> findBy(Pageable pageable);

  Scale findByStartAfter(LocalDate start);
}