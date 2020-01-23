package es.uca.iw.okto.backend.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.Ship;
import es.uca.iw.okto.backend.repositories.ShipRepository;

@Service
public class ShipService {
  private final ShipRepository shipRepository;

  public ShipService(ShipRepository shipRepository) {
    this.shipRepository = shipRepository;
  }

  public Collection<Ship> findAll() {
    return shipRepository.findAll();
  }

  public int countAll() {
    return (int) shipRepository.count();
  }

  public Ship save(Ship ship) {
    return shipRepository.save(ship);
  }

  public void delete(Ship ship) {
    shipRepository.delete(ship);
  }
}
