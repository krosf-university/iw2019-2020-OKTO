package es.uca.iw.okto.ui.views.consultardatos;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.security.access.annotation.Secured;

import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.ui.views.MainView;

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
  private TextArea Dato2 = new TextArea();

  public ConsultarDatosView() {
    setId("consultardatos-view");
    VerticalLayout wrapper = createWrapper();
    wrapper.setAlignItems(Alignment.CENTER);
    createTitle(wrapper);
    createFormLayout(wrapper);
    createTitle2(wrapper);
    createFormLayout(wrapper);
    createTitle3(wrapper);
    createFormLayout(wrapper);

    add(wrapper);
  }

  private void createTitle(VerticalLayout wrapper) {
    H1 h1 = new H1("Datos Excursiones");
    wrapper.add(h1);
  }

  private void createTitle2(VerticalLayout wrapper) {
    H1 h1 = new H1("Datos Servicios");
    wrapper.add(h1);
  }

  private void createTitle3(VerticalLayout wrapper) {
    H1 h1 = new H1("Datos Actividades");
    wrapper.add(h1);
  }

  private VerticalLayout createWrapper() {
    VerticalLayout wrapper = new VerticalLayout();
    wrapper.setId("wrapper");
    wrapper.setSpacing(false);
    return wrapper;
  }

  private void createFormLayout(VerticalLayout wrapper) {
    FormLayout formLayout = new FormLayout();
    addFormItem(wrapper, formLayout, Dato1, "Username");
    FormLayout formLayout2 = new FormLayout();
    addFormItem(wrapper, formLayout2, Dato2, "excursiones");
  }

  private FormLayout.FormItem addFormItem(VerticalLayout wrapper, FormLayout formLayout,
      Component field, String fieldName) {
    FormLayout.FormItem formItem = formLayout.addFormItem(field, fieldName);
    wrapper.add(formLayout);
    field.getElement().getClassList().add("full-width");
    return formItem;
  }
}
