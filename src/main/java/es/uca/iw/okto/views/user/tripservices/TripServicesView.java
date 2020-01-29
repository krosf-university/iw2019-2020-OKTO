package es.uca.iw.okto.views.user.tripservices;

import java.io.Serializable;
import java.util.Collection;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;

import es.uca.iw.okto.backend.HasLogger;
import es.uca.iw.okto.backend.models.Service;
import es.uca.iw.okto.backend.models.Trip;
import es.uca.iw.okto.backend.repositories.ServiceRepository;
import es.uca.iw.okto.backend.security.CurrentUser;
import es.uca.iw.okto.views.MainView;

@Route(value = "user/tripservices", layout = MainView.class)
@PageTitle("Trips")
@CssImport("./styles/views/users/user-services.css")
public class TripServicesView extends Div implements HasLogger, AfterNavigationObserver, Serializable {
  private static final long serialVersionUID = 4405988136982821755L;

  private final Grid<Trip> grid;
  @Autowired
  private ServiceRepository serviceRepository;

  @Autowired
  private CurrentUser currentUser;

  public TripServicesView() {
    setId("user-services-view");
    grid = new Grid<>();
    // grid.setId("list");
    // grid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
    // GridVariant.LUMO_NO_ROW_BORDERS);
    // grid.setHeightFull();
    // grid.addColumn(new ComponentRenderer<>(trip -> {
    // H3 h3 = new H3(trip.getName());
    // Div div = new Div(h3);
    // div.addClassName("user-services");
    // return div;
    // }));
    add(grid);
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    // grid.setItems(tripService.findByUser(currentUser.getUser()));

    Collection<Service> services = serviceRepository.findByUserOnCurrentTrip(currentUser.getUser().getId());

    services.forEach(s -> {
      getLogger().warn(s.getId().toString());
    });
  }
}