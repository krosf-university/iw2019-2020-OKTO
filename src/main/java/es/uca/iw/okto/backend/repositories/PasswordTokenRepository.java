package es.uca.iw.okto.backend.repositories;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import es.uca.iw.okto.backend.models.PasswordToken;
import es.uca.iw.okto.backend.models.User;

public interface PasswordTokenRepository extends JpaRepository<PasswordToken, Long> {

  PasswordToken findByToken(String token);

  PasswordToken findByUser(User user);

  Stream<PasswordToken> findAllByExpiryDateLessThan(Date now);

  void deleteByExpiryDateLessThan(Date now);

  @Modifying
  @Query("DELETE FROM PasswordToken t WHERE t.expiryDate <= ?1")
  void deleteAllExpiredSince(Date now);
}