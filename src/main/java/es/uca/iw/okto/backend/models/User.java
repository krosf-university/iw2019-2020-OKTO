package es.uca.iw.okto.backend.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class User implements UserDetails, Serializable, Cloneable {
  /**
   *
   */
  private static final long serialVersionUID = -8769481576163041861L;

  @Id
  @Column(unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String firstName;

  private String lastName;

  private String DNI;

  private String email;

  @Column(length = 60)
  private String password;

  private String phone;

  private boolean enabled;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Collection<Role> roles;

  public User() {
  }

  public User(String firstName, String lastName, String DNI, String email, String password, String phone,
      Collection<Role> roles) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.DNI = DNI;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.roles = roles;
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

  public String getDNI() {
    return DNI;
  }

  public void setDNI(String DNI) {
    this.DNI = DNI;
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

  /**
   * Returns the authorities granted to the user. Cannot return <code>null</code>.
   *
   * @return the authorities, sorted by natural key (never <code>null</code>)
   */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  /**
   * Returns the password used to authenticate the user.
   *
   * @return the password
   */
  @Override
  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Returns the username used to authenticate the user. Cannot return
   * <code>null</code>.
   *
   * @return the username (never <code>null</code>)
   */
  @Override
  public String getUsername() {
    return this.email;
  }

  /**
   * Indicates whether the user's account has expired. An expired account cannot
   * be authenticated.
   *
   * @return <code>true</code> if the user's account is valid (ie non-expired),
   *         <code>false</code> if no longer valid (ie expired)
   */
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  /**
   * Indicates whether the user is locked or unlocked. A locked user cannot be
   * authenticated.
   *
   * @return <code>true</code> if the user is not locked, <code>false</code>
   *         otherwise
   */
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  /**
   * Indicates whether the user's credentials (password) has expired. Expired
   * credentials prevent authentication.
   *
   * @return <code>true</code> if the user's credentials are valid (ie
   *         non-expired), <code>false</code> if no longer valid (ie expired)
   */
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /**
   * Indicates whether the user is enabled or disabled. A disabled user cannot be
   * authenticated.
   *
   * @return <code>true</code> if the user is enabled, <code>false</code>
   *         otherwise
   */
  @Override
  public boolean isEnabled() {
    return this.enabled;
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
    return email.equals(user.email);
  }

  public void setRoles(Collection<Role> roles) {
    this.roles = roles;
  }

  public void setEnabled(boolean b) {
    this.enabled = b;
  }
}
