package es.uca.iw.okto.views.admin.cities;

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

import es.uca.iw.okto.backend.models.City;
import es.uca.iw.okto.backend.services.CityService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/cities", layout = MainView.class)
@PageTitle("Cities")
@CssImport("./styles/views/cities/cities-view.css")
public class CitiesView extends VerticalLayout {
  private static final long serialVersionUID = 591404710284427431L;

  private static final String[] COLUMNS = { "name", "description", "country" };

  private final H1 h1 = new H1("Manage Cities");
  private final H3 h3 = new H3("Add, modify or delete cities from the system");

  public CitiesView(CityService cityService) {
    GridCrud<City> crud = new GridCrud<>(City.class);
    crud.getGrid().setColumns(Arrays.copyOfRange(COLUMNS, 0, 2));
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties(COLUMNS);
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, COLUMNS);
    crud.setCrudListener(this.crudListener(cityService));
    setSizeFull();
    add(h1, h3, crud);
  }

  CrudListener<City> crudListener(CityService cityService) {
    return new CrudListener<City>() {
      private static final long serialVersionUID = 174653454765L;

      @Override
      public Collection<City> findAll() {
        return cityService.findAll();
      }

      @Override
      public City add(City city) {
        return cityService.save(city);
      }

      @Override
      public City update(City city) {
        return cityService.save(city);
      }

      @Override
      public void delete(City city) {
        cityService.delete(city);
      }
    };
  }
}
