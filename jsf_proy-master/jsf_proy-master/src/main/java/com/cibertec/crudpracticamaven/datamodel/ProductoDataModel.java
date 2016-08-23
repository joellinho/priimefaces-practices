/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibertec.crudpracticamaven.datamodel;

import com.cibertec.crudpracticamaven.model.Producto;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

/**
 *
 * @author clapj
 */
public class ProductoDataModel extends LazyDataModel<Producto> {

    @Override
    public List<Producto> load(int first, int pageSize, 
            List<SortMeta> multiSortMeta, 
            Map<String, Object> filters) {
        //To change body of generated methods, choose Tools | Templates.
        return null;
    }
    
    
    
}
