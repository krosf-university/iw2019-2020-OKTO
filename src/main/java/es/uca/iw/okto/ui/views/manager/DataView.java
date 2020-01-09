package es.uca.iw.okto.ui.views.manager;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.security.access.annotation.Secured;

import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.ui.views.MainView;

@Route(value = DataView.ROUTE, layout = MainView.class)
@PageTitle("ConsultarDatos")
@Secured(User.Role.GERENTE)
public class DataView extends Div {

  private static final long serialVersionUID = 5280515399074523767L;
  public static final String ROUTE = "ConsultaDatos";

  public DataView() {
    setId("consultardatos-view");
    VerticalLayout wrapper = createWrapper();
    wrapper.setAlignItems(Alignment.CENTER);

    H1 titulo1 = new H1("Servicios");
    wrapper.add(titulo1);
    createTitle(wrapper);
    
    H1 titulo2 = new H1("Actividades");
    wrapper.add(titulo2);

    H1 titulo3 = new H1("Excursiones");
    wrapper.add(titulo3);

    add(wrapper);
  }

  private void createTitle(VerticalLayout wrapper) {
    Grid<User> grid = new Grid<>();
    grid.addColumn(User::getEmail).setWidth("270px").setHeader("Email").setFlexGrow(5);
    grid.addColumn(u -> u.getFirstName() + " " + u.getLastName()).setHeader("Name").setWidth("200px").setFlexGrow(5);
    grid.addColumn(User::getRole).setHeader("Role").setWidth("150px");
    wrapper.add(grid);
  }

  private VerticalLayout createWrapper() {
    VerticalLayout wrapper = new VerticalLayout();
    wrapper.setId("wrapper");
    wrapper.setSpacing(false);
    return wrapper;
  }
}
