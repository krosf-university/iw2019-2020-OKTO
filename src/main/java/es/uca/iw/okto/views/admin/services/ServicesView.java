package es.uca.iw.okto.views.admin.services;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import es.uca.iw.okto.views.admin.AdminView;

@Route(value = "manger/services", layout = AdminView.class)
@PageTitle("Services")
@CssImport("styles/views/services/services-view.css")
public class ServicesView extends Div {

  private static final long serialVersionUID = -8663675772934702721L;

  public ServicesView() {
    super();
  }
}
