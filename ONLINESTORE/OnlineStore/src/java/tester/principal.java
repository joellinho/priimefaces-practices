/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import beans.ClienteTO;
import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin-joel
 */
public class principal {
    public static void main(String[] args) {
        List<ClienteTO> clientes =null;
        try{
        clientes = new ArrayList<ClienteTO>();
        ClienteDAO dao = new ClienteDAO();
        clientes = dao.getClientes2();
            System.out.println(clientes.get(2).getApellidos()+clientes.get(2).getDireccion());
        }catch(Exception e){
        e.printStackTrace();
        }
    }
}
