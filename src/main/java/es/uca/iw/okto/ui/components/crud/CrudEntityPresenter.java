package es.uca.iw.okto.ui.components.crud;

import java.util.function.Consumer;

import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;

import es.uca.iw.okto.app.security.CurrentUser;
import es.uca.iw.okto.backend.services.CrudService;
import es.uca.iw.okto.backend.services.UserFriendlyDataException;
import es.uca.iw.okto.backend.utils.AbstractEntity;
import es.uca.iw.okto.ui.components.HasNotifications;

public class CrudEntityPresenter<E extends AbstractEntity> {

  private final CrudService<E> crudService;

  private final CurrentUser currentUser;

  private final HasNotifications view;

  public CrudEntityPresenter(CrudService<E> crudService, CurrentUser currentUser, HasNotifications view) {
    this.crudService = crudService;
    this.currentUser = currentUser;
    this.view = view;
  }

  public void delete(E entity, Consumer<E> onSuccess, Consumer<E> onFail) {
    if (executeOperation(() -> crudService.delete(currentUser.getUser(), entity))) {
      onSuccess.accept(entity);
    } else {
      onFail.accept(entity);
    }
  }

  public void save(E entity, Consumer<E> onSuccess, Consumer<E> onFail) {
    if (executeOperation(() -> saveEntity(entity))) {
      onSuccess.accept(entity);
    } else {
      onFail.accept(entity);
    }
  }

  private boolean executeOperation(Runnable operation) {
    try {
      operation.run();
      return true;
    } catch (UserFriendlyDataException e) {
      // Commit failed because of application-level data constraints
      consumeError(e, e.getMessage(), true);
    } catch (DataIntegrityViolationException e) {
      // Commit failed because of validation errors
      consumeError(e, CrudErrorMessage.OPERATION_PREVENTED_BY_REFERENCES, true);
    } catch (OptimisticLockingFailureException e) {
      consumeError(e, CrudErrorMessage.CONCURRENT_UPDATE, true);
    } catch (EntityNotFoundException e) {
      consumeError(e, CrudErrorMessage.ENTITY_NOT_FOUND, false);
    } catch (ConstraintViolationException e) {
      consumeError(e, CrudErrorMessage.REQUIRED_FIELDS_MISSING, false);
    }
    return false;
  }

  private void consumeError(Exception e, String message, boolean isPersistent) {
    view.showNotification(message, isPersistent);
  }

  private void saveEntity(E entity) {
    crudService.save(currentUser.getUser(), entity);
  }

  public boolean loadEntity(Long id, Consumer<E> onSuccess) {
    return executeOperation(() -> onSuccess.accept(crudService.load(id)));
  }
}