package security;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class AuthorizationListener implements PhaseListener {

    String unauthorizedPage = "unauthorized.xhtml";
    
    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        String currentPage = facesContext.getViewRoot().getViewId();

        boolean isLoginPage = (currentPage.lastIndexOf("ingreso_clientes.xhtml") > -1);
        boolean isPrivatePage = (currentPage.lastIndexOf("carrito.xhtml") > -1
                || currentPage.lastIndexOf("pedidos_en_linea.xhtml") > -1
                || currentPage.lastIndexOf("contacto.xhtml") > -1);
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

        if (!isPrivatePage) {
            return;
        }
        if (session == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, unauthorizedPage);
        } else {
            Object currentUser = session.getAttribute("username");
            if (isPrivatePage && (currentUser == null || currentUser == "")) {
                //if (!isLoginPage && (currentUser == null || currentUser == "")) {
                NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
                nh.handleNavigation(facesContext, null, unauthorizedPage);
            }
        }

    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
