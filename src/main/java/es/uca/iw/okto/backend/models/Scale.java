package es.uca.iw.okto.backend.models;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Scale
 */
@Entity
public class Scale extends AbstractEntity {

  private static final long serialVersionUID = -5873780733709877895L;

  @ManyToOne
  @JoinColumn(name = "trip_id")
  private Trip trip;

  private LocalDate start;

  private LocalDate end;

  @OneToMany(mappedBy = "scale")
  private Collection<Tour> tours;

  @ManyToOne
  @JoinColumn(name = "city_id", nullable = false)
  private City city;

  public Scale() {
    // Empty due to JPA use of getters and setters
  }

  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
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

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
