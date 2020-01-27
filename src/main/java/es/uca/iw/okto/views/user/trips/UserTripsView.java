package es.uca.iw.okto.views.user.trips;

import java.io.Serializable;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;

import es.uca.iw.okto.backend.HasLogger;
import es.uca.iw.okto.backend.models.Trip;
import es.uca.iw.okto.backend.security.CurrentUser;
import es.uca.iw.okto.backend.services.TripService;
import es.uca.iw.okto.views.MainView;

@Route(value = "user/trips", layout = MainView.class)
@PageTitle("Trips")
@CssImport("./styles/views/users/user-trips.css")
public class UserTripsView extends Div implements HasLogger, AfterNavigationObserver, Serializable {
  private static final long serialVersionUID = 4405988136982821755L;

  private final Grid<Trip> grid;
  @Autowired
  private TripService tripService;

  @Autowired
  private CurrentUser currentUser;

  public UserTripsView() {
    setId("user-trips-view");
    grid = new Grid<>();
    grid.setId("list");
    grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
    grid.setHeightFull();
    grid.addColumn(new ComponentRenderer<>(trip -> {
      H3 h3 = new H3(trip.toString());
      Div div = new Div(h3);
      div.addClassName("user-trip");
      return div; 
    }));
    add(grid);
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    grid.setItems(tripService.findByUser(currentUser.getUser()));
  }
}