package es.uca.iw.okto.views.manager.dashboard;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;

import es.uca.iw.okto.backend.models.Activity;
import es.uca.iw.okto.backend.models.OtherService;
import es.uca.iw.okto.backend.models.Tour;
import es.uca.iw.okto.backend.services.ActivityService;
import es.uca.iw.okto.backend.services.OtherServiceService;
import es.uca.iw.okto.backend.services.TourService;
import es.uca.iw.okto.views.MainView;

@Route(value = "manager/Data", layout = MainView.class)
@PageTitle("Data")
@CssImport("styles/views/users/users-view.css")
public class DataView extends VerticalLayout {
  private static final long serialVersionUID = -5006331655968812186L;

  @Autowired
  public DataView(ActivityService activityService, TourService tourService, OtherServiceService otherServiceService){
    H2 titulo1 = new H2("Activities");
    add(titulo1);
    
    List<Activity> list = new ArrayList<>();
    list.addAll(activityService.findAll());
    Grid<Activity> grid = new Grid<>(Activity.class);
    grid.setItems(list);
    grid.setColumns("name","description","start","end");
    add(grid);


    H2 titulo2 = new H2("Tours");

    add(titulo2);

    List<Tour> list2 = new ArrayList<>();
    list2.addAll(tourService.findAll());
    Grid<Tour> grid2 = new Grid<>(Tour.class);
    grid2.setItems(list2);
    grid2.setColumns("name","description","start","end","price");
    grid2.addColumn(tour -> tour.getCity().getName()).setHeader("City");
    add(grid2);

    H2 titulo3 = new H2("On Ship Services");
    add(titulo3);

    List<OtherService> list3 = new ArrayList<>();
    list3.addAll(otherServiceService.findAll());
    Grid<OtherService> grid3 = new Grid<>(OtherService.class);
    grid3.setItems(list3);
    grid3.setColumns("name","description","price","ship");
    grid3.addColumn(ship -> ship.getShip().getName()).setHeader("Ship");
    add(grid3);
  }

}