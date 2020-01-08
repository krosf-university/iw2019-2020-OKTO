package es.uca.iw.okto.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.UserTrip;

/**
 * UserTripRepository
 */
public interface UserTripRepository extends JpaRepository<UserTrip,Long> {
}