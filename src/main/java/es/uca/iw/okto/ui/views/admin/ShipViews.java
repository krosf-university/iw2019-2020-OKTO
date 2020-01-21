package es.uca.iw.okto.ui.views.admin;

import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import es.uca.iw.okto.app.security.CurrentUser;
import es.uca.iw.okto.backend.models.Ship;
import es.uca.iw.okto.backend.models.Tip;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.services.ShipService;
import es.uca.iw.okto.backend.services.TipService;
import es.uca.iw.okto.ui.components.crud.AbstractCrudView;
import es.uca.iw.okto.ui.components.crud.CrudEntityDataProvider;
import es.uca.iw.okto.ui.views.MainView;

@Route(value = ShipViews.ROUTE, layout = MainView.class)
@PageTitle("Manage Ships")
@Secured(User.Role.ADMIN)
public class ShipViews extends AbstractCrudView<Ship> {


    /**
     *
     */
    private static final long serialVersionUID = -2168520839631971782L;
    public static final String ROUTE = "admin/ships";
  
  @Autowired
  public ShipViews(ShipService service, CurrentUser currentUser, TipService tipService) {
    super(Ship.class, service, new Grid<>(Ship.class), createForm(new CrudEntityDataProvider<>(tipService)), currentUser);
  }

  @Override
  public void setupGrid(Grid<Ship> grid) {
    grid.setColumns("name");
    setHeightFull();
  }

  @Override
  protected String getBasePage() {
    return ROUTE;
  }

  private static BinderCrudEditor<Ship> createForm(DataProvider<Tip,String> tipProvider) {
    TextField name = new TextField("Name");

    FormLayout form = new FormLayout(name);

    BeanValidationBinder<Ship> binder = new BeanValidationBinder<>(Ship.class);

    binder.bind(name, "name");

    return new BinderCrudEditor<Ship>(binder, form);
  }
}

