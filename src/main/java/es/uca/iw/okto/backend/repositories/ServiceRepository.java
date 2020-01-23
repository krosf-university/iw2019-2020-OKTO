package es.uca.iw.okto.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.Service;

/**
 * ServiceRepository
 */
public interface ServiceRepository extends JpaRepository<Service, Long> {

	Service findByNameIgnoreCase(String name);

}
