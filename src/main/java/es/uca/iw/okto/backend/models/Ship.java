package es.uca.iw.okto.backend.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ship {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  private  String name;
  
  @OneToMany(mappedBy = "ship")
  private Set<Trip> trips = new HashSet<>();


  public Ship(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Trip> getTrips() {
    return trips;
  }

  public void setTrips(Set<Trip> trips) {
    this.trips = trips;
  }
}
