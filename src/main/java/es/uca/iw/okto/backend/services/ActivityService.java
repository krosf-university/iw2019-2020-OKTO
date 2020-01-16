package es.uca.iw.okto.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.Activity;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.ActivityRepository;

@Service
public class ActivityService implements FilterableCrudService<Activity> {

  private final ActivityRepository activityRepository;

  @Autowired
  public ActivityService(ActivityRepository activityRepository) {
    this.activityRepository = activityRepository;
  }

  @Override
  public long countAnyMatching(Optional<String> filter) {
    return count();
  }

  @Override
  public ActivityRepository getRepository() {
    return activityRepository;
  }

  public Page<Activity> find(Pageable pageable) {
    return getRepository().findBy(pageable);
  }

  @Override
  public Activity createNew(User currentUser) {
    return new Activity();
  }

  @Override
  public Page<Activity> findAnyMatching(Optional<String> filter, Pageable pageable) {
    return find(pageable);
  }
}
