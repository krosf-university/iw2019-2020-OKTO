package es.uca.iw.okto.ui.views.admin;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import es.uca.iw.okto.app.security.CurrentUser;
import es.uca.iw.okto.backend.models.Service;
import es.uca.iw.okto.backend.models.Ship;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.services.ServiceService;
import es.uca.iw.okto.backend.services.ShipService;
import es.uca.iw.okto.ui.components.crud.AbstractCrudView;
import es.uca.iw.okto.ui.components.crud.CrudEntityDataProvider;
import es.uca.iw.okto.ui.views.MainView;

@Route(value = ServicesView.ROUTE, layout = MainView.class)
@PageTitle("Manage Services")
@Secured(User.Role.ADMIN)
public class ServicesView extends AbstractCrudView<Service> {

  /**
  *
  */
  private static final long serialVersionUID = 1L;

  public static final String ROUTE = "admin/services";
  
  @Autowired
  public ServicesView(ServiceService service, CurrentUser currentUser, ShipService shipService) {
    super(Service.class, service, new Grid<>(Service.class), createForm(new CrudEntityDataProvider<>(shipService)), currentUser);
  }

  @Override
  public void setupGrid(Grid<Service> grid) {
    grid.setColumns("ship.name","name","description","price");
    grid.getColumnByKey("ship.name").setHeader("Ship");
    setHeightFull();
  }

  @Override
  protected String getBasePage() {
    return ROUTE;
  }

  private static BinderCrudEditor<Service> createForm(DataProvider<Ship,String> shipProvider) {
    ComboBox<Ship> ship = new ComboBox<>();
    ship.getElement().setAttribute("colspan", "2");
    ship.setLabel("ship");

    TextField name = new TextField("Name");
    TextField description = new TextField("Description");
    NumberField price = new NumberField("Price");

    FormLayout form = new FormLayout(name, description, ship, price);

    BeanValidationBinder<Service> binder = new BeanValidationBinder<>(Service.class);
    ship.setDataProvider(shipProvider);

    binder.bind(name, "name");
    binder.bind(description, "description");
    binder.bind(ship, "ship");
    binder.bind(price, "price");

    return new BinderCrudEditor<Service>(binder, form);
  }
}

