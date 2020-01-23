package es.uca.iw.okto.backend.security;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.spring.annotation.SpringComponent;

import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.views.admin.users.UsersView;
import es.uca.iw.okto.views.login.LoginView;
import es.uca.iw.okto.views.manager.dashboard.DashboardView;

@SpringComponent
public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {
  private static final long serialVersionUID = -3940474407617646716L;

  @Override
  public void serviceInit(ServiceInitEvent event) {
    event.getSource().addUIInitListener(uiEvent -> {
      final UI ui = uiEvent.getUI();
      // ui.add(new OfflineBanner());
      ui.addBeforeEnterListener(this::beforeEnter);
    });
  }

  /**
   * Reroutes the user if she is not authorized to access the view.
   *
   * @param event before navigation event with event details
   */
  private void beforeEnter(BeforeEnterEvent event) {
    final boolean accessGranted = SecurityUtils.isAccessGranted(event.getNavigationTarget());
    if (!accessGranted) {
      if (SecurityUtils.isUserLoggedIn()) {
        if (SecurityUtils.hasRole(User.Role.ADMIN)) {
          event.forwardTo(UsersView.class);
        } else if (SecurityUtils.hasRole(User.Role.MANAGER)) {
          event.forwardTo(DashboardView.class);
        } else {
          event.rerouteToError(AccessDeniedException.class);
        }
      } else {
        event.rerouteTo(LoginView.class);
      }
    }
  }
}
