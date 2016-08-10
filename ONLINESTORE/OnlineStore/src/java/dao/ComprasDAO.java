package dao;

import beans.PedidosBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComprasDAO {

    public void registrarCompra(ComprasTO compra) throws Exception {
        Connection con = connection.Oracle.getConnection();
        String sqlInsercion = "INSERT INTO COMPRAS(cod_compra, cod_cliente, total_neto, fecha) VALUES(seq_cod_compra.nextval, ?,?,?)";
        PreparedStatement pst = con.prepareStatement(sqlInsercion);
        pst.setInt(1, compra.getCod_cliente());
        pst.setDouble(2, compra.getTotal_neto());
        pst.setString(3, compra.getFecha());
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public List<PedidosBean> getCompras() throws Exception {
        Connection con = connection.Oracle.getConnection();
        List<PedidosBean> lista = new ArrayList<PedidosBean>();
        String query = "SELECT *  FROM  Compras";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            PedidosBean pedid = new PedidosBean();
            pedid.setCod_cliente(rs.getInt("cod_cliente"));
            pedid.setCod_compra(rs.getInt("cod_compra"));
            pedid.setFecha(rs.getString("fecha"));
            pedid.setTotal_neto(rs.getDouble("total_neto"));
            lista.add(pedid);
        }
        rs.close();
        st.close();
        con.close();
        return lista;
    }

    public void eliminarCompra(int cod_compra) throws Exception {
        Connection con = connection.Oracle.getConnection();
        String sql = "DELETE FROM compras WHERE cod_compra = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, cod_compra);
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public void eliminarTodos() throws Exception {
        Connection con = connection.Oracle.getConnection();
        String sql = "DELETE FROM compras";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.executeUpdate();
        pst.close();
        con.close();
    }
}