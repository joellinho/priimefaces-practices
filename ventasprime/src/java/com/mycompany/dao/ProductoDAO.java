/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dao.model.Categoria;
import com.mycompany.dao.model.Producto;
import com.mycompany.dao.CategoriaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin-joel
 */
public class ProductoDAO extends DAO {

    public List<Producto> encontar() throws Exception {
        CategoriaDAO catdao = new CategoriaDAO();
        List<Producto> listaProductos = new ArrayList<>();
        Categoria cat = null;
        ResultSet rs;
        ResultSet rs2;
        int idprod;
        int idcat;
        String nombre;
        double precio;
        int stock;
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareCall("select idprod,idcat,nombre,precio,stock from producto");
            listaProductos = new ArrayList();

            rs = st.executeQuery();
            this.conectar();
            while (rs.next()) {
                Producto prod = new Producto();
                idprod = rs.getInt("idprod");
                idcat = rs.getInt("idcat");
                nombre = rs.getString("nombre");
                precio = rs.getDouble("precio");
                stock = rs.getInt("stock");
                
                cat = catdao.leerId2(idcat);
                prod.setIdprod(idprod);
                prod.setCategoria(cat);
                prod.setNombre(nombre);
                prod.setPrecio(precio);
                prod.setStock(stock);
                listaProductos.add(prod);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listaProductos;

    }

    public void registrar(Producto p) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("INSERT INTO producto(idcat,nombre,precio,stock) values(?,?,?,?)");

            st.setInt(1, p.getCategoria().getIdcat());
            st.setString(2, p.getNombre());
            st.setDouble(3, p.getPrecio());
            st.setInt(4, p.getStock());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public Producto leerId(Producto p) throws Exception {
        Producto per = null;
        ResultSet rs;
        int idcat;
        Categoria cat3;
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("select idprod,idcat,nombre,precio,stock from producto where idprod=?");
            st.setInt(1, p.getIdprod());
            rs = st.executeQuery();
            CategoriaDAO catDao = new CategoriaDAO();
            while (rs.next()) {
                per = new Producto();
                per.setIdprod(rs.getInt("idprod"));
                idcat = rs.getInt("idcat");         
                cat3= catDao.leerId2(idcat);
                per.setCategoria(cat3);
                per.setNombre(rs.getString("nombre"));
                per.setPrecio(rs.getInt("precio"));
                per.setStock(rs.getInt("stock"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return per;
    }

    public void modificar(Producto p) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("UPDATE producto set idcat=?,nombre=?,precio=?,stock=?  where idprod=?");
            st.setInt(1, p.getCategoria().getIdcat());
            st.setString(2, p.getNombre());
            st.setDouble(3, p.getPrecio());
            st.setInt(4, p.getStock());
            st.setInt(5, p.getIdprod());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(Producto p) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("delete from producto where idprod=?");

            st.setInt(1, p.getIdprod());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
