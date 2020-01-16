package es.uca.iw.okto.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.Trip;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.TripRepository;

@Service
public class TripService implements FilterableCrudService<Trip> {

  private final TripRepository tripRepository;

  @Autowired
  public TripService(TripRepository tripRepository) {
    this.tripRepository = tripRepository;
  }

  @Override
  public long countAnyMatching(Optional<String> filter) {
    return count();
  }

  @Override
  public TripRepository getRepository() {
    return tripRepository;
  }

  public Page<Trip> find(Pageable pageable) {
    return getRepository().findBy(pageable);
  }

  @Override
  public Trip createNew(User currentUser) {
    return new Trip();
  }

  @Override
  public Page<Trip> findAnyMatching(Optional<String> filter, Pageable pageable) {
    return find(pageable);
  }
}
