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
 * Scale
 */
@Entity
public class Scale extends AbstractEntity {

  private static final long serialVersionUID = -5873780733709877895L;

  @ManyToOne
  @JoinColumn(name="trip_id", nullable=false)
  private Trip trip;

  @Temporal(TemporalType.DATE)
  private Date start;

  @Temporal(TemporalType.DATE)
  private Date end;

  @OneToMany(mappedBy = "scale")
  private Collection<Tour> tours;

  @ManyToOne
  @JoinColumn(name="city_id", nullable=false)
  private City city;

  public Scale() {
  }

  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
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

  public Collection<Tour> getTours() {
    return tours;
  }

  public void setTours(Collection<Tour> tours) {
    this.tours = tours;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "Scale [city=" + city.getId() + ", end=" + end + ", start=" + start + ", trip=" + trip.getId() + "]";
  }
}