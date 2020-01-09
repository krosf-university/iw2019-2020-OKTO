package es.uca.iw.okto.ui.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;

/**
 * TabView
 */
public class TabView {

  public Class<? extends Component> view;
  public VaadinIcon icon;
  public String title;

  public TabView(Class<? extends Component> view, VaadinIcon icon, String title) {
    this.view = view;
    this.icon = icon;
    this.title = title;
  }
}