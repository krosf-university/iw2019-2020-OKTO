package es.uca.iw.okto.views.manager.dashboard;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.impl.GridCrud;

import es.uca.iw.okto.backend.models.Activity;
import es.uca.iw.okto.backend.models.Tour;
import es.uca.iw.okto.backend.services.ActivityService;
import es.uca.iw.okto.backend.services.TourService;
import es.uca.iw.okto.views.MainView;

@Route(value = "manager/Data", layout = MainView.class)
@PageTitle("Data")
@CssImport("styles/views/users/users-view.css")
public class DataView extends VerticalLayout {
  private static final long serialVersionUID = -5006331655968812186L;

  @Autowired
  public DataView(ActivityService activityService, TourService tourService) {
    GridCrud<Activity> crud = new GridCrud<>(Activity.class);
    H2 titulo1 = new H2("Activities");
    add(titulo1);
    crud.getGrid().setColumns("name", "description");
    crud.getGrid().setColumnReorderingAllowed(true);
    setSizeFull();
    add(crud);
    crud.setOperations(() -> activityService.findAll(), null, null, null);

    GridCrud<Tour> crud2 = new GridCrud<>(Tour.class);
    H2 titulo2 = new H2("Tours");
    add(titulo2);
    crud2.getGrid().setColumns("name", "description", "price");
    crud2.getGrid().addColumn(tour -> tour.getCity().getName()).setHeader("City").setKey("tour");
    crud2.getGrid().setColumnReorderingAllowed(true);
    setSizeFull();
    add(crud2);
    crud2.setOperations(() -> tourService.findAll(), null, null, null);
  }

}