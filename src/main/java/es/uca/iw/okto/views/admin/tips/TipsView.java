
package es.uca.iw.okto.views.admin.tips;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;

import es.uca.iw.okto.backend.models.Tip;
import es.uca.iw.okto.backend.services.TipService;
import es.uca.iw.okto.views.MainView;

@Route(value = "admin/tips", layout = MainView.class)
@PageTitle("Tips")
@CssImport("./styles/views/tips/tips-view.css")
public class TipsView extends VerticalLayout {
    private static final long serialVersionUID = 1L;

    public TipsView(TipService tipservice) {
        H1 h1 = new H1("Manage Tips");
        H3 h3 = new H3("Add, modify or delete tips from the system");
        add(h1);
        add(h3);
        GridCrud<Tip> crud = new GridCrud<>(Tip.class);
        crud.getGrid().setColumns("description");
        crud.getGrid().getColumnByKey("description").setHeader("Tip");
        crud.getGrid().addColumn(tip -> tip.getCity().getName()).setHeader("City").setKey("city");
        crud.getGrid().setColumnReorderingAllowed(true);
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.getCrudFormFactory().setVisibleProperties("city", "description");
        crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "city", "description");
        setSizeFull();
        add(crud);
        crud.setOperations(() -> tipservice.findAll(), tip -> tipservice.save(tip), tip -> tipservice.save(tip),
                tip -> tipservice.delete(tip));
    }
}