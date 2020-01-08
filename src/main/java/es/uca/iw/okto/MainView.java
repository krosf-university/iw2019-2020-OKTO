package es.uca.iw.okto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import es.uca.iw.okto.app.security.SecurityUtils;
import es.uca.iw.okto.ui.views.HasConfirmation;
import es.uca.iw.okto.ui.views.consultardatos.ConsultarDatosView;
import es.uca.iw.okto.ui.views.vistasadmin.GestionarClientes;
import es.uca.iw.okto.ui.views.vistasadmin.GestionarEscalas;
import es.uca.iw.okto.ui.views.vistasadmin.GestionarExcursiones;
import es.uca.iw.okto.ui.views.vistasadmin.GestionarServicios;
import es.uca.iw.okto.ui.views.vistascliente.ConsultarGastos;
import es.uca.iw.okto.ui.views.vistascliente.ConsultarViajeCrucero;
import es.uca.iw.okto.ui.views.vistascliente.ConsultarViajeEscalas;
import es.uca.iw.okto.ui.views.vistascliente.ReservaServicio;

@JsModule("./styles/shared-styles.js")
@PWA(name = "OKTO", shortName = "OKTO", startPath = "login")
@Theme(value = Lumo.class, variant = Lumo.DARK)

public class MainView extends AppLayout {

	/**
	*
	*/
	private static final long serialVersionUID = 3890567471058738207L;
	private final ConfirmDialog confirmDialog = new ConfirmDialog();
	private final Tabs menu;

	public MainView() {
		confirmDialog.setCancelable(true);
		confirmDialog.setConfirmButtonTheme("raised tertiary error");
		confirmDialog.setCancelButtonTheme("raised tertiary");

		this.setDrawerOpened(false);
		//appName.addClassName("hide-on-mobile");

		menu = createMenuTabs();

		//this.addToNavbar(appName);
		this.addToNavbar(true, menu);
		this.getElement().appendChild(confirmDialog.getElement());

		getElement().addEventListener("search-focus", e -> {
			getElement().getClassList().add("hide-navbar");
		});

		getElement().addEventListener("search-blur", e -> {
			getElement().getClassList().remove("hide-navbar");
		});
	}

	@Override
	protected void afterNavigation() {
		super.afterNavigation();
		confirmDialog.setOpened(false);
		if (getContent() instanceof HasConfirmation) {
			((HasConfirmation) getContent()).setConfirmDialog(confirmDialog);
		}

		String target = RouteConfiguration.forSessionScope().getUrl(this.getContent().getClass());
		Optional<Component> tabToSelect = menu.getChildren().filter(tab -> {
			Component child = tab.getChildren().findFirst().get();
			return child instanceof RouterLink && ((RouterLink) child).getHref().equals(target);
		}).findFirst();
		tabToSelect.ifPresent(tab -> menu.setSelectedTab((Tab) tab));
	}

	private static Tabs createMenuTabs() {
		final Tabs tabs = new Tabs();
		tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
		tabs.add(getAvailableTabs());
		return tabs;
	}

	private static Tab[] getAvailableTabs() {
		final List<Tab> tabs = new ArrayList<>(4);
		if (SecurityUtils.isAccessGranted(GestionarClientes.class)) {
			tabs.add(createTab(VaadinIcon.USER, "Gestionar Clientes", GestionarClientes.class));
		}
		if (SecurityUtils.isAccessGranted(GestionarEscalas.class)) {
			tabs.add(createTab(VaadinIcon.USER, "Gestionar Escalas", GestionarEscalas.class));
		}
		if (SecurityUtils.isAccessGranted(GestionarExcursiones.class)) {
			tabs.add(createTab(VaadinIcon.USER, "Gestionar Escursiones",
					GestionarExcursiones.class));
		}
		if (SecurityUtils.isAccessGranted(GestionarServicios.class)) {
			tabs.add(createTab(VaadinIcon.USER, "Gestionar Servicios", GestionarServicios.class));
		}
		if (SecurityUtils.isAccessGranted(ConsultarDatosView.class)) {
			tabs.add(createTab(VaadinIcon.USER, "Consultar Datos", ConsultarDatosView.class));
		}
		if (SecurityUtils.isAccessGranted(ConsultarGastos.class)) {
			tabs.add(createTab(VaadinIcon.USER, "Gastos", ConsultarGastos.class));
		}
		if (SecurityUtils.isAccessGranted(ConsultarViajeCrucero.class)) {
			tabs.add(createTab(VaadinIcon.USER, "Crucero", ConsultarViajeCrucero.class));
		}
		if (SecurityUtils.isAccessGranted(ConsultarViajeEscalas.class)) {
			tabs.add(createTab(VaadinIcon.USER, "Escalas", ConsultarViajeEscalas.class));
		}
		if (SecurityUtils.isAccessGranted(ReservaServicio.class)) {
			tabs.add(createTab(VaadinIcon.USER, "Reserva/Compra Servicios", ReservaServicio.class));
		}
		final String contextPath = VaadinServlet.getCurrent().getServletContext().getContextPath();
		final Tab logoutTab = createTab(createLogoutLink(contextPath));
		tabs.add(logoutTab);
		return tabs.toArray(new Tab[tabs.size()]);
	}

	private static Tab createTab(VaadinIcon icon, String title,
			Class<? extends Component> viewClass) {
		return createTab(populateLink(new RouterLink(null, viewClass), icon, title));
	}

	private static Tab createTab(Component content) {
		final Tab tab = new Tab();
		tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
		tab.add(content);
		return tab;
	}

	private static Anchor createLogoutLink(String contextPath) {
		final Anchor a = populateLink(new Anchor(), VaadinIcon.ARROW_RIGHT, "log-out");
		a.setHref(contextPath + "/logout");
		return a;
	}

	private static <T extends HasComponents> T populateLink(T a, VaadinIcon icon, String title) {
		a.add(icon.create());
		a.add(title);
		return a;
	}
}
