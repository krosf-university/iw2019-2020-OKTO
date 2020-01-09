package es.uca.iw.okto.ui.views.client;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.icon.VaadinIcon;

import es.uca.iw.okto.ui.components.TabView;

/**
 * AdminTabs
 */
public class ClientViews {

  private final static List<TabView> views = new ArrayList<TabView>(4){
    private static final long serialVersionUID = 3650578607109584561L;
    {
    add(new TabView(ExpensesView.class,VaadinIcon.USER, "Gastos"));
    add(new TabView(ReservationServiceView.class,VaadinIcon.USER,"Reservar / Servicios"));
    add(new TabView(TripScalesView.class,VaadinIcon.USER,"Escalas"));
    add(new TabView(TripShipView.class,VaadinIcon.USER,"Crucero"));
  }
};

  private ClientViews() {}

  public static List<TabView> getViews() {
   return views;
  }
}