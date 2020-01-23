package es.uca.iw.okto.views.login;

import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.security.SecurityUtils;
import es.uca.iw.okto.views.admin.users.UsersView;
import es.uca.iw.okto.views.manager.dashboard.DashboardView;

/**
 * LoginView
 */
@Route(value = "login")
@PageTitle("Login")
public class LoginView extends LoginOverlay implements AfterNavigationObserver, BeforeEnterObserver {
  private static final long serialVersionUID = 7623973319220884828L;

  public LoginView() {
    LoginI18n i18n = LoginI18n.createDefault();
    i18n.setHeader(new LoginI18n.Header());
    i18n.getHeader().setTitle("OKTO");
    i18n.setAdditionalInformation(null);
    i18n.setForm(new LoginI18n.Form());
    i18n.getForm().setSubmit("Sign in");
    i18n.getForm().setTitle("Sign in");
    i18n.getForm().setUsername("Email");
    i18n.getForm().setPassword("Password");
    setI18n(i18n);
    setForgotPasswordButtonVisible(false);
    setAction("login");
  }

  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    if (SecurityUtils.hasRole(User.Role.ADMIN)) {
      event.forwardTo(UsersView.class);
    } else if (SecurityUtils.hasRole(User.Role.MANAGER)) {
      event.forwardTo(DashboardView.class);
    } else{
      setOpened(true);
    }
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    setError(event.getLocation().getQueryParameters().getParameters().containsKey("error"));
  }
}