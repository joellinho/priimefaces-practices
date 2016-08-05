/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author admin-joel
 */
@ManagedBean
public class solicitudRegistroListener implements ActionListener{

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        System.out.println("clickando boton"+event.getComponent().getId());  
    }
    
}
