package es.uca.iw.okto.ui.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.router.RouterLink;

/**
 * CreateTab
 */
public class CreateTab {

  private CreateTab() {
  }

  public static Tab fromTabView(TabView tabView) {
    return fromParams(tabView.icon, tabView.title,tabView.view);
  }

  public static Tab fromParams(VaadinIcon icon, String title,
      Class<? extends Component> viewClass) {
    return fromComponent(populateLink(new RouterLink(null, viewClass), icon, title));
  }

  public static Tab fromComponent(Component content) {
    final Tab tab = new Tab();
    tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
    tab.add(content);
    return tab;
  }

  public static <T extends HasComponents> T populateLink(T a, VaadinIcon icon, String title) {
    a.add(icon.create());
    a.add(title);
    return a;
  }
}