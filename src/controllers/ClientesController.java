/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.ClienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Cliente;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class ClientesController {

    public ClientesController() {
    }
    
    public ArrayList<Object[]> filtrar(int code){
        ArrayList<Object[]> clientes = new ArrayList<>();
        try {            
            ResultSet rs = ClienteDAO.getINSTANCE().searchCliente(code);
            while(rs.next()){
                int id = rs.getInt("cliente_id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                Object[] ob = {id, nombre, email};
                clientes.add(ob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    
    public void guardar(Cliente cliente){
        try {
            ClienteDAO.getINSTANCE().createCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente guardado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);            
        }
    }
    
    public void editar(Cliente cliente){
        try {
            ClienteDAO.getINSTANCE().updateCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente editado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);            
        }
    }
    
    public void eliminar(int code){
        try {
            ClienteDAO.getINSTANCE().deleteCliente(code);
            JOptionPane.showMessageDialog(null, "Cliente eliminado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);            
        }
    }
    
}
