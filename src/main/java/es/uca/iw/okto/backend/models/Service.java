package es.uca.iw.okto.backend.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Service extends AbstractEntity {
  private static final long serialVersionUID = -8104609640892884129L;

  @ManyToOne
  @JoinColumn(name = "ship_id", nullable = false)
  private Ship ship;

  @NotBlank
  @Column(nullable = false)
  private String name;

  @NotBlank
  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private Double price;

  @OneToMany(mappedBy = "service")
  private Collection<ShopLine> shopLine;

  public Service() {
    // Empty due to JPA use of getters and setters
  }

  public Ship getShip() {
    return ship;
  }

  public void setShip(Ship ship) {
    this.ship = ship;
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

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Collection<ShopLine> getShopLine() {
    return shopLine;
  }

  public void setShopLine(Collection<ShopLine> shopLine) {
    this.shopLine = shopLine;
  }

}
