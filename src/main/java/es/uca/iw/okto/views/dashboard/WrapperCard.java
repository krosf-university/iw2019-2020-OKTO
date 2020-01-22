package es.uca.iw.okto.views.dashboard;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class WrapperCard extends Div {
  private static final long serialVersionUID = 3935130179523716833L;

  public WrapperCard(String className, Component[] components, String... classes) {
    addClassName(className);

    Div card = new Div();
    card.addClassNames(classes);
    card.add(components);

    add(card);
  }

}
