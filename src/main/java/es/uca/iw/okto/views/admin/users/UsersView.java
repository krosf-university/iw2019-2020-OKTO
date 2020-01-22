package es.uca.iw.okto.views.admin.users;

import java.util.Arrays;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.impl.field.provider.ComboBoxProvider;

import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.services.UserService;
import es.uca.iw.okto.views.admin.AdminView;


@Route(value = "admin/users", layout = AdminView.class)
@RouteAlias(value = "admin", layout = AdminView.class)
@PageTitle("Users")
@CssImport("styles/views/users/users-view.css")
public class UsersView extends VerticalLayout {
  private static final long serialVersionUID = -5006331655968812186L;

  @Autowired
  public UsersView(UserService userService) {
    GridCrud<User> crud = new GridCrud<>(User.class);
    crud.getGrid().setColumns("firstName", "lastName", "dni", "email", "phone", "enabled", "role");
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("firstName", "lastName", "dni", "email", "phone", "enabled", "role");
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "firstName", "lastName", "dni", "email", "phone",
        "enabled", "role");
    crud.getCrudFormFactory().setFieldProvider("role", new ComboBoxProvider<>(Arrays.asList(User.Role.getAllRoles())));
    setSizeFull();
    add(crud);
    crud.setOperations(() -> userService.findAll(), user -> userService.save(user), user -> userService.save(user),
        user -> userService.delete(user));
  }

}
