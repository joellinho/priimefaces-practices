/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;

import com.mycompany.dao.PersonaDAO;
import com.mycompany.dao.model.Persona;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author admin-joel
 */
public class principal {
    public static void main(String[] args) {
        
        
        
        
        Persona persona = new Persona();
        persona.setNombre("joelinho");
        persona.setSexo("F");
        try {
            PersonaDAO personadao = new PersonaDAO();
        personadao.registrar(persona);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
         try {
            PersonaDAO personadao = new PersonaDAO();
        personadao.encontar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
