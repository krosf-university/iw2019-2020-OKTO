package es.uca.iw.okto.views.login.vistascliente;

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

@Route(value = ConsultarViajeEscalas.ROUTE, layout = MainViewCliente.class)
@RouteAlias(value = "   ", layout = MainViewCliente.class)
@PageTitle("ConsultarViajeEscalas")

public class ConsultarViajeEscalas extends Div {

    /**
     *
     */
    private static final long serialVersionUID = -6778109375103792705L;
    public static final String ROUTE = "ConsultarViajeEscalas";

    private TextField Dato1 = new TextField();
    private TextArea Dato2 = new TextArea();

    public ConsultarViajeEscalas() {
        setId("consultarviajeEscalas-view");
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
//horarios de llegada y salida,información de la ciudad, información meteorológica, consejos y excursiones programadas
    private void createTitle(VerticalLayout wrapper) {
        H1 h1 = new H1("horarios llegada y salida");
        wrapper.add(h1);
    }

    private void createTitle2(VerticalLayout wrapper) {
        H1 h1 = new H1("informacion de la ciudad");
        wrapper.add(h1);
    }

    private void createTitle3(VerticalLayout wrapper) {
        H1 h1 = new H1("informacion meteorologica");
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

