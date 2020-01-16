package es.uca.iw.okto.backend.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.uca.iw.okto.backend.utils.AbstractEntity;

public interface FilterableCrudService<T extends AbstractEntity> extends CrudService<T> {

  Page<T> findAnyMatching(Optional<String> filter, Pageable pageable);

  long countAnyMatching(Optional<String> filter);
}
