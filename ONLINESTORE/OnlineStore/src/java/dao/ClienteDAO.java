package dao;

import beans.ClienteBean;
import beans.ClienteTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public boolean login(ClienteBean cliente) throws Exception {
        Connection con = null;
        try {
            con = connection.Oracle.getConnection();
            String query = "SELECT * FROM clientes WHERE email=? AND clave=? AND estado='A'";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, cliente.getEmail());
            pst.setString(2, cliente.getClave());
            ResultSet rs = pst.executeQuery();
            return (rs.next() ? true : false);
        } catch (Exception e) {
            throw new Exception("Acceso denegado.");
        } finally {
            con.close();
        }
    }

    public void create(ClienteBean cliente) throws Exception {
        Connection con = connection.Oracle.getConnection();
        String insercion = "INSERT INTO clientes(cod_cliente, nombres, apellidos, direccion,"
                + " telefono, email, clave, fecha_nac, estado) values(seq_cod_cliente.nextval, ?,?,?,?,?,?,?, 'A')";
        PreparedStatement pst = con.prepareStatement(insercion);
        pst.setString(1, cliente.getNombres());
        pst.setString(2, cliente.getApellidos());
        pst.setString(3, cliente.getDireccion());
        pst.setString(4, cliente.getTelefono());
        pst.setString(5, cliente.getEmail());
        pst.setString(6, cliente.getClave());
        pst.setString(7, cliente.getFecha_nac());
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public ClienteBean getDatos(ClienteBean cliente) throws Exception {
        Connection con = null;
        try {
            con = connection.Oracle.getConnection();
            String query = "SELECT * FROM clientes WHERE email=? AND clave=? AND estado='A'";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, cliente.getEmail());
            pst.setString(2, cliente.getClave());
            ResultSet rs = pst.executeQuery();
            rs.next();
            ClienteBean cli = new ClienteBean();
            cli.setCod_cliente(rs.getInt("cod_cliente"));
            cli.setApellidos(rs.getString("apellidos"));
            cli.setClave(rs.getString("clave"));
            cli.setDireccion(rs.getString("direccion"));
            cli.setEmail(rs.getString("email"));
            cli.setEstado(rs.getString("estado"));
            cli.setFecha_nac(rs.getString("fecha_nac"));
            cli.setNombres(rs.getString("nombres"));
            cli.setTelefono(rs.getString("telefono"));
            rs.close();
            pst.close();
            return cli;
        } catch (Exception e) {
            throw new Exception("Error cargando los datos del Cliente.");
        } finally {
            con.close();
        }
    }

    public List<ClienteBean> getClientes() throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<ClienteBean> lista = new ArrayList<ClienteBean>();
        String query = "SELECT *  FROM  Clientes";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            ClienteBean cli = new ClienteBean();
            cli.setCod_cliente(rs.getInt("cod_cliente"));
            cli.setNombres(rs.getString("nombres"));
            cli.setApellidos(rs.getString("apellidos"));
            cli.setDireccion(rs.getString("direccion"));
            cli.setTelefono(rs.getString("telefono"));
            cli.setEmail(rs.getString("email"));
            cli.setClave(rs.getString("clave"));
            lista.add(cli);
        }
        rs.close();
        st.close();
        con.close();
        return lista;
    }
public List<ClienteTO> getClientes2() throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<ClienteTO> lista = new ArrayList<ClienteTO>();
        String query = "SELECT *  FROM  Clientes";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            ClienteTO cli = new ClienteTO();
            cli.setCod_cliente(rs.getInt("cod_cliente"));
            cli.setNombres(rs.getString("nombres"));
            cli.setApellidos(rs.getString("apellidos"));
            cli.setDireccion(rs.getString("direccion"));
            cli.setTelefono(rs.getString("telefono"));
            cli.setEmail(rs.getString("email"));
            cli.setClave(rs.getString("clave"));
            lista.add(cli);
        }
        rs.close();
        st.close();
        con.close();
        return lista;
    }
    public void eliminarCliente(int codigo) throws Exception {
        Connection con = connection.Oracle.getConnection();
        String sql = "DELETE FROM Clientes WHERE cod_cliente = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public void modificar(ClienteBean clie) throws Exception {
        Connection con = connection.Oracle.getConnection();
        String sql = "UPDATE Clientes SET nombres=?, apellidos=?, direccion=?,"
                + " telefono = ?,email = ?, clave = ? WHERE cod_cliente = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, clie.getNombres());
        pst.setString(2, clie.getApellidos());
        pst.setString(3, clie.getDireccion());
        pst.setString(4, clie.getTelefono());
        pst.setString(5, clie.getEmail());
        pst.setString(6, clie.getClave());
        pst.setInt(7, clie.getCod_cliente());
        pst.executeUpdate();
        pst.close();
        con.close();
    }
}
