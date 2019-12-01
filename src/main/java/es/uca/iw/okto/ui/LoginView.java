package es.uca.iw.okto.ui;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import es.uca.iw.okto.backend.utils.security.CustomRequestCache;
import es.uca.iw.okto.backend.utils.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * A Designer generated component for the login-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("login-view")
@JsModule("./login-view.js")
@Route(value = LoginView.ROUTE)
public class LoginView extends PolymerTemplate<LoginView.LoginViewModel> {
  public static final String ROUTE = "login";

  @Id("vaadinLoginForm")
  private LoginForm vaadinLoginForm;

  private AuthenticationManager authenticationManager;
  private CustomRequestCache customRequestCache;

  /**
   * Creates a new LoginView.
   */
  @Autowired
  public LoginView(AuthenticationManager authenticationManager, CustomRequestCache customRequestCache) {
    this.authenticationManager = authenticationManager;
    this.customRequestCache = customRequestCache;
    vaadinLoginForm.addLoginListener(this::authenticate);
  }

  private void authenticate(LoginForm.LoginEvent e) {
    System.out.println(e.getUsername());
    System.out.println(e.getPassword());
    if (SecurityUtils.isUserLoggedIn()) {
      UI.getCurrent().navigate(MainView.class);
    } else {
      try {
        final Authentication authentication = authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(e.getUsername(), e.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UI.getCurrent().navigate(customRequestCache.resolveRedirectUrl());
      } catch (AuthenticationException ex) {
        ex.printStackTrace();
        vaadinLoginForm.setError(true);
      }
    }
  }

  /**
   * This model binds properties between LoginView and login-view
   */
  public interface LoginViewModel extends TemplateModel {
    // Add setters and getters for template properties here.
  }

}
