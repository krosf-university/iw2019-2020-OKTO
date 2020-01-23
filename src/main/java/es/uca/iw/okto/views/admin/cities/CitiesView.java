package es.uca.iw.okto.views.admin.cities;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import es.uca.iw.okto.views.MainView;

@Route(value = "admin/cities", layout = MainView.class)
@PageTitle("Cities")
@CssImport("styles/views/cities/cities-view.css")
public class CitiesView extends Div {
  private static final long serialVersionUID = 591404710284427431L;

  public CitiesView() {
    super();
  }
}
