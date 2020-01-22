package es.uca.iw.okto.backend.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
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

  public void delete(User user) {
    userRepository.delete(user);
  }
}
