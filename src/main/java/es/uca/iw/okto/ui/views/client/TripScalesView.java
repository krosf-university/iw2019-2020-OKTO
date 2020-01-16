package es.uca.iw.okto.ui.views.client;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import es.uca.iw.okto.backend.models.City;
import es.uca.iw.okto.backend.models.Scale;
import es.uca.iw.okto.backend.models.Tour;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.services.CityService;
import es.uca.iw.okto.backend.services.ScaleService;
import es.uca.iw.okto.backend.services.TourService;
import es.uca.iw.okto.backend.services.TripService;
import es.uca.iw.okto.backend.services.UserService;
import es.uca.iw.okto.ui.components.crud.CrudEntityDataProvider;
import es.uca.iw.okto.ui.views.MainView;

@Route(value = TripScalesView.ROUTE, layout = MainView.class)
@PageTitle("ConsultarViajeEscalas")
@Secured(User.Role.USER)
public class TripScalesView extends Div {

  /**
   *
   */
  private static final long serialVersionUID = -6778109375103792705L;
  public static final String ROUTE = "ConsultarViajeEscalas";

  // private TextField Dato1 = new TextField();
  // private TextArea Dato2 = new TextArea();

  // public TripScalesView() {
  // setId("consultarviajeEscalas-view");
  // VerticalLayout wrapper = createWrapper();
  // wrapper.setAlignItems(Alignment.CENTER);
  // createTitle(wrapper);
  // createFormLayout(wrapper);

  // add(wrapper);
  // }

  // // horarios de llegada y salida,información de la ciudad, información
  // // meteorológica, consejos y
  // // excursiones programadas
  // private void createTitle(VerticalLayout wrapper) {
  // H1 h1 = new H1("Consultar Escalas");
  // wrapper.add(h1);
  // }

  // private VerticalLayout createWrapper() {
  // VerticalLayout wrapper = new VerticalLayout();
  // wrapper.setId("wrapper");
  // wrapper.setSpacing(false);
  // return wrapper;
  // }

  // private void createFormLayout(VerticalLayout wrapper) {
  // FormLayout formLayout = new FormLayout();
  // addFormItem(wrapper, formLayout, Dato1, "Username");
  // FormLayout formLayout2 = new FormLayout();
  // addFormItem(wrapper, formLayout2, Dato2, "excursiones");
  // }

  // private FormLayout.FormItem addFormItem(VerticalLayout wrapper, FormLayout
  // formLayout, Component field,
  // String fieldName) {
  // FormLayout.FormItem formItem = formLayout.addFormItem(field, fieldName);
  // wrapper.add(formLayout);
  // field.getElement().getClassList().add("full-width");
  // return formItem;
  // }

  private ScaleService scaleService;
  private CityService cityService;
  private TourService tourService;
  private TripService tripService;


  @Autowired
  public TripScalesView(UserService userService, ScaleService scaleService, CityService cityService,
      TourService tourService, TripService tripService) {
    this.scaleService = scaleService;
    this.cityService = cityService;
    this.tourService = tourService;
    this.tripService = tripService;
    setId("consultardatos-view");
    VerticalLayout wrapper = createWrapper();
    wrapper.setAlignItems(Alignment.CENTER);

    H1 titulo1 = new H1("Check Stopover schedule");
    wrapper.add(titulo1);
    setupGrid1(wrapper);

    H1 titulo2 = new H1("City Information");
    wrapper.add(titulo2);
    setupGrid2(wrapper);

    H1 titulo3 = new H1("City Tips");
    wrapper.add(titulo3);
    setupGrid3(wrapper);

    H1 titulo4 = new H1("City Tours");
    wrapper.add(titulo4);
    setupGrid4(wrapper);

    add(wrapper);
  }

  private void setupGrid1(VerticalLayout wrapper) {
    Grid<Scale> grid = new Grid<>();
    CrudEntityDataProvider<Scale> dataProvider = new CrudEntityDataProvider<>(scaleService);
    grid.setDataProvider(dataProvider);
    grid.addColumn(Scale::getCity).setWidth("270px").setHeader("City").setFlexGrow(5);
    grid.addColumn(Scale::getStart).setHeader("Start").setWidth("200px").setFlexGrow(5);
    grid.addColumn(Scale::getEnd).setHeader("End").setWidth("150px");
    wrapper.add(grid);
  }

  private void setupGrid2(VerticalLayout wrapper) {
    Grid<City> grid = new Grid<>();
    CrudEntityDataProvider<City> dataProvider = new CrudEntityDataProvider<>(cityService);
    grid.setDataProvider(dataProvider);
    grid.addColumn(City::getName).setWidth("270px").setHeader("City").setFlexGrow(5);
    grid.addColumn(City::getDescription).setHeader("Description").setWidth("200px").setFlexGrow(5);
    wrapper.add(grid);
  }

  private void setupGrid3(VerticalLayout wrapper) {
    Grid<City> grid = new Grid<>();
    CrudEntityDataProvider<City> dataProvider = new CrudEntityDataProvider<>(cityService);
    grid.setDataProvider(dataProvider);
    grid.addColumn(City::getName).setWidth("270px").setHeader("City").setFlexGrow(5);
    grid.addColumn(City::getTips).setHeader("Tips").setWidth("200px").setFlexGrow(5);
    wrapper.add(grid);
  }

  private void setupGrid4(VerticalLayout wrapper) {
    Grid<Tour> grid = new Grid<>();
    CrudEntityDataProvider<Tour> dataProvider = new CrudEntityDataProvider<>(tourService);
    grid.setDataProvider(dataProvider);
    grid.addColumn(Tour::getName).setWidth("270px").setHeader("Name").setFlexGrow(5);
    grid.addColumn(Tour::getDescription).setHeader("Description").setWidth("200px").setFlexGrow(5);
    grid.addColumn(Tour::getPrice).setHeader("Price").setWidth("150px");
    grid.addColumn(Tour::getStart).setHeader("Start").setWidth("150px");
    grid.addColumn(Tour::getEnd).setHeader("End").setWidth("150px");
    wrapper.add(grid);
  }

  private VerticalLayout createWrapper() {
    VerticalLayout wrapper = new VerticalLayout();
    wrapper.setId("wrapper");
    wrapper.setSpacing(false);
    return wrapper;
  }
}
