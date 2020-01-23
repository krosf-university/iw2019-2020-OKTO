package es.uca.iw.okto.views.admin.ships;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

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

  public ShipsView(ShipService shipService) {
    GridCrud<Ship> crud = new GridCrud<>(Ship.class);
    crud.getGrid().setColumns("name");
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("name");
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "name");
    setSizeFull();
    add(crud);
    crud.setOperations(() -> shipService.findAll(), ship -> shipService.save(ship), ship -> shipService.save(ship),
    ship -> shipService.delete(ship));
  }

}
