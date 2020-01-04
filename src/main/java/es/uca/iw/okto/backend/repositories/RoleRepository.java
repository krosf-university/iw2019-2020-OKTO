package es.uca.iw.okto.backend.repositories;

import es.uca.iw.okto.backend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Role findByName(String name);
}
