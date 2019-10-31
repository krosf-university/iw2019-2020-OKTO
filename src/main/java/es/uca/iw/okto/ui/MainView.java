package es.uca.iw.okto.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;



@Route
@PWA(name = "Project Base for Vaadin Flow with Spring", shortName = "Project Base")
public class MainView extends VerticalLayout {

  private static final long serialVersionUID = 6107529168228967599L;

  public MainView(@Autowired MessageBean bean) {
    Button button = new Button("Click Here", e -> Notification.show(bean.getMessage()));
    add(button);
  }

}
