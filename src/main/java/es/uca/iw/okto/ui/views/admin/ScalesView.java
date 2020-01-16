package es.uca.iw.okto.ui.views.admin;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import es.uca.iw.okto.app.security.CurrentUser;
import es.uca.iw.okto.backend.models.Scale;
import es.uca.iw.okto.backend.models.Trip;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.services.ScaleService;
import es.uca.iw.okto.backend.services.TripService;
import es.uca.iw.okto.ui.components.crud.AbstractCrudView;
import es.uca.iw.okto.ui.components.crud.CrudEntityDataProvider;
import es.uca.iw.okto.ui.views.MainView;

@Route(value = ScalesView.ROUTE, layout = MainView.class)
@PageTitle("Manage Scales")
@Secured(User.Role.ADMIN)
public class ScalesView extends AbstractCrudView<Scale> {

  /**
  *
  */
  private static final long serialVersionUID = 1L;
  
  public static final String ROUTE = "admin/scales";
  
  @Autowired
  public ScalesView(ScaleService service, CurrentUser currentUser, TripService tripService) {
    super(Scale.class, service, new Grid<>(Scale.class), createForm(new CrudEntityDataProvider<>(tripService)), currentUser);
  }

  @Override
  public void setupGrid(Grid<Scale> grid) {
    grid.setColumns("city.name","start","end");
    grid.getColumnByKey("city.name").setHeader("City");
    setHeightFull();
  }

  @Override
  protected String getBasePage() {
    return ROUTE;
  }

  private static BinderCrudEditor<Scale> createForm(DataProvider<Trip,String> tripProvider) {
    ComboBox<Trip> trip = new ComboBox<>();
    trip.getElement().setAttribute("colspan", "2");
    trip.setLabel("trip");

    DatePicker start = new DatePicker("Date Start");
    DatePicker end = new DatePicker("Date End");
    
    FormLayout form = new FormLayout(start, end, trip);

    BeanValidationBinder<Scale> binder = new BeanValidationBinder<>(Scale.class);
    trip.setDataProvider(tripProvider);

    binder.bind(start, "start");
    binder.bind(end, "end");
    binder.bind(trip,"trip");


    return new BinderCrudEditor<Scale>(binder, form);
  }
}

