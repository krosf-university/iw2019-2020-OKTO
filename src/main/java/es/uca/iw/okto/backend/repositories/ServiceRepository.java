package es.uca.iw.okto.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import es.uca.iw.okto.backend.models.Service;

/**
 * ActivityRepository
 */
public interface ServiceRepository extends JpaRepository<Service, Long> {
    Page<Service> findBy(Pageable pageable);

    Service findByNameIgnoreCase(String name);
  
    // Page<Activity> findByStartAfterOrEndAfterOrNameOrIgnoreCase(
    //     LocalDate Start, LocalDate End, String name, Pageable pageable);
}
