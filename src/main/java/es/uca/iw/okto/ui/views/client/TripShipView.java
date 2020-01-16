
package es.uca.iw.okto.ui.views.client;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.security.access.annotation.Secured;
import es.uca.iw.okto.backend.models.Service;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.services.ServiceService;
import es.uca.iw.okto.ui.components.crud.CrudEntityDataProvider;
import es.uca.iw.okto.ui.views.MainView;

@Route(value = TripShipView.ROUTE, layout = MainView.class)
@PageTitle("ConsultarViajeCrucero")
@Secured(User.Role.USER)
public class TripShipView extends Div {

  /**
   *
   */
  private static final long serialVersionUID = -6778109375103792705L;
  public static final String ROUTE = "ConsultarViajeCrucero";


  // private TipService tipService;
  private ServiceService serviceService;

  public TripShipView(/* TipService tipService , */ ServiceService serviceService) {
    // this.tipService = tipService;
    this.serviceService = serviceService;
    setId("consultarviajeCrucero-view");
    // VerticalLayout wrapper = createWrapper();
    // wrapper.setAlignItems(Alignment.CENTER);
    // createTitle(wrapper);
    // createFormLayout(wrapper);
    // createTitle2(wrapper);
    // createFormLayout(wrapper);
    // createTitle3(wrapper);
    // createFormLayout(wrapper);

    // add(wrapper);
    // }

    // // consejos para los viajeros, servicios e instalaciones disponibles en el barco, planos de
    // // localización
    // private void createTitle(VerticalLayout wrapper) {
    // H1 h1 = new H1("Consejos para los Viajeros");
    // wrapper.add(h1);
    // }

    // private void createTitle2(VerticalLayout wrapper) {
    // H1 h1 = new H1("Datos Servicios");
    // wrapper.add(h1);
    // }

    // private void createTitle3(VerticalLayout wrapper) {
    // H1 h1 = new H1("instalaciones Disponibles");
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

    // private FormLayout.FormItem addFormItem(VerticalLayout wrapper, FormLayout formLayout,
    // Component field, String fieldName) {
    // FormLayout.FormItem formItem = formLayout.addFormItem(field, fieldName);
    // wrapper.add(formLayout);
    // field.getElement().getClassList().add("full-width");
    // return formItem;
    // }

    VerticalLayout wrapper = createWrapper();
    wrapper.setAlignItems(Alignment.CENTER);

    H1 titulo1 = new H1("Trip tips");
    wrapper.add(titulo1);
    setupGrid1(wrapper);

    H1 titulo2 = new H1("Advailable Services on the ship");
    wrapper.add(titulo2);
    setupGrid2(wrapper);

    add(wrapper);
  }

  private void setupGrid1(VerticalLayout wrapper) {
    // Grid<Tip> grid = new Grid<>();
    // CrudEntityDataProvider<Tip> dataProvider = new CrudEntityDataProvider<>(tipService);
    // grid.setDataProvider(dataProvider);
    // grid.addColumn(Scale::getCity).setWidth("270px").setHeader("City").setFlexGrow(5);
    // grid.addColumn(Scale::getStart).setHeader("Start").setWidth("200px").setFlexGrow(5);
    // grid.addColumn(Scale::getEnd).setHeader("End").setWidth("150px");
    // wrapper.add(grid);
  }

  private void setupGrid2(VerticalLayout wrapper) {
    Grid<Service> grid = new Grid<>();
    CrudEntityDataProvider<Service> dataProvider = new CrudEntityDataProvider<>(serviceService);
    grid.setDataProvider(dataProvider);
    grid.addColumn(Service::getName).setWidth("270px").setHeader("Name").setFlexGrow(5);
    grid.addColumn(Service::getDescription).setHeader("Description").setWidth("200px")
        .setFlexGrow(5);
    grid.addColumn(Service::getPrice).setHeader("Price").setWidth("200px").setFlexGrow(5);
    wrapper.add(grid);
  }

  private VerticalLayout createWrapper() {
    VerticalLayout wrapper = new VerticalLayout();
    wrapper.setId("wrapper");
    wrapper.setSpacing(false);
    return wrapper;
  }
}