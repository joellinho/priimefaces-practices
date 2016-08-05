/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.converter;

import com.mycompany.dao.CategoriaDAO;
import com.mycompany.dao.model.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author admin-joel
 */
@ManagedBean
@FacesConverter("categoriaConverter")
public class categoriaConverter implements Converter{

    /**
     * Creates a new instance of categoriaConverter
     */
    public categoriaConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String categoriaS ="";
        CategoriaDAO categoriaDAO = null;
         Categoria cat = null ;
       int idcat ;
         
         try {
             categoriaS = (String)value;
             idcat = Integer.parseInt(categoriaS);
            categoriaDAO = new CategoriaDAO();
          cat = categoriaDAO.leerId2(idcat);
         categoriaS= cat.getNombre();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoriaS;
    }
    
}
