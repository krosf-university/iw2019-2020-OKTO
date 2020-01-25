package es.uca.iw.okto.backend.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Tip
 */
@Entity
@Override
public class Tip extends AbstractEntity {
  private static final long serialVersionUID = 4394291262804331237L;

  private String description;

  @ManyToOne
  @JoinColumn(name = "city_id", nullable = false)
  private City city;

  public Tip(String description, City city) {
    this.description=description;
    this.city=city;
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
