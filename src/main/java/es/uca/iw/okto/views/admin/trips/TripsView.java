package es.uca.iw.okto.views.admin.trips;

import java.util.Arrays;
import java.util.Collection;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;

import es.uca.iw.okto.backend.models.Trip;
import es.uca.iw.okto.backend.services.ScaleService;
import es.uca.iw.okto.backend.services.ShipService;
import es.uca.iw.okto.backend.services.TripService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/trips", layout = MainView.class)
@PageTitle("Trips")
@CssImport("./styles/views/trips/trips-view.css")
public class TripsView extends VerticalLayout {
  private static final long serialVersionUID = -7085673506780715794L;

  private static final String[] COLUMNS = { "name", "start", "end", "ship", "scales" };

  private final H1 h1 = new H1("Manage Trips");
  private final H3 h3 = new H3("Add, modify or delete trips from the system");

  public TripsView(TripService tripService, ShipService shipService, ScaleService scaleService) {
    GridCrud<Trip> crud = new GridCrud<>(Trip.class);
    crud.getGrid().setColumns(Arrays.copyOfRange(COLUMNS, 0, 4));
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties(COLUMNS);
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, COLUMNS);
    crud.setCrudListener(this.crudListener(tripService));
    setSizeFull();
    add(h1, h3, crud);
  }

  CrudListener<Trip> crudListener(TripService tripService) {
    return new CrudListener<Trip>() {
      private static final long serialVersionUID = 174653454765L;

      @Override
      public Collection<Trip> findAll() {
        return tripService.findAll();
      }

      @Override
      public Trip add(Trip trip) {
        return tripService.save(trip);
      }

      @Override
      public Trip update(Trip trip) {
        return tripService.save(trip);
      }

      @Override
      public void delete(Trip trip) {
        tripService.delete(trip);
      }
    };
  }
}
