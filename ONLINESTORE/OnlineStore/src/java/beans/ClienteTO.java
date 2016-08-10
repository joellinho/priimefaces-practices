package beans;

import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


public class ClienteTO implements java.io.Serializable {

    private int cod_cliente;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private String clave;
    private String fecha_nac;
    private String estado;

    public ClienteTO() {
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

   
    public List<ClienteTO> getListaClientes() {
        List<ClienteTO> lista = new ArrayList<ClienteTO>();
        try {
            ClienteDAO dao = new ClienteDAO();
            lista = dao.getClientes2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

  

   
    
}
