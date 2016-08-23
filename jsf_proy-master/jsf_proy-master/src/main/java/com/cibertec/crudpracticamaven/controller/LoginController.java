/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibertec.crudpracticamaven.controller;

import com.cibertec.crudpracticamaven.model.Usuario;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Java_VS
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController { 
    
    public Usuario usuario;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    public String login(){
        ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest)ex.getRequest();
        HttpSession session = request.getSession(true);
        
        if(session!=null){
            session.setAttribute("usuario", usuario.getUsername());
            return "usuarios?faces-redirect-true";
        }else{
            return "";
        }
    }
    
    public void cerraSesion(){
    }
    
    public String procesar(){
        return "paso3";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
