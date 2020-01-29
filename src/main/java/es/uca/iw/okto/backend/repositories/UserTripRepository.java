package es.uca.iw.okto.backend.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uca.iw.okto.backend.models.UserTrip;

/**
 * TripRepository
 */
public interface UserTripRepository extends JpaRepository<UserTrip, Long> {  
  @Query("FROM UserTrip ut WHERE ut.user.id = :userId")
  Collection<UserTrip> findUserTrip(@Param("userId")Long id);
}
