package es.uca.iw.okto.backend.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import es.uca.iw.okto.backend.models.Tip;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.TipRepository;

@Service
public class TipService implements FilterableCrudService<Tip> {

  private final TipRepository tipRepository;

  @Autowired
  public TipService(TipRepository tipRepository) {
    this.tipRepository = tipRepository;
  }

  @Override
  public long countAnyMatching(Optional<String> filter) {
    return count();
  }

  @Override
  public TipRepository getRepository() {
    return tipRepository;
  }

  public Page<Tip> find(Pageable pageable) {
    return getRepository().findBy(pageable);
  }

  @Override
  public Tip createNew(User currentUser) {
    return new Tip();
  }

  @Override
  public Page<Tip> findAnyMatching(Optional<String> filter, Pageable pageable) {
    return find(pageable);
  }
}
