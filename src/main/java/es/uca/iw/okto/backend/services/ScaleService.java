package es.uca.iw.okto.backend.services;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import es.uca.iw.okto.backend.models.Scale;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.ScaleRepository;

@Service
public class ScaleService implements FilterableCrudService<Scale> {

  private final ScaleRepository scaleRepository;

  @Autowired
  public ScaleService(ScaleRepository scaleRepository) {
    this.scaleRepository = scaleRepository;
  }

  public Page<Scale> findAnyMatching(Optional<LocalDate> filter,Optional<String> filter2, Pageable pageable) {
    return find(pageable); 
  }

  @Override
  public long countAnyMatching(Optional<String> filter) {
    return count();
  }

  @Override
  public ScaleRepository getRepository() {
    return scaleRepository;
  }

  public Page<Scale> find(Pageable pageable) {
    return getRepository().findBy(pageable);
  }

  @Override
  public Scale createNew(User currentUser) {
    return new Scale();
  }

  @Override
  public Page<Scale> findAnyMatching(Optional<String> filter, Pageable pageable) {
    return find(pageable);
  }
}
