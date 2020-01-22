package es.uca.iw.okto.views.admin;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import es.uca.iw.okto.views.BaseView;
import es.uca.iw.okto.views.admin.cities.CitiesView;
import es.uca.iw.okto.views.admin.ships.ShipsView;
import es.uca.iw.okto.views.admin.tours.ToursView;
import es.uca.iw.okto.views.admin.trips.TripsView;
import es.uca.iw.okto.views.admin.users.UsersView;

@JsModule("./styles/shared-styles.js")
@PWA(name = "OKTO", shortName = "OKTO")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
public class AdminView extends BaseView {
  private static final long serialVersionUID = 684705152990363787L;
  final static List<Tab> tabs = new ArrayList<Tab>() {
    private static final long serialVersionUID = 1L;
    {
      add(createTab("Users", UsersView.class));
      add(createTab("Trips", TripsView.class));
      add(createTab("Ships", ShipsView.class));
      add(createTab("Cities", CitiesView.class));
      add(createTab("Tours", ToursView.class));
    }
  };

  AdminView() {
    super(tabs);
  }
}