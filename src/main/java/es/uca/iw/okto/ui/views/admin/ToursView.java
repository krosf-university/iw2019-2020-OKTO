package es.uca.iw.okto.ui.views.admin;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.security.access.annotation.Secured;
import es.uca.iw.okto.app.security.CurrentUser;
import es.uca.iw.okto.backend.models.Scale;
import es.uca.iw.okto.backend.models.Tour;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.services.ScaleService;
import es.uca.iw.okto.backend.services.TourService;
import es.uca.iw.okto.ui.components.crud.AbstractCrudView;
import es.uca.iw.okto.ui.components.crud.CrudEntityDataProvider;
import es.uca.iw.okto.ui.views.MainView;

@Route(value = ToursView.ROUTE, layout = MainView.class)
@PageTitle("Manage Tours")
@Secured(User.Role.ADMIN)
public class ToursView extends AbstractCrudView<Tour> {

  /**
  *
  */
  private static final long serialVersionUID = 3953623731124759118L;

  public static final String ROUTE = "admin/tours";

  public ToursView(TourService service, CurrentUser currentUser, ScaleService scaleService) {
    super(Tour.class, service, new Grid<>(Tour.class), createForm(new CrudEntityDataProvider<>(scaleService)), currentUser);
  }

  @Override
  public void setupGrid(Grid<Tour> grid) {
    grid.setColumns("scale.city.name","start","end");
    grid.getColumnByKey("scale.city.name").setHeader("Scale");
    setHeightFull();
  }

  @Override
  protected String getBasePage() {
    return ROUTE;
  }

  private static BinderCrudEditor<Tour> createForm(DataProvider<Scale,String> scaleProvider) {
    ComboBox<Scale> scale = new ComboBox<>();
    scale.getElement().setAttribute("colspan", "2");
    scale.setLabel("scale");

    DatePicker start = new DatePicker("Date Start");
    DatePicker end = new DatePicker("Date End");

    FormLayout form = new FormLayout(start, end, scale);

    BeanValidationBinder<Tour> binder = new BeanValidationBinder<>(Tour.class);
    scale.setDataProvider(scaleProvider);

    binder.bind(start, "start");
    binder.bind(end, "end");
    binder.bind(scale, "scale");

    return new BinderCrudEditor<Tour>(binder, form);
  }
}

