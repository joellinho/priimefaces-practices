package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SubCategoriaBean implements java.io.Serializable {

    private int cod_sub_categoria;
    private int cod_categoria;
    private String nom_sub_categoria;
    private String img_sub_categoria;
    private String estado;

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public int getCod_sub_categoria() {
        return cod_sub_categoria;
    }

    public void setCod_sub_categoria(int cod_sub_categoria) {
        this.cod_sub_categoria = cod_sub_categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImg_sub_categoria() {
        return img_sub_categoria;
    }

    public void setImg_sub_categoria(String img_sub_categoria) {
        this.img_sub_categoria = img_sub_categoria;
    }

    public String getNom_sub_categoria() {
        return nom_sub_categoria;
    }

    public void setNom_sub_categoria(String nom_sub_categoria) {
        this.nom_sub_categoria = nom_sub_categoria;
    }
}
