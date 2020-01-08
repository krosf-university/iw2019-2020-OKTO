package es.uca.iw.okto.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.Tip;

/**
 * TipRepository
 */
public interface TipRepository extends JpaRepository<Tip,Long> {
}