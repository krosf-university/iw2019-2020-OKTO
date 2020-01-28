package es.uca.iw.okto.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import es.uca.iw.okto.backend.HasLogger;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.security.SecurityUtils;
import es.uca.iw.okto.views.admin.cities.CitiesView;
import es.uca.iw.okto.views.admin.scales.ScalesView;
import es.uca.iw.okto.views.admin.services.ServicesView;
import es.uca.iw.okto.views.admin.ships.ShipsView;
import es.uca.iw.okto.views.admin.tours.ToursView;
import es.uca.iw.okto.views.admin.trips.TripsView;
import es.uca.iw.okto.views.admin.users.UsersView;
import es.uca.iw.okto.views.login.LoginView;
import es.uca.iw.okto.views.manager.dashboard.DashboardView;
import es.uca.iw.okto.views.manager.dashboard.DataView;
import es.uca.iw.okto.views.user.expenses.ExpensesView;
import es.uca.iw.okto.views.user.reservations.ReservationView;
import es.uca.iw.okto.views.user.trips.UserTripsView;
import es.uca.iw.okto.views.user.tripservices.TripServicesView;

@JsModule("./styles/shared-styles.js")
@PWA(name = "OKTO", shortName = "OKTO")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
public class MainView extends AppLayout implements HasLogger {
  private static final long serialVersionUID = -4764580068380788514L;

  private final Tabs menu;

  public MainView() {
    menu = createMenuTabs();
    Button logout = new Button("Logout");
    logout.addClickListener(e -> {
      VaadinSession.getCurrent().getSession().invalidate();
      UI.getCurrent().navigate(LoginView.class);
      UI.getCurrent().getPage().reload();
    });
    addToNavbar(true, menu, logout);
  }

  private static Tabs createMenuTabs() {
    final Tabs tabs = new Tabs();
    tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
    tabs.add(getAvailableTabs());
    return tabs;
  }

  private static Tab[] getAvailableTabs() {
    final List<Tab> tabs = new ArrayList<>();
    if (SecurityUtils.hasRole(User.Role.MANAGER)) {
      tabs.add(createTab("Dashboard", DashboardView.class));
      tabs.add(createTab("Data", DataView.class));
    } else if (SecurityUtils.hasRole(User.Role.ADMIN)) {
      tabs.add(createTab("Users", UsersView.class));
      tabs.add(createTab("Services", ServicesView.class));
      tabs.add(createTab("Trips", TripsView.class));
      tabs.add(createTab("Ships", ShipsView.class));
      tabs.add(createTab("Cities", CitiesView.class));
      tabs.add(createTab("Tours", ToursView.class));
      tabs.add(createTab("Scales", ScalesView.class));
    } else if (SecurityUtils.hasRole(User.Role.USER)) {
      tabs.add(createTab("Trips", UserTripsView.class));
      tabs.add(createTab("Services", TripServicesView.class));
      tabs.add(createTab("Reservations", ReservationView.class));
      tabs.add(createTab("Expenses", ExpensesView.class));
      
    }

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