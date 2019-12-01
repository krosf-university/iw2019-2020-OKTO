package es.uca.iw.okto.backend.repositories;

import es.uca.iw.okto.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
  User findByEmail(String username);
}
