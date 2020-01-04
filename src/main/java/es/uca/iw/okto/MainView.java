package es.uca.iw.okto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import es.uca.iw.okto.views.home.HomeView;
import es.uca.iw.okto.views.login.LoginView;
import es.uca.iw.okto.views.login.consultardatos.ConsultarDatosView;
import es.uca.iw.okto.views.login.vistasadmin.GestionarClientes;
import es.uca.iw.okto.views.login.vistascliente.ConsultarViajeCrucero;

/**
 * The main view is a top-level placeholder for other views.
 */
@JsModule("./styles/shared-styles.js")
@PWA(name = "OKTO", shortName = "OKTO")
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class MainView extends AppLayout {

  /**
   *
   */
  private static final long serialVersionUID = -5266611431615679171L;
  private final Tabs menu;

  public MainView() {
    menu = createMenuTabs();
    addToNavbar(menu);
  }

  private static Tabs createMenuTabs() {
    final Tabs tabs = new Tabs();
    tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
    tabs.add(getAvailableTabs());
    return tabs;
  }

  private static Tab[] getAvailableTabs() {
    final List<Tab> tabs = new ArrayList<>();
    tabs.add(createTab("Login", LoginView.class));
    tabs.add(createTab("gerente", ConsultarDatosView.class));
    tabs.add(createTab("cliente", ConsultarViajeCrucero.class));
    tabs.add(createTab("admin", GestionarClientes.class));
    tabs.add(createTab("Home", HomeView.class));
    return tabs.toArray(new Tab[tabs.size()]);
  }

  private static Tab createTab(String title, Class<? extends Component> viewClass) {
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
