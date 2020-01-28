package es.uca.iw.okto.views.user.expenses;

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
import es.uca.iw.okto.backend.models.UserTrip;
import es.uca.iw.okto.backend.repositories.UserTripRepository;
import es.uca.iw.okto.backend.security.CurrentUser;
import es.uca.iw.okto.views.MainView;

@Route(value = "user/expenses", layout = MainView.class)
@PageTitle("Expenses")
@CssImport("./styles/views/users/user-expenses.css")
public class ExpensesView extends Div implements HasLogger, AfterNavigationObserver, Serializable {
  private static final long serialVersionUID = 4405988136982821755L;

  private final Grid<UserTrip> grid;

  @Autowired
  private UserTripRepository userTripRepository;

  @Autowired
  private CurrentUser currentUser;

  public ExpensesView() {
    setId("user-expenses-view");
    grid = new Grid<>();
    grid.setId("list");
    grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
    grid.setHeightFull();
    
    grid.addColumn(new ComponentRenderer<>(userTrips -> {
      H3 h3 = new H3(userTrips.toString());
      Div div = new Div(h3);
      div.addClassName("trip");
      return div; 
    }));

    add(grid);
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    grid.setItems(userTripRepository.findUserTrip(currentUser.getUser().getId()));
  }
}