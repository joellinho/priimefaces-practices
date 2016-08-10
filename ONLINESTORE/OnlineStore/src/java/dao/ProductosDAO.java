package dao;

import beans.CategoriaBean;
import beans.ProductoBean;
import beans.SubCategoriaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAO {

    public List<ProductoBean> getBanner() throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<ProductoBean> lista = new ArrayList<ProductoBean>();
        String query = "SELECT * FROM productos WHERE estado='A' AND banner_grande='SI' ORDER BY fecha_ing DESC";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            ProductoBean banner = new ProductoBean();
            banner.setCod_producto(rs.getInt("cod_producto"));
            banner.setBanner_oferta_grande(rs.getString("banner_oferta_grande"));
            lista.add(banner);
        }
        rs.close();
        st.close();
        con.close();
        return lista;
    }

    public List<ProductoBean> getNuevosProductos() throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<ProductoBean> lista = new ArrayList<ProductoBean>();
        String query = "select *  from  ( select * from productos order by fecha_ing desc ) where ROWNUM <= 9";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            ProductoBean nuevoProd = new ProductoBean();
            nuevoProd.setCod_producto(rs.getInt("cod_producto"));
            nuevoProd.setImg_producto(rs.getString("img_producto"));
            nuevoProd.setNom_producto(rs.getString("nom_producto"));
            nuevoProd.setPrecio_normal(rs.getDouble("precio_normal"));
            nuevoProd.setOferta(rs.getString("oferta"));
            nuevoProd.setPrecio_oferta(rs.getDouble("precio_oferta"));
            lista.add(nuevoProd);
        }
        rs.close();
        st.close();
        con.close();
        return lista;
    }

    public List<ProductoBean> getIndexProductos() throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<ProductoBean> lista = new ArrayList<ProductoBean>();
        String query = "select *  from  (select * from productos order by fecha_ing desc) where ROWNUM <= 5";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            ProductoBean nuevoProd = new ProductoBean();
            nuevoProd.setCod_producto(rs.getInt("cod_producto"));
            nuevoProd.setImg_producto(rs.getString("img_producto"));
            nuevoProd.setNom_producto(rs.getString("nom_producto"));
            nuevoProd.setPrecio_normal(rs.getDouble("precio_normal"));
            nuevoProd.setOferta(rs.getString("oferta"));
            nuevoProd.setPrecio_oferta(rs.getDouble("precio_oferta"));
            lista.add(nuevoProd);
        }
        rs.close();
        st.close();
        con.close();
        return lista;
    }

    public List<CategoriaBean> getCategorias() throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<CategoriaBean> lista = new ArrayList<CategoriaBean>();
        String query = "SELECT * FROM categoria_productos WHERE estado='A'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            CategoriaBean categoria = new CategoriaBean();
            categoria.setCod_categoria(rs.getInt("cod_categoria"));
            categoria.setImg_categoria(rs.getString("img_categoria"));
            categoria.setNom_categoria(rs.getString("nom_categoria"));
            lista.add(categoria);
        }
        rs.close();
        st.close();
        con.close();
        return lista;
    }

    public List<SubCategoriaBean> getSubCategoriaPorCategoria(int cod_categoria) throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<SubCategoriaBean> listaSubCategorias = new ArrayList<SubCategoriaBean>();
        try {
            con.setAutoCommit(true);
            String query = "SELECT * FROM subcategoria_productos where cod_categoria = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, cod_categoria);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                SubCategoriaBean subCategoria = new SubCategoriaBean();
                subCategoria.setCod_sub_categoria(rs.getInt("cod_sub_categoria"));
                subCategoria.setCod_categoria(rs.getInt("cod_categoria"));
                subCategoria.setNom_sub_categoria(rs.getString("nom_sub_categoria"));
                subCategoria.setEstado(rs.getString("estado"));
                subCategoria.setImg_sub_categoria(rs.getString("Img_sub_categoria"));
                listaSubCategorias.add(subCategoria);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            con.close();
        }
        return listaSubCategorias;
    }

    public List<ProductoBean> getProductosPorSubCategoria(int cod_sub_categoria) throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<ProductoBean> listaProductos = new ArrayList<ProductoBean>();
        try {
            con.setAutoCommit(true);
            String query = "SELECT * FROM productos where cod_sub_categoria = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, cod_sub_categoria);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ProductoBean producto = new ProductoBean();
                producto.setCod_producto(rs.getInt("cod_producto"));
                producto.setImg_producto(rs.getString("img_producto"));
                producto.setNom_producto(rs.getString("nom_producto"));
                producto.setPrecio_normal(rs.getDouble("precio_normal"));
                producto.setOferta(rs.getString("oferta"));
                producto.setPrecio_oferta(rs.getDouble("precio_oferta"));
                listaProductos.add(producto);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            con.close();
        }
        return listaProductos;
    }

    public List<ProductoBean> getThreeOfertas() throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<ProductoBean> lista = new ArrayList<ProductoBean>();
        String query = "SELECT * FROM (select * from productos order by fecha_ing desc) WHERE estado='A' AND banner_chico='SI' AND ROWNUM <= 3";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            ProductoBean oferta = new ProductoBean();
            oferta.setCod_producto(rs.getInt("cod_producto"));
            oferta.setBanner_oferta_chica(rs.getString("banner_oferta_chica"));
            oferta.setImg_producto(rs.getString("img_producto"));
            oferta.setNom_producto(rs.getString("nom_producto"));
            oferta.setPrecio_oferta(rs.getDouble("precio_oferta"));
            oferta.setPrecio_normal(rs.getDouble("precio_normal"));
            oferta.setOferta(rs.getString("oferta"));
            lista.add(oferta);
        }
        rs.close();
        st.close();
        con.close();
        return lista;
    }

    public List<ProductoBean> getNueveOfertas() throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<ProductoBean> lista = new ArrayList<ProductoBean>();
        String query = "SELECT * FROM (select * from productos order by fecha_ing desc) WHERE estado='A' AND oferta='SI' AND ROWNUM <= 9";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            ProductoBean oferta = new ProductoBean();
            oferta.setCod_producto(rs.getInt("cod_producto"));
            oferta.setBanner_oferta_chica(rs.getString("banner_oferta_chica"));
            oferta.setImg_producto(rs.getString("img_producto"));
            oferta.setNom_producto(rs.getString("nom_producto"));
            oferta.setPrecio_oferta(rs.getDouble("precio_oferta"));
            oferta.setPrecio_normal(rs.getDouble("precio_normal"));
            oferta.setOferta(rs.getString("oferta"));
            lista.add(oferta);
        }
        rs.close();
        st.close();
        con.close();
        return lista;
    }

    public ProductoBean consultarDetalles(int cod_producto) throws Exception {
        Connection con = connection.Oracle.getConnection();
        ProductoBean producto = new ProductoBean();
        try {
            con.setAutoCommit(true);
            String query = "SELECT * FROM productos WHERE cod_producto=?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, cod_producto);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            producto.setCod_producto(rs.getInt("cod_producto"));
            producto.setNom_producto(rs.getString("nom_producto"));
            producto.setFecha_ing(rs.getString("fecha_ing"));
            producto.setImg_producto(rs.getString("img_producto"));
            producto.setPrecio_normal(rs.getDouble("precio_normal"));
            producto.setPrecio_oferta(rs.getDouble("precio_oferta"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setVideo_youtube(rs.getString("video_youtube"));
            producto.setOferta(rs.getString("oferta"));
            rs.close();
            pstm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            con.close();
        }
        return producto;
    }

    public List<ProductoBean> buscar(String nom_producto) throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<ProductoBean> lista = new ArrayList<ProductoBean>();
        try {
            con.setAutoCommit(true);
            String query = "SELECT * FROM productos WHERE nom_producto LIKE ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, "%" + nom_producto + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ProductoBean producto = new ProductoBean();
                producto.setCod_producto(rs.getInt("cod_producto"));
                producto.setNom_producto(rs.getString("nom_producto"));
                producto.setFecha_ing(rs.getString("fecha_ing"));
                producto.setImg_producto(rs.getString("img_producto"));
                producto.setPrecio_normal(rs.getDouble("precio_normal"));
                producto.setPrecio_oferta(rs.getDouble("precio_oferta"));
                lista.add(producto);
            }
            rs.close();
            pstm.close();
            return lista;
        } catch (Exception e) {
            throw new Exception("No se encontró ningun producto.");
        } finally {
            con.close();
        }
    }
}
