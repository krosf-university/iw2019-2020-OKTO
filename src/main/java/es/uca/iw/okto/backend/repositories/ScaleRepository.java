package es.uca.iw.okto.backend.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.Scale;

/**
 * ScaleRepository
 */
public interface ScaleRepository extends JpaRepository<Scale, Long> {

	Scale findByStartAfter(LocalDate start);

}
