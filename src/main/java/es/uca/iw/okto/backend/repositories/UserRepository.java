package es.uca.iw.okto.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.User;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmailIgnoreCase(String email);
}
