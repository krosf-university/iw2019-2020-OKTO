package es.uca.iw.okto.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.UserRepository;

@Service
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

  /**
   * Locates the user based on the username. In the actual implementation, the search may possibly
   * be case sensitive, or case insensitive depending on how the implementation instance is
   * configured. In this case, the <code>UserDetails</code> object that comes back may have a
   * username that is of a different case than what was actually requested..
   *
   * @param username the username identifying the user whose data is required.
   * @return a fully populated user record (never <code>null</code>)
   * @throws UsernameNotFoundException if the user could not be found or the user has no
   *                                   GrantedAuthority
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repository.findByEmail(username);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    }
    return user;
  }
}
