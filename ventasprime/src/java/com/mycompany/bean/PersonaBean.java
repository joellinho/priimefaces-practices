/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.dao.PersonaDAO;
import com.mycompany.dao.model.Persona;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PersonaBean implements Serializable {

    Persona persona;
    private List<Persona> lstPersona;
    private String accion;

    public PersonaBean() {
        persona = new Persona();
    }

    public List<Persona> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(List<Persona> lstPersona) {
        this.lstPersona = lstPersona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void operar() throws Exception {
        switch (accion) {
            case "Registrar":
                this.registrar();
                limpiar();
                break;
            case "Modificar":
                this.modificar();
                limpiar();
                break;
        }
    }

    public void registrar() throws Exception {
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            dao.registrar(persona);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            lstPersona = dao.encontar();
        } catch (Exception e) {
            throw e;
        }

    }

    public void leerID(Persona p) throws Exception {
        PersonaDAO dao;
        Persona temp;
        try {
            dao = new PersonaDAO();
            temp = dao.leerId(p);
            this.accion = "Modificar";
            if (temp != null) {
                this.persona = temp;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            dao.modificar(persona);
            this.listar();
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar(Persona per) throws Exception {
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            dao.eliminar(per);
            this.listar();
        } catch (Exception e) {
            throw e;
        }

    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
public void limpiar(){
persona.setCodigo(0);
persona.setNombre("");
persona.setSexo("");
}
}
