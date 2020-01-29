package es.uca.iw.okto.backend.services;

import java.util.Collection;

import es.uca.iw.okto.backend.models.Service;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService {
  private final ServiceRepository serviceRepository;

  public ServiceService(ServiceRepository serviceRepository) {
    this.serviceRepository = serviceRepository;
  }

  public Collection<Service> findAll() {
    return serviceRepository.findAll();
  }

  public int countAll() {
    return (int) serviceRepository.count();
  }

  public Service save(Service service) {
    return serviceRepository.save(service);
  }

  public void delete(Service service) {
    serviceRepository.delete(service);
  }

  public Collection<Service> findByUser(User user) {
    return serviceRepository.findByUserId(user.getId());
  }
}
