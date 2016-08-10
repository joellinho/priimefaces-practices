package dao;

import beans.UsuarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public boolean login(UsuarioBean usuario) throws Exception {
        Connection con = null;
        try {
            con = connection.Oracle.getConnection();
            String query = "SELECT * FROM Usuarios WHERE usuario=? AND password=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getPassword());
            ResultSet rs = pst.executeQuery();
            return (rs.next() ? true : false);
        } catch (Exception e) {
            throw new Exception("Acceso denegado.");
        } finally {
            con.close();
        }
    }

    public UsuarioBean getDatos(UsuarioBean usuario) throws Exception {
        Connection con = null;
        try {
            con = connection.Oracle.getConnection();
            String query = "SELECT * FROM Usuarios WHERE usuario=? AND password=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getPassword());
            ResultSet rs = pst.executeQuery();
            rs.next();
            UsuarioBean user = new UsuarioBean();
            user.setUsuario(rs.getString("usuario"));
            user.setPassword(rs.getString("password"));
            user.setNombres(rs.getString("nombres"));
            user.setCod_usuario(rs.getInt("cod_usuario"));
            rs.close();
            pst.close();
            return user;
        } catch (Exception e) {
            throw new Exception("Error cargando los datos del Usuario.");
        } finally {
            con.close();
        }
    }

    public List<UsuarioBean> getUsuarios() throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
        String query = "SELECT *  FROM  usuarios";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            UsuarioBean user = new UsuarioBean();
            user.setCod_usuario(rs.getInt("cod_usuario"));
            user.setNombres(rs.getString("nombres"));
            user.setPassword(rs.getString("password"));
            user.setUsuario(rs.getString("usuario"));
            lista.add(user);
        }
        rs.close();
        st.close();
        con.close();
        return lista;
    }

    public void eliminarUsuario(int cod_usuario) throws Exception {
        Connection con = connection.Oracle.getConnection();
        String sql = "DELETE FROM usuarios WHERE cod_usuario = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, cod_usuario);
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public void crearUsuario(UsuarioBean user) throws Exception {
        Connection con = connection.Oracle.getConnection();
        String insercion = "INSERT INTO Usuarios(cod_usuario, nombres, usuario, password)"
                + " values(seq_cod_usuario.nextval, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(insercion);
        pst.setString(1, user.getNombres());
        pst.setString(2, user.getUsuario());
        pst.setString(3, user.getPassword());
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public void modificarUsuario(UsuarioBean user) throws Exception {
        Connection con = connection.Oracle.getConnection();
        String insercion = "UPDATE Usuarios SET nombres = ?, usuario = ?, password = ?"
                + " WHERE cod_usuario = ?";
        PreparedStatement pst = con.prepareStatement(insercion);
        pst.setString(1, user.getNombres());
        pst.setString(2, user.getUsuario());
        pst.setString(3, user.getPassword());
        pst.setInt(4, user.getCod_usuario());
        pst.executeUpdate();
        pst.close();
        con.close();
    }
}
