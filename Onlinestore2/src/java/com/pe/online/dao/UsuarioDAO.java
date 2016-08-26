/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.dao;

import com.pe.online.entity.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UsuarioDAO {
   private Map<Integer,Usuario> fuente = new  HashMap<>();
   
   public UsuarioDAO(){
   poblar();
   }

    private void poblar() {
    Usuario usuario1 = new Usuario();
    usuario1.setCodigo(1);
    usuario1.setUsuario("enciso");
    usuario1.setPassword("123456");
     
    Usuario usuario2 = new Usuario();
    usuario2.setCodigo(2);
    usuario2.setUsuario("cibertec");
    usuario2.setPassword("1234567");
    
    fuente.put(1, usuario1);
    fuente.put(2, usuario2);
    
    }
    
    public List<Usuario> getAll(){
    List<Usuario> listausuario = new ArrayList<>();
        for(int i=1;i<=fuente.size();i++){
            listausuario.add(fuente.get(i));
    }
    return listausuario;
    }
   
}
