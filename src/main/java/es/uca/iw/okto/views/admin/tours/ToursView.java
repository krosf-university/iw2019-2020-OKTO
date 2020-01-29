package es.uca.iw.okto.views.admin.tours;

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

import es.uca.iw.okto.backend.models.Tour;
import es.uca.iw.okto.backend.services.CityService;
import es.uca.iw.okto.backend.services.TourService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/tours", layout = MainView.class)
@PageTitle("Tours")
@CssImport("./styles/views/tours/tours-view.css")
public class ToursView extends VerticalLayout {
  private static final long serialVersionUID = -7149150251231753448L;

  private static final String[] COLUMNS = { "start", "end", "city" };

  private final H1 h1 = new H1("Manage Tours");
  private final H3 h3 = new H3("Add, modify or delete tours from the system");

  public ToursView(TourService tourService, CityService cityService) {
    GridCrud<Tour> crud = new GridCrud<>(Tour.class);
    crud.getGrid().setColumns(Arrays.copyOfRange(COLUMNS, 0, 2));
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties(COLUMNS);
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, COLUMNS);
    crud.setCrudListener(this.crudListener(tourService));
    setSizeFull();
    add(h1, h3, crud);
  }

  CrudListener<Tour> crudListener(TourService tourService) {
    return new CrudListener<Tour>() {
      private static final long serialVersionUID = 174653454765L;

      @Override
      public Collection<Tour> findAll() {
        return tourService.findAll();
      }

      @Override
      public Tour add(Tour tour) {
        return tourService.save(tour);
      }

      @Override
      public Tour update(Tour tour) {
        return tourService.save(tour);
      }

      @Override
      public void delete(Tour tour) {
        tourService.delete(tour);
      }
    };
  }
}
