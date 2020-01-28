package es.uca.iw.okto.backend.services;

import java.util.Collection;
import java.util.UUID;

import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.PasswordToken;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.PasswordTokenRepository;
import es.uca.iw.okto.backend.repositories.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final PasswordTokenRepository passwordTokenRepository;
  private final MailService mailService;

  public UserService(UserRepository userRepository, PasswordTokenRepository passwordTokenRepository,
      MailService mailService) {
    this.userRepository = userRepository;
    this.passwordTokenRepository = passwordTokenRepository;
    this.mailService = mailService;
  }

  public Collection<User> findAll() {
    return userRepository.findAll();
  }

  public int countAll() {
    return (int) userRepository.count();
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public User create(User user) {
    user = userRepository.save(user);
    final PasswordToken token = new PasswordToken(UUID.randomUUID().toString(), user);
    passwordTokenRepository.save(token);
    mailService.sendEmail(user.getEmail(), "OKTO TOKEN",
        String.format("http://localhost:8080/password?id=%s&token=%s", user.getId(), token.getToken()));
    return user;
  }

  public void delete(User user) {
    userRepository.delete(user);
  }
}
