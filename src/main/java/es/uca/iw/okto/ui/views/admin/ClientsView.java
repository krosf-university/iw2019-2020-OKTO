package es.uca.iw.okto.ui.views.admin;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import es.uca.iw.okto.app.security.CurrentUser;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.models.User.Role;
import es.uca.iw.okto.backend.services.UserService;
import es.uca.iw.okto.ui.components.crud.AbstractCrudView;
import es.uca.iw.okto.ui.views.MainView;

@Route(value = ClientsView.ROUTE, layout = MainView.class)
@RouteAlias(value = "",layout = MainView.class)
@PageTitle("Clients")
@Secured(User.Role.ADMIN)
public class ClientsView extends AbstractCrudView<User> {
  private static final long serialVersionUID = 8896817309959219116L;

  public static final String ROUTE = "admin/client";
  public static final String PAGE_TITLE = "Manage Clients";

  @Autowired
  public ClientsView(UserService service, CurrentUser currentUser) {
    super(User.class, service, new Grid<>(), createForm(), currentUser);
  }

  @Override
  public void setupGrid(Grid<User> grid) {
    grid.addColumn(User::getEmail).setWidth("50%").setHeader("Email").setFlexGrow(5);
    grid.addColumn(u -> u.getFirstName() + " " + u.getLastName()).setHeader("Name").setWidth("10%").setFlexGrow(5);
    grid.addColumn(User::getRole).setHeader("Role").setWidth("10%");
  }

  @Override
  protected String getBasePage() {
    return ROUTE;
  }

  private static BinderCrudEditor<User> createForm() {
    EmailField email = new EmailField("Email (login)");
    email.getElement().setAttribute("colspan", "2");
    TextField first = new TextField("First name");
    TextField last = new TextField("Last name");
    PasswordField password = new PasswordField("Password");
    password.getElement().setAttribute("colspan", "2");
    ComboBox<String> role = new ComboBox<>();
    role.getElement().setAttribute("colspan", "2");
    role.setLabel("Role");

    FormLayout form = new FormLayout(email, first, last, password, role);

    BeanValidationBinder<User> binder = new BeanValidationBinder<>(User.class);

    ListDataProvider<String> roleProvider = DataProvider.ofItems(Role.getAllRoles());
    role.setItemLabelGenerator(s -> s != null ? s : "");
    role.setDataProvider(roleProvider);

    binder.bind(first, "firstName");
    binder.bind(last, "lastName");
    binder.bind(email, "email");
    binder.bind(role, "role");

    return new BinderCrudEditor<User>(binder, form);
  }
}
