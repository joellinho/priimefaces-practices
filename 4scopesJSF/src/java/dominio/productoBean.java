/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class productoBean {

    private Producto producto;
    private List<Producto> listaProducto;
    private List<Producto> listprodfiltered;
    private Producto selected;
    private String valueToFilter;

    public String getValueToFilter() {
        return valueToFilter;
    }

    public void setValueToFilter(String valueToFilter) {
        this.valueToFilter = valueToFilter;
    }

    public Producto getSelected() {
        return selected;
    }

    public void setSelected(Producto selected) {
        this.selected = selected;
    }
    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
         producto = new Producto();
    }
    
    public void incluir() {
        //System.out.println("incluyendo");
        listaProducto.add(producto);
        producto = new  Producto();
       
    }

    public productoBean() {
       
        listaProducto = new ArrayList<>();
         producto = new Producto();
         listprodfiltered = new ArrayList<>();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public void verificacion(ActionEvent event){
        System.out.println("verificando");
    if("".equals(this.producto.getFabricante())){
    this.producto.setFabricante("sin fabricante");
    }
    }
    public void eliminar(){
    listaProducto.remove(selected);
  
    }

    public List<Producto> getListprodfiltered() {
        return listprodfiltered;
    }

    public void setListprodfiltered(List<Producto> listprodfiltered) {
        this.listprodfiltered = listprodfiltered;
    }
    
    
    public void filtrar(ValueChangeEvent event){
        System.out.println("elemento alterado"+event.getNewValue().toString());
        listprodfiltered.clear();
    for(Producto prod : listaProducto){
        if(prod.getFabricante().startsWith(event.getNewValue().toString())){
        listprodfiltered.add(prod);
        }
    }}
}
