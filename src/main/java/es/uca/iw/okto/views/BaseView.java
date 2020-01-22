package es.uca.iw.okto.views;

import java.util.List;
import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLink;

/**
 * The main view is a top-level placeholder for other views.
 */
public abstract class BaseView extends AppLayout {
  private static final long serialVersionUID = -4764580068380788514L;
  protected final Tabs menu;

  public BaseView(List<Tab> tabs) {
    menu = createMenuTabs(tabs);
    addToNavbar(menu);
  }

  private static Tabs createMenuTabs(List<Tab> tabsArray) {
    final Tabs tabs = new Tabs();
    tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
    tabs.add(tabsArray.toArray(new Tab[tabsArray.size()]));
    return tabs;
  }

  protected static Tab createTab(String title, Class<? extends Component> viewClass) {
    return createTab(populateLink(new RouterLink(null, viewClass), title));
  }

  private static Tab createTab(Component content) {
    final Tab tab = new Tab();
    tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
    tab.add(content);
    return tab;
  }

  private static <T extends HasComponents> T populateLink(T a, String title) {
    a.add(title);
    return a;
  }

  @Override
  protected void afterNavigation() {
    super.afterNavigation();
    selectTab();
  }

  private void selectTab() {
    String target = RouteConfiguration.forSessionScope().getUrl(getContent().getClass());
    Optional<Component> tabToSelect = menu.getChildren().filter(tab -> {
      Component child = tab.getChildren().findFirst().get();
      return child instanceof RouterLink && ((RouterLink) child).getHref().equals(target);
    }).findFirst();
    tabToSelect.ifPresent(tab -> menu.setSelectedTab((Tab) tab));
  }
}
