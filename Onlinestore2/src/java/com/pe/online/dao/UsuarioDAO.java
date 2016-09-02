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

    private Map<Integer, Usuario> fuente = new HashMap<>();

    public UsuarioDAO() {
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

        Usuario usuario3 = new Usuario();
        usuario3.setCodigo(3);
        usuario3.setUsuario("javier");
        usuario3.setPassword("123");

        Usuario usuario4 = new Usuario();
        usuario4.setCodigo(4);
        usuario4.setUsuario("miguel");
        usuario4.setPassword("12345");

        fuente.put(1, usuario1);
        fuente.put(2, usuario2);
        fuente.put(3, usuario3);
        fuente.put(4, usuario4);

    }

    public List<Usuario> getAll() {
        List<Usuario> listausuario = new ArrayList<>();
        for (int i = 1; i <= fuente.size(); i++) {
            listausuario.add(fuente.get(i));
        }
        return listausuario;
    }

    public boolean login(Usuario usuario){
        boolean bandera = false;
        for (int i = 1; i <= fuente.size(); i++) {
            if(fuente.get(i).getPassword().equals(usuario.getPassword())){
            bandera=true;
            }
        }
        return bandera;
    }
}
