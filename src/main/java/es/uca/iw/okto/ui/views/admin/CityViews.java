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
import es.uca.iw.okto.backend.models.City;
import es.uca.iw.okto.backend.models.Tip;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.services.CityService;
import es.uca.iw.okto.backend.services.TipService;
import es.uca.iw.okto.ui.components.crud.AbstractCrudView;
import es.uca.iw.okto.ui.components.crud.CrudEntityDataProvider;
import es.uca.iw.okto.ui.views.MainView;

@Route(value = CityViews.ROUTE, layout = MainView.class)
@PageTitle("Manage Cities")
@Secured(User.Role.ADMIN)
public class CityViews extends AbstractCrudView<City> {


    /**
     *
     */
    private static final long serialVersionUID = -2168520839631971782L;
    public static final String ROUTE = "admin/cities";
  
  @Autowired
  public CityViews(CityService service, CurrentUser currentUser, TipService tipService) {
    super(City.class, service, new Grid<>(City.class), createForm(new CrudEntityDataProvider<>(tipService)), currentUser);
  }

  @Override
  public void setupGrid(Grid<City> grid) {
    grid.setColumns("name","description");
    setHeightFull();
  }

  @Override
  protected String getBasePage() {
    return ROUTE;
  }

  private static BinderCrudEditor<City> createForm(DataProvider<Tip,String> tipProvider) {
    TextField name = new TextField("Name");
    TextField description = new TextField("Description");

    FormLayout form = new FormLayout(name, description);

    BeanValidationBinder<City> binder = new BeanValidationBinder<>(City.class);

    binder.bind(name, "name");
    binder.bind(description, "description");

    return new BinderCrudEditor<City>(binder, form);
  }
}

