package es.uca.iw.okto.views.admin.tours;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;

import es.uca.iw.okto.backend.models.Tour;
import es.uca.iw.okto.backend.services.TourService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/tours", layout = MainView.class)
@PageTitle("Tours")
@CssImport("styles/views/tours/tours-view.css")
public class ToursView extends VerticalLayout {
  private static final long serialVersionUID = -7149150251231753448L;

  public ToursView(TourService tourService) {
    GridCrud<Tour> crud = new GridCrud<>(Tour.class);
    crud.getGrid().setColumns("start","end","city.name");
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("start","end","city.name");
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "start","end","city.name");
    setSizeFull();
    add(crud);
    crud.setOperations(() -> tourService.findAll(), tour -> tourService.save(tour), tour -> tourService.save(tour),
    tour -> tourService.delete(tour));
  }
}
