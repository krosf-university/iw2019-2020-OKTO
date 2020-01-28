package es.uca.iw.okto.views.user.expenses;

import java.io.Serializable;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

import org.springframework.beans.factory.annotation.Autowired;

import es.uca.iw.okto.backend.HasLogger;
import es.uca.iw.okto.backend.models.ShopLine;
import es.uca.iw.okto.backend.repositories.PurchaseRepository;
import es.uca.iw.okto.views.MainView;

/**
 * UserTripsDetailsView
 */
@Route(value = "user/expenses", layout = MainView.class)
@PageTitle("Trip Detail")
public class ExpensesDetailsView extends Div implements RouterLayout, HasUrlParameter<Long>, HasLogger, AfterNavigationObserver, Serializable {
  private static final long serialVersionUID = -8186351175360737959L;

  private final Grid<ShopLine> grid;

  @Autowired
  private PurchaseRepository purchaseRepository;

  private Long purchaseId;

  @Override
  public void setParameter(BeforeEvent event, Long parameter) {
    this.purchaseId = parameter;
  }

  public ExpensesDetailsView() {
    setId("user-trips-view");
    grid = new Grid<>();
    grid.setId("list");
    grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
    grid.setHeightFull();

    grid.addColumn(new ComponentRenderer<>(shopline -> {
      H3 h3 = new H3(shopline.toString());
      Div div = new Div(h3);
      div.addClassName("user-trip");
      return div;
    }));
    add(grid);
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    grid.setItems(purchaseRepository.findPurchaseLine(purchaseId));
  }
}