/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Calendar;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

 @ManagedBean
public class Registro {
    private String nombre;
    private String email;
    private String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void registrar(){
    if(this.getNombre()==null||this.getNombre().length()<10){
    addmessage("fm:nombre",FacesMessage.SEVERITY_WARN,"ingresar nombre","por favor ingrese nombre completo");
    }
    if(diaDescanzo()){
     addmessage(null,FacesMessage.SEVERITY_WARN,"dia de dezcanzo","el dia miercoles es dia de descanzo ingrese otro dia");
   
    }
    }
    public void addmessage(String clientId,Severity severity,String error,String detail    ){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(severity, error, detail);
        context.addMessage(clientId, message);
     }
    public boolean diaDescanzo(){
    
    return Calendar.getInstance().get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY;
    }
}