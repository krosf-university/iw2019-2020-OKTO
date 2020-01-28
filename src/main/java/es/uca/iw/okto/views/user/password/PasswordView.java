package es.uca.iw.okto.views.user.password;

import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Location;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;

import es.uca.iw.okto.backend.HasLogger;
import es.uca.iw.okto.backend.services.PasswordTokenService;

@Route(value = "password")
@PageTitle("Password")
public class PasswordView extends FormLayout implements HasUrlParameter<String>, HasLogger {
  private static final long serialVersionUID = 591404710284427431L;

  private Long id;
  private String token;

  @Autowired
  private PasswordTokenService passwordTokenService;

  public PasswordView() {
    H1 title = new H1("Create New Password");
    PasswordField password = new PasswordField();
    PasswordField confirmPassword = new PasswordField();
    add(title);
    add(password);
    add(confirmPassword);
  }

  @Override
  public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
    Location location = event.getLocation();
    QueryParameters queryParameters = location.getQueryParameters();
    Map<String, List<String>> parametersMap = queryParameters.getParameters();

    id = Long.parseLong(parametersMap.get("id").get(0));
    token = parametersMap.get("token").get(0);
  }

  private void validateToken() {
    final String valid = passwordTokenService.validateToken(id, token);
    if (valid.equals("invalid")) {
    } else if (valid.equals("expired")) {
    } else {
    }
  }
}