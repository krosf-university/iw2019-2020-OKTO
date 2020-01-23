package es.uca.iw.okto.backend.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.Tip;
import es.uca.iw.okto.backend.repositories.TipRepository;

@Service
public class TipService {
  private final TipRepository tipRepository;

  public TipService(TipRepository tipRepository) {
    this.tipRepository = tipRepository;
  }

  public Collection<Tip> findAll() {
    return tipRepository.findAll();
  }

  public int countAll() {
    return (int) tipRepository.count();
  }

  public Tip save(Tip tip) {
    return tipRepository.save(tip);
  }

  public void delete(Tip tip) {
    tipRepository.delete(tip);
  }
}
