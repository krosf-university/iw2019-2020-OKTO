package es.uca.iw.okto.backend.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.OtherService;
import es.uca.iw.okto.backend.repositories.OtherServiceRepository;

@Service
public class OtherServiceService {
  private final OtherServiceRepository otherServiceRepository;

  public OtherServiceService(OtherServiceRepository otherServiceRepository) {
    this.otherServiceRepository = otherServiceRepository;
  }

  public Collection<OtherService> findAll() {
    return otherServiceRepository.findAll();
  }

  public int countAll() {
    return (int) otherServiceRepository.count();
  }

  public OtherService save(OtherService otherService) {
    return otherServiceRepository.save(otherService);
  }

  public void delete(OtherService otherService) {
    otherServiceRepository.delete(otherService);
  }
}
