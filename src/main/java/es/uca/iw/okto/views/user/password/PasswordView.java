package es.uca.iw.okto.views.user.password;

import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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
import es.uca.iw.okto.backend.security.AccessDeniedException;
import es.uca.iw.okto.backend.services.PasswordTokenService;
import es.uca.iw.okto.views.login.LoginView;

@Route(value = "password")
@PageTitle("Password")
@CssImport("./styles/views/users/user-password.css")
public class PasswordView extends Div implements HasUrlParameter<String>, HasLogger {
  private static final long serialVersionUID = 591404710284427431L;

  private Long id;
  private String token;
  private Notification notification = new Notification();
  private Label message = new Label();

  PasswordField password = new PasswordField();
  PasswordField confirmPassword = new PasswordField();
  private Button save = new Button("Save");

  @Autowired
  private PasswordTokenService passwordTokenService;

  public PasswordView() {
    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
    notification.add(message);
    notification.setDuration(3000);
    setId("password-view");
    VerticalLayout wrapper = createWrapper();
    wrapper.add(new H1("Create Password"));

    createFormLayout(wrapper);
    createButtonLayout(wrapper);

    save.addClickListener(e -> {
      getLogger().warn("Password: {}, Id: {}, Token: {}", password.getValue(), id,token);
      validateTokenAndCreatePassword();
    });
    wrapper.setAlignItems(Alignment.CENTER);
    wrapper.setJustifyContentMode(JustifyContentMode.CENTER);
    add(wrapper);
  }

  private VerticalLayout createWrapper() {
    VerticalLayout wrapper = new VerticalLayout();
    wrapper.setId("wrapper-password");
    wrapper.setSpacing(false);
    return wrapper;
  }

  private void createFormLayout(VerticalLayout wrapper) {
    FormLayout formLayout = new FormLayout();
    FormLayout.FormItem passwordFormItem = addFormItem(wrapper, formLayout, password, "Password");
    formLayout.setColspan(passwordFormItem, 3);
    FormLayout.FormItem confirmPasswordFormItem = addFormItem(wrapper, formLayout, confirmPassword, "Repeat Password");
    formLayout.setColspan(confirmPasswordFormItem, 3);
  }

  private void createButtonLayout(VerticalLayout wrapper) {
    HorizontalLayout buttonLayout = new HorizontalLayout();
    buttonLayout.addClassName("button-layout-password");
    buttonLayout.setWidthFull();
    buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
    save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    buttonLayout.add(save);
    wrapper.add(buttonLayout);
  }

  private FormLayout.FormItem addFormItem(VerticalLayout wrapper, FormLayout formLayout, Component field,
      String fieldName) {
    FormLayout.FormItem formItem = formLayout.addFormItem(field, fieldName);
    wrapper.add(formLayout);
    field.getElement().getClassList().add("full-width");
    return formItem;
  }

  @Override
  public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
    Location location = event.getLocation();
    QueryParameters queryParameters = location.getQueryParameters();
    Map<String, List<String>> parametersMap = queryParameters.getParameters();

    if (parametersMap.isEmpty()) {
      event.rerouteToError(AccessDeniedException.class);
    }

    id = Long.parseLong(parametersMap.get("id").get(0));
    token = parametersMap.get("token").get(0);
  }

  private void validateTokenAndCreatePassword() {
    if (password.getValue().equals(confirmPassword.getValue()) && !password.isEmpty()) {
      final String valid = passwordTokenService.validateTokenAndCreatePassword(id, token, password.getValue());
      if (valid.equals("invalid")) {
        message.setText("Invalid token was provided");
        notification.open();
      } else if (valid.equals("expired")) {
        message.setText("Token has already expired");
        notification.open();
      } else {
        getUI().ifPresent(ui -> ui.navigate(LoginView.class));
      }
    } else {
      message.setText("Passwords do not match");
      notification.open();
    }
  }
}