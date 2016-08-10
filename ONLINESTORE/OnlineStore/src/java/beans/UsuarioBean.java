package beans;

import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gustavo Fernández
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements java.io.Serializable {

    private int cod_usuario;
    private String usuario;
    private String password;
    private String nombres;

    public UsuarioBean() {
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "UsuarioBean{" + "usuario=" + usuario + ", nombres=" + nombres + '}';
    }

    public List<UsuarioBean> getListaUsuarios() {
        List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            lista = dao.getUsuarios();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return lista;
    }

    public String login() {
        String destino = null;
        try {
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.login(this)) {
                UsuarioBean datos = dao.getDatos(this);
                this.setNombres(datos.getNombres());
                this.setPassword(datos.getPassword());
                this.setUsuario(datos.getUsuario());
                this.setCod_usuario(datos.getCod_usuario());
                destino = "inicio";
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("user_administrator", datos.getUsuario());
                session.setAttribute("name_administrator", datos.getNombres());
            } else {
                throw new Exception("Acceso denegado.");
            }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return destino;
    }

    public String getNombreSession() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Object nombreSession = session.getAttribute("name_administrator");
        if (nombreSession == null) {
            nombreSession = " ";
        }
        return nombreSession.toString();
    }

    public String getUsuarioSession() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Object usuarioSession = session.getAttribute("user_administrator");
        if (usuarioSession == null) {
            usuarioSession = " ";
        }
        return usuarioSession.toString();
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }

    public String modificarUsuario() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.modificarUsuario(this);
            return "usuario_modificado.xhtml";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "error";
        }
    }

    public void eliminarUsuario(int codigo) {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.eliminarUsuario(codigo);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public String crearUsuario() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.crearUsuario(this);
            return "usuario_registrado.xhtml";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "error";
        }
    }
}