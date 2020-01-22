package es.uca.iw.okto.views.admin.trips;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import es.uca.iw.okto.views.admin.AdminView;

@Route(value = "admin/trips", layout = AdminView.class)
@PageTitle("Trips")
@CssImport("styles/views/trips/trips-view.css")
public class TripsView extends Div {
  private static final long serialVersionUID = -7085673506780715794L;

  public TripsView() {
    super();
  }

}
