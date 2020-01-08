package es.uca.iw.okto.backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import es.uca.iw.okto.backend.utils.AbstractEntity;

/**
 * UserTrip
 */
@Entity
public class UserTrip extends AbstractEntity {
  private static final long serialVersionUID = -1873290553852736669L;

  @Id
  @ManyToOne
  @JoinColumn
  private User user;

  @Id
  @ManyToOne
  @JoinColumn
  private Trip trip;

  @Id
  @ManyToOne
  @JoinColumn
  private Room room;

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
}