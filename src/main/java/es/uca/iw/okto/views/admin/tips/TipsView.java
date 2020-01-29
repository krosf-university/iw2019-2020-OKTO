
package es.uca.iw.okto.views.admin.tips;

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

import es.uca.iw.okto.backend.models.Tip;
import es.uca.iw.okto.backend.services.CityService;
import es.uca.iw.okto.backend.services.TipService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/tips", layout = MainView.class)
@PageTitle("Tips")
@CssImport("./styles/views/tips/tips-view.css")
public class TipsView extends VerticalLayout {
    private static final long serialVersionUID = 1L;

    private static final String[] COLUMNS = { "description", "city" };

    private final H1 h1 = new H1("Manage Tips");
    private final H3 h3 = new H3("Add, modify or delete tips from the system");

    public TipsView(TipService tipService, CityService cityservice) {
        GridCrud<Tip> crud = new GridCrud<>(Tip.class);
        crud.getGrid().setColumns(Arrays.copyOfRange(COLUMNS, 0, 1));
        crud.getGrid().setColumnReorderingAllowed(true);
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.getCrudFormFactory().setVisibleProperties(COLUMNS);
        crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, COLUMNS);
        crud.setCrudListener(this.crudListener(tipService));
        setSizeFull();
        add(h1, h3, crud);
    }

    CrudListener<Tip> crudListener(TipService tipService) {
        return new CrudListener<Tip>() {
            private static final long serialVersionUID = 174653454765L;

            @Override
            public Collection<Tip> findAll() {
                return tipService.findAll();
            }

            @Override
            public Tip add(Tip tip) {
                return tipService.save(tip);
            }

            @Override
            public Tip update(Tip tip) {
                return tipService.save(tip);
            }

            @Override
            public void delete(Tip tip) {
                tipService.delete(tip);
            }
        };
    }
}