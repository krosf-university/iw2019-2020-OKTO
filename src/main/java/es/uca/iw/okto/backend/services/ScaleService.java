package es.uca.iw.okto.backend.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.Scale;
import es.uca.iw.okto.backend.repositories.ScaleRepository;

@Service
public class ScaleService {
  private final ScaleRepository scaleRepository;

  public ScaleService(ScaleRepository scaleRepository) {
    this.scaleRepository = scaleRepository;
  }

  public Collection<Scale> findAll() {
    return scaleRepository.findAll();
  }

  public int countAll() {
    return (int) scaleRepository.count();
  }

  public Scale save(Scale scale) {
    return scaleRepository.save(scale);
  }

  public void delete(Scale scale) {
    scaleRepository.delete(scale);
  }
}
