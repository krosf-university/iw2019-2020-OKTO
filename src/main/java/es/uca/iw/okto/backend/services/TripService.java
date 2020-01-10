package es.uca.iw.okto.backend.services;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.UserRepository;

@Service
public class TripService implements FilterableCrudService<User> {

  public static final String MODIFY_DISABLED_USER_NOT_PERMITTED =
      "User is disable and cannot be modified or deleted";
  private static final String DELETING_SELF_NOT_PERMITTED = "You cannot delete your own account";
  private final UserRepository userRepository;

  @Autowired
  public TripService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Page<User> findAnyMatching(Optional<String> filter, Pageable pageable) {
    if (filter.isPresent()) {
      String repositoryFilter = "%" + filter.get() + "%";
      return getRepository()
          .findByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(
              repositoryFilter, repositoryFilter, repositoryFilter, repositoryFilter, pageable);
    } else {
      return find(pageable);
    }
  }

  @Override
  public long countAnyMatching(Optional<String> filter) {
    if (filter.isPresent()) {
      String repositoryFilter = "%" + filter.get() + "%";
      return userRepository
          .countByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(
              repositoryFilter, repositoryFilter, repositoryFilter, repositoryFilter);
    } else {
      return count();
    }
  }

  @Override
  public UserRepository getRepository() {
    return userRepository;
  }

  public Page<User> find(Pageable pageable) {
    return getRepository().findBy(pageable);
  }

  @Override
  public User save(User currentUser, User entity) {
    throwIfUserDisabled(entity);
    return getRepository().saveAndFlush(entity);
  }

  @Override
  @Transactional
  public void delete(User currentUser, User userToDelete) {
    throwIfDeletingSelf(currentUser, userToDelete);
    throwIfUserDisabled(userToDelete);
    FilterableCrudService.super.delete(currentUser, userToDelete);
  }

  private void throwIfDeletingSelf(User currentUser, User user) {
    if (currentUser.equals(user)) {
      throw new UserFriendlyDataException(DELETING_SELF_NOT_PERMITTED);
    }
  }

  private void throwIfUserDisabled(User entity) {
    if (entity != null && entity.isEnabled()) {
      throw new UserFriendlyDataException(MODIFY_DISABLED_USER_NOT_PERMITTED);
    }
  }

  @Override
  public User createNew(User currentUser) {
    return new User();
  }
}
