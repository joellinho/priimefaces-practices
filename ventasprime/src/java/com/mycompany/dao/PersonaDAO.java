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


public class PersonaDAO extends DAO{
    
    public void encontar()throws Exception{
    try {
            this.conectar();
          Statement st = getCn().createStatement();
          
           ResultSet rs = st.executeQuery("select * from persona");
           while(rs.next()){
           int id= rs.getInt(1);
           String nombre = rs.getString(2);
           String sexo = rs.getString(3);
               System.out.println(id+nombre+sexo);
           }
        } catch (Exception e) {
        throw e;
        }finally{
        this.Cerrar();
        }
    }
    public void registrar(Persona p) throws Exception{
        try {
            this.conectar();
            PreparedStatement st = getCn().prepareStatement("INSERT INTO persona(nombre,sexo) values(?,?)");
            st.setString(1, p.getNombre());
            st.setString(2,p.getSexo());
            st.executeUpdate();
        } catch (Exception e) {
        throw e;
        }finally{
        this.Cerrar();
        }
    }
}
