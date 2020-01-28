package es.uca.iw.okto.views.user.trips;

import java.io.Serializable;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

import org.springframework.beans.factory.annotation.Autowired;

import es.uca.iw.okto.backend.HasLogger;
import es.uca.iw.okto.backend.models.Scale;
import es.uca.iw.okto.backend.services.TripService;
import es.uca.iw.okto.views.MainView;

/**
 * UserTripsDetailsView
 */
@Route(value = "user/trips", layout = MainView.class)
@PageTitle("Trip Detail")
public class UserTripsDetailsView extends Div implements RouterLayout, HasUrlParameter<Long>, HasLogger, AfterNavigationObserver, Serializable {
  private static final long serialVersionUID = -8186351175360737959L;

  private final Grid<Scale> grid;

  @Autowired
  private TripService tripService;

  private Long tripId;

  @Override
  public void setParameter(BeforeEvent event, Long parameter) {
    this.tripId = parameter;
  }

  public UserTripsDetailsView() {
    setId("user-trips-view");
    grid = new Grid<>();
    grid.setId("list");
    grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
    grid.setHeightFull();

    grid.addColumn(new ComponentRenderer<>(scale -> {
      H3 h3 = new H3(scale.getCity().getName());
      Span start = new Span("Start: " + scale.getStart().toString());
      Span end = new Span("End: " + scale.getEnd().toString());
      Div date = new Div(start, end);
      Div div = new Div(h3 , date);
      div.addClassName("user-trip");
      return div;
    }));
    add(grid);
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    grid.setItems(tripService.findScales(tripId));
  }
}