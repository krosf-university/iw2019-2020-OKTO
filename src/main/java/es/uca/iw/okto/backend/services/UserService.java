package es.uca.iw.okto.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.UserRepository;

/**
 * UserService
 */
public class UserService implements UserDetailsService {

  private UserRepository repository;
  private PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
    super();
    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
  }

  public void create(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    repository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repository.findByEmail(username);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    }
    return user;
  }
}
