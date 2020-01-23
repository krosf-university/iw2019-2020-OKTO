package es.uca.iw.okto.backend.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.Activity;
import es.uca.iw.okto.backend.repositories.ActivityRepository;

@Service
public class ActivityService {
  private final ActivityRepository activityRepository;

  public ActivityService(ActivityRepository activityRepository) {
    this.activityRepository = activityRepository;
  }

  public Collection<Activity> findAll() {
    return activityRepository.findAll();
  }

  public int countAll() {
    return (int) activityRepository.count();
  }

  public Activity save(Activity activity) {
    return activityRepository.save(activity);
  }

  public void delete(Activity activity) {
    activityRepository.delete(activity);
  }
}
