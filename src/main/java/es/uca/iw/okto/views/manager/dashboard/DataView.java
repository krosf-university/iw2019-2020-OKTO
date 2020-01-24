package es.uca.iw.okto.views.manager.dashboard;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;

import es.uca.iw.okto.backend.models.Activity;
import es.uca.iw.okto.backend.services.ActivityService;
import es.uca.iw.okto.views.MainView;

@Route(value = "manager/data", layout = MainView.class)
@PageTitle("Data")
@CssImport("./styles/views/users/users-view.css")
public class DataView extends VerticalLayout {
  private static final long serialVersionUID = -5006331655968812186L;

  @Autowired
  public DataView(ActivityService activityService) {
    Grid<Activity> grid = new Grid<>(Activity.class);
    grid.addColumn(Activity::getName).setHeader("Name");
    setSizeFull();
    add(grid);
  }

}
