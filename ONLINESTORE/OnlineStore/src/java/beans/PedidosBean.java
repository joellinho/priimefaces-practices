package beans;

import dao.ComprasDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class PedidosBean implements java.io.Serializable {

    public PedidosBean() {
    }
    private int cod_compra;
    private int cod_cliente;
    private double total_neto;
    private String fecha;

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_compra() {
        return cod_compra;
    }

    public void setCod_compra(int cod_compra) {
        this.cod_compra = cod_compra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal_neto() {
        return total_neto;
    }

    public void setTotal_neto(double total_neto) {
        this.total_neto = total_neto;
    }

    
    public List<PedidosBean> getListaPedidos() {
        List<PedidosBean> lista = new ArrayList<PedidosBean>();
        try {
            ComprasDAO dao = new ComprasDAO();
            lista = dao.getCompras();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return lista;
    }

    public void eliminar(int codigo) {
        try {
            ComprasDAO dao = new ComprasDAO();
            dao.eliminarCompra(codigo);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void eliminarTodos() {
        try {
            ComprasDAO dao = new ComprasDAO();
            dao.eliminarTodos();
        } catch (Exception e) {
        }
    }
}
