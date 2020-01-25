package es.uca.iw.okto.views.admin.users;

import java.util.Arrays;
import java.util.Collection;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.impl.field.provider.ComboBoxProvider;

import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.services.UserService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/users", layout = MainView.class)
@PageTitle("Users")
@CssImport("./styles/views/users/users-view.css")
public class UsersView extends VerticalLayout {
  private static final long serialVersionUID = -5006331655968812186L;
  private static final String FIRSTNAME = "firstName";
  private static final String LASTNAME = "lastName";
  private static final String DNI = "dni";
  private static final String EMAIL = "email";
  private static final String ENABLED = "enabled";
  private static final String PHONE = "phone";
  private static final String ROLE = "role";

  @Autowired
  public UsersView(UserService userService) {
    GridCrud<User> crud = new GridCrud<>(User.class);
    crud.getGrid().setColumns(FIRSTNAME, LASTNAME, DNI, EMAIL, PHONE, ENABLED, ROLE);
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties(FIRSTNAME, LASTNAME, DNI, EMAIL, PHONE, ENABLED, ROLE);
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, FIRSTNAME, LASTNAME, DNI, EMAIL, PHONE, ENABLED,
        ROLE);
    crud.getCrudFormFactory().setFieldProvider(ROLE, new ComboBoxProvider<>(Arrays.asList(User.Role.getAllRoles())));
    setSizeFull();
    add(crud);
    crud.setCrudListener(this.userCrudLister(userService));
  }

  CrudListener<User> userCrudLister(UserService userService) {
    return new CrudListener<User>() {
      private static final long serialVersionUID = 5006331655968812186L;
      
      @Override
      public Collection<User> findAll() {
        return userService.findAll();
      }
      
      @Override
      public User add(User user) {
        return userService.save(user);
      }
      
      @Override
      public User update(User user) {
        return userService.save(user);
      }
      
      @Override
      public void delete(User user) {
        userService.delete(user);
      }
    };
  }
}
