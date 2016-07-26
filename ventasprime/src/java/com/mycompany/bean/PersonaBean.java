/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.dao.PersonaDAO;
import com.mycompany.dao.model.Persona;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PersonaBean {
    Persona persona;
    public PersonaBean(){
      persona = new Persona();
    }
   

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public void registrar() throws Exception{
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            dao.registrar(persona);
        } catch (Exception e) {
            throw e;
        }
        System.out.println(persona.getNombre()+" "+persona.getSexo());
    }
    
}
