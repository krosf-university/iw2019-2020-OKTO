package es.uca.iw.okto.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import es.uca.iw.okto.backend.models.Trip;

/**
 * TripRepository
 */
public interface TripRepository extends JpaRepository<Trip, Long> {
    Page<Trip> findBy(Pageable pageable);

    Trip findByEmailIgnoreCase(String email);
  
    Page<Trip> findByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(
        String emailLike, String firstNameLike, String lastNameLike, String roleLike,
        Pageable pageable);
  
    long countByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(
        String emailLike, String firstNameLike, String lastNameLike, String roleLike);
}
