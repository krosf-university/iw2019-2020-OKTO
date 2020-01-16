package es.uca.iw.okto.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.City;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.CityRepository;

@Service
public class CityService implements FilterableCrudService<City> {

  private final CityRepository cityRepository;

  @Autowired
  public CityService(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  @Override
  public long countAnyMatching(Optional<String> filter) {
    return count();
  }

  @Override
  public CityRepository getRepository() {
    return cityRepository;
  }

  public Page<City> find(Pageable pageable) {
    return getRepository().findBy(pageable);
  }

  @Override
  public City createNew(User currentUser) {
    return new City();
  }

  @Override
  public Page<City> findAnyMatching(Optional<String> filter, Pageable pageable) {
    return find(pageable);
  }
}
