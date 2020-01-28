package es.uca.iw.okto.backend.services;

import java.util.Calendar;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.PasswordToken;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.PasswordTokenRepository;

@Service
public class PasswordTokenService {

  private PasswordTokenRepository passwordTokenRepository;
  private UserService userService;
  private PasswordEncoder passwordEncoder;

  public PasswordTokenService(PasswordTokenRepository passwordTokenRepository, UserService userService,
      PasswordEncoder passwordEncoder) {
    this.passwordTokenRepository = passwordTokenRepository;
    this.userService = userService;
    this.passwordEncoder = passwordEncoder;
  }

  public String validateTokenAndCreatePassword(Long id, String token, String password) {
    final PasswordToken passToken = passwordTokenRepository.findByToken(token);
    if ((passToken == null) || (passToken.getUser().getId() != id)) {
      return "invalid";
    }

    final Calendar cal = Calendar.getInstance();
    if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
      return "expired";
    }

    User user = passToken.getUser();
    user.setPassword(passwordEncoder.encode(password));
    user.setEnabled(true);
    userService.save(user);

    return "valid";
  }
}