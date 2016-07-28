/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;

import com.mycompany.dao.CategoriaDAO;
import com.mycompany.dao.PersonaDAO;
import com.mycompany.dao.ProductoDAO;
import com.mycompany.dao.model.Categoria;
import com.mycompany.dao.model.Persona;
import com.mycompany.dao.model.Producto;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin-joel
 */
public class principal {
    public static void main(String[] args) {
        
        
        /**************************************TEST PERSONA******************/
        
//        Persona persona = new Persona();
//        persona.setNombre("joelinho");
//        persona.setSexo("F");
//        try {
//            PersonaDAO personadao = new PersonaDAO();
//        personadao.registrar(persona);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



//    List<Persona> lstPersona= new ArrayList<>();
//    Persona persona;
//        persona = new Persona();
//    try {
//            PersonaDAO personadao = new PersonaDAO();
//        lstPersona =personadao.encontar();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally{
//         persona =lstPersona.get(1);
//         System.out.println(persona.getCodigo()+persona.getSexo());
//    }
    
//      PersonaDAO dao;
//       Persona temp= new Persona();
//       temp.setCodigo(2);
//       
//           try {
//               dao = new PersonaDAO();
//               persona= dao.leerId(temp);
//             
//              
//             
//           } catch (Exception e) {
//           e.printStackTrace();
//           }
//    finally{
//    System.out.println(persona.getCodigo()+persona.getNombre()+persona.getSexo());
//    }


//        persona.setCodigo(2);
//        persona.setNombre("joelinho");
//        persona.setSexo("F");
//        try {
//            PersonaDAO personadao = new PersonaDAO();
//        personadao.modificar(persona);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



/****************TEST CATEGORIA*************/
    List<Categoria> listcat = new ArrayList<>();
    Categoria cat;
        try {
            CategoriaDAO catdao = new CategoriaDAO();
            listcat = catdao.encontar();
            
        } catch (Exception e) {
        e.printStackTrace();
        }finally{
        cat = listcat.get(0);
            System.out.println(cat.getIdcat()+cat.getNombre());
        }


 ////////////////////////////////////
// Categoria cat4 = new Categoria();
// cat4.setIdcat(12);
// cat4.setNombre("categoria nueva");
//        try {
//            CategoriaDAO catdao2 = new CategoriaDAO();
//            catdao2.registrar(cat4);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
 
 ////////////////////////////////////
 Categoria cat5 = new Categoria();
 cat5.setIdcat(12);
 cat5.setNombre("nueva categoria actualizada");
        try {
            CategoriaDAO catdao5 = new CategoriaDAO();
            catdao5.modificar(cat5);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
 /////////////////////////////////////
 
  Categoria cat2=null;
        try {
            CategoriaDAO catdao = new CategoriaDAO();
            cat2 = catdao.leerId2(2);
            
        } catch (Exception e) {
        e.printStackTrace();
        }finally{
        
            System.out.println(cat2.getIdcat()+cat2.getNombre());
        }
       //////////////////////////////////////////////////
       
       
   List<Producto> listprod = new ArrayList<>();
       Producto prod=null;
        try {
            ProductoDAO proddao = new ProductoDAO();
            listprod= proddao.encontar();
        } catch (Exception e) {
        e.printStackTrace();
        }finally{
        prod = listprod.get(0);
            System.out.println(prod.getIdprod()+prod.getStock()+" "+prod.getCategoria().getIdcat());
        }
        //////////////////////////////////////////
//        Categoria cat3 = new Categoria();
//        cat3.setIdcat(2);
//        cat3.setNombre("MENAJE");
//        Producto prod3 = new Producto();
//        prod3.setCategoria(cat3);
//        prod3.setNombre("nuevo prod");
//        prod3.setPrecio(12.0);
//        prod3.setStock(50);
//        try {
//            ProductoDAO proDAO = new ProductoDAO();
//            proDAO.registrar(prod3);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
       
}}
