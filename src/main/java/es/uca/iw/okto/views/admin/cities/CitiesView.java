package es.uca.iw.okto.views.admin.cities;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;

import es.uca.iw.okto.backend.models.City;
import es.uca.iw.okto.backend.services.CityService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/cities", layout = MainView.class)
@PageTitle("Cities")
@CssImport("./styles/views/cities/cities-view.css")
public class CitiesView extends VerticalLayout {
  private static final long serialVersionUID = 591404710284427431L;

  public CitiesView(CityService cityservice) {
    GridCrud<City> crud = new GridCrud<>(City.class);
    crud.getGrid().setColumns("name", "description");
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("name", "description");
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "name", "description");
    setSizeFull();
    add(crud);
    crud.setOperations(() -> cityservice.findAll(), city -> cityservice.save(city), city -> cityservice.save(city),
    city -> cityservice.delete(city));
  }
}
