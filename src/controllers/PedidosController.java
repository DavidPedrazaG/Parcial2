/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.ClienteDAO;
import daos.PedidoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Pedido;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author david
 */
public class PedidosController {

    public PedidosController() {
    }
    
    public ArrayList<Object[]> filtrar(int code){
        ArrayList<Object[]> pedidos = new ArrayList<>();
        try {            
            ResultSet rs = PedidoDAO.getINSTANCE().searchPedido(code);
            while(rs.next()){
                int id = rs.getInt("pedido_id");                
                Date fecha = rs.getDate("fecha_pedido");
                float total = rs.getFloat("total");
                int clienteID = rs.getInt("cliente_id");
                Object[] ob = {id, fecha, total, clienteID};
                pedidos.add(ob);
            }
        } catch (SQLException ex) {
        }
        return pedidos;
    }
    
    public ArrayList<Integer> filtrarClientes(int code){
        ArrayList<Integer> clientes = new ArrayList<>();
        try {            
            ResultSet rs = ClienteDAO.getINSTANCE().searchCliente(code);
            while(rs.next()){
                int id = rs.getInt("cliente_id");
                clientes.add(id);
            }
        } catch (SQLException ex) {
        }
        return clientes;
    }
    
    public void guardar(Pedido pedido){
        try {
            PedidoDAO.getINSTANCE().createPedido(pedido);
            JOptionPane.showMessageDialog(null, "Pedido guardado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);            
        }
    }
    
    public void editar(Pedido Pedido){
        try {
            PedidoDAO.getINSTANCE().updatePedido(Pedido);
            JOptionPane.showMessageDialog(null, "Pedido editado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);            
        }
    }
    
    public void eliminar(int code){
        try {
            PedidoDAO.getINSTANCE().deletePedido(code);
            JOptionPane.showMessageDialog(null, "Pedido eliminado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);            
        }
    }
    
}
