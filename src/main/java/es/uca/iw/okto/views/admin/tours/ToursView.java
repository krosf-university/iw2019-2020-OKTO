package es.uca.iw.okto.views.admin.tours;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import es.uca.iw.okto.views.MainView;

@Route(value = "admin/tours", layout = MainView.class)
@PageTitle("Tours")
@CssImport("styles/views/tours/tours-view.css")
public class ToursView extends Div {
  private static final long serialVersionUID = -7149150251231753448L;

  public ToursView() {
    super();
  }
}
