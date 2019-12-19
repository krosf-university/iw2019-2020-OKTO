package es.uca.iw.okto.backend.models;

import javax.persistence.*;

@Entity
public class Trip {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @ManyToOne
  private Ship ship;

  public Trip(Ship ship) {
    this.ship = ship;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Ship getShip() {
    return ship;
  }

  public void setShip(Ship ship) {
    this.ship = ship;
  }
}
