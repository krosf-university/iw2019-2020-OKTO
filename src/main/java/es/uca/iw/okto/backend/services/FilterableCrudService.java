package es.uca.iw.okto.backend.services;

import java.util.Optional;

import es.uca.iw.okto.backend.utils.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilterableCrudService<T extends AbstractEntity> extends CrudService<T> {

  Page<T> findAnyMatching(Optional<String> filter, Pageable pageable);

  long countAnyMatching(Optional<String> filter);

}
