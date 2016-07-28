/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dao.model.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;

public class PersonaDAO extends DAO {

    public List<Persona> encontar() throws Exception {
        List<Persona> listaPersonas = new ArrayList<>();
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareCall("select codigo,nombre,sexo from persona");
            listaPersonas = new ArrayList();
            rs = st.executeQuery();
            this.conectar();
            while (rs.next()) {
                Persona per = new Persona();
                per.setCodigo(rs.getInt("codigo"));
                per.setNombre(rs.getString("nombre"));
                per.setSexo(rs.getString("sexo"));
                listaPersonas.add(per);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listaPersonas;

    }

    public void registrar(Persona p) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("INSERT INTO persona(nombre,sexo) values(?,?)");
            st.setString(1, p.getNombre());
            st.setString(2, p.getSexo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    public Persona leerId(Persona p) throws Exception{
        Persona per=null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("select codigo,nombre,sexo from persona where codigo=?");
            st.setInt(1, p.getCodigo());
           rs = st.executeQuery();
           while(rs.next()){
           per= new Persona();
           per.setCodigo(rs.getInt("codigo"));
           
           per.setNombre(rs.getString("nombre"));
           per.setSexo(rs.getString("sexo"));
           }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return per;
    }
    public void modificar(Persona p) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("UPDATE persona set nombre=?,sexo=? where codigo=?");
            st.setString(1, p.getNombre());
            st.setString(2, p.getSexo());
             st.setInt(3, p.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    public void eliminar(Persona p) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("delete from persona where codigo=?");
          
             st.setInt(1, p.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
