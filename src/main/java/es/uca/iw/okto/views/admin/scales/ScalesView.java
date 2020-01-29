package es.uca.iw.okto.views.admin.scales;

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

import es.uca.iw.okto.backend.models.Scale;
import es.uca.iw.okto.backend.services.CityService;
import es.uca.iw.okto.backend.services.ScaleService;
import es.uca.iw.okto.backend.services.TripService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/scales", layout = MainView.class)
@PageTitle("Scales")
@CssImport("./styles/views/scales/scales-view.css")
public class ScalesView extends VerticalLayout {
  private static final long serialVersionUID = -7085673506780715794L;

  private static final String[] COLUMNS = { "start", "end", "city", "trip" };

  private final H1 h1 = new H1("Manage Scales");
  private final H3 h3 = new H3("Add, modify or delete scales from the system");

  public ScalesView(ScaleService scaleService, CityService cityService, TripService tripService) {
    GridCrud<Scale> crud = new GridCrud<>(Scale.class);
    crud.getGrid().setColumns(Arrays.copyOfRange(COLUMNS, 0, 3));
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties(COLUMNS);
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, COLUMNS);
    crud.setCrudListener(this.crudListener(scaleService));
    setSizeFull();
    add(h1, h3, crud);
  }

  CrudListener<Scale> crudListener(ScaleService scaleService) {
    return new CrudListener<Scale>() {
      private static final long serialVersionUID = 174653454765L;

      @Override
      public Collection<Scale> findAll() {
        return scaleService.findAll();
      }

      @Override
      public Scale add(Scale scale) {
        return scaleService.save(scale);
      }

      @Override
      public Scale update(Scale scale) {
        return scaleService.save(scale);
      }

      @Override
      public void delete(Scale scale) {
        scaleService.delete(scale);
      }
    };
  }
}
