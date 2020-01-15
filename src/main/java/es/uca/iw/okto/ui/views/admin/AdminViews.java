package es.uca.iw.okto.ui.views.admin;

import java.util.ArrayList;
import java.util.List;
import com.vaadin.flow.component.icon.VaadinIcon;
import es.uca.iw.okto.ui.components.TabView;

/**
 * AdminTabs
 */

public class AdminViews {

  private final static List<TabView> views = new ArrayList<TabView>(4) {
    private static final long serialVersionUID = 3650578607109584561L;
    {
      add(new TabView(ClientsView.class, VaadinIcon.USER, "Clientes"));
      add(new TabView(ScalesView.class, VaadinIcon.USER, "Escalas"));
      add(new TabView(ServicesView.class, VaadinIcon.USER, "Servicios"));
      add(new TabView(ToursView.class, VaadinIcon.USER, "Escursiones"));
    }
  };

  private AdminViews() {
  }

  public static List<TabView> getViews() {
    return views;
  }
}
