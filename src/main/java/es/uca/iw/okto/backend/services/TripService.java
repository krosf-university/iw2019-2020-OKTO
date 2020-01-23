package es.uca.iw.okto.backend.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.Trip;
import es.uca.iw.okto.backend.repositories.TripRepository;

@Service
public class TripService {
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
}
