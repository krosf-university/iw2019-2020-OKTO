package es.uca.iw.okto.backend.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.UserRepository;


@Component
public class Seeder implements ApplicationListener<ContextRefreshedEvent> {
  private boolean alreadySetup = false;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public void onApplicationEvent(final ContextRefreshedEvent event) {
    if (!alreadySetup) {
      createUserIfNotFound("okto@okto.com", "Test", "Test", "adminokto", "00000000O", "000000000",
          User.Role.ADMIN);
      alreadySetup = true;
    }
  }


  @Transactional
  void createUserIfNotFound(final String email, final String firstName, final String lastName,
      final String password, final String dni, final String phone, String role) {
    User user = userRepository.findByEmailIgnoreCase(email);
    if (user == null) {
      user = new User();
      user.setEmail(email);
      user.setFirstName(firstName);
      user.setLastName(lastName);
      user.setPassword(passwordEncoder.encode(password));
      user.setDni(dni);
      user.setPhone(phone);
      user.setRole(role);
      user.setEnabled(true);
    }
    userRepository.save(user);
  }

}
