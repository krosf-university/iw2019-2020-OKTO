package es.uca.iw.okto.backend.services;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import es.uca.iw.okto.backend.models.Tour;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.TourRepository;

@Service
public class TourService implements FilterableCrudService<Tour> {

  private final TourRepository tourRepository;

  @Autowired
  public TourService(TourRepository tourRepository) {
    this.tourRepository = tourRepository;
  }

  public Page<Tour> findAnyMatching(Optional<LocalDate> filter,Optional<String> filter2, Pageable pageable) {
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
  public TourRepository getRepository() {
    return tourRepository;
  }

  public Page<Tour> find(Pageable pageable) {
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
  public Tour createNew(User currentUser) {
    return new Tour();
  }

  @Override
  public Page<Tour> findAnyMatching(Optional<String> filter, Pageable pageable) {
    return find(pageable);
  }
}
