/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.dao.ProductoDAO;
import com.mycompany.dao.model.Categoria;
import com.mycompany.dao.model.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean
@ViewScoped
public class ProductoBean {
    private Producto producto;
    private ProductoDAO productoDAO;
    private List<Producto> listaProducto;
    private Categoria categoria;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ProductoBean(){
    producto = new Producto();
    categoria = new Categoria();
    }
    
    public ProductoDAO getProductoDAO() {
        return productoDAO;
    }

    public void setProductoDAO(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public void limpiar(){
    producto = new Producto();
    producto.setIdprod(0);
    producto.setCategoria(null);
    producto.setNombre("");
    producto.setPrecio(0.00);
    producto.setStock(0);
    }
    public void operar() throws Exception{
    switch(accion){
    case "registrar":
        this.registrar();
        limpiar();
        break;
    case "modificar":   
        this.modificar(producto);
        limpiar();
        break;
    
    }
    }
    
    
    
    public void registrar() throws Exception{
        productoDAO = new ProductoDAO();
   
        try{
            producto.setCategoria(categoria);
        productoDAO.registrar(producto);
        this.listar();
        }catch(Exception e){
        e.printStackTrace();
        
        }finally{
        productoDAO.Cerrar();
        }
    }
    
    /*
    metodo de listar todos los productos
    */
    public List<Producto> listar() throws Exception{
        listaProducto = new ArrayList<>();
        productoDAO = new ProductoDAO();
        
        try {
          listaProducto = productoDAO.encontar();
        } catch (Exception e) {
        e.printStackTrace();
        }finally{
        productoDAO.Cerrar();
        }
            return listaProducto;
    }
    
    /*
    metodo de eliminar el producto mediante un objero
    */
    public void eliminar(Producto prod) throws Exception{
    ProductoDAO productoDAO = new ProductoDAO();
    try{
        productoDAO.eliminar(prod);
        this.listar();
    }catch(Exception e){
    e.printStackTrace();
    }finally{
    productoDAO.Cerrar();
    }
    }
    
    public Producto leerId(Producto p) throws Exception{
    ProductoDAO productoDAO = new ProductoDAO();
    Producto temp =null;
    
        try {
           producto= productoDAO.leerId(p);
        categoria.setIdcat(producto.getCategoria().getIdcat());
        
           accion="modificar";
           temp=producto;
        } catch (Exception e) {
        e.printStackTrace();
        
        }finally{
        productoDAO.Cerrar();
        }
    return temp;
    }
    
    public void modificar(Producto p) throws Exception{
        productoDAO = new ProductoDAO();
       
        try{
            productoDAO.modificar(p);
        }catch(Exception e){
        e.printStackTrace();
        
        }finally{
        productoDAO.Cerrar();
        }
    
    }
}
