package es.uca.iw.okto.backend.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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

  @OneToOne
  @JoinColumn(name = "purchase_id", referencedColumnName = "id", nullable = true)
  private Purchase purchase;

  public UserTrip() {
    // Empty due to JPA use of getters and setters
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

  public Purchase getPurchase() {
    return purchase;
  }

  public void setPurchase(Purchase purchase) {
    this.purchase = purchase;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    if (purchase != null)
      return "Trip: " + trip.getName() + " - " + purchase.total() + "€";
    else
      return "Trip: " + trip.getName() + " - No purchases in this trip";
  }
}
