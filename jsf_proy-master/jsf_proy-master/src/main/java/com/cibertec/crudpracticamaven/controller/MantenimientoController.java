/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibertec.crudpracticamaven.controller;

import com.cibertec.crudpracticamaven.datamodel.ProductoDataModel;
import com.cibertec.crudpracticamaven.model.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author clapj
 */
@ManagedBean(name = "mantenimientoController")
@ViewScoped
public class MantenimientoController implements Serializable{
    
    private List<Producto> productos,allProductos;
    private ProductoDataModel productosDataModel;
    @ManagedProperty(value = "#{loginController}")
    private LoginController loginController;
    private String index;
    private String nombreProducto;
    private Producto productoSearch;
    private Producto productoEdit;
    private Producto productoCreate;
    @PostConstruct
    public void init(){
        productos = new ArrayList<>();
        Producto producto = new Producto();
        producto.setCodigo("AB1");
        producto.setNombre("mesa");
        productos.add(producto);
        producto = new Producto();
        producto.setCodigo("DF3");
        producto.setNombre("mesa de oro");
        productos.add(producto);
        producto = new Producto();
        producto.setCodigo("TG2");
        producto.setNombre("tv smart");
        productos.add(producto);
         producto = new Producto();
        producto.setCodigo("TH0");
        producto.setNombre("tv analogica");
        productos.add(producto);
        allProductos=new ArrayList<>();
        allProductos.addAll(productos);
        
        cargarFiltros();
    }
    
    public void cargarFiltros(){
        cargarProfesion();
        cargarGenero();
    }
     public void saveProductoIndex(ActionEvent ae){
         index=(String)ae.getComponent().getAttributes().get("index");
    }
    public void cargarProfesion(){
    
    }
    public void save(){
        
        allProductos.set(Integer.parseInt(getIndex()), productoEdit);
        
    }
    public void create(){
       allProductos.add(productoCreate);
       productos.add(productoCreate);
    }
     public void createProducto(){
       productoCreate=new Producto();
    }
    public String getIndex() {
        return index;
    }
    public void saveProducto(Producto productoEdit){
        setIndex(allProductos.indexOf(productoEdit)+"");
        this.productoEdit=productoEdit;
    }
    public void setIndex(String index) {
        this.index = index;
    }
    
    public void deleteProducto(Producto producto){
        productos.remove(producto);
        allProductos.remove(producto);
    }
    
    public void cargarGenero(){
    }
    
    public String procesar(){
        
        return "paso3";
    }
     public void buscarProducto(){
         if (nombreProducto.isEmpty() || nombreProducto.trim().isEmpty()) {
             productos.clear();
             productos.addAll(allProductos);
         }else{
             productos.clear();
            for (Producto producto : allProductos) {
                if (producto.getNombre().contains(nombreProducto)) {
                        productos.add(producto);
                }
            }
         }
         
    }
    public void buscar(){
        try {
            
        } catch (Exception e) {
            loginController.cerraSesion();
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

  
    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public ProductoDataModel getProductosDataModel() {
        return productosDataModel;
    }

    public void setProductosDataModel(ProductoDataModel productosDataModel) {
        this.productosDataModel = productosDataModel;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Producto getProductoSearch() {
        return productoSearch;
    }

    public void setProductoSearch(Producto productoSearch) {
        this.productoSearch = productoSearch;
    }

    public Producto getProductoEdit() {
        return productoEdit;
    }

    public void setProductoEdit(Producto productoEdit) {
        this.productoEdit = productoEdit;
    }

    public Producto getProductoCreate() {
        return productoCreate;
    }

    public void setProductoCreate(Producto productoCreate) {
        this.productoCreate = productoCreate;
    }
    
   
}
