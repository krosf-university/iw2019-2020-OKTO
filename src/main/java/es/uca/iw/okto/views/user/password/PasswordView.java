package es.uca.iw.okto.views.user.password;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import es.uca.iw.okto.views.MainView;

@Route(value = "user/password", layout = MainView.class)
@PageTitle("Password")
@CssImport("./styles/views/cities/cities-view.css")
public class PasswordView extends VerticalLayout {
    private static final long serialVersionUID = 591404710284427431L;

    public PasswordView() {
        H1 h1 = new H1("Set Password");
        H3 h3 = new H3("Introduce a valid password and set it for your account");
        add(h1);
        add(h3);
        FormLayout form = new FormLayout();
        PasswordField pass1 = new PasswordField();
        PasswordField pass2 = new PasswordField();
        
        form.add(pass1);
        form.add(pass2);
    }
}