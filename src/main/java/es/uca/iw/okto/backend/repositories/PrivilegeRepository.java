package es.uca.iw.okto.backend.repositories;

import es.uca.iw.okto.backend.models.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
  Privilege findByName(String name);
}
