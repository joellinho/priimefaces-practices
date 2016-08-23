/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibertec.crudpracticamaven.controller;

import com.cibertec.crudpracticamaven.model.Cliente;
import com.cibertec.crudpracticamaven.model.Producto;
import com.cibertec.crudpracticamaven.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author jhurtace
 */
@ManagedBean(name = "clienteController")
@ViewScoped
public class ClienteController implements Serializable{
    
    List<Usuario> clientes=new ArrayList<Usuario>();
    List<Usuario> allClientes=new ArrayList<Usuario>();
    private Usuario clienteCreate;
    private String nombreCliente;
    private Usuario usuarioEdit;
    private String index;
    
    @PostConstruct
    public void init(){
        clientes = new ArrayList<>();
        Usuario cliente = new Usuario();
        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
        cliente.setPassword("a123");
        cliente.setUsername("jupe1");
        clientes.add(cliente);
        cliente = new Usuario();
        cliente.setNombre("Jose");
        cliente.setApellido("Anaya");
        cliente.setPassword("xyz2");
        cliente.setUsername("joan2");
        clientes.add(cliente);
        cliente = new Usuario();
        cliente.setNombre("Ana");
        cliente.setApellido("Hurtado");
        cliente.setPassword("a1d2f4");
        cliente.setUsername("anhu7");
        clientes.add(cliente);
        cliente = new Usuario();
        cliente.setNombre("Maria");
        cliente.setApellido("Cortez");
        cliente.setPassword("o0p9i8");
        cliente.setUsername("maco3");
        clientes.add(cliente);
        allClientes=new ArrayList<>();
        allClientes.addAll(clientes);
        
    } 
    public void createCliente(){
        clienteCreate=new Usuario();
    }
    public void buscarCliente(){
        if (nombreCliente.isEmpty() || nombreCliente.trim().isEmpty()) {
             clientes.clear();
             clientes.addAll(allClientes);
         }else{
             clientes.clear();
            for (Usuario cliente : allClientes) {
                if (cliente.getNombre().contains(nombreCliente)) {
                        clientes.add(cliente);
                }
            }
         }
    }
    public void create(){
       allClientes.add(clienteCreate);
       clientes.add(clienteCreate);
    }
    public void saveCliente(Usuario usuarioEdit){
        setIndex(allClientes.indexOf(usuarioEdit)+"");
        this.usuarioEdit=usuarioEdit;
    }
     public void deleteCliente(Usuario usuario){
        clientes.remove(usuario);
        allClientes.remove(usuario);
    }
     public String getIndex() {
        return index;
    }
    public void save(){
        
        allClientes.set(Integer.parseInt(getIndex()), usuarioEdit);
        
    }
    public void setIndex(String index) {
        this.index = index;
    }
    public Usuario getClienteCreate() {
        return clienteCreate;
    }

    public void setClienteCreate(Usuario clienteCreate) {
        this.clienteCreate = clienteCreate;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public List<Usuario> getClientes() {
        return clientes;
    }

    public void setClientes(List<Usuario> clientes) {
        this.clientes = clientes;
    }

    public List<Usuario> getAllClientes() {
        return allClientes;
    }

    public void setAllClientes(List<Usuario> allClientes) {
        this.allClientes = allClientes;
    }

    public Usuario getUsuarioEdit() {
        return usuarioEdit;
    }

    public void setUsuarioEdit(Usuario usuarioEdit) {
        this.usuarioEdit = usuarioEdit;
    }
    
    
}
