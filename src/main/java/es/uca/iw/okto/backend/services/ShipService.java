package es.uca.iw.okto.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.uca.iw.okto.backend.models.Ship;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.ShipRepository;

@org.springframework.stereotype.Service
public class ShipService implements FilterableCrudService<Ship> {

  private final ShipRepository shipRepository;

  @Autowired
  public ShipService(ShipRepository shipRepository) {
    this.shipRepository = shipRepository;
  }

  @Override
  public long countAnyMatching(Optional<String> filter) {
    return count();
  }

  @Override
  public ShipRepository getRepository() {
    return shipRepository;
  }

  public Page<Ship> find(Pageable pageable) {
    return getRepository().findBy(pageable);
  }

  @Override
  public Ship createNew(User currentUser) {
    return new Ship();
  }

  @Override
  public Page<Ship> findAnyMatching(Optional<String> filter, Pageable pageable) {
    return find(pageable);
  }
}
