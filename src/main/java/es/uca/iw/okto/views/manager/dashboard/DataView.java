package es.uca.iw.okto.views.manager.dashboard;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;

import es.uca.iw.okto.backend.models.Activity;
import es.uca.iw.okto.backend.models.Service;
import es.uca.iw.okto.backend.models.Tour;
import es.uca.iw.okto.backend.services.ActivityService;
import es.uca.iw.okto.backend.services.ServiceService;
import es.uca.iw.okto.backend.services.TourService;
import es.uca.iw.okto.views.MainView;

@Route(value = "manager/data", layout = MainView.class)
@PageTitle("Data")
@CssImport("./styles/views/users/users-view.css")
public class DataView extends VerticalLayout implements AfterNavigationObserver {
  private static final long serialVersionUID = -5006331655968812186L;

  private final Grid<Activity> activitiesGrid = new Grid<>(Activity.class);
  private final Grid<Tour> toursGrid = new Grid<>(Tour.class);
  private final Grid<Service> servicesGrid = new Grid<>(Service.class);

  private final String[] COLUMNS = { "name", "description", "start", "end" };

  private ActivityService activityService;
  private TourService tourService;
  private ServiceService serviceService;

  @Autowired
  public DataView(ActivityService activityService, TourService tourService, ServiceService serviceService) {
    this.activityService = activityService;
    this.tourService = tourService;
    this.serviceService = serviceService;

    H2 activitiesTitle = new H2("Activities");
    activitiesGrid.setColumns(COLUMNS);
    add(activitiesTitle, activitiesGrid);

    H2 toursTitle = new H2("Tours");
    toursGrid.setColumns(COLUMNS);
    toursGrid.addColumn("price");
    toursGrid.addColumn(tour -> tour.getCity().getName()).setHeader("City");
    add(toursTitle, toursGrid);

    H2 servicesTitle = new H2("Services");
    servicesGrid.setColumns("name", "description", "price");

    add(servicesTitle, servicesGrid);
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    activitiesGrid.setItems(activityService.findAll());
    toursGrid.setItems(tourService.findAll());
    servicesGrid.setItems(serviceService.findAll());
  }

}