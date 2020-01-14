package es.uca.iw.okto.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import es.uca.iw.okto.backend.models.Activity;

/**
 * ActivityRepository
 */
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Page<Activity> findBy(Pageable pageable);

    Activity findByNameIgnoreCase(String name);
  
    // Page<Activity> findByStartAfterOrEndAfterOrNameOrIgnoreCase(
    //     LocalDate Start, LocalDate End, String name, Pageable pageable);
}