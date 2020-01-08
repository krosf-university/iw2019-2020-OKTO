package es.uca.iw.okto.backend.utils;

import com.github.javafaker.Faker;

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

  private Faker faker = new Faker();

  @Override
  @Transactional
  public void onApplicationEvent(final ContextRefreshedEvent event) {
    if (!alreadySetup) {
      createUserIfNotFound("admin@okto.com", "Test", "Test", "okto", "00000000O", "000000000",
          User.Role.ADMIN);
      createUserIfNotFound("user@okto.com", "Test", "Test", "okto", "00000000O", "000000000",
          User.Role.USER);
      createUserIfNotFound("gerente@okto.com", "Test", "Test", "okto", "00000000O", "000000000",
          User.Role.GERENTE);
      alreadySetup = true;

      for (int i = 0; i < 10; ++i) {
        createUserIfNotFound(
          faker.internet().safeEmailAddress(),
          faker.name().firstName(),
          faker.name().lastName(),
          faker.internet().password(),
          faker.bothify("########?"),
          faker.numerify("6########"),
          User.Role.USER
        );
      }
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
