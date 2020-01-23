package es.uca.iw.okto.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.Activity;

/**
 * ActivityRepository
 */
public interface ActivityRepository extends JpaRepository<Activity, Long> {

	Activity findByNameIgnoreCase(String name);

}
