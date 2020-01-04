package es.uca.iw.okto.backend.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import es.uca.iw.okto.backend.models.Privilege;
import es.uca.iw.okto.backend.models.Role;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.PrivilegeRepository;
import es.uca.iw.okto.backend.repositories.RoleRepository;
import es.uca.iw.okto.backend.repositories.UserRepository;


@Component
public class Seeder implements ApplicationListener<ContextRefreshedEvent> {
  private boolean alreadySetup = false;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PrivilegeRepository privilegeRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public void onApplicationEvent(final ContextRefreshedEvent event) {
    if (alreadySetup) {
      return;
    }

    // == create initial privileges
    final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
    final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
    final Privilege passwordPrivilege = createPrivilegeIfNotFound("CHANGE_PASSWORD_PRIVILEGE");

    // == create initial roles
    final List<Privilege> adminPrivileges =
        new ArrayList<Privilege>(Arrays.asList(readPrivilege, writePrivilege, passwordPrivilege));
    final List<Privilege> userPrivileges =
        new ArrayList<Privilege>(Arrays.asList(readPrivilege, passwordPrivilege));
    final Role adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
    createRoleIfNotFound("ROLE_USER", userPrivileges);

    // == create initial user
    createUserIfNotFound("okto@okto.com", "Test", "Test", "adminokto", "00000000O", "000000000",
        new ArrayList<Role>(Collections.singletonList(adminRole)));

    alreadySetup = true;
  }

  @Transactional
  Privilege createPrivilegeIfNotFound(final String name) {
    Privilege privilege = privilegeRepository.findByName(name);
    if (privilege == null) {
      privilege = new Privilege(name);
      privilege = privilegeRepository.save(privilege);
    }
    return privilege;
  }

  @Transactional
  Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
    Role role = roleRepository.findByName(name);
    if (role == null) {
      role = new Role(name);
    }
    role.setPrivileges(privileges);
    role = roleRepository.save(role);
    return role;
  }

  @Transactional
  void createUserIfNotFound(final String email, final String firstName, final String lastName,
      final String password, final String dni, final String phone, final Collection<Role> roles) {
    User user = userRepository.findByEmail(email);
    if (user == null) {
      user = new User();
      user.setEmail(email);
      user.setFirstName(firstName);
      user.setLastName(lastName);
      user.setPassword(passwordEncoder.encode(password));
      user.setDni(dni);
      user.setPhone(phone);
      user.setRoles(roles);
      user.setEnabled(true);
    }
    userRepository.save(user);
  }

}
