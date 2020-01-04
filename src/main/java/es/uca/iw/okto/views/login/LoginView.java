package es.uca.iw.okto.views.login;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import es.uca.iw.okto.MainView;

@Route(value = LoginView.ROUTE, layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Login")
@CssImport("styles/views/login/login-view.css")
public class LoginView extends Div {

  /**
   *
   */
  private static final long serialVersionUID = -1446591496559780454L;
  static final String ROUTE = "route";

  private PasswordField passwordField = new PasswordField();
  private EmailField emailField = new EmailField("");

  private Button login = new Button("Login");

  public LoginView() {
    setId("login-view");
    VerticalLayout wrapper = createWrapper();
    wrapper.setAlignItems(Alignment.CENTER);
    createTitle(wrapper);
    createFormLayout(wrapper);
    createButtonLayout(wrapper);

    add(wrapper);
  }

  private void createTitle(VerticalLayout wrapper) {
    H1 h1 = new H1("Login");
    wrapper.add(h1);
  }

  private VerticalLayout createWrapper() {
    VerticalLayout wrapper = new VerticalLayout();
    wrapper.setId("wrapper");
    wrapper.setSpacing(false);
    return wrapper;
  }

  private void createFormLayout(VerticalLayout wrapper) {
    FormLayout formLayout = new FormLayout();
    addFormItem(wrapper, formLayout, emailField, "Username");
    FormLayout formLayout2 = new FormLayout();
    addFormItem(wrapper, formLayout2, passwordField, "Pasword");
  }

  private void createButtonLayout(VerticalLayout wrapper) {
    HorizontalLayout buttonLayout = new HorizontalLayout();
    buttonLayout.addClassName("button-layout");
    buttonLayout.setWidthFull();
    buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
    login.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    buttonLayout.add(login);
    wrapper.add(buttonLayout);
  }

  private FormLayout.FormItem addFormItem(VerticalLayout wrapper, FormLayout formLayout,
      Component field, String fieldName) {
    FormLayout.FormItem formItem = formLayout.addFormItem(field, fieldName);
    wrapper.add(formLayout);
    field.getElement().getClassList().add("full-width");
    return formItem;
  }

}
