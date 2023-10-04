/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import connection.Supabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Pedido;

/**
 *
 * @author david
 */
public class PedidoDAO {
    
    private static PedidoDAO INSTANCE;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection connection;

    private PedidoDAO() {
        connection = Supabase.getINSTANCE().getConnection();
        stmt = getStatement();
        rs = null;
    }
    
    public static PedidoDAO getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new PedidoDAO();
        }
        return INSTANCE;
    }
    
    private Statement getStatement(){
        try {
            return connection.createStatement();
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet searchPedido(int code) throws SQLException{
        String where = "";
        if(code > 0){
            where = "WHERE pedido_id = " + code +"";
        }
        rs = stmt.executeQuery("SELECT * FROM pedidos "+where);
        return rs;
    }
    
    public void createPedido(Pedido pedido) throws SQLException{
        String sql = "INSERT INTO pedidos (fecha_pedido, total, cliente_id) VALUES(?,?,?)";
        ps = connection.prepareStatement(sql);
        ps.setDate(1, pedido.getFechapedido());
        ps.setFloat(2, pedido.getTotal());
        ps.setInt(3, pedido.getClienteID());
        ps.executeUpdate();
    }
    
    public void updatePedido(Pedido pedido) throws SQLException{
        String sql = "update pedidos set fecha_pedido = ?, total = ?, cliente_id = ? where pedido_id = ?";
        ps = connection.prepareStatement(sql);

        ps.setDate(1, pedido.getFechapedido());
        ps.setFloat(2, pedido.getTotal());
        ps.setInt(3, pedido.getClienteID());
        ps.setInt(4, pedido.getId());        
        ps.executeUpdate();
    }
    
    public void deletePedido(int code) throws SQLException{
        String sql = "delete from pedidos where pedido_id=?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, code);
        ps.executeUpdate();
    }
}
