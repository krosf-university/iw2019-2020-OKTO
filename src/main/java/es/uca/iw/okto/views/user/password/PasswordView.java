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

import es.uca.iw.okto.backend.HasLogger;

@Route(value = "password")
@PageTitle("Password")
public class PasswordView extends FormLayout implements HasUrlParameter<String>, HasLogger {
  private static final long serialVersionUID = 591404710284427431L;

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
    getLogger().warn(parametersMap.toString());
  }
}