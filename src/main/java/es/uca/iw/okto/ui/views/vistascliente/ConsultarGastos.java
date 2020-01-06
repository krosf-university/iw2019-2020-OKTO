package es.uca.iw.okto.ui.views.vistascliente;

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
import es.uca.iw.okto.MainView;
import es.uca.iw.okto.backend.models.User;

@Route(value = ConsultarGastos.ROUTE, layout = MainView.class)
@PageTitle("ConsultarGastos")
@Secured(User.Role.USER)
public class ConsultarGastos extends Div {

  /**
  *
  */
  private static final long serialVersionUID = 3883724890328316149L;

  public static final String ROUTE = "ConsultarGastos";

  private TextField Dato1 = new TextField();
  private TextArea Dato2 = new TextArea();

  public ConsultarGastos() {
    setId("consultarGastos-view");
    VerticalLayout wrapper = createWrapper();
    wrapper.setAlignItems(Alignment.CENTER);
    createTitle(wrapper);
    createFormLayout(wrapper);
    createTitle2(wrapper);
    createFormLayout(wrapper);

    add(wrapper);
  }

  // horarios de llegada y salida,información de la ciudad, información meteorológica, consejos y
  // excursiones programadas
  private void createTitle(VerticalLayout wrapper) {
    H1 h1 = new H1("Gastos de Actividades");
    wrapper.add(h1);
  }

  private void createTitle2(VerticalLayout wrapper) {
    H1 h1 = new H1("Gastos de Servicios");
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
