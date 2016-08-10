package beans;

import dao.ContactoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ContactoBean {

    private int cod_contacto;
    private String nombres;
    private String apellidos;
    private String email;
    private String comentario;

    public ContactoBean() {
    }

    public int getCod_contacto() {
        return cod_contacto;
    }

    public void setCod_contacto(int cod_contacto) {
        this.cod_contacto = cod_contacto;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String enviar() {
        try {
            ContactoDAO dao = new ContactoDAO();
            dao.contactar(this);
            return "contacto_mensaje";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "";
        }
    }

    public String mensaje() {
        return "Contacto enviado";
    }

    public List<ContactoBean> getListaContactos() {
        List<ContactoBean> lista = new ArrayList<ContactoBean>();
        try {
            ContactoDAO dao = new ContactoDAO();
            lista = dao.getContactos();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return lista;
    }

    public void eliminar(int codigo) {
        try {
            ContactoDAO dao = new ContactoDAO();
            dao.eliminarContacto(codigo);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void eliminarTodos() {
        try {
            ContactoDAO dao = new ContactoDAO();
            dao.eliminarTodos();
        } catch (Exception e) {
        }
    }
}
