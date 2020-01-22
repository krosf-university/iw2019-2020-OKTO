package es.uca.iw.okto.backend;

import javax.transaction.Transactional;

import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.UserRepository;

@Component
public class Seeder implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private UserRepository userRepository;

  private Faker faker = new Faker();

  @Override
  @Transactional
  public void onApplicationEvent(final ContextRefreshedEvent event) {
    for (int i = 0; i < 20; ++i) {
      createUserIfNotFound(faker.internet().emailAddress(), faker.name().firstName(), faker.name().lastName(),
          faker.internet().password(), faker.bothify("########?"), faker.numerify("6########"), User.Role.USER);
    }
  }

  @Transactional
  void createUserIfNotFound(final String email, final String firstName, final String lastName, final String password,
      final String dni, final String phone, final String role) {
    User user = userRepository.findByEmailIgnoreCase(email);
    if (user == null) {
      user = new User();
      user.setEmail(email);
      user.setFirstName(firstName);
      user.setLastName(lastName);
      user.setPassword(password);
      user.setDni(dni);
      user.setPhone(phone);
      user.setRole(role);
      user.setEnabled(true);
      userRepository.save(user);
    }
  }
}