/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibertec.crudpracticamaven.controller;

import com.cibertec.crudpracticamaven.datamodel.ProductoDataModel;
import com.cibertec.crudpracticamaven.model.Producto;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author clapj
 */
@ManagedBean(name = "updateController")
@ViewScoped
public class UpdateController implements Serializable{
    private String index;
    private Producto producto;
    @ManagedProperty(value = "#{mantenimientoController}")
    private MantenimientoController mantenimientoController;
    
    
    public String callEditPage(Producto producto){
        this.producto=producto;
        System.out.println(producto.getCodigo());
        return  "actualizar";
    }
    public void saveProductoIndex(ActionEvent ae){
         index=(String)ae.getComponent().getAttributes().get("index");
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
