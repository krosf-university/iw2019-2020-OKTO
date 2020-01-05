package es.uca.iw.okto.ui.views.login.vistascliente;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import es.uca.iw.okto.MainViewCliente;

@Route(value = ReservaServicio.ROUTE, layout = MainViewCliente.class)
@RouteAlias(value = "     ", layout = MainViewCliente.class)
@PageTitle("ReservaServicio")

public class ReservaServicio extends Div {
  /**
  *
  */
  private static final long serialVersionUID = -2879645305999430450L;

  public static final String ROUTE = "ReservaServicio";

  private TextField Dato1 = new TextField();
  private TextArea Dato2 = new TextArea();

  public ReservaServicio() {
    setId("ReservaServicio-view");
    VerticalLayout wrapper = createWrapper();
    wrapper.setAlignItems(Alignment.CENTER);
    createTitle(wrapper);
    createFormLayout(wrapper);

    add(wrapper);
  }

  // consejos para los viajeros, servicios e instalaciones disponibles en el barco, planos de
  // localización
  private void createTitle(VerticalLayout wrapper) {
    H1 h1 = new H1("Estos son los servicios disponibles");
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

