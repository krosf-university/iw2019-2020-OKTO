package es.uca.iw.okto.backend.repositories;

import java.time.LocalDate;
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

  @Query("SELECT ser FROM Service ser WHERE ser.ship.id IN (SELECT ship.id FROM Trip tr WHERE tr.id IN (SELECT trip.id FROM UserTrip us WHERE us.user.id = :userId) AND tr.end > :now AND :now > tr.start)")
  Collection<Service> findByUserOnCurrentTrip(@Param("userId") Long id, @Param("now") LocalDate now);

  default Collection<Service> findByUserOnCurrentTrip(Long id) {
    return findByUserOnCurrentTrip(id, LocalDate.now());
  }
}
