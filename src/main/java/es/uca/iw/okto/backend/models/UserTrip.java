package es.uca.iw.okto.backend.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import es.uca.iw.okto.backend.utils.AbstractEntity;

/**
 * UserTrip
 */
@Entity
public class UserTrip extends AbstractEntity {
  private static final long serialVersionUID = -1873290553852736669L;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "trip_id", nullable = false)
  private Trip trip;

  @ManyToOne
  @JoinColumn(name = "room_id", nullable = false)
  private Room room;

  @OneToMany(mappedBy = "userTrip")
  private Collection<Purchase> purchases;

  public UserTrip() {
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public Collection<Purchase> getPurchases() {
    return purchases;
  }

  public void setPurchases(Collection<Purchase> purchases) {
    this.purchases = purchases;
  }
}