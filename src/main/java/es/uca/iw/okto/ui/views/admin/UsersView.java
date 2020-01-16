package es.uca.iw.okto.ui.views.admin;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import es.uca.iw.okto.app.security.CurrentUser;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.models.User.Role;
import es.uca.iw.okto.backend.services.UserService;
import es.uca.iw.okto.ui.components.crud.AbstractCrudView;
import es.uca.iw.okto.ui.views.MainView;

@Route(value = UsersView.ROUTE, layout = MainView.class)
@PageTitle(value = UsersView.PAGE_TITLE)
@Secured(User.Role.ADMIN)
public class UsersView extends AbstractCrudView<User> {
  private static final long serialVersionUID = 8896817309959219116L;

  public static final String ROUTE = "admin/users";
  public static final String PAGE_TITLE = "Manage Users";

  @Autowired
  public UsersView(UserService service, CurrentUser currentUser) {
    super(User.class, service, new Grid<>(), createForm(), currentUser);
    setHeightFull();
  }

  @Override
  public void setupGrid(Grid<User> grid) {
    grid.addColumn(User::getEmail).setWidth("10%").setHeader("Email").setFlexGrow(5);
    grid.addColumn(User::getDni).setWidth("10%").setHeader("DNI").setFlexGrow(5);
    grid.addColumn(u -> u.getFirstName() + " " + u.getLastName()).setHeader("Name").setWidth("20%").setFlexGrow(5);
    grid.addColumn(User::getPhone).setWidth("10%").setHeader("Phone").setFlexGrow(5);
    grid.addColumn(User::getRole).setHeader("Role").setWidth("10%");
    
    setHeightFull();
  }

  @Override
  protected String getBasePage() {
    return ROUTE;
  }

  private static BinderCrudEditor<User> createForm() {
    EmailField email = new EmailField("Email");
    TextField first = new TextField("First name");
    TextField last = new TextField("Last name");
    TextField dni = new TextField("DNI");
    TextField phone = new TextField("Phone");
    ComboBox<String> role = new ComboBox<>();
    // role.getElement().setAttribute("colspan", "2");
    role.setLabel("Role");

    FormLayout form = new FormLayout(email,dni, first, last,phone, role);

    BeanValidationBinder<User> binder = new BeanValidationBinder<>(User.class);

    ListDataProvider<String> roleProvider = DataProvider.ofItems(Role.getAllRoles());
    role.setItemLabelGenerator(s -> s != null ? s : "");
    role.setDataProvider(roleProvider);

    binder.bind(first, "firstName");
    binder.bind(last, "lastName");
    binder.bind(email, "email");
    binder.bind(dni, "dni");
    binder.bind(phone, "phone");
    binder.bind(role, "role");

    return new BinderCrudEditor<User>(binder, form);
  }
}
