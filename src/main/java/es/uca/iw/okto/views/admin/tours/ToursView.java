package es.uca.iw.okto.views.admin.tours;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.impl.field.provider.ComboBoxProvider;

import es.uca.iw.okto.backend.models.City;
import es.uca.iw.okto.backend.models.Tour;
import es.uca.iw.okto.backend.services.CityService;
import es.uca.iw.okto.backend.services.TourService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/tours", layout = MainView.class)
@PageTitle("Tours")
@CssImport("styles/views/tours/tours-view.css")
public class ToursView extends VerticalLayout {
  private static final long serialVersionUID = -7149150251231753448L;

  public ToursView(TourService tourService, CityService cityService) {
    GridCrud<Tour> crud = new GridCrud<>(Tour.class);
    crud.getGrid().setColumns("start","end");
    crud.getGrid().addColumn(tour -> tour.getCity().getName()).setHeader("City").setKey("city");
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("start","end","city");
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "start","end","city");
    crud.getCrudFormFactory().setFieldProvider("city",
        new ComboBoxProvider<City>("Cities", cityService.findAll(), new TextRenderer<>(City::getName), City::getName));
    setSizeFull();
    add(crud);
    crud.setOperations(() -> tourService.findAll(), tour -> tourService.save(tour), tour -> tourService.save(tour),
    tour -> tourService.delete(tour));
  }
}
