/*
 * To change producto license header, choose License Headers in Project Properties.
 * To change producto template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.beans;

import com.pe.online.dao.ProductoDAO;
import com.pe.online.entity.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@SessionScoped
public class ProductoBean implements Serializable {

    Producto producto;

    private List<Producto> lista;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProductoBean() {
        lista = new ArrayList<>();
        producto = new Producto();
    }

    public void mostraTodos() {
        ProductoDAO dao = new ProductoDAO();

        lista = dao.mostrarTodos();

    }

    public String mostrarDetalles(int codigo) {

        ProductoDAO dao = new ProductoDAO();
        producto = dao.mostrarDetalles(codigo);
        producto.setCodigoCategoria(producto.getCodigoCategoria());
        producto.setCodigoSubcategoria(producto.getCodigoSubcategoria());
        producto.setDescripcion(producto.getDescripcion());
        producto.setNombreProducto(producto.getNombreProducto());
        producto.setPrecio(producto.getPrecio());
        producto.setImagen(producto.getImagen());

        lista.add(producto);
        return "detalles.xhtml?faces-redirect=true";
    }

    public List<Producto> eliminar(Producto producto) {
        lista.remove(producto);
        return lista;

    }

    public void seleccionar(Producto prod) {
       
        int index = lista.indexOf(prod);
        producto = lista.get(index);
          this.accion = "modificar";
    }

    public List<Producto> editar() {
       
        int index = lista.indexOf(producto);

        lista.add(index, producto);
        lista.remove(index+1);
        accion="";
        
        return lista;

    }

    public List<Producto> adicionar() {
        int size = lista.size();
        producto.setCodigo(size + 1);
        lista.add(producto);
        return lista;
    }

    public void limpiar() {
        producto = new Producto();
//    producto.setCodigo(0);
//    producto.setDescripcion("");
//    producto.setBannerChico("");
//    producto.setImagen("");
//    producto.setNombreProducto("");
//    producto.setPrecio(0.0);
//    producto.setCodigoSubcategoria(0);
//    producto.setCodigoCategoria(0);
//    producto.setImagen("");
    }

    public void operar() {
        switch (accion) {
            case "nuevo":
                adicionar();
                limpiar();
                
                break;
            case "modificar":
                editar();
                limpiar();
               
                break;

        }
    }
}
