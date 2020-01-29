package es.uca.iw.okto.views.user.services;

import java.io.Serializable;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;

import es.uca.iw.okto.backend.HasLogger;
import es.uca.iw.okto.backend.models.Service;
import es.uca.iw.okto.backend.security.CurrentUser;
import es.uca.iw.okto.backend.services.ServiceService;
import es.uca.iw.okto.views.MainView;

@Route(value = "user/services", layout = MainView.class)
@PageTitle("Services")
@CssImport("./styles/views/users/user-trips.css")
public class UserServicesView extends Div implements HasLogger, AfterNavigationObserver, Serializable {
  private static final long serialVersionUID = 4405988136982821755L;

  private final Grid<Service> grid;
  @Autowired
  private ServiceService serviceService;

  @Autowired
  private CurrentUser currentUser;

  public UserServicesView() {
    setId("user-services-view");
    grid = new Grid<>();
    grid.setId("list");
    grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
    grid.setHeightFull();
    grid.addColumn(new ComponentRenderer<>(service -> {
      H3 h3 = new H3(service.toString());
      Div div = new Div(h3);
      div.addClassName("user-service");
      return div; 
    }));
    
    add(grid);
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    grid.setItems(serviceService.findByUser(currentUser.getUser()));
  }
}