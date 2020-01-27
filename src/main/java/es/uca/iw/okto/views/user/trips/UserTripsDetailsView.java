package es.uca.iw.okto.views.user.trips;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

/**
 * UserTripsDetailsView
 */
public class UserTripsDetailsView {

    @Route(value = "greet")
    public class GreetingComponent extends Div implements HasUrlParameter<String> {
        private static final long serialVersionUID = 1475431150981641229L;

        @Override
        public void setParameter(BeforeEvent event, String parameter) {
            setText(String.format("Hello, %s!", parameter));
        }
    }
}