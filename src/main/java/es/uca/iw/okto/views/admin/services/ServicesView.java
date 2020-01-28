package es.uca.iw.okto.views.admin.services;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;

import es.uca.iw.okto.backend.models.Service;
import es.uca.iw.okto.backend.services.ServiceService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/services", layout = MainView.class)
@PageTitle("Services")
@CssImport("./styles/views/services/services-view.css")
public class ServicesView extends VerticalLayout {

  private static final long serialVersionUID = -8663675772934702721L;

  public ServicesView(ServiceService serviceService) {
    H1 h1 = new H1("Manage Services");
    H3 h3 = new H3("Add, modify or delete services from the system");
    add(h1);
    add(h3);
    GridCrud<Service> crud = new GridCrud<>(Service.class);
    crud.getGrid().setColumns("name", "description","price");
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("name", "description","price");
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "name", "description","price");
    setSizeFull();
    add(crud);
    crud.setOperations(() -> serviceService.findAll(), service -> serviceService.save(service), service -> serviceService.save(service),
    service -> serviceService.delete(service));
  }
}
