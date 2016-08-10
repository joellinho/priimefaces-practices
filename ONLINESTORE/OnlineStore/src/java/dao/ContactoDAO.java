package dao;

import beans.ContactoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    public void contactar(ContactoBean contacto) throws Exception {
        Connection con = connection.Oracle.getConnection();
        String sqlInsercion = "INSERT INTO contacto(cod_contacto, nombres, apellidos, email, comentarios, estado) VALUES(seq_cod_contacto.nextval, ?, ?, ?, ?, 'A')";
        PreparedStatement pst = con.prepareStatement(sqlInsercion);
        pst.setString(1, contacto.getNombres());
        pst.setString(2, contacto.getApellidos());
        pst.setString(3, contacto.getEmail());
        pst.setString(4, contacto.getComentario());
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public List<ContactoBean> getContactos() throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<ContactoBean> lista = new ArrayList<ContactoBean>();
        String query = "SELECT *  FROM  Contacto";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            ContactoBean cont = new ContactoBean();
            cont.setCod_contacto(rs.getInt("cod_contacto"));
            cont.setNombres(rs.getString("nombres"));
            cont.setApellidos(rs.getString("apellidos"));
            cont.setEmail(rs.getString("email"));
            cont.setComentario(rs.getString("comentarios"));
            lista.add(cont);
        }
        rs.close();
        st.close();
        con.close();
        return lista;
    }

    public void eliminarContacto(int cod_contacto) throws Exception {
        Connection con = connection.Oracle.getConnection();
        String sql = "DELETE FROM contacto WHERE cod_contacto = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, cod_contacto);
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public void eliminarTodos() throws Exception {
        Connection con = connection.Oracle.getConnection();
        String sql = "DELETE FROM contacto";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.executeUpdate();
        pst.close();
        con.close();
    }
}
