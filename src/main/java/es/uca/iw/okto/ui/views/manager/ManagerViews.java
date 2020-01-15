package es.uca.iw.okto.ui.views.manager;

import java.util.ArrayList;
import java.util.List;
import com.vaadin.flow.component.icon.VaadinIcon;
import es.uca.iw.okto.ui.components.TabView;

/**
 * AdminTabs
 */
public class ManagerViews {

  private final static List<TabView> views = new ArrayList<TabView>(4){
    private static final long serialVersionUID = 3650578607109584561L;
    {
    add(new TabView(DataView.class,VaadinIcon.USER, "Datos"));
  }
};

  private ManagerViews() {}

  public static List<TabView> getViews() {
   return views;
  }
}