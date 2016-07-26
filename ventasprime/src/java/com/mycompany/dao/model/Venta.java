/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.model;

import java.util.Date;

/**
 *
 * @author admin-joel
 */
public class Venta {
    private int ideventa;
    private Persona persona;
    private Date fecha;
    private double importe;

    public int getIdeventa() {
        return ideventa;
    }

    public void setIdeventa(int ideventa) {
        this.ideventa = ideventa;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
