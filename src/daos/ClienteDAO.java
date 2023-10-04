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
import models.Cliente;

/**
 *
 * @author david
 */
public class ClienteDAO {
    
    private static ClienteDAO INSTANCE;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection connection;

    private ClienteDAO() {
        connection = Supabase.getINSTANCE().getConnection();
        stmt = getStatement();
        rs = null;
    }
    
    public static ClienteDAO getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new ClienteDAO();
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
    
    public ResultSet searchCliente(int code) throws SQLException{
        String where = "";
        if(code > 0){
            where = "WHERE cliente_id = " + code +"";
        }
        rs = stmt.executeQuery("SELECT * FROM clientes "+where);
        return rs;
    }
    
    public void createCliente(Cliente cliente) throws SQLException{
        String sql = "INSERT INTO clientes (cliente_id, nombre, email) VALUES(?,?,?)";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, cliente.getId());
        ps.setString(2, cliente.getNombre());
        ps.setString(3, cliente.getEmail());
        ps.executeUpdate();
    }
    
    public void updateCliente(Cliente cliente) throws SQLException{
        String sql = "update clientes set nombre = ?, email = ? where cliente_id = ?";
        ps = connection.prepareStatement(sql);

        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getEmail());
        ps.setInt(3, cliente.getId());
        ps.executeUpdate();
    }
    
    public void deleteCliente(int code) throws SQLException{
        String sql = "delete from clientes where cliente_id=?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, code);
        ps.executeUpdate();
    }
}
