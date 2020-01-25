package es.uca.iw.okto.backend.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * City
 */
@Entity
@Override
public class City extends AbstractEntity {
  private static final long serialVersionUID = -6743878952544679659L;

  private String name;

  private String description;

  @OneToMany(mappedBy = "city")
  private Collection<Tip> tips;

  @OneToMany(mappedBy = "city")
  private Collection<Scale> scales;

  public City(String description, Collection<Tip> tips, Collection<Scale> scales) {
    this.description=description;
    this.tips=tips;
    this.scales=scales;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
}
