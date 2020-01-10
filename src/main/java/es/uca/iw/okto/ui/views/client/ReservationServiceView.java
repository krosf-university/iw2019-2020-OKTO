package es.uca.iw.okto.ui.views.client;

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

@Route(value = ReservationServiceView.ROUTE, layout = MainView.class)
@PageTitle("Book Services")
@Secured(User.Role.USER)

public class ReservationServiceView extends Div {
  /**
  *
  */
  private static final long serialVersionUID = -2879645305999430450L;

  public static final String ROUTE = "ReservaServicio";

  private TextField Dato1 = new TextField();
  private TextArea Dato2 = new TextArea();

  public ReservationServiceView() {
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
    H1 h1 = new H1("Available Services");
    wrapper.add(h1);
  }

  private VerticalLayout createWrapper() {
    VerticalLayout wrapper = new VerticalLayout();
    wrapper.setId("wrapper");
    wrapper.setSpacing(false);
    wrapper.setWidth("100%");
    return wrapper;
  }

  private void createFormLayout(VerticalLayout wrapper) {
    FormLayout formLayout = new FormLayout();
    formLayout.setWidth("100%");
    addFormItem(wrapper, formLayout, Dato1, "Username");
    FormLayout formLayout2 = new FormLayout();
    formLayout2.setWidth("100%");
    addFormItem(wrapper, formLayout2, Dato2, "excursiones");
  }

  private FormLayout.FormItem addFormItem(VerticalLayout wrapper, FormLayout formLayout,
      Component field, String fieldName) {
    FormLayout.FormItem formItem = formLayout.addFormItem(field, fieldName);
    wrapper.add(formLayout);
    return formItem;
  }

}

