package es.uca.iw.okto.backend.repositories;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uca.iw.okto.backend.models.Trip;
import es.uca.iw.okto.backend.models.UserTrip;

/**
 * TripRepository
 */
public interface TripRepository extends JpaRepository<Trip, Long> {
  Trip findByStartAfter(LocalDate start);

  @Query("SELECT trip FROM UserTrip ut WHERE ut.user.id = :userId")
  Collection<Trip> findByUserId(@Param("userId")Long id);

  @Query("SELECT * FROM UserTrip ut WHERE ut.user.id = :userId")
  Collection<UserTrip> findUserTrip(@Param("userId")Long id);
}
