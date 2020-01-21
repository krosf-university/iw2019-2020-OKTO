package es.uca.iw.okto.ui.views.admin;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.security.access.annotation.Secured;
import es.uca.iw.okto.app.security.CurrentUser;
import es.uca.iw.okto.backend.models.City;
import es.uca.iw.okto.backend.models.Tip;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.services.CityService;
import es.uca.iw.okto.backend.services.TipService;
import es.uca.iw.okto.ui.components.crud.AbstractCrudView;
import es.uca.iw.okto.ui.components.crud.CrudEntityDataProvider;
import es.uca.iw.okto.ui.views.MainView;

@Route(value = TipViews.ROUTE, layout = MainView.class)
@PageTitle("Manage Tip")
@Secured(User.Role.ADMIN)
public class TipViews extends AbstractCrudView<Tip> {

  /**
  *
  */
  private static final long serialVersionUID = 3953623731124759118L;

  public static final String ROUTE = "admin/tips";

  public TipViews(TipService service, CurrentUser currentUser, CityService cityService) {
    super(Tip.class, service, new Grid<>(Tip.class), createForm(new CrudEntityDataProvider<>(cityService)), currentUser);
  }

  @Override
  public void setupGrid(Grid<Tip> grid) {
    grid.setColumns("city.name","description");
    grid.getColumnByKey("city.name").setHeader("City");
    setHeightFull();
  }

  @Override
  protected String getBasePage() {
    return ROUTE;
  }

  private static BinderCrudEditor<Tip> createForm(DataProvider<City,String> cityProvider) {
    ComboBox<City> city = new ComboBox<>();
    city.getElement().setAttribute("colspan", "2");
    city.setLabel("city");

    TextField description = new TextField("Description");

    FormLayout form = new FormLayout(description, city);

    BeanValidationBinder<Tip> binder = new BeanValidationBinder<>(Tip.class);
    city.setDataProvider(cityProvider);

    binder.bind(description, "description");
    binder.bind(city, "city");

    return new BinderCrudEditor<Tip>(binder, form);
  }
}

