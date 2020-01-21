package es.uca.iw.okto.backend.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import es.uca.iw.okto.backend.utils.AbstractEntity;

/**
 * Tip
 */
@Entity
public class Tip extends AbstractEntity {
  private static final long serialVersionUID = 4394291262804331237L;

  @NotBlank
  @NotEmpty
  private String description;

  @ManyToOne
  @JoinColumn(name="city_id", nullable=false)
  private City city;

  public Tip() {
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "Tip [city=" + city.getId() + ", description=" + description + "]";
  }
}