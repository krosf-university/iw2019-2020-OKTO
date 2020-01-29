package es.uca.iw.okto.views.admin.ships;

import java.util.Arrays;
import java.util.Collection;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;

import es.uca.iw.okto.backend.models.Ship;
import es.uca.iw.okto.backend.services.ShipService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/ships", layout = MainView.class)
@PageTitle("Ships")
@CssImport("./styles/views/ships/ships-view.css")
public class ShipsView extends VerticalLayout {
  private static final long serialVersionUID = -1523963772684047695L;

  private static final String[] COLUMNS = { "name", "capacity", "length" };

  private final H1 h1 = new H1("Manage Ships");
  private final H3 h3 = new H3("Add, modify or delete ships from the system");

  public ShipsView(ShipService shipService) {
    GridCrud<Ship> crud = new GridCrud<>(Ship.class);
    crud.getGrid().setColumns(Arrays.copyOfRange(COLUMNS, 0, 2));
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties(COLUMNS);
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, COLUMNS);
    crud.setCrudListener(this.crudListener(shipService));
    setSizeFull();
    add(h1, h3, crud);
  }

  CrudListener<Ship> crudListener(ShipService shipService) {
    return new CrudListener<Ship>() {
      private static final long serialVersionUID = 174653454765L;

      @Override
      public Collection<Ship> findAll() {
        return shipService.findAll();
      }

      @Override
      public Ship add(Ship ship) {
        return shipService.save(ship);
      }

      @Override
      public Ship update(Ship ship) {
        return shipService.save(ship);
      }

      @Override
      public void delete(Ship ship) {
        shipService.delete(ship);
      }
    };
  }
}