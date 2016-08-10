package beans;

import dao.ProductosDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ProductoBean implements java.io.Serializable {

    private int cod_producto;
    private int cod_categoria;
    private int cod_sub_categoria;
    private String nom_producto;
    private String descripcion;
    private String oferta;
    private double precio_oferta;
    private double precio_normal;
    private String fecha_ing;
    private String img_producto;
    private String video_youtube;
    private String banner_grande;
    private String banner_oferta_grande;
    private String banner_chico;
    private String banner_oferta_chica;
    private String estado;
    private List<ProductoBean> resultadoBusqueda;

    public ProductoBean() {
    }

    public String getBanner_chico() {
        return banner_chico;
    }

    public void setBanner_chico(String banner_chico) {
        this.banner_chico = banner_chico;
    }

    public String getBanner_grande() {
        return banner_grande;
    }

    public void setBanner_grande(String banner_grande) {
        this.banner_grande = banner_grande;
    }

    public String getBanner_oferta_chica() {
        return banner_oferta_chica;
    }

    public void setBanner_oferta_chica(String banner_oferta_chica) {
        this.banner_oferta_chica = banner_oferta_chica;
    }

    public String getBanner_oferta_grande() {
        return banner_oferta_grande;
    }

    public void setBanner_oferta_grande(String banner_oferta_grande) {
        this.banner_oferta_grande = banner_oferta_grande;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getCod_sub_categoria() {
        return cod_sub_categoria;
    }

    public void setCod_sub_categoria(int cod_sub_categoria) {
        this.cod_sub_categoria = cod_sub_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_ing() {
        return fecha_ing;
    }

    public void setFecha_ing(String fecha_ing) {
        this.fecha_ing = fecha_ing;
    }

    public String getImg_producto() {
        return img_producto;
    }

    public void setImg_producto(String img_producto) {
        this.img_producto = img_producto;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public double getPrecio_normal() {
        return precio_normal;
    }

    public void setPrecio_normal(double precio_normal) {
        this.precio_normal = precio_normal;
    }

    public double getPrecio_oferta() {
        return precio_oferta;
    }

    public void setPrecio_oferta(double precio_oferta) {
        this.precio_oferta = precio_oferta;
    }

    public String getVideo_youtube() {
        return video_youtube;
    }

    public void setVideo_youtube(String video_youtube) {
        this.video_youtube = video_youtube;
    }

    public List<ProductoBean> getResultadoBusqueda() {
        return resultadoBusqueda;
    }

    @Override
    public String toString() {
        return "ProductoBean{" + "cod_producto=" + cod_producto + ", cod_categoria=" + cod_categoria + ", cod_sub_categoria=" + cod_sub_categoria + ", nom_producto=" + nom_producto + ", precio_normal=" + precio_normal + '}';
    }

    public String mostrarDetalles(int cod_producto) {
        try {
            ProductosDAO dao = new ProductosDAO();
            ProductoBean producto = dao.consultarDetalles(cod_producto);
            this.setCod_producto(producto.getCod_producto());
            this.setNom_producto(producto.getNom_producto());
            this.setFecha_ing(producto.getFecha_ing());
            this.setImg_producto(producto.getImg_producto());
            this.setPrecio_normal(producto.getPrecio_normal());
            this.setPrecio_oferta(producto.getPrecio_oferta());
            this.setDescripcion(producto.getDescripcion());
            this.setVideo_youtube(producto.getVideo_youtube());
            return "detalle_de_productos?faces-redirect=true";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "error?faces-redirect=true";
        }
    }

    public String buscar() throws Exception {
        try {
            ProductosDAO dao = new ProductosDAO();
            resultadoBusqueda = dao.buscar(nom_producto);
            return "busca_productos?faces-redirect=true";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "error?faces-redirect=true";
        }
    }
}