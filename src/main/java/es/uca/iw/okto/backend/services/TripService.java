package es.uca.iw.okto.backend.services;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.Trip;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.models.UserTrip;
import es.uca.iw.okto.backend.repositories.TripRepository;

@Service
public class TripService implements Serializable {
  private static final long serialVersionUID = -1653601070644039338L;

  private final TripRepository tripRepository;

  public TripService(TripRepository tripRepository) {
    this.tripRepository = tripRepository;
  }

  public Collection<Trip> findAll() {
    return tripRepository.findAll();
  }

  public int countAll() {
    return (int) tripRepository.count();
  }

  public Trip save(Trip trip) {
    return tripRepository.save(trip);
  }

  public void delete(Trip trip) {
    tripRepository.delete(trip);
  }

  public Collection<Trip> findByUser(User user) {
    return tripRepository.findByUserId(user.getId());
  }

  public Collection<UserTrip> findUserTrip(User user) {
    return tripRepository.findUserTrip(user.getId());
  }
}
