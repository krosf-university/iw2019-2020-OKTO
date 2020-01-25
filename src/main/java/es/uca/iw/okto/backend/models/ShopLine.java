package es.uca.iw.okto.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Override
public class ShopLine extends AbstractEntity {
  private static final long serialVersionUID = -4047702656737581607L;

  @Column(nullable = false)
  private Integer amount;

  @Column(nullable = false)
  private Double price;

  @ManyToOne
  @JoinColumn(name = "shopline_id", insertable = false, updatable = false, nullable = false)
  private Service service;

  @ManyToOne
  @JoinColumn(name = "shopline_id", nullable = false)
  private Purchase purchase;

  public ShopLine(Integer amount, Double price, Service service, Purchase purchase) {
    this.amount=amount;
    this.price=price;
    this.service=service;
    this.purchase=purchase;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }

  public Purchase getPurchase() {
    return purchase;
  }

  public void setPurchase(Purchase purchase) {
    this.purchase = purchase;
  }
}
