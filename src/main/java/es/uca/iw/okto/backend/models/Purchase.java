package es.uca.iw.okto.backend.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Purchase extends AbstractEntity {
  private static final long serialVersionUID = 49272672233553808L;

  private UserTrip userTrip;

  @OneToMany(mappedBy = "purchase", fetch = FetchType.EAGER)
  private Collection<ShopLine> shopLines;


  public Purchase() {
    // Empty due to JPA use of getters and setters
  }

  public Double total() {
    return shopLines.stream().map(shopLine -> shopLine.getAmount() * shopLine.getPrice()).mapToDouble(Double::new).sum();
  }

  public Collection<ShopLine> getShopLines() {
    return shopLines;
  }

  public void setShopLines(Collection<ShopLine> shopLines) {
    this.shopLines = shopLines;
  }

  public UserTrip getUserTrip() {
    return userTrip;
  }

  public void setUserTrip(UserTrip userTrip) {
    this.userTrip = userTrip;
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
