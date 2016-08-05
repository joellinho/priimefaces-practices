/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Favorito {
    private String itemFavorito;
    private String[] itemsfavotiros;

    public String[] getItemsfavotiros() {
        return itemsfavotiros;
    }

    public void setItemsfavotiros(String[] itemsfavotiros) {
        this.itemsfavotiros = itemsfavotiros;
    }

    public String getItemFavorito() {
        return itemFavorito;
    }

    public void setItemFavorito(String itemFavorito) {
        this.itemFavorito = itemFavorito;
    }
    public void validar(){
    
    }
    public void escojeritems(){
    for(String item : itemsfavotiros){
        System.out.println(item.toString());
    
    }
    }
}
