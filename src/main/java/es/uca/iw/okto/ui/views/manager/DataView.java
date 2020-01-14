package es.uca.iw.okto.ui.views.manager;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import es.uca.iw.okto.backend.models.Activity;
import es.uca.iw.okto.backend.models.Service;
import es.uca.iw.okto.backend.models.Trip;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.services.ActivityService;
import es.uca.iw.okto.backend.services.ServiceService;
import es.uca.iw.okto.backend.services.TripService;
import es.uca.iw.okto.backend.services.UserService;
import es.uca.iw.okto.ui.components.crud.CrudEntityDataProvider;
import es.uca.iw.okto.ui.views.MainView;


@Route(value = DataView.ROUTE, layout = MainView.class)
@PageTitle("ConsultarDatos")
@Secured(User.Role.GERENTE)
public class DataView extends Div {
  private static final long serialVersionUID = 5280515399074523767L;
  public static final String ROUTE = "ConsultaDatos";
  private UserService userService;
  private ServiceService serviceService;
  private ActivityService actService;
  private TripService tripService;

  @Autowired
  public DataView(UserService userService,ServiceService serviceService,ActivityService actService,TripService tripService) {
    this.userService = userService;
    this.serviceService = serviceService;
    this.actService = actService;
    this.tripService = tripService;
    setId("consultardatos-view");
    VerticalLayout wrapper = createWrapper();
    wrapper.setAlignItems(Alignment.CENTER);

    H1 titulo1 = new H1("Servicios");
    wrapper.add(titulo1);
    setupGrid1(wrapper);

    H1 titulo2 = new H1("Actividades");
    wrapper.add(titulo2);
    setupGrid2(wrapper);

    H1 titulo3 = new H1("Excursiones");
    wrapper.add(titulo3);
    setupGrid3(wrapper);

    add(wrapper);
  }

  private void setupGrid1(VerticalLayout wrapper) {
    Grid<Service> grid = new Grid<>();
    CrudEntityDataProvider<Service> dataProvider = new CrudEntityDataProvider<>(serviceService);
    grid.setDataProvider(dataProvider);
    grid.addColumn(Service::getName).setWidth("270px").setHeader("Name").setFlexGrow(5);
    grid.addColumn(s -> s.getDescription()).setHeader("Description").setWidth("200px").setFlexGrow(5);
    grid.addColumn(Service::getPrice).setHeader("Price").setWidth("150px");
    wrapper.add(grid);
  }

  private void setupGrid2(VerticalLayout wrapper) {
    Grid<Activity> grid = new Grid<>();
    CrudEntityDataProvider<Activity> dataProvider = new CrudEntityDataProvider<>(actService);
    grid.setDataProvider(dataProvider);
    grid.addColumn(Activity::getName).setWidth("270px").setHeader("Name").setFlexGrow(5);
    grid.addColumn(u -> u.getStart()).setHeader("Start").setWidth("200px").setFlexGrow(5);
    grid.addColumn(Activity::getEnd).setHeader("End").setWidth("150px");
    wrapper.add(grid);
  }

  private void setupGrid3(VerticalLayout wrapper) {
    Grid<Trip> grid = new Grid<>();
    CrudEntityDataProvider<Trip> dataProvider = new CrudEntityDataProvider<>(tripService);
    grid.setDataProvider(dataProvider);
    grid.addColumn(Trip::getStart).setWidth("270px").setHeader("Start").setFlexGrow(5);
    grid.addColumn(u -> u.getEnd()).setHeader("End").setWidth("200px").setFlexGrow(5);
    grid.addColumn(Trip::getShip).setHeader("Role").setWidth("150px");
    wrapper.add(grid);
  }

  private VerticalLayout createWrapper() {
    VerticalLayout wrapper = new VerticalLayout();
    wrapper.setId("wrapper");
    wrapper.setSpacing(false);
    return wrapper;
  }
}
