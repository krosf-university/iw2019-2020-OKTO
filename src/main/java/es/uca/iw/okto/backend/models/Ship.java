package es.uca.iw.okto.backend.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Ship
 */
@Entity
public class Ship extends AbstractEntity {
  private static final long serialVersionUID = 6951752917350417687L;

  private String name;
  private int capacity;
  private long length;

  @OneToMany(mappedBy = "ship")
  private Collection<Room> rooms;

  @OneToMany(mappedBy = "ship")
  private Collection<Trip> trips;

  @OneToMany(mappedBy = "ship")
  private Collection<Service> services;

  public Ship() {
    // Empty due to JPA use of getters and setters
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public long getLength() {
    return length;
  }

  public void setLength(long length) {
    this.length = length;
  }

  public Collection<Room> getRooms() {
    return rooms;
  }

  public void setRooms(Collection<Room> rooms) {
    this.rooms = rooms;
  }

  public Collection<Trip> getTrips() {
    return trips;
  }

  public void setTrips(Collection<Trip> trips) {
    this.trips = trips;
  }

  public Collection<Service> getServices() {
    return services;
  }

  public void setServices(Collection<Service> services) {
    this.services = services;
  }
}
