package es.uca.iw.okto.backend.services;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.PasswordToken;
import es.uca.iw.okto.backend.repositories.PasswordTokenRepository;

@Service
public class PasswordTokenService {

  private PasswordTokenRepository passwordTokenRepository;

  public PasswordTokenService(PasswordTokenRepository passwordTokenRepository) {
    this.passwordTokenRepository = passwordTokenRepository;
  }

  public String validateToken(Long id, String token) {
    final PasswordToken passToken = passwordTokenRepository.findByToken(token);
    if ((passToken == null) || (passToken.getUser().getId() != id)) {
      return "invalid";
    }

    final Calendar cal = Calendar.getInstance();
    if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
      return "expired";
    }

    return "valid";
  }
}