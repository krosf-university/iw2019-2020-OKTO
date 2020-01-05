package es.uca.iw.okto;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;

public class MainLayout extends AppLayout{

    /**
     *
     */
    private static final long serialVersionUID = -656606849932248225L;

    public MainLayout(){
        VerticalLayout wrapper = createWrapper();
        wrapper.setAlignItems(Alignment.CENTER);
        addToNavbar(wrapper);
    }

    private VerticalLayout createWrapper() {
        VerticalLayout wrapper = new VerticalLayout();
        wrapper.setId("wrapper");
        wrapper.setSpacing(false);
        return wrapper;
      }

}