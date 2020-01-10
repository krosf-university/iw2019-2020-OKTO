package es.uca.iw.okto.backend.models;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import es.uca.iw.okto.backend.utils.AbstractEntity;

/**
 * Trip
 */
@Entity
public class Trip extends AbstractEntity {
  private static final long serialVersionUID = 2447199126332907173L;

  @Temporal(TemporalType.DATE)
  private Date start;

  @Temporal(TemporalType.DATE)
  private Date end;

  @ManyToOne
  @JoinColumn(name = "ship_id")
  private Ship ship;

  @OneToMany(mappedBy = "trip")
  private Collection<UserTrip> users;

  @OneToMany(mappedBy = "trip")
  private Collection<Scale> scales;

  public Trip() {
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
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