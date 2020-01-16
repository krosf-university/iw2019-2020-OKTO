package es.uca.iw.okto.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.User;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {
  Page<User> findBy(Pageable pageable);

  User findByEmailIgnoreCase(String email);

  Page<User> findByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(String emailLike, String firstNameLike, String lastNameLike, String roleLike, Pageable pageable);

  long countByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(String emailLike, String firstNameLike, String lastNameLike, String roleLike);
}
