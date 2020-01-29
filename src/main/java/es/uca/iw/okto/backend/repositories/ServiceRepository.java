package es.uca.iw.okto.backend.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uca.iw.okto.backend.models.Service;

/**
 * ServiceRepository
 */
public interface ServiceRepository extends JpaRepository<Service, Long> {

	Service findByNameIgnoreCase(String name);

	@Query("SELECT service FROM Service ser WHERE ser.ship.id IN (SELECT ship.id FROM Trip tr WHERE tr.id IN (SELECT trip.id FROM UserTrip us Where us.user.id = :userId))")
  	Collection<Service> findByUserId(@Param("userId")Long id);
}
