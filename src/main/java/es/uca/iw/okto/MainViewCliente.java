package es.uca.iw.okto;

import java.util.ArrayList;
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
import es.uca.iw.okto.ui.views.login.vistascliente.ConsultarGastos;
import es.uca.iw.okto.ui.views.login.vistascliente.ConsultarViajeCrucero;
import es.uca.iw.okto.ui.views.login.vistascliente.ConsultarViajeEscalas;
import es.uca.iw.okto.ui.views.login.vistascliente.ReservaServicio;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainViewCliente extends AppLayout {

  /**
   *
   */
  private static final long serialVersionUID = -5266611431615679171L;
  private final Tabs menu;

  public MainViewCliente() {
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
    tabs.add(createTab("Consulta Datos Viaje(crucero)", ConsultarViajeCrucero.class));
    tabs.add(createTab("Consulta Datos Viaje(escalas)", ConsultarViajeEscalas.class));
    tabs.add(createTab("Consulta Gastos del viaje", ConsultarGastos.class));
    tabs.add(createTab("Reserva/Compra de Servicios", ReservaServicio.class));
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
