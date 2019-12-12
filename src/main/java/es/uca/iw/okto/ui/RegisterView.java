package es.uca.iw.okto.ui;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import es.uca.iw.okto.backend.models.User;

/**
 * A Designer generated component for the register-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("register-view")
@JsModule("./register-view.js")
@Route(value = RegisterView.ROUTE)
@PageTitle("Register")
public class RegisterView extends PolymerTemplate<RegisterView.RegisterViewModel> {
  static final String ROUTE = "register";
  // private Binder<User> binder = new Binder<>(User.class);

  @Id("submit")
  private Button submit;
  @Id("password")
  private PasswordField password;
  @Id("firstName")
  private TextField firstName;
  @Id("lastName")
  private TextField lastName;
  @Id("phone")
  private TextField phone;
  @Id("email")
  private EmailField email;

  /**
   * Creates a new RegisterView.
   */
  public RegisterView() {
    // You can initialise any data required for the connected UI components here.
    // binder.bindInstanceFields(this);
  }
  
  private void onSubmit() {
  }
  /**
   * This model binds properties between RegisterView and register-view
   */
  public interface RegisterViewModel extends TemplateModel {
    // Add setters and getters for template properties here.
  }
}
