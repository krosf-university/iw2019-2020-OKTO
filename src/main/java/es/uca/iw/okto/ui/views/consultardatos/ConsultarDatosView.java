package es.uca.iw.okto.ui.views.consultardatos;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.security.access.annotation.Secured;
import es.uca.iw.okto.MainView;
import es.uca.iw.okto.backend.models.User;

@Route(value = ConsultarDatosView.ROUTE, layout = MainView.class)
@PageTitle("ConsultarDatos")
@Secured(User.Role.GERENTE)

public class ConsultarDatosView extends Div {

  /**
   *
   */
  private static final long serialVersionUID = 5280515399074523767L;
  public static final String ROUTE = "ConsultaDatos";

  private TextField Dato1 = new TextField();
  private TextField Dato2 = new TextField();

  public ConsultarDatosView() {
    setId("consultardatos-view");
    VerticalLayout wrapper = createWrapper();
    wrapper.setAlignItems(Alignment.CENTER);

    H1 titulo1 = new H1("Servicios");
    wrapper.add(titulo1);
    //createTitle(wrapper);
    
    H1 titulo2 = new H1("Actividades");
    wrapper.add(titulo2);
    //createTitle2(wrapper);

    H1 titulo3 = new H1("Excursiones");
    wrapper.add(titulo3);
    //createTitle3(wrapper);

    add(wrapper);
  }

  // private void createTitle(VerticalLayout wrapper) {
  //   Grid<Person> grid = new Grid<>();
  //   grid.addColumn(Person::getFirstName).setHeader("Nombre");
  //   grid.addColumn(Person::getLastName).setHeader("Precio");

  //   wrapper.add(grid);
  // }

  // private void createTitle2(VerticalLayout wrapper) {
  //   Grid<Person> grid = new Grid<>();
  //   grid.addColumn(Person::getFirstName).setHeader("Nombre");
  //   grid.addColumn(Person::getLastName).setHeader("Precio");
  //   wrapper.add(grid);
  // }

  // private void createTitle3(VerticalLayout wrapper) {
  //   Grid<Person> grid = new Grid<>();
  //   grid.addColumn(Person::getFirstName).setHeader("Nombre");
  //   grid.addColumn(Person::getLastName).setHeader("Precio");
  //   wrapper.add(grid);
  // }

  private VerticalLayout createWrapper() {
    VerticalLayout wrapper = new VerticalLayout();
    wrapper.setId("wrapper");
    wrapper.setSpacing(false);
    return wrapper;
  }

  // private void createFormLayout1(VerticalLayout wrapper) {
  //   FormLayout formLayout = new FormLayout();
  //   addFormItem(wrapper, formLayout, Dato1, "Servicios");
  // }

  // private void createFormLayout2(VerticalLayout wrapper) {
  //   FormLayout formLayout = new FormLayout();
  //   addFormItem(wrapper, formLayout, Dato1, "Actividades");
  // }

  // private void createFormLayout3(VerticalLayout wrapper) {
  //   FormLayout formLayout2 = new FormLayout();
  //   addFormItem(wrapper, formLayout2, Dato2, "Excursiones");
  // }

  // private FormLayout.FormItem addFormItem(VerticalLayout wrapper, FormLayout formLayout,
  //     Component field, String fieldName) {
  //   FormLayout.FormItem formItem = formLayout.addFormItem(field, fieldName);
  //   wrapper.add(formLayout);
  //   field.getElement().getClassList().add("full-width");
  //   return formItem;
  // }
}
