package es.uca.iw.okto.views.admin.services;

import java.util.Arrays;
import java.util.Collection;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.vaadin.crudui.crud.CrudListener;
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

  private static final String[] COLUMNS = { "name", "description", "price" };

  private final H1 h1 = new H1("Manage Services");
  private final H3 h3 = new H3("Add, modify or delete services from the system");

  public ServicesView(ServiceService serviceService) {
    GridCrud<Service> crud = new GridCrud<>(Service.class);
    crud.getGrid().setColumns(Arrays.copyOfRange(COLUMNS, 0, 2));
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties(COLUMNS);
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, COLUMNS);
    crud.setCrudListener(this.crudListener(serviceService));
    setSizeFull();
    add(h1, h3, crud);
  }

  CrudListener<Service> crudListener(ServiceService serviceService) {
    return new CrudListener<Service>() {
      private static final long serialVersionUID = 174653454765L;

      @Override
      public Collection<Service> findAll() {
        return serviceService.findAll();
      }

      @Override
      public Service add(Service service) {
        return serviceService.save(service);
      }

      @Override
      public Service update(Service service) {
        return serviceService.save(service);
      }

      @Override
      public void delete(Service service) {
        serviceService.delete(service);
      }
    };
  }
}
