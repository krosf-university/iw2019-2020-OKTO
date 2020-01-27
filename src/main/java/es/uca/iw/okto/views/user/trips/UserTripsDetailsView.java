package es.uca.iw.okto.views.user.trips;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

import es.uca.iw.okto.backend.HasLogger;
import es.uca.iw.okto.views.MainView;

/**
 * UserTripsDetailsView
 */
@Route(value = "user/trips", layout = MainView.class)
@PageTitle("Trip Detail")
public class UserTripsDetailsView extends Div implements RouterLayout, HasUrlParameter<Long>, HasLogger {
  private static final long serialVersionUID = -8186351175360737959L;

  @Override
  public void setParameter(BeforeEvent event, Long parameter) {
    getLogger().info(parameter.toString());
  }
}