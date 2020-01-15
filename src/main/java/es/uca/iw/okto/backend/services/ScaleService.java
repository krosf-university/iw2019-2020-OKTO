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
    // if (filter.isPresent()) {
    //   return getRepository().findByStartAfterOrEndAfterOrNameOrIgnoreCase(
    //       filter.get(), filter.get(), filter2.get(), pageable);
    // } else {
    //   return find(pageable);
    // }
    return find(pageable); 
  }

  @Override
  public long countAnyMatching(Optional<String> filter) {
    // if (filter.isPresent()) {
    //   return tripRepository.countfindByStartAfterOrEndAfterOrShipNameContainigIgnoreCase(
    //       filter.get(), filter.get(),);
    // } else {
    //   return count();
    // }
    return count();
  }

  @Override
  public ScaleRepository getRepository() {
    return scaleRepository;
  }

  public Page<Scale> find(Pageable pageable) {
    return getRepository().findBy(pageable);
  }

  // @Override
  // public Trip save(User currentUser, Trip entity) {
  //   throwIfTripDisabled(currentUser);
  //   return getRepository().saveAndFlush(entity);
  // }

  // @Override
  // @Transactional
  // public void delete(User currentUser, Trip userToDelete) {
  //   throwIfTripDisabled(currentUser);
  //   FilterableCrudService.super.delete(currentUser, userToDelete);
  // }

  // private void throwIfTripDisabled(User entity) {
  //   if (entity != null && entity.isEnabled()) {
  //     throw new UserFriendlyDataException(MODIFY_DISABLED_USER_NOT_PERMITTED);
  //   }
  // }

  @Override
  public Scale createNew(User currentUser) {
    return new Scale();
  }

  @Override
  public Page<Scale> findAnyMatching(Optional<String> filter, Pageable pageable) {
    return find(pageable);
  }
}
