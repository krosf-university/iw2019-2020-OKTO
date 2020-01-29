package es.uca.iw.okto.backend.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * City
 */
@Entity
public class City extends AbstractEntity {
  private static final long serialVersionUID = -6743878952544679659L;

  private String name;

  private String country;

  private String description;

  @OneToMany(mappedBy = "city")
  private Collection<Tip> tips;

  @OneToMany(mappedBy = "city")
  private Collection<Scale> scales;

  public City() {
    // Empty due to JPA use of getters and setters
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Collection<Tip> getTips() {
    return tips;
  }

  public void setTips(Collection<Tip> tips) {
    this.tips = tips;
  }

  @Override
  public String toString() {
    return "City [description=" + description + ", name=" + name + "]";
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
