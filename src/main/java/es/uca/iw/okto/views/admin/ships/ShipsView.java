package es.uca.iw.okto.views.admin.ships;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;

import es.uca.iw.okto.backend.models.Ship;
import es.uca.iw.okto.backend.services.ShipService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/ships", layout = MainView.class)
@PageTitle("Ships")
@CssImport("styles/views/ships/ships-view.css")
public class ShipsView extends VerticalLayout {
  private static final long serialVersionUID = -1523963772684047695L;

    @Autowired
  public ShipsView(ShipService shipsService) {
    GridCrud<Ship> crud = new GridCrud<>(Ship.class);
    crud.getGrid().setColumns("name", "capacity", "length");
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("name", "capacity", "length");
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "name", "capacity", "length");
    setSizeFull();
    add(crud);
    crud.setOperations(() -> shipsService.findAll(), ship -> shipsService.save(ship), ship -> shipsService.save(ship),
        ship -> shipsService.delete(ship));
  }

}