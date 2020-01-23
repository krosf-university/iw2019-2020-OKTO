package es.uca.iw.okto.views.admin.scales;

import java.util.Arrays;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.impl.field.provider.ComboBoxProvider;

import es.uca.iw.okto.backend.models.Scale;
import es.uca.iw.okto.backend.services.CityService;
import es.uca.iw.okto.backend.services.ScaleService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/scales", layout = MainView.class)
@PageTitle("Scales")
@CssImport("styles/views/scales/scales-view.css")
public class ScalesView extends VerticalLayout {
  private static final long serialVersionUID = -7085673506780715794L;

  public ScalesView(ScaleService scaleService, CityService cityService) {
    GridCrud<Scale> crud = new GridCrud<>(Scale.class);
    crud.getGrid().setColumns("start","end","city.name");
    crud.getGrid().setColumnReorderingAllowed(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("start","end","city.name");
    crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "start","end","city.name");
    crud.getGrid().getColumnByKey("city.name").setHeader("City");
    crud.getCrudFormFactory().setFieldProvider("city", new ComboBoxProvider<>(Arrays.asList(cityService.findAll())));
    setSizeFull();
    add(crud);
    crud.setOperations(() -> scaleService.findAll(), scale -> scaleService.save(scale), scale -> scaleService.save(scale),
    scale -> scaleService.delete(scale));
  }

}
