package es.uca.iw.okto.views.login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import es.uca.iw.okto.MainView;
import es.uca.iw.okto.backend.utils.security.CustomRequestCache;
import es.uca.iw.okto.backend.utils.security.SecurityUtils;
import es.uca.iw.okto.views.home.HomeView;

@Route(value = LoginView.ROUTE, layout = MainView.class)
@PageTitle("Login")
public class LoginView extends HorizontalLayout {
  private static final long serialVersionUID = -1446591496559780454L;
  public static final String ROUTE = "login";

  private AuthenticationManager authenticationManager;
  private CustomRequestCache customRequestCache;

  private LoginForm loginForm = new LoginForm();


  @Autowired
  public LoginView(AuthenticationManager authenticationManager,
      CustomRequestCache customRequestCache) {
    this.authenticationManager = authenticationManager;
    this.customRequestCache = customRequestCache;
    setJustifyContentMode(JustifyContentMode.CENTER);
    setAlignItems(Alignment.CENTER);
    setHeightFull();
    loginForm.addLoginListener(this::authenticate);
    add(loginForm);
  }

  private void authenticate(LoginForm.LoginEvent e) {
    System.out.println(e.getUsername());
    System.out.println(e.getPassword());
    if (SecurityUtils.isUserLoggedIn()) {
      UI.getCurrent().navigate(HomeView.class);
    } else {
      try {
        final Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(e.getUsername(), e.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UI.getCurrent().navigate(customRequestCache.resolveRedirectUrl());
      } catch (AuthenticationException ex) {
        loginForm.setError(true);
      }
    }
  }
}
