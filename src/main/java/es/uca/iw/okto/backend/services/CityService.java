package es.uca.iw.okto.backend.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.City;
import es.uca.iw.okto.backend.repositories.CityRepository;

@Service
public class CityService {
  private final CityRepository cityRepository;

  public CityService(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  public Collection<City> findAll() {
    return cityRepository.findAll();
  }

  public int countAll() {
    return (int) cityRepository.count();
  }

  public City save(City city) {
    return cityRepository.save(city);
  }

  public void delete(City city) {
    cityRepository.delete(city);
  }
}
