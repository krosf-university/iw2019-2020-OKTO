package es.uca.iw.okto.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.Tour;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.TourRepository;

@Service
public class TourService implements FilterableCrudService<Tour> {

  private final TourRepository tourRepository;

  @Autowired
  public TourService(TourRepository tourRepository) {
    this.tourRepository = tourRepository;
  }

  @Override
  public long countAnyMatching(Optional<String> filter) {
    return count();
  }

  @Override
  public TourRepository getRepository() {
    return tourRepository;
  }

  public Page<Tour> find(Pageable pageable) {
    return getRepository().findBy(pageable);
  }

  @Override
  public Tour createNew(User currentUser) {
    return new Tour();
  }

  @Override
  public Page<Tour> findAnyMatching(Optional<String> filter, Pageable pageable) {
    return find(pageable);
  }
}
