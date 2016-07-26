/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin-joel
 */
public class DAO {
private Connection cn;
private static String JDBC_DRIVER="com.mysql.jdbc.Driver";
private static String JDBC_USER="root";
private static String URL ="jdbc:mysql://localhost:3306/ventas";
private static String JDBC_PASSWORD="Cibertec20160227";
private static Driver driver= null;
    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn =DriverManager.getConnection(URL, JDBC_USER, JDBC_PASSWORD);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e){
        e.printStackTrace();
        }
        
    }
    public void Cerrar() throws Exception{
        try {
            if(cn!=null){
                if(cn.isClosed()==false){
                cn.close();
                }
            }
        } catch (Exception e) {
        throw e;
        }
    }
}
