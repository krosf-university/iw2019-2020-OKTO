package es.uca.iw.okto.views.user.password;

import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
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
@CssImport("./styles/views/users/user-password.css")
public class PasswordView extends FormLayout implements HasUrlParameter<String>, HasLogger {
  private static final long serialVersionUID = 591404710284427431L;

  public PasswordView() {
    H1 title = new H1("Create New Password");
    H2 title2 = new H2("New password");
    H2 title3 = new H2("Confirmed password");
    PasswordField password = new PasswordField();
    PasswordField confirmPassword = new PasswordField();
    Div div = new Div(title , title2, confirmPassword);
    Button button = new Button("Confirm");
    Div div2 = new Div(div, title3, password);
    //button.addClickListener();
    Div div3 = new Div(div2, button);

    add(div3);
  }

  @Override
  public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
    Location location = event.getLocation();
    QueryParameters queryParameters = location.getQueryParameters();
    Map<String, List<String>> parametersMap = queryParameters.getParameters();
    getLogger().warn(parametersMap.toString());
  }
}