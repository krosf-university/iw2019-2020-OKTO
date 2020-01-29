package es.uca.iw.okto.views.user.tripservices;

import java.io.Serializable;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;

import es.uca.iw.okto.backend.HasLogger;
import es.uca.iw.okto.backend.models.Service;
import es.uca.iw.okto.backend.repositories.ServiceRepository;
import es.uca.iw.okto.backend.security.CurrentUser;
import es.uca.iw.okto.views.MainView;

@Route(value = "user/tripservices", layout = MainView.class)
@PageTitle("Trips")
@CssImport("./styles/views/users/user-services.css")
public class TripServicesView extends Div implements HasLogger, AfterNavigationObserver, Serializable {
  private static final long serialVersionUID = 4405988136982821755L;

  private final Grid<Service> grid;
  @Autowired
  private ServiceRepository serviceRepository;

  @Autowired
  private CurrentUser currentUser;

  public TripServicesView() {
    setId("user-services-view");
    grid = new Grid<>();
    grid.setId("list");
    grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
    grid.setHeightFull();
    grid.addColumn(new ComponentRenderer<>(service -> {
      H3 h3 = new H3(service.getName());
      Span price = new Span("Price: " + service.getPrice().toString());
      Span ship = new Span("Ship:" + service.getShip().getName());
      Div div = new Div(h3, price, ship);
      div.addClassName("user-services");
      return div;
    }));
    add(grid);
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    grid.setItems(serviceRepository.findByUserOnCurrentTrip(currentUser.getUser().getId()));
  }
}