package es.uca.iw.okto.views.admin.ships;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import es.uca.iw.okto.views.admin.AdminView;

@Route(value = "admin/ships", layout = AdminView.class)
@PageTitle("Ships")
@CssImport("styles/views/ships/ships-view.css")
public class ShipsView extends Div {
  private static final long serialVersionUID = -1523963772684047695L;

  public ShipsView() {
    super();
  }

}
