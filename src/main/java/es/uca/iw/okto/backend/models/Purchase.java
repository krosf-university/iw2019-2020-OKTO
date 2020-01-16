package es.uca.iw.okto.backend.models;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import es.uca.iw.okto.backend.utils.AbstractEntity;

@Entity
public class Purchase extends AbstractEntity {
  private static final long serialVersionUID = 49272672233553808L;

  private Date price;

  @OneToMany(mappedBy = "purchase")
  private Collection<ShopLine> shopLines;

  @ManyToOne
  @JoinColumn(name = "usertrip_id")
  private UserTrip userTrip;

  public Purchase() {
  }

  public Date getPrice() {
    return price;
  }

  public void setPrice(Date price) {
    this.price = price;
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
}
