package es.uca.iw.okto.backend.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.Tour;
import es.uca.iw.okto.backend.repositories.TourRepository;

@Service
public class TourService {
  private final TourRepository tourRepository;

  public TourService(TourRepository tourRepository) {
    this.tourRepository = tourRepository;
  }

  public Collection<Tour> findAll() {
    return tourRepository.findAll();
  }

  public int countAll() {
    return (int) tourRepository.count();
  }

  public Tour save(Tour tour) {
    return tourRepository.save(tour);
  }

  public void delete(Tour tour) {
    tourRepository.delete(tour);
  }
}
