package es.uca.iw.okto.backend.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import es.uca.iw.okto.backend.utils.AbstractEntity;
import es.uca.iw.okto.backend.utils.PasswordGenerator;

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
  @Column(unique = false)
  private String email;

  @Column(nullable = true)
  private String phone;

  private String password;

  @NotBlank
  @Size(max = 255)
  private String role;

  @OneToMany(mappedBy = "user")
  private Collection<UserTrip> trips;

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

  public Collection<UserTrip> getTrips() {
    return trips;
  }

  public void setTrips(Collection<UserTrip> trips) {
    this.trips = trips;
  }

  @PreUpdate
  private void preUpdate() {
    this.email = email == null ? null : email.toLowerCase();
  }

  @PrePersist
  public void prePersist() {
    this.email = email == null ? null : email.toLowerCase();
    this.password = password == null ? PasswordGenerator.getPassword() : password;
  }
  

  public static class Role {
    public static final String USER = "user";
    public static final String ADMIN = "admin";
    public static final String MANAGER = "manager";

    private Role() {
    }

    public static String[] getAllRoles() {
      return new String[] { ADMIN, USER, MANAGER };
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((dni == null) ? 0 : dni.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (dni == null) {
      if (other.dni != null)
        return false;
    } else if (!dni.equals(other.dni))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    return true;
  }
}
