package es.uca.iw.okto.backend.models;

import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import es.uca.iw.okto.backend.utils.AbstractEntity;

/**
 * Trip
 */
@Entity
public class Trip extends AbstractEntity {
  private static final long serialVersionUID = 2447199126332907173L;

  private LocalDate start;

  private LocalDate end;

  private String name;

  @ManyToOne
  @JoinColumn(name = "ship_id")
  private Ship ship;

  @OneToMany(mappedBy = "trip")
  private Collection<UserTrip> users;

  @OneToMany(mappedBy = "trip")
  private Collection<Scale> scales;

  public Trip() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getStart() {
    return start;
  }

  public void setStart(LocalDate start) {
    this.start = start;
  }

  public LocalDate getEnd() {
    return end;
  }

  public void setEnd(LocalDate end) {
    this.end = end;
  }

  public Ship getShip() {
    return ship;
  }

  public void setShip(Ship ship) {
    this.ship = ship;
  }

  public Collection<UserTrip> getUsers() {
    return users;
  }

  public void setUsers(Collection<UserTrip> users) {
    this.users = users;
  }

  public Collection<Scale> getScales() {
    return scales;
  }

  public void setScales(Collection<Scale> scales) {
    this.scales = scales;
  }

  @Override
  public String toString() {
    return "Trip [end=" + end + ", ship=" + ship.getId() + ", start=" + start + "]";
  }
}