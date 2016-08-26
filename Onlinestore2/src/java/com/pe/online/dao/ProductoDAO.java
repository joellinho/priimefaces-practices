/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.dao;

import com.pe.online.entity.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author admin-joel
 */
public class ProductoDAO {

    Map<Integer, Producto> fuente = new HashMap<>();

    public ProductoDAO() {
        fuente = poblar();
    }

    public Map<Integer, Producto> poblar() {
        Map<Integer, Producto> fuente2 = new HashMap<>();
        Producto bean1 = new Producto();
        bean1.setCodigo(1);
        bean1.setCodigoCategoria(1);
        bean1.setCodigoSubcategoria(1);
        bean1.setNombreProducto("polo azul");
        bean1.setImagen("poloazul.jpg");
        bean1.setDescripcion("polo marca BICKINS azul marino algodon ,ideal para el verano entallada una marca prestigiosa y duradera ");
        bean1.setPrecio(20.00);
        bean1.setImagenChica("");
        bean1.setImagenGrande("");
        bean1.setBannerChico("no");
        bean1.setBannerGrande("no");

        Producto bean2 = new Producto();
        bean2.setCodigo(2);
        bean2.setCodigoCategoria(1);
        bean2.setCodigoSubcategoria(1);
        bean2.setNombreProducto("polo negro");
        bean2.setImagen("polonegro.jpg");
        bean2.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean2.setPrecio(30.00);
        bean2.setImagenChica("");
        bean2.setImagenGrande("");
        bean2.setBannerChico("no");
        bean2.setBannerGrande("no");

        Producto bean3 = new Producto();
        bean3.setCodigo(3);
        bean3.setCodigoCategoria(1);
        bean3.setCodigoSubcategoria(1);
        bean3.setNombreProducto("tacones rojos");
        bean3.setImagen("tacosrojos.jpg");
        bean3.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean3.setPrecio(30.00);
        bean3.setImagenChica("");
        bean3.setImagenGrande("");
        bean3.setBannerChico("no");
        bean3.setBannerGrande("no");

        Producto bean4 = new Producto();
        bean4.setCodigo(4);
        bean4.setCodigoCategoria(1);
        bean4.setCodigoSubcategoria(1);
        bean4.setNombreProducto("molsa bege de cuero");
        bean4.setImagen("bolsabeige.jpg");
        bean4.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean4.setPrecio(30.00);
        bean4.setImagenChica("");
        bean4.setImagenGrande("");
        bean4.setBannerChico("no");
        bean4.setBannerGrande("no");

        Producto bean5 = new Producto();
        bean5.setCodigo(5);
        bean5.setCodigoCategoria(1);
        bean5.setCodigoSubcategoria(1);
        bean5.setNombreProducto("billetera de cuero negra");
        bean5.setImagen("billeteranegra.jpg");
        bean5.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean5.setPrecio(30.00);
        bean5.setImagenChica("");
        bean5.setImagenGrande("");
        bean5.setBannerChico("no");
        bean5.setBannerGrande("no");

        Producto bean6 = new Producto();
        bean6.setCodigo(6);
        bean6.setCodigoCategoria(1);
        bean6.setCodigoSubcategoria(1);
        bean6.setNombreProducto("polo plomo");
        bean6.setImagen("poloplomo.jpg");
        bean6.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean6.setPrecio(30.00);
        bean6.setImagenChica("");
        bean6.setImagenGrande("");
        bean6.setBannerChico("no");
        bean6.setBannerGrande("no");

        Producto bean7 = new Producto();
        bean7.setCodigo(7);
        bean7.setCodigoCategoria(1);
        bean7.setCodigoSubcategoria(1);
        bean7.setNombreProducto("polera blanco manga negra");
        bean7.setImagen("");
        bean7.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean7.setPrecio(30.00);
        bean7.setImagenChica("");
        bean7.setImagenGrande("polerablancanegragrande.png");
        bean7.setBannerChico("no");
        bean7.setBannerGrande("si");

        Producto bean8 = new Producto();
        bean8.setCodigo(8);
        bean8.setCodigoCategoria(1);
        bean8.setCodigoSubcategoria(1);
        bean8.setNombreProducto(" polera  blanca manga roja ");
        bean8.setImagen("");
        bean8.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean8.setPrecio(30.00);
        bean8.setImagenChica("");
        bean8.setImagenGrande("polerarojablancagrande.png");
        bean8.setBannerChico("no");
        bean8.setBannerGrande("si");

        Producto bean9 = new Producto();
        bean9.setCodigo(9);
        bean9.setCodigoCategoria(1);
        bean9.setCodigoSubcategoria(1);
        bean9.setNombreProducto("polo blanco levis");
        bean9.setImagen("");
        bean9.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean9.setPrecio(30.00);
        bean9.setImagenChica("");
        bean9.setImagenGrande("poloblancogrande.png");
        bean9.setBannerChico("no");
        bean9.setBannerGrande("si");

        Producto bean10 = new Producto();
        bean10.setCodigo(10);
        bean10.setCodigoCategoria(1);
        bean10.setCodigoSubcategoria(1);
        bean10.setNombreProducto("zapatilla negra convert");
        bean10.setImagen("");
        bean10.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean10.setPrecio(30.00);
        bean10.setImagenChica("");
        bean10.setImagenGrande("zapatillanegragrande.png");
        bean10.setBannerChico("no");
        bean10.setBannerGrande("si");

        Producto bean11 = new Producto();
        bean11.setCodigo(11);
        bean11.setCodigoCategoria(1);
        bean11.setCodigoSubcategoria(1);
        bean11.setNombreProducto("zapato marron bata");
        bean11.setImagen("");
        bean11.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean11.setPrecio(30.00);
        bean11.setImagenChica("zapatomarronchico.jpg");
        bean11.setImagenGrande("");
        bean11.setBannerChico("si");
        bean11.setBannerGrande("no");

        Producto bean12 = new Producto();
        bean12.setCodigo(12);
        bean12.setCodigoCategoria(1);
        bean12.setCodigoSubcategoria(1);
        bean12.setNombreProducto("polo negro evans");
        bean12.setImagen("");
        bean12.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean12.setPrecio(30.00);
        bean12.setImagenChica("polonegrochico.jpg");
        bean12.setImagenGrande("");
        bean12.setBannerChico("si");
        bean12.setBannerGrande("no");

        Producto bean13 = new Producto();
        bean13.setCodigo(13);
        bean13.setCodigoCategoria(1);
        bean13.setCodigoSubcategoria(1);
        bean13.setNombreProducto("jean Azul marino piers");
        bean13.setImagen("");
        bean13.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean13.setPrecio(30.00);
        bean13.setImagenChica("jeanazulchico.jpg");
        bean13.setImagenGrande("no");
        bean13.setBannerChico("si");
        bean13.setBannerGrande("no");

        Producto bean14 = new Producto();
        bean14.setCodigo(14);
        bean14.setCodigoCategoria(1);
        bean14.setCodigoSubcategoria(1);
        bean14.setNombreProducto("zapato marron bata");
        bean14.setImagen("");
        bean14.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean14.setPrecio(30.00);
        bean14.setImagenChica("zapatomarronchico.jpg");
        bean14.setImagenGrande("no");
        bean14.setBannerChico("si");
        bean14.setBannerGrande("no");
        Producto bean15 = new Producto();
        bean15.setCodigo(15);
        bean15.setCodigoCategoria(1);
        bean15.setCodigoSubcategoria(1);
        bean15.setNombreProducto("polo negro evans");
        bean15.setImagen("");
        bean15.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean15.setPrecio(30.00);
        bean15.setImagenChica("polonegrochico.jpg");
        bean15.setImagenGrande("");
        bean15.setBannerChico("si");
        bean15.setBannerGrande("");

        fuente2.put(1, bean1);
        fuente2.put(2, bean2);
        fuente2.put(3, bean3);
        fuente2.put(4, bean4);
        fuente2.put(5, bean5);
        fuente2.put(6, bean6);
        fuente2.put(7, bean7);
        fuente2.put(8, bean8);
        fuente2.put(9, bean9);
        fuente2.put(10, bean10);
        fuente2.put(11, bean11);
        fuente2.put(12, bean12);
        fuente2.put(13, bean13);
        fuente2.put(14, bean14);
        fuente2.put(15, bean15);

        return fuente2;
    }

    @Override
    public String toString() {
        return "ProductoDAO{" + '}';
    }

    public List<Producto> getProductosIndex() {

        List<Producto> listaproductos = new ArrayList<>();
        int sizemap = poblar().size();
        for (int i = 1; i <= 3; i++) {
            if (poblar().get(i).getBannerChico().equals("no") && poblar().get(i).getBannerGrande().equals("no")) {
                listaproductos.add(poblar().get(i));
            }

        }
        return listaproductos;
    }

    public List<Producto> getBanner() {

        Producto producto = new Producto();
        List<Producto> listaBanner = new ArrayList<>();
        int sizemap = fuente.size();
        String nombre = "";
        for (int i = 1; i <= sizemap; i++) {
            if (fuente.get(i).getBannerGrande().equals("si")) {
                producto = fuente.get(i);
                listaBanner.add(producto);

            }
//              listaBanner.add(producto); 
        }
        return listaBanner;

    }

    public List<Producto> getThreeOfertas() {
        List<Producto> lista = new ArrayList<>();
        int sizemap = poblar().size();
        for (int i = 1; i <= sizemap; i++) {
            if (poblar().get(i).getBannerChico().equals("si")) {
                lista.add(poblar().get(i));
            }
        }
        return lista;
    }

    public Producto mostrarDetalles(int codigo) {

        Producto producto = new Producto();
        for (int i = 1; i <= fuente.size(); i++) {
            if (fuente.get(i).getCodigo() == codigo) {
                producto = fuente.get(i);

            }
        }

        return producto;
    }

    public List<Producto> mostrarTodos() {

        List<Producto> lista = new ArrayList<>();
        for (int i = 1; i <= fuente.size(); i++) {
            lista.add(fuente.get(i));

        }
        return lista;
    }
    public void eliminar(Producto producto){
    fuente.remove(producto.getCodigo());
    
    }

}
