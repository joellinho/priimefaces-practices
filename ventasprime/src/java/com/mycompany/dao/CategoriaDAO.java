/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dao.model.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin-joel
 */
public class CategoriaDAO extends DAO{
    public List<Categoria> encontar() throws Exception {
        List<Categoria> listaCategorias = new ArrayList<>();
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareCall("select idcat,nombre from categoria");
            listaCategorias = new ArrayList();
            rs = st.executeQuery();
            
            while (rs.next()) {
                Categoria cat  = new Categoria();
                cat.setIdcat(rs.getInt("idcat"));
                cat.setNombre(rs.getString("nombre"));
                
                listaCategorias.add(cat);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listaCategorias;

    }

    public void registrar(Categoria p) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("INSERT INTO categoria(idcat,nombre) values(?,?)");
            st.setInt(1, p.getIdcat());
            st.setString(2,p.getNombre());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    public Categoria leerId(Categoria p) throws Exception{
        Categoria cat=null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("select idcat,nombre where idcat=?");
            st.setInt(1, p.getIdcat());
           rs = st.executeQuery();
           while(rs.next()){
           cat= new Categoria();
           cat.setIdcat(rs.getInt("idcat"));
           
           cat.setNombre(rs.getString("nombre"));
          
           }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return cat;
    }
    public void modificar(Categoria p) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("UPDATE categoria set nombre=? where idcat=?");
            st.setString(1, p.getNombre());
            st.setInt(2, p.getIdcat());
           
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    public void eliminar(Categoria p) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("delete from categoria where codigo=?");
          
             st.setInt(1, p.getIdcat());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
}
public Categoria leerId2(int idcat) throws Exception{
        Categoria cat=null;
        ResultSet rs;
        int idtemp = idcat;
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("select idcat,nombre from categoria where idcat=?");
            st.setInt(1, idtemp);
           rs = st.executeQuery();
           while(rs.next()){
           cat= new Categoria();
           cat.setIdcat(rs.getInt("idcat"));
           
           cat.setNombre(rs.getString("nombre"));
          
           }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return cat;
    }


}
