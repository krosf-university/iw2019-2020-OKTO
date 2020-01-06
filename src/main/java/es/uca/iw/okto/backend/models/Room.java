package es.uca.iw.okto.backend.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import es.uca.iw.okto.backend.utils.AbstractEntity;

/**
 * Room
 */
@Entity
public class Room extends AbstractEntity {
  private static final long serialVersionUID = 8378060911859966240L;

  private Integer capacity;

  @ManyToOne
  @JoinColumn(name="ship_id", nullable=false)
  private Ship ship;

  @OneToMany(mappedBy = "room")
  private Collection<UserTrip> users;

  public Room() {
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public Ship getShip() {
    return ship;
  }

  public void setShip(Ship ship) {
    this.ship = ship;
  }

  @Override
  public String toString() {
    return "Room [capacity=" + capacity + "]";
  }

  public Collection<UserTrip> getUsers() {
    return users;
  }

  public void setUsers(Collection<UserTrip> users) {
    this.users = users;
  }
}