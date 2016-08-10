package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CategoriaBean implements java.io.Serializable {

    private int cod_categoria;
    private String nom_categoria;
    private String img_categoria;
    private String estado;

    public CategoriaBean() {
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImg_categoria() {
        return img_categoria;
    }

    public void setImg_categoria(String img_categoria) {
        this.img_categoria = img_categoria;
    }

    public String getNom_categoria() {
        return nom_categoria;
    }

    public void setNom_categoria(String nom_categoria) {
        this.nom_categoria = nom_categoria;
    }
}