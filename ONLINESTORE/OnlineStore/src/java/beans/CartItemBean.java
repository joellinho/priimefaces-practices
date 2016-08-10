package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CartItemBean implements java.io.Serializable {

    private int cod_producto;
    private String nom_producto;
    private String img_producto;
    private double precio;
    private int cantidad;
    private double total;

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getImg_producto() {
        return img_producto;
    }

    public void setImg_producto(String img_producto) {
        this.img_producto = img_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio_normal) {
        this.precio = precio_normal;
    }

    public double getTotal() {
        return total;
    }

    public void calcularTotal() {
        this.total = (double) this.cantidad * this.precio;
    }
}
