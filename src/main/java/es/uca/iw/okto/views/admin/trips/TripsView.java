package es.uca.iw.okto.views.admin.trips;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;

import es.uca.iw.okto.backend.models.Trip;
import es.uca.iw.okto.backend.services.TripService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/trips", layout = MainView.class)
@PageTitle("Trips")
@CssImport("styles/views/trips/trips-view.css")
public class TripsView extends VerticalLayout {
  private static final long serialVersionUID = -7085673506780715794L;

  public TripsView(TripService tripService) {
    GridCrud<Trip> crud = new GridCrud<>(Trip.class);
    crud.getGrid().setColumns("name","start","end","ship.name");
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("name","start","end","ship.name");
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "name","start","end","ship.name");
    crud.getGrid().getColumnByKey("ship.name").setHeader("Ship");
    setSizeFull();
    add(crud);
    crud.setOperations(() -> tripService.findAll(), trip -> tripService.save(trip), trip -> tripService.save(trip),
    trip -> tripService.delete(trip));
  }

}
