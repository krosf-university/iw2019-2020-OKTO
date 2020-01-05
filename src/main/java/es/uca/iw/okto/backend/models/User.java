package es.uca.iw.okto.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import es.uca.iw.okto.backend.utils.AbstractEntity;

@Entity
public class User extends AbstractEntity {

  private static final long serialVersionUID = 4220485624755494919L;

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @NotBlank
  private String dni;

  @NotEmpty
  @Email
  @Column(unique = true)
  private String email;

  @Column(nullable = true)
  private String phone;

  @NotNull
  @Size(min = 4, max = 255)
  private String password;

  @NotBlank
  @Size(max = 255)
  private String role;

  private boolean enabled = false;

  public User() {
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @PrePersist
  @PreUpdate
  private void prepareData() {
    this.email = email == null ? null : email.toLowerCase();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((email == null) ? 0 : email.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final User user = (User) obj;
    if (!email.equals(user.email)) {
      return false;
    }
    return true;
  }

  public static class Role {
    public static final String USER = "user";
    public static final String ADMIN = "admin";

    private Role() {
    }

    public static String[] getAllRoles() {
      return new String[] {ADMIN, USER};
    }

  }
}
