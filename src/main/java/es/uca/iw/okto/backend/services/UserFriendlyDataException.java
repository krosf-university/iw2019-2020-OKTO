package es.uca.iw.okto.backend.services;

import org.springframework.dao.DataIntegrityViolationException;

/**
 * A data integrity violation exception containing a message intended to be
 * shown to the end user.
 */
public class UserFriendlyDataException extends DataIntegrityViolationException {
  private static final long serialVersionUID = -8180156559446998752L;

  public UserFriendlyDataException(String message) {
    super(message);
  }
}
