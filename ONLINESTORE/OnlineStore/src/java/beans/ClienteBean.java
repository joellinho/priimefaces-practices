package beans;

import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ClienteBean implements java.io.Serializable {

    private int cod_cliente;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private String clave;
    private String fecha_nac;
    private String estado;

    public ClienteBean() {
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGreeting() {
        if (this.getNombres() == null) {
            return "";
        } else if (this.getNombres().length() == 0) {
            return "";
        } else {
            return "Welcome to JSF2 + Ajax, " + this.getNombres() + "!";
        }
    }

    public String login() {
        String destino = null;
        try {
            ClienteDAO dao = new ClienteDAO();
            if (dao.login(this)) {
                ClienteBean datos = dao.getDatos(this);
                this.setCod_cliente(datos.getCod_cliente());
                this.setApellidos(datos.getApellidos());
                this.setDireccion(datos.getDireccion());
                this.setFecha_nac(datos.getFecha_nac());
                this.setNombres(datos.getNombres());
                this.setTelefono(datos.getTelefono());
                destino = "bienvenida_clientes";
            } else {
                throw new Exception("Acceso denegado.");
            }
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("username", this.getEmail());
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return destino;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "ingreso_clientes";
    }

    public String create() {
        try {
            ClienteDAO dao = new ClienteDAO();
            dao.create(this);
            return "ingreso_clientes";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "error";
        }
    }

    public List<ClienteBean> getListaClientes() {
        List<ClienteBean> lista = new ArrayList<ClienteBean>();
        try {
            ClienteDAO dao = new ClienteDAO();
            lista = dao.getClientes();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return lista;
    }

    public void eliminarCliente(int codigo) {
        try {
            ClienteDAO dao = new ClienteDAO();
            dao.eliminarCliente(codigo);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public String createCMS() {
        try {
            ClienteDAO dao = new ClienteDAO();
            dao.create(this);
            return "cliente_registrado.xhtml";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "error";
        }
    }

    public String modificarCliente() {
        try {
            ClienteDAO dao = new ClienteDAO();
            dao.modificar(this);
            return "cliente_modificado.xhtml";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "error";
        }
    }
}
