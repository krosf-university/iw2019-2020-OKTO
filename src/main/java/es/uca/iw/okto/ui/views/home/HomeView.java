package es.uca.iw.okto.ui.views.home;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import es.uca.iw.okto.ui.views.MainView;

@Route(value = HomeView.ROUTE, layout = MainView.class)
@PageTitle("Home")
public class HomeView extends HorizontalLayout {
  private static final long serialVersionUID = -1045176750090898180L;
  public static final String ROUTE = "home";
  private Text text = new Text("Welcome");


  public HomeView() {
    setAlignItems(Alignment.CENTER);
    setJustifyContentMode(JustifyContentMode.CENTER);
    setHeightFull();
    add(text);
  }
}
