package es.uca.iw.okto.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.uca.iw.okto.backend.models.Service;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService implements FilterableCrudService<Service> {

  private final ServiceRepository serviceRepository;

  @Autowired
  public ServiceService(ServiceRepository serviceRepository) {
    this.serviceRepository = serviceRepository;
  }

  @Override
  public long countAnyMatching(Optional<String> filter) {
    return count();
  }

  @Override
  public ServiceRepository getRepository() {
    return serviceRepository;
  }

  public Page<Service> find(Pageable pageable) {
    return getRepository().findBy(pageable);
  }

  @Override
  public Service createNew(User currentUser) {
    return new Service();
  }

  @Override
  public Page<Service> findAnyMatching(Optional<String> filter, Pageable pageable) {
    return find(pageable);
  }
}
