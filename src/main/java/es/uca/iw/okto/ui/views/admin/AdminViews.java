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
      add(new TabView(UsersView.class, VaadinIcon.USER, "Users"));
      add(new TabView(ScalesView.class, VaadinIcon.ANCHOR, "Scales"));
      add(new TabView(ServicesView.class, VaadinIcon.BOOK_DOLLAR, "Services"));
      add(new TabView(ToursView.class, VaadinIcon.BUSS, "Tours"));
      add(new TabView(TipViews.class, VaadinIcon.BOOK, "Tips"));
      add(new TabView(CityViews.class, VaadinIcon.BUILDING, "Cities"));
      add(new TabView(ShipViews.class, VaadinIcon.BOAT, "Ships"));
    }
  };

  private AdminViews() {
  }

  public static List<TabView> getViews() {
    return views;
  }
}
