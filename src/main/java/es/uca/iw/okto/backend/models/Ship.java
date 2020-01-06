package es.uca.iw.okto.backend.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import es.uca.iw.okto.backend.utils.AbstractEntity;

/**
 * Ship
 */
@Entity
public class Ship extends AbstractEntity {
  private static final long serialVersionUID = 6951752917350417687L;

  private String name;

  @OneToMany(mappedBy = "ship")
  private Collection<Room> rooms;

  @OneToMany(mappedBy = "ship")
  private Collection<Trip> trips;

  public Ship() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Collection<Room> getRooms() {
    return rooms;
  }

  public void setRooms(final Collection<Room> rooms) {
    this.rooms = rooms;
  }

  @Override
  public String toString() {
    return "Ship [name=" + name + "]";
  }

  public Collection<Trip> getTrips() {
    return trips;
  }

  public void setTrips(Collection<Trip> trips) {
    this.trips = trips;
  }
}